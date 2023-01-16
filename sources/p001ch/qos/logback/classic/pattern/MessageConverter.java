package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.MessageConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/MessageConverter.class */
public class MessageConverter extends ClassicConverter {
    public String convert(ILoggingEvent event) {
        return event.getFormattedMessage();
    }
}
