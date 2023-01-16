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
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleArrays;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleMap;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleArrayMap.class */
public class Int2DoubleArrayMap extends AbstractInt2DoubleMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient int[] key;
    private transient double[] value;
    private int size;
    private transient Int2DoubleMap.FastEntrySet entries;
    private transient IntSet keys;
    private transient DoubleCollection values;

    static /* synthetic */ int access$010(Int2DoubleArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Int2DoubleArrayMap(int[] key, double[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Int2DoubleArrayMap() {
        this.key = IntArrays.EMPTY_ARRAY;
        this.value = DoubleArrays.EMPTY_ARRAY;
    }

    public Int2DoubleArrayMap(int capacity) {
        this.key = new int[capacity];
        this.value = new double[capacity];
    }

    public Int2DoubleArrayMap(Int2DoubleMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Int2DoubleMap.Entry> it = m.int2DoubleEntrySet().iterator();
        while (it.hasNext()) {
            Int2DoubleMap.Entry e = it.next();
            this.key[i] = e.getIntKey();
            this.value[i] = e.getDoubleValue();
            i++;
        }
        this.size = i;
    }

    public Int2DoubleArrayMap(Map<? extends Integer, ? extends Double> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Integer, ? extends Double> e : m.entrySet()) {
            this.key[i] = ((Integer) e.getKey()).intValue();
            this.value[i] = ((Double) e.getValue()).doubleValue();
            i++;
        }
        this.size = i;
    }

    public Int2DoubleArrayMap(int[] key, double[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Int2DoubleMap.Entry> implements Int2DoubleMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Int2DoubleMap.Entry> iterator() {
            return new ObjectIterator<Int2DoubleMap.Entry>() { // from class: it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Int2DoubleArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Int2DoubleMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int[] iArr = Int2DoubleArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    int i2 = iArr[i];
                    double[] dArr = Int2DoubleArrayMap.this.value;
                    int i3 = this.next;
                    this.next = i3 + 1;
                    return new AbstractInt2DoubleMap.BasicEntry(i2, dArr[i3]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Int2DoubleArrayMap.access$010(Int2DoubleArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Int2DoubleArrayMap.this.key, this.next + 1, Int2DoubleArrayMap.this.key, this.next, tail);
                    System.arraycopy(Int2DoubleArrayMap.this.value, this.next + 1, Int2DoubleArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Int2DoubleMap.Entry> action) {
                    int max = Int2DoubleArrayMap.this.size;
                    while (this.next < max) {
                        int[] iArr = Int2DoubleArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        int i2 = iArr[i];
                        double[] dArr = Int2DoubleArrayMap.this.value;
                        int i3 = this.next;
                        this.next = i3 + 1;
                        action.accept(new AbstractInt2DoubleMap.BasicEntry(i2, dArr[i3]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMap.FastEntrySet
        public ObjectIterator<Int2DoubleMap.Entry> fastIterator() {
            return new ObjectIterator<Int2DoubleMap.Entry>() { // from class: it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractInt2DoubleMap.BasicEntry entry = new AbstractInt2DoubleMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Int2DoubleArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Int2DoubleMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractInt2DoubleMap.BasicEntry basicEntry = this.entry;
                    int[] iArr = Int2DoubleArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = iArr[i];
                    AbstractInt2DoubleMap.BasicEntry basicEntry2 = this.entry;
                    double[] dArr = Int2DoubleArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = dArr[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Int2DoubleArrayMap.access$010(Int2DoubleArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Int2DoubleArrayMap.this.key, this.next + 1, Int2DoubleArrayMap.this.key, this.next, tail);
                    System.arraycopy(Int2DoubleArrayMap.this.value, this.next + 1, Int2DoubleArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Int2DoubleMap.Entry> action) {
                    int max = Int2DoubleArrayMap.this.size;
                    while (this.next < max) {
                        AbstractInt2DoubleMap.BasicEntry basicEntry = this.entry;
                        int[] iArr = Int2DoubleArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = iArr[i];
                        AbstractInt2DoubleMap.BasicEntry basicEntry2 = this.entry;
                        double[] dArr = Int2DoubleArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = dArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Int2DoubleMap.Entry> implements ObjectSpliterator<Int2DoubleMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Int2DoubleMap.Entry get(int location) {
                return new AbstractInt2DoubleMap.BasicEntry(Int2DoubleArrayMap.this.key[location], Int2DoubleArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Int2DoubleMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Int2DoubleArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Int2DoubleMap.Entry> action) {
            int max = Int2DoubleArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractInt2DoubleMap.BasicEntry(Int2DoubleArrayMap.this.key[i], Int2DoubleArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMap.FastEntrySet
        public void fastForEach(Consumer<? super Int2DoubleMap.Entry> action) {
            AbstractInt2DoubleMap.BasicEntry entry = new AbstractInt2DoubleMap.BasicEntry();
            int max = Int2DoubleArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Int2DoubleArrayMap.this.key[i];
                entry.value = Int2DoubleArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2DoubleArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Double)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            return Int2DoubleArrayMap.this.containsKey(k) && Double.doubleToLongBits(Int2DoubleArrayMap.this.get(k)) == Double.doubleToLongBits(((Double) e.getValue()).doubleValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Double)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            double v = ((Double) e.getValue()).doubleValue();
            int oldPos = Int2DoubleArrayMap.this.findKey(k);
            if (oldPos == -1 || Double.doubleToLongBits(v) != Double.doubleToLongBits(Int2DoubleArrayMap.this.value[oldPos])) {
                return false;
            }
            int tail = (Int2DoubleArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Int2DoubleArrayMap.this.key, oldPos + 1, Int2DoubleArrayMap.this.key, oldPos, tail);
            System.arraycopy(Int2DoubleArrayMap.this.value, oldPos + 1, Int2DoubleArrayMap.this.value, oldPos, tail);
            Int2DoubleArrayMap.access$010(Int2DoubleArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
    public Int2DoubleMap.FastEntrySet int2DoubleEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
    public double get(int k) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap
    public boolean containsKey(int k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap
    public boolean containsValue(double v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (Double.doubleToLongBits(this.value[i]) != Double.doubleToLongBits(v));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
    public double put(int k, double v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            double oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            int[] newKey = new int[this.size == 0 ? 2 : this.size * 2];
            double[] newValue = new double[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
    public double remove(int k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        double oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleArrayMap$KeySet.class */
    public final class KeySet extends AbstractIntSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return Int2DoubleArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.IntSet
        public boolean remove(int k) {
            int oldPos = Int2DoubleArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Int2DoubleArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Int2DoubleArrayMap.this.key, oldPos + 1, Int2DoubleArrayMap.this.key, oldPos, tail);
            System.arraycopy(Int2DoubleArrayMap.this.value, oldPos + 1, Int2DoubleArrayMap.this.value, oldPos, tail);
            Int2DoubleArrayMap.access$010(Int2DoubleArrayMap.this);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator iterator() {
            return new IntIterator() { // from class: it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Int2DoubleArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                public int nextInt() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int[] iArr = Int2DoubleArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return iArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Int2DoubleArrayMap.this.size - this.pos;
                    System.arraycopy(Int2DoubleArrayMap.this.key, this.pos, Int2DoubleArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Int2DoubleArrayMap.this.value, this.pos, Int2DoubleArrayMap.this.value, this.pos - 1, tail);
                    Int2DoubleArrayMap.access$010(Int2DoubleArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfInt
                public void forEachRemaining(IntConsumer action) {
                    int max = Int2DoubleArrayMap.this.size;
                    while (this.pos < max) {
                        int[] iArr = Int2DoubleArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(iArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleArrayMap$KeySet$KeySetSpliterator.class */
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
                return Int2DoubleArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfInt
            public void forEachRemaining(IntConsumer action) {
                int max = Int2DoubleArrayMap.this.size;
                while (this.pos < max) {
                    int[] iArr = Int2DoubleArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(iArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return new KeySetSpliterator(0, Int2DoubleArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer action) {
            int max = Int2DoubleArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Int2DoubleArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2DoubleArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2DoubleArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
    public Set<Integer> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractDoubleCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double v) {
            return Int2DoubleArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator iterator() {
            return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Int2DoubleArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                public double nextDouble() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    double[] dArr = Int2DoubleArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return dArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Int2DoubleArrayMap.this.size - this.pos;
                    System.arraycopy(Int2DoubleArrayMap.this.key, this.pos, Int2DoubleArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Int2DoubleArrayMap.this.value, this.pos, Int2DoubleArrayMap.this.value, this.pos - 1, tail);
                    Int2DoubleArrayMap.access$010(Int2DoubleArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfDouble
                public void forEachRemaining(DoubleConsumer action) {
                    int max = Int2DoubleArrayMap.this.size;
                    while (this.pos < max) {
                        double[] dArr = Int2DoubleArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(dArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleArrayMap$ValuesCollection$ValuesSpliterator.class */
        public final class ValuesSpliterator extends DoubleSpliterators.EarlyBindingSizeIndexBasedSpliterator implements DoubleSpliterator {
            ValuesSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16720;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator
            protected final double get(int location) {
                return Int2DoubleArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfDouble
            public void forEachRemaining(DoubleConsumer action) {
                int max = Int2DoubleArrayMap.this.size;
                while (this.pos < max) {
                    double[] dArr = Int2DoubleArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(dArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return new ValuesSpliterator(0, Int2DoubleArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer action) {
            int max = Int2DoubleArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Int2DoubleArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Int2DoubleArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Int2DoubleArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
    public Collection<Double> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Int2DoubleArrayMap clone() {
        try {
            Int2DoubleArrayMap c = (Int2DoubleArrayMap) clone();
            c.key = (int[]) this.key.clone();
            c.value = (double[]) this.value.clone();
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
            s.writeDouble(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new int[this.size];
        this.value = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readInt();
            this.value[i] = s.readDouble();
        }
    }
}
