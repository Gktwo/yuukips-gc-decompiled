package org.terracotta.quartz;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import org.quartz.Calendar;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.JobPersistenceException;
import org.quartz.SchedulerConfigException;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.OperableTrigger;
import org.quartz.spi.SchedulerSignaler;
import org.quartz.spi.TriggerFiredResult;
import org.terracotta.quartz.ClusteredJobStore;
import org.terracotta.toolkit.internal.ToolkitInternal;

/* loaded from: grasscutter.jar:org/terracotta/quartz/PlainTerracottaJobStore.class */
public class PlainTerracottaJobStore<T extends ClusteredJobStore> implements TerracottaJobStoreExtensions {
    private static final long WEEKLY = 604800000;
    private Timer updateCheckTimer;
    private String schedName;
    private String schedInstanceId;
    private long tcRetryInterval;
    private int threadPoolSize;
    protected final ToolkitInternal toolkit;
    private volatile T clusteredJobStore = null;
    private Long misfireThreshold = null;
    private String synchWrite = "false";
    private Long estimatedTimeToReleaseAndAcquireTrigger = null;

    public PlainTerracottaJobStore(ToolkitInternal toolkit) {
        this.toolkit = toolkit;
    }

    @Override // org.terracotta.quartz.TerracottaJobStoreExtensions
    public void setSynchronousWrite(String synchWrite) {
        this.synchWrite = synchWrite;
    }

    @Override // org.terracotta.quartz.TerracottaJobStoreExtensions, org.quartz.spi.JobStore
    public void setThreadPoolSize(int size) {
        this.threadPoolSize = size;
    }

