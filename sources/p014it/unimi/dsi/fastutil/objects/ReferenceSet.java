package p014it.unimi.dsi.fastutil.objects;

import java.util.Set;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceSet.class */
public interface ReferenceSet<K> extends ReferenceCollection<K>, Set<K> {
    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
    ObjectIterator<K> iterator();

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    default ObjectSpliterator<K> spliterator() {
        return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 65);
    }

    /* renamed from: of */
    static <K> ReferenceSet<K> m474of() {
        return ReferenceSets.UNMODIFIABLE_EMPTY_SET;
    }

    /* renamed from: of */
    static <K> ReferenceSet<K> m473of(K e) {
        return ReferenceSets.singleton(e);
    }

    /* renamed from: of */
    static <K> ReferenceSet<K> m472of(K e0, K e1) {
        ReferenceArraySet<K> innerSet = new ReferenceArraySet<>(2);
        innerSet.add(e0);
        if (innerSet.add(e1)) {
            return ReferenceSets.unmodifiable(innerSet);
        }
        throw new IllegalArgumentException("Duplicate element: " + e1);
    }

    /* renamed from: of */
    static <K> ReferenceSet<K> m471of(K e0, K e1, K e2) {
        ReferenceArraySet<K> innerSet = new ReferenceArraySet<>(3);
        innerSet.add(e0);
        if (!innerSet.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + e1);
        } else if (innerSet.add(e2)) {
            return ReferenceSets.unmodifiable(innerSet);
        } else {
            throw new IllegalArgumentException("Duplicate element: " + e2);
        }
    }

    @SafeVarargs
    /* renamed from: of */
    static <K> ReferenceSet<K> m470of(K... a) {
        switch (a.length) {
            case 0:
                return m474of();
            case 1:
                return m473of((Object) a[0]);
            case 2:
                return m472of((Object) a[0], (Object) a[1]);
            case 3:
                return m471of((Object) a[0], (Object) a[1], (Object) a[2]);
            default:
                ReferenceSet<K> innerSet = a.length <= 4 ? new ReferenceArraySet<>(a.length) : new ReferenceOpenHashSet<>(a.length);
                for (K element : a) {
                    if (!innerSet.add(element)) {
                        throw new IllegalArgumentException("Duplicate element: " + element);
                    }
                }
                return ReferenceSets.unmodifiable(innerSet);
        }
    }
}
