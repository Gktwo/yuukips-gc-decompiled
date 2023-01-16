package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.errorprone.annotations.ForOverride;
import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractCatchingFuture.class */
public abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {
    ListenableFuture<? extends V> inputFuture;
    Class<X> exceptionType;
    F fallback;

    @ForOverride
    abstract T doFallback(F f, X x) throws Exception;

    @ForOverride
    abstract void setResult(T t);

    /* access modifiers changed from: package-private */
    public static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> input, Class<X> exceptionType, Function<? super X, ? extends V> fallback, Executor executor) {
        CatchingFuture<V, X> future = new CatchingFuture<>(input, exceptionType, fallback);
        input.addListener(future, MoreExecutors.rejectionPropagatingExecutor(executor, future));
        return future;
    }

    /* access modifiers changed from: package-private */
    public static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> input, Class<X> exceptionType, AsyncFunction<? super X, ? extends V> fallback, Executor executor) {
        AsyncCatchingFuture<V, X> future = new AsyncCatchingFuture<>(input, exceptionType, fallback);
        input.addListener(future, MoreExecutors.rejectionPropagatingExecutor(executor, future));
        return future;
    }

    AbstractCatchingFuture(ListenableFuture<? extends V> inputFuture, Class<X> exceptionType, F fallback) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(inputFuture);
        this.exceptionType = (Class) Preconditions.checkNotNull(exceptionType);
        this.fallback = (F) Preconditions.checkNotNull(fallback);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.util.concurrent.AbstractCatchingFuture<V, X extends java.lang.Throwable, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture<? extends V> localInputFuture = this.inputFuture;
        Class<X> localExceptionType = this.exceptionType;
        F localFallback = this.fallback;
        if (!((localInputFuture == null) | (localExceptionType == null) | (localFallback == null)) && !isCancelled()) {
            this.inputFuture = null;
            Object obj = null;
            Throwable throwable = null;
            try {
                obj = Futures.getDone(localInputFuture);
            } catch (ExecutionException e) {
                throwable = (Throwable) Preconditions.checkNotNull(e.getCause());
            } catch (Throwable e2) {
                throwable = e2;
            }
            if (throwable == null) {
                set(obj);
            } else if (!Platform.isInstanceOfThrowableClass(throwable, localExceptionType)) {
                setFuture(localInputFuture);
            } else {
                try {
                    T fallbackResult = doFallback(localFallback, throwable);
                    this.exceptionType = null;
                    this.fallback = null;
                    setResult(fallbackResult);
                } catch (Throwable th) {
                    this.exceptionType = null;
                    this.fallback = null;
                    throw th;
                }
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected String pendingToString() {
        ListenableFuture<? extends V> localInputFuture = this.inputFuture;
        Class<X> localExceptionType = this.exceptionType;
        F localFallback = this.fallback;
        String superString = pendingToString();
        String resultString = "";
        if (localInputFuture != null) {
            resultString = "inputFuture=[" + localInputFuture + "], ";
        }
        if (localExceptionType != null && localFallback != null) {
            return resultString + "exceptionType=[" + localExceptionType + "], fallback=[" + localFallback + "]";
        }
        if (superString != null) {
            return resultString + superString;
        }
        return null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractCatchingFuture$AsyncCatchingFuture.class */
    public static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* bridge */ /* synthetic */ void setResult(Object obj) {
            setResult((ListenableFuture) ((ListenableFuture) obj));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Throwable */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* bridge */ /* synthetic */ Object doFallback(Object obj, Throwable th) throws Exception {
            return doFallback((AsyncFunction<? super AsyncFunction<? super X, ? extends V>, ? extends V>) ((AsyncFunction) obj), (AsyncFunction<? super X, ? extends V>) th);
        }

        AsyncCatchingFuture(ListenableFuture<? extends V> input, Class<X> exceptionType, AsyncFunction<? super X, ? extends V> fallback) {
            super(input, exceptionType, fallback);
        }

        ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> fallback, X cause) throws Exception {
            ListenableFuture<? extends V> replacement = fallback.apply(cause);
            Preconditions.checkNotNull(replacement, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", fallback);
            return replacement;
        }

        void setResult(ListenableFuture<? extends V> result) {
            setFuture(result);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractCatchingFuture$CatchingFuture.class */
    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Throwable */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* bridge */ /* synthetic */ Object doFallback(Object obj, Throwable th) throws Exception {
            return doFallback((Function<? super Function<? super X, ? extends V>, ? extends V>) ((Function) obj), (Function<? super X, ? extends V>) th);
        }

        CatchingFuture(ListenableFuture<? extends V> input, Class<X> exceptionType, Function<? super X, ? extends V> fallback) {
            super(input, exceptionType, fallback);
        }

        V doFallback(Function<? super X, ? extends V> fallback, X cause) throws Exception {
            return (V) fallback.apply(cause);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        void setResult(V result) {
            set(result);
        }
    }
}
