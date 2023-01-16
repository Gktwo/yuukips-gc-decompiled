package com.mchange.p011v3.concurrent;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.mchange.v3.concurrent.BoundedExecutorService */
/* loaded from: grasscutter.jar:com/mchange/v3/concurrent/BoundedExecutorService.class */
public final class BoundedExecutorService extends AbstractExecutorService {
    static final MLogger logger = MLog.getLogger(BoundedExecutorService.class);
    final ExecutorService inner;
    final int blockBound;
    final int restartBeneath;
    State state;
    int permits;
    Map<Thread, Runnable> waiters;

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v3.concurrent.BoundedExecutorService$State */
    /* loaded from: grasscutter.jar:com/mchange/v3/concurrent/BoundedExecutorService$State.class */
    public enum State {
        ACCEPTING,
        SATURATED,
        UNWINDING,
        SHUTDOWN,
        SHUTDOWN_NOW
    }

    public BoundedExecutorService(ExecutorService executorService, int i, int i2) {
        this.waiters = new HashMap();
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("blockBound and restartBeneath must both be greater than zero!");
        } else if (i2 > i) {
            throw new IllegalArgumentException("restartBeneath must be less than or equal to blockBound!");
        } else {
            this.inner = executorService;
            this.blockBound = i;
            this.restartBeneath = i2;
            this.state = State.ACCEPTING;
            this.permits = 0;
        }
    }

    public BoundedExecutorService(ExecutorService executorService, int i) {
        this(executorService, i, i);
    }

    public synchronized State getState() {
        return this.state;
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized boolean isShutdown() {
        return this.state == State.SHUTDOWN || this.state == State.SHUTDOWN_NOW;
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized boolean isTerminated() {
        return isShutdown() && this.permits == 0;
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized void shutdown() {
        this.inner.shutdown();
        updateState(State.SHUTDOWN);
        notifyAll();
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized List<Runnable> shutdownNow() {
        updateState(State.SHUTDOWN_NOW);
        List<Runnable> shutdownNow = this.inner.shutdownNow();
        Collection<Runnable> values = this.waiters.values();
        ArrayList arrayList = new ArrayList(shutdownNow.size() + values.size());
        arrayList.addAll(shutdownNow);
        arrayList.addAll(values);
        for (Thread thread : this.waiters.keySet()) {
            thread.interrupt();
        }
        this.waiters.clear();
        return Collections.unmodifiableList(arrayList);
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(j, timeUnit);
        if (!this.inner.awaitTermination(j, timeUnit)) {
            return false;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        while (!isTerminated()) {
            if (currentTimeMillis2 > currentTimeMillis) {
                return false;
            }
            wait(currentTimeMillis - currentTimeMillis2);
        }
        return true;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.inner.execute(newTaskFor(runnable, null));
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <V> RunnableFuture<V> newTaskFor(Callable<V> callable) {
        ReleasingFutureTask releasingFutureTask = new ReleasingFutureTask(callable);
        acquirePermit(releasingFutureTask);
        return releasingFutureTask;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
        ReleasingFutureTask releasingFutureTask = new ReleasingFutureTask(runnable, v);
        acquirePermit(releasingFutureTask);
        return releasingFutureTask;
    }

    private boolean shouldWait() {
        switch (this.state) {
            case SHUTDOWN:
            case SHUTDOWN_NOW:
                return this.permits == this.blockBound;
            case ACCEPTING:
                return false;
            case SATURATED:
            case UNWINDING:
                return true;
            default:
                throw new AssertionError("This should be dead code.");
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x007c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private synchronized void acquirePermit(java.lang.Runnable r6) {
        /*
            r5 = this;
            int[] r0 = com.mchange.p011v3.concurrent.BoundedExecutorService.C09461.f423xaf7ac162     // Catch: InterruptedException -> 0x00b8
            r1 = r5
            com.mchange.v3.concurrent.BoundedExecutorService$State r1 = r1.state     // Catch: InterruptedException -> 0x00b8
            int r1 = r1.ordinal()     // Catch: InterruptedException -> 0x00b8
            r0 = r0[r1]     // Catch: InterruptedException -> 0x00b8
            switch(r0) {
                case 1: goto L_0x002c;
                case 2: goto L_0x002c;
                case 3: goto L_0x0053;
                case 4: goto L_0x0053;
                case 5: goto L_0x0053;
                default: goto L_0x00b5;
            }     // Catch: InterruptedException -> 0x00b8
        L_0x002c:
            java.util.concurrent.RejectedExecutionException r0 = new java.util.concurrent.RejectedExecutionException     // Catch: InterruptedException -> 0x00b8
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: InterruptedException -> 0x00b8
            r3 = r2
            r3.<init>()     // Catch: InterruptedException -> 0x00b8
            r3 = r5
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: InterruptedException -> 0x00b8
            java.lang.String r3 = " has been shut down. [state="
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: InterruptedException -> 0x00b8
            r3 = r5
            com.mchange.v3.concurrent.BoundedExecutorService$State r3 = r3.state     // Catch: InterruptedException -> 0x00b8
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: InterruptedException -> 0x00b8
            java.lang.String r3 = "]"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: InterruptedException -> 0x00b8
            java.lang.String r2 = r2.toString()     // Catch: InterruptedException -> 0x00b8
            r1.<init>(r2)     // Catch: InterruptedException -> 0x00b8
            throw r0     // Catch: InterruptedException -> 0x00b8
        L_0x0053:
            r0 = r5
            boolean r0 = r0.shouldWait()     // Catch: InterruptedException -> 0x00b8
            if (r0 == 0) goto L_0x008f
            r0 = r5
            java.util.Map<java.lang.Thread, java.lang.Runnable> r0 = r0.waiters     // Catch: all -> 0x007c, InterruptedException -> 0x00b8
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: all -> 0x007c, InterruptedException -> 0x00b8
            r2 = r6
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: all -> 0x007c, InterruptedException -> 0x00b8
            r0 = r5
            r0.wait()     // Catch: all -> 0x007c, InterruptedException -> 0x00b8
            r0 = r5
            java.util.Map<java.lang.Thread, java.lang.Runnable> r0 = r0.waiters     // Catch: InterruptedException -> 0x00b8
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: InterruptedException -> 0x00b8
            java.lang.Object r0 = r0.remove(r1)     // Catch: InterruptedException -> 0x00b8
            goto L_0x008c
        L_0x007c:
            r7 = move-exception
            r0 = r5
            java.util.Map<java.lang.Thread, java.lang.Runnable> r0 = r0.waiters     // Catch: InterruptedException -> 0x00b8
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: InterruptedException -> 0x00b8
            java.lang.Object r0 = r0.remove(r1)     // Catch: InterruptedException -> 0x00b8
            r0 = r7
            throw r0     // Catch: InterruptedException -> 0x00b8
        L_0x008c:
            goto L_0x0053
        L_0x008f:
            r0 = r5
            com.mchange.v3.concurrent.BoundedExecutorService$State r0 = r0.state     // Catch: InterruptedException -> 0x00b8
            com.mchange.v3.concurrent.BoundedExecutorService$State r1 = com.mchange.p011v3.concurrent.BoundedExecutorService.State.SHUTDOWN_NOW     // Catch: InterruptedException -> 0x00b8
            if (r0 == r1) goto L_0x00b5
            r0 = r5
            r1 = r0
            int r1 = r1.permits     // Catch: InterruptedException -> 0x00b8
            r2 = 1
            int r1 = r1 + r2
            r0.permits = r1     // Catch: InterruptedException -> 0x00b8
            r0 = r5
            int r0 = r0.permits     // Catch: InterruptedException -> 0x00b8
            r1 = r5
            int r1 = r1.blockBound     // Catch: InterruptedException -> 0x00b8
            if (r0 != r1) goto L_0x00b5
            r0 = r5
            com.mchange.v3.concurrent.BoundedExecutorService$State r1 = com.mchange.p011v3.concurrent.BoundedExecutorService.State.SATURATED     // Catch: InterruptedException -> 0x00b8
            r0.updateState(r1)     // Catch: InterruptedException -> 0x00b8
        L_0x00b5:
            goto L_0x00e1
        L_0x00b8:
            r7 = move-exception
            java.util.concurrent.RejectedExecutionException r0 = new java.util.concurrent.RejectedExecutionException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            r3 = r5
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " has been forcibly shut down. [state="
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r5
            com.mchange.v3.concurrent.BoundedExecutorService$State r3 = r3.state
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "]"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = r7
            r1.<init>(r2, r3)
            throw r0
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p011v3.concurrent.BoundedExecutorService.acquirePermit(java.lang.Runnable):void");
    }

    /* access modifiers changed from: private */
    public synchronized void releasePermit() {
        this.permits--;
        if (this.permits < this.restartBeneath) {
            updateState(State.ACCEPTING);
        } else if (this.state == State.SATURATED && this.permits < this.blockBound) {
            updateState(State.UNWINDING);
        }
    }

    private void updateState(State state) {
        switch (this.state) {
            case SHUTDOWN:
                if (state == State.SHUTDOWN_NOW) {
                    doUpdateState(state);
                    return;
                }
                return;
            case SHUTDOWN_NOW:
            default:
                return;
            case ACCEPTING:
            case SATURATED:
            case UNWINDING:
                if (this.state != state) {
                    doUpdateState(state);
                    return;
                }
                return;
        }
    }

    private void doUpdateState(State state) {
        if (logger.isLoggable(MLevel.FINE)) {
            logger.log(MLevel.FINE, "State transition " + this.state + " => " + state + "; blockBound=" + this.blockBound + "; restartBeneath=" + this.restartBeneath + "; permits=" + this.permits);
        }
        this.state = state;
        if (this.state == State.SHUTDOWN_NOW) {
            this.permits = 0;
        }
        notifyAll();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v3.concurrent.BoundedExecutorService$ReleasingFutureTask */
    /* loaded from: grasscutter.jar:com/mchange/v3/concurrent/BoundedExecutorService$ReleasingFutureTask.class */
    public class ReleasingFutureTask<V> extends FutureTask<V> {
        ReleasingFutureTask(Callable<V> callable) {
            super(callable);
        }

        ReleasingFutureTask(Runnable runnable, V v) {
            super(runnable, v);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            BoundedExecutorService.this.releasePermit();
        }
    }
}
