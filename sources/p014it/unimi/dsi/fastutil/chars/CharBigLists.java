package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.chars.CharCollections;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;

/* renamed from: it.unimi.dsi.fastutil.chars.CharBigLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharBigLists.class */
public final class CharBigLists {
    public static final EmptyBigList EMPTY_BIG_LIST = new EmptyBigList();

    private CharBigLists() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p014it.unimi.dsi.fastutil.chars.CharBigList shuffle(p014it.unimi.dsi.fastutil.chars.CharBigList r7, java.util.Random r8) {
        /*
            r0 = r7
            long r0 = r0.size64()
            r9 = r0
        L_0x0007:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0046
            r0 = r8
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r9
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r11 = r0
            r0 = r7
            r1 = r9
            char r0 = r0.getChar(r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            char r2 = r2.getChar(r3)
            char r0 = r0.set(r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            char r0 = r0.set(r1, r2)
            goto L_0x0007
        L_0x0046:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.CharBigLists.shuffle(it.unimi.dsi.fastutil.chars.CharBigList, java.util.Random):it.unimi.dsi.fastutil.chars.CharBigList");
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharBigLists$EmptyBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharBigLists$EmptyBigList.class */
    public static class EmptyBigList extends CharCollections.EmptyCollection implements CharBigList, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyBigList() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public char getChar(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean rem(char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public char removeChar(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void add(long index, char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public char set(long index, char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public long indexOf(char k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public long lastIndexOf(char k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Character> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.EmptyCollection, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean addAll(CharCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(CharBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(long i, CharCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(long i, CharBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        @Deprecated
        public void add(long index, Character k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public boolean add(Character k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Character get(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        @Deprecated
        public Character set(long index, Character k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Character remove(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object k) {
            return -1;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Character> listIterator() {
            return CharBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.EmptyCollection, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharBigListIterator iterator() {
            return CharBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Character> listIterator(long i) {
            if (i == 0) {
                return CharBigListIterators.EMPTY_BIG_LIST_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.EmptyCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return CharSpliterators.EMPTY_SPLITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Character> subList(long from, long to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void getElements(long from, char[][] a, long offset, long length) {
            BigArrays.ensureOffsetLength(a, offset, length);
            if (from != 0) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void addElements(long index, char[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void addElements(long index, char[][] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public void size(long s) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return 0;
        }

        public int compareTo(BigList<? extends Character> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return CharBigLists.EMPTY_BIG_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof BigList) && ((BigList) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return CharBigLists.EMPTY_BIG_LIST;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharBigLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharBigLists$Singleton.class */
    public static class Singleton extends AbstractCharBigList implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final char element;

        protected Singleton(char element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public char getChar(long i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean rem(char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList
        public char removeChar(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList
        public long indexOf(char k) {
            return k == this.element ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public char[] toCharArray() {
            return new char[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Character> listIterator() {
            return CharBigListIterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.chars.CharBigListIterator, it.unimi.dsi.fastutil.BigListIterator<java.lang.Character>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p014it.unimi.dsi.fastutil.BigListIterator<java.lang.Character> listIterator(long r6) {
            /*
                r5 = this;
                r0 = r6
                r1 = 1
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L_0x000c
                r0 = r6
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0014
            L_0x000c:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                r1 = r0
                r1.<init>()
                throw r0
            L_0x0014:
                r0 = r5
                it.unimi.dsi.fastutil.chars.CharBigListIterator r0 = r0.listIterator()
                r8 = r0
                r0 = r6
                r1 = 1
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0026
                r0 = r8
                char r0 = r0.nextChar()
            L_0x0026:
                r0 = r8
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.CharBigLists.Singleton.listIterator(long):it.unimi.dsi.fastutil.chars.CharBigListIterator");
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return CharSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Character> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : CharBigLists.EMPTY_BIG_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Character> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Character> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(CharBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(long i, CharBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(long i, CharCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean addAll(CharCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean removeAll(CharCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean retainAll(CharCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return 1;
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static CharBigList singleton(char element) {
        return new Singleton(element);
    }

    public static CharBigList singleton(Object element) {
        return new Singleton(((Character) element).charValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharBigLists$SynchronizedBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharBigLists$SynchronizedBigList.class */
    public static class SynchronizedBigList extends CharCollections.SynchronizedCollection implements CharBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final CharBigList list;

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean removeIf(CharPredicate charPredicate) {
            return removeIf(charPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Character> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public /* bridge */ /* synthetic */ void forEach(CharConsumer charConsumer) {
            forEach(charConsumer);
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Character> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Character> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
        public /* bridge */ /* synthetic */ CharSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ IntStream intParallelStream() {
            return intParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ IntStream intStream() {
            return intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public /* bridge */ /* synthetic */ IntSpliterator intSpliterator() {
            return intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public /* bridge */ /* synthetic */ IntIterator intIterator() {
            return intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Character ch) {
            return add(ch);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean retainAll(CharCollection charCollection) {
            return retainAll(charCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean removeAll(CharCollection charCollection) {
            return removeAll(charCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean containsAll(CharCollection charCollection) {
            return containsAll(charCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean addAll(CharCollection charCollection) {
            return addAll(charCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ char[] toArray(char[] cArr) {
            return toArray(cArr);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public /* bridge */ /* synthetic */ char[] toCharArray(char[] cArr) {
            return toCharArray(cArr);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ char[] toCharArray() {
            return toCharArray();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean rem(char c) {
            return rem(c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean contains(char c) {
            return contains(c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean add(char c) {
            return add(c);
        }

        protected SynchronizedBigList(CharBigList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedBigList(CharBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public char getChar(long i) {
            char c;
            synchronized (this.sync) {
                c = this.list.getChar(i);
            }
            return c;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public char set(long i, char k) {
            char c;
            synchronized (this.sync) {
                c = this.list.set(i, k);
            }
            return c;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void add(long i, char k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public char removeChar(long i) {
            char removeChar;
            synchronized (this.sync) {
                removeChar = this.list.removeChar(i);
            }
            return removeChar;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public long indexOf(char k) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public long lastIndexOf(char k) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Character> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void getElements(long from, char[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void removeElements(long from, long to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void addElements(long index, char[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void addElements(long index, char[][] a) {
            synchronized (this.sync) {
                this.list.addElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public void size(long size) {
            synchronized (this.sync) {
                this.list.size(size);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            long size64;
            synchronized (this.sync) {
                size64 = this.list.size64();
            }
            return size64;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.chars.CharBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharBigListIterator iterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Character> listIterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Character> listIterator(long i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.chars.CharBigList] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Character> subList(long from, long to) {
            CharBigList synchronize;
            synchronized (this.sync) {
                synchronize = CharBigLists.synchronize(this.list.subList(from, to), this.sync);
            }
            return synchronize;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.list.equals(o);
            }
            return equals;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.list.hashCode();
            }
            return hashCode;
        }

        public int compareTo(BigList<? extends Character> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(long index, CharCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(long index, CharBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(CharBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        @Deprecated
        public void add(long i, Character k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Character get(long i) {
            Character ch;
            synchronized (this.sync) {
                ch = this.list.get(i);
            }
            return ch;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        @Deprecated
        public Character set(long index, Character k) {
            Character ch;
            synchronized (this.sync) {
                ch = this.list.set(index, k);
            }
            return ch;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Character remove(long i) {
            Character remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }
    }

    public static CharBigList synchronize(CharBigList l) {
        return new SynchronizedBigList(l);
    }

    public static CharBigList synchronize(CharBigList l, Object sync) {
        return new SynchronizedBigList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharBigLists$UnmodifiableBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharBigLists$UnmodifiableBigList.class */
    public static class UnmodifiableBigList extends CharCollections.UnmodifiableCollection implements CharBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final CharBigList list;

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ IntStream intParallelStream() {
            return intParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ IntStream intStream() {
            return intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public /* bridge */ /* synthetic */ IntSpliterator intSpliterator() {
            return intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public /* bridge */ /* synthetic */ IntIterator intIterator() {
            return intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean retainAll(CharCollection charCollection) {
            return retainAll(charCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean removeAll(CharCollection charCollection) {
            return removeAll(charCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean addAll(CharCollection charCollection) {
            return addAll(charCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean containsAll(CharCollection charCollection) {
            return containsAll(charCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ char[] toArray(char[] cArr) {
            return toArray(cArr);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public /* bridge */ /* synthetic */ char[] toCharArray(char[] cArr) {
            return toCharArray(cArr);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ char[] toCharArray() {
            return toCharArray();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Character ch) {
            return add(ch);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean removeIf(CharPredicate charPredicate) {
            return removeIf(charPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Character> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public /* bridge */ /* synthetic */ void forEach(CharConsumer charConsumer) {
            forEach(charConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Character> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Character> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
        public /* bridge */ /* synthetic */ CharSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean contains(char c) {
            return contains(c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean rem(char c) {
            return rem(c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean add(char c) {
            return add(c);
        }

        protected UnmodifiableBigList(CharBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public char getChar(long i) {
            return this.list.getChar(i);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public char set(long i, char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void add(long i, char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public char removeChar(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public long indexOf(char k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public long lastIndexOf(char k) {
            return this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Character> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void getElements(long from, char[][] a, long offset, long length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void addElements(long index, char[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public void addElements(long index, char[][] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public void size(long size) {
            this.list.size(size);
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return this.list.size64();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.chars.CharBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharBigListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.chars.CharBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Character> listIterator() {
            return CharBigListIterators.unmodifiable(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.chars.CharBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Character> listIterator(long i) {
            return CharBigListIterators.unmodifiable(this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.chars.CharBigList] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Character> subList(long from, long to) {
            return CharBigLists.unmodifiable(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.list.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }

        public int compareTo(BigList<? extends Character> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(long index, CharCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(CharBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(long index, CharBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Character get(long i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        @Deprecated
        public void add(long i, Character k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        @Deprecated
        public Character set(long index, Character k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Character remove(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }
    }

    public static CharBigList unmodifiable(CharBigList l) {
        return new UnmodifiableBigList(l);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharBigLists$ListBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharBigLists$ListBigList.class */
    public static class ListBigList extends AbstractCharBigList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final CharList list;

        protected ListBigList(CharList list) {
            this.list = list;
        }

        private int intIndex(long index) {
            if (index < 2147483647L) {
                return (int) index;
            }
            throw new IndexOutOfBoundsException("This big list is restricted to 32-bit indices");
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return (long) this.list.size();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.BigList
        public void size(long size) {
            this.list.size(intIndex(size));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharBigListIterator iterator() {
            return CharBigListIterators.asBigListIterator(this.list.iterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Character> listIterator() {
            return CharBigListIterators.asBigListIterator(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Character> listIterator(long index) {
            return CharBigListIterators.asBigListIterator(this.list.listIterator(intIndex(index)));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Character> c) {
            return this.list.addAll(intIndex(index), c);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharBigList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.chars.CharList] */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Character> subList(long from, long to) {
            return new ListBigList(this.list.subList(intIndex(from), intIndex(to)));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char key) {
            return this.list.contains(key);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public char[] toCharArray() {
            return this.list.toCharArray();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList
        public void removeElements(long from, long to) {
            this.list.removeElements(intIndex(from), intIndex(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public char[] toCharArray(char[] a) {
            return this.list.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(long index, CharCollection c) {
            return this.list.addAll(intIndex(index), c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean addAll(CharCollection c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(long index, CharBigList c) {
            return this.list.addAll(intIndex(index), (CharCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public boolean addAll(CharBigList c) {
            return this.list.addAll((CharCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean containsAll(CharCollection c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean removeAll(CharCollection c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean retainAll(CharCollection c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList
        public void add(long index, char key) {
            this.list.add(intIndex(index), key);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean add(char key) {
            return this.list.add(key);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
        public char getChar(long index) {
            return this.list.getChar(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList
        public long indexOf(char k) {
            return (long) this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList
        public long lastIndexOf(char k) {
            return (long) this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList
        public char removeChar(long index) {
            return this.list.removeChar(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList
        public char set(long index, char k) {
            return this.list.set(intIndex(index), k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.Stack, java.util.List
        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] a) {
            return (T[]) this.list.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Character> c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.list.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }
    }

    public static CharBigList asBigList(CharList list) {
        return new ListBigList(list);
    }
}
