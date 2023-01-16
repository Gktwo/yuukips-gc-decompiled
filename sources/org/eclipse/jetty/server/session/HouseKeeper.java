package org.eclipse.jetty.server.session;

import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.server.SessionIdManager;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.ScheduledExecutorScheduler;
import org.eclipse.jetty.util.thread.Scheduler;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/HouseKeeper.class */
public class HouseKeeper extends AbstractLifeCycle {
    private static final Logger LOG = Log.getLogger("org.eclipse.jetty.server.session");
    public static final long DEFAULT_PERIOD_MS = 600000;
    protected SessionIdManager _sessionIdManager;
    protected Scheduler _scheduler;
    protected Scheduler.Task _task;
    protected Runner _runner;
    protected boolean _ownScheduler = false;
    private long _intervalMs = DEFAULT_PERIOD_MS;

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/HouseKeeper$Runner.class */
    public class Runner implements Runnable {
        protected Runner() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HouseKeeper.this.scavenge();
                synchronized (HouseKeeper.this) {
                    try {
                        if (HouseKeeper.this._scheduler != null && HouseKeeper.this._scheduler.isRunning()) {
                            HouseKeeper.this._task = HouseKeeper.this._scheduler.schedule(this, HouseKeeper.this._intervalMs, TimeUnit.MILLISECONDS);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                synchronized (HouseKeeper.this) {
                    try {
                        if (HouseKeeper.this._scheduler != null && HouseKeeper.this._scheduler.isRunning()) {
                            HouseKeeper.this._task = HouseKeeper.this._scheduler.schedule(this, HouseKeeper.this._intervalMs, TimeUnit.MILLISECONDS);
                        }
                        throw th2;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            }
        }
    }

    public void setSessionIdManager(SessionIdManager sessionIdManager) {
        if (isStarted()) {
            throw new IllegalStateException("HouseKeeper started");
        }
        this._sessionIdManager = sessionIdManager;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._sessionIdManager == null) {
            throw new IllegalStateException("No SessionIdManager for Housekeeper");
        }
        setIntervalSec(getIntervalSec());
        doStart();
    }

    protected void startScavenging() throws Exception {
        synchronized (this) {
            if (this._scheduler == null) {
                if (this._sessionIdManager instanceof DefaultSessionIdManager) {
                    this._scheduler = (Scheduler) ((DefaultSessionIdManager) this._sessionIdManager).getServer().getBean((Class<Object>) Scheduler.class);
                }
                if (this._scheduler == null) {
                    this._scheduler = new ScheduledExecutorScheduler(String.format("Session-HouseKeeper-%x", Integer.valueOf(hashCode())), false);
                    this._ownScheduler = true;
                    this._scheduler.start();
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Using own scheduler for scavenging", new Object[0]);
                    }
                } else if (!this._scheduler.isStarted()) {
                    throw new IllegalStateException("Shared scheduler not started");
                }
            }
            if (this._task != null) {
                this._task.cancel();
            }
            if (this._runner == null) {
                this._runner = new Runner();
            }
            LOG.info("{} Scavenging every {}ms", this._sessionIdManager.getWorkerName(), Long.valueOf(this._intervalMs));
            this._task = this._scheduler.schedule(this._runner, this._intervalMs, TimeUnit.MILLISECONDS);
        }
    }

    protected void stopScavenging() throws Exception {
        synchronized (this) {
            if (this._task != null) {
                this._task.cancel();
                LOG.info("{} Stopped scavenging", this._sessionIdManager.getWorkerName());
            }
            this._task = null;
            if (this._ownScheduler && this._scheduler != null) {
                this._ownScheduler = false;
                this._scheduler.stop();
                this._scheduler = null;
            }
            this._runner = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        synchronized (this) {
            stopScavenging();
            this._scheduler = null;
        }
        doStop();
    }

    public void setIntervalSec(long sec) throws Exception {
        synchronized (this) {
            if (!isStarted() && !isStarting()) {
                this._intervalMs = sec * 1000;
            } else if (sec <= 0) {
                this._intervalMs = 0;
                LOG.info("{} Scavenging disabled", this._sessionIdManager.getWorkerName());
                stopScavenging();
            } else {
                if (sec < 10) {
                    LOG.warn("{} Short interval of {}sec for session scavenging.", this._sessionIdManager.getWorkerName(), Long.valueOf(sec));
                }
                this._intervalMs = sec * 1000;
                long tenPercent = this._intervalMs / 10;
                if (System.currentTimeMillis() % 2 == 0) {
                    this._intervalMs += tenPercent;
                }
                if (isStarting() || isStarted()) {
                    startScavenging();
                }
            }
        }
    }

    @ManagedAttribute(value = "secs between scavenge cycles", readonly = true)
    public long getIntervalSec() {
        long j;
        synchronized (this) {
            j = this._intervalMs / 1000;
        }
        return j;
    }

    public void scavenge() {
        if (!(isStopping() || isStopped())) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} scavenging sessions", this._sessionIdManager.getWorkerName());
            }
            for (SessionHandler manager : this._sessionIdManager.getSessionHandlers()) {
                if (manager != null) {
                    try {
                        manager.scavenge();
                    } catch (Exception e) {
                        LOG.warn(e);
                    }
                }
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        String str;
        synchronized (this) {
            str = toString() + "[interval=" + this._intervalMs + ", ownscheduler=" + this._ownScheduler + "]";
        }
        return str;
    }
}
