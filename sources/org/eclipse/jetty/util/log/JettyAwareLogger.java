package org.eclipse.jetty.util.log;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/log/JettyAwareLogger.class */
public class JettyAwareLogger implements Logger {
    private static final int DEBUG = 10;
    private static final int ERROR = 40;
    private static final int INFO = 20;
    private static final int TRACE = 0;
    private static final int WARN = 30;
    private static final String FQCN = Slf4jLog.class.getName();
    private final LocationAwareLogger _logger;

    public JettyAwareLogger(LocationAwareLogger logger) {
        this._logger = logger;
    }

    @Override // org.slf4j.Logger
    public String getName() {
        return this._logger.getName();
    }

    @Override // org.slf4j.Logger
    public boolean isTraceEnabled() {
        return this._logger.isTraceEnabled();
    }

    @Override // org.slf4j.Logger
    public void trace(String msg) {
        log(null, 0, msg, null, null);
    }

    @Override // org.slf4j.Logger
    public void trace(String format, Object arg) {
        log(null, 0, format, new Object[]{arg}, null);
    }

    @Override // org.slf4j.Logger
    public void trace(String format, Object arg1, Object arg2) {
        log(null, 0, format, new Object[]{arg1, arg2}, null);
    }

    @Override // org.slf4j.Logger
    public void trace(String format, Object[] argArray) {
        log(null, 0, format, argArray, null);
    }

    @Override // org.slf4j.Logger
    public void trace(String msg, Throwable t) {
        log(null, 0, msg, null, t);
    }

    @Override // org.slf4j.Logger
    public boolean isTraceEnabled(Marker marker) {
        return this._logger.isTraceEnabled(marker);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String msg) {
        log(marker, 0, msg, null, null);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String format, Object arg) {
        log(marker, 0, format, new Object[]{arg}, null);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        log(marker, 0, format, new Object[]{arg1, arg2}, null);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String format, Object[] argArray) {
        log(marker, 0, format, argArray, null);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String msg, Throwable t) {
        log(marker, 0, msg, null, t);
    }

    @Override // org.slf4j.Logger
    public boolean isDebugEnabled() {
        return this._logger.isDebugEnabled();
    }

