package p001ch.qos.logback.core.sift;

import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.sift.AbstractDiscriminator */
/* loaded from: grasscutter.jar:ch/qos/logback/core/sift/AbstractDiscriminator.class */
public abstract class AbstractDiscriminator<E> extends ContextAwareBase implements Discriminator<E> {
    protected boolean started;

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.started = true;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.started = false;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.started;
    }
}
