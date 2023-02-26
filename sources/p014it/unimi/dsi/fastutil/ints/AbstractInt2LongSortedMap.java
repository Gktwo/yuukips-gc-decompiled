package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2LongMap;
import p014it.unimi.dsi.fastutil.ints.Int2LongMap;
import p014it.unimi.dsi.fastutil.longs.AbstractLongCollection;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.longs.LongIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2LongSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2LongSortedMap.class */
public abstract class AbstractInt2LongSortedMap extends AbstractInt2LongMap implements Int2LongSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2LongMap, p014it.unimi.dsi.fastutil.ints.Int2LongMap, java.util.Map
    public IntSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2LongSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2LongSortedMap$KeySet.class */
    public class KeySet extends AbstractIntSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return AbstractInt2LongSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractInt2LongSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractInt2LongSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        public Comparator<? super Integer> comparator() {
            return AbstractInt2LongSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int firstInt() {
            return AbstractInt2LongSortedMap.this.firstIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int lastInt() {
            return AbstractInt2LongSortedMap.this.lastIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet headSet(int to) {
            return AbstractInt2LongSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet tailSet(int from) {
            return AbstractInt2LongSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet subSet(int from, int to) {
            return AbstractInt2LongSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntBidirectionalIterator iterator(int from) {
            return new KeySetIterator(AbstractInt2LongSortedMap.this.int2LongEntrySet().iterator(new AbstractInt2LongMap.BasicEntry(from, 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSortedSet, p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntBidirectionalIterator iterator() {
            return new KeySetIterator(Int2LongSortedMaps.fastIterator(AbstractInt2LongSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2LongSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2LongSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements IntBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Int2LongMap.Entry> f1965i;

        public KeySetIterator(ObjectBidirectionalIterator<Int2LongMap.Entry> i) {
            this.f1965i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return ((Int2LongMap.Entry) this.f1965i.next()).getIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            return this.f1965i.previous().getIntKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1965i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1965i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2LongMap, p014it.unimi.dsi.fastutil.ints.Int2LongMap, java.util.Map
    public LongCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2LongSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2LongSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractLongCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator iterator() {
            return new ValuesIterator(Int2LongSortedMaps.fastIterator(AbstractInt2LongSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return AbstractInt2LongSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractInt2LongSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractInt2LongSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2LongSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2LongSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements LongIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Int2LongMap.Entry> f1966i;

        public ValuesIterator(ObjectBidirectionalIterator<Int2LongMap.Entry> i) {
            this.f1966i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return ((Int2LongMap.Entry) this.f1966i.next()).getLongValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1966i.hasNext();
        }
    }
}
