package ch.cyberduck.ui.cocoa;

/*
 *  Copyright (c) 2003 David Kocher. All rights reserved.
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

import com.apple.cocoa.application.*;
import com.apple.cocoa.foundation.NSAttributedString;
import com.apple.cocoa.foundation.NSPoint;
import com.apple.cocoa.foundation.NSRect;
import com.apple.cocoa.foundation.NSSize;

import org.apache.log4j.Logger;

import ch.cyberduck.core.Queue;

public class CDQueueCell extends CDTableCell {
    private static Logger log = Logger.getLogger(CDQueueCell.class);

    private Queue queue;
	
    public void setObjectValue(Object q) {
        this.queue = (Queue) q;
    }

    public static NSMenu defaultMenu() {
        return new NSMenu("Queue Item");
    }

    private static final NSImage arrowUpIcon = NSImage.imageNamed("arrowUp.tiff");
    private static final NSImage arrowDownIcon = NSImage.imageNamed("arrowDown.tiff");
    private static final NSImage folderIcon = NSImage.imageNamed("folder32.tiff");
    private static final NSImage notFoundIcon = NSImage.imageNamed("notfound.tiff");

    static {
        arrowUpIcon.setSize(new NSSize(32f, 32f));
        arrowDownIcon.setSize(new NSSize(32f, 32f));
    }

    private NSImage fileIcon = null;
    private NSImage arrowIcon = null;

    public void drawInteriorWithFrameInView(NSRect cellFrame, NSView controlView) {
        super.drawInteriorWithFrameInView(cellFrame, controlView);
        if (queue != null) {
            NSPoint cellPoint = cellFrame.origin();
            NSSize cellSize = cellFrame.size();
			
            // drawing file icon
            switch (queue.kind()) {
                case Queue.KIND_DOWNLOAD:
                    arrowIcon = arrowDownIcon;
                    if (queue.getRoot().isFile()) {
						fileIcon = CDIconCache.instance().get(queue.getRoot().getExtension());
                    }
					else if (queue.getRoot().isDirectory()) {
						fileIcon = folderIcon;
					}
					break;
                case Queue.KIND_UPLOAD:
                    arrowIcon = arrowUpIcon;
                    if (queue.getRoot().getLocal().isFile()) {
						if(queue.getRoot().getLocal().exists()) {
							fileIcon = CDIconCache.instance().get(queue.getRoot().getExtension());
						}
						else { 
							fileIcon = notFoundIcon;
						}
                    }
					else if (queue.getRoot().getLocal().isDirectory()) {
						fileIcon = folderIcon;
					}
					else { 
						fileIcon = notFoundIcon;
					}
					break;
            }
			
            final float BORDER = 40;
            final float SPACE = 5;

            if (fileIcon != null) {
//				fileIcon.setScalesWhenResized(true);
                fileIcon.setSize(new NSSize(32f, 32f));

                fileIcon.compositeToPoint(new NSPoint(cellPoint.x() + SPACE, cellPoint.y() + 32 + SPACE), NSImage.CompositeSourceOver);
                arrowIcon.compositeToPoint(new NSPoint(cellPoint.x() + SPACE * 2, cellPoint.y() + 32 + SPACE * 2), NSImage.CompositeSourceOver);
            }

            // drawing path properties
            // local file
            NSGraphics.drawAttributedString(new NSAttributedString(queue.getRoot().getName(),
                    boldFont),
                    new NSRect(cellPoint.x() + BORDER + SPACE,
                            cellPoint.y() + SPACE,
                            cellSize.width() - BORDER - SPACE,
                            cellSize.height()));
            // remote url
            NSGraphics.drawAttributedString(new NSAttributedString(queue.getRoot().getHost().getProtocol() + "://" +
                    queue.getRoot().getHost().getHostname() +
                    queue.getRoot().getAbsolute(),
                    tinyFont),
                    new NSRect(cellPoint.x() + BORDER + SPACE,
                            cellPoint.y() + 20,
                            cellSize.width() - BORDER - SPACE,
                            cellSize.height()));
            NSGraphics.drawAttributedString(new NSAttributedString(queue.getStatus(),
                    tinyFont),
                    new NSRect(cellPoint.x() + BORDER + SPACE,
                            cellPoint.y() + 33,
                            cellSize.width() - BORDER - SPACE,
                            cellSize.height()));
        }
    }
}
