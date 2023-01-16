package p014it.unimi.dsi.fastutil.objects;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.objects.AbstractReferenceList;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceList.class */
public interface ReferenceList<K> extends List<K>, ReferenceCollection<K> {
    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
    ObjectListIterator<K> iterator();

    @Override // java.util.List
    ObjectListIterator<K> listIterator();

    @Override // java.util.List
    ObjectListIterator<K> listIterator(int i);

    @Override // java.util.List
    ReferenceList<K> subList(int i, int i2);

    void size(int i);

    void getElements(int i, Object[] objArr, int i2, int i3);

    void removeElements(int i, int i2);

    void addElements(int i, K[] kArr);

    void addElements(int i, K[] kArr, int i2, int i3);

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    default ObjectSpliterator<K> spliterator() {
        if (this instanceof RandomAccess) {
            return new AbstractReferenceList.IndexBasedSpliterator(this, 0);
        }
        return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), ObjectSpliterators.LIST_SPLITERATOR_CHARACTERISTICS);
    }

    default void setElements(K[] a) {
        setElements(0, a);
    }

    default void setElements(int index, K[] a) {
        setElements(index, a, 0, a.length);
    }

    default void setElements(int index, K[] a, int offset, int length) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is negative");
        } else if (index > size()) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than list size (" + size() + ")");
        } else {
            ObjectArrays.ensureOffsetLength(a, offset, length);
            if (index + length > size()) {
                throw new IndexOutOfBoundsException("End index (" + (index + length) + ") is greater than list size (" + size() + ")");
            }
            ObjectListIterator<K> iter = listIterator(index);
            int i = 0;
            while (i < length) {
                iter.next();
                i++;
                iter.set(a[offset + i]);
            }
        }
    }

    default boolean addAll(int index, ReferenceList<? extends K> l) {
        return addAll(index, (Collection) l);
    }

    default boolean addAll(ReferenceList<? extends K> l) {
        return addAll(size(), (ReferenceList) l);
    }

    /* renamed from: of */
    static <K> ReferenceList<K> m493of() {
        return ReferenceImmutableList.m503of();
    }

    /* renamed from: of */
    static <K> ReferenceList<K> m492of(K e) {
        return ReferenceLists.singleton(e);
    }

    /* renamed from: of */
    static <K> ReferenceList<K> m491of(K e0, K e1) {
        return ReferenceImmutableList.m502of(e0, e1);
    }

    /* renamed from: of */
    static <K> ReferenceList<K> m490of(K e0, K e1, K e2) {
        return ReferenceImmutableList.m502of(e0, e1, e2);
    }

    @SafeVarargs
    /* renamed from: of */
    static <K> ReferenceList<K> m489of(K... a) {
        switch (a.length) {
            case 0:
                return m493of();
            case 1:
                return m492of((Object) a[0]);
            default:
                return ReferenceImmutableList.m502of((Object[]) a);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: it.unimi.dsi.fastutil.objects.ReferenceList<K> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    default void sort(Comparator<? super K> comparator) {
        Object[] array = toArray();
        if (comparator == null) {
            ObjectArrays.stableSort(array);
        } else {
            ObjectArrays.stableSort(array, comparator);
        }
        setElements(array);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: it.unimi.dsi.fastutil.objects.ReferenceList<K> */
    /* JADX WARN: Multi-variable type inference failed */
    default void unstableSort(Comparator<? super K> comparator) {
        Object[] array = toArray();
        if (comparator == null) {
            ObjectArrays.unstableSort(array);
        } else {
            ObjectArrays.unstableSort(array, comparator);
        }
        setElements(array);
    }
}
