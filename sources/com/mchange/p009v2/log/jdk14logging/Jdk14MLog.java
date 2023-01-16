package com.mchange.p009v2.log.jdk14logging;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogConfig;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.util.DoubleWeakHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Filter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/* renamed from: com.mchange.v2.log.jdk14logging.Jdk14MLog */
/* loaded from: grasscutter.jar:com/mchange/v2/log/jdk14logging/Jdk14MLog.class */
public final class Jdk14MLog extends MLog {
    static final String SUPPRESS_STACK_WALK_KEY = "com.mchange.v2.log.jdk14logging.suppressStackWalk";
    private static String[] UNKNOWN_ARRAY = {"UNKNOWN_CLASS", "UNKNOWN_METHOD"};
    private static final String CHECK_CLASS = "java.util.logging.Logger";
    private static final boolean suppress_stack_walk;
    private final Map namedLoggerMap = new DoubleWeakHashMap();
    MLogger global = null;

    static {
        String property = MLogConfig.getProperty(SUPPRESS_STACK_WALK_KEY);
        if (property != null) {
            String trim = property.trim();
            if (trim.length() != 0) {
                if (trim.equalsIgnoreCase(C3P0Substitutions.DEBUG)) {
                    suppress_stack_walk = true;
                    return;
                } else if (trim.equalsIgnoreCase("false")) {
                    suppress_stack_walk = false;
                    return;
                } else {
                    System.err.println("Bad value for com.mchange.v2.log.jdk14logging.suppressStackWalk: '" + trim + "'; defaulting to 'false'.");
                    suppress_stack_walk = false;
                    return;
                }
            }
        }
        suppress_stack_walk = false;
    }

    public Jdk14MLog() throws ClassNotFoundException {
        Class.forName(CHECK_CLASS);
    }

    @Override // com.mchange.p009v2.log.MLog
    public synchronized MLogger getMLogger(String str) {
        String intern = str.intern();
        MLogger mLogger = (MLogger) this.namedLoggerMap.get(intern);
        if (mLogger == null) {
            mLogger = new Jdk14MLogger(Logger.getLogger(intern));
            this.namedLoggerMap.put(intern, mLogger);
        }
        return mLogger;
    }

    @Override // com.mchange.p009v2.log.MLog
    public synchronized MLogger getMLogger() {
        if (this.global == null) {
            this.global = new Jdk14MLogger(LogManager.getLogManager().getLogger("global"));
        }
        return this.global;
    }

