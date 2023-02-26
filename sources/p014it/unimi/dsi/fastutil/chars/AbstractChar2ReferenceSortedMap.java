package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ReferenceSortedMap.class */
public abstract class AbstractChar2ReferenceSortedMap<V> extends AbstractChar2ReferenceMap<V> implements Char2ReferenceSortedMap<V> {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
    public CharSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ReferenceSortedMap$KeySet.class */
    public class KeySet extends AbstractCharSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return AbstractChar2ReferenceSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractChar2ReferenceSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractChar2ReferenceSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        public Comparator<? super Character> comparator() {
            return AbstractChar2ReferenceSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char firstChar() {
            return AbstractChar2ReferenceSortedMap.this.firstCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char lastChar() {
            return AbstractChar2ReferenceSortedMap.this.lastCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet headSet(char to) {
            return AbstractChar2ReferenceSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet tailSet(char from) {
            return AbstractChar2ReferenceSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet subSet(char from, char to) {
            return AbstractChar2ReferenceSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharBidirectionalIterator iterator(char from) {
            return new KeySetIterator(AbstractChar2ReferenceSortedMap.this.char2ReferenceEntrySet().iterator(new AbstractChar2ReferenceMap.BasicEntry(from, (Object) null)));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSortedSet, p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharBidirectionalIterator iterator() {
            return new KeySetIterator(Char2ReferenceSortedMaps.fastIterator(AbstractChar2ReferenceSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ReferenceSortedMap$KeySetIterator.class */
    public static class KeySetIterator<V> implements CharBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Char2ReferenceMap.Entry<V>> f1304i;

        public KeySetIterator(ObjectBidirectionalIterator<Char2ReferenceMap.Entry<V>> i) {
            this.f1304i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return ((Char2ReferenceMap.Entry) this.f1304i.next()).getCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            return this.f1304i.previous().getCharKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1304i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1304i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ReferenceSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractReferenceCollection<V> {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectIterator<V> iterator() {
            return new ValuesIterator(Char2ReferenceSortedMaps.fastIterator(AbstractChar2ReferenceSortedMap.this));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object k) {
            return AbstractChar2ReferenceSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractChar2ReferenceSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractChar2ReferenceSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ReferenceSortedMap$ValuesIterator.class */
    public static class ValuesIterator<V> implements ObjectIterator<V> {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Char2ReferenceMap.Entry<V>> f1305i;

        public ValuesIterator(ObjectBidirectionalIterator<Char2ReferenceMap.Entry<V>> i) {
            this.f1305i = i;
        }

        @Override // java.util.Iterator
        public V next() {
            return ((Char2ReferenceMap.Entry) this.f1305i.next()).getValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1305i.hasNext();
        }
    }
}
