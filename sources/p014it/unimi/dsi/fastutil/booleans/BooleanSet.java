package p014it.unimi.dsi.fastutil.booleans;

import java.util.Set;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSet.class */
public interface BooleanSet extends BooleanCollection, Set<Boolean> {
    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    BooleanIterator iterator();

    boolean remove(boolean z);

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    default BooleanSpliterator spliterator() {
        return BooleanSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 321);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection
    @Deprecated
    default boolean remove(Object o) {
        return remove(o);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    @Deprecated
    default boolean add(Boolean o) {
        return add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection
    @Deprecated
    default boolean contains(Object o) {
        return contains(o);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    @Deprecated
    default boolean rem(boolean k) {
        return remove(k);
    }

    /* renamed from: of */
    static BooleanSet m1122of() {
        return BooleanSets.UNMODIFIABLE_EMPTY_SET;
    }

    /* renamed from: of */
    static BooleanSet m1121of(boolean e) {
        return BooleanSets.singleton(e);
    }

    /* renamed from: of */
    static BooleanSet m1120of(boolean e0, boolean e1) {
        BooleanArraySet innerSet = new BooleanArraySet(2);
        innerSet.add(e0);
        if (innerSet.add(e1)) {
            return BooleanSets.unmodifiable(innerSet);
        }
        throw new IllegalArgumentException("Duplicate element: " + e1);
    }

    /* renamed from: of */
    static BooleanSet m1119of(boolean e0, boolean e1, boolean e2) {
        BooleanArraySet innerSet = new BooleanArraySet(3);
        innerSet.add(e0);
        if (!innerSet.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + e1);
        } else if (innerSet.add(e2)) {
            return BooleanSets.unmodifiable(innerSet);
        } else {
            throw new IllegalArgumentException("Duplicate element: " + e2);
        }
    }

    /* renamed from: of */
    static BooleanSet m1118of(boolean... a) {
        switch (a.length) {
            case 0:
                return m1122of();
            case 1:
                return m1121of(a[0]);
            case 2:
                return m1120of(a[0], a[1]);
            case 3:
                return m1119of(a[0], a[1], a[2]);
            default:
                BooleanSet innerSet = a.length <= 4 ? new BooleanArraySet(a.length) : new BooleanOpenHashSet(a.length);
                for (boolean element : a) {
                    if (!innerSet.add(element)) {
                        throw new IllegalArgumentException("Duplicate element: " + element);
                    }
                }
                return BooleanSets.unmodifiable(innerSet);
        }
    }
}
