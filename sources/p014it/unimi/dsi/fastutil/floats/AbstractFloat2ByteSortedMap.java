package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2ByteMap;
import p014it.unimi.dsi.fastutil.floats.Float2ByteMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ByteSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ByteSortedMap.class */
public abstract class AbstractFloat2ByteSortedMap extends AbstractFloat2ByteMap implements Float2ByteSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ByteMap, p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
    public FloatSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ByteSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ByteSortedMap$KeySet.class */
    public class KeySet extends AbstractFloatSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return AbstractFloat2ByteSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractFloat2ByteSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractFloat2ByteSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        public Comparator<? super Float> comparator() {
            return AbstractFloat2ByteSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float firstFloat() {
            return AbstractFloat2ByteSortedMap.this.firstFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float lastFloat() {
            return AbstractFloat2ByteSortedMap.this.lastFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet headSet(float to) {
            return AbstractFloat2ByteSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet tailSet(float from) {
            return AbstractFloat2ByteSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet subSet(float from, float to) {
            return AbstractFloat2ByteSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatBidirectionalIterator iterator(float from) {
            return new KeySetIterator(AbstractFloat2ByteSortedMap.this.float2ByteEntrySet().iterator(new AbstractFloat2ByteMap.BasicEntry(from, (byte) 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSortedSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatBidirectionalIterator iterator() {
            return new KeySetIterator(Float2ByteSortedMaps.fastIterator(AbstractFloat2ByteSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ByteSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ByteSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements FloatBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Float2ByteMap.Entry> f1724i;

        public KeySetIterator(ObjectBidirectionalIterator<Float2ByteMap.Entry> i) {
            this.f1724i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return ((Float2ByteMap.Entry) this.f1724i.next()).getFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
            return this.f1724i.previous().getFloatKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1724i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1724i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ByteMap, p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
    public ByteCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ByteSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ByteSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractByteCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteIterator iterator() {
            return new ValuesIterator(Float2ByteSortedMaps.fastIterator(AbstractFloat2ByteSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return AbstractFloat2ByteSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractFloat2ByteSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractFloat2ByteSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ByteSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ByteSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements ByteIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Float2ByteMap.Entry> f1725i;

        public ValuesIterator(ObjectBidirectionalIterator<Float2ByteMap.Entry> i) {
            this.f1725i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return ((Float2ByteMap.Entry) this.f1725i.next()).getByteValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1725i.hasNext();
        }
    }
}
