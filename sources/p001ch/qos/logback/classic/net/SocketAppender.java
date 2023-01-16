package p001ch.qos.logback.classic.net;

import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.net.AbstractSocketAppender;
import p001ch.qos.logback.core.spi.PreSerializationTransformer;

/* renamed from: ch.qos.logback.classic.net.SocketAppender */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/SocketAppender.class */
public class SocketAppender extends AbstractSocketAppender<ILoggingEvent> {
    private static final PreSerializationTransformer<ILoggingEvent> pst = new LoggingEventPreSerializationTransformer();
    private boolean includeCallerData = false;

    /* access modifiers changed from: protected */
    public void postProcessEvent(ILoggingEvent event) {
        if (this.includeCallerData) {
            event.getCallerData();
        }
    }

    public void setIncludeCallerData(boolean includeCallerData) {
        this.includeCallerData = includeCallerData;
    }

    @Override // p001ch.qos.logback.core.net.AbstractSocketAppender
    public PreSerializationTransformer<ILoggingEvent> getPST() {
        return pst;
    }
}
