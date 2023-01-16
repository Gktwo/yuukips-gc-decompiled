package org.quartz.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import org.jline.reader.LineReader;
import org.quartz.Calendar;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.ListenerManager;
import org.quartz.Scheduler;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.quartz.SchedulerMetaData;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.UnableToInterruptJobException;
import org.quartz.core.jmx.JobDetailSupport;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.matchers.StringMatcher;
import org.quartz.spi.JobFactory;

/* loaded from: grasscutter.jar:org/quartz/impl/RemoteMBeanScheduler.class */
public abstract class RemoteMBeanScheduler implements Scheduler {
    private ObjectName schedulerObjectName;

    public abstract void initialize() throws SchedulerException;

    protected abstract Object getAttribute(String str) throws SchedulerException;

    protected abstract AttributeList getAttributes(String[] strArr) throws SchedulerException;

    protected abstract Object invoke(String str, Object[] objArr, String[] strArr) throws SchedulerException;

    protected ObjectName getSchedulerObjectName() {
        return this.schedulerObjectName;
    }

    public void setSchedulerObjectName(String schedulerObjectName) throws SchedulerException {
        try {
            this.schedulerObjectName = new ObjectName(schedulerObjectName);
        } catch (MalformedObjectNameException e) {
            throw new SchedulerException("Failed to parse Scheduler MBean name: " + schedulerObjectName, e);
        }
    }

    public void setSchedulerObjectName(ObjectName schedulerObjectName) throws SchedulerException {
        this.schedulerObjectName = schedulerObjectName;
    }

    @Override // org.quartz.Scheduler
    public String getSchedulerName() throws SchedulerException {
        return (String) getAttribute("SchedulerName");
    }

    @Override // org.quartz.Scheduler
    public String getSchedulerInstanceId() throws SchedulerException {
        return (String) getAttribute("SchedulerInstanceId");
    }

    @Override // org.quartz.Scheduler
    public SchedulerMetaData getMetaData() throws SchedulerException {
        AttributeList attributeList = getAttributes(new String[]{"SchedulerName", "SchedulerInstanceId", "StandbyMode", "Shutdown", "JobStoreClassName", "ThreadPoolClassName", "ThreadPoolSize", "Version", "PerformanceMetrics"});
        try {
            return new SchedulerMetaData((String) getAttribute(attributeList, 0).getValue(), (String) getAttribute(attributeList, 1).getValue(), getClass(), true, false, ((Boolean) getAttribute(attributeList, 2).getValue()).booleanValue(), ((Boolean) getAttribute(attributeList, 3).getValue()).booleanValue(), null, Integer.parseInt(((Map) getAttribute(attributeList, 8).getValue()).get("JobsExecuted").toString()), Class.forName((String) getAttribute(attributeList, 4).getValue()), false, false, Class.forName((String) getAttribute(attributeList, 5).getValue()), ((Integer) getAttribute(attributeList, 6).getValue()).intValue(), (String) getAttribute(attributeList, 7).getValue());
        } catch (ClassNotFoundException e) {
            throw new SchedulerException(e);
        }
    }

    private Attribute getAttribute(AttributeList attributeList, int index) {
        return (Attribute) attributeList.get(index);
    }

    @Override // org.quartz.Scheduler
    public SchedulerContext getContext() throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public void start() throws SchedulerException {
        invoke("start", new Object[0], new String[0]);
    }

    @Override // org.quartz.Scheduler
    public void startDelayed(int seconds) throws SchedulerException {
        invoke("startDelayed", new Object[]{Integer.valueOf(seconds)}, new String[]{Integer.TYPE.getName()});
    }

    @Override // org.quartz.Scheduler
    public void standby() throws SchedulerException {
        invoke("standby", new Object[0], new String[0]);
    }

    @Override // org.quartz.Scheduler
    public boolean isStarted() throws SchedulerException {
        return ((Boolean) getAttribute("Started")).booleanValue();
    }

