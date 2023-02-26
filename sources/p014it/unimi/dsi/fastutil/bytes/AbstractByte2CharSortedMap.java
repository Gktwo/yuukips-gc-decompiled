package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2CharMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharMap;
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2CharSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2CharSortedMap.class */
public abstract class AbstractByte2CharSortedMap extends AbstractByte2CharMap implements Byte2CharSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2CharMap, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, java.util.Map
    public ByteSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2CharSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2CharSortedMap$KeySet.class */
    public class KeySet extends AbstractByteSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return AbstractByte2CharSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractByte2CharSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractByte2CharSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        public Comparator<? super Byte> comparator() {
            return AbstractByte2CharSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte firstByte() {
            return AbstractByte2CharSortedMap.this.firstByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte lastByte() {
            return AbstractByte2CharSortedMap.this.lastByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet headSet(byte to) {
            return AbstractByte2CharSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet tailSet(byte from) {
            return AbstractByte2CharSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet subSet(byte from, byte to) {
            return AbstractByte2CharSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteBidirectionalIterator iterator(byte from) {
            return new KeySetIterator(AbstractByte2CharSortedMap.this.byte2CharEntrySet().iterator(new AbstractByte2CharMap.BasicEntry(from, (char) 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSortedSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteBidirectionalIterator iterator() {
            return new KeySetIterator(Byte2CharSortedMaps.fastIterator(AbstractByte2CharSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2CharSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2CharSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements ByteBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Byte2CharMap.Entry> f1053i;

        public KeySetIterator(ObjectBidirectionalIterator<Byte2CharMap.Entry> i) {
            this.f1053i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return ((Byte2CharMap.Entry) this.f1053i.next()).getByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
            return this.f1053i.previous().getByteKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1053i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1053i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2CharMap, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, java.util.Map
    public CharCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2CharSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2CharSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractCharCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharIterator iterator() {
            return new ValuesIterator(Byte2CharSortedMaps.fastIterator(AbstractByte2CharSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return AbstractByte2CharSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractByte2CharSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractByte2CharSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2CharSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2CharSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements CharIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Byte2CharMap.Entry> f1054i;

        public ValuesIterator(ObjectBidirectionalIterator<Byte2CharMap.Entry> i) {
            this.f1054i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return ((Byte2CharMap.Entry) this.f1054i.next()).getCharValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1054i.hasNext();
        }
    }
}
