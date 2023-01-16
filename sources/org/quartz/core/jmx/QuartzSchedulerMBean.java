package org.quartz.core.jmx;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.TabularData;

/* loaded from: grasscutter.jar:org/quartz/core/jmx/QuartzSchedulerMBean.class */
public interface QuartzSchedulerMBean {
    public static final String SCHEDULER_STARTED = "schedulerStarted";
    public static final String SCHEDULER_PAUSED = "schedulerPaused";
    public static final String SCHEDULER_SHUTDOWN = "schedulerShutdown";
    public static final String SCHEDULER_ERROR = "schedulerError";
    public static final String JOB_ADDED = "jobAdded";
    public static final String JOB_DELETED = "jobDeleted";
    public static final String JOB_SCHEDULED = "jobScheduled";
    public static final String JOB_UNSCHEDULED = "jobUnscheduled";
    public static final String JOBS_PAUSED = "jobsPaused";
    public static final String JOBS_RESUMED = "jobsResumed";
    public static final String JOB_EXECUTION_VETOED = "jobExecutionVetoed";
    public static final String JOB_TO_BE_EXECUTED = "jobToBeExecuted";
    public static final String JOB_WAS_EXECUTED = "jobWasExecuted";
    public static final String TRIGGER_FINALIZED = "triggerFinalized";
    public static final String TRIGGERS_PAUSED = "triggersPaused";
    public static final String TRIGGERS_RESUMED = "triggersResumed";
    public static final String SCHEDULING_DATA_CLEARED = "schedulingDataCleared";
    public static final String SAMPLED_STATISTICS_ENABLED = "sampledStatisticsEnabled";
    public static final String SAMPLED_STATISTICS_RESET = "sampledStatisticsReset";

    String getSchedulerName();

    String getSchedulerInstanceId();

    boolean isStandbyMode();

    boolean isShutdown();

    String getVersion();

    String getJobStoreClassName();

    String getThreadPoolClassName();

    int getThreadPoolSize();

    long getJobsScheduledMostRecentSample();

    long getJobsExecutedMostRecentSample();

    long getJobsCompletedMostRecentSample();

    Map<String, Long> getPerformanceMetrics();

    TabularData getCurrentlyExecutingJobs() throws Exception;

    TabularData getAllJobDetails() throws Exception;

    List<CompositeData> getAllTriggers() throws Exception;

    List<String> getJobGroupNames() throws Exception;

    List<String> getJobNames(String str) throws Exception;

    CompositeData getJobDetail(String str, String str2) throws Exception;

    boolean isStarted();

    void start() throws Exception;

    void shutdown();

    void standby();

    void clear() throws Exception;

    Date scheduleJob(String str, String str2, String str3, String str4) throws Exception;

    void scheduleBasicJob(Map<String, Object> map, Map<String, Object> map2) throws Exception;

    void scheduleJob(Map<String, Object> map, Map<String, Object> map2) throws Exception;

    void scheduleJob(String str, String str2, Map<String, Object> map) throws Exception;

    boolean unscheduleJob(String str, String str2) throws Exception;

    boolean interruptJob(String str, String str2) throws Exception;

    boolean interruptJob(String str) throws Exception;

    void triggerJob(String str, String str2, Map<String, String> map) throws Exception;

    boolean deleteJob(String str, String str2) throws Exception;

    void addJob(CompositeData compositeData, boolean z) throws Exception;

    void addJob(Map<String, Object> map, boolean z) throws Exception;

    void pauseJobGroup(String str) throws Exception;

    void pauseJobsStartingWith(String str) throws Exception;

    void pauseJobsEndingWith(String str) throws Exception;

    void pauseJobsContaining(String str) throws Exception;

    void pauseJobsAll() throws Exception;

    void resumeJobGroup(String str) throws Exception;

    void resumeJobsStartingWith(String str) throws Exception;

    void resumeJobsEndingWith(String str) throws Exception;

    void resumeJobsContaining(String str) throws Exception;

    void resumeJobsAll() throws Exception;

    void pauseJob(String str, String str2) throws Exception;

    void resumeJob(String str, String str2) throws Exception;

    List<String> getTriggerGroupNames() throws Exception;

    List<String> getTriggerNames(String str) throws Exception;

    CompositeData getTrigger(String str, String str2) throws Exception;

    String getTriggerState(String str, String str2) throws Exception;

    List<CompositeData> getTriggersOfJob(String str, String str2) throws Exception;

    Set<String> getPausedTriggerGroups() throws Exception;

    void pauseAllTriggers() throws Exception;

    void resumeAllTriggers() throws Exception;

    void pauseTriggerGroup(String str) throws Exception;

    void pauseTriggersStartingWith(String str) throws Exception;

    void pauseTriggersEndingWith(String str) throws Exception;

    void pauseTriggersContaining(String str) throws Exception;

    void pauseTriggersAll() throws Exception;

    void resumeTriggerGroup(String str) throws Exception;

    void resumeTriggersStartingWith(String str) throws Exception;

    void resumeTriggersEndingWith(String str) throws Exception;

    void resumeTriggersContaining(String str) throws Exception;

    void resumeTriggersAll() throws Exception;

    void pauseTrigger(String str, String str2) throws Exception;

    void resumeTrigger(String str, String str2) throws Exception;

    List<String> getCalendarNames() throws Exception;

    void deleteCalendar(String str) throws Exception;

    void setSampledStatisticsEnabled(boolean z);

    boolean isSampledStatisticsEnabled();
}
