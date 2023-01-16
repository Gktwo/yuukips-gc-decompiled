package org.quartz;

import java.util.Date;

/* loaded from: grasscutter.jar:org/quartz/JobExecutionContext.class */
public interface JobExecutionContext {
    Scheduler getScheduler();

    Trigger getTrigger();

    Calendar getCalendar();

    boolean isRecovering();

    TriggerKey getRecoveringTriggerKey() throws IllegalStateException;

    int getRefireCount();

    JobDataMap getMergedJobDataMap();

    JobDetail getJobDetail();

    Job getJobInstance();

    Date getFireTime();

    Date getScheduledFireTime();

    Date getPreviousFireTime();

    Date getNextFireTime();

    String getFireInstanceId();

    Object getResult();

    void setResult(Object obj);

    long getJobRunTime();

    void put(Object obj, Object obj2);

    Object get(Object obj);
}
