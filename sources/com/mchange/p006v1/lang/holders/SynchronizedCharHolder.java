package com.mchange.p006v1.lang.holders;

/* renamed from: com.mchange.v1.lang.holders.SynchronizedCharHolder */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/holders/SynchronizedCharHolder.class */
public class SynchronizedCharHolder implements ThreadSafeCharHolder {
    char value;

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeCharHolder
    public synchronized char getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeCharHolder
    public synchronized void setValue(char c) {
        this.value = c;
    }
}
