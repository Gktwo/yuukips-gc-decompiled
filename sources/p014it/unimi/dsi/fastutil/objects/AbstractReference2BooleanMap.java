package p014it.unimi.dsi.fastutil.objects;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators;
import p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2BooleanMap.class */
public abstract class AbstractReference2BooleanMap<K> extends AbstractReference2BooleanFunction<K> implements Reference2BooleanMap<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        ObjectIterator<Reference2BooleanMap.Entry<K>> i = reference2BooleanEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap
    public boolean containsValue(boolean v) {
        ObjectIterator<Reference2BooleanMap.Entry<K>> i = reference2BooleanEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getBooleanValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2BooleanMap$BasicEntry.class */
    public static class BasicEntry<K> implements Reference2BooleanMap.Entry<K> {
        protected K key;
        protected boolean value;

        public BasicEntry() {
        }

        public BasicEntry(K key, Boolean value) {
            this.key = key;
            this.value = value.booleanValue();
        }

        public BasicEntry(K key, boolean value) {
            this.key = key;
            this.value = value;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap.Entry
        public boolean getBooleanValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap.Entry
        public boolean setValue(boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Reference2BooleanMap.Entry) {
                Reference2BooleanMap.Entry<K> e = (Reference2BooleanMap.Entry) o;
                return this.key == e.getKey() && this.value == e.getBooleanValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            Object value = e2.getValue();
            return value != null && (value instanceof Boolean) && this.key == key && this.value == ((Boolean) value).booleanValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return System.identityHashCode(this.key) ^ (this.value ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2BooleanMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet<K> extends AbstractObjectSet<Reference2BooleanMap.Entry<K>> {
        protected final Reference2BooleanMap<K> map;

        public BasicEntrySet(Reference2BooleanMap<K> map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Reference2BooleanMap.Entry) {
                Reference2BooleanMap.Entry<K> e = (Reference2BooleanMap.Entry) o;
                K k = e.getKey();
                return this.map.containsKey(k) && this.map.getBoolean(k) == e.getBooleanValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k2 = e2.getKey();
            Object value = e2.getValue();
            return value != null && (value instanceof Boolean) && this.map.containsKey(k2) && this.map.getBoolean(k2) == ((Boolean) value).booleanValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Reference2BooleanMap.Entry) {
                Reference2BooleanMap.Entry<K> e = (Reference2BooleanMap.Entry) o;
                return this.map.remove(e.getKey(), e.getBooleanValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k = e2.getKey();
            Object value = e2.getValue();
            if (value == null || !(value instanceof Boolean)) {
                return false;
            }
            return this.map.remove(k, ((Boolean) value).booleanValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Reference2BooleanMap.Entry<K>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap, java.util.Map
    public ReferenceSet<K> keySet() {
        return new AbstractReferenceSet<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object k) {
                return AbstractReference2BooleanMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractReference2BooleanMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractReference2BooleanMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<K> iterator() {
                return new ObjectIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Reference2BooleanMap.Entry<K>> f2494i;

                    {
                        this.f2494i = Reference2BooleanMaps.fastIterator(AbstractReference2BooleanMap.this);
                    }

                    @Override // java.util.Iterator
                    public K next() {
                        return this.f2494i.next().getKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2494i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2494i.remove();
                    }

                    @Override // java.util.Iterator
                    public void forEachRemaining(Consumer<? super K> action) {
                        this.f2494i.forEachRemaining(entry -> {
                            action.accept(entry.getKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<K> spliterator() {
                return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractReference2BooleanMap.this), 65);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap, java.util.Map
    public Collection<Boolean> values() {
        return new AbstractBooleanCollection() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap.2
            @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
            public boolean contains(boolean k) {
                return AbstractReference2BooleanMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractReference2BooleanMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractReference2BooleanMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
            public BooleanIterator iterator() {
                return new BooleanIterator() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Reference2BooleanMap.Entry<K>> f2495i;

                    {
                        this.f2495i = Reference2BooleanMaps.fastIterator(AbstractReference2BooleanMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                    public boolean nextBoolean() {
                        return this.f2495i.next().getBooleanValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2495i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2495i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                    public void forEachRemaining(BooleanConsumer action) {
                        this.f2495i.forEachRemaining(entry -> {
                            action.accept(entry.getBooleanValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
            public BooleanSpliterator spliterator() {
                return BooleanSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractReference2BooleanMap.this), 320);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends Boolean> m) {
        if (m instanceof Reference2BooleanMap) {
            ObjectIterator<Reference2BooleanMap.Entry<K>> i = Reference2BooleanMaps.fastIterator((Reference2BooleanMap) m);
            while (i.hasNext()) {
                Reference2BooleanMap.Entry<? extends K> e = (Reference2BooleanMap.Entry) i.next();
                put((AbstractReference2BooleanMap<K>) e.getKey(), e.getBooleanValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends K, ? extends Boolean>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends K, ? extends Boolean> e2 = i2.next();
                put((AbstractReference2BooleanMap<K>) e2.getKey(), (Boolean) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Reference2BooleanMap.Entry<K>> i = Reference2BooleanMaps.fastIterator(this);
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += ((Reference2BooleanMap.Entry) i.next()).hashCode();
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
        return reference2BooleanEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Reference2BooleanMap.Entry<K>> i = Reference2BooleanMaps.fastIterator(this);
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
                Reference2BooleanMap.Entry<K> e = i.next();
                if (this == e.getKey()) {
                    s.append("(this map)");
                } else {
                    s.append(String.valueOf(e.getKey()));
                }
                s.append("=>");
                s.append(String.valueOf(e.getBooleanValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
