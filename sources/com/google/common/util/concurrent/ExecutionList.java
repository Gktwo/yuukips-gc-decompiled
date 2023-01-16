package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/ExecutionList.class */
public final class ExecutionList {
    private static final Logger log = Logger.getLogger(ExecutionList.class.getName());
    @GuardedBy("this")
    private RunnableExecutorPair runnables;
    @GuardedBy("this")
    private boolean executed;

    public void add(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        synchronized (this) {
            if (!this.executed) {
                this.runnables = new RunnableExecutorPair(runnable, executor, this.runnables);
            } else {
                executeListener(runnable, executor);
            }
        }
    }

    public void execute() {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                RunnableExecutorPair list = this.runnables;
                this.runnables = null;
                RunnableExecutorPair reversedList = null;
                while (list != null) {
                    list = list.next;
                    list.next = reversedList;
                    reversedList = list;
                }
                while (reversedList != null) {
                    executeListener(reversedList.runnable, reversedList.executor);
                    reversedList = reversedList.next;
                }
            }
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/ExecutionList$RunnableExecutorPair.class */
    public static final class RunnableExecutorPair {
        final Runnable runnable;
        final Executor executor;
        RunnableExecutorPair next;

        RunnableExecutorPair(Runnable runnable, Executor executor, RunnableExecutorPair next) {
            this.runnable = runnable;
            this.executor = executor;
            this.next = next;
        }
    }
}
