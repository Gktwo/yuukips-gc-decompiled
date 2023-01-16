package com.mchange.p009v2.resourcepool;

import com.mchange.p009v2.async.AsynchronousRunner;
import com.mchange.p009v2.async.RunnableQueue;
import com.mchange.p009v2.cfg.MConfig;
import com.mchange.p009v2.lang.ThreadUtils;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.resourcepool.ResourcePool;
import com.mchange.p009v2.util.ResourceClosedException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.WeakHashMap;
import kotlin.jvm.internal.LongCompanionObject;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v2.resourcepool.BasicResourcePool */
/* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/BasicResourcePool.class */
public class BasicResourcePool implements ResourcePool {
    private static final MLogger logger;
    static final int AUTO_CULL_FREQUENCY_DIVISOR = 4;
    static final int AUTO_MAX_CULL_FREQUENCY = 900000;
    static final int AUTO_MIN_CULL_FREQUENCY = 1000;
    static final String USE_SCATTERED_ACQUIRE_TASK_KEY = "com.mchange.v2.resourcepool.experimental.useScatteredAcquireTask";
    static final boolean USE_SCATTERED_ACQUIRE_TASK;
    final ResourcePool.Manager mgr;
    final int start;
    final int min;
    final int max;
    final int inc;
    final int num_acq_attempts;
    final int acq_attempt_delay;
    final long check_idle_resources_delay;
    final long max_resource_age;
    final long max_idle_time;
    final long excess_max_idle_time;
    final long destroy_unreturned_resc_time;
    final long expiration_enforcement_delay;
    final boolean break_on_acquisition_failure;
    final boolean debug_store_checkout_exceptions;
    final boolean force_synchronous_checkins;
    final BasicResourcePoolFactory factory;
    final AsynchronousRunner taskRunner;
    final RunnableQueue asyncEventQueue;
    final ResourcePoolEventSupport rpes;
    Timer cullAndIdleRefurbishTimer;
    TimerTask cullTask;
    TimerTask idleRefurbishTask;
    int pending_acquires;
    int pending_removes;
    int target_pool_size;
    Object exampleResource;
    private static final int NO_DECREMENT = 0;
    private static final int DECREMENT_ON_SUCCESS = 1;
    private static final int DECREMENT_WITH_CERTAINTY = 2;
    static final /* synthetic */ boolean $assertionsDisabled;
    final long pool_start_time = System.currentTimeMillis();
    HashSet acquireWaiters = new HashSet();
    HashSet otherWaiters = new HashSet();
    HashMap managed = new HashMap();
    LinkedList unused = new LinkedList();
    HashSet excluded = new HashSet();
    Map formerResources = new WeakHashMap();
    Set idleCheckResources = new HashSet();
    boolean force_kill_acquires = false;
    boolean broken = false;
    long failed_checkins = 0;
    long failed_checkouts = 0;
    long failed_idle_tests = 0;
    Throwable lastCheckinFailure = null;
    Throwable lastCheckoutFailure = null;
    Throwable lastIdleTestFailure = null;
    Throwable lastResourceTestFailure = null;
    Throwable lastAcquisitionFailiure = null;

