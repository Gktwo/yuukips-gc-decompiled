package p001ch.qos.logback.core.boolex;

import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.boolex.EventEvaluatorBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/boolex/EventEvaluatorBase.class */
public abstract class EventEvaluatorBase<E> extends ContextAwareBase implements EventEvaluator<E> {
    String name;
    boolean started;

    @Override // p001ch.qos.logback.core.boolex.EventEvaluator
    public String getName() {
        return this.name;
    }

    @Override // p001ch.qos.logback.core.boolex.EventEvaluator
    public void setName(String name) {
        if (this.name != null) {
            throw new IllegalStateException("name has been already set");
        }
        this.name = name;
    }

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
