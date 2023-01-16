package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2CharMap;
import p014it.unimi.dsi.fastutil.chars.Char2CharMap;
import p014it.unimi.dsi.fastutil.chars.Char2CharMaps;
import p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2CharSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2CharSortedMaps.class */
public final class Char2CharSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Char2CharSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Character, ?>> entryComparator(CharComparator comparator) {
        return x, y -> {
            return comparator.compare(((Character) x.getKey()).charValue(), ((Character) y.getKey()).charValue());
        };
    }

    public static ObjectBidirectionalIterator<Char2CharMap.Entry> fastIterator(Char2CharSortedMap map) {
        ObjectSortedSet<Char2CharMap.Entry> entries = map.char2CharEntrySet();
        return entries instanceof Char2CharSortedMap.FastSortedEntrySet ? ((Char2CharSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Char2CharMap.Entry> fastIterable(Char2CharSortedMap map) {
        ObjectSortedSet<Char2CharMap.Entry> entries = map.char2CharEntrySet();
        if (!(entries instanceof Char2CharSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Char2CharSortedMap.FastSortedEntrySet fastSortedEntrySet = (Char2CharSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2CharSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2CharSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Char2CharMaps.EmptyMap implements Char2CharSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2CharMap, p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public ObjectSortedSet<Char2CharMap.Entry> char2CharEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Character>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2CharMap, java.util.Map
        public CharSortedSet keySet() {
            return CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public Char2CharSortedMap subMap(char from, char to) {
            return Char2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public Char2CharSortedMap headMap(char to) {
            return Char2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public Char2CharSortedMap tailMap(char from) {
            return Char2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public char firstCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public char lastCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        @Deprecated
        public Char2CharSortedMap headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        @Deprecated
        public Char2CharSortedMap tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        @Deprecated
        public Char2CharSortedMap subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2CharSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2CharSortedMaps$Singleton.class */
    public static class Singleton extends Char2CharMaps.Singleton implements Char2CharSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final CharComparator comparator;

        protected Singleton(char key, char value, CharComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(char key, char value) {
            this(key, value, null);
        }

        final int compare(char k1, char k2) {
            return this.comparator == null ? Character.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2CharMap, p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public ObjectSortedSet<Char2CharMap.Entry> char2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractChar2CharMap.BasicEntry(this.key, this.value), Char2CharSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Character>> entrySet() {
            return char2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2CharMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.singleton(this.key, this.comparator);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public Char2CharSortedMap subMap(char from, char to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Char2CharSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public Char2CharSortedMap headMap(char to) {
            return compare(this.key, to) < 0 ? this : Char2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public Char2CharSortedMap tailMap(char from) {
            return compare(from, this.key) <= 0 ? this : Char2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public char firstCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public char lastCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        @Deprecated
        public Char2CharSortedMap headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        @Deprecated
        public Char2CharSortedMap tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        @Deprecated
        public Char2CharSortedMap subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    public static Char2CharSortedMap singleton(Character key, Character value) {
        return new Singleton(key.charValue(), value.charValue());
    }

    public static Char2CharSortedMap singleton(Character key, Character value, CharComparator comparator) {
        return new Singleton(key.charValue(), value.charValue(), comparator);
    }

    public static Char2CharSortedMap singleton(char key, char value) {
        return new Singleton(key, value);
    }

    public static Char2CharSortedMap singleton(char key, char value, CharComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2CharSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2CharSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Char2CharMaps.SynchronizedMap implements Char2CharSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2CharSortedMap sortedMap;

        protected SynchronizedSortedMap(Char2CharSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Char2CharSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            Comparator<? super Character> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2CharMap, p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public ObjectSortedSet<Char2CharMap.Entry> char2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.char2CharEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Character>> entrySet() {
            return char2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2CharMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public Char2CharSortedMap subMap(char from, char to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public Char2CharSortedMap headMap(char to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public Char2CharSortedMap tailMap(char from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public char firstCharKey() {
            char firstCharKey;
            synchronized (this.sync) {
                firstCharKey = this.sortedMap.firstCharKey();
            }
            return firstCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public char lastCharKey() {
            char lastCharKey;
            synchronized (this.sync) {
                lastCharKey = this.sortedMap.lastCharKey();
            }
            return lastCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            Character firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            Character lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        @Deprecated
        public Char2CharSortedMap subMap(Character from, Character to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        @Deprecated
        public Char2CharSortedMap headMap(Character to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        @Deprecated
        public Char2CharSortedMap tailMap(Character from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Char2CharSortedMap synchronize(Char2CharSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Char2CharSortedMap synchronize(Char2CharSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2CharSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2CharSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Char2CharMaps.UnmodifiableMap implements Char2CharSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2CharSortedMap sortedMap;

        protected UnmodifiableSortedMap(Char2CharSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2CharMap, p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public ObjectSortedSet<Char2CharMap.Entry> char2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.char2CharEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Character>> entrySet() {
            return char2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2CharMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public Char2CharSortedMap subMap(char from, char to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public Char2CharSortedMap headMap(char to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public Char2CharSortedMap tailMap(char from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public char firstCharKey() {
            return this.sortedMap.firstCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        public char lastCharKey() {
            return this.sortedMap.lastCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        @Deprecated
        public Char2CharSortedMap subMap(Character from, Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        @Deprecated
        public Char2CharSortedMap headMap(Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
        @Deprecated
        public Char2CharSortedMap tailMap(Character from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Char2CharSortedMap unmodifiable(Char2CharSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