    @Override // org.quartz.Scheduler
    public boolean isInStandbyMode() throws SchedulerException {
        return ((Boolean) getAttribute("StandbyMode")).booleanValue();
    }

    @Override // org.quartz.Scheduler
    public void shutdown() throws SchedulerException {
        String schedulerName = getSchedulerName();
        invoke("shutdown", new Object[0], new String[0]);
        SchedulerRepository.getInstance().remove(schedulerName);
    }

    @Override // org.quartz.Scheduler
    public void shutdown(boolean waitForJobsToComplete) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public boolean isShutdown() throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public List<JobExecutionContext> getCurrentlyExecutingJobs() throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public Date scheduleJob(JobDetail jobDetail, Trigger trigger) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public Date scheduleJob(Trigger trigger) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public void addJob(JobDetail jobDetail, boolean replace) throws SchedulerException {
        invoke("addJob", new Object[]{JobDetailSupport.toCompositeData(jobDetail), Boolean.valueOf(replace)}, new String[]{CompositeData.class.getName(), Boolean.TYPE.getName()});
    }

    @Override // org.quartz.Scheduler
    public void addJob(JobDetail jobDetail, boolean replace, boolean storeNonDurableWhileAwaitingScheduling) throws SchedulerException {
        invoke("addJob", new Object[]{JobDetailSupport.toCompositeData(jobDetail), Boolean.valueOf(replace), Boolean.valueOf(storeNonDurableWhileAwaitingScheduling)}, new String[]{CompositeData.class.getName(), Boolean.TYPE.getName(), Boolean.TYPE.getName()});
    }

    @Override // org.quartz.Scheduler
    public boolean deleteJob(JobKey jobKey) throws SchedulerException {
        return ((Boolean) invoke("deleteJob", new Object[]{jobKey.getName(), jobKey.getGroup()}, new String[]{String.class.getName(), String.class.getName()})).booleanValue();
    }

    @Override // org.quartz.Scheduler
    public boolean unscheduleJob(TriggerKey triggerKey) throws SchedulerException {
        return ((Boolean) invoke("unscheduleJob", new Object[]{triggerKey.getName(), triggerKey.getGroup()}, new String[]{String.class.getName(), String.class.getName()})).booleanValue();
    }

    @Override // org.quartz.Scheduler
    public boolean deleteJobs(List<JobKey> jobKeys) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public void scheduleJobs(Map<JobDetail, Set<? extends Trigger>> triggersAndJobs, boolean replace) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public void scheduleJob(JobDetail jobDetail, Set<? extends Trigger> triggersForJob, boolean replace) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public boolean unscheduleJobs(List<TriggerKey> triggerKeys) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public Date rescheduleJob(TriggerKey triggerKey, Trigger newTrigger) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public void triggerJob(JobKey jobKey) throws SchedulerException {
        triggerJob(jobKey, null);
    }

    @Override // org.quartz.Scheduler
    public void triggerJob(JobKey jobKey, JobDataMap data) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public void pauseTrigger(TriggerKey triggerKey) throws SchedulerException {
        invoke("pauseTrigger", new Object[]{triggerKey.getName(), triggerKey.getGroup()}, new String[]{String.class.getName(), String.class.getName()});
    }

    @Override // org.quartz.Scheduler
    public void pauseTriggers(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        String operation = null;
        switch (matcher.getCompareWithOperator()) {
            case EQUALS:
                operation = "pauseTriggerGroup";
                break;
            case CONTAINS:
                operation = "pauseTriggersContaining";
                break;
            case STARTS_WITH:
                operation = "pauseTriggersStartingWith";
                break;
            case ANYTHING:
                operation = "pauseTriggersAll";
                break;
        }
        if (operation != null) {
            invoke(operation, new Object[]{matcher.getCompareToValue()}, new String[]{String.class.getName()});
            return;
        }
        throw new SchedulerException("Unsupported GroupMatcher kind for pausing triggers: " + matcher.getCompareWithOperator());
    }

