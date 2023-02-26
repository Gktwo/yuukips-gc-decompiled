package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2ObjectSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2ObjectSortedMap.class */
public abstract class AbstractInt2ObjectSortedMap<V> extends AbstractInt2ObjectMap<V> implements Int2ObjectSortedMap<V> {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap, p014it.unimi.dsi.fastutil.ints.Int2ObjectMap, java.util.Map
    public IntSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2ObjectSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2ObjectSortedMap$KeySet.class */
    public class KeySet extends AbstractIntSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return AbstractInt2ObjectSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractInt2ObjectSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractInt2ObjectSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        public Comparator<? super Integer> comparator() {
            return AbstractInt2ObjectSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int firstInt() {
            return AbstractInt2ObjectSortedMap.this.firstIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int lastInt() {
            return AbstractInt2ObjectSortedMap.this.lastIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet headSet(int to) {
            return AbstractInt2ObjectSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet tailSet(int from) {
            return AbstractInt2ObjectSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet subSet(int from, int to) {
            return AbstractInt2ObjectSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntBidirectionalIterator iterator(int from) {
            return new KeySetIterator(AbstractInt2ObjectSortedMap.this.int2ObjectEntrySet().iterator(new AbstractInt2ObjectMap.BasicEntry(from, (Object) null)));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSortedSet, p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntBidirectionalIterator iterator() {
            return new KeySetIterator(Int2ObjectSortedMaps.fastIterator(AbstractInt2ObjectSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2ObjectSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2ObjectSortedMap$KeySetIterator.class */
    public static class KeySetIterator<V> implements IntBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> f1969i;

        public KeySetIterator(ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> i) {
            this.f1969i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return ((Int2ObjectMap.Entry) this.f1969i.next()).getIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            return this.f1969i.previous().getIntKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1969i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1969i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap, p014it.unimi.dsi.fastutil.ints.Int2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2ObjectSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2ObjectSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractObjectCollection<V> {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<V> iterator() {
            return new ValuesIterator(Int2ObjectSortedMaps.fastIterator(AbstractInt2ObjectSortedMap.this));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object k) {
            return AbstractInt2ObjectSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractInt2ObjectSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractInt2ObjectSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2ObjectSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2ObjectSortedMap$ValuesIterator.class */
    public static class ValuesIterator<V> implements ObjectIterator<V> {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> f1970i;

        public ValuesIterator(ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> i) {
            this.f1970i = i;
        }

        @Override // java.util.Iterator
        public V next() {
            return ((Int2ObjectMap.Entry) this.f1970i.next()).getValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1970i.hasNext();
        }
    }
}
