package com.mchange.p009v2.log.slf4j;

import com.mchange.p009v2.log.FallbackMLog;
import com.mchange.p009v2.log.LogUtils;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogInitializationException;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.log.NullMLogger;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* renamed from: com.mchange.v2.log.slf4j.Slf4jMLog */
/* loaded from: grasscutter.jar:com/mchange/v2/log/slf4j/Slf4jMLog.class */
public final class Slf4jMLog extends MLog {
    static final Object[] EMPTY_OBJ_ARRAY = new Object[0];
    private static final int ALL_INTVAL = MLevel.ALL.intValue();
    private static final int CONFIG_INTVAL = MLevel.CONFIG.intValue();
    private static final int FINE_INTVAL = MLevel.FINE.intValue();
    private static final int FINER_INTVAL = MLevel.FINER.intValue();
    private static final int FINEST_INTVAL = MLevel.FINEST.intValue();
    private static final int INFO_INTVAL = MLevel.INFO.intValue();
    private static final int OFF_INTVAL = MLevel.OFF.intValue();
    private static final int SEVERE_INTVAL = MLevel.SEVERE.intValue();
    private static final int WARNING_INTVAL = MLevel.WARNING.intValue();
    static final String CHECK_CLASS = "org.slf4j.LoggerFactory";
    static final String DFLT_LOGGER_NAME = "global";

    public Slf4jMLog() throws ClassNotFoundException, MLogInitializationException {
        Class.forName(CHECK_CLASS);
        ILoggerFactory iLoggerFactory = LoggerFactory.getILoggerFactory();
        if (iLoggerFactory == null || iLoggerFactory.getClass().getName() == "org.slf4j.helpers.NOPLoggerFactory") {
            throw new MLogInitializationException("slf4j found no binding or threatened to use its (dangerously silent) NOPLogger. We consider the slf4j library not found.");
        }
    }

    @Override // com.mchange.p009v2.log.MLog
    public MLogger getMLogger(String str) {
        Logger logger = LoggerFactory.getLogger(str);
        if (logger != null) {
            return new Slf4jMLogger(logger);
        }
        fallbackWarn(" with name '" + str + "'");
        return NullMLogger.instance();
    }

    @Override // com.mchange.p009v2.log.MLog
    public MLogger getMLogger() {
        Logger logger = LoggerFactory.getLogger(DFLT_LOGGER_NAME);
        if (logger != null) {
            return new Slf4jMLogger(logger);
        }
        fallbackWarn(" (default, with name 'global')");
        return NullMLogger.instance();
    }

    private void fallbackWarn(String str) {
        FallbackMLog.getLogger().warning("Could not create or find slf4j Logger" + str + ". Using NullMLogger. All messages sent to thislogger will be silently ignored. You might want to fix this.");
    }

    /* renamed from: com.mchange.v2.log.slf4j.Slf4jMLog$Slf4jMLogger */
    /* loaded from: grasscutter.jar:com/mchange/v2/log/slf4j/Slf4jMLog$Slf4jMLogger.class */
    private static final class Slf4jMLogger implements MLogger {
        static final String FQCN = Slf4jMLogger.class.getName();
        final Logger logger;
        MLevel myLevel = null;
        final LevelLogger traceL = new TraceLogger();
        final LevelLogger debugL = new DebugLogger();
        final LevelLogger infoL = new InfoLogger();
        final LevelLogger warnL = new WarnLogger();
        final LevelLogger errorL = new ErrorLogger();
        final LevelLogger offL = new OffLogger();

        /* access modifiers changed from: private */
        /* renamed from: com.mchange.v2.log.slf4j.Slf4jMLog$Slf4jMLogger$LevelLogger */
        /* loaded from: grasscutter.jar:com/mchange/v2/log/slf4j/Slf4jMLog$Slf4jMLogger$LevelLogger.class */
        public interface LevelLogger {
            void log(String str);

            void log(String str, Object obj);

            void log(String str, Object[] objArr);

            void log(String str, Throwable th);
        }

        Slf4jMLogger(Logger logger) {
            this.logger = logger;
        }

        private MLevel guessMLevel() {
            if (this.logger.isTraceEnabled()) {
                return MLevel.FINEST;
            }
            if (this.logger.isDebugEnabled()) {
                return MLevel.FINER;
            }
            if (this.logger.isInfoEnabled()) {
                return MLevel.INFO;
            }
            if (this.logger.isWarnEnabled()) {
                return MLevel.WARNING;
            }
            if (this.logger.isErrorEnabled()) {
                return MLevel.SEVERE;
            }
            return MLevel.OFF;
        }

        private synchronized boolean myLevelMayBeLoggable(int i) {
            return this.myLevel == null || i >= this.myLevel.intValue();
        }

