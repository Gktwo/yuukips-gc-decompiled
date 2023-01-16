package p014it.unimi.dsi.fastutil.doubles;

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
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2IntMap;
import p014it.unimi.dsi.fastutil.doubles.Double2IntMap;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;
import p014it.unimi.dsi.fastutil.ints.AbstractIntCollection;
import p014it.unimi.dsi.fastutil.ints.IntArrays;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2IntArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2IntArrayMap.class */
public class Double2IntArrayMap extends AbstractDouble2IntMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient double[] key;
    private transient int[] value;
    private int size;
    private transient Double2IntMap.FastEntrySet entries;
    private transient DoubleSet keys;
    private transient IntCollection values;

    static /* synthetic */ int access$010(Double2IntArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Double2IntArrayMap(double[] key, int[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Double2IntArrayMap() {
        this.key = DoubleArrays.EMPTY_ARRAY;
        this.value = IntArrays.EMPTY_ARRAY;
    }

    public Double2IntArrayMap(int capacity) {
        this.key = new double[capacity];
        this.value = new int[capacity];
    }

    public Double2IntArrayMap(Double2IntMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Double2IntMap.Entry> it = m.double2IntEntrySet().iterator();
        while (it.hasNext()) {
            Double2IntMap.Entry e = it.next();
            this.key[i] = e.getDoubleKey();
            this.value[i] = e.getIntValue();
            i++;
        }
        this.size = i;
    }

    public Double2IntArrayMap(Map<? extends Double, ? extends Integer> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Double, ? extends Integer> e : m.entrySet()) {
            this.key[i] = ((Double) e.getKey()).doubleValue();
            this.value[i] = ((Integer) e.getValue()).intValue();
            i++;
        }
        this.size = i;
    }

    public Double2IntArrayMap(double[] key, int[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2IntArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2IntArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Double2IntMap.Entry> implements Double2IntMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Double2IntMap.Entry> iterator() {
            return new ObjectIterator<Double2IntMap.Entry>() { // from class: it.unimi.dsi.fastutil.doubles.Double2IntArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Double2IntArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Double2IntMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    double[] dArr = Double2IntArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    double d = dArr[i];
                    int[] iArr = Double2IntArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractDouble2IntMap.BasicEntry(d, iArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Double2IntArrayMap.access$010(Double2IntArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Double2IntArrayMap.this.key, this.next + 1, Double2IntArrayMap.this.key, this.next, tail);
                    System.arraycopy(Double2IntArrayMap.this.value, this.next + 1, Double2IntArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Double2IntMap.Entry> action) {
                    int max = Double2IntArrayMap.this.size;
                    while (this.next < max) {
                        double[] dArr = Double2IntArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        double d = dArr[i];
                        int[] iArr = Double2IntArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractDouble2IntMap.BasicEntry(d, iArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap.FastEntrySet
        public ObjectIterator<Double2IntMap.Entry> fastIterator() {
            return new ObjectIterator<Double2IntMap.Entry>() { // from class: it.unimi.dsi.fastutil.doubles.Double2IntArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractDouble2IntMap.BasicEntry entry = new AbstractDouble2IntMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Double2IntArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Double2IntMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractDouble2IntMap.BasicEntry basicEntry = this.entry;
                    double[] dArr = Double2IntArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = dArr[i];
                    AbstractDouble2IntMap.BasicEntry basicEntry2 = this.entry;
                    int[] iArr = Double2IntArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = iArr[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Double2IntArrayMap.access$010(Double2IntArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Double2IntArrayMap.this.key, this.next + 1, Double2IntArrayMap.this.key, this.next, tail);
                    System.arraycopy(Double2IntArrayMap.this.value, this.next + 1, Double2IntArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Double2IntMap.Entry> action) {
                    int max = Double2IntArrayMap.this.size;
                    while (this.next < max) {
                        AbstractDouble2IntMap.BasicEntry basicEntry = this.entry;
                        double[] dArr = Double2IntArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = dArr[i];
                        AbstractDouble2IntMap.BasicEntry basicEntry2 = this.entry;
                        int[] iArr = Double2IntArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = iArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.Double2IntArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2IntArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Double2IntMap.Entry> implements ObjectSpliterator<Double2IntMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Double2IntMap.Entry get(int location) {
                return new AbstractDouble2IntMap.BasicEntry(Double2IntArrayMap.this.key[location], Double2IntArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Double2IntMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Double2IntArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Double2IntMap.Entry> action) {
            int max = Double2IntArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractDouble2IntMap.BasicEntry(Double2IntArrayMap.this.key[i], Double2IntArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap.FastEntrySet
        public void fastForEach(Consumer<? super Double2IntMap.Entry> action) {
            AbstractDouble2IntMap.BasicEntry entry = new AbstractDouble2IntMap.BasicEntry();
            int max = Double2IntArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Double2IntArrayMap.this.key[i];
                entry.value = Double2IntArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Double2IntArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Double) || e.getValue() == null || !(e.getValue() instanceof Integer)) {
                return false;
            }
            double k = ((Double) e.getKey()).doubleValue();
            return Double2IntArrayMap.this.containsKey(k) && Double2IntArrayMap.this.get(k) == ((Integer) e.getValue()).intValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Double) || e.getValue() == null || !(e.getValue() instanceof Integer)) {
                return false;
            }
            double k = ((Double) e.getKey()).doubleValue();
            int v = ((Integer) e.getValue()).intValue();
            int oldPos = Double2IntArrayMap.this.findKey(k);
            if (oldPos == -1 || v != Double2IntArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Double2IntArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Double2IntArrayMap.this.key, oldPos + 1, Double2IntArrayMap.this.key, oldPos, tail);
            System.arraycopy(Double2IntArrayMap.this.value, oldPos + 1, Double2IntArrayMap.this.value, oldPos, tail);
            Double2IntArrayMap.access$010(Double2IntArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap, p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
    public Double2IntMap.FastEntrySet double2IntEntrySet() {
        if (this.entries == null) {
            this.entries = new EntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    public int findKey(double k) {
        double[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (Double.doubleToLongBits(key[i]) != Double.doubleToLongBits(k));
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntFunction
    public int get(double k) {
        double[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return this.defRetValue;
            }
        } while (Double.doubleToLongBits(key[i]) != Double.doubleToLongBits(k));
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2IntMap, p014it.unimi.dsi.fastutil.doubles.Double2IntFunction, p014it.unimi.dsi.fastutil.doubles.Double2IntMap
    public boolean containsKey(double k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2IntMap, p014it.unimi.dsi.fastutil.doubles.Double2IntMap
    public boolean containsValue(int v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (this.value[i] != v);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2IntMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntFunction
    public int put(double k, int v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            int oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            double[] newKey = new double[this.size == 0 ? 2 : this.size * 2];
            int[] newValue = new int[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntFunction
    public int remove(double k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        int oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2IntArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2IntArrayMap$KeySet.class */
    public final class KeySet extends AbstractDoubleSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return Double2IntArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
        public boolean remove(double k) {
            int oldPos = Double2IntArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Double2IntArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Double2IntArrayMap.this.key, oldPos + 1, Double2IntArrayMap.this.key, oldPos, tail);
            System.arraycopy(Double2IntArrayMap.this.value, oldPos + 1, Double2IntArrayMap.this.value, oldPos, tail);
            Double2IntArrayMap.access$010(Double2IntArrayMap.this);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator iterator() {
            return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.doubles.Double2IntArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Double2IntArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                public double nextDouble() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    double[] dArr = Double2IntArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return dArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Double2IntArrayMap.this.size - this.pos;
                    System.arraycopy(Double2IntArrayMap.this.key, this.pos, Double2IntArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Double2IntArrayMap.this.value, this.pos, Double2IntArrayMap.this.value, this.pos - 1, tail);
                    Double2IntArrayMap.access$010(Double2IntArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfDouble
                public void forEachRemaining(DoubleConsumer action) {
                    int max = Double2IntArrayMap.this.size;
                    while (this.pos < max) {
                        double[] dArr = Double2IntArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(dArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.Double2IntArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2IntArrayMap$KeySet$KeySetSpliterator.class */
        public final class KeySetSpliterator extends DoubleSpliterators.EarlyBindingSizeIndexBasedSpliterator implements DoubleSpliterator {
            KeySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16721;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator
            protected final double get(int location) {
                return Double2IntArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfDouble
            public void forEachRemaining(DoubleConsumer action) {
                int max = Double2IntArrayMap.this.size;
                while (this.pos < max) {
                    double[] dArr = Double2IntArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(dArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return new KeySetSpliterator(0, Double2IntArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer action) {
            int max = Double2IntArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Double2IntArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Double2IntArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Double2IntArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2IntMap, p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
    public Set<Double> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2IntArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2IntArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractIntCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int v) {
            return Double2IntArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator iterator() {
            return new IntIterator() { // from class: it.unimi.dsi.fastutil.doubles.Double2IntArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Double2IntArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                public int nextInt() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int[] iArr = Double2IntArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return iArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Double2IntArrayMap.this.size - this.pos;
                    System.arraycopy(Double2IntArrayMap.this.key, this.pos, Double2IntArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Double2IntArrayMap.this.value, this.pos, Double2IntArrayMap.this.value, this.pos - 1, tail);
                    Double2IntArrayMap.access$010(Double2IntArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfInt
                public void forEachRemaining(IntConsumer action) {
                    int max = Double2IntArrayMap.this.size;
                    while (this.pos < max) {
                        int[] iArr = Double2IntArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(iArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.Double2IntArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2IntArrayMap$ValuesCollection$ValuesSpliterator.class */
        public final class ValuesSpliterator extends IntSpliterators.EarlyBindingSizeIndexBasedSpliterator implements IntSpliterator {
            ValuesSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16720;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator
            protected final int get(int location) {
                return Double2IntArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfInt
            public void forEachRemaining(IntConsumer action) {
                int max = Double2IntArrayMap.this.size;
                while (this.pos < max) {
                    int[] iArr = Double2IntArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(iArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return new ValuesSpliterator(0, Double2IntArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer action) {
            int max = Double2IntArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Double2IntArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Double2IntArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Double2IntArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2IntMap, p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
    public Collection<Integer> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Double2IntArrayMap clone() {
        try {
            Double2IntArrayMap c = (Double2IntArrayMap) clone();
            c.key = (double[]) this.key.clone();
            c.value = (int[]) this.value.clone();
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
            s.writeDouble(this.key[i]);
            s.writeInt(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new double[this.size];
        this.value = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readDouble();
            this.value[i] = s.readInt();
        }
    }
}
