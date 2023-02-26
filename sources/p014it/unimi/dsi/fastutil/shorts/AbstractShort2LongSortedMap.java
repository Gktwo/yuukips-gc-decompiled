package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.longs.AbstractLongCollection;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.longs.LongIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2LongMap;
import p014it.unimi.dsi.fastutil.shorts.Short2LongMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2LongSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2LongSortedMap.class */
public abstract class AbstractShort2LongSortedMap extends AbstractShort2LongMap implements Short2LongSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
    public ShortSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2LongSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2LongSortedMap$KeySet.class */
    public class KeySet extends AbstractShortSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return AbstractShort2LongSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractShort2LongSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractShort2LongSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        public Comparator<? super Short> comparator() {
            return AbstractShort2LongSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short firstShort() {
            return AbstractShort2LongSortedMap.this.firstShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short lastShort() {
            return AbstractShort2LongSortedMap.this.lastShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet headSet(short to) {
            return AbstractShort2LongSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet tailSet(short from) {
            return AbstractShort2LongSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet subSet(short from, short to) {
            return AbstractShort2LongSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortBidirectionalIterator iterator(short from) {
            return new KeySetIterator(AbstractShort2LongSortedMap.this.short2LongEntrySet().iterator(new AbstractShort2LongMap.BasicEntry(from, 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSortedSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortBidirectionalIterator iterator() {
            return new KeySetIterator(Short2LongSortedMaps.fastIterator(AbstractShort2LongSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2LongSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2LongSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements ShortBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Short2LongMap.Entry> f2837i;

        public KeySetIterator(ObjectBidirectionalIterator<Short2LongMap.Entry> i) {
            this.f2837i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return ((Short2LongMap.Entry) this.f2837i.next()).getShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            return this.f2837i.previous().getShortKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2837i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2837i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
    public LongCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2LongSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2LongSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractLongCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator iterator() {
            return new ValuesIterator(Short2LongSortedMaps.fastIterator(AbstractShort2LongSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return AbstractShort2LongSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractShort2LongSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractShort2LongSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2LongSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2LongSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements LongIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Short2LongMap.Entry> f2838i;

        public ValuesIterator(ObjectBidirectionalIterator<Short2LongMap.Entry> i) {
            this.f2838i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return ((Short2LongMap.Entry) this.f2838i.next()).getLongValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2838i.hasNext();
        }
    }
}
