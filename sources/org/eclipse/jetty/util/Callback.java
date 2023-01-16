package org.eclipse.jetty.util;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import org.eclipse.jetty.util.thread.Invocable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/Callback.class */
public interface Callback extends Invocable {
    public static final Callback NOOP = new Callback() { // from class: org.eclipse.jetty.util.Callback.1
        @Override // org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            return Invocable.InvocationType.NON_BLOCKING;
        }
    };

    default void succeeded() {
    }

    default void failed(Throwable x) {
    }

    static Callback from(CompletableFuture<?> completable) {
        return from(completable, Invocable.InvocationType.NON_BLOCKING);
    }

    static Callback from(final CompletableFuture<?> completable, final Invocable.InvocationType invocation) {
        if (completable instanceof Callback) {
            return (Callback) completable;
        }
        return new Callback() { // from class: org.eclipse.jetty.util.Callback.2
            @Override // org.eclipse.jetty.util.Callback
            public void succeeded() {
                completable.complete(null);
            }

            @Override // org.eclipse.jetty.util.Callback
            public void failed(Throwable x) {
                completable.completeExceptionally(x);
            }

            @Override // org.eclipse.jetty.util.thread.Invocable
            public Invocable.InvocationType getInvocationType() {
                return invocation;
            }
        };
    }

    static Callback from(Runnable success, Consumer<Throwable> failure) {
        return from(Invocable.InvocationType.BLOCKING, success, failure);
    }

    static Callback from(final Invocable.InvocationType invocationType, final Runnable success, final Consumer<Throwable> failure) {
        return new Callback() { // from class: org.eclipse.jetty.util.Callback.3
            @Override // org.eclipse.jetty.util.Callback
            public void succeeded() {
                success.run();
            }

            @Override // org.eclipse.jetty.util.Callback
            public void failed(Throwable x) {
                failure.accept(x);
            }

            @Override // org.eclipse.jetty.util.thread.Invocable
            public Invocable.InvocationType getInvocationType() {
                return invocationType;
            }
        };
    }

    static Callback from(final Runnable completed) {
        return new Completing() { // from class: org.eclipse.jetty.util.Callback.4
            @Override // org.eclipse.jetty.util.Callback.Completing
            public void completed() {
                completed.run();
            }
        };
    }

    static Callback from(Callback callback, final Runnable completed) {
        return new Nested(callback) { // from class: org.eclipse.jetty.util.Callback.5
            @Override // org.eclipse.jetty.util.Callback.Completing
            public void completed() {
                completed.run();
            }
        };
    }

    static Callback from(final Runnable completed, final Callback callback) {
        return new Callback() { // from class: org.eclipse.jetty.util.Callback.6
            @Override // org.eclipse.jetty.util.Callback
            public void succeeded() {
                try {
                    completed.run();
                    callback.succeeded();
                } catch (Throwable t) {
                    callback.failed(t);
                }
            }

            @Override // org.eclipse.jetty.util.Callback
            public void failed(Throwable x) {
                try {
                    completed.run();
                } catch (Throwable t) {
                    x.addSuppressed(t);
                }
                callback.failed(x);
            }
        };
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Callback$Completing.class */
    public static class Completing implements Callback {
        @Override // org.eclipse.jetty.util.Callback
        public void succeeded() {
            completed();
        }

        @Override // org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            completed();
        }

        public void completed() {
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Callback$Nested.class */
    public static class Nested extends Completing {
        private final Callback callback;

        public Nested(Callback callback) {
            this.callback = callback;
        }

        public Nested(Nested nested) {
            this.callback = nested.callback;
        }

        public Callback getCallback() {
            return this.callback;
        }

        @Override // org.eclipse.jetty.util.Callback.Completing, org.eclipse.jetty.util.Callback
        public void succeeded() {
            try {
                this.callback.succeeded();
            } finally {
                completed();
            }
        }

        @Override // org.eclipse.jetty.util.Callback.Completing, org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            try {
                this.callback.failed(x);
            } finally {
                completed();
            }
        }

        @Override // org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            return this.callback.getInvocationType();
        }
    }

    static Callback combine(Callback cb1, final Callback cb2) {
        if (cb1 == null || cb1 == cb2) {
            return cb2;
        }
        if (cb2 == null) {
            return cb1;
        }
        return new Callback() { // from class: org.eclipse.jetty.util.Callback.7
            @Override // org.eclipse.jetty.util.Callback
            public void succeeded() {
                try {
                    Callback.this.succeeded();
                } finally {
                    cb2.succeeded();
                }
            }

            @Override // org.eclipse.jetty.util.Callback
            public void failed(Throwable x) {
                try {
                    Callback.this.failed(x);
                } finally {
                    cb2.failed(x);
                }
            }

            @Override // org.eclipse.jetty.util.thread.Invocable
            public Invocable.InvocationType getInvocationType() {
                return Invocable.combine(Invocable.getInvocationType(Callback.this), Invocable.getInvocationType(cb2));
            }
        };
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Callback$Completable.class */
    public static class Completable extends CompletableFuture<Void> implements Callback {
        private final Invocable.InvocationType invocation;

        public Completable() {
            this(Invocable.InvocationType.NON_BLOCKING);
        }

        public Completable(Invocable.InvocationType invocation) {
            this.invocation = invocation;
        }

        @Override // org.eclipse.jetty.util.Callback
        public void succeeded() {
            complete(null);
        }

        @Override // org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            completeExceptionally(x);
        }

        @Override // org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            return this.invocation;
        }
    }
}
