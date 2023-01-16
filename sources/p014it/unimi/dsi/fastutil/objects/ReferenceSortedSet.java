package p014it.unimi.dsi.fastutil.objects;

import java.util.SortedSet;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceSortedSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceSortedSet.class */
public interface ReferenceSortedSet<K> extends ReferenceSet<K>, SortedSet<K>, ObjectBidirectionalIterable<K> {
    ObjectBidirectionalIterator<K> iterator(K k);

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSet, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
    ObjectBidirectionalIterator<K> iterator();

    @Override // java.util.SortedSet
    ReferenceSortedSet<K> subSet(K k, K k2);

    @Override // java.util.SortedSet
    ReferenceSortedSet<K> headSet(K k);

    @Override // java.util.SortedSet
    ReferenceSortedSet<K> tailSet(K k);

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSet, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    default ObjectSpliterator<K> spliterator() {
        return ObjectSpliterators.asSpliteratorFromSorted(iterator(), Size64.sizeOf(this), 85, comparator());
    }
}
