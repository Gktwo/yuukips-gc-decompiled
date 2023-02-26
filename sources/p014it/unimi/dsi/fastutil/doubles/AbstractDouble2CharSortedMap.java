package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2CharMap;
import p014it.unimi.dsi.fastutil.doubles.Double2CharMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2CharSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2CharSortedMap.class */
public abstract class AbstractDouble2CharSortedMap extends AbstractDouble2CharMap implements Double2CharSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2CharMap, p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
    public DoubleSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2CharSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2CharSortedMap$KeySet.class */
    public class KeySet extends AbstractDoubleSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return AbstractDouble2CharSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractDouble2CharSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractDouble2CharSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        public Comparator<? super Double> comparator() {
            return AbstractDouble2CharSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double firstDouble() {
            return AbstractDouble2CharSortedMap.this.firstDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double lastDouble() {
            return AbstractDouble2CharSortedMap.this.lastDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet headSet(double to) {
            return AbstractDouble2CharSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet tailSet(double from) {
            return AbstractDouble2CharSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet subSet(double from, double to) {
            return AbstractDouble2CharSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleBidirectionalIterator iterator(double from) {
            return new KeySetIterator(AbstractDouble2CharSortedMap.this.double2CharEntrySet().iterator(new AbstractDouble2CharMap.BasicEntry(from, (char) 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSortedSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleBidirectionalIterator iterator() {
            return new KeySetIterator(Double2CharSortedMaps.fastIterator(AbstractDouble2CharSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2CharSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2CharSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements DoubleBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Double2CharMap.Entry> f1507i;

        public KeySetIterator(ObjectBidirectionalIterator<Double2CharMap.Entry> i) {
            this.f1507i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return ((Double2CharMap.Entry) this.f1507i.next()).getDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
            return this.f1507i.previous().getDoubleKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1507i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1507i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2CharMap, p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
    public CharCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2CharSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2CharSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractCharCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharIterator iterator() {
            return new ValuesIterator(Double2CharSortedMaps.fastIterator(AbstractDouble2CharSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return AbstractDouble2CharSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractDouble2CharSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractDouble2CharSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2CharSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2CharSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements CharIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Double2CharMap.Entry> f1508i;

        public ValuesIterator(ObjectBidirectionalIterator<Double2CharMap.Entry> i) {
            this.f1508i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return ((Double2CharMap.Entry) this.f1508i.next()).getCharValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1508i.hasNext();
        }
    }
}
