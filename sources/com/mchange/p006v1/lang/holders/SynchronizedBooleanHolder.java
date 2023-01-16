package com.mchange.p006v1.lang.holders;

/* renamed from: com.mchange.v1.lang.holders.SynchronizedBooleanHolder */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/holders/SynchronizedBooleanHolder.class */
public class SynchronizedBooleanHolder implements ThreadSafeBooleanHolder {
    boolean value;

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeBooleanHolder
    public synchronized boolean getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeBooleanHolder
    public synchronized void setValue(boolean z) {
        this.value = z;
    }
}
