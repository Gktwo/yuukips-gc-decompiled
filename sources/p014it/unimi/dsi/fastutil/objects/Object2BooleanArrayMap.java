package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanArrays;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanArrayMap.class */
public class Object2BooleanArrayMap<K> extends AbstractObject2BooleanMap<K> implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient Object[] key;
    private transient boolean[] value;
    private int size;
    private transient Object2BooleanMap.FastEntrySet<K> entries;
    private transient ObjectSet<K> keys;
    private transient BooleanCollection values;

    static /* synthetic */ int access$010(Object2BooleanArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Object2BooleanArrayMap(Object[] key, boolean[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Object2BooleanArrayMap() {
        this.key = ObjectArrays.EMPTY_ARRAY;
        this.value = BooleanArrays.EMPTY_ARRAY;
    }

    public Object2BooleanArrayMap(int capacity) {
        this.key = new Object[capacity];
        this.value = new boolean[capacity];
    }

    public Object2BooleanArrayMap(Object2BooleanMap<K> m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Object2BooleanMap.Entry<K>> it = m.object2BooleanEntrySet().iterator();
        while (it.hasNext()) {
            Object2BooleanMap.Entry<K> e = it.next();
            this.key[i] = e.getKey();
            this.value[i] = e.getBooleanValue();
            i++;
        }
        this.size = i;
    }

    public Object2BooleanArrayMap(Map<? extends K, ? extends Boolean> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends K, ? extends Boolean> e : m.entrySet()) {
            this.key[i] = e.getKey();
            this.value[i] = ((Boolean) e.getValue()).booleanValue();
            i++;
        }
        this.size = i;
    }

    public Object2BooleanArrayMap(Object[] key, boolean[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Object2BooleanMap.Entry<K>> implements Object2BooleanMap.FastEntrySet<K> {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Object2BooleanMap.Entry<K>> iterator() {
            return new ObjectIterator<Object2BooleanMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Object2BooleanArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Object2BooleanMap.Entry<K> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Object2BooleanArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    Object obj = objArr[i];
                    boolean[] zArr = Object2BooleanArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractObject2BooleanMap.BasicEntry(obj, zArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Object2BooleanArrayMap.access$010(Object2BooleanArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Object2BooleanArrayMap.this.key, this.next + 1, Object2BooleanArrayMap.this.key, this.next, tail);
                    System.arraycopy(Object2BooleanArrayMap.this.value, this.next + 1, Object2BooleanArrayMap.this.value, this.next, tail);
                    Object2BooleanArrayMap.this.key[Object2BooleanArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Object2BooleanMap.Entry<K>> action) {
                    int max = Object2BooleanArrayMap.this.size;
                    while (this.next < max) {
                        Object[] objArr = Object2BooleanArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        Object obj = objArr[i];
                        boolean[] zArr = Object2BooleanArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractObject2BooleanMap.BasicEntry(obj, zArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap.FastEntrySet
        public ObjectIterator<Object2BooleanMap.Entry<K>> fastIterator() {
            return new ObjectIterator<Object2BooleanMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractObject2BooleanMap.BasicEntry<K> entry = new AbstractObject2BooleanMap.BasicEntry<>();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Object2BooleanArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Object2BooleanMap.Entry<K> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractObject2BooleanMap.BasicEntry<K> basicEntry = this.entry;
                    Object[] objArr = Object2BooleanArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = (K) objArr[i];
                    AbstractObject2BooleanMap.BasicEntry<K> basicEntry2 = this.entry;
                    boolean[] zArr = Object2BooleanArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = zArr[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Object2BooleanArrayMap.access$010(Object2BooleanArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Object2BooleanArrayMap.this.key, this.next + 1, Object2BooleanArrayMap.this.key, this.next, tail);
                    System.arraycopy(Object2BooleanArrayMap.this.value, this.next + 1, Object2BooleanArrayMap.this.value, this.next, tail);
                    Object2BooleanArrayMap.this.key[Object2BooleanArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Object2BooleanMap.Entry<K>> action) {
                    int max = Object2BooleanArrayMap.this.size;
                    while (this.next < max) {
                        AbstractObject2BooleanMap.BasicEntry<K> basicEntry = this.entry;
                        Object[] objArr = Object2BooleanArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = (K) objArr[i];
                        AbstractObject2BooleanMap.BasicEntry<K> basicEntry2 = this.entry;
                        boolean[] zArr = Object2BooleanArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = zArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Object2BooleanMap.Entry<K>> implements ObjectSpliterator<Object2BooleanMap.Entry<K>> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Object2BooleanMap.Entry<K> get(int location) {
                return new AbstractObject2BooleanMap.BasicEntry(Object2BooleanArrayMap.this.key[location], Object2BooleanArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Object2BooleanArrayMap<K>.EntrySet.EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Object2BooleanMap.Entry<K>> spliterator() {
            return new EntrySetSpliterator(0, Object2BooleanArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Object2BooleanMap.Entry<K>> action) {
            int max = Object2BooleanArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractObject2BooleanMap.BasicEntry(Object2BooleanArrayMap.this.key[i], Object2BooleanArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap.FastEntrySet
        public void fastForEach(Consumer<? super Object2BooleanMap.Entry<K>> action) {
            AbstractObject2BooleanMap.BasicEntry<K> entry = new AbstractObject2BooleanMap.BasicEntry<>();
            int max = Object2BooleanArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = (K) Object2BooleanArrayMap.this.key[i];
                entry.value = Object2BooleanArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Object2BooleanArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Boolean)) {
                return false;
            }
            Object key = e.getKey();
            return Object2BooleanArrayMap.this.containsKey(key) && Object2BooleanArrayMap.this.getBoolean(key) == ((Boolean) e.getValue()).booleanValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Boolean)) {
                return false;
            }
            Object key = e.getKey();
            boolean v = ((Boolean) e.getValue()).booleanValue();
            int oldPos = Object2BooleanArrayMap.this.findKey(key);
            if (oldPos == -1 || v != Object2BooleanArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Object2BooleanArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Object2BooleanArrayMap.this.key, oldPos + 1, Object2BooleanArrayMap.this.key, oldPos, tail);
            System.arraycopy(Object2BooleanArrayMap.this.value, oldPos + 1, Object2BooleanArrayMap.this.value, oldPos, tail);
            Object2BooleanArrayMap.access$010(Object2BooleanArrayMap.this);
            Object2BooleanArrayMap.this.key[Object2BooleanArrayMap.this.size] = null;
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap
    public Object2BooleanMap.FastEntrySet<K> object2BooleanEntrySet() {
        if (this.entries == null) {
            this.entries = new EntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    public int findKey(Object k) {
        Object[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (!Objects.equals(key[i], k));
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
    public boolean getBoolean(Object k) {
        Object[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return this.defRetValue;
            }
        } while (!Objects.equals(key[i], k));
        return this.value[i];
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
                this.key[i] = null;
            } else {
                this.size = 0;
                return;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2BooleanMap, p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2BooleanMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
    public boolean containsValue(boolean v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (this.value[i] != v);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2BooleanMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
    public boolean put(K k, boolean v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            boolean oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            Object[] newKey = new Object[this.size == 0 ? 2 : this.size * 2];
            boolean[] newValue = new boolean[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
    public boolean removeBoolean(Object k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        boolean oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        this.key[this.size] = null;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanArrayMap$KeySet.class */
    public final class KeySet extends AbstractObjectSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Object2BooleanArrayMap.this.findKey(k) != -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldPos = Object2BooleanArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Object2BooleanArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Object2BooleanArrayMap.this.key, oldPos + 1, Object2BooleanArrayMap.this.key, oldPos, tail);
            System.arraycopy(Object2BooleanArrayMap.this.value, oldPos + 1, Object2BooleanArrayMap.this.value, oldPos, tail);
            Object2BooleanArrayMap.access$010(Object2BooleanArrayMap.this);
            Object2BooleanArrayMap.this.key[Object2BooleanArrayMap.this.size] = null;
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<K> iterator() {
            return new ObjectIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Object2BooleanArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public K next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Object2BooleanArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return (K) objArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Object2BooleanArrayMap.this.size - this.pos;
                    System.arraycopy(Object2BooleanArrayMap.this.key, this.pos, Object2BooleanArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Object2BooleanArrayMap.this.value, this.pos, Object2BooleanArrayMap.this.value, this.pos - 1, tail);
                    Object2BooleanArrayMap.access$010(Object2BooleanArrayMap.this);
                    this.pos--;
                    Object2BooleanArrayMap.this.key[Object2BooleanArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super K> action) {
                    int max = Object2BooleanArrayMap.this.size;
                    while (this.pos < max) {
                        Object[] objArr = Object2BooleanArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(objArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanArrayMap$KeySet$KeySetSpliterator.class */
        public final class KeySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<K> implements ObjectSpliterator<K> {
            KeySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            protected final K get(int location) {
                return (K) Object2BooleanArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Object2BooleanArrayMap<K>.KeySet.KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super K> action) {
                int max = Object2BooleanArrayMap.this.size;
                while (this.pos < max) {
                    Object[] objArr = Object2BooleanArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(objArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return new KeySetSpliterator(0, Object2BooleanArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> action) {
            int max = Object2BooleanArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Object2BooleanArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Object2BooleanArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2BooleanArrayMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2BooleanMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
    public ObjectSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractBooleanCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean contains(boolean v) {
            return Object2BooleanArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanIterator iterator() {
            return new BooleanIterator() { // from class: it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Object2BooleanArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                public boolean nextBoolean() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    boolean[] zArr = Object2BooleanArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return zArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Object2BooleanArrayMap.this.size - this.pos;
                    System.arraycopy(Object2BooleanArrayMap.this.key, this.pos, Object2BooleanArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Object2BooleanArrayMap.this.value, this.pos, Object2BooleanArrayMap.this.value, this.pos - 1, tail);
                    Object2BooleanArrayMap.access$010(Object2BooleanArrayMap.this);
                    this.pos--;
                    Object2BooleanArrayMap.this.key[Object2BooleanArrayMap.this.size] = null;
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                public void forEachRemaining(BooleanConsumer action) {
                    int max = Object2BooleanArrayMap.this.size;
                    while (this.pos < max) {
                        boolean[] zArr = Object2BooleanArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(zArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanArrayMap$ValuesCollection$ValuesSpliterator.class */
        public final class ValuesSpliterator extends BooleanSpliterators.EarlyBindingSizeIndexBasedSpliterator implements BooleanSpliterator {
            ValuesSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16720;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
            protected final boolean get(int location) {
                return Object2BooleanArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
            public final Object2BooleanArrayMap<K>.ValuesCollection.ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(BooleanConsumer action) {
                int max = Object2BooleanArrayMap.this.size;
                while (this.pos < max) {
                    boolean[] zArr = Object2BooleanArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(zArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanSpliterator spliterator() {
            return new ValuesSpliterator(0, Object2BooleanArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterable
        public void forEach(BooleanConsumer action) {
            int max = Object2BooleanArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Object2BooleanArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Object2BooleanArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Object2BooleanArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2BooleanMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
    public Collection<Boolean> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Object2BooleanArrayMap<K> clone() {
        try {
            Object2BooleanArrayMap<K> c = (Object2BooleanArrayMap) clone();
            c.key = (Object[]) this.key.clone();
            c.value = (boolean[]) this.value.clone();
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
            s.writeObject(this.key[i]);
            s.writeBoolean(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new Object[this.size];
        this.value = new boolean[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readObject();
            this.value[i] = s.readBoolean();
        }
    }
}
