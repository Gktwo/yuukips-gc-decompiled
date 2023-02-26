package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ShortSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ShortSortedMap.class */
public abstract class AbstractByte2ShortSortedMap extends AbstractByte2ShortMap implements Byte2ShortSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
    public ByteSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ShortSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ShortSortedMap$KeySet.class */
    public class KeySet extends AbstractByteSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return AbstractByte2ShortSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractByte2ShortSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractByte2ShortSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        public Comparator<? super Byte> comparator() {
            return AbstractByte2ShortSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte firstByte() {
            return AbstractByte2ShortSortedMap.this.firstByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte lastByte() {
            return AbstractByte2ShortSortedMap.this.lastByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet headSet(byte to) {
            return AbstractByte2ShortSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet tailSet(byte from) {
            return AbstractByte2ShortSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet subSet(byte from, byte to) {
            return AbstractByte2ShortSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteBidirectionalIterator iterator(byte from) {
            return new KeySetIterator(AbstractByte2ShortSortedMap.this.byte2ShortEntrySet().iterator(new AbstractByte2ShortMap.BasicEntry(from, (short) 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSortedSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteBidirectionalIterator iterator() {
            return new KeySetIterator(Byte2ShortSortedMaps.fastIterator(AbstractByte2ShortSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ShortSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ShortSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements ByteBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Byte2ShortMap.Entry> f1081i;

        public KeySetIterator(ObjectBidirectionalIterator<Byte2ShortMap.Entry> i) {
            this.f1081i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return ((Byte2ShortMap.Entry) this.f1081i.next()).getByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
            return this.f1081i.previous().getByteKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1081i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1081i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
    public ShortCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ShortSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ShortSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractShortCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortIterator iterator() {
            return new ValuesIterator(Byte2ShortSortedMaps.fastIterator(AbstractByte2ShortSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return AbstractByte2ShortSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractByte2ShortSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractByte2ShortSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ShortSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ShortSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements ShortIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Byte2ShortMap.Entry> f1082i;

        public ValuesIterator(ObjectBidirectionalIterator<Byte2ShortMap.Entry> i) {
            this.f1082i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return ((Byte2ShortMap.Entry) this.f1082i.next()).getShortValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1082i.hasNext();
        }
    }
}
