package com.mchange.p009v2.resourcepool;

/* renamed from: com.mchange.v2.resourcepool.EventSupportingResourcePool */
/* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/EventSupportingResourcePool.class */
public interface EventSupportingResourcePool extends ResourcePool {
    void addResourcePoolListener(ResourcePoolListener resourcePoolListener) throws ResourcePoolException;

    void removeResourcePoolListener(ResourcePoolListener resourcePoolListener) throws ResourcePoolException;
}