        private LevelLogger levelLogger(MLevel mLevel) {
            LevelLogger levelLogger = this.offL;
            int intValue = mLevel.intValue();
            if (myLevelMayBeLoggable(intValue) && intValue >= Slf4jMLog.FINEST_INTVAL) {
                if (intValue < Slf4jMLog.FINER_INTVAL) {
                    if (this.logger.isTraceEnabled()) {
                        levelLogger = this.traceL;
                    }
                } else if (intValue < Slf4jMLog.INFO_INTVAL) {
                    if (this.logger.isDebugEnabled()) {
                        levelLogger = this.debugL;
                    }
                } else if (intValue < Slf4jMLog.WARNING_INTVAL) {
                    if (this.logger.isInfoEnabled()) {
                        levelLogger = this.infoL;
                    }
                } else if (intValue < Slf4jMLog.SEVERE_INTVAL) {
                    if (this.logger.isWarnEnabled()) {
                        levelLogger = this.warnL;
                    }
                } else if (intValue < Slf4jMLog.OFF_INTVAL && this.logger.isErrorEnabled()) {
                    levelLogger = this.errorL;
                }
            }
            return levelLogger;
        }

        /* renamed from: com.mchange.v2.log.slf4j.Slf4jMLog$Slf4jMLogger$OffLogger */
        /* loaded from: grasscutter.jar:com/mchange/v2/log/slf4j/Slf4jMLog$Slf4jMLogger$OffLogger.class */
        private class OffLogger implements LevelLogger {
            private OffLogger() {
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str) {
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Object obj) {
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Object[] objArr) {
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Throwable th) {
            }
        }

        /* renamed from: com.mchange.v2.log.slf4j.Slf4jMLog$Slf4jMLogger$TraceLogger */
        /* loaded from: grasscutter.jar:com/mchange/v2/log/slf4j/Slf4jMLog$Slf4jMLogger$TraceLogger.class */
        private class TraceLogger implements LevelLogger {
            private TraceLogger() {
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str) {
                Slf4jMLogger.this.logger.trace(str);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Object obj) {
                Slf4jMLogger.this.logger.trace(str, obj);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Object[] objArr) {
                Slf4jMLogger.this.logger.trace(str, objArr);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Throwable th) {
                Slf4jMLogger.this.logger.trace(str, th);
            }
        }

        /* renamed from: com.mchange.v2.log.slf4j.Slf4jMLog$Slf4jMLogger$DebugLogger */
        /* loaded from: grasscutter.jar:com/mchange/v2/log/slf4j/Slf4jMLog$Slf4jMLogger$DebugLogger.class */
        private class DebugLogger implements LevelLogger {
            private DebugLogger() {
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str) {
                Slf4jMLogger.this.logger.debug(str);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Object obj) {
                Slf4jMLogger.this.logger.debug(str, obj);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Object[] objArr) {
                Slf4jMLogger.this.logger.debug(str, objArr);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Throwable th) {
                Slf4jMLogger.this.logger.debug(str, th);
            }
        }

        /* renamed from: com.mchange.v2.log.slf4j.Slf4jMLog$Slf4jMLogger$InfoLogger */
        /* loaded from: grasscutter.jar:com/mchange/v2/log/slf4j/Slf4jMLog$Slf4jMLogger$InfoLogger.class */
        private class InfoLogger implements LevelLogger {
            private InfoLogger() {
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str) {
                Slf4jMLogger.this.logger.info(str);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Object obj) {
                Slf4jMLogger.this.logger.info(str, obj);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Object[] objArr) {
                Slf4jMLogger.this.logger.info(str, objArr);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Throwable th) {
                Slf4jMLogger.this.logger.info(str, th);
            }
        }

        /* renamed from: com.mchange.v2.log.slf4j.Slf4jMLog$Slf4jMLogger$WarnLogger */
        /* loaded from: grasscutter.jar:com/mchange/v2/log/slf4j/Slf4jMLog$Slf4jMLogger$WarnLogger.class */
        private class WarnLogger implements LevelLogger {
            private WarnLogger() {
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str) {
                Slf4jMLogger.this.logger.warn(str);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Object obj) {
                Slf4jMLogger.this.logger.warn(str, obj);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Object[] objArr) {
                Slf4jMLogger.this.logger.warn(str, objArr);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Throwable th) {
                Slf4jMLogger.this.logger.warn(str, th);
            }
        }

