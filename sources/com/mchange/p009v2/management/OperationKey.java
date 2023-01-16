package com.mchange.p009v2.management;

import java.util.Arrays;

/* renamed from: com.mchange.v2.management.OperationKey */
/* loaded from: grasscutter.jar:com/mchange/v2/management/OperationKey.class */
public final class OperationKey {
    String name;
    String[] signature;

    public OperationKey(String str, String[] strArr) {
        this.name = str;
        this.signature = strArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof OperationKey)) {
            return false;
        }
        OperationKey operationKey = (OperationKey) obj;
        return this.name.equals(operationKey.name) && Arrays.equals(this.signature, operationKey.signature);
    }

    public int hashCode() {
        return this.name.hashCode() ^ Arrays.hashCode(this.signature);
    }
}
