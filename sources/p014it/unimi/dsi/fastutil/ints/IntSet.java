package p014it.unimi.dsi.fastutil.ints;

import java.util.Set;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.ints.IntSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntSet.class */
public interface IntSet extends IntCollection, Set<Integer> {
    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
    IntIterator iterator();

    boolean remove(int i);

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
    default IntSpliterator spliterator() {
        return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 321);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
    @Deprecated
    default boolean remove(Object o) {
        return remove(o);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    @Deprecated
    default boolean add(Integer o) {
        return add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
    @Deprecated
    default boolean contains(Object o) {
        return contains(o);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    @Deprecated
    default boolean rem(int k) {
        return remove(k);
    }

    /* renamed from: of */
    static IntSet m700of() {
        return IntSets.UNMODIFIABLE_EMPTY_SET;
    }

    /* renamed from: of */
    static IntSet m699of(int e) {
        return IntSets.singleton(e);
    }

    /* renamed from: of */
    static IntSet m698of(int e0, int e1) {
        IntArraySet innerSet = new IntArraySet(2);
        innerSet.add(e0);
        if (innerSet.add(e1)) {
            return IntSets.unmodifiable(innerSet);
        }
        throw new IllegalArgumentException("Duplicate element: " + e1);
    }

    /* renamed from: of */
    static IntSet m697of(int e0, int e1, int e2) {
        IntArraySet innerSet = new IntArraySet(3);
        innerSet.add(e0);
        if (!innerSet.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + e1);
        } else if (innerSet.add(e2)) {
            return IntSets.unmodifiable(innerSet);
        } else {
            throw new IllegalArgumentException("Duplicate element: " + e2);
        }
    }

    /* renamed from: of */
    static IntSet m696of(int... a) {
        switch (a.length) {
            case 0:
                return m700of();
            case 1:
                return m699of(a[0]);
            case 2:
                return m698of(a[0], a[1]);
            case 3:
                return m697of(a[0], a[1], a[2]);
            default:
                IntSet innerSet = a.length <= 4 ? new IntArraySet(a.length) : new IntOpenHashSet(a.length);
                for (int element : a) {
                    if (!innerSet.add(element)) {
                        throw new IllegalArgumentException("Duplicate element: " + element);
                    }
                }
                return IntSets.unmodifiable(innerSet);
        }
    }
}
