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
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2IntMap;
import p014it.unimi.dsi.fastutil.chars.Char2IntMap;
import p014it.unimi.dsi.fastutil.chars.CharSpliterators;
import p014it.unimi.dsi.fastutil.ints.AbstractIntCollection;
import p014it.unimi.dsi.fastutil.ints.IntArrays;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2IntArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntArrayMap.class */
public class Char2IntArrayMap extends AbstractChar2IntMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient char[] key;
    private transient int[] value;
    private int size;
    private transient Char2IntMap.FastEntrySet entries;
    private transient CharSet keys;
    private transient IntCollection values;

    static /* synthetic */ int access$010(Char2IntArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Char2IntArrayMap(char[] key, int[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Char2IntArrayMap() {
        this.key = CharArrays.EMPTY_ARRAY;
        this.value = IntArrays.EMPTY_ARRAY;
    }

    public Char2IntArrayMap(int capacity) {
        this.key = new char[capacity];
        this.value = new int[capacity];
    }

    public Char2IntArrayMap(Char2IntMap m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Char2IntMap.Entry> it = m.char2IntEntrySet().iterator();
        while (it.hasNext()) {
            Char2IntMap.Entry e = it.next();
            this.key[i] = e.getCharKey();
            this.value[i] = e.getIntValue();
            i++;
        }
        this.size = i;
    }

    public Char2IntArrayMap(Map<? extends Character, ? extends Integer> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends Character, ? extends Integer> e : m.entrySet()) {
            this.key[i] = ((Character) e.getKey()).charValue();
            this.value[i] = ((Integer) e.getValue()).intValue();
            i++;
        }
        this.size = i;
    }

    public Char2IntArrayMap(char[] key, int[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2IntArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Char2IntMap.Entry> implements Char2IntMap.FastEntrySet {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Char2IntMap.Entry> iterator() {
            return new ObjectIterator<Char2IntMap.Entry>() { // from class: it.unimi.dsi.fastutil.chars.Char2IntArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Char2IntArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Char2IntMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    char[] cArr = Char2IntArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    char c = cArr[i];
                    int[] iArr = Char2IntArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractChar2IntMap.BasicEntry(c, iArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Char2IntArrayMap.access$010(Char2IntArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Char2IntArrayMap.this.key, this.next + 1, Char2IntArrayMap.this.key, this.next, tail);
                    System.arraycopy(Char2IntArrayMap.this.value, this.next + 1, Char2IntArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Char2IntMap.Entry> action) {
                    int max = Char2IntArrayMap.this.size;
                    while (this.next < max) {
                        char[] cArr = Char2IntArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        char c = cArr[i];
                        int[] iArr = Char2IntArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractChar2IntMap.BasicEntry(c, iArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntMap.FastEntrySet
        public ObjectIterator<Char2IntMap.Entry> fastIterator() {
            return new ObjectIterator<Char2IntMap.Entry>() { // from class: it.unimi.dsi.fastutil.chars.Char2IntArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractChar2IntMap.BasicEntry entry = new AbstractChar2IntMap.BasicEntry();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Char2IntArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Char2IntMap.Entry next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractChar2IntMap.BasicEntry basicEntry = this.entry;
                    char[] cArr = Char2IntArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = cArr[i];
                    AbstractChar2IntMap.BasicEntry basicEntry2 = this.entry;
                    int[] iArr = Char2IntArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    basicEntry2.value = iArr[i2];
                    return this.entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Char2IntArrayMap.access$010(Char2IntArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Char2IntArrayMap.this.key, this.next + 1, Char2IntArrayMap.this.key, this.next, tail);
                    System.arraycopy(Char2IntArrayMap.this.value, this.next + 1, Char2IntArrayMap.this.value, this.next, tail);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Char2IntMap.Entry> action) {
                    int max = Char2IntArrayMap.this.size;
                    while (this.next < max) {
                        AbstractChar2IntMap.BasicEntry basicEntry = this.entry;
                        char[] cArr = Char2IntArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = cArr[i];
                        AbstractChar2IntMap.BasicEntry basicEntry2 = this.entry;
                        int[] iArr = Char2IntArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = iArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.chars.Char2IntArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Char2IntMap.Entry> implements ObjectSpliterator<Char2IntMap.Entry> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Char2IntMap.Entry get(int location) {
                return new AbstractChar2IntMap.BasicEntry(Char2IntArrayMap.this.key[location], Char2IntArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Char2IntMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Char2IntArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Char2IntMap.Entry> action) {
            int max = Char2IntArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractChar2IntMap.BasicEntry(Char2IntArrayMap.this.key[i], Char2IntArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntMap.FastEntrySet
        public void fastForEach(Consumer<? super Char2IntMap.Entry> action) {
            AbstractChar2IntMap.BasicEntry entry = new AbstractChar2IntMap.BasicEntry();
            int max = Char2IntArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = Char2IntArrayMap.this.key[i];
                entry.value = Char2IntArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Char2IntArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Character) || e.getValue() == null || !(e.getValue() instanceof Integer)) {
                return false;
            }
            char k = ((Character) e.getKey()).charValue();
            return Char2IntArrayMap.this.containsKey(k) && Char2IntArrayMap.this.get(k) == ((Integer) e.getValue()).intValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Character) || e.getValue() == null || !(e.getValue() instanceof Integer)) {
                return false;
            }
            char k = ((Character) e.getKey()).charValue();
            int v = ((Integer) e.getValue()).intValue();
            int oldPos = Char2IntArrayMap.this.findKey(k);
            if (oldPos == -1 || v != Char2IntArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Char2IntArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Char2IntArrayMap.this.key, oldPos + 1, Char2IntArrayMap.this.key, oldPos, tail);
            System.arraycopy(Char2IntArrayMap.this.value, oldPos + 1, Char2IntArrayMap.this.value, oldPos, tail);
            Char2IntArrayMap.access$010(Char2IntArrayMap.this);
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntMap, p014it.unimi.dsi.fastutil.chars.Char2IntSortedMap
    public Char2IntMap.FastEntrySet char2IntEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
    public int get(char k) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2IntMap, p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.chars.Char2IntMap
    public boolean containsKey(char k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2IntMap, p014it.unimi.dsi.fastutil.chars.Char2IntMap
    public boolean containsValue(int v) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return false;
            }
        } while (this.value[i] != v);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2IntMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
    public int put(char k, int v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            int oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            char[] newKey = new char[this.size == 0 ? 2 : this.size * 2];
            int[] newValue = new int[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
    public int remove(char k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        int oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2IntArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntArrayMap$KeySet.class */
    public final class KeySet extends AbstractCharSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return Char2IntArrayMap.this.findKey(k) != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.CharSet
        public boolean remove(char k) {
            int oldPos = Char2IntArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Char2IntArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Char2IntArrayMap.this.key, oldPos + 1, Char2IntArrayMap.this.key, oldPos, tail);
            System.arraycopy(Char2IntArrayMap.this.value, oldPos + 1, Char2IntArrayMap.this.value, oldPos, tail);
            Char2IntArrayMap.access$010(Char2IntArrayMap.this);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharIterator iterator() {
            return new CharIterator() { // from class: it.unimi.dsi.fastutil.chars.Char2IntArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Char2IntArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                public char nextChar() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    char[] cArr = Char2IntArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return cArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Char2IntArrayMap.this.size - this.pos;
                    System.arraycopy(Char2IntArrayMap.this.key, this.pos, Char2IntArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Char2IntArrayMap.this.value, this.pos, Char2IntArrayMap.this.value, this.pos - 1, tail);
                    Char2IntArrayMap.access$010(Char2IntArrayMap.this);
                    this.pos--;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                public void forEachRemaining(CharConsumer action) {
                    int max = Char2IntArrayMap.this.size;
                    while (this.pos < max) {
                        char[] cArr = Char2IntArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(cArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.chars.Char2IntArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntArrayMap$KeySet$KeySetSpliterator.class */
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
                return Char2IntArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public final KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(CharConsumer action) {
                int max = Char2IntArrayMap.this.size;
                while (this.pos < max) {
                    char[] cArr = Char2IntArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(cArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return new KeySetSpliterator(0, Char2IntArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
        public void forEach(CharConsumer action) {
            int max = Char2IntArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Char2IntArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Char2IntArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Char2IntArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2IntMap, p014it.unimi.dsi.fastutil.chars.Char2IntMap, java.util.Map
    public Set<Character> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2IntArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractIntCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int v) {
            return Char2IntArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator iterator() {
            return new IntIterator() { // from class: it.unimi.dsi.fastutil.chars.Char2IntArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Char2IntArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                public int nextInt() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int[] iArr = Char2IntArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return iArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Char2IntArrayMap.this.size - this.pos;
                    System.arraycopy(Char2IntArrayMap.this.key, this.pos, Char2IntArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Char2IntArrayMap.this.value, this.pos, Char2IntArrayMap.this.value, this.pos - 1, tail);
                    Char2IntArrayMap.access$010(Char2IntArrayMap.this);
                    this.pos--;
                }

                @Override // java.util.PrimitiveIterator.OfInt
                public void forEachRemaining(IntConsumer action) {
                    int max = Char2IntArrayMap.this.size;
                    while (this.pos < max) {
                        int[] iArr = Char2IntArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(iArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.chars.Char2IntArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntArrayMap$ValuesCollection$ValuesSpliterator.class */
        public final class ValuesSpliterator extends IntSpliterators.EarlyBindingSizeIndexBasedSpliterator implements IntSpliterator {
            ValuesSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16720;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator
            protected final int get(int location) {
                return Char2IntArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator
            public final ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfInt
            public void forEachRemaining(IntConsumer action) {
                int max = Char2IntArrayMap.this.size;
                while (this.pos < max) {
                    int[] iArr = Char2IntArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(iArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return new ValuesSpliterator(0, Char2IntArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer action) {
            int max = Char2IntArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Char2IntArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Char2IntArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Char2IntArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2IntMap, p014it.unimi.dsi.fastutil.chars.Char2IntMap, java.util.Map
    public Collection<Integer> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Char2IntArrayMap clone() {
        try {
            Char2IntArrayMap c = (Char2IntArrayMap) clone();
            c.key = (char[]) this.key.clone();
            c.value = (int[]) this.value.clone();
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
            s.writeInt(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new char[this.size];
        this.value = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readChar();
            this.value[i] = s.readInt();
        }
    }
}