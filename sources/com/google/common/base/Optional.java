package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

@GwtCompatible(serializable = true)
/* loaded from: grasscutter.jar:com/google/common/base/Optional.class */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract boolean isPresent();

    public abstract T get();

    /* renamed from: or */
    public abstract T mo1456or(T t);

    /* renamed from: or */
    public abstract Optional<T> mo1458or(Optional<? extends T> optional);

    @Beta
    /* renamed from: or */
    public abstract T mo1457or(Supplier<? extends T> supplier);

    public abstract T orNull();

    public abstract Set<T> asSet();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);

    @Override // java.lang.Object
    public abstract boolean equals(Object obj);

    @Override // java.lang.Object
    public abstract int hashCode();

    @Override // java.lang.Object
    public abstract String toString();

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    /* renamed from: of */
    public static <T> Optional<T> m1463of(T reference) {
        return new Present(Preconditions.checkNotNull(reference));
    }

    public static <T> Optional<T> fromNullable(T nullableReference) {
        return nullableReference == null ? absent() : new Present(nullableReference);
    }

    public static <T> Optional<T> fromJavaUtil(java.util.Optional<T> javaUtilOptional) {
        if (javaUtilOptional == null) {
            return null;
        }
        return fromNullable(javaUtilOptional.orElse(null));
    }

    public static <T> java.util.Optional<T> toJavaUtil(Optional<T> googleOptional) {
        if (googleOptional == null) {
            return null;
        }
        return googleOptional.toJavaUtil();
    }

    public java.util.Optional<T> toJavaUtil() {
        return java.util.Optional.ofNullable(orNull());
    }

    @Beta
    public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> optionals) {
        Preconditions.checkNotNull(optionals);
        return new Iterable<T>() { // from class: com.google.common.base.Optional.1
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return new AbstractIterator<T>() { // from class: com.google.common.base.Optional.1.1
                    private final Iterator<? extends Optional<? extends T>> iterator;

                    {
                        this.iterator = (Iterator) Preconditions.checkNotNull(optionals.iterator());
                    }

                    @Override // com.google.common.base.AbstractIterator
                    protected T computeNext() {
                        while (this.iterator.hasNext()) {
                            Optional<? extends T> optional = (Optional) this.iterator.next();
                            if (optional.isPresent()) {
                                return (T) optional.get();
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }
}
