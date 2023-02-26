package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanMap;
import p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2BooleanSortedMap.class */
public abstract class AbstractDouble2BooleanSortedMap extends AbstractDouble2BooleanMap implements Double2BooleanSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanMap, p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
    public DoubleSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2BooleanSortedMap$KeySet.class */
    public class KeySet extends AbstractDoubleSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return AbstractDouble2BooleanSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractDouble2BooleanSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractDouble2BooleanSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        public Comparator<? super Double> comparator() {
            return AbstractDouble2BooleanSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double firstDouble() {
            return AbstractDouble2BooleanSortedMap.this.firstDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double lastDouble() {
            return AbstractDouble2BooleanSortedMap.this.lastDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet headSet(double to) {
            return AbstractDouble2BooleanSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet tailSet(double from) {
            return AbstractDouble2BooleanSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet subSet(double from, double to) {
            return AbstractDouble2BooleanSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleBidirectionalIterator iterator(double from) {
            return new KeySetIterator(AbstractDouble2BooleanSortedMap.this.double2BooleanEntrySet().iterator(new AbstractDouble2BooleanMap.BasicEntry(from, false)));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSortedSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleBidirectionalIterator iterator() {
            return new KeySetIterator(Double2BooleanSortedMaps.fastIterator(AbstractDouble2BooleanSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2BooleanSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements DoubleBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Double2BooleanMap.Entry> f1499i;

        public KeySetIterator(ObjectBidirectionalIterator<Double2BooleanMap.Entry> i) {
            this.f1499i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return ((Double2BooleanMap.Entry) this.f1499i.next()).getDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
            return this.f1499i.previous().getDoubleKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1499i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1499i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanMap, p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
    public BooleanCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2BooleanSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractBooleanCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanIterator iterator() {
            return new ValuesIterator(Double2BooleanSortedMaps.fastIterator(AbstractDouble2BooleanSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean contains(boolean k) {
            return AbstractDouble2BooleanSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractDouble2BooleanSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractDouble2BooleanSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2BooleanSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements BooleanIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Double2BooleanMap.Entry> f1500i;

        public ValuesIterator(ObjectBidirectionalIterator<Double2BooleanMap.Entry> i) {
            this.f1500i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            return ((Double2BooleanMap.Entry) this.f1500i.next()).getBooleanValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1500i.hasNext();
        }
    }
}
