package org.quartz.plugins.history;

import java.text.MessageFormat;
import java.util.Date;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.matchers.EverythingMatcher;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.SchedulerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/plugins/history/LoggingJobHistoryPlugin.class */
public class LoggingJobHistoryPlugin implements SchedulerPlugin, JobListener {
    private String name;
    private String jobToBeFiredMessage = "Job {1}.{0} fired (by trigger {4}.{3}) at: {2, date, HH:mm:ss MM/dd/yyyy}";
    private String jobSuccessMessage = "Job {1}.{0} execution complete at {2, date, HH:mm:ss MM/dd/yyyy} and reports: {8}";
    private String jobFailedMessage = "Job {1}.{0} execution failed at {2, date, HH:mm:ss MM/dd/yyyy} and reports: {8}";
    private String jobWasVetoedMessage = "Job {1}.{0} was vetoed.  It was to be fired (by trigger {4}.{3}) at: {2, date, HH:mm:ss MM/dd/yyyy}";
    private final Logger log = LoggerFactory.getLogger(getClass());

    protected Logger getLog() {
        return this.log;
    }

    public String getJobSuccessMessage() {
        return this.jobSuccessMessage;
    }

    public String getJobFailedMessage() {
        return this.jobFailedMessage;
    }

    public String getJobToBeFiredMessage() {
        return this.jobToBeFiredMessage;
    }

    public void setJobSuccessMessage(String jobSuccessMessage) {
        this.jobSuccessMessage = jobSuccessMessage;
    }

    public void setJobFailedMessage(String jobFailedMessage) {
        this.jobFailedMessage = jobFailedMessage;
    }

    public void setJobToBeFiredMessage(String jobToBeFiredMessage) {
        this.jobToBeFiredMessage = jobToBeFiredMessage;
    }

    public String getJobWasVetoedMessage() {
        return this.jobWasVetoedMessage;
    }

    public void setJobWasVetoedMessage(String jobWasVetoedMessage) {
        this.jobWasVetoedMessage = jobWasVetoedMessage;
    }

    @Override // org.quartz.spi.SchedulerPlugin
    public void initialize(String pname, Scheduler scheduler, ClassLoadHelper classLoadHelper) throws SchedulerException {
        this.name = pname;
        scheduler.getListenerManager().addJobListener(this, EverythingMatcher.allJobs());
    }

    @Override // org.quartz.spi.SchedulerPlugin
    public void start() {
    }

    @Override // org.quartz.spi.SchedulerPlugin
    public void shutdown() {
    }

    @Override // org.quartz.JobListener
    public String getName() {
        return this.name;
    }

    @Override // org.quartz.JobListener
    public void jobToBeExecuted(JobExecutionContext context) {
        if (getLog().isInfoEnabled()) {
            Trigger trigger = context.getTrigger();
            getLog().info(MessageFormat.format(getJobToBeFiredMessage(), context.getJobDetail().getKey().getName(), context.getJobDetail().getKey().getGroup(), new Date(), trigger.getKey().getName(), trigger.getKey().getGroup(), trigger.getPreviousFireTime(), trigger.getNextFireTime(), Integer.valueOf(context.getRefireCount())));
        }
    }

    @Override // org.quartz.JobListener
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        Trigger trigger = context.getTrigger();
        if (jobException != null) {
            if (getLog().isWarnEnabled()) {
                getLog().warn(MessageFormat.format(getJobFailedMessage(), context.getJobDetail().getKey().getName(), context.getJobDetail().getKey().getGroup(), new Date(), trigger.getKey().getName(), trigger.getKey().getGroup(), trigger.getPreviousFireTime(), trigger.getNextFireTime(), Integer.valueOf(context.getRefireCount()), jobException.getMessage()), (Throwable) jobException);
            }
        } else if (getLog().isInfoEnabled()) {
            getLog().info(MessageFormat.format(getJobSuccessMessage(), context.getJobDetail().getKey().getName(), context.getJobDetail().getKey().getGroup(), new Date(), trigger.getKey().getName(), trigger.getKey().getGroup(), trigger.getPreviousFireTime(), trigger.getNextFireTime(), Integer.valueOf(context.getRefireCount()), String.valueOf(context.getResult())));
        }
    }

    @Override // org.quartz.JobListener
    public void jobExecutionVetoed(JobExecutionContext context) {
        if (getLog().isInfoEnabled()) {
            Trigger trigger = context.getTrigger();
            getLog().info(MessageFormat.format(getJobWasVetoedMessage(), context.getJobDetail().getKey().getName(), context.getJobDetail().getKey().getGroup(), new Date(), trigger.getKey().getName(), trigger.getKey().getGroup(), trigger.getPreviousFireTime(), trigger.getNextFireTime(), Integer.valueOf(context.getRefireCount())));
        }
    }
}
