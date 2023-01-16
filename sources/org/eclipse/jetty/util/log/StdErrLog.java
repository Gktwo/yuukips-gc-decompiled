package org.eclipse.jetty.util.log;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.PrintStream;
import java.security.AccessControlException;
import java.util.Properties;
import org.eclipse.jetty.util.DateCache;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import p001ch.qos.logback.core.CoreConstants;

@ManagedObject("Jetty StdErr Logging Implementation")
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/log/StdErrLog.class */
public class StdErrLog extends AbstractLogger {
    private static DateCache _dateCache;
    private int _level;
    private int _configuredLevel;
    private PrintStream _altStream;
    private boolean _source;
    private boolean _printLongNames;
    private final String _name;
    protected final String _abbrevname;
    private boolean _hideStacks;
    private static final String EOL = System.lineSeparator();
    private static final Object[] EMPTY_ARGS = new Object[0];
    private static int __tagpad = Integer.parseInt(Log.__props.getProperty("org.eclipse.jetty.util.log.StdErrLog.TAG_PAD", "0"));
    private static final boolean __source = Boolean.parseBoolean(Log.__props.getProperty("org.eclipse.jetty.util.log.SOURCE", Log.__props.getProperty("org.eclipse.jetty.util.log.stderr.SOURCE", "false")));
    private static final boolean __long = Boolean.parseBoolean(Log.__props.getProperty("org.eclipse.jetty.util.log.stderr.LONG", "false"));
    private static final boolean __escape = Boolean.parseBoolean(Log.__props.getProperty("org.eclipse.jetty.util.log.stderr.ESCAPE", C3P0Substitutions.DEBUG));

    static {
        String[] deprecatedProperties = {"DEBUG", "org.eclipse.jetty.util.log.DEBUG", "org.eclipse.jetty.util.log.stderr.DEBUG"};
        for (String deprecatedProp : deprecatedProperties) {
            if (System.getProperty(deprecatedProp) != null) {
                System.err.printf("System Property [%s] has been deprecated! (Use org.eclipse.jetty.LEVEL=DEBUG instead)%n", deprecatedProp);
            }
        }
        try {
            _dateCache = new DateCache("yyyy-MM-dd HH:mm:ss");
        } catch (Exception x) {
            x.printStackTrace(System.err);
        }
    }

    public static void setTagPad(int pad) {
        __tagpad = pad;
    }

    public static int getLoggingLevel(Properties props, String name) {
        int level = lookupLoggingLevel(props, name);
        if (level == -1) {
            level = lookupLoggingLevel(props, "log");
            if (level == -1) {
                level = 2;
            }
        }
        return level;
    }

    public static StdErrLog getLogger(Class<?> clazz) {
        Logger log = Log.getLogger(clazz);
        if (log instanceof StdErrLog) {
            return (StdErrLog) log;
        }
        throw new RuntimeException("Logger for " + clazz + " is not of type StdErrLog");
    }

    public StdErrLog() {
        this(null);
    }

    public StdErrLog(String name) {
        this(name, null);
    }

