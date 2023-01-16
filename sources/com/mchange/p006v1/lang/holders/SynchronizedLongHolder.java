package com.mchange.p006v1.lang.holders;

/* renamed from: com.mchange.v1.lang.holders.SynchronizedLongHolder */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/holders/SynchronizedLongHolder.class */
public class SynchronizedLongHolder implements ThreadSafeLongHolder {
    long value;

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeLongHolder
    public synchronized long getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeLongHolder
    public synchronized void setValue(long j) {
        this.value = j;
    }

    public SynchronizedLongHolder(long j) {
        this.value = j;
    }

    public SynchronizedLongHolder() {
        this(0);
    }
}
