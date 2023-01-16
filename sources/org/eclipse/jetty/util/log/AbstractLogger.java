package org.eclipse.jetty.util.log;

import dev.morphia.mapping.Mapper;
import java.util.Properties;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/log/AbstractLogger.class */
public abstract class AbstractLogger implements Logger {
    public static final int LEVEL_DEFAULT = -1;
    public static final int LEVEL_ALL = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_WARN = 3;
    public static final int LEVEL_OFF = 10;

    protected abstract Logger newLogger(String str);

    @Override // org.eclipse.jetty.util.log.Logger
    public final Logger getLogger(String name) {
        if (isBlank(name)) {
            return this;
        }
        String basename = getName();
        String fullname = (isBlank(basename) || Log.getRootLogger() == this) ? name : basename + Mapper.IGNORED_FIELDNAME + name;
        Logger logger = Log.getLoggers().get(fullname);
        if (logger == null) {
            Logger newlog = newLogger(fullname);
            logger = Log.getMutableLoggers().putIfAbsent(fullname, newlog);
            if (logger == null) {
                logger = newlog;
            }
        }
        return logger;
    }

    private static boolean isBlank(String name) {
        if (name == null) {
            return true;
        }
        int size = name.length();
        for (int i = 0; i < size; i++) {
            if (!Character.isWhitespace(name.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int lookupLoggingLevel(Properties props, String name) {
        if (props == null || props.isEmpty() || name == null) {
            return -1;
        }
        String nameSegment = name;
        while (nameSegment != null && nameSegment.length() > 0) {
            int level = getLevelId(nameSegment + ".LEVEL", props.getProperty(nameSegment + ".LEVEL"));
            if (level != -1) {
                return level;
            }
            int idx = nameSegment.lastIndexOf(46);
            if (idx >= 0) {
                nameSegment = nameSegment.substring(0, idx);
            } else {
                nameSegment = null;
            }
        }
        return -1;
    }

    public static String getLoggingProperty(Properties props, String name, String property) {
        String nameSegment = name;
        while (nameSegment != null && nameSegment.length() > 0) {
            String s = props.getProperty(nameSegment + Mapper.IGNORED_FIELDNAME + property);
            if (s != null) {
                return s;
            }
            int idx = nameSegment.lastIndexOf(46);
            nameSegment = idx >= 0 ? nameSegment.substring(0, idx) : null;
        }
        return null;
    }

    protected static int getLevelId(String levelSegment, String levelName) {
        if (levelName == null) {
            return -1;
        }
        String levelStr = levelName.trim();
        if ("ALL".equalsIgnoreCase(levelStr)) {
            return 0;
        }
        if ("DEBUG".equalsIgnoreCase(levelStr)) {
            return 1;
        }
        if ("INFO".equalsIgnoreCase(levelStr)) {
            return 2;
        }
        if ("WARN".equalsIgnoreCase(levelStr)) {
            return 3;
        }
        if ("OFF".equalsIgnoreCase(levelStr)) {
            return 10;
        }
        System.err.println("Unknown StdErrLog level [" + levelSegment + "]=[" + levelStr + "], expecting only [ALL, DEBUG, INFO, WARN, OFF] as values.");
        return -1;
    }

    protected static String condensePackageString(String classname) {
        if (classname == null || classname.isEmpty()) {
            return "";
        }
        int rawLen = classname.length();
        StringBuilder dense = new StringBuilder(rawLen);
        boolean foundStart = false;
        boolean hasPackage = false;
        int startIdx = -1;
        int endIdx = -1;
        for (int i = 0; i < rawLen; i++) {
            char c = classname.charAt(i);
            if (!foundStart) {
                foundStart = Character.isJavaIdentifierStart(c);
                if (foundStart) {
                    if (startIdx >= 0) {
                        dense.append(classname.charAt(startIdx));
                        hasPackage = true;
                    }
                    startIdx = i;
                }
            }
            if (foundStart) {
                if (!Character.isJavaIdentifierPart(c)) {
                    foundStart = false;
                } else {
                    endIdx = i;
                }
            }
        }
        if (startIdx >= 0 && endIdx >= startIdx) {
            if (hasPackage) {
                dense.append('.');
            }
            dense.append((CharSequence) classname, startIdx, endIdx + 1);
        }
        return dense.toString();
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void debug(String msg, long arg) {
        if (isDebugEnabled()) {
            debug(msg, new Long(arg));
        }
    }
}
