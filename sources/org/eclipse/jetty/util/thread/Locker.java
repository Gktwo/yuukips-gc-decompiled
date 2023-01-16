package org.eclipse.jetty.util.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/Locker.class */
public class Locker {
    private final ReentrantLock _lock = new ReentrantLock();
    private final Lock _unlock = new Lock();

    public Lock lock() {
        this._lock.lock();
        return this._unlock;
    }

    @Deprecated
    public Lock lockIfNotHeld() {
        return lock();
    }

    public boolean isLocked() {
        return this._lock.isLocked();
    }

    public Condition newCondition() {
        return this._lock.newCondition();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/Locker$Lock.class */
    public class Lock implements AutoCloseable {
        public Lock() {
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            Locker.this._lock.unlock();
        }
    }

    @Deprecated
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/Locker$UnLock.class */
    public class UnLock extends Lock {
        public UnLock() {
            super();
        }
    }
}
