package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanArrays;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2BooleanMap;
import p014it.unimi.dsi.fastutil.longs.Long2BooleanMap;
import p014it.unimi.dsi.fastutil.longs.LongSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanArrayMap.class */
public class Long2BooleanArrayMap extends AbstractLong2BooleanMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient long[] key;
    private transient boolean[] value;
    private int size;
    private transient Long2BooleanMap.FastEntrySet entries;
    private transient LongSet keys;
    private transient BooleanCollection values;

    static /* synthetic */ int access$010(Long2BooleanArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Long2BooleanArrayMap(long[] key, boolean[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Long2BooleanArrayMap() {
        this.key = LongArrays.EMPTY_ARRAY;
        this.value = BooleanArrays.EMPTY_ARRAY;
    }

    public Long2BooleanArrayMap(int capacity) {
        this.key = new long[capacity];
        this.value = new boolean[capacity];
    }

    public Long2BooleanArrayMap(Long2BooleanMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Long2BooleanMap.Entry> it = m.long2BooleanEntrySet().iterator();
        while (it.hasNext()) {
            Long2BooleanMap.Entry e = it.next();
            this.key[i] = e.getLongKey();
            this.value[i] = e.getBooleanValue();
            i++;
        }
        this.size = i;
    }

    public Long2BooleanArrayMap(Map<? extends Long, ? extends Boolean> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Long, ? extends Boolean> e : m.entrySet()) {
            this.key[i] = ((Long) e.getKey()).longValue();
            this.value[i] = ((Boolean) e.getValue()).booleanValue();
            i++;
        }
        this.size = i;
    }

    public Long2BooleanArrayMap(long[] key, boolean[] value, int size) {
        this.key = key;
        this.value = value;
        this.size = size;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        } else if (size > key.length) {
            throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the backing-arrays size (" + key.length + ")");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Long2BooleanMap.Entry> implements Long2BooleanMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Long2BooleanMap.Entry> iterator() {
            return new ObjectIterator<Long2BooleanMap.Entry>() { // from class: it.unimi.dsi.fastutil.longs.Long2BooleanArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Long2BooleanArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Long2BooleanMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    long[] jArr = Long2BooleanArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    long j = jArr[i];
                    boolean[] zArr = Long2BooleanArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractLong2BooleanMap.BasicEntry(j, zArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Long2BooleanArrayMap.access$010(Long2BooleanArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Long2BooleanArrayMap.this.key, this.next + 1, Long2BooleanArrayMap.this.key, this.next, tail);
                    System.arraycopy(Long2BooleanArrayMap.this.value, this.next + 1, Long2BooleanArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Long2BooleanMap.Entry> action) {
                    int max = Long2BooleanArrayMap.this.size;
                    while (this.next < max) {
                        long[] jArr = Long2BooleanArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        long j = jArr[i];
                        boolean[] zArr = Long2BooleanArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractLong2BooleanMap.BasicEntry(j, zArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap.FastEntrySet
        public ObjectIterator<Long2BooleanMap.Entry> fastIterator() {
            return new ObjectIterator<Long2BooleanMap.Entry>() { // from class: it.unimi.dsi.fastutil.longs.Long2BooleanArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractLong2BooleanMap.BasicEntry entry = new AbstractLong2BooleanMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Long2BooleanArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Long2BooleanMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractLong2BooleanMap.BasicEntry basicEntry = this.entry;
                    long[] jArr = Long2BooleanArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = jArr[i];
                    AbstractLong2BooleanMap.BasicEntry basicEntry2 = this.entry;
                    boolean[] zArr = Long2BooleanArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = zArr[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Long2BooleanArrayMap.access$010(Long2BooleanArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Long2BooleanArrayMap.this.key, this.next + 1, Long2BooleanArrayMap.this.key, this.next, tail);
                    System.arraycopy(Long2BooleanArrayMap.this.value, this.next + 1, Long2BooleanArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Long2BooleanMap.Entry> action) {
                    int max = Long2BooleanArrayMap.this.size;
                    while (this.next < max) {
                        AbstractLong2BooleanMap.BasicEntry basicEntry = this.entry;
                        long[] jArr = Long2BooleanArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = jArr[i];
                        AbstractLong2BooleanMap.BasicEntry basicEntry2 = this.entry;
                        boolean[] zArr = Long2BooleanArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = zArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Long2BooleanMap.Entry> implements ObjectSpliterator<Long2BooleanMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Long2BooleanMap.Entry get(int location) {
                return new AbstractLong2BooleanMap.BasicEntry(Long2BooleanArrayMap.this.key[location], Long2BooleanArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Long2BooleanMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Long2BooleanArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Long2BooleanMap.Entry> action) {
            int max = Long2BooleanArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractLong2BooleanMap.BasicEntry(Long2BooleanArrayMap.this.key[i], Long2BooleanArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap.FastEntrySet
        public void fastForEach(Consumer<? super Long2BooleanMap.Entry> action) {
            AbstractLong2BooleanMap.BasicEntry entry = new AbstractLong2BooleanMap.BasicEntry();
            int max = Long2BooleanArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Long2BooleanArrayMap.this.key[i];
                entry.value = Long2BooleanArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Long2BooleanArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Long) || e.getValue() == null || !(e.getValue() instanceof Boolean)) {
                return false;
            }
            long k = ((Long) e.getKey()).longValue();
            return Long2BooleanArrayMap.this.containsKey(k) && Long2BooleanArrayMap.this.get(k) == ((Boolean) e.getValue()).booleanValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Long) || e.getValue() == null || !(e.getValue() instanceof Boolean)) {
                return false;
            }
            long k = ((Long) e.getKey()).longValue();
            boolean v = ((Boolean) e.getValue()).booleanValue();
            int oldPos = Long2BooleanArrayMap.this.findKey(k);
            if (oldPos == -1 || v != Long2BooleanArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Long2BooleanArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Long2BooleanArrayMap.this.key, oldPos + 1, Long2BooleanArrayMap.this.key, oldPos, tail);
            System.arraycopy(Long2BooleanArrayMap.this.value, oldPos + 1, Long2BooleanArrayMap.this.value, oldPos, tail);
            Long2BooleanArrayMap.access$010(Long2BooleanArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
    public Long2BooleanMap.FastEntrySet long2BooleanEntrySet() {
        if (this.entries == null) {
            this.entries = new EntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    public int findKey(long k) {
        long[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (key[i] != k);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanFunction
    public boolean get(long k) {
        long[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return this.defRetValue;
            }
        } while (key[i] != k);
        return this.value[i];
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public void clear() {
        this.size = 0;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2BooleanMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanFunction, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap
    public boolean containsKey(long k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2BooleanMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap
    public boolean containsValue(boolean v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (this.value[i] != v);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2BooleanMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanFunction
    public boolean put(long k, boolean v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            boolean oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            long[] newKey = new long[this.size == 0 ? 2 : this.size * 2];
            boolean[] newValue = new boolean[this.size == 0 ? 2 : this.size * 2];
            int i = this.size;
            while (true) {
                i--;
                if (i == 0) {
                    break;
                }
                newKey[i] = this.key[i];
                newValue[i] = this.value[i];
            }
            this.key = newKey;
            this.value = newValue;
        }
        this.key[this.size] = k;
        this.value[this.size] = v;
        this.size++;
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanFunction
    public boolean remove(long k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        boolean oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanArrayMap$KeySet.class */
    public final class KeySet extends AbstractLongSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return Long2BooleanArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.LongSet
        public boolean remove(long k) {
            int oldPos = Long2BooleanArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Long2BooleanArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Long2BooleanArrayMap.this.key, oldPos + 1, Long2BooleanArrayMap.this.key, oldPos, tail);
            System.arraycopy(Long2BooleanArrayMap.this.value, oldPos + 1, Long2BooleanArrayMap.this.value, oldPos, tail);
            Long2BooleanArrayMap.access$010(Long2BooleanArrayMap.this);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator iterator() {
            return new LongIterator() { // from class: it.unimi.dsi.fastutil.longs.Long2BooleanArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Long2BooleanArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
                public long nextLong() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    long[] jArr = Long2BooleanArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return jArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Long2BooleanArrayMap.this.size - this.pos;
                    System.arraycopy(Long2BooleanArrayMap.this.key, this.pos, Long2BooleanArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Long2BooleanArrayMap.this.value, this.pos, Long2BooleanArrayMap.this.value, this.pos - 1, tail);
                    Long2BooleanArrayMap.access$010(Long2BooleanArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfLong
                public void forEachRemaining(LongConsumer action) {
                    int max = Long2BooleanArrayMap.this.size;
                    while (this.pos < max) {
                        long[] jArr = Long2BooleanArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(jArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanArrayMap$KeySet$KeySetSpliterator.class */
        public final class KeySetSpliterator extends LongSpliterators.EarlyBindingSizeIndexBasedSpliterator implements LongSpliterator {
            KeySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16721;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
            protected final long get(int location) {
                return Long2BooleanArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfLong
            public void forEachRemaining(LongConsumer action) {
                int max = Long2BooleanArrayMap.this.size;
                while (this.pos < max) {
                    long[] jArr = Long2BooleanArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(jArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return new KeySetSpliterator(0, Long2BooleanArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
        public void forEach(LongConsumer action) {
            int max = Long2BooleanArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Long2BooleanArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Long2BooleanArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Long2BooleanArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2BooleanMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
    public Set<Long> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractBooleanCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean contains(boolean v) {
            return Long2BooleanArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanIterator iterator() {
            return new BooleanIterator() { // from class: it.unimi.dsi.fastutil.longs.Long2BooleanArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Long2BooleanArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                public boolean nextBoolean() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    boolean[] zArr = Long2BooleanArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return zArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Long2BooleanArrayMap.this.size - this.pos;
                    System.arraycopy(Long2BooleanArrayMap.this.key, this.pos, Long2BooleanArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Long2BooleanArrayMap.this.value, this.pos, Long2BooleanArrayMap.this.value, this.pos - 1, tail);
                    Long2BooleanArrayMap.access$010(Long2BooleanArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                public void forEachRemaining(BooleanConsumer action) {
                    int max = Long2BooleanArrayMap.this.size;
                    while (this.pos < max) {
                        boolean[] zArr = Long2BooleanArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(zArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanArrayMap$ValuesCollection$ValuesSpliterator.class */
        public final class ValuesSpliterator extends BooleanSpliterators.EarlyBindingSizeIndexBasedSpliterator implements BooleanSpliterator {
            ValuesSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16720;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
            protected final boolean get(int location) {
                return Long2BooleanArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(BooleanConsumer action) {
                int max = Long2BooleanArrayMap.this.size;
                while (this.pos < max) {
                    boolean[] zArr = Long2BooleanArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(zArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanSpliterator spliterator() {
            return new ValuesSpliterator(0, Long2BooleanArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterable
        public void forEach(BooleanConsumer action) {
            int max = Long2BooleanArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Long2BooleanArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Long2BooleanArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Long2BooleanArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2BooleanMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
    public Collection<Boolean> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Long2BooleanArrayMap clone() {
        try {
            Long2BooleanArrayMap c = (Long2BooleanArrayMap) clone();
            c.key = (long[]) this.key.clone();
            c.value = (boolean[]) this.value.clone();
            c.entries = null;
            c.keys = null;
            c.values = null;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        int max = this.size;
        for (int i = 0; i < max; i++) {
            s.writeLong(this.key[i]);
            s.writeBoolean(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new long[this.size];
        this.value = new boolean[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readLong();
            this.value[i] = s.readBoolean();
        }
    }
}
