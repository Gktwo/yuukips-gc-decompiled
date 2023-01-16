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
import p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteArrays;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteConsumer;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterator;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterators;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ByteMap;
import p014it.unimi.dsi.fastutil.doubles.Double2ByteMap;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteArrayMap.class */
public class Double2ByteArrayMap extends AbstractDouble2ByteMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient double[] key;
    private transient byte[] value;
    private int size;
    private transient Double2ByteMap.FastEntrySet entries;
    private transient DoubleSet keys;
    private transient ByteCollection values;

    static /* synthetic */ int access$010(Double2ByteArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Double2ByteArrayMap(double[] key, byte[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Double2ByteArrayMap() {
        this.key = DoubleArrays.EMPTY_ARRAY;
        this.value = ByteArrays.EMPTY_ARRAY;
    }

    public Double2ByteArrayMap(int capacity) {
        this.key = new double[capacity];
        this.value = new byte[capacity];
    }

    public Double2ByteArrayMap(Double2ByteMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Double2ByteMap.Entry> it = m.double2ByteEntrySet().iterator();
        while (it.hasNext()) {
            Double2ByteMap.Entry e = it.next();
            this.key[i] = e.getDoubleKey();
            this.value[i] = e.getByteValue();
            i++;
        }
        this.size = i;
    }

    public Double2ByteArrayMap(Map<? extends Double, ? extends Byte> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Double, ? extends Byte> e : m.entrySet()) {
            this.key[i] = ((Double) e.getKey()).doubleValue();
            this.value[i] = ((Byte) e.getValue()).byteValue();
            i++;
        }
        this.size = i;
    }

    public Double2ByteArrayMap(double[] key, byte[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Double2ByteMap.Entry> implements Double2ByteMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Double2ByteMap.Entry> iterator() {
            return new ObjectIterator<Double2ByteMap.Entry>() { // from class: it.unimi.dsi.fastutil.doubles.Double2ByteArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Double2ByteArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Double2ByteMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    double[] dArr = Double2ByteArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    double d = dArr[i];
                    byte[] bArr = Double2ByteArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractDouble2ByteMap.BasicEntry(d, bArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Double2ByteArrayMap.access$010(Double2ByteArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Double2ByteArrayMap.this.key, this.next + 1, Double2ByteArrayMap.this.key, this.next, tail);
                    System.arraycopy(Double2ByteArrayMap.this.value, this.next + 1, Double2ByteArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Double2ByteMap.Entry> action) {
                    int max = Double2ByteArrayMap.this.size;
                    while (this.next < max) {
                        double[] dArr = Double2ByteArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        double d = dArr[i];
                        byte[] bArr = Double2ByteArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractDouble2ByteMap.BasicEntry(d, bArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMap.FastEntrySet
        public ObjectIterator<Double2ByteMap.Entry> fastIterator() {
            return new ObjectIterator<Double2ByteMap.Entry>() { // from class: it.unimi.dsi.fastutil.doubles.Double2ByteArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractDouble2ByteMap.BasicEntry entry = new AbstractDouble2ByteMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Double2ByteArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Double2ByteMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractDouble2ByteMap.BasicEntry basicEntry = this.entry;
                    double[] dArr = Double2ByteArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = dArr[i];
                    AbstractDouble2ByteMap.BasicEntry basicEntry2 = this.entry;
                    byte[] bArr = Double2ByteArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = bArr[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Double2ByteArrayMap.access$010(Double2ByteArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Double2ByteArrayMap.this.key, this.next + 1, Double2ByteArrayMap.this.key, this.next, tail);
                    System.arraycopy(Double2ByteArrayMap.this.value, this.next + 1, Double2ByteArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Double2ByteMap.Entry> action) {
                    int max = Double2ByteArrayMap.this.size;
                    while (this.next < max) {
                        AbstractDouble2ByteMap.BasicEntry basicEntry = this.entry;
                        double[] dArr = Double2ByteArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = dArr[i];
                        AbstractDouble2ByteMap.BasicEntry basicEntry2 = this.entry;
                        byte[] bArr = Double2ByteArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = bArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Double2ByteMap.Entry> implements ObjectSpliterator<Double2ByteMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Double2ByteMap.Entry get(int location) {
                return new AbstractDouble2ByteMap.BasicEntry(Double2ByteArrayMap.this.key[location], Double2ByteArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Double2ByteMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Double2ByteArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Double2ByteMap.Entry> action) {
            int max = Double2ByteArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractDouble2ByteMap.BasicEntry(Double2ByteArrayMap.this.key[i], Double2ByteArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMap.FastEntrySet
        public void fastForEach(Consumer<? super Double2ByteMap.Entry> action) {
            AbstractDouble2ByteMap.BasicEntry entry = new AbstractDouble2ByteMap.BasicEntry();
            int max = Double2ByteArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Double2ByteArrayMap.this.key[i];
                entry.value = Double2ByteArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Double2ByteArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Double) || e.getValue() == null || !(e.getValue() instanceof Byte)) {
                return false;
            }
            double k = ((Double) e.getKey()).doubleValue();
            return Double2ByteArrayMap.this.containsKey(k) && Double2ByteArrayMap.this.get(k) == ((Byte) e.getValue()).byteValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Double) || e.getValue() == null || !(e.getValue() instanceof Byte)) {
                return false;
            }
            double k = ((Double) e.getKey()).doubleValue();
            byte v = ((Byte) e.getValue()).byteValue();
            int oldPos = Double2ByteArrayMap.this.findKey(k);
            if (oldPos == -1 || v != Double2ByteArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Double2ByteArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Double2ByteArrayMap.this.key, oldPos + 1, Double2ByteArrayMap.this.key, oldPos, tail);
            System.arraycopy(Double2ByteArrayMap.this.value, oldPos + 1, Double2ByteArrayMap.this.value, oldPos, tail);
            Double2ByteArrayMap.access$010(Double2ByteArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
    public Double2ByteMap.FastEntrySet double2ByteEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction
    public byte get(double k) {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ByteMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap
    public boolean containsKey(double k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ByteMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap
    public boolean containsValue(byte v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (this.value[i] != v);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ByteMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction
    public byte put(double k, byte v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            byte oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            double[] newKey = new double[this.size == 0 ? 2 : this.size * 2];
            byte[] newValue = new byte[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction
    public byte remove(double k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        byte oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteArrayMap$KeySet.class */
    public final class KeySet extends AbstractDoubleSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return Double2ByteArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
        public boolean remove(double k) {
            int oldPos = Double2ByteArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Double2ByteArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Double2ByteArrayMap.this.key, oldPos + 1, Double2ByteArrayMap.this.key, oldPos, tail);
            System.arraycopy(Double2ByteArrayMap.this.value, oldPos + 1, Double2ByteArrayMap.this.value, oldPos, tail);
            Double2ByteArrayMap.access$010(Double2ByteArrayMap.this);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator iterator() {
            return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.doubles.Double2ByteArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Double2ByteArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                public double nextDouble() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    double[] dArr = Double2ByteArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return dArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Double2ByteArrayMap.this.size - this.pos;
                    System.arraycopy(Double2ByteArrayMap.this.key, this.pos, Double2ByteArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Double2ByteArrayMap.this.value, this.pos, Double2ByteArrayMap.this.value, this.pos - 1, tail);
                    Double2ByteArrayMap.access$010(Double2ByteArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfDouble
                public void forEachRemaining(DoubleConsumer action) {
                    int max = Double2ByteArrayMap.this.size;
                    while (this.pos < max) {
                        double[] dArr = Double2ByteArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(dArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteArrayMap$KeySet$KeySetSpliterator.class */
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
                return Double2ByteArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfDouble
            public void forEachRemaining(DoubleConsumer action) {
                int max = Double2ByteArrayMap.this.size;
                while (this.pos < max) {
                    double[] dArr = Double2ByteArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(dArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return new KeySetSpliterator(0, Double2ByteArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer action) {
            int max = Double2ByteArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Double2ByteArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Double2ByteArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Double2ByteArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ByteMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, java.util.Map
    public Set<Double> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractByteCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte v) {
            return Double2ByteArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteIterator iterator() {
            return new ByteIterator() { // from class: it.unimi.dsi.fastutil.doubles.Double2ByteArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Double2ByteArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                public byte nextByte() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    byte[] bArr = Double2ByteArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return bArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Double2ByteArrayMap.this.size - this.pos;
                    System.arraycopy(Double2ByteArrayMap.this.key, this.pos, Double2ByteArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Double2ByteArrayMap.this.value, this.pos, Double2ByteArrayMap.this.value, this.pos - 1, tail);
                    Double2ByteArrayMap.access$010(Double2ByteArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                public void forEachRemaining(ByteConsumer action) {
                    int max = Double2ByteArrayMap.this.size;
                    while (this.pos < max) {
                        byte[] bArr = Double2ByteArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(bArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteArrayMap$ValuesCollection$ValuesSpliterator.class */
        public final class ValuesSpliterator extends ByteSpliterators.EarlyBindingSizeIndexBasedSpliterator implements ByteSpliterator {
            ValuesSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16720;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            protected final byte get(int location) {
                return Double2ByteArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ByteConsumer action) {
                int max = Double2ByteArrayMap.this.size;
                while (this.pos < max) {
                    byte[] bArr = Double2ByteArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(bArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteSpliterator spliterator() {
            return new ValuesSpliterator(0, Double2ByteArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public void forEach(ByteConsumer action) {
            int max = Double2ByteArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Double2ByteArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Double2ByteArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Double2ByteArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ByteMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, java.util.Map
    public Collection<Byte> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Double2ByteArrayMap clone() {
        try {
            Double2ByteArrayMap c = (Double2ByteArrayMap) clone();
            c.key = (double[]) this.key.clone();
            c.value = (byte[]) this.value.clone();
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
            s.writeByte(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new double[this.size];
        this.value = new byte[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readDouble();
            this.value[i] = s.readByte();
        }
    }
}
