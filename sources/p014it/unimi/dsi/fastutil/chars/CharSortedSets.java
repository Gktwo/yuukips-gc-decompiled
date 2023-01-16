package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.chars.CharSets;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;

/* renamed from: it.unimi.dsi.fastutil.chars.CharSortedSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharSortedSets.class */
public final class CharSortedSets {
    public static final EmptySet EMPTY_SET = new EmptySet();

    private CharSortedSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharSortedSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharSortedSets$EmptySet.class */
    public static class EmptySet extends CharSets.EmptySet implements CharSortedSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharBidirectionalIterator iterator(char from) {
            return CharIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet subSet(char from, char to) {
            return CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet headSet(char from) {
            return CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet tailSet(char to) {
            return CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char firstChar() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char lastChar() {
            throw new NoSuchElementException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        public Comparator<? super Character> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        @Deprecated
        public CharSortedSet subSet(Character from, Character to) {
            return CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        @Deprecated
        public CharSortedSet headSet(Character from) {
            return CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        @Deprecated
        public CharSortedSet tailSet(Character to) {
            return CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        @Deprecated
        public Character first() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        @Deprecated
        public Character last() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSets.EmptySet, java.lang.Object
        public Object clone() {
            return CharSortedSets.EMPTY_SET;
        }

        private Object readResolve() {
            return CharSortedSets.EMPTY_SET;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharSortedSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharSortedSets$Singleton.class */
    public static class Singleton extends CharSets.Singleton implements CharSortedSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        final CharComparator comparator;

        @Override // p014it.unimi.dsi.fastutil.chars.CharSets.Singleton, p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public /* bridge */ /* synthetic */ CharBidirectionalIterator iterator() {
            return iterator();
        }

        protected Singleton(char element, CharComparator comparator) {
            super(element);
            this.comparator = comparator;
        }

        Singleton(char element) {
            this(element, null);
        }

        final int compare(char k1, char k2) {
            return this.comparator == null ? Character.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharBidirectionalIterator iterator(char from) {
            CharBidirectionalIterator i = iterator();
            if (compare(this.element, from) <= 0) {
                i.nextChar();
            }
            return i;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        public Comparator<? super Character> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSets.Singleton, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return CharSpliterators.singleton(this.element, this.comparator);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet subSet(char from, char to) {
            return (compare(from, this.element) > 0 || compare(this.element, to) >= 0) ? CharSortedSets.EMPTY_SET : this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet headSet(char to) {
            return compare(this.element, to) < 0 ? this : CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet tailSet(char from) {
            return compare(from, this.element) <= 0 ? this : CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char firstChar() {
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char lastChar() {
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSets.Singleton, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public IntSpliterator intSpliterator() {
            return IntSpliterators.singleton(this.element, left, right -> {
                return comparator().compare(SafeMath.safeIntToChar(left), SafeMath.safeIntToChar(right));
            });
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        @Deprecated
        public CharSortedSet subSet(Character from, Character to) {
            return subSet(from.charValue(), to.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        @Deprecated
        public CharSortedSet headSet(Character to) {
            return headSet(to.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        @Deprecated
        public CharSortedSet tailSet(Character from) {
            return tailSet(from.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        @Deprecated
        public Character first() {
            return Character.valueOf(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        @Deprecated
        public Character last() {
            return Character.valueOf(this.element);
        }
    }

    public static CharSortedSet singleton(char element) {
        return new Singleton(element);
    }

    public static CharSortedSet singleton(char element, CharComparator comparator) {
        return new Singleton(element, comparator);
    }

    public static CharSortedSet singleton(Object element) {
        return new Singleton(((Character) element).charValue());
    }

    public static CharSortedSet singleton(Object element, CharComparator comparator) {
        return new Singleton(((Character) element).charValue(), comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharSortedSets$SynchronizedSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharSortedSets$SynchronizedSortedSet.class */
    public static class SynchronizedSortedSet extends CharSets.SynchronizedSet implements CharSortedSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final CharSortedSet sortedSet;

        protected SynchronizedSortedSet(CharSortedSet s, Object sync) {
            super(s, sync);
            this.sortedSet = s;
        }

        protected SynchronizedSortedSet(CharSortedSet s) {
            super(s);
            this.sortedSet = s;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        public Comparator<? super Character> comparator() {
            Comparator<? super Character> comparator;
            synchronized (this.sync) {
                comparator = this.sortedSet.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet subSet(char from, char to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet headSet(char to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet tailSet(char from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSets.SynchronizedSet, p014it.unimi.dsi.fastutil.chars.CharCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharBidirectionalIterator iterator() {
            return this.sortedSet.iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharBidirectionalIterator iterator(char from) {
            return this.sortedSet.iterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char firstChar() {
            char firstChar;
            synchronized (this.sync) {
                firstChar = this.sortedSet.firstChar();
            }
            return firstChar;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char lastChar() {
            char lastChar;
            synchronized (this.sync) {
                lastChar = this.sortedSet.lastChar();
            }
            return lastChar;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        @Deprecated
        public Character first() {
            Character first;
            synchronized (this.sync) {
                first = this.sortedSet.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        @Deprecated
        public Character last() {
            Character last;
            synchronized (this.sync) {
                last = this.sortedSet.last();
            }
            return last;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        @Deprecated
        public CharSortedSet subSet(Character from, Character to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        @Deprecated
        public CharSortedSet headSet(Character to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        @Deprecated
        public CharSortedSet tailSet(Character from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet(from), this.sync);
        }
    }

    public static CharSortedSet synchronize(CharSortedSet s) {
        return new SynchronizedSortedSet(s);
    }

    public static CharSortedSet synchronize(CharSortedSet s, Object sync) {
        return new SynchronizedSortedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharSortedSets$UnmodifiableSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharSortedSets$UnmodifiableSortedSet.class */
    public static class UnmodifiableSortedSet extends CharSets.UnmodifiableSet implements CharSortedSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final CharSortedSet sortedSet;

        protected UnmodifiableSortedSet(CharSortedSet s) {
            super(s);
            this.sortedSet = s;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        public Comparator<? super Character> comparator() {
            return this.sortedSet.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet subSet(char from, char to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet headSet(char to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet tailSet(char from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet(from));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSets.UnmodifiableSet, p014it.unimi.dsi.fastutil.chars.CharCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharBidirectionalIterator iterator() {
            return CharIterators.unmodifiable(this.sortedSet.iterator());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharBidirectionalIterator iterator(char from) {
            return CharIterators.unmodifiable(this.sortedSet.iterator(from));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char firstChar() {
            return this.sortedSet.firstChar();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char lastChar() {
            return this.sortedSet.lastChar();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        @Deprecated
        public Character first() {
            return this.sortedSet.first();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        @Deprecated
        public Character last() {
            return this.sortedSet.last();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        @Deprecated
        public CharSortedSet subSet(Character from, Character to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        @Deprecated
        public CharSortedSet headSet(Character to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        @Deprecated
        public CharSortedSet tailSet(Character from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet(from));
        }
    }

    public static CharSortedSet unmodifiable(CharSortedSet s) {
        return new UnmodifiableSortedSet(s);
    }
}
