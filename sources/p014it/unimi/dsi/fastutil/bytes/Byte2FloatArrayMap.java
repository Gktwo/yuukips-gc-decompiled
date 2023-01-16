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
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2FloatMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterators;
import p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatArrays;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatConsumer;
import p014it.unimi.dsi.fastutil.floats.FloatIterator;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterator;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatArrayMap.class */
public class Byte2FloatArrayMap extends AbstractByte2FloatMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient byte[] key;
    private transient float[] value;
    private int size;
    private transient Byte2FloatMap.FastEntrySet entries;
    private transient ByteSet keys;
    private transient FloatCollection values;

    static /* synthetic */ int access$010(Byte2FloatArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Byte2FloatArrayMap(byte[] key, float[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Byte2FloatArrayMap() {
        this.key = ByteArrays.EMPTY_ARRAY;
        this.value = FloatArrays.EMPTY_ARRAY;
    }

    public Byte2FloatArrayMap(int capacity) {
        this.key = new byte[capacity];
        this.value = new float[capacity];
    }

    public Byte2FloatArrayMap(Byte2FloatMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Byte2FloatMap.Entry> it = m.byte2FloatEntrySet().iterator();
        while (it.hasNext()) {
            Byte2FloatMap.Entry e = it.next();
            this.key[i] = e.getByteKey();
            this.value[i] = e.getFloatValue();
            i++;
        }
        this.size = i;
    }

    public Byte2FloatArrayMap(Map<? extends Byte, ? extends Float> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Byte, ? extends Float> e : m.entrySet()) {
            this.key[i] = ((Byte) e.getKey()).byteValue();
            this.value[i] = ((Float) e.getValue()).floatValue();
            i++;
        }
        this.size = i;
    }

    public Byte2FloatArrayMap(byte[] key, float[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Byte2FloatMap.Entry> implements Byte2FloatMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Byte2FloatMap.Entry> iterator() {
            return new ObjectIterator<Byte2FloatMap.Entry>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2FloatArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Byte2FloatArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Byte2FloatMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    byte[] bArr = Byte2FloatArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    byte b = bArr[i];
                    float[] fArr = Byte2FloatArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractByte2FloatMap.BasicEntry(b, fArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Byte2FloatArrayMap.access$010(Byte2FloatArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Byte2FloatArrayMap.this.key, this.next + 1, Byte2FloatArrayMap.this.key, this.next, tail);
                    System.arraycopy(Byte2FloatArrayMap.this.value, this.next + 1, Byte2FloatArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Byte2FloatMap.Entry> action) {
                    int max = Byte2FloatArrayMap.this.size;
                    while (this.next < max) {
                        byte[] bArr = Byte2FloatArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        byte b = bArr[i];
                        float[] fArr = Byte2FloatArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractByte2FloatMap.BasicEntry(b, fArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap.FastEntrySet
        public ObjectIterator<Byte2FloatMap.Entry> fastIterator() {
            return new ObjectIterator<Byte2FloatMap.Entry>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2FloatArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractByte2FloatMap.BasicEntry entry = new AbstractByte2FloatMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Byte2FloatArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Byte2FloatMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractByte2FloatMap.BasicEntry basicEntry = this.entry;
                    byte[] bArr = Byte2FloatArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = bArr[i];
                    AbstractByte2FloatMap.BasicEntry basicEntry2 = this.entry;
                    float[] fArr = Byte2FloatArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = fArr[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Byte2FloatArrayMap.access$010(Byte2FloatArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Byte2FloatArrayMap.this.key, this.next + 1, Byte2FloatArrayMap.this.key, this.next, tail);
                    System.arraycopy(Byte2FloatArrayMap.this.value, this.next + 1, Byte2FloatArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Byte2FloatMap.Entry> action) {
                    int max = Byte2FloatArrayMap.this.size;
                    while (this.next < max) {
                        AbstractByte2FloatMap.BasicEntry basicEntry = this.entry;
                        byte[] bArr = Byte2FloatArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = bArr[i];
                        AbstractByte2FloatMap.BasicEntry basicEntry2 = this.entry;
                        float[] fArr = Byte2FloatArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = fArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Byte2FloatMap.Entry> implements ObjectSpliterator<Byte2FloatMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Byte2FloatMap.Entry get(int location) {
                return new AbstractByte2FloatMap.BasicEntry(Byte2FloatArrayMap.this.key[location], Byte2FloatArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Byte2FloatMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Byte2FloatArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Byte2FloatMap.Entry> action) {
            int max = Byte2FloatArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractByte2FloatMap.BasicEntry(Byte2FloatArrayMap.this.key[i], Byte2FloatArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap.FastEntrySet
        public void fastForEach(Consumer<? super Byte2FloatMap.Entry> action) {
            AbstractByte2FloatMap.BasicEntry entry = new AbstractByte2FloatMap.BasicEntry();
            int max = Byte2FloatArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Byte2FloatArrayMap.this.key[i];
                entry.value = Byte2FloatArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Byte2FloatArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Byte) || e.getValue() == null || !(e.getValue() instanceof Float)) {
                return false;
            }
            byte k = ((Byte) e.getKey()).byteValue();
            return Byte2FloatArrayMap.this.containsKey(k) && Float.floatToIntBits(Byte2FloatArrayMap.this.get(k)) == Float.floatToIntBits(((Float) e.getValue()).floatValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Byte) || e.getValue() == null || !(e.getValue() instanceof Float)) {
                return false;
            }
            byte k = ((Byte) e.getKey()).byteValue();
            float v = ((Float) e.getValue()).floatValue();
            int oldPos = Byte2FloatArrayMap.this.findKey(k);
            if (oldPos == -1 || Float.floatToIntBits(v) != Float.floatToIntBits(Byte2FloatArrayMap.this.value[oldPos])) {
                return false;
            }
            int tail = (Byte2FloatArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Byte2FloatArrayMap.this.key, oldPos + 1, Byte2FloatArrayMap.this.key, oldPos, tail);
            System.arraycopy(Byte2FloatArrayMap.this.value, oldPos + 1, Byte2FloatArrayMap.this.value, oldPos, tail);
            Byte2FloatArrayMap.access$010(Byte2FloatArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
    public Byte2FloatMap.FastEntrySet byte2FloatEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
    public float get(byte k) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2FloatMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap
    public boolean containsKey(byte k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2FloatMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap
    public boolean containsValue(float v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (Float.floatToIntBits(this.value[i]) != Float.floatToIntBits(v));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2FloatMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
    public float put(byte k, float v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            float oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            byte[] newKey = new byte[this.size == 0 ? 2 : this.size * 2];
            float[] newValue = new float[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
    public float remove(byte k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        float oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatArrayMap$KeySet.class */
    public final class KeySet extends AbstractByteSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return Byte2FloatArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.ByteSet
        public boolean remove(byte k) {
            int oldPos = Byte2FloatArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Byte2FloatArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Byte2FloatArrayMap.this.key, oldPos + 1, Byte2FloatArrayMap.this.key, oldPos, tail);
            System.arraycopy(Byte2FloatArrayMap.this.value, oldPos + 1, Byte2FloatArrayMap.this.value, oldPos, tail);
            Byte2FloatArrayMap.access$010(Byte2FloatArrayMap.this);
            return true;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public Iterator<Byte> iterator() {
            return new ByteIterator() { // from class: it.unimi.dsi.fastutil.bytes.Byte2FloatArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Byte2FloatArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                public byte nextByte() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    byte[] bArr = Byte2FloatArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return bArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Byte2FloatArrayMap.this.size - this.pos;
                    System.arraycopy(Byte2FloatArrayMap.this.key, this.pos, Byte2FloatArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Byte2FloatArrayMap.this.value, this.pos, Byte2FloatArrayMap.this.value, this.pos - 1, tail);
                    Byte2FloatArrayMap.access$010(Byte2FloatArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                public void forEachRemaining(ByteConsumer action) {
                    int max = Byte2FloatArrayMap.this.size;
                    while (this.pos < max) {
                        byte[] bArr = Byte2FloatArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(bArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatArrayMap$KeySet$KeySetSpliterator.class */
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
                return Byte2FloatArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ByteConsumer action) {
                int max = Byte2FloatArrayMap.this.size;
                while (this.pos < max) {
                    byte[] bArr = Byte2FloatArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(bArr[i]);
                }
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public Spliterator<Byte> spliterator() {
            return new KeySetSpliterator(0, Byte2FloatArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public void forEach(ByteConsumer action) {
            int max = Byte2FloatArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Byte2FloatArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Byte2FloatArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Byte2FloatArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2FloatMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
    public Set<Byte> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractFloatCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float v) {
            return Byte2FloatArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatIterator iterator() {
            return new FloatIterator() { // from class: it.unimi.dsi.fastutil.bytes.Byte2FloatArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Byte2FloatArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                public float nextFloat() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    float[] fArr = Byte2FloatArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return fArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Byte2FloatArrayMap.this.size - this.pos;
                    System.arraycopy(Byte2FloatArrayMap.this.key, this.pos, Byte2FloatArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Byte2FloatArrayMap.this.value, this.pos, Byte2FloatArrayMap.this.value, this.pos - 1, tail);
                    Byte2FloatArrayMap.access$010(Byte2FloatArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                public void forEachRemaining(FloatConsumer action) {
                    int max = Byte2FloatArrayMap.this.size;
                    while (this.pos < max) {
                        float[] fArr = Byte2FloatArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(fArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatArrayMap$ValuesCollection$ValuesSpliterator.class */
        public final class ValuesSpliterator extends FloatSpliterators.EarlyBindingSizeIndexBasedSpliterator implements FloatSpliterator {
            ValuesSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16720;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            protected final float get(int location) {
                return Byte2FloatArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(FloatConsumer action) {
                int max = Byte2FloatArrayMap.this.size;
                while (this.pos < max) {
                    float[] fArr = Byte2FloatArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(fArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return new ValuesSpliterator(0, Byte2FloatArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
        public void forEach(FloatConsumer action) {
            int max = Byte2FloatArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Byte2FloatArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Byte2FloatArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Byte2FloatArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2FloatMap, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
    public Collection<Float> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Byte2FloatArrayMap clone() {
        try {
            Byte2FloatArrayMap c = (Byte2FloatArrayMap) clone();
            c.key = (byte[]) this.key.clone();
            c.value = (float[]) this.value.clone();
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
            s.writeFloat(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new byte[this.size];
        this.value = new float[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readByte();
            this.value[i] = s.readFloat();
        }
    }
}
