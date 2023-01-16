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
import java.util.function.DoubleConsumer;
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleArrays;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterators;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleArrayMap.class */
public class Short2DoubleArrayMap extends AbstractShort2DoubleMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient short[] key;
    private transient double[] value;
    private int size;
    private transient Short2DoubleMap.FastEntrySet entries;
    private transient ShortSet keys;
    private transient DoubleCollection values;

    static /* synthetic */ int access$010(Short2DoubleArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Short2DoubleArrayMap(short[] key, double[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Short2DoubleArrayMap() {
        this.key = ShortArrays.EMPTY_ARRAY;
        this.value = DoubleArrays.EMPTY_ARRAY;
    }

    public Short2DoubleArrayMap(int capacity) {
        this.key = new short[capacity];
        this.value = new double[capacity];
    }

    public Short2DoubleArrayMap(Short2DoubleMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Short2DoubleMap.Entry> it = m.short2DoubleEntrySet().iterator();
        while (it.hasNext()) {
            Short2DoubleMap.Entry e = it.next();
            this.key[i] = e.getShortKey();
            this.value[i] = e.getDoubleValue();
            i++;
        }
        this.size = i;
    }

    public Short2DoubleArrayMap(Map<? extends Short, ? extends Double> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Short, ? extends Double> e : m.entrySet()) {
            this.key[i] = ((Short) e.getKey()).shortValue();
            this.value[i] = ((Double) e.getValue()).doubleValue();
            i++;
        }
        this.size = i;
    }

    public Short2DoubleArrayMap(short[] key, double[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Short2DoubleMap.Entry> implements Short2DoubleMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Short2DoubleMap.Entry> iterator() {
            return new ObjectIterator<Short2DoubleMap.Entry>() { // from class: it.unimi.dsi.fastutil.shorts.Short2DoubleArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Short2DoubleArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Short2DoubleMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    short[] sArr = Short2DoubleArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    short s = sArr[i];
                    double[] dArr = Short2DoubleArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractShort2DoubleMap.BasicEntry(s, dArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Short2DoubleArrayMap.access$010(Short2DoubleArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Short2DoubleArrayMap.this.key, this.next + 1, Short2DoubleArrayMap.this.key, this.next, tail);
                    System.arraycopy(Short2DoubleArrayMap.this.value, this.next + 1, Short2DoubleArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Short2DoubleMap.Entry> action) {
                    int max = Short2DoubleArrayMap.this.size;
                    while (this.next < max) {
                        short[] sArr = Short2DoubleArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        short s = sArr[i];
                        double[] dArr = Short2DoubleArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractShort2DoubleMap.BasicEntry(s, dArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap.FastEntrySet
        public ObjectIterator<Short2DoubleMap.Entry> fastIterator() {
            return new ObjectIterator<Short2DoubleMap.Entry>() { // from class: it.unimi.dsi.fastutil.shorts.Short2DoubleArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractShort2DoubleMap.BasicEntry entry = new AbstractShort2DoubleMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Short2DoubleArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Short2DoubleMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractShort2DoubleMap.BasicEntry basicEntry = this.entry;
                    short[] sArr = Short2DoubleArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = sArr[i];
                    AbstractShort2DoubleMap.BasicEntry basicEntry2 = this.entry;
                    double[] dArr = Short2DoubleArrayMap.this.value;
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
                    int access$010 = Short2DoubleArrayMap.access$010(Short2DoubleArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Short2DoubleArrayMap.this.key, this.next + 1, Short2DoubleArrayMap.this.key, this.next, tail);
                    System.arraycopy(Short2DoubleArrayMap.this.value, this.next + 1, Short2DoubleArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Short2DoubleMap.Entry> action) {
                    int max = Short2DoubleArrayMap.this.size;
                    while (this.next < max) {
                        AbstractShort2DoubleMap.BasicEntry basicEntry = this.entry;
                        short[] sArr = Short2DoubleArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = sArr[i];
                        AbstractShort2DoubleMap.BasicEntry basicEntry2 = this.entry;
                        double[] dArr = Short2DoubleArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = dArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Short2DoubleMap.Entry> implements ObjectSpliterator<Short2DoubleMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Short2DoubleMap.Entry get(int location) {
                return new AbstractShort2DoubleMap.BasicEntry(Short2DoubleArrayMap.this.key[location], Short2DoubleArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Short2DoubleMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Short2DoubleArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Short2DoubleMap.Entry> action) {
            int max = Short2DoubleArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractShort2DoubleMap.BasicEntry(Short2DoubleArrayMap.this.key[i], Short2DoubleArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap.FastEntrySet
        public void fastForEach(Consumer<? super Short2DoubleMap.Entry> action) {
            AbstractShort2DoubleMap.BasicEntry entry = new AbstractShort2DoubleMap.BasicEntry();
            int max = Short2DoubleArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Short2DoubleArrayMap.this.key[i];
                entry.value = Short2DoubleArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Short2DoubleArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short) || e.getValue() == null || !(e.getValue() instanceof Double)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            return Short2DoubleArrayMap.this.containsKey(k) && Double.doubleToLongBits(Short2DoubleArrayMap.this.get(k)) == Double.doubleToLongBits(((Double) e.getValue()).doubleValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short) || e.getValue() == null || !(e.getValue() instanceof Double)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            double v = ((Double) e.getValue()).doubleValue();
            int oldPos = Short2DoubleArrayMap.this.findKey(k);
            if (oldPos == -1 || Double.doubleToLongBits(v) != Double.doubleToLongBits(Short2DoubleArrayMap.this.value[oldPos])) {
                return false;
            }
            int tail = (Short2DoubleArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Short2DoubleArrayMap.this.key, oldPos + 1, Short2DoubleArrayMap.this.key, oldPos, tail);
            System.arraycopy(Short2DoubleArrayMap.this.value, oldPos + 1, Short2DoubleArrayMap.this.value, oldPos, tail);
            Short2DoubleArrayMap.access$010(Short2DoubleArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
    public Short2DoubleMap.FastEntrySet short2DoubleEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction
    public double get(short k) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap
    public boolean containsKey(short k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction
    public double put(short k, double v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            double oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            short[] newKey = new short[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction
    public double remove(short k) {
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
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleArrayMap$KeySet.class */
    public final class KeySet extends AbstractShortSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return Short2DoubleArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.ShortSet
        public boolean remove(short k) {
            int oldPos = Short2DoubleArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Short2DoubleArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Short2DoubleArrayMap.this.key, oldPos + 1, Short2DoubleArrayMap.this.key, oldPos, tail);
            System.arraycopy(Short2DoubleArrayMap.this.value, oldPos + 1, Short2DoubleArrayMap.this.value, oldPos, tail);
            Short2DoubleArrayMap.access$010(Short2DoubleArrayMap.this);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortIterator iterator() {
            return new ShortIterator() { // from class: it.unimi.dsi.fastutil.shorts.Short2DoubleArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Short2DoubleArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                public short nextShort() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    short[] sArr = Short2DoubleArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return sArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Short2DoubleArrayMap.this.size - this.pos;
                    System.arraycopy(Short2DoubleArrayMap.this.key, this.pos, Short2DoubleArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Short2DoubleArrayMap.this.value, this.pos, Short2DoubleArrayMap.this.value, this.pos - 1, tail);
                    Short2DoubleArrayMap.access$010(Short2DoubleArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                public void forEachRemaining(ShortConsumer action) {
                    int max = Short2DoubleArrayMap.this.size;
                    while (this.pos < max) {
                        short[] sArr = Short2DoubleArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(sArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleArrayMap$KeySet$KeySetSpliterator.class */
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
                return Short2DoubleArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ShortConsumer action) {
                int max = Short2DoubleArrayMap.this.size;
                while (this.pos < max) {
                    short[] sArr = Short2DoubleArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(sArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return new KeySetSpliterator(0, Short2DoubleArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public void forEach(ShortConsumer action) {
            int max = Short2DoubleArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Short2DoubleArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Short2DoubleArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Short2DoubleArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
    public Set<Short> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractDoubleCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double v) {
            return Short2DoubleArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator iterator() {
            return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.shorts.Short2DoubleArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Short2DoubleArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                public double nextDouble() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    double[] dArr = Short2DoubleArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return dArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Short2DoubleArrayMap.this.size - this.pos;
                    System.arraycopy(Short2DoubleArrayMap.this.key, this.pos, Short2DoubleArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Short2DoubleArrayMap.this.value, this.pos, Short2DoubleArrayMap.this.value, this.pos - 1, tail);
                    Short2DoubleArrayMap.access$010(Short2DoubleArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfDouble
                public void forEachRemaining(DoubleConsumer action) {
                    int max = Short2DoubleArrayMap.this.size;
                    while (this.pos < max) {
                        double[] dArr = Short2DoubleArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(dArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleArrayMap$ValuesCollection$ValuesSpliterator.class */
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
                return Short2DoubleArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfDouble
            public void forEachRemaining(DoubleConsumer action) {
                int max = Short2DoubleArrayMap.this.size;
                while (this.pos < max) {
                    double[] dArr = Short2DoubleArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(dArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return new ValuesSpliterator(0, Short2DoubleArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer action) {
            int max = Short2DoubleArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Short2DoubleArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Short2DoubleArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Short2DoubleArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
    public Collection<Double> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Short2DoubleArrayMap clone() {
        try {
            Short2DoubleArrayMap c = (Short2DoubleArrayMap) clone();
            c.key = (short[]) this.key.clone();
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
            s.writeShort(this.key[i]);
            s.writeDouble(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new short[this.size];
        this.value = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readShort();
            this.value[i] = s.readDouble();
        }
    }
}
