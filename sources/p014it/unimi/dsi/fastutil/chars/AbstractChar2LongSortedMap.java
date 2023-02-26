package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2LongMap;
import p014it.unimi.dsi.fastutil.chars.Char2LongMap;
import p014it.unimi.dsi.fastutil.longs.AbstractLongCollection;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.longs.LongIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2LongSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2LongSortedMap.class */
public abstract class AbstractChar2LongSortedMap extends AbstractChar2LongMap implements Char2LongSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2LongMap, p014it.unimi.dsi.fastutil.chars.Char2LongMap, java.util.Map
    public CharSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2LongSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2LongSortedMap$KeySet.class */
    public class KeySet extends AbstractCharSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return AbstractChar2LongSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractChar2LongSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractChar2LongSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        public Comparator<? super Character> comparator() {
            return AbstractChar2LongSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char firstChar() {
            return AbstractChar2LongSortedMap.this.firstCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char lastChar() {
            return AbstractChar2LongSortedMap.this.lastCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet headSet(char to) {
            return AbstractChar2LongSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet tailSet(char from) {
            return AbstractChar2LongSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet subSet(char from, char to) {
            return AbstractChar2LongSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharBidirectionalIterator iterator(char from) {
            return new KeySetIterator(AbstractChar2LongSortedMap.this.char2LongEntrySet().iterator(new AbstractChar2LongMap.BasicEntry(from, 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSortedSet, p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharBidirectionalIterator iterator() {
            return new KeySetIterator(Char2LongSortedMaps.fastIterator(AbstractChar2LongSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2LongSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2LongSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements CharBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Char2LongMap.Entry> f1296i;

        public KeySetIterator(ObjectBidirectionalIterator<Char2LongMap.Entry> i) {
            this.f1296i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return ((Char2LongMap.Entry) this.f1296i.next()).getCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            return this.f1296i.previous().getCharKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1296i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1296i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2LongMap, p014it.unimi.dsi.fastutil.chars.Char2LongMap, java.util.Map
    public LongCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2LongSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2LongSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractLongCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator iterator() {
            return new ValuesIterator(Char2LongSortedMaps.fastIterator(AbstractChar2LongSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return AbstractChar2LongSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractChar2LongSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractChar2LongSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2LongSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2LongSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements LongIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Char2LongMap.Entry> f1297i;

        public ValuesIterator(ObjectBidirectionalIterator<Char2LongMap.Entry> i) {
            this.f1297i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return ((Char2LongMap.Entry) this.f1297i.next()).getLongValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1297i.hasNext();
        }
    }
}
