package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2DoubleMap;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleMap;
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2DoubleSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2DoubleSortedMap.class */
public abstract class AbstractChar2DoubleSortedMap extends AbstractChar2DoubleMap implements Char2DoubleSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2DoubleMap, p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, java.util.Map
    public CharSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2DoubleSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2DoubleSortedMap$KeySet.class */
    public class KeySet extends AbstractCharSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return AbstractChar2DoubleSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractChar2DoubleSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractChar2DoubleSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        public Comparator<? super Character> comparator() {
            return AbstractChar2DoubleSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char firstChar() {
            return AbstractChar2DoubleSortedMap.this.firstCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char lastChar() {
            return AbstractChar2DoubleSortedMap.this.lastCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet headSet(char to) {
            return AbstractChar2DoubleSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet tailSet(char from) {
            return AbstractChar2DoubleSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet subSet(char from, char to) {
            return AbstractChar2DoubleSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharBidirectionalIterator iterator(char from) {
            return new KeySetIterator(AbstractChar2DoubleSortedMap.this.char2DoubleEntrySet().iterator(new AbstractChar2DoubleMap.BasicEntry(from, 0.0d)));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSortedSet, p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharBidirectionalIterator iterator() {
            return new KeySetIterator(Char2DoubleSortedMaps.fastIterator(AbstractChar2DoubleSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2DoubleSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2DoubleSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements CharBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Char2DoubleMap.Entry> f1284i;

        public KeySetIterator(ObjectBidirectionalIterator<Char2DoubleMap.Entry> i) {
            this.f1284i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return ((Char2DoubleMap.Entry) this.f1284i.next()).getCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            return this.f1284i.previous().getCharKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1284i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1284i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2DoubleMap, p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, java.util.Map
    public DoubleCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2DoubleSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2DoubleSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractDoubleCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator iterator() {
            return new ValuesIterator(Char2DoubleSortedMaps.fastIterator(AbstractChar2DoubleSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return AbstractChar2DoubleSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractChar2DoubleSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractChar2DoubleSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2DoubleSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2DoubleSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements DoubleIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Char2DoubleMap.Entry> f1285i;

        public ValuesIterator(ObjectBidirectionalIterator<Char2DoubleMap.Entry> i) {
            this.f1285i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return ((Char2DoubleMap.Entry) this.f1285i.next()).getDoubleValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1285i.hasNext();
        }
    }
}