    /* access modifiers changed from: private */
    public static String[] findCallingClassAndMethod() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (!(className == null || className.startsWith("com.mchange.v2.log.jdk14logging") || className.startsWith("com.mchange.sc.v1.log"))) {
                return new String[]{stackTraceElement.getClassName(), stackTraceElement.getMethodName()};
            }
        }
        return UNKNOWN_ARRAY;
    }

    /* renamed from: com.mchange.v2.log.jdk14logging.Jdk14MLog$Jdk14MLogger */
    /* loaded from: grasscutter.jar:com/mchange/v2/log/jdk14logging/Jdk14MLog$Jdk14MLogger.class */
    private static final class Jdk14MLogger implements MLogger {
        final Logger logger;
        final String name;
        final ClassAndMethodFinder cmFinder;

        /* renamed from: com.mchange.v2.log.jdk14logging.Jdk14MLog$Jdk14MLogger$ClassAndMethodFinder */
        /* loaded from: grasscutter.jar:com/mchange/v2/log/jdk14logging/Jdk14MLog$Jdk14MLogger$ClassAndMethodFinder.class */
        interface ClassAndMethodFinder {
            String[] find();
        }

        Jdk14MLogger(Logger logger) {
            this.logger = logger;
            this.name = logger.getName();
            if (Jdk14MLog.suppress_stack_walk) {
                this.cmFinder = new ClassAndMethodFinder() { // from class: com.mchange.v2.log.jdk14logging.Jdk14MLog.Jdk14MLogger.1
                    String[] fakedClassAndMethod;

                    {
                        this.fakedClassAndMethod = new String[]{Jdk14MLogger.this.name, ""};
                    }

                    @Override // com.mchange.p009v2.log.jdk14logging.Jdk14MLog.Jdk14MLogger.ClassAndMethodFinder
                    public String[] find() {
                        return this.fakedClassAndMethod;
                    }
                };
            } else {
                this.cmFinder = new ClassAndMethodFinder() { // from class: com.mchange.v2.log.jdk14logging.Jdk14MLog.Jdk14MLogger.2
                    @Override // com.mchange.p009v2.log.jdk14logging.Jdk14MLog.Jdk14MLogger.ClassAndMethodFinder
                    public String[] find() {
                        return Jdk14MLog.findCallingClassAndMethod();
                    }
                };
            }
        }

        private static Level level(MLevel mLevel) {
            return (Level) mLevel.asJdk14Level();
        }

        @Override // com.mchange.p009v2.log.MLogger
        public ResourceBundle getResourceBundle() {
            return this.logger.getResourceBundle();
        }

        @Override // com.mchange.p009v2.log.MLogger
        public String getResourceBundleName() {
            return this.logger.getResourceBundleName();
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void setFilter(Object obj) throws SecurityException {
            if (!(obj instanceof Filter)) {
                throw new IllegalArgumentException("MLogger.setFilter( ... ) requires a java.util.logging.Filter. This is not enforced by the compiler only to permit building under jdk 1.3");
            }
            this.logger.setFilter((Filter) obj);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public Object getFilter() {
            return this.logger.getFilter();
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str) {
            if (this.logger.isLoggable(level(mLevel))) {
                String[] find = this.cmFinder.find();
                this.logger.logp(level(mLevel), find[0], find[1], str);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str, Object obj) {
            if (this.logger.isLoggable(level(mLevel))) {
                String[] find = this.cmFinder.find();
                this.logger.logp(level(mLevel), find[0], find[1], str, obj);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str, Object[] objArr) {
            if (this.logger.isLoggable(level(mLevel))) {
                String[] find = this.cmFinder.find();
                this.logger.logp(level(mLevel), find[0], find[1], str, objArr);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str, Throwable th) {
            if (this.logger.isLoggable(level(mLevel))) {
                String[] find = this.cmFinder.find();
                this.logger.logp(level(mLevel), find[0], find[1], str, th);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3) {
            if (this.logger.isLoggable(level(mLevel))) {
                if (str == null && str2 == null) {
                    String[] find = this.cmFinder.find();
                    str = find[0];
                    str2 = find[1];
                }
                this.logger.logp(level(mLevel), str, str2, str3);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3, Object obj) {
            if (this.logger.isLoggable(level(mLevel))) {
                if (str == null && str2 == null) {
                    String[] find = this.cmFinder.find();
                    str = find[0];
                    str2 = find[1];
                }
                this.logger.logp(level(mLevel), str, str2, str3, obj);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3, Object[] objArr) {
            if (this.logger.isLoggable(level(mLevel))) {
                if (str == null && str2 == null) {
                    String[] find = this.cmFinder.find();
                    str = find[0];
                    str2 = find[1];
                }
                this.logger.logp(level(mLevel), str, str2, str3, objArr);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3, Throwable th) {
            if (this.logger.isLoggable(level(mLevel))) {
                if (str == null && str2 == null) {
                    String[] find = this.cmFinder.find();
                    str = find[0];
                    str2 = find[1];
                }
                this.logger.logp(level(mLevel), str, str2, str3, th);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4) {
            if (this.logger.isLoggable(level(mLevel))) {
                if (str == null && str2 == null) {
                    String[] find = this.cmFinder.find();
                    str = find[0];
                    str2 = find[1];
                }
                this.logger.logrb(level(mLevel), str, str2, str3, str4);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Object obj) {
            if (this.logger.isLoggable(level(mLevel))) {
                if (str == null && str2 == null) {
                    String[] find = this.cmFinder.find();
                    str = find[0];
                    str2 = find[1];
                }
                this.logger.logrb(level(mLevel), str, str2, str3, str4, obj);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Object[] objArr) {
            if (this.logger.isLoggable(level(mLevel))) {
                if (str == null && str2 == null) {
                    String[] find = this.cmFinder.find();
                    str = find[0];
                    str2 = find[1];
                }
                this.logger.logrb(level(mLevel), str, str2, str3, str4, objArr);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Throwable th) {
            if (this.logger.isLoggable(level(mLevel))) {
                if (str == null && str2 == null) {
                    String[] find = this.cmFinder.find();
                    str = find[0];
                    str2 = find[1];
                }
                this.logger.logrb(level(mLevel), str, str2, str3, str4, th);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void entering(String str, String str2) {
            if (this.logger.isLoggable(Level.FINER)) {
                this.logger.entering(str, str2);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void entering(String str, String str2, Object obj) {
            if (this.logger.isLoggable(Level.FINER)) {
                this.logger.entering(str, str2, obj);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void entering(String str, String str2, Object[] objArr) {
            if (this.logger.isLoggable(Level.FINER)) {
                this.logger.entering(str, str2, objArr);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void exiting(String str, String str2) {
            if (this.logger.isLoggable(Level.FINER)) {
                this.logger.exiting(str, str2);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void exiting(String str, String str2, Object obj) {
            if (this.logger.isLoggable(Level.FINER)) {
                this.logger.exiting(str, str2, obj);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void throwing(String str, String str2, Throwable th) {
            if (this.logger.isLoggable(Level.FINER)) {
                this.logger.throwing(str, str2, th);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void severe(String str) {
            if (this.logger.isLoggable(Level.SEVERE)) {
                String[] find = this.cmFinder.find();
                this.logger.logp(Level.SEVERE, find[0], find[1], str);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void warning(String str) {
            if (this.logger.isLoggable(Level.WARNING)) {
                String[] find = this.cmFinder.find();
                this.logger.logp(Level.WARNING, find[0], find[1], str);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void info(String str) {
            if (this.logger.isLoggable(Level.INFO)) {
                String[] find = this.cmFinder.find();
                this.logger.logp(Level.INFO, find[0], find[1], str);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void config(String str) {
            if (this.logger.isLoggable(Level.CONFIG)) {
                String[] find = this.cmFinder.find();
                this.logger.logp(Level.CONFIG, find[0], find[1], str);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void fine(String str) {
            if (this.logger.isLoggable(Level.FINE)) {
                String[] find = this.cmFinder.find();
                this.logger.logp(Level.FINE, find[0], find[1], str);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void finer(String str) {
            if (this.logger.isLoggable(Level.FINER)) {
                String[] find = this.cmFinder.find();
                this.logger.logp(Level.FINER, find[0], find[1], str);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void finest(String str) {
            if (this.logger.isLoggable(Level.FINEST)) {
                String[] find = this.cmFinder.find();
                this.logger.logp(Level.FINEST, find[0], find[1], str);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void setLevel(MLevel mLevel) throws SecurityException {
            this.logger.setLevel(level(mLevel));
        }

        @Override // com.mchange.p009v2.log.MLogger
        public MLevel getLevel() {
            return MLevel.fromIntValue(this.logger.getLevel().intValue());
        }

        @Override // com.mchange.p009v2.log.MLogger
        public boolean isLoggable(MLevel mLevel) {
            return this.logger.isLoggable(level(mLevel));
        }

        @Override // com.mchange.p009v2.log.MLogger
        public String getName() {
            return this.name;
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void addHandler(Object obj) throws SecurityException {
            if (!(obj instanceof Handler)) {
                throw new IllegalArgumentException("MLogger.addHandler( ... ) requires a java.util.logging.Handler. This is not enforced by the compiler only to permit building under jdk 1.3");
            }
            this.logger.addHandler((Handler) obj);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void removeHandler(Object obj) throws SecurityException {
            if (!(obj instanceof Handler)) {
                throw new IllegalArgumentException("MLogger.removeHandler( ... ) requires a java.util.logging.Handler. This is not enforced by the compiler only to permit building under jdk 1.3");
            }
            this.logger.removeHandler((Handler) obj);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public Object[] getHandlers() {
            return this.logger.getHandlers();
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void setUseParentHandlers(boolean z) {
            this.logger.setUseParentHandlers(z);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public boolean getUseParentHandlers() {
            return this.logger.getUseParentHandlers();
        }
    }
}
