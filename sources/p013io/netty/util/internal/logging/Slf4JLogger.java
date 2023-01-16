package p013io.netty.util.internal.logging;

import org.slf4j.Logger;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.logging.Slf4JLogger */
/* loaded from: grasscutter.jar:io/netty/util/internal/logging/Slf4JLogger.class */
public final class Slf4JLogger extends AbstractInternalLogger {
    private static final long serialVersionUID = 108038972685130825L;
    private final transient Logger logger;

    /* access modifiers changed from: package-private */
    public Slf4JLogger(Logger logger) {
        super(logger.getName());
        this.logger = logger;
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void trace(String msg) {
        this.logger.trace(msg);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void trace(String format, Object arg) {
        this.logger.trace(format, arg);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void trace(String format, Object argA, Object argB) {
        this.logger.trace(format, argA, argB);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void trace(String format, Object... argArray) {
        this.logger.trace(format, argArray);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void trace(String msg, Throwable t) {
        this.logger.trace(msg, t);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void debug(String msg) {
        this.logger.debug(msg);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void debug(String format, Object arg) {
        this.logger.debug(format, arg);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void debug(String format, Object argA, Object argB) {
        this.logger.debug(format, argA, argB);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void debug(String format, Object... argArray) {
        this.logger.debug(format, argArray);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void debug(String msg, Throwable t) {
        this.logger.debug(msg, t);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void info(String msg) {
        this.logger.info(msg);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void info(String format, Object arg) {
        this.logger.info(format, arg);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void info(String format, Object argA, Object argB) {
        this.logger.info(format, argA, argB);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void info(String format, Object... argArray) {
        this.logger.info(format, argArray);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void info(String msg, Throwable t) {
        this.logger.info(msg, t);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void warn(String msg) {
        this.logger.warn(msg);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void warn(String format, Object arg) {
        this.logger.warn(format, arg);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void warn(String format, Object... argArray) {
        this.logger.warn(format, argArray);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void warn(String format, Object argA, Object argB) {
        this.logger.warn(format, argA, argB);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void warn(String msg, Throwable t) {
        this.logger.warn(msg, t);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void error(String msg) {
        this.logger.error(msg);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void error(String format, Object arg) {
        this.logger.error(format, arg);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void error(String format, Object argA, Object argB) {
        this.logger.error(format, argA, argB);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void error(String format, Object... argArray) {
        this.logger.error(format, argArray);
    }

    @Override // p013io.netty.util.internal.logging.InternalLogger
    public void error(String msg, Throwable t) {
        this.logger.error(msg, t);
    }
}
