package com.mchange.p006v1.lang;

/* renamed from: com.mchange.v1.lang.NullUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/NullUtils.class */
public final class NullUtils {
    public static boolean equalsOrBothNull(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    private NullUtils() {
    }
}
