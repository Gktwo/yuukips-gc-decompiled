package p001ch.qos.logback.classic.net;

import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.classic.net.ReceiverBase */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/ReceiverBase.class */
public abstract class ReceiverBase extends ContextAwareBase implements LifeCycle {
    private boolean started;

    protected abstract boolean shouldStart();

    protected abstract void onStop();

    protected abstract Runnable getRunnableTask();

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        if (!isStarted()) {
            if (getContext() == null) {
                throw new IllegalStateException("context not set");
            } else if (shouldStart()) {
                getContext().getScheduledExecutorService().execute(getRunnableTask());
                this.started = true;
            }
        }
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        if (isStarted()) {
            try {
                onStop();
            } catch (RuntimeException ex) {
                addError("on stop: " + ex, ex);
            }
            this.started = false;
        }
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.started;
    }
}
