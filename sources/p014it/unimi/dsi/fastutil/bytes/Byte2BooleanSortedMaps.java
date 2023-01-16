package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2BooleanMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanSortedMaps.class */
public final class Byte2BooleanSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Byte2BooleanSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Byte, ?>> entryComparator(ByteComparator comparator) {
        return x, y -> {
            return comparator.compare(((Byte) x.getKey()).byteValue(), ((Byte) y.getKey()).byteValue());
        };
    }

    public static ObjectBidirectionalIterator<Byte2BooleanMap.Entry> fastIterator(Byte2BooleanSortedMap map) {
        ObjectSortedSet<Byte2BooleanMap.Entry> entries = map.byte2BooleanEntrySet();
        return entries instanceof Byte2BooleanSortedMap.FastSortedEntrySet ? ((Byte2BooleanSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Byte2BooleanMap.Entry> fastIterable(Byte2BooleanSortedMap map) {
        ObjectSortedSet<Byte2BooleanMap.Entry> entries = map.byte2BooleanEntrySet();
        if (!(entries instanceof Byte2BooleanSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Byte2BooleanSortedMap.FastSortedEntrySet fastSortedEntrySet = (Byte2BooleanSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Byte2BooleanMaps.EmptyMap implements Byte2BooleanSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public ObjectSortedSet<Byte2BooleanMap.Entry> byte2BooleanEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Boolean>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public ByteSortedSet keySet() {
            return ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public Byte2BooleanSortedMap subMap(byte from, byte to) {
            return Byte2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public Byte2BooleanSortedMap headMap(byte to) {
            return Byte2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public Byte2BooleanSortedMap tailMap(byte from) {
            return Byte2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public byte firstByteKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public byte lastByteKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        @Deprecated
        public Byte2BooleanSortedMap headMap(Byte oto) {
            return headMap(oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        @Deprecated
        public Byte2BooleanSortedMap tailMap(Byte ofrom) {
            return tailMap(ofrom.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        @Deprecated
        public Byte2BooleanSortedMap subMap(Byte ofrom, Byte oto) {
            return subMap(ofrom.byteValue(), oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return Byte.valueOf(firstByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return Byte.valueOf(lastByteKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanSortedMaps$Singleton.class */
    public static class Singleton extends Byte2BooleanMaps.Singleton implements Byte2BooleanSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteComparator comparator;

        protected Singleton(byte key, boolean value, ByteComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(byte key, boolean value) {
            this(key, value, null);
        }

        final int compare(byte k1, byte k2) {
            return this.comparator == null ? Byte.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public ObjectSortedSet<Byte2BooleanMap.Entry> byte2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractByte2BooleanMap.BasicEntry(this.key, this.value), Byte2BooleanSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Boolean>> entrySet() {
            return byte2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.singleton(this.key, this.comparator);
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public Byte2BooleanSortedMap subMap(byte from, byte to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Byte2BooleanSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public Byte2BooleanSortedMap headMap(byte to) {
            return compare(this.key, to) < 0 ? this : Byte2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public Byte2BooleanSortedMap tailMap(byte from) {
            return compare(from, this.key) <= 0 ? this : Byte2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public byte firstByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public byte lastByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        @Deprecated
        public Byte2BooleanSortedMap headMap(Byte oto) {
            return headMap(oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        @Deprecated
        public Byte2BooleanSortedMap tailMap(Byte ofrom) {
            return tailMap(ofrom.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        @Deprecated
        public Byte2BooleanSortedMap subMap(Byte ofrom, Byte oto) {
            return subMap(ofrom.byteValue(), oto.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return Byte.valueOf(firstByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return Byte.valueOf(lastByteKey());
        }
    }

    public static Byte2BooleanSortedMap singleton(Byte key, Boolean value) {
        return new Singleton(key.byteValue(), value.booleanValue());
    }

    public static Byte2BooleanSortedMap singleton(Byte key, Boolean value, ByteComparator comparator) {
        return new Singleton(key.byteValue(), value.booleanValue(), comparator);
    }

    public static Byte2BooleanSortedMap singleton(byte key, boolean value) {
        return new Singleton(key, value);
    }

    public static Byte2BooleanSortedMap singleton(byte key, boolean value, ByteComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Byte2BooleanMaps.SynchronizedMap implements Byte2BooleanSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2BooleanSortedMap sortedMap;

        protected SynchronizedSortedMap(Byte2BooleanSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Byte2BooleanSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            Comparator<? super Byte> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public ObjectSortedSet<Byte2BooleanMap.Entry> byte2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.byte2BooleanEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Boolean>> entrySet() {
            return byte2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public Byte2BooleanSortedMap subMap(byte from, byte to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public Byte2BooleanSortedMap headMap(byte to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public Byte2BooleanSortedMap tailMap(byte from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public byte firstByteKey() {
            byte firstByteKey;
            synchronized (this.sync) {
                firstByteKey = this.sortedMap.firstByteKey();
            }
            return firstByteKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public byte lastByteKey() {
            byte lastByteKey;
            synchronized (this.sync) {
                lastByteKey = this.sortedMap.lastByteKey();
            }
            return lastByteKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            Byte firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            Byte lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        @Deprecated
        public Byte2BooleanSortedMap subMap(Byte from, Byte to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        @Deprecated
        public Byte2BooleanSortedMap headMap(Byte to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        @Deprecated
        public Byte2BooleanSortedMap tailMap(Byte from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Byte2BooleanSortedMap synchronize(Byte2BooleanSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Byte2BooleanSortedMap synchronize(Byte2BooleanSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Byte2BooleanMaps.UnmodifiableMap implements Byte2BooleanSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2BooleanSortedMap sortedMap;

        protected UnmodifiableSortedMap(Byte2BooleanSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public ObjectSortedSet<Byte2BooleanMap.Entry> byte2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.byte2BooleanEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Byte, Boolean>> entrySet() {
            return byte2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ByteSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ByteSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public Byte2BooleanSortedMap subMap(byte from, byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public Byte2BooleanSortedMap headMap(byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public Byte2BooleanSortedMap tailMap(byte from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public byte firstByteKey() {
            return this.sortedMap.firstByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public byte lastByteKey() {
            return this.sortedMap.lastByteKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Byte firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Byte lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        @Deprecated
        public Byte2BooleanSortedMap subMap(Byte from, Byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        @Deprecated
        public Byte2BooleanSortedMap headMap(Byte to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        @Deprecated
        public Byte2BooleanSortedMap tailMap(Byte from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Byte2BooleanSortedMap unmodifiable(Byte2BooleanSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
