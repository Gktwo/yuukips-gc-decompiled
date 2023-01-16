package com.github.davidmoten.rtreemulti.internal.util;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/util/Pair.class */
public final class Pair<T> {
    private final T value1;
    private final T value2;

    public Pair(T value1, T value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T value1() {
        return this.value1;
    }

    public T value2() {
        return this.value2;
    }
}
