package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectArrays;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceArrayMap.class */
public class Byte2ReferenceArrayMap<V> extends AbstractByte2ReferenceMap<V> implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient byte[] key;
    private transient Object[] value;
    private int size;
    private transient Byte2ReferenceMap.FastEntrySet<V> entries;
    private transient ByteSet keys;
    private transient ReferenceCollection<V> values;

    static /* synthetic */ int access$010(Byte2ReferenceArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Byte2ReferenceArrayMap(byte[] key, Object[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Byte2ReferenceArrayMap() {
        this.key = ByteArrays.EMPTY_ARRAY;
        this.value = ObjectArrays.EMPTY_ARRAY;
    }

    public Byte2ReferenceArrayMap(int capacity) {
        this.key = new byte[capacity];
        this.value = new Object[capacity];
    }

    public Byte2ReferenceArrayMap(Byte2ReferenceMap<V> m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Byte2ReferenceMap.Entry<V>> it = m.byte2ReferenceEntrySet().iterator();
        while (it.hasNext()) {
            Byte2ReferenceMap.Entry<V> e = it.next();
            this.key[i] = e.getByteKey();
            this.value[i] = e.getValue();
            i++;
        }
        this.size = i;
    }

    public Byte2ReferenceArrayMap(Map<? extends Byte, ? extends V> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Byte, ? extends V> e : m.entrySet()) {
            this.key[i] = ((Byte) e.getKey()).byteValue();
            this.value[i] = e.getValue();
            i++;
        }
        this.size = i;
    }

    public Byte2ReferenceArrayMap(byte[] key, Object[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Byte2ReferenceMap.Entry<V>> implements Byte2ReferenceMap.FastEntrySet<V> {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Byte2ReferenceMap.Entry<V>> iterator() {
            return new ObjectIterator<Byte2ReferenceMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ReferenceArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Byte2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Byte2ReferenceMap.Entry<V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    byte[] bArr = Byte2ReferenceArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    byte b = bArr[i];
                    Object[] objArr = Byte2ReferenceArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractByte2ReferenceMap.BasicEntry(b, objArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Byte2ReferenceArrayMap.access$010(Byte2ReferenceArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Byte2ReferenceArrayMap.this.key, this.next + 1, Byte2ReferenceArrayMap.this.key, this.next, tail);
                    System.arraycopy(Byte2ReferenceArrayMap.this.value, this.next + 1, Byte2ReferenceArrayMap.this.value, this.next, tail);
                    Byte2ReferenceArrayMap.this.value[Byte2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Byte2ReferenceMap.Entry<V>> action) {
                    int max = Byte2ReferenceArrayMap.this.size;
                    while (this.next < max) {
                        byte[] bArr = Byte2ReferenceArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        byte b = bArr[i];
                        Object[] objArr = Byte2ReferenceArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractByte2ReferenceMap.BasicEntry(b, objArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap.FastEntrySet
        public ObjectIterator<Byte2ReferenceMap.Entry<V>> fastIterator() {
            return new ObjectIterator<Byte2ReferenceMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ReferenceArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractByte2ReferenceMap.BasicEntry<V> entry = new AbstractByte2ReferenceMap.BasicEntry<>();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Byte2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Byte2ReferenceMap.Entry<V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractByte2ReferenceMap.BasicEntry<V> basicEntry = this.entry;
                    byte[] bArr = Byte2ReferenceArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = bArr[i];
                    AbstractByte2ReferenceMap.BasicEntry<V> basicEntry2 = this.entry;
                    Object[] objArr = Byte2ReferenceArrayMap.this.value;
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
                    int access$010 = Byte2ReferenceArrayMap.access$010(Byte2ReferenceArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Byte2ReferenceArrayMap.this.key, this.next + 1, Byte2ReferenceArrayMap.this.key, this.next, tail);
                    System.arraycopy(Byte2ReferenceArrayMap.this.value, this.next + 1, Byte2ReferenceArrayMap.this.value, this.next, tail);
                    Byte2ReferenceArrayMap.this.value[Byte2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Byte2ReferenceMap.Entry<V>> action) {
                    int max = Byte2ReferenceArrayMap.this.size;
                    while (this.next < max) {
                        AbstractByte2ReferenceMap.BasicEntry<V> basicEntry = this.entry;
                        byte[] bArr = Byte2ReferenceArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = bArr[i];
                        AbstractByte2ReferenceMap.BasicEntry<V> basicEntry2 = this.entry;
                        Object[] objArr = Byte2ReferenceArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = (V) objArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Byte2ReferenceMap.Entry<V>> implements ObjectSpliterator<Byte2ReferenceMap.Entry<V>> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Byte2ReferenceMap.Entry<V> get(int location) {
                return new AbstractByte2ReferenceMap.BasicEntry(Byte2ReferenceArrayMap.this.key[location], Byte2ReferenceArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Byte2ReferenceArrayMap<V>.EntrySet.EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Byte2ReferenceMap.Entry<V>> spliterator() {
            return new EntrySetSpliterator(0, Byte2ReferenceArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Byte2ReferenceMap.Entry<V>> action) {
            int max = Byte2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractByte2ReferenceMap.BasicEntry(Byte2ReferenceArrayMap.this.key[i], Byte2ReferenceArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap.FastEntrySet
        public void fastForEach(Consumer<? super Byte2ReferenceMap.Entry<V>> action) {
            AbstractByte2ReferenceMap.BasicEntry<V> entry = new AbstractByte2ReferenceMap.BasicEntry<>();
            int max = Byte2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Byte2ReferenceArrayMap.this.key[i];
                entry.value = (V) Byte2ReferenceArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Byte2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Byte)) {
                return false;
            }
            byte k = ((Byte) e.getKey()).byteValue();
            return Byte2ReferenceArrayMap.this.containsKey(k) && Byte2ReferenceArrayMap.this.get(k) == e.getValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Byte)) {
                return false;
            }
            byte k = ((Byte) e.getKey()).byteValue();
            Object value = e.getValue();
            int oldPos = Byte2ReferenceArrayMap.this.findKey(k);
            if (oldPos == -1 || value != Byte2ReferenceArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Byte2ReferenceArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Byte2ReferenceArrayMap.this.key, oldPos + 1, Byte2ReferenceArrayMap.this.key, oldPos, tail);
            System.arraycopy(Byte2ReferenceArrayMap.this.value, oldPos + 1, Byte2ReferenceArrayMap.this.value, oldPos, tail);
            Byte2ReferenceArrayMap.access$010(Byte2ReferenceArrayMap.this);
            Byte2ReferenceArrayMap.this.value[Byte2ReferenceArrayMap.this.size] = null;
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
    public Byte2ReferenceMap.FastEntrySet<V> byte2ReferenceEntrySet() {
        if (this.entries == null) {
            this.entries = new EntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    public int findKey(byte k) {
        byte[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (key[i] != k);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction
    public V get(byte k) {
        byte[] key = this.key;
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

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap
    public boolean containsKey(byte k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap, java.util.Map
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

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction
    public V put(byte k, V v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            V oldValue = (V) this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            byte[] newKey = new byte[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction
    public V remove(byte k) {
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
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceArrayMap$KeySet.class */
    public final class KeySet extends AbstractByteSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return Byte2ReferenceArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.ByteSet
        public boolean remove(byte k) {
            int oldPos = Byte2ReferenceArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Byte2ReferenceArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Byte2ReferenceArrayMap.this.key, oldPos + 1, Byte2ReferenceArrayMap.this.key, oldPos, tail);
            System.arraycopy(Byte2ReferenceArrayMap.this.value, oldPos + 1, Byte2ReferenceArrayMap.this.value, oldPos, tail);
            Byte2ReferenceArrayMap.access$010(Byte2ReferenceArrayMap.this);
            Byte2ReferenceArrayMap.this.value[Byte2ReferenceArrayMap.this.size] = null;
            return true;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public Iterator<Byte> iterator() {
            return new ByteIterator() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ReferenceArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Byte2ReferenceArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                public byte nextByte() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    byte[] bArr = Byte2ReferenceArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return bArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Byte2ReferenceArrayMap.this.size - this.pos;
                    System.arraycopy(Byte2ReferenceArrayMap.this.key, this.pos, Byte2ReferenceArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Byte2ReferenceArrayMap.this.value, this.pos, Byte2ReferenceArrayMap.this.value, this.pos - 1, tail);
                    Byte2ReferenceArrayMap.access$010(Byte2ReferenceArrayMap.this);
                    this.pos--;
                    Byte2ReferenceArrayMap.this.value[Byte2ReferenceArrayMap.this.size] = null;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                public void forEachRemaining(ByteConsumer action) {
                    int max = Byte2ReferenceArrayMap.this.size;
                    while (this.pos < max) {
                        byte[] bArr = Byte2ReferenceArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(bArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceArrayMap$KeySet$KeySetSpliterator.class */
        public final class KeySetSpliterator extends ByteSpliterators.EarlyBindingSizeIndexBasedSpliterator implements ByteSpliterator {
            KeySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16721;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            protected final byte get(int location) {
                return Byte2ReferenceArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public final Byte2ReferenceArrayMap<V>.KeySet.KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ByteConsumer action) {
                int max = Byte2ReferenceArrayMap.this.size;
                while (this.pos < max) {
                    byte[] bArr = Byte2ReferenceArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(bArr[i]);
                }
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public Spliterator<Byte> spliterator() {
            return new KeySetSpliterator(0, Byte2ReferenceArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public void forEach(ByteConsumer action) {
            int max = Byte2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Byte2ReferenceArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Byte2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Byte2ReferenceArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
    public Set<Byte> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractReferenceCollection<V> {
        private ValuesCollection() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object v) {
            return Byte2ReferenceArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectIterator<V> iterator() {
            return new ObjectIterator<V>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ReferenceArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Byte2ReferenceArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public V next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Byte2ReferenceArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return (V) objArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Byte2ReferenceArrayMap.this.size - this.pos;
                    System.arraycopy(Byte2ReferenceArrayMap.this.key, this.pos, Byte2ReferenceArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Byte2ReferenceArrayMap.this.value, this.pos, Byte2ReferenceArrayMap.this.value, this.pos - 1, tail);
                    Byte2ReferenceArrayMap.access$010(Byte2ReferenceArrayMap.this);
                    this.pos--;
                    Byte2ReferenceArrayMap.this.value[Byte2ReferenceArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super V> action) {
                    int max = Byte2ReferenceArrayMap.this.size;
                    while (this.pos < max) {
                        Object[] objArr = Byte2ReferenceArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(objArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceArrayMap$ValuesCollection$ValuesSpliterator.class */
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
                return (V) Byte2ReferenceArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Byte2ReferenceArrayMap<V>.ValuesCollection.ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super V> action) {
                int max = Byte2ReferenceArrayMap.this.size;
                while (this.pos < max) {
                    Object[] objArr = Byte2ReferenceArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(objArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<V> spliterator() {
            return new ValuesSpliterator(0, Byte2ReferenceArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> action) {
            int max = Byte2ReferenceArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Byte2ReferenceArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Byte2ReferenceArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Byte2ReferenceArrayMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Byte2ReferenceArrayMap<V> clone() {
        try {
            Byte2ReferenceArrayMap<V> c = (Byte2ReferenceArrayMap) clone();
            c.key = (byte[]) this.key.clone();
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
            s.writeByte(this.key[i]);
            s.writeObject(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new byte[this.size];
        this.value = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readByte();
            this.value[i] = s.readObject();
        }
    }
}
