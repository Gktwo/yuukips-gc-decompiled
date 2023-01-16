package org.quartz.p026ee.jta;

import org.quartz.ExecuteInJTATransaction;
import org.quartz.Scheduler;
import org.quartz.SchedulerConfigException;
import org.quartz.SchedulerException;
import org.quartz.core.JobRunShell;
import org.quartz.core.JobRunShellFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.quartz.utils.ClassUtils;

/* renamed from: org.quartz.ee.jta.JTAAnnotationAwareJobRunShellFactory */
/* loaded from: grasscutter.jar:org/quartz/ee/jta/JTAAnnotationAwareJobRunShellFactory.class */
public class JTAAnnotationAwareJobRunShellFactory implements JobRunShellFactory {
    private Scheduler scheduler;

    @Override // org.quartz.core.JobRunShellFactory
    public void initialize(Scheduler sched) throws SchedulerConfigException {
        this.scheduler = sched;
    }

    @Override // org.quartz.core.JobRunShellFactory
    public JobRunShell createJobRunShell(TriggerFiredBundle bundle) throws SchedulerException {
        ExecuteInJTATransaction jtaAnnotation = (ExecuteInJTATransaction) ClassUtils.getAnnotation(bundle.getJobDetail().getJobClass(), ExecuteInJTATransaction.class);
        if (jtaAnnotation == null) {
            return new JobRunShell(this.scheduler, bundle);
        }
        int timeout = jtaAnnotation.timeout();
        if (timeout >= 0) {
            return new JTAJobRunShell(this.scheduler, bundle, timeout);
        }
        return new JTAJobRunShell(this.scheduler, bundle);
    }
}
