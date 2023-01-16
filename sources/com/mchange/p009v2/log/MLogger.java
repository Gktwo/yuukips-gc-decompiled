package com.mchange.p009v2.log;

import java.util.ResourceBundle;

/* renamed from: com.mchange.v2.log.MLogger */
/* loaded from: grasscutter.jar:com/mchange/v2/log/MLogger.class */
public interface MLogger {
    String getName();

    void log(MLevel mLevel, String str);

    void log(MLevel mLevel, String str, Object obj);

    void log(MLevel mLevel, String str, Object[] objArr);

    void log(MLevel mLevel, String str, Throwable th);

    void logp(MLevel mLevel, String str, String str2, String str3);

    void logp(MLevel mLevel, String str, String str2, String str3, Object obj);

    void logp(MLevel mLevel, String str, String str2, String str3, Object[] objArr);

    void logp(MLevel mLevel, String str, String str2, String str3, Throwable th);

    void logrb(MLevel mLevel, String str, String str2, String str3, String str4);

    void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Object obj);

    void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Object[] objArr);

    void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Throwable th);

    void entering(String str, String str2);

    void entering(String str, String str2, Object obj);

    void entering(String str, String str2, Object[] objArr);

    void exiting(String str, String str2);

    void exiting(String str, String str2, Object obj);

    void throwing(String str, String str2, Throwable th);

    void severe(String str);

    void warning(String str);

    void info(String str);

    void config(String str);

    void fine(String str);

    void finer(String str);

    void finest(String str);

    boolean isLoggable(MLevel mLevel);

    ResourceBundle getResourceBundle();

    String getResourceBundleName();

    void setFilter(Object obj) throws SecurityException;

    Object getFilter();

    void setLevel(MLevel mLevel) throws SecurityException;

    MLevel getLevel();

    void addHandler(Object obj) throws SecurityException;

    void removeHandler(Object obj) throws SecurityException;

    Object[] getHandlers();

    void setUseParentHandlers(boolean z);

    boolean getUseParentHandlers();
}
