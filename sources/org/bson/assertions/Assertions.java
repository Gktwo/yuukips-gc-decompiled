package org.bson.assertions;

/* loaded from: grasscutter.jar:org/bson/assertions/Assertions.class */
public final class Assertions {
    public static <T> T notNull(String name, T value) {
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(name + " can not be null");
    }

    public static void isTrue(String name, boolean condition) {
        if (!condition) {
            throw new IllegalStateException("state should be: " + name);
        }
    }

    public static void isTrueArgument(String name, boolean condition) {
        if (!condition) {
            throw new IllegalArgumentException("state should be: " + name);
        }
    }

    public static <T> T isTrueArgument(String name, T value, boolean condition) {
        if (condition) {
            return value;
        }
        throw new IllegalArgumentException("state should be: " + name);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T convertToType(Class<T> clazz, Object value, String errorMessage) {
        if (clazz.isAssignableFrom(value.getClass())) {
            return value;
        }
        throw new IllegalArgumentException(errorMessage);
    }

    private Assertions() {
    }
}
