package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.j2objc.annotations.ReflectionSupport;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jline.builtins.Tmux;
import sun.misc.Unsafe;

@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractFuture.class */
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {
    private static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger log = Logger.getLogger(AbstractFuture.class.getName());
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final AtomicHelper ATOMIC_HELPER;
    private static final Object NULL;
    private volatile Object value;
    private volatile Listener listeners;
    private volatile Waiter waiters;

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractFuture$Trusted.class */
    public interface Trusted<V> extends ListenableFuture<V> {
    }

    static {
        AtomicHelper helper;
        Throwable thrownUnsafeFailure = null;
        Throwable thrownAtomicReferenceFieldUpdaterFailure = null;
        try {
            helper = new UnsafeAtomicHelper();
        } catch (Throwable unsafeFailure) {
            thrownUnsafeFailure = unsafeFailure;
            try {
                helper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, Tmux.CMD_NEXT), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));
            } catch (Throwable atomicReferenceFieldUpdaterFailure) {
                thrownAtomicReferenceFieldUpdaterFailure = atomicReferenceFieldUpdaterFailure;
                helper = new SynchronizedHelper();
            }
        }
        ATOMIC_HELPER = helper;
        if (thrownAtomicReferenceFieldUpdaterFailure != null) {
            log.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", thrownUnsafeFailure);
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", thrownAtomicReferenceFieldUpdaterFailure);
        }
        NULL = new Object();
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractFuture$TrustedFuture.class */
    public static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get() throws InterruptedException, ExecutionException {
            return get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return get(timeout, unit);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable listener, Executor executor) {
            addListener(listener, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final boolean cancel(boolean mayInterruptIfRunning) {
            return cancel(mayInterruptIfRunning);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractFuture$Waiter.class */
    public static final class Waiter {
        static final Waiter TOMBSTONE = new Waiter(false);
        volatile Thread thread;
        volatile Waiter next;

        Waiter(boolean unused) {
        }

        Waiter() {
            AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }

        void setNext(Waiter next) {
            AbstractFuture.ATOMIC_HELPER.putNext(this, next);
        }

        void unpark() {
            Thread w = this.thread;
            if (w != null) {
                this.thread = null;
                LockSupport.unpark(w);
            }
        }
    }

    private void removeWaiter(Waiter node) {
        node.thread = null;
        while (true) {
            Waiter pred = null;
            Waiter curr = this.waiters;
            if (curr != Waiter.TOMBSTONE) {
                while (curr != null) {
                    Waiter succ = curr.next;
                    if (curr.thread != null) {
                        pred = curr;
                    } else if (pred != null) {
                        pred.next = succ;
                        if (pred.thread == null) {
                            break;
                        }
                    } else if (!ATOMIC_HELPER.casWaiters(this, curr, succ)) {
                        break;
                    }
                    curr = succ;
                }
                return;
            }
            return;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractFuture$Listener.class */
    public static final class Listener {
        static final Listener TOMBSTONE = new Listener(null, null);
        final Runnable task;
        final Executor executor;
        Listener next;

        Listener(Runnable task, Executor executor) {
            this.task = task;
            this.executor = executor;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractFuture$Failure.class */
    public static final class Failure {
        static final Failure FALLBACK_INSTANCE = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable exception;

        Failure(Throwable exception) {
            this.exception = (Throwable) Preconditions.checkNotNull(exception);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractFuture$Cancellation.class */
    public static final class Cancellation {
        static final Cancellation CAUSELESS_INTERRUPTED;
        static final Cancellation CAUSELESS_CANCELLED;
        final boolean wasInterrupted;
        final Throwable cause;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                CAUSELESS_CANCELLED = null;
                CAUSELESS_INTERRUPTED = null;
                return;
            }
            CAUSELESS_CANCELLED = new Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new Cancellation(true, null);
        }

        Cancellation(boolean wasInterrupted, Throwable cause) {
            this.wasInterrupted = wasInterrupted;
            this.cause = cause;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractFuture$SetFuture.class */
    public static final class SetFuture<V> implements Runnable {
        final AbstractFuture<V> owner;
        final ListenableFuture<? extends V> future;

        SetFuture(AbstractFuture<V> owner, ListenableFuture<? extends V> future) {
            this.owner = owner;
            this.future = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((AbstractFuture) this.owner).value == this) {
                if (AbstractFuture.ATOMIC_HELPER.casValue(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
                    AbstractFuture.complete(this.owner);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v88, types: [long] */
    /* JADX WARN: Type inference failed for: r0v112, types: [long] */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0089, code lost:
        java.util.concurrent.locks.LockSupport.parkNanos(r6, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0092, code lost:
        if (java.lang.Thread.interrupted() == false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0095, code lost:
        removeWaiter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a2, code lost:
        throw new java.lang.InterruptedException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a3, code lost:
        r0 = r6.value;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ab, code lost:
        if (r0 == null) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ae, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b2, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b8, code lost:
        if ((r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture) != false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bb, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bf, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c1, code lost:
        if ((r0 & r1) == false) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ca, code lost:
        return getDoneValue(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cb, code lost:
        r12 = r0 - java.lang.System.nanoTime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d9, code lost:
        if (r12 >= 1000) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00dc, code lost:
        removeWaiter(r0);
     */
    @Override // java.util.concurrent.Future
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V get(long r7, java.util.concurrent.TimeUnit r9) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException, java.util.concurrent.ExecutionException {
        /*
        // Method dump skipped, instructions count: 674
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        java.util.concurrent.locks.LockSupport.park(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (java.lang.Thread.interrupted() == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0061, code lost:
        removeWaiter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006d, code lost:
        throw new java.lang.InterruptedException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006e, code lost:
        r0 = r5.value;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r0 == null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0077, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007b, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0080, code lost:
        if ((r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture) != false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0087, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0089, code lost:
        if ((r0 & r1) == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
        return getDoneValue(r0);
     */
    @Override // java.util.concurrent.Future
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V get() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        /*
            r5 = this;
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 == 0) goto L_0x000e
            java.lang.InterruptedException r0 = new java.lang.InterruptedException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x000e:
            r0 = r5
            java.lang.Object r0 = r0.value
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L_0x001b
            r0 = 1
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            r1 = r6
            boolean r1 = r1 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            if (r1 != 0) goto L_0x0027
            r1 = 1
            goto L_0x0028
        L_0x0027:
            r1 = 0
        L_0x0028:
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0032
            r0 = r5
            r1 = r6
            java.lang.Object r0 = r0.getDoneValue(r1)
            return r0
        L_0x0032:
            r0 = r5
            com.google.common.util.concurrent.AbstractFuture$Waiter r0 = r0.waiters
            r7 = r0
            r0 = r7
            com.google.common.util.concurrent.AbstractFuture$Waiter r1 = com.google.common.util.concurrent.AbstractFuture.Waiter.TOMBSTONE
            if (r0 == r1) goto L_0x009e
            com.google.common.util.concurrent.AbstractFuture$Waiter r0 = new com.google.common.util.concurrent.AbstractFuture$Waiter
            r1 = r0
            r1.<init>()
            r8 = r0
        L_0x0046:
            r0 = r8
            r1 = r7
            r0.setNext(r1)
            com.google.common.util.concurrent.AbstractFuture$AtomicHelper r0 = com.google.common.util.concurrent.AbstractFuture.ATOMIC_HELPER
            r1 = r5
            r2 = r7
            r3 = r8
            boolean r0 = r0.casWaiters(r1, r2, r3)
            if (r0 == 0) goto L_0x0092
        L_0x0057:
            r0 = r5
            java.util.concurrent.locks.LockSupport.park(r0)
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 == 0) goto L_0x006e
            r0 = r5
            r1 = r8
            r0.removeWaiter(r1)
            java.lang.InterruptedException r0 = new java.lang.InterruptedException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x006e:
            r0 = r5
            java.lang.Object r0 = r0.value
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L_0x007b
            r0 = 1
            goto L_0x007c
        L_0x007b:
            r0 = 0
        L_0x007c:
            r1 = r6
            boolean r1 = r1 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            if (r1 != 0) goto L_0x0087
            r1 = 1
            goto L_0x0088
        L_0x0087:
            r1 = 0
        L_0x0088:
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0057
            r0 = r5
            r1 = r6
            java.lang.Object r0 = r0.getDoneValue(r1)
            return r0
        L_0x0092:
            r0 = r5
            com.google.common.util.concurrent.AbstractFuture$Waiter r0 = r0.waiters
            r7 = r0
            r0 = r7
            com.google.common.util.concurrent.AbstractFuture$Waiter r1 = com.google.common.util.concurrent.AbstractFuture.Waiter.TOMBSTONE
            if (r0 != r1) goto L_0x0046
        L_0x009e:
            r0 = r5
            r1 = r5
            java.lang.Object r1 = r1.value
            java.lang.Object r0 = r0.getDoneValue(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.get():java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) obj).cause);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).exception);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object localValue = this.value;
        return (localValue != null) & (!(localValue instanceof SetFuture));
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public boolean cancel(boolean mayInterruptIfRunning) {
        Object localValue = this.value;
        boolean rValue = false;
        if ((localValue == null) || (localValue instanceof SetFuture)) {
            Object valueToSet = GENERATE_CANCELLATION_CAUSES ? new Cancellation(mayInterruptIfRunning, new CancellationException("Future.cancel() was called.")) : mayInterruptIfRunning ? Cancellation.CAUSELESS_INTERRUPTED : Cancellation.CAUSELESS_CANCELLED;
            AbstractFuture<V> abstractFuture = this;
            while (true) {
                if (ATOMIC_HELPER.casValue(abstractFuture, localValue, valueToSet)) {
                    rValue = true;
                    if (mayInterruptIfRunning) {
                        abstractFuture.interruptTask();
                    }
                    complete(abstractFuture);
                    if (!(localValue instanceof SetFuture)) {
                        break;
                    }
                    ListenableFuture<?> futureToPropagateTo = ((SetFuture) localValue).future;
                    if (!(futureToPropagateTo instanceof Trusted)) {
                        futureToPropagateTo.cancel(mayInterruptIfRunning);
                        break;
                    }
                    AbstractFuture<V> abstractFuture2 = (AbstractFuture) futureToPropagateTo;
                    localValue = abstractFuture2.value;
                    if (!(localValue == null) && !(localValue instanceof SetFuture)) {
                        break;
                    }
                    abstractFuture = abstractFuture2;
                } else {
                    localValue = abstractFuture.value;
                    if (!(localValue instanceof SetFuture)) {
                        break;
                    }
                }
            }
        }
        return rValue;
    }

    protected void interruptTask() {
    }

    protected final boolean wasInterrupted() {
        Object localValue = this.value;
        return (localValue instanceof Cancellation) && ((Cancellation) localValue).wasInterrupted;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable listener, Executor executor) {
        Preconditions.checkNotNull(listener, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        if (!isDone()) {
            Listener oldHead = this.listeners;
            if (oldHead != Listener.TOMBSTONE) {
                Listener newNode = new Listener(listener, executor);
                do {
                    newNode.next = oldHead;
                    if (!ATOMIC_HELPER.casListeners(this, oldHead, newNode)) {
                        oldHead = this.listeners;
                    } else {
                        return;
                    }
                } while (oldHead != Listener.TOMBSTONE);
            }
        }
        executeListener(listener, executor);
    }

    @CanIgnoreReturnValue
    protected boolean set(V value) {
        if (!ATOMIC_HELPER.casValue(this, null, value == null ? NULL : value)) {
            return false;
        }
        complete(this);
        return true;
    }

    /* access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean setException(Throwable throwable) {
        if (!ATOMIC_HELPER.casValue(this, null, new Failure((Throwable) Preconditions.checkNotNull(throwable)))) {
            return false;
        }
        complete(this);
        return true;
    }

    /* access modifiers changed from: protected */
    @CanIgnoreReturnValue
    @Beta
    public boolean setFuture(ListenableFuture<? extends V> future) {
        Failure failure;
        Preconditions.checkNotNull(future);
        Object localValue = this.value;
        if (localValue == null) {
            if (future.isDone()) {
                if (!ATOMIC_HELPER.casValue(this, null, getFutureValue(future))) {
                    return false;
                }
                complete(this);
                return true;
            }
            SetFuture valueToSet = new SetFuture(this, future);
            if (ATOMIC_HELPER.casValue(this, null, valueToSet)) {
                try {
                    future.addListener(valueToSet, DirectExecutor.INSTANCE);
                    return true;
                } catch (Throwable t) {
                    try {
                        failure = new Failure(t);
                    } catch (Throwable th) {
                        failure = Failure.FALLBACK_INSTANCE;
                    }
                    ATOMIC_HELPER.casValue(this, valueToSet, failure);
                    return true;
                }
            } else {
                localValue = this.value;
            }
        }
        if (!(localValue instanceof Cancellation)) {
            return false;
        }
        future.cancel(((Cancellation) localValue).wasInterrupted);
        return false;
    }

    /* access modifiers changed from: private */
    public static Object getFutureValue(ListenableFuture<?> future) {
        Throwable throwable;
        if (future instanceof Trusted) {
            Object v = ((AbstractFuture) future).value;
            if (v instanceof Cancellation) {
                Cancellation c = (Cancellation) v;
                if (c.wasInterrupted) {
                    v = c.cause != null ? new Cancellation(false, c.cause) : Cancellation.CAUSELESS_CANCELLED;
                }
            }
            return v;
        } else if ((future instanceof InternalFutureFailureAccess) && (throwable = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) future)) != null) {
            return new Failure(throwable);
        } else {
            boolean wasCancelled = future.isCancelled();
            if ((!GENERATE_CANCELLATION_CAUSES) && wasCancelled) {
                return Cancellation.CAUSELESS_CANCELLED;
            }
            try {
                Object v2 = getUninterruptibly(future);
                if (wasCancelled) {
                    return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + future));
                }
                return v2 == null ? NULL : v2;
            } catch (CancellationException cancellation) {
                if (!wasCancelled) {
                    return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + future, cancellation));
                }
                return new Cancellation(false, cancellation);
            } catch (ExecutionException exception) {
                if (wasCancelled) {
                    return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + future, exception));
                }
                return new Failure(exception.getCause());
            } catch (Throwable t) {
                return new Failure(t);
            }
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v;
        boolean interrupted = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException e) {
                interrupted = true;
            } catch (Throwable th) {
                if (interrupted) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (interrupted) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.google.common.util.concurrent.AbstractFuture<V>] */
    /* access modifiers changed from: private */
    public static void complete(AbstractFuture<?> future) {
        Listener next = null;
        while (true) {
            future.releaseWaiters();
            future.afterDone();
            next = future.clearListeners(next);
            while (next != null) {
                next = next.next;
                Runnable task = next.task;
                if (task instanceof SetFuture) {
                    SetFuture<?> setFuture = (SetFuture) task;
                    future = setFuture.owner;
                    if (((AbstractFuture) future).value == setFuture) {
                        if (ATOMIC_HELPER.casValue(future, setFuture, getFutureValue(setFuture.future))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    executeListener(task, next.executor);
                }
            }
            return;
        }
    }

    @Beta
    @ForOverride
    protected void afterDone() {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.internal.InternalFutureFailureAccess
    public final Throwable tryInternalFastPathGetFailure() {
        if (!(this instanceof Trusted)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    final void maybePropagateCancellationTo(Future<?> related) {
        if ((related != null) && isCancelled()) {
            related.cancel(wasInterrupted());
        }
    }

    private void releaseWaiters() {
        Waiter head;
        do {
            head = this.waiters;
        } while (!ATOMIC_HELPER.casWaiters(this, head, Waiter.TOMBSTONE));
        for (Waiter currentWaiter = head; currentWaiter != null; currentWaiter = currentWaiter.next) {
            currentWaiter.unpark();
        }
    }

    private Listener clearListeners(Listener onto) {
        Listener head;
        do {
            head = this.listeners;
        } while (!ATOMIC_HELPER.casListeners(this, head, Listener.TOMBSTONE));
        Listener reversedList = onto;
        while (head != null) {
            head = head.next;
            head.next = reversedList;
            reversedList = head;
        }
        return reversedList;
    }

    @Override // java.lang.Object
    public String toString() {
        String pendingDescription;
        StringBuilder builder = new StringBuilder().append(toString()).append("[status=");
        if (isCancelled()) {
            builder.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(builder);
        } else {
            try {
                pendingDescription = pendingToString();
            } catch (RuntimeException e) {
                pendingDescription = "Exception thrown from implementation: " + e.getClass();
            }
            if (pendingDescription != null && !pendingDescription.isEmpty()) {
                builder.append("PENDING, info=[").append(pendingDescription).append("]");
            } else if (isDone()) {
                addDoneString(builder);
            } else {
                builder.append("PENDING");
            }
        }
        return builder.append("]").toString();
    }

    protected String pendingToString() {
        Object localValue = this.value;
        if (localValue instanceof SetFuture) {
            return "setFuture=[" + userObjectToString(((SetFuture) localValue).future) + "]";
        }
        if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
        return null;
    }

    private void addDoneString(StringBuilder builder) {
        try {
            builder.append("SUCCESS, result=[").append(userObjectToString(getUninterruptibly(this))).append("]");
        } catch (CancellationException e) {
            builder.append("CANCELLED");
        } catch (RuntimeException e2) {
            builder.append("UNKNOWN, cause=[").append(e2.getClass()).append(" thrown from get()]");
        } catch (ExecutionException e3) {
            builder.append("FAILURE, cause=[").append(e3.getCause()).append("]");
        }
    }

    private String userObjectToString(Object o) {
        if (o == this) {
            return "this future";
        }
        return String.valueOf(o);
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractFuture$AtomicHelper.class */
    public static abstract class AtomicHelper {
        abstract void putThread(Waiter waiter, Thread thread);

        abstract void putNext(Waiter waiter, Waiter waiter2);

        abstract boolean casWaiters(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2);

        abstract boolean casListeners(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2);

        abstract boolean casValue(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        private AtomicHelper() {
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractFuture$UnsafeAtomicHelper.class */
    private static final class UnsafeAtomicHelper extends AtomicHelper {
        static final Unsafe UNSAFE;
        static final long LISTENERS_OFFSET;
        static final long WAITERS_OFFSET;
        static final long VALUE_OFFSET;
        static final long WAITER_THREAD_OFFSET;
        static final long WAITER_NEXT_OFFSET;

        private UnsafeAtomicHelper() {
            super();
        }

        static {
            Unsafe unsafe;
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (SecurityException e) {
                try {
                    unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.1
                        @Override // java.security.PrivilegedExceptionAction
                        public Unsafe run() throws Exception {
                            Field[] declaredFields = Unsafe.class.getDeclaredFields();
                            for (Field f : declaredFields) {
                                f.setAccessible(true);
                                Object x = f.get(null);
                                if (Unsafe.class.isInstance(x)) {
                                    return (Unsafe) Unsafe.class.cast(x);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            }
            try {
                WAITERS_OFFSET = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
                LISTENERS_OFFSET = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
                VALUE_OFFSET = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));
                WAITER_THREAD_OFFSET = unsafe.objectFieldOffset(Waiter.class.getDeclaredField("thread"));
                WAITER_NEXT_OFFSET = unsafe.objectFieldOffset(Waiter.class.getDeclaredField(Tmux.CMD_NEXT));
                UNSAFE = unsafe;
            } catch (Exception e3) {
                Throwables.throwIfUnchecked(e3);
                throw new RuntimeException(e3);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void putThread(Waiter waiter, Thread newValue) {
            UNSAFE.putObject(waiter, WAITER_THREAD_OFFSET, newValue);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void putNext(Waiter waiter, Waiter newValue) {
            UNSAFE.putObject(waiter, WAITER_NEXT_OFFSET, newValue);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casWaiters(AbstractFuture<?> future, Waiter expect, Waiter update) {
            return UNSAFE.compareAndSwapObject(future, WAITERS_OFFSET, expect, update);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casListeners(AbstractFuture<?> future, Listener expect, Listener update) {
            return UNSAFE.compareAndSwapObject(future, LISTENERS_OFFSET, expect, update);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casValue(AbstractFuture<?> future, Object expect, Object update) {
            return UNSAFE.compareAndSwapObject(future, VALUE_OFFSET, expect, update);
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractFuture$SafeAtomicHelper.class */
    private static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> waitersUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> listenersUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> waitersUpdater, AtomicReferenceFieldUpdater<AbstractFuture, Listener> listenersUpdater, AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater) {
            super();
            this.waiterThreadUpdater = waiterThreadUpdater;
            this.waiterNextUpdater = waiterNextUpdater;
            this.waitersUpdater = waitersUpdater;
            this.listenersUpdater = listenersUpdater;
            this.valueUpdater = valueUpdater;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void putThread(Waiter waiter, Thread newValue) {
            this.waiterThreadUpdater.lazySet(waiter, newValue);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void putNext(Waiter waiter, Waiter newValue) {
            this.waiterNextUpdater.lazySet(waiter, newValue);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casWaiters(AbstractFuture<?> future, Waiter expect, Waiter update) {
            return this.waitersUpdater.compareAndSet(future, expect, update);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casListeners(AbstractFuture<?> future, Listener expect, Listener update) {
            return this.listenersUpdater.compareAndSet(future, expect, update);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casValue(AbstractFuture<?> future, Object expect, Object update) {
            return this.valueUpdater.compareAndSet(future, expect, update);
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractFuture$SynchronizedHelper.class */
    private static final class SynchronizedHelper extends AtomicHelper {
        private SynchronizedHelper() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void putThread(Waiter waiter, Thread newValue) {
            waiter.thread = newValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void putNext(Waiter waiter, Waiter newValue) {
            waiter.next = newValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casWaiters(AbstractFuture<?> future, Waiter expect, Waiter update) {
            synchronized (future) {
                if (((AbstractFuture) future).waiters != expect) {
                    return false;
                }
                ((AbstractFuture) future).waiters = update;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casListeners(AbstractFuture<?> future, Listener expect, Listener update) {
            synchronized (future) {
                if (((AbstractFuture) future).listeners != expect) {
                    return false;
                }
                ((AbstractFuture) future).listeners = update;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casValue(AbstractFuture<?> future, Object expect, Object update) {
            synchronized (future) {
                if (((AbstractFuture) future).value != expect) {
                    return false;
                }
                ((AbstractFuture) future).value = update;
                return true;
            }
        }
    }

    private static CancellationException cancellationExceptionWithCause(String message, Throwable cause) {
        CancellationException exception = new CancellationException(message);
        exception.initCause(cause);
        return exception;
    }
}
