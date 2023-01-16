package p001ch.qos.logback.classic.net;

import java.io.Serializable;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.classic.spi.LoggingEvent;
import p001ch.qos.logback.classic.spi.LoggingEventVO;
import p001ch.qos.logback.core.spi.PreSerializationTransformer;

/* renamed from: ch.qos.logback.classic.net.LoggingEventPreSerializationTransformer */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/LoggingEventPreSerializationTransformer.class */
public class LoggingEventPreSerializationTransformer implements PreSerializationTransformer<ILoggingEvent> {
    public Serializable transform(ILoggingEvent event) {
        if (event == null) {
            return null;
        }
        if (event instanceof LoggingEvent) {
            return LoggingEventVO.build(event);
        }
        if (event instanceof LoggingEventVO) {
            return (LoggingEventVO) event;
        }
        throw new IllegalArgumentException("Unsupported type " + event.getClass().getName());
    }
}
