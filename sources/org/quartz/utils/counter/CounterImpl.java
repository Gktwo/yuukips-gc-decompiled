package org.quartz.utils.counter;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: grasscutter.jar:org/quartz/utils/counter/CounterImpl.class */
public class CounterImpl implements Counter, Serializable {
    private static final long serialVersionUID = -1529134342654953984L;
    private AtomicLong value;

    public CounterImpl() {
        this(0);
    }

    public CounterImpl(long initialValue) {
        this.value = new AtomicLong(initialValue);
    }

    @Override // org.quartz.utils.counter.Counter
    public long increment() {
        return this.value.incrementAndGet();
    }

    @Override // org.quartz.utils.counter.Counter
    public long decrement() {
        return this.value.decrementAndGet();
    }

    @Override // org.quartz.utils.counter.Counter
    public long getAndSet(long newValue) {
        return this.value.getAndSet(newValue);
    }

    @Override // org.quartz.utils.counter.Counter
    public long getValue() {
        return this.value.get();
    }

    @Override // org.quartz.utils.counter.Counter
    public long increment(long amount) {
        return this.value.addAndGet(amount);
    }

    @Override // org.quartz.utils.counter.Counter
    public long decrement(long amount) {
        return this.value.addAndGet(amount * -1);
    }

    @Override // org.quartz.utils.counter.Counter
    public void setValue(long newValue) {
        this.value.set(newValue);
    }
}
