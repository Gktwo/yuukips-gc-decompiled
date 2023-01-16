package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectArrays;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceArrayMap.class */
public class Int2ReferenceArrayMap<V> extends AbstractInt2ReferenceMap<V> implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient int[] key;
    private transient Object[] value;
    private int size;
    private transient Int2ReferenceMap.FastEntrySet<V> entries;
    private transient IntSet keys;
    private transient ReferenceCollection<V> values;

    static /* synthetic */ int access$010(Int2ReferenceArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Int2ReferenceArrayMap(int[] key, Object[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Int2ReferenceArrayMap() {
        this.key = IntArrays.EMPTY_ARRAY;
        this.value = ObjectArrays.EMPTY_ARRAY;
    }

    public Int2ReferenceArrayMap(int capacity) {
        this.key = new int[capacity];
        this.value = new Object[capacity];
    }

    public Int2ReferenceArrayMap(Int2ReferenceMap<V> m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Int2ReferenceMap.Entry<V>> it = m.int2ReferenceEntrySet().iterator();
        while (it.hasNext()) {
            Int2ReferenceMap.Entry<V> e = it.next();
            this.key[i] = e.getIntKey();
            this.value[i] = e.getValue();
            i++;
        }
        this.size = i;
    }

    public Int2ReferenceArrayMap(Map<? extends Integer, ? extends V> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Integer, ? extends V> e : m.entrySet()) {
            this.key[i] = ((Integer) e.getKey()).intValue();
            this.value[i] = e.getValue();
            i++;
        }
        this.size = i;
    }

    public Int2ReferenceArrayMap(int[] key, Object[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Int2ReferenceMap.Entry<V>> implements Int2ReferenceMap.FastEntrySet<V> {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Int2ReferenceMap.Entry<V>> iterator() {
            return new ObjectIterator<Int2ReferenceMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.ints.Int2ReferenceArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Int2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Int2ReferenceMap.Entry<V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int[] iArr = Int2ReferenceArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    int i2 = iArr[i];
                    Object[] objArr = Int2ReferenceArrayMap.this.value;
                    int i3 = this.next;
                    this.next = i3 + 1;
                    return new AbstractInt2ReferenceMap.BasicEntry(i2, objArr[i3]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Int2ReferenceArrayMap.access$010(Int2ReferenceArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Int2ReferenceArrayMap.this.key, this.next + 1, Int2ReferenceArrayMap.this.key, this.next, tail);
                    System.arraycopy(Int2ReferenceArrayMap.this.value, this.next + 1, Int2ReferenceArrayMap.this.value, this.next, tail);
                    Int2ReferenceArrayMap.this.value[Int2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Int2ReferenceMap.Entry<V>> action) {
                    int max = Int2ReferenceArrayMap.this.size;
                    while (this.next < max) {
                        int[] iArr = Int2ReferenceArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        int i2 = iArr[i];
                        Object[] objArr = Int2ReferenceArrayMap.this.value;
                        int i3 = this.next;
                        this.next = i3 + 1;
                        action.accept(new AbstractInt2ReferenceMap.BasicEntry(i2, objArr[i3]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap.FastEntrySet
        public ObjectIterator<Int2ReferenceMap.Entry<V>> fastIterator() {
            return new ObjectIterator<Int2ReferenceMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.ints.Int2ReferenceArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractInt2ReferenceMap.BasicEntry<V> entry = new AbstractInt2ReferenceMap.BasicEntry<>();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Int2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Int2ReferenceMap.Entry<V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractInt2ReferenceMap.BasicEntry<V> basicEntry = this.entry;
                    int[] iArr = Int2ReferenceArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = iArr[i];
                    AbstractInt2ReferenceMap.BasicEntry<V> basicEntry2 = this.entry;
                    Object[] objArr = Int2ReferenceArrayMap.this.value;
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
                    int access$010 = Int2ReferenceArrayMap.access$010(Int2ReferenceArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Int2ReferenceArrayMap.this.key, this.next + 1, Int2ReferenceArrayMap.this.key, this.next, tail);
                    System.arraycopy(Int2ReferenceArrayMap.this.value, this.next + 1, Int2ReferenceArrayMap.this.value, this.next, tail);
                    Int2ReferenceArrayMap.this.value[Int2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Int2ReferenceMap.Entry<V>> action) {
                    int max = Int2ReferenceArrayMap.this.size;
                    while (this.next < max) {
                        AbstractInt2ReferenceMap.BasicEntry<V> basicEntry = this.entry;
                        int[] iArr = Int2ReferenceArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = iArr[i];
                        AbstractInt2ReferenceMap.BasicEntry<V> basicEntry2 = this.entry;
                        Object[] objArr = Int2ReferenceArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = (V) objArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Int2ReferenceMap.Entry<V>> implements ObjectSpliterator<Int2ReferenceMap.Entry<V>> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Int2ReferenceMap.Entry<V> get(int location) {
                return new AbstractInt2ReferenceMap.BasicEntry(Int2ReferenceArrayMap.this.key[location], Int2ReferenceArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Int2ReferenceArrayMap<V>.EntrySet.EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Int2ReferenceMap.Entry<V>> spliterator() {
            return new EntrySetSpliterator(0, Int2ReferenceArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Int2ReferenceMap.Entry<V>> action) {
            int max = Int2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractInt2ReferenceMap.BasicEntry(Int2ReferenceArrayMap.this.key[i], Int2ReferenceArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap.FastEntrySet
        public void fastForEach(Consumer<? super Int2ReferenceMap.Entry<V>> action) {
            AbstractInt2ReferenceMap.BasicEntry<V> entry = new AbstractInt2ReferenceMap.BasicEntry<>();
            int max = Int2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Int2ReferenceArrayMap.this.key[i];
                entry.value = (V) Int2ReferenceArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            return Int2ReferenceArrayMap.this.containsKey(k) && Int2ReferenceArrayMap.this.get(k) == e.getValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            Object value = e.getValue();
            int oldPos = Int2ReferenceArrayMap.this.findKey(k);
            if (oldPos == -1 || value != Int2ReferenceArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Int2ReferenceArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Int2ReferenceArrayMap.this.key, oldPos + 1, Int2ReferenceArrayMap.this.key, oldPos, tail);
            System.arraycopy(Int2ReferenceArrayMap.this.value, oldPos + 1, Int2ReferenceArrayMap.this.value, oldPos, tail);
            Int2ReferenceArrayMap.access$010(Int2ReferenceArrayMap.this);
            Int2ReferenceArrayMap.this.value[Int2ReferenceArrayMap.this.size] = null;
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
    public Int2ReferenceMap.FastEntrySet<V> int2ReferenceEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction
    public V get(int k) {
        int[] key = this.key;
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap
    public boolean containsKey(int k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap, java.util.Map
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction
    public V put(int k, V v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            V oldValue = (V) this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            int[] newKey = new int[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction
    public V remove(int k) {
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceArrayMap$KeySet.class */
    public final class KeySet extends AbstractIntSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return Int2ReferenceArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.IntSet
        public boolean remove(int k) {
            int oldPos = Int2ReferenceArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Int2ReferenceArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Int2ReferenceArrayMap.this.key, oldPos + 1, Int2ReferenceArrayMap.this.key, oldPos, tail);
            System.arraycopy(Int2ReferenceArrayMap.this.value, oldPos + 1, Int2ReferenceArrayMap.this.value, oldPos, tail);
            Int2ReferenceArrayMap.access$010(Int2ReferenceArrayMap.this);
            Int2ReferenceArrayMap.this.value[Int2ReferenceArrayMap.this.size] = null;
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator iterator() {
            return new IntIterator() { // from class: it.unimi.dsi.fastutil.ints.Int2ReferenceArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Int2ReferenceArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                public int nextInt() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int[] iArr = Int2ReferenceArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return iArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Int2ReferenceArrayMap.this.size - this.pos;
                    System.arraycopy(Int2ReferenceArrayMap.this.key, this.pos, Int2ReferenceArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Int2ReferenceArrayMap.this.value, this.pos, Int2ReferenceArrayMap.this.value, this.pos - 1, tail);
                    Int2ReferenceArrayMap.access$010(Int2ReferenceArrayMap.this);
                    this.pos--;
                    Int2ReferenceArrayMap.this.value[Int2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.PrimitiveIterator.OfInt
                public void forEachRemaining(IntConsumer action) {
                    int max = Int2ReferenceArrayMap.this.size;
                    while (this.pos < max) {
                        int[] iArr = Int2ReferenceArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(iArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceArrayMap$KeySet$KeySetSpliterator.class */
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
                return Int2ReferenceArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator
            public final Int2ReferenceArrayMap<V>.KeySet.KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfInt
            public void forEachRemaining(IntConsumer action) {
                int max = Int2ReferenceArrayMap.this.size;
                while (this.pos < max) {
                    int[] iArr = Int2ReferenceArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(iArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return new KeySetSpliterator(0, Int2ReferenceArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer action) {
            int max = Int2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Int2ReferenceArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2ReferenceArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
    public Set<Integer> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractReferenceCollection<V> {
        private ValuesCollection() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object v) {
            return Int2ReferenceArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectIterator<V> iterator() {
            return new ObjectIterator<V>() { // from class: it.unimi.dsi.fastutil.ints.Int2ReferenceArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Int2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public V next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Int2ReferenceArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return (V) objArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Int2ReferenceArrayMap.this.size - this.pos;
                    System.arraycopy(Int2ReferenceArrayMap.this.key, this.pos, Int2ReferenceArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Int2ReferenceArrayMap.this.value, this.pos, Int2ReferenceArrayMap.this.value, this.pos - 1, tail);
                    Int2ReferenceArrayMap.access$010(Int2ReferenceArrayMap.this);
                    this.pos--;
                    Int2ReferenceArrayMap.this.value[Int2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super V> action) {
                    int max = Int2ReferenceArrayMap.this.size;
                    while (this.pos < max) {
                        Object[] objArr = Int2ReferenceArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(objArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceArrayMap$ValuesCollection$ValuesSpliterator.class */
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
                return (V) Int2ReferenceArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Int2ReferenceArrayMap<V>.ValuesCollection.ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super V> action) {
                int max = Int2ReferenceArrayMap.this.size;
                while (this.pos < max) {
                    Object[] objArr = Int2ReferenceArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(objArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<V> spliterator() {
            return new ValuesSpliterator(0, Int2ReferenceArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> action) {
            int max = Int2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Int2ReferenceArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Int2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Int2ReferenceArrayMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Int2ReferenceArrayMap<V> clone() {
        try {
            Int2ReferenceArrayMap<V> c = (Int2ReferenceArrayMap) clone();
            c.key = (int[]) this.key.clone();
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
            s.writeInt(this.key[i]);
            s.writeObject(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new int[this.size];
        this.value = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readInt();
            this.value[i] = s.readObject();
        }
    }
}
