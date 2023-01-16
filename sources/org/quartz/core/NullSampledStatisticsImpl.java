package org.quartz.core;

/* loaded from: grasscutter.jar:org/quartz/core/NullSampledStatisticsImpl.class */
public class NullSampledStatisticsImpl implements SampledStatistics {
    @Override // org.quartz.core.SampledStatistics
    public long getJobsCompletedMostRecentSample() {
        return 0;
    }

    @Override // org.quartz.core.SampledStatistics
    public long getJobsExecutingMostRecentSample() {
        return 0;
    }

    @Override // org.quartz.core.SampledStatistics
    public long getJobsScheduledMostRecentSample() {
        return 0;
    }

    @Override // org.quartz.core.SampledStatistics
    public void shutdown() {
    }
}
