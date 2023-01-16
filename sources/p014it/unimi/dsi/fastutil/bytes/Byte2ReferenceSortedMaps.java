package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMaps;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceSortedMaps.class */
public final class Byte2ReferenceSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Byte2ReferenceSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Byte, ?>> entryComparator(ByteComparator comparator) {
        return x, y -> {
            return comparator.compare(((Byte) x.getKey()).byteValue(), ((Byte) y.getKey()).byteValue());
        };
    }

    public static <V> ObjectBidirectionalIterator<Byte2ReferenceMap.Entry<V>> fastIterator(Byte2ReferenceSortedMap<V> map) {
        ObjectSortedSet<Byte2ReferenceMap.Entry<V>> entries = map.byte2ReferenceEntrySet();
        return entries instanceof Byte2ReferenceSortedMap.FastSortedEntrySet ? ((Byte2ReferenceSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> ObjectBidirectionalIterable<Byte2ReferenceMap.Entry<V>> fastIterable(Byte2ReferenceSortedMap<V> map) {
        ObjectSortedSet<Byte2ReferenceMap.Entry<V>> entries = map.byte2ReferenceEntrySet();
        if (!(entries instanceof Byte2ReferenceSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Byte2ReferenceSortedMap.FastSortedEntrySet fastSortedEntrySet = (Byte2ReferenceSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<V> extends Byte2ReferenceMaps.EmptyMap<V> implements Byte2ReferenceSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMaps.EmptyMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public ObjectSortedSet<Byte2ReferenceMap.Entry<V>> byte2ReferenceEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, V>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMaps.EmptyMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
        public ByteSortedSet keySet() {
            return ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public Byte2ReferenceSortedMap<V> subMap(byte from, byte to) {
            return Byte2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public Byte2ReferenceSortedMap<V> headMap(byte to) {
            return Byte2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public Byte2ReferenceSortedMap<V> tailMap(byte from) {
            return Byte2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public byte firstByteKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public byte lastByteKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        @Deprecated
        public Byte2ReferenceSortedMap<V> headMap(Byte oto) {
            return headMap(oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        @Deprecated
        public Byte2ReferenceSortedMap<V> tailMap(Byte ofrom) {
            return tailMap(ofrom.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        @Deprecated
        public Byte2ReferenceSortedMap<V> subMap(Byte ofrom, Byte oto) {
            return subMap(ofrom.byteValue(), oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return Byte.valueOf(firstByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return Byte.valueOf(lastByteKey());
        }
    }

    public static <V> Byte2ReferenceSortedMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceSortedMaps$Singleton.class */
    public static class Singleton<V> extends Byte2ReferenceMaps.Singleton<V> implements Byte2ReferenceSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteComparator comparator;

        protected Singleton(byte key, V value, ByteComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(byte key, V value) {
            this(key, value, null);
        }

        final int compare(byte k1, byte k2) {
            return this.comparator == null ? Byte.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public ObjectSortedSet<Byte2ReferenceMap.Entry<V>> byte2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractByte2ReferenceMap.BasicEntry(this.key, this.value), Byte2ReferenceSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, V>> entrySet() {
            return byte2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.singleton(this.key, this.comparator);
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public Byte2ReferenceSortedMap<V> subMap(byte from, byte to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Byte2ReferenceSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public Byte2ReferenceSortedMap<V> headMap(byte to) {
            return compare(this.key, to) < 0 ? this : Byte2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public Byte2ReferenceSortedMap<V> tailMap(byte from) {
            return compare(from, this.key) <= 0 ? this : Byte2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public byte firstByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public byte lastByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        @Deprecated
        public Byte2ReferenceSortedMap<V> headMap(Byte oto) {
            return headMap(oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        @Deprecated
        public Byte2ReferenceSortedMap<V> tailMap(Byte ofrom) {
            return tailMap(ofrom.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        @Deprecated
        public Byte2ReferenceSortedMap<V> subMap(Byte ofrom, Byte oto) {
            return subMap(ofrom.byteValue(), oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return Byte.valueOf(firstByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return Byte.valueOf(lastByteKey());
        }
    }

    public static <V> Byte2ReferenceSortedMap<V> singleton(Byte key, V value) {
        return new Singleton(key.byteValue(), value);
    }

    public static <V> Byte2ReferenceSortedMap<V> singleton(Byte key, V value, ByteComparator comparator) {
        return new Singleton(key.byteValue(), value, comparator);
    }

    public static <V> Byte2ReferenceSortedMap<V> singleton(byte key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Byte2ReferenceSortedMap<V> singleton(byte key, V value, ByteComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<V> extends Byte2ReferenceMaps.SynchronizedMap<V> implements Byte2ReferenceSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2ReferenceSortedMap<V> sortedMap;

        protected SynchronizedSortedMap(Byte2ReferenceSortedMap<V> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Byte2ReferenceSortedMap<V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            Comparator<? super Byte> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public ObjectSortedSet<Byte2ReferenceMap.Entry<V>> byte2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.byte2ReferenceEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, V>> entrySet() {
            return byte2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public Byte2ReferenceSortedMap<V> subMap(byte from, byte to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public Byte2ReferenceSortedMap<V> headMap(byte to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public Byte2ReferenceSortedMap<V> tailMap(byte from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public byte firstByteKey() {
            byte firstByteKey;
            synchronized (this.sync) {
                firstByteKey = this.sortedMap.firstByteKey();
            }
            return firstByteKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public byte lastByteKey() {
            byte lastByteKey;
            synchronized (this.sync) {
                lastByteKey = this.sortedMap.lastByteKey();
            }
            return lastByteKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            Byte firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            Byte lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        @Deprecated
        public Byte2ReferenceSortedMap<V> subMap(Byte from, Byte to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        @Deprecated
        public Byte2ReferenceSortedMap<V> headMap(Byte to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        @Deprecated
        public Byte2ReferenceSortedMap<V> tailMap(Byte from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static <V> Byte2ReferenceSortedMap<V> synchronize(Byte2ReferenceSortedMap<V> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <V> Byte2ReferenceSortedMap<V> synchronize(Byte2ReferenceSortedMap<V> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<V> extends Byte2ReferenceMaps.UnmodifiableMap<V> implements Byte2ReferenceSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2ReferenceSortedMap<? extends V> sortedMap;

        protected UnmodifiableSortedMap(Byte2ReferenceSortedMap<? extends V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public ObjectSortedSet<Byte2ReferenceMap.Entry<V>> byte2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.byte2ReferenceEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, V>> entrySet() {
            return byte2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public Byte2ReferenceSortedMap<V> subMap(byte from, byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public Byte2ReferenceSortedMap<V> headMap(byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public Byte2ReferenceSortedMap<V> tailMap(byte from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public byte firstByteKey() {
            return this.sortedMap.firstByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        public byte lastByteKey() {
            return this.sortedMap.lastByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        @Deprecated
        public Byte2ReferenceSortedMap<V> subMap(Byte from, Byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        @Deprecated
        public Byte2ReferenceSortedMap<V> headMap(Byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
        @Deprecated
        public Byte2ReferenceSortedMap<V> tailMap(Byte from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static <V> Byte2ReferenceSortedMap<V> unmodifiable(Byte2ReferenceSortedMap<? extends V> m) {
        return new UnmodifiableSortedMap(m);
    }
}
