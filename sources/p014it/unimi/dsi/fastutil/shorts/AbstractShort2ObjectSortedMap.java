package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2ObjectSortedMap.class */
public abstract class AbstractShort2ObjectSortedMap<V> extends AbstractShort2ObjectMap<V> implements Short2ObjectSortedMap<V> {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
    public ShortSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2ObjectSortedMap$KeySet.class */
    public class KeySet extends AbstractShortSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return AbstractShort2ObjectSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractShort2ObjectSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractShort2ObjectSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        public Comparator<? super Short> comparator() {
            return AbstractShort2ObjectSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short firstShort() {
            return AbstractShort2ObjectSortedMap.this.firstShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short lastShort() {
            return AbstractShort2ObjectSortedMap.this.lastShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet headSet(short to) {
            return AbstractShort2ObjectSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet tailSet(short from) {
            return AbstractShort2ObjectSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet subSet(short from, short to) {
            return AbstractShort2ObjectSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortBidirectionalIterator iterator(short from) {
            return new KeySetIterator(AbstractShort2ObjectSortedMap.this.short2ObjectEntrySet().iterator(new AbstractShort2ObjectMap.BasicEntry(from, (Object) null)));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSortedSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortBidirectionalIterator iterator() {
            return new KeySetIterator(Short2ObjectSortedMaps.fastIterator(AbstractShort2ObjectSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2ObjectSortedMap$KeySetIterator.class */
    public static class KeySetIterator<V> implements ShortBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Short2ObjectMap.Entry<V>> f2841i;

        public KeySetIterator(ObjectBidirectionalIterator<Short2ObjectMap.Entry<V>> i) {
            this.f2841i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return ((Short2ObjectMap.Entry) this.f2841i.next()).getShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            return this.f2841i.previous().getShortKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2841i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2841i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2ObjectSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractObjectCollection<V> {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<V> iterator() {
            return new ValuesIterator(Short2ObjectSortedMaps.fastIterator(AbstractShort2ObjectSortedMap.this));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object k) {
            return AbstractShort2ObjectSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractShort2ObjectSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractShort2ObjectSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2ObjectSortedMap$ValuesIterator.class */
    public static class ValuesIterator<V> implements ObjectIterator<V> {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Short2ObjectMap.Entry<V>> f2842i;

        public ValuesIterator(ObjectBidirectionalIterator<Short2ObjectMap.Entry<V>> i) {
            this.f2842i = i;
        }

        @Override // java.util.Iterator
        public V next() {
            return ((Short2ObjectMap.Entry) this.f2842i.next()).getValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2842i.hasNext();
        }
    }
}
