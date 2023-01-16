package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2LongMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongMap;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterators;
import p014it.unimi.dsi.fastutil.longs.AbstractLongCollection;
import p014it.unimi.dsi.fastutil.longs.LongArrays;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.longs.LongIterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongArrayMap.class */
public class Byte2LongArrayMap extends AbstractByte2LongMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient byte[] key;
    private transient long[] value;
    private int size;
    private transient Byte2LongMap.FastEntrySet entries;
    private transient ByteSet keys;
    private transient LongCollection values;

    static /* synthetic */ int access$010(Byte2LongArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Byte2LongArrayMap(byte[] key, long[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Byte2LongArrayMap() {
        this.key = ByteArrays.EMPTY_ARRAY;
        this.value = LongArrays.EMPTY_ARRAY;
    }

    public Byte2LongArrayMap(int capacity) {
        this.key = new byte[capacity];
        this.value = new long[capacity];
    }

    public Byte2LongArrayMap(Byte2LongMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Byte2LongMap.Entry> it = m.byte2LongEntrySet().iterator();
        while (it.hasNext()) {
            Byte2LongMap.Entry e = it.next();
            this.key[i] = e.getByteKey();
            this.value[i] = e.getLongValue();
            i++;
        }
        this.size = i;
    }

    public Byte2LongArrayMap(Map<? extends Byte, ? extends Long> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Byte, ? extends Long> e : m.entrySet()) {
            this.key[i] = ((Byte) e.getKey()).byteValue();
            this.value[i] = ((Long) e.getValue()).longValue();
            i++;
        }
        this.size = i;
    }

    public Byte2LongArrayMap(byte[] key, long[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Byte2LongMap.Entry> implements Byte2LongMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Byte2LongMap.Entry> iterator() {
            return new ObjectIterator<Byte2LongMap.Entry>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2LongArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Byte2LongArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Byte2LongMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    byte[] bArr = Byte2LongArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    byte b = bArr[i];
                    long[] jArr = Byte2LongArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractByte2LongMap.BasicEntry(b, jArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Byte2LongArrayMap.access$010(Byte2LongArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Byte2LongArrayMap.this.key, this.next + 1, Byte2LongArrayMap.this.key, this.next, tail);
                    System.arraycopy(Byte2LongArrayMap.this.value, this.next + 1, Byte2LongArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Byte2LongMap.Entry> action) {
                    int max = Byte2LongArrayMap.this.size;
                    while (this.next < max) {
                        byte[] bArr = Byte2LongArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        byte b = bArr[i];
                        long[] jArr = Byte2LongArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractByte2LongMap.BasicEntry(b, jArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap.FastEntrySet
        public ObjectIterator<Byte2LongMap.Entry> fastIterator() {
            return new ObjectIterator<Byte2LongMap.Entry>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2LongArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractByte2LongMap.BasicEntry entry = new AbstractByte2LongMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Byte2LongArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Byte2LongMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractByte2LongMap.BasicEntry basicEntry = this.entry;
                    byte[] bArr = Byte2LongArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = bArr[i];
                    AbstractByte2LongMap.BasicEntry basicEntry2 = this.entry;
                    long[] jArr = Byte2LongArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = jArr[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Byte2LongArrayMap.access$010(Byte2LongArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Byte2LongArrayMap.this.key, this.next + 1, Byte2LongArrayMap.this.key, this.next, tail);
                    System.arraycopy(Byte2LongArrayMap.this.value, this.next + 1, Byte2LongArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Byte2LongMap.Entry> action) {
                    int max = Byte2LongArrayMap.this.size;
                    while (this.next < max) {
                        AbstractByte2LongMap.BasicEntry basicEntry = this.entry;
                        byte[] bArr = Byte2LongArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = bArr[i];
                        AbstractByte2LongMap.BasicEntry basicEntry2 = this.entry;
                        long[] jArr = Byte2LongArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = jArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Byte2LongMap.Entry> implements ObjectSpliterator<Byte2LongMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Byte2LongMap.Entry get(int location) {
                return new AbstractByte2LongMap.BasicEntry(Byte2LongArrayMap.this.key[location], Byte2LongArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Byte2LongMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Byte2LongArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Byte2LongMap.Entry> action) {
            int max = Byte2LongArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractByte2LongMap.BasicEntry(Byte2LongArrayMap.this.key[i], Byte2LongArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap.FastEntrySet
        public void fastForEach(Consumer<? super Byte2LongMap.Entry> action) {
            AbstractByte2LongMap.BasicEntry entry = new AbstractByte2LongMap.BasicEntry();
            int max = Byte2LongArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Byte2LongArrayMap.this.key[i];
                entry.value = Byte2LongArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Byte2LongArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Byte) || e.getValue() == null || !(e.getValue() instanceof Long)) {
                return false;
            }
            byte k = ((Byte) e.getKey()).byteValue();
            return Byte2LongArrayMap.this.containsKey(k) && Byte2LongArrayMap.this.get(k) == ((Long) e.getValue()).longValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Byte) || e.getValue() == null || !(e.getValue() instanceof Long)) {
                return false;
            }
            byte k = ((Byte) e.getKey()).byteValue();
            long v = ((Long) e.getValue()).longValue();
            int oldPos = Byte2LongArrayMap.this.findKey(k);
            if (oldPos == -1 || v != Byte2LongArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Byte2LongArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Byte2LongArrayMap.this.key, oldPos + 1, Byte2LongArrayMap.this.key, oldPos, tail);
            System.arraycopy(Byte2LongArrayMap.this.value, oldPos + 1, Byte2LongArrayMap.this.value, oldPos, tail);
            Byte2LongArrayMap.access$010(Byte2LongArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap
    public Byte2LongMap.FastEntrySet byte2LongEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
    public long get(byte k) {
        byte[] key = this.key;
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

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2LongMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap
    public boolean containsKey(byte k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2LongMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap
    public boolean containsValue(long v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (this.value[i] != v);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2LongMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
    public long put(byte k, long v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            long oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            byte[] newKey = new byte[this.size == 0 ? 2 : this.size * 2];
            long[] newValue = new long[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
    public long remove(byte k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        long oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongArrayMap$KeySet.class */
    public final class KeySet extends AbstractByteSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return Byte2LongArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.ByteSet
        public boolean remove(byte k) {
            int oldPos = Byte2LongArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Byte2LongArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Byte2LongArrayMap.this.key, oldPos + 1, Byte2LongArrayMap.this.key, oldPos, tail);
            System.arraycopy(Byte2LongArrayMap.this.value, oldPos + 1, Byte2LongArrayMap.this.value, oldPos, tail);
            Byte2LongArrayMap.access$010(Byte2LongArrayMap.this);
            return true;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public Iterator<Byte> iterator() {
            return new ByteIterator() { // from class: it.unimi.dsi.fastutil.bytes.Byte2LongArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Byte2LongArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                public byte nextByte() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    byte[] bArr = Byte2LongArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return bArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Byte2LongArrayMap.this.size - this.pos;
                    System.arraycopy(Byte2LongArrayMap.this.key, this.pos, Byte2LongArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Byte2LongArrayMap.this.value, this.pos, Byte2LongArrayMap.this.value, this.pos - 1, tail);
                    Byte2LongArrayMap.access$010(Byte2LongArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                public void forEachRemaining(ByteConsumer action) {
                    int max = Byte2LongArrayMap.this.size;
                    while (this.pos < max) {
                        byte[] bArr = Byte2LongArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(bArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongArrayMap$KeySet$KeySetSpliterator.class */
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
                return Byte2LongArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ByteConsumer action) {
                int max = Byte2LongArrayMap.this.size;
                while (this.pos < max) {
                    byte[] bArr = Byte2LongArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(bArr[i]);
                }
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public Spliterator<Byte> spliterator() {
            return new KeySetSpliterator(0, Byte2LongArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public void forEach(ByteConsumer action) {
            int max = Byte2LongArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Byte2LongArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Byte2LongArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Byte2LongArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2LongMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
    public Set<Byte> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractLongCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long v) {
            return Byte2LongArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator iterator() {
            return new LongIterator() { // from class: it.unimi.dsi.fastutil.bytes.Byte2LongArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Byte2LongArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
                public long nextLong() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    long[] jArr = Byte2LongArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return jArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Byte2LongArrayMap.this.size - this.pos;
                    System.arraycopy(Byte2LongArrayMap.this.key, this.pos, Byte2LongArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Byte2LongArrayMap.this.value, this.pos, Byte2LongArrayMap.this.value, this.pos - 1, tail);
                    Byte2LongArrayMap.access$010(Byte2LongArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfLong
                public void forEachRemaining(LongConsumer action) {
                    int max = Byte2LongArrayMap.this.size;
                    while (this.pos < max) {
                        long[] jArr = Byte2LongArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(jArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongArrayMap$ValuesCollection$ValuesSpliterator.class */
        public final class ValuesSpliterator extends LongSpliterators.EarlyBindingSizeIndexBasedSpliterator implements LongSpliterator {
            ValuesSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16720;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
            protected final long get(int location) {
                return Byte2LongArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfLong
            public void forEachRemaining(LongConsumer action) {
                int max = Byte2LongArrayMap.this.size;
                while (this.pos < max) {
                    long[] jArr = Byte2LongArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(jArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return new ValuesSpliterator(0, Byte2LongArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
        public void forEach(LongConsumer action) {
            int max = Byte2LongArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Byte2LongArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Byte2LongArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Byte2LongArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2LongMap, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
    public Collection<Long> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Byte2LongArrayMap clone() {
        try {
            Byte2LongArrayMap c = (Byte2LongArrayMap) clone();
            c.key = (byte[]) this.key.clone();
            c.value = (long[]) this.value.clone();
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
            s.writeLong(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new byte[this.size];
        this.value = new long[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readByte();
            this.value[i] = s.readLong();
        }
    }
}
