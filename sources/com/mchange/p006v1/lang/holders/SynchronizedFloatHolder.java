package com.mchange.p006v1.lang.holders;

/* renamed from: com.mchange.v1.lang.holders.SynchronizedFloatHolder */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/holders/SynchronizedFloatHolder.class */
public class SynchronizedFloatHolder implements ThreadSafeFloatHolder {
    float value;

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeFloatHolder
    public synchronized float getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeFloatHolder
    public synchronized void setValue(float f) {
        this.value = f;
    }
}
