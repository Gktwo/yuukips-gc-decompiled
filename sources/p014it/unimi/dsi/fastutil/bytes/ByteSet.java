package p014it.unimi.dsi.fastutil.bytes;

import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteSet.class */
public interface ByteSet extends ByteCollection, Set<Byte> {
    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    Iterator<Byte> iterator();

    boolean remove(byte b);

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteIterator] */
    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    default Spliterator<Byte> spliterator() {
        return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 321);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
    @Deprecated
    default boolean remove(Object o) {
        return remove(o);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    @Deprecated
    default boolean add(Byte o) {
        return add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
    @Deprecated
    default boolean contains(Object o) {
        return contains(o);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    @Deprecated
    default boolean rem(byte k) {
        return remove(k);
    }

    /* renamed from: of */
    static ByteSet m1038of() {
        return ByteSets.UNMODIFIABLE_EMPTY_SET;
    }

    /* renamed from: of */
    static ByteSet m1037of(byte e) {
        return ByteSets.singleton(e);
    }

    /* renamed from: of */
    static ByteSet m1036of(byte e0, byte e1) {
        ByteArraySet innerSet = new ByteArraySet(2);
        innerSet.add(e0);
        if (innerSet.add(e1)) {
            return ByteSets.unmodifiable(innerSet);
        }
        throw new IllegalArgumentException("Duplicate element: " + ((int) e1));
    }

    /* renamed from: of */
    static ByteSet m1035of(byte e0, byte e1, byte e2) {
        ByteArraySet innerSet = new ByteArraySet(3);
        innerSet.add(e0);
        if (!innerSet.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + ((int) e1));
        } else if (innerSet.add(e2)) {
            return ByteSets.unmodifiable(innerSet);
        } else {
            throw new IllegalArgumentException("Duplicate element: " + ((int) e2));
        }
    }

    /* renamed from: of */
    static ByteSet m1034of(byte... a) {
        switch (a.length) {
            case 0:
                return m1038of();
            case 1:
                return m1037of(a[0]);
            case 2:
                return m1036of(a[0], a[1]);
            case 3:
                return m1035of(a[0], a[1], a[2]);
            default:
                ByteSet innerSet = a.length <= 4 ? new ByteArraySet(a.length) : new ByteOpenHashSet(a.length);
                for (byte element : a) {
                    if (!innerSet.add(element)) {
                        throw new IllegalArgumentException("Duplicate element: " + ((int) element));
                    }
                }
                return ByteSets.unmodifiable(innerSet);
        }
    }
}
