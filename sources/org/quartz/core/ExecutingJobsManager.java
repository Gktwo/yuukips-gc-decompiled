package org.quartz.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.spi.OperableTrigger;

/* compiled from: QuartzScheduler.java */
/* loaded from: grasscutter.jar:org/quartz/core/ExecutingJobsManager.class */
class ExecutingJobsManager implements JobListener {
    HashMap<String, JobExecutionContext> executingJobs = new HashMap<>();
    AtomicInteger numJobsFired = new AtomicInteger(0);

    @Override // org.quartz.JobListener
    public String getName() {
        return getClass().getName();
    }

    public int getNumJobsCurrentlyExecuting() {
        int size;
        synchronized (this.executingJobs) {
            size = this.executingJobs.size();
        }
        return size;
    }

    @Override // org.quartz.JobListener
    public void jobToBeExecuted(JobExecutionContext context) {
        this.numJobsFired.incrementAndGet();
        synchronized (this.executingJobs) {
            this.executingJobs.put(((OperableTrigger) context.getTrigger()).getFireInstanceId(), context);
        }
    }

    @Override // org.quartz.JobListener
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        synchronized (this.executingJobs) {
            this.executingJobs.remove(((OperableTrigger) context.getTrigger()).getFireInstanceId());
        }
    }

    public int getNumJobsFired() {
        return this.numJobsFired.get();
    }

    public List<JobExecutionContext> getExecutingJobs() {
        List<JobExecutionContext> unmodifiableList;
        synchronized (this.executingJobs) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(this.executingJobs.values()));
        }
        return unmodifiableList;
    }

    @Override // org.quartz.JobListener
    public void jobExecutionVetoed(JobExecutionContext context) {
    }
}
