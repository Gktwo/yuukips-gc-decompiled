package org.quartz.simpl;

import org.quartz.SchedulerConfigException;
import org.quartz.spi.ThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/simpl/ZeroSizeThreadPool.class */
public class ZeroSizeThreadPool implements ThreadPool {
    private final Logger log = LoggerFactory.getLogger(getClass());

    public Logger getLog() {
        return this.log;
    }

    @Override // org.quartz.spi.ThreadPool
    public int getPoolSize() {
        return 0;
    }

    @Override // org.quartz.spi.ThreadPool
    public void initialize() throws SchedulerConfigException {
    }

    public void shutdown() {
        shutdown(true);
    }

    @Override // org.quartz.spi.ThreadPool
    public void shutdown(boolean waitForJobsToComplete) {
        getLog().debug("shutdown complete");
    }

    @Override // org.quartz.spi.ThreadPool
    public boolean runInThread(Runnable runnable) {
        throw new UnsupportedOperationException("This ThreadPool should not be used on Scheduler instances that are start()ed.");
    }

    @Override // org.quartz.spi.ThreadPool
    public int blockForAvailableThreads() {
        throw new UnsupportedOperationException("This ThreadPool should not be used on Scheduler instances that are start()ed.");
    }

    @Override // org.quartz.spi.ThreadPool
    public void setInstanceId(String schedInstId) {
    }

    @Override // org.quartz.spi.ThreadPool
    public void setInstanceName(String schedName) {
    }
}
