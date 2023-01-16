package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.LoggerConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/LoggerConverter.class */
public class LoggerConverter extends NamedConverter {
    @Override // p001ch.qos.logback.classic.pattern.NamedConverter
    protected String getFullyQualifiedName(ILoggingEvent event) {
        return event.getLoggerName();
    }
}
