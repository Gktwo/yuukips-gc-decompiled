package org.eclipse.jetty.util.component;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.Uptime;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject("Abstract Implementation of LifeCycle")
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/AbstractLifeCycle.class */
public abstract class AbstractLifeCycle implements LifeCycle {
    private static final Logger LOG = Log.getLogger(AbstractLifeCycle.class);
    public static final String STOPPED = "STOPPED";
    public static final String FAILED = "FAILED";
    public static final String STARTING = "STARTING";
    public static final String STARTED = "STARTED";
    public static final String STOPPING = "STOPPING";
    public static final String RUNNING = "RUNNING";
    private static final int STATE_FAILED = -1;
    private static final int STATE_STOPPED = 0;
    private static final int STATE_STARTING = 1;
    private static final int STATE_STARTED = 2;
    private static final int STATE_STOPPING = 3;
    private final CopyOnWriteArrayList<LifeCycle.Listener> _listeners = new CopyOnWriteArrayList<>();
    private final Object _lock = new Object();
    private volatile int _state = 0;
    private long _stopTimeout = 30000;

    /* access modifiers changed from: protected */
    public void doStart() throws Exception {
    }

    /* access modifiers changed from: protected */
    public void doStop() throws Exception {
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public final void start() throws Exception {
        synchronized (this._lock) {
            if (this._state != 2 && this._state != 1) {
                setStarting();
                doStart();
                setStarted();
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public final void stop() throws Exception {
        synchronized (this._lock) {
            if (this._state != 3 && this._state != 0) {
                setStopping();
                doStop();
                setStopped();
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public boolean isRunning() {
        int state = this._state;
        return state == 2 || state == 1;
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public boolean isStarted() {
        return this._state == 2;
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public boolean isStarting() {
        return this._state == 1;
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public boolean isStopping() {
        return this._state == 3;
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public boolean isStopped() {
        return this._state == 0;
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public boolean isFailed() {
        return this._state == -1;
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public void addLifeCycleListener(LifeCycle.Listener listener) {
        this._listeners.add(listener);
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public void removeLifeCycleListener(LifeCycle.Listener listener) {
        this._listeners.remove(listener);
    }

    @ManagedAttribute(value = "Lifecycle State for this instance", readonly = true)
    public String getState() {
        switch (this._state) {
            case -1:
                return FAILED;
            case 0:
                return STOPPED;
            case 1:
                return STARTING;
            case 2:
                return STARTED;
            case 3:
                return STOPPING;
            default:
                return null;
        }
    }

    public static String getState(LifeCycle lc) {
        if (lc.isStarting()) {
            return STARTING;
        }
        if (lc.isStarted()) {
            return STARTED;
        }
        if (lc.isStopping()) {
            return STOPPING;
        }
        if (lc.isStopped()) {
            return STOPPED;
        }
        return FAILED;
    }

    private void setStarted() {
        this._state = 2;
        if (LOG.isDebugEnabled()) {
            LOG.debug("STARTED @{}ms {}", Long.valueOf(Uptime.getUptime()), this);
        }
        Iterator<LifeCycle.Listener> it = this._listeners.iterator();
        while (it.hasNext()) {
            it.next().lifeCycleStarted(this);
        }
    }

    private void setStarting() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("starting {}", this);
        }
        this._state = 1;
        Iterator<LifeCycle.Listener> it = this._listeners.iterator();
        while (it.hasNext()) {
            it.next().lifeCycleStarting(this);
        }
    }

    private void setStopping() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("stopping {}", this);
        }
        this._state = 3;
        Iterator<LifeCycle.Listener> it = this._listeners.iterator();
        while (it.hasNext()) {
            it.next().lifeCycleStopping(this);
        }
    }

    private void setStopped() {
        this._state = 0;
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} {}", STOPPED, this);
        }
        Iterator<LifeCycle.Listener> it = this._listeners.iterator();
        while (it.hasNext()) {
            it.next().lifeCycleStopped(this);
        }
    }

    private void setFailed(Throwable th) {
        this._state = -1;
        if (LOG.isDebugEnabled()) {
            LOG.warn("FAILED " + this + ": " + th, th);
        }
        Iterator<LifeCycle.Listener> it = this._listeners.iterator();
        while (it.hasNext()) {
            it.next().lifeCycleFailure(this, th);
        }
    }

    @ManagedAttribute("The stop timeout in milliseconds")
    public long getStopTimeout() {
        return this._stopTimeout;
    }

    public void setStopTimeout(long stopTimeout) {
        this._stopTimeout = stopTimeout;
    }

    @Deprecated
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/AbstractLifeCycle$AbstractLifeCycleListener.class */
    public static abstract class AbstractLifeCycleListener implements LifeCycle.Listener {
        @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
        public void lifeCycleFailure(LifeCycle event, Throwable cause) {
        }

        @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
        public void lifeCycleStarted(LifeCycle event) {
        }

        @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
        public void lifeCycleStarting(LifeCycle event) {
        }

        @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
        public void lifeCycleStopped(LifeCycle event) {
        }

        @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
        public void lifeCycleStopping(LifeCycle event) {
        }
    }

    @Override // java.lang.Object
    public String toString() {
        String name = getClass().getSimpleName();
        if (StringUtil.isBlank(name) && getClass().getSuperclass() != null) {
            name = getClass().getSuperclass().getSimpleName();
        }
        return String.format("%s@%x{%s}", name, Integer.valueOf(hashCode()), getState());
    }
}
