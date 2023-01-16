package org.quartz.spi;

import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

/* loaded from: grasscutter.jar:org/quartz/spi/JobFactory.class */
public interface JobFactory {
    Job newJob(TriggerFiredBundle triggerFiredBundle, Scheduler scheduler) throws SchedulerException;
}
