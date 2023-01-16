package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatIterator;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2FloatMap;
import p014it.unimi.dsi.fastutil.objects.Object2FloatMap;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2FloatSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2FloatSortedMap.class */
public abstract class AbstractObject2FloatSortedMap<K> extends AbstractObject2FloatMap<K> implements Object2FloatSortedMap<K> {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2FloatMap, p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
    public ObjectSortedSet<K> keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2FloatSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2FloatSortedMap$KeySet.class */
    public class KeySet extends AbstractObjectSortedSet<K> {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return AbstractObject2FloatSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractObject2FloatSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractObject2FloatSortedMap.this.clear();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return AbstractObject2FloatSortedMap.this.comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return (K) AbstractObject2FloatSortedMap.this.firstKey();
        }

        @Override // java.util.SortedSet
        public K last() {
            return (K) AbstractObject2FloatSortedMap.this.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> headSet(K to) {
            return AbstractObject2FloatSortedMap.this.headMap((AbstractObject2FloatSortedMap) to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> tailSet(K from) {
            return AbstractObject2FloatSortedMap.this.tailMap((AbstractObject2FloatSortedMap) from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> subSet(K from, K to) {
            return AbstractObject2FloatSortedMap.this.subMap((Object) from, (Object) to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public ObjectBidirectionalIterator<K> iterator(K from) {
            return new KeySetIterator(AbstractObject2FloatSortedMap.this.object2FloatEntrySet().iterator(new AbstractObject2FloatMap.BasicEntry(from, 0.0f)));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<K> iterator() {
            return new KeySetIterator(Object2FloatSortedMaps.fastIterator(AbstractObject2FloatSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2FloatSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2FloatSortedMap$KeySetIterator.class */
    public static class KeySetIterator<K> implements ObjectBidirectionalIterator<K> {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Object2FloatMap.Entry<K>> f2466i;

        public KeySetIterator(ObjectBidirectionalIterator<Object2FloatMap.Entry<K>> i) {
            this.f2466i = i;
        }

        @Override // java.util.Iterator
        public K next() {
            return ((Object2FloatMap.Entry) this.f2466i.next()).getKey();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return this.f2466i.previous().getKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2466i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2466i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2FloatMap, p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
    public FloatCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2FloatSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2FloatSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractFloatCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatIterator iterator() {
            return new ValuesIterator(Object2FloatSortedMaps.fastIterator(AbstractObject2FloatSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return AbstractObject2FloatSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractObject2FloatSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractObject2FloatSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2FloatSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2FloatSortedMap$ValuesIterator.class */
    public static class ValuesIterator<K> implements FloatIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Object2FloatMap.Entry<K>> f2467i;

        public ValuesIterator(ObjectBidirectionalIterator<Object2FloatMap.Entry<K>> i) {
            this.f2467i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return ((Object2FloatMap.Entry) this.f2467i.next()).getFloatValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2467i.hasNext();
        }
    }
}
