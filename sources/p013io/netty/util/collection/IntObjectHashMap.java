package p013io.netty.util.collection;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import p013io.netty.util.collection.IntObjectMap;
import p013io.netty.util.internal.MathUtil;

/* renamed from: io.netty.util.collection.IntObjectHashMap */
/* loaded from: grasscutter.jar:io/netty/util/collection/IntObjectHashMap.class */
public class IntObjectHashMap<V> implements IntObjectMap<V> {
    public static final int DEFAULT_CAPACITY = 8;
    public static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final Object NULL_VALUE;
    private int maxSize;
    private final float loadFactor;
    private int[] keys;
    private V[] values;
    private int size;
    private int mask;
    private final Set<Integer> keySet;
    private final Set<Map.Entry<Integer, V>> entrySet;
    private final Iterable<IntObjectMap.PrimitiveEntry<V>> entries;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Integer num, Object obj) {
        return put(num, (Integer) obj);
    }

    static {
        $assertionsDisabled = !IntObjectHashMap.class.desiredAssertionStatus();
        NULL_VALUE = new Object();
    }

    public IntObjectHashMap() {
        this(8, 0.5f);
    }

    public IntObjectHashMap(int initialCapacity) {
        this(initialCapacity, 0.5f);
    }

    public IntObjectHashMap(int initialCapacity, float loadFactor) {
        this.keySet = new KeySet();
        this.entrySet = new EntrySet();
        this.entries = new Iterable<IntObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.IntObjectHashMap.1
            @Override // java.lang.Iterable
            public Iterator<IntObjectMap.PrimitiveEntry<V>> iterator() {
                return new PrimitiveIterator();
            }
        };
        if (loadFactor <= 0.0f || loadFactor > 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and <= 1");
        }
        this.loadFactor = loadFactor;
        int capacity = MathUtil.safeFindNextPositivePowerOfTwo(initialCapacity);
        this.mask = capacity - 1;
        this.keys = new int[capacity];
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

    @Override // p013io.netty.util.collection.IntObjectMap
    public V get(int key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        return (V) toExternal(this.values[index]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: V[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: V[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.util.collection.IntObjectMap
    public V put(int key, V value) {
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

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.netty.util.collection.IntObjectHashMap<V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends Integer, ? extends V> sourceMap) {
        if (sourceMap instanceof IntObjectHashMap) {
            IntObjectHashMap<V> source = (IntObjectHashMap) sourceMap;
            for (int i = 0; i < source.values.length; i++) {
                V sourceValue = source.values[i];
                if (sourceValue != null) {
                    put(source.keys[i], (int) sourceValue);
                }
            }
            return;
        }
        for (Map.Entry<? extends Integer, ? extends V> entry : sourceMap.entrySet()) {
            put((Integer) entry.getKey(), (Integer) entry.getValue());
        }
    }

    @Override // p013io.netty.util.collection.IntObjectMap
    public V remove(int key) {
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
        Arrays.fill(this.keys, 0);
        Arrays.fill(this.values, (Object) null);
        this.size = 0;
    }

    @Override // p013io.netty.util.collection.IntObjectMap
    public boolean containsKey(int key) {
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

    @Override // p013io.netty.util.collection.IntObjectMap
    public Iterable<IntObjectMap.PrimitiveEntry<V>> entries() {
        return this.entries;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return new AbstractCollection<V>() { // from class: io.netty.util.collection.IntObjectHashMap.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<V> iterator() {
                return new Iterator<V>() { // from class: io.netty.util.collection.IntObjectHashMap.2.1
                    final IntObjectHashMap<V>.PrimitiveIterator iter;

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
                return IntObjectHashMap.this.size;
            }
        };
    }

    @Override // java.util.Map, java.lang.Object
    public int hashCode() {
        int hash = this.size;
        for (int key : this.keys) {
            hash ^= hashCode(key);
        }
        return hash;
    }

    @Override // java.util.Map, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntObjectMap)) {
            return false;
        }
        IntObjectMap other = (IntObjectMap) obj;
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

    public V put(Integer key, V value) {
        return put(objectToKey(key), (int) value);
    }

    @Override // java.util.Map
    public V remove(Object key) {
        return remove(objectToKey(key));
    }

    @Override // java.util.Map
    public Set<Integer> keySet() {
        return this.keySet;
    }

    @Override // java.util.Map
    public Set<Map.Entry<Integer, V>> entrySet() {
        return this.entrySet;
    }

    private int objectToKey(Object key) {
        return ((Integer) key).intValue();
    }

    private int indexOf(int key) {
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

    private int hashIndex(int key) {
        return hashCode(key) & this.mask;
    }

    private static int hashCode(int key) {
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
            int key = this.keys[i];
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
        int[] oldKeys = this.keys;
        V[] oldVals = this.values;
        this.keys = new int[newCapacity];
        this.values = (V[]) new Object[newCapacity];
        this.maxSize = calcMaxSize(newCapacity);
        this.mask = newCapacity - 1;
        for (int i = 0; i < oldVals.length; i++) {
            V oldVal = oldVals[i];
            if (oldVal != null) {
                int oldKey = oldKeys[i];
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

    protected String keyToString(int key) {
        return Integer.toString(key);
    }

    /* renamed from: io.netty.util.collection.IntObjectHashMap$EntrySet */
    /* loaded from: grasscutter.jar:io/netty/util/collection/IntObjectHashMap$EntrySet.class */
    private final class EntrySet extends AbstractSet<Map.Entry<Integer, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<Integer, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IntObjectHashMap.this.size();
        }
    }

    /* renamed from: io.netty.util.collection.IntObjectHashMap$KeySet */
    /* loaded from: grasscutter.jar:io/netty/util/collection/IntObjectHashMap$KeySet.class */
    private final class KeySet extends AbstractSet<Integer> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IntObjectHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            return IntObjectHashMap.this.containsKey(o);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            return IntObjectHashMap.this.remove(o) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> retainedKeys) {
            boolean changed = false;
            Iterator<IntObjectMap.PrimitiveEntry<V>> iter = IntObjectHashMap.this.entries().iterator();
            while (iter.hasNext()) {
                if (!retainedKeys.contains(Integer.valueOf(iter.next().key()))) {
                    changed = true;
                    iter.remove();
                }
            }
            return changed;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            IntObjectHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() { // from class: io.netty.util.collection.IntObjectHashMap.KeySet.1
                private final Iterator<Map.Entry<Integer, V>> iter;

                {
                    this.iter = IntObjectHashMap.this.entrySet.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.iter.hasNext();
                }

                @Override // java.util.Iterator
                public Integer next() {
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
    /* renamed from: io.netty.util.collection.IntObjectHashMap$PrimitiveIterator */
    /* loaded from: grasscutter.jar:io/netty/util/collection/IntObjectHashMap$PrimitiveIterator.class */
    public final class PrimitiveIterator implements Iterator<IntObjectMap.PrimitiveEntry<V>>, IntObjectMap.PrimitiveEntry<V> {
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
                if (i == IntObjectHashMap.this.values.length) {
                    return;
                }
            } while (IntObjectHashMap.this.values[this.nextIndex] == null);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextIndex == -1) {
                scanNext();
            }
            return this.nextIndex != IntObjectHashMap.this.values.length;
        }

        @Override // java.util.Iterator
        public IntObjectMap.PrimitiveEntry<V> next() {
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
            if (IntObjectHashMap.this.removeAt(this.prevIndex)) {
                this.nextIndex = this.prevIndex;
            }
            this.prevIndex = -1;
        }

        @Override // p013io.netty.util.collection.IntObjectMap.PrimitiveEntry
        public int key() {
            return IntObjectHashMap.this.keys[this.entryIndex];
        }

        @Override // p013io.netty.util.collection.IntObjectMap.PrimitiveEntry
        public V value() {
            return (V) IntObjectHashMap.toExternal(IntObjectHashMap.this.values[this.entryIndex]);
        }

        @Override // p013io.netty.util.collection.IntObjectMap.PrimitiveEntry
        public void setValue(V value) {
            IntObjectHashMap.this.values[this.entryIndex] = IntObjectHashMap.toInternal(value);
        }
    }

    /* renamed from: io.netty.util.collection.IntObjectHashMap$MapIterator */
    /* loaded from: grasscutter.jar:io/netty/util/collection/IntObjectHashMap$MapIterator.class */
    private final class MapIterator implements Iterator<Map.Entry<Integer, V>> {
        private final IntObjectHashMap<V>.PrimitiveIterator iter;

        private MapIterator() {
            this.iter = new PrimitiveIterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<Integer, V> next() {
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
    /* renamed from: io.netty.util.collection.IntObjectHashMap$MapEntry */
    /* loaded from: grasscutter.jar:io/netty/util/collection/IntObjectHashMap$MapEntry.class */
    public final class MapEntry implements Map.Entry<Integer, V> {
        private final int entryIndex;

        MapEntry(int entryIndex) {
            this.entryIndex = entryIndex;
        }

        @Override // java.util.Map.Entry
        public Integer getKey() {
            verifyExists();
            return Integer.valueOf(IntObjectHashMap.this.keys[this.entryIndex]);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            verifyExists();
            return (V) IntObjectHashMap.toExternal(IntObjectHashMap.this.values[this.entryIndex]);
        }

        @Override // java.util.Map.Entry
        public V setValue(V value) {
            verifyExists();
            V prevValue = (V) IntObjectHashMap.toExternal(IntObjectHashMap.this.values[this.entryIndex]);
            IntObjectHashMap.this.values[this.entryIndex] = IntObjectHashMap.toInternal(value);
            return prevValue;
        }

        private void verifyExists() {
            if (IntObjectHashMap.this.values[this.entryIndex] == null) {
                throw new IllegalStateException("The map entry has been removed");
            }
        }
    }
}
