package com.mchange.p006v1.identicator;

import com.mchange.p006v1.util.AbstractMapEntry;
import com.mchange.p006v1.util.SimpleMapEntry;
import com.mchange.p006v1.util.WrapperIterator;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.mchange.v1.identicator.IdMap */
/* loaded from: grasscutter.jar:com/mchange/v1/identicator/IdMap.class */
abstract class IdMap extends AbstractMap implements Map {
    Map inner;

    /* renamed from: id */
    Identicator f382id;

    protected abstract IdHashKey createIdKey(Object obj);

    /* access modifiers changed from: protected */
    public IdMap(Map map, Identicator identicator) {
        this.inner = map;
        this.f382id = identicator;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        return this.inner.put(createIdKey(obj), obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.inner.containsKey(createIdKey(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        return this.inner.get(createIdKey(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        return this.inner.remove(createIdKey(obj));
    }

    protected Object removeIdHashKey(IdHashKey idHashKey) {
        return this.inner.remove(idHashKey);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        return new UserEntrySet();
    }

    protected final Set internalEntrySet() {
        return this.inner.entrySet();
    }

    protected final Map.Entry createIdEntry(Object obj, Object obj2) {
        return new SimpleMapEntry(createIdKey(obj), obj2);
    }

    protected final Map.Entry createIdEntry(Map.Entry entry) {
        return createIdEntry(entry.getKey(), entry.getValue());
    }

    /* renamed from: com.mchange.v1.identicator.IdMap$UserEntrySet */
    /* loaded from: grasscutter.jar:com/mchange/v1/identicator/IdMap$UserEntrySet.class */
    private final class UserEntrySet extends AbstractSet {
        Set innerEntries;

        private UserEntrySet() {
            this.innerEntries = IdMap.this.inner.entrySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator iterator() {
            return new WrapperIterator(this.innerEntries.iterator(), true) { // from class: com.mchange.v1.identicator.IdMap.UserEntrySet.1
                @Override // com.mchange.p006v1.util.WrapperIterator
                protected Object transformObject(Object obj) {
                    return new UserEntry((Map.Entry) obj);
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.innerEntries.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            return this.innerEntries.contains(IdMap.this.createIdEntry((Map.Entry) obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            return this.innerEntries.remove(IdMap.this.createIdEntry((Map.Entry) obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            IdMap.this.inner.clear();
        }
    }

    /* renamed from: com.mchange.v1.identicator.IdMap$UserEntry */
    /* loaded from: grasscutter.jar:com/mchange/v1/identicator/IdMap$UserEntry.class */
    protected static class UserEntry extends AbstractMapEntry {
        private Map.Entry innerEntry;

        /* access modifiers changed from: package-private */
        public UserEntry(Map.Entry entry) {
            this.innerEntry = entry;
        }

        @Override // com.mchange.p006v1.util.AbstractMapEntry, java.util.Map.Entry
        public final Object getKey() {
            return ((IdHashKey) this.innerEntry.getKey()).getKeyObj();
        }

        @Override // com.mchange.p006v1.util.AbstractMapEntry, java.util.Map.Entry
        public final Object getValue() {
            return this.innerEntry.getValue();
        }

        @Override // com.mchange.p006v1.util.AbstractMapEntry, java.util.Map.Entry
        public final Object setValue(Object obj) {
            return this.innerEntry.setValue(obj);
        }
    }
}
