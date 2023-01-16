package com.mchange.p009v2.resourcepool;

import com.mchange.p009v2.async.AsynchronousRunner;
import com.mchange.p009v2.async.CarefulRunnableQueue;
import com.mchange.p009v2.async.RunnableQueue;
import com.mchange.p009v2.async.ThreadPoolAsynchronousRunner;
import com.mchange.p009v2.resourcepool.ResourcePool;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;

/* renamed from: com.mchange.v2.resourcepool.BasicResourcePoolFactory */
/* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/BasicResourcePoolFactory.class */
public class BasicResourcePoolFactory extends ResourcePoolFactory {
    int start;
    int min;
    int max;
    int inc;
    int retry_attempts;
    int retry_delay;
    long idle_resource_test_period;
    long max_age;
    long max_idle_time;
    long excess_max_idle_time;
    long destroy_overdue_resc_time;
    long expiration_enforcement_delay;
    boolean break_on_acquisition_failure;
    boolean debug_store_checkout_stacktrace;
    boolean force_synchronous_checkins;
    AsynchronousRunner taskRunner;
    boolean taskRunner_is_external;
    RunnableQueue asyncEventQueue;
    boolean asyncEventQueue_is_external;
    Timer timer;
    boolean timer_is_external;
    int default_num_task_threads;
    Set liveChildren;

    public static BasicResourcePoolFactory createNoEventSupportInstance(int num_task_threads) {
        return createNoEventSupportInstance(null, null, num_task_threads);
    }

    public static BasicResourcePoolFactory createNoEventSupportInstance(AsynchronousRunner taskRunner, Timer timer) {
        return createNoEventSupportInstance(taskRunner, timer, 3);
    }

    private static BasicResourcePoolFactory createNoEventSupportInstance(AsynchronousRunner taskRunner, Timer timer, int default_num_task_threads) {
        return new BasicResourcePoolFactory(taskRunner, timer, default_num_task_threads, true);
    }

    /* access modifiers changed from: package-private */
    public BasicResourcePoolFactory() {
        this(null, null, null);
    }

    /* access modifiers changed from: package-private */
    public BasicResourcePoolFactory(AsynchronousRunner taskRunner, RunnableQueue asyncEventQueue, Timer timer) {
        this(taskRunner, asyncEventQueue, timer, 3);
    }

    /* access modifiers changed from: package-private */
    public BasicResourcePoolFactory(int num_task_threads) {
        this((AsynchronousRunner) null, (RunnableQueue) null, (Timer) null, num_task_threads);
    }

    BasicResourcePoolFactory(AsynchronousRunner taskRunner, Timer timer, int default_num_task_threads, boolean no_event_support) {
        this(taskRunner, (RunnableQueue) null, timer, default_num_task_threads);
        if (no_event_support) {
            this.asyncEventQueue_is_external = true;
        }
    }

    BasicResourcePoolFactory(AsynchronousRunner taskRunner, RunnableQueue asyncEventQueue, Timer timer, int default_num_task_threads) {
        this.start = -1;
        this.min = 1;
        this.max = 12;
        this.inc = 3;
        this.retry_attempts = -1;
        this.retry_delay = 1000;
        this.idle_resource_test_period = -1;
        this.max_age = -1;
        this.max_idle_time = -1;
        this.excess_max_idle_time = -1;
        this.destroy_overdue_resc_time = -1;
        this.expiration_enforcement_delay = -1;
        this.break_on_acquisition_failure = true;
        this.debug_store_checkout_stacktrace = false;
        this.force_synchronous_checkins = false;
        this.taskRunner = taskRunner;
        this.taskRunner_is_external = taskRunner != null;
        this.asyncEventQueue = asyncEventQueue;
        this.asyncEventQueue_is_external = asyncEventQueue != null;
        this.timer = timer;
        this.timer_is_external = timer != null;
        this.default_num_task_threads = default_num_task_threads;
    }

    private void createThreadResources() {
        if (!this.taskRunner_is_external) {
            this.taskRunner = new ThreadPoolAsynchronousRunner(this.default_num_task_threads, true);
        }
        if (!this.asyncEventQueue_is_external) {
            this.asyncEventQueue = new CarefulRunnableQueue(true, false);
        }
        if (!this.timer_is_external) {
            this.timer = new Timer(true);
        }
        this.liveChildren = new HashSet();
    }

    private void destroyThreadResources() {
        if (!this.taskRunner_is_external) {
            this.taskRunner.close();
            this.taskRunner = null;
        }
        if (!this.asyncEventQueue_is_external) {
            this.asyncEventQueue.close();
            this.asyncEventQueue = null;
        }
        if (!this.timer_is_external) {
            this.timer.cancel();
            this.timer = null;
        }
        this.liveChildren = null;
    }

