package org.eclipse.jetty.util.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.jetty.util.component.Destroyable;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ShutdownThread.class */
public class ShutdownThread extends Thread {
    private static final Logger LOG = Log.getLogger(ShutdownThread.class);
    private static final ShutdownThread _thread = (ShutdownThread) PrivilegedThreadFactory.newThread(() -> {
        return new ShutdownThread();
    });
    private boolean _hooked;
    private final List<LifeCycle> _lifeCycles = new CopyOnWriteArrayList();

    private ShutdownThread() {
        super("JettyShutdownThread");
    }

    private synchronized void hook() {
        try {
            if (!this._hooked) {
                Runtime.getRuntime().addShutdownHook(this);
            }
            this._hooked = true;
        } catch (Exception e) {
            LOG.ignore(e);
            LOG.info("shutdown already commenced", new Object[0]);
        }
    }

    private synchronized void unhook() {
        try {
            this._hooked = false;
            Runtime.getRuntime().removeShutdownHook(this);
        } catch (Exception e) {
            LOG.ignore(e);
            LOG.debug("shutdown already commenced", new Object[0]);
        }
    }

    public static ShutdownThread getInstance() {
        return _thread;
    }

    public static synchronized void register(LifeCycle... lifeCycles) {
        _thread._lifeCycles.addAll(Arrays.asList(lifeCycles));
        if (_thread._lifeCycles.size() > 0) {
            _thread.hook();
        }
    }

    public static synchronized void register(int index, LifeCycle... lifeCycles) {
        _thread._lifeCycles.addAll(index, Arrays.asList(lifeCycles));
        if (_thread._lifeCycles.size() > 0) {
            _thread.hook();
        }
    }

    public static synchronized void deregister(LifeCycle lifeCycle) {
        _thread._lifeCycles.remove(lifeCycle);
        if (_thread._lifeCycles.size() == 0) {
            _thread.unhook();
        }
    }

    public static synchronized boolean isRegistered(LifeCycle lifeCycle) {
        return _thread._lifeCycles.contains(lifeCycle);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        for (LifeCycle lifeCycle : _thread._lifeCycles) {
            try {
                if (lifeCycle.isStarted()) {
                    lifeCycle.stop();
                    LOG.debug("Stopped {}", lifeCycle);
                }
                if (lifeCycle instanceof Destroyable) {
                    ((Destroyable) lifeCycle).destroy();
                    LOG.debug("Destroyed {}", lifeCycle);
                }
            } catch (Exception ex) {
                LOG.debug(ex);
            }
        }
    }
}
