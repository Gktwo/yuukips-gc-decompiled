package com.github.davidmoten.guavamini;

import java.util.Collection;

/* loaded from: grasscutter.jar:com/github/davidmoten/guavamini/Collections2.class */
public final class Collections2 {
    private Collections2() {
    }

    /* access modifiers changed from: package-private */
    public static <T> Collection<T> cast(Iterable<T> iterable) {
        return (Collection) iterable;
    }
}
