package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.Object2DoubleMap;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2DoubleSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2DoubleSortedMap.class */
public abstract class AbstractObject2DoubleSortedMap<K> extends AbstractObject2DoubleMap<K> implements Object2DoubleSortedMap<K> {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2DoubleMap, p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, java.util.Map
    public ObjectSortedSet<K> keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2DoubleSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2DoubleSortedMap$KeySet.class */
    public class KeySet extends AbstractObjectSortedSet<K> {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return AbstractObject2DoubleSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractObject2DoubleSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractObject2DoubleSortedMap.this.clear();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return AbstractObject2DoubleSortedMap.this.comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return (K) AbstractObject2DoubleSortedMap.this.firstKey();
        }

        @Override // java.util.SortedSet
        public K last() {
            return (K) AbstractObject2DoubleSortedMap.this.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> headSet(K to) {
            return AbstractObject2DoubleSortedMap.this.headMap((AbstractObject2DoubleSortedMap) to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> tailSet(K from) {
            return AbstractObject2DoubleSortedMap.this.tailMap((AbstractObject2DoubleSortedMap) from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> subSet(K from, K to) {
            return AbstractObject2DoubleSortedMap.this.subMap((Object) from, (Object) to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public ObjectBidirectionalIterator<K> iterator(K from) {
            return new KeySetIterator(AbstractObject2DoubleSortedMap.this.object2DoubleEntrySet().iterator(new AbstractObject2DoubleMap.BasicEntry(from, 0.0d)));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<K> iterator() {
            return new KeySetIterator(Object2DoubleSortedMaps.fastIterator(AbstractObject2DoubleSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2DoubleSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2DoubleSortedMap$KeySetIterator.class */
    public static class KeySetIterator<K> implements ObjectBidirectionalIterator<K> {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Object2DoubleMap.Entry<K>> f2462i;

        public KeySetIterator(ObjectBidirectionalIterator<Object2DoubleMap.Entry<K>> i) {
            this.f2462i = i;
        }

        @Override // java.util.Iterator
        public K next() {
            return ((Object2DoubleMap.Entry) this.f2462i.next()).getKey();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return this.f2462i.previous().getKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2462i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2462i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2DoubleMap, p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, java.util.Map
    public DoubleCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2DoubleSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2DoubleSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractDoubleCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator iterator() {
            return new ValuesIterator(Object2DoubleSortedMaps.fastIterator(AbstractObject2DoubleSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return AbstractObject2DoubleSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractObject2DoubleSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractObject2DoubleSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2DoubleSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2DoubleSortedMap$ValuesIterator.class */
    public static class ValuesIterator<K> implements DoubleIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Object2DoubleMap.Entry<K>> f2463i;

        public ValuesIterator(ObjectBidirectionalIterator<Object2DoubleMap.Entry<K>> i) {
            this.f2463i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return ((Object2DoubleMap.Entry) this.f2463i.next()).getDoubleValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2463i.hasNext();
        }
    }
}
