package org.quartz.listeners;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/listeners/SchedulerListenerSupport.class */
public abstract class SchedulerListenerSupport implements SchedulerListener {
    private final Logger log = LoggerFactory.getLogger(getClass());

    protected Logger getLog() {
        return this.log;
    }

    @Override // org.quartz.SchedulerListener
    public void jobAdded(JobDetail jobDetail) {
    }

    @Override // org.quartz.SchedulerListener
    public void jobDeleted(JobKey jobKey) {
    }

    @Override // org.quartz.SchedulerListener
    public void jobPaused(JobKey jobKey) {
    }

    @Override // org.quartz.SchedulerListener
    public void jobResumed(JobKey jobKey) {
    }

    @Override // org.quartz.SchedulerListener
    public void jobScheduled(Trigger trigger) {
    }

    @Override // org.quartz.SchedulerListener
    public void jobsPaused(String jobGroup) {
    }

    @Override // org.quartz.SchedulerListener
    public void jobsResumed(String jobGroup) {
    }

    @Override // org.quartz.SchedulerListener
    public void jobUnscheduled(TriggerKey triggerKey) {
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerError(String msg, SchedulerException cause) {
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerInStandbyMode() {
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerShutdown() {
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerShuttingdown() {
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerStarted() {
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerStarting() {
    }

    @Override // org.quartz.SchedulerListener
    public void triggerFinalized(Trigger trigger) {
    }

    @Override // org.quartz.SchedulerListener
    public void triggerPaused(TriggerKey triggerKey) {
    }

    @Override // org.quartz.SchedulerListener
    public void triggerResumed(TriggerKey triggerKey) {
    }

    @Override // org.quartz.SchedulerListener
    public void triggersPaused(String triggerGroup) {
    }

    @Override // org.quartz.SchedulerListener
    public void triggersResumed(String triggerGroup) {
    }

    @Override // org.quartz.SchedulerListener
    public void schedulingDataCleared() {
    }
}
