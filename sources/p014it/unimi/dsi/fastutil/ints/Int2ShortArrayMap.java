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
import p014it.unimi.dsi.fastutil.ints.AbstractInt2ShortMap;
import p014it.unimi.dsi.fastutil.ints.Int2ShortMap;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortArrays;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortConsumer;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterators;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortArrayMap.class */
public class Int2ShortArrayMap extends AbstractInt2ShortMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient int[] key;
    private transient short[] value;
    private int size;
    private transient Int2ShortMap.FastEntrySet entries;
    private transient IntSet keys;
    private transient ShortCollection values;

    static /* synthetic */ int access$010(Int2ShortArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Int2ShortArrayMap(int[] key, short[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Int2ShortArrayMap() {
        this.key = IntArrays.EMPTY_ARRAY;
        this.value = ShortArrays.EMPTY_ARRAY;
    }

    public Int2ShortArrayMap(int capacity) {
        this.key = new int[capacity];
        this.value = new short[capacity];
    }

    public Int2ShortArrayMap(Int2ShortMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Int2ShortMap.Entry> it = m.int2ShortEntrySet().iterator();
        while (it.hasNext()) {
            Int2ShortMap.Entry e = it.next();
            this.key[i] = e.getIntKey();
            this.value[i] = e.getShortValue();
            i++;
        }
        this.size = i;
    }

    public Int2ShortArrayMap(Map<? extends Integer, ? extends Short> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Integer, ? extends Short> e : m.entrySet()) {
            this.key[i] = ((Integer) e.getKey()).intValue();
            this.value[i] = ((Short) e.getValue()).shortValue();
            i++;
        }
        this.size = i;
    }

    public Int2ShortArrayMap(int[] key, short[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Int2ShortMap.Entry> implements Int2ShortMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Int2ShortMap.Entry> iterator() {
            return new ObjectIterator<Int2ShortMap.Entry>() { // from class: it.unimi.dsi.fastutil.ints.Int2ShortArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Int2ShortArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Int2ShortMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int[] iArr = Int2ShortArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    int i2 = iArr[i];
                    short[] sArr = Int2ShortArrayMap.this.value;
                    int i3 = this.next;
                    this.next = i3 + 1;
                    return new AbstractInt2ShortMap.BasicEntry(i2, sArr[i3]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Int2ShortArrayMap.access$010(Int2ShortArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Int2ShortArrayMap.this.key, this.next + 1, Int2ShortArrayMap.this.key, this.next, tail);
                    System.arraycopy(Int2ShortArrayMap.this.value, this.next + 1, Int2ShortArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Int2ShortMap.Entry> action) {
                    int max = Int2ShortArrayMap.this.size;
                    while (this.next < max) {
                        int[] iArr = Int2ShortArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        int i2 = iArr[i];
                        short[] sArr = Int2ShortArrayMap.this.value;
                        int i3 = this.next;
                        this.next = i3 + 1;
                        action.accept(new AbstractInt2ShortMap.BasicEntry(i2, sArr[i3]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap.FastEntrySet
        public ObjectIterator<Int2ShortMap.Entry> fastIterator() {
            return new ObjectIterator<Int2ShortMap.Entry>() { // from class: it.unimi.dsi.fastutil.ints.Int2ShortArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractInt2ShortMap.BasicEntry entry = new AbstractInt2ShortMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Int2ShortArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Int2ShortMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractInt2ShortMap.BasicEntry basicEntry = this.entry;
                    int[] iArr = Int2ShortArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = iArr[i];
                    AbstractInt2ShortMap.BasicEntry basicEntry2 = this.entry;
                    short[] sArr = Int2ShortArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = sArr[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Int2ShortArrayMap.access$010(Int2ShortArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Int2ShortArrayMap.this.key, this.next + 1, Int2ShortArrayMap.this.key, this.next, tail);
                    System.arraycopy(Int2ShortArrayMap.this.value, this.next + 1, Int2ShortArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Int2ShortMap.Entry> action) {
                    int max = Int2ShortArrayMap.this.size;
                    while (this.next < max) {
                        AbstractInt2ShortMap.BasicEntry basicEntry = this.entry;
                        int[] iArr = Int2ShortArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = iArr[i];
                        AbstractInt2ShortMap.BasicEntry basicEntry2 = this.entry;
                        short[] sArr = Int2ShortArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = sArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Int2ShortMap.Entry> implements ObjectSpliterator<Int2ShortMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Int2ShortMap.Entry get(int location) {
                return new AbstractInt2ShortMap.BasicEntry(Int2ShortArrayMap.this.key[location], Int2ShortArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Int2ShortMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Int2ShortArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Int2ShortMap.Entry> action) {
            int max = Int2ShortArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractInt2ShortMap.BasicEntry(Int2ShortArrayMap.this.key[i], Int2ShortArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap.FastEntrySet
        public void fastForEach(Consumer<? super Int2ShortMap.Entry> action) {
            AbstractInt2ShortMap.BasicEntry entry = new AbstractInt2ShortMap.BasicEntry();
            int max = Int2ShortArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Int2ShortArrayMap.this.key[i];
                entry.value = Int2ShortArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2ShortArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Short)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            return Int2ShortArrayMap.this.containsKey(k) && Int2ShortArrayMap.this.get(k) == ((Short) e.getValue()).shortValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Short)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            short v = ((Short) e.getValue()).shortValue();
            int oldPos = Int2ShortArrayMap.this.findKey(k);
            if (oldPos == -1 || v != Int2ShortArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Int2ShortArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Int2ShortArrayMap.this.key, oldPos + 1, Int2ShortArrayMap.this.key, oldPos, tail);
            System.arraycopy(Int2ShortArrayMap.this.value, oldPos + 1, Int2ShortArrayMap.this.value, oldPos, tail);
            Int2ShortArrayMap.access$010(Int2ShortArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
    public Int2ShortMap.FastEntrySet int2ShortEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunction
    public short get(int k) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ShortMap, p014it.unimi.dsi.fastutil.ints.Int2ShortFunction, p014it.unimi.dsi.fastutil.ints.Int2ShortMap
    public boolean containsKey(int k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ShortMap, p014it.unimi.dsi.fastutil.ints.Int2ShortMap
    public boolean containsValue(short v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (this.value[i] != v);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ShortMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunction
    public short put(int k, short v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            short oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            int[] newKey = new int[this.size == 0 ? 2 : this.size * 2];
            short[] newValue = new short[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunction
    public short remove(int k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        short oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortArrayMap$KeySet.class */
    public final class KeySet extends AbstractIntSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return Int2ShortArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.IntSet
        public boolean remove(int k) {
            int oldPos = Int2ShortArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Int2ShortArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Int2ShortArrayMap.this.key, oldPos + 1, Int2ShortArrayMap.this.key, oldPos, tail);
            System.arraycopy(Int2ShortArrayMap.this.value, oldPos + 1, Int2ShortArrayMap.this.value, oldPos, tail);
            Int2ShortArrayMap.access$010(Int2ShortArrayMap.this);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator iterator() {
            return new IntIterator() { // from class: it.unimi.dsi.fastutil.ints.Int2ShortArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Int2ShortArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                public int nextInt() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int[] iArr = Int2ShortArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return iArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Int2ShortArrayMap.this.size - this.pos;
                    System.arraycopy(Int2ShortArrayMap.this.key, this.pos, Int2ShortArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Int2ShortArrayMap.this.value, this.pos, Int2ShortArrayMap.this.value, this.pos - 1, tail);
                    Int2ShortArrayMap.access$010(Int2ShortArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfInt
                public void forEachRemaining(IntConsumer action) {
                    int max = Int2ShortArrayMap.this.size;
                    while (this.pos < max) {
                        int[] iArr = Int2ShortArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(iArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortArrayMap$KeySet$KeySetSpliterator.class */
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
                return Int2ShortArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfInt
            public void forEachRemaining(IntConsumer action) {
                int max = Int2ShortArrayMap.this.size;
                while (this.pos < max) {
                    int[] iArr = Int2ShortArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(iArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return new KeySetSpliterator(0, Int2ShortArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer action) {
            int max = Int2ShortArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Int2ShortArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2ShortArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2ShortArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ShortMap, p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
    public Set<Integer> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractShortCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short v) {
            return Int2ShortArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortIterator iterator() {
            return new ShortIterator() { // from class: it.unimi.dsi.fastutil.ints.Int2ShortArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Int2ShortArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                public short nextShort() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    short[] sArr = Int2ShortArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return sArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Int2ShortArrayMap.this.size - this.pos;
                    System.arraycopy(Int2ShortArrayMap.this.key, this.pos, Int2ShortArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Int2ShortArrayMap.this.value, this.pos, Int2ShortArrayMap.this.value, this.pos - 1, tail);
                    Int2ShortArrayMap.access$010(Int2ShortArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                public void forEachRemaining(ShortConsumer action) {
                    int max = Int2ShortArrayMap.this.size;
                    while (this.pos < max) {
                        short[] sArr = Int2ShortArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(sArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortArrayMap$ValuesCollection$ValuesSpliterator.class */
        public final class ValuesSpliterator extends ShortSpliterators.EarlyBindingSizeIndexBasedSpliterator implements ShortSpliterator {
            ValuesSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16720;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            protected final short get(int location) {
                return Int2ShortArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ShortConsumer action) {
                int max = Int2ShortArrayMap.this.size;
                while (this.pos < max) {
                    short[] sArr = Int2ShortArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(sArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return new ValuesSpliterator(0, Int2ShortArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public void forEach(ShortConsumer action) {
            int max = Int2ShortArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Int2ShortArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Int2ShortArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Int2ShortArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ShortMap, p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
    public Collection<Short> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Int2ShortArrayMap clone() {
        try {
            Int2ShortArrayMap c = (Int2ShortArrayMap) clone();
            c.key = (int[]) this.key.clone();
            c.value = (short[]) this.value.clone();
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
            s.writeShort(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new int[this.size];
        this.value = new short[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readInt();
            this.value[i] = s.readShort();
        }
    }
}
