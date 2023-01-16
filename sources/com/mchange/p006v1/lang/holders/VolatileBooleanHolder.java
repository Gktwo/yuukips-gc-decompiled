package com.mchange.p006v1.lang.holders;

/* renamed from: com.mchange.v1.lang.holders.VolatileBooleanHolder */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/holders/VolatileBooleanHolder.class */
public class VolatileBooleanHolder implements ThreadSafeBooleanHolder {
    volatile boolean value;

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeBooleanHolder
    public boolean getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.lang.holders.ThreadSafeBooleanHolder
    public void setValue(boolean z) {
        this.value = z;
    }
}