    @Override // org.slf4j.Logger
    public void debug(String msg) {
        log(null, 10, msg, null, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String format, Object arg) {
        log(null, 10, format, new Object[]{arg}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String format, Object arg1, Object arg2) {
        log(null, 10, format, new Object[]{arg1, arg2}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String format, Object[] argArray) {
        log(null, 10, format, argArray, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String msg, Throwable t) {
        log(null, 10, msg, null, t);
    }

    @Override // org.slf4j.Logger
    public boolean isDebugEnabled(Marker marker) {
        return this._logger.isDebugEnabled(marker);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String msg) {
        log(marker, 10, msg, null, null);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String format, Object arg) {
        log(marker, 10, format, new Object[]{arg}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        log(marker, 10, format, new Object[]{arg1, arg2}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String format, Object[] argArray) {
        log(marker, 10, format, argArray, null);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String msg, Throwable t) {
        log(marker, 10, msg, null, t);
    }

    @Override // org.slf4j.Logger
    public boolean isInfoEnabled() {
        return this._logger.isInfoEnabled();
    }

    @Override // org.slf4j.Logger
    public void info(String msg) {
        log(null, 20, msg, null, null);
    }

    @Override // org.slf4j.Logger
    public void info(String format, Object arg) {
        log(null, 20, format, new Object[]{arg}, null);
    }

    @Override // org.slf4j.Logger
    public void info(String format, Object arg1, Object arg2) {
        log(null, 20, format, new Object[]{arg1, arg2}, null);
    }

    @Override // org.slf4j.Logger
    public void info(String format, Object[] argArray) {
        log(null, 20, format, argArray, null);
    }

    @Override // org.slf4j.Logger
    public void info(String msg, Throwable t) {
        log(null, 20, msg, null, t);
    }

    @Override // org.slf4j.Logger
    public boolean isInfoEnabled(Marker marker) {
        return this._logger.isInfoEnabled(marker);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String msg) {
        log(marker, 20, msg, null, null);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String format, Object arg) {
        log(marker, 20, format, new Object[]{arg}, null);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        log(marker, 20, format, new Object[]{arg1, arg2}, null);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String format, Object[] argArray) {
        log(marker, 20, format, argArray, null);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String msg, Throwable t) {
        log(marker, 20, msg, null, t);
    }

    @Override // org.slf4j.Logger
    public boolean isWarnEnabled() {
        return this._logger.isWarnEnabled();
    }

    @Override // org.slf4j.Logger
    public void warn(String msg) {
        log(null, 30, msg, null, null);
    }

    @Override // org.slf4j.Logger
    public void warn(String format, Object arg) {
        log(null, 30, format, new Object[]{arg}, null);
    }

    @Override // org.slf4j.Logger
    public void warn(String format, Object[] argArray) {
        log(null, 30, format, argArray, null);
    }

    @Override // org.slf4j.Logger
    public void warn(String format, Object arg1, Object arg2) {
        log(null, 30, format, new Object[]{arg1, arg2}, null);
    }

    @Override // org.slf4j.Logger
    public void warn(String msg, Throwable t) {
        log(null, 30, msg, null, t);
    }

    @Override // org.slf4j.Logger
    public boolean isWarnEnabled(Marker marker) {
        return this._logger.isWarnEnabled(marker);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String msg) {
        log(marker, 30, msg, null, null);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String format, Object arg) {
        log(marker, 30, format, new Object[]{arg}, null);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        log(marker, 30, format, new Object[]{arg1, arg2}, null);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String format, Object[] argArray) {
        log(marker, 30, format, argArray, null);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String msg, Throwable t) {
        log(marker, 30, msg, null, t);
    }

    @Override // org.slf4j.Logger
    public boolean isErrorEnabled() {
        return this._logger.isErrorEnabled();
    }

    @Override // org.slf4j.Logger
    public void error(String msg) {
        log(null, 40, msg, null, null);
    }

    @Override // org.slf4j.Logger
    public void error(String format, Object arg) {
        log(null, 40, format, new Object[]{arg}, null);
    }

    @Override // org.slf4j.Logger
    public void error(String format, Object arg1, Object arg2) {
        log(null, 40, format, new Object[]{arg1, arg2}, null);
    }

    @Override // org.slf4j.Logger
    public void error(String format, Object[] argArray) {
        log(null, 40, format, argArray, null);
    }

    @Override // org.slf4j.Logger
    public void error(String msg, Throwable t) {
        log(null, 40, msg, null, t);
    }

    @Override // org.slf4j.Logger
    public boolean isErrorEnabled(Marker marker) {
        return this._logger.isErrorEnabled(marker);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String msg) {
        log(marker, 40, msg, null, null);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String format, Object arg) {
        log(marker, 40, format, new Object[]{arg}, null);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        log(marker, 40, format, new Object[]{arg1, arg2}, null);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String format, Object[] argArray) {
        log(marker, 40, format, argArray, null);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String msg, Throwable t) {
        log(marker, 40, msg, null, t);
    }

    public String toString() {
        return this._logger.toString();
    }

    private void log(Marker marker, int level, String msg, Object[] argArray, Throwable t) {
        int loggerLevel;
        if (argArray == null) {
            this._logger.log(marker, FQCN, level, msg, null, t);
            return;
        }
        if (this._logger.isTraceEnabled()) {
            loggerLevel = 0;
        } else if (this._logger.isDebugEnabled()) {
            loggerLevel = 10;
        } else if (this._logger.isInfoEnabled()) {
            loggerLevel = 20;
        } else if (this._logger.isWarnEnabled()) {
            loggerLevel = 30;
        } else {
            loggerLevel = 40;
        }
        if (loggerLevel <= level) {
            this._logger.log(marker, FQCN, level, MessageFormatter.arrayFormat(msg, argArray).getMessage(), null, t);
        }
    }
}
