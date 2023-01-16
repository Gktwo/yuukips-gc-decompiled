package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteArrays;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteConsumer;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterator;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2ByteMap;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.objects.Reference2ByteMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteArrayMap.class */
public class Reference2ByteArrayMap<K> extends AbstractReference2ByteMap<K> implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient Object[] key;
    private transient byte[] value;
    private int size;
    private transient Reference2ByteMap.FastEntrySet<K> entries;
    private transient ReferenceSet<K> keys;
    private transient ByteCollection values;

    static /* synthetic */ int access$010(Reference2ByteArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Reference2ByteArrayMap(Object[] key, byte[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Reference2ByteArrayMap() {
        this.key = ObjectArrays.EMPTY_ARRAY;
        this.value = ByteArrays.EMPTY_ARRAY;
    }

    public Reference2ByteArrayMap(int capacity) {
        this.key = new Object[capacity];
        this.value = new byte[capacity];
    }

    public Reference2ByteArrayMap(Reference2ByteMap<K> m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Reference2ByteMap.Entry<K>> it = m.reference2ByteEntrySet().iterator();
        while (it.hasNext()) {
            Reference2ByteMap.Entry<K> e = it.next();
            this.key[i] = e.getKey();
            this.value[i] = e.getByteValue();
            i++;
        }
        this.size = i;
    }

    public Reference2ByteArrayMap(Map<? extends K, ? extends Byte> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends K, ? extends Byte> e : m.entrySet()) {
            this.key[i] = e.getKey();
            this.value[i] = ((Byte) e.getValue()).byteValue();
            i++;
        }
        this.size = i;
    }

    public Reference2ByteArrayMap(Object[] key, byte[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Reference2ByteMap.Entry<K>> implements Reference2ByteMap.FastEntrySet<K> {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Reference2ByteMap.Entry<K>> iterator() {
            return new ObjectIterator<Reference2ByteMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Reference2ByteArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Reference2ByteArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Reference2ByteMap.Entry<K> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Reference2ByteArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    Object obj = objArr[i];
                    byte[] bArr = Reference2ByteArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractReference2ByteMap.BasicEntry(obj, bArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Reference2ByteArrayMap.access$010(Reference2ByteArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Reference2ByteArrayMap.this.key, this.next + 1, Reference2ByteArrayMap.this.key, this.next, tail);
                    System.arraycopy(Reference2ByteArrayMap.this.value, this.next + 1, Reference2ByteArrayMap.this.value, this.next, tail);
                    Reference2ByteArrayMap.this.key[Reference2ByteArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Reference2ByteMap.Entry<K>> action) {
                    int max = Reference2ByteArrayMap.this.size;
                    while (this.next < max) {
                        Object[] objArr = Reference2ByteArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        Object obj = objArr[i];
                        byte[] bArr = Reference2ByteArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractReference2ByteMap.BasicEntry(obj, bArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteMap.FastEntrySet
        public ObjectIterator<Reference2ByteMap.Entry<K>> fastIterator() {
            return new ObjectIterator<Reference2ByteMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Reference2ByteArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractReference2ByteMap.BasicEntry<K> entry = new AbstractReference2ByteMap.BasicEntry<>();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Reference2ByteArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Reference2ByteMap.Entry<K> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractReference2ByteMap.BasicEntry<K> basicEntry = this.entry;
                    Object[] objArr = Reference2ByteArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = (K) objArr[i];
                    AbstractReference2ByteMap.BasicEntry<K> basicEntry2 = this.entry;
                    byte[] bArr = Reference2ByteArrayMap.this.value;
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
                    int access$010 = Reference2ByteArrayMap.access$010(Reference2ByteArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Reference2ByteArrayMap.this.key, this.next + 1, Reference2ByteArrayMap.this.key, this.next, tail);
                    System.arraycopy(Reference2ByteArrayMap.this.value, this.next + 1, Reference2ByteArrayMap.this.value, this.next, tail);
                    Reference2ByteArrayMap.this.key[Reference2ByteArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Reference2ByteMap.Entry<K>> action) {
                    int max = Reference2ByteArrayMap.this.size;
                    while (this.next < max) {
                        AbstractReference2ByteMap.BasicEntry<K> basicEntry = this.entry;
                        Object[] objArr = Reference2ByteArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = (K) objArr[i];
                        AbstractReference2ByteMap.BasicEntry<K> basicEntry2 = this.entry;
                        byte[] bArr = Reference2ByteArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = bArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Reference2ByteMap.Entry<K>> implements ObjectSpliterator<Reference2ByteMap.Entry<K>> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Reference2ByteMap.Entry<K> get(int location) {
                return new AbstractReference2ByteMap.BasicEntry(Reference2ByteArrayMap.this.key[location], Reference2ByteArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Reference2ByteArrayMap<K>.EntrySet.EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Reference2ByteMap.Entry<K>> spliterator() {
            return new EntrySetSpliterator(0, Reference2ByteArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Reference2ByteMap.Entry<K>> action) {
            int max = Reference2ByteArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractReference2ByteMap.BasicEntry(Reference2ByteArrayMap.this.key[i], Reference2ByteArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteMap.FastEntrySet
        public void fastForEach(Consumer<? super Reference2ByteMap.Entry<K>> action) {
            AbstractReference2ByteMap.BasicEntry<K> entry = new AbstractReference2ByteMap.BasicEntry<>();
            int max = Reference2ByteArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = (K) Reference2ByteArrayMap.this.key[i];
                entry.value = Reference2ByteArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2ByteArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Byte)) {
                return false;
            }
            Object key = e.getKey();
            return Reference2ByteArrayMap.this.containsKey(key) && Reference2ByteArrayMap.this.getByte(key) == ((Byte) e.getValue()).byteValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Byte)) {
                return false;
            }
            Object key = e.getKey();
            byte v = ((Byte) e.getValue()).byteValue();
            int oldPos = Reference2ByteArrayMap.this.findKey(key);
            if (oldPos == -1 || v != Reference2ByteArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Reference2ByteArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Reference2ByteArrayMap.this.key, oldPos + 1, Reference2ByteArrayMap.this.key, oldPos, tail);
            System.arraycopy(Reference2ByteArrayMap.this.value, oldPos + 1, Reference2ByteArrayMap.this.value, oldPos, tail);
            Reference2ByteArrayMap.access$010(Reference2ByteArrayMap.this);
            Reference2ByteArrayMap.this.key[Reference2ByteArrayMap.this.size] = null;
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteMap
    public Reference2ByteMap.FastEntrySet<K> reference2ByteEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
    public byte getByte(Object k) {
        Object[] key = this.key;
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ByteMap, p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ByteMap, p014it.unimi.dsi.fastutil.objects.Reference2ByteMap
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ByteMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
    public byte put(K k, byte v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            byte oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            Object[] newKey = new Object[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
    public byte removeByte(Object k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        byte oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        this.key[this.size] = null;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteArrayMap$KeySet.class */
    public final class KeySet extends AbstractReferenceSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Reference2ByteArrayMap.this.findKey(k) != -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldPos = Reference2ByteArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Reference2ByteArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Reference2ByteArrayMap.this.key, oldPos + 1, Reference2ByteArrayMap.this.key, oldPos, tail);
            System.arraycopy(Reference2ByteArrayMap.this.value, oldPos + 1, Reference2ByteArrayMap.this.value, oldPos, tail);
            Reference2ByteArrayMap.access$010(Reference2ByteArrayMap.this);
            Reference2ByteArrayMap.this.key[Reference2ByteArrayMap.this.size] = null;
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectIterator<K> iterator() {
            return new ObjectIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.Reference2ByteArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Reference2ByteArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public K next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Reference2ByteArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return (K) objArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Reference2ByteArrayMap.this.size - this.pos;
                    System.arraycopy(Reference2ByteArrayMap.this.key, this.pos, Reference2ByteArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Reference2ByteArrayMap.this.value, this.pos, Reference2ByteArrayMap.this.value, this.pos - 1, tail);
                    Reference2ByteArrayMap.access$010(Reference2ByteArrayMap.this);
                    this.pos--;
                    Reference2ByteArrayMap.this.key[Reference2ByteArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super K> action) {
                    int max = Reference2ByteArrayMap.this.size;
                    while (this.pos < max) {
                        Object[] objArr = Reference2ByteArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(objArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteArrayMap$KeySet$KeySetSpliterator.class */
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
                return (K) Reference2ByteArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Reference2ByteArrayMap<K>.KeySet.KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super K> action) {
                int max = Reference2ByteArrayMap.this.size;
                while (this.pos < max) {
                    Object[] objArr = Reference2ByteArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(objArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return new KeySetSpliterator(0, Reference2ByteArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> action) {
            int max = Reference2ByteArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Reference2ByteArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2ByteArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Reference2ByteArrayMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ByteMap, p014it.unimi.dsi.fastutil.objects.Reference2ByteMap, java.util.Map
    public ReferenceSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractByteCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte v) {
            return Reference2ByteArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteIterator iterator() {
            return new ByteIterator() { // from class: it.unimi.dsi.fastutil.objects.Reference2ByteArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Reference2ByteArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                public byte nextByte() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    byte[] bArr = Reference2ByteArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return bArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Reference2ByteArrayMap.this.size - this.pos;
                    System.arraycopy(Reference2ByteArrayMap.this.key, this.pos, Reference2ByteArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Reference2ByteArrayMap.this.value, this.pos, Reference2ByteArrayMap.this.value, this.pos - 1, tail);
                    Reference2ByteArrayMap.access$010(Reference2ByteArrayMap.this);
                    this.pos--;
                    Reference2ByteArrayMap.this.key[Reference2ByteArrayMap.this.size] = null;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                public void forEachRemaining(ByteConsumer action) {
                    int max = Reference2ByteArrayMap.this.size;
                    while (this.pos < max) {
                        byte[] bArr = Reference2ByteArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(bArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteArrayMap$ValuesCollection$ValuesSpliterator.class */
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
                return Reference2ByteArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public final Reference2ByteArrayMap<K>.ValuesCollection.ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ByteConsumer action) {
                int max = Reference2ByteArrayMap.this.size;
                while (this.pos < max) {
                    byte[] bArr = Reference2ByteArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(bArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteSpliterator spliterator() {
            return new ValuesSpliterator(0, Reference2ByteArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public void forEach(ByteConsumer action) {
            int max = Reference2ByteArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Reference2ByteArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Reference2ByteArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Reference2ByteArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ByteMap, p014it.unimi.dsi.fastutil.objects.Reference2ByteMap, java.util.Map
    public Collection<Byte> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Reference2ByteArrayMap<K> clone() {
        try {
            Reference2ByteArrayMap<K> c = (Reference2ByteArrayMap) clone();
            c.key = (Object[]) this.key.clone();
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
            s.writeObject(this.key[i]);
            s.writeByte(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new Object[this.size];
        this.value = new byte[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readObject();
            this.value[i] = s.readByte();
        }
    }
}
