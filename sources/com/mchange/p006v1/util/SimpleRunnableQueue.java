package com.mchange.p006v1.util;

import java.util.LinkedList;
import java.util.List;

/* renamed from: com.mchange.v1.util.SimpleRunnableQueue */
/* loaded from: grasscutter.jar:com/mchange/v1/util/SimpleRunnableQueue.class */
public class SimpleRunnableQueue implements RunnableQueue {
    private List taskList;

    /* renamed from: t */
    private Thread f387t;

    public SimpleRunnableQueue(boolean z) {
        this.taskList = new LinkedList();
        this.f387t = new TaskThread();
        this.f387t.setDaemon(z);
        this.f387t.start();
    }

    public SimpleRunnableQueue() {
        this(true);
    }

    @Override // com.mchange.p006v1.util.RunnableQueue
    public synchronized void postRunnable(Runnable runnable) {
        this.taskList.add(runnable);
        notifyAll();
    }

    public synchronized void close() {
        this.f387t.interrupt();
        this.taskList = null;
        this.f387t = null;
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
            wait();
        }
    }

    /* renamed from: com.mchange.v1.util.SimpleRunnableQueue$TaskThread */
    /* loaded from: grasscutter.jar:com/mchange/v1/util/SimpleRunnableQueue$TaskThread.class */
    class TaskThread extends Thread {
        TaskThread() {
            super("SimpleRunnableQueue.TaskThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    SimpleRunnableQueue.this.awaitTask();
                    try {
                        SimpleRunnableQueue.this.dequeueRunnable().run();
                    } catch (Exception e) {
                        System.err.println(getClass().getName() + " -- Unexpected exception in task!");
                        e.printStackTrace();
                    }
                } catch (InterruptedException e2) {
                    System.err.println(toString() + " interrupted. Shutting down.");
                    return;
                }
            }
        }
    }
}
