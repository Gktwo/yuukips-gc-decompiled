package org.quartz.impl;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.core.JobRunShell;
import org.quartz.core.JobRunShellFactory;
import org.quartz.spi.TriggerFiredBundle;

/* loaded from: grasscutter.jar:org/quartz/impl/StdJobRunShellFactory.class */
public class StdJobRunShellFactory implements JobRunShellFactory {
    private Scheduler scheduler;

    @Override // org.quartz.core.JobRunShellFactory
    public void initialize(Scheduler sched) {
        this.scheduler = sched;
    }

    @Override // org.quartz.core.JobRunShellFactory
    public JobRunShell createJobRunShell(TriggerFiredBundle bndle) throws SchedulerException {
        return new JobRunShell(this.scheduler, bndle);
    }
}
