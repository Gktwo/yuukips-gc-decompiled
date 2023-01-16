package com.mongodb.assertions;

import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.lang.Nullable;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: grasscutter.jar:com/mongodb/assertions/Assertions.class */
public final class Assertions {
    public static <T> T notNull(String name, T value) {
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(name + " can not be null");
    }

    public static <T> T notNull(String name, T value, SingleResultCallback<?> callback) {
        if (value != null) {
            return value;
        }
        IllegalArgumentException exception = new IllegalArgumentException(name + " can not be null");
        callback.onResult(null, exception);
        throw exception;
    }

    public static void isTrue(String name, boolean condition) {
        if (!condition) {
            throw new IllegalStateException("state should be: " + name);
        }
    }

    public static void isTrue(String name, boolean condition, SingleResultCallback<?> callback) {
        if (!condition) {
            IllegalStateException exception = new IllegalStateException("state should be: " + name);
            callback.onResult(null, exception);
            throw exception;
        }
    }

    public static void isTrueArgument(String name, boolean condition) {
        if (!condition) {
            throw new IllegalArgumentException("state should be: " + name);
        }
    }

    public static void doesNotContainNull(String name, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException(name + " can not contain a null value");
            }
        }
    }

    @Nullable
    public static <T> T assertNull(@Nullable T value) throws AssertionError {
        if (value == null) {
            return null;
        }
        throw new AssertionError(value.toString());
    }

    public static <T> T assertNotNull(@Nullable T value) throws AssertionError {
        if (value != null) {
            return value;
        }
        throw new AssertionError();
    }

    public static boolean assertTrue(boolean value) throws AssertionError {
        if (value) {
            return true;
        }
        throw new AssertionError();
    }

    public static boolean assertFalse(boolean value) throws AssertionError {
        if (!value) {
            return false;
        }
        throw new AssertionError();
    }

    private Assertions() {
    }
}
