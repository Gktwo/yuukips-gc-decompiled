package p014it.unimi.dsi.fastutil.chars;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.chars.CharCollections;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterators;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;

/* renamed from: it.unimi.dsi.fastutil.chars.CharLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharLists.class */
public final class CharLists {
    public static final EmptyList EMPTY_LIST = new EmptyList();

    private CharLists() {
    }

    public static CharList shuffle(CharList l, Random random) {
        int i = l.size();
        while (true) {
            i--;
            if (i == 0) {
                return l;
            }
            int p = random.nextInt(i + 1);
            char t = l.getChar(i);
            l.set(i, l.getChar(p));
            l.set(p, t);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharLists$EmptyList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharLists$EmptyList.class */
    public static class EmptyList extends CharCollections.EmptyCollection implements CharList, RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyList() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public char getChar(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean rem(char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public char removeChar(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void add(int index, char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public char set(int index, char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public int indexOf(char k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public int lastIndexOf(char k) {
            return -1;
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends Character> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Character> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void replaceAll(CharUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public boolean addAll(CharList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public boolean addAll(int i, CharCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public boolean addAll(int i, CharList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public void add(int index, Character k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public Character get(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public boolean add(Character k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public Character set(int index, Character k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public Character remove(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public int indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public int lastIndexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void sort(CharComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void unstableSort(CharComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Character> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public void unstableSort(Comparator<? super Character> comparator) {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public ListIterator<Character> listIterator() {
            return CharIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.EmptyCollection, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharListIterator iterator() {
            return CharIterators.EMPTY_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public ListIterator<Character> listIterator(int i) {
            if (i == 0) {
                return CharIterators.EMPTY_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public List<Character> subList(int from, int to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void getElements(int from, char[] a, int offset, int length) {
            if (from != 0 || length != 0 || offset < 0 || offset > a.length) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void addElements(int index, char[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void addElements(int index, char[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void setElements(char[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void setElements(int index, char[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void setElements(int index, char[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void size(int s) {
            throw new UnsupportedOperationException();
        }

        public int compareTo(List<? extends Character> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return CharLists.EMPTY_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof List) && ((List) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return CharLists.EMPTY_LIST;
        }
    }

    public static CharList emptyList() {
        return EMPTY_LIST;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharLists$Singleton.class */
    public static class Singleton extends AbstractCharList implements RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final char element;

        protected Singleton(char element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public char getChar(int i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean rem(char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public char removeChar(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public int indexOf(char k) {
            return k == this.element ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public char[] toCharArray() {
            return new char[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public ListIterator<Character> listIterator() {
            return CharIterators.singleton(this.element);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharListIterator iterator() {
            return listIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return CharSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ListIterator<java.lang.Character>, it.unimi.dsi.fastutil.chars.CharListIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.ListIterator<java.lang.Character> listIterator(int r4) {
            /*
                r3 = this;
                r0 = r4
                r1 = 1
                if (r0 > r1) goto L_0x0009
                r0 = r4
                if (r0 >= 0) goto L_0x0011
            L_0x0009:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                r1 = r0
                r1.<init>()
                throw r0
            L_0x0011:
                r0 = r3
                it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator()
                r5 = r0
                r0 = r4
                r1 = 1
                if (r0 != r1) goto L_0x0022
                r0 = r5
                char r0 = r0.nextChar()
            L_0x0022:
                r0 = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.CharLists.Singleton.listIterator(int):it.unimi.dsi.fastutil.chars.CharListIterator");
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public List<Character> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : CharLists.EMPTY_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
        @Deprecated
        public void forEach(Consumer<? super Character> action) {
            action.accept(Character.valueOf(this.element));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, java.util.List
        public boolean addAll(int i, Collection<? extends Character> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection
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

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public boolean removeIf(Predicate<? super Character> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Character> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void replaceAll(CharUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharIterable
        public void forEach(CharConsumer action) {
            action.accept(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public boolean addAll(CharList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public boolean addAll(int i, CharList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public boolean addAll(int i, CharCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
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

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean removeIf(CharPredicate filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public IntIterator intIterator() {
            return IntIterators.singleton(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public IntSpliterator intSpliterator() {
            return IntSpliterators.singleton(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Character.valueOf(this.element)};
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void sort(CharComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void unstableSort(CharComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Character> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public void unstableSort(Comparator<? super Character> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public void getElements(int from, char[] a, int offset, int length) {
            if (offset < 0) {
                throw new ArrayIndexOutOfBoundsException("Offset (" + offset + ") is negative");
            } else if (offset + length > a.length) {
                throw new ArrayIndexOutOfBoundsException("End index (" + (offset + length) + ") is greater than array length (" + a.length + ")");
            } else if (from + length > size()) {
                throw new IndexOutOfBoundsException("End index (" + (from + length) + ") is greater than list size (" + size() + ")");
            } else if (length > 0) {
                a[offset] = this.element;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public void addElements(int index, char[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public void addElements(int index, char[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void setElements(char[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void setElements(int index, char[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public void setElements(int index, char[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static CharList singleton(char element) {
        return new Singleton(element);
    }

    public static CharList singleton(Object element) {
        return new Singleton(((Character) element).charValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharLists$SynchronizedList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharLists$SynchronizedList.class */
    public static class SynchronizedList extends CharCollections.SynchronizedCollection implements CharList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final CharList list;

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
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

        protected SynchronizedList(CharList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedList(CharList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public char getChar(int i) {
            char c;
            synchronized (this.sync) {
                c = this.list.getChar(i);
            }
            return c;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public char set(int i, char k) {
            char c;
            synchronized (this.sync) {
                c = this.list.set(i, k);
            }
            return c;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void add(int i, char k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public char removeChar(int i) {
            char removeChar;
            synchronized (this.sync) {
                removeChar = this.list.removeChar(i);
            }
            return removeChar;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public int indexOf(char k) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public int lastIndexOf(char k) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean removeIf(CharPredicate filter) {
            boolean removeIf;
            synchronized (this.sync) {
                removeIf = this.list.removeIf(filter);
            }
            return removeIf;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void replaceAll(CharUnaryOperator operator) {
            synchronized (this.sync) {
                this.list.replaceAll(operator);
            }
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Character> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void getElements(int from, char[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void removeElements(int from, int to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void addElements(int index, char[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void addElements(int index, char[] a) {
            synchronized (this.sync) {
                this.list.addElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void setElements(char[] a) {
            synchronized (this.sync) {
                this.list.setElements(a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void setElements(int index, char[] a) {
            synchronized (this.sync) {
                this.list.setElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void setElements(int index, char[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.setElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void size(int size) {
            synchronized (this.sync) {
                this.list.size(size);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public ListIterator<Character> listIterator() {
            return this.list.listIterator();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public ListIterator<Character> listIterator(int i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.chars.CharList] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public List<Character> subList(int from, int to) {
            SynchronizedList synchronizedList;
            synchronized (this.sync) {
                synchronizedList = new SynchronizedList(this.list.subList(from, to), this.sync);
            }
            return synchronizedList;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.collection.equals(o);
            }
            return equals;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.collection.hashCode();
            }
            return hashCode;
        }

        public int compareTo(List<? extends Character> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public boolean addAll(int index, CharCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public boolean addAll(int index, CharList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public boolean addAll(CharList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public Character get(int i) {
            Character ch;
            synchronized (this.sync) {
                ch = this.list.get(i);
            }
            return ch;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public void add(int i, Character k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public Character set(int index, Character k) {
            Character ch;
            synchronized (this.sync) {
                ch = this.list.set(index, k);
            }
            return ch;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public Character remove(int i) {
            Character remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void sort(CharComparator comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void unstableSort(CharComparator comparator) {
            synchronized (this.sync) {
                this.list.unstableSort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Character> comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public void unstableSort(Comparator<? super Character> comparator) {
            synchronized (this.sync) {
                this.list.unstableSort(comparator);
            }
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharLists$SynchronizedRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharLists$SynchronizedRandomAccessList.class */
    public static class SynchronizedRandomAccessList extends SynchronizedList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected SynchronizedRandomAccessList(CharList l, Object sync) {
            super(l, sync);
        }

        protected SynchronizedRandomAccessList(CharList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.chars.CharList] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharLists.SynchronizedList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public List<Character> subList(int from, int to) {
            SynchronizedRandomAccessList synchronizedRandomAccessList;
            synchronized (this.sync) {
                synchronizedRandomAccessList = new SynchronizedRandomAccessList(this.list.subList(from, to), this.sync);
            }
            return synchronizedRandomAccessList;
        }
    }

    public static CharList synchronize(CharList l) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l) : new SynchronizedList(l);
    }

    public static CharList synchronize(CharList l, Object sync) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l, sync) : new SynchronizedList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharLists$UnmodifiableList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharLists$UnmodifiableList.class */
    public static class UnmodifiableList extends CharCollections.UnmodifiableCollection implements CharList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final CharList list;

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

        protected UnmodifiableList(CharList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public char getChar(int i) {
            return this.list.getChar(i);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public char set(int i, char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void add(int i, char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public char removeChar(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public int indexOf(char k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public int lastIndexOf(char k) {
            return this.list.lastIndexOf(k);
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Character> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Character> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void getElements(int from, char[] a, int offset, int length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void addElements(int index, char[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void addElements(int index, char[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void setElements(char[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void setElements(int index, char[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void setElements(int index, char[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void size(int size) {
            this.list.size(size);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public ListIterator<Character> listIterator() {
            return CharIterators.unmodifiable((CharListIterator) this.list.listIterator());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public ListIterator<Character> listIterator(int i) {
            return CharIterators.unmodifiable((CharListIterator) this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.chars.CharList] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public List<Character> subList(int from, int to) {
            return new UnmodifiableList(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        public int compareTo(List<? extends Character> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public boolean addAll(int index, CharCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public boolean addAll(CharList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public boolean addAll(int index, CharList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void replaceAll(IntUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public Character get(int i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public void add(int i, Character k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public Character set(int index, Character k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public Character remove(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void sort(CharComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public void unstableSort(CharComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Character> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public void unstableSort(Comparator<? super Character> comparator) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharLists$UnmodifiableRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharLists$UnmodifiableRandomAccessList.class */
    public static class UnmodifiableRandomAccessList extends UnmodifiableList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected UnmodifiableRandomAccessList(CharList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.chars.CharList] */
        @Override // p014it.unimi.dsi.fastutil.chars.CharLists.UnmodifiableList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public List<Character> subList(int from, int to) {
            return new UnmodifiableRandomAccessList(this.list.subList(from, to));
        }
    }

    public static CharList unmodifiable(CharList l) {
        return l instanceof RandomAccess ? new UnmodifiableRandomAccessList(l) : new UnmodifiableList(l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.chars.CharLists$ImmutableListBase */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharLists$ImmutableListBase.class */
    public static abstract class ImmutableListBase extends AbstractCharList implements CharList {
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final void add(int index, char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public final boolean add(char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean addAll(Collection<? extends Character> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, java.util.List
        @Deprecated
        public final boolean addAll(int index, Collection<? extends Character> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final char removeChar(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public final boolean rem(char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public final boolean removeIf(Predicate<? super Character> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public final boolean removeIf(CharPredicate c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public final void replaceAll(UnaryOperator<Character> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final void replaceAll(IntUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final void add(int index, Character k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public final boolean add(Character k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public final Character remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public final boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final Character set(int index, Character k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public final boolean addAll(CharCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final boolean addAll(CharList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final boolean addAll(int index, CharCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final boolean addAll(int index, CharList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public final boolean removeAll(CharCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public final boolean retainAll(CharCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final char set(int index, char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final void addElements(int index, char[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final void setElements(int index, char[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final void sort(CharComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final void unstableSort(CharComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        @Deprecated
        public final void sort(Comparator<? super Character> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        @Deprecated
        public final void unstableSort(Comparator<? super Character> comparator) {
            throw new UnsupportedOperationException();
        }
    }
}
