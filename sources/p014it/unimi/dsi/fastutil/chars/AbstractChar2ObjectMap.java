package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ObjectMap.class */
public abstract class AbstractChar2ObjectMap<V> extends AbstractChar2ObjectFunction<V> implements Char2ObjectMap<V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public boolean containsKey(char k) {
        ObjectIterator<Char2ObjectMap.Entry<V>> i = char2ObjectEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getCharKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object v) {
        ObjectIterator<Char2ObjectMap.Entry<V>> i = char2ObjectEntrySet().iterator();
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

    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ObjectMap$BasicEntry.class */
    public static class BasicEntry<V> implements Char2ObjectMap.Entry<V> {
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

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap.Entry
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
            if (o instanceof Char2ObjectMap.Entry) {
                Char2ObjectMap.Entry<V> e = (Char2ObjectMap.Entry) o;
                return this.key == e.getCharKey() && Objects.equals(this.value, e.getValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Character)) {
                return false;
            }
            return this.key == ((Character) key).charValue() && Objects.equals(this.value, e2.getValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ (this.value == null ? 0 : this.value.hashCode());
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ObjectMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet<V> extends AbstractObjectSet<Char2ObjectMap.Entry<V>> {
        protected final Char2ObjectMap<V> map;

        public BasicEntrySet(Char2ObjectMap<V> map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Char2ObjectMap.Entry) {
                Char2ObjectMap.Entry<V> e = (Char2ObjectMap.Entry) o;
                char k = e.getCharKey();
                return this.map.containsKey(k) && Objects.equals(this.map.get(k), e.getValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Character)) {
                return false;
            }
            char k2 = ((Character) key).charValue();
            return this.map.containsKey(k2) && Objects.equals(this.map.get(k2), e2.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Char2ObjectMap.Entry) {
                Char2ObjectMap.Entry<V> e = (Char2ObjectMap.Entry) o;
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
        public ObjectSpliterator<Char2ObjectMap.Entry<V>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
    public Set<Character> keySet() {
        return new AbstractCharSet() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap.1
            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
            public boolean contains(char k) {
                return AbstractChar2ObjectMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractChar2ObjectMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractChar2ObjectMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharIterator iterator() {
                return new CharIterator() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Char2ObjectMap.Entry<V>> f1298i;

                    {
                        this.f1298i = Char2ObjectMaps.fastIterator(AbstractChar2ObjectMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public char nextChar() {
                        return this.f1298i.next().getCharKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1298i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1298i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public void forEachRemaining(CharConsumer action) {
                        this.f1298i.forEachRemaining(entry -> {
                            action.accept(entry.getCharKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharSpliterator spliterator() {
                return CharSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractChar2ObjectMap.this), 321);
            }
        };
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        return new AbstractObjectCollection<V>() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap.2
            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean contains(Object k) {
                return AbstractChar2ObjectMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractChar2ObjectMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractChar2ObjectMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
            public ObjectIterator<V> iterator() {
                return new ObjectIterator<V>() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Char2ObjectMap.Entry<V>> f1299i;

                    {
                        this.f1299i = Char2ObjectMaps.fastIterator(AbstractChar2ObjectMap.this);
                    }

                    @Override // java.util.Iterator
                    public V next() {
                        return this.f1299i.next().getValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1299i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1299i.remove();
                    }

                    @Override // java.util.Iterator
                    public void forEachRemaining(Consumer<? super V> action) {
                        this.f1299i.forEachRemaining(entry -> {
                            action.accept(entry.getValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<V> spliterator() {
                return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractChar2ObjectMap.this), 64);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap<V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends Character, ? extends V> m) {
        if (m instanceof Char2ObjectMap) {
            ObjectIterator<Char2ObjectMap.Entry<V>> i = Char2ObjectMaps.fastIterator((Char2ObjectMap) m);
            while (i.hasNext()) {
                Char2ObjectMap.Entry<? extends V> e = (Char2ObjectMap.Entry) i.next();
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
        ObjectIterator<Char2ObjectMap.Entry<V>> i = Char2ObjectMaps.fastIterator(this);
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += ((Char2ObjectMap.Entry) i.next()).hashCode();
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
        return char2ObjectEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Char2ObjectMap.Entry<V>> i = Char2ObjectMaps.fastIterator(this);
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
                Char2ObjectMap.Entry<V> e = i.next();
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