    @Override // org.quartz.Scheduler
    public void pauseJob(JobKey jobKey) throws SchedulerException {
        invoke("pauseJob", new Object[]{jobKey.getName(), jobKey.getGroup()}, new String[]{String.class.getName(), String.class.getName()});
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.quartz.Scheduler
    public void pauseJobs(GroupMatcher<JobKey> matcher) throws SchedulerException {
        String operation = null;
        switch (matcher.getCompareWithOperator()) {
            case EQUALS:
                operation = "pauseJobGroup";
                break;
            case CONTAINS:
                operation = "pauseJobsAll";
                break;
            case STARTS_WITH:
                operation = "pauseJobsStartingWith";
                break;
            case ENDS_WITH:
                operation = "pauseJobsEndingWith";
                break;
            case ANYTHING:
                operation = "pauseJobsAll";
                break;
        }
        invoke(operation, new Object[]{matcher.getCompareToValue()}, new String[]{String.class.getName()});
    }

    @Override // org.quartz.Scheduler
    public void resumeTrigger(TriggerKey triggerKey) throws SchedulerException {
        invoke("resumeTrigger", new Object[]{triggerKey.getName(), triggerKey.getGroup()}, new String[]{String.class.getName(), String.class.getName()});
    }

    @Override // org.quartz.Scheduler
    public void resumeTriggers(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        String operation = null;
        switch (matcher.getCompareWithOperator()) {
            case EQUALS:
                operation = "resumeTriggerGroup";
                break;
            case CONTAINS:
                operation = "resumeTriggersContaining";
                break;
            case STARTS_WITH:
                operation = "resumeTriggersStartingWith";
                break;
            case ANYTHING:
                operation = "resumeTriggersAll";
                break;
        }
        if (operation != null) {
            invoke(operation, new Object[]{matcher.getCompareToValue()}, new String[]{String.class.getName()});
            return;
        }
        throw new SchedulerException("Unsupported GroupMatcher kind for resuming triggers: " + matcher.getCompareWithOperator());
    }

    @Override // org.quartz.Scheduler
    public void resumeJob(JobKey jobKey) throws SchedulerException {
        invoke("resumeJob", new Object[]{jobKey.getName(), jobKey.getGroup()}, new String[]{String.class.getName(), String.class.getName()});
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.quartz.Scheduler
    public void resumeJobs(GroupMatcher<JobKey> matcher) throws SchedulerException {
        String operation = null;
        switch (matcher.getCompareWithOperator()) {
            case EQUALS:
                operation = "resumeJobGroup";
                break;
            case CONTAINS:
                operation = "resumeJobsAll";
                break;
            case STARTS_WITH:
                operation = "resumeJobsStartingWith";
                break;
            case ENDS_WITH:
                operation = "resumeJobsEndingWith";
                break;
            case ANYTHING:
                operation = "resumeJobsAll";
                break;
        }
        invoke(operation, new Object[]{matcher.getCompareToValue()}, new String[]{String.class.getName()});
    }

    @Override // org.quartz.Scheduler
    public void pauseAll() throws SchedulerException {
        invoke("pauseAllTriggers", new Object[0], new String[0]);
    }

    @Override // org.quartz.Scheduler
    public void resumeAll() throws SchedulerException {
        invoke("resumeAllTriggers", new Object[0], new String[0]);
    }

    @Override // org.quartz.Scheduler
    public List<String> getJobGroupNames() throws SchedulerException {
        return (List) getAttribute("JobGroupNames");
    }

    @Override // org.quartz.Scheduler
    public Set<JobKey> getJobKeys(GroupMatcher<JobKey> matcher) throws SchedulerException {
        if (matcher.getCompareWithOperator().equals(StringMatcher.StringOperatorName.EQUALS)) {
            return new HashSet((List) invoke("getJobNames", new Object[]{matcher.getCompareToValue()}, new String[]{String.class.getName()}));
        }
        throw new SchedulerException("Only equals matcher are supported for looking up JobKeys");
    }

    @Override // org.quartz.Scheduler
    public List<Trigger> getTriggersOfJob(JobKey jobKey) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public List<String> getTriggerGroupNames() throws SchedulerException {
        return (List) getAttribute("TriggerGroupNames");
    }

    @Override // org.quartz.Scheduler
    public Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public JobDetail getJobDetail(JobKey jobKey) throws SchedulerException {
        try {
            return JobDetailSupport.newJobDetail((CompositeData) invoke("getJobDetail", new Object[]{jobKey.getName(), jobKey.getGroup()}, new String[]{String.class.getName(), String.class.getName()}));
        } catch (ClassNotFoundException e) {
            throw new SchedulerException("Unable to resolve job class", e);
        }
    }

    @Override // org.quartz.Scheduler
    public Trigger getTrigger(TriggerKey triggerKey) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public boolean checkExists(JobKey jobKey) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public boolean checkExists(TriggerKey triggerKey) throws SchedulerException {
        return ((Boolean) invoke("checkExists", new Object[]{triggerKey}, new String[]{TriggerKey.class.getName()})).booleanValue();
    }

    @Override // org.quartz.Scheduler
    public void clear() throws SchedulerException {
        invoke(LineReader.CLEAR, new Object[0], new String[0]);
    }

    @Override // org.quartz.Scheduler
    public Trigger.TriggerState getTriggerState(TriggerKey triggerKey) throws SchedulerException {
        return Trigger.TriggerState.valueOf((String) invoke("getTriggerState", new Object[]{triggerKey.getName(), triggerKey.getGroup()}, new String[]{String.class.getName(), String.class.getName()}));
    }

    @Override // org.quartz.Scheduler
    public void resetTriggerFromErrorState(TriggerKey triggerKey) throws SchedulerException {
        invoke("resetTriggerFromErrorState", new Object[]{triggerKey.getName(), triggerKey.getGroup()}, new String[]{String.class.getName(), String.class.getName()});
    }

    @Override // org.quartz.Scheduler
    public void addCalendar(String calName, Calendar calendar, boolean replace, boolean updateTriggers) throws SchedulerException {
        invoke("addCalendar", new Object[]{calName, calendar, Boolean.valueOf(replace), Boolean.valueOf(updateTriggers)}, new String[]{String.class.getName(), Calendar.class.getName(), Boolean.TYPE.getName(), Boolean.TYPE.getName()});
    }

    @Override // org.quartz.Scheduler
    public boolean deleteCalendar(String calName) throws SchedulerException {
        invoke("deleteCalendar", new Object[]{calName}, new String[]{String.class.getName()});
        return true;
    }

    @Override // org.quartz.Scheduler
    public Calendar getCalendar(String calName) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public List<String> getCalendarNames() throws SchedulerException {
        return (List) getAttribute("CalendarNames");
    }

    @Override // org.quartz.Scheduler
    public Set<String> getPausedTriggerGroups() throws SchedulerException {
        return (Set) getAttribute("PausedTriggerGroups");
    }

    @Override // org.quartz.Scheduler
    public ListenerManager getListenerManager() throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public boolean interrupt(JobKey jobKey) throws UnableToInterruptJobException {
        try {
            return ((Boolean) invoke("interruptJob", new Object[]{jobKey.getName(), jobKey.getGroup()}, new String[]{String.class.getName(), String.class.getName()})).booleanValue();
        } catch (SchedulerException se) {
            throw new UnableToInterruptJobException(se);
        }
    }

    @Override // org.quartz.Scheduler
    public boolean interrupt(String fireInstanceId) throws UnableToInterruptJobException {
        try {
            return ((Boolean) invoke("interruptJob", new Object[]{fireInstanceId}, new String[]{String.class.getName()})).booleanValue();
        } catch (SchedulerException se) {
            throw new UnableToInterruptJobException(se);
        }
    }

    @Override // org.quartz.Scheduler
    public void setJobFactory(JobFactory factory) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }
}
