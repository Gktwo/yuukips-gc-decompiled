package com.mchange.p009v2.resourcepool;

/* renamed from: com.mchange.v2.resourcepool.NoGoodResourcesException */
/* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/NoGoodResourcesException.class */
public class NoGoodResourcesException extends ResourcePoolException {
    public NoGoodResourcesException(String msg, Throwable t) {
        super(msg, t);
    }

    public NoGoodResourcesException(Throwable t) {
        super(t);
    }

    public NoGoodResourcesException(String msg) {
        super(msg);
    }

    public NoGoodResourcesException() {
    }
}
