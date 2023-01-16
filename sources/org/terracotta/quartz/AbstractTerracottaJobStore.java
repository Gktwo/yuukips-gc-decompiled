package org.terracotta.quartz;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
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
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.JobStore;
import org.quartz.spi.OperableTrigger;
import org.quartz.spi.SchedulerSignaler;
import org.quartz.spi.TriggerFiredResult;
import org.terracotta.toolkit.internal.ToolkitInternal;
import org.terracotta.toolkit.rejoin.RejoinException;

/* loaded from: grasscutter.jar:org/terracotta/quartz/AbstractTerracottaJobStore.class */
public abstract class AbstractTerracottaJobStore implements JobStore {
    public static final String TC_CONFIG_PROP = "org.quartz.jobStore.tcConfig";
    public static final String TC_CONFIGURL_PROP = "org.quartz.jobStore.tcConfigUrl";
    public static final String TC_REJOIN_PROP = "org.quartz.jobStore.rejoin";
    private volatile ToolkitInternal toolkit;
    private volatile TerracottaJobStoreExtensions realJobStore;
    private String tcConfig = null;
    private String tcConfigUrl = null;
    private String schedInstId = null;
    private String schedName = null;
    private Long misFireThreshold = null;
    private String synchWrite = null;
    private String rejoin = null;
    private Long estimatedTimeToReleaseAndAcquireTrigger = null;
    private long tcRetryInterval = TimeUnit.SECONDS.toMillis(15);

    abstract TerracottaJobStoreExtensions getRealStore(ToolkitInternal toolkitInternal);

    private void init() throws SchedulerConfigException {
        if (this.realJobStore == null) {
            if (this.tcConfig != null && this.tcConfigUrl != null) {
                throw new SchedulerConfigException("Both org.quartz.jobStore.tcConfig and org.quartz.jobStore.tcConfigUrl are set in your properties. Please define only one of them");
            } else if (this.tcConfig == null && this.tcConfigUrl == null) {
                throw new SchedulerConfigException("Neither org.quartz.jobStore.tcConfig or org.quartz.jobStore.tcConfigUrl are set in your properties. Please define one of them");
            } else {
                boolean isURLConfig = this.tcConfig == null;
                TerracottaToolkitBuilder toolkitBuilder = new TerracottaToolkitBuilder();
                if (isURLConfig) {
                    toolkitBuilder.setTCConfigUrl(this.tcConfigUrl);
                } else {
                    toolkitBuilder.setTCConfigSnippet(this.tcConfig);
                }
                if (this.rejoin != null) {
                    toolkitBuilder.setRejoin(this.rejoin);
                }
                toolkitBuilder.addTunnelledMBeanDomain("quartz");
                this.toolkit = toolkitBuilder.buildToolkit();
                try {
                    this.realJobStore = getRealStore(this.toolkit);
                } catch (Exception e) {
                    throw new SchedulerConfigException("Unable to create Terracotta client", e);
                }
            }
        }
    }

