package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2DoubleMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMaps;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2DoubleSortedMaps.class */
public final class Byte2DoubleSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Byte2DoubleSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Byte, ?>> entryComparator(ByteComparator comparator) {
        return x, y -> {
            return comparator.compare(((Byte) x.getKey()).byteValue(), ((Byte) y.getKey()).byteValue());
        };
    }

    public static ObjectBidirectionalIterator<Byte2DoubleMap.Entry> fastIterator(Byte2DoubleSortedMap map) {
        ObjectSortedSet<Byte2DoubleMap.Entry> entries = map.byte2DoubleEntrySet();
        return entries instanceof Byte2DoubleSortedMap.FastSortedEntrySet ? ((Byte2DoubleSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Byte2DoubleMap.Entry> fastIterable(Byte2DoubleSortedMap map) {
        ObjectSortedSet<Byte2DoubleMap.Entry> entries = map.byte2DoubleEntrySet();
        if (!(entries instanceof Byte2DoubleSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Byte2DoubleSortedMap.FastSortedEntrySet fastSortedEntrySet = (Byte2DoubleSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2DoubleSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Byte2DoubleMaps.EmptyMap implements Byte2DoubleSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public ObjectSortedSet<Byte2DoubleMap.Entry> byte2DoubleEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Double>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, java.util.Map
        public ByteSortedSet keySet() {
            return ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public Byte2DoubleSortedMap subMap(byte from, byte to) {
            return Byte2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public Byte2DoubleSortedMap headMap(byte to) {
            return Byte2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public Byte2DoubleSortedMap tailMap(byte from) {
            return Byte2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public byte firstByteKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public byte lastByteKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        @Deprecated
        public Byte2DoubleSortedMap headMap(Byte oto) {
            return headMap(oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        @Deprecated
        public Byte2DoubleSortedMap tailMap(Byte ofrom) {
            return tailMap(ofrom.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        @Deprecated
        public Byte2DoubleSortedMap subMap(Byte ofrom, Byte oto) {
            return subMap(ofrom.byteValue(), oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return Byte.valueOf(firstByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return Byte.valueOf(lastByteKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2DoubleSortedMaps$Singleton.class */
    public static class Singleton extends Byte2DoubleMaps.Singleton implements Byte2DoubleSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteComparator comparator;

        protected Singleton(byte key, double value, ByteComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(byte key, double value) {
            this(key, value, null);
        }

        final int compare(byte k1, byte k2) {
            return this.comparator == null ? Byte.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public ObjectSortedSet<Byte2DoubleMap.Entry> byte2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractByte2DoubleMap.BasicEntry(this.key, this.value), Byte2DoubleSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Double>> entrySet() {
            return byte2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.singleton(this.key, this.comparator);
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public Byte2DoubleSortedMap subMap(byte from, byte to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Byte2DoubleSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public Byte2DoubleSortedMap headMap(byte to) {
            return compare(this.key, to) < 0 ? this : Byte2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public Byte2DoubleSortedMap tailMap(byte from) {
            return compare(from, this.key) <= 0 ? this : Byte2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public byte firstByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public byte lastByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        @Deprecated
        public Byte2DoubleSortedMap headMap(Byte oto) {
            return headMap(oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        @Deprecated
        public Byte2DoubleSortedMap tailMap(Byte ofrom) {
            return tailMap(ofrom.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        @Deprecated
        public Byte2DoubleSortedMap subMap(Byte ofrom, Byte oto) {
            return subMap(ofrom.byteValue(), oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return Byte.valueOf(firstByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return Byte.valueOf(lastByteKey());
        }
    }

    public static Byte2DoubleSortedMap singleton(Byte key, Double value) {
        return new Singleton(key.byteValue(), value.doubleValue());
    }

    public static Byte2DoubleSortedMap singleton(Byte key, Double value, ByteComparator comparator) {
        return new Singleton(key.byteValue(), value.doubleValue(), comparator);
    }

    public static Byte2DoubleSortedMap singleton(byte key, double value) {
        return new Singleton(key, value);
    }

    public static Byte2DoubleSortedMap singleton(byte key, double value, ByteComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2DoubleSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Byte2DoubleMaps.SynchronizedMap implements Byte2DoubleSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2DoubleSortedMap sortedMap;

        protected SynchronizedSortedMap(Byte2DoubleSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Byte2DoubleSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            Comparator<? super Byte> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public ObjectSortedSet<Byte2DoubleMap.Entry> byte2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.byte2DoubleEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Double>> entrySet() {
            return byte2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public Byte2DoubleSortedMap subMap(byte from, byte to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public Byte2DoubleSortedMap headMap(byte to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public Byte2DoubleSortedMap tailMap(byte from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public byte firstByteKey() {
            byte firstByteKey;
            synchronized (this.sync) {
                firstByteKey = this.sortedMap.firstByteKey();
            }
            return firstByteKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public byte lastByteKey() {
            byte lastByteKey;
            synchronized (this.sync) {
                lastByteKey = this.sortedMap.lastByteKey();
            }
            return lastByteKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            Byte firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            Byte lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        @Deprecated
        public Byte2DoubleSortedMap subMap(Byte from, Byte to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        @Deprecated
        public Byte2DoubleSortedMap headMap(Byte to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        @Deprecated
        public Byte2DoubleSortedMap tailMap(Byte from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Byte2DoubleSortedMap synchronize(Byte2DoubleSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Byte2DoubleSortedMap synchronize(Byte2DoubleSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2DoubleSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Byte2DoubleMaps.UnmodifiableMap implements Byte2DoubleSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2DoubleSortedMap sortedMap;

        protected UnmodifiableSortedMap(Byte2DoubleSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public ObjectSortedSet<Byte2DoubleMap.Entry> byte2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.byte2DoubleEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Double>> entrySet() {
            return byte2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public Byte2DoubleSortedMap subMap(byte from, byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public Byte2DoubleSortedMap headMap(byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public Byte2DoubleSortedMap tailMap(byte from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public byte firstByteKey() {
            return this.sortedMap.firstByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        public byte lastByteKey() {
            return this.sortedMap.lastByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        @Deprecated
        public Byte2DoubleSortedMap subMap(Byte from, Byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        @Deprecated
        public Byte2DoubleSortedMap headMap(Byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
        @Deprecated
        public Byte2DoubleSortedMap tailMap(Byte from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Byte2DoubleSortedMap unmodifiable(Byte2DoubleSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
