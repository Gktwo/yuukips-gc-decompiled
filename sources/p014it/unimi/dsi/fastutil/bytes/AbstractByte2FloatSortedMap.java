package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2FloatMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap;
import p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2FloatSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2FloatSortedMap.class */
public abstract class AbstractByte2FloatSortedMap extends AbstractByte2FloatMap implements Byte2FloatSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2FloatMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
    public ByteSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2FloatSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2FloatSortedMap$KeySet.class */
    public class KeySet extends AbstractByteSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return AbstractByte2FloatSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractByte2FloatSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractByte2FloatSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        public Comparator<? super Byte> comparator() {
            return AbstractByte2FloatSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte firstByte() {
            return AbstractByte2FloatSortedMap.this.firstByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte lastByte() {
            return AbstractByte2FloatSortedMap.this.lastByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet headSet(byte to) {
            return AbstractByte2FloatSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet tailSet(byte from) {
            return AbstractByte2FloatSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet subSet(byte from, byte to) {
            return AbstractByte2FloatSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteBidirectionalIterator iterator(byte from) {
            return new KeySetIterator(AbstractByte2FloatSortedMap.this.byte2FloatEntrySet().iterator(new AbstractByte2FloatMap.BasicEntry(from, 0.0f)));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSortedSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteBidirectionalIterator iterator() {
            return new KeySetIterator(Byte2FloatSortedMaps.fastIterator(AbstractByte2FloatSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2FloatSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2FloatSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements ByteBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Byte2FloatMap.Entry> f1061i;

        public KeySetIterator(ObjectBidirectionalIterator<Byte2FloatMap.Entry> i) {
            this.f1061i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return ((Byte2FloatMap.Entry) this.f1061i.next()).getByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
            return this.f1061i.previous().getByteKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1061i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1061i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2FloatMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
    public FloatCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2FloatSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2FloatSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractFloatCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatIterator iterator() {
            return new ValuesIterator(Byte2FloatSortedMaps.fastIterator(AbstractByte2FloatSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return AbstractByte2FloatSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractByte2FloatSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractByte2FloatSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2FloatSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2FloatSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements FloatIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Byte2FloatMap.Entry> f1062i;

        public ValuesIterator(ObjectBidirectionalIterator<Byte2FloatMap.Entry> i) {
            this.f1062i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return ((Byte2FloatMap.Entry) this.f1062i.next()).getFloatValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1062i.hasNext();
        }
    }
}
