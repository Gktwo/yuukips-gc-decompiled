package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatIterator;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap;
import p014it.unimi.dsi.fastutil.longs.Long2FloatMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2FloatSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2FloatSortedMap.class */
public abstract class AbstractLong2FloatSortedMap extends AbstractLong2FloatMap implements Long2FloatSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
    public LongSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2FloatSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2FloatSortedMap$KeySet.class */
    public class KeySet extends AbstractLongSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return AbstractLong2FloatSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractLong2FloatSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractLong2FloatSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        public Comparator<? super Long> comparator() {
            return AbstractLong2FloatSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long firstLong() {
            return AbstractLong2FloatSortedMap.this.firstLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long lastLong() {
            return AbstractLong2FloatSortedMap.this.lastLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet headSet(long to) {
            return AbstractLong2FloatSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet tailSet(long from) {
            return AbstractLong2FloatSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet subSet(long from, long to) {
            return AbstractLong2FloatSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongBidirectionalIterator iterator(long from) {
            return new KeySetIterator(AbstractLong2FloatSortedMap.this.long2FloatEntrySet().iterator(new AbstractLong2FloatMap.BasicEntry(from, 0.0f)));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBidirectionalIterator iterator() {
            return new KeySetIterator(Long2FloatSortedMaps.fastIterator(AbstractLong2FloatSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2FloatSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2FloatSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements LongBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Long2FloatMap.Entry> f2199i;

        public KeySetIterator(ObjectBidirectionalIterator<Long2FloatMap.Entry> i) {
            this.f2199i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return ((Long2FloatMap.Entry) this.f2199i.next()).getLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            return this.f2199i.previous().getLongKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2199i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2199i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
    public FloatCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2FloatSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2FloatSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractFloatCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatIterator iterator() {
            return new ValuesIterator(Long2FloatSortedMaps.fastIterator(AbstractLong2FloatSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return AbstractLong2FloatSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractLong2FloatSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractLong2FloatSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2FloatSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2FloatSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements FloatIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Long2FloatMap.Entry> f2200i;

        public ValuesIterator(ObjectBidirectionalIterator<Long2FloatMap.Entry> i) {
            this.f2200i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return ((Long2FloatMap.Entry) this.f2200i.next()).getFloatValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2200i.hasNext();
        }
    }
}
