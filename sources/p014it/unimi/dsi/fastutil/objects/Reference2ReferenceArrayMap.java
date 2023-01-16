package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceArrayMap.class */
public class Reference2ReferenceArrayMap<K, V> extends AbstractReference2ReferenceMap<K, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient Object[] key;
    private transient Object[] value;
    private int size;
    private transient Reference2ReferenceMap.FastEntrySet<K, V> entries;
    private transient ReferenceSet<K> keys;
    private transient ReferenceCollection<V> values;

    static /* synthetic */ int access$010(Reference2ReferenceArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Reference2ReferenceArrayMap(Object[] key, Object[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Reference2ReferenceArrayMap() {
        this.key = ObjectArrays.EMPTY_ARRAY;
        this.value = ObjectArrays.EMPTY_ARRAY;
    }

    public Reference2ReferenceArrayMap(int capacity) {
        this.key = new Object[capacity];
        this.value = new Object[capacity];
    }

    public Reference2ReferenceArrayMap(Reference2ReferenceMap<K, V> m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Reference2ReferenceMap.Entry<K, V>> it = m.reference2ReferenceEntrySet().iterator();
        while (it.hasNext()) {
            Reference2ReferenceMap.Entry<K, V> e = it.next();
            this.key[i] = e.getKey();
            this.value[i] = e.getValue();
            i++;
        }
        this.size = i;
    }

    public Reference2ReferenceArrayMap(Map<? extends K, ? extends V> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            this.key[i] = e.getKey();
            this.value[i] = e.getValue();
            i++;
        }
        this.size = i;
    }

    public Reference2ReferenceArrayMap(Object[] key, Object[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Reference2ReferenceMap.Entry<K, V>> implements Reference2ReferenceMap.FastEntrySet<K, V> {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Reference2ReferenceMap.Entry<K, V>> iterator() {
            return new ObjectIterator<Reference2ReferenceMap.Entry<K, V>>() { // from class: it.unimi.dsi.fastutil.objects.Reference2ReferenceArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Reference2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Reference2ReferenceMap.Entry<K, V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Reference2ReferenceArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    Object obj = objArr[i];
                    Object[] objArr2 = Reference2ReferenceArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractReference2ReferenceMap.BasicEntry(obj, objArr2[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Reference2ReferenceArrayMap.access$010(Reference2ReferenceArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Reference2ReferenceArrayMap.this.key, this.next + 1, Reference2ReferenceArrayMap.this.key, this.next, tail);
                    System.arraycopy(Reference2ReferenceArrayMap.this.value, this.next + 1, Reference2ReferenceArrayMap.this.value, this.next, tail);
                    Reference2ReferenceArrayMap.this.key[Reference2ReferenceArrayMap.this.size] = null;
                    Reference2ReferenceArrayMap.this.value[Reference2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Reference2ReferenceMap.Entry<K, V>> action) {
                    int max = Reference2ReferenceArrayMap.this.size;
                    while (this.next < max) {
                        Object[] objArr = Reference2ReferenceArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        Object obj = objArr[i];
                        Object[] objArr2 = Reference2ReferenceArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractReference2ReferenceMap.BasicEntry(obj, objArr2[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap.FastEntrySet
        public ObjectIterator<Reference2ReferenceMap.Entry<K, V>> fastIterator() {
            return new ObjectIterator<Reference2ReferenceMap.Entry<K, V>>() { // from class: it.unimi.dsi.fastutil.objects.Reference2ReferenceArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractReference2ReferenceMap.BasicEntry<K, V> entry = new AbstractReference2ReferenceMap.BasicEntry<>();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Reference2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Reference2ReferenceMap.Entry<K, V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractReference2ReferenceMap.BasicEntry<K, V> basicEntry = this.entry;
                    Object[] objArr = Reference2ReferenceArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = (K) objArr[i];
                    AbstractReference2ReferenceMap.BasicEntry<K, V> basicEntry2 = this.entry;
                    Object[] objArr2 = Reference2ReferenceArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = (V) objArr2[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Reference2ReferenceArrayMap.access$010(Reference2ReferenceArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Reference2ReferenceArrayMap.this.key, this.next + 1, Reference2ReferenceArrayMap.this.key, this.next, tail);
                    System.arraycopy(Reference2ReferenceArrayMap.this.value, this.next + 1, Reference2ReferenceArrayMap.this.value, this.next, tail);
                    Reference2ReferenceArrayMap.this.key[Reference2ReferenceArrayMap.this.size] = null;
                    Reference2ReferenceArrayMap.this.value[Reference2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Reference2ReferenceMap.Entry<K, V>> action) {
                    int max = Reference2ReferenceArrayMap.this.size;
                    while (this.next < max) {
                        AbstractReference2ReferenceMap.BasicEntry<K, V> basicEntry = this.entry;
                        Object[] objArr = Reference2ReferenceArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = (K) objArr[i];
                        AbstractReference2ReferenceMap.BasicEntry<K, V> basicEntry2 = this.entry;
                        Object[] objArr2 = Reference2ReferenceArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = (V) objArr2[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Reference2ReferenceMap.Entry<K, V>> implements ObjectSpliterator<Reference2ReferenceMap.Entry<K, V>> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Reference2ReferenceMap.Entry<K, V> get(int location) {
                return new AbstractReference2ReferenceMap.BasicEntry(Reference2ReferenceArrayMap.this.key[location], Reference2ReferenceArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Reference2ReferenceArrayMap<K, V>.EntrySet.EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Reference2ReferenceMap.Entry<K, V>> spliterator() {
            return new EntrySetSpliterator(0, Reference2ReferenceArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Reference2ReferenceMap.Entry<K, V>> action) {
            int max = Reference2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractReference2ReferenceMap.BasicEntry(Reference2ReferenceArrayMap.this.key[i], Reference2ReferenceArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap.FastEntrySet
        public void fastForEach(Consumer<? super Reference2ReferenceMap.Entry<K, V>> action) {
            AbstractReference2ReferenceMap.BasicEntry<K, V> entry = new AbstractReference2ReferenceMap.BasicEntry<>();
            int max = Reference2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = (K) Reference2ReferenceArrayMap.this.key[i];
                entry.value = (V) Reference2ReferenceArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            Object key = e.getKey();
            return Reference2ReferenceArrayMap.this.containsKey(key) && Reference2ReferenceArrayMap.this.get(key) == e.getValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            Object key = e.getKey();
            Object value = e.getValue();
            int oldPos = Reference2ReferenceArrayMap.this.findKey(key);
            if (oldPos == -1 || value != Reference2ReferenceArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Reference2ReferenceArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Reference2ReferenceArrayMap.this.key, oldPos + 1, Reference2ReferenceArrayMap.this.key, oldPos, tail);
            System.arraycopy(Reference2ReferenceArrayMap.this.value, oldPos + 1, Reference2ReferenceArrayMap.this.value, oldPos, tail);
            Reference2ReferenceArrayMap.access$010(Reference2ReferenceArrayMap.this);
            Reference2ReferenceArrayMap.this.key[Reference2ReferenceArrayMap.this.size] = null;
            Reference2ReferenceArrayMap.this.value[Reference2ReferenceArrayMap.this.size] = null;
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap
    public Reference2ReferenceMap.FastEntrySet<K, V> reference2ReferenceEntrySet() {
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
        } while (key[i] != k);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
    public V get(Object k) {
        Object[] key = this.key;
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
                this.key[i] = null;
                this.value[i] = null;
            } else {
                this.size = 0;
                return;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap, p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap, java.util.Map
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
    public V put(K k, V v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            V oldValue = (V) this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            Object[] newKey = new Object[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
    public V remove(Object k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return (V) this.defRetValue;
        }
        V oldValue = (V) this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        this.key[this.size] = null;
        this.value[this.size] = null;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceArrayMap$KeySet.class */
    public final class KeySet extends AbstractReferenceSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Reference2ReferenceArrayMap.this.findKey(k) != -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldPos = Reference2ReferenceArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Reference2ReferenceArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Reference2ReferenceArrayMap.this.key, oldPos + 1, Reference2ReferenceArrayMap.this.key, oldPos, tail);
            System.arraycopy(Reference2ReferenceArrayMap.this.value, oldPos + 1, Reference2ReferenceArrayMap.this.value, oldPos, tail);
            Reference2ReferenceArrayMap.access$010(Reference2ReferenceArrayMap.this);
            Reference2ReferenceArrayMap.this.key[Reference2ReferenceArrayMap.this.size] = null;
            Reference2ReferenceArrayMap.this.value[Reference2ReferenceArrayMap.this.size] = null;
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectIterator<K> iterator() {
            return new ObjectIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.Reference2ReferenceArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Reference2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public K next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Reference2ReferenceArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return (K) objArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Reference2ReferenceArrayMap.this.size - this.pos;
                    System.arraycopy(Reference2ReferenceArrayMap.this.key, this.pos, Reference2ReferenceArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Reference2ReferenceArrayMap.this.value, this.pos, Reference2ReferenceArrayMap.this.value, this.pos - 1, tail);
                    Reference2ReferenceArrayMap.access$010(Reference2ReferenceArrayMap.this);
                    this.pos--;
                    Reference2ReferenceArrayMap.this.key[Reference2ReferenceArrayMap.this.size] = null;
                    Reference2ReferenceArrayMap.this.value[Reference2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super K> action) {
                    int max = Reference2ReferenceArrayMap.this.size;
                    while (this.pos < max) {
                        Object[] objArr = Reference2ReferenceArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(objArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceArrayMap$KeySet$KeySetSpliterator.class */
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
                return (K) Reference2ReferenceArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Reference2ReferenceArrayMap<K, V>.KeySet.KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super K> action) {
                int max = Reference2ReferenceArrayMap.this.size;
                while (this.pos < max) {
                    Object[] objArr = Reference2ReferenceArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(objArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return new KeySetSpliterator(0, Reference2ReferenceArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> action) {
            int max = Reference2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Reference2ReferenceArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Reference2ReferenceArrayMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
    public ReferenceSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractReferenceCollection<V> {
        private ValuesCollection() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object v) {
            return Reference2ReferenceArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectIterator<V> iterator() {
            return new ObjectIterator<V>() { // from class: it.unimi.dsi.fastutil.objects.Reference2ReferenceArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Reference2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public V next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Reference2ReferenceArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return (V) objArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Reference2ReferenceArrayMap.this.size - this.pos;
                    System.arraycopy(Reference2ReferenceArrayMap.this.key, this.pos, Reference2ReferenceArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Reference2ReferenceArrayMap.this.value, this.pos, Reference2ReferenceArrayMap.this.value, this.pos - 1, tail);
                    Reference2ReferenceArrayMap.access$010(Reference2ReferenceArrayMap.this);
                    this.pos--;
                    Reference2ReferenceArrayMap.this.key[Reference2ReferenceArrayMap.this.size] = null;
                    Reference2ReferenceArrayMap.this.value[Reference2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super V> action) {
                    int max = Reference2ReferenceArrayMap.this.size;
                    while (this.pos < max) {
                        Object[] objArr = Reference2ReferenceArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(objArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceArrayMap$ValuesCollection$ValuesSpliterator.class */
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
                return (V) Reference2ReferenceArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Reference2ReferenceArrayMap<K, V>.ValuesCollection.ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super V> action) {
                int max = Reference2ReferenceArrayMap.this.size;
                while (this.pos < max) {
                    Object[] objArr = Reference2ReferenceArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(objArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<V> spliterator() {
            return new ValuesSpliterator(0, Reference2ReferenceArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> action) {
            int max = Reference2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Reference2ReferenceArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Reference2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Reference2ReferenceArrayMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Reference2ReferenceArrayMap<K, V> clone() {
        try {
            Reference2ReferenceArrayMap<K, V> c = (Reference2ReferenceArrayMap) clone();
            c.key = (Object[]) this.key.clone();
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
            s.writeObject(this.key[i]);
            s.writeObject(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new Object[this.size];
        this.value = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readObject();
            this.value[i] = s.readObject();
        }
    }
}
