package com.mchange.p009v2.async;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.util.ResourceClosedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.mchange.v2.async.ThreadPerTaskAsynchronousRunner */
/* loaded from: grasscutter.jar:com/mchange/v2/async/ThreadPerTaskAsynchronousRunner.class */
public class ThreadPerTaskAsynchronousRunner implements AsynchronousRunner {
    static final int PRESUME_DEADLOCKED_MULTIPLE = 3;
    static final MLogger logger = MLog.getLogger(ThreadPerTaskAsynchronousRunner.class);
    final int max_task_threads;
    final long interrupt_task_delay;
    LinkedList queue;
    ArrayList running;
    ArrayList deadlockSnapshot;
    boolean still_open;
    Thread dispatchThread;
    Timer interruptAndDeadlockTimer;

    public ThreadPerTaskAsynchronousRunner(int i) {
        this(i, 0);
    }

    public ThreadPerTaskAsynchronousRunner(int i, long j) {
        this.queue = new LinkedList();
        this.running = new ArrayList();
        this.deadlockSnapshot = null;
        this.still_open = true;
        this.dispatchThread = new DispatchThread();
        this.max_task_threads = i;
        this.interrupt_task_delay = j;
        if (hasIdTimer()) {
            this.interruptAndDeadlockTimer = new Timer(true);
            long j2 = j * 3;
            this.interruptAndDeadlockTimer.schedule(new TimerTask() { // from class: com.mchange.v2.async.ThreadPerTaskAsynchronousRunner.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ThreadPerTaskAsynchronousRunner.this.checkForDeadlock();
                }
            }, j2, j2);
        }
        this.dispatchThread.start();
    }

    /* access modifiers changed from: private */
    public boolean hasIdTimer() {
        return this.interrupt_task_delay > 0;
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner
    public synchronized void postRunnable(Runnable runnable) {
        if (this.still_open) {
            this.queue.add(runnable);
            notifyAll();
            return;
        }
        throw new ResourceClosedException("Attempted to use a ThreadPerTaskAsynchronousRunner in a closed or broken state.");
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner, com.mchange.p006v1.util.ClosableResource
    public void close() {
        close(true);
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner
    public synchronized void close(boolean z) {
        if (this.still_open) {
            this.still_open = false;
            if (z) {
                this.queue.clear();
                Iterator it = this.running.iterator();
                while (it.hasNext()) {
                    ((Thread) it.next()).interrupt();
                }
                closeThreadResources();
            }
        }
    }

    public synchronized int getRunningCount() {
        return this.running.size();
    }

    public synchronized Collection getRunningTasks() {
        return (Collection) this.running.clone();
    }

    public synchronized int getWaitingCount() {
        return this.queue.size();
    }

    public synchronized Collection getWaitingTasks() {
        return (Collection) this.queue.clone();
    }

    public synchronized boolean isClosed() {
        return !this.still_open;
    }

    public synchronized boolean isDoneAndGone() {
        return !this.dispatchThread.isAlive() && this.running.isEmpty() && this.interruptAndDeadlockTimer == null;
    }

    /* access modifiers changed from: private */
    public synchronized void acknowledgeComplete(TaskThread taskThread) {
        if (!taskThread.isCompleted()) {
            this.running.remove(taskThread);
            taskThread.markCompleted();
            notifyAll();
            if (!this.still_open && this.queue.isEmpty() && this.running.isEmpty()) {
                closeThreadResources();
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void checkForDeadlock() {
        if (this.deadlockSnapshot == null) {
            if (this.running.size() == this.max_task_threads) {
                this.deadlockSnapshot = (ArrayList) this.running.clone();
            }
        } else if (this.running.size() < this.max_task_threads) {
            this.deadlockSnapshot = null;
        } else if (this.deadlockSnapshot.equals(this.running)) {
            if (logger.isLoggable(MLevel.WARNING)) {
                StringBuffer stringBuffer = new StringBuffer(1024);
                stringBuffer.append("APPARENT DEADLOCK! (");
                stringBuffer.append(this);
                stringBuffer.append(") Deadlocked threads (unresponsive to interrupt()) are being set aside as hopeless and up to ");
                stringBuffer.append(this.max_task_threads);
                stringBuffer.append(" may now be spawned for new tasks. If tasks continue to deadlock, you may run out of memory. Deadlocked task list: ");
                int size = this.deadlockSnapshot.size();
                for (int i = 0; i < size; i++) {
                    if (i != 0) {
                        stringBuffer.append(", ");
                    }
                    stringBuffer.append(((TaskThread) this.deadlockSnapshot.get(i)).getTask());
                }
                logger.log(MLevel.WARNING, stringBuffer.toString());
            }
            int size2 = this.deadlockSnapshot.size();
            for (int i2 = 0; i2 < size2; i2++) {
                acknowledgeComplete((TaskThread) this.deadlockSnapshot.get(i2));
            }
            this.deadlockSnapshot = null;
        } else {
            this.deadlockSnapshot = (ArrayList) this.running.clone();
        }
    }

    private void closeThreadResources() {
        if (this.interruptAndDeadlockTimer != null) {
            this.interruptAndDeadlockTimer.cancel();
            this.interruptAndDeadlockTimer = null;
        }
        this.dispatchThread.interrupt();
    }

    /* renamed from: com.mchange.v2.async.ThreadPerTaskAsynchronousRunner$DispatchThread */
    /* loaded from: grasscutter.jar:com/mchange/v2/async/ThreadPerTaskAsynchronousRunner$DispatchThread.class */
    class DispatchThread extends Thread {
        DispatchThread() {
            super("Dispatch-Thread-for-" + ThreadPerTaskAsynchronousRunner.this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0061
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            /*
                r5 = this;
                r0 = r5
                com.mchange.v2.async.ThreadPerTaskAsynchronousRunner r0 = com.mchange.p009v2.async.ThreadPerTaskAsynchronousRunner.this
                r1 = r0
                r6 = r1
                monitor-enter(r0)
            L_0x0007:
                r0 = r5
                com.mchange.v2.async.ThreadPerTaskAsynchronousRunner r0 = com.mchange.p009v2.async.ThreadPerTaskAsynchronousRunner.this     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                java.util.LinkedList r0 = r0.queue     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                boolean r0 = r0.isEmpty()     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                if (r0 != 0) goto L_0x0028
                r0 = r5
                com.mchange.v2.async.ThreadPerTaskAsynchronousRunner r0 = com.mchange.p009v2.async.ThreadPerTaskAsynchronousRunner.this     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                java.util.ArrayList r0 = r0.running     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                int r0 = r0.size()     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                r1 = r5
                com.mchange.v2.async.ThreadPerTaskAsynchronousRunner r1 = com.mchange.p009v2.async.ThreadPerTaskAsynchronousRunner.this     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                int r1 = r1.max_task_threads     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                if (r0 != r1) goto L_0x0032
            L_0x0028:
                r0 = r5
                com.mchange.v2.async.ThreadPerTaskAsynchronousRunner r0 = com.mchange.p009v2.async.ThreadPerTaskAsynchronousRunner.this     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                r0.wait()     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                goto L_0x0007
            L_0x0032:
                r0 = r5
                com.mchange.v2.async.ThreadPerTaskAsynchronousRunner r0 = com.mchange.p009v2.async.ThreadPerTaskAsynchronousRunner.this     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                java.util.LinkedList r0 = r0.queue     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                r1 = 0
                java.lang.Object r0 = r0.remove(r1)     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                r7 = r0
                com.mchange.v2.async.ThreadPerTaskAsynchronousRunner$TaskThread r0 = new com.mchange.v2.async.ThreadPerTaskAsynchronousRunner$TaskThread     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                r1 = r0
                r2 = r5
                com.mchange.v2.async.ThreadPerTaskAsynchronousRunner r2 = com.mchange.p009v2.async.ThreadPerTaskAsynchronousRunner.this     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                r3 = r7
                r1.<init>(r3)     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                r8 = r0
                r0 = r8
                r0.start()     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                r0 = r5
                com.mchange.v2.async.ThreadPerTaskAsynchronousRunner r0 = com.mchange.p009v2.async.ThreadPerTaskAsynchronousRunner.this     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                java.util.ArrayList r0 = r0.running     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                r1 = r8
                boolean r0 = r0.add(r1)     // Catch: all -> 0x00a8, InterruptedException -> 0x0061
                goto L_0x0007
            L_0x0061:
                r7 = move-exception
                r0 = r5
                com.mchange.v2.async.ThreadPerTaskAsynchronousRunner r0 = com.mchange.p009v2.async.ThreadPerTaskAsynchronousRunner.this     // Catch: all -> 0x00a8
                boolean r0 = r0.still_open     // Catch: all -> 0x00a8
                if (r0 == 0) goto L_0x00a3
                com.mchange.v2.log.MLogger r0 = com.mchange.p009v2.async.ThreadPerTaskAsynchronousRunner.logger     // Catch: all -> 0x00a8
                com.mchange.v2.log.MLevel r1 = com.mchange.p009v2.log.MLevel.WARNING     // Catch: all -> 0x00a8
                boolean r0 = r0.isLoggable(r1)     // Catch: all -> 0x00a8
                if (r0 == 0) goto L_0x009b
                com.mchange.v2.log.MLogger r0 = com.mchange.p009v2.async.ThreadPerTaskAsynchronousRunner.logger     // Catch: all -> 0x00a8
                com.mchange.v2.log.MLevel r1 = com.mchange.p009v2.log.MLevel.WARNING     // Catch: all -> 0x00a8
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: all -> 0x00a8
                r3 = r2
                r3.<init>()     // Catch: all -> 0x00a8
                r3 = r5
                java.lang.String r3 = r3.getName()     // Catch: all -> 0x00a8
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: all -> 0x00a8
                java.lang.String r3 = " unexpectedly interrupted! Shutting down!"
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: all -> 0x00a8
                java.lang.String r2 = r2.toString()     // Catch: all -> 0x00a8
                r0.log(r1, r2)     // Catch: all -> 0x00a8
            L_0x009b:
                r0 = r5
                com.mchange.v2.async.ThreadPerTaskAsynchronousRunner r0 = com.mchange.p009v2.async.ThreadPerTaskAsynchronousRunner.this     // Catch: all -> 0x00a8
                r1 = 0
                r0.close(r1)     // Catch: all -> 0x00a8
            L_0x00a3:
                r0 = r6
                monitor-exit(r0)     // Catch: all -> 0x00a8
                goto L_0x00af
            L_0x00a8:
                r9 = move-exception
                r0 = r6
                monitor-exit(r0)     // Catch: all -> 0x00a8
                r0 = r9
                throw r0
            L_0x00af:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.async.ThreadPerTaskAsynchronousRunner.DispatchThread.run():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.async.ThreadPerTaskAsynchronousRunner$TaskThread */
    /* loaded from: grasscutter.jar:com/mchange/v2/async/ThreadPerTaskAsynchronousRunner$TaskThread.class */
    public class TaskThread extends Thread {

        /* renamed from: r */
        Runnable f391r;
        boolean completed = false;

        TaskThread(Runnable runnable) {
            super("Task-Thread-for-" + ThreadPerTaskAsynchronousRunner.this);
            this.f391r = runnable;
        }

        Runnable getTask() {
            return this.f391r;
        }

        synchronized void markCompleted() {
            this.completed = true;
        }

        synchronized boolean isCompleted() {
            return this.completed;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (ThreadPerTaskAsynchronousRunner.this.hasIdTimer()) {
                    ThreadPerTaskAsynchronousRunner.this.interruptAndDeadlockTimer.schedule(new TimerTask() { // from class: com.mchange.v2.async.ThreadPerTaskAsynchronousRunner.TaskThread.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            TaskThread.this.interrupt();
                        }
                    }, ThreadPerTaskAsynchronousRunner.this.interrupt_task_delay);
                }
                this.f391r.run();
            } finally {
                ThreadPerTaskAsynchronousRunner.this.acknowledgeComplete(this);
            }
        }
    }
}
