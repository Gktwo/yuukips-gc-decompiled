package com.mchange.p006v1.lang.holders;

/* renamed from: com.mchange.v1.lang.holders.VolatileFloatHolder */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/holders/VolatileFloatHolder.class */
public class VolatileFloatHolder implements ThreadSafeFloatHolder {
    volatile float value;

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeFloatHolder
    public float getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeFloatHolder
    public void setValue(float f) {
        this.value = f;
    }
}
