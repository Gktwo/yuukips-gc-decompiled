package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.LevelConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/LevelConverter.class */
public class LevelConverter extends ClassicConverter {
    public String convert(ILoggingEvent le) {
        return le.getLevel().toString();
    }
}
