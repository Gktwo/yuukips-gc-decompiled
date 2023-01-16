package com.mchange.p006v1.lang.holders;

/* renamed from: com.mchange.v1.lang.holders.SynchronizedDoubleHolder */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/holders/SynchronizedDoubleHolder.class */
public class SynchronizedDoubleHolder implements ThreadSafeDoubleHolder {
    double value;

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeDoubleHolder
    public synchronized double getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeDoubleHolder
    public synchronized void setValue(double d) {
        this.value = d;
    }
}
