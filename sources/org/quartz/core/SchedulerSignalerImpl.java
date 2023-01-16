package org.quartz.core;

import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.spi.SchedulerSignaler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/core/SchedulerSignalerImpl.class */
public class SchedulerSignalerImpl implements SchedulerSignaler {
    Logger log = LoggerFactory.getLogger(SchedulerSignalerImpl.class);
    protected QuartzScheduler sched;
    protected QuartzSchedulerThread schedThread;

    public SchedulerSignalerImpl(QuartzScheduler sched, QuartzSchedulerThread schedThread) {
        this.sched = sched;
        this.schedThread = schedThread;
        this.log.info("Initialized Scheduler Signaller of type: " + getClass());
    }

    @Override // org.quartz.spi.SchedulerSignaler
    public void notifyTriggerListenersMisfired(Trigger trigger) {
        try {
            this.sched.notifyTriggerListenersMisfired(trigger);
        } catch (SchedulerException se) {
            this.sched.getLog().error("Error notifying listeners of trigger misfire.", (Throwable) se);
            this.sched.notifySchedulerListenersError("Error notifying listeners of trigger misfire.", se);
        }
    }

    @Override // org.quartz.spi.SchedulerSignaler
    public void notifySchedulerListenersFinalized(Trigger trigger) {
        this.sched.notifySchedulerListenersFinalized(trigger);
    }

    @Override // org.quartz.spi.SchedulerSignaler
    public void signalSchedulingChange(long candidateNewNextFireTime) {
        this.schedThread.signalSchedulingChange(candidateNewNextFireTime);
    }

    @Override // org.quartz.spi.SchedulerSignaler
    public void notifySchedulerListenersJobDeleted(JobKey jobKey) {
        this.sched.notifySchedulerListenersJobDeleted(jobKey);
    }

    @Override // org.quartz.spi.SchedulerSignaler
    public void notifySchedulerListenersError(String string, SchedulerException jpe) {
        this.sched.notifySchedulerListenersError(string, jpe);
    }
}
