package org.eclipse.jetty.server;

import java.io.IOException;
import org.eclipse.jetty.util.annotation.ManagedObject;

@ManagedObject("NCSA standard format request log to slf4j bridge")
@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/Slf4jRequestLog.class */
public class Slf4jRequestLog extends AbstractNCSARequestLog {
    private final Slf4jRequestLogWriter _requestLogWriter;

    public Slf4jRequestLog() {
        this(new Slf4jRequestLogWriter());
    }

    public Slf4jRequestLog(Slf4jRequestLogWriter writer) {
        super(writer);
        this._requestLogWriter = writer;
    }

    public void setLoggerName(String loggerName) {
        this._requestLogWriter.setLoggerName(loggerName);
    }

    public String getLoggerName() {
        return this._requestLogWriter.getLoggerName();
    }

    @Override // org.eclipse.jetty.server.AbstractNCSARequestLog
    protected boolean isEnabled() {
        return this._requestLogWriter.isEnabled();
    }

    @Override // org.eclipse.jetty.server.AbstractNCSARequestLog
    public void write(String requestEntry) throws IOException {
        this._requestLogWriter.write(requestEntry);
    }
}
