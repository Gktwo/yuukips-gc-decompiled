package com.mchange.p009v2.resourcepool;

import com.mchange.p009v2.async.AsynchronousRunner;
import com.mchange.p009v2.async.Queuable;
import com.mchange.p009v2.async.RunnableQueue;
import com.mchange.p009v2.resourcepool.ResourcePool;
import java.util.Timer;

/* renamed from: com.mchange.v2.resourcepool.ResourcePoolFactory */
/* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/ResourcePoolFactory.class */
public abstract class ResourcePoolFactory {
    static final ResourcePoolFactory SHARED_INSTANCE = new BasicResourcePoolFactory();
    static final int DEFAULT_NUM_TASK_THREADS = 3;

    public abstract void setMin(int i) throws ResourcePoolException;

    public abstract int getMin() throws ResourcePoolException;

    public abstract void setMax(int i) throws ResourcePoolException;

    public abstract int getStart() throws ResourcePoolException;

    public abstract void setStart(int i) throws ResourcePoolException;

    public abstract int getMax() throws ResourcePoolException;

    public abstract void setIncrement(int i) throws ResourcePoolException;

    public abstract int getIncrement() throws ResourcePoolException;

    public abstract void setAcquisitionRetryAttempts(int i) throws ResourcePoolException;

    public abstract int getAcquisitionRetryAttempts() throws ResourcePoolException;

    public abstract void setAcquisitionRetryDelay(int i) throws ResourcePoolException;

    public abstract int getAcquisitionRetryDelay() throws ResourcePoolException;

    public abstract void setIdleResourceTestPeriod(long j) throws ResourcePoolException;

    public abstract long getIdleResourceTestPeriod() throws ResourcePoolException;

    public abstract void setResourceMaxAge(long j) throws ResourcePoolException;

    public abstract long getResourceMaxAge() throws ResourcePoolException;

    public abstract void setResourceMaxIdleTime(long j) throws ResourcePoolException;

    public abstract long getResourceMaxIdleTime() throws ResourcePoolException;

    public abstract void setExcessResourceMaxIdleTime(long j) throws ResourcePoolException;

    public abstract long getExcessResourceMaxIdleTime() throws ResourcePoolException;

    public abstract long getDestroyOverdueResourceTime() throws ResourcePoolException;

    public abstract void setDestroyOverdueResourceTime(long j) throws ResourcePoolException;

    public abstract void setExpirationEnforcementDelay(long j) throws ResourcePoolException;

    public abstract long getExpirationEnforcementDelay() throws ResourcePoolException;

    public abstract void setBreakOnAcquisitionFailure(boolean z) throws ResourcePoolException;

    public abstract boolean getBreakOnAcquisitionFailure() throws ResourcePoolException;

    public abstract void setDebugStoreCheckoutStackTrace(boolean z) throws ResourcePoolException;

    public abstract boolean getDebugStoreCheckoutStackTrace() throws ResourcePoolException;

    public abstract void setForceSynchronousCheckins(boolean z) throws ResourcePoolException;

    public abstract boolean getForceSynchronousCheckins() throws ResourcePoolException;

    public abstract ResourcePool createPool(ResourcePool.Manager manager) throws ResourcePoolException;

    public static ResourcePoolFactory getSharedInstance() throws ResourcePoolException {
        return SHARED_INSTANCE;
    }

    public static ResourcePoolFactory createInstance() {
        return new BasicResourcePoolFactory();
    }

    public static ResourcePoolFactory createInstance(int num_task_threads) {
        return new BasicResourcePoolFactory(num_task_threads);
    }

    public static ResourcePoolFactory createInstance(AsynchronousRunner taskRunner, RunnableQueue asyncEventQueue, Timer cullTimer) {
        return new BasicResourcePoolFactory(taskRunner, asyncEventQueue, cullTimer);
    }

    public static ResourcePoolFactory createInstance(Queuable taskRunnerEventQueue, Timer cullTimer) {
        return createInstance(taskRunnerEventQueue, taskRunnerEventQueue == null ? null : taskRunnerEventQueue.asRunnableQueue(), cullTimer);
    }
}
