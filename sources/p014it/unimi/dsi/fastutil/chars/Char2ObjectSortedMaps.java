package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectMaps;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectSortedMaps.class */
public final class Char2ObjectSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Char2ObjectSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Character, ?>> entryComparator(CharComparator comparator) {
        return x, y -> {
            return comparator.compare(((Character) x.getKey()).charValue(), ((Character) y.getKey()).charValue());
        };
    }

    public static <V> ObjectBidirectionalIterator<Char2ObjectMap.Entry<V>> fastIterator(Char2ObjectSortedMap<V> map) {
        ObjectSortedSet<Char2ObjectMap.Entry<V>> entries = map.char2ObjectEntrySet();
        return entries instanceof Char2ObjectSortedMap.FastSortedEntrySet ? ((Char2ObjectSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> ObjectBidirectionalIterable<Char2ObjectMap.Entry<V>> fastIterable(Char2ObjectSortedMap<V> map) {
        ObjectSortedSet<Char2ObjectMap.Entry<V>> entries = map.char2ObjectEntrySet();
        if (!(entries instanceof Char2ObjectSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Char2ObjectSortedMap.FastSortedEntrySet fastSortedEntrySet = (Char2ObjectSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<V> extends Char2ObjectMaps.EmptyMap<V> implements Char2ObjectSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public ObjectSortedSet<Char2ObjectMap.Entry<V>> char2ObjectEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, V>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        public CharSortedSet keySet() {
            return CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public Char2ObjectSortedMap<V> subMap(char from, char to) {
            return Char2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public Char2ObjectSortedMap<V> headMap(char to) {
            return Char2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public Char2ObjectSortedMap<V> tailMap(char from) {
            return Char2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public char firstCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public char lastCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        @Deprecated
        public Char2ObjectSortedMap<V> headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        @Deprecated
        public Char2ObjectSortedMap<V> tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        @Deprecated
        public Char2ObjectSortedMap<V> subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    public static <V> Char2ObjectSortedMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectSortedMaps$Singleton.class */
    public static class Singleton<V> extends Char2ObjectMaps.Singleton<V> implements Char2ObjectSortedMap<V>, Serializable, Cloneable {
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
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public ObjectSortedSet<Char2ObjectMap.Entry<V>> char2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractChar2ObjectMap.BasicEntry(this.key, this.value), Char2ObjectSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, V>> entrySet() {
            return char2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.singleton(this.key, this.comparator);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public Char2ObjectSortedMap<V> subMap(char from, char to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Char2ObjectSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public Char2ObjectSortedMap<V> headMap(char to) {
            return compare(this.key, to) < 0 ? this : Char2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public Char2ObjectSortedMap<V> tailMap(char from) {
            return compare(from, this.key) <= 0 ? this : Char2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public char firstCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public char lastCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        @Deprecated
        public Char2ObjectSortedMap<V> headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        @Deprecated
        public Char2ObjectSortedMap<V> tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        @Deprecated
        public Char2ObjectSortedMap<V> subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    public static <V> Char2ObjectSortedMap<V> singleton(Character key, V value) {
        return new Singleton(key.charValue(), value);
    }

    public static <V> Char2ObjectSortedMap<V> singleton(Character key, V value, CharComparator comparator) {
        return new Singleton(key.charValue(), value, comparator);
    }

    public static <V> Char2ObjectSortedMap<V> singleton(char key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Char2ObjectSortedMap<V> singleton(char key, V value, CharComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<V> extends Char2ObjectMaps.SynchronizedMap<V> implements Char2ObjectSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2ObjectSortedMap<V> sortedMap;

        protected SynchronizedSortedMap(Char2ObjectSortedMap<V> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Char2ObjectSortedMap<V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            Comparator<? super Character> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public ObjectSortedSet<Char2ObjectMap.Entry<V>> char2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.char2ObjectEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, V>> entrySet() {
            return char2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public Char2ObjectSortedMap<V> subMap(char from, char to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public Char2ObjectSortedMap<V> headMap(char to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public Char2ObjectSortedMap<V> tailMap(char from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public char firstCharKey() {
            char firstCharKey;
            synchronized (this.sync) {
                firstCharKey = this.sortedMap.firstCharKey();
            }
            return firstCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public char lastCharKey() {
            char lastCharKey;
            synchronized (this.sync) {
                lastCharKey = this.sortedMap.lastCharKey();
            }
            return lastCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            Character firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            Character lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        @Deprecated
        public Char2ObjectSortedMap<V> subMap(Character from, Character to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        @Deprecated
        public Char2ObjectSortedMap<V> headMap(Character to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        @Deprecated
        public Char2ObjectSortedMap<V> tailMap(Character from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static <V> Char2ObjectSortedMap<V> synchronize(Char2ObjectSortedMap<V> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <V> Char2ObjectSortedMap<V> synchronize(Char2ObjectSortedMap<V> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<V> extends Char2ObjectMaps.UnmodifiableMap<V> implements Char2ObjectSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2ObjectSortedMap<? extends V> sortedMap;

        protected UnmodifiableSortedMap(Char2ObjectSortedMap<? extends V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public ObjectSortedSet<Char2ObjectMap.Entry<V>> char2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.char2ObjectEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, V>> entrySet() {
            return char2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public Char2ObjectSortedMap<V> subMap(char from, char to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public Char2ObjectSortedMap<V> headMap(char to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public Char2ObjectSortedMap<V> tailMap(char from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public char firstCharKey() {
            return this.sortedMap.firstCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public char lastCharKey() {
            return this.sortedMap.lastCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        @Deprecated
        public Char2ObjectSortedMap<V> subMap(Character from, Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        @Deprecated
        public Char2ObjectSortedMap<V> headMap(Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        @Deprecated
        public Char2ObjectSortedMap<V> tailMap(Character from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static <V> Char2ObjectSortedMap<V> unmodifiable(Char2ObjectSortedMap<? extends V> m) {
        return new UnmodifiableSortedMap(m);
    }
}
