package p001ch.qos.logback.classic.jul;

import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: ch.qos.logback.classic.jul.JULHelper */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/jul/JULHelper.class */
public class JULHelper {
    public static final boolean isRegularNonRootLogger(Logger julLogger) {
        return julLogger != null && !julLogger.getName().equals("");
    }

    public static final boolean isRoot(Logger julLogger) {
        if (julLogger == null) {
            return false;
        }
        return julLogger.getName().equals("");
    }

    public static Level asJULLevel(p001ch.qos.logback.classic.Level lbLevel) {
        if (lbLevel == null) {
            throw new IllegalArgumentException("Unexpected level [null]");
        }
        switch (lbLevel.levelInt) {
            case Integer.MIN_VALUE:
                return Level.ALL;
            case 5000:
                return Level.FINEST;
            case 10000:
                return Level.FINE;
            case p001ch.qos.logback.classic.Level.INFO_INT:
                return Level.INFO;
            case 30000:
                return Level.WARNING;
            case p001ch.qos.logback.classic.Level.ERROR_INT:
                return Level.SEVERE;
            case Integer.MAX_VALUE:
                return Level.OFF;
            default:
                throw new IllegalArgumentException("Unexpected level [" + lbLevel + "]");
        }
    }

    public static String asJULLoggerName(String loggerName) {
        if (org.slf4j.Logger.ROOT_LOGGER_NAME.equals(loggerName)) {
            return "";
        }
        return loggerName;
    }

    public static Logger asJULLogger(String loggerName) {
        return Logger.getLogger(asJULLoggerName(loggerName));
    }

    public static Logger asJULLogger(p001ch.qos.logback.classic.Logger logger) {
        return asJULLogger(logger.getName());
    }
}
