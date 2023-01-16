package p013io.netty.util.internal.logging;

import java.security.AccessController;
import java.security.PrivilegedAction;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;

/* renamed from: io.netty.util.internal.logging.Log4J2Logger */
/* loaded from: grasscutter.jar:io/netty/util/internal/logging/Log4J2Logger.class */
class Log4J2Logger extends ExtendedLoggerWrapper implements InternalLogger {
    private static final long serialVersionUID = 5485418394879791397L;
    private static final boolean VARARGS_ONLY = ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: io.netty.util.internal.logging.Log4J2Logger.1
        @Override // java.security.PrivilegedAction
        public Boolean run() {
            try {
                Logger.class.getMethod("debug", String.class, Object.class);
                return false;
            } catch (NoSuchMethodException e) {
                return true;
            } catch (SecurityException e2) {
                return false;
            }
        }
    })).booleanValue();

    /* access modifiers changed from: package-private */
    public Log4J2Logger(Logger logger) {
        super((ExtendedLogger) logger, logger.getName(), logger.getMessageFactory());
        if (VARARGS_ONLY) {
            throw new UnsupportedOperationException("Log4J2 version mismatch");
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public String name() {
        return getName();
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void trace(Throwable t) {
        log(Level.TRACE, "Unexpected exception:", t);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void debug(Throwable t) {
        log(Level.DEBUG, "Unexpected exception:", t);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void info(Throwable t) {
        log(Level.INFO, "Unexpected exception:", t);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void warn(Throwable t) {
        log(Level.WARN, "Unexpected exception:", t);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void error(Throwable t) {
        log(Level.ERROR, "Unexpected exception:", t);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public boolean isEnabled(InternalLogLevel level) {
        return isEnabled(toLevel(level));
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel level, String msg) {
        log(toLevel(level), msg);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel level, String format, Object arg) {
        log(toLevel(level), format, arg);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel level, String format, Object argA, Object argB) {
        log(toLevel(level), format, argA, argB);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel level, String format, Object... arguments) {
        log(toLevel(level), format, arguments);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel level, String msg, Throwable t) {
        log(toLevel(level), msg, t);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel level, Throwable t) {
        log(toLevel(level), "Unexpected exception:", t);
    }

    private static Level toLevel(InternalLogLevel level) {
        switch (level) {
            case INFO:
                return Level.INFO;
            case DEBUG:
                return Level.DEBUG;
            case WARN:
                return Level.WARN;
            case ERROR:
                return Level.ERROR;
            case TRACE:
                return Level.TRACE;
            default:
                throw new Error();
        }
    }
}
