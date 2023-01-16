package p013io.netty.util.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.jline.reader.LineReader;
import p013io.netty.util.collection.CharObjectMap;

/* renamed from: io.netty.util.collection.CharCollections */
/* loaded from: grasscutter.jar:io/netty/util/collection/CharCollections.class */
public final class CharCollections {
    private static final CharObjectMap<Object> EMPTY_MAP = new EmptyMap();

    private CharCollections() {
    }

    public static <V> CharObjectMap<V> emptyMap() {
        return (CharObjectMap<V>) EMPTY_MAP;
    }

    public static <V> CharObjectMap<V> unmodifiableMap(CharObjectMap<V> map) {
        return new UnmodifiableMap(map);
    }

    /* renamed from: io.netty.util.collection.CharCollections$EmptyMap */
    /* loaded from: grasscutter.jar:io/netty/util/collection/CharCollections$EmptyMap.class */
    private static final class EmptyMap implements CharObjectMap<Object> {
        private EmptyMap() {
        }

        @Override // p013io.netty.util.collection.CharObjectMap
        public Object get(char key) {
            return null;
        }

        @Override // p013io.netty.util.collection.CharObjectMap
        public Object put(char key, Object value) {
            throw new UnsupportedOperationException("put");
        }

        @Override // p013io.netty.util.collection.CharObjectMap
        public Object remove(char key) {
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
        public Set<Character> keySet() {
            return Collections.emptySet();
        }

        @Override // p013io.netty.util.collection.CharObjectMap
        public boolean containsKey(char key) {
            return false;
        }

        @Override // java.util.Map
        public boolean containsValue(Object value) {
            return false;
        }

        @Override // p013io.netty.util.collection.CharObjectMap
        public Iterable<CharObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.emptySet();
        }

        @Override // java.util.Map
        public Object get(Object key) {
            return null;
        }

        public Object put(Character key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Object remove(Object key) {
            return null;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ?> m) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Collection<Object> values() {
            return Collections.emptyList();
        }

        @Override // java.util.Map
        public Set<Map.Entry<Character, Object>> entrySet() {
            return Collections.emptySet();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.collection.CharCollections$UnmodifiableMap */
    /* loaded from: grasscutter.jar:io/netty/util/collection/CharCollections$UnmodifiableMap.class */
    public static final class UnmodifiableMap<V> implements CharObjectMap<V> {
        private final CharObjectMap<V> map;
        private Set<Character> keySet;
        private Set<Map.Entry<Character, V>> entrySet;
        private Collection<V> values;
        private Iterable<CharObjectMap.PrimitiveEntry<V>> entries;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Object put(Character ch, Object obj) {
            return put(ch, (Character) obj);
        }

        UnmodifiableMap(CharObjectMap<V> map) {
            this.map = map;
        }

        @Override // p013io.netty.util.collection.CharObjectMap
        public V get(char key) {
            return this.map.get(key);
        }

        @Override // p013io.netty.util.collection.CharObjectMap
        public V put(char key, V value) {
            throw new UnsupportedOperationException("put");
        }

        @Override // p013io.netty.util.collection.CharObjectMap
        public V remove(char key) {
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

        @Override // p013io.netty.util.collection.CharObjectMap
        public boolean containsKey(char key) {
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

        public V put(Character key, V value) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public V remove(Object key) {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ? extends V> m) {
            throw new UnsupportedOperationException("putAll");
        }

        @Override // p013io.netty.util.collection.CharObjectMap
        public Iterable<CharObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<CharObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.CharCollections.UnmodifiableMap.1
                    @Override // java.lang.Iterable
                    public Iterator<CharObjectMap.PrimitiveEntry<V>> iterator() {
                        return new IteratorImpl(UnmodifiableMap.this.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        @Override // java.util.Map
        public Set<Character> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Character, V>> entrySet() {
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

        /* renamed from: io.netty.util.collection.CharCollections$UnmodifiableMap$IteratorImpl */
        /* loaded from: grasscutter.jar:io/netty/util/collection/CharCollections$UnmodifiableMap$IteratorImpl.class */
        private class IteratorImpl implements Iterator<CharObjectMap.PrimitiveEntry<V>> {
            final Iterator<CharObjectMap.PrimitiveEntry<V>> iter;

            IteratorImpl(Iterator<CharObjectMap.PrimitiveEntry<V>> iter) {
                this.iter = iter;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public CharObjectMap.PrimitiveEntry<V> next() {
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
        /* renamed from: io.netty.util.collection.CharCollections$UnmodifiableMap$EntryImpl */
        /* loaded from: grasscutter.jar:io/netty/util/collection/CharCollections$UnmodifiableMap$EntryImpl.class */
        public class EntryImpl implements CharObjectMap.PrimitiveEntry<V> {
            private final CharObjectMap.PrimitiveEntry<V> entry;

            EntryImpl(CharObjectMap.PrimitiveEntry<V> entry) {
                this.entry = entry;
            }

            @Override // p013io.netty.util.collection.CharObjectMap.PrimitiveEntry
            public char key() {
                return this.entry.key();
            }

            @Override // p013io.netty.util.collection.CharObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }

            @Override // p013io.netty.util.collection.CharObjectMap.PrimitiveEntry
            public void setValue(V value) {
                throw new UnsupportedOperationException("setValue");
            }
        }
    }
}
