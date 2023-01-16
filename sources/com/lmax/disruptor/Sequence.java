package com.lmax.disruptor;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/* loaded from: grasscutter.jar:com/lmax/disruptor/Sequence.class */
public class Sequence extends RhsPadding {
    static final long INITIAL_VALUE = -1;
    private static final VarHandle VALUE_FIELD;

    static {
        try {
            VALUE_FIELD = MethodHandles.lookup().in(Sequence.class).findVarHandle(Sequence.class, "value", Long.TYPE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Sequence() {
        this(-1);
    }

    public Sequence(long initialValue) {
        VarHandle.releaseFence();
        this.value = initialValue;
    }

    public long get() {
        long value = this.value;
        VarHandle.acquireFence();
        return value;
    }

    public void set(long value) {
        VarHandle.releaseFence();
        this.value = value;
    }

    public void setVolatile(long value) {
        VarHandle.releaseFence();
        this.value = value;
        VarHandle.fullFence();
    }

    public boolean compareAndSet(long expectedValue, long newValue) {
        return VALUE_FIELD.compareAndSet(this, expectedValue, newValue);
    }

    public long incrementAndGet() {
        return addAndGet(1);
    }

    public long addAndGet(long increment) {
        return VALUE_FIELD.getAndAdd(this, increment) + increment;
    }

    public long getAndAdd(long increment) {
        return VALUE_FIELD.getAndAdd(this, increment);
    }

    public String toString() {
        return Long.toString(get());
    }
}
