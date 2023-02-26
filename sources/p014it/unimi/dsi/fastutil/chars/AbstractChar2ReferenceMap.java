package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ReferenceMap.class */
public abstract class AbstractChar2ReferenceMap<V> extends AbstractChar2ReferenceFunction<V> implements Char2ReferenceMap<V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap
    public boolean containsKey(char k) {
        ObjectIterator<Char2ReferenceMap.Entry<V>> i = char2ReferenceEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getCharKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object v) {
        ObjectIterator<Char2ReferenceMap.Entry<V>> i = char2ReferenceEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ReferenceMap$BasicEntry.class */
    public static class BasicEntry<V> implements Char2ReferenceMap.Entry<V> {
        protected char key;
        protected V value;

        public BasicEntry() {
        }

        public BasicEntry(Character key, V value) {
            this.key = key.charValue();
            this.value = value;
        }

        public BasicEntry(char key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap.Entry
        public char getCharKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Char2ReferenceMap.Entry) {
                Char2ReferenceMap.Entry<V> e = (Char2ReferenceMap.Entry) o;
                return this.key == e.getCharKey() && this.value == e.getValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Character)) {
                return false;
            }
            return this.key == ((Character) key).charValue() && this.value == e2.getValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ (this.value == null ? 0 : System.identityHashCode(this.value));
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ReferenceMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet<V> extends AbstractObjectSet<Char2ReferenceMap.Entry<V>> {
        protected final Char2ReferenceMap<V> map;

        public BasicEntrySet(Char2ReferenceMap<V> map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Char2ReferenceMap.Entry) {
                Char2ReferenceMap.Entry<V> e = (Char2ReferenceMap.Entry) o;
                char k = e.getCharKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Character)) {
                return false;
            }
            char k2 = ((Character) key).charValue();
            return this.map.containsKey(k2) && this.map.get(k2) == e2.getValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Char2ReferenceMap.Entry) {
                Char2ReferenceMap.Entry<V> e = (Char2ReferenceMap.Entry) o;
                return this.map.remove(e.getCharKey(), e.getValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Character)) {
                return false;
            }
            return this.map.remove(((Character) key).charValue(), e2.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Char2ReferenceMap.Entry<V>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
    public Set<Character> keySet() {
        return new AbstractCharSet() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap.1
            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
            public boolean contains(char k) {
                return AbstractChar2ReferenceMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractChar2ReferenceMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractChar2ReferenceMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharIterator iterator() {
                return new CharIterator() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Char2ReferenceMap.Entry<V>> f1302i;

                    {
                        this.f1302i = Char2ReferenceMaps.fastIterator(AbstractChar2ReferenceMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public char nextChar() {
                        return this.f1302i.next().getCharKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1302i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1302i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public void forEachRemaining(CharConsumer action) {
                        this.f1302i.forEachRemaining(entry -> {
                            action.accept(entry.getCharKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharSpliterator spliterator() {
                return CharSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractChar2ReferenceMap.this), 321);
            }
        };
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        return new AbstractReferenceCollection<V>() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap.2
            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean contains(Object k) {
                return AbstractChar2ReferenceMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractChar2ReferenceMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractChar2ReferenceMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<V> iterator() {
                return new ObjectIterator<V>() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Char2ReferenceMap.Entry<V>> f1303i;

                    {
                        this.f1303i = Char2ReferenceMaps.fastIterator(AbstractChar2ReferenceMap.this);
                    }

                    @Override // java.util.Iterator
                    public V next() {
                        return this.f1303i.next().getValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1303i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1303i.remove();
                    }

                    @Override // java.util.Iterator
                    public void forEachRemaining(Consumer<? super V> action) {
                        this.f1303i.forEachRemaining(entry -> {
                            action.accept(entry.getValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<V> spliterator() {
                return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractChar2ReferenceMap.this), 64);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap<V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends Character, ? extends V> m) {
        if (m instanceof Char2ReferenceMap) {
            ObjectIterator<Char2ReferenceMap.Entry<V>> i = Char2ReferenceMaps.fastIterator((Char2ReferenceMap) m);
            while (i.hasNext()) {
                Char2ReferenceMap.Entry<? extends V> e = (Char2ReferenceMap.Entry) i.next();
                put(e.getCharKey(), (char) e.getValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Character, ? extends V>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Character, ? extends V> e2 = i2.next();
                put((Character) e2.getKey(), (Character) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Char2ReferenceMap.Entry<V>> i = Char2ReferenceMaps.fastIterator(this);
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += ((Char2ReferenceMap.Entry) i.next()).hashCode();
        }
    }

    @Override // java.lang.Object, java.util.Map
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Map)) {
            return false;
        }
        Map<?, ?> m = (Map) o;
        if (m.size() != size()) {
            return false;
        }
        return char2ReferenceEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Char2ReferenceMap.Entry<V>> i = Char2ReferenceMaps.fastIterator(this);
        int n = size();
        boolean first = true;
        s.append("{");
        while (true) {
            n--;
            if (n != 0) {
                if (first) {
                    first = false;
                } else {
                    s.append(", ");
                }
                Char2ReferenceMap.Entry<V> e = i.next();
                s.append(String.valueOf(e.getCharKey()));
                s.append("=>");
                if (this == e.getValue()) {
                    s.append("(this map)");
                } else {
                    s.append(String.valueOf(e.getValue()));
                }
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
