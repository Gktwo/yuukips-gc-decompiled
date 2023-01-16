package p013io.netty.util.collection;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import p013io.netty.util.collection.ShortObjectMap;
import p013io.netty.util.internal.MathUtil;

/* renamed from: io.netty.util.collection.ShortObjectHashMap */
/* loaded from: grasscutter.jar:io/netty/util/collection/ShortObjectHashMap.class */
public class ShortObjectHashMap<V> implements ShortObjectMap<V> {
    public static final int DEFAULT_CAPACITY = 8;
    public static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final Object NULL_VALUE;
    private int maxSize;
    private final float loadFactor;
    private short[] keys;
    private V[] values;
    private int size;
    private int mask;
    private final Set<Short> keySet;
    private final Set<Map.Entry<Short, V>> entrySet;
    private final Iterable<ShortObjectMap.PrimitiveEntry<V>> entries;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Short sh, Object obj) {
        return put(sh, (Short) obj);
    }

    static {
        $assertionsDisabled = !ShortObjectHashMap.class.desiredAssertionStatus();
        NULL_VALUE = new Object();
    }

    public ShortObjectHashMap() {
        this(8, 0.5f);
    }

    public ShortObjectHashMap(int initialCapacity) {
        this(initialCapacity, 0.5f);
    }

    public ShortObjectHashMap(int initialCapacity, float loadFactor) {
        this.keySet = new KeySet();
        this.entrySet = new EntrySet();
        this.entries = new Iterable<ShortObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.ShortObjectHashMap.1
            @Override // java.lang.Iterable
            public Iterator<ShortObjectMap.PrimitiveEntry<V>> iterator() {
                return new PrimitiveIterator();
            }
        };
        if (loadFactor <= 0.0f || loadFactor > 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and <= 1");
        }
        this.loadFactor = loadFactor;
        int capacity = MathUtil.safeFindNextPositivePowerOfTwo(initialCapacity);
        this.mask = capacity - 1;
        this.keys = new short[capacity];
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

    @Override // p013io.netty.util.collection.ShortObjectMap
    public V get(short key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        return (V) toExternal(this.values[index]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: V[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: V[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.util.collection.ShortObjectMap
    public V put(short key, V value) {
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

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.netty.util.collection.ShortObjectHashMap<V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends Short, ? extends V> sourceMap) {
        if (sourceMap instanceof ShortObjectHashMap) {
            ShortObjectHashMap<V> source = (ShortObjectHashMap) sourceMap;
            for (int i = 0; i < source.values.length; i++) {
                V sourceValue = source.values[i];
                if (sourceValue != null) {
                    put(source.keys[i], (short) sourceValue);
                }
            }
            return;
        }
        for (Map.Entry<? extends Short, ? extends V> entry : sourceMap.entrySet()) {
            put((Short) entry.getKey(), (Short) entry.getValue());
        }
    }

    @Override // p013io.netty.util.collection.ShortObjectMap
    public V remove(short key) {
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
        Arrays.fill(this.keys, (short) 0);
        Arrays.fill(this.values, (Object) null);
        this.size = 0;
    }

    @Override // p013io.netty.util.collection.ShortObjectMap
    public boolean containsKey(short key) {
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

    @Override // p013io.netty.util.collection.ShortObjectMap
    public Iterable<ShortObjectMap.PrimitiveEntry<V>> entries() {
        return this.entries;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return new AbstractCollection<V>() { // from class: io.netty.util.collection.ShortObjectHashMap.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<V> iterator() {
                return new Iterator<V>() { // from class: io.netty.util.collection.ShortObjectHashMap.2.1
                    final ShortObjectHashMap<V>.PrimitiveIterator iter;

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
                return ShortObjectHashMap.this.size;
            }
        };
    }

    @Override // java.util.Map, java.lang.Object
    public int hashCode() {
        int hash = this.size;
        for (short key : this.keys) {
            hash ^= hashCode(key);
        }
        return hash;
    }

    @Override // java.util.Map, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShortObjectMap)) {
            return false;
        }
        ShortObjectMap other = (ShortObjectMap) obj;
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

    public V put(Short key, V value) {
        return put(objectToKey(key), (short) value);
    }

    @Override // java.util.Map
    public V remove(Object key) {
        return remove(objectToKey(key));
    }

    @Override // java.util.Map
    public Set<Short> keySet() {
        return this.keySet;
    }

    @Override // java.util.Map
    public Set<Map.Entry<Short, V>> entrySet() {
        return this.entrySet;
    }

    private short objectToKey(Object key) {
        return ((Short) key).shortValue();
    }

    private int indexOf(short key) {
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

    private int hashIndex(short key) {
        return hashCode(key) & this.mask;
    }

    private static int hashCode(short key) {
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
            short key = this.keys[i];
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
        short[] oldKeys = this.keys;
        V[] oldVals = this.values;
        this.keys = new short[newCapacity];
        this.values = (V[]) new Object[newCapacity];
        this.maxSize = calcMaxSize(newCapacity);
        this.mask = newCapacity - 1;
        for (int i = 0; i < oldVals.length; i++) {
            V oldVal = oldVals[i];
            if (oldVal != null) {
                short oldKey = oldKeys[i];
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

    protected String keyToString(short key) {
        return Short.toString(key);
    }

    /* renamed from: io.netty.util.collection.ShortObjectHashMap$EntrySet */
    /* loaded from: grasscutter.jar:io/netty/util/collection/ShortObjectHashMap$EntrySet.class */
    private final class EntrySet extends AbstractSet<Map.Entry<Short, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<Short, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ShortObjectHashMap.this.size();
        }
    }

    /* renamed from: io.netty.util.collection.ShortObjectHashMap$KeySet */
    /* loaded from: grasscutter.jar:io/netty/util/collection/ShortObjectHashMap$KeySet.class */
    private final class KeySet extends AbstractSet<Short> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ShortObjectHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            return ShortObjectHashMap.this.containsKey(o);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            return ShortObjectHashMap.this.remove(o) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> retainedKeys) {
            boolean changed = false;
            Iterator<ShortObjectMap.PrimitiveEntry<V>> iter = ShortObjectHashMap.this.entries().iterator();
            while (iter.hasNext()) {
                if (!retainedKeys.contains(Short.valueOf(iter.next().key()))) {
                    changed = true;
                    iter.remove();
                }
            }
            return changed;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ShortObjectHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Short> iterator() {
            return new Iterator<Short>() { // from class: io.netty.util.collection.ShortObjectHashMap.KeySet.1
                private final Iterator<Map.Entry<Short, V>> iter;

                {
                    this.iter = ShortObjectHashMap.this.entrySet.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.iter.hasNext();
                }

                @Override // java.util.Iterator
                public Short next() {
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
    /* renamed from: io.netty.util.collection.ShortObjectHashMap$PrimitiveIterator */
    /* loaded from: grasscutter.jar:io/netty/util/collection/ShortObjectHashMap$PrimitiveIterator.class */
    public final class PrimitiveIterator implements Iterator<ShortObjectMap.PrimitiveEntry<V>>, ShortObjectMap.PrimitiveEntry<V> {
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
                if (i == ShortObjectHashMap.this.values.length) {
                    return;
                }
            } while (ShortObjectHashMap.this.values[this.nextIndex] == null);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextIndex == -1) {
                scanNext();
            }
            return this.nextIndex != ShortObjectHashMap.this.values.length;
        }

        @Override // java.util.Iterator
        public ShortObjectMap.PrimitiveEntry<V> next() {
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
            if (ShortObjectHashMap.this.removeAt(this.prevIndex)) {
                this.nextIndex = this.prevIndex;
            }
            this.prevIndex = -1;
        }

        @Override // p013io.netty.util.collection.ShortObjectMap.PrimitiveEntry
        public short key() {
            return ShortObjectHashMap.this.keys[this.entryIndex];
        }

        @Override // p013io.netty.util.collection.ShortObjectMap.PrimitiveEntry
        public V value() {
            return (V) ShortObjectHashMap.toExternal(ShortObjectHashMap.this.values[this.entryIndex]);
        }

        @Override // p013io.netty.util.collection.ShortObjectMap.PrimitiveEntry
        public void setValue(V value) {
            ShortObjectHashMap.this.values[this.entryIndex] = ShortObjectHashMap.toInternal(value);
        }
    }

    /* renamed from: io.netty.util.collection.ShortObjectHashMap$MapIterator */
    /* loaded from: grasscutter.jar:io/netty/util/collection/ShortObjectHashMap$MapIterator.class */
    private final class MapIterator implements Iterator<Map.Entry<Short, V>> {
        private final ShortObjectHashMap<V>.PrimitiveIterator iter;

        private MapIterator() {
            this.iter = new PrimitiveIterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<Short, V> next() {
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
    /* renamed from: io.netty.util.collection.ShortObjectHashMap$MapEntry */
    /* loaded from: grasscutter.jar:io/netty/util/collection/ShortObjectHashMap$MapEntry.class */
    public final class MapEntry implements Map.Entry<Short, V> {
        private final int entryIndex;

        MapEntry(int entryIndex) {
            this.entryIndex = entryIndex;
        }

        @Override // java.util.Map.Entry
        public Short getKey() {
            verifyExists();
            return Short.valueOf(ShortObjectHashMap.this.keys[this.entryIndex]);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            verifyExists();
            return (V) ShortObjectHashMap.toExternal(ShortObjectHashMap.this.values[this.entryIndex]);
        }

        @Override // java.util.Map.Entry
        public V setValue(V value) {
            verifyExists();
            V prevValue = (V) ShortObjectHashMap.toExternal(ShortObjectHashMap.this.values[this.entryIndex]);
            ShortObjectHashMap.this.values[this.entryIndex] = ShortObjectHashMap.toInternal(value);
            return prevValue;
        }

        private void verifyExists() {
            if (ShortObjectHashMap.this.values[this.entryIndex] == null) {
                throw new IllegalStateException("The map entry has been removed");
            }
        }
    }
}
