package com.mchange.p006v1.lang;

/* renamed from: com.mchange.v1.lang.GentleThread */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/GentleThread.class */
public abstract class GentleThread extends Thread {
    boolean should_stop = false;
    boolean should_suspend = false;

    @Override // java.lang.Thread, java.lang.Runnable
    public abstract void run();

    public GentleThread() {
    }

    public GentleThread(String str) {
        super(str);
    }

    public synchronized void gentleStop() {
        this.should_stop = true;
    }

    public synchronized void gentleSuspend() {
        this.should_suspend = true;
    }

    public synchronized void gentleResume() {
        this.should_suspend = false;
        notifyAll();
    }

    protected synchronized boolean shouldStop() {
        return this.should_stop;
    }

    protected synchronized boolean shouldSuspend() {
        return this.should_suspend;
    }

    protected synchronized void allowSuspend() throws InterruptedException {
        while (this.should_suspend) {
            wait();
        }
    }
}
