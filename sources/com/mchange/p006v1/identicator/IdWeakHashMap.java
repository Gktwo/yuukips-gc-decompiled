package com.mchange.p006v1.identicator;

import com.mchange.p006v1.identicator.IdMap;
import com.mchange.p006v1.identicator.WeakIdHashKey;
import com.mchange.p006v1.util.WrapperIterator;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.mchange.v1.identicator.IdWeakHashMap */
/* loaded from: grasscutter.jar:com/mchange/v1/identicator/IdWeakHashMap.class */
public final class IdWeakHashMap extends IdMap implements Map {

    /* renamed from: rq */
    ReferenceQueue f383rq = new ReferenceQueue();

    public IdWeakHashMap(Identicator identicator) {
        super(new HashMap(), identicator);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        cleanCleared();
        return size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        try {
            return isEmpty();
        } finally {
            cleanCleared();
        }
    }

    @Override // com.mchange.p006v1.identicator.IdMap, java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        try {
            return containsKey(obj);
        } finally {
            cleanCleared();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        try {
            return containsValue(obj);
        } finally {
            cleanCleared();
        }
    }

    @Override // com.mchange.p006v1.identicator.IdMap, java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        try {
            return get(obj);
        } finally {
            cleanCleared();
        }
    }

    @Override // com.mchange.p006v1.identicator.IdMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        try {
            Object put = put(obj, obj2);
            cleanCleared();
            return put;
        } catch (Throwable th) {
            cleanCleared();
            throw th;
        }
    }

    @Override // com.mchange.p006v1.identicator.IdMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        try {
            return remove(obj);
        } finally {
            cleanCleared();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        try {
            putAll(map);
        } finally {
            cleanCleared();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        try {
            clear();
        } finally {
            cleanCleared();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        try {
            return keySet();
        } finally {
            cleanCleared();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        try {
            return values();
        } finally {
            cleanCleared();
        }
    }

    @Override // com.mchange.p006v1.identicator.IdMap, java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        try {
            return new WeakUserEntrySet();
        } finally {
            cleanCleared();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map, java.lang.Object
    public boolean equals(Object obj) {
        try {
            return equals(obj);
        } finally {
            cleanCleared();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map, java.lang.Object
    public int hashCode() {
        try {
            return hashCode();
        } finally {
            cleanCleared();
        }
    }

    @Override // com.mchange.p006v1.identicator.IdMap
    protected IdHashKey createIdKey(Object obj) {
        return new WeakIdHashKey(obj, this.f382id, this.f383rq);
    }

    /* access modifiers changed from: private */
    public void cleanCleared() {
        while (true) {
            WeakIdHashKey.Ref ref = (WeakIdHashKey.Ref) this.f383rq.poll();
            if (ref != null) {
                removeIdHashKey(ref.getKey());
            } else {
                return;
            }
        }
    }

    /* renamed from: com.mchange.v1.identicator.IdWeakHashMap$WeakUserEntrySet */
    /* loaded from: grasscutter.jar:com/mchange/v1/identicator/IdWeakHashMap$WeakUserEntrySet.class */
    private final class WeakUserEntrySet extends AbstractSet {
        Set innerEntries;

        private WeakUserEntrySet() {
            this.innerEntries = IdWeakHashMap.this.internalEntrySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator iterator() {
            try {
                return new WrapperIterator(this.innerEntries.iterator(), true) { // from class: com.mchange.v1.identicator.IdWeakHashMap.WeakUserEntrySet.1
                    @Override // com.mchange.p006v1.util.WrapperIterator
                    protected Object transformObject(Object obj) {
                        Map.Entry entry = (Map.Entry) obj;
                        final Object keyObj = ((IdHashKey) entry.getKey()).getKeyObj();
                        if (keyObj == null) {
                            return WrapperIterator.SKIP_TOKEN;
                        }
                        return new IdMap.UserEntry(entry) { // from class: com.mchange.v1.identicator.IdWeakHashMap.WeakUserEntrySet.1.1
                            Object preventRefClear;

                            {
                                this.preventRefClear = keyObj;
                            }
                        };
                    }
                };
            } finally {
                IdWeakHashMap.this.cleanCleared();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            IdWeakHashMap.this.cleanCleared();
            return this.innerEntries.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            try {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                boolean contains = this.innerEntries.contains(IdWeakHashMap.this.createIdEntry((Map.Entry) obj));
                IdWeakHashMap.this.cleanCleared();
                return contains;
            } finally {
                IdWeakHashMap.this.cleanCleared();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            try {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                boolean remove = this.innerEntries.remove(IdWeakHashMap.this.createIdEntry((Map.Entry) obj));
                IdWeakHashMap.this.cleanCleared();
                return remove;
            } finally {
                IdWeakHashMap.this.cleanCleared();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            try {
                IdWeakHashMap.this.inner.clear();
            } finally {
                IdWeakHashMap.this.cleanCleared();
            }
        }
    }
}
