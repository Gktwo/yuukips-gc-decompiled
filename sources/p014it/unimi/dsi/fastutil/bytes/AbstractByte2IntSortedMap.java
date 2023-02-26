package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2IntMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2IntMap;
import p014it.unimi.dsi.fastutil.ints.AbstractIntCollection;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2IntSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2IntSortedMap.class */
public abstract class AbstractByte2IntSortedMap extends AbstractByte2IntMap implements Byte2IntSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2IntMap, p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
    public ByteSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2IntSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2IntSortedMap$KeySet.class */
    public class KeySet extends AbstractByteSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return AbstractByte2IntSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractByte2IntSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractByte2IntSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        public Comparator<? super Byte> comparator() {
            return AbstractByte2IntSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte firstByte() {
            return AbstractByte2IntSortedMap.this.firstByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte lastByte() {
            return AbstractByte2IntSortedMap.this.lastByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet headSet(byte to) {
            return AbstractByte2IntSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet tailSet(byte from) {
            return AbstractByte2IntSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet subSet(byte from, byte to) {
            return AbstractByte2IntSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteBidirectionalIterator iterator(byte from) {
            return new KeySetIterator(AbstractByte2IntSortedMap.this.byte2IntEntrySet().iterator(new AbstractByte2IntMap.BasicEntry(from, 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSortedSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteBidirectionalIterator iterator() {
            return new KeySetIterator(Byte2IntSortedMaps.fastIterator(AbstractByte2IntSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2IntSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2IntSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements ByteBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Byte2IntMap.Entry> f1065i;

        public KeySetIterator(ObjectBidirectionalIterator<Byte2IntMap.Entry> i) {
            this.f1065i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return ((Byte2IntMap.Entry) this.f1065i.next()).getByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
            return this.f1065i.previous().getByteKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1065i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1065i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2IntMap, p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
    public IntCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2IntSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2IntSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractIntCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator iterator() {
            return new ValuesIterator(Byte2IntSortedMaps.fastIterator(AbstractByte2IntSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return AbstractByte2IntSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractByte2IntSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractByte2IntSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2IntSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2IntSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements IntIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Byte2IntMap.Entry> f1066i;

        public ValuesIterator(ObjectBidirectionalIterator<Byte2IntMap.Entry> i) {
            this.f1066i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return ((Byte2IntMap.Entry) this.f1066i.next()).getIntValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1066i.hasNext();
        }
    }
}
