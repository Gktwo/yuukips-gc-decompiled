package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2FloatMap;
import p014it.unimi.dsi.fastutil.chars.Char2FloatMap;
import p014it.unimi.dsi.fastutil.chars.Char2FloatMaps;
import p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatSortedMaps.class */
public final class Char2FloatSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Char2FloatSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Character, ?>> entryComparator(CharComparator comparator) {
        return x, y -> {
            return comparator.compare(((Character) x.getKey()).charValue(), ((Character) y.getKey()).charValue());
        };
    }

    public static ObjectBidirectionalIterator<Char2FloatMap.Entry> fastIterator(Char2FloatSortedMap map) {
        ObjectSortedSet<Char2FloatMap.Entry> entries = map.char2FloatEntrySet();
        return entries instanceof Char2FloatSortedMap.FastSortedEntrySet ? ((Char2FloatSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Char2FloatMap.Entry> fastIterable(Char2FloatSortedMap map) {
        ObjectSortedSet<Char2FloatMap.Entry> entries = map.char2FloatEntrySet();
        if (!(entries instanceof Char2FloatSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Char2FloatSortedMap.FastSortedEntrySet fastSortedEntrySet = (Char2FloatSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Char2FloatMaps.EmptyMap implements Char2FloatSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2FloatMap, p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public ObjectSortedSet<Char2FloatMap.Entry> char2FloatEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Float>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        public CharSortedSet keySet() {
            return CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public Char2FloatSortedMap subMap(char from, char to) {
            return Char2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public Char2FloatSortedMap headMap(char to) {
            return Char2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public Char2FloatSortedMap tailMap(char from) {
            return Char2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public char firstCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public char lastCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        @Deprecated
        public Char2FloatSortedMap headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        @Deprecated
        public Char2FloatSortedMap tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        @Deprecated
        public Char2FloatSortedMap subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatSortedMaps$Singleton.class */
    public static class Singleton extends Char2FloatMaps.Singleton implements Char2FloatSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final CharComparator comparator;

        protected Singleton(char key, float value, CharComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(char key, float value) {
            this(key, value, null);
        }

        final int compare(char k1, char k2) {
            return this.comparator == null ? Character.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2FloatMap, p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public ObjectSortedSet<Char2FloatMap.Entry> char2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractChar2FloatMap.BasicEntry(this.key, this.value), Char2FloatSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Float>> entrySet() {
            return char2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.singleton(this.key, this.comparator);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public Char2FloatSortedMap subMap(char from, char to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Char2FloatSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public Char2FloatSortedMap headMap(char to) {
            return compare(this.key, to) < 0 ? this : Char2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public Char2FloatSortedMap tailMap(char from) {
            return compare(from, this.key) <= 0 ? this : Char2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public char firstCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public char lastCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        @Deprecated
        public Char2FloatSortedMap headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        @Deprecated
        public Char2FloatSortedMap tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        @Deprecated
        public Char2FloatSortedMap subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    public static Char2FloatSortedMap singleton(Character key, Float value) {
        return new Singleton(key.charValue(), value.floatValue());
    }

    public static Char2FloatSortedMap singleton(Character key, Float value, CharComparator comparator) {
        return new Singleton(key.charValue(), value.floatValue(), comparator);
    }

    public static Char2FloatSortedMap singleton(char key, float value) {
        return new Singleton(key, value);
    }

    public static Char2FloatSortedMap singleton(char key, float value, CharComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Char2FloatMaps.SynchronizedMap implements Char2FloatSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2FloatSortedMap sortedMap;

        protected SynchronizedSortedMap(Char2FloatSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Char2FloatSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            Comparator<? super Character> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2FloatMap, p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public ObjectSortedSet<Char2FloatMap.Entry> char2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.char2FloatEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Float>> entrySet() {
            return char2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public Char2FloatSortedMap subMap(char from, char to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public Char2FloatSortedMap headMap(char to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public Char2FloatSortedMap tailMap(char from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public char firstCharKey() {
            char firstCharKey;
            synchronized (this.sync) {
                firstCharKey = this.sortedMap.firstCharKey();
            }
            return firstCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public char lastCharKey() {
            char lastCharKey;
            synchronized (this.sync) {
                lastCharKey = this.sortedMap.lastCharKey();
            }
            return lastCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            Character firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            Character lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        @Deprecated
        public Char2FloatSortedMap subMap(Character from, Character to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        @Deprecated
        public Char2FloatSortedMap headMap(Character to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        @Deprecated
        public Char2FloatSortedMap tailMap(Character from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Char2FloatSortedMap synchronize(Char2FloatSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Char2FloatSortedMap synchronize(Char2FloatSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Char2FloatMaps.UnmodifiableMap implements Char2FloatSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2FloatSortedMap sortedMap;

        protected UnmodifiableSortedMap(Char2FloatSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2FloatMap, p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public ObjectSortedSet<Char2FloatMap.Entry> char2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.char2FloatEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Float>> entrySet() {
            return char2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public Char2FloatSortedMap subMap(char from, char to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public Char2FloatSortedMap headMap(char to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public Char2FloatSortedMap tailMap(char from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public char firstCharKey() {
            return this.sortedMap.firstCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public char lastCharKey() {
            return this.sortedMap.lastCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        @Deprecated
        public Char2FloatSortedMap subMap(Character from, Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        @Deprecated
        public Char2FloatSortedMap headMap(Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        @Deprecated
        public Char2FloatSortedMap tailMap(Character from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Char2FloatSortedMap unmodifiable(Char2FloatSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
