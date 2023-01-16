package org.quartz;

/* loaded from: grasscutter.jar:org/quartz/Job.class */
public interface Job {
    void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException;
}
