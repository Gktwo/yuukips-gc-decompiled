package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectArrays;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectArrayMap.class */
public class Byte2ObjectArrayMap<V> extends AbstractByte2ObjectMap<V> implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient byte[] key;
    private transient Object[] value;
    private int size;
    private transient Byte2ObjectMap.FastEntrySet<V> entries;
    private transient ByteSet keys;
    private transient ObjectCollection<V> values;

    static /* synthetic */ int access$010(Byte2ObjectArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Byte2ObjectArrayMap(byte[] key, Object[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Byte2ObjectArrayMap() {
        this.key = ByteArrays.EMPTY_ARRAY;
        this.value = ObjectArrays.EMPTY_ARRAY;
    }

    public Byte2ObjectArrayMap(int capacity) {
        this.key = new byte[capacity];
        this.value = new Object[capacity];
    }

    public Byte2ObjectArrayMap(Byte2ObjectMap<V> m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Byte2ObjectMap.Entry<V>> it = m.byte2ObjectEntrySet().iterator();
        while (it.hasNext()) {
            Byte2ObjectMap.Entry<V> e = it.next();
            this.key[i] = e.getByteKey();
            this.value[i] = e.getValue();
            i++;
        }
        this.size = i;
    }

    public Byte2ObjectArrayMap(Map<? extends Byte, ? extends V> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Byte, ? extends V> e : m.entrySet()) {
            this.key[i] = ((Byte) e.getKey()).byteValue();
            this.value[i] = e.getValue();
            i++;
        }
        this.size = i;
    }

    public Byte2ObjectArrayMap(byte[] key, Object[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Byte2ObjectMap.Entry<V>> implements Byte2ObjectMap.FastEntrySet<V> {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Byte2ObjectMap.Entry<V>> iterator() {
            return new ObjectIterator<Byte2ObjectMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ObjectArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Byte2ObjectArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Byte2ObjectMap.Entry<V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    byte[] bArr = Byte2ObjectArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    byte b = bArr[i];
                    Object[] objArr = Byte2ObjectArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractByte2ObjectMap.BasicEntry(b, objArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Byte2ObjectArrayMap.access$010(Byte2ObjectArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Byte2ObjectArrayMap.this.key, this.next + 1, Byte2ObjectArrayMap.this.key, this.next, tail);
                    System.arraycopy(Byte2ObjectArrayMap.this.value, this.next + 1, Byte2ObjectArrayMap.this.value, this.next, tail);
                    Byte2ObjectArrayMap.this.value[Byte2ObjectArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Byte2ObjectMap.Entry<V>> action) {
                    int max = Byte2ObjectArrayMap.this.size;
                    while (this.next < max) {
                        byte[] bArr = Byte2ObjectArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        byte b = bArr[i];
                        Object[] objArr = Byte2ObjectArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractByte2ObjectMap.BasicEntry(b, objArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap.FastEntrySet
        public ObjectIterator<Byte2ObjectMap.Entry<V>> fastIterator() {
            return new ObjectIterator<Byte2ObjectMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ObjectArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractByte2ObjectMap.BasicEntry<V> entry = new AbstractByte2ObjectMap.BasicEntry<>();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Byte2ObjectArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Byte2ObjectMap.Entry<V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractByte2ObjectMap.BasicEntry<V> basicEntry = this.entry;
                    byte[] bArr = Byte2ObjectArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = bArr[i];
                    AbstractByte2ObjectMap.BasicEntry<V> basicEntry2 = this.entry;
                    Object[] objArr = Byte2ObjectArrayMap.this.value;
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
                    int access$010 = Byte2ObjectArrayMap.access$010(Byte2ObjectArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Byte2ObjectArrayMap.this.key, this.next + 1, Byte2ObjectArrayMap.this.key, this.next, tail);
                    System.arraycopy(Byte2ObjectArrayMap.this.value, this.next + 1, Byte2ObjectArrayMap.this.value, this.next, tail);
                    Byte2ObjectArrayMap.this.value[Byte2ObjectArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Byte2ObjectMap.Entry<V>> action) {
                    int max = Byte2ObjectArrayMap.this.size;
                    while (this.next < max) {
                        AbstractByte2ObjectMap.BasicEntry<V> basicEntry = this.entry;
                        byte[] bArr = Byte2ObjectArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = bArr[i];
                        AbstractByte2ObjectMap.BasicEntry<V> basicEntry2 = this.entry;
                        Object[] objArr = Byte2ObjectArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = (V) objArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Byte2ObjectMap.Entry<V>> implements ObjectSpliterator<Byte2ObjectMap.Entry<V>> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Byte2ObjectMap.Entry<V> get(int location) {
                return new AbstractByte2ObjectMap.BasicEntry(Byte2ObjectArrayMap.this.key[location], Byte2ObjectArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Byte2ObjectArrayMap<V>.EntrySet.EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Byte2ObjectMap.Entry<V>> spliterator() {
            return new EntrySetSpliterator(0, Byte2ObjectArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Byte2ObjectMap.Entry<V>> action) {
            int max = Byte2ObjectArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractByte2ObjectMap.BasicEntry(Byte2ObjectArrayMap.this.key[i], Byte2ObjectArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap.FastEntrySet
        public void fastForEach(Consumer<? super Byte2ObjectMap.Entry<V>> action) {
            AbstractByte2ObjectMap.BasicEntry<V> entry = new AbstractByte2ObjectMap.BasicEntry<>();
            int max = Byte2ObjectArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Byte2ObjectArrayMap.this.key[i];
                entry.value = (V) Byte2ObjectArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Byte2ObjectArrayMap.this.size;
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
            return Byte2ObjectArrayMap.this.containsKey(k) && Objects.equals(Byte2ObjectArrayMap.this.get(k), e.getValue());
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
            int oldPos = Byte2ObjectArrayMap.this.findKey(k);
            if (oldPos == -1 || !Objects.equals(value, Byte2ObjectArrayMap.this.value[oldPos])) {
                return false;
            }
            int tail = (Byte2ObjectArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Byte2ObjectArrayMap.this.key, oldPos + 1, Byte2ObjectArrayMap.this.key, oldPos, tail);
            System.arraycopy(Byte2ObjectArrayMap.this.value, oldPos + 1, Byte2ObjectArrayMap.this.value, oldPos, tail);
            Byte2ObjectArrayMap.access$010(Byte2ObjectArrayMap.this);
            Byte2ObjectArrayMap.this.value[Byte2ObjectArrayMap.this.size] = null;
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectSortedMap
    public Byte2ObjectMap.FastEntrySet<V> byte2ObjectEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction
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

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
    public boolean containsKey(byte k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap, java.util.Map
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

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction
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
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectArrayMap$KeySet.class */
    public final class KeySet extends AbstractByteSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return Byte2ObjectArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.ByteSet
        public boolean remove(byte k) {
            int oldPos = Byte2ObjectArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Byte2ObjectArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Byte2ObjectArrayMap.this.key, oldPos + 1, Byte2ObjectArrayMap.this.key, oldPos, tail);
            System.arraycopy(Byte2ObjectArrayMap.this.value, oldPos + 1, Byte2ObjectArrayMap.this.value, oldPos, tail);
            Byte2ObjectArrayMap.access$010(Byte2ObjectArrayMap.this);
            Byte2ObjectArrayMap.this.value[Byte2ObjectArrayMap.this.size] = null;
            return true;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public Iterator<Byte> iterator() {
            return new ByteIterator() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ObjectArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Byte2ObjectArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                public byte nextByte() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    byte[] bArr = Byte2ObjectArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return bArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Byte2ObjectArrayMap.this.size - this.pos;
                    System.arraycopy(Byte2ObjectArrayMap.this.key, this.pos, Byte2ObjectArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Byte2ObjectArrayMap.this.value, this.pos, Byte2ObjectArrayMap.this.value, this.pos - 1, tail);
                    Byte2ObjectArrayMap.access$010(Byte2ObjectArrayMap.this);
                    this.pos--;
                    Byte2ObjectArrayMap.this.value[Byte2ObjectArrayMap.this.size] = null;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                public void forEachRemaining(ByteConsumer action) {
                    int max = Byte2ObjectArrayMap.this.size;
                    while (this.pos < max) {
                        byte[] bArr = Byte2ObjectArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(bArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectArrayMap$KeySet$KeySetSpliterator.class */
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
                return Byte2ObjectArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public final Byte2ObjectArrayMap<V>.KeySet.KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ByteConsumer action) {
                int max = Byte2ObjectArrayMap.this.size;
                while (this.pos < max) {
                    byte[] bArr = Byte2ObjectArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(bArr[i]);
                }
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public Spliterator<Byte> spliterator() {
            return new KeySetSpliterator(0, Byte2ObjectArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public void forEach(ByteConsumer action) {
            int max = Byte2ObjectArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Byte2ObjectArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Byte2ObjectArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Byte2ObjectArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
    public Set<Byte> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractObjectCollection<V> {
        private ValuesCollection() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object v) {
            return Byte2ObjectArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<V> iterator() {
            return new ObjectIterator<V>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ObjectArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Byte2ObjectArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public V next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Byte2ObjectArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return (V) objArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Byte2ObjectArrayMap.this.size - this.pos;
                    System.arraycopy(Byte2ObjectArrayMap.this.key, this.pos, Byte2ObjectArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Byte2ObjectArrayMap.this.value, this.pos, Byte2ObjectArrayMap.this.value, this.pos - 1, tail);
                    Byte2ObjectArrayMap.access$010(Byte2ObjectArrayMap.this);
                    this.pos--;
                    Byte2ObjectArrayMap.this.value[Byte2ObjectArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super V> action) {
                    int max = Byte2ObjectArrayMap.this.size;
                    while (this.pos < max) {
                        Object[] objArr = Byte2ObjectArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(objArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectArrayMap$ValuesCollection$ValuesSpliterator.class */
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
                return (V) Byte2ObjectArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Byte2ObjectArrayMap<V>.ValuesCollection.ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super V> action) {
                int max = Byte2ObjectArrayMap.this.size;
                while (this.pos < max) {
                    Object[] objArr = Byte2ObjectArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(objArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<V> spliterator() {
            return new ValuesSpliterator(0, Byte2ObjectArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> action) {
            int max = Byte2ObjectArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Byte2ObjectArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Byte2ObjectArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Byte2ObjectArrayMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Byte2ObjectArrayMap<V> clone() {
        try {
            Byte2ObjectArrayMap<V> c = (Byte2ObjectArrayMap) clone();
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
