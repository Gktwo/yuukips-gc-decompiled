package p013io.netty.util.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.jline.reader.LineReader;
import p013io.netty.util.collection.LongObjectMap;

/* renamed from: io.netty.util.collection.LongCollections */
/* loaded from: grasscutter.jar:io/netty/util/collection/LongCollections.class */
public final class LongCollections {
    private static final LongObjectMap<Object> EMPTY_MAP = new EmptyMap();

    private LongCollections() {
    }

    public static <V> LongObjectMap<V> emptyMap() {
        return (LongObjectMap<V>) EMPTY_MAP;
    }

    public static <V> LongObjectMap<V> unmodifiableMap(LongObjectMap<V> map) {
        return new UnmodifiableMap(map);
    }

    /* renamed from: io.netty.util.collection.LongCollections$EmptyMap */
    /* loaded from: grasscutter.jar:io/netty/util/collection/LongCollections$EmptyMap.class */
    private static final class EmptyMap implements LongObjectMap<Object> {
        private EmptyMap() {
        }

        @Override // p013io.netty.util.collection.LongObjectMap
        public Object get(long key) {
            return null;
        }

        @Override // p013io.netty.util.collection.LongObjectMap
        public Object put(long key, Object value) {
            throw new UnsupportedOperationException("put");
        }

        @Override // p013io.netty.util.collection.LongObjectMap
        public Object remove(long key) {
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
        public Set<Long> keySet() {
            return Collections.emptySet();
        }

        @Override // p013io.netty.util.collection.LongObjectMap
        public boolean containsKey(long key) {
            return false;
        }

        @Override // java.util.Map
        public boolean containsValue(Object value) {
            return false;
        }

        @Override // p013io.netty.util.collection.LongObjectMap
        public Iterable<LongObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.emptySet();
        }

        @Override // java.util.Map
        public Object get(Object key) {
            return null;
        }

        public Object put(Long key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Object remove(Object key) {
            return null;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ?> m) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Collection<Object> values() {
            return Collections.emptyList();
        }

        @Override // java.util.Map
        public Set<Map.Entry<Long, Object>> entrySet() {
            return Collections.emptySet();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.collection.LongCollections$UnmodifiableMap */
    /* loaded from: grasscutter.jar:io/netty/util/collection/LongCollections$UnmodifiableMap.class */
    public static final class UnmodifiableMap<V> implements LongObjectMap<V> {
        private final LongObjectMap<V> map;
        private Set<Long> keySet;
        private Set<Map.Entry<Long, V>> entrySet;
        private Collection<V> values;
        private Iterable<LongObjectMap.PrimitiveEntry<V>> entries;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Object put(Long l, Object obj) {
            return put(l, (Long) obj);
        }

        UnmodifiableMap(LongObjectMap<V> map) {
            this.map = map;
        }

        @Override // p013io.netty.util.collection.LongObjectMap
        public V get(long key) {
            return this.map.get(key);
        }

        @Override // p013io.netty.util.collection.LongObjectMap
        public V put(long key, V value) {
            throw new UnsupportedOperationException("put");
        }

        @Override // p013io.netty.util.collection.LongObjectMap
        public V remove(long key) {
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

        @Override // p013io.netty.util.collection.LongObjectMap
        public boolean containsKey(long key) {
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

        public V put(Long key, V value) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public V remove(Object key) {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends V> m) {
            throw new UnsupportedOperationException("putAll");
        }

        @Override // p013io.netty.util.collection.LongObjectMap
        public Iterable<LongObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<LongObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.LongCollections.UnmodifiableMap.1
                    @Override // java.lang.Iterable
                    public Iterator<LongObjectMap.PrimitiveEntry<V>> iterator() {
                        return new IteratorImpl(UnmodifiableMap.this.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        @Override // java.util.Map
        public Set<Long> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Long, V>> entrySet() {
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

        /* renamed from: io.netty.util.collection.LongCollections$UnmodifiableMap$IteratorImpl */
        /* loaded from: grasscutter.jar:io/netty/util/collection/LongCollections$UnmodifiableMap$IteratorImpl.class */
        private class IteratorImpl implements Iterator<LongObjectMap.PrimitiveEntry<V>> {
            final Iterator<LongObjectMap.PrimitiveEntry<V>> iter;

            IteratorImpl(Iterator<LongObjectMap.PrimitiveEntry<V>> iter) {
                this.iter = iter;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public LongObjectMap.PrimitiveEntry<V> next() {
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
        /* renamed from: io.netty.util.collection.LongCollections$UnmodifiableMap$EntryImpl */
        /* loaded from: grasscutter.jar:io/netty/util/collection/LongCollections$UnmodifiableMap$EntryImpl.class */
        public class EntryImpl implements LongObjectMap.PrimitiveEntry<V> {
            private final LongObjectMap.PrimitiveEntry<V> entry;

            EntryImpl(LongObjectMap.PrimitiveEntry<V> entry) {
                this.entry = entry;
            }

            @Override // p013io.netty.util.collection.LongObjectMap.PrimitiveEntry
            public long key() {
                return this.entry.key();
            }

            @Override // p013io.netty.util.collection.LongObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }

            @Override // p013io.netty.util.collection.LongObjectMap.PrimitiveEntry
            public void setValue(V value) {
                throw new UnsupportedOperationException("setValue");
            }
        }
    }
}
