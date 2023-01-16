package com.mchange.p009v2.resourcepool;

import java.util.EventListener;

/* renamed from: com.mchange.v2.resourcepool.ResourcePoolListener */
/* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/ResourcePoolListener.class */
public interface ResourcePoolListener extends EventListener {
    void resourceAcquired(ResourcePoolEvent resourcePoolEvent);

    void resourceCheckedIn(ResourcePoolEvent resourcePoolEvent);

    void resourceCheckedOut(ResourcePoolEvent resourcePoolEvent);

    void resourceRemoved(ResourcePoolEvent resourcePoolEvent);
}
