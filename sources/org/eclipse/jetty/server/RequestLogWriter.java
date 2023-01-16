package org.eclipse.jetty.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.TimeZone;
import org.eclipse.jetty.server.RequestLog;
import org.eclipse.jetty.util.RolloverFileOutputStream;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject("Request Log writer which writes to file")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/RequestLogWriter.class */
public class RequestLogWriter extends AbstractLifeCycle implements RequestLog.Writer {
    private static final Logger LOG = Log.getLogger(RequestLogWriter.class);
    private String _filename;
    private boolean _append;
    private int _retainDays;
    private boolean _closeOut;
    private String _timeZone;
    private String _filenameDateFormat;
    private transient OutputStream _out;
    private transient OutputStream _fileOut;
    private transient Writer _writer;

    public RequestLogWriter() {
        this(null);
    }

    public RequestLogWriter(String filename) {
        this._timeZone = "GMT";
        this._filenameDateFormat = null;
        setAppend(true);
        setRetainDays(31);
        if (filename != null) {
            setFilename(filename);
        }
    }

    public void setFilename(String filename) {
        if (filename != null) {
            filename = filename.trim();
            if (filename.length() == 0) {
                filename = null;
            }
        }
        this._filename = filename;
    }

    @ManagedAttribute("filename")
    public String getFileName() {
        return this._filename;
    }

    @ManagedAttribute("dated filename")
    public String getDatedFilename() {
        if (this._fileOut instanceof RolloverFileOutputStream) {
            return ((RolloverFileOutputStream) this._fileOut).getDatedFilename();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean isEnabled() {
        return this._fileOut != null;
    }

    public void setRetainDays(int retainDays) {
        this._retainDays = retainDays;
    }

    @ManagedAttribute("number of days to keep a log file")
    public int getRetainDays() {
        return this._retainDays;
    }

    public void setAppend(boolean append) {
        this._append = append;
    }

    @ManagedAttribute("if request log file will be appended after restart")
    public boolean isAppend() {
        return this._append;
    }

    public void setFilenameDateFormat(String logFileDateFormat) {
        this._filenameDateFormat = logFileDateFormat;
    }

    @ManagedAttribute("log file name date format")
    public String getFilenameDateFormat() {
        return this._filenameDateFormat;
    }

    @Override // org.eclipse.jetty.server.RequestLog.Writer
    public void write(String requestEntry) throws IOException {
        synchronized (this) {
            if (this._writer != null) {
                this._writer.write(requestEntry);
                this._writer.write(System.lineSeparator());
                this._writer.flush();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public synchronized void doStart() throws Exception {
        if (this._filename != null) {
            this._fileOut = new RolloverFileOutputStream(this._filename, this._append, this._retainDays, TimeZone.getTimeZone(getTimeZone()), this._filenameDateFormat, null);
            this._closeOut = true;
            LOG.info("Opened " + getDatedFilename(), new Object[0]);
        } else {
            this._fileOut = System.err;
        }
        this._out = this._fileOut;
        synchronized (this) {
            this._writer = new OutputStreamWriter(this._out);
        }
        doStart();
    }

    public void setTimeZone(String timeZone) {
        this._timeZone = timeZone;
    }

    @ManagedAttribute("timezone of the log")
    public String getTimeZone() {
        return this._timeZone;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x003b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws java.lang.Exception {
        /*
            r3 = this;
            r0 = r3
            r1 = r0
            r4 = r1
            monitor-enter(r0)
            r0 = r3
            r0.doStop()     // Catch: all -> 0x005e
            r0 = r3
            java.io.Writer r0 = r0._writer     // Catch: all -> 0x005e, IOException -> 0x0019
            if (r0 == 0) goto L_0x0016
            r0 = r3
            java.io.Writer r0 = r0._writer     // Catch: all -> 0x005e, IOException -> 0x0019
            r0.flush()     // Catch: all -> 0x005e, IOException -> 0x0019
        L_0x0016:
            goto L_0x0023
        L_0x0019:
            r5 = move-exception
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.RequestLogWriter.LOG     // Catch: all -> 0x005e
            r1 = r5
            r0.ignore(r1)     // Catch: all -> 0x005e
        L_0x0023:
            r0 = r3
            java.io.OutputStream r0 = r0._out     // Catch: all -> 0x005e
            if (r0 == 0) goto L_0x0045
            r0 = r3
            boolean r0 = r0._closeOut     // Catch: all -> 0x005e
            if (r0 == 0) goto L_0x0045
            r0 = r3
            java.io.OutputStream r0 = r0._out     // Catch: all -> 0x005e, IOException -> 0x003b
            r0.close()     // Catch: all -> 0x005e, IOException -> 0x003b
            goto L_0x0045
        L_0x003b:
            r5 = move-exception
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.RequestLogWriter.LOG     // Catch: all -> 0x005e
            r1 = r5
            r0.ignore(r1)     // Catch: all -> 0x005e
        L_0x0045:
            r0 = r3
            r1 = 0
            r0._out = r1     // Catch: all -> 0x005e
            r0 = r3
            r1 = 0
            r0._fileOut = r1     // Catch: all -> 0x005e
            r0 = r3
            r1 = 0
            r0._closeOut = r1     // Catch: all -> 0x005e
            r0 = r3
            r1 = 0
            r0._writer = r1     // Catch: all -> 0x005e
            r0 = r4
            monitor-exit(r0)     // Catch: all -> 0x005e
            goto L_0x0063
        L_0x005e:
            r6 = move-exception
            r0 = r4
            monitor-exit(r0)     // Catch: all -> 0x005e
            r0 = r6
            throw r0
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.RequestLogWriter.doStop():void");
    }
}
