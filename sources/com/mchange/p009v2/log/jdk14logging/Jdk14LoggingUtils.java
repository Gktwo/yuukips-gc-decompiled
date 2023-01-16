package com.mchange.p009v2.log.jdk14logging;

import com.mchange.p009v2.log.MLevel;
import java.util.logging.Level;

/* renamed from: com.mchange.v2.log.jdk14logging.Jdk14LoggingUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/log/jdk14logging/Jdk14LoggingUtils.class */
final class Jdk14LoggingUtils {
    public static MLevel mlevelFromLevel(Level level) {
        if (level == Level.ALL) {
            return MLevel.ALL;
        }
        if (level == Level.CONFIG) {
            return MLevel.CONFIG;
        }
        if (level == Level.FINE) {
            return MLevel.FINE;
        }
        if (level == Level.FINER) {
            return MLevel.FINER;
        }
        if (level == Level.FINEST) {
            return MLevel.FINEST;
        }
        if (level == Level.INFO) {
            return MLevel.INFO;
        }
        if (level == Level.OFF) {
            return MLevel.OFF;
        }
        if (level == Level.SEVERE) {
            return MLevel.SEVERE;
        }
        if (level == Level.WARNING) {
            return MLevel.WARNING;
        }
        throw new IllegalArgumentException("Unexpected Jdk14 logging level: " + level);
    }

    private Jdk14LoggingUtils() {
    }
}
