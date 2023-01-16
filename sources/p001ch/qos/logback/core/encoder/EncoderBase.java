package p001ch.qos.logback.core.encoder;

import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.encoder.EncoderBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/encoder/EncoderBase.class */
public abstract class EncoderBase<E> extends ContextAwareBase implements Encoder<E> {
    protected boolean started;

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.started;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.started = true;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.started = false;
    }
}
