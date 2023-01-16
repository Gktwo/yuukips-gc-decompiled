package org.quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/* loaded from: grasscutter.jar:org/quartz/jobs/NoOpJob.class */
public class NoOpJob implements Job {
    @Override // org.quartz.Job
    public void execute(JobExecutionContext context) throws JobExecutionException {
    }
}
