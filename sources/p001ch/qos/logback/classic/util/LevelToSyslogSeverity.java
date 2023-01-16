package p001ch.qos.logback.classic.util;

import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.util.LevelToSyslogSeverity */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/util/LevelToSyslogSeverity.class */
public class LevelToSyslogSeverity {
    public static int convert(ILoggingEvent event) {
        Level level = event.getLevel();
        switch (level.levelInt) {
            case 5000:
            case 10000:
                return 7;
            case Level.INFO_INT:
                return 6;
            case 30000:
                return 4;
            case Level.ERROR_INT:
                return 3;
            default:
                throw new IllegalArgumentException("Level " + level + " is not a valid level for a printing method");
        }
    }
}
