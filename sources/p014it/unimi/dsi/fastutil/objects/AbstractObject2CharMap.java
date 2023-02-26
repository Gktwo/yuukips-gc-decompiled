package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharConsumer;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterators;
import p014it.unimi.dsi.fastutil.objects.Object2CharMap;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2CharMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2CharMap.class */
public abstract class AbstractObject2CharMap<K> extends AbstractObject2CharFunction<K> implements Object2CharMap<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        ObjectIterator<Object2CharMap.Entry<K>> i = object2CharEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
    public boolean containsValue(char v) {
        ObjectIterator<Object2CharMap.Entry<K>> i = object2CharEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getCharValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2CharMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2CharMap$BasicEntry.class */
    public static class BasicEntry<K> implements Object2CharMap.Entry<K> {
        protected K key;
        protected char value;

        public BasicEntry() {
        }

        public BasicEntry(K key, Character value) {
            this.key = key;
            this.value = value.charValue();
        }

        public BasicEntry(K key, char value) {
            this.key = key;
            this.value = value;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap.Entry
        public char getCharValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap.Entry
        public char setValue(char value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Object2CharMap.Entry) {
                Object2CharMap.Entry<K> e = (Object2CharMap.Entry) o;
                return Objects.equals(this.key, e.getKey()) && this.value == e.getCharValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            Object value = e2.getValue();
            return value != null && (value instanceof Character) && Objects.equals(this.key, key) && this.value == ((Character) value).charValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2CharMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2CharMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet<K> extends AbstractObjectSet<Object2CharMap.Entry<K>> {
        protected final Object2CharMap<K> map;

        public BasicEntrySet(Object2CharMap<K> map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Object2CharMap.Entry) {
                Object2CharMap.Entry<K> e = (Object2CharMap.Entry) o;
                K k = e.getKey();
                return this.map.containsKey(k) && this.map.getChar(k) == e.getCharValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k2 = e2.getKey();
            Object value = e2.getValue();
            return value != null && (value instanceof Character) && this.map.containsKey(k2) && this.map.getChar(k2) == ((Character) value).charValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Object2CharMap.Entry) {
                Object2CharMap.Entry<K> e = (Object2CharMap.Entry) o;
                return this.map.remove(e.getKey(), e.getCharValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k = e2.getKey();
            Object value = e2.getValue();
            if (value == null || !(value instanceof Character)) {
                return false;
            }
            return this.map.remove(k, ((Character) value).charValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Object2CharMap.Entry<K>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
    public ObjectSet<K> keySet() {
        return new AbstractObjectSet<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2CharMap.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object k) {
                return AbstractObject2CharMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractObject2CharMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractObject2CharMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
            public ObjectIterator<K> iterator() {
                return new ObjectIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2CharMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Object2CharMap.Entry<K>> f2420i;

                    {
                        this.f2420i = Object2CharMaps.fastIterator(AbstractObject2CharMap.this);
                    }

                    @Override // java.util.Iterator
                    public K next() {
                        return this.f2420i.next().getKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2420i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2420i.remove();
                    }

                    @Override // java.util.Iterator
                    public void forEachRemaining(Consumer<? super K> action) {
                        this.f2420i.forEachRemaining(entry -> {
                            action.accept(entry.getKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<K> spliterator() {
                return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractObject2CharMap.this), 65);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
    public Collection<Character> values() {
        return new AbstractCharCollection() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2CharMap.2
            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
            public boolean contains(char k) {
                return AbstractObject2CharMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractObject2CharMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractObject2CharMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharIterator iterator() {
                return new CharIterator() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2CharMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Object2CharMap.Entry<K>> f2421i;

                    {
                        this.f2421i = Object2CharMaps.fastIterator(AbstractObject2CharMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public char nextChar() {
                        return this.f2421i.next().getCharValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2421i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2421i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public void forEachRemaining(CharConsumer action) {
                        this.f2421i.forEachRemaining(entry -> {
                            action.accept(entry.getCharValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharSpliterator spliterator() {
                return CharSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractObject2CharMap.this), 320);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.AbstractObject2CharMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends Character> m) {
        if (m instanceof Object2CharMap) {
            ObjectIterator<Object2CharMap.Entry<K>> i = Object2CharMaps.fastIterator((Object2CharMap) m);
            while (i.hasNext()) {
                Object2CharMap.Entry<? extends K> e = (Object2CharMap.Entry) i.next();
                put((AbstractObject2CharMap<K>) e.getKey(), e.getCharValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends K, ? extends Character>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends K, ? extends Character> e2 = i2.next();
                put((AbstractObject2CharMap<K>) e2.getKey(), (Character) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Object2CharMap.Entry<K>> i = Object2CharMaps.fastIterator(this);
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += ((Object2CharMap.Entry) i.next()).hashCode();
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
        return object2CharEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Object2CharMap.Entry<K>> i = Object2CharMaps.fastIterator(this);
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
                Object2CharMap.Entry<K> e = i.next();
                if (this == e.getKey()) {
                    s.append("(this map)");
                } else {
                    s.append(String.valueOf(e.getKey()));
                }
                s.append("=>");
                s.append(String.valueOf(e.getCharValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
