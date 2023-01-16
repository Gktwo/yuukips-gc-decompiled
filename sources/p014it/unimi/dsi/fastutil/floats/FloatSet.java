package p014it.unimi.dsi.fastutil.floats;

import java.util.Set;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSet.class */
public interface FloatSet extends FloatCollection, Set<Float> {
    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
    FloatIterator iterator();

    boolean remove(float f);

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
    default FloatSpliterator spliterator() {
        return FloatSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 321);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
    @Deprecated
    default boolean remove(Object o) {
        return remove(o);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    @Deprecated
    default boolean add(Float o) {
        return add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
    @Deprecated
    default boolean contains(Object o) {
        return contains(o);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    @Deprecated
    default boolean rem(float k) {
        return remove(k);
    }

    /* renamed from: of */
    static FloatSet m784of() {
        return FloatSets.UNMODIFIABLE_EMPTY_SET;
    }

    /* renamed from: of */
    static FloatSet m783of(float e) {
        return FloatSets.singleton(e);
    }

    /* renamed from: of */
    static FloatSet m782of(float e0, float e1) {
        FloatArraySet innerSet = new FloatArraySet(2);
        innerSet.add(e0);
        if (innerSet.add(e1)) {
            return FloatSets.unmodifiable(innerSet);
        }
        throw new IllegalArgumentException("Duplicate element: " + e1);
    }

    /* renamed from: of */
    static FloatSet m781of(float e0, float e1, float e2) {
        FloatArraySet innerSet = new FloatArraySet(3);
        innerSet.add(e0);
        if (!innerSet.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + e1);
        } else if (innerSet.add(e2)) {
            return FloatSets.unmodifiable(innerSet);
        } else {
            throw new IllegalArgumentException("Duplicate element: " + e2);
        }
    }

    /* renamed from: of */
    static FloatSet m780of(float... a) {
        switch (a.length) {
            case 0:
                return m784of();
            case 1:
                return m783of(a[0]);
            case 2:
                return m782of(a[0], a[1]);
            case 3:
                return m781of(a[0], a[1], a[2]);
            default:
                FloatSet innerSet = a.length <= 4 ? new FloatArraySet(a.length) : new FloatOpenHashSet(a.length);
                for (float element : a) {
                    if (!innerSet.add(element)) {
                        throw new IllegalArgumentException("Duplicate element: " + element);
                    }
                }
                return FloatSets.unmodifiable(innerSet);
        }
    }
}
