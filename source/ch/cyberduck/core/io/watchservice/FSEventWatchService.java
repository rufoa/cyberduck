package ch.cyberduck.core.io.watchservice;

import ch.cyberduck.core.io.watchservice.jna.CFArrayRef;
import ch.cyberduck.core.io.watchservice.jna.CFIndex;
import ch.cyberduck.core.io.watchservice.jna.CFRunLoopRef;
import ch.cyberduck.core.io.watchservice.jna.CFStringRef;
import ch.cyberduck.core.io.watchservice.jna.FSEventStreamRef;
import ch.cyberduck.core.io.watchservice.jna.FSEvents;
import ch.cyberduck.core.threading.NamedThreadFactory;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

/**
 * This class contains the bulk of my implementation of the Watch Service API.
 *
 * @author Steve McLeod
 */
public class FSEventWatchService extends AbstractWatchService {
    private static final Logger log = Logger.getLogger(FSEventWatchService.class);

    private final FSEvents library = FSEvents.library;

    private CFRunLoop thread;

    private ThreadFactory threadFactory
            = new NamedThreadFactory("fsevent");

    public FSEventWatchService() {
        if(log.isDebugEnabled()) {
            log.debug("Create new watch service");
        }
    }

    @Override
    public WatchKey register(final WatchableFile file,
                             final WatchEvent.Kind<?>[] events, final WatchEvent.Modifier... modifiers)
            throws IOException {
        if(log.isInfoEnabled()) {
            log.info(String.format("Register file %s for events %s", file, Arrays.toString(events)));
        }
        final Map<File, Long> lastModifiedMap = createLastModifiedMap(file.getFile());
        final Pointer[] values = {
                CFStringRef.toCFString(file.getFile().getCanonicalPath()).getPointer()
        };
        final CFArrayRef pathsToWatch = library.CFArrayCreate(null, values, CFIndex.valueOf(1), null);
        final MacOSXWatchKey watchKey = new MacOSXWatchKey(this, events);

        final double latency = 1.0; // Latency in seconds

        final long kFSEventStreamEventIdSinceNow = -1; // This is 0xFFFFFFFFFFFFFFFF
        // final int kFSEventStreamCreateFlagUseCFTypes = 0x00000001;
        final int kFSEventStreamCreateFlagNoDefer = 0x00000002;
        // final int kFSEventStreamCreateFlagIgnoreSelf = 0x00000008;
        final FSEvents.FSEventStreamCallback callback = new Callback(watchKey, lastModifiedMap);
        final FSEventStreamRef stream = library.FSEventStreamCreate(
                Pointer.NULL,
                callback,
                Pointer.NULL,
                pathsToWatch,
                kFSEventStreamEventIdSinceNow,
                latency,
                kFSEventStreamCreateFlagNoDefer);
        threadFactory.newThread(thread = new CFRunLoop(stream)).start();
        return watchKey;
    }

    private final class CFRunLoop implements Runnable {

        private final FSEventStreamRef streamRef;
        private CFRunLoopRef runLoop;

        public CFRunLoop(final FSEventStreamRef streamRef) {
            this.streamRef = streamRef;
        }

        @Override
        public void run() {
            runLoop = FSEvents.library.CFRunLoopGetCurrent();
            // Schedule an FSEventStream on a runloop
            library.FSEventStreamScheduleWithRunLoop(streamRef, runLoop,
                    CFStringRef.toCFString("kCFRunLoopDefaultMode"));
            // Start receiving events on the stream
            library.FSEventStreamStart(streamRef);
            library.CFRunLoopRun();
        }

        public CFRunLoopRef getRunLoop() {
            return runLoop;
        }

        public FSEventStreamRef getStreamRef() {
            return streamRef;
        }
    }

    private Map<File, Long> createLastModifiedMap(File folder) {
        Map<File, Long> lastModifiedMap = new ConcurrentHashMap<File, Long>();
        for(File file : recursiveListFiles(folder)) {
            lastModifiedMap.put(file, file.lastModified());
        }
        return lastModifiedMap;
    }

    private static Set<File> recursiveListFiles(File folder) {
        Set<File> files = new HashSet<File>();
        if(folder.isDirectory()) {
            final File[] children = folder.listFiles();
            if(null == children) {
                return files;
            }
            for(File file : children) {
                if(file.isDirectory()) {
                    files.addAll(recursiveListFiles(file));
                }
                else {
                    files.add(file);
                }
            }
        }
        return files;
    }

