package org.eclipse.jetty.util.log;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/log/Logger.class */
public interface Logger {
    String getName();

    void warn(String str, Object... objArr);

    void warn(Throwable th);

    void warn(String str, Throwable th);

    void info(String str, Object... objArr);

    void info(Throwable th);

    void info(String str, Throwable th);

    boolean isDebugEnabled();

    void setDebugEnabled(boolean z);

    void debug(String str, Object... objArr);

    void debug(String str, long j);

    void debug(Throwable th);

    void debug(String str, Throwable th);

    Logger getLogger(String str);

    void ignore(Throwable th);
}
