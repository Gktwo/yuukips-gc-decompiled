package com.mchange.p006v1.lang.holders;

/* renamed from: com.mchange.v1.lang.holders.VolatileByteHolder */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/holders/VolatileByteHolder.class */
public class VolatileByteHolder implements ThreadSafeByteHolder {
    volatile byte value;

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeByteHolder
    public byte getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeByteHolder
    public void setValue(byte b) {
        this.value = b;
    }
}