    @Override
    void implClose() throws IOException {
        // Tells the daemon to stop sending events
        library.FSEventStreamStop(thread.getStreamRef());
        // Removes the stream from the specified run loop
        library.FSEventStreamUnscheduleFromRunLoop(thread.getStreamRef(), thread.getRunLoop(),
                CFStringRef.toCFString("kCFRunLoopDefaultMode"));
        // Remove the stream from the run loops upon which it has been scheduled
        library.FSEventStreamInvalidate(thread.getStreamRef());
        // Release reference to the stream
        library.FSEventStreamRelease(thread.getStreamRef());
    }


    private static final class MacOSXWatchKey extends AbstractWatchKey {
        private final AtomicBoolean cancelled = new AtomicBoolean(false);
        private final boolean reportCreateEvents;
        private final boolean reportModifyEvents;
        private final boolean reportDeleteEvents;

        public MacOSXWatchKey(final FSEventWatchService service, final WatchEvent.Kind<?>[] events) {
            super(service);
            boolean reportCreateEvents = false;
            boolean reportModifyEvents = false;
            boolean reportDeleteEvents = false;

            for(WatchEvent.Kind<?> event : events) {
                if(event == StandardWatchEventKind.ENTRY_CREATE) {
                    reportCreateEvents = true;
                }
                else if(event == StandardWatchEventKind.ENTRY_MODIFY) {
                    reportModifyEvents = true;
                }
                else if(event == StandardWatchEventKind.ENTRY_DELETE) {
                    reportDeleteEvents = true;
                }
            }
            this.reportCreateEvents = reportCreateEvents;
            this.reportDeleteEvents = reportDeleteEvents;
            this.reportModifyEvents = reportModifyEvents;
        }

        @Override
        public boolean isValid() {
            return !cancelled.get() && watcher().isOpen();
        }

        @Override
        public void cancel() {
            cancelled.set(true);
        }

        public boolean isReportCreateEvents() {
            return reportCreateEvents;
        }

        public boolean isReportModifyEvents() {
            return reportModifyEvents;
        }

        public boolean isReportDeleteEvents() {
            return reportDeleteEvents;
        }
    }

    private static final class Callback implements FSEvents.FSEventStreamCallback {
        private final MacOSXWatchKey key;
        private final Map<File, Long> timestamps;

        private Callback(final MacOSXWatchKey key, final Map<File, Long> timestamps) {
            this.key = key;
            this.timestamps = timestamps;
        }

        public void invoke(FSEventStreamRef streamRef, Pointer clientCallBackInfo, NativeLong numEvents,
                           Pointer eventPaths, Pointer /* array of unsigned int */ eventFlags, /* array of unsigned long */ Pointer eventIds) {
            final int length = numEvents.intValue();
            for(String folder : eventPaths.getStringArray(0, length)) {
                final Set<File> filesOnDisk = recursiveListFiles(new File(folder));
                for(File file : findCreatedFiles(filesOnDisk)) {
                    if(key.isReportCreateEvents()) {
                        key.signalEvent(StandardWatchEventKind.ENTRY_CREATE, file);
                    }
                    timestamps.put(file, file.lastModified());
                }

                for(File file : findModifiedFiles(filesOnDisk)) {
                    if(key.isReportModifyEvents()) {
                        key.signalEvent(StandardWatchEventKind.ENTRY_MODIFY, file);
                    }
                    timestamps.put(file, file.lastModified());
                }

                for(File file : findDeletedFiles(folder, filesOnDisk)) {
                    if(key.isReportDeleteEvents()) {
                        key.signalEvent(StandardWatchEventKind.ENTRY_DELETE, file);
                    }
                    timestamps.remove(file);
                }
            }
        }

        private List<File> findModifiedFiles(Set<File> filesOnDisk) {
            List<File> modifiedFileList = new ArrayList<File>();
            for(File file : filesOnDisk) {
                final Long lastModified = timestamps.get(file);
                if(lastModified != null && lastModified != file.lastModified()) {
                    modifiedFileList.add(file);
                }
            }
            return modifiedFileList;
        }

        private List<File> findCreatedFiles(Set<File> filesOnDisk) {
            List<File> createdFileList = new ArrayList<File>();
            for(File file : filesOnDisk) {
                if(!timestamps.containsKey(file)) {
                    createdFileList.add(file);
                }
            }
            return createdFileList;
        }

        private List<File> findDeletedFiles(String folderName, Set<File> filesOnDisk) {
            List<File> deletedFileList = new ArrayList<File>();
            for(File file : timestamps.keySet()) {
                if(file.getAbsolutePath().startsWith(folderName) && !filesOnDisk.contains(file)) {
                    deletedFileList.add(file);
                }
            }
            return deletedFileList;
        }
    }
}
