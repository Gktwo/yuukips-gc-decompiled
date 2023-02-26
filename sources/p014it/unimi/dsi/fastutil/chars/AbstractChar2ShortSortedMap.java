package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2ShortMap;
import p014it.unimi.dsi.fastutil.chars.Char2ShortMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ShortSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ShortSortedMap.class */
public abstract class AbstractChar2ShortSortedMap extends AbstractChar2ShortMap implements Char2ShortSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ShortMap, p014it.unimi.dsi.fastutil.chars.Char2ShortMap, java.util.Map
    public CharSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ShortSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ShortSortedMap$KeySet.class */
    public class KeySet extends AbstractCharSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return AbstractChar2ShortSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractChar2ShortSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractChar2ShortSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        public Comparator<? super Character> comparator() {
            return AbstractChar2ShortSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char firstChar() {
            return AbstractChar2ShortSortedMap.this.firstCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char lastChar() {
            return AbstractChar2ShortSortedMap.this.lastCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet headSet(char to) {
            return AbstractChar2ShortSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet tailSet(char from) {
            return AbstractChar2ShortSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet subSet(char from, char to) {
            return AbstractChar2ShortSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharBidirectionalIterator iterator(char from) {
            return new KeySetIterator(AbstractChar2ShortSortedMap.this.char2ShortEntrySet().iterator(new AbstractChar2ShortMap.BasicEntry(from, (short) 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSortedSet, p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharBidirectionalIterator iterator() {
            return new KeySetIterator(Char2ShortSortedMaps.fastIterator(AbstractChar2ShortSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ShortSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ShortSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements CharBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Char2ShortMap.Entry> f1308i;

        public KeySetIterator(ObjectBidirectionalIterator<Char2ShortMap.Entry> i) {
            this.f1308i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return ((Char2ShortMap.Entry) this.f1308i.next()).getCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            return this.f1308i.previous().getCharKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1308i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1308i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ShortMap, p014it.unimi.dsi.fastutil.chars.Char2ShortMap, java.util.Map
    public ShortCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ShortSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ShortSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractShortCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortIterator iterator() {
            return new ValuesIterator(Char2ShortSortedMaps.fastIterator(AbstractChar2ShortSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return AbstractChar2ShortSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractChar2ShortSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractChar2ShortSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ShortSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ShortSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements ShortIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Char2ShortMap.Entry> f1309i;

        public ValuesIterator(ObjectBidirectionalIterator<Char2ShortMap.Entry> i) {
            this.f1309i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return ((Char2ShortMap.Entry) this.f1309i.next()).getShortValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1309i.hasNext();
        }
    }
}
