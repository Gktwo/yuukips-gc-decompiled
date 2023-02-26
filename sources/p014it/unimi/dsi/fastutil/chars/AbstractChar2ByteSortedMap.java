package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap;
import p014it.unimi.dsi.fastutil.chars.Char2ByteMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ByteSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ByteSortedMap.class */
public abstract class AbstractChar2ByteSortedMap extends AbstractChar2ByteMap implements Char2ByteSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
    public CharSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ByteSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ByteSortedMap$KeySet.class */
    public class KeySet extends AbstractCharSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return AbstractChar2ByteSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractChar2ByteSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractChar2ByteSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        public Comparator<? super Character> comparator() {
            return AbstractChar2ByteSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char firstChar() {
            return AbstractChar2ByteSortedMap.this.firstCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char lastChar() {
            return AbstractChar2ByteSortedMap.this.lastCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet headSet(char to) {
            return AbstractChar2ByteSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet tailSet(char from) {
            return AbstractChar2ByteSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet subSet(char from, char to) {
            return AbstractChar2ByteSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharBidirectionalIterator iterator(char from) {
            return new KeySetIterator(AbstractChar2ByteSortedMap.this.char2ByteEntrySet().iterator(new AbstractChar2ByteMap.BasicEntry(from, (byte) 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSortedSet, p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharBidirectionalIterator iterator() {
            return new KeySetIterator(Char2ByteSortedMaps.fastIterator(AbstractChar2ByteSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ByteSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ByteSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements CharBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Char2ByteMap.Entry> f1276i;

        public KeySetIterator(ObjectBidirectionalIterator<Char2ByteMap.Entry> i) {
            this.f1276i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return ((Char2ByteMap.Entry) this.f1276i.next()).getCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            return this.f1276i.previous().getCharKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1276i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1276i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
    public ByteCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ByteSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ByteSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractByteCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteIterator iterator() {
            return new ValuesIterator(Char2ByteSortedMaps.fastIterator(AbstractChar2ByteSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return AbstractChar2ByteSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractChar2ByteSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractChar2ByteSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ByteSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ByteSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements ByteIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Char2ByteMap.Entry> f1277i;

        public ValuesIterator(ObjectBidirectionalIterator<Char2ByteMap.Entry> i) {
            this.f1277i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return ((Char2ByteMap.Entry) this.f1277i.next()).getByteValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1277i.hasNext();
        }
    }
}
