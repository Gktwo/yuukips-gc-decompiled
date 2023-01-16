package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.ReflectionSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/AtomicDouble.class */
public class AtomicDouble extends Number implements Serializable {
    private static final long serialVersionUID = 0;
    private volatile transient long value;
    private static final AtomicLongFieldUpdater<AtomicDouble> updater = AtomicLongFieldUpdater.newUpdater(AtomicDouble.class, "value");

    public AtomicDouble(double initialValue) {
        this.value = Double.doubleToRawLongBits(initialValue);
    }

    public AtomicDouble() {
    }

    public final double get() {
        return Double.longBitsToDouble(this.value);
    }

    public final void set(double newValue) {
        this.value = Double.doubleToRawLongBits(newValue);
    }

    public final void lazySet(double newValue) {
        updater.lazySet(this, Double.doubleToRawLongBits(newValue));
    }

    public final double getAndSet(double newValue) {
        return Double.longBitsToDouble(updater.getAndSet(this, Double.doubleToRawLongBits(newValue)));
    }

    public final boolean compareAndSet(double expect, double update) {
        return updater.compareAndSet(this, Double.doubleToRawLongBits(expect), Double.doubleToRawLongBits(update));
    }

    public final boolean weakCompareAndSet(double expect, double update) {
        return updater.weakCompareAndSet(this, Double.doubleToRawLongBits(expect), Double.doubleToRawLongBits(update));
    }

    @CanIgnoreReturnValue
    public final double getAndAdd(double delta) {
        long current;
        double currentVal;
        do {
            current = this.value;
            currentVal = Double.longBitsToDouble(current);
        } while (!updater.compareAndSet(this, current, Double.doubleToRawLongBits(currentVal + delta)));
        return currentVal;
    }

    @CanIgnoreReturnValue
    public final double addAndGet(double delta) {
        long current;
        double nextVal;
        do {
            current = this.value;
            nextVal = Double.longBitsToDouble(current) + delta;
        } while (!updater.compareAndSet(this, current, Double.doubleToRawLongBits(nextVal)));
        return nextVal;
    }

    @Override // java.lang.Object
    public String toString() {
        return Double.toString(get());
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeDouble(get());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        set(s.readDouble());
    }
}
