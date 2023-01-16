package com.mchange.p009v2.resourcepool;

import com.mchange.p006v1.util.ClosableResource;

/* renamed from: com.mchange.v2.resourcepool.ResourcePool */
/* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/ResourcePool.class */
public interface ResourcePool extends ClosableResource {
    public static final int KNOWN_AND_AVAILABLE = 0;
    public static final int KNOWN_AND_CHECKED_OUT = 1;
    public static final int UNKNOWN_OR_PURGED = -1;

    /* renamed from: com.mchange.v2.resourcepool.ResourcePool$Manager */
    /* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/ResourcePool$Manager.class */
    public interface Manager {
        Object acquireResource() throws Exception;

        void refurbishIdleResource(Object obj) throws Exception;

        void refurbishResourceOnCheckout(Object obj) throws Exception;

        void refurbishResourceOnCheckin(Object obj) throws Exception;

        void destroyResource(Object obj, boolean z) throws Exception;
    }

    Object checkoutResource() throws ResourcePoolException, InterruptedException;

    Object checkoutResource(long j) throws TimeoutException, ResourcePoolException, InterruptedException;

    void checkinResource(Object obj) throws ResourcePoolException;

    void checkinAll() throws ResourcePoolException;

    int statusInPool(Object obj) throws ResourcePoolException;

    void markBroken(Object obj) throws ResourcePoolException;

    int getMinPoolSize() throws ResourcePoolException;

    int getMaxPoolSize() throws ResourcePoolException;

    int getPoolSize() throws ResourcePoolException;

    void setPoolSize(int i) throws ResourcePoolException;

    int getAvailableCount() throws ResourcePoolException;

    int getExcludedCount() throws ResourcePoolException;

    int getAwaitingCheckinCount() throws ResourcePoolException;

    int getAwaitingCheckinNotExcludedCount() throws ResourcePoolException;

    long getEffectiveExpirationEnforcementDelay() throws ResourcePoolException;

    long getStartTime() throws ResourcePoolException;

    long getUpTime() throws ResourcePoolException;

    long getNumFailedCheckins() throws ResourcePoolException;

    long getNumFailedCheckouts() throws ResourcePoolException;

    long getNumFailedIdleTests() throws ResourcePoolException;

    int getNumCheckoutWaiters() throws ResourcePoolException;

    Throwable getLastAcquisitionFailure() throws ResourcePoolException;

    Throwable getLastCheckinFailure() throws ResourcePoolException;

    Throwable getLastCheckoutFailure() throws ResourcePoolException;

    Throwable getLastIdleCheckFailure() throws ResourcePoolException;

    Throwable getLastResourceTestFailure() throws ResourcePoolException;

    void resetPool() throws ResourcePoolException;

    @Override // com.mchange.p006v1.util.ClosableResource
    void close() throws ResourcePoolException;

    void close(boolean z) throws ResourcePoolException;
}
