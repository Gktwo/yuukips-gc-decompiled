package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/SequentialExecutor.class */
public final class SequentialExecutor implements Executor {
    private static final Logger log = Logger.getLogger(SequentialExecutor.class.getName());
    private final Executor executor;
    @GuardedBy("queue")
    private final Deque<Runnable> queue = new ArrayDeque();
    @GuardedBy("queue")
    private WorkerRunningState workerRunningState = WorkerRunningState.IDLE;
    @GuardedBy("queue")
    private long workerRunCount = 0;
    private final QueueWorker worker = new QueueWorker();

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/SequentialExecutor$WorkerRunningState.class */
    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    static /* synthetic */ long access$308(SequentialExecutor x0) {
        long j = x0.workerRunCount;
        x0.workerRunCount = j + 1;
        return j;
    }

    /* access modifiers changed from: package-private */
    public SequentialExecutor(Executor executor) {
        this.executor = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable task) {
        Preconditions.checkNotNull(task);
        synchronized (this.queue) {
            if (this.workerRunningState == WorkerRunningState.RUNNING || this.workerRunningState == WorkerRunningState.QUEUED) {
                this.queue.add(task);
                return;
            }
            long oldRunCount = this.workerRunCount;
            Runnable submittedTask = new Runnable() { // from class: com.google.common.util.concurrent.SequentialExecutor.1
                @Override // java.lang.Runnable
                public void run() {
                    task.run();
                }
            };
            this.queue.add(submittedTask);
            this.workerRunningState = WorkerRunningState.QUEUING;
            try {
                this.executor.execute(this.worker);
                if (!(this.workerRunningState != WorkerRunningState.QUEUING)) {
                    synchronized (this.queue) {
                        if (this.workerRunCount == oldRunCount && this.workerRunningState == WorkerRunningState.QUEUING) {
                            this.workerRunningState = WorkerRunningState.QUEUED;
                        }
                    }
                }
            } catch (Error | RuntimeException t) {
                synchronized (this.queue) {
                    boolean removed = (this.workerRunningState == WorkerRunningState.IDLE || this.workerRunningState == WorkerRunningState.QUEUING) && this.queue.removeLastOccurrence(submittedTask);
                    if (!(t instanceof RejectedExecutionException) || removed) {
                        throw t;
                    }
                }
            }
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/SequentialExecutor$QueueWorker.class */
    private final class QueueWorker implements Runnable {
        private QueueWorker() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                workOnQueue();
            } catch (Error e) {
                synchronized (SequentialExecutor.this.queue) {
                    SequentialExecutor.this.workerRunningState = WorkerRunningState.IDLE;
                    throw e;
                }
            }
        }

        /*  JADX ERROR: NullPointerException in pass: AttachTryCatchVisitor
            java.lang.NullPointerException: Cannot invoke "String.charAt(int)" because "obj" is null
            	at jadx.core.utils.Utils.cleanObjectName(Utils.java:33)
            	at jadx.core.dex.instructions.args.ArgType.object(ArgType.java:84)
            	at jadx.core.dex.info.ClassInfo.fromName(ClassInfo.java:40)
            	at jadx.core.dex.visitors.AttachTryCatchVisitor.attachHandlers(AttachTryCatchVisitor.java:113)
            	at jadx.core.dex.visitors.AttachTryCatchVisitor.initTryCatches(AttachTryCatchVisitor.java:54)
            	at jadx.core.dex.visitors.AttachTryCatchVisitor.visit(AttachTryCatchVisitor.java:42)
            */
        private void workOnQueue() {
            /*
                r5 = this;
                r0 = 0
                r6 = r0
                r0 = 0
                r7 = r0
                r0 = r5     // Catch: all -> 0x00b0
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: all -> 0x00b0
                java.util.Deque r0 = com.google.common.util.concurrent.SequentialExecutor.access$100(r0)     // Catch: all -> 0x00b0
                r1 = r0     // Catch: all -> 0x00b0
                r9 = r1     // Catch: all -> 0x00b0
                monitor-enter(r0)     // Catch: all -> 0x00b0
                r0 = r7     // Catch: all -> 0x00b0
                if (r0 != 0) goto L_0x0043     // Catch: all -> 0x00b0
                r0 = r5     // Catch: all -> 0x00b0
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: all -> 0x00b0
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r0 = com.google.common.util.concurrent.SequentialExecutor.access$200(r0)     // Catch: all -> 0x00b0
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r1 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.RUNNING     // Catch: all -> 0x00b0
                if (r0 != r1) goto L_0x002e     // Catch: all -> 0x00b0
                r0 = r9     // Catch: all -> 0x00b0
                monitor-exit(r0)     // Catch: all -> 0x00b0
                r0 = r6     // Catch: all -> 0x00b0
                if (r0 == 0) goto L_0x002d
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
                return
                r0 = r5
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this
                long r0 = com.google.common.util.concurrent.SequentialExecutor.access$308(r0)
                r0 = r5
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r1 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.RUNNING
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r0 = com.google.common.util.concurrent.SequentialExecutor.access$202(r0, r1)
                r0 = 1
                r7 = r0
                r0 = r5
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this
                java.util.Deque r0 = com.google.common.util.concurrent.SequentialExecutor.access$100(r0)
                java.lang.Object r0 = r0.poll()
                java.lang.Runnable r0 = (java.lang.Runnable) r0
                r8 = r0
                r0 = r8
                if (r0 != 0) goto L_0x0070
                r0 = r5
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r1 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r0 = com.google.common.util.concurrent.SequentialExecutor.access$202(r0, r1)
                r0 = r9
                monitor-exit(r0)
                r0 = r6
                if (r0 == 0) goto L_0x006f
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
                return
                r0 = r9
                monitor-exit(r0)
                goto L_0x007e
                r10 = move-exception
                r0 = r9
                monitor-exit(r0)
                r0 = r10
                throw r0
                r0 = r6
                boolean r1 = java.lang.Thread.interrupted()
                r0 = r0 | r1
                r6 = r0
                r0 = r8
                r0.run()
                goto L_0x00ad
                r9 = move-exception
                java.util.logging.Logger r0 = com.google.common.util.concurrent.SequentialExecutor.access$400()
                java.util.logging.Level r1 = java.util.logging.Level.SEVERE
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = r2
                r3.<init>()
                java.lang.String r3 = "Exception while executing runnable "
                java.lang.StringBuilder r2 = r2.append(r3)
                r3 = r8
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r2 = r2.toString()
                r3 = r9
                r0.log(r1, r2, r3)
                goto L_0x0004
            L_0x00b0:
                r11 = move-exception
                r0 = r6
                if (r0 == 0) goto L_0x00bc
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
                r0 = r11
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SequentialExecutor.QueueWorker.workOnQueue():void");
        }
    }
}
