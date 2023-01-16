package org.eclipse.jetty.server;

import java.io.IOException;
import org.eclipse.jetty.server.RequestLog;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Slf4jLog;

@ManagedObject("Slf4j RequestLog Writer")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/Slf4jRequestLogWriter.class */
public class Slf4jRequestLogWriter extends AbstractLifeCycle implements RequestLog.Writer {
    private Slf4jLog logger;
    private String loggerName = "org.eclipse.jetty.server.RequestLog";

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    @ManagedAttribute("logger name")
    public String getLoggerName() {
        return this.loggerName;
    }

    /* access modifiers changed from: protected */
    public boolean isEnabled() {
        return this.logger != null;
    }

    @Override // org.eclipse.jetty.server.RequestLog.Writer
    public void write(String requestEntry) throws IOException {
        this.logger.info(requestEntry, new Object[0]);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public synchronized void doStart() throws Exception {
        this.logger = new Slf4jLog(this.loggerName);
        doStart();
    }
}
