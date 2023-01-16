package p014it.unimi.dsi.fastutil.floats;

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
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleArrays;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleMap;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleArrayMap.class */
public class Float2DoubleArrayMap extends AbstractFloat2DoubleMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient float[] key;
    private transient double[] value;
    private int size;
    private transient Float2DoubleMap.FastEntrySet entries;
    private transient FloatSet keys;
    private transient DoubleCollection values;

    static /* synthetic */ int access$010(Float2DoubleArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Float2DoubleArrayMap(float[] key, double[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Float2DoubleArrayMap() {
        this.key = FloatArrays.EMPTY_ARRAY;
        this.value = DoubleArrays.EMPTY_ARRAY;
    }

    public Float2DoubleArrayMap(int capacity) {
        this.key = new float[capacity];
        this.value = new double[capacity];
    }

    public Float2DoubleArrayMap(Float2DoubleMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Float2DoubleMap.Entry> it = m.float2DoubleEntrySet().iterator();
        while (it.hasNext()) {
            Float2DoubleMap.Entry e = it.next();
            this.key[i] = e.getFloatKey();
            this.value[i] = e.getDoubleValue();
            i++;
        }
        this.size = i;
    }

    public Float2DoubleArrayMap(Map<? extends Float, ? extends Double> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Float, ? extends Double> e : m.entrySet()) {
            this.key[i] = ((Float) e.getKey()).floatValue();
            this.value[i] = ((Double) e.getValue()).doubleValue();
            i++;
        }
        this.size = i;
    }

    public Float2DoubleArrayMap(float[] key, double[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Float2DoubleMap.Entry> implements Float2DoubleMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Float2DoubleMap.Entry> iterator() {
            return new ObjectIterator<Float2DoubleMap.Entry>() { // from class: it.unimi.dsi.fastutil.floats.Float2DoubleArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Float2DoubleArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Float2DoubleMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    float[] fArr = Float2DoubleArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    float f = fArr[i];
                    double[] dArr = Float2DoubleArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractFloat2DoubleMap.BasicEntry(f, dArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Float2DoubleArrayMap.access$010(Float2DoubleArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Float2DoubleArrayMap.this.key, this.next + 1, Float2DoubleArrayMap.this.key, this.next, tail);
                    System.arraycopy(Float2DoubleArrayMap.this.value, this.next + 1, Float2DoubleArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Float2DoubleMap.Entry> action) {
                    int max = Float2DoubleArrayMap.this.size;
                    while (this.next < max) {
                        float[] fArr = Float2DoubleArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        float f = fArr[i];
                        double[] dArr = Float2DoubleArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractFloat2DoubleMap.BasicEntry(f, dArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap.FastEntrySet
        public ObjectIterator<Float2DoubleMap.Entry> fastIterator() {
            return new ObjectIterator<Float2DoubleMap.Entry>() { // from class: it.unimi.dsi.fastutil.floats.Float2DoubleArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractFloat2DoubleMap.BasicEntry entry = new AbstractFloat2DoubleMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Float2DoubleArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Float2DoubleMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractFloat2DoubleMap.BasicEntry basicEntry = this.entry;
                    float[] fArr = Float2DoubleArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = fArr[i];
                    AbstractFloat2DoubleMap.BasicEntry basicEntry2 = this.entry;
                    double[] dArr = Float2DoubleArrayMap.this.value;
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
                    int access$010 = Float2DoubleArrayMap.access$010(Float2DoubleArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Float2DoubleArrayMap.this.key, this.next + 1, Float2DoubleArrayMap.this.key, this.next, tail);
                    System.arraycopy(Float2DoubleArrayMap.this.value, this.next + 1, Float2DoubleArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Float2DoubleMap.Entry> action) {
                    int max = Float2DoubleArrayMap.this.size;
                    while (this.next < max) {
                        AbstractFloat2DoubleMap.BasicEntry basicEntry = this.entry;
                        float[] fArr = Float2DoubleArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = fArr[i];
                        AbstractFloat2DoubleMap.BasicEntry basicEntry2 = this.entry;
                        double[] dArr = Float2DoubleArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = dArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Float2DoubleMap.Entry> implements ObjectSpliterator<Float2DoubleMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Float2DoubleMap.Entry get(int location) {
                return new AbstractFloat2DoubleMap.BasicEntry(Float2DoubleArrayMap.this.key[location], Float2DoubleArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Float2DoubleMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Float2DoubleArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Float2DoubleMap.Entry> action) {
            int max = Float2DoubleArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractFloat2DoubleMap.BasicEntry(Float2DoubleArrayMap.this.key[i], Float2DoubleArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap.FastEntrySet
        public void fastForEach(Consumer<? super Float2DoubleMap.Entry> action) {
            AbstractFloat2DoubleMap.BasicEntry entry = new AbstractFloat2DoubleMap.BasicEntry();
            int max = Float2DoubleArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Float2DoubleArrayMap.this.key[i];
                entry.value = Float2DoubleArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Float2DoubleArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Float) || e.getValue() == null || !(e.getValue() instanceof Double)) {
                return false;
            }
            float k = ((Float) e.getKey()).floatValue();
            return Float2DoubleArrayMap.this.containsKey(k) && Double.doubleToLongBits(Float2DoubleArrayMap.this.get(k)) == Double.doubleToLongBits(((Double) e.getValue()).doubleValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Float) || e.getValue() == null || !(e.getValue() instanceof Double)) {
                return false;
            }
            float k = ((Float) e.getKey()).floatValue();
            double v = ((Double) e.getValue()).doubleValue();
            int oldPos = Float2DoubleArrayMap.this.findKey(k);
            if (oldPos == -1 || Double.doubleToLongBits(v) != Double.doubleToLongBits(Float2DoubleArrayMap.this.value[oldPos])) {
                return false;
            }
            int tail = (Float2DoubleArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Float2DoubleArrayMap.this.key, oldPos + 1, Float2DoubleArrayMap.this.key, oldPos, tail);
            System.arraycopy(Float2DoubleArrayMap.this.value, oldPos + 1, Float2DoubleArrayMap.this.value, oldPos, tail);
            Float2DoubleArrayMap.access$010(Float2DoubleArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
    public Float2DoubleMap.FastEntrySet float2DoubleEntrySet() {
        if (this.entries == null) {
            this.entries = new EntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    public int findKey(float k) {
        float[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (Float.floatToIntBits(key[i]) != Float.floatToIntBits(k));
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
    public double get(float k) {
        float[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return this.defRetValue;
            }
        } while (Float.floatToIntBits(key[i]) != Float.floatToIntBits(k));
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

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
    public boolean containsKey(float k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
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

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
    public double put(float k, double v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            double oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            float[] newKey = new float[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
    public double remove(float k) {
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
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleArrayMap$KeySet.class */
    public final class KeySet extends AbstractFloatSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return Float2DoubleArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.FloatSet
        public boolean remove(float k) {
            int oldPos = Float2DoubleArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Float2DoubleArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Float2DoubleArrayMap.this.key, oldPos + 1, Float2DoubleArrayMap.this.key, oldPos, tail);
            System.arraycopy(Float2DoubleArrayMap.this.value, oldPos + 1, Float2DoubleArrayMap.this.value, oldPos, tail);
            Float2DoubleArrayMap.access$010(Float2DoubleArrayMap.this);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatIterator iterator() {
            return new FloatIterator() { // from class: it.unimi.dsi.fastutil.floats.Float2DoubleArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Float2DoubleArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                public float nextFloat() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    float[] fArr = Float2DoubleArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return fArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Float2DoubleArrayMap.this.size - this.pos;
                    System.arraycopy(Float2DoubleArrayMap.this.key, this.pos, Float2DoubleArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Float2DoubleArrayMap.this.value, this.pos, Float2DoubleArrayMap.this.value, this.pos - 1, tail);
                    Float2DoubleArrayMap.access$010(Float2DoubleArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                public void forEachRemaining(FloatConsumer action) {
                    int max = Float2DoubleArrayMap.this.size;
                    while (this.pos < max) {
                        float[] fArr = Float2DoubleArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(fArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleArrayMap$KeySet$KeySetSpliterator.class */
        public final class KeySetSpliterator extends FloatSpliterators.EarlyBindingSizeIndexBasedSpliterator implements FloatSpliterator {
            KeySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16721;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            protected final float get(int location) {
                return Float2DoubleArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(FloatConsumer action) {
                int max = Float2DoubleArrayMap.this.size;
                while (this.pos < max) {
                    float[] fArr = Float2DoubleArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(fArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return new KeySetSpliterator(0, Float2DoubleArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
        public void forEach(FloatConsumer action) {
            int max = Float2DoubleArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Float2DoubleArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Float2DoubleArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Float2DoubleArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
    public Set<Float> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractDoubleCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double v) {
            return Float2DoubleArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator iterator() {
            return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.floats.Float2DoubleArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Float2DoubleArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                public double nextDouble() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    double[] dArr = Float2DoubleArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return dArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Float2DoubleArrayMap.this.size - this.pos;
                    System.arraycopy(Float2DoubleArrayMap.this.key, this.pos, Float2DoubleArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Float2DoubleArrayMap.this.value, this.pos, Float2DoubleArrayMap.this.value, this.pos - 1, tail);
                    Float2DoubleArrayMap.access$010(Float2DoubleArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfDouble
                public void forEachRemaining(DoubleConsumer action) {
                    int max = Float2DoubleArrayMap.this.size;
                    while (this.pos < max) {
                        double[] dArr = Float2DoubleArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(dArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleArrayMap$ValuesCollection$ValuesSpliterator.class */
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
                return Float2DoubleArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfDouble
            public void forEachRemaining(DoubleConsumer action) {
                int max = Float2DoubleArrayMap.this.size;
                while (this.pos < max) {
                    double[] dArr = Float2DoubleArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(dArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return new ValuesSpliterator(0, Float2DoubleArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer action) {
            int max = Float2DoubleArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Float2DoubleArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Float2DoubleArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Float2DoubleArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
    public Collection<Double> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Float2DoubleArrayMap clone() {
        try {
            Float2DoubleArrayMap c = (Float2DoubleArrayMap) clone();
            c.key = (float[]) this.key.clone();
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
            s.writeFloat(this.key[i]);
            s.writeDouble(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new float[this.size];
        this.value = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readFloat();
            this.value[i] = s.readDouble();
        }
    }
}
