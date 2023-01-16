package com.mchange.p009v2.lock;

/* renamed from: com.mchange.v2.lock.SharedUseExclusiveUseLock */
/* loaded from: grasscutter.jar:com/mchange/v2/lock/SharedUseExclusiveUseLock.class */
public interface SharedUseExclusiveUseLock {
    void acquireShared() throws InterruptedException;

    void relinquishShared();

    void acquireExclusive() throws InterruptedException;

    void relinquishExclusive();
}
