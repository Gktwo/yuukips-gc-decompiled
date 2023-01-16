package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2DoubleMap;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleMap;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleMaps;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2DoubleSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2DoubleSortedMaps.class */
public final class Char2DoubleSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Char2DoubleSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Character, ?>> entryComparator(CharComparator comparator) {
        return x, y -> {
            return comparator.compare(((Character) x.getKey()).charValue(), ((Character) y.getKey()).charValue());
        };
    }

    public static ObjectBidirectionalIterator<Char2DoubleMap.Entry> fastIterator(Char2DoubleSortedMap map) {
        ObjectSortedSet<Char2DoubleMap.Entry> entries = map.char2DoubleEntrySet();
        return entries instanceof Char2DoubleSortedMap.FastSortedEntrySet ? ((Char2DoubleSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Char2DoubleMap.Entry> fastIterable(Char2DoubleSortedMap map) {
        ObjectSortedSet<Char2DoubleMap.Entry> entries = map.char2DoubleEntrySet();
        if (!(entries instanceof Char2DoubleSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Char2DoubleSortedMap.FastSortedEntrySet fastSortedEntrySet = (Char2DoubleSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2DoubleSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2DoubleSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Char2DoubleMaps.EmptyMap implements Char2DoubleSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public ObjectSortedSet<Char2DoubleMap.Entry> char2DoubleEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Double>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, java.util.Map
        public CharSortedSet keySet() {
            return CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public Char2DoubleSortedMap subMap(char from, char to) {
            return Char2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public Char2DoubleSortedMap headMap(char to) {
            return Char2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public Char2DoubleSortedMap tailMap(char from) {
            return Char2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public char firstCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public char lastCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        @Deprecated
        public Char2DoubleSortedMap headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        @Deprecated
        public Char2DoubleSortedMap tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        @Deprecated
        public Char2DoubleSortedMap subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2DoubleSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2DoubleSortedMaps$Singleton.class */
    public static class Singleton extends Char2DoubleMaps.Singleton implements Char2DoubleSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final CharComparator comparator;

        protected Singleton(char key, double value, CharComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(char key, double value) {
            this(key, value, null);
        }

        final int compare(char k1, char k2) {
            return this.comparator == null ? Character.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public ObjectSortedSet<Char2DoubleMap.Entry> char2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractChar2DoubleMap.BasicEntry(this.key, this.value), Char2DoubleSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Double>> entrySet() {
            return char2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.singleton(this.key, this.comparator);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public Char2DoubleSortedMap subMap(char from, char to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Char2DoubleSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public Char2DoubleSortedMap headMap(char to) {
            return compare(this.key, to) < 0 ? this : Char2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public Char2DoubleSortedMap tailMap(char from) {
            return compare(from, this.key) <= 0 ? this : Char2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public char firstCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public char lastCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        @Deprecated
        public Char2DoubleSortedMap headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        @Deprecated
        public Char2DoubleSortedMap tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        @Deprecated
        public Char2DoubleSortedMap subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    public static Char2DoubleSortedMap singleton(Character key, Double value) {
        return new Singleton(key.charValue(), value.doubleValue());
    }

    public static Char2DoubleSortedMap singleton(Character key, Double value, CharComparator comparator) {
        return new Singleton(key.charValue(), value.doubleValue(), comparator);
    }

    public static Char2DoubleSortedMap singleton(char key, double value) {
        return new Singleton(key, value);
    }

    public static Char2DoubleSortedMap singleton(char key, double value, CharComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2DoubleSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2DoubleSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Char2DoubleMaps.SynchronizedMap implements Char2DoubleSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2DoubleSortedMap sortedMap;

        protected SynchronizedSortedMap(Char2DoubleSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Char2DoubleSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            Comparator<? super Character> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public ObjectSortedSet<Char2DoubleMap.Entry> char2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.char2DoubleEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Double>> entrySet() {
            return char2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public Char2DoubleSortedMap subMap(char from, char to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public Char2DoubleSortedMap headMap(char to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public Char2DoubleSortedMap tailMap(char from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public char firstCharKey() {
            char firstCharKey;
            synchronized (this.sync) {
                firstCharKey = this.sortedMap.firstCharKey();
            }
            return firstCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public char lastCharKey() {
            char lastCharKey;
            synchronized (this.sync) {
                lastCharKey = this.sortedMap.lastCharKey();
            }
            return lastCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            Character firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            Character lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        @Deprecated
        public Char2DoubleSortedMap subMap(Character from, Character to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        @Deprecated
        public Char2DoubleSortedMap headMap(Character to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        @Deprecated
        public Char2DoubleSortedMap tailMap(Character from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Char2DoubleSortedMap synchronize(Char2DoubleSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Char2DoubleSortedMap synchronize(Char2DoubleSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2DoubleSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2DoubleSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Char2DoubleMaps.UnmodifiableMap implements Char2DoubleSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2DoubleSortedMap sortedMap;

        protected UnmodifiableSortedMap(Char2DoubleSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public ObjectSortedSet<Char2DoubleMap.Entry> char2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.char2DoubleEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Double>> entrySet() {
            return char2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public Char2DoubleSortedMap subMap(char from, char to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public Char2DoubleSortedMap headMap(char to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public Char2DoubleSortedMap tailMap(char from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public char firstCharKey() {
            return this.sortedMap.firstCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        public char lastCharKey() {
            return this.sortedMap.lastCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        @Deprecated
        public Char2DoubleSortedMap subMap(Character from, Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        @Deprecated
        public Char2DoubleSortedMap headMap(Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
        @Deprecated
        public Char2DoubleSortedMap tailMap(Character from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Char2DoubleSortedMap unmodifiable(Char2DoubleSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
