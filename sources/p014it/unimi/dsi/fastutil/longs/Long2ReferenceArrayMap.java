package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap;
import p014it.unimi.dsi.fastutil.longs.LongSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectArrays;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceArrayMap.class */
public class Long2ReferenceArrayMap<V> extends AbstractLong2ReferenceMap<V> implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient long[] key;
    private transient Object[] value;
    private int size;
    private transient Long2ReferenceMap.FastEntrySet<V> entries;
    private transient LongSet keys;
    private transient ReferenceCollection<V> values;

    static /* synthetic */ int access$010(Long2ReferenceArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Long2ReferenceArrayMap(long[] key, Object[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Long2ReferenceArrayMap() {
        this.key = LongArrays.EMPTY_ARRAY;
        this.value = ObjectArrays.EMPTY_ARRAY;
    }

    public Long2ReferenceArrayMap(int capacity) {
        this.key = new long[capacity];
        this.value = new Object[capacity];
    }

    public Long2ReferenceArrayMap(Long2ReferenceMap<V> m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Long2ReferenceMap.Entry<V>> it = m.long2ReferenceEntrySet().iterator();
        while (it.hasNext()) {
            Long2ReferenceMap.Entry<V> e = it.next();
            this.key[i] = e.getLongKey();
            this.value[i] = e.getValue();
            i++;
        }
        this.size = i;
    }

    public Long2ReferenceArrayMap(Map<? extends Long, ? extends V> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Long, ? extends V> e : m.entrySet()) {
            this.key[i] = ((Long) e.getKey()).longValue();
            this.value[i] = e.getValue();
            i++;
        }
        this.size = i;
    }

    public Long2ReferenceArrayMap(long[] key, Object[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Long2ReferenceMap.Entry<V>> implements Long2ReferenceMap.FastEntrySet<V> {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Long2ReferenceMap.Entry<V>> iterator() {
            return new ObjectIterator<Long2ReferenceMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.longs.Long2ReferenceArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Long2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Long2ReferenceMap.Entry<V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    long[] jArr = Long2ReferenceArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    long j = jArr[i];
                    Object[] objArr = Long2ReferenceArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractLong2ReferenceMap.BasicEntry(j, objArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Long2ReferenceArrayMap.access$010(Long2ReferenceArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Long2ReferenceArrayMap.this.key, this.next + 1, Long2ReferenceArrayMap.this.key, this.next, tail);
                    System.arraycopy(Long2ReferenceArrayMap.this.value, this.next + 1, Long2ReferenceArrayMap.this.value, this.next, tail);
                    Long2ReferenceArrayMap.this.value[Long2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Long2ReferenceMap.Entry<V>> action) {
                    int max = Long2ReferenceArrayMap.this.size;
                    while (this.next < max) {
                        long[] jArr = Long2ReferenceArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        long j = jArr[i];
                        Object[] objArr = Long2ReferenceArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractLong2ReferenceMap.BasicEntry(j, objArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap.FastEntrySet
        public ObjectIterator<Long2ReferenceMap.Entry<V>> fastIterator() {
            return new ObjectIterator<Long2ReferenceMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.longs.Long2ReferenceArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractLong2ReferenceMap.BasicEntry<V> entry = new AbstractLong2ReferenceMap.BasicEntry<>();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Long2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Long2ReferenceMap.Entry<V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractLong2ReferenceMap.BasicEntry<V> basicEntry = this.entry;
                    long[] jArr = Long2ReferenceArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = jArr[i];
                    AbstractLong2ReferenceMap.BasicEntry<V> basicEntry2 = this.entry;
                    Object[] objArr = Long2ReferenceArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = (V) objArr[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Long2ReferenceArrayMap.access$010(Long2ReferenceArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Long2ReferenceArrayMap.this.key, this.next + 1, Long2ReferenceArrayMap.this.key, this.next, tail);
                    System.arraycopy(Long2ReferenceArrayMap.this.value, this.next + 1, Long2ReferenceArrayMap.this.value, this.next, tail);
                    Long2ReferenceArrayMap.this.value[Long2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Long2ReferenceMap.Entry<V>> action) {
                    int max = Long2ReferenceArrayMap.this.size;
                    while (this.next < max) {
                        AbstractLong2ReferenceMap.BasicEntry<V> basicEntry = this.entry;
                        long[] jArr = Long2ReferenceArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = jArr[i];
                        AbstractLong2ReferenceMap.BasicEntry<V> basicEntry2 = this.entry;
                        Object[] objArr = Long2ReferenceArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = (V) objArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Long2ReferenceMap.Entry<V>> implements ObjectSpliterator<Long2ReferenceMap.Entry<V>> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Long2ReferenceMap.Entry<V> get(int location) {
                return new AbstractLong2ReferenceMap.BasicEntry(Long2ReferenceArrayMap.this.key[location], Long2ReferenceArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Long2ReferenceArrayMap<V>.EntrySet.EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Long2ReferenceMap.Entry<V>> spliterator() {
            return new EntrySetSpliterator(0, Long2ReferenceArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Long2ReferenceMap.Entry<V>> action) {
            int max = Long2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractLong2ReferenceMap.BasicEntry(Long2ReferenceArrayMap.this.key[i], Long2ReferenceArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap.FastEntrySet
        public void fastForEach(Consumer<? super Long2ReferenceMap.Entry<V>> action) {
            AbstractLong2ReferenceMap.BasicEntry<V> entry = new AbstractLong2ReferenceMap.BasicEntry<>();
            int max = Long2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Long2ReferenceArrayMap.this.key[i];
                entry.value = (V) Long2ReferenceArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Long2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Long)) {
                return false;
            }
            long k = ((Long) e.getKey()).longValue();
            return Long2ReferenceArrayMap.this.containsKey(k) && Long2ReferenceArrayMap.this.get(k) == e.getValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Long)) {
                return false;
            }
            long k = ((Long) e.getKey()).longValue();
            Object value = e.getValue();
            int oldPos = Long2ReferenceArrayMap.this.findKey(k);
            if (oldPos == -1 || value != Long2ReferenceArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Long2ReferenceArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Long2ReferenceArrayMap.this.key, oldPos + 1, Long2ReferenceArrayMap.this.key, oldPos, tail);
            System.arraycopy(Long2ReferenceArrayMap.this.value, oldPos + 1, Long2ReferenceArrayMap.this.value, oldPos, tail);
            Long2ReferenceArrayMap.access$010(Long2ReferenceArrayMap.this);
            Long2ReferenceArrayMap.this.value[Long2ReferenceArrayMap.this.size] = null;
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
    public Long2ReferenceMap.FastEntrySet<V> long2ReferenceEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
    public V get(long k) {
        long[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return (V) this.defRetValue;
            }
        } while (key[i] != k);
        return (V) this.value[i];
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public void clear() {
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                this.value[i] = null;
            } else {
                this.size = 0;
                return;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction, p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
    public boolean containsKey(long k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, java.util.Map
    public boolean containsValue(Object v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (this.value[i] != v);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
    public V put(long k, V v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            V oldValue = (V) this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            long[] newKey = new long[this.size == 0 ? 2 : this.size * 2];
            Object[] newValue = new Object[this.size == 0 ? 2 : this.size * 2];
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
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
    public V remove(long k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return (V) this.defRetValue;
        }
        V oldValue = (V) this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        this.value[this.size] = null;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceArrayMap$KeySet.class */
    public final class KeySet extends AbstractLongSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return Long2ReferenceArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.LongSet
        public boolean remove(long k) {
            int oldPos = Long2ReferenceArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Long2ReferenceArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Long2ReferenceArrayMap.this.key, oldPos + 1, Long2ReferenceArrayMap.this.key, oldPos, tail);
            System.arraycopy(Long2ReferenceArrayMap.this.value, oldPos + 1, Long2ReferenceArrayMap.this.value, oldPos, tail);
            Long2ReferenceArrayMap.access$010(Long2ReferenceArrayMap.this);
            Long2ReferenceArrayMap.this.value[Long2ReferenceArrayMap.this.size] = null;
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator iterator() {
            return new LongIterator() { // from class: it.unimi.dsi.fastutil.longs.Long2ReferenceArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Long2ReferenceArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
                public long nextLong() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    long[] jArr = Long2ReferenceArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return jArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Long2ReferenceArrayMap.this.size - this.pos;
                    System.arraycopy(Long2ReferenceArrayMap.this.key, this.pos, Long2ReferenceArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Long2ReferenceArrayMap.this.value, this.pos, Long2ReferenceArrayMap.this.value, this.pos - 1, tail);
                    Long2ReferenceArrayMap.access$010(Long2ReferenceArrayMap.this);
                    this.pos--;
                    Long2ReferenceArrayMap.this.value[Long2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.PrimitiveIterator.OfLong
                public void forEachRemaining(LongConsumer action) {
                    int max = Long2ReferenceArrayMap.this.size;
                    while (this.pos < max) {
                        long[] jArr = Long2ReferenceArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(jArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceArrayMap$KeySet$KeySetSpliterator.class */
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
                return Long2ReferenceArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
            public final Long2ReferenceArrayMap<V>.KeySet.KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfLong
            public void forEachRemaining(LongConsumer action) {
                int max = Long2ReferenceArrayMap.this.size;
                while (this.pos < max) {
                    long[] jArr = Long2ReferenceArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(jArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return new KeySetSpliterator(0, Long2ReferenceArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
        public void forEach(LongConsumer action) {
            int max = Long2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Long2ReferenceArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Long2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Long2ReferenceArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
    public Set<Long> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractReferenceCollection<V> {
        private ValuesCollection() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object v) {
            return Long2ReferenceArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectIterator<V> iterator() {
            return new ObjectIterator<V>() { // from class: it.unimi.dsi.fastutil.longs.Long2ReferenceArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Long2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public V next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Long2ReferenceArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return (V) objArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Long2ReferenceArrayMap.this.size - this.pos;
                    System.arraycopy(Long2ReferenceArrayMap.this.key, this.pos, Long2ReferenceArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Long2ReferenceArrayMap.this.value, this.pos, Long2ReferenceArrayMap.this.value, this.pos - 1, tail);
                    Long2ReferenceArrayMap.access$010(Long2ReferenceArrayMap.this);
                    this.pos--;
                    Long2ReferenceArrayMap.this.value[Long2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super V> action) {
                    int max = Long2ReferenceArrayMap.this.size;
                    while (this.pos < max) {
                        Object[] objArr = Long2ReferenceArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(objArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceArrayMap$ValuesCollection$ValuesSpliterator.class */
        public final class ValuesSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<V> implements ObjectSpliterator<V> {
            ValuesSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return ObjectSpliterators.LIST_SPLITERATOR_CHARACTERISTICS;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            protected final V get(int location) {
                return (V) Long2ReferenceArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Long2ReferenceArrayMap<V>.ValuesCollection.ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super V> action) {
                int max = Long2ReferenceArrayMap.this.size;
                while (this.pos < max) {
                    Object[] objArr = Long2ReferenceArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(objArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<V> spliterator() {
            return new ValuesSpliterator(0, Long2ReferenceArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> action) {
            int max = Long2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Long2ReferenceArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Long2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Long2ReferenceArrayMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Long2ReferenceArrayMap<V> clone() {
        try {
            Long2ReferenceArrayMap<V> c = (Long2ReferenceArrayMap) clone();
            c.key = (long[]) this.key.clone();
            c.value = (Object[]) this.value.clone();
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
            s.writeObject(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new long[this.size];
        this.value = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readLong();
            this.value[i] = s.readObject();
        }
    }
}
