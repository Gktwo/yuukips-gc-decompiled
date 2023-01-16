package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharArrays;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharConsumer;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterators;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap;
import p014it.unimi.dsi.fastutil.ints.Int2CharMap;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2CharArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharArrayMap.class */
public class Int2CharArrayMap extends AbstractInt2CharMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient int[] key;
    private transient char[] value;
    private int size;
    private transient Int2CharMap.FastEntrySet entries;
    private transient IntSet keys;
    private transient CharCollection values;

    static /* synthetic */ int access$010(Int2CharArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Int2CharArrayMap(int[] key, char[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Int2CharArrayMap() {
        this.key = IntArrays.EMPTY_ARRAY;
        this.value = CharArrays.EMPTY_ARRAY;
    }

    public Int2CharArrayMap(int capacity) {
        this.key = new int[capacity];
        this.value = new char[capacity];
    }

    public Int2CharArrayMap(Int2CharMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Int2CharMap.Entry> it = m.int2CharEntrySet().iterator();
        while (it.hasNext()) {
            Int2CharMap.Entry e = it.next();
            this.key[i] = e.getIntKey();
            this.value[i] = e.getCharValue();
            i++;
        }
        this.size = i;
    }

    public Int2CharArrayMap(Map<? extends Integer, ? extends Character> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Integer, ? extends Character> e : m.entrySet()) {
            this.key[i] = ((Integer) e.getKey()).intValue();
            this.value[i] = ((Character) e.getValue()).charValue();
            i++;
        }
        this.size = i;
    }

    public Int2CharArrayMap(int[] key, char[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Int2CharMap.Entry> implements Int2CharMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Int2CharMap.Entry> iterator() {
            return new ObjectIterator<Int2CharMap.Entry>() { // from class: it.unimi.dsi.fastutil.ints.Int2CharArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Int2CharArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Int2CharMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int[] iArr = Int2CharArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    int i2 = iArr[i];
                    char[] cArr = Int2CharArrayMap.this.value;
                    int i3 = this.next;
                    this.next = i3 + 1;
                    return new AbstractInt2CharMap.BasicEntry(i2, cArr[i3]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Int2CharArrayMap.access$010(Int2CharArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Int2CharArrayMap.this.key, this.next + 1, Int2CharArrayMap.this.key, this.next, tail);
                    System.arraycopy(Int2CharArrayMap.this.value, this.next + 1, Int2CharArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Int2CharMap.Entry> action) {
                    int max = Int2CharArrayMap.this.size;
                    while (this.next < max) {
                        int[] iArr = Int2CharArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        int i2 = iArr[i];
                        char[] cArr = Int2CharArrayMap.this.value;
                        int i3 = this.next;
                        this.next = i3 + 1;
                        action.accept(new AbstractInt2CharMap.BasicEntry(i2, cArr[i3]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap.FastEntrySet
        public ObjectIterator<Int2CharMap.Entry> fastIterator() {
            return new ObjectIterator<Int2CharMap.Entry>() { // from class: it.unimi.dsi.fastutil.ints.Int2CharArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractInt2CharMap.BasicEntry entry = new AbstractInt2CharMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Int2CharArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Int2CharMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractInt2CharMap.BasicEntry basicEntry = this.entry;
                    int[] iArr = Int2CharArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = iArr[i];
                    AbstractInt2CharMap.BasicEntry basicEntry2 = this.entry;
                    char[] cArr = Int2CharArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = cArr[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Int2CharArrayMap.access$010(Int2CharArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Int2CharArrayMap.this.key, this.next + 1, Int2CharArrayMap.this.key, this.next, tail);
                    System.arraycopy(Int2CharArrayMap.this.value, this.next + 1, Int2CharArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Int2CharMap.Entry> action) {
                    int max = Int2CharArrayMap.this.size;
                    while (this.next < max) {
                        AbstractInt2CharMap.BasicEntry basicEntry = this.entry;
                        int[] iArr = Int2CharArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = iArr[i];
                        AbstractInt2CharMap.BasicEntry basicEntry2 = this.entry;
                        char[] cArr = Int2CharArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = cArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Int2CharMap.Entry> implements ObjectSpliterator<Int2CharMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Int2CharMap.Entry get(int location) {
                return new AbstractInt2CharMap.BasicEntry(Int2CharArrayMap.this.key[location], Int2CharArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Int2CharMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Int2CharArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Int2CharMap.Entry> action) {
            int max = Int2CharArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractInt2CharMap.BasicEntry(Int2CharArrayMap.this.key[i], Int2CharArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap.FastEntrySet
        public void fastForEach(Consumer<? super Int2CharMap.Entry> action) {
            AbstractInt2CharMap.BasicEntry entry = new AbstractInt2CharMap.BasicEntry();
            int max = Int2CharArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Int2CharArrayMap.this.key[i];
                entry.value = Int2CharArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2CharArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            return Int2CharArrayMap.this.containsKey(k) && Int2CharArrayMap.this.get(k) == ((Character) e.getValue()).charValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            char v = ((Character) e.getValue()).charValue();
            int oldPos = Int2CharArrayMap.this.findKey(k);
            if (oldPos == -1 || v != Int2CharArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Int2CharArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Int2CharArrayMap.this.key, oldPos + 1, Int2CharArrayMap.this.key, oldPos, tail);
            System.arraycopy(Int2CharArrayMap.this.value, oldPos + 1, Int2CharArrayMap.this.value, oldPos, tail);
            Int2CharArrayMap.access$010(Int2CharArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
    public Int2CharMap.FastEntrySet int2CharEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction
    public char get(int k) {
        int[] key = this.key;
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharFunction, p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public boolean containsKey(int k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public boolean containsValue(char v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (this.value[i] != v);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction
    public char put(int k, char v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            char oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            int[] newKey = new int[this.size == 0 ? 2 : this.size * 2];
            char[] newValue = new char[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction
    public char remove(int k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        char oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharArrayMap$KeySet.class */
    public final class KeySet extends AbstractIntSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return Int2CharArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.IntSet
        public boolean remove(int k) {
            int oldPos = Int2CharArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Int2CharArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Int2CharArrayMap.this.key, oldPos + 1, Int2CharArrayMap.this.key, oldPos, tail);
            System.arraycopy(Int2CharArrayMap.this.value, oldPos + 1, Int2CharArrayMap.this.value, oldPos, tail);
            Int2CharArrayMap.access$010(Int2CharArrayMap.this);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator iterator() {
            return new IntIterator() { // from class: it.unimi.dsi.fastutil.ints.Int2CharArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Int2CharArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                public int nextInt() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int[] iArr = Int2CharArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return iArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Int2CharArrayMap.this.size - this.pos;
                    System.arraycopy(Int2CharArrayMap.this.key, this.pos, Int2CharArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Int2CharArrayMap.this.value, this.pos, Int2CharArrayMap.this.value, this.pos - 1, tail);
                    Int2CharArrayMap.access$010(Int2CharArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfInt
                public void forEachRemaining(IntConsumer action) {
                    int max = Int2CharArrayMap.this.size;
                    while (this.pos < max) {
                        int[] iArr = Int2CharArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(iArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharArrayMap$KeySet$KeySetSpliterator.class */
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
                return Int2CharArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfInt
            public void forEachRemaining(IntConsumer action) {
                int max = Int2CharArrayMap.this.size;
                while (this.pos < max) {
                    int[] iArr = Int2CharArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(iArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return new KeySetSpliterator(0, Int2CharArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer action) {
            int max = Int2CharArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Int2CharArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2CharArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2CharArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
    public Set<Integer> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractCharCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char v) {
            return Int2CharArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharIterator iterator() {
            return new CharIterator() { // from class: it.unimi.dsi.fastutil.ints.Int2CharArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Int2CharArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                public char nextChar() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    char[] cArr = Int2CharArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return cArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Int2CharArrayMap.this.size - this.pos;
                    System.arraycopy(Int2CharArrayMap.this.key, this.pos, Int2CharArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Int2CharArrayMap.this.value, this.pos, Int2CharArrayMap.this.value, this.pos - 1, tail);
                    Int2CharArrayMap.access$010(Int2CharArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                public void forEachRemaining(CharConsumer action) {
                    int max = Int2CharArrayMap.this.size;
                    while (this.pos < max) {
                        char[] cArr = Int2CharArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(cArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharArrayMap$ValuesCollection$ValuesSpliterator.class */
        public final class ValuesSpliterator extends CharSpliterators.EarlyBindingSizeIndexBasedSpliterator implements CharSpliterator {
            ValuesSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16720;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            protected final char get(int location) {
                return Int2CharArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(CharConsumer action) {
                int max = Int2CharArrayMap.this.size;
                while (this.pos < max) {
                    char[] cArr = Int2CharArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(cArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return new ValuesSpliterator(0, Int2CharArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
        public void forEach(CharConsumer action) {
            int max = Int2CharArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Int2CharArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Int2CharArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Int2CharArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
    public Collection<Character> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Int2CharArrayMap clone() {
        try {
            Int2CharArrayMap c = (Int2CharArrayMap) clone();
            c.key = (int[]) this.key.clone();
            c.value = (char[]) this.value.clone();
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
            s.writeChar(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new int[this.size];
        this.value = new char[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readInt();
            this.value[i] = s.readChar();
        }
    }
}
