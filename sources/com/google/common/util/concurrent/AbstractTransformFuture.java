package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractTransformFuture.class */
public abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {
    ListenableFuture<? extends I> inputFuture;
    F function;

    @ForOverride
    abstract T doTransform(F f, I i) throws Exception;

    @ForOverride
    abstract void setResult(T t);

    /* access modifiers changed from: package-private */
    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> input, AsyncFunction<? super I, ? extends O> function, Executor executor) {
        Preconditions.checkNotNull(executor);
        AsyncTransformFuture<I, O> output = new AsyncTransformFuture<>(input, function);
        input.addListener(output, MoreExecutors.rejectionPropagatingExecutor(executor, output));
        return output;
    }

    /* access modifiers changed from: package-private */
    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> input, Function<? super I, ? extends O> function, Executor executor) {
        Preconditions.checkNotNull(function);
        TransformFuture<I, O> output = new TransformFuture<>(input, function);
        input.addListener(output, MoreExecutors.rejectionPropagatingExecutor(executor, output));
        return output;
    }

    AbstractTransformFuture(ListenableFuture<? extends I> inputFuture, F function) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(inputFuture);
        this.function = (F) Preconditions.checkNotNull(function);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.util.concurrent.AbstractTransformFuture<I, O, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture<? extends I> localInputFuture = this.inputFuture;
        F localFunction = this.function;
        if (!(isCancelled() | (localInputFuture == null)) && !(localFunction == null)) {
            this.inputFuture = null;
            if (localInputFuture.isCancelled()) {
                setFuture(localInputFuture);
                return;
            }
            try {
                try {
                    T transformResult = doTransform(localFunction, Futures.getDone(localInputFuture));
                    this.function = null;
                    setResult(transformResult);
                } catch (Throwable th) {
                    this.function = null;
                    throw th;
                }
            } catch (Error e) {
                setException(e);
            } catch (CancellationException e2) {
                cancel(false);
            } catch (RuntimeException e3) {
                setException(e3);
            } catch (ExecutionException e4) {
                setException(e4.getCause());
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected String pendingToString() {
        ListenableFuture<? extends I> localInputFuture = this.inputFuture;
        F localFunction = this.function;
        String superString = pendingToString();
        String resultString = "";
        if (localInputFuture != null) {
            resultString = "inputFuture=[" + localInputFuture + "], ";
        }
        if (localFunction != null) {
            return resultString + "function=[" + localFunction + "]";
        }
        if (superString != null) {
            return resultString + superString;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractTransformFuture$AsyncTransformFuture.class */
    public static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* bridge */ /* synthetic */ void setResult(Object obj) {
            setResult((ListenableFuture) ((ListenableFuture) obj));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* bridge */ /* synthetic */ Object doTransform(Object obj, Object obj2) throws Exception {
            return doTransform((AsyncFunction<? super AsyncFunction<? super I, ? extends O>, ? extends O>) ((AsyncFunction) obj), (AsyncFunction<? super I, ? extends O>) obj2);
        }

        AsyncTransformFuture(ListenableFuture<? extends I> inputFuture, AsyncFunction<? super I, ? extends O> function) {
            super(inputFuture, function);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: I */
        /* JADX WARN: Multi-variable type inference failed */
        ListenableFuture<? extends O> doTransform(AsyncFunction<? super I, ? extends O> function, I input) throws Exception {
            ListenableFuture<? extends O> outputFuture = function.apply(input);
            Preconditions.checkNotNull(outputFuture, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", function);
            return outputFuture;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.util.concurrent.ListenableFuture<? extends O> */
        /* JADX WARN: Multi-variable type inference failed */
        void setResult(ListenableFuture<? extends O> result) {
            setFuture(result);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractTransformFuture$TransformFuture.class */
    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* bridge */ /* synthetic */ Object doTransform(Object obj, Object obj2) throws Exception {
            return doTransform((Function<? super Function<? super I, ? extends O>, ? extends O>) ((Function) obj), (Function<? super I, ? extends O>) obj2);
        }

        TransformFuture(ListenableFuture<? extends I> inputFuture, Function<? super I, ? extends O> function) {
            super(inputFuture, function);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: I */
        /* JADX WARN: Multi-variable type inference failed */
        O doTransform(Function<? super I, ? extends O> function, I input) {
            return (O) function.apply(input);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        void setResult(O result) {
            set(result);
        }
    }
}
