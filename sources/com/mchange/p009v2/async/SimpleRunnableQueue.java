package com.mchange.p009v2.async;

import java.util.LinkedList;
import java.util.List;

/* renamed from: com.mchange.v2.async.SimpleRunnableQueue */
/* loaded from: grasscutter.jar:com/mchange/v2/async/SimpleRunnableQueue.class */
public class SimpleRunnableQueue implements RunnableQueue, Queuable {
    private List taskList;

    /* renamed from: t */
    private Thread f390t;
    boolean gentle_close_requested;

    public SimpleRunnableQueue(boolean z) {
        this.taskList = new LinkedList();
        this.f390t = new TaskThread();
        this.gentle_close_requested = false;
        this.f390t.setDaemon(z);
        this.f390t.start();
    }

    public SimpleRunnableQueue() {
        this(true);
    }

    @Override // com.mchange.p009v2.async.Queuable
    public RunnableQueue asRunnableQueue() {
        return this;
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner
    public synchronized void postRunnable(Runnable runnable) {
        if (this.gentle_close_requested) {
            throw new IllegalStateException("Attempted to post a task to a closed AsynchronousRunner.");
        }
        this.taskList.add(runnable);
        notifyAll();
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner
    public synchronized void close(boolean z) {
        if (z) {
            this.f390t.interrupt();
        } else {
            this.gentle_close_requested = true;
        }
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner, com.mchange.p006v1.util.ClosableResource
    public synchronized void close() {
        close(true);
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
                this.f390t.interrupt();
            }
            wait();
        }
    }

    /* renamed from: com.mchange.v2.async.SimpleRunnableQueue$TaskThread */
    /* loaded from: grasscutter.jar:com/mchange/v2/async/SimpleRunnableQueue$TaskThread.class */
    class TaskThread extends Thread {
        TaskThread() {
            super("SimpleRunnableQueue.TaskThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!isInterrupted()) {
                try {
                    SimpleRunnableQueue.this.awaitTask();
                    try {
                        SimpleRunnableQueue.this.dequeueRunnable().run();
                    } catch (Exception e) {
                        System.err.println(getClass().getName() + " -- Unexpected exception in task!");
                        e.printStackTrace();
                    }
                } catch (InterruptedException e2) {
                    return;
                } finally {
                    SimpleRunnableQueue.this.taskList = null;
                    SimpleRunnableQueue.this.f390t = null;
                }
            }
        }
    }
}
