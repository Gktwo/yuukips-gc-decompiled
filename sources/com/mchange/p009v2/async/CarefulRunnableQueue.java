package com.mchange.p009v2.async;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.util.ResourceClosedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.mchange.v2.async.CarefulRunnableQueue */
/* loaded from: grasscutter.jar:com/mchange/v2/async/CarefulRunnableQueue.class */
public class CarefulRunnableQueue implements RunnableQueue, Queuable, StrandedTaskReporting {
    private static final MLogger logger = MLog.getLogger(CarefulRunnableQueue.class);
    private boolean shutdown_on_interrupt;
    private List taskList = new LinkedList();

    /* renamed from: t */
    private TaskThread f389t = new TaskThread();
    private boolean gentle_close_requested = false;
    private List strandedTasks = null;

    public CarefulRunnableQueue(boolean z, boolean z2) {
        this.shutdown_on_interrupt = z2;
        this.f389t.setDaemon(z);
        this.f389t.start();
    }

    @Override // com.mchange.p009v2.async.Queuable
    public RunnableQueue asRunnableQueue() {
        return this;
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner
    public synchronized void postRunnable(Runnable runnable) {
        try {
            if (this.gentle_close_requested) {
                throw new ResourceClosedException("Attempted to post a task to a closing CarefulRunnableQueue.");
            }
            this.taskList.add(runnable);
            notifyAll();
        } catch (NullPointerException e) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "NullPointerException while posting Runnable.", (Throwable) e);
            }
            if (this.taskList == null) {
                throw new ResourceClosedException("Attempted to post a task to a CarefulRunnableQueue which has been closed, or whose TaskThread has been interrupted.");
            }
            throw e;
        }
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner
    public synchronized void close(boolean z) {
        if (z) {
            this.f389t.safeStop();
            this.f389t.interrupt();
            return;
        }
        this.gentle_close_requested = true;
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner, com.mchange.p006v1.util.ClosableResource
    public synchronized void close() {
        close(true);
    }

    @Override // com.mchange.p009v2.async.StrandedTaskReporting
    public synchronized List getStrandedTasks() {
        while (this.gentle_close_requested && this.taskList != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, Thread.currentThread() + " interrupted while waiting for stranded tasks from CarefulRunnableQueue.", (Throwable) e);
                }
                throw new RuntimeException(Thread.currentThread() + " interrupted while waiting for stranded tasks from CarefulRunnableQueue.");
            }
        }
        return this.strandedTasks;
    }

    /* access modifiers changed from: private */
    public synchronized Runnable dequeueRunnable() {
        Runnable runnable = (Runnable) this.taskList.get(0);
        this.taskList.remove(0);
        return runnable;
    }

    /* access modifiers changed from: private */
    public synchronized void awaitTask() throws InterruptedException {
        while (this.taskList.size() == 0) {
            if (this.gentle_close_requested) {
                this.f389t.safeStop();
                this.f389t.interrupt();
            }
            wait();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.async.CarefulRunnableQueue$TaskThread */
    /* loaded from: grasscutter.jar:com/mchange/v2/async/CarefulRunnableQueue$TaskThread.class */
    public class TaskThread extends Thread {
        boolean should_stop = false;

        TaskThread() {
            super("CarefulRunnableQueue.TaskThread");
        }

        public synchronized void safeStop() {
            this.should_stop = true;
        }

        private synchronized boolean shouldStop() {
            return this.should_stop;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!shouldStop()) {
                try {
                    CarefulRunnableQueue.this.awaitTask();
                    try {
                        CarefulRunnableQueue.this.dequeueRunnable().run();
                    } catch (InterruptedException e) {
                        if (CarefulRunnableQueue.this.shutdown_on_interrupt) {
                            CarefulRunnableQueue.this.close(false);
                            if (CarefulRunnableQueue.logger.isLoggable(MLevel.INFO)) {
                                CarefulRunnableQueue.logger.info(toString() + " interrupted. Shutting down after current tasks have completed.");
                            }
                        } else {
                            CarefulRunnableQueue.logger.info(toString() + " received interrupt. IGNORING.");
                        }
                    } catch (Exception e2) {
                        if (CarefulRunnableQueue.logger.isLoggable(MLevel.WARNING)) {
                            CarefulRunnableQueue.logger.log(MLevel.WARNING, getClass().getName() + " -- Unexpected exception in task!", (Throwable) e2);
                        }
                    }
                } catch (Throwable th) {
                    synchronized (CarefulRunnableQueue.this) {
                        try {
                            CarefulRunnableQueue.this.strandedTasks = Collections.unmodifiableList(CarefulRunnableQueue.this.taskList);
                            CarefulRunnableQueue.this.taskList = null;
                            CarefulRunnableQueue.this.f389t = null;
                            CarefulRunnableQueue.this.notifyAll();
                            throw th;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            }
            synchronized (CarefulRunnableQueue.this) {
                try {
                    CarefulRunnableQueue.this.strandedTasks = Collections.unmodifiableList(CarefulRunnableQueue.this.taskList);
                    CarefulRunnableQueue.this.taskList = null;
                    CarefulRunnableQueue.this.f389t = null;
                    CarefulRunnableQueue.this.notifyAll();
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }
}
