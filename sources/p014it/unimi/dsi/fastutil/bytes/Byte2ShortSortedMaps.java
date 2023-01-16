package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortMaps;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortSortedMaps.class */
public final class Byte2ShortSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Byte2ShortSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Byte, ?>> entryComparator(ByteComparator comparator) {
        return x, y -> {
            return comparator.compare(((Byte) x.getKey()).byteValue(), ((Byte) y.getKey()).byteValue());
        };
    }

    public static ObjectBidirectionalIterator<Byte2ShortMap.Entry> fastIterator(Byte2ShortSortedMap map) {
        ObjectSortedSet<Byte2ShortMap.Entry> entries = map.byte2ShortEntrySet();
        return entries instanceof Byte2ShortSortedMap.FastSortedEntrySet ? ((Byte2ShortSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Byte2ShortMap.Entry> fastIterable(Byte2ShortSortedMap map) {
        ObjectSortedSet<Byte2ShortMap.Entry> entries = map.byte2ShortEntrySet();
        if (!(entries instanceof Byte2ShortSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Byte2ShortSortedMap.FastSortedEntrySet fastSortedEntrySet = (Byte2ShortSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Byte2ShortMaps.EmptyMap implements Byte2ShortSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMaps.EmptyMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public ObjectSortedSet<Byte2ShortMap.Entry> byte2ShortEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Short>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMaps.EmptyMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        public ByteSortedSet keySet() {
            return ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap subMap(byte from, byte to) {
            return Byte2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap headMap(byte to) {
            return Byte2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap tailMap(byte from) {
            return Byte2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public byte firstByteKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public byte lastByteKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        @Deprecated
        public Byte2ShortSortedMap headMap(Byte oto) {
            return headMap(oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        @Deprecated
        public Byte2ShortSortedMap tailMap(Byte ofrom) {
            return tailMap(ofrom.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        @Deprecated
        public Byte2ShortSortedMap subMap(Byte ofrom, Byte oto) {
            return subMap(ofrom.byteValue(), oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return Byte.valueOf(firstByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return Byte.valueOf(lastByteKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortSortedMaps$Singleton.class */
    public static class Singleton extends Byte2ShortMaps.Singleton implements Byte2ShortSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteComparator comparator;

        protected Singleton(byte key, short value, ByteComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(byte key, short value) {
            this(key, value, null);
        }

        final int compare(byte k1, byte k2) {
            return this.comparator == null ? Byte.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public ObjectSortedSet<Byte2ShortMap.Entry> byte2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractByte2ShortMap.BasicEntry(this.key, this.value), Byte2ShortSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Short>> entrySet() {
            return byte2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.singleton(this.key, this.comparator);
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap subMap(byte from, byte to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Byte2ShortSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap headMap(byte to) {
            return compare(this.key, to) < 0 ? this : Byte2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap tailMap(byte from) {
            return compare(from, this.key) <= 0 ? this : Byte2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public byte firstByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public byte lastByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        @Deprecated
        public Byte2ShortSortedMap headMap(Byte oto) {
            return headMap(oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        @Deprecated
        public Byte2ShortSortedMap tailMap(Byte ofrom) {
            return tailMap(ofrom.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        @Deprecated
        public Byte2ShortSortedMap subMap(Byte ofrom, Byte oto) {
            return subMap(ofrom.byteValue(), oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return Byte.valueOf(firstByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return Byte.valueOf(lastByteKey());
        }
    }

    public static Byte2ShortSortedMap singleton(Byte key, Short value) {
        return new Singleton(key.byteValue(), value.shortValue());
    }

    public static Byte2ShortSortedMap singleton(Byte key, Short value, ByteComparator comparator) {
        return new Singleton(key.byteValue(), value.shortValue(), comparator);
    }

    public static Byte2ShortSortedMap singleton(byte key, short value) {
        return new Singleton(key, value);
    }

    public static Byte2ShortSortedMap singleton(byte key, short value, ByteComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Byte2ShortMaps.SynchronizedMap implements Byte2ShortSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2ShortSortedMap sortedMap;

        protected SynchronizedSortedMap(Byte2ShortSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Byte2ShortSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            Comparator<? super Byte> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public ObjectSortedSet<Byte2ShortMap.Entry> byte2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.byte2ShortEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Short>> entrySet() {
            return byte2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap subMap(byte from, byte to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap headMap(byte to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap tailMap(byte from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public byte firstByteKey() {
            byte firstByteKey;
            synchronized (this.sync) {
                firstByteKey = this.sortedMap.firstByteKey();
            }
            return firstByteKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public byte lastByteKey() {
            byte lastByteKey;
            synchronized (this.sync) {
                lastByteKey = this.sortedMap.lastByteKey();
            }
            return lastByteKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            Byte firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            Byte lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        @Deprecated
        public Byte2ShortSortedMap subMap(Byte from, Byte to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        @Deprecated
        public Byte2ShortSortedMap headMap(Byte to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        @Deprecated
        public Byte2ShortSortedMap tailMap(Byte from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Byte2ShortSortedMap synchronize(Byte2ShortSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Byte2ShortSortedMap synchronize(Byte2ShortSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Byte2ShortMaps.UnmodifiableMap implements Byte2ShortSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2ShortSortedMap sortedMap;

        protected UnmodifiableSortedMap(Byte2ShortSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public ObjectSortedSet<Byte2ShortMap.Entry> byte2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.byte2ShortEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Short>> entrySet() {
            return byte2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap subMap(byte from, byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap headMap(byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap tailMap(byte from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public byte firstByteKey() {
            return this.sortedMap.firstByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public byte lastByteKey() {
            return this.sortedMap.lastByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        @Deprecated
        public Byte2ShortSortedMap subMap(Byte from, Byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        @Deprecated
        public Byte2ShortSortedMap headMap(Byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        @Deprecated
        public Byte2ShortSortedMap tailMap(Byte from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Byte2ShortSortedMap unmodifiable(Byte2ShortSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
