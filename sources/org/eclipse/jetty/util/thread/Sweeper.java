package org.eclipse.jetty.util.thread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/Sweeper.class */
public class Sweeper extends AbstractLifeCycle implements Runnable {
    private static final Logger LOG = Log.getLogger(Sweeper.class);
    private final AtomicReference<List<Sweepable>> items = new AtomicReference<>();
    private final AtomicReference<Scheduler.Task> task = new AtomicReference<>();
    private final Scheduler scheduler;
    private final long period;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/Sweeper$Sweepable.class */
    public interface Sweepable {
        boolean sweep();
    }

    public Sweeper(Scheduler scheduler, long period) {
        this.scheduler = scheduler;
        this.period = period;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStart() throws Exception {
        doStart();
        this.items.set(new CopyOnWriteArrayList());
        activate();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws Exception {
        deactivate();
        this.items.set(null);
        doStop();
    }

    public int getSize() {
        List<Sweepable> refs = this.items.get();
        if (refs == null) {
            return 0;
        }
        return refs.size();
    }

    public boolean offer(Sweepable sweepable) {
        List<Sweepable> refs = this.items.get();
        if (refs == null) {
            return false;
        }
        refs.add(sweepable);
        if (!LOG.isDebugEnabled()) {
            return true;
        }
        LOG.debug("Resource offered {}", sweepable);
        return true;
    }

    public boolean remove(Sweepable sweepable) {
        List<Sweepable> refs = this.items.get();
        return refs != null && refs.remove(sweepable);
    }

    @Override // java.lang.Runnable
    public void run() {
        List<Sweepable> refs = this.items.get();
        if (refs != null) {
            for (Sweepable sweepable : refs) {
                try {
                    if (sweepable.sweep()) {
                        refs.remove(sweepable);
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Resource swept {}", sweepable);
                        }
                    }
                } catch (Throwable x) {
                    LOG.info("Exception while sweeping " + sweepable, x);
                }
            }
            activate();
        }
    }

    private void activate() {
        if (isRunning()) {
            Scheduler.Task t = this.scheduler.schedule(this, this.period, TimeUnit.MILLISECONDS);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Scheduled in {} ms sweep task {}", Long.valueOf(this.period), t);
            }
            this.task.set(t);
        } else if (LOG.isDebugEnabled()) {
            LOG.debug("Skipping sweep task scheduling", new Object[0]);
        }
    }

    private void deactivate() {
        Scheduler.Task t = this.task.getAndSet(null);
        if (t != null) {
            boolean cancelled = t.cancel();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Cancelled ({}) sweep task {}", Boolean.valueOf(cancelled), t);
            }
        }
    }
}
