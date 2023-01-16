package com.mchange.p009v2.resourcepool;

/* renamed from: com.mchange.v2.resourcepool.CannotAcquireResourceException */
/* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/CannotAcquireResourceException.class */
public class CannotAcquireResourceException extends ResourcePoolException {
    public CannotAcquireResourceException(String msg, Throwable t) {
        super(msg, t);
    }

    public CannotAcquireResourceException(Throwable t) {
        super(t);
    }

    public CannotAcquireResourceException(String msg) {
        super(msg);
    }

    public CannotAcquireResourceException() {
    }
}
