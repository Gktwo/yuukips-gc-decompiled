package org.quartz.spi;

import org.quartz.SchedulerConfigException;

/* loaded from: grasscutter.jar:org/quartz/spi/ThreadPool.class */
public interface ThreadPool {
    boolean runInThread(Runnable runnable);

    int blockForAvailableThreads();

    void initialize() throws SchedulerConfigException;

    void shutdown(boolean z);

    int getPoolSize();

    void setInstanceId(String str);

    void setInstanceName(String str);
}
