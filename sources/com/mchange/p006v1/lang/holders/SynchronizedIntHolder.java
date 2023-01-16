package com.mchange.p006v1.lang.holders;

/* renamed from: com.mchange.v1.lang.holders.SynchronizedIntHolder */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/holders/SynchronizedIntHolder.class */
public class SynchronizedIntHolder implements ThreadSafeIntHolder {
    int value;

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeIntHolder
    public synchronized int getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeIntHolder
    public synchronized void setValue(int i) {
        this.value = i;
    }
}
