package com.mchange.p009v2.log;

import com.mchange.p006v1.util.StringTokenizerUtils;
import com.mchange.p009v2.cfg.MultiPropertiesConfig;
import java.util.ArrayList;
import p001ch.qos.logback.classic.net.SyslogAppender;

/* renamed from: com.mchange.v2.log.MLog */
/* loaded from: grasscutter.jar:com/mchange/v2/log/MLog.class */
public abstract class MLog {
    private static NameTransformer _transformer;
    private static MLog _mlog;
    private static MLogger _logger;

    public abstract MLogger getMLogger(String str);

    public abstract MLogger getMLogger();

    static {
        refreshConfig(null, null);
    }

    private static synchronized NameTransformer transformer() {
        return _transformer;
    }

    private static synchronized MLog mlog() {
        return _mlog;
    }

    private static synchronized MLogger logger() {
        return _logger;
    }

    public static synchronized void refreshConfig(MultiPropertiesConfig[] multiPropertiesConfigArr, String str) {
        MLogConfig.refresh(multiPropertiesConfigArr, str);
        String property = MLogConfig.getProperty("com.mchange.v2.log.MLog");
        String[] strArr = null;
        if (property == null) {
            property = MLogConfig.getProperty("com.mchange.v2.log.mlog");
        }
        if (property != null) {
            strArr = StringTokenizerUtils.tokenizeToArray(property, ", \t\r\n");
        }
        boolean z = false;
        FallbackMLog fallbackMLog = null;
        if (strArr != null) {
            fallbackMLog = findByClassnames(strArr, true);
        }
        if (fallbackMLog == null) {
            fallbackMLog = findByClassnames(MLogClasses.SEARCH_CLASSNAMES, false);
        }
        if (fallbackMLog == null) {
            z = true;
            fallbackMLog = new FallbackMLog();
        }
        _mlog = fallbackMLog;
        if (z) {
            info("Using " + _mlog.getClass().getName() + " -- Named logger's not supported, everything goes to System.err.");
        }
        NameTransformer nameTransformer = null;
        String property2 = MLogConfig.getProperty("com.mchange.v2.log.NameTransformer");
        if (property2 == null) {
            property2 = MLogConfig.getProperty("com.mchange.v2.log.nametransformer");
        }
        if (property2 != null) {
            try {
                nameTransformer = (NameTransformer) Class.forName(property2).newInstance();
            } catch (Exception e) {
                System.err.println("Failed to instantiate com.mchange.v2.log.NameTransformer '" + property2 + "'!");
                e.printStackTrace();
            }
        }
        _transformer = nameTransformer;
        MLog mLog = _mlog;
        _logger = getLogger(MLog.class);
        new Thread("MLog-Init-Reporter") { // from class: com.mchange.v2.log.MLog.1
            final MLogger logo = MLog._logger;
            String loggerDesc = MLog._mlog.getClass().getName();

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                if ("com.mchange.v2.log.jdk14logging.Jdk14MLog".equals(this.loggerDesc)) {
                    this.loggerDesc = "java 1.4+ standard";
                } else if ("com.mchange.v2.log.log4j2.Log4j2MLog".equals(this.loggerDesc)) {
                    this.loggerDesc = "log4j2";
                } else if ("com.mchange.v2.log.log4j.Log4jMLog".equals(this.loggerDesc)) {
                    this.loggerDesc = "log4j";
                } else if ("com.mchange.v2.log.slf4j.Slf4jMLog".equals(this.loggerDesc)) {
                    this.loggerDesc = "slf4j";
                }
                if (this.logo.isLoggable(MLevel.INFO)) {
                    this.logo.log(MLevel.INFO, "MLog clients using " + this.loggerDesc + " logging.");
                }
                MLogConfig.logDelayedItems(this.logo);
                if (this.logo.isLoggable(MLevel.FINEST)) {
                    this.logo.log(MLevel.FINEST, "Config available to MLog library: " + MLogConfig.dump());
                }
            }
        }.start();
    }

    public static MLog findByClassnames(String[] strArr, boolean z) {
        ArrayList arrayList = null;
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            try {
                return (MLog) Class.forName(MLogClasses.resolveIfAlias(strArr[i])).newInstance();
            } catch (Exception e) {
                if (e instanceof MLogInitializationException) {
                    System.err.println("MLog initialization issue: " + e.getMessage());
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(strArr[i]);
                if (z) {
                    System.err.println("com.mchange.v2.log.MLog '" + strArr[i] + "' could not be loaded!");
                    e.printStackTrace();
                }
            }
        }
        System.err.println("Tried without success to load the following MLog classes:");
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            System.err.println(SyslogAppender.DEFAULT_STACKTRACE_PATTERN + arrayList.get(i2));
        }
        return null;
    }

    public static MLog instance() {
        return mlog();
    }

    public static MLogger getLogger(String str) {
        NameTransformer transformer;
        MLog instance;
        MLogger mLogger;
        synchronized (MLog.class) {
            transformer = transformer();
            instance = instance();
        }
        if (transformer == null) {
            mLogger = instance().getMLogger(str);
        } else {
            String transformName = transformer.transformName(str);
            if (transformName != null) {
                mLogger = instance.getMLogger(transformName);
            } else {
                mLogger = instance.getMLogger(str);
            }
        }
        return mLogger;
    }

    public static MLogger getLogger(Class cls) {
        NameTransformer transformer;
        MLog instance;
        MLogger mLogger;
        synchronized (MLog.class) {
            transformer = transformer();
            instance = instance();
        }
        if (transformer == null) {
            mLogger = instance.getMLogger(cls);
        } else {
            String transformName = transformer.transformName(cls);
            if (transformName != null) {
                mLogger = instance.getMLogger(transformName);
            } else {
                mLogger = instance.getMLogger(cls);
            }
        }
        return mLogger;
    }

    public static MLogger getLogger() {
        NameTransformer transformer;
        MLog instance;
        MLogger mLogger;
        synchronized (MLog.class) {
            transformer = transformer();
            instance = instance();
        }
        if (transformer == null) {
            mLogger = instance.getMLogger();
        } else {
            String transformName = transformer.transformName();
            if (transformName != null) {
                mLogger = instance.getMLogger(transformName);
            } else {
                mLogger = instance.getMLogger();
            }
        }
        return mLogger;
    }

    public static void log(MLevel mLevel, String str) {
        instance();
        getLogger().log(mLevel, str);
    }

    public static void log(MLevel mLevel, String str, Object obj) {
        instance();
        getLogger().log(mLevel, str, obj);
    }

    public static void log(MLevel mLevel, String str, Object[] objArr) {
        instance();
        getLogger().log(mLevel, str, objArr);
    }

    public static void log(MLevel mLevel, String str, Throwable th) {
        instance();
        getLogger().log(mLevel, str, th);
    }

    public static void logp(MLevel mLevel, String str, String str2, String str3) {
        instance();
        getLogger().logp(mLevel, str, str2, str3);
    }

    public static void logp(MLevel mLevel, String str, String str2, String str3, Object obj) {
        instance();
        getLogger().logp(mLevel, str, str2, str3, obj);
    }

    public static void logp(MLevel mLevel, String str, String str2, String str3, Object[] objArr) {
        instance();
        getLogger().logp(mLevel, str, str2, str3, objArr);
    }

    public static void logp(MLevel mLevel, String str, String str2, String str3, Throwable th) {
        instance();
        getLogger().logp(mLevel, str, str2, str3, th);
    }

    public static void logrb(MLevel mLevel, String str, String str2, String str3, String str4) {
        instance();
        getLogger().logp(mLevel, str, str2, str3, str4);
    }

    public static void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Object obj) {
        instance();
        getLogger().logrb(mLevel, str, str2, str3, str4, obj);
    }

    public static void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Object[] objArr) {
        instance();
        getLogger().logrb(mLevel, str, str2, str3, str4, objArr);
    }

    public static void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Throwable th) {
        instance();
        getLogger().logrb(mLevel, str, str2, str3, str4, th);
    }

    public static void entering(String str, String str2) {
        instance();
        getLogger().entering(str, str2);
    }

    public static void entering(String str, String str2, Object obj) {
        instance();
        getLogger().entering(str, str2, obj);
    }

    public static void entering(String str, String str2, Object[] objArr) {
        instance();
        getLogger().entering(str, str2, objArr);
    }

    public static void exiting(String str, String str2) {
        instance();
        getLogger().exiting(str, str2);
    }

    public static void exiting(String str, String str2, Object obj) {
        instance();
        getLogger().exiting(str, str2, obj);
    }

    public static void throwing(String str, String str2, Throwable th) {
        instance();
        getLogger().throwing(str, str2, th);
    }

    public static void severe(String str) {
        instance();
        getLogger().severe(str);
    }

    public static void warning(String str) {
        instance();
        getLogger().warning(str);
    }

    public static void info(String str) {
        instance();
        getLogger().info(str);
    }

    public static void config(String str) {
        instance();
        getLogger().config(str);
    }

    public static void fine(String str) {
        instance();
        getLogger().fine(str);
    }

    public static void finer(String str) {
        instance();
        getLogger().finer(str);
    }

    public static void finest(String str) {
        instance();
        getLogger().finest(str);
    }

    public MLogger getMLogger(Class cls) {
        return getMLogger(cls.getName());
    }
}
