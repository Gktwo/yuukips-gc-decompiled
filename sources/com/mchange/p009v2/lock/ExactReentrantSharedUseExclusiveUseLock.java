package com.mchange.p009v2.lock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* renamed from: com.mchange.v2.lock.ExactReentrantSharedUseExclusiveUseLock */
/* loaded from: grasscutter.jar:com/mchange/v2/lock/ExactReentrantSharedUseExclusiveUseLock.class */
public class ExactReentrantSharedUseExclusiveUseLock implements SharedUseExclusiveUseLock {
    Set waitingShared;
    List activeShared;
    Set waitingExclusive;
    Thread activeExclusive;
    int exclusive_shared_reentries;
    int exclusive_exclusive_reentries;
    String name;

    public ExactReentrantSharedUseExclusiveUseLock(String str) {
        this.waitingShared = new HashSet();
        this.activeShared = new LinkedList();
        this.waitingExclusive = new HashSet();
        this.activeExclusive = null;
        this.exclusive_shared_reentries = 0;
        this.exclusive_exclusive_reentries = 0;
        this.name = str;
    }

    public ExactReentrantSharedUseExclusiveUseLock() {
        this(null);
    }

    void status(String str) {
        System.err.println(this + " -- after " + str);
        System.err.println("waitingShared: " + this.waitingShared);
        System.err.println("activeShared: " + this.activeShared);
        System.err.println("waitingExclusive: " + this.waitingExclusive);
        System.err.println("activeExclusive: " + this.activeExclusive);
        System.err.println("exclusive_shared_reentries: " + this.exclusive_shared_reentries);
        System.err.println("exclusive_exclusive_reentries: " + this.exclusive_exclusive_reentries);
        System.err.println(" ---- ");
        System.err.println();
    }

    @Override // com.mchange.p009v2.lock.SharedUseExclusiveUseLock
    public synchronized void acquireShared() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        if (currentThread == this.activeExclusive) {
            this.exclusive_shared_reentries++;
            return;
        }
        try {
            this.waitingShared.add(currentThread);
            while (!okayForShared()) {
                wait();
            }
            this.activeShared.add(currentThread);
        } finally {
            this.waitingShared.remove(currentThread);
        }
    }

    @Override // com.mchange.p009v2.lock.SharedUseExclusiveUseLock
    public synchronized void relinquishShared() {
        Thread currentThread = Thread.currentThread();
        if (currentThread == this.activeExclusive) {
            this.exclusive_shared_reentries--;
            if (this.exclusive_shared_reentries < 0) {
                throw new IllegalStateException(currentThread + " relinquished a shared lock (reentrant on exclusive) it did not hold!");
            }
        } else if (!this.activeShared.remove(currentThread)) {
            throw new IllegalStateException(currentThread + " relinquished a shared lock it did not hold!");
        } else {
            notifyAll();
        }
    }

    @Override // com.mchange.p009v2.lock.SharedUseExclusiveUseLock
    public synchronized void acquireExclusive() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        if (currentThread == this.activeExclusive) {
            this.exclusive_exclusive_reentries++;
            return;
        }
        try {
            this.waitingExclusive.add(currentThread);
            while (!okayForExclusive(currentThread)) {
                wait();
            }
            this.activeExclusive = currentThread;
        } finally {
            this.waitingExclusive.remove(currentThread);
        }
    }

    @Override // com.mchange.p009v2.lock.SharedUseExclusiveUseLock
    public synchronized void relinquishExclusive() {
        Thread currentThread = Thread.currentThread();
        if (currentThread != this.activeExclusive) {
            throw new IllegalStateException(currentThread + " relinquished an exclusive lock it did not hold!");
        } else if (this.exclusive_exclusive_reentries > 0) {
            this.exclusive_exclusive_reentries--;
        } else if (this.exclusive_shared_reentries != 0) {
            throw new IllegalStateException(currentThread + " relinquished an exclusive lock while it had reentered but not yet relinquished shared lock acquisitions!");
        } else {
            this.activeExclusive = null;
            notifyAll();
        }
    }

    private boolean okayForShared() {
        return this.activeExclusive == null && this.waitingExclusive.size() == 0;
    }

    private boolean okayForExclusive(Thread thread) {
        int size = this.activeShared.size();
        if (size == 0) {
            return this.activeExclusive == null;
        }
        if (size == 1) {
            return this.activeShared.get(0) == thread;
        }
        HashSet hashSet = new HashSet(this.activeShared);
        return hashSet.size() == 1 && hashSet.contains(thread);
    }

    public String toString() {
        return toString() + " [name=" + this.name + ']';
    }
}
