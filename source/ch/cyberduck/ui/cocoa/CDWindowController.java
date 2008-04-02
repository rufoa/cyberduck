package ch.cyberduck.ui.cocoa;

/*
 *  Copyright (c) 2005 David Kocher. All rights reserved.
 *  http://cyberduck.ch/
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Bug fixes, suggestions and comments should be sent to:
 *  dkocher@cyberduck.ch
 */

import ch.cyberduck.ui.cocoa.threading.BackgroundActionImpl;
import ch.cyberduck.ui.cocoa.threading.WindowMainAction;
import ch.cyberduck.core.StringUtils;

import com.apple.cocoa.application.*;
import com.apple.cocoa.foundation.*;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.Vector;

/**
 * @version $Id$
 */
public abstract class CDWindowController extends CDBundleController {
    private static Logger log = Logger.getLogger(CDWindowController.class);

    protected static final String DEFAULT = NSBundle.localizedString("Default", "");

    public CDWindowController() {
        super();
    }

    /**
     * Called by the runtime after the NIB file has been loaded sucessfully
     */
    public abstract void awakeFromNib();

    private static NSMutableParagraphStyle lineBreakByTruncatingMiddleParagraph = new NSMutableParagraphStyle();

    static {
        lineBreakByTruncatingMiddleParagraph.setLineBreakMode(NSParagraphStyle.LineBreakByTruncatingMiddle);
    }

    protected static final NSDictionary TRUNCATE_MIDDLE_ATTRIBUTES = new NSDictionary(
            new Object[]{lineBreakByTruncatingMiddleParagraph},
            new Object[]{NSAttributedString.ParagraphStyleAttributeName});

    protected static final NSDictionary TRUNCATE_MIDDLE_BOLD_RED_FONT_ATTRIBUTES = new NSDictionary(
            new Object[]{lineBreakByTruncatingMiddleParagraph, NSFont.boldSystemFontOfSize(10.0f), NSColor.redColor()},
            new Object[]{NSAttributedString.ParagraphStyleAttributeName, NSAttributedString.FontAttributeName, NSAttributedString.ForegroundColorAttributeName}
    );

    protected static final NSDictionary FIXED_WITH_FONT_ATTRIBUTES = new NSDictionary(
            new Object[]{NSFont.userFixedPitchFontOfSize(9.0f)},
            new Object[]{NSAttributedString.FontAttributeName}
    );

    protected static final NSDictionary BOLD_RED_FONT_ATTRIBUTES = new NSDictionary(
            new Object[]{NSFont.boldSystemFontOfSize(10.0f), NSColor.redColor()},
            new Object[]{NSAttributedString.FontAttributeName, NSAttributedString.ForegroundColorAttributeName}
    );

    /**
     * Run the runnable in the background waiting for no lock to acquire
     * @param runnable The runnable to execute in a secondary Thread
     * @see java.lang.Thread
     */
    public void background(final BackgroundActionImpl runnable) {
        this.background(runnable, new Object());
    }

    /**
     * Run the runnable in the background using a new thread. Will return
     * immediatly but not run the runnable before the lock is acquired.
     * If the <code>BackgroundAction</code> has failed, <code>BackgroundAction#alert</code>
     * is called. 
     * @param runnable The runnable to execute in a secondary Thread
     * @param lock The synchronisation object to use
     * @see java.lang.Thread
     */
    public void background(final BackgroundActionImpl runnable, final Object lock) {
        log.debug("background:"+runnable+","+lock);
        new Thread("Background") {
            public void run() {
                // Synchronize all background threads to this lock so actions run
                // sequentially as they were initiated from the main interface thread
                synchronized(lock) {
                    log.debug("Acquired lock for background runnable:"+runnable);
                    // An autorelease pool is used to manage Foundation's autorelease
                    // mechanism for Objective-C objects. If you start off a thread
                    // that calls Cocoa, there won't be a top-level pool.
                    final int pool = NSAutoreleasePool.push();
                    try {
                        runnable.prepare();
                        if(runnable.hasFailed()) {
                            // This is a automated retry. Wait some time first.
                            runnable.pause(lock);
                            if(0 == runnable.retry()) {
                                return;
                            }
                        }
                        // Clear previous failure status
                        runnable.init();
                        // Execute the action of the runnable
                        runnable.run();
                    }
                    catch(NullPointerException e) {
                        log.error(e.getClass().getName());
                        StackTraceElement[] stacktrace = e.getStackTrace();
                        for(int i = 0; i < stacktrace.length; i++) {
                            log.error(stacktrace[i].toString());
                        }
                        // We might get a null pointer if the session has been interrupted
                        // during the action in progress and closing the underlying socket
                        // asynchronously. See Session#interrupt
                    }
                    finally {
                        // Increase the run counter
                        runnable.finish();
                        // Invoke the cleanup on the main thread to let the action
                        // synchronize the user interface
                        CDMainApplication.invoke(new WindowMainAction(CDWindowController.this) {
                            public void run() {
                                runnable.cleanup();
                                // If there was any failure, display the summary now
                                if(runnable.hasFailed()) {
                                    if(runnable.retry() > 0) {
                                        log.info("Retry failed background action:"+runnable);
                                        // Re-run the action with the previous lock used
                                        CDWindowController.this.background(runnable, lock);
                                    }
                                    // Do not pop up an alert if the action was canceled intentionally
                                    else if(!runnable.isCanceled()) {
                                        runnable.alert(lock);
                                    }
                                }
                            }
                        });
                        // Indicates that you are finished using the
                        // NSAutoreleasePool identified by pool.
                        NSAutoreleasePool.pop(pool);
                    }
                    log.debug("Releasing lock for background runnable:"+runnable);
                }
            }
        }.start();
        log.debug("Started background runnable for:"+runnable);
    }

