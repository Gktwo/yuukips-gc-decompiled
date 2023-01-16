package org.eclipse.jetty.util.component;

import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/StopLifeCycle.class */
public class StopLifeCycle extends AbstractLifeCycle implements LifeCycle.Listener {
    private static final Logger LOG = Log.getLogger(StopLifeCycle.class);
    private final LifeCycle _lifecycle;

    public StopLifeCycle(LifeCycle lifecycle) {
        this._lifecycle = lifecycle;
        addLifeCycleListener(this);
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
    public void lifeCycleStarted(LifeCycle lifecycle) {
        try {
            this._lifecycle.stop();
        } catch (Exception e) {
            LOG.warn(e);
        }
    }
}