    public StdErrLog(String name, Properties props) {
        this._printLongNames = __long;
        this._hideStacks = false;
        boolean sameObject = props != Log.__props;
        if (props != null && sameObject) {
            Log.__props.putAll(props);
        }
        this._name = name == null ? "" : name;
        this._abbrevname = condensePackageString(this._name);
        this._level = getLoggingLevel(Log.__props, this._name);
        this._configuredLevel = this._level;
        try {
            String source = getLoggingProperty(Log.__props, this._name, "SOURCE");
            this._source = source == null ? __source : Boolean.parseBoolean(source);
        } catch (AccessControlException e) {
            this._source = __source;
        }
        try {
            String stacks = getLoggingProperty(Log.__props, this._name, "STACKS");
            this._hideStacks = stacks != null && !Boolean.parseBoolean(stacks);
        } catch (AccessControlException e2) {
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public String getName() {
        return this._name;
    }

    public void setPrintLongNames(boolean printLongNames) {
        this._printLongNames = printLongNames;
    }

    public boolean isPrintLongNames() {
        return this._printLongNames;
    }

    public boolean isHideStacks() {
        return this._hideStacks;
    }

    public void setHideStacks(boolean hideStacks) {
        this._hideStacks = hideStacks;
    }

    public boolean isSource() {
        return this._source;
    }

    public void setSource(boolean source) {
        this._source = source;
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void warn(String msg, Object... args) {
        if (this._level <= 3) {
            StringBuilder builder = new StringBuilder(64);
            format(builder, ":WARN:", msg, args);
            println(builder);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void warn(Throwable thrown) {
        warn("", thrown);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void warn(String msg, Throwable thrown) {
        if (this._level <= 3) {
            StringBuilder builder = new StringBuilder(64);
            format(builder, ":WARN:", msg, thrown);
            println(builder);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void info(String msg, Object... args) {
        if (this._level <= 2) {
            StringBuilder builder = new StringBuilder(64);
            format(builder, ":INFO:", msg, args);
            println(builder);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void info(Throwable thrown) {
        info("", thrown);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void info(String msg, Throwable thrown) {
        if (this._level <= 2) {
            StringBuilder builder = new StringBuilder(64);
            format(builder, ":INFO:", msg, thrown);
            println(builder);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    @ManagedAttribute("is debug enabled for root logger Log.LOG")
    public boolean isDebugEnabled() {
        return this._level <= 1;
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void setDebugEnabled(boolean enabled) {
        setLevel(enabled ? 1 : getConfiguredLevel());
        String name = getName();
        for (Logger log : Log.getLoggers().values()) {
            if (log.getName().startsWith(name) && (log instanceof StdErrLog)) {
                StdErrLog logger = (StdErrLog) log;
                logger.setLevel(enabled ? 1 : logger.getConfiguredLevel());
            }
        }
    }

    private int getConfiguredLevel() {
        return this._configuredLevel;
    }

    public int getLevel() {
        return this._level;
    }

    public void setLevel(int level) {
        this._level = level;
    }

    public void setStdErrStream(PrintStream stream) {
        this._altStream = stream;
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void debug(String msg, Object... args) {
        if (isDebugEnabled()) {
            StringBuilder builder = new StringBuilder(64);
            format(builder, ":DBUG:", msg, args);
            println(builder);
        }
    }

    @Override // org.eclipse.jetty.util.log.AbstractLogger, org.eclipse.jetty.util.log.Logger
    public void debug(String msg, long arg) {
        if (isDebugEnabled()) {
            StringBuilder builder = new StringBuilder(64);
            format(builder, ":DBUG:", msg, Long.valueOf(arg));
            println(builder);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void debug(Throwable thrown) {
        debug("", thrown);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void debug(String msg, Throwable thrown) {
        if (isDebugEnabled()) {
            StringBuilder builder = new StringBuilder(64);
            format(builder, ":DBUG:", msg, thrown);
            println(builder);
        }
    }

    private void println(StringBuilder builder) {
        if (this._altStream != null) {
            this._altStream.println(builder);
        } else {
            System.err.println(builder);
        }
    }

    private void format(StringBuilder builder, String level, String msg, Object... inArgs) {
        long now = System.currentTimeMillis();
        tag(builder, _dateCache.formatNow(now), (int) (now % 1000), level);
        Object[] msgArgs = EMPTY_ARGS;
        int msgArgsLen = 0;
        Throwable cause = null;
        if (inArgs != null) {
            msgArgs = inArgs;
            msgArgsLen = inArgs.length;
            if (msgArgsLen > 0 && (inArgs[msgArgsLen - 1] instanceof Throwable)) {
                cause = (Throwable) inArgs[msgArgsLen - 1];
                msgArgsLen--;
            }
        }
        if (msg == null) {
            msg = "";
            for (int i = 0; i < msgArgsLen; i++) {
                msg = msg + "{} ";
            }
        }
        int start = 0;
        for (int i2 = 0; i2 < msgArgsLen; i2++) {
            Object arg = msgArgs[i2];
            int bracesIndex = msg.indexOf("{}", start);
            if (bracesIndex < 0) {
                escape(builder, msg.substring(start));
                builder.append(" ");
                if (arg != null) {
                    builder.append(arg);
                }
                start = msg.length();
            } else {
                escape(builder, msg.substring(start, bracesIndex));
                if (arg != null) {
                    builder.append(arg);
                }
                start = bracesIndex + "{}".length();
            }
        }
        escape(builder, msg.substring(start));
        if (cause == null) {
            return;
        }
        if (isHideStacks()) {
            builder.append(": ").append(cause);
        } else {
            formatCause(builder, cause, "");
        }
    }

    private void formatCause(StringBuilder builder, Throwable cause, String indent) {
        builder.append(EOL).append(indent);
        escape(builder, cause.toString());
        StackTraceElement[] elements = cause.getStackTrace();
        int i = 0;
        while (elements != null && i < elements.length) {
            builder.append(EOL).append(indent).append("\tat ");
            escape(builder, elements[i].toString());
            i++;
        }
        Throwable[] suppressed = cause.getSuppressed();
        for (Throwable suppressed2 : suppressed) {
            builder.append(EOL).append(indent).append(CoreConstants.SUPPRESSED);
            formatCause(builder, suppressed2, "\t|" + indent);
        }
        Throwable by = cause.getCause();
        if (!(by == null || by == cause)) {
            builder.append(EOL).append(indent).append(CoreConstants.CAUSED_BY);
            formatCause(builder, by, indent);
        }
    }

    private void escape(StringBuilder builder, String str) {
        if (__escape) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!Character.isISOControl(c)) {
                    builder.append(c);
                } else if (c == '\n') {
                    builder.append('|');
                } else if (c == '\r') {
                    builder.append('<');
                } else {
                    builder.append('?');
                }
            }
            return;
        }
        builder.append(str);
    }

    private void tag(StringBuilder builder, String d, int ms, String tag) {
        builder.setLength(0);
        builder.append(d);
        if (ms > 99) {
            builder.append('.');
        } else if (ms > 9) {
            builder.append(".0");
        } else {
            builder.append(".00");
        }
        builder.append(ms).append(tag);
        String name = this._printLongNames ? this._name : this._abbrevname;
        String tname = Thread.currentThread().getName();
        int p = __tagpad > 0 ? (name.length() + tname.length()) - __tagpad : 0;
        if (p < 0) {
            builder.append(name).append(':').append("                                                  ", 0, -p).append(tname);
        } else if (p == 0) {
            builder.append(name).append(':').append(tname);
        }
        builder.append(':');
        if (this._source) {
            StackTraceElement[] frames = new Throwable().getStackTrace();
            int length = frames.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement frame = frames[i];
                String clazz = frame.getClassName();
                if (clazz.equals(StdErrLog.class.getName()) || clazz.equals(Log.class.getName())) {
                    i++;
                } else {
                    if (this._printLongNames || !clazz.startsWith("org.eclipse.jetty.")) {
                        builder.append(clazz);
                    } else {
                        builder.append(condensePackageString(clazz));
                    }
                    builder.append('#').append(frame.getMethodName());
                    if (frame.getFileName() != null) {
                        builder.append('(').append(frame.getFileName()).append(':').append(frame.getLineNumber()).append(')');
                    }
                    builder.append(':');
                }
            }
        }
        builder.append(' ');
    }

    @Override // org.eclipse.jetty.util.log.AbstractLogger
    protected Logger newLogger(String fullname) {
        StdErrLog logger = new StdErrLog(fullname);
        logger.setPrintLongNames(this._printLongNames);
        logger._altStream = this._altStream;
        if (this._level != this._configuredLevel) {
            logger._level = this._level;
        }
        return logger;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("StdErrLog:");
        s.append(this._name);
        s.append(":LEVEL=");
        switch (this._level) {
            case 0:
                s.append("ALL");
                break;
            case 1:
                s.append("DEBUG");
                break;
            case 2:
                s.append("INFO");
                break;
            case 3:
                s.append("WARN");
                break;
            default:
                s.append("?");
                break;
        }
        return s.toString();
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void ignore(Throwable ignored) {
        if (this._level <= 0) {
            StringBuilder builder = new StringBuilder(64);
            format(builder, ":IGNORED:", "", ignored);
            println(builder);
        }
    }
}
