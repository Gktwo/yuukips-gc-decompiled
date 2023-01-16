package com.mchange.p009v2.log.log4j;

import com.mchange.p009v2.log.FallbackMLog;
import com.mchange.p009v2.log.LogUtils;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.log.NullMLogger;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.ResourceBundle;
import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/* renamed from: com.mchange.v2.log.log4j.Log4jMLog */
/* loaded from: grasscutter.jar:com/mchange/v2/log/log4j/Log4jMLog.class */
public final class Log4jMLog extends MLog {
    static final String CHECK_CLASS = "org.apache.log4j.Logger";

    public Log4jMLog() throws ClassNotFoundException {
        Class.forName(CHECK_CLASS);
    }

    @Override // com.mchange.p009v2.log.MLog
    public MLogger getMLogger(String str) {
        Logger logger = Logger.getLogger(str);
        if (logger != null) {
            return new Log4jMLogger(logger);
        }
        fallbackWarn(" with name '" + str + "'");
        return NullMLogger.instance();
    }

    @Override // com.mchange.p009v2.log.MLog
    public MLogger getMLogger(Class cls) {
        Logger logger = Logger.getLogger(cls);
        if (logger != null) {
            return new Log4jMLogger(logger);
        }
        fallbackWarn(" for class '" + cls.getName() + "'");
        return NullMLogger.instance();
    }

    @Override // com.mchange.p009v2.log.MLog
    public MLogger getMLogger() {
        Logger rootLogger = Logger.getRootLogger();
        if (rootLogger != null) {
            return new Log4jMLogger(rootLogger);
        }
        fallbackWarn(" (root logger)");
        return NullMLogger.instance();
    }

    private void fallbackWarn(String str) {
        FallbackMLog.getLogger().warning("Could not create or find log4j Logger" + str + ". Using NullMLogger. All messages sent to thislogger will be silently ignored. You might want to fix this.");
    }

    /* renamed from: com.mchange.v2.log.log4j.Log4jMLog$Log4jMLogger */
    /* loaded from: grasscutter.jar:com/mchange/v2/log/log4j/Log4jMLog$Log4jMLogger.class */
    private static final class Log4jMLogger implements MLogger {
        static final String FQCN = Log4jMLogger.class.getName();
        MLevel myLevel = null;
        final Logger logger;

        Log4jMLogger(Logger logger) {
            this.logger = logger;
        }

        private static MLevel guessMLevel(Level level) {
            if (level == null) {
                return null;
            }
            if (level == Level.ALL) {
                return MLevel.ALL;
            }
            if (level == Level.DEBUG) {
                return MLevel.FINEST;
            }
            if (level == Level.ERROR) {
                return MLevel.SEVERE;
            }
            if (level == Level.FATAL) {
                return MLevel.SEVERE;
            }
            if (level == Level.INFO) {
                return MLevel.INFO;
            }
            if (level == Level.OFF) {
                return MLevel.OFF;
            }
            if (level == Level.WARN) {
                return MLevel.WARNING;
            }
            throw new IllegalArgumentException("Unknown level: " + level);
        }

