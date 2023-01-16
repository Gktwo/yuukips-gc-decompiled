package org.quartz.core;

import org.quartz.Scheduler;
import org.quartz.SchedulerConfigException;
import org.quartz.SchedulerException;
import org.quartz.spi.TriggerFiredBundle;

/* loaded from: grasscutter.jar:org/quartz/core/JobRunShellFactory.class */
public interface JobRunShellFactory {
    void initialize(Scheduler scheduler) throws SchedulerConfigException;

    JobRunShell createJobRunShell(TriggerFiredBundle triggerFiredBundle) throws SchedulerException;
}
