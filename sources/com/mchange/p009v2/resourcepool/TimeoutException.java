package com.mchange.p009v2.resourcepool;

/* renamed from: com.mchange.v2.resourcepool.TimeoutException */
/* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/TimeoutException.class */
public class TimeoutException extends ResourcePoolException {
    public TimeoutException(String msg, Throwable t) {
        super(msg, t);
    }

    public TimeoutException(Throwable t) {
        super(t);
    }

    public TimeoutException(String msg) {
        super(msg);
    }

    public TimeoutException() {
    }
}
