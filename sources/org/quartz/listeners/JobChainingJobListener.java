package org.quartz.listeners;

import java.util.HashMap;
import java.util.Map;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.SchedulerException;

/* loaded from: grasscutter.jar:org/quartz/listeners/JobChainingJobListener.class */
public class JobChainingJobListener extends JobListenerSupport {
    private String name;
    private Map<JobKey, JobKey> chainLinks;

    public JobChainingJobListener(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Listener name cannot be null!");
        }
        this.name = name;
        this.chainLinks = new HashMap();
    }

    @Override // org.quartz.JobListener
    public String getName() {
        return this.name;
    }

    public void addJobChainLink(JobKey firstJob, JobKey secondJob) {
        if (firstJob == null || secondJob == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        } else if (firstJob.getName() == null || secondJob.getName() == null) {
            throw new IllegalArgumentException("Key cannot have a null name!");
        } else {
            this.chainLinks.put(firstJob, secondJob);
        }
    }

    @Override // org.quartz.listeners.JobListenerSupport, org.quartz.JobListener
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        JobKey sj = this.chainLinks.get(context.getJobDetail().getKey());
        if (sj != null) {
            getLog().info("Job '" + context.getJobDetail().getKey() + "' will now chain to Job '" + sj + "'");
            try {
                context.getScheduler().triggerJob(sj);
            } catch (SchedulerException se) {
                getLog().error("Error encountered during chaining to Job '" + sj + "'", (Throwable) se);
            }
        }
    }
}
