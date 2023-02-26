package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2ByteMap;
import p014it.unimi.dsi.fastutil.longs.Long2ByteMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ByteSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ByteSortedMap.class */
public abstract class AbstractLong2ByteSortedMap extends AbstractLong2ByteMap implements Long2ByteSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ByteMap, p014it.unimi.dsi.fastutil.longs.Long2ByteMap, java.util.Map
    public LongSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ByteSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ByteSortedMap$KeySet.class */
    public class KeySet extends AbstractLongSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return AbstractLong2ByteSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractLong2ByteSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractLong2ByteSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        public Comparator<? super Long> comparator() {
            return AbstractLong2ByteSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long firstLong() {
            return AbstractLong2ByteSortedMap.this.firstLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long lastLong() {
            return AbstractLong2ByteSortedMap.this.lastLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet headSet(long to) {
            return AbstractLong2ByteSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet tailSet(long from) {
            return AbstractLong2ByteSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet subSet(long from, long to) {
            return AbstractLong2ByteSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongBidirectionalIterator iterator(long from) {
            return new KeySetIterator(AbstractLong2ByteSortedMap.this.long2ByteEntrySet().iterator(new AbstractLong2ByteMap.BasicEntry(from, (byte) 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBidirectionalIterator iterator() {
            return new KeySetIterator(Long2ByteSortedMaps.fastIterator(AbstractLong2ByteSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ByteSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ByteSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements LongBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Long2ByteMap.Entry> f2187i;

        public KeySetIterator(ObjectBidirectionalIterator<Long2ByteMap.Entry> i) {
            this.f2187i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return ((Long2ByteMap.Entry) this.f2187i.next()).getLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            return this.f2187i.previous().getLongKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2187i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2187i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ByteMap, p014it.unimi.dsi.fastutil.longs.Long2ByteMap, java.util.Map
    public ByteCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ByteSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ByteSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractByteCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteIterator iterator() {
            return new ValuesIterator(Long2ByteSortedMaps.fastIterator(AbstractLong2ByteSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return AbstractLong2ByteSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractLong2ByteSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractLong2ByteSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ByteSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ByteSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements ByteIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Long2ByteMap.Entry> f2188i;

        public ValuesIterator(ObjectBidirectionalIterator<Long2ByteMap.Entry> i) {
            this.f2188i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return ((Long2ByteMap.Entry) this.f2188i.next()).getByteValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2188i.hasNext();
        }
    }
}
