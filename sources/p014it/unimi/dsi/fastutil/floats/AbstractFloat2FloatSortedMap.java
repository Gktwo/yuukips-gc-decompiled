package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2FloatMap;
import p014it.unimi.dsi.fastutil.floats.Float2FloatMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2FloatSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2FloatSortedMap.class */
public abstract class AbstractFloat2FloatSortedMap extends AbstractFloat2FloatMap implements Float2FloatSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2FloatMap, p014it.unimi.dsi.fastutil.floats.Float2FloatMap, java.util.Map
    public FloatSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2FloatSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2FloatSortedMap$KeySet.class */
    public class KeySet extends AbstractFloatSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return AbstractFloat2FloatSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractFloat2FloatSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractFloat2FloatSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        public Comparator<? super Float> comparator() {
            return AbstractFloat2FloatSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float firstFloat() {
            return AbstractFloat2FloatSortedMap.this.firstFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float lastFloat() {
            return AbstractFloat2FloatSortedMap.this.lastFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet headSet(float to) {
            return AbstractFloat2FloatSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet tailSet(float from) {
            return AbstractFloat2FloatSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet subSet(float from, float to) {
            return AbstractFloat2FloatSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatBidirectionalIterator iterator(float from) {
            return new KeySetIterator(AbstractFloat2FloatSortedMap.this.float2FloatEntrySet().iterator(new AbstractFloat2FloatMap.BasicEntry(from, 0.0f)));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSortedSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatBidirectionalIterator iterator() {
            return new KeySetIterator(Float2FloatSortedMaps.fastIterator(AbstractFloat2FloatSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2FloatSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2FloatSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements FloatBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Float2FloatMap.Entry> f1736i;

        public KeySetIterator(ObjectBidirectionalIterator<Float2FloatMap.Entry> i) {
            this.f1736i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return ((Float2FloatMap.Entry) this.f1736i.next()).getFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
            return this.f1736i.previous().getFloatKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1736i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1736i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2FloatMap, p014it.unimi.dsi.fastutil.floats.Float2FloatMap, java.util.Map
    public FloatCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2FloatSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2FloatSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractFloatCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatIterator iterator() {
            return new ValuesIterator(Float2FloatSortedMaps.fastIterator(AbstractFloat2FloatSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return AbstractFloat2FloatSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractFloat2FloatSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractFloat2FloatSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2FloatSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2FloatSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements FloatIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Float2FloatMap.Entry> f1737i;

        public ValuesIterator(ObjectBidirectionalIterator<Float2FloatMap.Entry> i) {
            this.f1737i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return ((Float2FloatMap.Entry) this.f1737i.next()).getFloatValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1737i.hasNext();
        }
    }
}
