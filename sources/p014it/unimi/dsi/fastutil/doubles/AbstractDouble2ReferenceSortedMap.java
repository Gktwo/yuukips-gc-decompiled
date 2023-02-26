package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ReferenceMap;
import p014it.unimi.dsi.fastutil.doubles.Double2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2ReferenceSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2ReferenceSortedMap.class */
public abstract class AbstractDouble2ReferenceSortedMap<V> extends AbstractDouble2ReferenceMap<V> implements Double2ReferenceSortedMap<V> {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ReferenceMap, p014it.unimi.dsi.fastutil.doubles.Double2ReferenceMap, java.util.Map
    public DoubleSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2ReferenceSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2ReferenceSortedMap$KeySet.class */
    public class KeySet extends AbstractDoubleSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return AbstractDouble2ReferenceSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractDouble2ReferenceSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractDouble2ReferenceSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        public Comparator<? super Double> comparator() {
            return AbstractDouble2ReferenceSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double firstDouble() {
            return AbstractDouble2ReferenceSortedMap.this.firstDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double lastDouble() {
            return AbstractDouble2ReferenceSortedMap.this.lastDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet headSet(double to) {
            return AbstractDouble2ReferenceSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet tailSet(double from) {
            return AbstractDouble2ReferenceSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet subSet(double from, double to) {
            return AbstractDouble2ReferenceSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleBidirectionalIterator iterator(double from) {
            return new KeySetIterator(AbstractDouble2ReferenceSortedMap.this.double2ReferenceEntrySet().iterator(new AbstractDouble2ReferenceMap.BasicEntry(from, (Object) null)));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSortedSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleBidirectionalIterator iterator() {
            return new KeySetIterator(Double2ReferenceSortedMaps.fastIterator(AbstractDouble2ReferenceSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2ReferenceSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2ReferenceSortedMap$KeySetIterator.class */
    public static class KeySetIterator<V> implements DoubleBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Double2ReferenceMap.Entry<V>> f1531i;

        public KeySetIterator(ObjectBidirectionalIterator<Double2ReferenceMap.Entry<V>> i) {
            this.f1531i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return ((Double2ReferenceMap.Entry) this.f1531i.next()).getDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
            return this.f1531i.previous().getDoubleKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1531i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1531i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ReferenceMap, p014it.unimi.dsi.fastutil.doubles.Double2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2ReferenceSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2ReferenceSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractReferenceCollection<V> {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectIterator<V> iterator() {
            return new ValuesIterator(Double2ReferenceSortedMaps.fastIterator(AbstractDouble2ReferenceSortedMap.this));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object k) {
            return AbstractDouble2ReferenceSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractDouble2ReferenceSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractDouble2ReferenceSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2ReferenceSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2ReferenceSortedMap$ValuesIterator.class */
    public static class ValuesIterator<V> implements ObjectIterator<V> {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Double2ReferenceMap.Entry<V>> f1532i;

        public ValuesIterator(ObjectBidirectionalIterator<Double2ReferenceMap.Entry<V>> i) {
            this.f1532i = i;
        }

        @Override // java.util.Iterator
        public V next() {
            return ((Double2ReferenceMap.Entry) this.f1532i.next()).getValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1532i.hasNext();
        }
    }
}