        private static Level level(MLevel mLevel) {
            if (mLevel == null) {
                return null;
            }
            if (mLevel == MLevel.ALL) {
                return Level.ALL;
            }
            if (mLevel == MLevel.CONFIG) {
                return Level.DEBUG;
            }
            if (mLevel == MLevel.FINE) {
                return Level.DEBUG;
            }
            if (mLevel == MLevel.FINER) {
                return Level.DEBUG;
            }
            if (mLevel == MLevel.FINEST) {
                return Level.DEBUG;
            }
            if (mLevel == MLevel.INFO) {
                return Level.INFO;
            }
            if (mLevel == MLevel.OFF) {
                return Level.OFF;
            }
            if (mLevel == MLevel.SEVERE) {
                return Level.ERROR;
            }
            if (mLevel == MLevel.WARNING) {
                return Level.WARN;
            }
            throw new IllegalArgumentException("Unknown MLevel: " + mLevel);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public ResourceBundle getResourceBundle() {
            return null;
        }

        @Override // com.mchange.p009v2.log.MLogger
        public String getResourceBundleName() {
            return null;
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void setFilter(Object obj) throws SecurityException {
            warning("setFilter() not supported by MLogger " + getClass().getName());
        }

        @Override // com.mchange.p009v2.log.MLogger
        public Object getFilter() {
            return null;
        }

        private void log(Level level, Object obj, Throwable th) {
            this.logger.log(FQCN, level, obj, th);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str) {
            log(level(mLevel), str, (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str, Object obj) {
            log(level(mLevel), str != null ? MessageFormat.format(str, obj) : null, (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str, Object[] objArr) {
            log(level(mLevel), str != null ? MessageFormat.format(str, objArr) : null, (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str, Throwable th) {
            log(level(mLevel), str, th);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3) {
            log(level(mLevel), LogUtils.createMessage(str, str2, str3), (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3, Object obj) {
            log(level(mLevel), LogUtils.createMessage(str, str2, str3 != null ? MessageFormat.format(str3, obj) : null), (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3, Object[] objArr) {
            log(level(mLevel), LogUtils.createMessage(str, str2, str3 != null ? MessageFormat.format(str3, objArr) : null), (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3, Throwable th) {
            log(level(mLevel), LogUtils.createMessage(str, str2, str3), th);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4) {
            log(level(mLevel), LogUtils.createMessage(str, str2, LogUtils.formatMessage(str3, str4, null)), (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Object obj) {
            log(level(mLevel), LogUtils.createMessage(str, str2, LogUtils.formatMessage(str3, str4, new Object[]{obj})), (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Object[] objArr) {
            log(level(mLevel), LogUtils.createMessage(str, str2, LogUtils.formatMessage(str3, str4, objArr)), (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Throwable th) {
            log(level(mLevel), LogUtils.createMessage(str, str2, LogUtils.formatMessage(str3, str4, null)), th);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void entering(String str, String str2) {
            log(Level.DEBUG, LogUtils.createMessage(str, str2, "entering method."), (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void entering(String str, String str2, Object obj) {
            log(Level.DEBUG, LogUtils.createMessage(str, str2, "entering method... param: " + obj.toString()), (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void entering(String str, String str2, Object[] objArr) {
            log(Level.DEBUG, LogUtils.createMessage(str, str2, "entering method... " + LogUtils.createParamsList(objArr)), (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void exiting(String str, String str2) {
            log(Level.DEBUG, LogUtils.createMessage(str, str2, "exiting method."), (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void exiting(String str, String str2, Object obj) {
            log(Level.DEBUG, LogUtils.createMessage(str, str2, "exiting method... result: " + obj.toString()), (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void throwing(String str, String str2, Throwable th) {
            log(Level.DEBUG, LogUtils.createMessage(str, str2, "throwing exception... "), th);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void severe(String str) {
            log(Level.ERROR, str, (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void warning(String str) {
            log(Level.WARN, str, (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void info(String str) {
            log(Level.INFO, str, (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void config(String str) {
            log(Level.DEBUG, str, (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void fine(String str) {
            log(Level.DEBUG, str, (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void finer(String str) {
            log(Level.DEBUG, str, (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void finest(String str) {
            log(Level.DEBUG, str, (Throwable) null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public synchronized void setLevel(MLevel mLevel) throws SecurityException {
            this.logger.setLevel(level(mLevel));
            this.myLevel = mLevel;
        }

        @Override // com.mchange.p009v2.log.MLogger
        public synchronized MLevel getLevel() {
            if (this.myLevel == null) {
                this.myLevel = guessMLevel(this.logger.getLevel());
            }
            return this.myLevel;
        }

        @Override // com.mchange.p009v2.log.MLogger
        public boolean isLoggable(MLevel mLevel) {
            return this.logger.isEnabledFor(level(mLevel));
        }

        @Override // com.mchange.p009v2.log.MLogger
        public String getName() {
            return this.logger.getName();
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void addHandler(Object obj) throws SecurityException {
            if (!(obj instanceof Appender)) {
                throw new IllegalArgumentException("The 'handler' " + obj + " is not compatible with MLogger " + this);
            }
            this.logger.addAppender((Appender) obj);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void removeHandler(Object obj) throws SecurityException {
            if (!(obj instanceof Appender)) {
                throw new IllegalArgumentException("The 'handler' " + obj + " is not compatible with MLogger " + this);
            }
            this.logger.removeAppender((Appender) obj);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public Object[] getHandlers() {
            LinkedList linkedList = new LinkedList();
            Enumeration allAppenders = this.logger.getAllAppenders();
            while (allAppenders.hasMoreElements()) {
                linkedList.add(allAppenders.nextElement());
            }
            return linkedList.toArray();
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void setUseParentHandlers(boolean z) {
            this.logger.setAdditivity(z);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public boolean getUseParentHandlers() {
            return this.logger.getAdditivity();
        }
    }
}
