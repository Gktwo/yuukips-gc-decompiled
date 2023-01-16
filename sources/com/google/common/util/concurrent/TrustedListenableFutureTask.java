package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/TrustedListenableFutureTask.class */
public class TrustedListenableFutureTask<V> extends FluentFuture.TrustedFuture<V> implements RunnableFuture<V> {
    private volatile InterruptibleTask<?> task;

    /* access modifiers changed from: package-private */
    public static <V> TrustedListenableFutureTask<V> create(AsyncCallable<V> callable) {
        return new TrustedListenableFutureTask<>(callable);
    }

    /* access modifiers changed from: package-private */
    public static <V> TrustedListenableFutureTask<V> create(Callable<V> callable) {
        return new TrustedListenableFutureTask<>(callable);
    }

    /* access modifiers changed from: package-private */
    public static <V> TrustedListenableFutureTask<V> create(Runnable runnable, V result) {
        return new TrustedListenableFutureTask<>(Executors.callable(runnable, result));
    }

    TrustedListenableFutureTask(Callable<V> callable) {
        this.task = new TrustedFutureInterruptibleTask(callable);
    }

    TrustedListenableFutureTask(AsyncCallable<V> callable) {
        this.task = new TrustedFutureInterruptibleAsyncTask(callable);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        InterruptibleTask localTask = this.task;
        if (localTask != null) {
            localTask.run();
        }
        this.task = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected void afterDone() {
        InterruptibleTask localTask;
        afterDone();
        if (wasInterrupted() && (localTask = this.task) != null) {
            localTask.interruptTask();
        }
        this.task = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected String pendingToString() {
        InterruptibleTask localTask = this.task;
        if (localTask != null) {
            return "task=[" + localTask + "]";
        }
        return pendingToString();
    }

    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/TrustedListenableFutureTask$TrustedFutureInterruptibleTask.class */
    private final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;

        TrustedFutureInterruptibleTask(Callable<V> callable) {
            this.callable = (Callable) Preconditions.checkNotNull(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        void afterRanInterruptibly(V result, Throwable error) {
            if (error == null) {
                TrustedListenableFutureTask.this.set(result);
            } else {
                TrustedListenableFutureTask.this.setException(error);
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String toPendingString() {
            return this.callable.toString();
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/TrustedListenableFutureTask$TrustedFutureInterruptibleAsyncTask.class */
    private final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;

        @Override // com.google.common.util.concurrent.InterruptibleTask
        /* bridge */ /* synthetic */ void afterRanInterruptibly(Object obj, Throwable th) {
            afterRanInterruptibly((ListenableFuture) ((ListenableFuture) obj), th);
        }

        TrustedFutureInterruptibleAsyncTask(AsyncCallable<V> callable) {
            this.callable = (AsyncCallable) Preconditions.checkNotNull(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public ListenableFuture<V> runInterruptibly() throws Exception {
            return (ListenableFuture) Preconditions.checkNotNull(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }

        void afterRanInterruptibly(ListenableFuture<V> result, Throwable error) {
            if (error == null) {
                TrustedListenableFutureTask.this.setFuture(result);
            } else {
                TrustedListenableFutureTask.this.setException(error);
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String toPendingString() {
            return this.callable.toString();
        }
    }
}
