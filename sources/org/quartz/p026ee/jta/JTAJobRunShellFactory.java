package org.quartz.p026ee.jta;

import org.quartz.Scheduler;
import org.quartz.SchedulerConfigException;
import org.quartz.SchedulerException;
import org.quartz.core.JobRunShell;
import org.quartz.core.JobRunShellFactory;
import org.quartz.spi.TriggerFiredBundle;

/* renamed from: org.quartz.ee.jta.JTAJobRunShellFactory */
/* loaded from: grasscutter.jar:org/quartz/ee/jta/JTAJobRunShellFactory.class */
public class JTAJobRunShellFactory implements JobRunShellFactory {
    private Scheduler scheduler;

    @Override // org.quartz.core.JobRunShellFactory
    public void initialize(Scheduler sched) throws SchedulerConfigException {
        this.scheduler = sched;
    }

    @Override // org.quartz.core.JobRunShellFactory
    public JobRunShell createJobRunShell(TriggerFiredBundle bundle) throws SchedulerException {
        return new JTAJobRunShell(this.scheduler, bundle);
    }
}