    public String getUUID() {
        if (this.realJobStore == null) {
            try {
                init();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return this.realJobStore.getUUID();
    }

    public void setMisfireThreshold(long threshold) {
        this.misFireThreshold = Long.valueOf(threshold);
    }

    public void setTcRetryInterval(long tcRetryInterval) {
        this.tcRetryInterval = tcRetryInterval;
    }

    @Override // org.quartz.spi.JobStore
    public List<OperableTrigger> acquireNextTriggers(long noLaterThan, int maxCount, long timeWindow) throws JobPersistenceException {
        try {
            return this.realJobStore.acquireNextTriggers(noLaterThan, maxCount, timeWindow);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Trigger acquisition failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getCalendarNames() throws JobPersistenceException {
        try {
            return this.realJobStore.getCalendarNames();
        } catch (RejoinException e) {
            throw new JobPersistenceException("Calendar name retrieval failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getJobGroupNames() throws JobPersistenceException {
        try {
            return this.realJobStore.getJobGroupNames();
        } catch (RejoinException e) {
            throw new JobPersistenceException("Job name retrieval failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Set<JobKey> getJobKeys(GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        try {
            return this.realJobStore.getJobKeys(matcher);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Job key retrieval failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfCalendars() throws JobPersistenceException {
        try {
            return this.realJobStore.getNumberOfCalendars();
        } catch (RejoinException e) {
            throw new JobPersistenceException("Calendar count retrieval failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfJobs() throws JobPersistenceException {
        try {
            return this.realJobStore.getNumberOfJobs();
        } catch (RejoinException e) {
            throw new JobPersistenceException("Job count retrieval failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfTriggers() throws JobPersistenceException {
        try {
            return this.realJobStore.getNumberOfTriggers();
        } catch (RejoinException e) {
            throw new JobPersistenceException("Trigger count retrieval failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Set<String> getPausedTriggerGroups() throws JobPersistenceException {
        try {
            return this.realJobStore.getPausedTriggerGroups();
        } catch (RejoinException e) {
            throw new JobPersistenceException("Paused trigger group retrieval failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getTriggerGroupNames() throws JobPersistenceException {
        try {
            return this.realJobStore.getTriggerGroupNames();
        } catch (RejoinException e) {
            throw new JobPersistenceException("Trigger group retrieval failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        try {
            return this.realJobStore.getTriggerKeys(matcher);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Trigger key retrieval failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<OperableTrigger> getTriggersForJob(JobKey jobKey) throws JobPersistenceException {
        try {
            return this.realJobStore.getTriggersForJob(jobKey);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Trigger retrieval failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Trigger.TriggerState getTriggerState(TriggerKey triggerKey) throws JobPersistenceException {
        try {
            return this.realJobStore.getTriggerState(triggerKey);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Trigger state retrieval failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void resetTriggerFromErrorState(TriggerKey triggerKey) throws JobPersistenceException {
        try {
            this.realJobStore.resetTriggerFromErrorState(triggerKey);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Trigger state reset failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void initialize(ClassLoadHelper loadHelper, SchedulerSignaler signaler) throws SchedulerConfigException {
        init();
        this.realJobStore.setInstanceId(this.schedInstId);
        this.realJobStore.setInstanceName(this.schedName);
        this.realJobStore.setTcRetryInterval(this.tcRetryInterval);
        if (this.misFireThreshold != null) {
            this.realJobStore.setMisfireThreshold(this.misFireThreshold.longValue());
        }
        if (this.synchWrite != null) {
            this.realJobStore.setSynchronousWrite(this.synchWrite);
        }
        if (this.estimatedTimeToReleaseAndAcquireTrigger != null) {
            this.realJobStore.setEstimatedTimeToReleaseAndAcquireTrigger(this.estimatedTimeToReleaseAndAcquireTrigger.longValue());
        }
        this.realJobStore.initialize(loadHelper, signaler);
    }

    @Override // org.quartz.spi.JobStore
    public void pauseAll() throws JobPersistenceException {
        try {
            this.realJobStore.pauseAll();
        } catch (RejoinException e) {
            throw new JobPersistenceException("Pausing failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void pauseJob(JobKey jobKey) throws JobPersistenceException {
        try {
            this.realJobStore.pauseJob(jobKey);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Pausing job failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Collection<String> pauseJobs(GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        try {
            return this.realJobStore.pauseJobs(matcher);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Pausing jobs failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void pauseTrigger(TriggerKey triggerKey) throws JobPersistenceException {
        try {
            this.realJobStore.pauseTrigger(triggerKey);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Pausing trigger failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Collection<String> pauseTriggers(GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        try {
            return this.realJobStore.pauseTriggers(matcher);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Pausing triggers failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void releaseAcquiredTrigger(OperableTrigger trigger) {
        this.realJobStore.releaseAcquiredTrigger(trigger);
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeCalendar(String calName) throws JobPersistenceException {
        try {
            return this.realJobStore.removeCalendar(calName);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Removing calendar failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeJob(JobKey jobKey) throws JobPersistenceException {
        try {
            return this.realJobStore.removeJob(jobKey);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Removing job failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeTrigger(TriggerKey triggerKey) throws JobPersistenceException {
        try {
            return this.realJobStore.removeTrigger(triggerKey);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Removing trigger failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean replaceTrigger(TriggerKey triggerKey, OperableTrigger newTrigger) throws JobPersistenceException {
        try {
            return this.realJobStore.replaceTrigger(triggerKey, newTrigger);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Replacing trigger failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void resumeAll() throws JobPersistenceException {
        try {
            this.realJobStore.resumeAll();
        } catch (RejoinException e) {
            throw new JobPersistenceException("Resuming failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void resumeJob(JobKey jobKey) throws JobPersistenceException {
        try {
            this.realJobStore.resumeJob(jobKey);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Reusming job failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Collection<String> resumeJobs(GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        try {
            return this.realJobStore.resumeJobs(matcher);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Resuming jobs failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void resumeTrigger(TriggerKey triggerKey) throws JobPersistenceException {
        try {
            this.realJobStore.resumeTrigger(triggerKey);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Resuming trigger failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Collection<String> resumeTriggers(GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        try {
            return this.realJobStore.resumeTriggers(matcher);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Resuming triggers failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Calendar retrieveCalendar(String calName) throws JobPersistenceException {
        try {
            return this.realJobStore.retrieveCalendar(calName);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Calendar retrieval failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public JobDetail retrieveJob(JobKey jobKey) throws JobPersistenceException {
        try {
            return this.realJobStore.retrieveJob(jobKey);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Job retrieval failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public OperableTrigger retrieveTrigger(TriggerKey triggerKey) throws JobPersistenceException {
        try {
            return this.realJobStore.retrieveTrigger(triggerKey);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Trigger retrieval failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerStarted() throws SchedulerException {
        try {
            this.realJobStore.schedulerStarted();
        } catch (RejoinException e) {
            throw new JobPersistenceException("Scheduler start failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerPaused() {
        this.realJobStore.schedulerPaused();
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerResumed() {
        this.realJobStore.schedulerResumed();
    }

    @Override // org.quartz.spi.JobStore
    public void setInstanceId(String schedInstId) {
        this.schedInstId = schedInstId;
    }

    @Override // org.quartz.spi.JobStore
    public void setInstanceName(String schedName) {
        this.schedName = schedName;
    }

    @Override // org.quartz.spi.JobStore
    public void setThreadPoolSize(int poolSize) {
        this.realJobStore.setThreadPoolSize(poolSize);
    }

    @Override // org.quartz.spi.JobStore
    public void shutdown() {
        if (this.realJobStore != null) {
            this.realJobStore.shutdown();
        }
        if (this.toolkit != null) {
            this.toolkit.shutdown();
        }
    }

    @Override // org.quartz.spi.JobStore
    public void storeCalendar(String name, Calendar calendar, boolean replaceExisting, boolean updateTriggers) throws ObjectAlreadyExistsException, JobPersistenceException {
        try {
            this.realJobStore.storeCalendar(name, calendar, replaceExisting, updateTriggers);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Storing calendar failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void storeJob(JobDetail newJob, boolean replaceExisting) throws ObjectAlreadyExistsException, JobPersistenceException {
        try {
            this.realJobStore.storeJob(newJob, replaceExisting);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Storing job failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void storeJobAndTrigger(JobDetail newJob, OperableTrigger newTrigger) throws ObjectAlreadyExistsException, JobPersistenceException {
        try {
            this.realJobStore.storeJobAndTrigger(newJob, newTrigger);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Storing job and trigger failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void storeTrigger(OperableTrigger newTrigger, boolean replaceExisting) throws ObjectAlreadyExistsException, JobPersistenceException {
        try {
            this.realJobStore.storeTrigger(newTrigger, replaceExisting);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Storing trigger failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean supportsPersistence() {
        return true;
    }

    @Override // org.quartz.spi.JobStore
    public void triggeredJobComplete(OperableTrigger trigger, JobDetail jobDetail, Trigger.CompletedExecutionInstruction instruction) {
        this.realJobStore.triggeredJobComplete(trigger, jobDetail, instruction);
    }

    @Override // org.quartz.spi.JobStore
    public List<TriggerFiredResult> triggersFired(List<OperableTrigger> triggers) throws JobPersistenceException {
        try {
            return this.realJobStore.triggersFired(triggers);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Trigger fire marking failed due to client rejoin", e);
        }
    }

    public void setTcConfig(String tcConfig) {
        this.tcConfig = tcConfig.trim();
    }

    public void setTcConfigUrl(String tcConfigUrl) {
        this.tcConfigUrl = tcConfigUrl.trim();
    }

    public void setSynchronousWrite(String synchWrite) {
        this.synchWrite = synchWrite;
    }

    public void setRejoin(String rejoin) {
        this.rejoin = rejoin;
        setSynchronousWrite(Boolean.TRUE.toString());
    }

    @Override // org.quartz.spi.JobStore
    public long getEstimatedTimeToReleaseAndAcquireTrigger() {
        return this.realJobStore.getEstimatedTimeToReleaseAndAcquireTrigger();
    }

    public void setEstimatedTimeToReleaseAndAcquireTrigger(long estimate) {
        this.estimatedTimeToReleaseAndAcquireTrigger = Long.valueOf(estimate);
    }

    @Override // org.quartz.spi.JobStore
    public boolean isClustered() {
        return true;
    }

    @Override // org.quartz.spi.JobStore
    public boolean checkExists(JobKey jobKey) throws JobPersistenceException {
        try {
            return this.realJobStore.checkExists(jobKey);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Job existence check failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean checkExists(TriggerKey triggerKey) throws JobPersistenceException {
        try {
            return this.realJobStore.checkExists(triggerKey);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Trigger existence check failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void clearAllSchedulingData() throws JobPersistenceException {
        try {
            this.realJobStore.clearAllSchedulingData();
        } catch (RejoinException e) {
            throw new JobPersistenceException("Scheduler data clear failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeTriggers(List<TriggerKey> arg0) throws JobPersistenceException {
        try {
            return this.realJobStore.removeTriggers(arg0);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Remvoing triggers failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeJobs(List<JobKey> arg0) throws JobPersistenceException {
        try {
            return this.realJobStore.removeJobs(arg0);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Removing jobs failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void storeJobsAndTriggers(Map<JobDetail, Set<? extends Trigger>> arg0, boolean arg1) throws ObjectAlreadyExistsException, JobPersistenceException {
        try {
            this.realJobStore.storeJobsAndTriggers(arg0, arg1);
        } catch (RejoinException e) {
            throw new JobPersistenceException("Store jobs and triggers failed due to client rejoin", e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public long getAcquireRetryDelay(int failureCount) {
        try {
            return this.realJobStore.getAcquireRetryDelay(failureCount);
        } catch (Exception e) {
            return 20;
        }
    }

    protected TerracottaJobStoreExtensions getRealJobStore() {
        return this.realJobStore;
    }
}
