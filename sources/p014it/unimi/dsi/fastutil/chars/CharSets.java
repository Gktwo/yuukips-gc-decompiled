package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import okhttp3.internal.p021ws.WebSocketProtocol;
import p014it.unimi.dsi.fastutil.chars.CharCollections;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterators;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;

/* renamed from: it.unimi.dsi.fastutil.chars.CharSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharSets.class */
public final class CharSets {
    static final int ARRAY_SET_CUTOFF = 4;
    public static final EmptySet EMPTY_SET = new EmptySet();
    static final CharSet UNMODIFIABLE_EMPTY_SET = unmodifiable(new CharArraySet(CharArrays.EMPTY_ARRAY));

    private CharSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharSets$EmptySet.class */
    public static class EmptySet extends CharCollections.EmptyCollection implements CharSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.chars.CharSet
        public boolean remove(char ok) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return CharSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof Set) && ((Set) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public boolean rem(char k) {
            return rem(k);
        }

        private Object readResolve() {
            return CharSets.EMPTY_SET;
        }
    }

    public static CharSet emptySet() {
        return EMPTY_SET;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharSets$Singleton.class */
    public static class Singleton extends AbstractCharSet implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final char element;

        /* access modifiers changed from: protected */
        public Singleton(char element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.CharSet
        public boolean remove(char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharListIterator iterator() {
            return CharIterators.singleton(this.element);
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return CharSpliterators.singleton(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public char[] toCharArray() {
            return new char[]{this.element};
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
        @Deprecated
        public void forEach(Consumer<? super Character> action) {
            action.accept(Character.valueOf(this.element));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection
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

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
        public void forEach(CharConsumer action) {
            action.accept(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
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

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Character.valueOf(this.element)};
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static CharSet singleton(char element) {
        return new Singleton(element);
    }

    public static CharSet singleton(Character element) {
        return new Singleton(element.charValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharSets$SynchronizedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharSets$SynchronizedSet.class */
    public static class SynchronizedSet extends CharCollections.SynchronizedCollection implements CharSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ boolean equals(Object obj) {
            return equals(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ int hashCode() {
            return hashCode();
        }

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

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public /* bridge */ /* synthetic */ void forEach(CharConsumer charConsumer) {
            forEach(charConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
        public /* bridge */ /* synthetic */ CharSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
        public /* bridge */ /* synthetic */ CharIterator iterator() {
            return iterator();
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
        public /* bridge */ /* synthetic */ boolean contains(char c) {
            return contains(c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public /* bridge */ /* synthetic */ boolean add(char c) {
            return add(c);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(CharSet s, Object sync) {
            super(s, sync);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(CharSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSet
        public boolean remove(char k) {
            boolean rem;
            synchronized (this.sync) {
                rem = this.collection.rem(k);
            }
            return rem;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public boolean rem(char k) {
            return rem(k);
        }
    }

    public static CharSet synchronize(CharSet s) {
        return new SynchronizedSet(s);
    }

    public static CharSet synchronize(CharSet s, Object sync) {
        return new SynchronizedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharSets$UnmodifiableSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharSets$UnmodifiableSet.class */
    public static class UnmodifiableSet extends CharCollections.UnmodifiableCollection implements CharSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

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

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
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

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
        public /* bridge */ /* synthetic */ CharSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
        public /* bridge */ /* synthetic */ CharIterator iterator() {
            return iterator();
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
        public /* bridge */ /* synthetic */ boolean add(char c) {
            return add(c);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableSet(CharSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSet
        public boolean remove(char k) {
            throw new UnsupportedOperationException();
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

        @Override // p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        @Deprecated
        public boolean rem(char k) {
            return rem(k);
        }
    }

    public static CharSet unmodifiable(CharSet s) {
        return new UnmodifiableSet(s);
    }

    public static CharSet fromTo(final char from, final char to) {
        return new AbstractCharSet() { // from class: it.unimi.dsi.fastutil.chars.CharSets.1
            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
            public boolean contains(char x) {
                return x >= from && x < to;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharIterator iterator() {
                return CharIterators.fromTo(from, to);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                long size = ((long) to) - ((long) from);
                if (size < 0 || size > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) size;
            }
        };
    }

    public static CharSet from(final char from) {
        return new AbstractCharSet() { // from class: it.unimi.dsi.fastutil.chars.CharSets.2
            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
            public boolean contains(char x) {
                return x >= from;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharIterator iterator() {
                return CharIterators.concat(CharIterators.fromTo(from, 65535), CharSets.singleton((char) 65535).iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                long size = (WebSocketProtocol.PAYLOAD_SHORT_MAX - ((long) from)) + 1;
                if (size < 0 || size > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) size;
            }
        };
    }

    /* renamed from: to */
    public static CharSet m948to(final char to) {
        return new AbstractCharSet() { // from class: it.unimi.dsi.fastutil.chars.CharSets.3
            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
            public boolean contains(char x) {
                return x < to;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharIterator iterator() {
                return CharIterators.fromTo(0, to);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                long size = ((long) to) - 0;
                if (size < 0 || size > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) size;
            }
        };
    }
}
