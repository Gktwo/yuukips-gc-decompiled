package org.quartz.impl.jdbcjobstore;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.LongCompanionObject;
import org.quartz.Calendar;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.JobPersistenceException;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.quartz.SchedulerConfigException;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.DefaultThreadExecutor;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.matchers.StringMatcher;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.JobStore;
import org.quartz.spi.OperableTrigger;
import org.quartz.spi.SchedulerSignaler;
import org.quartz.spi.ThreadExecutor;
import org.quartz.spi.TriggerFiredBundle;
import org.quartz.spi.TriggerFiredResult;
import org.quartz.utils.DBConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p013io.netty.handler.traffic.AbstractTrafficShapingHandler;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/JobStoreSupport.class */
public abstract class JobStoreSupport implements JobStore, Constants {
    protected static final String LOCK_TRIGGER_ACCESS = "TRIGGER_ACCESS";
    protected static final String LOCK_STATE_ACCESS = "STATE_ACCESS";
    protected String dsName;
    protected String instanceId;
    protected String instanceName;
    protected String delegateClassName;
    protected String delegateInitString;
    private DriverDelegate delegate;
    private ClassLoadHelper classLoadHelper;
    private SchedulerSignaler schedSignaler;
    private static long ftrCtr = System.currentTimeMillis();
    protected String tablePrefix = Constants.DEFAULT_TABLE_PREFIX;
    protected boolean useProperties = false;
    protected Class<? extends DriverDelegate> delegateClass = StdJDBCDelegate.class;
    protected HashMap<String, Calendar> calendarCache = new HashMap<>();
    private long misfireThreshold = 60000;
    private boolean dontSetAutoCommitFalse = false;
    private boolean isClustered = false;
    private boolean useDBLocks = false;
    private boolean lockOnInsert = true;
    private Semaphore lockHandler = null;
    private String selectWithLockSQL = null;
    private long clusterCheckinInterval = 7500;
    private ClusterManager clusterManagementThread = null;
    private MisfireHandler misfireHandler = null;
    protected int maxToRecoverAtATime = 20;
    private boolean setTxIsolationLevelSequential = false;
    private boolean acquireTriggersWithinLock = false;
    private long dbRetryInterval = AbstractTrafficShapingHandler.DEFAULT_MAX_TIME;
    private boolean makeThreadsDaemons = false;
    private boolean threadsInheritInitializersClassLoadContext = false;
    private ClassLoader initializersLoader = null;
    private boolean doubleCheckLockMisfireHandler = true;
    private final Logger log = LoggerFactory.getLogger(getClass());
    private ThreadExecutor threadExecutor = new DefaultThreadExecutor();
    private volatile boolean schedulerRunning = false;
    private volatile boolean shutdown = false;
    protected ThreadLocal<Long> sigChangeForTxCompletion = new ThreadLocal<>();
    protected boolean firstCheckIn = true;
    protected long lastCheckin = System.currentTimeMillis();

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/JobStoreSupport$TransactionCallback.class */
    public interface TransactionCallback<T> {
        T execute(Connection connection) throws JobPersistenceException;
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/JobStoreSupport$TransactionValidator.class */
    public interface TransactionValidator<T> {
        Boolean validate(Connection connection, T t) throws JobPersistenceException;
    }

    protected abstract Connection getNonManagedTXConnection() throws JobPersistenceException;

    protected abstract <T> T executeInLock(String str, TransactionCallback<T> transactionCallback) throws JobPersistenceException;

    public void setDataSource(String dsName) {
        this.dsName = dsName;
    }

    public String getDataSource() {
        return this.dsName;
    }

    public void setTablePrefix(String prefix) {
        if (prefix == null) {
            prefix = "";
        }
        this.tablePrefix = prefix;
    }

    public String getTablePrefix() {
        return this.tablePrefix;
    }

    public void setUseProperties(String useProp) {
        if (useProp == null) {
            useProp = "false";
        }
        this.useProperties = Boolean.valueOf(useProp).booleanValue();
    }

    public boolean canUseProperties() {
        return this.useProperties;
    }

    @Override // org.quartz.spi.JobStore
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    @Override // org.quartz.spi.JobStore
    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    @Override // org.quartz.spi.JobStore
    public void setThreadPoolSize(int poolSize) {
    }

    public void setThreadExecutor(ThreadExecutor threadExecutor) {
        this.threadExecutor = threadExecutor;
    }

    public ThreadExecutor getThreadExecutor() {
        return this.threadExecutor;
    }

    public String getInstanceName() {
        return this.instanceName;
    }

    @Override // org.quartz.spi.JobStore
    public long getEstimatedTimeToReleaseAndAcquireTrigger() {
        return 70;
    }

    public void setIsClustered(boolean isClustered) {
        this.isClustered = isClustered;
    }

    @Override // org.quartz.spi.JobStore
    public boolean isClustered() {
        return this.isClustered;
    }

    public long getClusterCheckinInterval() {
        return this.clusterCheckinInterval;
    }

    public void setClusterCheckinInterval(long l) {
        this.clusterCheckinInterval = l;
    }

    public int getMaxMisfiresToHandleAtATime() {
        return this.maxToRecoverAtATime;
    }

    public void setMaxMisfiresToHandleAtATime(int maxToRecoverAtATime) {
        this.maxToRecoverAtATime = maxToRecoverAtATime;
    }

    public long getDbRetryInterval() {
        return this.dbRetryInterval;
    }

    public void setDbRetryInterval(long dbRetryInterval) {
        this.dbRetryInterval = dbRetryInterval;
    }

    public void setUseDBLocks(boolean useDBLocks) {
        this.useDBLocks = useDBLocks;
    }

    public boolean getUseDBLocks() {
        return this.useDBLocks;
    }

    public boolean isLockOnInsert() {
        return this.lockOnInsert;
    }

    public void setLockOnInsert(boolean lockOnInsert) {
        this.lockOnInsert = lockOnInsert;
    }

    public long getMisfireThreshold() {
        return this.misfireThreshold;
    }

    public void setMisfireThreshold(long misfireThreshold) {
        if (misfireThreshold < 1) {
            throw new IllegalArgumentException("Misfirethreshold must be larger than 0");
        }
        this.misfireThreshold = misfireThreshold;
    }

    public boolean isDontSetAutoCommitFalse() {
        return this.dontSetAutoCommitFalse;
    }

    public void setDontSetAutoCommitFalse(boolean b) {
        this.dontSetAutoCommitFalse = b;
    }

    public boolean isTxIsolationLevelSerializable() {
        return this.setTxIsolationLevelSequential;
    }

    public void setTxIsolationLevelSerializable(boolean b) {
        this.setTxIsolationLevelSequential = b;
    }

    public boolean isAcquireTriggersWithinLock() {
        return this.acquireTriggersWithinLock;
    }

    public void setAcquireTriggersWithinLock(boolean acquireTriggersWithinLock) {
        this.acquireTriggersWithinLock = acquireTriggersWithinLock;
    }

    public void setDriverDelegateClass(String delegateClassName) throws InvalidConfigurationException {
        synchronized (this) {
            this.delegateClassName = delegateClassName;
        }
    }

    public String getDriverDelegateClass() {
        return this.delegateClassName;
    }

    public void setDriverDelegateInitString(String delegateInitString) throws InvalidConfigurationException {
        this.delegateInitString = delegateInitString;
    }

    public String getDriverDelegateInitString() {
        return this.delegateInitString;
    }

    public String getSelectWithLockSQL() {
        return this.selectWithLockSQL;
    }

    public void setSelectWithLockSQL(String string) {
        this.selectWithLockSQL = string;
    }

    protected ClassLoadHelper getClassLoadHelper() {
        return this.classLoadHelper;
    }

    public boolean getMakeThreadsDaemons() {
        return this.makeThreadsDaemons;
    }

    public void setMakeThreadsDaemons(boolean makeThreadsDaemons) {
        this.makeThreadsDaemons = makeThreadsDaemons;
    }

    public boolean isThreadsInheritInitializersClassLoadContext() {
        return this.threadsInheritInitializersClassLoadContext;
    }

    public void setThreadsInheritInitializersClassLoadContext(boolean threadsInheritInitializersClassLoadContext) {
        this.threadsInheritInitializersClassLoadContext = threadsInheritInitializersClassLoadContext;
    }

    public boolean getDoubleCheckLockMisfireHandler() {
        return this.doubleCheckLockMisfireHandler;
    }

    public void setDoubleCheckLockMisfireHandler(boolean doubleCheckLockMisfireHandler) {
        this.doubleCheckLockMisfireHandler = doubleCheckLockMisfireHandler;
    }

    @Override // org.quartz.spi.JobStore
    public long getAcquireRetryDelay(int failureCount) {
        return this.dbRetryInterval;
    }

    protected Logger getLog() {
        return this.log;
    }

