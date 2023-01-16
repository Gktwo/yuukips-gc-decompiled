package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap;
import p014it.unimi.dsi.fastutil.chars.Char2ByteMap;
import p014it.unimi.dsi.fastutil.chars.Char2ByteMaps;
import p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteSortedMaps.class */
public final class Char2ByteSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Char2ByteSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Character, ?>> entryComparator(CharComparator comparator) {
        return x, y -> {
            return comparator.compare(((Character) x.getKey()).charValue(), ((Character) y.getKey()).charValue());
        };
    }

    public static ObjectBidirectionalIterator<Char2ByteMap.Entry> fastIterator(Char2ByteSortedMap map) {
        ObjectSortedSet<Char2ByteMap.Entry> entries = map.char2ByteEntrySet();
        return entries instanceof Char2ByteSortedMap.FastSortedEntrySet ? ((Char2ByteSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Char2ByteMap.Entry> fastIterable(Char2ByteSortedMap map) {
        ObjectSortedSet<Char2ByteMap.Entry> entries = map.char2ByteEntrySet();
        if (!(entries instanceof Char2ByteSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Char2ByteSortedMap.FastSortedEntrySet fastSortedEntrySet = (Char2ByteSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Char2ByteMaps.EmptyMap implements Char2ByteSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public ObjectSortedSet<Char2ByteMap.Entry> char2ByteEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Byte>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
        public CharSortedSet keySet() {
            return CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public Char2ByteSortedMap subMap(char from, char to) {
            return Char2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public Char2ByteSortedMap headMap(char to) {
            return Char2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public Char2ByteSortedMap tailMap(char from) {
            return Char2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public char firstCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public char lastCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        @Deprecated
        public Char2ByteSortedMap headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        @Deprecated
        public Char2ByteSortedMap tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        @Deprecated
        public Char2ByteSortedMap subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteSortedMaps$Singleton.class */
    public static class Singleton extends Char2ByteMaps.Singleton implements Char2ByteSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final CharComparator comparator;

        protected Singleton(char key, byte value, CharComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(char key, byte value) {
            this(key, value, null);
        }

        final int compare(char k1, char k2) {
            return this.comparator == null ? Character.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public ObjectSortedSet<Char2ByteMap.Entry> char2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractChar2ByteMap.BasicEntry(this.key, this.value), Char2ByteSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Byte>> entrySet() {
            return char2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.singleton(this.key, this.comparator);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public Char2ByteSortedMap subMap(char from, char to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Char2ByteSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public Char2ByteSortedMap headMap(char to) {
            return compare(this.key, to) < 0 ? this : Char2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public Char2ByteSortedMap tailMap(char from) {
            return compare(from, this.key) <= 0 ? this : Char2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public char firstCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public char lastCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        @Deprecated
        public Char2ByteSortedMap headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        @Deprecated
        public Char2ByteSortedMap tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        @Deprecated
        public Char2ByteSortedMap subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    public static Char2ByteSortedMap singleton(Character key, Byte value) {
        return new Singleton(key.charValue(), value.byteValue());
    }

    public static Char2ByteSortedMap singleton(Character key, Byte value, CharComparator comparator) {
        return new Singleton(key.charValue(), value.byteValue(), comparator);
    }

    public static Char2ByteSortedMap singleton(char key, byte value) {
        return new Singleton(key, value);
    }

    public static Char2ByteSortedMap singleton(char key, byte value, CharComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Char2ByteMaps.SynchronizedMap implements Char2ByteSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2ByteSortedMap sortedMap;

        protected SynchronizedSortedMap(Char2ByteSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Char2ByteSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            Comparator<? super Character> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public ObjectSortedSet<Char2ByteMap.Entry> char2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.char2ByteEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Byte>> entrySet() {
            return char2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public Char2ByteSortedMap subMap(char from, char to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public Char2ByteSortedMap headMap(char to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public Char2ByteSortedMap tailMap(char from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public char firstCharKey() {
            char firstCharKey;
            synchronized (this.sync) {
                firstCharKey = this.sortedMap.firstCharKey();
            }
            return firstCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public char lastCharKey() {
            char lastCharKey;
            synchronized (this.sync) {
                lastCharKey = this.sortedMap.lastCharKey();
            }
            return lastCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            Character firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            Character lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        @Deprecated
        public Char2ByteSortedMap subMap(Character from, Character to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        @Deprecated
        public Char2ByteSortedMap headMap(Character to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        @Deprecated
        public Char2ByteSortedMap tailMap(Character from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Char2ByteSortedMap synchronize(Char2ByteSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Char2ByteSortedMap synchronize(Char2ByteSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Char2ByteMaps.UnmodifiableMap implements Char2ByteSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2ByteSortedMap sortedMap;

        protected UnmodifiableSortedMap(Char2ByteSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public ObjectSortedSet<Char2ByteMap.Entry> char2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.char2ByteEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Byte>> entrySet() {
            return char2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public Char2ByteSortedMap subMap(char from, char to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public Char2ByteSortedMap headMap(char to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public Char2ByteSortedMap tailMap(char from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public char firstCharKey() {
            return this.sortedMap.firstCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        public char lastCharKey() {
            return this.sortedMap.lastCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        @Deprecated
        public Char2ByteSortedMap subMap(Character from, Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        @Deprecated
        public Char2ByteSortedMap headMap(Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
        @Deprecated
        public Char2ByteSortedMap tailMap(Character from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Char2ByteSortedMap unmodifiable(Char2ByteSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
