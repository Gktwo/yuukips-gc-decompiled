package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/Platform.class */
final class Platform {
    /* access modifiers changed from: package-private */
    public static boolean isInstanceOfThrowableClass(Throwable t, Class<? extends Throwable> expectedClass) {
        return expectedClass.isInstance(t);
    }

    private Platform() {
    }
}