    @Override // org.quartz.spi.JobStore
    public void initialize(ClassLoadHelper loadHelper, SchedulerSignaler signaler) throws SchedulerConfigException {
        if (this.dsName == null) {
            throw new SchedulerConfigException("DataSource name not set.");
        }
        this.classLoadHelper = loadHelper;
        if (isThreadsInheritInitializersClassLoadContext()) {
            this.log.info("JDBCJobStore threads will inherit ContextClassLoader of thread: " + Thread.currentThread().getName());
            this.initializersLoader = Thread.currentThread().getContextClassLoader();
        }
        this.schedSignaler = signaler;
        if (getLockHandler() == null) {
            if (isClustered()) {
                setUseDBLocks(true);
            }
            if (getUseDBLocks()) {
                if (getDriverDelegateClass() != null && getDriverDelegateClass().equals(MSSQLDelegate.class.getName()) && getSelectWithLockSQL() == null) {
                    getLog().info("Detected usage of MSSQLDelegate class - defaulting 'selectWithLockSQL' to 'SELECT * FROM {0}LOCKS WITH (UPDLOCK,ROWLOCK) WHERE SCHED_NAME = {1} AND LOCK_NAME = ?'.");
                    setSelectWithLockSQL("SELECT * FROM {0}LOCKS WITH (UPDLOCK,ROWLOCK) WHERE SCHED_NAME = {1} AND LOCK_NAME = ?");
                }
                getLog().info("Using db table-based data access locking (synchronization).");
                setLockHandler(new StdRowLockSemaphore(getTablePrefix(), getInstanceName(), getSelectWithLockSQL()));
                return;
            }
            getLog().info("Using thread monitor-based data access locking (synchronization).");
            setLockHandler(new SimpleSemaphore());
        }
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerStarted() throws SchedulerException {
        if (isClustered()) {
            this.clusterManagementThread = new ClusterManager();
            if (this.initializersLoader != null) {
                this.clusterManagementThread.setContextClassLoader(this.initializersLoader);
            }
            this.clusterManagementThread.initialize();
        } else {
            try {
                recoverJobs();
            } catch (SchedulerException se) {
                throw new SchedulerConfigException("Failure occured during job recovery.", se);
            }
        }
        this.misfireHandler = new MisfireHandler();
        if (this.initializersLoader != null) {
            this.misfireHandler.setContextClassLoader(this.initializersLoader);
        }
        this.misfireHandler.initialize();
        this.schedulerRunning = true;
        getLog().debug("JobStore background threads started (as scheduler was started).");
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerPaused() {
        this.schedulerRunning = false;
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerResumed() {
        this.schedulerRunning = true;
    }

    @Override // org.quartz.spi.JobStore
    public void shutdown() {
        this.shutdown = true;
        if (this.misfireHandler != null) {
            this.misfireHandler.shutdown();
            try {
                this.misfireHandler.join();
            } catch (InterruptedException e) {
            }
        }
        if (this.clusterManagementThread != null) {
            this.clusterManagementThread.shutdown();
            try {
                this.clusterManagementThread.join();
            } catch (InterruptedException e2) {
            }
        }
        try {
            DBConnectionManager.getInstance().shutdown(getDataSource());
        } catch (SQLException sqle) {
            getLog().warn("Database connection shutdown unsuccessful.", (Throwable) sqle);
        }
        getLog().debug("JobStore background threads shutdown.");
    }

    @Override // org.quartz.spi.JobStore
    public boolean supportsPersistence() {
        return true;
    }

    protected Connection getAttributeRestoringConnection(Connection conn) {
        return (Connection) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Connection.class}, new AttributeRestoringConnectionInvocationHandler(conn));
    }

    protected Connection getConnection() throws JobPersistenceException {
        try {
            Connection conn = DBConnectionManager.getInstance().getConnection(getDataSource());
            if (conn == null) {
                throw new JobPersistenceException("Could not get connection from DataSource '" + getDataSource() + "'");
            }
            Connection conn2 = getAttributeRestoringConnection(conn);
            try {
                if (!isDontSetAutoCommitFalse()) {
                    conn2.setAutoCommit(false);
                }
                if (isTxIsolationLevelSerializable()) {
                    conn2.setTransactionIsolation(8);
                }
            } catch (SQLException sqle) {
                getLog().warn("Failed to override connection auto commit/transaction isolation.", (Throwable) sqle);
            } catch (Throwable e) {
                try {
                    conn2.close();
                } catch (Throwable th) {
                }
                throw new JobPersistenceException("Failure setting up connection.", e);
            }
            return conn2;
        } catch (SQLException sqle2) {
            throw new JobPersistenceException("Failed to obtain DB connection from data source '" + getDataSource() + "': " + sqle2.toString(), sqle2);
        } catch (Throwable e2) {
            throw new JobPersistenceException("Failed to obtain DB connection from data source '" + getDataSource() + "': " + e2.toString(), e2);
        }
    }

    protected void releaseLock(String lockName, boolean doIt) {
        if (doIt) {
            try {
                getLockHandler().releaseLock(lockName);
            } catch (LockException le) {
                getLog().error("Error returning lock: " + le.getMessage(), (Throwable) le);
            }
        }
    }

    protected void recoverJobs() throws JobPersistenceException {
        executeInNonManagedTXLock(LOCK_TRIGGER_ACCESS, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.1
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                JobStoreSupport.this.recoverJobs(conn);
            }
        }, null);
    }

    protected void recoverJobs(Connection conn) throws JobPersistenceException {
        try {
            getLog().info("Freed " + (getDelegate().updateTriggerStatesFromOtherStates(conn, Constants.STATE_WAITING, Constants.STATE_ACQUIRED, Constants.STATE_BLOCKED) + getDelegate().updateTriggerStatesFromOtherStates(conn, Constants.STATE_PAUSED, Constants.STATE_PAUSED_BLOCKED, Constants.STATE_PAUSED_BLOCKED)) + " triggers from 'acquired' / 'blocked' state.");
            recoverMisfiredJobs(conn, true);
            List<OperableTrigger> recoveringJobTriggers = getDelegate().selectTriggersForRecoveringJobs(conn);
            getLog().info("Recovering " + recoveringJobTriggers.size() + " jobs that were in-progress at the time of the last shut-down.");
            for (OperableTrigger recoveringJobTrigger : recoveringJobTriggers) {
                if (jobExists(conn, recoveringJobTrigger.getJobKey())) {
                    recoveringJobTrigger.computeFirstFireTime(null);
                    storeTrigger(conn, recoveringJobTrigger, null, false, Constants.STATE_WAITING, false, true);
                }
            }
            getLog().info("Recovery complete.");
            List<TriggerKey> cts = getDelegate().selectTriggersInState(conn, Constants.STATE_COMPLETE);
            for (TriggerKey ct : cts) {
                removeTrigger(conn, ct);
            }
            getLog().info("Removed " + cts.size() + " 'complete' triggers.");
            getLog().info("Removed " + getDelegate().deleteFiredTriggers(conn) + " stale fired job entries.");
        } catch (JobPersistenceException e) {
            throw e;
        } catch (Exception e2) {
            throw new JobPersistenceException("Couldn't recover jobs: " + e2.getMessage(), e2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v9, types: [long] */
    protected long getMisfireTime() {
        char currentTimeMillis = System.currentTimeMillis();
        if (getMisfireThreshold() > 0) {
            currentTimeMillis -= getMisfireThreshold();
        }
        if (currentTimeMillis > 0) {
            return currentTimeMillis;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/JobStoreSupport$RecoverMisfiredJobsResult.class */
    public static class RecoverMisfiredJobsResult {
        public static final RecoverMisfiredJobsResult NO_OP = new RecoverMisfiredJobsResult(false, 0, LongCompanionObject.MAX_VALUE);
        private boolean _hasMoreMisfiredTriggers;
        private int _processedMisfiredTriggerCount;
        private long _earliestNewTime;

        public RecoverMisfiredJobsResult(boolean hasMoreMisfiredTriggers, int processedMisfiredTriggerCount, long earliestNewTime) {
            this._hasMoreMisfiredTriggers = hasMoreMisfiredTriggers;
            this._processedMisfiredTriggerCount = processedMisfiredTriggerCount;
            this._earliestNewTime = earliestNewTime;
        }

        public boolean hasMoreMisfiredTriggers() {
            return this._hasMoreMisfiredTriggers;
        }

        public int getProcessedMisfiredTriggerCount() {
            return this._processedMisfiredTriggerCount;
        }

        public long getEarliestNewTime() {
            return this._earliestNewTime;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x00b0 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x00b0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [long] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected org.quartz.impl.jdbcjobstore.JobStoreSupport.RecoverMisfiredJobsResult recoverMisfiredJobs(java.sql.Connection r9, boolean r10) throws org.quartz.JobPersistenceException, java.sql.SQLException {
        /*
        // Method dump skipped, instructions count: 286
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.jdbcjobstore.JobStoreSupport.recoverMisfiredJobs(java.sql.Connection, boolean):org.quartz.impl.jdbcjobstore.JobStoreSupport$RecoverMisfiredJobsResult");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v15, types: [long] */
    protected boolean updateMisfiredTrigger(Connection conn, TriggerKey triggerKey, String newStateIfNotComplete, boolean forceState) throws JobPersistenceException {
        try {
            OperableTrigger trig = retrieveTrigger(conn, triggerKey);
            char currentTimeMillis = System.currentTimeMillis();
            if (getMisfireThreshold() > 0) {
                currentTimeMillis -= getMisfireThreshold();
            }
            if (trig.getNextFireTime().getTime() > currentTimeMillis) {
                return false;
            }
            doUpdateOfMisfiredTrigger(conn, trig, forceState, newStateIfNotComplete, false);
            return true;
        } catch (Exception e) {
            throw new JobPersistenceException("Couldn't update misfired trigger '" + triggerKey + "': " + e.getMessage(), e);
        }
    }

    private void doUpdateOfMisfiredTrigger(Connection conn, OperableTrigger trig, boolean forceState, String newStateIfNotComplete, boolean recovering) throws JobPersistenceException {
        Calendar cal = null;
        if (trig.getCalendarName() != null) {
            cal = retrieveCalendar(conn, trig.getCalendarName());
        }
        this.schedSignaler.notifyTriggerListenersMisfired(trig);
        trig.updateAfterMisfire(cal);
        if (trig.getNextFireTime() == null) {
            storeTrigger(conn, trig, null, true, Constants.STATE_COMPLETE, forceState, recovering);
            this.schedSignaler.notifySchedulerListenersFinalized(trig);
            return;
        }
        storeTrigger(conn, trig, null, true, newStateIfNotComplete, forceState, recovering);
    }

    @Override // org.quartz.spi.JobStore
    public void storeJobAndTrigger(final JobDetail newJob, final OperableTrigger newTrigger) throws JobPersistenceException {
        executeInLock(isLockOnInsert() ? LOCK_TRIGGER_ACCESS : null, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.2
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                JobStoreSupport.this.storeJob(conn, newJob, false);
                JobStoreSupport.this.storeTrigger(conn, newTrigger, newJob, false, Constants.STATE_WAITING, false, false);
            }
        });
    }

    @Override // org.quartz.spi.JobStore
    public void storeJob(final JobDetail newJob, final boolean replaceExisting) throws JobPersistenceException {
        executeInLock((isLockOnInsert() || replaceExisting) ? LOCK_TRIGGER_ACCESS : null, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.3
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                JobStoreSupport.this.storeJob(conn, newJob, replaceExisting);
            }
        });
    }

    protected void storeJob(Connection conn, JobDetail newJob, boolean replaceExisting) throws JobPersistenceException {
        try {
            if (!jobExists(conn, newJob.getKey())) {
                getDelegate().insertJobDetail(conn, newJob);
            } else if (!replaceExisting) {
                throw new ObjectAlreadyExistsException(newJob);
            } else {
                getDelegate().updateJobDetail(conn, newJob);
            }
        } catch (IOException e) {
            throw new JobPersistenceException("Couldn't store job: " + e.getMessage(), e);
        } catch (SQLException e2) {
            throw new JobPersistenceException("Couldn't store job: " + e2.getMessage(), e2);
        }
    }

    protected boolean jobExists(Connection conn, JobKey jobKey) throws JobPersistenceException {
        try {
            return getDelegate().jobExists(conn, jobKey);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't determine job existence (" + jobKey + "): " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void storeTrigger(final OperableTrigger newTrigger, final boolean replaceExisting) throws JobPersistenceException {
        executeInLock((isLockOnInsert() || replaceExisting) ? LOCK_TRIGGER_ACCESS : null, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.4
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                JobStoreSupport.this.storeTrigger(conn, newTrigger, null, replaceExisting, Constants.STATE_WAITING, false, false);
            }
        });
    }

    protected void storeTrigger(Connection conn, OperableTrigger newTrigger, JobDetail job, boolean replaceExisting, String state, boolean forceState, boolean recovering) throws JobPersistenceException {
        boolean existingTrigger = triggerExists(conn, newTrigger.getKey());
        if (!existingTrigger || replaceExisting) {
            if (!forceState) {
                try {
                    boolean shouldBepaused = getDelegate().isTriggerGroupPaused(conn, newTrigger.getKey().getGroup());
                    if (!shouldBepaused) {
                        shouldBepaused = getDelegate().isTriggerGroupPaused(conn, Constants.ALL_GROUPS_PAUSED);
                        if (shouldBepaused) {
                            getDelegate().insertPausedTriggerGroup(conn, newTrigger.getKey().getGroup());
                        }
                    }
                    if (shouldBepaused && (state.equals(Constants.STATE_WAITING) || state.equals(Constants.STATE_ACQUIRED))) {
                        state = Constants.STATE_PAUSED;
                    }
                } catch (Exception e) {
                    throw new JobPersistenceException("Couldn't store trigger '" + newTrigger.getKey() + "' for '" + newTrigger.getJobKey() + "' job:" + e.getMessage(), e);
                }
            }
            if (job == null) {
                job = retrieveJob(conn, newTrigger.getJobKey());
            }
            if (job == null) {
                throw new JobPersistenceException("The job (" + newTrigger.getJobKey() + ") referenced by the trigger does not exist.");
            }
            if (job.isConcurrentExectionDisallowed() && !recovering) {
                state = checkBlockedState(conn, job.getKey(), state);
            }
            if (existingTrigger) {
                getDelegate().updateTrigger(conn, newTrigger, state, job);
            } else {
                getDelegate().insertTrigger(conn, newTrigger, state, job);
            }
            return;
        }
        throw new ObjectAlreadyExistsException(newTrigger);
    }

    protected boolean triggerExists(Connection conn, TriggerKey key) throws JobPersistenceException {
        try {
            return getDelegate().triggerExists(conn, key);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't determine trigger existence (" + key + "): " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeJob(final JobKey jobKey) throws JobPersistenceException {
        return ((Boolean) executeInLock(LOCK_TRIGGER_ACCESS, new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.5
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.removeJob(conn, jobKey) ? Boolean.TRUE : Boolean.FALSE;
            }
        })).booleanValue();
    }

    protected boolean removeJob(Connection conn, JobKey jobKey) throws JobPersistenceException {
        try {
            for (TriggerKey jobTrigger : getDelegate().selectTriggerKeysForJob(conn, jobKey)) {
                deleteTriggerAndChildren(conn, jobTrigger);
            }
            return deleteJobAndChildren(conn, jobKey);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't remove job: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeJobs(final List<JobKey> jobKeys) throws JobPersistenceException {
        return ((Boolean) executeInLock(LOCK_TRIGGER_ACCESS, new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.6
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                boolean allFound = true;
                for (JobKey jobKey : jobKeys) {
                    allFound = JobStoreSupport.this.removeJob(conn, jobKey) && allFound;
                }
                return allFound ? Boolean.TRUE : Boolean.FALSE;
            }
        })).booleanValue();
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeTriggers(final List<TriggerKey> triggerKeys) throws JobPersistenceException {
        return ((Boolean) executeInLock(LOCK_TRIGGER_ACCESS, new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.7
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                boolean allFound = true;
                for (TriggerKey triggerKey : triggerKeys) {
                    allFound = JobStoreSupport.this.removeTrigger(conn, triggerKey) && allFound;
                }
                return allFound ? Boolean.TRUE : Boolean.FALSE;
            }
        })).booleanValue();
    }