    /**
     * The window this controller is owner of
     */
    protected NSWindow window; // IBOutlet

    private List listeners = new Vector();

    /**
     * @param listener
     */
    public void addListener(CDWindowListener listener) {
        listeners.add(listener);
    }

    /**
     * @param listener
     */
    public void removeListener(CDWindowListener listener) {
        listeners.remove(listener);
    }

    public void setWindow(NSWindow window) {
        this.window = window;
        NSNotificationCenter.defaultCenter().addObserver(this,
                new NSSelector("windowWillClose", new Class[]{NSNotification.class}),
                NSWindow.WindowWillCloseNotification,
                this.window);
        this.window.setReleasedWhenClosed(true);
    }

    public NSWindow window() {
        return this.window;
    }

    /**
     * @see com.apple.cocoa.application.NSWindow.Delegate
     */
    public boolean windowShouldClose(NSWindow sender) {
        return true;
    }

    /**
     * Override this method if the controller should not be invalidated after its window closes
     * @param notification
     */
    public void windowWillClose(NSNotification notification) {
        log.debug("windowWillClose:"+notification);
        CDWindowListener[] l = (CDWindowListener[]) listeners.toArray(new CDWindowListener[]{});
        for(int i = 0; i < l.length; i++) {
            l[i].windowWillClose();
        }
        //If the window is closed it is assumed the controller object is no longer used
        this.invalidate();
    }

    protected void invalidate() {
        this.window = null;
        super.invalidate();
    }

    /**
     * @return False if the window has been released
     */
    public boolean isShown() {
        return this.window != null;
    }

    /**
     * Position this controller's window relative to other open windows
     */
    public void cascade() {
        NSArray windows = NSApplication.sharedApplication().windows();
        int count = windows.count();
        if (count != 0) {
            NSWindow window = (NSWindow) windows.objectAtIndex(count-1);
            NSPoint origin = window.frame().origin();
            origin = new NSPoint(origin.x(), origin.y() + window.frame().size().height());
            this.window.setFrameTopLeftPoint(this.window.cascadeTopLeftFromPoint(origin));
        }
    }

    /**
     *
     * @return True if this window has a sheet attached
     */
    public boolean hasSheet() {
        if(null == this.window) {
            return false;
        }
        return this.window.attachedSheet() != null;
    }

    /**
     * Attach a sheet to this window
     * @param sheet The sheet to be attached to this window
     * @see ch.cyberduck.ui.cocoa.CDSheetController#beginSheet()
     */
    protected void alert(final NSWindow sheet) {
        this.alert(sheet, new CDSheetCallback() {
            public void callback(final int returncode) {
                ;
            }
        });
    }

    /**
     * Attach a sheet to this window
     * @param sheet The sheet to be attached to this window
     * @param callback The callback to call after the sheet is dismissed
     * @see ch.cyberduck.ui.cocoa.CDSheetController#beginSheet()
     */
    protected void alert(final NSWindow sheet, final CDSheetCallback callback) {
        CDSheetController c = new CDSheetController(this, sheet) {
            public void callback(final int returncode) {
                callback.callback(returncode);
            }
        };
        c.beginSheet();
    }


    protected void updateField(final NSTextView f, final String value) {
        f.setString(StringUtils.hasText(value) ? value : "");
    }

    protected void updateField(final NSTextField f, final String value) {
        f.setStringValue(StringUtils.hasText(value) ? value : "");
    }
}