    /* access modifiers changed from: package-private */
    public synchronized void markBroken(BasicResourcePool pool) {
        if (this.liveChildren != null) {
            this.liveChildren.remove(pool);
            if (this.liveChildren.isEmpty()) {
                destroyThreadResources();
            }
        }
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setStart(int start) throws ResourcePoolException {
        this.start = start;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized int getStart() throws ResourcePoolException {
        return this.start;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setMin(int min) throws ResourcePoolException {
        this.min = min;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized int getMin() throws ResourcePoolException {
        return this.min;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setMax(int max) throws ResourcePoolException {
        this.max = max;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized int getMax() throws ResourcePoolException {
        return this.max;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setIncrement(int inc) throws ResourcePoolException {
        this.inc = inc;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized int getIncrement() throws ResourcePoolException {
        return this.inc;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setAcquisitionRetryAttempts(int retry_attempts) throws ResourcePoolException {
        this.retry_attempts = retry_attempts;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized int getAcquisitionRetryAttempts() throws ResourcePoolException {
        return this.retry_attempts;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setAcquisitionRetryDelay(int retry_delay) throws ResourcePoolException {
        this.retry_delay = retry_delay;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized int getAcquisitionRetryDelay() throws ResourcePoolException {
        return this.retry_delay;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setIdleResourceTestPeriod(long test_period) {
        this.idle_resource_test_period = test_period;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized long getIdleResourceTestPeriod() {
        return this.idle_resource_test_period;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setResourceMaxAge(long max_age) throws ResourcePoolException {
        this.max_age = max_age;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized long getResourceMaxAge() throws ResourcePoolException {
        return this.max_age;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setResourceMaxIdleTime(long millis) throws ResourcePoolException {
        this.max_idle_time = millis;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized long getResourceMaxIdleTime() throws ResourcePoolException {
        return this.max_idle_time;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setExcessResourceMaxIdleTime(long millis) throws ResourcePoolException {
        this.excess_max_idle_time = millis;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized long getExcessResourceMaxIdleTime() throws ResourcePoolException {
        return this.excess_max_idle_time;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized long getDestroyOverdueResourceTime() throws ResourcePoolException {
        return this.destroy_overdue_resc_time;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setDestroyOverdueResourceTime(long millis) throws ResourcePoolException {
        this.destroy_overdue_resc_time = millis;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setExpirationEnforcementDelay(long expiration_enforcement_delay) throws ResourcePoolException {
        this.expiration_enforcement_delay = expiration_enforcement_delay;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized long getExpirationEnforcementDelay() throws ResourcePoolException {
        return this.expiration_enforcement_delay;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setBreakOnAcquisitionFailure(boolean break_on_acquisition_failure) throws ResourcePoolException {
        this.break_on_acquisition_failure = break_on_acquisition_failure;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized boolean getBreakOnAcquisitionFailure() throws ResourcePoolException {
        return this.break_on_acquisition_failure;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setDebugStoreCheckoutStackTrace(boolean debug_store_checkout_stacktrace) throws ResourcePoolException {
        this.debug_store_checkout_stacktrace = debug_store_checkout_stacktrace;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized boolean getDebugStoreCheckoutStackTrace() throws ResourcePoolException {
        return this.debug_store_checkout_stacktrace;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized void setForceSynchronousCheckins(boolean force_synchronous_checkins) throws ResourcePoolException {
        this.force_synchronous_checkins = force_synchronous_checkins;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized boolean getForceSynchronousCheckins() throws ResourcePoolException {
        return this.force_synchronous_checkins;
    }

    @Override // com.mchange.p009v2.resourcepool.ResourcePoolFactory
    public synchronized ResourcePool createPool(ResourcePool.Manager mgr) throws ResourcePoolException {
        if (this.liveChildren == null) {
            createThreadResources();
        }
        BasicResourcePool basicResourcePool = new BasicResourcePool(mgr, this.start, this.min, this.max, this.inc, this.retry_attempts, this.retry_delay, this.idle_resource_test_period, this.max_age, this.max_idle_time, this.excess_max_idle_time, this.destroy_overdue_resc_time, this.expiration_enforcement_delay, this.break_on_acquisition_failure, this.debug_store_checkout_stacktrace, this.force_synchronous_checkins, this.taskRunner, this.asyncEventQueue, this.timer, this);
        this.liveChildren.add(basicResourcePool);
        return basicResourcePool;
    }
}
