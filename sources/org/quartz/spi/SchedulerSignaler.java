package org.quartz.spi;

import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

/* loaded from: grasscutter.jar:org/quartz/spi/SchedulerSignaler.class */
public interface SchedulerSignaler {
    void notifyTriggerListenersMisfired(Trigger trigger);

    void notifySchedulerListenersFinalized(Trigger trigger);

    void notifySchedulerListenersJobDeleted(JobKey jobKey);

    void signalSchedulingChange(long j);

    void notifySchedulerListenersError(String str, SchedulerException schedulerException);
}
