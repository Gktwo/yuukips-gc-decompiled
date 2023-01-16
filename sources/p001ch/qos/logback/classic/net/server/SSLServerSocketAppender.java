package p001ch.qos.logback.classic.net.server;

import p001ch.qos.logback.classic.net.LoggingEventPreSerializationTransformer;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.net.server.SSLServerSocketAppenderBase;
import p001ch.qos.logback.core.spi.PreSerializationTransformer;

/* renamed from: ch.qos.logback.classic.net.server.SSLServerSocketAppender */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/server/SSLServerSocketAppender.class */
public class SSLServerSocketAppender extends SSLServerSocketAppenderBase<ILoggingEvent> {
    private static final PreSerializationTransformer<ILoggingEvent> pst = new LoggingEventPreSerializationTransformer();
    private boolean includeCallerData;

    /* access modifiers changed from: protected */
    public void postProcessEvent(ILoggingEvent event) {
        if (isIncludeCallerData()) {
            event.getCallerData();
        }
    }

    @Override // p001ch.qos.logback.core.net.server.AbstractServerSocketAppender
    protected PreSerializationTransformer<ILoggingEvent> getPST() {
        return pst;
    }

    public boolean isIncludeCallerData() {
        return this.includeCallerData;
    }

    public void setIncludeCallerData(boolean includeCallerData) {
        this.includeCallerData = includeCallerData;
    }
}
