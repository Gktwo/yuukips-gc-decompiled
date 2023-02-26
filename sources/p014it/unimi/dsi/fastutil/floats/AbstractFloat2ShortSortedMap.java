package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap;
import p014it.unimi.dsi.fastutil.floats.Float2ShortMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ShortSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ShortSortedMap.class */
public abstract class AbstractFloat2ShortSortedMap extends AbstractFloat2ShortMap implements Float2ShortSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
    public FloatSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ShortSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ShortSortedMap$KeySet.class */
    public class KeySet extends AbstractFloatSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return AbstractFloat2ShortSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractFloat2ShortSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractFloat2ShortSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        public Comparator<? super Float> comparator() {
            return AbstractFloat2ShortSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float firstFloat() {
            return AbstractFloat2ShortSortedMap.this.firstFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float lastFloat() {
            return AbstractFloat2ShortSortedMap.this.lastFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet headSet(float to) {
            return AbstractFloat2ShortSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet tailSet(float from) {
            return AbstractFloat2ShortSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet subSet(float from, float to) {
            return AbstractFloat2ShortSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatBidirectionalIterator iterator(float from) {
            return new KeySetIterator(AbstractFloat2ShortSortedMap.this.float2ShortEntrySet().iterator(new AbstractFloat2ShortMap.BasicEntry(from, (short) 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSortedSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatBidirectionalIterator iterator() {
            return new KeySetIterator(Float2ShortSortedMaps.fastIterator(AbstractFloat2ShortSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ShortSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ShortSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements FloatBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Float2ShortMap.Entry> f1756i;

        public KeySetIterator(ObjectBidirectionalIterator<Float2ShortMap.Entry> i) {
            this.f1756i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return ((Float2ShortMap.Entry) this.f1756i.next()).getFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
            return this.f1756i.previous().getFloatKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1756i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1756i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
    public ShortCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ShortSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ShortSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractShortCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortIterator iterator() {
            return new ValuesIterator(Float2ShortSortedMaps.fastIterator(AbstractFloat2ShortSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return AbstractFloat2ShortSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractFloat2ShortSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractFloat2ShortSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ShortSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ShortSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements ShortIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Float2ShortMap.Entry> f1757i;

        public ValuesIterator(ObjectBidirectionalIterator<Float2ShortMap.Entry> i) {
            this.f1757i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return ((Float2ShortMap.Entry) this.f1757i.next()).getShortValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1757i.hasNext();
        }
    }
}
