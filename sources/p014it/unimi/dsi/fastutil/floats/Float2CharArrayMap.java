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
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharArrays;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharConsumer;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterators;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap;
import p014it.unimi.dsi.fastutil.floats.Float2CharMap;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2CharArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharArrayMap.class */
public class Float2CharArrayMap extends AbstractFloat2CharMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient float[] key;
    private transient char[] value;
    private int size;
    private transient Float2CharMap.FastEntrySet entries;
    private transient FloatSet keys;
    private transient CharCollection values;

    static /* synthetic */ int access$010(Float2CharArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Float2CharArrayMap(float[] key, char[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Float2CharArrayMap() {
        this.key = FloatArrays.EMPTY_ARRAY;
        this.value = CharArrays.EMPTY_ARRAY;
    }

    public Float2CharArrayMap(int capacity) {
        this.key = new float[capacity];
        this.value = new char[capacity];
    }

    public Float2CharArrayMap(Float2CharMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Float2CharMap.Entry> it = m.float2CharEntrySet().iterator();
        while (it.hasNext()) {
            Float2CharMap.Entry e = it.next();
            this.key[i] = e.getFloatKey();
            this.value[i] = e.getCharValue();
            i++;
        }
        this.size = i;
    }

    public Float2CharArrayMap(Map<? extends Float, ? extends Character> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Float, ? extends Character> e : m.entrySet()) {
            this.key[i] = ((Float) e.getKey()).floatValue();
            this.value[i] = ((Character) e.getValue()).charValue();
            i++;
        }
        this.size = i;
    }

    public Float2CharArrayMap(float[] key, char[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Float2CharMap.Entry> implements Float2CharMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Float2CharMap.Entry> iterator() {
            return new ObjectIterator<Float2CharMap.Entry>() { // from class: it.unimi.dsi.fastutil.floats.Float2CharArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Float2CharArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Float2CharMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    float[] fArr = Float2CharArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    float f = fArr[i];
                    char[] cArr = Float2CharArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractFloat2CharMap.BasicEntry(f, cArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Float2CharArrayMap.access$010(Float2CharArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Float2CharArrayMap.this.key, this.next + 1, Float2CharArrayMap.this.key, this.next, tail);
                    System.arraycopy(Float2CharArrayMap.this.value, this.next + 1, Float2CharArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Float2CharMap.Entry> action) {
                    int max = Float2CharArrayMap.this.size;
                    while (this.next < max) {
                        float[] fArr = Float2CharArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        float f = fArr[i];
                        char[] cArr = Float2CharArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractFloat2CharMap.BasicEntry(f, cArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap.FastEntrySet
        public ObjectIterator<Float2CharMap.Entry> fastIterator() {
            return new ObjectIterator<Float2CharMap.Entry>() { // from class: it.unimi.dsi.fastutil.floats.Float2CharArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractFloat2CharMap.BasicEntry entry = new AbstractFloat2CharMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Float2CharArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Float2CharMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractFloat2CharMap.BasicEntry basicEntry = this.entry;
                    float[] fArr = Float2CharArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = fArr[i];
                    AbstractFloat2CharMap.BasicEntry basicEntry2 = this.entry;
                    char[] cArr = Float2CharArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = cArr[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Float2CharArrayMap.access$010(Float2CharArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Float2CharArrayMap.this.key, this.next + 1, Float2CharArrayMap.this.key, this.next, tail);
                    System.arraycopy(Float2CharArrayMap.this.value, this.next + 1, Float2CharArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Float2CharMap.Entry> action) {
                    int max = Float2CharArrayMap.this.size;
                    while (this.next < max) {
                        AbstractFloat2CharMap.BasicEntry basicEntry = this.entry;
                        float[] fArr = Float2CharArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = fArr[i];
                        AbstractFloat2CharMap.BasicEntry basicEntry2 = this.entry;
                        char[] cArr = Float2CharArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = cArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Float2CharMap.Entry> implements ObjectSpliterator<Float2CharMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Float2CharMap.Entry get(int location) {
                return new AbstractFloat2CharMap.BasicEntry(Float2CharArrayMap.this.key[location], Float2CharArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Float2CharMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Float2CharArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Float2CharMap.Entry> action) {
            int max = Float2CharArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractFloat2CharMap.BasicEntry(Float2CharArrayMap.this.key[i], Float2CharArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap.FastEntrySet
        public void fastForEach(Consumer<? super Float2CharMap.Entry> action) {
            AbstractFloat2CharMap.BasicEntry entry = new AbstractFloat2CharMap.BasicEntry();
            int max = Float2CharArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Float2CharArrayMap.this.key[i];
                entry.value = Float2CharArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Float2CharArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Float) || e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            float k = ((Float) e.getKey()).floatValue();
            return Float2CharArrayMap.this.containsKey(k) && Float2CharArrayMap.this.get(k) == ((Character) e.getValue()).charValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Float) || e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            float k = ((Float) e.getKey()).floatValue();
            char v = ((Character) e.getValue()).charValue();
            int oldPos = Float2CharArrayMap.this.findKey(k);
            if (oldPos == -1 || v != Float2CharArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Float2CharArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Float2CharArrayMap.this.key, oldPos + 1, Float2CharArrayMap.this.key, oldPos, tail);
            System.arraycopy(Float2CharArrayMap.this.value, oldPos + 1, Float2CharArrayMap.this.value, oldPos, tail);
            Float2CharArrayMap.access$010(Float2CharArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
    public Float2CharMap.FastEntrySet float2CharEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunction
    public char get(float k) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharFunction, p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public boolean containsKey(float k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public boolean containsValue(char v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (this.value[i] != v);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunction
    public char put(float k, char v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            char oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            float[] newKey = new float[this.size == 0 ? 2 : this.size * 2];
            char[] newValue = new char[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunction
    public char remove(float k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        char oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharArrayMap$KeySet.class */
    public final class KeySet extends AbstractFloatSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return Float2CharArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.FloatSet
        public boolean remove(float k) {
            int oldPos = Float2CharArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Float2CharArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Float2CharArrayMap.this.key, oldPos + 1, Float2CharArrayMap.this.key, oldPos, tail);
            System.arraycopy(Float2CharArrayMap.this.value, oldPos + 1, Float2CharArrayMap.this.value, oldPos, tail);
            Float2CharArrayMap.access$010(Float2CharArrayMap.this);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatIterator iterator() {
            return new FloatIterator() { // from class: it.unimi.dsi.fastutil.floats.Float2CharArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Float2CharArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                public float nextFloat() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    float[] fArr = Float2CharArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return fArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Float2CharArrayMap.this.size - this.pos;
                    System.arraycopy(Float2CharArrayMap.this.key, this.pos, Float2CharArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Float2CharArrayMap.this.value, this.pos, Float2CharArrayMap.this.value, this.pos - 1, tail);
                    Float2CharArrayMap.access$010(Float2CharArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                public void forEachRemaining(FloatConsumer action) {
                    int max = Float2CharArrayMap.this.size;
                    while (this.pos < max) {
                        float[] fArr = Float2CharArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(fArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharArrayMap$KeySet$KeySetSpliterator.class */
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
                return Float2CharArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(FloatConsumer action) {
                int max = Float2CharArrayMap.this.size;
                while (this.pos < max) {
                    float[] fArr = Float2CharArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(fArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return new KeySetSpliterator(0, Float2CharArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
        public void forEach(FloatConsumer action) {
            int max = Float2CharArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Float2CharArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Float2CharArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Float2CharArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
    public Set<Float> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractCharCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char v) {
            return Float2CharArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharIterator iterator() {
            return new CharIterator() { // from class: it.unimi.dsi.fastutil.floats.Float2CharArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Float2CharArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                public char nextChar() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    char[] cArr = Float2CharArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return cArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Float2CharArrayMap.this.size - this.pos;
                    System.arraycopy(Float2CharArrayMap.this.key, this.pos, Float2CharArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Float2CharArrayMap.this.value, this.pos, Float2CharArrayMap.this.value, this.pos - 1, tail);
                    Float2CharArrayMap.access$010(Float2CharArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                public void forEachRemaining(CharConsumer action) {
                    int max = Float2CharArrayMap.this.size;
                    while (this.pos < max) {
                        char[] cArr = Float2CharArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(cArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharArrayMap$ValuesCollection$ValuesSpliterator.class */
        public final class ValuesSpliterator extends CharSpliterators.EarlyBindingSizeIndexBasedSpliterator implements CharSpliterator {
            ValuesSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16720;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            protected final char get(int location) {
                return Float2CharArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(CharConsumer action) {
                int max = Float2CharArrayMap.this.size;
                while (this.pos < max) {
                    char[] cArr = Float2CharArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(cArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return new ValuesSpliterator(0, Float2CharArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
        public void forEach(CharConsumer action) {
            int max = Float2CharArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Float2CharArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Float2CharArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Float2CharArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
    public Collection<Character> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Float2CharArrayMap clone() {
        try {
            Float2CharArrayMap c = (Float2CharArrayMap) clone();
            c.key = (float[]) this.key.clone();
            c.value = (char[]) this.value.clone();
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
            s.writeChar(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new float[this.size];
        this.value = new char[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readFloat();
            this.value[i] = s.readChar();
        }
    }
}
