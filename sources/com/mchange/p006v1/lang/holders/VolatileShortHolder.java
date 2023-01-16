package com.mchange.p006v1.lang.holders;

/* renamed from: com.mchange.v1.lang.holders.VolatileShortHolder */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/holders/VolatileShortHolder.class */
public class VolatileShortHolder implements ThreadSafeShortHolder {
    volatile short value;

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeShortHolder
    public short getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeShortHolder
    public void setValue(short s) {
        this.value = s;
    }
}
