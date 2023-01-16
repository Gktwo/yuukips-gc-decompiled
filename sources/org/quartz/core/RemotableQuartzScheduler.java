package org.quartz.core;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.quartz.Calendar;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.UnableToInterruptJobException;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.spi.OperableTrigger;

/* loaded from: grasscutter.jar:org/quartz/core/RemotableQuartzScheduler.class */
public interface RemotableQuartzScheduler extends Remote {
    String getSchedulerName() throws RemoteException;

    String getSchedulerInstanceId() throws RemoteException;

    SchedulerContext getSchedulerContext() throws SchedulerException, RemoteException;

    void start() throws SchedulerException, RemoteException;

    void startDelayed(int i) throws SchedulerException, RemoteException;

    void standby() throws RemoteException;

    boolean isInStandbyMode() throws RemoteException;

    void shutdown() throws RemoteException;

    void shutdown(boolean z) throws RemoteException;

    boolean isShutdown() throws RemoteException;

    Date runningSince() throws RemoteException;

    String getVersion() throws RemoteException;

    int numJobsExecuted() throws RemoteException;

    Class<?> getJobStoreClass() throws RemoteException;

    boolean supportsPersistence() throws RemoteException;

    boolean isClustered() throws RemoteException;

    Class<?> getThreadPoolClass() throws RemoteException;

    int getThreadPoolSize() throws RemoteException;

    void clear() throws SchedulerException, RemoteException;

    List<JobExecutionContext> getCurrentlyExecutingJobs() throws SchedulerException, RemoteException;

    Date scheduleJob(JobDetail jobDetail, Trigger trigger) throws SchedulerException, RemoteException;

    Date scheduleJob(Trigger trigger) throws SchedulerException, RemoteException;

    void addJob(JobDetail jobDetail, boolean z) throws SchedulerException, RemoteException;

    void addJob(JobDetail jobDetail, boolean z, boolean z2) throws SchedulerException, RemoteException;

    boolean deleteJob(JobKey jobKey) throws SchedulerException, RemoteException;

    boolean unscheduleJob(TriggerKey triggerKey) throws SchedulerException, RemoteException;

    Date rescheduleJob(TriggerKey triggerKey, Trigger trigger) throws SchedulerException, RemoteException;

    void triggerJob(JobKey jobKey, JobDataMap jobDataMap) throws SchedulerException, RemoteException;

    void triggerJob(OperableTrigger operableTrigger) throws SchedulerException, RemoteException;

    void pauseTrigger(TriggerKey triggerKey) throws SchedulerException, RemoteException;

    void pauseTriggers(GroupMatcher<TriggerKey> groupMatcher) throws SchedulerException, RemoteException;

    void pauseJob(JobKey jobKey) throws SchedulerException, RemoteException;

    void pauseJobs(GroupMatcher<JobKey> groupMatcher) throws SchedulerException, RemoteException;

    void resumeTrigger(TriggerKey triggerKey) throws SchedulerException, RemoteException;

    void resumeTriggers(GroupMatcher<TriggerKey> groupMatcher) throws SchedulerException, RemoteException;

    Set<String> getPausedTriggerGroups() throws SchedulerException, RemoteException;

    void resumeJob(JobKey jobKey) throws SchedulerException, RemoteException;

    void resumeJobs(GroupMatcher<JobKey> groupMatcher) throws SchedulerException, RemoteException;

    void pauseAll() throws SchedulerException, RemoteException;

    void resumeAll() throws SchedulerException, RemoteException;

    List<String> getJobGroupNames() throws SchedulerException, RemoteException;

    Set<JobKey> getJobKeys(GroupMatcher<JobKey> groupMatcher) throws SchedulerException, RemoteException;

    List<? extends Trigger> getTriggersOfJob(JobKey jobKey) throws SchedulerException, RemoteException;

    List<String> getTriggerGroupNames() throws SchedulerException, RemoteException;

    Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> groupMatcher) throws SchedulerException, RemoteException;

    JobDetail getJobDetail(JobKey jobKey) throws SchedulerException, RemoteException;

    Trigger getTrigger(TriggerKey triggerKey) throws SchedulerException, RemoteException;

    Trigger.TriggerState getTriggerState(TriggerKey triggerKey) throws SchedulerException, RemoteException;

    void resetTriggerFromErrorState(TriggerKey triggerKey) throws SchedulerException, RemoteException;

    void addCalendar(String str, Calendar calendar, boolean z, boolean z2) throws SchedulerException, RemoteException;

    boolean deleteCalendar(String str) throws SchedulerException, RemoteException;

    Calendar getCalendar(String str) throws SchedulerException, RemoteException;

    List<String> getCalendarNames() throws SchedulerException, RemoteException;

    boolean interrupt(JobKey jobKey) throws UnableToInterruptJobException, RemoteException;

    boolean interrupt(String str) throws UnableToInterruptJobException, RemoteException;

    boolean checkExists(JobKey jobKey) throws SchedulerException, RemoteException;

    boolean checkExists(TriggerKey triggerKey) throws SchedulerException, RemoteException;

    boolean deleteJobs(List<JobKey> list) throws SchedulerException, RemoteException;

    void scheduleJobs(Map<JobDetail, Set<? extends Trigger>> map, boolean z) throws SchedulerException, RemoteException;

    void scheduleJob(JobDetail jobDetail, Set<? extends Trigger> set, boolean z) throws SchedulerException, RemoteException;

    boolean unscheduleJobs(List<TriggerKey> list) throws SchedulerException, RemoteException;
}
