package p001ch.qos.logback.core.rolling;

import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.rolling.TriggeringPolicyBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/TriggeringPolicyBase.class */
public abstract class TriggeringPolicyBase<E> extends ContextAwareBase implements TriggeringPolicy<E> {
    private boolean start;

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.start = true;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.start = false;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.start;
    }
}
