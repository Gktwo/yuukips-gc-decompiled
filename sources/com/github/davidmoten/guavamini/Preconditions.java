package com.github.davidmoten.guavamini;

/* loaded from: grasscutter.jar:com/github/davidmoten/guavamini/Preconditions.class */
public final class Preconditions {
    private Preconditions() {
    }

    public static <T> T checkNotNull(T t) {
        return (T) checkNotNull(t, null);
    }

    public static <T> T checkNotNull(T t, String message) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(message);
    }

    public static void checkArgument(boolean b, String message) {
        if (!b) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void checkArgument(boolean b) {
        if (!b) {
            throw new IllegalArgumentException();
        }
    }
}
