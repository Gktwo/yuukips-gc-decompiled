package org.quartz;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.quartz.Trigger;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.spi.JobFactory;

/* loaded from: grasscutter.jar:org/quartz/Scheduler.class */
public interface Scheduler {
    public static final String DEFAULT_GROUP = "DEFAULT";
    public static final String DEFAULT_RECOVERY_GROUP = "RECOVERING_JOBS";
    public static final String DEFAULT_FAIL_OVER_GROUP = "FAILED_OVER_JOBS";
    public static final String FAILED_JOB_ORIGINAL_TRIGGER_NAME = "QRTZ_FAILED_JOB_ORIG_TRIGGER_NAME";
    public static final String FAILED_JOB_ORIGINAL_TRIGGER_GROUP = "QRTZ_FAILED_JOB_ORIG_TRIGGER_GROUP";
    public static final String FAILED_JOB_ORIGINAL_TRIGGER_FIRETIME_IN_MILLISECONDS = "QRTZ_FAILED_JOB_ORIG_TRIGGER_FIRETIME_IN_MILLISECONDS_AS_STRING";
    public static final String FAILED_JOB_ORIGINAL_TRIGGER_SCHEDULED_FIRETIME_IN_MILLISECONDS = "QRTZ_FAILED_JOB_ORIG_TRIGGER_SCHEDULED_FIRETIME_IN_MILLISECONDS_AS_STRING";

    String getSchedulerName() throws SchedulerException;

    String getSchedulerInstanceId() throws SchedulerException;

    SchedulerContext getContext() throws SchedulerException;

    void start() throws SchedulerException;

    void startDelayed(int i) throws SchedulerException;

    boolean isStarted() throws SchedulerException;

    void standby() throws SchedulerException;

    boolean isInStandbyMode() throws SchedulerException;

    void shutdown() throws SchedulerException;

    void shutdown(boolean z) throws SchedulerException;

    boolean isShutdown() throws SchedulerException;

    SchedulerMetaData getMetaData() throws SchedulerException;

    List<JobExecutionContext> getCurrentlyExecutingJobs() throws SchedulerException;

    void setJobFactory(JobFactory jobFactory) throws SchedulerException;

    ListenerManager getListenerManager() throws SchedulerException;

    Date scheduleJob(JobDetail jobDetail, Trigger trigger) throws SchedulerException;

    Date scheduleJob(Trigger trigger) throws SchedulerException;

    void scheduleJobs(Map<JobDetail, Set<? extends Trigger>> map, boolean z) throws SchedulerException;

    void scheduleJob(JobDetail jobDetail, Set<? extends Trigger> set, boolean z) throws SchedulerException;

    boolean unscheduleJob(TriggerKey triggerKey) throws SchedulerException;

    boolean unscheduleJobs(List<TriggerKey> list) throws SchedulerException;

    Date rescheduleJob(TriggerKey triggerKey, Trigger trigger) throws SchedulerException;

    void addJob(JobDetail jobDetail, boolean z) throws SchedulerException;

    void addJob(JobDetail jobDetail, boolean z, boolean z2) throws SchedulerException;

    boolean deleteJob(JobKey jobKey) throws SchedulerException;

    boolean deleteJobs(List<JobKey> list) throws SchedulerException;

    void triggerJob(JobKey jobKey) throws SchedulerException;

    void triggerJob(JobKey jobKey, JobDataMap jobDataMap) throws SchedulerException;

    void pauseJob(JobKey jobKey) throws SchedulerException;

    void pauseJobs(GroupMatcher<JobKey> groupMatcher) throws SchedulerException;

    void pauseTrigger(TriggerKey triggerKey) throws SchedulerException;

    void pauseTriggers(GroupMatcher<TriggerKey> groupMatcher) throws SchedulerException;

    void resumeJob(JobKey jobKey) throws SchedulerException;

    void resumeJobs(GroupMatcher<JobKey> groupMatcher) throws SchedulerException;

    void resumeTrigger(TriggerKey triggerKey) throws SchedulerException;

    void resumeTriggers(GroupMatcher<TriggerKey> groupMatcher) throws SchedulerException;

    void pauseAll() throws SchedulerException;

    void resumeAll() throws SchedulerException;

    List<String> getJobGroupNames() throws SchedulerException;

    Set<JobKey> getJobKeys(GroupMatcher<JobKey> groupMatcher) throws SchedulerException;

    List<? extends Trigger> getTriggersOfJob(JobKey jobKey) throws SchedulerException;

    List<String> getTriggerGroupNames() throws SchedulerException;

    Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> groupMatcher) throws SchedulerException;

    Set<String> getPausedTriggerGroups() throws SchedulerException;

    JobDetail getJobDetail(JobKey jobKey) throws SchedulerException;

    Trigger getTrigger(TriggerKey triggerKey) throws SchedulerException;

    Trigger.TriggerState getTriggerState(TriggerKey triggerKey) throws SchedulerException;

    void resetTriggerFromErrorState(TriggerKey triggerKey) throws SchedulerException;

    void addCalendar(String str, Calendar calendar, boolean z, boolean z2) throws SchedulerException;

    boolean deleteCalendar(String str) throws SchedulerException;

    Calendar getCalendar(String str) throws SchedulerException;

    List<String> getCalendarNames() throws SchedulerException;

    boolean interrupt(JobKey jobKey) throws UnableToInterruptJobException;

    boolean interrupt(String str) throws UnableToInterruptJobException;

    boolean checkExists(JobKey jobKey) throws SchedulerException;

    boolean checkExists(TriggerKey triggerKey) throws SchedulerException;

    void clear() throws SchedulerException;
}
