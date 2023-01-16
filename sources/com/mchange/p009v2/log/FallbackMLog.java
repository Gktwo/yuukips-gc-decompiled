package com.mchange.p009v2.log;

import com.mchange.lang.ThrowableUtils;
import java.text.MessageFormat;
import java.util.ResourceBundle;

/* renamed from: com.mchange.v2.log.FallbackMLog */
/* loaded from: grasscutter.jar:com/mchange/v2/log/FallbackMLog.class */
public final class FallbackMLog extends MLog {
    static final MLevel DEFAULT_CUTOFF_LEVEL;
    static final String SEP;
    MLogger logger = new FallbackMLogger();

    static {
        MLevel mLevel = null;
        String property = MLogConfig.getProperty("com.mchange.v2.log.FallbackMLog.DEFAULT_CUTOFF_LEVEL");
        if (property != null) {
            mLevel = MLevel.fromSeverity(property);
        }
        if (mLevel == null) {
            mLevel = MLevel.INFO;
        }
        DEFAULT_CUTOFF_LEVEL = mLevel;
        SEP = System.getProperty("line.separator");
    }

    @Override // com.mchange.p009v2.log.MLog
    public MLogger getMLogger(String str) {
        return this.logger;
    }

    @Override // com.mchange.p009v2.log.MLog
    public MLogger getMLogger() {
        return this.logger;
    }

    /* renamed from: com.mchange.v2.log.FallbackMLog$FallbackMLogger */
    /* loaded from: grasscutter.jar:com/mchange/v2/log/FallbackMLog$FallbackMLogger.class */
    private static final class FallbackMLogger implements MLogger {
        MLevel cutoffLevel;

        private FallbackMLogger() {
            this.cutoffLevel = FallbackMLog.DEFAULT_CUTOFF_LEVEL;
        }

        private void formatrb(MLevel mLevel, String str, String str2, String str3, String str4, Object[] objArr, Throwable th) {
            String string;
            ResourceBundle bundle = ResourceBundle.getBundle(str3);
            if (!(str4 == null || bundle == null || (string = bundle.getString(str4)) == null)) {
                str4 = string;
            }
            format(mLevel, str, str2, str4, objArr, th);
        }

        private void format(MLevel mLevel, String str, String str2, String str3, Object[] objArr, Throwable th) {
            System.err.println(formatString(mLevel, str, str2, str3, objArr, th));
        }

        private String formatString(MLevel mLevel, String str, String str2, String str3, Object[] objArr, Throwable th) {
            boolean z = str2 != null && !str2.endsWith(")");
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append(mLevel.getLineHeader());
            stringBuffer.append(' ');
            if (str != null && str2 != null) {
                stringBuffer.append('[');
                stringBuffer.append(str);
                stringBuffer.append('.');
                stringBuffer.append(str2);
                if (z) {
                    stringBuffer.append("()");
                }
                stringBuffer.append(']');
            } else if (str != null) {
                stringBuffer.append('[');
                stringBuffer.append(str);
                stringBuffer.append(']');
            } else if (str2 != null) {
                stringBuffer.append('[');
                stringBuffer.append(str2);
                if (z) {
                    stringBuffer.append("()");
                }
                stringBuffer.append(']');
            }
            if (str3 == null) {
                if (objArr != null) {
                    stringBuffer.append("params: ");
                    int length = objArr.length;
                    for (int i = 0; i < length; i++) {
                        if (i != 0) {
                            stringBuffer.append(", ");
                        }
                        stringBuffer.append(objArr[i]);
                    }
                }
            } else if (objArr == null) {
                stringBuffer.append(str3);
            } else {
                stringBuffer.append(new MessageFormat(str3).format(objArr));
            }
            if (th != null) {
                stringBuffer.append(FallbackMLog.SEP);
                stringBuffer.append(ThrowableUtils.extractStackTrace(th));
            }
            return stringBuffer.toString();
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
            warning("Using FallbackMLog -- Filters not supported!");
        }