        /* renamed from: com.mchange.v2.log.slf4j.Slf4jMLog$Slf4jMLogger$ErrorLogger */
        /* loaded from: grasscutter.jar:com/mchange/v2/log/slf4j/Slf4jMLog$Slf4jMLogger$ErrorLogger.class */
        private class ErrorLogger implements LevelLogger {
            private ErrorLogger() {
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str) {
                Slf4jMLogger.this.logger.error(str);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Object obj) {
                Slf4jMLogger.this.logger.error(str, obj);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Object[] objArr) {
                Slf4jMLogger.this.logger.error(str, objArr);
            }

            @Override // com.mchange.p009v2.log.slf4j.Slf4jMLog.Slf4jMLogger.LevelLogger
            public void log(String str, Throwable th) {
                Slf4jMLogger.this.logger.error(str, th);
            }
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

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str) {
            levelLogger(mLevel).log(str);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str, Object obj) {
            levelLogger(mLevel).log(str, obj);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str, Object[] objArr) {
            levelLogger(mLevel).log(str, objArr);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str, Throwable th) {
            levelLogger(mLevel).log(str, th);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3) {
            levelLogger(mLevel).log(LogUtils.createMessage(str, str2, str3));
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3, Object obj) {
            levelLogger(mLevel).log(LogUtils.createMessage(str, str2, str3 != null ? MessageFormat.format(str3, obj) : null));
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3, Object[] objArr) {
            levelLogger(mLevel).log(LogUtils.createMessage(str, str2, str3 != null ? MessageFormat.format(str3, objArr) : null));
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3, Throwable th) {
            levelLogger(mLevel).log(LogUtils.createMessage(str, str2, str3), th);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4) {
            levelLogger(mLevel).log(LogUtils.createMessage(str, str2, LogUtils.formatMessage(str3, str4, null)));
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Object obj) {
            levelLogger(mLevel).log(LogUtils.createMessage(str, str2, LogUtils.formatMessage(str3, str4, new Object[]{obj})));
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Object[] objArr) {
            levelLogger(mLevel).log(LogUtils.createMessage(str, str2, LogUtils.formatMessage(str3, str4, objArr)));
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Throwable th) {
            levelLogger(mLevel).log(LogUtils.createMessage(str, str2, LogUtils.formatMessage(str3, str4, null)), th);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void entering(String str, String str2) {
            this.traceL.log(LogUtils.createMessage(str, str2, "entering method."));
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void entering(String str, String str2, Object obj) {
            this.traceL.log(LogUtils.createMessage(str, str2, "entering method... param: " + obj.toString()));
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void entering(String str, String str2, Object[] objArr) {
            this.traceL.log(LogUtils.createMessage(str, str2, "entering method... " + LogUtils.createParamsList(objArr)));
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void exiting(String str, String str2) {
            this.traceL.log(LogUtils.createMessage(str, str2, "exiting method."));
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void exiting(String str, String str2, Object obj) {
            this.traceL.log(LogUtils.createMessage(str, str2, "exiting method... result: " + obj.toString()));
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void throwing(String str, String str2, Throwable th) {
            this.traceL.log(LogUtils.createMessage(str, str2, "throwing exception... "), th);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void severe(String str) {
            this.errorL.log(str);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void warning(String str) {
            this.warnL.log(str);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void info(String str) {
            this.infoL.log(str);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void config(String str) {
            this.debugL.log(str);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void fine(String str) {
            this.debugL.log(str);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void finer(String str) {
            this.debugL.log(str);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void finest(String str) {
            this.traceL.log(str);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public synchronized void setLevel(MLevel mLevel) throws SecurityException {
            this.myLevel = mLevel;
        }

        @Override // com.mchange.p009v2.log.MLogger
        public synchronized MLevel getLevel() {
            if (this.myLevel == null) {
                this.myLevel = guessMLevel();
            }
            return this.myLevel;
        }

        @Override // com.mchange.p009v2.log.MLogger
        public boolean isLoggable(MLevel mLevel) {
            return levelLogger(mLevel) != this.offL;
        }

        @Override // com.mchange.p009v2.log.MLogger
        public String getName() {
            return this.logger.getName();
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void addHandler(Object obj) throws SecurityException {
            throw new UnsupportedOperationException("Handlers not supported; the 'handler' " + obj + " is not compatible with MLogger " + this);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void removeHandler(Object obj) throws SecurityException {
            throw new UnsupportedOperationException("Handlers not supported; the 'handler' " + obj + " is not compatible with MLogger " + this);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public Object[] getHandlers() {
            return Slf4jMLog.EMPTY_OBJ_ARRAY;
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void setUseParentHandlers(boolean z) {
            throw new UnsupportedOperationException("Handlers not supported.");
        }

        @Override // com.mchange.p009v2.log.MLogger
        public boolean getUseParentHandlers() {
            throw new UnsupportedOperationException("Handlers not supported.");
        }
    }
}
