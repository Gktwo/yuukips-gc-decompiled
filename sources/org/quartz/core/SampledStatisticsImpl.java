package org.quartz.core;

import java.util.Timer;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.listeners.SchedulerListenerSupport;
import org.quartz.utils.counter.CounterConfig;
import org.quartz.utils.counter.CounterManager;
import org.quartz.utils.counter.CounterManagerImpl;
import org.quartz.utils.counter.sampled.SampledCounter;
import org.quartz.utils.counter.sampled.SampledCounterConfig;
import org.quartz.utils.counter.sampled.SampledRateCounterConfig;

/* loaded from: grasscutter.jar:org/quartz/core/SampledStatisticsImpl.class */
public class SampledStatisticsImpl extends SchedulerListenerSupport implements SampledStatistics, JobListener, SchedulerListener {
    private final QuartzScheduler scheduler;
    private static final String NAME = "QuartzSampledStatistics";
    private static final int DEFAULT_HISTORY_SIZE = 30;
    private static final int DEFAULT_INTERVAL_SECS = 1;
    private static final SampledCounterConfig DEFAULT_SAMPLED_COUNTER_CONFIG = new SampledCounterConfig(1, 30, true, 0);
    private static final SampledRateCounterConfig DEFAULT_SAMPLED_RATE_COUNTER_CONFIG = new SampledRateCounterConfig(1, 30, true);
    private volatile CounterManager counterManager = new CounterManagerImpl(new Timer("QuartzSampledStatisticsTimer"));
    private final SampledCounter jobsScheduledCount = createSampledCounter(DEFAULT_SAMPLED_COUNTER_CONFIG);
    private final SampledCounter jobsExecutingCount = createSampledCounter(DEFAULT_SAMPLED_COUNTER_CONFIG);
    private final SampledCounter jobsCompletedCount = createSampledCounter(DEFAULT_SAMPLED_COUNTER_CONFIG);

    /* access modifiers changed from: package-private */
    public SampledStatisticsImpl(QuartzScheduler scheduler) {
        this.scheduler = scheduler;
        scheduler.addInternalSchedulerListener(this);
        scheduler.addInternalJobListener(this);
    }

    @Override // org.quartz.core.SampledStatistics
    public void shutdown() {
        this.counterManager.shutdown(true);
    }

    private SampledCounter createSampledCounter(CounterConfig defaultCounterConfig) {
        return (SampledCounter) this.counterManager.createCounter(defaultCounterConfig);
    }

    public void clearStatistics() {
        this.jobsScheduledCount.getAndReset();
        this.jobsExecutingCount.getAndReset();
        this.jobsCompletedCount.getAndReset();
    }

    @Override // org.quartz.core.SampledStatistics
    public long getJobsCompletedMostRecentSample() {
        return this.jobsCompletedCount.getMostRecentSample().getCounterValue();
    }

    @Override // org.quartz.core.SampledStatistics
    public long getJobsExecutingMostRecentSample() {
        return this.jobsExecutingCount.getMostRecentSample().getCounterValue();
    }

    @Override // org.quartz.core.SampledStatistics
    public long getJobsScheduledMostRecentSample() {
        return this.jobsScheduledCount.getMostRecentSample().getCounterValue();
    }

    @Override // org.quartz.JobListener
    public String getName() {
        return NAME;
    }

    @Override // org.quartz.listeners.SchedulerListenerSupport, org.quartz.SchedulerListener
    public void jobScheduled(Trigger trigger) {
        this.jobsScheduledCount.increment();
    }

    @Override // org.quartz.JobListener
    public void jobExecutionVetoed(JobExecutionContext context) {
    }

    @Override // org.quartz.JobListener
    public void jobToBeExecuted(JobExecutionContext context) {
        this.jobsExecutingCount.increment();
    }

    @Override // org.quartz.JobListener
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        this.jobsCompletedCount.increment();
    }

    @Override // org.quartz.listeners.SchedulerListenerSupport, org.quartz.SchedulerListener
    public void jobAdded(JobDetail jobDetail) {
    }

    public void jobDeleted(String jobName, String groupName) {
    }
}
