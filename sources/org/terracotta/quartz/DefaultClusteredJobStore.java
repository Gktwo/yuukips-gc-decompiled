package org.terracotta.quartz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.utility.JavaConstant;
import org.quartz.Calendar;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.JobPersistenceException;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.matchers.StringMatcher;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.OperableTrigger;
import org.quartz.spi.SchedulerSignaler;
import org.quartz.spi.TriggerFiredBundle;
import org.quartz.spi.TriggerFiredResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.terracotta.quartz.collections.TimeTriggerSet;
import org.terracotta.quartz.collections.ToolkitDSHolder;
import org.terracotta.quartz.wrappers.DefaultWrapperFactory;
import org.terracotta.quartz.wrappers.FiredTrigger;
import org.terracotta.quartz.wrappers.JobFacade;
import org.terracotta.quartz.wrappers.JobWrapper;
import org.terracotta.quartz.wrappers.TriggerFacade;
import org.terracotta.quartz.wrappers.TriggerWrapper;
import org.terracotta.quartz.wrappers.WrapperFactory;
import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.atomic.ToolkitTransactionType;
import org.terracotta.toolkit.cluster.ClusterEvent;
import org.terracotta.toolkit.cluster.ClusterInfo;
import org.terracotta.toolkit.cluster.ClusterNode;
import org.terracotta.toolkit.concurrent.locks.ToolkitLock;
import org.terracotta.toolkit.internal.ToolkitInternal;
import org.terracotta.toolkit.internal.concurrent.locks.ToolkitLockTypeInternal;
import org.terracotta.toolkit.rejoin.RejoinException;
import org.terracotta.toolkit.store.ToolkitStore;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/terracotta/quartz/DefaultClusteredJobStore.class */
public class DefaultClusteredJobStore implements ClusteredJobStore {
    private final ToolkitDSHolder toolkitDSHolder;
    private final Toolkit toolkit;
    private final JobFacade jobFacade;
    private final TriggerFacade triggerFacade;
    private final TimeTriggerSet timeTriggers;
    private final ToolkitStore<String, Calendar> calendarsByName;
    private long misfireThreshold;
    private final ToolkitLockTypeInternal lockType;
    private final transient ToolkitLock lock;
    private final ClusterInfo clusterInfo;
    private final WrapperFactory wrapperFactory;
    private long ftrCtr;
    private volatile SchedulerSignaler signaler;
    private final Logger logger;
    private volatile String terracottaClientId;
    private long estimatedTimeToReleaseAndAcquireTrigger;
    private volatile LocalLockState localStateLock;
    private volatile TriggerRemovedFromCandidateFiringListHandler triggerRemovedFromCandidateFiringListHandler;
    private volatile boolean toolkitShutdown;
    private long retryInterval;

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/terracotta/quartz/DefaultClusteredJobStore$TriggerRemovedFromCandidateFiringListHandler.class */
    public interface TriggerRemovedFromCandidateFiringListHandler {
        boolean removeCandidateTrigger(TriggerWrapper triggerWrapper);
    }

    public DefaultClusteredJobStore(boolean synchWrite, Toolkit toolkit, String jobStoreName) {
        this(synchWrite, toolkit, jobStoreName, new ToolkitDSHolder(jobStoreName, toolkit), new DefaultWrapperFactory());
    }

    public DefaultClusteredJobStore(boolean synchWrite, Toolkit toolkit, String jobStoreName, ToolkitDSHolder toolkitDSHolder, WrapperFactory wrapperFactory) {
        this.misfireThreshold = 60000;
        this.estimatedTimeToReleaseAndAcquireTrigger = 15;
        this.toolkit = toolkit;
        this.wrapperFactory = wrapperFactory;
        this.clusterInfo = toolkit.getClusterInfo();
        this.toolkitDSHolder = toolkitDSHolder;
        this.jobFacade = new JobFacade(toolkitDSHolder);
        this.triggerFacade = new TriggerFacade(toolkitDSHolder);
        this.timeTriggers = toolkitDSHolder.getOrCreateTimeTriggerSet();
        this.calendarsByName = toolkitDSHolder.getOrCreateCalendarWrapperMap();
        this.lockType = synchWrite ? ToolkitLockTypeInternal.SYNCHRONOUS_WRITE : ToolkitLockTypeInternal.WRITE;
        this.lock = new TransactionControllingLock((ToolkitInternal) toolkit, toolkitDSHolder.getLock(this.lockType), synchWrite ? ToolkitTransactionType.SYNC : ToolkitTransactionType.NORMAL);
        this.logger = LoggerFactory.getLogger(getClass());
        getLog().info("Synchronous write locking is [" + synchWrite + "]");
    }

    private Logger getLog() {
        return this.logger;
    }

    /* access modifiers changed from: private */
    public void disable() {
        this.toolkitShutdown = true;
        try {
            getLocalLockState().disableLocking();
        } catch (InterruptedException e) {
            getLog().error("failed to disable the job store", (Throwable) e);
        }
    }

    private LocalLockState getLocalLockState() {
        LocalLockState localLockState;
        LocalLockState rv = this.localStateLock;
        if (rv != null) {
            return rv;
        }
        synchronized (DefaultClusteredJobStore.class) {
            if (this.localStateLock == null) {
                this.localStateLock = new LocalLockState(null);
            }
            localLockState = this.localStateLock;
        }
        return localLockState;
    }

    void lock() throws JobPersistenceException {
        getLocalLockState().attemptAcquireBegin();
        try {
            this.lock.lock();
        } catch (RejoinException e) {
            getLocalLockState().release();
            throw e;
        }
    }

