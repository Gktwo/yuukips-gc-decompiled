package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectMap;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ObjectSortedMap.class */
public abstract class AbstractFloat2ObjectSortedMap<V> extends AbstractFloat2ObjectMap<V> implements Float2ObjectSortedMap<V> {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
    public FloatSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ObjectSortedMap$KeySet.class */
    public class KeySet extends AbstractFloatSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return AbstractFloat2ObjectSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractFloat2ObjectSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractFloat2ObjectSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        public Comparator<? super Float> comparator() {
            return AbstractFloat2ObjectSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float firstFloat() {
            return AbstractFloat2ObjectSortedMap.this.firstFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float lastFloat() {
            return AbstractFloat2ObjectSortedMap.this.lastFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet headSet(float to) {
            return AbstractFloat2ObjectSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet tailSet(float from) {
            return AbstractFloat2ObjectSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet subSet(float from, float to) {
            return AbstractFloat2ObjectSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatBidirectionalIterator iterator(float from) {
            return new KeySetIterator(AbstractFloat2ObjectSortedMap.this.float2ObjectEntrySet().iterator(new AbstractFloat2ObjectMap.BasicEntry(from, (Object) null)));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSortedSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatBidirectionalIterator iterator() {
            return new KeySetIterator(Float2ObjectSortedMaps.fastIterator(AbstractFloat2ObjectSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ObjectSortedMap$KeySetIterator.class */
    public static class KeySetIterator<V> implements FloatBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Float2ObjectMap.Entry<V>> f1748i;

        public KeySetIterator(ObjectBidirectionalIterator<Float2ObjectMap.Entry<V>> i) {
            this.f1748i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return ((Float2ObjectMap.Entry) this.f1748i.next()).getFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
            return this.f1748i.previous().getFloatKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1748i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1748i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ObjectSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractObjectCollection<V> {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<V> iterator() {
            return new ValuesIterator(Float2ObjectSortedMaps.fastIterator(AbstractFloat2ObjectSortedMap.this));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object k) {
            return AbstractFloat2ObjectSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractFloat2ObjectSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractFloat2ObjectSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ObjectSortedMap$ValuesIterator.class */
    public static class ValuesIterator<V> implements ObjectIterator<V> {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Float2ObjectMap.Entry<V>> f1749i;

        public ValuesIterator(ObjectBidirectionalIterator<Float2ObjectMap.Entry<V>> i) {
            this.f1749i = i;
        }

        @Override // java.util.Iterator
        public V next() {
            return ((Float2ObjectMap.Entry) this.f1749i.next()).getValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1749i.hasNext();
        }
    }
}
