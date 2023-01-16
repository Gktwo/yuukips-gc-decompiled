package com.mchange.p009v2.resourcepool;

import com.mchange.lang.PotentiallySecondaryException;

/* renamed from: com.mchange.v2.resourcepool.ResourcePoolException */
/* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/ResourcePoolException.class */
public class ResourcePoolException extends PotentiallySecondaryException {
    public ResourcePoolException(String msg, Throwable t) {
        super(msg, t);
    }

    public ResourcePoolException(Throwable t) {
        super(t);
    }

    public ResourcePoolException(String msg) {
        super(msg);
    }

    public ResourcePoolException() {
    }
}
