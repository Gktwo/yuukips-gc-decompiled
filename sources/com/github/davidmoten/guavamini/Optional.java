package com.github.davidmoten.guavamini;

/* loaded from: grasscutter.jar:com/github/davidmoten/guavamini/Optional.class */
public final class Optional<T> {
    private final T value;
    private final boolean present;

    /* loaded from: grasscutter.jar:com/github/davidmoten/guavamini/Optional$NotPresentException.class */
    public static class NotPresentException extends RuntimeException {
        private static final long serialVersionUID = -4444814681271790328L;
    }

    private Optional(T value, boolean present) {
        this.value = value;
        this.present = present;
    }

    private Optional() {
        this(null, false);
    }

    public boolean isPresent() {
        return this.present;
    }

    public T get() {
        if (this.present) {
            return this.value;
        }
        throw new NotPresentException();
    }

    /* renamed from: or */
    public T m1469or(T alternative) {
        if (this.present) {
            return this.value;
        }
        return alternative;
    }

    public static <T> Optional<T> fromNullable(T t) {
        if (t == null) {
            return absent();
        }
        return m1470of(t);
    }

    /* renamed from: of */
    public static <T> Optional<T> m1470of(T t) {
        return new Optional<>(t, true);
    }

    public static <T> Optional<T> absent() {
        return new Optional<>();
    }

    public String toString() {
        return this.present ? String.format("Optional.of(%s)", this.value) : "Optional.absent";
    }
}