    @Override // org.quartz.spi.JobStore
    public void storeJobsAndTriggers(final Map<JobDetail, Set<? extends Trigger>> triggersAndJobs, final boolean replace) throws JobPersistenceException {
        executeInLock((isLockOnInsert() || replace) ? LOCK_TRIGGER_ACCESS : null, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.8
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                for (JobDetail job : triggersAndJobs.keySet()) {
                    JobStoreSupport.this.storeJob(conn, job, replace);
                    for (Trigger trigger : (Set) triggersAndJobs.get(job)) {
                        JobStoreSupport.this.storeTrigger(conn, (OperableTrigger) trigger, job, replace, Constants.STATE_WAITING, false, false);
                    }
                }
            }
        });
    }

    private boolean deleteJobAndChildren(Connection conn, JobKey key) throws NoSuchDelegateException, SQLException {
        return getDelegate().deleteJobDetail(conn, key) > 0;
    }

    private boolean deleteTriggerAndChildren(Connection conn, TriggerKey key) throws SQLException, NoSuchDelegateException {
        return getDelegate().deleteTrigger(conn, key) > 0;
    }

    @Override // org.quartz.spi.JobStore
    public JobDetail retrieveJob(final JobKey jobKey) throws JobPersistenceException {
        return (JobDetail) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.9
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.retrieveJob(conn, jobKey);
            }
        });
    }

    protected JobDetail retrieveJob(Connection conn, JobKey key) throws JobPersistenceException {
        try {
            return getDelegate().selectJobDetail(conn, key, getClassLoadHelper());
        } catch (IOException e) {
            throw new JobPersistenceException("Couldn't retrieve job because the BLOB couldn't be deserialized: " + e.getMessage(), e);
        } catch (ClassNotFoundException e2) {
            throw new JobPersistenceException("Couldn't retrieve job because a required class was not found: " + e2.getMessage(), e2);
        } catch (SQLException e3) {
            throw new JobPersistenceException("Couldn't retrieve job: " + e3.getMessage(), e3);
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeTrigger(final TriggerKey triggerKey) throws JobPersistenceException {
        return ((Boolean) executeInLock(LOCK_TRIGGER_ACCESS, new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.10
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.removeTrigger(conn, triggerKey) ? Boolean.TRUE : Boolean.FALSE;
            }
        })).booleanValue();
    }

    protected boolean removeTrigger(Connection conn, TriggerKey key) throws JobPersistenceException {
        try {
            JobDetail job = getDelegate().selectJobForTrigger(conn, getClassLoadHelper(), key, false);
            boolean removedTrigger = deleteTriggerAndChildren(conn, key);
            if (null != job && !job.isDurable() && getDelegate().selectNumTriggersForJob(conn, job.getKey()) == 0) {
                deleteJobAndChildren(conn, job.getKey());
            }
            return removedTrigger;
        } catch (ClassNotFoundException e) {
            throw new JobPersistenceException("Couldn't remove trigger: " + e.getMessage(), e);
        } catch (SQLException e2) {
            throw new JobPersistenceException("Couldn't remove trigger: " + e2.getMessage(), e2);
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean replaceTrigger(final TriggerKey triggerKey, final OperableTrigger newTrigger) throws JobPersistenceException {
        return ((Boolean) executeInLock(LOCK_TRIGGER_ACCESS, new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.11
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.replaceTrigger(conn, triggerKey, newTrigger) ? Boolean.TRUE : Boolean.FALSE;
            }
        })).booleanValue();
    }

    protected boolean replaceTrigger(Connection conn, TriggerKey key, OperableTrigger newTrigger) throws JobPersistenceException {
        try {
            JobDetail job = getDelegate().selectJobForTrigger(conn, getClassLoadHelper(), key);
            if (job == null) {
                return false;
            }
            if (!newTrigger.getJobKey().equals(job.getKey())) {
                throw new JobPersistenceException("New trigger is not related to the same job as the old trigger.");
            }
            boolean removedTrigger = deleteTriggerAndChildren(conn, key);
            storeTrigger(conn, newTrigger, job, false, Constants.STATE_WAITING, false, false);
            return removedTrigger;
        } catch (ClassNotFoundException e) {
            throw new JobPersistenceException("Couldn't remove trigger: " + e.getMessage(), e);
        } catch (SQLException e2) {
            throw new JobPersistenceException("Couldn't remove trigger: " + e2.getMessage(), e2);
        }
    }

    @Override // org.quartz.spi.JobStore
    public OperableTrigger retrieveTrigger(final TriggerKey triggerKey) throws JobPersistenceException {
        return (OperableTrigger) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.12
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.retrieveTrigger(conn, triggerKey);
            }
        });
    }

    protected OperableTrigger retrieveTrigger(Connection conn, TriggerKey key) throws JobPersistenceException {
        try {
            return getDelegate().selectTrigger(conn, key);
        } catch (Exception e) {
            throw new JobPersistenceException("Couldn't retrieve trigger: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Trigger.TriggerState getTriggerState(final TriggerKey triggerKey) throws JobPersistenceException {
        return (Trigger.TriggerState) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.13
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.getTriggerState(conn, triggerKey);
            }
        });
    }

    public Trigger.TriggerState getTriggerState(Connection conn, TriggerKey key) throws JobPersistenceException {
        try {
            String ts = getDelegate().selectTriggerState(conn, key);
            if (ts == null) {
                return Trigger.TriggerState.NONE;
            }
            if (ts.equals(Constants.STATE_DELETED)) {
                return Trigger.TriggerState.NONE;
            }
            if (ts.equals(Constants.STATE_COMPLETE)) {
                return Trigger.TriggerState.COMPLETE;
            }
            if (ts.equals(Constants.STATE_PAUSED)) {
                return Trigger.TriggerState.PAUSED;
            }
            if (ts.equals(Constants.STATE_PAUSED_BLOCKED)) {
                return Trigger.TriggerState.PAUSED;
            }
            if (ts.equals(Constants.STATE_ERROR)) {
                return Trigger.TriggerState.ERROR;
            }
            if (ts.equals(Constants.STATE_BLOCKED)) {
                return Trigger.TriggerState.BLOCKED;
            }
            return Trigger.TriggerState.NORMAL;
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't determine state of trigger (" + key + "): " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void resetTriggerFromErrorState(final TriggerKey triggerKey) throws JobPersistenceException {
        executeInLock(LOCK_TRIGGER_ACCESS, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.14
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                JobStoreSupport.this.resetTriggerFromErrorState(conn, triggerKey);
            }
        });
    }

    void resetTriggerFromErrorState(Connection conn, TriggerKey triggerKey) throws JobPersistenceException {
        try {
            String newState = Constants.STATE_WAITING;
            if (getDelegate().isTriggerGroupPaused(conn, triggerKey.getGroup())) {
                newState = Constants.STATE_PAUSED;
            }
            getDelegate().updateTriggerStateFromOtherState(conn, triggerKey, newState, Constants.STATE_ERROR);
            getLog().info("Trigger " + triggerKey + " reset from ERROR state to: " + newState);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't reset from error state of trigger (" + triggerKey + "): " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void storeCalendar(final String calName, final Calendar calendar, final boolean replaceExisting, final boolean updateTriggers) throws JobPersistenceException {
        executeInLock((isLockOnInsert() || updateTriggers) ? LOCK_TRIGGER_ACCESS : null, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.15
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                JobStoreSupport.this.storeCalendar(conn, calName, calendar, replaceExisting, updateTriggers);
            }
        });
    }

    protected void storeCalendar(Connection conn, String calName, Calendar calendar, boolean replaceExisting, boolean updateTriggers) throws JobPersistenceException {
        try {
            boolean existingCal = calendarExists(conn, calName);
            if (!existingCal || replaceExisting) {
                if (existingCal) {
                    if (getDelegate().updateCalendar(conn, calName, calendar) < 1) {
                        throw new JobPersistenceException("Couldn't store calendar.  Update failed.");
                    } else if (updateTriggers) {
                        for (OperableTrigger trigger : getDelegate().selectTriggersForCalendar(conn, calName)) {
                            trigger.updateWithNewCalendar(calendar, getMisfireThreshold());
                            storeTrigger(conn, trigger, null, true, Constants.STATE_WAITING, false, false);
                        }
                    }
                } else if (getDelegate().insertCalendar(conn, calName, calendar) < 1) {
                    throw new JobPersistenceException("Couldn't store calendar.  Insert failed.");
                }
                if (!this.isClustered) {
                    this.calendarCache.put(calName, calendar);
                }
                return;
            }
            throw new ObjectAlreadyExistsException("Calendar with name '" + calName + "' already exists.");
        } catch (IOException e) {
            throw new JobPersistenceException("Couldn't store calendar because the BLOB couldn't be serialized: " + e.getMessage(), e);
        } catch (ClassNotFoundException e2) {
            throw new JobPersistenceException("Couldn't store calendar: " + e2.getMessage(), e2);
        } catch (SQLException e3) {
            throw new JobPersistenceException("Couldn't store calendar: " + e3.getMessage(), e3);
        }
    }

    protected boolean calendarExists(Connection conn, String calName) throws JobPersistenceException {
        try {
            return getDelegate().calendarExists(conn, calName);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't determine calendar existence (" + calName + "): " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeCalendar(final String calName) throws JobPersistenceException {
        return ((Boolean) executeInLock(LOCK_TRIGGER_ACCESS, new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.16
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.removeCalendar(conn, calName) ? Boolean.TRUE : Boolean.FALSE;
            }
        })).booleanValue();
    }

    protected boolean removeCalendar(Connection conn, String calName) throws JobPersistenceException {
        try {
            if (getDelegate().calendarIsReferenced(conn, calName)) {
                throw new JobPersistenceException("Calender cannot be removed if it referenced by a trigger!");
            }
            if (!this.isClustered) {
                this.calendarCache.remove(calName);
            }
            return getDelegate().deleteCalendar(conn, calName) > 0;
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't remove calendar: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Calendar retrieveCalendar(final String calName) throws JobPersistenceException {
        return (Calendar) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.17
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.retrieveCalendar(conn, calName);
            }
        });
    }

    protected Calendar retrieveCalendar(Connection conn, String calName) throws JobPersistenceException {
        Calendar cal = this.isClustered ? null : this.calendarCache.get(calName);
        if (cal != null) {
            return cal;
        }
        try {
            Calendar cal2 = getDelegate().selectCalendar(conn, calName);
            if (!this.isClustered) {
                this.calendarCache.put(calName, cal2);
            }
            return cal2;
        } catch (IOException e) {
            throw new JobPersistenceException("Couldn't retrieve calendar because the BLOB couldn't be deserialized: " + e.getMessage(), e);
        } catch (ClassNotFoundException e2) {
            throw new JobPersistenceException("Couldn't retrieve calendar because a required class was not found: " + e2.getMessage(), e2);
        } catch (SQLException e3) {
            throw new JobPersistenceException("Couldn't retrieve calendar: " + e3.getMessage(), e3);
        }
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfJobs() throws JobPersistenceException {
        return ((Integer) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.18
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return Integer.valueOf(JobStoreSupport.this.getNumberOfJobs(conn));
            }
        })).intValue();
    }

    protected int getNumberOfJobs(Connection conn) throws JobPersistenceException {
        try {
            return getDelegate().selectNumJobs(conn);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't obtain number of jobs: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfTriggers() throws JobPersistenceException {
        return ((Integer) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.19
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return Integer.valueOf(JobStoreSupport.this.getNumberOfTriggers(conn));
            }
        })).intValue();
    }

    protected int getNumberOfTriggers(Connection conn) throws JobPersistenceException {
        try {
            return getDelegate().selectNumTriggers(conn);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't obtain number of triggers: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfCalendars() throws JobPersistenceException {
        return ((Integer) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.20
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return Integer.valueOf(JobStoreSupport.this.getNumberOfCalendars(conn));
            }
        })).intValue();
    }

    protected int getNumberOfCalendars(Connection conn) throws JobPersistenceException {
        try {
            return getDelegate().selectNumCalendars(conn);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't obtain number of calendars: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Set<JobKey> getJobKeys(final GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        return (Set) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.21
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.getJobNames(conn, matcher);
            }
        });
    }

    protected Set<JobKey> getJobNames(Connection conn, GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        try {
            return getDelegate().selectJobsInGroup(conn, matcher);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't obtain job names: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean checkExists(final JobKey jobKey) throws JobPersistenceException {
        return ((Boolean) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.22
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return Boolean.valueOf(JobStoreSupport.this.checkExists(conn, jobKey));
            }
        })).booleanValue();
    }

    protected boolean checkExists(Connection conn, JobKey jobKey) throws JobPersistenceException {
        try {
            return getDelegate().jobExists(conn, jobKey);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't check for existence of job: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean checkExists(final TriggerKey triggerKey) throws JobPersistenceException {
        return ((Boolean) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.23
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return Boolean.valueOf(JobStoreSupport.this.checkExists(conn, triggerKey));
            }
        })).booleanValue();
    }

    protected boolean checkExists(Connection conn, TriggerKey triggerKey) throws JobPersistenceException {
        try {
            return getDelegate().triggerExists(conn, triggerKey);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't check for existence of job: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void clearAllSchedulingData() throws JobPersistenceException {
        executeInLock(LOCK_TRIGGER_ACCESS, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.24
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                JobStoreSupport.this.clearAllSchedulingData(conn);
            }
        });
    }

    protected void clearAllSchedulingData(Connection conn) throws JobPersistenceException {
        try {
            getDelegate().clearData(conn);
        } catch (SQLException e) {
            throw new JobPersistenceException("Error clearing scheduling data: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Set<TriggerKey> getTriggerKeys(final GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        return (Set) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.25
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.getTriggerNames(conn, matcher);
            }
        });
    }

    protected Set<TriggerKey> getTriggerNames(Connection conn, GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        try {
            return getDelegate().selectTriggersInGroup(conn, matcher);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't obtain trigger names: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getJobGroupNames() throws JobPersistenceException {
        return (List) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.26
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.getJobGroupNames(conn);
            }
        });
    }

    protected List<String> getJobGroupNames(Connection conn) throws JobPersistenceException {
        try {
            return getDelegate().selectJobGroups(conn);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't obtain job groups: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getTriggerGroupNames() throws JobPersistenceException {
        return (List) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.27
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.getTriggerGroupNames(conn);
            }
        });
    }

    protected List<String> getTriggerGroupNames(Connection conn) throws JobPersistenceException {
        try {
            return getDelegate().selectTriggerGroups(conn);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't obtain trigger groups: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getCalendarNames() throws JobPersistenceException {
        return (List) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.28
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.getCalendarNames(conn);
            }
        });
    }

    protected List<String> getCalendarNames(Connection conn) throws JobPersistenceException {
        try {
            return getDelegate().selectCalendars(conn);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't obtain trigger groups: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<OperableTrigger> getTriggersForJob(final JobKey jobKey) throws JobPersistenceException {
        return (List) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.29
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.getTriggersForJob(conn, jobKey);
            }
        });
    }

    protected List<OperableTrigger> getTriggersForJob(Connection conn, JobKey key) throws JobPersistenceException {
        try {
            return getDelegate().selectTriggersForJob(conn, key);
        } catch (Exception e) {
            throw new JobPersistenceException("Couldn't obtain triggers for job: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void pauseTrigger(final TriggerKey triggerKey) throws JobPersistenceException {
        executeInLock(LOCK_TRIGGER_ACCESS, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.30
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                JobStoreSupport.this.pauseTrigger(conn, triggerKey);
            }
        });
    }

    public void pauseTrigger(Connection conn, TriggerKey triggerKey) throws JobPersistenceException {
        try {
            String oldState = getDelegate().selectTriggerState(conn, triggerKey);
            if (oldState.equals(Constants.STATE_WAITING) || oldState.equals(Constants.STATE_ACQUIRED)) {
                getDelegate().updateTriggerState(conn, triggerKey, Constants.STATE_PAUSED);
            } else if (oldState.equals(Constants.STATE_BLOCKED)) {
                getDelegate().updateTriggerState(conn, triggerKey, Constants.STATE_PAUSED_BLOCKED);
            }
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't pause trigger '" + triggerKey + "': " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void pauseJob(final JobKey jobKey) throws JobPersistenceException {
        executeInLock(LOCK_TRIGGER_ACCESS, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.31
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                for (OperableTrigger trigger : JobStoreSupport.this.getTriggersForJob(conn, jobKey)) {
                    JobStoreSupport.this.pauseTrigger(conn, trigger.getKey());
                }
            }
        });
    }

    @Override // org.quartz.spi.JobStore
    public Set<String> pauseJobs(final GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        return (Set) executeInLock(LOCK_TRIGGER_ACCESS, new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.32
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Set<String> execute(Connection conn) throws JobPersistenceException {
                Set<String> groupNames = new HashSet<>();
                for (JobKey jobKey : JobStoreSupport.this.getJobNames(conn, matcher)) {
                    for (OperableTrigger trigger : JobStoreSupport.this.getTriggersForJob(conn, jobKey)) {
                        JobStoreSupport.this.pauseTrigger(conn, trigger.getKey());
                    }
                    groupNames.add(jobKey.getGroup());
                }
                return groupNames;
            }
        });
    }

    protected String checkBlockedState(Connection conn, JobKey jobKey, String currentState) throws JobPersistenceException {
        if (!currentState.equals(Constants.STATE_WAITING) && !currentState.equals(Constants.STATE_PAUSED)) {
            return currentState;
        }
        try {
            List<FiredTriggerRecord> lst = getDelegate().selectFiredTriggerRecordsByJob(conn, jobKey.getName(), jobKey.getGroup());
            if (lst.size() <= 0 || !lst.get(0).isJobDisallowsConcurrentExecution()) {
                return currentState;
            }
            return Constants.STATE_PAUSED.equals(currentState) ? Constants.STATE_PAUSED_BLOCKED : Constants.STATE_BLOCKED;
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't determine if trigger should be in a blocked state '" + jobKey + "': " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void resumeTrigger(final TriggerKey triggerKey) throws JobPersistenceException {
        executeInLock(LOCK_TRIGGER_ACCESS, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.33
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                JobStoreSupport.this.resumeTrigger(conn, triggerKey);
            }
        });
    }

    public void resumeTrigger(Connection conn, TriggerKey key) throws JobPersistenceException {
        try {
            TriggerStatus status = getDelegate().selectTriggerStatus(conn, key);
            if (status != null && status.getNextFireTime() != null) {
                boolean blocked = false;
                if (Constants.STATE_PAUSED_BLOCKED.equals(status.getStatus())) {
                    blocked = true;
                }
                String newState = checkBlockedState(conn, status.getJobKey(), Constants.STATE_WAITING);
                boolean misfired = false;
                if (this.schedulerRunning && status.getNextFireTime().before(new Date())) {
                    misfired = updateMisfiredTrigger(conn, key, newState, true);
                }
                if (!misfired) {
                    if (blocked) {
                        getDelegate().updateTriggerStateFromOtherState(conn, key, newState, Constants.STATE_PAUSED_BLOCKED);
                    } else {
                        getDelegate().updateTriggerStateFromOtherState(conn, key, newState, Constants.STATE_PAUSED);
                    }
                }
            }
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't resume trigger '" + key + "': " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void resumeJob(final JobKey jobKey) throws JobPersistenceException {
        executeInLock(LOCK_TRIGGER_ACCESS, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.34
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                for (OperableTrigger trigger : JobStoreSupport.this.getTriggersForJob(conn, jobKey)) {
                    JobStoreSupport.this.resumeTrigger(conn, trigger.getKey());
                }
            }
        });
    }

    @Override // org.quartz.spi.JobStore
    public Set<String> resumeJobs(final GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        return (Set) executeInLock(LOCK_TRIGGER_ACCESS, new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.35
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Set<String> execute(Connection conn) throws JobPersistenceException {
                Set<JobKey> jobKeys = JobStoreSupport.this.getJobNames(conn, matcher);
                Set<String> groupNames = new HashSet<>();
                for (JobKey jobKey : jobKeys) {
                    for (OperableTrigger trigger : JobStoreSupport.this.getTriggersForJob(conn, jobKey)) {
                        JobStoreSupport.this.resumeTrigger(conn, trigger.getKey());
                    }
                    groupNames.add(jobKey.getGroup());
                }
                return groupNames;
            }
        });
    }

    @Override // org.quartz.spi.JobStore
    public Set<String> pauseTriggers(final GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        return (Set) executeInLock(LOCK_TRIGGER_ACCESS, new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.36
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Set<String> execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.pauseTriggerGroup(conn, matcher);
            }
        });
    }

    public Set<String> pauseTriggerGroup(Connection conn, GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        try {
            getDelegate().updateTriggerGroupStateFromOtherStates(conn, matcher, Constants.STATE_PAUSED, Constants.STATE_ACQUIRED, Constants.STATE_WAITING, Constants.STATE_WAITING);
            getDelegate().updateTriggerGroupStateFromOtherState(conn, matcher, Constants.STATE_PAUSED_BLOCKED, Constants.STATE_BLOCKED);
            List<String> groups = getDelegate().selectTriggerGroups(conn, matcher);
            if (matcher.getCompareWithOperator().equals(StringMatcher.StringOperatorName.EQUALS) && !groups.contains(matcher.getCompareToValue())) {
                groups.add(matcher.getCompareToValue());
            }
            for (String group : groups) {
                if (!getDelegate().isTriggerGroupPaused(conn, group)) {
                    getDelegate().insertPausedTriggerGroup(conn, group);
                }
            }
            return new HashSet(groups);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't pause trigger group '" + matcher + "': " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Set<String> getPausedTriggerGroups() throws JobPersistenceException {
        return (Set) executeWithoutLock(new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.37
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Object execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.getPausedTriggerGroups(conn);
            }
        });
    }

    public Set<String> getPausedTriggerGroups(Connection conn) throws JobPersistenceException {
        try {
            return getDelegate().selectPausedTriggerGroups(conn);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't determine paused trigger groups: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public Set<String> resumeTriggers(final GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        return (Set) executeInLock(LOCK_TRIGGER_ACCESS, new TransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.38
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public Set<String> execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.resumeTriggerGroup(conn, matcher);
            }
        });
    }

    public Set<String> resumeTriggerGroup(Connection conn, GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        try {
            getDelegate().deletePausedTriggerGroup(conn, matcher);
            HashSet<String> groups = new HashSet<>();
            for (TriggerKey key : getDelegate().selectTriggersInGroup(conn, matcher)) {
                resumeTrigger(conn, key);
                groups.add(key.getGroup());
            }
            return groups;
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't pause trigger group '" + matcher + "': " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void pauseAll() throws JobPersistenceException {
        executeInLock(LOCK_TRIGGER_ACCESS, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.39
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                JobStoreSupport.this.pauseAll(conn);
            }
        });
    }

    public void pauseAll(Connection conn) throws JobPersistenceException {
        for (String name : getTriggerGroupNames(conn)) {
            pauseTriggerGroup(conn, GroupMatcher.triggerGroupEquals(name));
        }
        try {
            if (!getDelegate().isTriggerGroupPaused(conn, Constants.ALL_GROUPS_PAUSED)) {
                getDelegate().insertPausedTriggerGroup(conn, Constants.ALL_GROUPS_PAUSED);
            }
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't pause all trigger groups: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void resumeAll() throws JobPersistenceException {
        executeInLock(LOCK_TRIGGER_ACCESS, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.40
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                JobStoreSupport.this.resumeAll(conn);
            }
        });
    }

    public void resumeAll(Connection conn) throws JobPersistenceException {
        for (String name : getTriggerGroupNames(conn)) {
            resumeTriggerGroup(conn, GroupMatcher.triggerGroupEquals(name));
        }
        try {
            getDelegate().deletePausedTriggerGroup(conn, Constants.ALL_GROUPS_PAUSED);
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't resume all trigger groups: " + e.getMessage(), e);
        }
    }

    protected synchronized String getFiredTriggerRecordId() {
        StringBuilder append = new StringBuilder().append(getInstanceId());
        long j = ftrCtr;
        ftrCtr = j + 1;
        return append.append(j).toString();
    }

    @Override // org.quartz.spi.JobStore
    public List<OperableTrigger> acquireNextTriggers(final long noLaterThan, final int maxCount, final long timeWindow) throws JobPersistenceException {
        String lockName;
        if (isAcquireTriggersWithinLock() || maxCount > 1) {
            lockName = LOCK_TRIGGER_ACCESS;
        } else {
            lockName = null;
        }
        return (List) executeInNonManagedTXLock(lockName, new TransactionCallback<List<OperableTrigger>>() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.41
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public List<OperableTrigger> execute(Connection conn) throws JobPersistenceException {
                return JobStoreSupport.this.acquireNextTrigger(conn, noLaterThan, maxCount, timeWindow);
            }
        }, new TransactionValidator<List<OperableTrigger>>() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.42
            public Boolean validate(Connection conn, List<OperableTrigger> result) throws JobPersistenceException {
                try {
                    List<FiredTriggerRecord> acquired = JobStoreSupport.this.getDelegate().selectInstancesFiredTriggerRecords(conn, JobStoreSupport.this.getInstanceId());
                    Set<String> fireInstanceIds = new HashSet<>();
                    for (FiredTriggerRecord ft : acquired) {
                        fireInstanceIds.add(ft.getFireInstanceId());
                    }
                    for (OperableTrigger tr : result) {
                        if (fireInstanceIds.contains(tr.getFireInstanceId())) {
                            return true;
                        }
                    }
                    return false;
                } catch (SQLException e) {
                    throw new JobPersistenceException("error validating trigger acquisition", e);
                }
            }
        });
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:24:0x00bd
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    protected java.util.List<org.quartz.spi.OperableTrigger> acquireNextTrigger(java.sql.Connection r9, long r10, int r12, long r13) throws org.quartz.JobPersistenceException {
        /*
        // Method dump skipped, instructions count: 446
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.jdbcjobstore.JobStoreSupport.acquireNextTrigger(java.sql.Connection, long, int, long):java.util.List");
    }

    @Override // org.quartz.spi.JobStore
    public void releaseAcquiredTrigger(final OperableTrigger trigger) {
        retryExecuteInNonManagedTXLock(LOCK_TRIGGER_ACCESS, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.43
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                JobStoreSupport.this.releaseAcquiredTrigger(conn, trigger);
            }
        });
    }

    protected void releaseAcquiredTrigger(Connection conn, OperableTrigger trigger) throws JobPersistenceException {
        try {
            getDelegate().updateTriggerStateFromOtherState(conn, trigger.getKey(), Constants.STATE_WAITING, Constants.STATE_ACQUIRED);
            getDelegate().updateTriggerStateFromOtherState(conn, trigger.getKey(), Constants.STATE_WAITING, Constants.STATE_BLOCKED);
            getDelegate().deleteFiredTrigger(conn, trigger.getFireInstanceId());
        } catch (SQLException e) {
            throw new JobPersistenceException("Couldn't release acquired trigger: " + e.getMessage(), e);
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<TriggerFiredResult> triggersFired(final List<OperableTrigger> triggers) throws JobPersistenceException {
        return (List) executeInNonManagedTXLock(LOCK_TRIGGER_ACCESS, new TransactionCallback<List<TriggerFiredResult>>() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.44
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
            public List<TriggerFiredResult> execute(Connection conn) throws JobPersistenceException {
                TriggerFiredResult result;
                List<TriggerFiredResult> results = new ArrayList<>();
                for (OperableTrigger trigger : triggers) {
                    try {
                        result = new TriggerFiredResult(JobStoreSupport.this.triggerFired(conn, trigger));
                    } catch (RuntimeException re) {
                        result = new TriggerFiredResult(re);
                    } catch (JobPersistenceException jpe) {
                        result = new TriggerFiredResult(jpe);
                    }
                    results.add(result);
                }
                return results;
            }
        }, new TransactionValidator<List<TriggerFiredResult>>() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.45
            public Boolean validate(Connection conn, List<TriggerFiredResult> result) throws JobPersistenceException {
                try {
                    List<FiredTriggerRecord> acquired = JobStoreSupport.this.getDelegate().selectInstancesFiredTriggerRecords(conn, JobStoreSupport.this.getInstanceId());
                    Set<String> executingTriggers = new HashSet<>();
                    for (FiredTriggerRecord ft : acquired) {
                        if (Constants.STATE_EXECUTING.equals(ft.getFireInstanceState())) {
                            executingTriggers.add(ft.getFireInstanceId());
                        }
                    }
                    for (TriggerFiredResult tr : result) {
                        if (tr.getTriggerFiredBundle() != null && executingTriggers.contains(tr.getTriggerFiredBundle().getTrigger().getFireInstanceId())) {
                            return true;
                        }
                    }
                    return false;
                } catch (SQLException e) {
                    throw new JobPersistenceException("error validating trigger acquisition", e);
                }
            }
        });
    }

    protected TriggerFiredBundle triggerFired(Connection conn, OperableTrigger trigger) throws JobPersistenceException {
        Calendar cal = null;
        try {
            if (!getDelegate().selectTriggerState(conn, trigger.getKey()).equals(Constants.STATE_ACQUIRED)) {
                return null;
            }
            try {
                JobDetail job = retrieveJob(conn, trigger.getJobKey());
                if (job == null) {
                    return null;
                }
                if (trigger.getCalendarName() != null) {
                    cal = retrieveCalendar(conn, trigger.getCalendarName());
                    if (cal == null) {
                        return null;
                    }
                }
                try {
                    getDelegate().updateFiredTrigger(conn, trigger, Constants.STATE_EXECUTING, job);
                    Date prevFireTime = trigger.getPreviousFireTime();
                    trigger.triggered(cal);
                    String state = Constants.STATE_WAITING;
                    boolean force = true;
                    if (job.isConcurrentExectionDisallowed()) {
                        state = Constants.STATE_BLOCKED;
                        force = false;
                        try {
                            getDelegate().updateTriggerStatesForJobFromOtherState(conn, job.getKey(), Constants.STATE_BLOCKED, Constants.STATE_WAITING);
                            getDelegate().updateTriggerStatesForJobFromOtherState(conn, job.getKey(), Constants.STATE_BLOCKED, Constants.STATE_ACQUIRED);
                            getDelegate().updateTriggerStatesForJobFromOtherState(conn, job.getKey(), Constants.STATE_PAUSED_BLOCKED, Constants.STATE_PAUSED);
                        } catch (SQLException e) {
                            throw new JobPersistenceException("Couldn't update states of blocked triggers: " + e.getMessage(), e);
                        }
                    }
                    if (trigger.getNextFireTime() == null) {
                        state = Constants.STATE_COMPLETE;
                        force = true;
                    }
                    storeTrigger(conn, trigger, job, true, state, force, false);
                    job.getJobDataMap().clearDirtyFlag();
                    return new TriggerFiredBundle(job, trigger, cal, trigger.getKey().getGroup().equals(Scheduler.DEFAULT_RECOVERY_GROUP), new Date(), trigger.getPreviousFireTime(), prevFireTime, trigger.getNextFireTime());
                } catch (SQLException e2) {
                    throw new JobPersistenceException("Couldn't insert fired trigger: " + e2.getMessage(), e2);
                }
            } catch (JobPersistenceException jpe) {
                try {
                    getLog().error("Error retrieving job, setting trigger state to ERROR.", (Throwable) jpe);
                    getDelegate().updateTriggerState(conn, trigger.getKey(), Constants.STATE_ERROR);
                } catch (SQLException sqle) {
                    getLog().error("Unable to set trigger state to ERROR.", (Throwable) sqle);
                }
                throw jpe;
            }
        } catch (SQLException e3) {
            throw new JobPersistenceException("Couldn't select trigger state: " + e3.getMessage(), e3);
        }
    }

    @Override // org.quartz.spi.JobStore
    public void triggeredJobComplete(final OperableTrigger trigger, final JobDetail jobDetail, final Trigger.CompletedExecutionInstruction triggerInstCode) {
        retryExecuteInNonManagedTXLock(LOCK_TRIGGER_ACCESS, new VoidTransactionCallback() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.46
            @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.VoidTransactionCallback
            public void executeVoid(Connection conn) throws JobPersistenceException {
                JobStoreSupport.this.triggeredJobComplete(conn, trigger, jobDetail, triggerInstCode);
            }
        });
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:34:0x018a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    protected void triggeredJobComplete(java.sql.Connection r7, org.quartz.spi.OperableTrigger r8, org.quartz.JobDetail r9, org.quartz.Trigger.CompletedExecutionInstruction r10) throws org.quartz.JobPersistenceException {
        /*
        // Method dump skipped, instructions count: 562
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.jdbcjobstore.JobStoreSupport.triggeredJobComplete(java.sql.Connection, org.quartz.spi.OperableTrigger, org.quartz.JobDetail, org.quartz.Trigger$CompletedExecutionInstruction):void");
    }

    protected DriverDelegate getDelegate() throws NoSuchDelegateException {
        DriverDelegate driverDelegate;
        synchronized (this) {
            if (null == this.delegate) {
                try {
                    try {
                        if (this.delegateClassName != null) {
                            this.delegateClass = getClassLoadHelper().loadClass(this.delegateClassName, DriverDelegate.class);
                        }
                        this.delegate = (DriverDelegate) this.delegateClass.newInstance();
                        this.delegate.initialize(getLog(), this.tablePrefix, this.instanceName, this.instanceId, getClassLoadHelper(), canUseProperties(), getDriverDelegateInitString());
                    } catch (IllegalAccessException e) {
                        throw new NoSuchDelegateException("Couldn't create delegate: " + e.getMessage(), e);
                    }
                } catch (ClassNotFoundException e2) {
                    throw new NoSuchDelegateException("Couldn't load delegate class: " + e2.getMessage(), e2);
                } catch (InstantiationException e3) {
                    throw new NoSuchDelegateException("Couldn't create delegate: " + e3.getMessage(), e3);
                }
            }
            driverDelegate = this.delegate;
        }
        return driverDelegate;
    }

    protected Semaphore getLockHandler() {
        return this.lockHandler;
    }

    public void setLockHandler(Semaphore lockHandler) {
        this.lockHandler = lockHandler;
    }

    protected RecoverMisfiredJobsResult doRecoverMisfires() throws JobPersistenceException {
        boolean transOwner;
        Connection conn;
        try {
            transOwner = false;
            conn = getNonManagedTXConnection();
            try {
                try {
                    RecoverMisfiredJobsResult result = RecoverMisfiredJobsResult.NO_OP;
                    if ((getDoubleCheckLockMisfireHandler() ? getDelegate().countMisfiredTriggersInState(conn, Constants.STATE_WAITING, getMisfireTime()) : Integer.MAX_VALUE) == 0) {
                        getLog().debug("Found 0 triggers that missed their scheduled fire-time.");
                    } else {
                        transOwner = getLockHandler().obtainLock(conn, LOCK_TRIGGER_ACCESS);
                        result = recoverMisfiredJobs(conn, false);
                    }
                    commitConnection(conn);
                    try {
                        releaseLock(LOCK_TRIGGER_ACCESS, transOwner);
                        cleanupConnection(conn);
                        return result;
                    } catch (Throwable th) {
                        cleanupConnection(conn);
                        throw th;
                    }
                } catch (RuntimeException e) {
                    rollbackConnection(conn);
                    throw new JobPersistenceException("Unexpected runtime exception: " + e.getMessage(), e);
                }
            } catch (SQLException e2) {
                rollbackConnection(conn);
                throw new JobPersistenceException("Database error recovering from misfires.", e2);
            } catch (JobPersistenceException e3) {
                rollbackConnection(conn);
                throw e3;
            }
        } catch (Throwable th2) {
            try {
                releaseLock(LOCK_TRIGGER_ACCESS, transOwner);
                cleanupConnection(conn);
                throw th2;
            } catch (Throwable th3) {
                cleanupConnection(conn);
                throw th3;
            }
        }
    }

    protected void signalSchedulingChangeOnTxCompletion(long candidateNewNextFireTime) {
        Long sigTime = this.sigChangeForTxCompletion.get();
        if (sigTime == null && candidateNewNextFireTime >= 0) {
            this.sigChangeForTxCompletion.set(Long.valueOf(candidateNewNextFireTime));
        } else if (sigTime == null || candidateNewNextFireTime < sigTime.longValue()) {
            this.sigChangeForTxCompletion.set(Long.valueOf(candidateNewNextFireTime));
        }
    }

    protected Long clearAndGetSignalSchedulingChangeOnTxCompletion() {
        Long t = this.sigChangeForTxCompletion.get();
        this.sigChangeForTxCompletion.set(null);
        return t;
    }

    protected void signalSchedulingChangeImmediately(long candidateNewNextFireTime) {
        this.schedSignaler.signalSchedulingChange(candidateNewNextFireTime);
    }

    protected boolean doCheckin() throws JobPersistenceException {
        boolean transOwner = false;
        boolean transStateOwner = false;
        boolean recovered = false;
        Connection conn = getNonManagedTXConnection();
        try {
            try {
                List<SchedulerStateRecord> failedRecords = null;
                if (!this.firstCheckIn) {
                    failedRecords = clusterCheckIn(conn);
                    commitConnection(conn);
                }
                if (this.firstCheckIn || failedRecords.size() > 0) {
                    getLockHandler().obtainLock(conn, LOCK_STATE_ACCESS);
                    transStateOwner = true;
                    List<SchedulerStateRecord> failedRecords2 = this.firstCheckIn ? clusterCheckIn(conn) : findFailedInstances(conn);
                    if (failedRecords2.size() > 0) {
                        getLockHandler().obtainLock(conn, LOCK_TRIGGER_ACCESS);
                        transOwner = true;
                        clusterRecover(conn, failedRecords2);
                        recovered = true;
                    }
                }
                commitConnection(conn);
                try {
                    releaseLock(LOCK_TRIGGER_ACCESS, transOwner);
                    try {
                        releaseLock(LOCK_STATE_ACCESS, transStateOwner);
                        cleanupConnection(conn);
                        this.firstCheckIn = false;
                        return recovered;
                    } catch (Throwable th) {
                        cleanupConnection(conn);
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        releaseLock(LOCK_STATE_ACCESS, transStateOwner);
                        cleanupConnection(conn);
                        throw th2;
                    } catch (Throwable th3) {
                        cleanupConnection(conn);
                        throw th3;
                    }
                }
            } catch (JobPersistenceException e) {
                rollbackConnection(conn);
                throw e;
            }
        } catch (Throwable th4) {
            try {
                releaseLock(LOCK_TRIGGER_ACCESS, transOwner);
                try {
                    releaseLock(LOCK_STATE_ACCESS, transStateOwner);
                    cleanupConnection(conn);
                    throw th4;
                } catch (Throwable th5) {
                    cleanupConnection(conn);
                    throw th5;
                }
            } catch (Throwable th6) {
                try {
                    releaseLock(LOCK_STATE_ACCESS, transStateOwner);
                    cleanupConnection(conn);
                    throw th6;
                } catch (Throwable th7) {
                    cleanupConnection(conn);
                    throw th7;
                }
            }
        }
    }

    protected List<SchedulerStateRecord> findFailedInstances(Connection conn) throws JobPersistenceException {
        try {
            List<SchedulerStateRecord> failedInstances = new LinkedList<>();
            boolean foundThisScheduler = false;
            long timeNow = System.currentTimeMillis();
            List<SchedulerStateRecord> states = getDelegate().selectSchedulerStateRecords(conn, null);
            for (SchedulerStateRecord rec : states) {
                if (rec.getSchedulerInstanceId().equals(getInstanceId())) {
                    foundThisScheduler = true;
                    if (this.firstCheckIn) {
                        failedInstances.add(rec);
                    }
                } else if (calcFailedIfAfter(rec) < timeNow) {
                    failedInstances.add(rec);
                }
            }
            if (this.firstCheckIn) {
                failedInstances.addAll(findOrphanedFailedInstances(conn, states));
            }
            if (!foundThisScheduler && !this.firstCheckIn) {
                getLog().warn("This scheduler instance (" + getInstanceId() + ") is still active but was recovered by another instance in the cluster.  This may cause inconsistent behavior.");
            }
            return failedInstances;
        } catch (Exception e) {
            this.lastCheckin = System.currentTimeMillis();
            throw new JobPersistenceException("Failure identifying failed instances when checking-in: " + e.getMessage(), e);
        }
    }

    private List<SchedulerStateRecord> findOrphanedFailedInstances(Connection conn, List<SchedulerStateRecord> schedulerStateRecords) throws SQLException, NoSuchDelegateException {
        List<SchedulerStateRecord> orphanedInstances = new ArrayList<>();
        Set<String> allFiredTriggerInstanceNames = getDelegate().selectFiredTriggerInstanceNames(conn);
        if (!allFiredTriggerInstanceNames.isEmpty()) {
            for (SchedulerStateRecord rec : schedulerStateRecords) {
                allFiredTriggerInstanceNames.remove(rec.getSchedulerInstanceId());
            }
            for (String inst : allFiredTriggerInstanceNames) {
                SchedulerStateRecord orphanedInstance = new SchedulerStateRecord();
                orphanedInstance.setSchedulerInstanceId(inst);
                orphanedInstances.add(orphanedInstance);
                getLog().warn("Found orphaned fired triggers for instance: " + orphanedInstance.getSchedulerInstanceId());
            }
        }
        return orphanedInstances;
    }

    protected long calcFailedIfAfter(SchedulerStateRecord rec) {
        return rec.getCheckinTimestamp() + Math.max(rec.getCheckinInterval(), System.currentTimeMillis() - this.lastCheckin) + 7500;
    }

    protected List<SchedulerStateRecord> clusterCheckIn(Connection conn) throws JobPersistenceException {
        List<SchedulerStateRecord> failedInstances = findFailedInstances(conn);
        try {
            this.lastCheckin = System.currentTimeMillis();
            if (getDelegate().updateSchedulerState(conn, getInstanceId(), this.lastCheckin) == 0) {
                getDelegate().insertSchedulerState(conn, getInstanceId(), this.lastCheckin, getClusterCheckinInterval());
            }
            return failedInstances;
        } catch (Exception e) {
            throw new JobPersistenceException("Failure updating scheduler state when checking-in: " + e.getMessage(), e);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.StringBuilder, long] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void clusterRecover(java.sql.Connection r11, java.util.List<org.quartz.impl.jdbcjobstore.SchedulerStateRecord> r12) throws org.quartz.JobPersistenceException {
        /*
        // Method dump skipped, instructions count: 958
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.jdbcjobstore.JobStoreSupport.clusterRecover(java.sql.Connection, java.util.List):void");
    }

    protected void logWarnIfNonZero(int val, String warning) {
        if (val > 0) {
            getLog().info(warning);
        } else {
            getLog().debug(warning);
        }
    }

    protected void cleanupConnection(Connection conn) {
        if (conn != null) {
            if (conn instanceof Proxy) {
                InvocationHandler invocationHandler = Proxy.getInvocationHandler((Proxy) conn);
                if (invocationHandler instanceof AttributeRestoringConnectionInvocationHandler) {
                    AttributeRestoringConnectionInvocationHandler connHandler = (AttributeRestoringConnectionInvocationHandler) invocationHandler;
                    connHandler.restoreOriginalAtributes();
                    closeConnection(connHandler.getWrappedConnection());
                    return;
                }
            }
            closeConnection(conn);
        }
    }

    protected void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                getLog().error("Failed to close Connection", (Throwable) e);
            } catch (Throwable e2) {
                getLog().error("Unexpected exception closing Connection.  This is often due to a Connection being returned after or during shutdown.", e2);
            }
        }
    }

    protected void rollbackConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                getLog().error("Couldn't rollback jdbc connection. " + e.getMessage(), (Throwable) e);
            }
        }
    }

    protected void commitConnection(Connection conn) throws JobPersistenceException {
        if (conn != null) {
            try {
                conn.commit();
            } catch (SQLException e) {
                throw new JobPersistenceException("Couldn't commit jdbc connection. " + e.getMessage(), e);
            }
        }
    }

    /* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/JobStoreSupport$VoidTransactionCallback.class */
    protected abstract class VoidTransactionCallback implements TransactionCallback<Void> {
        abstract void executeVoid(Connection connection) throws JobPersistenceException;

        protected VoidTransactionCallback() {
        }

        @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
        public final Void execute(Connection conn) throws JobPersistenceException {
            executeVoid(conn);
            return null;
        }
    }

    public <T> T executeWithoutLock(TransactionCallback<T> txCallback) throws JobPersistenceException {
        return (T) executeInLock(null, txCallback);
    }

    protected <T> T retryExecuteInNonManagedTXLock(String lockName, TransactionCallback<T> txCallback) {
        int retry = 1;
        while (!this.shutdown) {
            try {
                return (T) executeInNonManagedTXLock(lockName, txCallback, null);
            } catch (RuntimeException e) {
                getLog().error("retryExecuteInNonManagedTXLock: RuntimeException " + e.getMessage(), (Throwable) e);
                try {
                    Thread.sleep(getDbRetryInterval());
                    retry++;
                } catch (InterruptedException e2) {
                    throw new IllegalStateException("Received interrupted exception", e2);
                }
            } catch (JobPersistenceException jpe) {
                if (retry % 4 == 0) {
                    this.schedSignaler.notifySchedulerListenersError("An error occurred while " + txCallback, jpe);
                }
                Thread.sleep(getDbRetryInterval());
                retry++;
            }
        }
        throw new IllegalStateException("JobStore is shutdown - aborting retry");
    }

    protected <T> T executeInNonManagedTXLock(String lockName, TransactionCallback<T> txCallback, final TransactionValidator<T> txValidator) throws JobPersistenceException {
        boolean transOwner;
        Connection conn;
        try {
            transOwner = false;
            conn = null;
            if (lockName != null) {
                try {
                    try {
                        if (getLockHandler().requiresConnection()) {
                            conn = getNonManagedTXConnection();
                        }
                        transOwner = getLockHandler().obtainLock(conn, lockName);
                    } catch (JobPersistenceException e) {
                        rollbackConnection(conn);
                        throw e;
                    }
                } catch (RuntimeException e2) {
                    rollbackConnection(conn);
                    throw new JobPersistenceException("Unexpected runtime exception: " + e2.getMessage(), e2);
                }
            }
            if (conn == null) {
                conn = getNonManagedTXConnection();
            }
            final T result = txCallback.execute(conn);
            try {
                commitConnection(conn);
            } catch (JobPersistenceException e3) {
                rollbackConnection(conn);
                if (txValidator == null || !((Boolean) retryExecuteInNonManagedTXLock(lockName, new TransactionCallback<Boolean>() { // from class: org.quartz.impl.jdbcjobstore.JobStoreSupport.47
                    @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport.TransactionCallback
                    public Boolean execute(Connection conn2) throws JobPersistenceException {
                        return txValidator.validate(conn2, result);
                    }
                })).booleanValue()) {
                    throw e3;
                }
            }
            Long sigTime = clearAndGetSignalSchedulingChangeOnTxCompletion();
            if (sigTime != null && sigTime.longValue() >= 0) {
                signalSchedulingChangeImmediately(sigTime.longValue());
            }
            try {
                releaseLock(lockName, transOwner);
                cleanupConnection(conn);
                return result;
            } catch (Throwable th) {
                cleanupConnection(conn);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                releaseLock(lockName, transOwner);
                cleanupConnection(conn);
                throw th2;
            } catch (Throwable th3) {
                cleanupConnection(conn);
                throw th3;
            }
        }
    }

    /* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/JobStoreSupport$ClusterManager.class */
    class ClusterManager extends Thread {
        private volatile boolean shutdown = false;
        private int numFails = 0;

        ClusterManager() {
            setPriority(7);
            setName("QuartzScheduler_" + JobStoreSupport.this.instanceName + "-" + JobStoreSupport.this.instanceId + "_ClusterManager");
            setDaemon(JobStoreSupport.this.getMakeThreadsDaemons());
        }

        public void initialize() {
            manage();
            JobStoreSupport.this.getThreadExecutor().execute(this);
        }

        public void shutdown() {
            this.shutdown = true;
            interrupt();
        }

        private boolean manage() {
            boolean res = false;
            try {
                res = JobStoreSupport.this.doCheckin();
                this.numFails = 0;
                JobStoreSupport.this.getLog().debug("ClusterManager: Check-in complete.");
            } catch (Exception e) {
                if (this.numFails % 4 == 0) {
                    JobStoreSupport.this.getLog().error("ClusterManager: Error managing cluster: " + e.getMessage(), (Throwable) e);
                }
                this.numFails++;
            }
            return res;
        }

        /* JADX WARN: Type inference failed for: r0v16, types: [long] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.shutdown) {
                if (!this.shutdown) {
                    char clusterCheckinInterval = JobStoreSupport.this.getClusterCheckinInterval() - (System.currentTimeMillis() - JobStoreSupport.this.lastCheckin);
                    int i = ((clusterCheckinInterval == 1 ? 1 : 0) > 0 ? 1 : ((clusterCheckinInterval == 1 ? 1 : 0) == 0 ? 0 : -1));
                    char c = clusterCheckinInterval;
                    if (i <= 0) {
                        c = 'd';
                    }
                    long timeToSleep = c;
                    if (this.numFails > 0) {
                        timeToSleep = Math.max(JobStoreSupport.this.getDbRetryInterval(), (long) c);
                    }
                    try {
                        Thread.sleep(timeToSleep == 1 ? 1 : 0);
                    } catch (Exception e) {
                    }
                }
                if (!this.shutdown && manage()) {
                    JobStoreSupport.this.signalSchedulingChangeImmediately(0);
                }
            }
        }
    }

    /* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/JobStoreSupport$MisfireHandler.class */
    class MisfireHandler extends Thread {
        private volatile boolean shutdown = false;
        private int numFails = 0;

        MisfireHandler() {
            setName("QuartzScheduler_" + JobStoreSupport.this.instanceName + "-" + JobStoreSupport.this.instanceId + "_MisfireHandler");
            setDaemon(JobStoreSupport.this.getMakeThreadsDaemons());
        }

        public void initialize() {
            JobStoreSupport.this.getThreadExecutor().execute(this);
        }

        public void shutdown() {
            this.shutdown = true;
            interrupt();
        }

        private RecoverMisfiredJobsResult manage() {
            try {
                JobStoreSupport.this.getLog().debug("MisfireHandler: scanning for misfires...");
                RecoverMisfiredJobsResult res = JobStoreSupport.this.doRecoverMisfires();
                this.numFails = 0;
                return res;
            } catch (Exception e) {
                if (this.numFails % 4 == 0) {
                    JobStoreSupport.this.getLog().error("MisfireHandler: Error handling misfires: " + e.getMessage(), (Throwable) e);
                }
                this.numFails++;
                return RecoverMisfiredJobsResult.NO_OP;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r11v3, types: [long] */
        /* JADX WARN: Type inference failed for: r11v5 */
        /* JADX WARN: Type inference failed for: r11v7 */
        /* JADX WARN: Type inference failed for: r11v8 */
        /* JADX WARN: Type inference failed for: r11v9 */
        /* JADX WARNING: Unknown variable types count: 2 */
        @Override // java.lang.Thread, java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
            L_0x0000:
                r0 = r7
                boolean r0 = r0.shutdown
                if (r0 != 0) goto L_0x0072
                long r0 = java.lang.System.currentTimeMillis()
                r8 = r0
                r0 = r7
                org.quartz.impl.jdbcjobstore.JobStoreSupport$RecoverMisfiredJobsResult r0 = r0.manage()
                r10 = r0
                r0 = r10
                int r0 = r0.getProcessedMisfiredTriggerCount()
                if (r0 <= 0) goto L_0x0022
                r0 = r7
                org.quartz.impl.jdbcjobstore.JobStoreSupport r0 = org.quartz.impl.jdbcjobstore.JobStoreSupport.this
                r1 = r10
                long r1 = r1.getEarliestNewTime()
                r0.signalSchedulingChangeImmediately(r1)
            L_0x0022:
                r0 = r7
                boolean r0 = r0.shutdown
                if (r0 != 0) goto L_0x006f
                r0 = 50
                r11 = r0
                r0 = r10
                boolean r0 = r0.hasMoreMisfiredTriggers()
                if (r0 != 0) goto L_0x0065
                r0 = r7
                org.quartz.impl.jdbcjobstore.JobStoreSupport r0 = org.quartz.impl.jdbcjobstore.JobStoreSupport.this
                long r0 = r0.getMisfireThreshold()
                long r1 = java.lang.System.currentTimeMillis()
                r2 = r8
                long r1 = r1 - r2
                long r0 = r0 - r1
                r11 = r0
                r0 = r11
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L_0x0050
                r0 = 50
                r11 = r0
            L_0x0050:
                r0 = r7
                int r0 = r0.numFails
                if (r0 <= 0) goto L_0x0065
                r0 = r7
                org.quartz.impl.jdbcjobstore.JobStoreSupport r0 = org.quartz.impl.jdbcjobstore.JobStoreSupport.this
                long r0 = r0.getDbRetryInterval()
                r1 = r11
                long r0 = java.lang.Math.max(r0, r1)
                r11 = r0
            L_0x0065:
                r0 = r11
                java.lang.Thread.sleep(r0)     // Catch: Exception -> 0x006d
                goto L_0x006f
            L_0x006d:
                r13 = move-exception
            L_0x006f:
                goto L_0x0000
            L_0x0072:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.jdbcjobstore.JobStoreSupport.MisfireHandler.run():void");
        }
    }
}
