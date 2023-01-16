package com.mchange.p006v1.lang.holders;

/* renamed from: com.mchange.v1.lang.holders.VolatileCharHolder */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/holders/VolatileCharHolder.class */
public class VolatileCharHolder implements ThreadSafeCharHolder {
    volatile char value;

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeCharHolder
    public char getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeCharHolder
    public void setValue(char c) {
        this.value = c;
    }
}
