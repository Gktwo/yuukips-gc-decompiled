package org.eclipse.jetty.util.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/TryExecutor.class */
public interface TryExecutor extends Executor {
    public static final TryExecutor NO_TRY = new TryExecutor() { // from class: org.eclipse.jetty.util.thread.TryExecutor.1
        @Override // org.eclipse.jetty.util.thread.TryExecutor
        public boolean tryExecute(Runnable task) {
            return false;
        }

        @Override // java.lang.Object
        public String toString() {
            return "NO_TRY";
        }
    };

    boolean tryExecute(Runnable runnable);

    @Override // org.eclipse.jetty.util.thread.TryExecutor
    default void execute(Runnable task) {
        if (!tryExecute(task)) {
            throw new RejectedExecutionException();
        }
    }

    static TryExecutor asTryExecutor(Executor executor) {
        if (executor instanceof TryExecutor) {
            return (TryExecutor) executor;
        }
        return new NoTryExecutor(executor);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/TryExecutor$NoTryExecutor.class */
    public static class NoTryExecutor implements TryExecutor {
        private final Executor executor;

        public NoTryExecutor(Executor executor) {
            this.executor = executor;
        }

        @Override // org.eclipse.jetty.util.thread.TryExecutor
        public void execute(Runnable task) {
            this.executor.execute(task);
        }

        @Override // org.eclipse.jetty.util.thread.TryExecutor
        public boolean tryExecute(Runnable task) {
            return false;
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("%s@%x[%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), this.executor);
        }
    }
}
