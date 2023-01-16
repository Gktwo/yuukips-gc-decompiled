package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceMaps;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceSortedMaps.class */
public final class Char2ReferenceSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Char2ReferenceSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Character, ?>> entryComparator(CharComparator comparator) {
        return x, y -> {
            return comparator.compare(((Character) x.getKey()).charValue(), ((Character) y.getKey()).charValue());
        };
    }

    public static <V> ObjectBidirectionalIterator<Char2ReferenceMap.Entry<V>> fastIterator(Char2ReferenceSortedMap<V> map) {
        ObjectSortedSet<Char2ReferenceMap.Entry<V>> entries = map.char2ReferenceEntrySet();
        return entries instanceof Char2ReferenceSortedMap.FastSortedEntrySet ? ((Char2ReferenceSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> ObjectBidirectionalIterable<Char2ReferenceMap.Entry<V>> fastIterable(Char2ReferenceSortedMap<V> map) {
        ObjectSortedSet<Char2ReferenceMap.Entry<V>> entries = map.char2ReferenceEntrySet();
        if (!(entries instanceof Char2ReferenceSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Char2ReferenceSortedMap.FastSortedEntrySet fastSortedEntrySet = (Char2ReferenceSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<V> extends Char2ReferenceMaps.EmptyMap<V> implements Char2ReferenceSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public ObjectSortedSet<Char2ReferenceMap.Entry<V>> char2ReferenceEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, V>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
        public CharSortedSet keySet() {
            return CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> subMap(char from, char to) {
            return Char2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> headMap(char to) {
            return Char2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> tailMap(char from) {
            return Char2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public char firstCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public char lastCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        @Deprecated
        public Char2ReferenceSortedMap<V> headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        @Deprecated
        public Char2ReferenceSortedMap<V> tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        @Deprecated
        public Char2ReferenceSortedMap<V> subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    public static <V> Char2ReferenceSortedMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceSortedMaps$Singleton.class */
    public static class Singleton<V> extends Char2ReferenceMaps.Singleton<V> implements Char2ReferenceSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final CharComparator comparator;

        protected Singleton(char key, V value, CharComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(char key, V value) {
            this(key, value, null);
        }

        final int compare(char k1, char k2) {
            return this.comparator == null ? Character.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public ObjectSortedSet<Char2ReferenceMap.Entry<V>> char2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractChar2ReferenceMap.BasicEntry(this.key, this.value), Char2ReferenceSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, V>> entrySet() {
            return char2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.singleton(this.key, this.comparator);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> subMap(char from, char to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Char2ReferenceSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> headMap(char to) {
            return compare(this.key, to) < 0 ? this : Char2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> tailMap(char from) {
            return compare(from, this.key) <= 0 ? this : Char2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public char firstCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public char lastCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        @Deprecated
        public Char2ReferenceSortedMap<V> headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        @Deprecated
        public Char2ReferenceSortedMap<V> tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        @Deprecated
        public Char2ReferenceSortedMap<V> subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    public static <V> Char2ReferenceSortedMap<V> singleton(Character key, V value) {
        return new Singleton(key.charValue(), value);
    }

    public static <V> Char2ReferenceSortedMap<V> singleton(Character key, V value, CharComparator comparator) {
        return new Singleton(key.charValue(), value, comparator);
    }

    public static <V> Char2ReferenceSortedMap<V> singleton(char key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Char2ReferenceSortedMap<V> singleton(char key, V value, CharComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<V> extends Char2ReferenceMaps.SynchronizedMap<V> implements Char2ReferenceSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2ReferenceSortedMap<V> sortedMap;

        protected SynchronizedSortedMap(Char2ReferenceSortedMap<V> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Char2ReferenceSortedMap<V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            Comparator<? super Character> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public ObjectSortedSet<Char2ReferenceMap.Entry<V>> char2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.char2ReferenceEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, V>> entrySet() {
            return char2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> subMap(char from, char to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> headMap(char to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> tailMap(char from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public char firstCharKey() {
            char firstCharKey;
            synchronized (this.sync) {
                firstCharKey = this.sortedMap.firstCharKey();
            }
            return firstCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public char lastCharKey() {
            char lastCharKey;
            synchronized (this.sync) {
                lastCharKey = this.sortedMap.lastCharKey();
            }
            return lastCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            Character firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            Character lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        @Deprecated
        public Char2ReferenceSortedMap<V> subMap(Character from, Character to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        @Deprecated
        public Char2ReferenceSortedMap<V> headMap(Character to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        @Deprecated
        public Char2ReferenceSortedMap<V> tailMap(Character from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static <V> Char2ReferenceSortedMap<V> synchronize(Char2ReferenceSortedMap<V> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <V> Char2ReferenceSortedMap<V> synchronize(Char2ReferenceSortedMap<V> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<V> extends Char2ReferenceMaps.UnmodifiableMap<V> implements Char2ReferenceSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2ReferenceSortedMap<? extends V> sortedMap;

        protected UnmodifiableSortedMap(Char2ReferenceSortedMap<? extends V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public ObjectSortedSet<Char2ReferenceMap.Entry<V>> char2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.char2ReferenceEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, V>> entrySet() {
            return char2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> subMap(char from, char to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> headMap(char to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> tailMap(char from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public char firstCharKey() {
            return this.sortedMap.firstCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public char lastCharKey() {
            return this.sortedMap.lastCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        @Deprecated
        public Char2ReferenceSortedMap<V> subMap(Character from, Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        @Deprecated
        public Char2ReferenceSortedMap<V> headMap(Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        @Deprecated
        public Char2ReferenceSortedMap<V> tailMap(Character from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static <V> Char2ReferenceSortedMap<V> unmodifiable(Char2ReferenceSortedMap<? extends V> m) {
        return new UnmodifiableSortedMap(m);
    }
}
