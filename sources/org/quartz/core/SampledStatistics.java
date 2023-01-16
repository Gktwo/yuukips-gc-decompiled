package org.quartz.core;

/* loaded from: grasscutter.jar:org/quartz/core/SampledStatistics.class */
public interface SampledStatistics {
    long getJobsScheduledMostRecentSample();

    long getJobsExecutingMostRecentSample();

    long getJobsCompletedMostRecentSample();

    void shutdown();
}
