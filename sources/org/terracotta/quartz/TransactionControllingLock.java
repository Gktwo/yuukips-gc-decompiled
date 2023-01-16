package org.terracotta.quartz;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import org.terracotta.toolkit.ToolkitFeatureTypeInternal;
import org.terracotta.toolkit.atomic.ToolkitTransaction;
import org.terracotta.toolkit.atomic.ToolkitTransactionController;
import org.terracotta.toolkit.atomic.ToolkitTransactionType;
import org.terracotta.toolkit.concurrent.locks.ToolkitLock;
import org.terracotta.toolkit.concurrent.locks.ToolkitLockType;
import org.terracotta.toolkit.internal.ToolkitInternal;
import org.terracotta.toolkit.rejoin.RejoinException;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/terracotta/quartz/TransactionControllingLock.class */
public class TransactionControllingLock implements ToolkitLock {
    private final ThreadLocal<HoldState> threadState = new ThreadLocal<HoldState>() { // from class: org.terracotta.quartz.TransactionControllingLock.1
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public HoldState initialValue() {
            return new HoldState();
        }
    };
    private final ToolkitTransactionController txnController;
    private final ToolkitTransactionType txnType;
    private final ToolkitLock delegate;

    public TransactionControllingLock(ToolkitInternal toolkit, ToolkitLock lock, ToolkitTransactionType txnType) {
        this.txnController = toolkit.getFeature(ToolkitFeatureTypeInternal.TRANSACTION);
        this.txnType = txnType;
        this.delegate = lock;
    }

    public Condition newCondition() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public Condition getCondition() {
        throw new UnsupportedOperationException();
    }

    public ToolkitLockType getLockType() {
        return this.delegate.getLockType();
    }

    public boolean isHeldByCurrentThread() {
        return this.delegate.isHeldByCurrentThread();
    }

    public void lock() {
        this.delegate.lock();
        try {
            this.threadState.get().lock();
        } catch (RejoinException e) {
            this.delegate.unlock();
        }
    }

    public void lockInterruptibly() throws InterruptedException {
        this.delegate.lockInterruptibly();
        try {
            this.threadState.get().lock();
        } catch (RejoinException e) {
            this.delegate.unlock();
        }
    }

    public boolean tryLock() {
        if (!this.delegate.tryLock()) {
            return false;
        }
        try {
            this.threadState.get().lock();
            return true;
        } catch (RejoinException e) {
            this.delegate.unlock();
            return true;
        }
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        if (!this.delegate.tryLock(time, unit)) {
            return false;
        }
        try {
            this.threadState.get().lock();
            return true;
        } catch (RejoinException e) {
            this.delegate.unlock();
            return true;
        }
    }

    public void unlock() {
        try {
            this.threadState.get().unlock();
            this.delegate.unlock();
        } catch (Throwable th) {
            this.delegate.unlock();
            throw th;
        }
    }

    public String getName() {
        return this.delegate.getName();
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/terracotta/quartz/TransactionControllingLock$HoldState.class */
    public class HoldState {
        private ToolkitTransaction txnHandle;
        private int holdCount = 0;

        HoldState() {
        }

        void lock() {
            int i = this.holdCount;
            this.holdCount = i + 1;
            if (i != 0) {
                return;
            }
            if (this.txnHandle == null) {
                this.txnHandle = TransactionControllingLock.this.txnController.beginTransaction(TransactionControllingLock.this.txnType);
                return;
            }
            throw new AssertionError();
        }

        void unlock() {
            int i = this.holdCount - 1;
            this.holdCount = i;
            try {
                if (i <= 0) {
                    try {
                        this.txnHandle.commit();
                        TransactionControllingLock.this.threadState.remove();
                    } catch (RejoinException e) {
                        throw new RejoinException("Exception caught during commit, transaction may or may not have committed.", e);
                    }
                }
            } catch (Throwable th) {
                TransactionControllingLock.this.threadState.remove();
                throw th;
            }
        }
    }
}
