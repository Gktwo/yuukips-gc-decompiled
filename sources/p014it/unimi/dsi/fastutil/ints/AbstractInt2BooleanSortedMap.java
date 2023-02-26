package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2BooleanMap;
import p014it.unimi.dsi.fastutil.ints.Int2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2BooleanSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2BooleanSortedMap.class */
public abstract class AbstractInt2BooleanSortedMap extends AbstractInt2BooleanMap implements Int2BooleanSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2BooleanMap, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
    public IntSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2BooleanSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2BooleanSortedMap$KeySet.class */
    public class KeySet extends AbstractIntSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return AbstractInt2BooleanSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractInt2BooleanSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractInt2BooleanSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        public Comparator<? super Integer> comparator() {
            return AbstractInt2BooleanSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int firstInt() {
            return AbstractInt2BooleanSortedMap.this.firstIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int lastInt() {
            return AbstractInt2BooleanSortedMap.this.lastIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet headSet(int to) {
            return AbstractInt2BooleanSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet tailSet(int from) {
            return AbstractInt2BooleanSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet subSet(int from, int to) {
            return AbstractInt2BooleanSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntBidirectionalIterator iterator(int from) {
            return new KeySetIterator(AbstractInt2BooleanSortedMap.this.int2BooleanEntrySet().iterator(new AbstractInt2BooleanMap.BasicEntry(from, false)));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSortedSet, p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntBidirectionalIterator iterator() {
            return new KeySetIterator(Int2BooleanSortedMaps.fastIterator(AbstractInt2BooleanSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2BooleanSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2BooleanSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements IntBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Int2BooleanMap.Entry> f1941i;

        public KeySetIterator(ObjectBidirectionalIterator<Int2BooleanMap.Entry> i) {
            this.f1941i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return ((Int2BooleanMap.Entry) this.f1941i.next()).getIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            return this.f1941i.previous().getIntKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1941i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1941i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2BooleanMap, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
    public BooleanCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2BooleanSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2BooleanSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractBooleanCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanIterator iterator() {
            return new ValuesIterator(Int2BooleanSortedMaps.fastIterator(AbstractInt2BooleanSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean contains(boolean k) {
            return AbstractInt2BooleanSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractInt2BooleanSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractInt2BooleanSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2BooleanSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2BooleanSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements BooleanIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Int2BooleanMap.Entry> f1942i;

        public ValuesIterator(ObjectBidirectionalIterator<Int2BooleanMap.Entry> i) {
            this.f1942i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            return ((Int2BooleanMap.Entry) this.f1942i.next()).getBooleanValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1942i.hasNext();
        }
    }
}
