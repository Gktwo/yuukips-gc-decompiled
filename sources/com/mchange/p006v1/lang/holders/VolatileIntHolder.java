package com.mchange.p006v1.lang.holders;

/* renamed from: com.mchange.v1.lang.holders.VolatileIntHolder */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/holders/VolatileIntHolder.class */
public class VolatileIntHolder implements ThreadSafeIntHolder {
    volatile int value;

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeIntHolder
    public int getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeIntHolder
    public void setValue(int i) {
        this.value = i;
    }
}
