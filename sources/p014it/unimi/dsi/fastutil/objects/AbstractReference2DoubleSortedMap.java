package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2DoubleSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2DoubleSortedMap.class */
public abstract class AbstractReference2DoubleSortedMap<K> extends AbstractReference2DoubleMap<K> implements Reference2DoubleSortedMap<K> {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
    public ReferenceSortedSet<K> keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2DoubleSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2DoubleSortedMap$KeySet.class */
    public class KeySet extends AbstractReferenceSortedSet<K> {
        protected KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return AbstractReference2DoubleSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractReference2DoubleSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractReference2DoubleSortedMap.this.clear();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return AbstractReference2DoubleSortedMap.this.comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return (K) AbstractReference2DoubleSortedMap.this.firstKey();
        }

        @Override // java.util.SortedSet
        public K last() {
            return (K) AbstractReference2DoubleSortedMap.this.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> headSet(K to) {
            return AbstractReference2DoubleSortedMap.this.headMap((AbstractReference2DoubleSortedMap) to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> tailSet(K from) {
            return AbstractReference2DoubleSortedMap.this.tailMap((AbstractReference2DoubleSortedMap) from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> subSet(K from, K to) {
            return AbstractReference2DoubleSortedMap.this.subMap((Object) from, (Object) to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet
        public ObjectBidirectionalIterator<K> iterator(K from) {
            return new KeySetIterator(AbstractReference2DoubleSortedMap.this.reference2DoubleEntrySet().iterator(new AbstractReference2DoubleMap.BasicEntry(from, 0.0d)));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectBidirectionalIterator<K> iterator() {
            return new KeySetIterator(Reference2DoubleSortedMaps.fastIterator(AbstractReference2DoubleSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2DoubleSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2DoubleSortedMap$KeySetIterator.class */
    public static class KeySetIterator<K> implements ObjectBidirectionalIterator<K> {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Reference2DoubleMap.Entry<K>> f2472i;

        public KeySetIterator(ObjectBidirectionalIterator<Reference2DoubleMap.Entry<K>> i) {
            this.f2472i = i;
        }

        @Override // java.util.Iterator
        public K next() {
            return ((Reference2DoubleMap.Entry) this.f2472i.next()).getKey();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return this.f2472i.previous().getKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2472i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2472i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
    public DoubleCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2DoubleSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2DoubleSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractDoubleCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator iterator() {
            return new ValuesIterator(Reference2DoubleSortedMaps.fastIterator(AbstractReference2DoubleSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return AbstractReference2DoubleSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractReference2DoubleSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractReference2DoubleSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2DoubleSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2DoubleSortedMap$ValuesIterator.class */
    public static class ValuesIterator<K> implements DoubleIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Reference2DoubleMap.Entry<K>> f2473i;

        public ValuesIterator(ObjectBidirectionalIterator<Reference2DoubleMap.Entry<K>> i) {
            this.f2473i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return ((Reference2DoubleMap.Entry) this.f2473i.next()).getDoubleValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2473i.hasNext();
        }
    }
}