    void unlock() {
        try {
            this.lock.unlock();
            getLocalLockState().release();
        } catch (Throwable th) {
            getLocalLockState().release();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public void initialize(ClassLoadHelper loadHelper, SchedulerSignaler schedulerSignaler) {
        this.terracottaClientId = this.clusterInfo.getCurrentNode().getId();
        this.ftrCtr = System.currentTimeMillis();
        this.signaler = schedulerSignaler;
        getLog().info(getClass().getSimpleName() + " initialized.");
        this.toolkit.registerBeforeShutdownHook(new ShutdownHook(this));
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerStarted() throws SchedulerException {
        this.clusterInfo.addClusterListener(this);
        Collection<ClusterNode> nodes = this.clusterInfo.getNodes();
        Set<String> activeClientIDs = new HashSet<>();
        for (ClusterNode node : nodes) {
            if (!activeClientIDs.add(node.getId())) {
                getLog().error("DUPLICATE node ID detected: " + node);
            }
        }
        lock();
        try {
            List<TriggerWrapper> toEval = new ArrayList<>();
            for (TriggerKey triggerKey : this.triggerFacade.allTriggerKeys()) {
                TriggerWrapper tw = this.triggerFacade.get(triggerKey);
                String lastTerracotaClientId = tw.getLastTerracotaClientId();
                if (lastTerracotaClientId != null) {
                    if (!activeClientIDs.contains(lastTerracotaClientId) || tw.getState() == TriggerWrapper.TriggerState.ERROR) {
                        toEval.add(tw);
                    }
                }
            }
            for (TriggerWrapper tw2 : toEval) {
                evalOrphanedTrigger(tw2, true);
            }
            Iterator<FiredTrigger> iter = this.triggerFacade.allFiredTriggers().iterator();
            while (iter.hasNext()) {
                FiredTrigger ft = iter.next();
                if (!activeClientIDs.contains(ft.getClientId())) {
                    getLog().info("Found non-complete fired trigger: " + ft);
                    iter.remove();
                    TriggerWrapper tw3 = this.triggerFacade.get(ft.getTriggerKey());
                    if (tw3 == null) {
                        getLog().error("no trigger found for executing trigger: " + ft.getTriggerKey());
                    } else {
                        scheduleRecoveryIfNeeded(tw3, ft);
                    }
                }
            }
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerPaused() {
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerResumed() {
    }

    private void evalOrphanedTrigger(TriggerWrapper tw, boolean newNode) {
        getLog().info("Evaluating orphaned trigger " + tw);
        JobWrapper jobWrapper = this.jobFacade.get(tw.getJobKey());
        if (jobWrapper == null) {
            getLog().error("No job found for orphaned trigger: " + tw);
            this.jobFacade.removeBlockedJob(tw.getJobKey());
            return;
        }
        if (newNode && tw.getState() == TriggerWrapper.TriggerState.ERROR) {
            tw.setState(TriggerWrapper.TriggerState.WAITING, this.terracottaClientId, this.triggerFacade);
            this.timeTriggers.add(tw);
        }
        if (tw.getState() == TriggerWrapper.TriggerState.BLOCKED) {
            tw.setState(TriggerWrapper.TriggerState.WAITING, this.terracottaClientId, this.triggerFacade);
            this.timeTriggers.add(tw);
        } else if (tw.getState() == TriggerWrapper.TriggerState.PAUSED_BLOCKED) {
            tw.setState(TriggerWrapper.TriggerState.PAUSED, this.terracottaClientId, this.triggerFacade);
        }
        if (tw.getState() == TriggerWrapper.TriggerState.ACQUIRED) {
            tw.setState(TriggerWrapper.TriggerState.WAITING, this.terracottaClientId, this.triggerFacade);
            this.timeTriggers.add(tw);
        }
        if (!tw.mayFireAgain() && !jobWrapper.requestsRecovery()) {
            try {
                removeTrigger(tw.getKey());
            } catch (JobPersistenceException e) {
                getLog().error("Can't remove completed trigger (and related job) " + tw, (Throwable) e);
            }
        }
        if (jobWrapper.isConcurrentExectionDisallowed()) {
            this.jobFacade.removeBlockedJob(jobWrapper.getKey());
            for (TriggerWrapper trigger : this.triggerFacade.getTriggerWrappersForJob(jobWrapper.getKey())) {
                if (trigger.getState() == TriggerWrapper.TriggerState.BLOCKED) {
                    trigger.setState(TriggerWrapper.TriggerState.WAITING, this.terracottaClientId, this.triggerFacade);
                    this.timeTriggers.add(trigger);
                } else if (trigger.getState() == TriggerWrapper.TriggerState.PAUSED_BLOCKED) {
                    trigger.setState(TriggerWrapper.TriggerState.PAUSED, this.terracottaClientId, this.triggerFacade);
                }
            }
        }
    }

    private void scheduleRecoveryIfNeeded(TriggerWrapper tw, FiredTrigger recovering) {
        JobWrapper jobWrapper = this.jobFacade.get(tw.getJobKey());
        if (jobWrapper == null) {
            getLog().error("No job found for orphaned trigger: " + tw);
        } else if (jobWrapper.requestsRecovery()) {
            StringBuilder append = new StringBuilder().append("recover_").append(this.terracottaClientId).append(JavaConstant.Dynamic.DEFAULT_NAME);
            long j = this.ftrCtr;
            this.ftrCtr = j + 1;
            OperableTrigger recoveryTrigger = createRecoveryTrigger(tw, jobWrapper, append.append(j).toString(), recovering);
            JobDataMap jd = tw.getTriggerClone().getJobDataMap();
            jd.put(Scheduler.FAILED_JOB_ORIGINAL_TRIGGER_NAME, tw.getKey().getName());
            jd.put(Scheduler.FAILED_JOB_ORIGINAL_TRIGGER_GROUP, tw.getKey().getGroup());
            jd.put(Scheduler.FAILED_JOB_ORIGINAL_TRIGGER_FIRETIME_IN_MILLISECONDS, String.valueOf(recovering.getFireTime()));
            jd.put(Scheduler.FAILED_JOB_ORIGINAL_TRIGGER_SCHEDULED_FIRETIME_IN_MILLISECONDS, String.valueOf(recovering.getScheduledFireTime()));
            recoveryTrigger.setJobDataMap(jd);
            recoveryTrigger.computeFirstFireTime(null);
            try {
                storeTrigger(recoveryTrigger, false);
                if (!tw.mayFireAgain()) {
                    removeTrigger(tw.getKey());
                }
                getLog().info("Recovered job " + jobWrapper + " for trigger " + tw);
            } catch (JobPersistenceException e) {
                getLog().error("Can't recover job " + jobWrapper + " for trigger " + tw, (Throwable) e);
            }
        }
    }

    protected OperableTrigger createRecoveryTrigger(TriggerWrapper tw, JobWrapper jw, String name, FiredTrigger recovering) {
        SimpleTriggerImpl recoveryTrigger = new SimpleTriggerImpl(name, Scheduler.DEFAULT_RECOVERY_GROUP, new Date(recovering.getScheduledFireTime()));
        recoveryTrigger.setJobName(jw.getKey().getName());
        recoveryTrigger.setJobGroup(jw.getKey().getGroup());
        recoveryTrigger.setMisfireInstruction(-1);
        recoveryTrigger.setPriority(tw.getPriority());
        return recoveryTrigger;
    }

    private long getMisfireThreshold() {
        return this.misfireThreshold;
    }

    @Override // org.terracotta.quartz.ClusteredJobStore
    public void setMisfireThreshold(long misfireThreshold) {
        if (misfireThreshold < 1) {
            throw new IllegalArgumentException("Misfirethreashold must be larger than 0");
        }
        this.misfireThreshold = misfireThreshold;
    }

    @Override // org.quartz.spi.JobStore
    public void shutdown() {
    }

    @Override // org.quartz.spi.JobStore
    public boolean supportsPersistence() {
        throw new AssertionError();
    }

    @Override // org.quartz.spi.JobStore
    public void storeJobAndTrigger(JobDetail newJob, OperableTrigger newTrigger) throws JobPersistenceException {
        lock();
        try {
            storeJob(newJob, false);
            storeTrigger(newTrigger, false);
            unlock();
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public void storeJob(JobDetail newJob, boolean replaceExisting) throws ObjectAlreadyExistsException, JobPersistenceException {
        JobDetail clone = (JobDetail) newJob.clone();
        lock();
        try {
            JobWrapper jw = this.wrapperFactory.createJobWrapper(clone);
            if (!this.jobFacade.containsKey(jw.getKey())) {
                this.toolkitDSHolder.getOrCreateJobsGroupMap(newJob.getKey().getGroup()).add(jw.getKey().getName());
                if (!this.jobFacade.hasGroup(jw.getKey().getGroup())) {
                    this.jobFacade.addGroup(jw.getKey().getGroup());
                }
            } else if (!replaceExisting) {
                throw new ObjectAlreadyExistsException(newJob);
            }
            this.jobFacade.put(jw.getKey(), jw);
            unlock();
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeJob(JobKey jobKey) throws JobPersistenceException {
        boolean found = false;
        lock();
        try {
            for (OperableTrigger trig : getTriggersForJob(jobKey)) {
                removeTrigger(trig.getKey());
                found = true;
            }
            boolean found2 = (this.jobFacade.remove(jobKey) != null) | found;
            if (found2) {
                Set<String> grpSet = this.toolkitDSHolder.getOrCreateJobsGroupMap(jobKey.getGroup());
                grpSet.remove(jobKey.getName());
                if (grpSet.isEmpty()) {
                    this.toolkitDSHolder.removeJobsGroupMap(jobKey.getGroup());
                    this.jobFacade.removeGroup(jobKey.getGroup());
                }
            }
            return found2;
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeJobs(List<JobKey> jobKeys) throws JobPersistenceException {
        boolean allFound = true;
        lock();
        try {
            for (JobKey key : jobKeys) {
                allFound = removeJob(key) && allFound;
            }
            return allFound;
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeTriggers(List<TriggerKey> triggerKeys) throws JobPersistenceException {
        boolean allFound = true;
        lock();
        try {
            for (TriggerKey key : triggerKeys) {
                allFound = removeTrigger(key) && allFound;
            }
            return allFound;
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public void storeJobsAndTriggers(Map<JobDetail, Set<? extends Trigger>> triggersAndJobs, boolean replace) throws ObjectAlreadyExistsException, JobPersistenceException {
        lock();
        if (!replace) {
            try {
                for (JobDetail job : triggersAndJobs.keySet()) {
                    if (checkExists(job.getKey())) {
                        throw new ObjectAlreadyExistsException(job);
                    }
                    for (Trigger trigger : triggersAndJobs.get(job)) {
                        if (checkExists(trigger.getKey())) {
                            throw new ObjectAlreadyExistsException(trigger);
                        }
                    }
                }
            } finally {
                unlock();
            }
        }
        for (JobDetail job2 : triggersAndJobs.keySet()) {
            storeJob(job2, true);
            for (Trigger trigger2 : triggersAndJobs.get(job2)) {
                storeTrigger((OperableTrigger) trigger2, true);
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public void storeTrigger(OperableTrigger newTrigger, boolean replaceExisting) throws JobPersistenceException {
        OperableTrigger clone = (OperableTrigger) newTrigger.clone();
        lock();
        try {
            JobDetail job = retrieveJob(newTrigger.getJobKey());
            if (job == null) {
                throw new JobPersistenceException("The job (" + newTrigger.getJobKey() + ") referenced by the trigger does not exist.");
            }
            TriggerWrapper tw = this.wrapperFactory.createTriggerWrapper(clone, job.isConcurrentExectionDisallowed());
            if (this.triggerFacade.containsKey(tw.getKey())) {
                if (!replaceExisting) {
                    throw new ObjectAlreadyExistsException(newTrigger);
                }
                removeTrigger(newTrigger.getKey(), false);
            }
            this.toolkitDSHolder.getOrCreateTriggersGroupMap(newTrigger.getKey().getGroup()).add(newTrigger.getKey().getName());
            if (!this.triggerFacade.hasGroup(newTrigger.getKey().getGroup())) {
                this.triggerFacade.addGroup(newTrigger.getKey().getGroup());
            }
            if (this.triggerFacade.pausedGroupsContain(newTrigger.getKey().getGroup()) || this.jobFacade.pausedGroupsContain(newTrigger.getJobKey().getGroup())) {
                tw.setState(TriggerWrapper.TriggerState.PAUSED, this.terracottaClientId, this.triggerFacade);
                if (this.jobFacade.blockedJobsContain(tw.getJobKey())) {
                    tw.setState(TriggerWrapper.TriggerState.PAUSED_BLOCKED, this.terracottaClientId, this.triggerFacade);
                }
            } else if (this.jobFacade.blockedJobsContain(tw.getJobKey())) {
                tw.setState(TriggerWrapper.TriggerState.BLOCKED, this.terracottaClientId, this.triggerFacade);
            } else {
                this.timeTriggers.add(tw);
            }
            this.triggerFacade.put(tw.getKey(), tw);
            unlock();
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeTrigger(TriggerKey triggerKey) throws JobPersistenceException {
        return removeTrigger(triggerKey, true);
    }

    private boolean removeTrigger(TriggerKey triggerKey, boolean removeOrphanedJob) throws JobPersistenceException {
        lock();
        try {
            TriggerWrapper tw = this.triggerFacade.remove(triggerKey);
            if (tw != null) {
                Set<String> grpSet = this.toolkitDSHolder.getOrCreateTriggersGroupMap(triggerKey.getGroup());
                grpSet.remove(triggerKey.getName());
                if (grpSet.size() == 0) {
                    this.toolkitDSHolder.removeTriggersGroupMap(triggerKey.getGroup());
                    this.triggerFacade.removeGroup(triggerKey.getGroup());
                }
                this.timeTriggers.remove(tw);
                if (removeOrphanedJob) {
                    JobWrapper jw = this.jobFacade.get(tw.getJobKey());
                    List<OperableTrigger> trigs = getTriggersForJob(tw.getJobKey());
                    if ((trigs == null || trigs.size() == 0) && !jw.isDurable()) {
                        JobKey jobKey = tw.getJobKey();
                        if (removeJob(jobKey)) {
                            this.signaler.notifySchedulerListenersJobDeleted(jobKey);
                        }
                    }
                }
            }
            return tw != null;
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean replaceTrigger(TriggerKey triggerKey, OperableTrigger newTrigger) throws JobPersistenceException {
        lock();
        try {
            TriggerWrapper tw = this.triggerFacade.remove(triggerKey);
            boolean found = tw != null;
            if (tw != null) {
                if (!tw.getJobKey().equals(newTrigger.getJobKey())) {
                    throw new JobPersistenceException("New trigger is not related to the same job as the old trigger.");
                }
                Set<String> grpSet = this.toolkitDSHolder.getOrCreateTriggersGroupMap(triggerKey.getGroup());
                grpSet.remove(triggerKey.getName());
                if (grpSet.size() == 0) {
                    this.toolkitDSHolder.removeTriggersGroupMap(triggerKey.getGroup());
                    this.triggerFacade.removeGroup(triggerKey.getGroup());
                }
                this.timeTriggers.remove(tw);
                try {
                    storeTrigger(newTrigger, false);
                } catch (JobPersistenceException jpe) {
                    storeTrigger(tw.getTriggerClone(), false);
                    throw jpe;
                }
            }
            return found;
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public JobDetail retrieveJob(JobKey jobKey) throws JobPersistenceException {
        JobWrapper jobWrapper = getJob(jobKey);
        if (jobWrapper == null) {
            return null;
        }
        return jobWrapper.getJobDetailClone();
    }

    JobWrapper getJob(JobKey key) throws JobPersistenceException {
        lock();
        try {
            JobWrapper jobWrapper = this.jobFacade.get(key);
            unlock();
            return jobWrapper;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public OperableTrigger retrieveTrigger(TriggerKey triggerKey) throws JobPersistenceException {
        lock();
        try {
            TriggerWrapper tw = this.triggerFacade.get(triggerKey);
            return tw != null ? tw.getTriggerClone() : null;
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean checkExists(JobKey jobKey) {
        return this.jobFacade.containsKey(jobKey);
    }

    @Override // org.quartz.spi.JobStore
    public boolean checkExists(TriggerKey triggerKey) throws JobPersistenceException {
        return this.triggerFacade.containsKey(triggerKey);
    }

    @Override // org.quartz.spi.JobStore
    public void clearAllSchedulingData() throws JobPersistenceException {
        lock();
        try {
            for (String group : getTriggerGroupNames()) {
                for (TriggerKey key : getTriggerKeys(GroupMatcher.triggerGroupEquals(group))) {
                    removeTrigger(key);
                }
            }
            for (String group2 : getJobGroupNames()) {
                for (JobKey key2 : getJobKeys(GroupMatcher.jobGroupEquals(group2))) {
                    removeJob(key2);
                }
            }
            for (String name : getCalendarNames()) {
                removeCalendar(name);
            }
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public Trigger.TriggerState getTriggerState(TriggerKey key) throws JobPersistenceException {
        lock();
        try {
            TriggerWrapper tw = this.triggerFacade.get(key);
            unlock();
            if (tw == null) {
                return Trigger.TriggerState.NONE;
            }
            if (tw.getState() == TriggerWrapper.TriggerState.COMPLETE) {
                return Trigger.TriggerState.COMPLETE;
            }
            if (!(tw.getState() == TriggerWrapper.TriggerState.PAUSED || tw.getState() == TriggerWrapper.TriggerState.PAUSED_BLOCKED)) {
                return tw.getState() == TriggerWrapper.TriggerState.BLOCKED ? Trigger.TriggerState.BLOCKED : tw.getState() == TriggerWrapper.TriggerState.ERROR ? Trigger.TriggerState.ERROR : Trigger.TriggerState.NORMAL;
            }
            return Trigger.TriggerState.PAUSED;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public void resetTriggerFromErrorState(TriggerKey triggerKey) throws JobPersistenceException {
        TriggerWrapper tw = this.triggerFacade.get(triggerKey);
        if (tw == null || tw.getState() != TriggerWrapper.TriggerState.ERROR) {
            return;
        }
        if (this.triggerFacade.pausedGroupsContain(triggerKey.getGroup())) {
            tw.setState(TriggerWrapper.TriggerState.PAUSED, this.terracottaClientId, this.triggerFacade);
            return;
        }
        tw.setState(TriggerWrapper.TriggerState.WAITING, this.terracottaClientId, this.triggerFacade);
        this.timeTriggers.add(tw);
    }

    @Override // org.quartz.spi.JobStore
    public void storeCalendar(String name, Calendar calendar, boolean replaceExisting, boolean updateTriggers) throws ObjectAlreadyExistsException, JobPersistenceException {
        Calendar clone = (Calendar) calendar.clone();
        lock();
        try {
            Calendar cal = (Calendar) this.calendarsByName.get(name);
            if (cal == null || replaceExisting) {
                if (cal != null) {
                    this.calendarsByName.remove(name);
                }
                this.calendarsByName.putNoReturn(name, clone);
                if (cal != null && updateTriggers) {
                    for (TriggerWrapper tw : this.triggerFacade.getTriggerWrappersForCalendar(name)) {
                        boolean removed = this.timeTriggers.remove(tw);
                        tw.updateWithNewCalendar(clone, getMisfireThreshold(), this.triggerFacade);
                        if (removed) {
                            this.timeTriggers.add(tw);
                        }
                    }
                }
                return;
            }
            throw new ObjectAlreadyExistsException("Calendar with name '" + name + "' already exists.");
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeCalendar(String calName) throws JobPersistenceException {
        int numRefs = 0;
        lock();
        try {
            for (TriggerKey triggerKey : this.triggerFacade.allTriggerKeys()) {
                TriggerWrapper tw = this.triggerFacade.get(triggerKey);
                if (tw.getCalendarName() != null && tw.getCalendarName().equals(calName)) {
                    numRefs++;
                }
            }
            if (numRefs > 0) {
                throw new JobPersistenceException("Calender cannot be removed if it referenced by a Trigger!");
            }
            return this.calendarsByName.remove(calName) != null;
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public Calendar retrieveCalendar(String calName) throws JobPersistenceException {
        lock();
        try {
            Calendar cw = (Calendar) this.calendarsByName.get(calName);
            Calendar calendar = (Calendar) (cw == null ? null : cw.clone());
            unlock();
            return calendar;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfJobs() throws JobPersistenceException {
        lock();
        try {
            int numberOfJobs = this.jobFacade.numberOfJobs();
            unlock();
            return numberOfJobs;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfTriggers() throws JobPersistenceException {
        lock();
        try {
            int numberOfTriggers = this.triggerFacade.numberOfTriggers();
            unlock();
            return numberOfTriggers;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfCalendars() throws JobPersistenceException {
        lock();
        try {
            int size = this.calendarsByName.size();
            unlock();
            return size;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public Set<JobKey> getJobKeys(GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        lock();
        try {
            Set<String> matchingGroups = new HashSet<>();
            switch (matcher.getCompareWithOperator()) {
                case EQUALS:
                    matchingGroups.add(matcher.getCompareToValue());
                    break;
                default:
                    for (String group : this.jobFacade.getAllGroupNames()) {
                        if (matcher.getCompareWithOperator().evaluate(group, matcher.getCompareToValue())) {
                            matchingGroups.add(group);
                        }
                    }
                    break;
            }
            Set<JobKey> out = new HashSet<>();
            for (String matchingGroup : matchingGroups) {
                for (String jobName : this.toolkitDSHolder.getOrCreateJobsGroupMap(matchingGroup)) {
                    JobKey jobKey = new JobKey(jobName, matchingGroup);
                    if (this.jobFacade.containsKey(jobKey)) {
                        out.add(jobKey);
                    }
                }
            }
            return out;
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getCalendarNames() throws JobPersistenceException {
        lock();
        try {
            ArrayList arrayList = new ArrayList(this.calendarsByName.keySet());
            unlock();
            return arrayList;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        lock();
        try {
            Set<String> groupNames = new HashSet<>();
            switch (matcher.getCompareWithOperator()) {
                case EQUALS:
                    groupNames.add(matcher.getCompareToValue());
                    break;
                default:
                    for (String group : this.triggerFacade.allTriggersGroupNames()) {
                        if (matcher.getCompareWithOperator().evaluate(group, matcher.getCompareToValue())) {
                            groupNames.add(group);
                        }
                    }
                    break;
            }
            Set<TriggerKey> out = new HashSet<>();
            for (String groupName : groupNames) {
                for (String key : this.toolkitDSHolder.getOrCreateTriggersGroupMap(groupName)) {
                    TriggerKey triggerKey = new TriggerKey(key, groupName);
                    if (this.triggerFacade.get(triggerKey) != null) {
                        out.add(triggerKey);
                    }
                }
            }
            return out;
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getJobGroupNames() throws JobPersistenceException {
        lock();
        try {
            ArrayList arrayList = new ArrayList(this.jobFacade.getAllGroupNames());
            unlock();
            return arrayList;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getTriggerGroupNames() throws JobPersistenceException {
        lock();
        try {
            ArrayList arrayList = new ArrayList(this.triggerFacade.allTriggersGroupNames());
            unlock();
            return arrayList;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<OperableTrigger> getTriggersForJob(JobKey jobKey) throws JobPersistenceException {
        List<OperableTrigger> trigList = new ArrayList<>();
        lock();
        try {
            for (TriggerKey triggerKey : this.triggerFacade.allTriggerKeys()) {
                TriggerWrapper tw = this.triggerFacade.get(triggerKey);
                if (tw.getJobKey().equals(jobKey)) {
                    trigList.add(tw.getTriggerClone());
                }
            }
            return trigList;
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public void pauseTrigger(TriggerKey triggerKey) throws JobPersistenceException {
        lock();
        try {
            TriggerWrapper tw = this.triggerFacade.get(triggerKey);
            if (tw != null) {
                if (tw.getState() == TriggerWrapper.TriggerState.COMPLETE) {
                    unlock();
                    return;
                }
                if (tw.getState() == TriggerWrapper.TriggerState.BLOCKED) {
                    tw.setState(TriggerWrapper.TriggerState.PAUSED_BLOCKED, this.terracottaClientId, this.triggerFacade);
                } else {
                    tw.setState(TriggerWrapper.TriggerState.PAUSED, this.terracottaClientId, this.triggerFacade);
                }
                this.timeTriggers.remove(tw);
                if (this.triggerRemovedFromCandidateFiringListHandler != null) {
                    this.triggerRemovedFromCandidateFiringListHandler.removeCandidateTrigger(tw);
                }
                unlock();
            }
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public Collection<String> pauseTriggers(GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        HashSet<String> pausedGroups = new HashSet<>();
        lock();
        try {
            for (TriggerKey key : getTriggerKeys(matcher)) {
                this.triggerFacade.addPausedGroup(key.getGroup());
                pausedGroups.add(key.getGroup());
                pauseTrigger(key);
            }
            if (matcher.getCompareWithOperator().equals(StringMatcher.StringOperatorName.EQUALS)) {
                this.triggerFacade.addPausedGroup(matcher.getCompareToValue());
                pausedGroups.add(matcher.getCompareToValue());
            }
            return pausedGroups;
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public void pauseJob(JobKey jobKey) throws JobPersistenceException {
        lock();
        try {
            for (OperableTrigger trigger : getTriggersForJob(jobKey)) {
                pauseTrigger(trigger.getKey());
            }
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public Collection<String> pauseJobs(GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        Collection<String> pausedGroups = new HashSet<>();
        lock();
        try {
            for (JobKey jobKey : getJobKeys(matcher)) {
                for (OperableTrigger trigger : getTriggersForJob(jobKey)) {
                    pauseTrigger(trigger.getKey());
                }
                pausedGroups.add(jobKey.getGroup());
            }
            if (matcher.getCompareWithOperator().equals(StringMatcher.StringOperatorName.EQUALS)) {
                this.jobFacade.addPausedGroup(matcher.getCompareToValue());
                pausedGroups.add(matcher.getCompareToValue());
            }
            return pausedGroups;
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public void resumeTrigger(TriggerKey triggerKey) throws JobPersistenceException {
        lock();
        try {
            TriggerWrapper tw = this.triggerFacade.get(triggerKey);
            if (tw != null) {
                if (tw.getState() == TriggerWrapper.TriggerState.PAUSED || tw.getState() == TriggerWrapper.TriggerState.PAUSED_BLOCKED) {
                    if (this.jobFacade.blockedJobsContain(tw.getJobKey())) {
                        tw.setState(TriggerWrapper.TriggerState.BLOCKED, this.terracottaClientId, this.triggerFacade);
                    } else {
                        tw.setState(TriggerWrapper.TriggerState.WAITING, this.terracottaClientId, this.triggerFacade);
                    }
                    applyMisfire(tw);
                    if (tw.getState() == TriggerWrapper.TriggerState.WAITING) {
                        this.timeTriggers.add(tw);
                    }
                    unlock();
                    return;
                }
                unlock();
            }
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public Collection<String> resumeTriggers(GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        Collection<String> groups = new HashSet<>();
        lock();
        try {
            for (TriggerKey triggerKey : getTriggerKeys(matcher)) {
                TriggerWrapper tw = this.triggerFacade.get(triggerKey);
                if (tw != null) {
                    if (!this.jobFacade.pausedGroupsContain(tw.getJobKey().getGroup())) {
                        groups.add(triggerKey.getGroup());
                    }
                }
                resumeTrigger(triggerKey);
            }
            this.triggerFacade.removeAllPausedGroups(groups);
            unlock();
            return groups;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public void resumeJob(JobKey jobKey) throws JobPersistenceException {
        lock();
        try {
            for (OperableTrigger trigger : getTriggersForJob(jobKey)) {
                resumeTrigger(trigger.getKey());
            }
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public Collection<String> resumeJobs(GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        Collection<String> groups = new HashSet<>();
        lock();
        try {
            for (JobKey jobKey : getJobKeys(matcher)) {
                if (groups.add(jobKey.getGroup())) {
                    this.jobFacade.removePausedJobGroup(jobKey.getGroup());
                }
                for (OperableTrigger trigger : getTriggersForJob(jobKey)) {
                    resumeTrigger(trigger.getKey());
                }
            }
            return groups;
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public void pauseAll() throws JobPersistenceException {
        lock();
        try {
            for (String name : getTriggerGroupNames()) {
                pauseTriggers(GroupMatcher.triggerGroupEquals(name));
            }
        } finally {
            unlock();
        }
    }

    @Override // org.quartz.spi.JobStore
    public void resumeAll() throws JobPersistenceException {
        lock();
        try {
            this.jobFacade.clearPausedJobGroups();
            for (String name : getTriggerGroupNames()) {
                resumeTriggers(GroupMatcher.triggerGroupEquals(name));
            }
        } finally {
            unlock();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v37, types: [long] */
    boolean applyMisfire(TriggerWrapper tw) throws JobPersistenceException {
        char currentTimeMillis = System.currentTimeMillis();
        if (getMisfireThreshold() > 0) {
            currentTimeMillis -= getMisfireThreshold();
        }
        Date tnft = tw.getNextFireTime();
        if (tnft == null || tnft.getTime() > currentTimeMillis || tw.getMisfireInstruction() == -1) {
            return false;
        }
        Calendar cal = null;
        if (tw.getCalendarName() != null) {
            cal = retrieveCalendar(tw.getCalendarName());
        }
        this.signaler.notifyTriggerListenersMisfired(tw.getTriggerClone());
        tw.updateAfterMisfire(cal, this.triggerFacade);
        if (tw.getNextFireTime() != null) {
            return !tnft.equals(tw.getNextFireTime());
        }
        tw.setState(TriggerWrapper.TriggerState.COMPLETE, this.terracottaClientId, this.triggerFacade);
        this.signaler.notifySchedulerListenersFinalized(tw.getTriggerClone());
        this.timeTriggers.remove(tw);
        return true;
    }

    @Override // org.quartz.spi.JobStore
    public List<OperableTrigger> acquireNextTriggers(long noLaterThan, int maxCount, long timeWindow) throws JobPersistenceException {
        List<OperableTrigger> result = new ArrayList<>();
        lock();
        try {
            for (TriggerWrapper tw : getNextTriggerWrappers(this.timeTriggers, noLaterThan, maxCount, timeWindow)) {
                result.add(markAndCloneTrigger(tw));
            }
            try {
                unlock();
            } catch (RejoinException e) {
                if (!validateAcquired(result)) {
                    throw e;
                }
            }
            return result;
        } catch (Throwable th) {
            try {
                unlock();
            } catch (RejoinException e2) {
                if (!validateAcquired(result)) {
                    throw e2;
                }
            }
            throw th;
        }
    }

    private boolean validateAcquired(List<OperableTrigger> result) {
        if (result.isEmpty()) {
            return false;
        }
        while (!this.toolkitShutdown) {
            try {
                lock();
                try {
                    for (OperableTrigger ot : result) {
                        TriggerWrapper tw = this.triggerFacade.get(ot.getKey());
                        if (!ot.getFireInstanceId().equals(tw.getTriggerClone().getFireInstanceId()) || !TriggerWrapper.TriggerState.ACQUIRED.equals(tw.getState())) {
                            return false;
                        }
                    }
                    unlock();
                    return true;
                } finally {
                    unlock();
                }
            } catch (RejoinException e) {
                try {
                    Thread.sleep(this.retryInterval);
                } catch (InterruptedException f) {
                    throw new IllegalStateException("Received interrupted exception", f);
                }
            } catch (JobPersistenceException e2) {
                try {
                    Thread.sleep(this.retryInterval);
                } catch (InterruptedException f2) {
                    throw new IllegalStateException("Received interrupted exception", f2);
                }
            }
        }
        throw new IllegalStateException("Scheduler has been shutdown");
    }

    OperableTrigger markAndCloneTrigger(TriggerWrapper tw) {
        tw.setState(TriggerWrapper.TriggerState.ACQUIRED, this.terracottaClientId, this.triggerFacade);
        StringBuilder append = new StringBuilder().append(this.terracottaClientId).append("-");
        long j = this.ftrCtr;
        this.ftrCtr = j + 1;
        tw.setFireInstanceId(append.append(String.valueOf(j)).toString(), this.triggerFacade);
        return tw.getTriggerClone();
    }

    List<TriggerWrapper> getNextTriggerWrappers(long noLaterThan, int maxCount, long timeWindow) throws JobPersistenceException {
        return getNextTriggerWrappers(this.timeTriggers, noLaterThan, maxCount, timeWindow);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x0021 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:71:0x0021 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [long] */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        r6.add(r18);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    java.util.List<org.terracotta.quartz.wrappers.TriggerWrapper> getNextTriggerWrappers(org.terracotta.quartz.collections.TimeTriggerSet r6, long r7, int r9, long r10) throws org.quartz.JobPersistenceException {
        /*
        // Method dump skipped, instructions count: 364
        */
        throw new UnsupportedOperationException("Method not decompiled: org.terracotta.quartz.DefaultClusteredJobStore.getNextTriggerWrappers(org.terracotta.quartz.collections.TimeTriggerSet, long, int, long):java.util.List");
    }

    public void setTriggerRemovedFromCandidateFiringListHandler(TriggerRemovedFromCandidateFiringListHandler triggerRemovedFromCandidateFiringListHandler) {
        this.triggerRemovedFromCandidateFiringListHandler = triggerRemovedFromCandidateFiringListHandler;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:14:0x005b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.quartz.spi.JobStore
    public void releaseAcquiredTrigger(org.quartz.spi.OperableTrigger r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = r5
            boolean r0 = r0.toolkitShutdown
            if (r0 != 0) goto L_0x009b
            r0 = r5
            r0.lock()     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080
            r0 = r5
            org.terracotta.quartz.wrappers.TriggerFacade r0 = r0.triggerFacade     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
            r1 = r6
            org.quartz.TriggerKey r1 = r1.getKey()     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
            org.terracotta.quartz.wrappers.TriggerWrapper r0 = r0.get(r1)     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L_0x0054
            r0 = r6
            java.lang.String r0 = r0.getFireInstanceId()     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
            r1 = r7
            org.quartz.spi.OperableTrigger r1 = r1.getTriggerClone()     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
            java.lang.String r1 = r1.getFireInstanceId()     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
            boolean r0 = r0.equals(r1)     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
            if (r0 == 0) goto L_0x0054
            r0 = r7
            org.terracotta.quartz.wrappers.TriggerWrapper$TriggerState r0 = r0.getState()     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
            org.terracotta.quartz.wrappers.TriggerWrapper$TriggerState r1 = org.terracotta.quartz.wrappers.TriggerWrapper.TriggerState.ACQUIRED     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
            if (r0 != r1) goto L_0x0054
            r0 = r7
            org.terracotta.quartz.wrappers.TriggerWrapper$TriggerState r1 = org.terracotta.quartz.wrappers.TriggerWrapper.TriggerState.WAITING     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
            r2 = r5
            java.lang.String r2 = r2.terracottaClientId     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
            r3 = r5
            org.terracotta.quartz.wrappers.TriggerFacade r3 = r3.triggerFacade     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
            r0.setState(r1, r2, r3)     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
            r0 = r5
            org.terracotta.quartz.collections.TimeTriggerSet r0 = r0.timeTriggers     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
            r1 = r7
            boolean r0 = r0.add(r1)     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080, all -> 0x005b
        L_0x0054:
            r0 = r5
            r0.unlock()     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080
            goto L_0x0062
        L_0x005b:
            r8 = move-exception
            r0 = r5
            r0.unlock()     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080
            r0 = r8
            throw r0     // Catch: RejoinException -> 0x0065, JobPersistenceException -> 0x0080
        L_0x0062:
            goto L_0x009b
        L_0x0065:
            r7 = move-exception
            r0 = r5
            long r0 = r0.retryInterval     // Catch: InterruptedException -> 0x0070
            java.lang.Thread.sleep(r0)     // Catch: InterruptedException -> 0x0070
            goto L_0x007d
        L_0x0070:
            r8 = move-exception
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "Received interrupted exception"
            r3 = r8
            r1.<init>(r2, r3)
            throw r0
        L_0x007d:
            goto L_0x0000
        L_0x0080:
            r7 = move-exception
            r0 = r5
            long r0 = r0.retryInterval     // Catch: InterruptedException -> 0x008b
            java.lang.Thread.sleep(r0)     // Catch: InterruptedException -> 0x008b
            goto L_0x0098
        L_0x008b:
            r8 = move-exception
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "Received interrupted exception"
            r3 = r8
            r1.<init>(r2, r3)
            throw r0
        L_0x0098:
            goto L_0x0000
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.terracotta.quartz.DefaultClusteredJobStore.releaseAcquiredTrigger(org.quartz.spi.OperableTrigger):void");
    }

    @Override // org.quartz.spi.JobStore
    public List<TriggerFiredResult> triggersFired(List<OperableTrigger> triggersFired) throws JobPersistenceException {
        List<TriggerFiredResult> results = new ArrayList<>();
        lock();
        try {
            for (OperableTrigger trigger : triggersFired) {
                TriggerWrapper tw = this.triggerFacade.get(trigger.getKey());
                if (tw == null) {
                    results.add(new TriggerFiredResult((TriggerFiredBundle) null));
                } else if (tw.getState() != TriggerWrapper.TriggerState.ACQUIRED) {
                    results.add(new TriggerFiredResult((TriggerFiredBundle) null));
                } else {
                    Calendar cal = null;
                    if (tw.getCalendarName() != null) {
                        cal = retrieveCalendar(tw.getCalendarName());
                        if (cal == null) {
                            results.add(new TriggerFiredResult((TriggerFiredBundle) null));
                        }
                    }
                    Date prevFireTime = trigger.getPreviousFireTime();
                    this.timeTriggers.remove(tw);
                    tw.triggered(cal, this.triggerFacade);
                    trigger.triggered(cal);
                    tw.setState(TriggerWrapper.TriggerState.WAITING, this.terracottaClientId, this.triggerFacade);
                    TriggerFiredBundle bndle = new TriggerFiredBundle(retrieveJob(trigger.getJobKey()), trigger, cal, false, new Date(), trigger.getPreviousFireTime(), prevFireTime, trigger.getNextFireTime());
                    String fireInstanceId = trigger.getFireInstanceId();
                    FiredTrigger prev = this.triggerFacade.getFiredTrigger(fireInstanceId);
                    this.triggerFacade.putFiredTrigger(fireInstanceId, new FiredTrigger(this.terracottaClientId, tw.getKey(), trigger.getPreviousFireTime().getTime()));
                    getLog().trace("Tracking " + trigger + " has fired on " + fireInstanceId);
                    if (prev != null) {
                        throw new AssertionError("duplicate fireInstanceId detected (" + fireInstanceId + ") for " + trigger + ", previous is " + prev);
                    }
                    JobDetail job = bndle.getJobDetail();
                    if (job.isConcurrentExectionDisallowed()) {
                        for (TriggerWrapper ttw : this.triggerFacade.getTriggerWrappersForJob(job.getKey())) {
                            if (!ttw.getKey().equals(tw.getKey())) {
                                if (ttw.getState() == TriggerWrapper.TriggerState.WAITING) {
                                    ttw.setState(TriggerWrapper.TriggerState.BLOCKED, this.terracottaClientId, this.triggerFacade);
                                }
                                if (ttw.getState() == TriggerWrapper.TriggerState.PAUSED) {
                                    ttw.setState(TriggerWrapper.TriggerState.PAUSED_BLOCKED, this.terracottaClientId, this.triggerFacade);
                                }
                                this.timeTriggers.remove(ttw);
                                if (this.triggerRemovedFromCandidateFiringListHandler != null) {
                                    this.triggerRemovedFromCandidateFiringListHandler.removeCandidateTrigger(ttw);
                                }
                            }
                        }
                        this.jobFacade.addBlockedJob(job.getKey());
                    } else if (tw.getNextFireTime() != null) {
                        this.timeTriggers.add(tw);
                    }
                    results.add(new TriggerFiredResult(bndle));
                }
            }
            try {
                unlock();
            } catch (RejoinException e) {
                if (!validateFiring(results)) {
                    throw e;
                }
            }
            return results;
        } catch (Throwable th) {
            try {
                unlock();
            } catch (RejoinException e2) {
                if (!validateFiring(results)) {
                    throw e2;
                }
            }
            throw th;
        }
    }

    private boolean validateFiring(List<TriggerFiredResult> result) {
        if (result.isEmpty()) {
            return false;
        }
        while (!this.toolkitShutdown) {
            try {
                lock();
                try {
                    for (TriggerFiredResult tfr : result) {
                        TriggerFiredBundle tfb = tfr.getTriggerFiredBundle();
                        if (!(tfb == null || this.triggerFacade.containsFiredTrigger(tfb.getTrigger().getFireInstanceId()))) {
                            return false;
                        }
                    }
                    unlock();
                    return true;
                } finally {
                    unlock();
                }
            } catch (RejoinException e) {
                try {
                    Thread.sleep(this.retryInterval);
                } catch (InterruptedException f) {
                    throw new IllegalStateException("Received interrupted exception", f);
                }
            } catch (JobPersistenceException e2) {
                try {
                    Thread.sleep(this.retryInterval);
                } catch (InterruptedException f2) {
                    throw new IllegalStateException("Received interrupted exception", f2);
                }
            }
        }
        throw new IllegalStateException("Scheduler has been shutdown");
    }

    /* JADX INFO: finally extract failed */
    @Override // org.quartz.spi.JobStore
    public void triggeredJobComplete(OperableTrigger trigger, JobDetail jobDetail, Trigger.CompletedExecutionInstruction triggerInstCode) {
        while (!this.toolkitShutdown) {
            try {
                lock();
                String fireId = trigger.getFireInstanceId();
                if (this.triggerFacade.removeFiredTrigger(fireId) == null) {
                    getLog().warn("No fired trigger record found for " + trigger + " (" + fireId + ")");
                    unlock();
                    return;
                }
                JobKey jobKey = jobDetail.getKey();
                JobWrapper jw = this.jobFacade.get(jobKey);
                TriggerWrapper tw = this.triggerFacade.get(trigger.getKey());
                if (jw != null) {
                    try {
                        if (jw.isPersistJobDataAfterExecution()) {
                            JobDataMap newData = jobDetail.getJobDataMap();
                            if (newData != null) {
                                newData = (JobDataMap) newData.clone();
                                newData.clearDirtyFlag();
                            }
                            jw.setJobDataMap(newData, this.jobFacade);
                        }
                        if (jw.isConcurrentExectionDisallowed()) {
                            this.jobFacade.removeBlockedJob(jw.getKey());
                            tw.setState(TriggerWrapper.TriggerState.WAITING, this.terracottaClientId, this.triggerFacade);
                            this.timeTriggers.add(tw);
                            for (TriggerWrapper ttw : this.triggerFacade.getTriggerWrappersForJob(jw.getKey())) {
                                if (ttw.getState() == TriggerWrapper.TriggerState.BLOCKED) {
                                    ttw.setState(TriggerWrapper.TriggerState.WAITING, this.terracottaClientId, this.triggerFacade);
                                    this.timeTriggers.add(ttw);
                                }
                                if (ttw.getState() == TriggerWrapper.TriggerState.PAUSED_BLOCKED) {
                                    ttw.setState(TriggerWrapper.TriggerState.PAUSED, this.terracottaClientId, this.triggerFacade);
                                }
                            }
                            this.signaler.signalSchedulingChange(0);
                        }
                    } catch (Throwable th) {
                        unlock();
                        throw th;
                    }
                } else {
                    this.jobFacade.removeBlockedJob(jobKey);
                }
                if (tw != null) {
                    if (triggerInstCode == Trigger.CompletedExecutionInstruction.DELETE_TRIGGER) {
                        if (trigger.getNextFireTime() != null) {
                            removeTrigger(trigger.getKey());
                            this.signaler.signalSchedulingChange(0);
                        } else if (tw.getNextFireTime() == null) {
                            removeTrigger(trigger.getKey());
                        }
                    } else if (triggerInstCode == Trigger.CompletedExecutionInstruction.SET_TRIGGER_COMPLETE) {
                        tw.setState(TriggerWrapper.TriggerState.COMPLETE, this.terracottaClientId, this.triggerFacade);
                        this.timeTriggers.remove(tw);
                        this.signaler.signalSchedulingChange(0);
                    } else if (triggerInstCode == Trigger.CompletedExecutionInstruction.SET_TRIGGER_ERROR) {
                        getLog().info("Trigger " + trigger.getKey() + " set to ERROR state.");
                        tw.setState(TriggerWrapper.TriggerState.ERROR, this.terracottaClientId, this.triggerFacade);
                        this.signaler.signalSchedulingChange(0);
                    } else if (triggerInstCode == Trigger.CompletedExecutionInstruction.SET_ALL_JOB_TRIGGERS_ERROR) {
                        getLog().info("All triggers of Job " + trigger.getJobKey() + " set to ERROR state.");
                        setAllTriggersOfJobToState(trigger.getJobKey(), TriggerWrapper.TriggerState.ERROR);
                        this.signaler.signalSchedulingChange(0);
                    } else if (triggerInstCode == Trigger.CompletedExecutionInstruction.SET_ALL_JOB_TRIGGERS_COMPLETE) {
                        setAllTriggersOfJobToState(trigger.getJobKey(), TriggerWrapper.TriggerState.COMPLETE);
                        this.signaler.signalSchedulingChange(0);
                    }
                }
                unlock();
                return;
            } catch (JobPersistenceException e) {
                try {
                    Thread.sleep(this.retryInterval);
                } catch (InterruptedException f) {
                    throw new IllegalStateException("Received interrupted exception", f);
                }
            } catch (RejoinException e2) {
                try {
                    Thread.sleep(this.retryInterval);
                } catch (InterruptedException f2) {
                    throw new IllegalStateException("Received interrupted exception", f2);
                }
            }
        }
    }

    private void setAllTriggersOfJobToState(JobKey jobKey, TriggerWrapper.TriggerState state) {
        for (TriggerWrapper tw : this.triggerFacade.getTriggerWrappersForJob(jobKey)) {
            tw.setState(state, this.terracottaClientId, this.triggerFacade);
            if (state != TriggerWrapper.TriggerState.WAITING) {
                this.timeTriggers.remove(tw);
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public Set<String> getPausedTriggerGroups() throws JobPersistenceException {
        lock();
        try {
            HashSet hashSet = new HashSet(this.triggerFacade.allPausedTriggersGroupNames());
            unlock();
            return hashSet;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // org.quartz.spi.JobStore
    public void setInstanceId(String schedInstId) {
    }

    @Override // org.quartz.spi.JobStore
    public void setInstanceName(String schedName) {
    }

    @Override // org.terracotta.quartz.ClusteredJobStore
    public void setTcRetryInterval(long retryInterval) {
        this.retryInterval = retryInterval;
    }

    public void nodeLeft(ClusterEvent event) {
        String nodeLeft = event.getNode().getId();
        try {
            lock();
            try {
                List<TriggerWrapper> toEval = new ArrayList<>();
                for (TriggerKey triggerKey : this.triggerFacade.allTriggerKeys()) {
                    TriggerWrapper tw = this.triggerFacade.get(triggerKey);
                    String clientId = tw.getLastTerracotaClientId();
                    if (clientId != null && clientId.equals(nodeLeft)) {
                        toEval.add(tw);
                    }
                }
                for (TriggerWrapper tw2 : toEval) {
                    evalOrphanedTrigger(tw2, false);
                }
                Iterator<FiredTrigger> iter = this.triggerFacade.allFiredTriggers().iterator();
                while (iter.hasNext()) {
                    FiredTrigger ft = iter.next();
                    if (nodeLeft.equals(ft.getClientId())) {
                        getLog().info("Found non-complete fired trigger: " + ft);
                        iter.remove();
                        TriggerWrapper tw3 = this.triggerFacade.get(ft.getTriggerKey());
                        if (tw3 == null) {
                            getLog().error("no trigger found for executing trigger: " + ft.getTriggerKey());
                        } else {
                            scheduleRecoveryIfNeeded(tw3, ft);
                        }
                    }
                }
                this.signaler.signalSchedulingChange(0);
            } finally {
                unlock();
            }
        } catch (JobPersistenceException e) {
            getLog().info("Job store is already disabled, not processing nodeLeft() for " + nodeLeft);
        }
    }

    @Override // org.quartz.spi.JobStore
    public long getEstimatedTimeToReleaseAndAcquireTrigger() {
        return this.estimatedTimeToReleaseAndAcquireTrigger;
    }

    @Override // org.terracotta.quartz.ClusteredJobStore
    public void setEstimatedTimeToReleaseAndAcquireTrigger(long estimate) {
        this.estimatedTimeToReleaseAndAcquireTrigger = estimate;
    }

    @Override // org.quartz.spi.JobStore
    public void setThreadPoolSize(int size) {
    }

    @Override // org.quartz.spi.JobStore
    public boolean isClustered() {
        throw new AssertionError();
    }

    @Override // org.quartz.spi.JobStore
    public long getAcquireRetryDelay(int failureCount) {
        return this.retryInterval;
    }

    void injectTriggerWrapper(TriggerWrapper triggerWrapper) {
        this.timeTriggers.add(triggerWrapper);
    }

    /* loaded from: grasscutter.jar:org/terracotta/quartz/DefaultClusteredJobStore$ShutdownHook.class */
    private static class ShutdownHook implements Runnable {
        private final DefaultClusteredJobStore store;

        ShutdownHook(DefaultClusteredJobStore store) {
            this.store = store;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.store.disable();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/terracotta/quartz/DefaultClusteredJobStore$LocalLockState.class */
    public static class LocalLockState {
        private int acquires;
        private boolean disabled;

        private LocalLockState() {
            this.acquires = 0;
        }

        /* synthetic */ LocalLockState(C59801 x0) {
            this();
        }

        synchronized void attemptAcquireBegin() throws JobPersistenceException {
            if (this.disabled) {
                throw new JobPersistenceException("org.terracotta.quartz.TerracottaJobStore is disabled");
            }
            this.acquires++;
        }

        synchronized void release() {
            this.acquires--;
            notifyAll();
        }

        synchronized void disableLocking() throws InterruptedException {
            this.disabled = true;
            while (this.acquires > 0) {
                wait();
            }
        }
    }

    ClusterInfo getDsoCluster() {
        return this.clusterInfo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: org.terracotta.quartz.DefaultClusteredJobStore$1 */
    /* loaded from: grasscutter.jar:org/terracotta/quartz/DefaultClusteredJobStore$1.class */
    public static /* synthetic */ class C59801 {
        static final /* synthetic */ int[] $SwitchMap$org$terracotta$toolkit$cluster$ClusterEvent$Type = new int[ClusterEvent.Type.values().length];

        static {
            try {
                $SwitchMap$org$terracotta$toolkit$cluster$ClusterEvent$Type[ClusterEvent.Type.NODE_JOINED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$terracotta$toolkit$cluster$ClusterEvent$Type[ClusterEvent.Type.OPERATIONS_DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$terracotta$toolkit$cluster$ClusterEvent$Type[ClusterEvent.Type.OPERATIONS_ENABLED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$org$terracotta$toolkit$cluster$ClusterEvent$Type[ClusterEvent.Type.NODE_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$org$terracotta$toolkit$cluster$ClusterEvent$Type[ClusterEvent.Type.NODE_REJOINED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            f3379xbe37f3ab = new int[StringMatcher.StringOperatorName.values().length];
            try {
                f3379xbe37f3ab[StringMatcher.StringOperatorName.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public void onClusterEvent(ClusterEvent event) {
        switch (C59801.$SwitchMap$org$terracotta$toolkit$cluster$ClusterEvent$Type[event.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            default:
                return;
            case 4:
                getLog().info("Received node left notification for " + event.getNode().getId());
                nodeLeft(event);
                return;
            case 5:
                getLog().info("Received rejoin notification " + this.terracottaClientId + " => " + event.getNode().getId());
                this.terracottaClientId = event.getNode().getId();
                return;
        }
    }

    protected TriggerFacade getTriggersFacade() {
        return this.triggerFacade;
    }
}
