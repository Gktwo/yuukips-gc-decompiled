package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap;
import p014it.unimi.dsi.fastutil.ints.Int2CharMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2CharSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2CharSortedMap.class */
public abstract class AbstractInt2CharSortedMap extends AbstractInt2CharMap implements Int2CharSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
    public IntSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2CharSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2CharSortedMap$KeySet.class */
    public class KeySet extends AbstractIntSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return AbstractInt2CharSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractInt2CharSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractInt2CharSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        public Comparator<? super Integer> comparator() {
            return AbstractInt2CharSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int firstInt() {
            return AbstractInt2CharSortedMap.this.firstIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int lastInt() {
            return AbstractInt2CharSortedMap.this.lastIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet headSet(int to) {
            return AbstractInt2CharSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet tailSet(int from) {
            return AbstractInt2CharSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet subSet(int from, int to) {
            return AbstractInt2CharSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntBidirectionalIterator iterator(int from) {
            return new KeySetIterator(AbstractInt2CharSortedMap.this.int2CharEntrySet().iterator(new AbstractInt2CharMap.BasicEntry(from, (char) 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSortedSet, p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntBidirectionalIterator iterator() {
            return new KeySetIterator(Int2CharSortedMaps.fastIterator(AbstractInt2CharSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2CharSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2CharSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements IntBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Int2CharMap.Entry> f1949i;

        public KeySetIterator(ObjectBidirectionalIterator<Int2CharMap.Entry> i) {
            this.f1949i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return ((Int2CharMap.Entry) this.f1949i.next()).getIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            return this.f1949i.previous().getIntKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1949i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1949i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
    public CharCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2CharSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2CharSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractCharCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharIterator iterator() {
            return new ValuesIterator(Int2CharSortedMaps.fastIterator(AbstractInt2CharSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return AbstractInt2CharSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractInt2CharSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractInt2CharSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2CharSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2CharSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements CharIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Int2CharMap.Entry> f1950i;

        public ValuesIterator(ObjectBidirectionalIterator<Int2CharMap.Entry> i) {
            this.f1950i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return ((Int2CharMap.Entry) this.f1950i.next()).getCharValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1950i.hasNext();
        }
    }
}
