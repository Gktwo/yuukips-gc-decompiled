package com.mchange.p006v1.lang.holders;

/* renamed from: com.mchange.v1.lang.holders.SynchronizedShortHolder */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/holders/SynchronizedShortHolder.class */
public class SynchronizedShortHolder implements ThreadSafeShortHolder {
    short value;

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeShortHolder
    public synchronized short getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeShortHolder
    public synchronized void setValue(short s) {
        this.value = s;
    }
}