    static {
        $assertionsDisabled = !BasicResourcePool.class.desiredAssertionStatus();
        logger = MLog.getLogger(BasicResourcePool.class);
        String checkScattered = MConfig.readVmConfig().getProperty(USE_SCATTERED_ACQUIRE_TASK_KEY);
        if (checkScattered == null || !checkScattered.trim().toLowerCase().equals("false")) {
            USE_SCATTERED_ACQUIRE_TASK = true;
            return;
        }
        USE_SCATTERED_ACQUIRE_TASK = false;
        if (logger.isLoggable(MLevel.INFO)) {
            logger.info(BasicResourcePool.class.getName() + " using traditional, Thread-blocking AcquireTask. Yuk. Why? It's no longer supported.");
        }
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public long getStartTime() {
        return this.pool_start_time;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public long getUpTime() {
        return System.currentTimeMillis() - this.pool_start_time;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized long getNumFailedCheckins() {
        return this.failed_checkins;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized long getNumFailedCheckouts() {
        return this.failed_checkouts;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized long getNumFailedIdleTests() {
        return this.failed_idle_tests;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized Throwable getLastCheckinFailure() {
        return this.lastCheckinFailure;
    }

    private void setLastCheckinFailure(Throwable t) {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            this.lastCheckinFailure = t;
            this.lastResourceTestFailure = t;
            return;
        }
        throw new AssertionError();
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized Throwable getLastCheckoutFailure() {
        return this.lastCheckoutFailure;
    }

    private void setLastCheckoutFailure(Throwable t) {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            this.lastCheckoutFailure = t;
            this.lastResourceTestFailure = t;
            return;
        }
        throw new AssertionError();
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized Throwable getLastIdleCheckFailure() {
        return this.lastIdleTestFailure;
    }

    /* access modifiers changed from: private */
    public void setLastIdleCheckFailure(Throwable t) {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            this.lastIdleTestFailure = t;
            this.lastResourceTestFailure = t;
            return;
        }
        throw new AssertionError();
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized Throwable getLastResourceTestFailure() {
        return this.lastResourceTestFailure;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized Throwable getLastAcquisitionFailure() {
        return this.lastAcquisitionFailiure;
    }

    /* access modifiers changed from: private */
    public synchronized void setLastAcquisitionFailure(Throwable t) {
        this.lastAcquisitionFailiure = t;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized int getNumCheckoutWaiters() {
        return this.acquireWaiters.size();
    }

    public synchronized int getNumPendingAcquireTasks() {
        return this.pending_acquires;
    }

    public synchronized int getNumPendingRemoveTasks() {
        return this.pending_removes;
    }

    public synchronized int getNumThreadsWaitingForResources() {
        return this.acquireWaiters.size();
    }

    public synchronized String[] getThreadNamesWaitingForResources() {
        String[] out = new String[this.acquireWaiters.size()];
        int i = 0;
        Iterator ii = this.acquireWaiters.iterator();
        while (ii.hasNext()) {
            i++;
            out[i] = ((Thread) ii.next()).getName();
        }
        Arrays.sort(out);
        return out;
    }

    public synchronized int getNumThreadsWaitingForAdministrativeTasks() {
        return this.otherWaiters.size();
    }

    public synchronized String[] getThreadNamesWaitingForAdministrativeTasks() {
        String[] out = new String[this.otherWaiters.size()];
        int i = 0;
        Iterator ii = this.otherWaiters.iterator();
        while (ii.hasNext()) {
            i++;
            out[i] = ((Thread) ii.next()).getName();
        }
        Arrays.sort(out);
        return out;
    }

    private void addToFormerResources(Object resc) {
        this.formerResources.put(resc, null);
    }

    private boolean isFormerResource(Object resc) {
        return this.formerResources.keySet().contains(resc);
    }

    public BasicResourcePool(ResourcePool.Manager mgr, int start, int min, int max, int inc, int num_acq_attempts, int acq_attempt_delay, long check_idle_resources_delay, long max_resource_age, long max_idle_time, long excess_max_idle_time, long destroy_unreturned_resc_time, long expiration_enforcement_delay, boolean break_on_acquisition_failure, boolean debug_store_checkout_exceptions, boolean force_synchronous_checkins, AsynchronousRunner taskRunner, RunnableQueue asyncEventQueue, Timer cullAndIdleRefurbishTimer, BasicResourcePoolFactory factory) throws ResourcePoolException {
        if (min > max) {
            try {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, "Bad pool size config, min " + min + " > max " + max + ". Using " + max + " as min.");
                }
                min = max;
            } catch (Exception e) {
                throw ResourcePoolUtils.convertThrowable(e);
            }
        }
        if (start < min) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Bad pool size config, start " + start + " < min " + min + ". Using " + min + " as start.");
            }
            start = min;
        }
        if (start > max) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Bad pool size config, start " + start + " > max " + max + ". Using " + max + " as start.");
            }
            start = max;
        }
        this.mgr = mgr;
        this.start = start;
        this.min = min;
        this.max = max;
        this.inc = inc;
        this.num_acq_attempts = num_acq_attempts;
        this.acq_attempt_delay = acq_attempt_delay;
        this.check_idle_resources_delay = check_idle_resources_delay;
        this.max_resource_age = max_resource_age;
        this.max_idle_time = max_idle_time;
        this.excess_max_idle_time = excess_max_idle_time;
        this.destroy_unreturned_resc_time = destroy_unreturned_resc_time;
        this.break_on_acquisition_failure = break_on_acquisition_failure;
        this.debug_store_checkout_exceptions = debug_store_checkout_exceptions && destroy_unreturned_resc_time > 0;
        this.force_synchronous_checkins = force_synchronous_checkins;
        this.taskRunner = taskRunner;
        this.asyncEventQueue = asyncEventQueue;
        this.cullAndIdleRefurbishTimer = cullAndIdleRefurbishTimer;
        this.factory = factory;
        this.pending_acquires = 0;
        this.pending_removes = 0;
        this.target_pool_size = this.start;
        if (asyncEventQueue != null) {
            this.rpes = new ResourcePoolEventSupport(this);
        } else {
            this.rpes = null;
        }
        ensureStartResources();
        if (mustEnforceExpiration()) {
            if (expiration_enforcement_delay <= 0) {
                this.expiration_enforcement_delay = automaticExpirationEnforcementDelay();
            } else {
                this.expiration_enforcement_delay = expiration_enforcement_delay;
            }
            this.cullTask = new CullTask();
            cullAndIdleRefurbishTimer.schedule(this.cullTask, minExpirationTime(), this.expiration_enforcement_delay);
        } else {
            this.expiration_enforcement_delay = expiration_enforcement_delay;
        }
        if (check_idle_resources_delay > 0) {
            this.idleRefurbishTask = new CheckIdleResourcesTask();
            cullAndIdleRefurbishTimer.schedule(this.idleRefurbishTask, check_idle_resources_delay, check_idle_resources_delay);
        }
        if (logger.isLoggable(MLevel.FINER)) {
            logger.finer(this + " config: [start -> " + this.start + "; min -> " + this.min + "; max -> " + this.max + "; inc -> " + this.inc + "; num_acq_attempts -> " + this.num_acq_attempts + "; acq_attempt_delay -> " + this.acq_attempt_delay + "; check_idle_resources_delay -> " + this.check_idle_resources_delay + "; max_resource_age -> " + this.max_resource_age + "; max_idle_time -> " + this.max_idle_time + "; excess_max_idle_time -> " + this.excess_max_idle_time + "; destroy_unreturned_resc_time -> " + this.destroy_unreturned_resc_time + "; expiration_enforcement_delay -> " + this.expiration_enforcement_delay + "; break_on_acquisition_failure -> " + this.break_on_acquisition_failure + "; debug_store_checkout_exceptions -> " + this.debug_store_checkout_exceptions + "; force_synchronous_checkins -> " + this.force_synchronous_checkins + "]");
        }
    }

    private boolean mustTestIdleResources() {
        return this.check_idle_resources_delay > 0;
    }

    private boolean mustEnforceExpiration() {
        return this.max_resource_age > 0 || this.max_idle_time > 0 || this.excess_max_idle_time > 0 || this.destroy_unreturned_resc_time > 0;
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [long] */
    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    private long minExpirationTime() {
        char c = 65535;
        if (this.max_resource_age > 0) {
            c = Math.min((long) LongCompanionObject.MAX_VALUE, this.max_resource_age);
        }
        if (this.max_idle_time > 0) {
            c = Math.min((long) c, this.max_idle_time);
        }
        if (this.excess_max_idle_time > 0) {
            c = Math.min((long) c, this.excess_max_idle_time);
        }
        if (this.destroy_unreturned_resc_time > 0) {
            c = Math.min((long) c, this.destroy_unreturned_resc_time);
        }
        return c;
    }

    private long automaticExpirationEnforcementDelay() {
        return Math.max(Math.min(minExpirationTime() / 4, 900000L), 1000L);
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public long getEffectiveExpirationEnforcementDelay() {
        return this.expiration_enforcement_delay;
    }

    private synchronized boolean isBroken() {
        return this.broken;
    }

    private boolean supportsEvents() {
        return this.asyncEventQueue != null;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public Object checkoutResource() throws ResourcePoolException, InterruptedException {
        try {
            return checkoutResource(0);
        } catch (TimeoutException e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Huh??? TimeoutException with no timeout set!!!", (Throwable) e);
            }
            throw new ResourcePoolException("Huh??? TimeoutException with no timeout set!!!", e);
        }
    }

    private void _recheckResizePool() {
        if (!$assertionsDisabled && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (!this.broken) {
            int msz = this.managed.size();
            int shrink_count = (msz - this.pending_removes) - this.target_pool_size;
            if (shrink_count > 0) {
                shrinkPool(shrink_count);
                return;
            }
            int expand_count = this.target_pool_size - (msz + this.pending_acquires);
            if (expand_count > 0) {
                expandPool(expand_count);
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void incrementPendingAcquires() {
        this.pending_acquires++;
        if (logger.isLoggable(MLevel.FINEST)) {
            logger.finest("incremented pending_acquires: " + this.pending_acquires);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void incrementPendingRemoves() {
        this.pending_removes++;
        if (logger.isLoggable(MLevel.FINEST)) {
            logger.finest("incremented pending_removes: " + this.pending_removes);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void decrementPendingAcquires() {
        _decrementPendingAcquires();
    }

    private void _decrementPendingAcquires() {
        this.pending_acquires--;
        if (logger.isLoggable(MLevel.FINEST)) {
            logger.finest("decremented pending_acquires: " + this.pending_acquires);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void decrementPendingRemoves() {
        this.pending_removes--;
        if (logger.isLoggable(MLevel.FINEST)) {
            logger.finest("decremented pending_removes: " + this.pending_removes);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void recheckResizePool() {
        _recheckResizePool();
    }

    private void expandPool(int count) {
        if (!$assertionsDisabled && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (USE_SCATTERED_ACQUIRE_TASK) {
            for (int i = 0; i < count; i++) {
                this.taskRunner.postRunnable(new ScatteredAcquireTask(this));
            }
        } else {
            for (int i2 = 0; i2 < count; i2++) {
                this.taskRunner.postRunnable(new AcquireTask());
            }
        }
    }

    private void shrinkPool(int count) {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            for (int i = 0; i < count; i++) {
                this.taskRunner.postRunnable(new RemoveTask());
            }
            return;
        }
        throw new AssertionError();
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public Object checkoutResource(long timeout) throws TimeoutException, ResourcePoolException, InterruptedException {
        try {
            Object resc = prelimCheckoutResource(timeout);
            boolean refurb = attemptRefurbishResourceOnCheckout(resc);
            synchronized (this) {
                if (!refurb) {
                    if (logger.isLoggable(MLevel.FINER)) {
                        logger.log(MLevel.FINER, "Resource [" + resc + "] could not be refurbished in preparation for checkout. Will try to find a better resource.");
                    }
                    removeResource(resc);
                    ensureMinResources();
                    resc = null;
                } else {
                    asyncFireResourceCheckedOut(resc, this.managed.size(), this.unused.size(), this.excluded.size());
                    trace();
                    PunchCard card = (PunchCard) this.managed.get(resc);
                    if (card == null) {
                        if (logger.isLoggable(MLevel.FINER)) {
                            logger.finer("Resource " + resc + " was removed from the pool while it was being checked out  or refurbished for checkout. Will try to find a replacement resource.");
                        }
                        resc = null;
                    } else {
                        card.checkout_time = System.currentTimeMillis();
                        if (this.debug_store_checkout_exceptions) {
                            card.checkoutStackTraceException = new Exception("DEBUG STACK TRACE: Overdue resource check-out stack trace.");
                        }
                    }
                }
            }
            if (resc == null) {
                return checkoutResource(timeout);
            }
            return resc;
        } catch (StackOverflowError e) {
            throw new NoGoodResourcesException("After checking so many resources we blew the stack, no resources tested acceptable for checkout. See logger com.mchange.v2.resourcepool.BasicResourcePool output at FINER/DEBUG for information on individual failures.", e);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:25:0x0158
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private synchronized java.lang.Object prelimCheckoutResource(long r6) throws com.mchange.p009v2.resourcepool.TimeoutException, com.mchange.p009v2.resourcepool.ResourcePoolException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 671
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.resourcepool.BasicResourcePool.prelimCheckoutResource(long):java.lang.Object");
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public void checkinResource(Object resc) throws ResourcePoolException {
        boolean unlocked_do_checkin_managed = false;
        try {
            synchronized (this) {
                if (this.managed.keySet().contains(resc)) {
                    unlocked_do_checkin_managed = true;
                } else if (this.excluded.contains(resc)) {
                    doCheckinExcluded(resc);
                } else if (!isFormerResource(resc)) {
                    throw new ResourcePoolException("ResourcePool" + (this.broken ? " [BROKEN!]" : "") + ": Tried to check-in a foreign resource!");
                } else if (logger.isLoggable(MLevel.FINER)) {
                    logger.finer("Resource " + resc + " checked-in after having been checked-in already, or checked-in after  having being destroyed for being checked-out too long.");
                }
            }
            if (unlocked_do_checkin_managed) {
                doCheckinManaged(resc);
            }
            syncTrace();
        } catch (ResourceClosedException e) {
            if (logger.isLoggable(MLevel.SEVERE)) {
                logger.log(MLevel.SEVERE, this + " - checkinResource( ... ) -- even broken pools should allow checkins without exception. probable resource pool bug.", (Throwable) e);
            }
            unexpectedBreak();
            throw e;
        }
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public void checkinAll() throws ResourcePoolException {
        Set<Object> checkedOutNotExcluded;
        try {
            synchronized (this) {
                checkedOutNotExcluded = new HashSet(this.managed.keySet());
                checkedOutNotExcluded.removeAll(this.unused);
                Iterator ii = this.excluded.iterator();
                while (ii.hasNext()) {
                    doCheckinExcluded(ii.next());
                }
            }
            for (Object obj : checkedOutNotExcluded) {
                doCheckinManaged(obj);
            }
        } catch (ResourceClosedException e) {
            if (logger.isLoggable(MLevel.SEVERE)) {
                logger.log(MLevel.SEVERE, this + " - checkinAll() -- even broken pools should allow checkins without exception. probable resource pool bug.", (Throwable) e);
            }
            unexpectedBreak();
            throw e;
        }
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized int statusInPool(Object resc) throws ResourcePoolException {
        try {
            if (this.unused.contains(resc)) {
                return 0;
            }
            if (this.managed.keySet().contains(resc)) {
                return 1;
            }
            if (this.excluded.contains(resc)) {
                return 1;
            }
            return -1;
        } catch (ResourceClosedException e) {
            if (logger.isLoggable(MLevel.SEVERE)) {
                logger.log(MLevel.SEVERE, "Apparent pool break.", (Throwable) e);
            }
            unexpectedBreak();
            throw e;
        }
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized void markBroken(Object resc) {
        try {
            if (logger.isLoggable(MLevel.FINER)) {
                logger.log(MLevel.FINER, "Resource " + resc + " marked broken by pool (" + this + ").");
            }
            _markBroken(resc);
            ensureMinResources();
        } catch (ResourceClosedException e) {
            if (logger.isLoggable(MLevel.SEVERE)) {
                logger.log(MLevel.SEVERE, "Apparent pool break.", (Throwable) e);
            }
            unexpectedBreak();
        }
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public int getMinPoolSize() {
        return this.min;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public int getMaxPoolSize() {
        return this.max;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized int getPoolSize() throws ResourcePoolException {
        return this.managed.size();
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized int getAvailableCount() {
        return this.unused.size();
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized int getExcludedCount() {
        return this.excluded.size();
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized int getAwaitingCheckinCount() {
        return (this.managed.size() - this.unused.size()) + this.excluded.size();
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized int getAwaitingCheckinNotExcludedCount() {
        return this.managed.size() - this.unused.size();
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized void resetPool() {
        try {
            for (Object obj : cloneOfManaged().keySet()) {
                markBrokenNoEnsureMinResources(obj);
            }
            ensureMinResources();
        } catch (ResourceClosedException e) {
            if (logger.isLoggable(MLevel.SEVERE)) {
                logger.log(MLevel.SEVERE, "Apparent pool break.", (Throwable) e);
            }
            unexpectedBreak();
        }
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool, com.mchange.p006v1.util.ClosableResource
    public synchronized void close() throws ResourcePoolException {
        close(true);
    }

    public void finalize() throws Throwable {
        if (!this.broken) {
            close();
        }
    }

    public void addResourcePoolListener(ResourcePoolListener rpl) {
        if (!supportsEvents()) {
            throw new RuntimeException(this + " does not support ResourcePoolEvents. Probably it was constructed by a BasicResourceFactory configured not to support such events.");
        }
        this.rpes.addResourcePoolListener(rpl);
    }

    public void removeResourcePoolListener(ResourcePoolListener rpl) {
        if (!supportsEvents()) {
            throw new RuntimeException(this + " does not support ResourcePoolEvents. Probably it was constructed by a BasicResourceFactory configured not to support such events.");
        }
        this.rpes.removeResourcePoolListener(rpl);
    }

    /* access modifiers changed from: private */
    public synchronized boolean isForceKillAcquiresPending() {
        return this.force_kill_acquires;
    }

    /* access modifiers changed from: private */
    public synchronized void forceKillAcquires() throws InterruptedException {
        if (logger.isLoggable(MLevel.WARNING)) {
            logger.log(MLevel.WARNING, "Having failed to acquire a resource, " + this + " is interrupting all Threads waiting on a resource to check out. Will try again in response to new client requests.");
        }
        Thread t = Thread.currentThread();
        try {
            try {
                this.force_kill_acquires = true;
                notifyAll();
                while (this.acquireWaiters.size() > 0) {
                    this.otherWaiters.add(t);
                    wait();
                }
                this.force_kill_acquires = false;
                this.otherWaiters.remove(t);
            } catch (InterruptedException e) {
                Iterator ii = this.acquireWaiters.iterator();
                while (ii.hasNext()) {
                    ((Thread) ii.next()).interrupt();
                }
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, "An interrupt left an attempt to gently clear threads waiting on resource acquisition potentially incomplete! We have made a best attempt to finish that by interrupt()ing the waiting Threads.");
                }
                this.force_kill_acquires = false;
                e.fillInStackTrace();
                throw e;
            }
        } catch (Throwable th) {
            this.otherWaiters.remove(t);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public synchronized void unexpectedBreak() {
        if (logger.isLoggable(MLevel.SEVERE)) {
            logger.log(MLevel.SEVERE, this + " -- Unexpectedly broken!!!", (Throwable) new ResourcePoolException("Unexpected Break Stack Trace!"));
        }
        close(false);
    }

    private boolean canFireEvents() {
        return this.asyncEventQueue != null && !isBroken();
    }

    private void asyncFireResourceAcquired(final Object resc, final int pool_size, final int available_size, final int removed_but_unreturned_size) {
        if (canFireEvents()) {
            this.asyncEventQueue.postRunnable(new Runnable() { // from class: com.mchange.v2.resourcepool.BasicResourcePool.1
                @Override // java.lang.Runnable
                public void run() {
                    BasicResourcePool.this.rpes.fireResourceAcquired(resc, pool_size, available_size, removed_but_unreturned_size);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void asyncFireResourceCheckedIn(final Object resc, final int pool_size, final int available_size, final int removed_but_unreturned_size) {
        if (canFireEvents()) {
            this.asyncEventQueue.postRunnable(new Runnable() { // from class: com.mchange.v2.resourcepool.BasicResourcePool.2
                @Override // java.lang.Runnable
                public void run() {
                    BasicResourcePool.this.rpes.fireResourceCheckedIn(resc, pool_size, available_size, removed_but_unreturned_size);
                }
            });
        }
    }

    private void asyncFireResourceCheckedOut(final Object resc, final int pool_size, final int available_size, final int removed_but_unreturned_size) {
        if (canFireEvents()) {
            this.asyncEventQueue.postRunnable(new Runnable() { // from class: com.mchange.v2.resourcepool.BasicResourcePool.3
                @Override // java.lang.Runnable
                public void run() {
                    BasicResourcePool.this.rpes.fireResourceCheckedOut(resc, pool_size, available_size, removed_but_unreturned_size);
                }
            });
        }
    }

    private void asyncFireResourceRemoved(final Object resc, final boolean checked_out_resource, final int pool_size, final int available_size, final int removed_but_unreturned_size) {
        if (canFireEvents()) {
            this.asyncEventQueue.postRunnable(new Runnable() { // from class: com.mchange.v2.resourcepool.BasicResourcePool.4
                @Override // java.lang.Runnable
                public void run() {
                    BasicResourcePool.this.rpes.fireResourceRemoved(resc, checked_out_resource, pool_size, available_size, removed_but_unreturned_size);
                }
            });
        }
    }

    private void destroyResource(Object resc) {
        destroyResource(resc, false);
    }

    /* access modifiers changed from: private */
    public void destroyResource(Object resc, boolean synchronous) {
        destroyResource(resc, synchronous, false);
    }

    private void destroyResource(final Object resc, boolean synchronous, final boolean checked_out) {
        Runnable r = new Runnable() { // from class: com.mchange.v2.resourcepool.BasicResourcePool.1DestroyResourceTask
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (BasicResourcePool.logger.isLoggable(MLevel.FINER)) {
                        BasicResourcePool.logger.log(MLevel.FINER, "Preparing to destroy resource: " + resc);
                    }
                    BasicResourcePool.this.mgr.destroyResource(resc, checked_out);
                    if (BasicResourcePool.logger.isLoggable(MLevel.FINER)) {
                        BasicResourcePool.logger.log(MLevel.FINER, "Successfully destroyed resource: " + resc);
                    }
                } catch (Exception e) {
                    if (BasicResourcePool.logger.isLoggable(MLevel.WARNING)) {
                        BasicResourcePool.logger.log(MLevel.WARNING, "Failed to destroy resource: " + resc, (Throwable) e);
                    }
                }
            }
        };
        if (synchronous || this.broken) {
            if (logger.isLoggable(MLevel.FINEST) && !this.broken && Boolean.TRUE.equals(ThreadUtils.reflectiveHoldsLock(this))) {
                logger.log(MLevel.FINEST, this + ": Destroyiong a resource on an active pool, synchronousy while holding pool's lock! (not a bug, but a potential bottleneck... is there a good reason for this?)", (Throwable) new Exception("DEBUG STACK TRACE: resource destruction while holding lock."));
            }
            r.run();
            return;
        }
        try {
            this.taskRunner.postRunnable(r);
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.FINER)) {
                logger.log(MLevel.FINER, "AsynchronousRunner refused to accept task to destroy resource. It is probably shared, and has probably been closed underneath us. Reverting to synchronous destruction. This is not usually a problem.", (Throwable) e);
            }
            destroyResource(resc, true);
        }
    }

    private void doAcquire() throws Exception {
        doAcquire(0);
    }

    /* access modifiers changed from: private */
    public void doAcquireAndDecrementPendingAcquiresWithinLockOnSuccess() throws Exception {
        doAcquire(1);
    }

    /* access modifiers changed from: private */
    public void doAcquireAndDecrementPendingAcquiresWithinLockAlways() throws Exception {
        doAcquire(2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e A[Catch: all -> 0x005e, all -> 0x0072, TryCatch #3 {, blocks: (B:12:0x0036, B:14:0x003f, B:18:0x004e, B:22:0x0057, B:24:0x006e), top: B:44:0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057 A[Catch: all -> 0x0072, TryCatch #3 {, blocks: (B:12:0x0036, B:14:0x003f, B:18:0x004e, B:22:0x0057, B:24:0x006e), top: B:44:0x0036 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doAcquire(int r6) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 235
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.resourcepool.BasicResourcePool.doAcquire(int):void");
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized void setPoolSize(int sz) throws ResourcePoolException {
        try {
            setTargetPoolSize(sz);
            while (this.managed.size() != sz) {
                wait();
            }
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.FINER)) {
                logger.log(MLevel.FINER, "An exception occurred while trying to set the pool size!", (Throwable) e);
            }
            throw ResourcePoolUtils.convertThrowable("An exception occurred while trying to set the pool size!", e);
        }
    }

    public synchronized void setTargetPoolSize(int sz) {
        if (sz > this.max) {
            throw new IllegalArgumentException("Requested size [" + sz + "] is greater than max [" + this.max + "].");
        } else if (sz < this.min) {
            throw new IllegalArgumentException("Requested size [" + sz + "] is less than min [" + this.min + "].");
        } else {
            this.target_pool_size = sz;
            _recheckResizePool();
        }
    }

    private void markBrokenNoEnsureMinResources(Object resc) {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            try {
                _markBroken(resc);
            } catch (ResourceClosedException e) {
                if (logger.isLoggable(MLevel.SEVERE)) {
                    logger.log(MLevel.SEVERE, "Apparent pool break.", (Throwable) e);
                }
                unexpectedBreak();
            }
        } else {
            throw new AssertionError();
        }
    }

    private void _markBroken(Object resc) {
        if (!$assertionsDisabled && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (this.unused.contains(resc)) {
            removeResource(resc);
        } else {
            excludeResource(resc);
        }
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePool
    public synchronized void close(boolean close_checked_out_resources) {
        if (!this.broken) {
            this.broken = true;
            final Collection<Object> cleanupResources = close_checked_out_resources ? cloneOfManaged().keySet() : cloneOfUnused();
            if (this.cullTask != null) {
                this.cullTask.cancel();
            }
            if (this.idleRefurbishTask != null) {
                this.idleRefurbishTask.cancel();
            }
            for (Object obj : cleanupResources) {
                addToFormerResources(obj);
            }
            this.managed.keySet().removeAll(cleanupResources);
            this.unused.removeAll(cleanupResources);
            new Thread("Resource Destroyer in BasicResourcePool.close()") { // from class: com.mchange.v2.resourcepool.BasicResourcePool.5
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    for (Object resc : cleanupResources) {
                        try {
                            BasicResourcePool.this.destroyResource(resc, true);
                        } catch (Exception e) {
                            if (BasicResourcePool.logger.isLoggable(MLevel.FINE)) {
                                BasicResourcePool.logger.log(MLevel.FINE, "BasicResourcePool -- A resource couldn't be cleaned up on close()", (Throwable) e);
                            }
                        }
                    }
                }
            }.start();
            Iterator ii = this.acquireWaiters.iterator();
            while (ii.hasNext()) {
                ((Thread) ii.next()).interrupt();
            }
            Iterator ii2 = this.otherWaiters.iterator();
            while (ii2.hasNext()) {
                ((Thread) ii2.next()).interrupt();
            }
            if (this.factory != null) {
                this.factory.markBroken(this);
            }
        } else if (logger.isLoggable(MLevel.WARNING)) {
            logger.warning(this + " -- close() called multiple times.");
        }
    }

    private void doCheckinManaged(final Object resc) throws ResourcePoolException {
        if (!$assertionsDisabled && Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (statusInPool(resc) == 0) {
            throw new ResourcePoolException("Tried to check-in an already checked-in resource: " + resc);
        } else {
            synchronized (this) {
                if (this.broken) {
                    removeResource(resc, true);
                    return;
                }
                Runnable doMe = new Runnable() { // from class: com.mchange.v2.resourcepool.BasicResourcePool.1RefurbishCheckinResourceTask
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean resc_okay = BasicResourcePool.this.attemptRefurbishResourceOnCheckin(resc);
                        synchronized (BasicResourcePool.this) {
                            PunchCard card = (PunchCard) BasicResourcePool.this.managed.get(resc);
                            if (!resc_okay || card == null) {
                                if (card != null) {
                                    card.checkout_time = -1;
                                }
                                BasicResourcePool.this.removeResource(resc);
                                BasicResourcePool.this.ensureMinResources();
                                if (card == null && BasicResourcePool.logger.isLoggable(MLevel.FINE)) {
                                    BasicResourcePool.logger.fine("Resource " + resc + " was removed from the pool during its refurbishment for checkin.");
                                }
                            } else {
                                BasicResourcePool.this.unused.add(0, resc);
                                card.last_checkin_time = System.currentTimeMillis();
                                card.checkout_time = -1;
                            }
                            BasicResourcePool.this.asyncFireResourceCheckedIn(resc, BasicResourcePool.this.managed.size(), BasicResourcePool.this.unused.size(), BasicResourcePool.this.excluded.size());
                            BasicResourcePool.this.notifyAll();
                        }
                    }
                };
                if (this.force_synchronous_checkins) {
                    doMe.run();
                } else {
                    this.taskRunner.postRunnable(doMe);
                }
            }
        }
    }

    private void doCheckinExcluded(Object resc) {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            this.excluded.remove(resc);
            destroyResource(resc);
            return;
        }
        throw new AssertionError();
    }

    private void awaitAvailable(long timeout) throws InterruptedException, TimeoutException, ResourcePoolException {
        if (!$assertionsDisabled && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (this.force_kill_acquires) {
            throw new ResourcePoolException("A ResourcePool cannot acquire a new resource -- the factory or source appears to be down.");
        } else {
            Thread t = Thread.currentThread();
            try {
                this.acquireWaiters.add(t);
                long start = timeout > 0 ? System.currentTimeMillis() : -1;
                if (logger.isLoggable(MLevel.FINE)) {
                    logger.fine("awaitAvailable(): " + (this.exampleResource != null ? this.exampleResource : "[unknown]"));
                }
                trace();
                while (this.unused.size() == 0) {
                    if (this.pending_acquires == 0 && this.managed.size() < this.max) {
                        _recheckResizePool();
                    }
                    wait(timeout);
                    if (timeout > 0 && System.currentTimeMillis() - start > timeout) {
                        throw new TimeoutException("A client timed out while waiting to acquire a resource from " + this + " -- timeout at awaitAvailable()");
                    } else if (this.force_kill_acquires) {
                        throw new CannotAcquireResourceException("A ResourcePool could not acquire a resource from its primary factory or source.", getLastAcquisitionFailure());
                    } else {
                        ensureNotBroken();
                    }
                }
                this.acquireWaiters.remove(t);
                if (this.acquireWaiters.size() == 0) {
                    notifyAll();
                }
            } catch (Throwable th) {
                this.acquireWaiters.remove(t);
                if (this.acquireWaiters.size() == 0) {
                    notifyAll();
                }
                throw th;
            }
        }
    }

    private void assimilateResource(Object resc) throws Exception {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            this.managed.put(resc, new PunchCard());
            this.unused.add(0, resc);
            asyncFireResourceAcquired(resc, this.managed.size(), this.unused.size(), this.excluded.size());
            notifyAll();
            trace();
            if (this.exampleResource == null) {
                this.exampleResource = resc;
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public void synchronousRemoveArbitraryResource() {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            Object removeMe = null;
            synchronized (this) {
                if (this.unused.size() > 0) {
                    removeMe = this.unused.get(0);
                    this.managed.remove(removeMe);
                    this.unused.remove(removeMe);
                } else {
                    Set checkedOut = cloneOfManaged().keySet();
                    if (checkedOut.isEmpty()) {
                        unexpectedBreak();
                        logger.severe("A pool from which a resource is requested to be removed appears to have no managed resources?!");
                    } else {
                        excludeResource(checkedOut.iterator().next());
                    }
                }
            }
            if (removeMe != null) {
                destroyResource(removeMe, true);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public void removeResource(Object resc) {
        removeResource(resc, false);
    }

    private void removeResource(Object resc, boolean synchronous) {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            PunchCard pc = (PunchCard) this.managed.remove(resc);
            boolean checked_out = false;
            if (pc != null) {
                checked_out = pc.checkout_time > 0;
                if (checked_out && !this.broken && logger.isLoggable(MLevel.INFO)) {
                    logger.info("A checked-out resource is overdue, and will be destroyed: " + resc);
                    if (pc.checkoutStackTraceException != null) {
                        logger.log(MLevel.INFO, "Logging the stack trace by which the overdue resource was checked-out.", (Throwable) pc.checkoutStackTraceException);
                    }
                }
            } else if (logger.isLoggable(MLevel.FINE)) {
                logger.fine("Resource " + resc + " was removed twice. (Lotsa reasons a resource can be removed, sometimes simultaneously. It's okay)");
            }
            this.unused.remove(resc);
            destroyResource(resc, synchronous, checked_out);
            addToFormerResources(resc);
            asyncFireResourceRemoved(resc, false, this.managed.size(), this.unused.size(), this.excluded.size());
            trace();
            return;
        }
        throw new AssertionError();
    }

    private void excludeResource(Object resc) {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            this.managed.remove(resc);
            this.excluded.add(resc);
            if (this.unused.contains(resc)) {
                throw new InternalError("We should only \"exclude\" checked-out resources!");
            }
            if (logger.isLoggable(MLevel.FINEST)) {
                logger.log(MLevel.FINEST, "Excluded resource " + resc, (Throwable) new Exception("DEBUG STACK TRACE: Excluded resource stack trace"));
            }
            asyncFireResourceRemoved(resc, true, this.managed.size(), this.unused.size(), this.excluded.size());
            return;
        }
        throw new AssertionError();
    }

    private void removeTowards(int new_sz) {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            int num_to_remove = this.managed.size() - new_sz;
            int count = 0;
            Iterator ii = cloneOfUnused().iterator();
            while (ii.hasNext() && count < num_to_remove) {
                removeResource(ii.next());
                count++;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public void cullExpired() {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            if (logger.isLoggable(MLevel.FINER)) {
                logger.log(MLevel.FINER, "BEGIN check for expired resources.  [" + this + "]");
            }
            for (Object resc : this.destroy_unreturned_resc_time > 0 ? cloneOfManaged().keySet() : cloneOfUnused()) {
                if (shouldExpire(resc)) {
                    if (logger.isLoggable(MLevel.FINER)) {
                        logger.log(MLevel.FINER, "Removing expired resource: " + resc + " [" + this + "]");
                    }
                    this.target_pool_size = Math.max(this.min, this.target_pool_size - 1);
                    removeResource(resc);
                    trace();
                }
            }
            if (logger.isLoggable(MLevel.FINER)) {
                logger.log(MLevel.FINER, "FINISHED check for expired resources.  [" + this + "]");
            }
            ensureMinResources();
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public void checkIdleResources() {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            for (Object resc : cloneOfUnused()) {
                if (this.idleCheckResources.add(resc)) {
                    this.taskRunner.postRunnable(new AsyncTestIdleResourceTask(resc));
                }
            }
            trace();
            return;
        }
        throw new AssertionError();
    }

    private boolean shouldExpire(Object resc) {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            boolean expired = false;
            PunchCard pc = (PunchCard) this.managed.get(resc);
            if (pc != null) {
                long now = System.currentTimeMillis();
                if (pc.checkout_time < 0) {
                    long idle_age = now - pc.last_checkin_time;
                    if (this.excess_max_idle_time > 0) {
                        int msz = this.managed.size();
                        expired = msz > this.min && idle_age > this.excess_max_idle_time;
                        if (expired && logger.isLoggable(MLevel.FINER)) {
                            logger.log(MLevel.FINER, "EXPIRED excess idle resource: " + resc + " ---> idle_time: " + idle_age + "; excess_max_idle_time: " + this.excess_max_idle_time + "; pool_size: " + msz + "; min_pool_size: " + this.min + " [" + this + "]");
                        }
                    }
                    if (!expired && this.max_idle_time > 0) {
                        expired = idle_age > this.max_idle_time;
                        if (expired && logger.isLoggable(MLevel.FINER)) {
                            logger.log(MLevel.FINER, "EXPIRED idle resource: " + resc + " ---> idle_time: " + idle_age + "; max_idle_time: " + this.max_idle_time + " [" + this + "]");
                        }
                    }
                    if (!expired && this.max_resource_age > 0) {
                        long abs_age = now - pc.acquisition_time;
                        expired = abs_age > this.max_resource_age;
                        if (expired && logger.isLoggable(MLevel.FINER)) {
                            logger.log(MLevel.FINER, "EXPIRED old resource: " + resc + " ---> absolute_age: " + abs_age + "; max_absolute_age: " + this.max_resource_age + " [" + this + "]");
                        }
                    }
                } else {
                    expired = now - pc.checkout_time > this.destroy_unreturned_resc_time;
                }
                return expired;
            } else if (!logger.isLoggable(MLevel.FINE)) {
                return true;
            } else {
                logger.fine("Resource " + resc + " was being tested for expiration, but has already been removed from the pool.");
                return true;
            }
        } else {
            throw new AssertionError();
        }
    }

    private void ensureStartResources() {
        recheckResizePool();
    }

    /* access modifiers changed from: private */
    public void ensureMinResources() {
        recheckResizePool();
    }

    private boolean attemptRefurbishResourceOnCheckout(Object resc) {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            try {
                this.mgr.refurbishResourceOnCheckout(resc);
                return true;
            } catch (Exception e) {
                if (logger.isLoggable(MLevel.FINE)) {
                    logger.log(MLevel.FINE, "A resource could not be refurbished for checkout. [" + resc + ']', (Throwable) e);
                }
                synchronized (this) {
                    this.failed_checkouts++;
                    setLastCheckoutFailure(e);
                    return false;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    public boolean attemptRefurbishResourceOnCheckin(Object resc) {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            try {
                this.mgr.refurbishResourceOnCheckin(resc);
                return true;
            } catch (Exception e) {
                if (logger.isLoggable(MLevel.FINE)) {
                    logger.log(MLevel.FINE, "A resource could not be refurbished on checkin. [" + resc + ']', (Throwable) e);
                }
                synchronized (this) {
                    this.failed_checkins++;
                    setLastCheckinFailure(e);
                    return false;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    private void ensureNotBroken() throws ResourcePoolException {
        if (!$assertionsDisabled && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (this.broken) {
            throw new ResourcePoolException("Attempted to use a closed or broken resource pool");
        }
    }

    private synchronized void syncTrace() {
        trace();
    }

    private void trace() {
        if (!$assertionsDisabled && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (logger.isLoggable(MLevel.FINEST)) {
            logger.finest("trace " + this + " [managed: " + this.managed.size() + ", unused: " + this.unused.size() + ", excluded: " + this.excluded.size() + ']' + (this.exampleResource == null ? "" : " (e.g. " + this.exampleResource + ")"));
        }
    }

    private final HashMap cloneOfManaged() {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            return (HashMap) this.managed.clone();
        }
        throw new AssertionError();
    }

    private final LinkedList cloneOfUnused() {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            return (LinkedList) this.unused.clone();
        }
        throw new AssertionError();
    }

    private final HashSet cloneOfExcluded() {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            return (HashSet) this.excluded.clone();
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.resourcepool.BasicResourcePool$ScatteredAcquireTask */
    /* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/BasicResourcePool$ScatteredAcquireTask.class */
    public class ScatteredAcquireTask implements Runnable {
        int attempts_remaining;

        ScatteredAcquireTask(BasicResourcePool this$0) {
            this(this$0.num_acq_attempts >= 0 ? this$0.num_acq_attempts : -1, true);
        }

        private ScatteredAcquireTask(int attempts_remaining, boolean first_attempt) {
            this.attempts_remaining = attempts_remaining;
            if (first_attempt) {
                BasicResourcePool.this.incrementPendingAcquires();
                if (BasicResourcePool.logger.isLoggable(MLevel.FINEST)) {
                    BasicResourcePool.logger.finest("Starting acquisition series. Incremented pending_acquires [" + BasicResourcePool.this.pending_acquires + "],  attempts_remaining: " + attempts_remaining);
                }
            } else if (BasicResourcePool.logger.isLoggable(MLevel.FINEST)) {
                BasicResourcePool.logger.finest("Continuing acquisition series. pending_acquires [" + BasicResourcePool.this.pending_acquires + "],  attempts_remaining: " + attempts_remaining);
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:30:0x009d
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.lang.Runnable
        public void run() {
            /*
            // Method dump skipped, instructions count: 555
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.resourcepool.BasicResourcePool.ScatteredAcquireTask.run():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.resourcepool.BasicResourcePool$AcquireTask */
    /* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/BasicResourcePool$AcquireTask.class */
    public class AcquireTask implements Runnable {
        boolean success = false;

        public AcquireTask() {
            BasicResourcePool.this.incrementPendingAcquires();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean decremented;
            boolean recheck;
            try {
                decremented = false;
                recheck = false;
                Exception lastException = null;
                for (int i = 0; shouldTry(i); i++) {
                    try {
                        try {
                            if (i > 0) {
                                Thread.sleep((long) BasicResourcePool.this.acq_attempt_delay);
                            }
                            if (goodAttemptNumber(i + 1)) {
                                BasicResourcePool.this.doAcquireAndDecrementPendingAcquiresWithinLockOnSuccess();
                                decremented = true;
                            } else {
                                decremented = true;
                                recheck = true;
                                BasicResourcePool.this.doAcquireAndDecrementPendingAcquiresWithinLockAlways();
                            }
                            try {
                                this.success = true;
                            } catch (InterruptedException e) {
                                throw e;
                            } catch (Exception e2) {
                                MLevel logLevel = BasicResourcePool.this.num_acq_attempts > 0 ? MLevel.FINE : MLevel.INFO;
                                if (BasicResourcePool.logger.isLoggable(logLevel)) {
                                    BasicResourcePool.logger.log(logLevel, "An exception occurred while acquiring a poolable resource. Will retry.", (Throwable) e2);
                                }
                                lastException = e2;
                                BasicResourcePool.this.setLastAcquisitionFailure(e2);
                            }
                        } catch (InterruptedException e3) {
                            if (BasicResourcePool.logger.isLoggable(MLevel.WARNING)) {
                                BasicResourcePool.logger.log(MLevel.WARNING, BasicResourcePool.this + " -- Thread unexpectedly interrupted while performing an acquisition attempt.", (Throwable) e3);
                            }
                            BasicResourcePool.this.recheckResizePool();
                            if (!decremented) {
                                BasicResourcePool.this.decrementPendingAcquires();
                            }
                            if (recheck) {
                                BasicResourcePool.this.recheckResizePool();
                                return;
                            }
                            return;
                        }
                    } catch (ResourceClosedException e4) {
                        if (BasicResourcePool.logger.isLoggable(MLevel.FINE)) {
                            BasicResourcePool.logger.log(MLevel.FINE, "a resource pool async thread died.", (Throwable) e4);
                        }
                        BasicResourcePool.this.unexpectedBreak();
                        if (!decremented) {
                            BasicResourcePool.this.decrementPendingAcquires();
                        }
                        if (recheck) {
                            BasicResourcePool.this.recheckResizePool();
                            return;
                        }
                        return;
                    }
                }
                if (!this.success) {
                    if (BasicResourcePool.logger.isLoggable(MLevel.WARNING)) {
                        BasicResourcePool.logger.log(MLevel.WARNING, this + " -- Acquisition Attempt Failed!!! Clearing pending acquires. While trying to acquire a needed new resource, we failed to succeed more than the maximum number of allowed acquisition attempts (" + BasicResourcePool.this.num_acq_attempts + "). " + (lastException == null ? "" : "Last acquisition attempt exception: "), (Throwable) lastException);
                    }
                    if (BasicResourcePool.this.break_on_acquisition_failure) {
                        if (BasicResourcePool.logger.isLoggable(MLevel.SEVERE)) {
                            BasicResourcePool.logger.severe("A RESOURCE POOL IS PERMANENTLY BROKEN! [" + this + "]");
                        }
                        BasicResourcePool.this.unexpectedBreak();
                    } else {
                        BasicResourcePool.this.forceKillAcquires();
                    }
                } else {
                    BasicResourcePool.this.recheckResizePool();
                }
                if (!decremented) {
                    BasicResourcePool.this.decrementPendingAcquires();
                }
                if (recheck) {
                    BasicResourcePool.this.recheckResizePool();
                }
            } catch (Throwable th) {
                if (!decremented) {
                    BasicResourcePool.this.decrementPendingAcquires();
                }
                if (recheck) {
                    BasicResourcePool.this.recheckResizePool();
                }
                throw th;
            }
        }

        private boolean shouldTry(int attempt_num) {
            return !this.success && !BasicResourcePool.this.isForceKillAcquiresPending() && goodAttemptNumber(attempt_num);
        }

        private boolean goodAttemptNumber(int attempt_num) {
            return BasicResourcePool.this.num_acq_attempts <= 0 || attempt_num < BasicResourcePool.this.num_acq_attempts;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.resourcepool.BasicResourcePool$RemoveTask */
    /* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/BasicResourcePool$RemoveTask.class */
    public class RemoveTask implements Runnable {
        public RemoveTask() {
            BasicResourcePool.this.incrementPendingRemoves();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BasicResourcePool.this.synchronousRemoveArbitraryResource();
                BasicResourcePool.this.recheckResizePool();
            } finally {
                BasicResourcePool.this.decrementPendingRemoves();
            }
        }
    }

    /* renamed from: com.mchange.v2.resourcepool.BasicResourcePool$CullTask */
    /* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/BasicResourcePool$CullTask.class */
    class CullTask extends TimerTask {
        CullTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (BasicResourcePool.logger.isLoggable(MLevel.FINER)) {
                    BasicResourcePool.logger.log(MLevel.FINER, "Checking for expired resources - " + new Date() + " [" + BasicResourcePool.this + "]");
                }
                synchronized (BasicResourcePool.this) {
                    BasicResourcePool.this.cullExpired();
                }
            } catch (ResourceClosedException e) {
                if (BasicResourcePool.logger.isLoggable(MLevel.FINE)) {
                    BasicResourcePool.logger.log(MLevel.FINE, "a resource pool async thread died.", (Throwable) e);
                }
                BasicResourcePool.this.unexpectedBreak();
            }
        }
    }

    /* renamed from: com.mchange.v2.resourcepool.BasicResourcePool$CheckIdleResourcesTask */
    /* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/BasicResourcePool$CheckIdleResourcesTask.class */
    class CheckIdleResourcesTask extends TimerTask {
        CheckIdleResourcesTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (BasicResourcePool.logger.isLoggable(MLevel.FINER)) {
                    BasicResourcePool.logger.log(MLevel.FINER, "Refurbishing idle resources - " + new Date() + " [" + BasicResourcePool.this + "]");
                }
                synchronized (BasicResourcePool.this) {
                    BasicResourcePool.this.checkIdleResources();
                }
            } catch (ResourceClosedException e) {
                if (BasicResourcePool.logger.isLoggable(MLevel.FINE)) {
                    BasicResourcePool.logger.log(MLevel.FINE, "a resource pool async thread died.", (Throwable) e);
                }
                BasicResourcePool.this.unexpectedBreak();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.resourcepool.BasicResourcePool$AsyncTestIdleResourceTask */
    /* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/BasicResourcePool$AsyncTestIdleResourceTask.class */
    public class AsyncTestIdleResourceTask implements Runnable {
        Object resc;
        boolean pending = true;
        boolean failed;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !BasicResourcePool.class.desiredAssertionStatus();
        }

        AsyncTestIdleResourceTask(Object resc) {
            this.resc = resc;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x002b
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.lang.Runnable
        public void run() {
            /*
            // Method dump skipped, instructions count: 273
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.resourcepool.BasicResourcePool.AsyncTestIdleResourceTask.run():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.resourcepool.BasicResourcePool$PunchCard */
    /* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/BasicResourcePool$PunchCard.class */
    public static final class PunchCard {
        long acquisition_time = System.currentTimeMillis();
        long last_checkin_time = this.acquisition_time;
        long checkout_time = -1;
        Exception checkoutStackTraceException = null;

        PunchCard() {
        }
    }
}
