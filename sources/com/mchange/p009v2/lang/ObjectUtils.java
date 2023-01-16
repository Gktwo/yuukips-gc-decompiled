package com.mchange.p009v2.lang;

/* renamed from: com.mchange.v2.lang.ObjectUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/lang/ObjectUtils.class */
public final class ObjectUtils {
    public static boolean eqOrBothNull(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static int hashOrZero(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    private ObjectUtils() {
    }
}
