package com.mchange.p006v1.util;

import com.mchange.util.AssertException;

/* renamed from: com.mchange.v1.util.DebugUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/util/DebugUtils.class */
public class DebugUtils {
    private DebugUtils() {
    }

    public static void myAssert(boolean z) {
        if (!z) {
            throw new AssertException();
        }
    }

    public static void myAssert(boolean z, String str) {
        if (!z) {
            throw new AssertException(str);
        }
    }
}
