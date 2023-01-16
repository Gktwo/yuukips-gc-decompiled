package org.eclipse.jetty.util.log;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.eclipse.jetty.util.Loader;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/log/JavaUtilLog.class */
public class JavaUtilLog extends AbstractLogger {
    private static final String THIS_CLASS = JavaUtilLog.class.getName();
    private static final boolean __source = Boolean.parseBoolean(Log.__props.getProperty("org.eclipse.jetty.util.log.SOURCE", Log.__props.getProperty("org.eclipse.jetty.util.log.javautil.SOURCE", C3P0Substitutions.DEBUG)));
    private static boolean _initialized = false;
    private Level configuredLevel;
    private Logger _logger;

    public JavaUtilLog() {
        this("org.eclipse.jetty.util.log.javautil");
    }

    public JavaUtilLog(String name) {
        synchronized (JavaUtilLog.class) {
            if (!_initialized) {
                _initialized = true;
                final String properties = Log.__props.getProperty("org.eclipse.jetty.util.log.javautil.PROPERTIES", null);
                if (properties != null) {
                    AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.eclipse.jetty.util.log.JavaUtilLog.1
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            try {
                                URL props = Loader.getResource(properties);
                                if (props != null) {
                                    LogManager.getLogManager().readConfiguration(props.openStream());
                                }
                                return null;
                            } catch (Throwable e) {
                                System.err.println("[WARN] Error loading logging config: " + properties);
                                e.printStackTrace(System.err);
                                return null;
                            }
                        }
                    });
                }
            }
        }
        this._logger = Logger.getLogger(name);
        switch (lookupLoggingLevel(Log.__props, name)) {
            case 0:
                this._logger.setLevel(Level.ALL);
                break;
            case 1:
                this._logger.setLevel(Level.FINE);
                break;
            case 2:
                this._logger.setLevel(Level.INFO);
                break;
            case 3:
                this._logger.setLevel(Level.WARNING);
                break;
            case 10:
                this._logger.setLevel(Level.OFF);
                break;
        }
        this.configuredLevel = this._logger.getLevel();
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public String getName() {
        return this._logger.getName();
    }

    protected void log(Level level, String msg, Throwable thrown) {
        LogRecord record = new LogRecord(level, msg);
        if (thrown != null) {
            record.setThrown(thrown);
        }
        record.setLoggerName(this._logger.getName());
        if (__source) {
            StackTraceElement[] stack = new Throwable().getStackTrace();
            int i = 0;
            while (true) {
                if (i >= stack.length) {
                    break;
                }
                StackTraceElement e = stack[i];
                if (!e.getClassName().equals(THIS_CLASS)) {
                    record.setSourceClassName(e.getClassName());
                    record.setSourceMethodName(e.getMethodName());
                    break;
                }
                i++;
            }
        }
        this._logger.log(record);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void warn(String msg, Object... args) {
        if (this._logger.isLoggable(Level.WARNING)) {
            log(Level.WARNING, format(msg, args), null);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void warn(Throwable thrown) {
        if (this._logger.isLoggable(Level.WARNING)) {
            log(Level.WARNING, "", thrown);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void warn(String msg, Throwable thrown) {
        if (this._logger.isLoggable(Level.WARNING)) {
            log(Level.WARNING, msg, thrown);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void info(String msg, Object... args) {
        if (this._logger.isLoggable(Level.INFO)) {
            log(Level.INFO, format(msg, args), null);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void info(Throwable thrown) {
        if (this._logger.isLoggable(Level.INFO)) {
            log(Level.INFO, "", thrown);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void info(String msg, Throwable thrown) {
        if (this._logger.isLoggable(Level.INFO)) {
            log(Level.INFO, msg, thrown);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public boolean isDebugEnabled() {
        return this._logger.isLoggable(Level.FINE);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void setDebugEnabled(boolean enabled) {
        if (enabled) {
            this.configuredLevel = this._logger.getLevel();
            this._logger.setLevel(Level.FINE);
            return;
        }
        this._logger.setLevel(this.configuredLevel);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void debug(String msg, Object... args) {
        if (this._logger.isLoggable(Level.FINE)) {
            log(Level.FINE, format(msg, args), null);
        }
    }

    @Override // org.eclipse.jetty.util.log.AbstractLogger, org.eclipse.jetty.util.log.Logger
    public void debug(String msg, long arg) {
        if (this._logger.isLoggable(Level.FINE)) {
            log(Level.FINE, format(msg, Long.valueOf(arg)), null);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void debug(Throwable thrown) {
        if (this._logger.isLoggable(Level.FINE)) {
            log(Level.FINE, "", thrown);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void debug(String msg, Throwable thrown) {
        if (this._logger.isLoggable(Level.FINE)) {
            log(Level.FINE, msg, thrown);
        }
    }

    @Override // org.eclipse.jetty.util.log.AbstractLogger
    protected Logger newLogger(String fullname) {
        return new JavaUtilLog(fullname);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void ignore(Throwable ignored) {
        if (this._logger.isLoggable(Level.FINEST)) {
            log(Level.FINEST, Log.IGNORED, ignored);
        }
    }

    private String format(String msg, Object... args) {
        String msg2 = String.valueOf(msg);
        StringBuilder builder = new StringBuilder();
        int start = 0;
        for (Object arg : args) {
            int bracesIndex = msg2.indexOf("{}", start);
            if (bracesIndex < 0) {
                builder.append(msg2.substring(start));
                builder.append(" ");
                builder.append(arg);
                start = msg2.length();
            } else {
                builder.append((CharSequence) msg2, start, bracesIndex);
                builder.append(arg);
                start = bracesIndex + "{}".length();
            }
        }
        builder.append(msg2.substring(start));
        return builder.toString();
    }
}
