package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2LongMap;
import p014it.unimi.dsi.fastutil.ints.Int2LongMap;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
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

/* renamed from: it.unimi.dsi.fastutil.ints.Int2LongArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2LongArrayMap.class */
public class Int2LongArrayMap extends AbstractInt2LongMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient int[] key;
    private transient long[] value;
    private int size;
    private transient Int2LongMap.FastEntrySet entries;
    private transient IntSet keys;
    private transient LongCollection values;

    static /* synthetic */ int access$010(Int2LongArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Int2LongArrayMap(int[] key, long[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Int2LongArrayMap() {
        this.key = IntArrays.EMPTY_ARRAY;
        this.value = LongArrays.EMPTY_ARRAY;
    }

    public Int2LongArrayMap(int capacity) {
        this.key = new int[capacity];
        this.value = new long[capacity];
    }

    public Int2LongArrayMap(Int2LongMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Int2LongMap.Entry> it = m.int2LongEntrySet().iterator();
        while (it.hasNext()) {
            Int2LongMap.Entry e = it.next();
            this.key[i] = e.getIntKey();
            this.value[i] = e.getLongValue();
            i++;
        }
        this.size = i;
    }

    public Int2LongArrayMap(Map<? extends Integer, ? extends Long> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Integer, ? extends Long> e : m.entrySet()) {
            this.key[i] = ((Integer) e.getKey()).intValue();
            this.value[i] = ((Long) e.getValue()).longValue();
            i++;
        }
        this.size = i;
    }

    public Int2LongArrayMap(int[] key, long[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2LongArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2LongArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Int2LongMap.Entry> implements Int2LongMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Int2LongMap.Entry> iterator() {
            return new ObjectIterator<Int2LongMap.Entry>() { // from class: it.unimi.dsi.fastutil.ints.Int2LongArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Int2LongArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Int2LongMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int[] iArr = Int2LongArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    int i2 = iArr[i];
                    long[] jArr = Int2LongArrayMap.this.value;
                    int i3 = this.next;
                    this.next = i3 + 1;
                    return new AbstractInt2LongMap.BasicEntry(i2, jArr[i3]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Int2LongArrayMap.access$010(Int2LongArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Int2LongArrayMap.this.key, this.next + 1, Int2LongArrayMap.this.key, this.next, tail);
                    System.arraycopy(Int2LongArrayMap.this.value, this.next + 1, Int2LongArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Int2LongMap.Entry> action) {
                    int max = Int2LongArrayMap.this.size;
                    while (this.next < max) {
                        int[] iArr = Int2LongArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        int i2 = iArr[i];
                        long[] jArr = Int2LongArrayMap.this.value;
                        int i3 = this.next;
                        this.next = i3 + 1;
                        action.accept(new AbstractInt2LongMap.BasicEntry(i2, jArr[i3]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2LongMap.FastEntrySet
        public ObjectIterator<Int2LongMap.Entry> fastIterator() {
            return new ObjectIterator<Int2LongMap.Entry>() { // from class: it.unimi.dsi.fastutil.ints.Int2LongArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractInt2LongMap.BasicEntry entry = new AbstractInt2LongMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Int2LongArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Int2LongMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractInt2LongMap.BasicEntry basicEntry = this.entry;
                    int[] iArr = Int2LongArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = iArr[i];
                    AbstractInt2LongMap.BasicEntry basicEntry2 = this.entry;
                    long[] jArr = Int2LongArrayMap.this.value;
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
                    int access$010 = Int2LongArrayMap.access$010(Int2LongArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Int2LongArrayMap.this.key, this.next + 1, Int2LongArrayMap.this.key, this.next, tail);
                    System.arraycopy(Int2LongArrayMap.this.value, this.next + 1, Int2LongArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Int2LongMap.Entry> action) {
                    int max = Int2LongArrayMap.this.size;
                    while (this.next < max) {
                        AbstractInt2LongMap.BasicEntry basicEntry = this.entry;
                        int[] iArr = Int2LongArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = iArr[i];
                        AbstractInt2LongMap.BasicEntry basicEntry2 = this.entry;
                        long[] jArr = Int2LongArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = jArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2LongArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2LongArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Int2LongMap.Entry> implements ObjectSpliterator<Int2LongMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Int2LongMap.Entry get(int location) {
                return new AbstractInt2LongMap.BasicEntry(Int2LongArrayMap.this.key[location], Int2LongArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Int2LongMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Int2LongArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Int2LongMap.Entry> action) {
            int max = Int2LongArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractInt2LongMap.BasicEntry(Int2LongArrayMap.this.key[i], Int2LongArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2LongMap.FastEntrySet
        public void fastForEach(Consumer<? super Int2LongMap.Entry> action) {
            AbstractInt2LongMap.BasicEntry entry = new AbstractInt2LongMap.BasicEntry();
            int max = Int2LongArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Int2LongArrayMap.this.key[i];
                entry.value = Int2LongArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2LongArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Long)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            return Int2LongArrayMap.this.containsKey(k) && Int2LongArrayMap.this.get(k) == ((Long) e.getValue()).longValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Long)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            long v = ((Long) e.getValue()).longValue();
            int oldPos = Int2LongArrayMap.this.findKey(k);
            if (oldPos == -1 || v != Int2LongArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Int2LongArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Int2LongArrayMap.this.key, oldPos + 1, Int2LongArrayMap.this.key, oldPos, tail);
            System.arraycopy(Int2LongArrayMap.this.value, oldPos + 1, Int2LongArrayMap.this.value, oldPos, tail);
            Int2LongArrayMap.access$010(Int2LongArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongMap, p014it.unimi.dsi.fastutil.ints.Int2LongSortedMap
    public Int2LongMap.FastEntrySet int2LongEntrySet() {
        if (this.entries == null) {
            this.entries = new EntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    public int findKey(int k) {
        int[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (key[i] != k);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongFunction
    public long get(int k) {
        int[] key = this.key;
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2LongMap, p014it.unimi.dsi.fastutil.ints.Int2LongFunction, p014it.unimi.dsi.fastutil.ints.Int2LongMap
    public boolean containsKey(int k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2LongMap, p014it.unimi.dsi.fastutil.ints.Int2LongMap
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2LongMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongFunction
    public long put(int k, long v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            long oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            int[] newKey = new int[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongFunction
    public long remove(int k) {
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2LongArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2LongArrayMap$KeySet.class */
    public final class KeySet extends AbstractIntSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return Int2LongArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.IntSet
        public boolean remove(int k) {
            int oldPos = Int2LongArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Int2LongArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Int2LongArrayMap.this.key, oldPos + 1, Int2LongArrayMap.this.key, oldPos, tail);
            System.arraycopy(Int2LongArrayMap.this.value, oldPos + 1, Int2LongArrayMap.this.value, oldPos, tail);
            Int2LongArrayMap.access$010(Int2LongArrayMap.this);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator iterator() {
            return new IntIterator() { // from class: it.unimi.dsi.fastutil.ints.Int2LongArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Int2LongArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                public int nextInt() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int[] iArr = Int2LongArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return iArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Int2LongArrayMap.this.size - this.pos;
                    System.arraycopy(Int2LongArrayMap.this.key, this.pos, Int2LongArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Int2LongArrayMap.this.value, this.pos, Int2LongArrayMap.this.value, this.pos - 1, tail);
                    Int2LongArrayMap.access$010(Int2LongArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfInt
                public void forEachRemaining(IntConsumer action) {
                    int max = Int2LongArrayMap.this.size;
                    while (this.pos < max) {
                        int[] iArr = Int2LongArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(iArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2LongArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2LongArrayMap$KeySet$KeySetSpliterator.class */
        public final class KeySetSpliterator extends IntSpliterators.EarlyBindingSizeIndexBasedSpliterator implements IntSpliterator {
            KeySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16721;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator
            protected final int get(int location) {
                return Int2LongArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfInt
            public void forEachRemaining(IntConsumer action) {
                int max = Int2LongArrayMap.this.size;
                while (this.pos < max) {
                    int[] iArr = Int2LongArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(iArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return new KeySetSpliterator(0, Int2LongArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer action) {
            int max = Int2LongArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Int2LongArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2LongArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2LongArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2LongMap, p014it.unimi.dsi.fastutil.ints.Int2LongMap, java.util.Map
    public Set<Integer> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2LongArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2LongArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractLongCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long v) {
            return Int2LongArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator iterator() {
            return new LongIterator() { // from class: it.unimi.dsi.fastutil.ints.Int2LongArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Int2LongArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
                public long nextLong() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    long[] jArr = Int2LongArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return jArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Int2LongArrayMap.this.size - this.pos;
                    System.arraycopy(Int2LongArrayMap.this.key, this.pos, Int2LongArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Int2LongArrayMap.this.value, this.pos, Int2LongArrayMap.this.value, this.pos - 1, tail);
                    Int2LongArrayMap.access$010(Int2LongArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfLong
                public void forEachRemaining(LongConsumer action) {
                    int max = Int2LongArrayMap.this.size;
                    while (this.pos < max) {
                        long[] jArr = Int2LongArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(jArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2LongArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2LongArrayMap$ValuesCollection$ValuesSpliterator.class */
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
                return Int2LongArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfLong
            public void forEachRemaining(LongConsumer action) {
                int max = Int2LongArrayMap.this.size;
                while (this.pos < max) {
                    long[] jArr = Int2LongArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(jArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return new ValuesSpliterator(0, Int2LongArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
        public void forEach(LongConsumer action) {
            int max = Int2LongArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Int2LongArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Int2LongArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Int2LongArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2LongMap, p014it.unimi.dsi.fastutil.ints.Int2LongMap, java.util.Map
    public Collection<Long> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Int2LongArrayMap clone() {
        try {
            Int2LongArrayMap c = (Int2LongArrayMap) clone();
            c.key = (int[]) this.key.clone();
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
            s.writeInt(this.key[i]);
            s.writeLong(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new int[this.size];
        this.value = new long[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readInt();
            this.value[i] = s.readLong();
        }
    }
}
