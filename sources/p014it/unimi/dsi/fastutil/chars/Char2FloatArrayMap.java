package p014it.unimi.dsi.fastutil.chars;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2FloatMap;
import p014it.unimi.dsi.fastutil.chars.Char2FloatMap;
import p014it.unimi.dsi.fastutil.chars.CharSpliterators;
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

/* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatArrayMap.class */
public class Char2FloatArrayMap extends AbstractChar2FloatMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient char[] key;
    private transient float[] value;
    private int size;
    private transient Char2FloatMap.FastEntrySet entries;
    private transient CharSet keys;
    private transient FloatCollection values;

    static /* synthetic */ int access$010(Char2FloatArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Char2FloatArrayMap(char[] key, float[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Char2FloatArrayMap() {
        this.key = CharArrays.EMPTY_ARRAY;
        this.value = FloatArrays.EMPTY_ARRAY;
    }

    public Char2FloatArrayMap(int capacity) {
        this.key = new char[capacity];
        this.value = new float[capacity];
    }

    public Char2FloatArrayMap(Char2FloatMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Char2FloatMap.Entry> it = m.char2FloatEntrySet().iterator();
        while (it.hasNext()) {
            Char2FloatMap.Entry e = it.next();
            this.key[i] = e.getCharKey();
            this.value[i] = e.getFloatValue();
            i++;
        }
        this.size = i;
    }

    public Char2FloatArrayMap(Map<? extends Character, ? extends Float> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Character, ? extends Float> e : m.entrySet()) {
            this.key[i] = ((Character) e.getKey()).charValue();
            this.value[i] = ((Float) e.getValue()).floatValue();
            i++;
        }
        this.size = i;
    }

    public Char2FloatArrayMap(char[] key, float[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Char2FloatMap.Entry> implements Char2FloatMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Char2FloatMap.Entry> iterator() {
            return new ObjectIterator<Char2FloatMap.Entry>() { // from class: it.unimi.dsi.fastutil.chars.Char2FloatArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Char2FloatArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Char2FloatMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    char[] cArr = Char2FloatArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    char c = cArr[i];
                    float[] fArr = Char2FloatArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractChar2FloatMap.BasicEntry(c, fArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Char2FloatArrayMap.access$010(Char2FloatArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Char2FloatArrayMap.this.key, this.next + 1, Char2FloatArrayMap.this.key, this.next, tail);
                    System.arraycopy(Char2FloatArrayMap.this.value, this.next + 1, Char2FloatArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Char2FloatMap.Entry> action) {
                    int max = Char2FloatArrayMap.this.size;
                    while (this.next < max) {
                        char[] cArr = Char2FloatArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        char c = cArr[i];
                        float[] fArr = Char2FloatArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractChar2FloatMap.BasicEntry(c, fArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap.FastEntrySet
        public ObjectIterator<Char2FloatMap.Entry> fastIterator() {
            return new ObjectIterator<Char2FloatMap.Entry>() { // from class: it.unimi.dsi.fastutil.chars.Char2FloatArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractChar2FloatMap.BasicEntry entry = new AbstractChar2FloatMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Char2FloatArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Char2FloatMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractChar2FloatMap.BasicEntry basicEntry = this.entry;
                    char[] cArr = Char2FloatArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = cArr[i];
                    AbstractChar2FloatMap.BasicEntry basicEntry2 = this.entry;
                    float[] fArr = Char2FloatArrayMap.this.value;
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
                    int access$010 = Char2FloatArrayMap.access$010(Char2FloatArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Char2FloatArrayMap.this.key, this.next + 1, Char2FloatArrayMap.this.key, this.next, tail);
                    System.arraycopy(Char2FloatArrayMap.this.value, this.next + 1, Char2FloatArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Char2FloatMap.Entry> action) {
                    int max = Char2FloatArrayMap.this.size;
                    while (this.next < max) {
                        AbstractChar2FloatMap.BasicEntry basicEntry = this.entry;
                        char[] cArr = Char2FloatArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = cArr[i];
                        AbstractChar2FloatMap.BasicEntry basicEntry2 = this.entry;
                        float[] fArr = Char2FloatArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = fArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Char2FloatMap.Entry> implements ObjectSpliterator<Char2FloatMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Char2FloatMap.Entry get(int location) {
                return new AbstractChar2FloatMap.BasicEntry(Char2FloatArrayMap.this.key[location], Char2FloatArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Char2FloatMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Char2FloatArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Char2FloatMap.Entry> action) {
            int max = Char2FloatArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractChar2FloatMap.BasicEntry(Char2FloatArrayMap.this.key[i], Char2FloatArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap.FastEntrySet
        public void fastForEach(Consumer<? super Char2FloatMap.Entry> action) {
            AbstractChar2FloatMap.BasicEntry entry = new AbstractChar2FloatMap.BasicEntry();
            int max = Char2FloatArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Char2FloatArrayMap.this.key[i];
                entry.value = Char2FloatArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Char2FloatArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Character) || e.getValue() == null || !(e.getValue() instanceof Float)) {
                return false;
            }
            char k = ((Character) e.getKey()).charValue();
            return Char2FloatArrayMap.this.containsKey(k) && Float.floatToIntBits(Char2FloatArrayMap.this.get(k)) == Float.floatToIntBits(((Float) e.getValue()).floatValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Character) || e.getValue() == null || !(e.getValue() instanceof Float)) {
                return false;
            }
            char k = ((Character) e.getKey()).charValue();
            float v = ((Float) e.getValue()).floatValue();
            int oldPos = Char2FloatArrayMap.this.findKey(k);
            if (oldPos == -1 || Float.floatToIntBits(v) != Float.floatToIntBits(Char2FloatArrayMap.this.value[oldPos])) {
                return false;
            }
            int tail = (Char2FloatArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Char2FloatArrayMap.this.key, oldPos + 1, Char2FloatArrayMap.this.key, oldPos, tail);
            System.arraycopy(Char2FloatArrayMap.this.value, oldPos + 1, Char2FloatArrayMap.this.value, oldPos, tail);
            Char2FloatArrayMap.access$010(Char2FloatArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
    public Char2FloatMap.FastEntrySet char2FloatEntrySet() {
        if (this.entries == null) {
            this.entries = new EntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    public int findKey(char k) {
        char[] key = this.key;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (key[i] != k);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
    public float get(char k) {
        char[] key = this.key;
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2FloatMap, p014it.unimi.dsi.fastutil.chars.Char2FloatFunction, p014it.unimi.dsi.fastutil.chars.Char2FloatMap
    public boolean containsKey(char k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2FloatMap, p014it.unimi.dsi.fastutil.chars.Char2FloatMap
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2FloatMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
    public float put(char k, float v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            float oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            char[] newKey = new char[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
    public float remove(char k) {
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
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatArrayMap$KeySet.class */
    public final class KeySet extends AbstractCharSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return Char2FloatArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.CharSet
        public boolean remove(char k) {
            int oldPos = Char2FloatArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Char2FloatArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Char2FloatArrayMap.this.key, oldPos + 1, Char2FloatArrayMap.this.key, oldPos, tail);
            System.arraycopy(Char2FloatArrayMap.this.value, oldPos + 1, Char2FloatArrayMap.this.value, oldPos, tail);
            Char2FloatArrayMap.access$010(Char2FloatArrayMap.this);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharIterator iterator() {
            return new CharIterator() { // from class: it.unimi.dsi.fastutil.chars.Char2FloatArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Char2FloatArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                public char nextChar() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    char[] cArr = Char2FloatArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return cArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Char2FloatArrayMap.this.size - this.pos;
                    System.arraycopy(Char2FloatArrayMap.this.key, this.pos, Char2FloatArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Char2FloatArrayMap.this.value, this.pos, Char2FloatArrayMap.this.value, this.pos - 1, tail);
                    Char2FloatArrayMap.access$010(Char2FloatArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                public void forEachRemaining(CharConsumer action) {
                    int max = Char2FloatArrayMap.this.size;
                    while (this.pos < max) {
                        char[] cArr = Char2FloatArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(cArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatArrayMap$KeySet$KeySetSpliterator.class */
        public final class KeySetSpliterator extends CharSpliterators.EarlyBindingSizeIndexBasedSpliterator implements CharSpliterator {
            KeySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16721;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            protected final char get(int location) {
                return Char2FloatArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(CharConsumer action) {
                int max = Char2FloatArrayMap.this.size;
                while (this.pos < max) {
                    char[] cArr = Char2FloatArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(cArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return new KeySetSpliterator(0, Char2FloatArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
        public void forEach(CharConsumer action) {
            int max = Char2FloatArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Char2FloatArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Char2FloatArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Char2FloatArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2FloatMap, p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
    public Set<Character> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractFloatCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float v) {
            return Char2FloatArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatIterator iterator() {
            return new FloatIterator() { // from class: it.unimi.dsi.fastutil.chars.Char2FloatArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Char2FloatArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                public float nextFloat() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    float[] fArr = Char2FloatArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return fArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Char2FloatArrayMap.this.size - this.pos;
                    System.arraycopy(Char2FloatArrayMap.this.key, this.pos, Char2FloatArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Char2FloatArrayMap.this.value, this.pos, Char2FloatArrayMap.this.value, this.pos - 1, tail);
                    Char2FloatArrayMap.access$010(Char2FloatArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                public void forEachRemaining(FloatConsumer action) {
                    int max = Char2FloatArrayMap.this.size;
                    while (this.pos < max) {
                        float[] fArr = Char2FloatArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(fArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatArrayMap$ValuesCollection$ValuesSpliterator.class */
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
                return Char2FloatArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(FloatConsumer action) {
                int max = Char2FloatArrayMap.this.size;
                while (this.pos < max) {
                    float[] fArr = Char2FloatArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(fArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return new ValuesSpliterator(0, Char2FloatArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
        public void forEach(FloatConsumer action) {
            int max = Char2FloatArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Char2FloatArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Char2FloatArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Char2FloatArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2FloatMap, p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
    public Collection<Float> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Char2FloatArrayMap clone() {
        try {
            Char2FloatArrayMap c = (Char2FloatArrayMap) clone();
            c.key = (char[]) this.key.clone();
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
            s.writeChar(this.key[i]);
            s.writeFloat(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new char[this.size];
        this.value = new float[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readChar();
            this.value[i] = s.readFloat();
        }
    }
}
