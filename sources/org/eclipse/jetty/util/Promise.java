package org.eclipse.jetty.util;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import org.eclipse.jetty.util.log.Log;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/Promise.class */
public interface Promise<C> {
    default void succeeded(C result) {
    }

    default void failed(Throwable x) {
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Promise$Adapter.class */
    public static class Adapter<U> implements Promise<U> {
        @Override // org.eclipse.jetty.util.Promise
        public void failed(Throwable x) {
            Log.getLogger(getClass()).warn(x);
        }
    }

    static <T> Promise<T> from(final CompletableFuture<? super T> completable) {
        if (completable instanceof Promise) {
            return (Promise) completable;
        }
        return new Promise<T>() { // from class: org.eclipse.jetty.util.Promise.1
            @Override // org.eclipse.jetty.util.Promise
            public void succeeded(T result) {
                completable.complete(result);
            }

            @Override // org.eclipse.jetty.util.Promise
            public void failed(Throwable x) {
                completable.completeExceptionally(x);
            }
        };
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Promise$Completable.class */
    public static class Completable<S> extends CompletableFuture<S> implements Promise<S> {
        @Override // org.eclipse.jetty.util.Promise
        public void succeeded(S result) {
            complete(result);
        }

        @Override // org.eclipse.jetty.util.Promise
        public void failed(Throwable x) {
            completeExceptionally(x);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Promise$Wrapper.class */
    public static class Wrapper<W> implements Promise<W> {
        private final Promise<W> promise;

        public Wrapper(Promise<W> promise) {
            this.promise = (Promise) Objects.requireNonNull(promise);
        }

        @Override // org.eclipse.jetty.util.Promise
        public void succeeded(W result) {
            this.promise.succeeded(result);
        }

        @Override // org.eclipse.jetty.util.Promise
        public void failed(Throwable x) {
            this.promise.failed(x);
        }

        public Promise<W> getPromise() {
            return this.promise;
        }

        public Promise<W> unwrap() {
            Promise<W> result = this.promise;
            while (result instanceof Wrapper) {
                result = ((Wrapper) result).unwrap();
            }
            return result;
        }
    }
}
