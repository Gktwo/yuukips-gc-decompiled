package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/BoundType.class */
public enum BoundType {
    OPEN(false),
    CLOSED(true);
    
    final boolean inclusive;

    BoundType(boolean inclusive) {
        this.inclusive = inclusive;
    }

    /* access modifiers changed from: package-private */
    public static BoundType forBoolean(boolean inclusive) {
        return inclusive ? CLOSED : OPEN;
    }

    BoundType flip() {
        return forBoolean(!this.inclusive);
    }
}
