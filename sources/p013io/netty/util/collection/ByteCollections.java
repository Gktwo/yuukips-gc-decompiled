package p013io.netty.util.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.jline.reader.LineReader;
import p013io.netty.util.collection.ByteObjectMap;

/* renamed from: io.netty.util.collection.ByteCollections */
/* loaded from: grasscutter.jar:io/netty/util/collection/ByteCollections.class */
public final class ByteCollections {
    private static final ByteObjectMap<Object> EMPTY_MAP = new EmptyMap();

    private ByteCollections() {
    }

    public static <V> ByteObjectMap<V> emptyMap() {
        return (ByteObjectMap<V>) EMPTY_MAP;
    }

    public static <V> ByteObjectMap<V> unmodifiableMap(ByteObjectMap<V> map) {
        return new UnmodifiableMap(map);
    }

    /* renamed from: io.netty.util.collection.ByteCollections$EmptyMap */
    /* loaded from: grasscutter.jar:io/netty/util/collection/ByteCollections$EmptyMap.class */
    private static final class EmptyMap implements ByteObjectMap<Object> {
        private EmptyMap() {
        }

        @Override // p013io.netty.util.collection.ByteObjectMap
        public Object get(byte key) {
            return null;
        }

        @Override // p013io.netty.util.collection.ByteObjectMap
        public Object put(byte key, Object value) {
            throw new UnsupportedOperationException("put");
        }

        @Override // p013io.netty.util.collection.ByteObjectMap
        public Object remove(byte key) {
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
        public Set<Byte> keySet() {
            return Collections.emptySet();
        }

        @Override // p013io.netty.util.collection.ByteObjectMap
        public boolean containsKey(byte key) {
            return false;
        }

        @Override // java.util.Map
        public boolean containsValue(Object value) {
            return false;
        }

        @Override // p013io.netty.util.collection.ByteObjectMap
        public Iterable<ByteObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.emptySet();
        }

        @Override // java.util.Map
        public Object get(Object key) {
            return null;
        }

        public Object put(Byte key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Object remove(Object key) {
            return null;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ?> m) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Collection<Object> values() {
            return Collections.emptyList();
        }

        @Override // java.util.Map
        public Set<Map.Entry<Byte, Object>> entrySet() {
            return Collections.emptySet();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.collection.ByteCollections$UnmodifiableMap */
    /* loaded from: grasscutter.jar:io/netty/util/collection/ByteCollections$UnmodifiableMap.class */
    public static final class UnmodifiableMap<V> implements ByteObjectMap<V> {
        private final ByteObjectMap<V> map;
        private Set<Byte> keySet;
        private Set<Map.Entry<Byte, V>> entrySet;
        private Collection<V> values;
        private Iterable<ByteObjectMap.PrimitiveEntry<V>> entries;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Object put(Byte b, Object obj) {
            return put(b, (Byte) obj);
        }

        UnmodifiableMap(ByteObjectMap<V> map) {
            this.map = map;
        }

        @Override // p013io.netty.util.collection.ByteObjectMap
        public V get(byte key) {
            return this.map.get(key);
        }

        @Override // p013io.netty.util.collection.ByteObjectMap
        public V put(byte key, V value) {
            throw new UnsupportedOperationException("put");
        }

        @Override // p013io.netty.util.collection.ByteObjectMap
        public V remove(byte key) {
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

        @Override // p013io.netty.util.collection.ByteObjectMap
        public boolean containsKey(byte key) {
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

        public V put(Byte key, V value) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public V remove(Object key) {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends V> m) {
            throw new UnsupportedOperationException("putAll");
        }

        @Override // p013io.netty.util.collection.ByteObjectMap
        public Iterable<ByteObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<ByteObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.ByteCollections.UnmodifiableMap.1
                    @Override // java.lang.Iterable
                    public Iterator<ByteObjectMap.PrimitiveEntry<V>> iterator() {
                        return new IteratorImpl(UnmodifiableMap.this.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        @Override // java.util.Map
        public Set<Byte> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Byte, V>> entrySet() {
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

        /* renamed from: io.netty.util.collection.ByteCollections$UnmodifiableMap$IteratorImpl */
        /* loaded from: grasscutter.jar:io/netty/util/collection/ByteCollections$UnmodifiableMap$IteratorImpl.class */
        private class IteratorImpl implements Iterator<ByteObjectMap.PrimitiveEntry<V>> {
            final Iterator<ByteObjectMap.PrimitiveEntry<V>> iter;

            IteratorImpl(Iterator<ByteObjectMap.PrimitiveEntry<V>> iter) {
                this.iter = iter;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public ByteObjectMap.PrimitiveEntry<V> next() {
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
        /* renamed from: io.netty.util.collection.ByteCollections$UnmodifiableMap$EntryImpl */
        /* loaded from: grasscutter.jar:io/netty/util/collection/ByteCollections$UnmodifiableMap$EntryImpl.class */
        public class EntryImpl implements ByteObjectMap.PrimitiveEntry<V> {
            private final ByteObjectMap.PrimitiveEntry<V> entry;

            EntryImpl(ByteObjectMap.PrimitiveEntry<V> entry) {
                this.entry = entry;
            }

            @Override // p013io.netty.util.collection.ByteObjectMap.PrimitiveEntry
            public byte key() {
                return this.entry.key();
            }

            @Override // p013io.netty.util.collection.ByteObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }

            @Override // p013io.netty.util.collection.ByteObjectMap.PrimitiveEntry
            public void setValue(V value) {
                throw new UnsupportedOperationException("setValue");
            }
        }
    }
}
