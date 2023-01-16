package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectArrays;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterators;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectArrayMap.class */
public class Short2ObjectArrayMap<V> extends AbstractShort2ObjectMap<V> implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient short[] key;
    private transient Object[] value;
    private int size;
    private transient Short2ObjectMap.FastEntrySet<V> entries;
    private transient ShortSet keys;
    private transient ObjectCollection<V> values;

    static /* synthetic */ int access$010(Short2ObjectArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Short2ObjectArrayMap(short[] key, Object[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Short2ObjectArrayMap() {
        this.key = ShortArrays.EMPTY_ARRAY;
        this.value = ObjectArrays.EMPTY_ARRAY;
    }

    public Short2ObjectArrayMap(int capacity) {
        this.key = new short[capacity];
        this.value = new Object[capacity];
    }

    public Short2ObjectArrayMap(Short2ObjectMap<V> m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Short2ObjectMap.Entry<V>> it = m.short2ObjectEntrySet().iterator();
        while (it.hasNext()) {
            Short2ObjectMap.Entry<V> e = it.next();
            this.key[i] = e.getShortKey();
            this.value[i] = e.getValue();
            i++;
        }
        this.size = i;
    }

    public Short2ObjectArrayMap(Map<? extends Short, ? extends V> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Short, ? extends V> e : m.entrySet()) {
            this.key[i] = ((Short) e.getKey()).shortValue();
            this.value[i] = e.getValue();
            i++;
        }
        this.size = i;
    }

    public Short2ObjectArrayMap(short[] key, Object[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Short2ObjectMap.Entry<V>> implements Short2ObjectMap.FastEntrySet<V> {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Short2ObjectMap.Entry<V>> iterator() {
            return new ObjectIterator<Short2ObjectMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.shorts.Short2ObjectArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Short2ObjectArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Short2ObjectMap.Entry<V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    short[] sArr = Short2ObjectArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    short s = sArr[i];
                    Object[] objArr = Short2ObjectArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractShort2ObjectMap.BasicEntry(s, objArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Short2ObjectArrayMap.access$010(Short2ObjectArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Short2ObjectArrayMap.this.key, this.next + 1, Short2ObjectArrayMap.this.key, this.next, tail);
                    System.arraycopy(Short2ObjectArrayMap.this.value, this.next + 1, Short2ObjectArrayMap.this.value, this.next, tail);
                    Short2ObjectArrayMap.this.value[Short2ObjectArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Short2ObjectMap.Entry<V>> action) {
                    int max = Short2ObjectArrayMap.this.size;
                    while (this.next < max) {
                        short[] sArr = Short2ObjectArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        short s = sArr[i];
                        Object[] objArr = Short2ObjectArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractShort2ObjectMap.BasicEntry(s, objArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap.FastEntrySet
        public ObjectIterator<Short2ObjectMap.Entry<V>> fastIterator() {
            return new ObjectIterator<Short2ObjectMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.shorts.Short2ObjectArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractShort2ObjectMap.BasicEntry<V> entry = new AbstractShort2ObjectMap.BasicEntry<>();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Short2ObjectArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Short2ObjectMap.Entry<V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractShort2ObjectMap.BasicEntry<V> basicEntry = this.entry;
                    short[] sArr = Short2ObjectArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = sArr[i];
                    AbstractShort2ObjectMap.BasicEntry<V> basicEntry2 = this.entry;
                    Object[] objArr = Short2ObjectArrayMap.this.value;
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
                    int access$010 = Short2ObjectArrayMap.access$010(Short2ObjectArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Short2ObjectArrayMap.this.key, this.next + 1, Short2ObjectArrayMap.this.key, this.next, tail);
                    System.arraycopy(Short2ObjectArrayMap.this.value, this.next + 1, Short2ObjectArrayMap.this.value, this.next, tail);
                    Short2ObjectArrayMap.this.value[Short2ObjectArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Short2ObjectMap.Entry<V>> action) {
                    int max = Short2ObjectArrayMap.this.size;
                    while (this.next < max) {
                        AbstractShort2ObjectMap.BasicEntry<V> basicEntry = this.entry;
                        short[] sArr = Short2ObjectArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = sArr[i];
                        AbstractShort2ObjectMap.BasicEntry<V> basicEntry2 = this.entry;
                        Object[] objArr = Short2ObjectArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = (V) objArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Short2ObjectMap.Entry<V>> implements ObjectSpliterator<Short2ObjectMap.Entry<V>> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Short2ObjectMap.Entry<V> get(int location) {
                return new AbstractShort2ObjectMap.BasicEntry(Short2ObjectArrayMap.this.key[location], Short2ObjectArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Short2ObjectArrayMap<V>.EntrySet.EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Short2ObjectMap.Entry<V>> spliterator() {
            return new EntrySetSpliterator(0, Short2ObjectArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Short2ObjectMap.Entry<V>> action) {
            int max = Short2ObjectArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractShort2ObjectMap.BasicEntry(Short2ObjectArrayMap.this.key[i], Short2ObjectArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap.FastEntrySet
        public void fastForEach(Consumer<? super Short2ObjectMap.Entry<V>> action) {
            AbstractShort2ObjectMap.BasicEntry<V> entry = new AbstractShort2ObjectMap.BasicEntry<>();
            int max = Short2ObjectArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Short2ObjectArrayMap.this.key[i];
                entry.value = (V) Short2ObjectArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Short2ObjectArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            return Short2ObjectArrayMap.this.containsKey(k) && Objects.equals(Short2ObjectArrayMap.this.get(k), e.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            Object value = e.getValue();
            int oldPos = Short2ObjectArrayMap.this.findKey(k);
            if (oldPos == -1 || !Objects.equals(value, Short2ObjectArrayMap.this.value[oldPos])) {
                return false;
            }
            int tail = (Short2ObjectArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Short2ObjectArrayMap.this.key, oldPos + 1, Short2ObjectArrayMap.this.key, oldPos, tail);
            System.arraycopy(Short2ObjectArrayMap.this.value, oldPos + 1, Short2ObjectArrayMap.this.value, oldPos, tail);
            Short2ObjectArrayMap.access$010(Short2ObjectArrayMap.this);
            Short2ObjectArrayMap.this.value[Short2ObjectArrayMap.this.size] = null;
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
    public Short2ObjectMap.FastEntrySet<V> short2ObjectEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
    public V get(short k) {
        short[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return (V) this.defRetValue;
            }
        } while (key[i] != k);
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
    public boolean containsKey(short k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, java.util.Map
    public boolean containsValue(Object v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (!Objects.equals(this.value[i], v));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
    public V put(short k, V v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            V oldValue = (V) this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            short[] newKey = new short[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
    public V remove(short k) {
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
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectArrayMap$KeySet.class */
    public final class KeySet extends AbstractShortSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return Short2ObjectArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.ShortSet
        public boolean remove(short k) {
            int oldPos = Short2ObjectArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Short2ObjectArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Short2ObjectArrayMap.this.key, oldPos + 1, Short2ObjectArrayMap.this.key, oldPos, tail);
            System.arraycopy(Short2ObjectArrayMap.this.value, oldPos + 1, Short2ObjectArrayMap.this.value, oldPos, tail);
            Short2ObjectArrayMap.access$010(Short2ObjectArrayMap.this);
            Short2ObjectArrayMap.this.value[Short2ObjectArrayMap.this.size] = null;
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortIterator iterator() {
            return new ShortIterator() { // from class: it.unimi.dsi.fastutil.shorts.Short2ObjectArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Short2ObjectArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                public short nextShort() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    short[] sArr = Short2ObjectArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return sArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Short2ObjectArrayMap.this.size - this.pos;
                    System.arraycopy(Short2ObjectArrayMap.this.key, this.pos, Short2ObjectArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Short2ObjectArrayMap.this.value, this.pos, Short2ObjectArrayMap.this.value, this.pos - 1, tail);
                    Short2ObjectArrayMap.access$010(Short2ObjectArrayMap.this);
                    this.pos--;
                    Short2ObjectArrayMap.this.value[Short2ObjectArrayMap.this.size] = null;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                public void forEachRemaining(ShortConsumer action) {
                    int max = Short2ObjectArrayMap.this.size;
                    while (this.pos < max) {
                        short[] sArr = Short2ObjectArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(sArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectArrayMap$KeySet$KeySetSpliterator.class */
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
                return Short2ObjectArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            public final Short2ObjectArrayMap<V>.KeySet.KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ShortConsumer action) {
                int max = Short2ObjectArrayMap.this.size;
                while (this.pos < max) {
                    short[] sArr = Short2ObjectArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(sArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return new KeySetSpliterator(0, Short2ObjectArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public void forEach(ShortConsumer action) {
            int max = Short2ObjectArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Short2ObjectArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Short2ObjectArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Short2ObjectArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
    public Set<Short> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractObjectCollection<V> {
        private ValuesCollection() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object v) {
            return Short2ObjectArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<V> iterator() {
            return new ObjectIterator<V>() { // from class: it.unimi.dsi.fastutil.shorts.Short2ObjectArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Short2ObjectArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public V next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Short2ObjectArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return (V) objArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Short2ObjectArrayMap.this.size - this.pos;
                    System.arraycopy(Short2ObjectArrayMap.this.key, this.pos, Short2ObjectArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Short2ObjectArrayMap.this.value, this.pos, Short2ObjectArrayMap.this.value, this.pos - 1, tail);
                    Short2ObjectArrayMap.access$010(Short2ObjectArrayMap.this);
                    this.pos--;
                    Short2ObjectArrayMap.this.value[Short2ObjectArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super V> action) {
                    int max = Short2ObjectArrayMap.this.size;
                    while (this.pos < max) {
                        Object[] objArr = Short2ObjectArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(objArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectArrayMap$ValuesCollection$ValuesSpliterator.class */
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
                return (V) Short2ObjectArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Short2ObjectArrayMap<V>.ValuesCollection.ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super V> action) {
                int max = Short2ObjectArrayMap.this.size;
                while (this.pos < max) {
                    Object[] objArr = Short2ObjectArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(objArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<V> spliterator() {
            return new ValuesSpliterator(0, Short2ObjectArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> action) {
            int max = Short2ObjectArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Short2ObjectArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Short2ObjectArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Short2ObjectArrayMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Short2ObjectArrayMap<V> clone() {
        try {
            Short2ObjectArrayMap<V> c = (Short2ObjectArrayMap) clone();
            c.key = (short[]) this.key.clone();
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
            s.writeShort(this.key[i]);
            s.writeObject(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new short[this.size];
        this.value = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readShort();
            this.value[i] = s.readObject();
        }
    }
}
