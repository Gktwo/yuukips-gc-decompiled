package org.quartz.simpl;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/simpl/SimpleJobFactory.class */
public class SimpleJobFactory implements JobFactory {
    private final Logger log = LoggerFactory.getLogger(getClass());

    protected Logger getLog() {
        return this.log;
    }

    @Override // org.quartz.spi.JobFactory
    public Job newJob(TriggerFiredBundle bundle, Scheduler Scheduler) throws SchedulerException {
        JobDetail jobDetail = bundle.getJobDetail();
        Class<? extends Job> jobClass = jobDetail.getJobClass();
        try {
            if (this.log.isDebugEnabled()) {
                this.log.debug("Producing instance of Job '" + jobDetail.getKey() + "', class=" + jobClass.getName());
            }
            return (Job) jobClass.newInstance();
        } catch (Exception e) {
            throw new SchedulerException("Problem instantiating class '" + jobDetail.getJobClass().getName() + "'", e);
        }
    }
}
