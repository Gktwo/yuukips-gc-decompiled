package org.jctools.util;

import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

/* loaded from: grasscutter.jar:org/jctools/util/PaddedAtomicLong.class */
public class PaddedAtomicLong extends PaddedAtomicLongL2Pad {
    @Override // org.jctools.util.PaddedAtomicLongL1Field
    public /* bridge */ /* synthetic */ long getAndAddVal(long j) {
        return getAndAddVal(j);
    }

    @Override // org.jctools.util.PaddedAtomicLongL1Field
    public /* bridge */ /* synthetic */ long getAndSetVal(long j) {
        return getAndSetVal(j);
    }

    @Override // org.jctools.util.PaddedAtomicLongL1Field
    public /* bridge */ /* synthetic */ boolean casVal(long j, long j2) {
        return casVal(j, j2);
    }

    @Override // org.jctools.util.PaddedAtomicLongL1Field
    public /* bridge */ /* synthetic */ long lpVal() {
        return lpVal();
    }

    @Override // org.jctools.util.PaddedAtomicLongL1Field
    public /* bridge */ /* synthetic */ long lvVal() {
        return lvVal();
    }

    @Override // org.jctools.util.PaddedAtomicLongL1Field
    public /* bridge */ /* synthetic */ void svVal(long j) {
        svVal(j);
    }

    @Override // org.jctools.util.PaddedAtomicLongL1Field
    public /* bridge */ /* synthetic */ void soVal(long j) {
        soVal(j);
    }

    @Override // org.jctools.util.PaddedAtomicLongL1Field
    public /* bridge */ /* synthetic */ void spVal(long j) {
        spVal(j);
    }

    public PaddedAtomicLong() {
    }

    public PaddedAtomicLong(long initialValue) {
        svVal(initialValue);
    }

    public long get() {
        return lvVal();
    }

    public void set(long newValue) {
        svVal(newValue);
    }

    public void lazySet(long newValue) {
        soVal(newValue);
    }

    public long getAndSet(long newValue) {
        return getAndSetVal(newValue);
    }

    public boolean compareAndSet(long expect, long update) {
        return casVal(expect, update);
    }

    public boolean weakCompareAndSet(long expect, long update) {
        return casVal(expect, update);
    }

    public long getAndIncrement() {
        return getAndAddVal(1);
    }

    public long getAndDecrement() {
        return getAndAddVal(-1);
    }

    public long getAndAdd(long delta) {
        return getAndAddVal(delta);
    }

    public long incrementAndGet() {
        return getAndAddVal(1) + 1;
    }

    public long decrementAndGet() {
        return getAndAddVal(-1) - 1;
    }

    public long addAndGet(long delta) {
        return getAndAddVal(delta) + delta;
    }

    public long getAndUpdate(LongUnaryOperator updateFunction) {
        long prev;
        do {
            prev = lvVal();
        } while (!casVal(prev, updateFunction.applyAsLong(prev)));
        return prev;
    }

    public long updateAndGet(LongUnaryOperator updateFunction) {
        long prev;
        long next;
        do {
            prev = lvVal();
            next = updateFunction.applyAsLong(prev);
        } while (!casVal(prev, next));
        return next;
    }

    public long getAndAccumulate(long v, LongBinaryOperator f) {
        long prev;
        do {
            prev = lvVal();
        } while (!casVal(prev, f.applyAsLong(prev, v)));
        return prev;
    }

    public long accumulateAndGet(long x, LongBinaryOperator f) {
        long prev;
        long next;
        do {
            prev = lvVal();
            next = f.applyAsLong(prev, x);
        } while (!casVal(prev, next));
        return next;
    }

    @Override // java.lang.Object
    public String toString() {
        return Long.toString(lvVal());
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) lvVal();
    }

    @Override // java.lang.Number
    public long longValue() {
        return lvVal();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) lvVal();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return (double) lvVal();
    }
}
