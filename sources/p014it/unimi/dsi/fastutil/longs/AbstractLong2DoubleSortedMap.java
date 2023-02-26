package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2DoubleMap;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2DoubleSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2DoubleSortedMap.class */
public abstract class AbstractLong2DoubleSortedMap extends AbstractLong2DoubleMap implements Long2DoubleSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2DoubleMap, p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, java.util.Map
    public LongSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2DoubleSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2DoubleSortedMap$KeySet.class */
    public class KeySet extends AbstractLongSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return AbstractLong2DoubleSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractLong2DoubleSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractLong2DoubleSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        public Comparator<? super Long> comparator() {
            return AbstractLong2DoubleSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long firstLong() {
            return AbstractLong2DoubleSortedMap.this.firstLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long lastLong() {
            return AbstractLong2DoubleSortedMap.this.lastLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet headSet(long to) {
            return AbstractLong2DoubleSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet tailSet(long from) {
            return AbstractLong2DoubleSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet subSet(long from, long to) {
            return AbstractLong2DoubleSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongBidirectionalIterator iterator(long from) {
            return new KeySetIterator(AbstractLong2DoubleSortedMap.this.long2DoubleEntrySet().iterator(new AbstractLong2DoubleMap.BasicEntry(from, 0.0d)));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBidirectionalIterator iterator() {
            return new KeySetIterator(Long2DoubleSortedMaps.fastIterator(AbstractLong2DoubleSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2DoubleSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2DoubleSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements LongBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Long2DoubleMap.Entry> f2195i;

        public KeySetIterator(ObjectBidirectionalIterator<Long2DoubleMap.Entry> i) {
            this.f2195i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return ((Long2DoubleMap.Entry) this.f2195i.next()).getLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            return this.f2195i.previous().getLongKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2195i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2195i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2DoubleMap, p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, java.util.Map
    public DoubleCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2DoubleSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2DoubleSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractDoubleCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator iterator() {
            return new ValuesIterator(Long2DoubleSortedMaps.fastIterator(AbstractLong2DoubleSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return AbstractLong2DoubleSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractLong2DoubleSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractLong2DoubleSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2DoubleSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2DoubleSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements DoubleIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Long2DoubleMap.Entry> f2196i;

        public ValuesIterator(ObjectBidirectionalIterator<Long2DoubleMap.Entry> i) {
            this.f2196i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return ((Long2DoubleMap.Entry) this.f2196i.next()).getDoubleValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2196i.hasNext();
        }
    }
}
