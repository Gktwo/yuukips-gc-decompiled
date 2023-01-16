package org.eclipse.jetty.server;

import java.io.IOException;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;

@ManagedObject("NCSA standard format request log")
@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/NCSARequestLog.class */
public class NCSARequestLog extends AbstractNCSARequestLog {
    private final RequestLogWriter _requestLogWriter;

    public NCSARequestLog() {
        this((String) null);
    }

    public NCSARequestLog(String filename) {
        this(new RequestLogWriter(filename));
    }

    public NCSARequestLog(RequestLogWriter writer) {
        super(writer);
        this._requestLogWriter = writer;
        setExtended(true);
    }

    public void setFilename(String filename) {
        this._requestLogWriter.setFilename(filename);
    }

    @Override // org.eclipse.jetty.server.AbstractNCSARequestLog
    public void setLogTimeZone(String tz) {
        setLogTimeZone(tz);
        this._requestLogWriter.setTimeZone(tz);
    }

    @ManagedAttribute("file of log")
    public String getFilename() {
        return this._requestLogWriter.getFileName();
    }

    public String getDatedFilename() {
        return this._requestLogWriter.getDatedFilename();
    }

    @Override // org.eclipse.jetty.server.AbstractNCSARequestLog
    protected boolean isEnabled() {
        return this._requestLogWriter.isEnabled();
    }

    public void setRetainDays(int retainDays) {
        this._requestLogWriter.setRetainDays(retainDays);
    }

    @ManagedAttribute("number of days that log files are kept")
    public int getRetainDays() {
        return this._requestLogWriter.getRetainDays();
    }

    public void setAppend(boolean append) {
        this._requestLogWriter.setAppend(append);
    }

    @ManagedAttribute("existing log files are appends to the new one")
    public boolean isAppend() {
        return this._requestLogWriter.isAppend();
    }

    public void setFilenameDateFormat(String logFileDateFormat) {
        this._requestLogWriter.setFilenameDateFormat(logFileDateFormat);
    }

    public String getFilenameDateFormat() {
        return this._requestLogWriter.getFilenameDateFormat();
    }

    @Override // org.eclipse.jetty.server.AbstractNCSARequestLog
    public void write(String requestEntry) throws IOException {
        this._requestLogWriter.write(requestEntry);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.AbstractNCSARequestLog, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public synchronized void doStart() throws Exception {
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.AbstractNCSARequestLog, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        synchronized (this) {
            doStop();
        }
    }
}
