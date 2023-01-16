package org.quartz;

/* loaded from: grasscutter.jar:org/quartz/JobListener.class */
public interface JobListener {
    String getName();

    void jobToBeExecuted(JobExecutionContext jobExecutionContext);

    void jobExecutionVetoed(JobExecutionContext jobExecutionContext);

    void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException jobExecutionException);
}
