package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatIterator;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2FloatMap;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2FloatSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2FloatSortedMap.class */
public abstract class AbstractInt2FloatSortedMap extends AbstractInt2FloatMap implements Int2FloatSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2FloatMap, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
    public IntSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2FloatSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2FloatSortedMap$KeySet.class */
    public class KeySet extends AbstractIntSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return AbstractInt2FloatSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractInt2FloatSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractInt2FloatSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        public Comparator<? super Integer> comparator() {
            return AbstractInt2FloatSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int firstInt() {
            return AbstractInt2FloatSortedMap.this.firstIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int lastInt() {
            return AbstractInt2FloatSortedMap.this.lastIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet headSet(int to) {
            return AbstractInt2FloatSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet tailSet(int from) {
            return AbstractInt2FloatSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet subSet(int from, int to) {
            return AbstractInt2FloatSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntBidirectionalIterator iterator(int from) {
            return new KeySetIterator(AbstractInt2FloatSortedMap.this.int2FloatEntrySet().iterator(new AbstractInt2FloatMap.BasicEntry(from, 0.0f)));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSortedSet, p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntBidirectionalIterator iterator() {
            return new KeySetIterator(Int2FloatSortedMaps.fastIterator(AbstractInt2FloatSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2FloatSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2FloatSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements IntBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Int2FloatMap.Entry> f1957i;

        public KeySetIterator(ObjectBidirectionalIterator<Int2FloatMap.Entry> i) {
            this.f1957i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return ((Int2FloatMap.Entry) this.f1957i.next()).getIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            return this.f1957i.previous().getIntKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1957i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1957i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2FloatMap, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
    public FloatCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2FloatSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2FloatSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractFloatCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatIterator iterator() {
            return new ValuesIterator(Int2FloatSortedMaps.fastIterator(AbstractInt2FloatSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return AbstractInt2FloatSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractInt2FloatSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractInt2FloatSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2FloatSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2FloatSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements FloatIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Int2FloatMap.Entry> f1958i;

        public ValuesIterator(ObjectBidirectionalIterator<Int2FloatMap.Entry> i) {
            this.f1958i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return ((Int2FloatMap.Entry) this.f1958i.next()).getFloatValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1958i.hasNext();
        }
    }
}
