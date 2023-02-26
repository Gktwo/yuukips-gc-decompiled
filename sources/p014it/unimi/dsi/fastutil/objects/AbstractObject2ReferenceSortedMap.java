package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2ReferenceSortedMap.class */
public abstract class AbstractObject2ReferenceSortedMap<K, V> extends AbstractObject2ReferenceMap<K, V> implements Object2ReferenceSortedMap<K, V> {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    public ObjectSortedSet<K> keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2ReferenceSortedMap$KeySet.class */
    public class KeySet extends AbstractObjectSortedSet<K> {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return AbstractObject2ReferenceSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractObject2ReferenceSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractObject2ReferenceSortedMap.this.clear();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return AbstractObject2ReferenceSortedMap.this.comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return (K) AbstractObject2ReferenceSortedMap.this.firstKey();
        }

        @Override // java.util.SortedSet
        public K last() {
            return (K) AbstractObject2ReferenceSortedMap.this.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> headSet(K to) {
            return AbstractObject2ReferenceSortedMap.this.headMap((AbstractObject2ReferenceSortedMap) to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> tailSet(K from) {
            return AbstractObject2ReferenceSortedMap.this.tailMap((AbstractObject2ReferenceSortedMap) from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> subSet(K from, K to) {
            return AbstractObject2ReferenceSortedMap.this.subMap((Object) from, (Object) to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public ObjectBidirectionalIterator<K> iterator(K from) {
            return new KeySetIterator(AbstractObject2ReferenceSortedMap.this.object2ReferenceEntrySet().iterator(new AbstractObject2ReferenceMap.BasicEntry(from, null)));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<K> iterator() {
            return new KeySetIterator(Object2ReferenceSortedMaps.fastIterator(AbstractObject2ReferenceSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2ReferenceSortedMap$KeySetIterator.class */
    public static class KeySetIterator<K, V> implements ObjectBidirectionalIterator<K> {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Object2ReferenceMap.Entry<K, V>> f2446i;

        public KeySetIterator(ObjectBidirectionalIterator<Object2ReferenceMap.Entry<K, V>> i) {
            this.f2446i = i;
        }

        @Override // java.util.Iterator
        public K next() {
            return ((Object2ReferenceMap.Entry) this.f2446i.next()).getKey();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return this.f2446i.previous().getKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2446i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2446i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2ReferenceSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractReferenceCollection<V> {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectIterator<V> iterator() {
            return new ValuesIterator(Object2ReferenceSortedMaps.fastIterator(AbstractObject2ReferenceSortedMap.this));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object k) {
            return AbstractObject2ReferenceSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractObject2ReferenceSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractObject2ReferenceSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2ReferenceSortedMap$ValuesIterator.class */
    public static class ValuesIterator<K, V> implements ObjectIterator<V> {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Object2ReferenceMap.Entry<K, V>> f2447i;

        public ValuesIterator(ObjectBidirectionalIterator<Object2ReferenceMap.Entry<K, V>> i) {
            this.f2447i = i;
        }

        @Override // java.util.Iterator
        public V next() {
            return ((Object2ReferenceMap.Entry) this.f2447i.next()).getValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2447i.hasNext();
        }
    }
}
