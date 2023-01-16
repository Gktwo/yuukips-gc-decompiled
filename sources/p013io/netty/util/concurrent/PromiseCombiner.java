package p013io.netty.util.concurrent;

import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.util.concurrent.PromiseCombiner */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/PromiseCombiner.class */
public final class PromiseCombiner {
    private int expectedCount;
    private int doneCount;
    private Promise<Void> aggregatePromise;
    private Throwable cause;
    private final GenericFutureListener<Future<?>> listener;
    private final EventExecutor executor;

    static /* synthetic */ int access$204(PromiseCombiner x0) {
        int i = x0.doneCount + 1;
        x0.doneCount = i;
        return i;
    }

    @Deprecated
    public PromiseCombiner() {
        this(ImmediateEventExecutor.INSTANCE);
    }

    public PromiseCombiner(EventExecutor executor) {
        this.listener = new GenericFutureListener<Future<?>>() { // from class: io.netty.util.concurrent.PromiseCombiner.1
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !PromiseCombiner.class.desiredAssertionStatus();
            }

            @Override // p013io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(final Future<?> future) {
                if (PromiseCombiner.this.executor.inEventLoop()) {
                    operationComplete0(future);
                } else {
                    PromiseCombiner.this.executor.execute(new Runnable() { // from class: io.netty.util.concurrent.PromiseCombiner.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C31561.this.operationComplete0(future);
                        }
                    });
                }
            }

            /* access modifiers changed from: private */
            public void operationComplete0(Future<?> future) {
                if ($assertionsDisabled || PromiseCombiner.this.executor.inEventLoop()) {
                    PromiseCombiner.access$204(PromiseCombiner.this);
                    if (!future.isSuccess() && PromiseCombiner.this.cause == null) {
                        PromiseCombiner.this.cause = future.cause();
                    }
                    if (PromiseCombiner.this.doneCount == PromiseCombiner.this.expectedCount && PromiseCombiner.this.aggregatePromise != null) {
                        PromiseCombiner.this.tryPromise();
                        return;
                    }
                    return;
                }
                throw new AssertionError();
            }
        };
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(executor, "executor");
    }

    @Deprecated
    public void add(Promise promise) {
        add((Future) promise);
    }

    public void add(Future future) {
        checkAddAllowed();
        checkInEventLoop();
        this.expectedCount++;
        future.addListener(this.listener);
    }

    @Deprecated
    public void addAll(Promise... promises) {
        addAll((Future[]) promises);
    }

    public void addAll(Future... futures) {
        for (Future future : futures) {
            add(future);
        }
    }

    public void finish(Promise<Void> aggregatePromise) {
        ObjectUtil.checkNotNull(aggregatePromise, "aggregatePromise");
        checkInEventLoop();
        if (this.aggregatePromise != null) {
            throw new IllegalStateException("Already finished");
        }
        this.aggregatePromise = aggregatePromise;
        if (this.doneCount == this.expectedCount) {
            tryPromise();
        }
    }

    private void checkInEventLoop() {
        if (!this.executor.inEventLoop()) {
            throw new IllegalStateException("Must be called from EventExecutor thread");
        }
    }

    /* access modifiers changed from: private */
    public boolean tryPromise() {
        return this.cause == null ? this.aggregatePromise.trySuccess(null) : this.aggregatePromise.tryFailure(this.cause);
    }

    private void checkAddAllowed() {
        if (this.aggregatePromise != null) {
            throw new IllegalStateException("Adding promises is not allowed after finished adding");
        }
    }
}
