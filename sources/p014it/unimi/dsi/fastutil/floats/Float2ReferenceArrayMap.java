package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2ReferenceMap;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectArrays;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceArrayMap.class */
public class Float2ReferenceArrayMap<V> extends AbstractFloat2ReferenceMap<V> implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient float[] key;
    private transient Object[] value;
    private int size;
    private transient Float2ReferenceMap.FastEntrySet<V> entries;
    private transient FloatSet keys;
    private transient ReferenceCollection<V> values;

    static /* synthetic */ int access$010(Float2ReferenceArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Float2ReferenceArrayMap(float[] key, Object[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Float2ReferenceArrayMap() {
        this.key = FloatArrays.EMPTY_ARRAY;
        this.value = ObjectArrays.EMPTY_ARRAY;
    }

    public Float2ReferenceArrayMap(int capacity) {
        this.key = new float[capacity];
        this.value = new Object[capacity];
    }

    public Float2ReferenceArrayMap(Float2ReferenceMap<V> m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Float2ReferenceMap.Entry<V>> it = m.float2ReferenceEntrySet().iterator();
        while (it.hasNext()) {
            Float2ReferenceMap.Entry<V> e = it.next();
            this.key[i] = e.getFloatKey();
            this.value[i] = e.getValue();
            i++;
        }
        this.size = i;
    }

    public Float2ReferenceArrayMap(Map<? extends Float, ? extends V> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Float, ? extends V> e : m.entrySet()) {
            this.key[i] = ((Float) e.getKey()).floatValue();
            this.value[i] = e.getValue();
            i++;
        }
        this.size = i;
    }

    public Float2ReferenceArrayMap(float[] key, Object[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Float2ReferenceMap.Entry<V>> implements Float2ReferenceMap.FastEntrySet<V> {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Float2ReferenceMap.Entry<V>> iterator() {
            return new ObjectIterator<Float2ReferenceMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.floats.Float2ReferenceArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Float2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Float2ReferenceMap.Entry<V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    float[] fArr = Float2ReferenceArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    float f = fArr[i];
                    Object[] objArr = Float2ReferenceArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractFloat2ReferenceMap.BasicEntry(f, objArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Float2ReferenceArrayMap.access$010(Float2ReferenceArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Float2ReferenceArrayMap.this.key, this.next + 1, Float2ReferenceArrayMap.this.key, this.next, tail);
                    System.arraycopy(Float2ReferenceArrayMap.this.value, this.next + 1, Float2ReferenceArrayMap.this.value, this.next, tail);
                    Float2ReferenceArrayMap.this.value[Float2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Float2ReferenceMap.Entry<V>> action) {
                    int max = Float2ReferenceArrayMap.this.size;
                    while (this.next < max) {
                        float[] fArr = Float2ReferenceArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        float f = fArr[i];
                        Object[] objArr = Float2ReferenceArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractFloat2ReferenceMap.BasicEntry(f, objArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap.FastEntrySet
        public ObjectIterator<Float2ReferenceMap.Entry<V>> fastIterator() {
            return new ObjectIterator<Float2ReferenceMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.floats.Float2ReferenceArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractFloat2ReferenceMap.BasicEntry<V> entry = new AbstractFloat2ReferenceMap.BasicEntry<>();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Float2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Float2ReferenceMap.Entry<V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractFloat2ReferenceMap.BasicEntry<V> basicEntry = this.entry;
                    float[] fArr = Float2ReferenceArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = fArr[i];
                    AbstractFloat2ReferenceMap.BasicEntry<V> basicEntry2 = this.entry;
                    Object[] objArr = Float2ReferenceArrayMap.this.value;
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
                    int access$010 = Float2ReferenceArrayMap.access$010(Float2ReferenceArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Float2ReferenceArrayMap.this.key, this.next + 1, Float2ReferenceArrayMap.this.key, this.next, tail);
                    System.arraycopy(Float2ReferenceArrayMap.this.value, this.next + 1, Float2ReferenceArrayMap.this.value, this.next, tail);
                    Float2ReferenceArrayMap.this.value[Float2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Float2ReferenceMap.Entry<V>> action) {
                    int max = Float2ReferenceArrayMap.this.size;
                    while (this.next < max) {
                        AbstractFloat2ReferenceMap.BasicEntry<V> basicEntry = this.entry;
                        float[] fArr = Float2ReferenceArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = fArr[i];
                        AbstractFloat2ReferenceMap.BasicEntry<V> basicEntry2 = this.entry;
                        Object[] objArr = Float2ReferenceArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = (V) objArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Float2ReferenceMap.Entry<V>> implements ObjectSpliterator<Float2ReferenceMap.Entry<V>> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Float2ReferenceMap.Entry<V> get(int location) {
                return new AbstractFloat2ReferenceMap.BasicEntry(Float2ReferenceArrayMap.this.key[location], Float2ReferenceArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Float2ReferenceArrayMap<V>.EntrySet.EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Float2ReferenceMap.Entry<V>> spliterator() {
            return new EntrySetSpliterator(0, Float2ReferenceArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Float2ReferenceMap.Entry<V>> action) {
            int max = Float2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractFloat2ReferenceMap.BasicEntry(Float2ReferenceArrayMap.this.key[i], Float2ReferenceArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap.FastEntrySet
        public void fastForEach(Consumer<? super Float2ReferenceMap.Entry<V>> action) {
            AbstractFloat2ReferenceMap.BasicEntry<V> entry = new AbstractFloat2ReferenceMap.BasicEntry<>();
            int max = Float2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Float2ReferenceArrayMap.this.key[i];
                entry.value = (V) Float2ReferenceArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Float2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Float)) {
                return false;
            }
            float k = ((Float) e.getKey()).floatValue();
            return Float2ReferenceArrayMap.this.containsKey(k) && Float2ReferenceArrayMap.this.get(k) == e.getValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Float)) {
                return false;
            }
            float k = ((Float) e.getKey()).floatValue();
            Object value = e.getValue();
            int oldPos = Float2ReferenceArrayMap.this.findKey(k);
            if (oldPos == -1 || value != Float2ReferenceArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Float2ReferenceArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Float2ReferenceArrayMap.this.key, oldPos + 1, Float2ReferenceArrayMap.this.key, oldPos, tail);
            System.arraycopy(Float2ReferenceArrayMap.this.value, oldPos + 1, Float2ReferenceArrayMap.this.value, oldPos, tail);
            Float2ReferenceArrayMap.access$010(Float2ReferenceArrayMap.this);
            Float2ReferenceArrayMap.this.value[Float2ReferenceArrayMap.this.size] = null;
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
    public Float2ReferenceMap.FastEntrySet<V> float2ReferenceEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
    public V get(float k) {
        float[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return (V) this.defRetValue;
            }
        } while (Float.floatToIntBits(key[i]) != Float.floatToIntBits(k));
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

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ReferenceMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
    public boolean containsKey(float k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ReferenceMap, java.util.Map
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

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ReferenceMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
    public V put(float k, V v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            V oldValue = (V) this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            float[] newKey = new float[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
    public V remove(float k) {
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
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceArrayMap$KeySet.class */
    public final class KeySet extends AbstractFloatSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return Float2ReferenceArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.FloatSet
        public boolean remove(float k) {
            int oldPos = Float2ReferenceArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Float2ReferenceArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Float2ReferenceArrayMap.this.key, oldPos + 1, Float2ReferenceArrayMap.this.key, oldPos, tail);
            System.arraycopy(Float2ReferenceArrayMap.this.value, oldPos + 1, Float2ReferenceArrayMap.this.value, oldPos, tail);
            Float2ReferenceArrayMap.access$010(Float2ReferenceArrayMap.this);
            Float2ReferenceArrayMap.this.value[Float2ReferenceArrayMap.this.size] = null;
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatIterator iterator() {
            return new FloatIterator() { // from class: it.unimi.dsi.fastutil.floats.Float2ReferenceArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Float2ReferenceArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                public float nextFloat() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    float[] fArr = Float2ReferenceArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return fArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Float2ReferenceArrayMap.this.size - this.pos;
                    System.arraycopy(Float2ReferenceArrayMap.this.key, this.pos, Float2ReferenceArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Float2ReferenceArrayMap.this.value, this.pos, Float2ReferenceArrayMap.this.value, this.pos - 1, tail);
                    Float2ReferenceArrayMap.access$010(Float2ReferenceArrayMap.this);
                    this.pos--;
                    Float2ReferenceArrayMap.this.value[Float2ReferenceArrayMap.this.size] = null;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                public void forEachRemaining(FloatConsumer action) {
                    int max = Float2ReferenceArrayMap.this.size;
                    while (this.pos < max) {
                        float[] fArr = Float2ReferenceArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(fArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceArrayMap$KeySet$KeySetSpliterator.class */
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
                return Float2ReferenceArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public final Float2ReferenceArrayMap<V>.KeySet.KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(FloatConsumer action) {
                int max = Float2ReferenceArrayMap.this.size;
                while (this.pos < max) {
                    float[] fArr = Float2ReferenceArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(fArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return new KeySetSpliterator(0, Float2ReferenceArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
        public void forEach(FloatConsumer action) {
            int max = Float2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Float2ReferenceArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Float2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Float2ReferenceArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ReferenceMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
    public Set<Float> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractReferenceCollection<V> {
        private ValuesCollection() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object v) {
            return Float2ReferenceArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectIterator<V> iterator() {
            return new ObjectIterator<V>() { // from class: it.unimi.dsi.fastutil.floats.Float2ReferenceArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Float2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public V next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Float2ReferenceArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return (V) objArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Float2ReferenceArrayMap.this.size - this.pos;
                    System.arraycopy(Float2ReferenceArrayMap.this.key, this.pos, Float2ReferenceArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Float2ReferenceArrayMap.this.value, this.pos, Float2ReferenceArrayMap.this.value, this.pos - 1, tail);
                    Float2ReferenceArrayMap.access$010(Float2ReferenceArrayMap.this);
                    this.pos--;
                    Float2ReferenceArrayMap.this.value[Float2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super V> action) {
                    int max = Float2ReferenceArrayMap.this.size;
                    while (this.pos < max) {
                        Object[] objArr = Float2ReferenceArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(objArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceArrayMap$ValuesCollection$ValuesSpliterator.class */
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
                return (V) Float2ReferenceArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Float2ReferenceArrayMap<V>.ValuesCollection.ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super V> action) {
                int max = Float2ReferenceArrayMap.this.size;
                while (this.pos < max) {
                    Object[] objArr = Float2ReferenceArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(objArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<V> spliterator() {
            return new ValuesSpliterator(0, Float2ReferenceArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> action) {
            int max = Float2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Float2ReferenceArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Float2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Float2ReferenceArrayMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ReferenceMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Float2ReferenceArrayMap<V> clone() {
        try {
            Float2ReferenceArrayMap<V> c = (Float2ReferenceArrayMap) clone();
            c.key = (float[]) this.key.clone();
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
            s.writeFloat(this.key[i]);
            s.writeObject(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new float[this.size];
        this.value = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readFloat();
            this.value[i] = s.readObject();
        }
    }
}
