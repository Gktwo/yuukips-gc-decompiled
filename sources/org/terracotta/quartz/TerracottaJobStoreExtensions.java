package org.terracotta.quartz;

import org.quartz.JobListener;
import org.quartz.spi.JobStore;

/* loaded from: grasscutter.jar:org/terracotta/quartz/TerracottaJobStoreExtensions.class */
public interface TerracottaJobStoreExtensions extends JobStore, JobListener {
    void setMisfireThreshold(long j);

    void setEstimatedTimeToReleaseAndAcquireTrigger(long j);

    void setSynchronousWrite(String str);

    @Override // org.quartz.spi.JobStore
    void setThreadPoolSize(int i);

    String getUUID();

    void setTcRetryInterval(long j);
}
