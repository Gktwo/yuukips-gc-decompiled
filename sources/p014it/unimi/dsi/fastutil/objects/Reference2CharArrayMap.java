package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharArrays;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharConsumer;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2CharMap;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.objects.Reference2CharMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharArrayMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharArrayMap.class */
public class Reference2CharArrayMap<K> extends AbstractReference2CharMap<K> implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private transient Object[] key;
    private transient char[] value;
    private int size;
    private transient Reference2CharMap.FastEntrySet<K> entries;
    private transient ReferenceSet<K> keys;
    private transient CharCollection values;

    static /* synthetic */ int access$010(Reference2CharArrayMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public Reference2CharArrayMap(Object[] key, char[] value) {
        this.key = key;
        this.value = value;
        this.size = key.length;
        if (key.length != value.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
        }
    }

    public Reference2CharArrayMap() {
        this.key = ObjectArrays.EMPTY_ARRAY;
        this.value = CharArrays.EMPTY_ARRAY;
    }

    public Reference2CharArrayMap(int capacity) {
        this.key = new Object[capacity];
        this.value = new char[capacity];
    }

    public Reference2CharArrayMap(Reference2CharMap<K> m) {
        this(m.size());
        int i = 0;
        ObjectIterator<Reference2CharMap.Entry<K>> it = m.reference2CharEntrySet().iterator();
        while (it.hasNext()) {
            Reference2CharMap.Entry<K> e = it.next();
            this.key[i] = e.getKey();
            this.value[i] = e.getCharValue();
            i++;
        }
        this.size = i;
    }

    public Reference2CharArrayMap(Map<? extends K, ? extends Character> m) {
        this(m.size());
        int i = 0;
        for (Map.Entry<? extends K, ? extends Character> e : m.entrySet()) {
            this.key[i] = e.getKey();
            this.value[i] = ((Character) e.getValue()).charValue();
            i++;
        }
        this.size = i;
    }

    public Reference2CharArrayMap(Object[] key, char[] value, int size) {
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharArrayMap$EntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharArrayMap$EntrySet.class */
    public final class EntrySet extends AbstractObjectSet<Reference2CharMap.Entry<K>> implements Reference2CharMap.FastEntrySet<K> {
        private EntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Reference2CharMap.Entry<K>> iterator() {
            return new ObjectIterator<Reference2CharMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Reference2CharArrayMap.EntrySet.1
                int curr = -1;
                int next = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Reference2CharArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Reference2CharMap.Entry<K> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Reference2CharArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    Object obj = objArr[i];
                    char[] cArr = Reference2CharArrayMap.this.value;
                    int i2 = this.next;
                    this.next = i2 + 1;
                    return new AbstractReference2CharMap.BasicEntry(obj, cArr[i2]);
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int access$010 = Reference2CharArrayMap.access$010(Reference2CharArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Reference2CharArrayMap.this.key, this.next + 1, Reference2CharArrayMap.this.key, this.next, tail);
                    System.arraycopy(Reference2CharArrayMap.this.value, this.next + 1, Reference2CharArrayMap.this.value, this.next, tail);
                    Reference2CharArrayMap.this.key[Reference2CharArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Reference2CharMap.Entry<K>> action) {
                    int max = Reference2CharArrayMap.this.size;
                    while (this.next < max) {
                        Object[] objArr = Reference2CharArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        Object obj = objArr[i];
                        char[] cArr = Reference2CharArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        action.accept(new AbstractReference2CharMap.BasicEntry(obj, cArr[i2]));
                    }
                }
            };
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMap.FastEntrySet
        public ObjectIterator<Reference2CharMap.Entry<K>> fastIterator() {
            return new ObjectIterator<Reference2CharMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Reference2CharArrayMap.EntrySet.2
                int next = 0;
                int curr = -1;
                final AbstractReference2CharMap.BasicEntry<K> entry = new AbstractReference2CharMap.BasicEntry<>();

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.next < Reference2CharArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public Reference2CharMap.Entry<K> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractReference2CharMap.BasicEntry<K> basicEntry = this.entry;
                    Object[] objArr = Reference2CharArrayMap.this.key;
                    int i = this.next;
                    this.curr = i;
                    basicEntry.key = (K) objArr[i];
                    AbstractReference2CharMap.BasicEntry<K> basicEntry2 = this.entry;
                    char[] cArr = Reference2CharArrayMap.this.value;
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
                    int access$010 = Reference2CharArrayMap.access$010(Reference2CharArrayMap.this);
                    int i = this.next;
                    this.next = i - 1;
                    int tail = access$010 - i;
                    System.arraycopy(Reference2CharArrayMap.this.key, this.next + 1, Reference2CharArrayMap.this.key, this.next, tail);
                    System.arraycopy(Reference2CharArrayMap.this.value, this.next + 1, Reference2CharArrayMap.this.value, this.next, tail);
                    Reference2CharArrayMap.this.key[Reference2CharArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super Reference2CharMap.Entry<K>> action) {
                    int max = Reference2CharArrayMap.this.size;
                    while (this.next < max) {
                        AbstractReference2CharMap.BasicEntry<K> basicEntry = this.entry;
                        Object[] objArr = Reference2CharArrayMap.this.key;
                        int i = this.next;
                        this.curr = i;
                        basicEntry.key = (K) objArr[i];
                        AbstractReference2CharMap.BasicEntry<K> basicEntry2 = this.entry;
                        char[] cArr = Reference2CharArrayMap.this.value;
                        int i2 = this.next;
                        this.next = i2 + 1;
                        basicEntry2.value = cArr[i2];
                        action.accept(this.entry);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharArrayMap$EntrySet$EntrySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharArrayMap$EntrySet$EntrySetSpliterator.class */
        public final class EntrySetSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Reference2CharMap.Entry<K>> implements ObjectSpliterator<Reference2CharMap.Entry<K>> {
            EntrySetSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 16465;
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Reference2CharMap.Entry<K> get(int location) {
                return new AbstractReference2CharMap.BasicEntry(Reference2CharArrayMap.this.key[location], Reference2CharArrayMap.this.value[location]);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Reference2CharArrayMap<K>.EntrySet.EntrySetSpliterator makeForSplit(int pos, int maxPos) {
                return new EntrySetSpliterator(pos, maxPos);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Reference2CharMap.Entry<K>> spliterator() {
            return new EntrySetSpliterator(0, Reference2CharArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Reference2CharMap.Entry<K>> action) {
            int max = Reference2CharArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(new AbstractReference2CharMap.BasicEntry(Reference2CharArrayMap.this.key[i], Reference2CharArrayMap.this.value[i]));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMap.FastEntrySet
        public void fastForEach(Consumer<? super Reference2CharMap.Entry<K>> action) {
            AbstractReference2CharMap.BasicEntry<K> entry = new AbstractReference2CharMap.BasicEntry<>();
            int max = Reference2CharArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                entry.key = (K) Reference2CharArrayMap.this.key[i];
                entry.value = Reference2CharArrayMap.this.value[i];
                action.accept(entry);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2CharArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            Object key = e.getKey();
            return Reference2CharArrayMap.this.containsKey(key) && Reference2CharArrayMap.this.getChar(key) == ((Character) e.getValue()).charValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            Object key = e.getKey();
            char v = ((Character) e.getValue()).charValue();
            int oldPos = Reference2CharArrayMap.this.findKey(key);
            if (oldPos == -1 || v != Reference2CharArrayMap.this.value[oldPos]) {
                return false;
            }
            int tail = (Reference2CharArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Reference2CharArrayMap.this.key, oldPos + 1, Reference2CharArrayMap.this.key, oldPos, tail);
            System.arraycopy(Reference2CharArrayMap.this.value, oldPos + 1, Reference2CharArrayMap.this.value, oldPos, tail);
            Reference2CharArrayMap.access$010(Reference2CharArrayMap.this);
            Reference2CharArrayMap.this.key[Reference2CharArrayMap.this.size] = null;
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMap
    public Reference2CharMap.FastEntrySet<K> reference2CharEntrySet() {
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharFunction
    public char getChar(Object k) {
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2CharMap, p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        return findKey(k) != -1;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2CharMap, p014it.unimi.dsi.fastutil.objects.Reference2CharMap
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2CharMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharFunction
    public char put(K k, char v) {
        int oldKey = findKey(k);
        if (oldKey != -1) {
            char oldValue = this.value[oldKey];
            this.value[oldKey] = v;
            return oldValue;
        }
        if (this.size == this.key.length) {
            Object[] newKey = new Object[this.size == 0 ? 2 : this.size * 2];
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharFunction
    public char removeChar(Object k) {
        int oldPos = findKey(k);
        if (oldPos == -1) {
            return this.defRetValue;
        }
        char oldValue = this.value[oldPos];
        int tail = (this.size - oldPos) - 1;
        System.arraycopy(this.key, oldPos + 1, this.key, oldPos, tail);
        System.arraycopy(this.value, oldPos + 1, this.value, oldPos, tail);
        this.size--;
        this.key[this.size] = null;
        return oldValue;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharArrayMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharArrayMap$KeySet.class */
    public final class KeySet extends AbstractReferenceSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Reference2CharArrayMap.this.findKey(k) != -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldPos = Reference2CharArrayMap.this.findKey(k);
            if (oldPos == -1) {
                return false;
            }
            int tail = (Reference2CharArrayMap.this.size - oldPos) - 1;
            System.arraycopy(Reference2CharArrayMap.this.key, oldPos + 1, Reference2CharArrayMap.this.key, oldPos, tail);
            System.arraycopy(Reference2CharArrayMap.this.value, oldPos + 1, Reference2CharArrayMap.this.value, oldPos, tail);
            Reference2CharArrayMap.access$010(Reference2CharArrayMap.this);
            Reference2CharArrayMap.this.key[Reference2CharArrayMap.this.size] = null;
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectIterator<K> iterator() {
            return new ObjectIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.Reference2CharArrayMap.KeySet.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Reference2CharArrayMap.this.size;
                }

                @Override // java.util.Iterator
                public K next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = Reference2CharArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    return (K) objArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Reference2CharArrayMap.this.size - this.pos;
                    System.arraycopy(Reference2CharArrayMap.this.key, this.pos, Reference2CharArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Reference2CharArrayMap.this.value, this.pos, Reference2CharArrayMap.this.value, this.pos - 1, tail);
                    Reference2CharArrayMap.access$010(Reference2CharArrayMap.this);
                    this.pos--;
                    Reference2CharArrayMap.this.key[Reference2CharArrayMap.this.size] = null;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super K> action) {
                    int max = Reference2CharArrayMap.this.size;
                    while (this.pos < max) {
                        Object[] objArr = Reference2CharArrayMap.this.key;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(objArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharArrayMap$KeySet$KeySetSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharArrayMap$KeySet$KeySetSpliterator.class */
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
                return (K) Reference2CharArrayMap.this.key[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final Reference2CharArrayMap<K>.KeySet.KeySetSpliterator makeForSplit(int pos, int maxPos) {
                return new KeySetSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super K> action) {
                int max = Reference2CharArrayMap.this.size;
                while (this.pos < max) {
                    Object[] objArr = Reference2CharArrayMap.this.key;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(objArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return new KeySetSpliterator(0, Reference2CharArrayMap.this.size);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> action) {
            int max = Reference2CharArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Reference2CharArrayMap.this.key[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2CharArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Reference2CharArrayMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2CharMap, p014it.unimi.dsi.fastutil.objects.Reference2CharMap, java.util.Map
    public ReferenceSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharArrayMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharArrayMap$ValuesCollection.class */
    public final class ValuesCollection extends AbstractCharCollection {
        private ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char v) {
            return Reference2CharArrayMap.this.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharIterator iterator() {
            return new CharIterator() { // from class: it.unimi.dsi.fastutil.objects.Reference2CharArrayMap.ValuesCollection.1
                int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < Reference2CharArrayMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                public char nextChar() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    char[] cArr = Reference2CharArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    return cArr[i];
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int tail = Reference2CharArrayMap.this.size - this.pos;
                    System.arraycopy(Reference2CharArrayMap.this.key, this.pos, Reference2CharArrayMap.this.key, this.pos - 1, tail);
                    System.arraycopy(Reference2CharArrayMap.this.value, this.pos, Reference2CharArrayMap.this.value, this.pos - 1, tail);
                    Reference2CharArrayMap.access$010(Reference2CharArrayMap.this);
                    this.pos--;
                    Reference2CharArrayMap.this.key[Reference2CharArrayMap.this.size] = null;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                public void forEachRemaining(CharConsumer action) {
                    int max = Reference2CharArrayMap.this.size;
                    while (this.pos < max) {
                        char[] cArr = Reference2CharArrayMap.this.value;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(cArr[i]);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharArrayMap$ValuesCollection$ValuesSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharArrayMap$ValuesCollection$ValuesSpliterator.class */
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
                return Reference2CharArrayMap.this.value[location];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public final Reference2CharArrayMap<K>.ValuesCollection.ValuesSpliterator makeForSplit(int pos, int maxPos) {
                return new ValuesSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(CharConsumer action) {
                int max = Reference2CharArrayMap.this.size;
                while (this.pos < max) {
                    char[] cArr = Reference2CharArrayMap.this.value;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(cArr[i]);
                }
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return new ValuesSpliterator(0, Reference2CharArrayMap.this.size);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
        public void forEach(CharConsumer action) {
            int max = Reference2CharArrayMap.this.size;
            for (int i = 0; i < max; i++) {
                action.accept(Reference2CharArrayMap.this.value[i]);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Reference2CharArrayMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Reference2CharArrayMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2CharMap, p014it.unimi.dsi.fastutil.objects.Reference2CharMap, java.util.Map
    public Collection<Character> values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    @Override // java.lang.Object
    public Reference2CharArrayMap<K> clone() {
        try {
            Reference2CharArrayMap<K> c = (Reference2CharArrayMap) clone();
            c.key = (Object[]) this.key.clone();
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
            s.writeObject(this.key[i]);
            s.writeChar(this.value[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.key = new Object[this.size];
        this.value = new char[this.size];
        for (int i = 0; i < this.size; i++) {
            this.key[i] = s.readObject();
            this.value[i] = s.readChar();
        }
    }
}
