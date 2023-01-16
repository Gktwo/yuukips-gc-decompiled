package org.quartz;

/* loaded from: grasscutter.jar:org/quartz/SchedulerListener.class */
public interface SchedulerListener {
    void jobScheduled(Trigger trigger);

    void jobUnscheduled(TriggerKey triggerKey);

    void triggerFinalized(Trigger trigger);

    void triggerPaused(TriggerKey triggerKey);

    void triggersPaused(String str);

    void triggerResumed(TriggerKey triggerKey);

    void triggersResumed(String str);

    void jobAdded(JobDetail jobDetail);

    void jobDeleted(JobKey jobKey);

    void jobPaused(JobKey jobKey);

    void jobsPaused(String str);

    void jobResumed(JobKey jobKey);

    void jobsResumed(String str);

    void schedulerError(String str, SchedulerException schedulerException);

    void schedulerInStandbyMode();

    void schedulerStarted();

    void schedulerStarting();

    void schedulerShutdown();

    void schedulerShuttingdown();

    void schedulingDataCleared();
}
