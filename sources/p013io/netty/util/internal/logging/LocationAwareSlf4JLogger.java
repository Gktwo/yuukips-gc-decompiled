package p013io.netty.util.internal.logging;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.logging.LocationAwareSlf4JLogger */
/* loaded from: grasscutter.jar:io/netty/util/internal/logging/LocationAwareSlf4JLogger.class */
public final class LocationAwareSlf4JLogger extends AbstractInternalLogger {
    static final String FQCN = LocationAwareSlf4JLogger.class.getName();
    private static final long serialVersionUID = -8292030083201538180L;
    private final transient LocationAwareLogger logger;

    /* access modifiers changed from: package-private */
    public LocationAwareSlf4JLogger(LocationAwareLogger logger) {
        super(logger.getName());
        this.logger = logger;
    }

    private void log(int level, String message) {
        this.logger.log(null, FQCN, level, message, null, null);
    }

    private void log(int level, String message, Throwable cause) {
        this.logger.log(null, FQCN, level, message, null, cause);
    }

    private void log(int level, FormattingTuple tuple) {
        this.logger.log(null, FQCN, level, tuple.getMessage(), tuple.getArgArray(), tuple.getThrowable());
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void trace(String msg) {
        if (isTraceEnabled()) {
            log(0, msg);
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void trace(String format, Object arg) {
        if (isTraceEnabled()) {
            log(0, MessageFormatter.format(format, arg));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void trace(String format, Object argA, Object argB) {
        if (isTraceEnabled()) {
            log(0, MessageFormatter.format(format, argA, argB));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void trace(String format, Object... argArray) {
        if (isTraceEnabled()) {
            log(0, MessageFormatter.arrayFormat(format, argArray));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void trace(String msg, Throwable t) {
        if (isTraceEnabled()) {
            log(0, msg, t);
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void debug(String msg) {
        if (isDebugEnabled()) {
            log(10, msg);
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void debug(String format, Object arg) {
        if (isDebugEnabled()) {
            log(10, MessageFormatter.format(format, arg));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void debug(String format, Object argA, Object argB) {
        if (isDebugEnabled()) {
            log(10, MessageFormatter.format(format, argA, argB));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void debug(String format, Object... argArray) {
        if (isDebugEnabled()) {
            log(10, MessageFormatter.arrayFormat(format, argArray));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void debug(String msg, Throwable t) {
        if (isDebugEnabled()) {
            log(10, msg, t);
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void info(String msg) {
        if (isInfoEnabled()) {
            log(20, msg);
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void info(String format, Object arg) {
        if (isInfoEnabled()) {
            log(20, MessageFormatter.format(format, arg));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void info(String format, Object argA, Object argB) {
        if (isInfoEnabled()) {
            log(20, MessageFormatter.format(format, argA, argB));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void info(String format, Object... argArray) {
        if (isInfoEnabled()) {
            log(20, MessageFormatter.arrayFormat(format, argArray));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void info(String msg, Throwable t) {
        if (isInfoEnabled()) {
            log(20, msg, t);
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void warn(String msg) {
        if (isWarnEnabled()) {
            log(30, msg);
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void warn(String format, Object arg) {
        if (isWarnEnabled()) {
            log(30, MessageFormatter.format(format, arg));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void warn(String format, Object... argArray) {
        if (isWarnEnabled()) {
            log(30, MessageFormatter.arrayFormat(format, argArray));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void warn(String format, Object argA, Object argB) {
        if (isWarnEnabled()) {
            log(30, MessageFormatter.format(format, argA, argB));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void warn(String msg, Throwable t) {
        if (isWarnEnabled()) {
            log(30, msg, t);
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void error(String msg) {
        if (isErrorEnabled()) {
            log(40, msg);
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void error(String format, Object arg) {
        if (isErrorEnabled()) {
            log(40, MessageFormatter.format(format, arg));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void error(String format, Object argA, Object argB) {
        if (isErrorEnabled()) {
            log(40, MessageFormatter.format(format, argA, argB));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void error(String format, Object... argArray) {
        if (isErrorEnabled()) {
            log(40, MessageFormatter.arrayFormat(format, argArray));
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void error(String msg, Throwable t) {
        if (isErrorEnabled()) {
            log(40, msg, t);
        }
    }
}
