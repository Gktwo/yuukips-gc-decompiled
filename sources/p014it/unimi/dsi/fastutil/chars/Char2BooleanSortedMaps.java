package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2BooleanMap;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanMap;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanMaps;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanSortedMaps.class */
public final class Char2BooleanSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Char2BooleanSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Character, ?>> entryComparator(CharComparator comparator) {
        return x, y -> {
            return comparator.compare(((Character) x.getKey()).charValue(), ((Character) y.getKey()).charValue());
        };
    }

    public static ObjectBidirectionalIterator<Char2BooleanMap.Entry> fastIterator(Char2BooleanSortedMap map) {
        ObjectSortedSet<Char2BooleanMap.Entry> entries = map.char2BooleanEntrySet();
        return entries instanceof Char2BooleanSortedMap.FastSortedEntrySet ? ((Char2BooleanSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Char2BooleanMap.Entry> fastIterable(Char2BooleanSortedMap map) {
        ObjectSortedSet<Char2BooleanMap.Entry> entries = map.char2BooleanEntrySet();
        if (!(entries instanceof Char2BooleanSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Char2BooleanSortedMap.FastSortedEntrySet fastSortedEntrySet = (Char2BooleanSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Char2BooleanMaps.EmptyMap implements Char2BooleanSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public ObjectSortedSet<Char2BooleanMap.Entry> char2BooleanEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Boolean>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        public CharSortedSet keySet() {
            return CharSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public Char2BooleanSortedMap subMap(char from, char to) {
            return Char2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public Char2BooleanSortedMap headMap(char to) {
            return Char2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public Char2BooleanSortedMap tailMap(char from) {
            return Char2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public char firstCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public char lastCharKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        @Deprecated
        public Char2BooleanSortedMap headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        @Deprecated
        public Char2BooleanSortedMap tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        @Deprecated
        public Char2BooleanSortedMap subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanSortedMaps$Singleton.class */
    public static class Singleton extends Char2BooleanMaps.Singleton implements Char2BooleanSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final CharComparator comparator;

        protected Singleton(char key, boolean value, CharComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(char key, boolean value) {
            this(key, value, null);
        }

        final int compare(char k1, char k2) {
            return this.comparator == null ? Character.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public ObjectSortedSet<Char2BooleanMap.Entry> char2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractChar2BooleanMap.BasicEntry(this.key, this.value), Char2BooleanSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Boolean>> entrySet() {
            return char2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.singleton(this.key, this.comparator);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public Char2BooleanSortedMap subMap(char from, char to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Char2BooleanSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public Char2BooleanSortedMap headMap(char to) {
            return compare(this.key, to) < 0 ? this : Char2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public Char2BooleanSortedMap tailMap(char from) {
            return compare(from, this.key) <= 0 ? this : Char2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public char firstCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public char lastCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        @Deprecated
        public Char2BooleanSortedMap headMap(Character oto) {
            return headMap(oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        @Deprecated
        public Char2BooleanSortedMap tailMap(Character ofrom) {
            return tailMap(ofrom.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        @Deprecated
        public Char2BooleanSortedMap subMap(Character ofrom, Character oto) {
            return subMap(ofrom.charValue(), oto.charValue());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return Character.valueOf(firstCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return Character.valueOf(lastCharKey());
        }
    }

    public static Char2BooleanSortedMap singleton(Character key, Boolean value) {
        return new Singleton(key.charValue(), value.booleanValue());
    }

    public static Char2BooleanSortedMap singleton(Character key, Boolean value, CharComparator comparator) {
        return new Singleton(key.charValue(), value.booleanValue(), comparator);
    }

    public static Char2BooleanSortedMap singleton(char key, boolean value) {
        return new Singleton(key, value);
    }

    public static Char2BooleanSortedMap singleton(char key, boolean value, CharComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Char2BooleanMaps.SynchronizedMap implements Char2BooleanSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2BooleanSortedMap sortedMap;

        protected SynchronizedSortedMap(Char2BooleanSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Char2BooleanSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            Comparator<? super Character> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public ObjectSortedSet<Char2BooleanMap.Entry> char2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.char2BooleanEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Boolean>> entrySet() {
            return char2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public Char2BooleanSortedMap subMap(char from, char to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public Char2BooleanSortedMap headMap(char to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public Char2BooleanSortedMap tailMap(char from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public char firstCharKey() {
            char firstCharKey;
            synchronized (this.sync) {
                firstCharKey = this.sortedMap.firstCharKey();
            }
            return firstCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public char lastCharKey() {
            char lastCharKey;
            synchronized (this.sync) {
                lastCharKey = this.sortedMap.lastCharKey();
            }
            return lastCharKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            Character firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            Character lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        @Deprecated
        public Char2BooleanSortedMap subMap(Character from, Character to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        @Deprecated
        public Char2BooleanSortedMap headMap(Character to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        @Deprecated
        public Char2BooleanSortedMap tailMap(Character from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Char2BooleanSortedMap synchronize(Char2BooleanSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Char2BooleanSortedMap synchronize(Char2BooleanSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Char2BooleanMaps.UnmodifiableMap implements Char2BooleanSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2BooleanSortedMap sortedMap;

        protected UnmodifiableSortedMap(Char2BooleanSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public ObjectSortedSet<Char2BooleanMap.Entry> char2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.char2BooleanEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Character, Boolean>> entrySet() {
            return char2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = CharSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (CharSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public Char2BooleanSortedMap subMap(char from, char to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public Char2BooleanSortedMap headMap(char to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public Char2BooleanSortedMap tailMap(char from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public char firstCharKey() {
            return this.sortedMap.firstCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public char lastCharKey() {
            return this.sortedMap.lastCharKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Character firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Character lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        @Deprecated
        public Char2BooleanSortedMap subMap(Character from, Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        @Deprecated
        public Char2BooleanSortedMap headMap(Character to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        @Deprecated
        public Char2BooleanSortedMap tailMap(Character from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Char2BooleanSortedMap unmodifiable(Char2BooleanSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
