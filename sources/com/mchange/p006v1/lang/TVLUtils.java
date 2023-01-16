package com.mchange.p006v1.lang;

/* renamed from: com.mchange.v1.lang.TVLUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/TVLUtils.class */
public final class TVLUtils {
    public static final boolean isDefinitelyTrue(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public static final boolean isDefinitelyFalse(Boolean bool) {
        return bool != null && !bool.booleanValue();
    }

    public static final boolean isPossiblyTrue(Boolean bool) {
        return bool == null || bool.booleanValue();
    }

    public static final boolean isPossiblyFalse(Boolean bool) {
        return bool == null || !bool.booleanValue();
    }

    public static final boolean isUnknown(Boolean bool) {
        return bool == null;
    }
}
