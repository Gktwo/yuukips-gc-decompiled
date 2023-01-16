package p013io.netty.util.collection;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import p013io.netty.util.collection.ByteObjectMap;
import p013io.netty.util.internal.MathUtil;

/* renamed from: io.netty.util.collection.ByteObjectHashMap */
/* loaded from: grasscutter.jar:io/netty/util/collection/ByteObjectHashMap.class */
public class ByteObjectHashMap<V> implements ByteObjectMap<V> {
    public static final int DEFAULT_CAPACITY = 8;
    public static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final Object NULL_VALUE;
    private int maxSize;
    private final float loadFactor;
    private byte[] keys;
    private V[] values;
    private int size;
    private int mask;
    private final Set<Byte> keySet;
    private final Set<Map.Entry<Byte, V>> entrySet;
    private final Iterable<ByteObjectMap.PrimitiveEntry<V>> entries;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Byte b, Object obj) {
        return put(b, (Byte) obj);
    }

    static {
        $assertionsDisabled = !ByteObjectHashMap.class.desiredAssertionStatus();
        NULL_VALUE = new Object();
    }

    public ByteObjectHashMap() {
        this(8, 0.5f);
    }

    public ByteObjectHashMap(int initialCapacity) {
        this(initialCapacity, 0.5f);
    }

    public ByteObjectHashMap(int initialCapacity, float loadFactor) {
        this.keySet = new KeySet();
        this.entrySet = new EntrySet();
        this.entries = new Iterable<ByteObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.ByteObjectHashMap.1
            @Override // java.lang.Iterable
            public Iterator<ByteObjectMap.PrimitiveEntry<V>> iterator() {
                return new PrimitiveIterator();
            }
        };
        if (loadFactor <= 0.0f || loadFactor > 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and <= 1");
        }
        this.loadFactor = loadFactor;
        int capacity = MathUtil.safeFindNextPositivePowerOfTwo(initialCapacity);
        this.mask = capacity - 1;
        this.keys = new byte[capacity];
        this.values = (V[]) new Object[capacity];
        this.maxSize = calcMaxSize(capacity);
    }

    /* access modifiers changed from: private */
    public static <T> T toExternal(T value) {
        if (!$assertionsDisabled && value == null) {
            throw new AssertionError("null is not a legitimate internal value. Concurrent Modification?");
        } else if (value == NULL_VALUE) {
            return null;
        } else {
            return value;
        }
    }

    /* access modifiers changed from: private */
    public static <T> T toInternal(T value) {
        return value == null ? (T) NULL_VALUE : value;
    }

    @Override // p013io.netty.util.collection.ByteObjectMap
    public V get(byte key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        return (V) toExternal(this.values[index]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: V[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: V[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.util.collection.ByteObjectMap
    public V put(byte key, V value) {
        int startIndex = hashIndex(key);
        int index = startIndex;
        while (this.values[index] != null) {
            if (this.keys[index] == key) {
                V previousValue = this.values[index];
                this.values[index] = toInternal(value);
                return (V) toExternal(previousValue);
            }
            int probeNext = probeNext(index);
            index = probeNext;
            if (probeNext == startIndex) {
                throw new IllegalStateException("Unable to insert");
            }
        }
        this.keys[index] = key;
        this.values[index] = toInternal(value);
        growSize();
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.netty.util.collection.ByteObjectHashMap<V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends Byte, ? extends V> sourceMap) {
        if (sourceMap instanceof ByteObjectHashMap) {
            ByteObjectHashMap<V> source = (ByteObjectHashMap) sourceMap;
            for (int i = 0; i < source.values.length; i++) {
                V sourceValue = source.values[i];
                if (sourceValue != null) {
                    put(source.keys[i], (byte) sourceValue);
                }
            }
            return;
        }
        for (Map.Entry<? extends Byte, ? extends V> entry : sourceMap.entrySet()) {
            put((Byte) entry.getKey(), (Byte) entry.getValue());
        }
    }

    @Override // p013io.netty.util.collection.ByteObjectMap
    public V remove(byte key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        V prev = this.values[index];
        removeAt(index);
        return (V) toExternal(prev);
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.Map
    public void clear() {
        Arrays.fill(this.keys, (byte) 0);
        Arrays.fill(this.values, (Object) null);
        this.size = 0;
    }

    @Override // p013io.netty.util.collection.ByteObjectMap
    public boolean containsKey(byte key) {
        return indexOf(key) >= 0;
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        Object internal = toInternal(value);
        V[] vArr = this.values;
        for (V v2 : vArr) {
            if (v2 != null && v2.equals(internal)) {
                return true;
            }
        }
        return false;
    }

    @Override // p013io.netty.util.collection.ByteObjectMap
    public Iterable<ByteObjectMap.PrimitiveEntry<V>> entries() {
        return this.entries;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return new AbstractCollection<V>() { // from class: io.netty.util.collection.ByteObjectHashMap.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<V> iterator() {
                return new Iterator<V>() { // from class: io.netty.util.collection.ByteObjectHashMap.2.1
                    final ByteObjectHashMap<V>.PrimitiveIterator iter;

                    {
                        this.iter = new PrimitiveIterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.iter.hasNext();
                    }

                    @Override // java.util.Iterator
                    public V next() {
                        return this.iter.next().value();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.iter.remove();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return ByteObjectHashMap.this.size;
            }
        };
    }

    @Override // java.util.Map, java.lang.Object
    public int hashCode() {
        int hash = this.size;
        for (byte key : this.keys) {
            hash ^= hashCode(key);
        }
        return hash;
    }

    @Override // java.util.Map, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ByteObjectMap)) {
            return false;
        }
        ByteObjectMap other = (ByteObjectMap) obj;
        if (this.size != other.size()) {
            return false;
        }
        for (int i = 0; i < this.values.length; i++) {
            V value = this.values[i];
            if (value != null) {
                Object otherValue = other.get(this.keys[i]);
                if (value == NULL_VALUE) {
                    if (otherValue != null) {
                        return false;
                    }
                } else if (!value.equals(otherValue)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return containsKey(objectToKey(key));
    }

    @Override // java.util.Map
    public V get(Object key) {
        return get(objectToKey(key));
    }

    public V put(Byte key, V value) {
        return put(objectToKey(key), (byte) value);
    }

    @Override // java.util.Map
    public V remove(Object key) {
        return remove(objectToKey(key));
    }

    @Override // java.util.Map
    public Set<Byte> keySet() {
        return this.keySet;
    }

    @Override // java.util.Map
    public Set<Map.Entry<Byte, V>> entrySet() {
        return this.entrySet;
    }

    private byte objectToKey(Object key) {
        return ((Byte) key).byteValue();
    }

    private int indexOf(byte key) {
        int startIndex = hashIndex(key);
        int index = startIndex;
        while (this.values[index] != null) {
            if (key == this.keys[index]) {
                return index;
            }
            int probeNext = probeNext(index);
            index = probeNext;
            if (probeNext == startIndex) {
                return -1;
            }
        }
        return -1;
    }

    private int hashIndex(byte key) {
        return hashCode(key) & this.mask;
    }

    private static int hashCode(byte key) {
        return key;
    }

    private int probeNext(int index) {
        return (index + 1) & this.mask;
    }

    private void growSize() {
        this.size++;
        if (this.size <= this.maxSize) {
            return;
        }
        if (this.keys.length == Integer.MAX_VALUE) {
            throw new IllegalStateException("Max capacity reached at size=" + this.size);
        }
        rehash(this.keys.length << 1);
    }

    /* access modifiers changed from: private */
    public boolean removeAt(int index) {
        this.size--;
        this.keys[index] = 0;
        this.values[index] = null;
        int nextFree = index;
        int i = probeNext(index);
        V value = this.values[i];
        while (value != null) {
            byte key = this.keys[i];
            int bucket = hashIndex(key);
            if ((i < bucket && (bucket <= nextFree || nextFree <= i)) || (bucket <= nextFree && nextFree <= i)) {
                this.keys[nextFree] = key;
                this.values[nextFree] = value;
                this.keys[i] = 0;
                this.values[i] = null;
                nextFree = i;
            }
            V[] vArr = this.values;
            int probeNext = probeNext(i);
            i = probeNext;
            value = vArr[probeNext];
        }
        return nextFree != index;
    }

    private int calcMaxSize(int capacity) {
        return Math.min(capacity - 1, (int) (((float) capacity) * this.loadFactor));
    }

    private void rehash(int newCapacity) {
        byte[] oldKeys = this.keys;
        V[] oldVals = this.values;
        this.keys = new byte[newCapacity];
        this.values = (V[]) new Object[newCapacity];
        this.maxSize = calcMaxSize(newCapacity);
        this.mask = newCapacity - 1;
        for (int i = 0; i < oldVals.length; i++) {
            V oldVal = oldVals[i];
            if (oldVal != null) {
                byte oldKey = oldKeys[i];
                int index = hashIndex(oldKey);
                while (this.values[index] != null) {
                    index = probeNext(index);
                }
                this.keys[index] = oldKey;
                this.values[index] = oldVal;
            }
        }
    }

    @Override // java.lang.Object
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(4 * this.size);
        sb.append('{');
        boolean first = true;
        for (int i = 0; i < this.values.length; i++) {
            V value = this.values[i];
            if (value != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(keyToString(this.keys[i])).append('=').append(value == this ? "(this Map)" : toExternal(value));
                first = false;
            }
        }
        return sb.append('}').toString();
    }

    protected String keyToString(byte key) {
        return Byte.toString(key);
    }

    /* renamed from: io.netty.util.collection.ByteObjectHashMap$EntrySet */
    /* loaded from: grasscutter.jar:io/netty/util/collection/ByteObjectHashMap$EntrySet.class */
    private final class EntrySet extends AbstractSet<Map.Entry<Byte, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<Byte, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ByteObjectHashMap.this.size();
        }
    }

    /* renamed from: io.netty.util.collection.ByteObjectHashMap$KeySet */
    /* loaded from: grasscutter.jar:io/netty/util/collection/ByteObjectHashMap$KeySet.class */
    private final class KeySet extends AbstractSet<Byte> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ByteObjectHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            return ByteObjectHashMap.this.containsKey(o);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            return ByteObjectHashMap.this.remove(o) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> retainedKeys) {
            boolean changed = false;
            Iterator<ByteObjectMap.PrimitiveEntry<V>> iter = ByteObjectHashMap.this.entries().iterator();
            while (iter.hasNext()) {
                if (!retainedKeys.contains(Byte.valueOf(iter.next().key()))) {
                    changed = true;
                    iter.remove();
                }
            }
            return changed;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ByteObjectHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Byte> iterator() {
            return new Iterator<Byte>() { // from class: io.netty.util.collection.ByteObjectHashMap.KeySet.1
                private final Iterator<Map.Entry<Byte, V>> iter;

                {
                    this.iter = ByteObjectHashMap.this.entrySet.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.iter.hasNext();
                }

                @Override // java.util.Iterator
                public Byte next() {
                    return this.iter.next().getKey();
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.iter.remove();
                }
            };
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.collection.ByteObjectHashMap$PrimitiveIterator */
    /* loaded from: grasscutter.jar:io/netty/util/collection/ByteObjectHashMap$PrimitiveIterator.class */
    public final class PrimitiveIterator implements Iterator<ByteObjectMap.PrimitiveEntry<V>>, ByteObjectMap.PrimitiveEntry<V> {
        private int prevIndex;
        private int nextIndex;
        private int entryIndex;

        private PrimitiveIterator() {
            this.prevIndex = -1;
            this.nextIndex = -1;
            this.entryIndex = -1;
        }

        private void scanNext() {
            do {
                int i = this.nextIndex + 1;
                this.nextIndex = i;
                if (i == ByteObjectHashMap.this.values.length) {
                    return;
                }
            } while (ByteObjectHashMap.this.values[this.nextIndex] == null);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextIndex == -1) {
                scanNext();
            }
            return this.nextIndex != ByteObjectHashMap.this.values.length;
        }

        @Override // java.util.Iterator
        public ByteObjectMap.PrimitiveEntry<V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.prevIndex = this.nextIndex;
            scanNext();
            this.entryIndex = this.prevIndex;
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.prevIndex == -1) {
                throw new IllegalStateException("next must be called before each remove.");
            }
            if (ByteObjectHashMap.this.removeAt(this.prevIndex)) {
                this.nextIndex = this.prevIndex;
            }
            this.prevIndex = -1;
        }

        @Override // p013io.netty.util.collection.ByteObjectMap.PrimitiveEntry
        public byte key() {
            return ByteObjectHashMap.this.keys[this.entryIndex];
        }

        @Override // p013io.netty.util.collection.ByteObjectMap.PrimitiveEntry
        public V value() {
            return (V) ByteObjectHashMap.toExternal(ByteObjectHashMap.this.values[this.entryIndex]);
        }

        @Override // p013io.netty.util.collection.ByteObjectMap.PrimitiveEntry
        public void setValue(V value) {
            ByteObjectHashMap.this.values[this.entryIndex] = ByteObjectHashMap.toInternal(value);
        }
    }

    /* renamed from: io.netty.util.collection.ByteObjectHashMap$MapIterator */
    /* loaded from: grasscutter.jar:io/netty/util/collection/ByteObjectHashMap$MapIterator.class */
    private final class MapIterator implements Iterator<Map.Entry<Byte, V>> {
        private final ByteObjectHashMap<V>.PrimitiveIterator iter;

        private MapIterator() {
            this.iter = new PrimitiveIterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<Byte, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.iter.next();
            return new MapEntry(((PrimitiveIterator) this.iter).entryIndex);
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iter.remove();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.util.collection.ByteObjectHashMap$MapEntry */
    /* loaded from: grasscutter.jar:io/netty/util/collection/ByteObjectHashMap$MapEntry.class */
    public final class MapEntry implements Map.Entry<Byte, V> {
        private final int entryIndex;

        MapEntry(int entryIndex) {
            this.entryIndex = entryIndex;
        }

        @Override // java.util.Map.Entry
        public Byte getKey() {
            verifyExists();
            return Byte.valueOf(ByteObjectHashMap.this.keys[this.entryIndex]);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            verifyExists();
            return (V) ByteObjectHashMap.toExternal(ByteObjectHashMap.this.values[this.entryIndex]);
        }

        @Override // java.util.Map.Entry
        public V setValue(V value) {
            verifyExists();
            V prevValue = (V) ByteObjectHashMap.toExternal(ByteObjectHashMap.this.values[this.entryIndex]);
            ByteObjectHashMap.this.values[this.entryIndex] = ByteObjectHashMap.toInternal(value);
            return prevValue;
        }

        private void verifyExists() {
            if (ByteObjectHashMap.this.values[this.entryIndex] == null) {
                throw new IllegalStateException("The map entry has been removed");
            }
        }
    }
}
