package org.quartz.core.jmx;

import java.util.ArrayList;
import java.util.List;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;
import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;

/* loaded from: grasscutter.jar:org/quartz/core/jmx/JobExecutionContextSupport.class */
public class JobExecutionContextSupport {
    private static final String COMPOSITE_TYPE_NAME = "JobExecutionContext";
    private static final String COMPOSITE_TYPE_DESCRIPTION = "Job Execution Instance Details";
    private static final CompositeType COMPOSITE_TYPE;
    private static final String TABULAR_TYPE_NAME = "JobExecutionContextArray";
    private static final String TABULAR_TYPE_DESCRIPTION = "Array of composite JobExecutionContext";
    private static final TabularType TABULAR_TYPE;
    private static final String[] ITEM_NAMES = {"schedulerName", "triggerName", "triggerGroup", "jobName", "jobGroup", "jobDataMap", "calendarName", "recovering", "refireCount", "fireTime", "scheduledFireTime", "previousFireTime", "nextFireTime", "jobRunTime", "fireInstanceId"};
    private static final String[] ITEM_DESCRIPTIONS = {"schedulerName", "triggerName", "triggerGroup", "jobName", "jobGroup", "jobDataMap", "calendarName", "recovering", "refireCount", "fireTime", "scheduledFireTime", "previousFireTime", "nextFireTime", "jobRunTime", "fireInstanceId"};
    private static final OpenType[] ITEM_TYPES = {SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, JobDataMapSupport.TABULAR_TYPE, SimpleType.STRING, SimpleType.BOOLEAN, SimpleType.INTEGER, SimpleType.DATE, SimpleType.DATE, SimpleType.DATE, SimpleType.DATE, SimpleType.LONG, SimpleType.STRING};
    private static final String[] INDEX_NAMES = {"schedulerName", "triggerName", "triggerGroup", "jobName", "jobGroup", "fireTime"};

    static {
        try {
            COMPOSITE_TYPE = new CompositeType(COMPOSITE_TYPE_NAME, COMPOSITE_TYPE_DESCRIPTION, ITEM_NAMES, ITEM_DESCRIPTIONS, ITEM_TYPES);
            TABULAR_TYPE = new TabularType(TABULAR_TYPE_NAME, TABULAR_TYPE_DESCRIPTION, COMPOSITE_TYPE, INDEX_NAMES);
        } catch (OpenDataException e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    public static CompositeData toCompositeData(JobExecutionContext jec) throws SchedulerException {
        try {
            return new CompositeDataSupport(COMPOSITE_TYPE, ITEM_NAMES, new Object[]{jec.getScheduler().getSchedulerName(), jec.getTrigger().getKey().getName(), jec.getTrigger().getKey().getGroup(), jec.getJobDetail().getKey().getName(), jec.getJobDetail().getKey().getGroup(), JobDataMapSupport.toTabularData(jec.getMergedJobDataMap()), jec.getTrigger().getCalendarName(), Boolean.valueOf(jec.isRecovering()), Integer.valueOf(jec.getRefireCount()), jec.getFireTime(), jec.getScheduledFireTime(), jec.getPreviousFireTime(), jec.getNextFireTime(), Long.valueOf(jec.getJobRunTime()), jec.getFireInstanceId()});
        } catch (OpenDataException e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    public static TabularData toTabularData(List<JobExecutionContext> executingJobs) throws SchedulerException {
        List<CompositeData> list = new ArrayList<>();
        for (JobExecutionContext executingJob : executingJobs) {
            list.add(toCompositeData(executingJob));
        }
        TabularData td = new TabularDataSupport(TABULAR_TYPE);
        td.putAll((CompositeData[]) list.toArray(new CompositeData[list.size()]));
        return td;
    }
}
