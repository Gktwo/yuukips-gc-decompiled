package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2ObjectMap;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ObjectSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ObjectSortedMap.class */
public abstract class AbstractLong2ObjectSortedMap<V> extends AbstractLong2ObjectMap<V> implements Long2ObjectSortedMap<V> {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ObjectMap, p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, java.util.Map
    public LongSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ObjectSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ObjectSortedMap$KeySet.class */
    public class KeySet extends AbstractLongSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return AbstractLong2ObjectSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractLong2ObjectSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractLong2ObjectSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        public Comparator<? super Long> comparator() {
            return AbstractLong2ObjectSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long firstLong() {
            return AbstractLong2ObjectSortedMap.this.firstLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long lastLong() {
            return AbstractLong2ObjectSortedMap.this.lastLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet headSet(long to) {
            return AbstractLong2ObjectSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet tailSet(long from) {
            return AbstractLong2ObjectSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet subSet(long from, long to) {
            return AbstractLong2ObjectSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongBidirectionalIterator iterator(long from) {
            return new KeySetIterator(AbstractLong2ObjectSortedMap.this.long2ObjectEntrySet().iterator(new AbstractLong2ObjectMap.BasicEntry(from, (Object) null)));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBidirectionalIterator iterator() {
            return new KeySetIterator(Long2ObjectSortedMaps.fastIterator(AbstractLong2ObjectSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ObjectSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ObjectSortedMap$KeySetIterator.class */
    public static class KeySetIterator<V> implements LongBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Long2ObjectMap.Entry<V>> f2211i;

        public KeySetIterator(ObjectBidirectionalIterator<Long2ObjectMap.Entry<V>> i) {
            this.f2211i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return ((Long2ObjectMap.Entry) this.f2211i.next()).getLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            return this.f2211i.previous().getLongKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2211i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2211i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ObjectMap, p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ObjectSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ObjectSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractObjectCollection<V> {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<V> iterator() {
            return new ValuesIterator(Long2ObjectSortedMaps.fastIterator(AbstractLong2ObjectSortedMap.this));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object k) {
            return AbstractLong2ObjectSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractLong2ObjectSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractLong2ObjectSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ObjectSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ObjectSortedMap$ValuesIterator.class */
    public static class ValuesIterator<V> implements ObjectIterator<V> {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Long2ObjectMap.Entry<V>> f2212i;

        public ValuesIterator(ObjectBidirectionalIterator<Long2ObjectMap.Entry<V>> i) {
            this.f2212i = i;
        }

        @Override // java.util.Iterator
        public V next() {
            return ((Long2ObjectMap.Entry) this.f2212i.next()).getValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2212i.hasNext();
        }
    }
}
