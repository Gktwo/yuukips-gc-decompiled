package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2CharMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharMaps;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2CharSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2CharSortedMaps.class */
public final class Byte2CharSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Byte2CharSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Byte, ?>> entryComparator(ByteComparator comparator) {
        return x, y -> {
            return comparator.compare(((Byte) x.getKey()).byteValue(), ((Byte) y.getKey()).byteValue());
        };
    }

    public static ObjectBidirectionalIterator<Byte2CharMap.Entry> fastIterator(Byte2CharSortedMap map) {
        ObjectSortedSet<Byte2CharMap.Entry> entries = map.byte2CharEntrySet();
        return entries instanceof Byte2CharSortedMap.FastSortedEntrySet ? ((Byte2CharSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Byte2CharMap.Entry> fastIterable(Byte2CharSortedMap map) {
        ObjectSortedSet<Byte2CharMap.Entry> entries = map.byte2CharEntrySet();
        if (!(entries instanceof Byte2CharSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Byte2CharSortedMap.FastSortedEntrySet fastSortedEntrySet = (Byte2CharSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2CharSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2CharSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Byte2CharMaps.EmptyMap implements Byte2CharSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMaps.EmptyMap, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public ObjectSortedSet<Byte2CharMap.Entry> byte2CharEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Character>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMaps.EmptyMap, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, java.util.Map
        public ByteSortedSet keySet() {
            return ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public Byte2CharSortedMap subMap(byte from, byte to) {
            return Byte2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public Byte2CharSortedMap headMap(byte to) {
            return Byte2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public Byte2CharSortedMap tailMap(byte from) {
            return Byte2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public byte firstByteKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public byte lastByteKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        @Deprecated
        public Byte2CharSortedMap headMap(Byte oto) {
            return headMap(oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        @Deprecated
        public Byte2CharSortedMap tailMap(Byte ofrom) {
            return tailMap(ofrom.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        @Deprecated
        public Byte2CharSortedMap subMap(Byte ofrom, Byte oto) {
            return subMap(ofrom.byteValue(), oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return Byte.valueOf(firstByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return Byte.valueOf(lastByteKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2CharSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2CharSortedMaps$Singleton.class */
    public static class Singleton extends Byte2CharMaps.Singleton implements Byte2CharSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteComparator comparator;

        protected Singleton(byte key, char value, ByteComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(byte key, char value) {
            this(key, value, null);
        }

        final int compare(byte k1, byte k2) {
            return this.comparator == null ? Byte.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public ObjectSortedSet<Byte2CharMap.Entry> byte2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractByte2CharMap.BasicEntry(this.key, this.value), Byte2CharSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Character>> entrySet() {
            return byte2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.singleton(this.key, this.comparator);
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public Byte2CharSortedMap subMap(byte from, byte to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Byte2CharSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public Byte2CharSortedMap headMap(byte to) {
            return compare(this.key, to) < 0 ? this : Byte2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public Byte2CharSortedMap tailMap(byte from) {
            return compare(from, this.key) <= 0 ? this : Byte2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public byte firstByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public byte lastByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        @Deprecated
        public Byte2CharSortedMap headMap(Byte oto) {
            return headMap(oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        @Deprecated
        public Byte2CharSortedMap tailMap(Byte ofrom) {
            return tailMap(ofrom.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        @Deprecated
        public Byte2CharSortedMap subMap(Byte ofrom, Byte oto) {
            return subMap(ofrom.byteValue(), oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return Byte.valueOf(firstByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return Byte.valueOf(lastByteKey());
        }
    }

    public static Byte2CharSortedMap singleton(Byte key, Character value) {
        return new Singleton(key.byteValue(), value.charValue());
    }

    public static Byte2CharSortedMap singleton(Byte key, Character value, ByteComparator comparator) {
        return new Singleton(key.byteValue(), value.charValue(), comparator);
    }

    public static Byte2CharSortedMap singleton(byte key, char value) {
        return new Singleton(key, value);
    }

    public static Byte2CharSortedMap singleton(byte key, char value, ByteComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2CharSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2CharSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Byte2CharMaps.SynchronizedMap implements Byte2CharSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2CharSortedMap sortedMap;

        protected SynchronizedSortedMap(Byte2CharSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Byte2CharSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            Comparator<? super Byte> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public ObjectSortedSet<Byte2CharMap.Entry> byte2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.byte2CharEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Character>> entrySet() {
            return byte2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public Byte2CharSortedMap subMap(byte from, byte to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public Byte2CharSortedMap headMap(byte to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public Byte2CharSortedMap tailMap(byte from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public byte firstByteKey() {
            byte firstByteKey;
            synchronized (this.sync) {
                firstByteKey = this.sortedMap.firstByteKey();
            }
            return firstByteKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public byte lastByteKey() {
            byte lastByteKey;
            synchronized (this.sync) {
                lastByteKey = this.sortedMap.lastByteKey();
            }
            return lastByteKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            Byte firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            Byte lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        @Deprecated
        public Byte2CharSortedMap subMap(Byte from, Byte to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        @Deprecated
        public Byte2CharSortedMap headMap(Byte to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        @Deprecated
        public Byte2CharSortedMap tailMap(Byte from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Byte2CharSortedMap synchronize(Byte2CharSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Byte2CharSortedMap synchronize(Byte2CharSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2CharSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2CharSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Byte2CharMaps.UnmodifiableMap implements Byte2CharSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2CharSortedMap sortedMap;

        protected UnmodifiableSortedMap(Byte2CharSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public ObjectSortedSet<Byte2CharMap.Entry> byte2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.byte2CharEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Character>> entrySet() {
            return byte2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public Byte2CharSortedMap subMap(byte from, byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public Byte2CharSortedMap headMap(byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public Byte2CharSortedMap tailMap(byte from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public byte firstByteKey() {
            return this.sortedMap.firstByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        public byte lastByteKey() {
            return this.sortedMap.lastByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        @Deprecated
        public Byte2CharSortedMap subMap(Byte from, Byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        @Deprecated
        public Byte2CharSortedMap headMap(Byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharSortedMap
        @Deprecated
        public Byte2CharSortedMap tailMap(Byte from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Byte2CharSortedMap unmodifiable(Byte2CharSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
