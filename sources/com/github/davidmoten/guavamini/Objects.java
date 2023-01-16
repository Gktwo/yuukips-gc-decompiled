package com.github.davidmoten.guavamini;

import java.util.Arrays;

/* loaded from: grasscutter.jar:com/github/davidmoten/guavamini/Objects.class */
public final class Objects {
    private Objects() {
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }
}
