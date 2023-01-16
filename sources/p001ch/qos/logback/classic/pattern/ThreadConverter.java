package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.ThreadConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/ThreadConverter.class */
public class ThreadConverter extends ClassicConverter {
    public String convert(ILoggingEvent event) {
        return event.getThreadName();
    }
}
