package p013io.netty.util.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.jline.reader.LineReader;
import p013io.netty.util.collection.IntObjectMap;

/* renamed from: io.netty.util.collection.IntCollections */
/* loaded from: grasscutter.jar:io/netty/util/collection/IntCollections.class */
public final class IntCollections {
    private static final IntObjectMap<Object> EMPTY_MAP = new EmptyMap();

    private IntCollections() {
    }

    public static <V> IntObjectMap<V> emptyMap() {
        return (IntObjectMap<V>) EMPTY_MAP;
    }

    public static <V> IntObjectMap<V> unmodifiableMap(IntObjectMap<V> map) {
        return new UnmodifiableMap(map);
    }

    /* renamed from: io.netty.util.collection.IntCollections$EmptyMap */
    /* loaded from: grasscutter.jar:io/netty/util/collection/IntCollections$EmptyMap.class */
    private static final class EmptyMap implements IntObjectMap<Object> {
        private EmptyMap() {
        }

        @Override // p013io.netty.util.collection.IntObjectMap
        public Object get(int key) {
            return null;
        }

        @Override // p013io.netty.util.collection.IntObjectMap
        public Object put(int key, Object value) {
            throw new UnsupportedOperationException("put");
        }

        @Override // p013io.netty.util.collection.IntObjectMap
        public Object remove(int key) {
            return null;
        }

        @Override // java.util.Map
        public int size() {
            return 0;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.Map
        public boolean containsKey(Object key) {
            return false;
        }

        @Override // java.util.Map
        public void clear() {
        }

        @Override // java.util.Map
        public Set<Integer> keySet() {
            return Collections.emptySet();
        }

        @Override // p013io.netty.util.collection.IntObjectMap
        public boolean containsKey(int key) {
            return false;
        }

        @Override // java.util.Map
        public boolean containsValue(Object value) {
            return false;
        }

        @Override // p013io.netty.util.collection.IntObjectMap
        public Iterable<IntObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.emptySet();
        }

        @Override // java.util.Map
        public Object get(Object key) {
            return null;
        }

        public Object put(Integer key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Object remove(Object key) {
            return null;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Integer, ?> m) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Collection<Object> values() {
            return Collections.emptyList();
        }

        @Override // java.util.Map
        public Set<Map.Entry<Integer, Object>> entrySet() {
            return Collections.emptySet();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.collection.IntCollections$UnmodifiableMap */
    /* loaded from: grasscutter.jar:io/netty/util/collection/IntCollections$UnmodifiableMap.class */
    public static final class UnmodifiableMap<V> implements IntObjectMap<V> {
        private final IntObjectMap<V> map;
        private Set<Integer> keySet;
        private Set<Map.Entry<Integer, V>> entrySet;
        private Collection<V> values;
        private Iterable<IntObjectMap.PrimitiveEntry<V>> entries;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Object put(Integer num, Object obj) {
            return put(num, (Integer) obj);
        }

        UnmodifiableMap(IntObjectMap<V> map) {
            this.map = map;
        }

        @Override // p013io.netty.util.collection.IntObjectMap
        public V get(int key) {
            return this.map.get(key);
        }

        @Override // p013io.netty.util.collection.IntObjectMap
        public V put(int key, V value) {
            throw new UnsupportedOperationException("put");
        }

        @Override // p013io.netty.util.collection.IntObjectMap
        public V remove(int key) {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Map
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException(LineReader.CLEAR);
        }

        @Override // p013io.netty.util.collection.IntObjectMap
        public boolean containsKey(int key) {
            return this.map.containsKey(key);
        }

        @Override // java.util.Map
        public boolean containsValue(Object value) {
            return this.map.containsValue(value);
        }

        @Override // java.util.Map
        public boolean containsKey(Object key) {
            return this.map.containsKey(key);
        }

        @Override // java.util.Map
        public V get(Object key) {
            return this.map.get(key);
        }

        public V put(Integer key, V value) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public V remove(Object key) {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Integer, ? extends V> m) {
            throw new UnsupportedOperationException("putAll");
        }

        @Override // p013io.netty.util.collection.IntObjectMap
        public Iterable<IntObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<IntObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.IntCollections.UnmodifiableMap.1
                    @Override // java.lang.Iterable
                    public Iterator<IntObjectMap.PrimitiveEntry<V>> iterator() {
                        return new IteratorImpl(UnmodifiableMap.this.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        @Override // java.util.Map
        public Set<Integer> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Integer, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
            }
            return this.entrySet;
        }

        @Override // java.util.Map
        public Collection<V> values() {
            if (this.values == null) {
                this.values = Collections.unmodifiableCollection(this.map.values());
            }
            return this.values;
        }

        /* renamed from: io.netty.util.collection.IntCollections$UnmodifiableMap$IteratorImpl */
        /* loaded from: grasscutter.jar:io/netty/util/collection/IntCollections$UnmodifiableMap$IteratorImpl.class */
        private class IteratorImpl implements Iterator<IntObjectMap.PrimitiveEntry<V>> {
            final Iterator<IntObjectMap.PrimitiveEntry<V>> iter;

            IteratorImpl(Iterator<IntObjectMap.PrimitiveEntry<V>> iter) {
                this.iter = iter;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public IntObjectMap.PrimitiveEntry<V> next() {
                if (hasNext()) {
                    return new EntryImpl(this.iter.next());
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: io.netty.util.collection.IntCollections$UnmodifiableMap$EntryImpl */
        /* loaded from: grasscutter.jar:io/netty/util/collection/IntCollections$UnmodifiableMap$EntryImpl.class */
        public class EntryImpl implements IntObjectMap.PrimitiveEntry<V> {
            private final IntObjectMap.PrimitiveEntry<V> entry;

            EntryImpl(IntObjectMap.PrimitiveEntry<V> entry) {
                this.entry = entry;
            }

            @Override // p013io.netty.util.collection.IntObjectMap.PrimitiveEntry
            public int key() {
                return this.entry.key();
            }

            @Override // p013io.netty.util.collection.IntObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }

            @Override // p013io.netty.util.collection.IntObjectMap.PrimitiveEntry
            public void setValue(V value) {
                throw new UnsupportedOperationException("setValue");
            }
        }
    }
}
