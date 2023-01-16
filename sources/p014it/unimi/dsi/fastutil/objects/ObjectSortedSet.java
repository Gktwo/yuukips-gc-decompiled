package p014it.unimi.dsi.fastutil.objects;

import java.util.SortedSet;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectSortedSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSortedSet.class */
public interface ObjectSortedSet<K> extends ObjectSet<K>, SortedSet<K>, ObjectBidirectionalIterable<K> {
    ObjectBidirectionalIterator<K> iterator(K k);

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSet, p014it.unimi.dsi.fastutil.objects.ObjectCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable
    ObjectBidirectionalIterator<K> iterator();

    @Override // java.util.SortedSet
    ObjectSortedSet<K> subSet(K k, K k2);

    @Override // java.util.SortedSet
    ObjectSortedSet<K> headSet(K k);

    @Override // java.util.SortedSet
    ObjectSortedSet<K> tailSet(K k);

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSet, p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.util.Set
    default ObjectSpliterator<K> spliterator() {
        return ObjectSpliterators.asSpliteratorFromSorted(iterator(), Size64.sizeOf(this), 85, comparator());
    }
}
