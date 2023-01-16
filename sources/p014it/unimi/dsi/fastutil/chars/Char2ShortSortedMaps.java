package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2ShortMap;
import p014it.unimi.dsi.fastutil.chars.Char2ShortMap;
import p014it.unimi.dsi.fastutil.chars.Char2ShortMaps;
import p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2ShortSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ShortSortedMaps.class */
public final class Char2ShortSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Char2ShortSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Character, ?>> entryComparator(CharComparator comparator) {
        return x, y -> {
            return comparator.compare(((Character) x.getKey()).charValue(), ((Character) y.getKey()).charValue());
        };
    }

    public static ObjectBidirectionalIterator<Char2ShortMap.Entry> fastIterator(Char2ShortSortedMap map) {
        ObjectSortedSet<Char2ShortMap.Entry> entries = map.char2ShortEntrySet();
        return entries instanceof Char2ShortSortedMap.FastSortedEntrySet ? ((Char2ShortSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Char2ShortMap.Entry> fastIterable(Char2ShortSortedMap map) {
        ObjectSortedSet<Char2ShortMap.Entry> entries = map.char2ShortEntrySet();
        if (!(entries instanceof Char2ShortSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Char2ShortSortedMap.FastSortedEntrySet fastSortedEntrySet = (Char2ShortSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ShortSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ShortSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Char2ShortMaps.EmptyMap implements Char2ShortSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2ShortMap, p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public ObjectSortedSet<Char2ShortMap.Entry> char2ShortEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Short>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2ShortMap, java.util.Map
        public CharSortedSet keySet() {
            return CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public Char2ShortSortedMap subMap(char from, char to) {
            return Char2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public Char2ShortSortedMap headMap(char to) {
            return Char2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public Char2ShortSortedMap tailMap(char from) {
            return Char2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public char firstCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public char lastCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        @Deprecated
        public Char2ShortSortedMap headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        @Deprecated
        public Char2ShortSortedMap tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        @Deprecated
        public Char2ShortSortedMap subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ShortSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ShortSortedMaps$Singleton.class */
    public static class Singleton extends Char2ShortMaps.Singleton implements Char2ShortSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final CharComparator comparator;

        protected Singleton(char key, short value, CharComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(char key, short value) {
            this(key, value, null);
        }

        final int compare(char k1, char k2) {
            return this.comparator == null ? Character.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2ShortMap, p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public ObjectSortedSet<Char2ShortMap.Entry> char2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractChar2ShortMap.BasicEntry(this.key, this.value), Char2ShortSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Short>> entrySet() {
            return char2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2ShortMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.singleton(this.key, this.comparator);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public Char2ShortSortedMap subMap(char from, char to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Char2ShortSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public Char2ShortSortedMap headMap(char to) {
            return compare(this.key, to) < 0 ? this : Char2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public Char2ShortSortedMap tailMap(char from) {
            return compare(from, this.key) <= 0 ? this : Char2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public char firstCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public char lastCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        @Deprecated
        public Char2ShortSortedMap headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        @Deprecated
        public Char2ShortSortedMap tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        @Deprecated
        public Char2ShortSortedMap subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    public static Char2ShortSortedMap singleton(Character key, Short value) {
        return new Singleton(key.charValue(), value.shortValue());
    }

    public static Char2ShortSortedMap singleton(Character key, Short value, CharComparator comparator) {
        return new Singleton(key.charValue(), value.shortValue(), comparator);
    }

    public static Char2ShortSortedMap singleton(char key, short value) {
        return new Singleton(key, value);
    }

    public static Char2ShortSortedMap singleton(char key, short value, CharComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ShortSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ShortSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Char2ShortMaps.SynchronizedMap implements Char2ShortSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2ShortSortedMap sortedMap;

        protected SynchronizedSortedMap(Char2ShortSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Char2ShortSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            Comparator<? super Character> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2ShortMap, p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public ObjectSortedSet<Char2ShortMap.Entry> char2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.char2ShortEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Short>> entrySet() {
            return char2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2ShortMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public Char2ShortSortedMap subMap(char from, char to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public Char2ShortSortedMap headMap(char to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public Char2ShortSortedMap tailMap(char from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public char firstCharKey() {
            char firstCharKey;
            synchronized (this.sync) {
                firstCharKey = this.sortedMap.firstCharKey();
            }
            return firstCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public char lastCharKey() {
            char lastCharKey;
            synchronized (this.sync) {
                lastCharKey = this.sortedMap.lastCharKey();
            }
            return lastCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            Character firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            Character lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        @Deprecated
        public Char2ShortSortedMap subMap(Character from, Character to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        @Deprecated
        public Char2ShortSortedMap headMap(Character to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        @Deprecated
        public Char2ShortSortedMap tailMap(Character from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Char2ShortSortedMap synchronize(Char2ShortSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Char2ShortSortedMap synchronize(Char2ShortSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ShortSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ShortSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Char2ShortMaps.UnmodifiableMap implements Char2ShortSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2ShortSortedMap sortedMap;

        protected UnmodifiableSortedMap(Char2ShortSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2ShortMap, p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public ObjectSortedSet<Char2ShortMap.Entry> char2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.char2ShortEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Short>> entrySet() {
            return char2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2ShortMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public Char2ShortSortedMap subMap(char from, char to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public Char2ShortSortedMap headMap(char to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public Char2ShortSortedMap tailMap(char from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public char firstCharKey() {
            return this.sortedMap.firstCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        public char lastCharKey() {
            return this.sortedMap.lastCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        @Deprecated
        public Char2ShortSortedMap subMap(Character from, Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        @Deprecated
        public Char2ShortSortedMap headMap(Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortSortedMap
        @Deprecated
        public Char2ShortSortedMap tailMap(Character from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Char2ShortSortedMap unmodifiable(Char2ShortSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
