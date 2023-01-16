package com.mchange.p006v1.lang.holders;

/* renamed from: com.mchange.v1.lang.holders.SynchronizedByteHolder */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/holders/SynchronizedByteHolder.class */
public class SynchronizedByteHolder implements ThreadSafeByteHolder {
    byte value;

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeByteHolder
    public synchronized byte getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeByteHolder
    public synchronized void setValue(byte b) {
        this.value = b;
    }
}
