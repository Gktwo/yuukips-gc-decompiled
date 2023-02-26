package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.shorts.Short2ShortMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2ShortMap.class */
public abstract class AbstractShort2ShortMap extends AbstractShort2ShortFunction implements Short2ShortMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    public boolean containsKey(short k) {
        ObjectIterator<Short2ShortMap.Entry> i = short2ShortEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getShortKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    public boolean containsValue(short v) {
        ObjectIterator<Short2ShortMap.Entry> i = short2ShortEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getShortValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2ShortMap$BasicEntry.class */
    public static class BasicEntry implements Short2ShortMap.Entry {
        protected short key;
        protected short value;

        public BasicEntry() {
        }

        public BasicEntry(Short key, Short value) {
            this.key = key.shortValue();
            this.value = value.shortValue();
        }

        public BasicEntry(short key, short value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap.Entry
        public short getShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap.Entry
        public short getShortValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap.Entry
        public short setValue(short value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Short2ShortMap.Entry) {
                Short2ShortMap.Entry e = (Short2ShortMap.Entry) o;
                return this.key == e.getShortKey() && this.value == e.getShortValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Short) && (value = e2.getValue()) != null && (value instanceof Short) && this.key == ((Short) key).shortValue() && this.value == ((Short) value).shortValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) this.key) + "->" + ((int) this.value);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2ShortMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Short2ShortMap.Entry> {
        protected final Short2ShortMap map;

        public BasicEntrySet(Short2ShortMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Short2ShortMap.Entry) {
                Short2ShortMap.Entry e = (Short2ShortMap.Entry) o;
                short k = e.getShortKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getShortValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Short)) {
                return false;
            }
            short k2 = ((Short) key).shortValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Short) && this.map.containsKey(k2) && this.map.get(k2) == ((Short) value).shortValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Short2ShortMap.Entry) {
                Short2ShortMap.Entry e = (Short2ShortMap.Entry) o;
                return this.map.remove(e.getShortKey(), e.getShortValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Short)) {
                return false;
            }
            short k = ((Short) key).shortValue();
            Object value = e2.getValue();
            if (value == null || !(value instanceof Short)) {
                return false;
            }
            return this.map.remove(k, ((Short) value).shortValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Short2ShortMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap, java.util.Map
    public Set<Short> keySet() {
        return new AbstractShortSet() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap.1
            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
            public boolean contains(short k) {
                return AbstractShort2ShortMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractShort2ShortMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractShort2ShortMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortIterator iterator() {
                return new ShortIterator() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Short2ShortMap.Entry> f2847i;

                    {
                        this.f2847i = Short2ShortMaps.fastIterator(AbstractShort2ShortMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public short nextShort() {
                        return this.f2847i.next().getShortKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2847i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2847i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public void forEachRemaining(ShortConsumer action) {
                        this.f2847i.forEachRemaining(entry -> {
                            action.accept(entry.getShortKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortSpliterator spliterator() {
                return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractShort2ShortMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap, java.util.Map
    public Collection<Short> values() {
        return new AbstractShortCollection() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap.2
            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
            public boolean contains(short k) {
                return AbstractShort2ShortMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractShort2ShortMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractShort2ShortMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortIterator iterator() {
                return new ShortIterator() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Short2ShortMap.Entry> f2848i;

                    {
                        this.f2848i = Short2ShortMaps.fastIterator(AbstractShort2ShortMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public short nextShort() {
                        return this.f2848i.next().getShortValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2848i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2848i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public void forEachRemaining(ShortConsumer action) {
                        this.f2848i.forEachRemaining(entry -> {
                            action.accept(entry.getShortValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortSpliterator spliterator() {
                return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractShort2ShortMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Short, ? extends Short> m) {
        if (m instanceof Short2ShortMap) {
            ObjectIterator<Short2ShortMap.Entry> i = Short2ShortMaps.fastIterator((Short2ShortMap) m);
            while (i.hasNext()) {
                Short2ShortMap.Entry e = i.next();
                put(e.getShortKey(), e.getShortValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Short, ? extends Short>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Short, ? extends Short> e2 = i2.next();
                put((Short) e2.getKey(), (Short) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Short2ShortMap.Entry> i = Short2ShortMaps.fastIterator(this);
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += i.next().hashCode();
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
        return short2ShortEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Short2ShortMap.Entry> i = Short2ShortMaps.fastIterator(this);
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
                Short2ShortMap.Entry e = i.next();
                s.append(String.valueOf((int) e.getShortKey()));
                s.append("=>");
                s.append(String.valueOf((int) e.getShortValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
