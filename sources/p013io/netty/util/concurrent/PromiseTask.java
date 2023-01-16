package p013io.netty.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import org.eclipse.jetty.util.component.AbstractLifeCycle;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.concurrent.PromiseTask */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/PromiseTask.class */
public class PromiseTask<V> extends DefaultPromise<V> implements RunnableFuture<V> {
    private static final Runnable COMPLETED = new SentinelRunnable("COMPLETED");
    private static final Runnable CANCELLED = new SentinelRunnable("CANCELLED");
    private static final Runnable FAILED = new SentinelRunnable(AbstractLifeCycle.FAILED);
    private Object task;

    /* renamed from: io.netty.util.concurrent.PromiseTask$RunnableAdapter */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/PromiseTask$RunnableAdapter.class */
    private static final class RunnableAdapter<T> implements Callable<T> {
        final Runnable task;
        final T result;

        RunnableAdapter(Runnable task, T result) {
            this.task = task;
            this.result = result;
        }

        @Override // java.util.concurrent.Callable
        public T call() {
            this.task.run();
            return this.result;
        }

        @Override // java.lang.Object
        public String toString() {
            return "Callable(task: " + this.task + ", result: " + this.result + ')';
        }
    }

    /* renamed from: io.netty.util.concurrent.PromiseTask$SentinelRunnable */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/PromiseTask$SentinelRunnable.class */
    private static class SentinelRunnable implements Runnable {
        private final String name;

        SentinelRunnable(String name) {
            this.name = name;
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        @Override // java.lang.Object
        public String toString() {
            return this.name;
        }
    }

    /* access modifiers changed from: package-private */
    public PromiseTask(EventExecutor executor, Runnable runnable, V result) {
        super(executor);
        this.task = result == null ? runnable : new RunnableAdapter(runnable, result);
    }

    /* access modifiers changed from: package-private */
    public PromiseTask(EventExecutor executor, Runnable runnable) {
        super(executor);
        this.task = runnable;
    }

    /* access modifiers changed from: package-private */
    public PromiseTask(EventExecutor executor, Callable<V> callable) {
        super(executor);
        this.task = callable;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        return this == obj;
    }

    /* access modifiers changed from: package-private */
    public V runTask() throws Throwable {
        Object task = this.task;
        if (task instanceof Callable) {
            return (V) ((Callable) task).call();
        }
        ((Runnable) task).run();
        return null;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        try {
            if (setUncancellableInternal()) {
                setSuccessInternal(runTask());
            }
        } catch (Throwable e) {
            setFailureInternal(e);
        }
    }

    private boolean clearTaskAfterCompletion(boolean done, Runnable result) {
        if (done) {
            this.task = result;
        }
        return done;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Promise, p013io.netty.channel.ChannelPromise
    public final Promise<V> setFailure(Throwable cause) {
        throw new IllegalStateException();
    }

    protected final Promise<V> setFailureInternal(Throwable cause) {
        setFailure(cause);
        clearTaskAfterCompletion(true, FAILED);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Promise
    public final boolean tryFailure(Throwable cause) {
        return false;
    }

    protected final boolean tryFailureInternal(Throwable cause) {
        return clearTaskAfterCompletion(tryFailure(cause), FAILED);
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.ProgressivePromise
    public final Promise<V> setSuccess(V result) {
        throw new IllegalStateException();
    }

    protected final Promise<V> setSuccessInternal(V result) {
        setSuccess(result);
        clearTaskAfterCompletion(true, COMPLETED);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Promise
    public final boolean trySuccess(V result) {
        return false;
    }

    protected final boolean trySuccessInternal(V result) {
        return clearTaskAfterCompletion(trySuccess(result), COMPLETED);
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Promise
    public final boolean setUncancellable() {
        throw new IllegalStateException();
    }

    protected final boolean setUncancellableInternal() {
        return setUncancellable();
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        return clearTaskAfterCompletion(cancel(mayInterruptIfRunning), CANCELLED);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.util.concurrent.DefaultPromise
    public StringBuilder toStringBuilder() {
        StringBuilder buf = toStringBuilder();
        buf.setCharAt(buf.length() - 1, ',');
        return buf.append(" task: ").append(this.task).append(')');
    }
}