        @Override // com.mchange.p009v2.log.MLogger
        public Object getFilter() {
            return null;
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str) {
            if (isLoggable(mLevel)) {
                format(mLevel, null, null, str, null, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str, Object obj) {
            if (isLoggable(mLevel)) {
                format(mLevel, null, null, str, new Object[]{obj}, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str, Object[] objArr) {
            if (isLoggable(mLevel)) {
                format(mLevel, null, null, str, objArr, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void log(MLevel mLevel, String str, Throwable th) {
            if (isLoggable(mLevel)) {
                format(mLevel, null, null, str, null, th);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3) {
            if (isLoggable(mLevel)) {
                format(mLevel, str, str2, str3, null, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3, Object obj) {
            if (isLoggable(mLevel)) {
                format(mLevel, str, str2, str3, new Object[]{obj}, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3, Object[] objArr) {
            if (isLoggable(mLevel)) {
                format(mLevel, str, str2, str3, objArr, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logp(MLevel mLevel, String str, String str2, String str3, Throwable th) {
            if (isLoggable(mLevel)) {
                format(mLevel, str, str2, str3, null, th);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4) {
            if (isLoggable(mLevel)) {
                formatrb(mLevel, str, str2, str3, str4, null, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Object obj) {
            if (isLoggable(mLevel)) {
                formatrb(mLevel, str, str2, str3, str4, new Object[]{obj}, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Object[] objArr) {
            if (isLoggable(mLevel)) {
                formatrb(mLevel, str, str2, str3, str4, objArr, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Throwable th) {
            if (isLoggable(mLevel)) {
                formatrb(mLevel, str, str2, str3, str4, null, th);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void entering(String str, String str2) {
            if (isLoggable(MLevel.FINER)) {
                format(MLevel.FINER, str, str2, "Entering method.", null, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void entering(String str, String str2, Object obj) {
            if (isLoggable(MLevel.FINER)) {
                format(MLevel.FINER, str, str2, "Entering method with argument " + obj, null, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void entering(String str, String str2, Object[] objArr) {
            if (!isLoggable(MLevel.FINER)) {
                return;
            }
            if (objArr == null) {
                entering(str, str2);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append("( ");
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append(objArr[i]);
            }
            stringBuffer.append(" )");
            format(MLevel.FINER, str, str2, "Entering method with arguments " + stringBuffer.toString(), null, null);
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void exiting(String str, String str2) {
            if (isLoggable(MLevel.FINER)) {
                format(MLevel.FINER, str, str2, "Exiting method.", null, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void exiting(String str, String str2, Object obj) {
            if (isLoggable(MLevel.FINER)) {
                format(MLevel.FINER, str, str2, "Exiting method with result " + obj, null, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void throwing(String str, String str2, Throwable th) {
            if (isLoggable(MLevel.FINE)) {
                format(MLevel.FINE, str, str2, "Throwing exception.", null, th);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void severe(String str) {
            if (isLoggable(MLevel.SEVERE)) {
                format(MLevel.SEVERE, null, null, str, null, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void warning(String str) {
            if (isLoggable(MLevel.WARNING)) {
                format(MLevel.WARNING, null, null, str, null, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void info(String str) {
            if (isLoggable(MLevel.INFO)) {
                format(MLevel.INFO, null, null, str, null, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void config(String str) {
            if (isLoggable(MLevel.CONFIG)) {
                format(MLevel.CONFIG, null, null, str, null, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void fine(String str) {
            if (isLoggable(MLevel.FINE)) {
                format(MLevel.FINE, null, null, str, null, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void finer(String str) {
            if (isLoggable(MLevel.FINER)) {
                format(MLevel.FINER, null, null, str, null, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void finest(String str) {
            if (isLoggable(MLevel.FINEST)) {
                format(MLevel.FINEST, null, null, str, null, null);
            }
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void setLevel(MLevel mLevel) throws SecurityException {
            this.cutoffLevel = mLevel;
        }

        @Override // com.mchange.p009v2.log.MLogger
        public synchronized MLevel getLevel() {
            return this.cutoffLevel;
        }

        @Override // com.mchange.p009v2.log.MLogger
        public synchronized boolean isLoggable(MLevel mLevel) {
            return mLevel.intValue() >= this.cutoffLevel.intValue();
        }

        @Override // com.mchange.p009v2.log.MLogger
        public String getName() {
            return "global";
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void addHandler(Object obj) throws SecurityException {
            warning("Using FallbackMLog -- Handlers not supported.");
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void removeHandler(Object obj) throws SecurityException {
            warning("Using FallbackMLog -- Handlers not supported.");
        }

        @Override // com.mchange.p009v2.log.MLogger
        public Object[] getHandlers() {
            warning("Using FallbackMLog -- Handlers not supported.");
            return new Object[0];
        }

        @Override // com.mchange.p009v2.log.MLogger
        public void setUseParentHandlers(boolean z) {
            warning("Using FallbackMLog -- Handlers not supported.");
        }

        @Override // com.mchange.p009v2.log.MLogger
        public boolean getUseParentHandlers() {
            return false;
        }
    }
}
