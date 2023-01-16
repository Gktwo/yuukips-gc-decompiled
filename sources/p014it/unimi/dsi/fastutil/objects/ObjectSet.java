package p014it.unimi.dsi.fastutil.objects;

import java.util.Set;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSet.class */
public interface ObjectSet<K> extends ObjectCollection<K>, Set<K> {
    @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable
    ObjectIterator<K> iterator();

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    default ObjectSpliterator<K> spliterator() {
        return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 65);
    }

    /* renamed from: of */
    static <K> ObjectSet<K> m533of() {
        return ObjectSets.UNMODIFIABLE_EMPTY_SET;
    }

    /* renamed from: of */
    static <K> ObjectSet<K> m532of(K e) {
        return ObjectSets.singleton(e);
    }

    /* renamed from: of */
    static <K> ObjectSet<K> m531of(K e0, K e1) {
        ObjectArraySet<K> innerSet = new ObjectArraySet<>(2);
        innerSet.add(e0);
        if (innerSet.add(e1)) {
            return ObjectSets.unmodifiable(innerSet);
        }
        throw new IllegalArgumentException("Duplicate element: " + e1);
    }

    /* renamed from: of */
    static <K> ObjectSet<K> m530of(K e0, K e1, K e2) {
        ObjectArraySet<K> innerSet = new ObjectArraySet<>(3);
        innerSet.add(e0);
        if (!innerSet.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + e1);
        } else if (innerSet.add(e2)) {
            return ObjectSets.unmodifiable(innerSet);
        } else {
            throw new IllegalArgumentException("Duplicate element: " + e2);
        }
    }

    @SafeVarargs
    /* renamed from: of */
    static <K> ObjectSet<K> m529of(K... a) {
        switch (a.length) {
            case 0:
                return m533of();
            case 1:
                return m532of((Object) a[0]);
            case 2:
                return m531of((Object) a[0], (Object) a[1]);
            case 3:
                return m530of((Object) a[0], (Object) a[1], (Object) a[2]);
            default:
                ObjectSet<K> innerSet = a.length <= 4 ? new ObjectArraySet<>(a.length) : new ObjectOpenHashSet<>(a.length);
                for (K element : a) {
                    if (!innerSet.add(element)) {
                        throw new IllegalArgumentException("Duplicate element: " + element);
                    }
                }
                return ObjectSets.unmodifiable(innerSet);
        }
    }
}
