package p013io.netty.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p013io.netty.util.internal.InternalThreadLocalMap;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.ThrowableUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.concurrent.DefaultPromise */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/DefaultPromise.class */
public class DefaultPromise<V> extends AbstractFuture<V> implements Promise<V> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultPromise.class);
    private static final InternalLogger rejectedExecutionLogger = InternalLoggerFactory.getInstance(DefaultPromise.class.getName() + ".rejectedExecution");
    private static final int MAX_LISTENER_STACK_DEPTH = Math.min(8, SystemPropertyUtil.getInt("io.netty.defaultPromise.maxListenerStackDepth", 8));
    private static final AtomicReferenceFieldUpdater<DefaultPromise, Object> RESULT_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultPromise.class, Object.class, "result");
    private static final Object SUCCESS = new Object();
    private static final Object UNCANCELLABLE = new Object();
    private static final CauseHolder CANCELLATION_CAUSE_HOLDER = new CauseHolder(StacklessCancellationException.newInstance(DefaultPromise.class, "cancel(...)"));
    private static final StackTraceElement[] CANCELLATION_STACK = CANCELLATION_CAUSE_HOLDER.cause.getStackTrace();
    private volatile Object result;
    private final EventExecutor executor;
    private Object listeners;
    private short waiters;
    private boolean notifyingListeners;

    public DefaultPromise(EventExecutor executor) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(executor, "executor");
    }

    /* access modifiers changed from: protected */
    public DefaultPromise() {
        this.executor = null;
    }

    @Override // p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.ProgressivePromise
    public Promise<V> setSuccess(V result) {
        if (setSuccess0(result)) {
            return this;
        }
        throw new IllegalStateException("complete already: " + this);
    }

    @Override // p013io.netty.util.concurrent.Promise
    public boolean trySuccess(V result) {
        return setSuccess0(result);
    }

    @Override // p013io.netty.util.concurrent.Promise, p013io.netty.channel.ChannelPromise
    public Promise<V> setFailure(Throwable cause) {
        if (setFailure0(cause)) {
            return this;
        }
        throw new IllegalStateException("complete already: " + this, cause);
    }

    @Override // p013io.netty.util.concurrent.Promise
    public boolean tryFailure(Throwable cause) {
        return setFailure0(cause);
    }

    @Override // p013io.netty.util.concurrent.Promise
    public boolean setUncancellable() {
        if (RESULT_UPDATER.compareAndSet(this, null, UNCANCELLABLE)) {
            return true;
        }
        Object result = this.result;
        return !isDone0(result) || !isCancelled0(result);
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean isSuccess() {
        Object result = this.result;
        return (result == null || result == UNCANCELLABLE || (result instanceof CauseHolder)) ? false : true;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return this.result == null;
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.concurrent.DefaultPromise$LeanCancellationException */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/DefaultPromise$LeanCancellationException.class */
    public static final class LeanCancellationException extends CancellationException {
        private static final long serialVersionUID = 2794674970981187807L;

        private LeanCancellationException() {
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            setStackTrace(DefaultPromise.CANCELLATION_STACK);
            return this;
        }

        @Override // java.lang.Throwable, java.lang.Object
        public String toString() {
            return CancellationException.class.getName();
        }
    }

    @Override // p013io.netty.util.concurrent.Future
    public Throwable cause() {
        return cause0(this.result);
    }

    private Throwable cause0(Object result) {
        if (!(result instanceof CauseHolder)) {
            return null;
        }
        if (result == CANCELLATION_CAUSE_HOLDER) {
            CancellationException ce = new LeanCancellationException();
            if (RESULT_UPDATER.compareAndSet(this, CANCELLATION_CAUSE_HOLDER, new CauseHolder(ce))) {
                return ce;
            }
            result = this.result;
        }
        return ((CauseHolder) result).cause;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> listener) {
        ObjectUtil.checkNotNull(listener, "listener");
        synchronized (this) {
            addListener0(listener);
        }
        if (isDone()) {
            notifyListeners();
        }
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Promise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... listeners) {
        GenericFutureListener<? extends Future<? super V>> listener;
        ObjectUtil.checkNotNull(listeners, "listeners");
        synchronized (this) {
            int length = listeners.length;
            int i = 0;
            while (i < length && (listener = listeners[i]) != null) {
                addListener0(listener);
                i++;
            }
        }
        if (isDone()) {
            notifyListeners();
        }
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Promise<V> removeListener(GenericFutureListener<? extends Future<? super V>> listener) {
        ObjectUtil.checkNotNull(listener, "listener");
        synchronized (this) {
            removeListener0(listener);
        }
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Promise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... listeners) {
        GenericFutureListener<? extends Future<? super V>> listener;
        ObjectUtil.checkNotNull(listeners, "listeners");
        synchronized (this) {
            int length = listeners.length;
            int i = 0;
            while (i < length && (listener = listeners[i]) != null) {
                removeListener0(listener);
                i++;
            }
        }
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Promise<V> await() throws InterruptedException {
        if (isDone()) {
            return this;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException(toString());
        }
        checkDeadLock();
        synchronized (this) {
            while (!isDone()) {
                incWaiters();
                wait();
                decWaiters();
            }
        }
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Promise<V> awaitUninterruptibly() {
        if (isDone()) {
            return this;
        }
        checkDeadLock();
        boolean interrupted = false;
        synchronized (this) {
            while (!isDone()) {
                incWaiters();
                try {
                    wait();
                    decWaiters();
                } catch (InterruptedException e) {
                    interrupted = true;
                    decWaiters();
                } catch (Throwable th) {
                    decWaiters();
                    throw th;
                }
            }
        }
        if (interrupted) {
            Thread.currentThread().interrupt();
        }
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        return await0(unit.toNanos(timeout), true);
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean await(long timeoutMillis) throws InterruptedException {
        return await0(TimeUnit.MILLISECONDS.toNanos(timeoutMillis), true);
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long timeout, TimeUnit unit) {
        try {
            return await0(unit.toNanos(timeout), false);
        } catch (InterruptedException e) {
            throw new InternalError();
        }
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long timeoutMillis) {
        try {
            return await0(TimeUnit.MILLISECONDS.toNanos(timeoutMillis), false);
        } catch (InterruptedException e) {
            throw new InternalError();
        }
    }

    @Override // p013io.netty.util.concurrent.Future
    public V getNow() {
        V v = (V) this.result;
        if ((v instanceof CauseHolder) || v == SUCCESS || v == UNCANCELLABLE) {
            return null;
        }
        return v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        Object result = (V) this.result;
        if (!isDone0(result)) {
            await();
            result = (V) this.result;
        }
        if (result == SUCCESS || result == UNCANCELLABLE) {
            return null;
        }
        Throwable cause = cause0(result);
        if (cause == null) {
            return (V) result;
        }
        if (cause instanceof CancellationException) {
            throw ((CancellationException) cause);
        }
        throw new ExecutionException(cause);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        Object result = (V) this.result;
        if (!isDone0(result)) {
            if (!await(timeout, unit)) {
                throw new TimeoutException();
            }
            result = (V) this.result;
        }
        if (result == SUCCESS || result == UNCANCELLABLE) {
            return null;
        }
        Throwable cause = cause0(result);
        if (cause == null) {
            return (V) result;
        }
        if (cause instanceof CancellationException) {
            throw ((CancellationException) cause);
        }
        throw new ExecutionException(cause);
    }

    @Override // p013io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        if (!RESULT_UPDATER.compareAndSet(this, null, CANCELLATION_CAUSE_HOLDER)) {
            return false;
        }
        if (!checkNotifyWaiters()) {
            return true;
        }
        notifyListeners();
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return isCancelled0(this.result);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return isDone0(this.result);
    }

    @Override // p013io.netty.util.concurrent.Future
    public Promise<V> sync() throws InterruptedException {
        await();
        rethrowIfFailed();
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Promise<V> syncUninterruptibly() {
        awaitUninterruptibly();
        rethrowIfFailed();
        return this;
    }

    @Override // java.lang.Object
    public String toString() {
        return toStringBuilder().toString();
    }

    /* access modifiers changed from: protected */
    public StringBuilder toStringBuilder() {
        StringBuilder buf = new StringBuilder(64).append(StringUtil.simpleClassName(this)).append('@').append(Integer.toHexString(hashCode()));
        Object result = this.result;
        if (result == SUCCESS) {
            buf.append("(success)");
        } else if (result == UNCANCELLABLE) {
            buf.append("(uncancellable)");
        } else if (result instanceof CauseHolder) {
            buf.append("(failure: ").append(((CauseHolder) result).cause).append(')');
        } else if (result != null) {
            buf.append("(success: ").append(result).append(')');
        } else {
            buf.append("(incomplete)");
        }
        return buf;
    }

    /* access modifiers changed from: protected */
    public EventExecutor executor() {
        return this.executor;
    }

    /* access modifiers changed from: protected */
    public void checkDeadLock() {
        EventExecutor e = executor();
        if (e != null && e.inEventLoop()) {
            throw new BlockingOperationException(toString());
        }
    }

    /* access modifiers changed from: protected */
    public static void notifyListener(EventExecutor eventExecutor, Future<?> future, GenericFutureListener<?> listener) {
        notifyListenerWithStackOverFlowProtection((EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "eventExecutor"), (Future) ObjectUtil.checkNotNull(future, "future"), (GenericFutureListener) ObjectUtil.checkNotNull(listener, "listener"));
    }

    private void notifyListeners() {
        InternalThreadLocalMap threadLocals;
        int stackDepth;
        EventExecutor executor = executor();
        if (!executor.inEventLoop() || (stackDepth = (threadLocals = InternalThreadLocalMap.get()).futureListenerStackDepth()) >= MAX_LISTENER_STACK_DEPTH) {
            safeExecute(executor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.1
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.this.notifyListenersNow();
                }
            });
            return;
        }
        threadLocals.setFutureListenerStackDepth(stackDepth + 1);
        try {
            notifyListenersNow();
            threadLocals.setFutureListenerStackDepth(stackDepth);
        } catch (Throwable th) {
            threadLocals.setFutureListenerStackDepth(stackDepth);
            throw th;
        }
    }

    private static void notifyListenerWithStackOverFlowProtection(EventExecutor executor, final Future<?> future, final GenericFutureListener<?> listener) {
        InternalThreadLocalMap threadLocals;
        int stackDepth;
        if (!executor.inEventLoop() || (stackDepth = (threadLocals = InternalThreadLocalMap.get()).futureListenerStackDepth()) >= MAX_LISTENER_STACK_DEPTH) {
            safeExecute(executor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.2
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyListener0(future, listener);
                }
            });
            return;
        }
        threadLocals.setFutureListenerStackDepth(stackDepth + 1);
        try {
            notifyListener0(future, listener);
            threadLocals.setFutureListenerStackDepth(stackDepth);
        } catch (Throwable th) {
            threadLocals.setFutureListenerStackDepth(stackDepth);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void notifyListenersNow() {
        synchronized (this) {
            if (!this.notifyingListeners && this.listeners != null) {
                this.notifyingListeners = true;
                Object listeners = this.listeners;
                this.listeners = null;
                while (true) {
                    if (listeners instanceof DefaultFutureListeners) {
                        notifyListeners0((DefaultFutureListeners) listeners);
                    } else {
                        notifyListener0(this, (GenericFutureListener) listeners);
                    }
                    synchronized (this) {
                        if (this.listeners == null) {
                            this.notifyingListeners = false;
                            return;
                        } else {
                            listeners = this.listeners;
                            this.listeners = null;
                        }
                    }
                }
            }
        }
    }

    private void notifyListeners0(DefaultFutureListeners listeners) {
        GenericFutureListener<?>[] a = listeners.listeners();
        int size = listeners.size();
        for (int i = 0; i < size; i++) {
            notifyListener0(this, a[i]);
        }
    }

    /* access modifiers changed from: private */
    public static void notifyListener0(Future future, GenericFutureListener l) {
        try {
            l.operationComplete(future);
        } catch (Throwable t) {
            if (logger.isWarnEnabled()) {
                logger.warn("An exception was thrown by " + l.getClass().getName() + ".operationComplete()", t);
            }
        }
    }

    private void addListener0(GenericFutureListener<? extends Future<? super V>> listener) {
        if (this.listeners == null) {
            this.listeners = listener;
        } else if (this.listeners instanceof DefaultFutureListeners) {
            ((DefaultFutureListeners) this.listeners).add(listener);
        } else {
            this.listeners = new DefaultFutureListeners((GenericFutureListener) this.listeners, listener);
        }
    }

    private void removeListener0(GenericFutureListener<? extends Future<? super V>> listener) {
        if (this.listeners instanceof DefaultFutureListeners) {
            ((DefaultFutureListeners) this.listeners).remove(listener);
        } else if (this.listeners == listener) {
            this.listeners = null;
        }
    }

    private boolean setSuccess0(V result) {
        return setValue0(result == null ? SUCCESS : result);
    }

    private boolean setFailure0(Throwable cause) {
        return setValue0(new CauseHolder((Throwable) ObjectUtil.checkNotNull(cause, "cause")));
    }

    private boolean setValue0(Object objResult) {
        if (!RESULT_UPDATER.compareAndSet(this, null, objResult) && !RESULT_UPDATER.compareAndSet(this, UNCANCELLABLE, objResult)) {
            return false;
        }
        if (!checkNotifyWaiters()) {
            return true;
        }
        notifyListeners();
        return true;
    }

    private synchronized boolean checkNotifyWaiters() {
        if (this.waiters > 0) {
            notifyAll();
        }
        return this.listeners != null;
    }

    private void incWaiters() {
        if (this.waiters == Short.MAX_VALUE) {
            throw new IllegalStateException("too many waiters: " + this);
        }
        this.waiters = (short) (this.waiters + 1);
    }

    private void decWaiters() {
        this.waiters = (short) (this.waiters - 1);
    }

    private void rethrowIfFailed() {
        Throwable cause = cause();
        if (cause != null) {
            PlatformDependent.throwException(cause);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:27:0x0068
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private boolean await0(long r9, boolean r11) throws java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 219
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.concurrent.DefaultPromise.await0(long, boolean):boolean");
    }

    void notifyProgressiveListeners(final long progress, final long total) {
        Object listeners = progressiveListeners();
        if (listeners != null) {
            final ProgressiveFuture<V> self = (ProgressiveFuture) this;
            EventExecutor executor = executor();
            if (executor.inEventLoop()) {
                if (listeners instanceof GenericProgressiveFutureListener[]) {
                    notifyProgressiveListeners0(self, (GenericProgressiveFutureListener[]) listeners, progress, total);
                } else {
                    notifyProgressiveListener0(self, (GenericProgressiveFutureListener) listeners, progress, total);
                }
            } else if (listeners instanceof GenericProgressiveFutureListener[]) {
                final GenericProgressiveFutureListener<?>[] array = (GenericProgressiveFutureListener[]) listeners;
                safeExecute(executor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.3
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultPromise.notifyProgressiveListeners0(self, array, progress, total);
                    }
                });
            } else {
                final GenericProgressiveFutureListener<ProgressiveFuture<V>> l = (GenericProgressiveFutureListener) listeners;
                safeExecute(executor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultPromise.notifyProgressiveListener0(self, l, progress, total);
                    }
                });
            }
        }
    }

    private synchronized Object progressiveListeners() {
        Object listeners = this.listeners;
        if (listeners == null) {
            return null;
        }
        if (listeners instanceof DefaultFutureListeners) {
            DefaultFutureListeners dfl = (DefaultFutureListeners) listeners;
            int progressiveSize = dfl.progressiveSize();
            switch (progressiveSize) {
                case 0:
                    return null;
                case 1:
                    GenericFutureListener<?>[] listeners2 = dfl.listeners();
                    for (GenericFutureListener<?> l : listeners2) {
                        if (l instanceof GenericProgressiveFutureListener) {
                            return l;
                        }
                    }
                    return null;
                default:
                    GenericFutureListener<?>[] array = dfl.listeners();
                    GenericProgressiveFutureListener<?>[] copy = new GenericProgressiveFutureListener[progressiveSize];
                    int i = 0;
                    int j = 0;
                    while (j < progressiveSize) {
                        GenericFutureListener<?> l2 = array[i];
                        if (l2 instanceof GenericProgressiveFutureListener) {
                            j++;
                            copy[j] = (GenericProgressiveFutureListener) l2;
                        }
                        i++;
                    }
                    return copy;
            }
        } else if (listeners instanceof GenericProgressiveFutureListener) {
            return listeners;
        } else {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void notifyProgressiveListeners0(ProgressiveFuture<?> future, GenericProgressiveFutureListener<?>[] listeners, long progress, long total) {
        GenericProgressiveFutureListener<?> l;
        int length = listeners.length;
        int i = 0;
        while (i < length && (l = listeners[i]) != null) {
            notifyProgressiveListener0(future, l, progress, total);
            i++;
        }
    }

    /* access modifiers changed from: private */
    public static void notifyProgressiveListener0(ProgressiveFuture future, GenericProgressiveFutureListener l, long progress, long total) {
        try {
            l.operationProgressed(future, progress, total);
        } catch (Throwable t) {
            if (logger.isWarnEnabled()) {
                logger.warn("An exception was thrown by " + l.getClass().getName() + ".operationProgressed()", t);
            }
        }
    }

    private static boolean isCancelled0(Object result) {
        return (result instanceof CauseHolder) && (((CauseHolder) result).cause instanceof CancellationException);
    }

    private static boolean isDone0(Object result) {
        return (result == null || result == UNCANCELLABLE) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.concurrent.DefaultPromise$CauseHolder */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/DefaultPromise$CauseHolder.class */
    public static final class CauseHolder {
        final Throwable cause;

        CauseHolder(Throwable cause) {
            this.cause = cause;
        }
    }

    private static void safeExecute(EventExecutor executor, Runnable task) {
        try {
            executor.execute(task);
        } catch (Throwable t) {
            rejectedExecutionLogger.error("Failed to submit a listener notification task. Event loop shut down?", t);
        }
    }

    /* renamed from: io.netty.util.concurrent.DefaultPromise$StacklessCancellationException */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/DefaultPromise$StacklessCancellationException.class */
    private static final class StacklessCancellationException extends CancellationException {
        private static final long serialVersionUID = -2974906711413716191L;

        private StacklessCancellationException() {
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        static StacklessCancellationException newInstance(Class<?> clazz, String method) {
            return (StacklessCancellationException) ThrowableUtil.unknownStackTrace(new StacklessCancellationException(), clazz, method);
        }
    }
}