    @Override // org.quartz.spi.JobStore
    public List<OperableTrigger> acquireNextTriggers(long noLaterThan, int maxCount, long timeWindow) throws JobPersistenceException {
        return this.clusteredJobStore.acquireNextTriggers(noLaterThan, maxCount, timeWindow);
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getCalendarNames() throws JobPersistenceException {
        return this.clusteredJobStore.getCalendarNames();
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getJobGroupNames() throws JobPersistenceException {
        return this.clusteredJobStore.getJobGroupNames();
    }

    @Override // org.quartz.spi.JobStore
    public Set<JobKey> getJobKeys(GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        return this.clusteredJobStore.getJobKeys(matcher);
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfCalendars() throws JobPersistenceException {
        return this.clusteredJobStore.getNumberOfCalendars();
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfJobs() throws JobPersistenceException {
        return this.clusteredJobStore.getNumberOfJobs();
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfTriggers() throws JobPersistenceException {
        return this.clusteredJobStore.getNumberOfTriggers();
    }

    @Override // org.quartz.spi.JobStore
    public Set<String> getPausedTriggerGroups() throws JobPersistenceException {
        return this.clusteredJobStore.getPausedTriggerGroups();
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getTriggerGroupNames() throws JobPersistenceException {
        return this.clusteredJobStore.getTriggerGroupNames();
    }

    @Override // org.quartz.spi.JobStore
    public Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        return this.clusteredJobStore.getTriggerKeys(matcher);
    }

    @Override // org.quartz.spi.JobStore
    public List<OperableTrigger> getTriggersForJob(JobKey jobKey) throws JobPersistenceException {
        return this.clusteredJobStore.getTriggersForJob(jobKey);
    }

    @Override // org.quartz.spi.JobStore
    public Trigger.TriggerState getTriggerState(TriggerKey triggerKey) throws JobPersistenceException {
        return this.clusteredJobStore.getTriggerState(triggerKey);
    }

    @Override // org.quartz.spi.JobStore
    public void resetTriggerFromErrorState(TriggerKey triggerKey) throws JobPersistenceException {
        this.clusteredJobStore.resetTriggerFromErrorState(triggerKey);
    }

    @Override // org.quartz.spi.JobStore
    public synchronized void initialize(ClassLoadHelper loadHelper, SchedulerSignaler signaler) throws SchedulerConfigException {
        if (this.clusteredJobStore != null) {
            throw new IllegalStateException("already initialized");
        }
        this.clusteredJobStore = createNewJobStoreInstance(this.schedName, Boolean.valueOf(this.synchWrite).booleanValue());
        this.clusteredJobStore.setThreadPoolSize(this.threadPoolSize);
        if (this.misfireThreshold != null) {
            this.clusteredJobStore.setMisfireThreshold(this.misfireThreshold.longValue());
            this.misfireThreshold = null;
        }
        if (this.estimatedTimeToReleaseAndAcquireTrigger != null) {
            this.clusteredJobStore.setEstimatedTimeToReleaseAndAcquireTrigger(this.estimatedTimeToReleaseAndAcquireTrigger.longValue());
            this.estimatedTimeToReleaseAndAcquireTrigger = null;
        }
        this.clusteredJobStore.setInstanceId(this.schedInstanceId);
        this.clusteredJobStore.setTcRetryInterval(this.tcRetryInterval);
        this.clusteredJobStore.initialize(loadHelper, signaler);
    }

    @Override // org.quartz.spi.JobStore
    public void pauseAll() throws JobPersistenceException {
        this.clusteredJobStore.pauseAll();
    }

    @Override // org.quartz.spi.JobStore
    public void pauseJob(JobKey jobKey) throws JobPersistenceException {
        this.clusteredJobStore.pauseJob(jobKey);
    }

    @Override // org.quartz.spi.JobStore
    public Collection<String> pauseJobs(GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        return this.clusteredJobStore.pauseJobs(matcher);
    }

    @Override // org.quartz.spi.JobStore
    public void pauseTrigger(TriggerKey triggerKey) throws JobPersistenceException {
        this.clusteredJobStore.pauseTrigger(triggerKey);
    }

    @Override // org.quartz.spi.JobStore
    public Collection<String> pauseTriggers(GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        return this.clusteredJobStore.pauseTriggers(matcher);
    }

    @Override // org.quartz.spi.JobStore
    public void releaseAcquiredTrigger(OperableTrigger trigger) {
        this.clusteredJobStore.releaseAcquiredTrigger(trigger);
    }

    @Override // org.quartz.spi.JobStore
    public List<TriggerFiredResult> triggersFired(List<OperableTrigger> triggers) throws JobPersistenceException {
        return this.clusteredJobStore.triggersFired(triggers);
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeCalendar(String calName) throws JobPersistenceException {
        return this.clusteredJobStore.removeCalendar(calName);
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeJob(JobKey jobKey) throws JobPersistenceException {
        return this.clusteredJobStore.removeJob(jobKey);
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeTrigger(TriggerKey triggerKey) throws JobPersistenceException {
        return this.clusteredJobStore.removeTrigger(triggerKey);
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeJobs(List<JobKey> jobKeys) throws JobPersistenceException {
        return this.clusteredJobStore.removeJobs(jobKeys);
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeTriggers(List<TriggerKey> triggerKeys) throws JobPersistenceException {
        return this.clusteredJobStore.removeTriggers(triggerKeys);
    }

    @Override // org.quartz.spi.JobStore
    public void storeJobsAndTriggers(Map<JobDetail, Set<? extends Trigger>> triggersAndJobs, boolean replace) throws JobPersistenceException {
        this.clusteredJobStore.storeJobsAndTriggers(triggersAndJobs, replace);
    }

    @Override // org.quartz.spi.JobStore
    public boolean replaceTrigger(TriggerKey triggerKey, OperableTrigger newTrigger) throws JobPersistenceException {
        return this.clusteredJobStore.replaceTrigger(triggerKey, newTrigger);
    }

    @Override // org.quartz.spi.JobStore
    public void resumeAll() throws JobPersistenceException {
        this.clusteredJobStore.resumeAll();
    }

    @Override // org.quartz.spi.JobStore
    public void resumeJob(JobKey jobKey) throws JobPersistenceException {
        this.clusteredJobStore.resumeJob(jobKey);
    }

    @Override // org.quartz.spi.JobStore
    public Collection<String> resumeJobs(GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        return this.clusteredJobStore.resumeJobs(matcher);
    }

    @Override // org.quartz.spi.JobStore
    public void resumeTrigger(TriggerKey triggerKey) throws JobPersistenceException {
        this.clusteredJobStore.resumeTrigger(triggerKey);
    }

    @Override // org.quartz.spi.JobStore
    public Collection<String> resumeTriggers(GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        return this.clusteredJobStore.resumeTriggers(matcher);
    }

    @Override // org.quartz.spi.JobStore
    public Calendar retrieveCalendar(String calName) throws JobPersistenceException {
        return this.clusteredJobStore.retrieveCalendar(calName);
    }

    @Override // org.quartz.spi.JobStore
    public JobDetail retrieveJob(JobKey jobKey) throws JobPersistenceException {
        return this.clusteredJobStore.retrieveJob(jobKey);
    }

    @Override // org.quartz.spi.JobStore
    public OperableTrigger retrieveTrigger(TriggerKey triggerKey) throws JobPersistenceException {
        return this.clusteredJobStore.retrieveTrigger(triggerKey);
    }

    @Override // org.quartz.spi.JobStore
    public boolean checkExists(JobKey jobKey) throws JobPersistenceException {
        return this.clusteredJobStore.checkExists(jobKey);
    }

    @Override // org.quartz.spi.JobStore
    public boolean checkExists(TriggerKey triggerKey) throws JobPersistenceException {
        return this.clusteredJobStore.checkExists(triggerKey);
    }

    @Override // org.quartz.spi.JobStore
    public void clearAllSchedulingData() throws JobPersistenceException {
        this.clusteredJobStore.clearAllSchedulingData();
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerStarted() throws SchedulerException {
        this.clusteredJobStore.schedulerStarted();
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerPaused() {
        if (this.clusteredJobStore != null) {
            this.clusteredJobStore.schedulerPaused();
        }
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerResumed() {
        this.clusteredJobStore.schedulerResumed();
    }

    @Override // org.quartz.spi.JobStore
    public void shutdown() {
        if (this.clusteredJobStore != null) {
            this.clusteredJobStore.shutdown();
        }
        if (this.updateCheckTimer != null) {
            this.updateCheckTimer.cancel();
        }
    }

    @Override // org.quartz.spi.JobStore
    public void storeCalendar(String name, Calendar calendar, boolean replaceExisting, boolean updateTriggers) throws JobPersistenceException {
        this.clusteredJobStore.storeCalendar(name, calendar, replaceExisting, updateTriggers);
    }

    @Override // org.quartz.spi.JobStore
    public void storeJob(JobDetail newJob, boolean replaceExisting) throws JobPersistenceException {
        this.clusteredJobStore.storeJob(newJob, replaceExisting);
    }

    @Override // org.quartz.spi.JobStore
    public void storeJobAndTrigger(JobDetail newJob, OperableTrigger newTrigger) throws JobPersistenceException {
        this.clusteredJobStore.storeJobAndTrigger(newJob, newTrigger);
    }

    @Override // org.quartz.spi.JobStore
    public void storeTrigger(OperableTrigger newTrigger, boolean replaceExisting) throws JobPersistenceException {
        this.clusteredJobStore.storeTrigger(newTrigger, replaceExisting);
    }

    @Override // org.quartz.spi.JobStore
    public boolean supportsPersistence() {
        return true;
    }

    public String toString() {
        return this.clusteredJobStore.toString();
    }

    @Override // org.quartz.spi.JobStore
    public void triggeredJobComplete(OperableTrigger trigger, JobDetail jobDetail, Trigger.CompletedExecutionInstruction triggerInstCode) {
        this.clusteredJobStore.triggeredJobComplete(trigger, jobDetail, triggerInstCode);
    }

    @Override // org.terracotta.quartz.TerracottaJobStoreExtensions
    public synchronized void setMisfireThreshold(long threshold) {
        ClusteredJobStore cjs = this.clusteredJobStore;
        if (cjs != null) {
            cjs.setMisfireThreshold(threshold);
        } else {
            this.misfireThreshold = Long.valueOf(threshold);
        }
    }

    @Override // org.terracotta.quartz.TerracottaJobStoreExtensions
    public synchronized void setEstimatedTimeToReleaseAndAcquireTrigger(long estimate) {
        ClusteredJobStore cjs = this.clusteredJobStore;
        if (cjs != null) {
            cjs.setEstimatedTimeToReleaseAndAcquireTrigger(estimate);
        } else {
            this.estimatedTimeToReleaseAndAcquireTrigger = Long.valueOf(estimate);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void setInstanceId(String schedInstId) {
        this.schedInstanceId = schedInstId;
    }

    @Override // org.quartz.spi.JobStore
    public void setInstanceName(String schedName) {
        this.schedName = schedName;
    }

    @Override // org.terracotta.quartz.TerracottaJobStoreExtensions
    public void setTcRetryInterval(long retryInterval) {
        this.tcRetryInterval = retryInterval;
    }

    @Override // org.quartz.spi.JobStore
    public long getAcquireRetryDelay(int failureCount) {
        return this.tcRetryInterval;
    }

    @Override // org.terracotta.quartz.TerracottaJobStoreExtensions
    public String getUUID() {
        return this.toolkit.getClientUUID();
    }

    protected T createNewJobStoreInstance(String schedulerName, boolean useSynchWrite) {
        return new DefaultClusteredJobStore(useSynchWrite, this.toolkit, schedulerName);
    }

    @Override // org.quartz.spi.JobStore
    public long getEstimatedTimeToReleaseAndAcquireTrigger() {
        return this.clusteredJobStore.getEstimatedTimeToReleaseAndAcquireTrigger();
    }

    @Override // org.quartz.spi.JobStore
    public boolean isClustered() {
        return true;
    }

    protected T getClusteredJobStore() {
        return this.clusteredJobStore;
    }

    @Override // org.quartz.JobListener
    public String getName() {
        return getClass().getName();
    }

    @Override // org.quartz.JobListener
    public void jobToBeExecuted(JobExecutionContext context) {
    }

    @Override // org.quartz.JobListener
    public void jobExecutionVetoed(JobExecutionContext context) {
    }

    @Override // org.quartz.JobListener
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
    }
}
