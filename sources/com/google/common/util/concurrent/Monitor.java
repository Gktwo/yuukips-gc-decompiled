package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BooleanSupplier;

@Beta
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/Monitor.class */
public final class Monitor {
    private final boolean fair;
    private final ReentrantLock lock;
    @GuardedBy("lock")
    private Guard activeGuards;

    @Beta
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/Monitor$Guard.class */
    public static abstract class Guard {
        @Weak
        final Monitor monitor;
        final Condition condition;
        @GuardedBy("monitor.lock")
        int waiterCount = 0;
        @GuardedBy("monitor.lock")
        Guard next;

        public abstract boolean isSatisfied();

        /* access modifiers changed from: protected */
        public Guard(Monitor monitor) {
            this.monitor = (Monitor) Preconditions.checkNotNull(monitor, "monitor");
            this.condition = monitor.lock.newCondition();
        }
    }

    public Monitor() {
        this(false);
    }

    public Monitor(boolean fair) {
        this.activeGuards = null;
        this.fair = fair;
        this.lock = new ReentrantLock(fair);
    }

    public Guard newGuard(final BooleanSupplier isSatisfied) {
        Preconditions.checkNotNull(isSatisfied, "isSatisfied");
        return new Guard(this) { // from class: com.google.common.util.concurrent.Monitor.1
            @Override // com.google.common.util.concurrent.Monitor.Guard
            public boolean isSatisfied() {
                return isSatisfied.getAsBoolean();
            }
        };
    }

