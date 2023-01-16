package org.eclipse.jetty.util.thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/TimerScheduler.class */
public class TimerScheduler extends AbstractLifeCycle implements Scheduler, Runnable {
    private static final Logger LOG = Log.getLogger(TimerScheduler.class);
    private final String _name;
    private final boolean _daemon;
    private Timer _timer;

    public TimerScheduler() {
        this(null, false);
    }

    public TimerScheduler(String name, boolean daemon) {
        this._name = name;
        this._daemon = daemon;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        this._timer = this._name == null ? new Timer() : new Timer(this._name, this._daemon);
        run();
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this._timer.cancel();
        doStop();
        this._timer = null;
    }

    @Override // org.eclipse.jetty.util.thread.Scheduler
    public Scheduler.Task schedule(Runnable task, long delay, TimeUnit units) {
        Timer timer = this._timer;
        if (timer == null) {
            throw new RejectedExecutionException("STOPPED: " + this);
        }
        SimpleTask t = new SimpleTask(task);
        timer.schedule(t, units.toMillis(delay));
        return t;
    }

    @Override // java.lang.Runnable
    public void run() {
        Timer timer = this._timer;
        if (timer != null) {
            timer.purge();
            schedule(this, 1, TimeUnit.SECONDS);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/TimerScheduler$SimpleTask.class */
    public static class SimpleTask extends TimerTask implements Scheduler.Task {
        private final Runnable _task;

        private SimpleTask(Runnable runnable) {
            this._task = runnable;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                this._task.run();
            } catch (Throwable x) {
                TimerScheduler.LOG.warn("Exception while executing task " + this._task, x);
            }
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("%s.%s@%x", TimerScheduler.class.getSimpleName(), SimpleTask.class.getSimpleName(), Integer.valueOf(hashCode()));
        }
    }
}
