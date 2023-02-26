package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ObjectSortedMap.class */
public abstract class AbstractByte2ObjectSortedMap<V> extends AbstractByte2ObjectMap<V> implements Byte2ObjectSortedMap<V> {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
    public ByteSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ObjectSortedMap$KeySet.class */
    public class KeySet extends AbstractByteSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return AbstractByte2ObjectSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractByte2ObjectSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractByte2ObjectSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        public Comparator<? super Byte> comparator() {
            return AbstractByte2ObjectSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte firstByte() {
            return AbstractByte2ObjectSortedMap.this.firstByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte lastByte() {
            return AbstractByte2ObjectSortedMap.this.lastByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet headSet(byte to) {
            return AbstractByte2ObjectSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet tailSet(byte from) {
            return AbstractByte2ObjectSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet subSet(byte from, byte to) {
            return AbstractByte2ObjectSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteBidirectionalIterator iterator(byte from) {
            return new KeySetIterator(AbstractByte2ObjectSortedMap.this.byte2ObjectEntrySet().iterator(new AbstractByte2ObjectMap.BasicEntry(from, (Object) null)));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSortedSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteBidirectionalIterator iterator() {
            return new KeySetIterator(Byte2ObjectSortedMaps.fastIterator(AbstractByte2ObjectSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ObjectSortedMap$KeySetIterator.class */
    public static class KeySetIterator<V> implements ByteBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Byte2ObjectMap.Entry<V>> f1073i;

        public KeySetIterator(ObjectBidirectionalIterator<Byte2ObjectMap.Entry<V>> i) {
            this.f1073i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return ((Byte2ObjectMap.Entry) this.f1073i.next()).getByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
            return this.f1073i.previous().getByteKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1073i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1073i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ObjectSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractObjectCollection<V> {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<V> iterator() {
            return new ValuesIterator(Byte2ObjectSortedMaps.fastIterator(AbstractByte2ObjectSortedMap.this));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object k) {
            return AbstractByte2ObjectSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractByte2ObjectSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractByte2ObjectSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ObjectSortedMap$ValuesIterator.class */
    public static class ValuesIterator<V> implements ObjectIterator<V> {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Byte2ObjectMap.Entry<V>> f1074i;

        public ValuesIterator(ObjectBidirectionalIterator<Byte2ObjectMap.Entry<V>> i) {
            this.f1074i = i;
        }

        @Override // java.util.Iterator
        public V next() {
            return ((Byte2ObjectMap.Entry) this.f1074i.next()).getValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1074i.hasNext();
        }
    }
}
