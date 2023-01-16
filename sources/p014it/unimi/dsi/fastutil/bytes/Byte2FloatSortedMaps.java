package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2FloatMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatMaps;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatSortedMaps.class */
public final class Byte2FloatSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Byte2FloatSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Byte, ?>> entryComparator(ByteComparator comparator) {
        return x, y -> {
            return comparator.compare(((Byte) x.getKey()).byteValue(), ((Byte) y.getKey()).byteValue());
        };
    }

    public static ObjectBidirectionalIterator<Byte2FloatMap.Entry> fastIterator(Byte2FloatSortedMap map) {
        ObjectSortedSet<Byte2FloatMap.Entry> entries = map.byte2FloatEntrySet();
        return entries instanceof Byte2FloatSortedMap.FastSortedEntrySet ? ((Byte2FloatSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Byte2FloatMap.Entry> fastIterable(Byte2FloatSortedMap map) {
        ObjectSortedSet<Byte2FloatMap.Entry> entries = map.byte2FloatEntrySet();
        if (!(entries instanceof Byte2FloatSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Byte2FloatSortedMap.FastSortedEntrySet fastSortedEntrySet = (Byte2FloatSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Byte2FloatMaps.EmptyMap implements Byte2FloatSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMaps.EmptyMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public ObjectSortedSet<Byte2FloatMap.Entry> byte2FloatEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Float>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMaps.EmptyMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
        public ByteSortedSet keySet() {
            return ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public Byte2FloatSortedMap subMap(byte from, byte to) {
            return Byte2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public Byte2FloatSortedMap headMap(byte to) {
            return Byte2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public Byte2FloatSortedMap tailMap(byte from) {
            return Byte2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public byte firstByteKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public byte lastByteKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        @Deprecated
        public Byte2FloatSortedMap headMap(Byte oto) {
            return headMap(oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        @Deprecated
        public Byte2FloatSortedMap tailMap(Byte ofrom) {
            return tailMap(ofrom.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        @Deprecated
        public Byte2FloatSortedMap subMap(Byte ofrom, Byte oto) {
            return subMap(ofrom.byteValue(), oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return Byte.valueOf(firstByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return Byte.valueOf(lastByteKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatSortedMaps$Singleton.class */
    public static class Singleton extends Byte2FloatMaps.Singleton implements Byte2FloatSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteComparator comparator;

        protected Singleton(byte key, float value, ByteComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(byte key, float value) {
            this(key, value, null);
        }

        final int compare(byte k1, byte k2) {
            return this.comparator == null ? Byte.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public ObjectSortedSet<Byte2FloatMap.Entry> byte2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractByte2FloatMap.BasicEntry(this.key, this.value), Byte2FloatSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Float>> entrySet() {
            return byte2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.singleton(this.key, this.comparator);
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public Byte2FloatSortedMap subMap(byte from, byte to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Byte2FloatSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public Byte2FloatSortedMap headMap(byte to) {
            return compare(this.key, to) < 0 ? this : Byte2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public Byte2FloatSortedMap tailMap(byte from) {
            return compare(from, this.key) <= 0 ? this : Byte2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public byte firstByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public byte lastByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        @Deprecated
        public Byte2FloatSortedMap headMap(Byte oto) {
            return headMap(oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        @Deprecated
        public Byte2FloatSortedMap tailMap(Byte ofrom) {
            return tailMap(ofrom.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        @Deprecated
        public Byte2FloatSortedMap subMap(Byte ofrom, Byte oto) {
            return subMap(ofrom.byteValue(), oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return Byte.valueOf(firstByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return Byte.valueOf(lastByteKey());
        }
    }

    public static Byte2FloatSortedMap singleton(Byte key, Float value) {
        return new Singleton(key.byteValue(), value.floatValue());
    }

    public static Byte2FloatSortedMap singleton(Byte key, Float value, ByteComparator comparator) {
        return new Singleton(key.byteValue(), value.floatValue(), comparator);
    }

    public static Byte2FloatSortedMap singleton(byte key, float value) {
        return new Singleton(key, value);
    }

    public static Byte2FloatSortedMap singleton(byte key, float value, ByteComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Byte2FloatMaps.SynchronizedMap implements Byte2FloatSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2FloatSortedMap sortedMap;

        protected SynchronizedSortedMap(Byte2FloatSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Byte2FloatSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            Comparator<? super Byte> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public ObjectSortedSet<Byte2FloatMap.Entry> byte2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.byte2FloatEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Float>> entrySet() {
            return byte2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public Byte2FloatSortedMap subMap(byte from, byte to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public Byte2FloatSortedMap headMap(byte to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public Byte2FloatSortedMap tailMap(byte from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public byte firstByteKey() {
            byte firstByteKey;
            synchronized (this.sync) {
                firstByteKey = this.sortedMap.firstByteKey();
            }
            return firstByteKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public byte lastByteKey() {
            byte lastByteKey;
            synchronized (this.sync) {
                lastByteKey = this.sortedMap.lastByteKey();
            }
            return lastByteKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            Byte firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            Byte lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        @Deprecated
        public Byte2FloatSortedMap subMap(Byte from, Byte to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        @Deprecated
        public Byte2FloatSortedMap headMap(Byte to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        @Deprecated
        public Byte2FloatSortedMap tailMap(Byte from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Byte2FloatSortedMap synchronize(Byte2FloatSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Byte2FloatSortedMap synchronize(Byte2FloatSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Byte2FloatMaps.UnmodifiableMap implements Byte2FloatSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2FloatSortedMap sortedMap;

        protected UnmodifiableSortedMap(Byte2FloatSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public ObjectSortedSet<Byte2FloatMap.Entry> byte2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.byte2FloatEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Float>> entrySet() {
            return byte2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public Byte2FloatSortedMap subMap(byte from, byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public Byte2FloatSortedMap headMap(byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public Byte2FloatSortedMap tailMap(byte from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public byte firstByteKey() {
            return this.sortedMap.firstByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        public byte lastByteKey() {
            return this.sortedMap.lastByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        @Deprecated
        public Byte2FloatSortedMap subMap(Byte from, Byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        @Deprecated
        public Byte2FloatSortedMap headMap(Byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
        @Deprecated
        public Byte2FloatSortedMap tailMap(Byte from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Byte2FloatSortedMap unmodifiable(Byte2FloatSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
