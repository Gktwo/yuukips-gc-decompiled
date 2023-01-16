package org.quartz.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import org.quartz.Calendar;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.spi.OperableTrigger;
import org.quartz.spi.TriggerFiredBundle;

/* loaded from: grasscutter.jar:org/quartz/impl/JobExecutionContextImpl.class */
public class JobExecutionContextImpl implements Serializable, JobExecutionContext {
    private static final long serialVersionUID = -8139417614523942021L;
    private transient Scheduler scheduler;
    private Trigger trigger;
    private JobDetail jobDetail;
    private transient Job job;
    private Calendar calendar;
    private boolean recovering;
    private Date fireTime;
    private Date scheduledFireTime;
    private Date prevFireTime;
    private Date nextFireTime;
    private Object result;
    private int numRefires = 0;
    private long jobRunTime = -1;
    private HashMap<Object, Object> data = new HashMap<>();
    private JobDataMap jobDataMap = new JobDataMap();

    public JobExecutionContextImpl(Scheduler scheduler, TriggerFiredBundle firedBundle, Job job) {
        this.recovering = false;
        this.scheduler = scheduler;
        this.trigger = firedBundle.getTrigger();
        this.calendar = firedBundle.getCalendar();
        this.jobDetail = firedBundle.getJobDetail();
        this.job = job;
        this.recovering = firedBundle.isRecovering();
        this.fireTime = firedBundle.getFireTime();
        this.scheduledFireTime = firedBundle.getScheduledFireTime();
        this.prevFireTime = firedBundle.getPrevFireTime();
        this.nextFireTime = firedBundle.getNextFireTime();
        this.jobDataMap.putAll(this.jobDetail.getJobDataMap());
        this.jobDataMap.putAll(this.trigger.getJobDataMap());
    }

    @Override // org.quartz.JobExecutionContext
    public Scheduler getScheduler() {
        return this.scheduler;
    }

    @Override // org.quartz.JobExecutionContext
    public Trigger getTrigger() {
        return this.trigger;
    }

    @Override // org.quartz.JobExecutionContext
    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // org.quartz.JobExecutionContext
    public boolean isRecovering() {
        return this.recovering;
    }

    @Override // org.quartz.JobExecutionContext
    public TriggerKey getRecoveringTriggerKey() {
        if (isRecovering()) {
            return new TriggerKey(this.jobDataMap.getString(Scheduler.FAILED_JOB_ORIGINAL_TRIGGER_NAME), this.jobDataMap.getString(Scheduler.FAILED_JOB_ORIGINAL_TRIGGER_GROUP));
        }
        throw new IllegalStateException("Not a recovering job");
    }

    public void incrementRefireCount() {
        this.numRefires++;
    }

    @Override // org.quartz.JobExecutionContext
    public int getRefireCount() {
        return this.numRefires;
    }

    @Override // org.quartz.JobExecutionContext
    public JobDataMap getMergedJobDataMap() {
        return this.jobDataMap;
    }

    @Override // org.quartz.JobExecutionContext
    public JobDetail getJobDetail() {
        return this.jobDetail;
    }

    @Override // org.quartz.JobExecutionContext
    public Job getJobInstance() {
        return this.job;
    }

    @Override // org.quartz.JobExecutionContext
    public Date getFireTime() {
        return this.fireTime;
    }

    @Override // org.quartz.JobExecutionContext
    public Date getScheduledFireTime() {
        return this.scheduledFireTime;
    }

    @Override // org.quartz.JobExecutionContext
    public Date getPreviousFireTime() {
        return this.prevFireTime;
    }

    @Override // org.quartz.JobExecutionContext
    public Date getNextFireTime() {
        return this.nextFireTime;
    }

    @Override // java.lang.Object
    public String toString() {
        return "JobExecutionContext: trigger: '" + getTrigger().getKey() + " job: " + getJobDetail().getKey() + " fireTime: '" + getFireTime() + " scheduledFireTime: " + getScheduledFireTime() + " previousFireTime: '" + getPreviousFireTime() + " nextFireTime: " + getNextFireTime() + " isRecovering: " + isRecovering() + " refireCount: " + getRefireCount();
    }

    @Override // org.quartz.JobExecutionContext
    public Object getResult() {
        return this.result;
    }

    @Override // org.quartz.JobExecutionContext
    public void setResult(Object result) {
        this.result = result;
    }

    @Override // org.quartz.JobExecutionContext
    public long getJobRunTime() {
        return this.jobRunTime;
    }

    public void setJobRunTime(long jobRunTime) {
        this.jobRunTime = jobRunTime;
    }

    @Override // org.quartz.JobExecutionContext
    public void put(Object key, Object value) {
        this.data.put(key, value);
    }

    @Override // org.quartz.JobExecutionContext
    public Object get(Object key) {
        return this.data.get(key);
    }

    @Override // org.quartz.JobExecutionContext
    public String getFireInstanceId() {
        return ((OperableTrigger) this.trigger).getFireInstanceId();
    }
}
