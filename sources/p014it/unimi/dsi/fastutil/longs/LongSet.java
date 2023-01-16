package p014it.unimi.dsi.fastutil.longs;

import java.util.Set;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.longs.LongSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSet.class */
public interface LongSet extends LongCollection, Set<Long> {
    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
    LongIterator iterator();

    boolean remove(long j);

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
    default LongSpliterator spliterator() {
        return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 321);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
    @Deprecated
    default boolean remove(Object o) {
        return remove(o);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    @Deprecated
    default boolean add(Long o) {
        return add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
    @Deprecated
    default boolean contains(Object o) {
        return contains(o);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    @Deprecated
    default boolean rem(long k) {
        return remove(k);
    }

    /* renamed from: of */
    static LongSet m615of() {
        return LongSets.UNMODIFIABLE_EMPTY_SET;
    }

    /* renamed from: of */
    static LongSet m614of(long e) {
        return LongSets.singleton(e);
    }

    /* renamed from: of */
    static LongSet m613of(long e0, long e1) {
        LongArraySet innerSet = new LongArraySet(2);
        innerSet.add(e0);
        if (innerSet.add(e1)) {
            return LongSets.unmodifiable(innerSet);
        }
        throw new IllegalArgumentException("Duplicate element: " + e1);
    }

    /* renamed from: of */
    static LongSet m612of(long e0, long e1, long e2) {
        LongArraySet innerSet = new LongArraySet(3);
        innerSet.add(e0);
        if (!innerSet.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + e1);
        } else if (innerSet.add(e2)) {
            return LongSets.unmodifiable(innerSet);
        } else {
            throw new IllegalArgumentException("Duplicate element: " + e2);
        }
    }

    /* renamed from: of */
    static LongSet m611of(long... a) {
        switch (a.length) {
            case 0:
                return m615of();
            case 1:
                return m614of(a[0]);
            case 2:
                return m613of(a[0], a[1]);
            case 3:
                return m612of(a[0], a[1], a[2]);
            default:
                LongSet innerSet = a.length <= 4 ? new LongArraySet(a.length) : new LongOpenHashSet(a.length);
                for (long element : a) {
                    if (!innerSet.add(element)) {
                        throw new IllegalArgumentException("Duplicate element: " + element);
                    }
                }
                return LongSets.unmodifiable(innerSet);
        }
    }
}
