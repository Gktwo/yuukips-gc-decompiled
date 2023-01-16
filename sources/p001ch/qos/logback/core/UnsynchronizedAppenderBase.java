package p001ch.qos.logback.core;

import java.util.List;
import p001ch.qos.logback.core.filter.Filter;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.spi.FilterAttachableImpl;
import p001ch.qos.logback.core.spi.FilterReply;
import p001ch.qos.logback.core.status.WarnStatus;

/* renamed from: ch.qos.logback.core.UnsynchronizedAppenderBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/UnsynchronizedAppenderBase.class */
public abstract class UnsynchronizedAppenderBase<E> extends ContextAwareBase implements Appender<E> {
    protected String name;
    static final int ALLOWED_REPEATS = 3;
    protected boolean started = false;
    private ThreadLocal<Boolean> guard = new ThreadLocal<>();
    private FilterAttachableImpl<E> fai = new FilterAttachableImpl<>();
    private int statusRepeatCount = 0;
    private int exceptionCount = 0;

    protected abstract void append(E e);

    @Override // p001ch.qos.logback.core.Appender
    public String getName() {
        return this.name;
    }

    @Override // p001ch.qos.logback.core.Appender
    public void doAppend(E eventObject) {
        try {
            if (!Boolean.TRUE.equals(this.guard.get())) {
                this.guard.set(Boolean.TRUE);
                if (!this.started) {
                    int i = this.statusRepeatCount;
                    this.statusRepeatCount = i + 1;
                    if (i < 3) {
                        addStatus(new WarnStatus("Attempted to append to non started appender [" + this.name + "].", this));
                    }
                } else if (getFilterChainDecision(eventObject) != FilterReply.DENY) {
                    append(eventObject);
                }
            }
        } catch (Exception e) {
            int i2 = this.exceptionCount;
            this.exceptionCount = i2 + 1;
            if (i2 < 3) {
                addError("Appender [" + this.name + "] failed to append.", e);
            }
        } finally {
            this.guard.set(Boolean.FALSE);
        }
    }

    @Override // p001ch.qos.logback.core.Appender
    public void setName(String name) {
        this.name = name;
    }

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

    public String toString() {
        return getClass().getName() + "[" + this.name + "]";
    }

    @Override // p001ch.qos.logback.core.spi.FilterAttachable
    public void addFilter(Filter<E> newFilter) {
        this.fai.addFilter(newFilter);
    }

    @Override // p001ch.qos.logback.core.spi.FilterAttachable
    public void clearAllFilters() {
        this.fai.clearAllFilters();
    }

    @Override // p001ch.qos.logback.core.spi.FilterAttachable
    public List<Filter<E>> getCopyOfAttachedFiltersList() {
        return this.fai.getCopyOfAttachedFiltersList();
    }

    @Override // p001ch.qos.logback.core.spi.FilterAttachable
    public FilterReply getFilterChainDecision(E event) {
        return this.fai.getFilterChainDecision(event);
    }
}
