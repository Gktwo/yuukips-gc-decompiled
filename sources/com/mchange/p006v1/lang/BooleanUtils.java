package com.mchange.p006v1.lang;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;

/* renamed from: com.mchange.v1.lang.BooleanUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/BooleanUtils.class */
public final class BooleanUtils {
    public static boolean parseBoolean(String str) throws IllegalArgumentException {
        if (str.equals(C3P0Substitutions.DEBUG)) {
            return true;
        }
        if (str.equals("false")) {
            return false;
        }
        throw new IllegalArgumentException("\"str\" is neither \"true\" nor \"false\".");
    }

    private BooleanUtils() {
    }
}
