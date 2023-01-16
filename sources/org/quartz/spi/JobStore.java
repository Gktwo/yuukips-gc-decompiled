package org.quartz.spi;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.quartz.Calendar;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.JobPersistenceException;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.SchedulerConfigException;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;

/* loaded from: grasscutter.jar:org/quartz/spi/JobStore.class */
public interface JobStore {
    void initialize(ClassLoadHelper classLoadHelper, SchedulerSignaler schedulerSignaler) throws SchedulerConfigException;

    void schedulerStarted() throws SchedulerException;

    void schedulerPaused();

    void schedulerResumed();

    void shutdown();

    boolean supportsPersistence();

    long getEstimatedTimeToReleaseAndAcquireTrigger();

    boolean isClustered();

    void storeJobAndTrigger(JobDetail jobDetail, OperableTrigger operableTrigger) throws ObjectAlreadyExistsException, JobPersistenceException;

    void storeJob(JobDetail jobDetail, boolean z) throws ObjectAlreadyExistsException, JobPersistenceException;

    void storeJobsAndTriggers(Map<JobDetail, Set<? extends Trigger>> map, boolean z) throws ObjectAlreadyExistsException, JobPersistenceException;

    boolean removeJob(JobKey jobKey) throws JobPersistenceException;

    boolean removeJobs(List<JobKey> list) throws JobPersistenceException;

    JobDetail retrieveJob(JobKey jobKey) throws JobPersistenceException;

    void storeTrigger(OperableTrigger operableTrigger, boolean z) throws ObjectAlreadyExistsException, JobPersistenceException;

    boolean removeTrigger(TriggerKey triggerKey) throws JobPersistenceException;

    boolean removeTriggers(List<TriggerKey> list) throws JobPersistenceException;

    boolean replaceTrigger(TriggerKey triggerKey, OperableTrigger operableTrigger) throws JobPersistenceException;

    OperableTrigger retrieveTrigger(TriggerKey triggerKey) throws JobPersistenceException;

    boolean checkExists(JobKey jobKey) throws JobPersistenceException;

    boolean checkExists(TriggerKey triggerKey) throws JobPersistenceException;

    void clearAllSchedulingData() throws JobPersistenceException;

    void storeCalendar(String str, Calendar calendar, boolean z, boolean z2) throws ObjectAlreadyExistsException, JobPersistenceException;

    boolean removeCalendar(String str) throws JobPersistenceException;

    Calendar retrieveCalendar(String str) throws JobPersistenceException;

    int getNumberOfJobs() throws JobPersistenceException;

    int getNumberOfTriggers() throws JobPersistenceException;

    int getNumberOfCalendars() throws JobPersistenceException;

    Set<JobKey> getJobKeys(GroupMatcher<JobKey> groupMatcher) throws JobPersistenceException;

    Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> groupMatcher) throws JobPersistenceException;

    List<String> getJobGroupNames() throws JobPersistenceException;

    List<String> getTriggerGroupNames() throws JobPersistenceException;

    List<String> getCalendarNames() throws JobPersistenceException;

    List<OperableTrigger> getTriggersForJob(JobKey jobKey) throws JobPersistenceException;

    Trigger.TriggerState getTriggerState(TriggerKey triggerKey) throws JobPersistenceException;

    void resetTriggerFromErrorState(TriggerKey triggerKey) throws JobPersistenceException;

    void pauseTrigger(TriggerKey triggerKey) throws JobPersistenceException;

    Collection<String> pauseTriggers(GroupMatcher<TriggerKey> groupMatcher) throws JobPersistenceException;

    void pauseJob(JobKey jobKey) throws JobPersistenceException;

    Collection<String> pauseJobs(GroupMatcher<JobKey> groupMatcher) throws JobPersistenceException;

    void resumeTrigger(TriggerKey triggerKey) throws JobPersistenceException;

    Collection<String> resumeTriggers(GroupMatcher<TriggerKey> groupMatcher) throws JobPersistenceException;

    Set<String> getPausedTriggerGroups() throws JobPersistenceException;

    void resumeJob(JobKey jobKey) throws JobPersistenceException;

    Collection<String> resumeJobs(GroupMatcher<JobKey> groupMatcher) throws JobPersistenceException;

    void pauseAll() throws JobPersistenceException;

    void resumeAll() throws JobPersistenceException;

    List<OperableTrigger> acquireNextTriggers(long j, int i, long j2) throws JobPersistenceException;

    void releaseAcquiredTrigger(OperableTrigger operableTrigger);

    List<TriggerFiredResult> triggersFired(List<OperableTrigger> list) throws JobPersistenceException;

    void triggeredJobComplete(OperableTrigger operableTrigger, JobDetail jobDetail, Trigger.CompletedExecutionInstruction completedExecutionInstruction);

    void setInstanceId(String str);

    void setInstanceName(String str);

    void setThreadPoolSize(int i);

    long getAcquireRetryDelay(int i);
}
