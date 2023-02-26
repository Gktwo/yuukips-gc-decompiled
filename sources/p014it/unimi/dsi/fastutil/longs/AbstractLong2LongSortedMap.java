package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap;
import p014it.unimi.dsi.fastutil.longs.Long2LongMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2LongSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2LongSortedMap.class */
public abstract class AbstractLong2LongSortedMap extends AbstractLong2LongMap implements Long2LongSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
    public LongSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2LongSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2LongSortedMap$KeySet.class */
    public class KeySet extends AbstractLongSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return AbstractLong2LongSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractLong2LongSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractLong2LongSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        public Comparator<? super Long> comparator() {
            return AbstractLong2LongSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long firstLong() {
            return AbstractLong2LongSortedMap.this.firstLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long lastLong() {
            return AbstractLong2LongSortedMap.this.lastLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet headSet(long to) {
            return AbstractLong2LongSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet tailSet(long from) {
            return AbstractLong2LongSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet subSet(long from, long to) {
            return AbstractLong2LongSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongBidirectionalIterator iterator(long from) {
            return new KeySetIterator(AbstractLong2LongSortedMap.this.long2LongEntrySet().iterator(new AbstractLong2LongMap.BasicEntry(from, 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBidirectionalIterator iterator() {
            return new KeySetIterator(Long2LongSortedMaps.fastIterator(AbstractLong2LongSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2LongSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2LongSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements LongBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Long2LongMap.Entry> f2207i;

        public KeySetIterator(ObjectBidirectionalIterator<Long2LongMap.Entry> i) {
            this.f2207i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return ((Long2LongMap.Entry) this.f2207i.next()).getLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            return this.f2207i.previous().getLongKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2207i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2207i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
    public LongCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2LongSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2LongSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractLongCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator iterator() {
            return new ValuesIterator(Long2LongSortedMaps.fastIterator(AbstractLong2LongSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return AbstractLong2LongSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractLong2LongSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractLong2LongSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2LongSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2LongSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements LongIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Long2LongMap.Entry> f2208i;

        public ValuesIterator(ObjectBidirectionalIterator<Long2LongMap.Entry> i) {
            this.f2208i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return ((Long2LongMap.Entry) this.f2208i.next()).getLongValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2208i.hasNext();
        }
    }
}
