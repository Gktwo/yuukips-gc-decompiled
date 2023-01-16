package org.terracotta.quartz;

import org.quartz.spi.JobStore;
import org.terracotta.toolkit.cluster.ClusterListener;

/* loaded from: grasscutter.jar:org/terracotta/quartz/ClusteredJobStore.class */
public interface ClusteredJobStore extends JobStore, ClusterListener {
    void setMisfireThreshold(long j);

    void setEstimatedTimeToReleaseAndAcquireTrigger(long j);

    void setTcRetryInterval(long j);
}
