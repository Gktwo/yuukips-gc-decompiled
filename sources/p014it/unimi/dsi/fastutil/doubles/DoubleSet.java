package p014it.unimi.dsi.fastutil.doubles;

import java.util.Set;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleSet.class */
public interface DoubleSet extends DoubleCollection, Set<Double> {
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    DoubleIterator iterator();

    boolean remove(double d);

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    default DoubleSpliterator spliterator() {
        return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 321);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
    @Deprecated
    default boolean remove(Object o) {
        return remove(o);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    @Deprecated
    default boolean add(Double o) {
        return add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
    @Deprecated
    default boolean contains(Object o) {
        return contains(o);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    @Deprecated
    default boolean rem(double k) {
        return remove(k);
    }

    /* renamed from: of */
    static DoubleSet m868of() {
        return DoubleSets.UNMODIFIABLE_EMPTY_SET;
    }

    /* renamed from: of */
    static DoubleSet m867of(double e) {
        return DoubleSets.singleton(e);
    }

    /* renamed from: of */
    static DoubleSet m866of(double e0, double e1) {
        DoubleArraySet innerSet = new DoubleArraySet(2);
        innerSet.add(e0);
        if (innerSet.add(e1)) {
            return DoubleSets.unmodifiable(innerSet);
        }
        throw new IllegalArgumentException("Duplicate element: " + e1);
    }

    /* renamed from: of */
    static DoubleSet m865of(double e0, double e1, double e2) {
        DoubleArraySet innerSet = new DoubleArraySet(3);
        innerSet.add(e0);
        if (!innerSet.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + e1);
        } else if (innerSet.add(e2)) {
            return DoubleSets.unmodifiable(innerSet);
        } else {
            throw new IllegalArgumentException("Duplicate element: " + e2);
        }
    }

    /* renamed from: of */
    static DoubleSet m864of(double... a) {
        switch (a.length) {
            case 0:
                return m868of();
            case 1:
                return m867of(a[0]);
            case 2:
                return m866of(a[0], a[1]);
            case 3:
                return m865of(a[0], a[1], a[2]);
            default:
                DoubleSet innerSet = a.length <= 4 ? new DoubleArraySet(a.length) : new DoubleOpenHashSet(a.length);
                for (double element : a) {
                    if (!innerSet.add(element)) {
                        throw new IllegalArgumentException("Duplicate element: " + element);
                    }
                }
                return DoubleSets.unmodifiable(innerSet);
        }
    }
}
