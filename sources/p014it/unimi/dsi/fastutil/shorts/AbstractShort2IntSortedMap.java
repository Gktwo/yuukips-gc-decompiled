package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.ints.AbstractIntCollection;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap;
import p014it.unimi.dsi.fastutil.shorts.Short2IntMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2IntSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2IntSortedMap.class */
public abstract class AbstractShort2IntSortedMap extends AbstractShort2IntMap implements Short2IntSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
    public ShortSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2IntSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2IntSortedMap$KeySet.class */
    public class KeySet extends AbstractShortSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return AbstractShort2IntSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractShort2IntSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractShort2IntSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        public Comparator<? super Short> comparator() {
            return AbstractShort2IntSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short firstShort() {
            return AbstractShort2IntSortedMap.this.firstShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short lastShort() {
            return AbstractShort2IntSortedMap.this.lastShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet headSet(short to) {
            return AbstractShort2IntSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet tailSet(short from) {
            return AbstractShort2IntSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet subSet(short from, short to) {
            return AbstractShort2IntSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortBidirectionalIterator iterator(short from) {
            return new KeySetIterator(AbstractShort2IntSortedMap.this.short2IntEntrySet().iterator(new AbstractShort2IntMap.BasicEntry(from, 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSortedSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortBidirectionalIterator iterator() {
            return new KeySetIterator(Short2IntSortedMaps.fastIterator(AbstractShort2IntSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2IntSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2IntSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements ShortBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Short2IntMap.Entry> f2869i;

        public KeySetIterator(ObjectBidirectionalIterator<Short2IntMap.Entry> i) {
            this.f2869i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return ((Short2IntMap.Entry) this.f2869i.next()).getShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            return this.f2869i.previous().getShortKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2869i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2869i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
    public IntCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2IntSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2IntSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractIntCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator iterator() {
            return new ValuesIterator(Short2IntSortedMaps.fastIterator(AbstractShort2IntSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return AbstractShort2IntSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractShort2IntSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractShort2IntSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2IntSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2IntSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements IntIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Short2IntMap.Entry> f2870i;

        public ValuesIterator(ObjectBidirectionalIterator<Short2IntMap.Entry> i) {
            this.f2870i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return ((Short2IntMap.Entry) this.f2870i.next()).getIntValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2870i.hasNext();
        }
    }
}