    public void enter() {
        this.lock.lock();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:15:0x0046
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public boolean enter(long r6, java.util.concurrent.TimeUnit r8) {
        /*
            r5 = this;
            r0 = r6
            r1 = r8
            long r0 = toSafeNanos(r0, r1)
            r9 = r0
            r0 = r5
            java.util.concurrent.locks.ReentrantLock r0 = r0.lock
            r11 = r0
            r0 = r5
            boolean r0 = r0.fair
            if (r0 != 0) goto L_0x001e
            r0 = r11
            boolean r0 = r0.tryLock()
            if (r0 == 0) goto L_0x001e
            r0 = 1
            return r0
        L_0x001e:
            boolean r0 = java.lang.Thread.interrupted()
            r12 = r0
            long r0 = java.lang.System.nanoTime()     // Catch: all -> 0x0057
            r13 = r0
            r0 = r9
            r15 = r0
        L_0x002c:
            r0 = r11
            r1 = r15
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: InterruptedException -> 0x0046, all -> 0x0057
            boolean r0 = r0.tryLock(r1, r2)     // Catch: InterruptedException -> 0x0046, all -> 0x0057
            r17 = r0
            r0 = r12
            if (r0 == 0) goto L_0x0043
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0043:
            r0 = r17
            return r0
        L_0x0046:
            r17 = move-exception
            r0 = 1
            r12 = r0
            r0 = r13
            r1 = r9
            long r0 = remainingNanos(r0, r1)     // Catch: all -> 0x0057
            r15 = r0
            goto L_0x002c
        L_0x0057:
            r18 = move-exception
            r0 = r12
            if (r0 == 0) goto L_0x0064
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0064:
            r0 = r18
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enter(long, java.util.concurrent.TimeUnit):boolean");
    }

    public void enterInterruptibly() throws InterruptedException {
        this.lock.lockInterruptibly();
    }

    public boolean enterInterruptibly(long time, TimeUnit unit) throws InterruptedException {
        return this.lock.tryLock(time, unit);
    }

    public boolean tryEnter() {
        return this.lock.tryLock();
    }

    public void enterWhen(Guard guard) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        boolean signalBeforeWaiting = lock.isHeldByCurrentThread();
        lock.lockInterruptibly();
        try {
            if (!guard.isSatisfied()) {
                await(guard, signalBeforeWaiting);
            }
            if (1 == 0) {
                leave();
            }
        } catch (Throwable th) {
            if (0 == 0) {
                leave();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r0v39, types: [long] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        if (r0.tryLock() != false) goto L_0x005c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean enterWhen(com.google.common.util.concurrent.Monitor.Guard r8, long r9, java.util.concurrent.TimeUnit r11) throws java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 230
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enterWhen(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public void enterWhenUninterruptibly(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        boolean signalBeforeWaiting = lock.isHeldByCurrentThread();
        lock.lock();
        try {
            if (!guard.isSatisfied()) {
                awaitUninterruptibly(guard, signalBeforeWaiting);
            }
            if (1 == 0) {
                leave();
            }
        } catch (Throwable th) {
            if (0 == 0) {
                leave();
            }
            throw th;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:20:0x0068
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public boolean enterWhenUninterruptibly(com.google.common.util.concurrent.Monitor.Guard r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
        // Method dump skipped, instructions count: 248
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enterWhenUninterruptibly(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public boolean enterIf(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        lock.lock();
        boolean satisfied = false;
        try {
            boolean isSatisfied = guard.isSatisfied();
            satisfied = isSatisfied;
            if (!satisfied) {
                lock.unlock();
            }
            return isSatisfied;
        } catch (Throwable th) {
            if (!satisfied) {
                lock.unlock();
            }
            throw th;
        }
    }

    public boolean enterIf(Guard guard, long time, TimeUnit unit) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        } else if (!enter(time, unit)) {
            return false;
        } else {
            boolean satisfied = false;
            try {
                boolean isSatisfied = guard.isSatisfied();
                satisfied = isSatisfied;
                if (!satisfied) {
                    this.lock.unlock();
                }
                return isSatisfied;
            } catch (Throwable th) {
                if (!satisfied) {
                    this.lock.unlock();
                }
                throw th;
            }
        }
    }

    public boolean enterIfInterruptibly(Guard guard) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        boolean satisfied = false;
        try {
            boolean isSatisfied = guard.isSatisfied();
            satisfied = isSatisfied;
            if (!satisfied) {
                lock.unlock();
            }
            return isSatisfied;
        } catch (Throwable th) {
            if (!satisfied) {
                lock.unlock();
            }
            throw th;
        }
    }

    public boolean enterIfInterruptibly(Guard guard, long time, TimeUnit unit) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        if (!lock.tryLock(time, unit)) {
            return false;
        }
        boolean satisfied = false;
        try {
            boolean isSatisfied = guard.isSatisfied();
            satisfied = isSatisfied;
            if (!satisfied) {
                lock.unlock();
            }
            return isSatisfied;
        } catch (Throwable th) {
            if (!satisfied) {
                lock.unlock();
            }
            throw th;
        }
    }

    public boolean tryEnterIf(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        if (!lock.tryLock()) {
            return false;
        }
        boolean satisfied = false;
        try {
            boolean isSatisfied = guard.isSatisfied();
            satisfied = isSatisfied;
            if (!satisfied) {
                lock.unlock();
            }
            return isSatisfied;
        } catch (Throwable th) {
            if (!satisfied) {
                lock.unlock();
            }
            throw th;
        }
    }

    public void waitFor(Guard guard) throws InterruptedException {
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (!guard.isSatisfied()) {
            await(guard, true);
        }
    }

    public boolean waitFor(Guard guard, long time, TimeUnit unit) throws InterruptedException {
        long timeoutNanos = toSafeNanos(time, unit);
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (guard.isSatisfied()) {
            return true;
        } else {
            if (!Thread.interrupted()) {
                return awaitNanos(guard, timeoutNanos, true);
            }
            throw new InterruptedException();
        }
    }

    public void waitForUninterruptibly(Guard guard) {
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (!guard.isSatisfied()) {
            awaitUninterruptibly(guard, true);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v25, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean waitForUninterruptibly(com.google.common.util.concurrent.Monitor.Guard r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r6 = this;
            r0 = r8
            r1 = r10
            long r0 = toSafeNanos(r0, r1)
            r11 = r0
            r0 = r7
            com.google.common.util.concurrent.Monitor r0 = r0.monitor
            r1 = r6
            if (r0 != r1) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            r1 = r6
            java.util.concurrent.locks.ReentrantLock r1 = r1.lock
            boolean r1 = r1.isHeldByCurrentThread()
            r0 = r0 & r1
            if (r0 != 0) goto L_0x0028
            java.lang.IllegalMonitorStateException r0 = new java.lang.IllegalMonitorStateException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0028:
            r0 = r7
            boolean r0 = r0.isSatisfied()
            if (r0 == 0) goto L_0x0031
            r0 = 1
            return r0
        L_0x0031:
            r0 = 1
            r13 = r0
            r0 = r11
            long r0 = initNanoTime(r0)
            r14 = r0
            boolean r0 = java.lang.Thread.interrupted()
            r16 = r0
            r0 = r11
            r17 = r0
        L_0x0044:
            r0 = r6
            r1 = r7
            r2 = r17
            r3 = r13
            boolean r0 = r0.awaitNanos(r1, r2, r3)     // Catch: all -> 0x0089, InterruptedException -> 0x005d
            r19 = r0
            r0 = r16
            if (r0 == 0) goto L_0x005a
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x005a:
            r0 = r19
            return r0
        L_0x005d:
            r19 = move-exception
            r0 = 1
            r16 = r0
            r0 = r7
            boolean r0 = r0.isSatisfied()     // Catch: all -> 0x0089
            if (r0 == 0) goto L_0x007a
            r0 = 1
            r20 = r0
            r0 = r16
            if (r0 == 0) goto L_0x0077
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0077:
            r0 = r20
            return r0
        L_0x007a:
            r0 = 0
            r13 = r0
            r0 = r14
            r1 = r11
            long r0 = remainingNanos(r0, r1)     // Catch: all -> 0x0089
            r17 = r0
            goto L_0x0044
        L_0x0089:
            r21 = move-exception
            r0 = r16
            if (r0 == 0) goto L_0x0096
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0096:
            r0 = r21
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.waitForUninterruptibly(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public void leave() {
        ReentrantLock lock = this.lock;
        try {
            if (lock.getHoldCount() == 1) {
                signalNextWaiter();
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean isFair() {
        return this.fair;
    }

    public boolean isOccupied() {
        return this.lock.isLocked();
    }

    public boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }

    public int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }

    public int getQueueLength() {
        return this.lock.getQueueLength();
    }

    public boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }

    public boolean hasQueuedThread(Thread thread) {
        return this.lock.hasQueuedThread(thread);
    }

    public boolean hasWaiters(Guard guard) {
        return getWaitQueueLength(guard) > 0;
    }

    public int getWaitQueueLength(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        this.lock.lock();
        try {
            return guard.waiterCount;
        } finally {
            this.lock.unlock();
        }
    }

    private static long toSafeNanos(long time, TimeUnit unit) {
        long timeoutNanos = unit.toNanos(time);
        if (timeoutNanos <= 0) {
            return 0;
        }
        if (timeoutNanos > 6917529027641081853L) {
            return 6917529027641081853L;
        }
        return timeoutNanos;
    }

    private static long initNanoTime(long timeoutNanos) {
        if (timeoutNanos <= 0) {
            return 0;
        }
        long startTime = System.nanoTime();
        if (startTime == 0) {
            return 1;
        }
        return startTime;
    }

    private static long remainingNanos(long startTime, long timeoutNanos) {
        if (timeoutNanos <= 0) {
            return 0;
        }
        return timeoutNanos - (System.nanoTime() - startTime);
    }

    @GuardedBy("lock")
    private void signalNextWaiter() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            if (isSatisfied(guard)) {
                guard.condition.signal();
                return;
            }
        }
    }

    @GuardedBy("lock")
    private boolean isSatisfied(Guard guard) {
        try {
            return guard.isSatisfied();
        } catch (Throwable throwable) {
            signalAllWaiters();
            throw throwable;
        }
    }

    @GuardedBy("lock")
    private void signalAllWaiters() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            guard.condition.signalAll();
        }
    }

    @GuardedBy("lock")
    private void beginWaitingFor(Guard guard) {
        int waiters = guard.waiterCount;
        guard.waiterCount = waiters + 1;
        if (waiters == 0) {
            guard.next = this.activeGuards;
            this.activeGuards = guard;
        }
    }

    @GuardedBy("lock")
    private void endWaitingFor(Guard guard) {
        int waiters = guard.waiterCount - 1;
        guard.waiterCount = waiters;
        if (waiters == 0) {
            Guard p = this.activeGuards;
            Guard pred = null;
            while (p != guard) {
                pred = p;
                p = p.next;
            }
            if (pred == null) {
                this.activeGuards = p.next;
            } else {
                pred.next = p.next;
            }
            p.next = null;
        }
    }

    @GuardedBy("lock")
    private void await(Guard guard, boolean signalBeforeWaiting) throws InterruptedException {
        if (signalBeforeWaiting) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.await();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    @GuardedBy("lock")
    private void awaitUninterruptibly(Guard guard, boolean signalBeforeWaiting) {
        if (signalBeforeWaiting) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.awaitUninterruptibly();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    @GuardedBy("lock")
    private boolean awaitNanos(Guard guard, long nanos, boolean signalBeforeWaiting) throws InterruptedException {
        boolean firstTime = true;
        while (nanos > 0) {
            if (firstTime) {
                if (signalBeforeWaiting) {
                    try {
                        signalNextWaiter();
                    } finally {
                        if (!firstTime) {
                            endWaitingFor(guard);
                        }
                    }
                }
                beginWaitingFor(guard);
                firstTime = false;
            }
            nanos = guard.condition.awaitNanos(nanos);
            if (guard.isSatisfied()) {
                if (!firstTime) {
                    endWaitingFor(guard);
                }
                return true;
            }
        }
        return false;
    }
}
