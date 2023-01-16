package p014it.unimi.dsi.fastutil.shorts;

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
import p014it.unimi.dsi.fastutil.longs.AbstractLongCollection;
import p014it.unimi.dsi.fastutil.longs.LongArrays;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.longs.LongIterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2LongMap;
import p014it.unimi.dsi.fastutil.shorts.Short2LongMap;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterators;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongArrayMap.class */
public class Short2LongArrayMap extends AbstractShort2LongMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient short[] key;
    private transient long[] value;
    private int size;
    private transient Short2LongMap.FastEntrySet entries;
    private transient ShortSet keys;
    private transient LongCollection values;

    static /* synthetic */ int access$010(Short2LongArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Short2LongArrayMap(short[] key, long[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Short2LongArrayMap() {
        this.key = ShortArrays.EMPTY_ARRAY;
        this.value = LongArrays.EMPTY_ARRAY;
    }

    public Short2LongArrayMap(int capacity) {
        this.key = new short[capacity];
        this.value = new long[capacity];
    }

    public Short2LongArrayMap(Short2LongMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Short2LongMap.Entry> it = m.short2LongEntrySet().iterator();
        while (it.hasNext()) {
            Short2LongMap.Entry e = it.next();
            this.key[i] = e.getShortKey();
            this.value[i] = e.getLongValue();
            i++;
        }
        this.size = i;
    }

    public Short2LongArrayMap(Map<? extends Short, ? extends Long> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Short, ? extends Long> e : m.entrySet()) {
            this.key[i] = ((Short) e.getKey()).shortValue();
            this.value[i] = ((Long) e.getValue()).longValue();
            i++;
        }
        this.size = i;
    }

    public Short2LongArrayMap(short[] key, long[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Short2LongMap.Entry> implements Short2LongMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Short2LongMap.Entry> iterator() {
            return new ObjectIterator<Short2LongMap.Entry>() { // from class: it.unimi.dsi.fastutil.shorts.Short2LongArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Short2LongArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Short2LongMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    short[] sArr = Short2LongArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    short s = sArr[i];
                    long[] jArr = Short2LongArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractShort2LongMap.BasicEntry(s, jArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Short2LongArrayMap.access$010(Short2LongArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Short2LongArrayMap.this.key, this.next + 1, Short2LongArrayMap.this.key, this.next, tail);
                    System.arraycopy(Short2LongArrayMap.this.value, this.next + 1, Short2LongArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Short2LongMap.Entry> action) {
                    int max = Short2LongArrayMap.this.size;
                    while (this.next < max) {
                        short[] sArr = Short2LongArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        short s = sArr[i];
                        long[] jArr = Short2LongArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractShort2LongMap.BasicEntry(s, jArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap.FastEntrySet
        public ObjectIterator<Short2LongMap.Entry> fastIterator() {
            return new ObjectIterator<Short2LongMap.Entry>() { // from class: it.unimi.dsi.fastutil.shorts.Short2LongArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractShort2LongMap.BasicEntry entry = new AbstractShort2LongMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Short2LongArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Short2LongMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractShort2LongMap.BasicEntry basicEntry = this.entry;
                    short[] sArr = Short2LongArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = sArr[i];
                    AbstractShort2LongMap.BasicEntry basicEntry2 = this.entry;
                    long[] jArr = Short2LongArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = jArr[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Short2LongArrayMap.access$010(Short2LongArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Short2LongArrayMap.this.key, this.next + 1, Short2LongArrayMap.this.key, this.next, tail);
                    System.arraycopy(Short2LongArrayMap.this.value, this.next + 1, Short2LongArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Short2LongMap.Entry> action) {
                    int max = Short2LongArrayMap.this.size;
                    while (this.next < max) {
                        AbstractShort2LongMap.BasicEntry basicEntry = this.entry;
                        short[] sArr = Short2LongArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = sArr[i];
                        AbstractShort2LongMap.BasicEntry basicEntry2 = this.entry;
                        long[] jArr = Short2LongArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = jArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Short2LongMap.Entry> implements ObjectSpliterator<Short2LongMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Short2LongMap.Entry get(int location) {
                return new AbstractShort2LongMap.BasicEntry(Short2LongArrayMap.this.key[location], Short2LongArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Short2LongMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Short2LongArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Short2LongMap.Entry> action) {
            int max = Short2LongArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractShort2LongMap.BasicEntry(Short2LongArrayMap.this.key[i], Short2LongArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap.FastEntrySet
        public void fastForEach(Consumer<? super Short2LongMap.Entry> action) {
            AbstractShort2LongMap.BasicEntry entry = new AbstractShort2LongMap.BasicEntry();
            int max = Short2LongArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Short2LongArrayMap.this.key[i];
                entry.value = Short2LongArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Short2LongArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short) || e.getValue() == null || !(e.getValue() instanceof Long)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            return Short2LongArrayMap.this.containsKey(k) && Short2LongArrayMap.this.get(k) == ((Long) e.getValue()).longValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short) || e.getValue() == null || !(e.getValue() instanceof Long)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            long v = ((Long) e.getValue()).longValue();
            int oldPos = Short2LongArrayMap.this.findKey(k);
            if (oldPos == -1 || v != Short2LongArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Short2LongArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Short2LongArrayMap.this.key, oldPos + 1, Short2LongArrayMap.this.key, oldPos, tail);
            System.arraycopy(Short2LongArrayMap.this.value, oldPos + 1, Short2LongArrayMap.this.value, oldPos, tail);
            Short2LongArrayMap.access$010(Short2LongArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
    public Short2LongMap.FastEntrySet short2LongEntrySet() {
        if (this.entries == null) {
            this.entries = new EntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    public int findKey(short k) {
        short[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (key[i] != k);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunction
    public long get(short k) {
        short[] key = this.key;
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongFunction, p014it.unimi.dsi.fastutil.shorts.Short2LongMap
    public boolean containsKey(short k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongMap
    public boolean containsValue(long v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (this.value[i] != v);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2LongMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunction
    public long put(short k, long v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            long oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            short[] newKey = new short[this.size == 0 ? 2 : this.size * 2];
            long[] newValue = new long[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunction
    public long remove(short k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        long oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongArrayMap$KeySet.class */
    public final class KeySet extends AbstractShortSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return Short2LongArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.ShortSet
        public boolean remove(short k) {
            int oldPos = Short2LongArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Short2LongArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Short2LongArrayMap.this.key, oldPos + 1, Short2LongArrayMap.this.key, oldPos, tail);
            System.arraycopy(Short2LongArrayMap.this.value, oldPos + 1, Short2LongArrayMap.this.value, oldPos, tail);
            Short2LongArrayMap.access$010(Short2LongArrayMap.this);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortIterator iterator() {
            return new ShortIterator() { // from class: it.unimi.dsi.fastutil.shorts.Short2LongArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Short2LongArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                public short nextShort() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    short[] sArr = Short2LongArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return sArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Short2LongArrayMap.this.size - this.pos;
                    System.arraycopy(Short2LongArrayMap.this.key, this.pos, Short2LongArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Short2LongArrayMap.this.value, this.pos, Short2LongArrayMap.this.value, this.pos - 1, tail);
                    Short2LongArrayMap.access$010(Short2LongArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                public void forEachRemaining(ShortConsumer action) {
                    int max = Short2LongArrayMap.this.size;
                    while (this.pos < max) {
                        short[] sArr = Short2LongArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(sArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongArrayMap$KeySet$KeySetSpliterator.class */
        public final class KeySetSpliterator extends ShortSpliterators.EarlyBindingSizeIndexBasedSpliterator implements ShortSpliterator {
            KeySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16721;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            protected final short get(int location) {
                return Short2LongArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ShortConsumer action) {
                int max = Short2LongArrayMap.this.size;
                while (this.pos < max) {
                    short[] sArr = Short2LongArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(sArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return new KeySetSpliterator(0, Short2LongArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public void forEach(ShortConsumer action) {
            int max = Short2LongArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Short2LongArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Short2LongArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Short2LongArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
    public Set<Short> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractLongCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long v) {
            return Short2LongArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator iterator() {
            return new LongIterator() { // from class: it.unimi.dsi.fastutil.shorts.Short2LongArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Short2LongArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
                public long nextLong() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    long[] jArr = Short2LongArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return jArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Short2LongArrayMap.this.size - this.pos;
                    System.arraycopy(Short2LongArrayMap.this.key, this.pos, Short2LongArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Short2LongArrayMap.this.value, this.pos, Short2LongArrayMap.this.value, this.pos - 1, tail);
                    Short2LongArrayMap.access$010(Short2LongArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfLong
                public void forEachRemaining(LongConsumer action) {
                    int max = Short2LongArrayMap.this.size;
                    while (this.pos < max) {
                        long[] jArr = Short2LongArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(jArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongArrayMap$ValuesCollection$ValuesSpliterator.class */
        public final class ValuesSpliterator extends LongSpliterators.EarlyBindingSizeIndexBasedSpliterator implements LongSpliterator {
            ValuesSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16720;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
            protected final long get(int location) {
                return Short2LongArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfLong
            public void forEachRemaining(LongConsumer action) {
                int max = Short2LongArrayMap.this.size;
                while (this.pos < max) {
                    long[] jArr = Short2LongArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(jArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return new ValuesSpliterator(0, Short2LongArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
        public void forEach(LongConsumer action) {
            int max = Short2LongArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Short2LongArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Short2LongArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Short2LongArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
    public Collection<Long> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Short2LongArrayMap clone() {
        try {
            Short2LongArrayMap c = (Short2LongArrayMap) clone();
            c.key = (short[]) this.key.clone();
            c.value = (long[]) this.value.clone();
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
            s.writeShort(this.key[i]);
            s.writeLong(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new short[this.size];
        this.value = new long[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readShort();
            this.value[i] = s.readLong();
        }
    }
}
