package org.quartz.spi;

import java.util.Date;
import org.quartz.Calendar;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

/* loaded from: grasscutter.jar:org/quartz/spi/OperableTrigger.class */
public interface OperableTrigger extends MutableTrigger {
    void triggered(Calendar calendar);

    Date computeFirstFireTime(Calendar calendar);

    Trigger.CompletedExecutionInstruction executionComplete(JobExecutionContext jobExecutionContext, JobExecutionException jobExecutionException);

    void updateAfterMisfire(Calendar calendar);

    void updateWithNewCalendar(Calendar calendar, long j);

    void validate() throws SchedulerException;

    void setFireInstanceId(String str);

    String getFireInstanceId();

    void setNextFireTime(Date date);

    void setPreviousFireTime(Date date);
}
