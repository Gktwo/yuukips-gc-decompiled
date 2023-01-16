package com.github.davidmoten.rtreemulti.internal.util;

import com.github.davidmoten.guavamini.annotations.VisibleForTesting;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/util/ObjectsHelper.class */
public final class ObjectsHelper {
    private ObjectsHelper() {
    }

    @VisibleForTesting
    static void instantiateForTestCoveragePurposesOnly() {
        new ObjectsHelper();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T asClass(Object object, Class<T> cls) {
        if (object != 0 && object.getClass() == cls) {
            return object;
        }
        return null;
    }
}
