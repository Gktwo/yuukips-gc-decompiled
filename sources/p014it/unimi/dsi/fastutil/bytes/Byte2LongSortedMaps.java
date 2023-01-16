package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2LongMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongMaps;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongSortedMaps.class */
public final class Byte2LongSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Byte2LongSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Byte, ?>> entryComparator(ByteComparator comparator) {
        return x, y -> {
            return comparator.compare(((Byte) x.getKey()).byteValue(), ((Byte) y.getKey()).byteValue());
        };
    }

    public static ObjectBidirectionalIterator<Byte2LongMap.Entry> fastIterator(Byte2LongSortedMap map) {
        ObjectSortedSet<Byte2LongMap.Entry> entries = map.byte2LongEntrySet();
        return entries instanceof Byte2LongSortedMap.FastSortedEntrySet ? ((Byte2LongSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Byte2LongMap.Entry> fastIterable(Byte2LongSortedMap map) {
        ObjectSortedSet<Byte2LongMap.Entry> entries = map.byte2LongEntrySet();
        if (!(entries instanceof Byte2LongSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Byte2LongSortedMap.FastSortedEntrySet fastSortedEntrySet = (Byte2LongSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Byte2LongMaps.EmptyMap implements Byte2LongSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMaps.EmptyMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public ObjectSortedSet<Byte2LongMap.Entry> byte2LongEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Long>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMaps.EmptyMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
        public ByteSortedSet keySet() {
            return ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public Byte2LongSortedMap subMap(byte from, byte to) {
            return Byte2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public Byte2LongSortedMap headMap(byte to) {
            return Byte2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public Byte2LongSortedMap tailMap(byte from) {
            return Byte2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public byte firstByteKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public byte lastByteKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        @Deprecated
        public Byte2LongSortedMap headMap(Byte oto) {
            return headMap(oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        @Deprecated
        public Byte2LongSortedMap tailMap(Byte ofrom) {
            return tailMap(ofrom.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        @Deprecated
        public Byte2LongSortedMap subMap(Byte ofrom, Byte oto) {
            return subMap(ofrom.byteValue(), oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return Byte.valueOf(firstByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return Byte.valueOf(lastByteKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongSortedMaps$Singleton.class */
    public static class Singleton extends Byte2LongMaps.Singleton implements Byte2LongSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteComparator comparator;

        protected Singleton(byte key, long value, ByteComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(byte key, long value) {
            this(key, value, null);
        }

        final int compare(byte k1, byte k2) {
            return this.comparator == null ? Byte.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public ObjectSortedSet<Byte2LongMap.Entry> byte2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractByte2LongMap.BasicEntry(this.key, this.value), Byte2LongSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Long>> entrySet() {
            return byte2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.singleton(this.key, this.comparator);
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public Byte2LongSortedMap subMap(byte from, byte to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Byte2LongSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public Byte2LongSortedMap headMap(byte to) {
            return compare(this.key, to) < 0 ? this : Byte2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public Byte2LongSortedMap tailMap(byte from) {
            return compare(from, this.key) <= 0 ? this : Byte2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public byte firstByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public byte lastByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        @Deprecated
        public Byte2LongSortedMap headMap(Byte oto) {
            return headMap(oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        @Deprecated
        public Byte2LongSortedMap tailMap(Byte ofrom) {
            return tailMap(ofrom.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        @Deprecated
        public Byte2LongSortedMap subMap(Byte ofrom, Byte oto) {
            return subMap(ofrom.byteValue(), oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return Byte.valueOf(firstByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return Byte.valueOf(lastByteKey());
        }
    }

    public static Byte2LongSortedMap singleton(Byte key, Long value) {
        return new Singleton(key.byteValue(), value.longValue());
    }

    public static Byte2LongSortedMap singleton(Byte key, Long value, ByteComparator comparator) {
        return new Singleton(key.byteValue(), value.longValue(), comparator);
    }

    public static Byte2LongSortedMap singleton(byte key, long value) {
        return new Singleton(key, value);
    }

    public static Byte2LongSortedMap singleton(byte key, long value, ByteComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Byte2LongMaps.SynchronizedMap implements Byte2LongSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2LongSortedMap sortedMap;

        protected SynchronizedSortedMap(Byte2LongSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Byte2LongSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            Comparator<? super Byte> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public ObjectSortedSet<Byte2LongMap.Entry> byte2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.byte2LongEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Long>> entrySet() {
            return byte2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public Byte2LongSortedMap subMap(byte from, byte to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public Byte2LongSortedMap headMap(byte to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public Byte2LongSortedMap tailMap(byte from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public byte firstByteKey() {
            byte firstByteKey;
            synchronized (this.sync) {
                firstByteKey = this.sortedMap.firstByteKey();
            }
            return firstByteKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public byte lastByteKey() {
            byte lastByteKey;
            synchronized (this.sync) {
                lastByteKey = this.sortedMap.lastByteKey();
            }
            return lastByteKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            Byte firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            Byte lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        @Deprecated
        public Byte2LongSortedMap subMap(Byte from, Byte to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        @Deprecated
        public Byte2LongSortedMap headMap(Byte to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        @Deprecated
        public Byte2LongSortedMap tailMap(Byte from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Byte2LongSortedMap synchronize(Byte2LongSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Byte2LongSortedMap synchronize(Byte2LongSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Byte2LongMaps.UnmodifiableMap implements Byte2LongSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2LongSortedMap sortedMap;

        protected UnmodifiableSortedMap(Byte2LongSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public ObjectSortedSet<Byte2LongMap.Entry> byte2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.byte2LongEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Long>> entrySet() {
            return byte2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public Byte2LongSortedMap subMap(byte from, byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public Byte2LongSortedMap headMap(byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public Byte2LongSortedMap tailMap(byte from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public byte firstByteKey() {
            return this.sortedMap.firstByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        public byte lastByteKey() {
            return this.sortedMap.lastByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        @Deprecated
        public Byte2LongSortedMap subMap(Byte from, Byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        @Deprecated
        public Byte2LongSortedMap headMap(Byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
        @Deprecated
        public Byte2LongSortedMap tailMap(Byte from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Byte2LongSortedMap unmodifiable(Byte2LongSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
