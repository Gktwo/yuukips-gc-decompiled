package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.ContextNameConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/ContextNameConverter.class */
public class ContextNameConverter extends ClassicConverter {
    public String convert(ILoggingEvent event) {
        return event.getLoggerContextVO().getName();
    }
}
