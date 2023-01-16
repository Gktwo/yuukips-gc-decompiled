package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/CollectPreconditions.class */
public final class CollectPreconditions {
    CollectPreconditions() {
    }

    /* access modifiers changed from: package-private */
    public static void checkEntryNotNull(Object key, Object value) {
        if (key == null) {
            throw new NullPointerException("null key in entry: null=" + value);
        } else if (value == null) {
            throw new NullPointerException("null value in entry: " + key + "=null");
        }
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static int checkNonnegative(int value, String name) {
        if (value >= 0) {
            return value;
        }
        throw new IllegalArgumentException(name + " cannot be negative but was: " + value);
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static long checkNonnegative(long value, String name) {
        if (value >= 0) {
            return value;
        }
        throw new IllegalArgumentException(name + " cannot be negative but was: " + value);
    }

    /* access modifiers changed from: package-private */
    public static void checkPositive(int value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(name + " must be positive but was: " + value);
        }
    }

    /* access modifiers changed from: package-private */
    public static void checkRemove(boolean canRemove) {
        Preconditions.checkState(canRemove, "no calls to next() since the last call to remove()");
    }
}
