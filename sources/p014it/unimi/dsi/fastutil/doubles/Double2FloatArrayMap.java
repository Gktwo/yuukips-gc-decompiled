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
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatMap;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatMap;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;
import p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatArrays;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatConsumer;
import p014it.unimi.dsi.fastutil.floats.FloatIterator;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterator;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatArrayMap.class */
public class Double2FloatArrayMap extends AbstractDouble2FloatMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient double[] key;
    private transient float[] value;
    private int size;
    private transient Double2FloatMap.FastEntrySet entries;
    private transient DoubleSet keys;
    private transient FloatCollection values;

    static /* synthetic */ int access$010(Double2FloatArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Double2FloatArrayMap(double[] key, float[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Double2FloatArrayMap() {
        this.key = DoubleArrays.EMPTY_ARRAY;
        this.value = FloatArrays.EMPTY_ARRAY;
    }

    public Double2FloatArrayMap(int capacity) {
        this.key = new double[capacity];
        this.value = new float[capacity];
    }

    public Double2FloatArrayMap(Double2FloatMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Double2FloatMap.Entry> it = m.double2FloatEntrySet().iterator();
        while (it.hasNext()) {
            Double2FloatMap.Entry e = it.next();
            this.key[i] = e.getDoubleKey();
            this.value[i] = e.getFloatValue();
            i++;
        }
        this.size = i;
    }

    public Double2FloatArrayMap(Map<? extends Double, ? extends Float> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Double, ? extends Float> e : m.entrySet()) {
            this.key[i] = ((Double) e.getKey()).doubleValue();
            this.value[i] = ((Float) e.getValue()).floatValue();
            i++;
        }
        this.size = i;
    }

    public Double2FloatArrayMap(double[] key, float[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Double2FloatMap.Entry> implements Double2FloatMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Double2FloatMap.Entry> iterator() {
            return new ObjectIterator<Double2FloatMap.Entry>() { // from class: it.unimi.dsi.fastutil.doubles.Double2FloatArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Double2FloatArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Double2FloatMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    double[] dArr = Double2FloatArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    double d = dArr[i];
                    float[] fArr = Double2FloatArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractDouble2FloatMap.BasicEntry(d, fArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Double2FloatArrayMap.access$010(Double2FloatArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Double2FloatArrayMap.this.key, this.next + 1, Double2FloatArrayMap.this.key, this.next, tail);
                    System.arraycopy(Double2FloatArrayMap.this.value, this.next + 1, Double2FloatArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Double2FloatMap.Entry> action) {
                    int max = Double2FloatArrayMap.this.size;
                    while (this.next < max) {
                        double[] dArr = Double2FloatArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        double d = dArr[i];
                        float[] fArr = Double2FloatArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractDouble2FloatMap.BasicEntry(d, fArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap.FastEntrySet
        public ObjectIterator<Double2FloatMap.Entry> fastIterator() {
            return new ObjectIterator<Double2FloatMap.Entry>() { // from class: it.unimi.dsi.fastutil.doubles.Double2FloatArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractDouble2FloatMap.BasicEntry entry = new AbstractDouble2FloatMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Double2FloatArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Double2FloatMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractDouble2FloatMap.BasicEntry basicEntry = this.entry;
                    double[] dArr = Double2FloatArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = dArr[i];
                    AbstractDouble2FloatMap.BasicEntry basicEntry2 = this.entry;
                    float[] fArr = Double2FloatArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = fArr[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Double2FloatArrayMap.access$010(Double2FloatArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Double2FloatArrayMap.this.key, this.next + 1, Double2FloatArrayMap.this.key, this.next, tail);
                    System.arraycopy(Double2FloatArrayMap.this.value, this.next + 1, Double2FloatArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Double2FloatMap.Entry> action) {
                    int max = Double2FloatArrayMap.this.size;
                    while (this.next < max) {
                        AbstractDouble2FloatMap.BasicEntry basicEntry = this.entry;
                        double[] dArr = Double2FloatArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = dArr[i];
                        AbstractDouble2FloatMap.BasicEntry basicEntry2 = this.entry;
                        float[] fArr = Double2FloatArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = fArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Double2FloatMap.Entry> implements ObjectSpliterator<Double2FloatMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Double2FloatMap.Entry get(int location) {
                return new AbstractDouble2FloatMap.BasicEntry(Double2FloatArrayMap.this.key[location], Double2FloatArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Double2FloatMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Double2FloatArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Double2FloatMap.Entry> action) {
            int max = Double2FloatArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractDouble2FloatMap.BasicEntry(Double2FloatArrayMap.this.key[i], Double2FloatArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap.FastEntrySet
        public void fastForEach(Consumer<? super Double2FloatMap.Entry> action) {
            AbstractDouble2FloatMap.BasicEntry entry = new AbstractDouble2FloatMap.BasicEntry();
            int max = Double2FloatArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Double2FloatArrayMap.this.key[i];
                entry.value = Double2FloatArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Double2FloatArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Double) || e.getValue() == null || !(e.getValue() instanceof Float)) {
                return false;
            }
            double k = ((Double) e.getKey()).doubleValue();
            return Double2FloatArrayMap.this.containsKey(k) && Float.floatToIntBits(Double2FloatArrayMap.this.get(k)) == Float.floatToIntBits(((Float) e.getValue()).floatValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Double) || e.getValue() == null || !(e.getValue() instanceof Float)) {
                return false;
            }
            double k = ((Double) e.getKey()).doubleValue();
            float v = ((Float) e.getValue()).floatValue();
            int oldPos = Double2FloatArrayMap.this.findKey(k);
            if (oldPos == -1 || Float.floatToIntBits(v) != Float.floatToIntBits(Double2FloatArrayMap.this.value[oldPos])) {
                return false;
            }
            int tail = (Double2FloatArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Double2FloatArrayMap.this.key, oldPos + 1, Double2FloatArrayMap.this.key, oldPos, tail);
            System.arraycopy(Double2FloatArrayMap.this.value, oldPos + 1, Double2FloatArrayMap.this.value, oldPos, tail);
            Double2FloatArrayMap.access$010(Double2FloatArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap, p014it.unimi.dsi.fastutil.doubles.Double2FloatSortedMap
    public Double2FloatMap.FastEntrySet double2FloatEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction
    public float get(double k) {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatMap, p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction, p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
    public boolean containsKey(double k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatMap, p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
    public boolean containsValue(float v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (Float.floatToIntBits(this.value[i]) != Float.floatToIntBits(v));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction
    public float put(double k, float v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            float oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            double[] newKey = new double[this.size == 0 ? 2 : this.size * 2];
            float[] newValue = new float[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction
    public float remove(double k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        float oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatArrayMap$KeySet.class */
    public final class KeySet extends AbstractDoubleSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return Double2FloatArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
        public boolean remove(double k) {
            int oldPos = Double2FloatArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Double2FloatArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Double2FloatArrayMap.this.key, oldPos + 1, Double2FloatArrayMap.this.key, oldPos, tail);
            System.arraycopy(Double2FloatArrayMap.this.value, oldPos + 1, Double2FloatArrayMap.this.value, oldPos, tail);
            Double2FloatArrayMap.access$010(Double2FloatArrayMap.this);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator iterator() {
            return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.doubles.Double2FloatArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Double2FloatArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                public double nextDouble() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    double[] dArr = Double2FloatArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return dArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Double2FloatArrayMap.this.size - this.pos;
                    System.arraycopy(Double2FloatArrayMap.this.key, this.pos, Double2FloatArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Double2FloatArrayMap.this.value, this.pos, Double2FloatArrayMap.this.value, this.pos - 1, tail);
                    Double2FloatArrayMap.access$010(Double2FloatArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfDouble
                public void forEachRemaining(DoubleConsumer action) {
                    int max = Double2FloatArrayMap.this.size;
                    while (this.pos < max) {
                        double[] dArr = Double2FloatArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(dArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatArrayMap$KeySet$KeySetSpliterator.class */
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
                return Double2FloatArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfDouble
            public void forEachRemaining(DoubleConsumer action) {
                int max = Double2FloatArrayMap.this.size;
                while (this.pos < max) {
                    double[] dArr = Double2FloatArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(dArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return new KeySetSpliterator(0, Double2FloatArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer action) {
            int max = Double2FloatArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Double2FloatArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Double2FloatArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Double2FloatArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatMap, p014it.unimi.dsi.fastutil.doubles.Double2FloatMap, java.util.Map
    public Set<Double> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractFloatCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float v) {
            return Double2FloatArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatIterator iterator() {
            return new FloatIterator() { // from class: it.unimi.dsi.fastutil.doubles.Double2FloatArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Double2FloatArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                public float nextFloat() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    float[] fArr = Double2FloatArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return fArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Double2FloatArrayMap.this.size - this.pos;
                    System.arraycopy(Double2FloatArrayMap.this.key, this.pos, Double2FloatArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Double2FloatArrayMap.this.value, this.pos, Double2FloatArrayMap.this.value, this.pos - 1, tail);
                    Double2FloatArrayMap.access$010(Double2FloatArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                public void forEachRemaining(FloatConsumer action) {
                    int max = Double2FloatArrayMap.this.size;
                    while (this.pos < max) {
                        float[] fArr = Double2FloatArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(fArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatArrayMap$ValuesCollection$ValuesSpliterator.class */
        public final class ValuesSpliterator extends FloatSpliterators.EarlyBindingSizeIndexBasedSpliterator implements FloatSpliterator {
            ValuesSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16720;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            protected final float get(int location) {
                return Double2FloatArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(FloatConsumer action) {
                int max = Double2FloatArrayMap.this.size;
                while (this.pos < max) {
                    float[] fArr = Double2FloatArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(fArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return new ValuesSpliterator(0, Double2FloatArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
        public void forEach(FloatConsumer action) {
            int max = Double2FloatArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Double2FloatArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Double2FloatArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Double2FloatArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatMap, p014it.unimi.dsi.fastutil.doubles.Double2FloatMap, java.util.Map
    public Collection<Float> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Double2FloatArrayMap clone() {
        try {
            Double2FloatArrayMap c = (Double2FloatArrayMap) clone();
            c.key = (double[]) this.key.clone();
            c.value = (float[]) this.value.clone();
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
            s.writeFloat(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new double[this.size];
        this.value = new float[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readDouble();
            this.value[i] = s.readFloat();
        }
    }
}
