package p014it.unimi.dsi.fastutil.shorts;

import java.util.Set;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSet.class */
public interface ShortSet extends ShortCollection, Set<Short> {
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    ShortIterator iterator();

    boolean remove(short s);

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    default ShortSpliterator spliterator() {
        return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 321);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
    @Deprecated
    default boolean remove(Object o) {
        return remove(o);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    @Deprecated
    default boolean add(Short o) {
        return add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
    @Deprecated
    default boolean contains(Object o) {
        return contains(o);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    @Deprecated
    default boolean rem(short k) {
        return remove(k);
    }

    /* renamed from: of */
    static ShortSet m392of() {
        return ShortSets.UNMODIFIABLE_EMPTY_SET;
    }

    /* renamed from: of */
    static ShortSet m391of(short e) {
        return ShortSets.singleton(e);
    }

    /* renamed from: of */
    static ShortSet m390of(short e0, short e1) {
        ShortArraySet innerSet = new ShortArraySet(2);
        innerSet.add(e0);
        if (innerSet.add(e1)) {
            return ShortSets.unmodifiable(innerSet);
        }
        throw new IllegalArgumentException("Duplicate element: " + ((int) e1));
    }

    /* renamed from: of */
    static ShortSet m389of(short e0, short e1, short e2) {
        ShortArraySet innerSet = new ShortArraySet(3);
        innerSet.add(e0);
        if (!innerSet.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + ((int) e1));
        } else if (innerSet.add(e2)) {
            return ShortSets.unmodifiable(innerSet);
        } else {
            throw new IllegalArgumentException("Duplicate element: " + ((int) e2));
        }
    }

    /* renamed from: of */
    static ShortSet m388of(short... a) {
        switch (a.length) {
            case 0:
                return m392of();
            case 1:
                return m391of(a[0]);
            case 2:
                return m390of(a[0], a[1]);
            case 3:
                return m389of(a[0], a[1], a[2]);
            default:
                ShortSet innerSet = a.length <= 4 ? new ShortArraySet(a.length) : new ShortOpenHashSet(a.length);
                for (short element : a) {
                    if (!innerSet.add(element)) {
                        throw new IllegalArgumentException("Duplicate element: " + ((int) element));
                    }
                }
                return ShortSets.unmodifiable(innerSet);
        }
    }
}
