package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap;
import p014it.unimi.dsi.fastutil.floats.Float2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2BooleanSortedMap.class */
public abstract class AbstractFloat2BooleanSortedMap extends AbstractFloat2BooleanMap implements Float2BooleanSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
    public FloatSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2BooleanSortedMap$KeySet.class */
    public class KeySet extends AbstractFloatSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return AbstractFloat2BooleanSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractFloat2BooleanSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractFloat2BooleanSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        public Comparator<? super Float> comparator() {
            return AbstractFloat2BooleanSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float firstFloat() {
            return AbstractFloat2BooleanSortedMap.this.firstFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float lastFloat() {
            return AbstractFloat2BooleanSortedMap.this.lastFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet headSet(float to) {
            return AbstractFloat2BooleanSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet tailSet(float from) {
            return AbstractFloat2BooleanSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet subSet(float from, float to) {
            return AbstractFloat2BooleanSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatBidirectionalIterator iterator(float from) {
            return new KeySetIterator(AbstractFloat2BooleanSortedMap.this.float2BooleanEntrySet().iterator(new AbstractFloat2BooleanMap.BasicEntry(from, false)));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSortedSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatBidirectionalIterator iterator() {
            return new KeySetIterator(Float2BooleanSortedMaps.fastIterator(AbstractFloat2BooleanSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2BooleanSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements FloatBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Float2BooleanMap.Entry> f1720i;

        public KeySetIterator(ObjectBidirectionalIterator<Float2BooleanMap.Entry> i) {
            this.f1720i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return ((Float2BooleanMap.Entry) this.f1720i.next()).getFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
            return this.f1720i.previous().getFloatKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1720i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1720i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
    public BooleanCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2BooleanSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractBooleanCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanIterator iterator() {
            return new ValuesIterator(Float2BooleanSortedMaps.fastIterator(AbstractFloat2BooleanSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean contains(boolean k) {
            return AbstractFloat2BooleanSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractFloat2BooleanSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractFloat2BooleanSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2BooleanSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements BooleanIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Float2BooleanMap.Entry> f1721i;

        public ValuesIterator(ObjectBidirectionalIterator<Float2BooleanMap.Entry> i) {
            this.f1721i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            return ((Float2BooleanMap.Entry) this.f1721i.next()).getBooleanValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1721i.hasNext();
        }
    }
}
