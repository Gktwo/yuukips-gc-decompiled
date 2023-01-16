package p001ch.qos.logback.core.filter;

import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.spi.FilterReply;
import p001ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.filter.Filter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/filter/Filter.class */
public abstract class Filter<E> extends ContextAwareBase implements LifeCycle {
    private String name;
    boolean start = false;

    public abstract FilterReply decide(E e);

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.start = true;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.start;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.start = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
