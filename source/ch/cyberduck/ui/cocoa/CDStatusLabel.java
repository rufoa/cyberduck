/* CDStatusLabel */
package ch.cyberduck.ui.cocoa;

import com.apple.cocoa.foundation.*;
import com.apple.cocoa.application.*;

import org.apache.log4j.Appender; //Implement this interface for your own strategies for outputting log statements.
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Layout;

public class CDStatusLabel extends NSTextField implements Appender {

    private static Logger log = Logger.getLogger(CDStatusLabel.class);
    private String name;
    
    public CDStatusLabel() {
	super();
    }

    public CDStatusLabel(NSCoder decoder, long token) {
	super(decoder, token);
    }
    
    public CDStatusLabel(NSRect frameRect) {
	super(frameRect);
    }

    public void encodeWithCoder(NSCoder encoder) {
	super.encodeWithCoder(encoder);
    }
    
    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }
    
    public void addFilter(Filter f) {
	log.debug("not implemented");
    }

    public Filter getFilter() {
	return null;
    }

    public void clearFilters() {
	log.debug("not implemented");
    }

    public void close() {
	//don't have anyhting to close, ie stream
    }

    public boolean requiresLayout() {
	return true;
    }

    public void setLayout(Layout l) {
	log.debug("not implemented");
    }
    
    public Layout getLayout() {
	return new LabelLayout();
    }

    public void setErrorHandler(ErrorHandler h) {
	log.debug("not implemented");
    }

    public ErrorHandler getErrorHandler() {
	log.debug("not implemented");
	return null;
    }
    
    public void doAppend(LoggingEvent event) {
	if(event.getLevel().equals(Level.INFO))
	    this.setStringValue(event.getRenderedMessage());
    }

    private class LabelLayout extends Layout {
	public String format(LoggingEvent event) {
	    return event.getRenderedMessage();
	}

	public void activateOptions() {

	}

	public boolean ignoresThrowable() {
	    return false;
	}
    }
}
