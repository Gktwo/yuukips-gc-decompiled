package com.mchange.p009v2.util;

import com.mchange.p006v1.util.AbstractMapEntry;
import com.mchange.p006v1.util.WrapperIterator;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.mchange.v2.util.DoubleWeakHashMap */
/* loaded from: grasscutter.jar:com/mchange/v2/util/DoubleWeakHashMap.class */
public class DoubleWeakHashMap implements Map {
    HashMap inner;
    ReferenceQueue keyQ;
    ReferenceQueue valQ;
    CheckKeyHolder holder;
    Set userKeySet;
    Collection valuesCollection;

    public DoubleWeakHashMap() {
        this.keyQ = new ReferenceQueue();
        this.valQ = new ReferenceQueue();
        this.holder = new CheckKeyHolder();
        this.userKeySet = null;
        this.valuesCollection = null;
        this.inner = new HashMap();
    }

    public DoubleWeakHashMap(int i) {
        this.keyQ = new ReferenceQueue();
        this.valQ = new ReferenceQueue();
        this.holder = new CheckKeyHolder();
        this.userKeySet = null;
        this.valuesCollection = null;
        this.inner = new HashMap(i);
    }

    public DoubleWeakHashMap(int i, float f) {
        this.keyQ = new ReferenceQueue();
        this.valQ = new ReferenceQueue();
        this.holder = new CheckKeyHolder();
        this.userKeySet = null;
        this.valuesCollection = null;
        this.inner = new HashMap(i, f);
    }

    public DoubleWeakHashMap(Map map) {
        this();
        putAll(map);
    }

    public void cleanCleared() {
        while (true) {
            WKey wKey = (WKey) this.keyQ.poll();
            if (wKey != null) {
                this.inner.remove(wKey);
            }
        }
        while (true) {
            WVal wVal = (WVal) this.valQ.poll();
            if (wVal != null) {
                this.inner.remove(wVal.getWKey());
            } else {
                return;
            }
        }
    }

    @Override // java.util.Map
    public void clear() {
        cleanCleared();
        this.inner.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        cleanCleared();
        try {
            return this.inner.containsKey(this.holder.set(obj));
        } finally {
            this.holder.clear();
        }
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        for (WVal wVal : this.inner.values()) {
            if (obj.equals(wVal.get())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set entrySet() {
        cleanCleared();
        return new UserEntrySet();
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        try {
            cleanCleared();
            WVal wVal = (WVal) this.inner.get(this.holder.set(obj));
            return wVal == null ? null : wVal.get();
        } finally {
            this.holder.clear();
        }
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        cleanCleared();
        return this.inner.isEmpty();
    }

    @Override // java.util.Map
    public Set keySet() {
        cleanCleared();
        if (this.userKeySet == null) {
            this.userKeySet = new UserKeySet();
        }
        return this.userKeySet;
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        cleanCleared();
        WVal doPut = doPut(obj, obj2);
        if (doPut != null) {
            return doPut.get();
        }
        return null;
    }

    private WVal doPut(Object obj, Object obj2) {
        WKey wKey = new WKey(obj, this.keyQ);
        return (WVal) this.inner.put(wKey, new WVal(wKey, obj2, this.valQ));
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        cleanCleared();
        for (Map.Entry entry : map.entrySet()) {
            doPut(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        try {
            cleanCleared();
            WVal wVal = (WVal) this.inner.remove(this.holder.set(obj));
            return wVal == null ? null : wVal.get();
        } finally {
            this.holder.clear();
        }
    }

    @Override // java.util.Map
    public int size() {
        cleanCleared();
        return this.inner.size();
    }

    @Override // java.util.Map
    public Collection values() {
        if (this.valuesCollection == null) {
            this.valuesCollection = new ValuesCollection();
        }
        return this.valuesCollection;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.util.DoubleWeakHashMap$CheckKeyHolder */
    /* loaded from: grasscutter.jar:com/mchange/v2/util/DoubleWeakHashMap$CheckKeyHolder.class */
    public static final class CheckKeyHolder {
        Object checkKey;
        static final /* synthetic */ boolean $assertionsDisabled;

        CheckKeyHolder() {
        }

        static {
            $assertionsDisabled = !DoubleWeakHashMap.class.desiredAssertionStatus();
        }

        public Object get() {
            return this.checkKey;
        }

        public CheckKeyHolder set(Object obj) {
            if ($assertionsDisabled || this.checkKey == null) {
                this.checkKey = obj;
                return this;
            }
            throw new AssertionError("Illegal concurrenct use of DoubleWeakHashMap!");
        }

        public void clear() {
            this.checkKey = null;
        }

        public int hashCode() {
            return this.checkKey.hashCode();
        }

        public boolean equals(Object obj) {
            if (!$assertionsDisabled && get() == null) {
                throw new AssertionError("CheckedKeyHolder should never do an equality check while its value is null.");
            } else if (this == obj) {
                return true;
            } else {
                if (obj instanceof CheckKeyHolder) {
                    return get().equals(((CheckKeyHolder) obj).get());
                }
                if (obj instanceof WKey) {
                    return get().equals(((WKey) obj).get());
                }
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.util.DoubleWeakHashMap$WKey */
    /* loaded from: grasscutter.jar:com/mchange/v2/util/DoubleWeakHashMap$WKey.class */
    public static final class WKey extends WeakReference {
        int cachedHash;

        WKey(Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.cachedHash = obj.hashCode();
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.cachedHash;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WKey) {
                Object obj2 = get();
                Object obj3 = ((WKey) obj).get();
                if (obj2 == null || obj3 == null) {
                    return false;
                }
                return obj2.equals(obj3);
            } else if (!(obj instanceof CheckKeyHolder)) {
                return false;
            } else {
                Object obj4 = get();
                Object obj5 = ((CheckKeyHolder) obj).get();
                if (obj4 == null || obj5 == null) {
                    return false;
                }
                return obj4.equals(obj5);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.util.DoubleWeakHashMap$WVal */
    /* loaded from: grasscutter.jar:com/mchange/v2/util/DoubleWeakHashMap$WVal.class */
    public static final class WVal extends WeakReference {
        WKey key;

        WVal(WKey wKey, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.key = wKey;
        }

        public WKey getWKey() {
            return this.key;
        }
    }

    /* renamed from: com.mchange.v2.util.DoubleWeakHashMap$UserEntrySet */
    /* loaded from: grasscutter.jar:com/mchange/v2/util/DoubleWeakHashMap$UserEntrySet.class */
    private final class UserEntrySet extends AbstractSet {
        private UserEntrySet() {
        }

        private Set innerEntrySet() {
            DoubleWeakHashMap.this.cleanCleared();
            return DoubleWeakHashMap.this.inner.entrySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator iterator() {
            return new WrapperIterator(innerEntrySet().iterator(), true) { // from class: com.mchange.v2.util.DoubleWeakHashMap.UserEntrySet.1
                @Override // com.mchange.p006v1.util.WrapperIterator
                protected Object transformObject(Object obj) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object obj2 = ((WKey) entry.getKey()).get();
                    Object obj3 = ((WVal) entry.getValue()).get();
                    if (obj2 == null || obj3 == null) {
                        return WrapperIterator.SKIP_TOKEN;
                    }
                    return new UserEntry(entry, obj2, obj3);
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return innerEntrySet().size();
        }
    }

    /* renamed from: com.mchange.v2.util.DoubleWeakHashMap$UserEntry */
    /* loaded from: grasscutter.jar:com/mchange/v2/util/DoubleWeakHashMap$UserEntry.class */
    class UserEntry extends AbstractMapEntry {
        Map.Entry innerEntry;
        Object key;
        Object val;

        UserEntry(Map.Entry entry, Object obj, Object obj2) {
            this.innerEntry = entry;
            this.key = obj;
            this.val = obj2;
        }

        @Override // com.mchange.p006v1.util.AbstractMapEntry, java.util.Map.Entry
        public final Object getKey() {
            return this.key;
        }

        @Override // com.mchange.p006v1.util.AbstractMapEntry, java.util.Map.Entry
        public final Object getValue() {
            return this.val;
        }

        @Override // com.mchange.p006v1.util.AbstractMapEntry, java.util.Map.Entry
        public final Object setValue(Object obj) {
            return this.innerEntry.setValue(new WVal((WKey) this.innerEntry.getKey(), obj, DoubleWeakHashMap.this.valQ));
        }
    }

    /* renamed from: com.mchange.v2.util.DoubleWeakHashMap$UserKeySet */
    /* loaded from: grasscutter.jar:com/mchange/v2/util/DoubleWeakHashMap$UserKeySet.class */
    class UserKeySet implements Set {
        UserKeySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            DoubleWeakHashMap.this.cleanCleared();
            throw new UnsupportedOperationException("You cannot add to a Map's key set.");
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            DoubleWeakHashMap.this.cleanCleared();
            throw new UnsupportedOperationException("You cannot add to a Map's key set.");
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            DoubleWeakHashMap.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return DoubleWeakHashMap.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            for (Object obj : collection) {
                if (!contains(obj)) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return DoubleWeakHashMap.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            DoubleWeakHashMap.this.cleanCleared();
            return new WrapperIterator(DoubleWeakHashMap.this.inner.keySet().iterator(), true) { // from class: com.mchange.v2.util.DoubleWeakHashMap.UserKeySet.1
                @Override // com.mchange.p006v1.util.WrapperIterator
                protected Object transformObject(Object obj) {
                    Object obj2 = ((WKey) obj).get();
                    if (obj2 == null) {
                        return WrapperIterator.SKIP_TOKEN;
                    }
                    return obj2;
                }
            };
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            return DoubleWeakHashMap.this.remove(obj) != null;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            boolean z = false;
            for (Object obj : collection) {
                z |= remove(obj);
            }
            return z;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            boolean z = false;
            Iterator it = iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return DoubleWeakHashMap.this.size();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            DoubleWeakHashMap.this.cleanCleared();
            return new HashSet(this).toArray();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            DoubleWeakHashMap.this.cleanCleared();
            return new HashSet(this).toArray(objArr);
        }
    }

    /* renamed from: com.mchange.v2.util.DoubleWeakHashMap$ValuesCollection */
    /* loaded from: grasscutter.jar:com/mchange/v2/util/DoubleWeakHashMap$ValuesCollection.class */
    class ValuesCollection implements Collection {
        ValuesCollection() {
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            DoubleWeakHashMap.this.cleanCleared();
            throw new UnsupportedOperationException("DoubleWeakHashMap does not support adding to its values Collection.");
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            DoubleWeakHashMap.this.cleanCleared();
            throw new UnsupportedOperationException("DoubleWeakHashMap does not support adding to its values Collection.");
        }

        @Override // java.util.Collection
        public void clear() {
            DoubleWeakHashMap.this.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return DoubleWeakHashMap.this.containsValue(obj);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            for (Object obj : collection) {
                if (!contains(obj)) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return DoubleWeakHashMap.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new WrapperIterator(DoubleWeakHashMap.this.inner.values().iterator(), true) { // from class: com.mchange.v2.util.DoubleWeakHashMap.ValuesCollection.1
                @Override // com.mchange.p006v1.util.WrapperIterator
                protected Object transformObject(Object obj) {
                    Object obj2 = ((WVal) obj).get();
                    if (obj2 == null) {
                        return WrapperIterator.SKIP_TOKEN;
                    }
                    return obj2;
                }
            };
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            DoubleWeakHashMap.this.cleanCleared();
            return removeValue(obj);
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            DoubleWeakHashMap.this.cleanCleared();
            boolean z = false;
            for (Object obj : collection) {
                z |= removeValue(obj);
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            DoubleWeakHashMap.this.cleanCleared();
            return retainValues(collection);
        }

        @Override // java.util.Collection
        public int size() {
            return DoubleWeakHashMap.this.size();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            DoubleWeakHashMap.this.cleanCleared();
            return new ArrayList(this).toArray();
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            DoubleWeakHashMap.this.cleanCleared();
            return new ArrayList(this).toArray(objArr);
        }

        private boolean removeValue(Object obj) {
            boolean z = false;
            Iterator it = DoubleWeakHashMap.this.inner.values().iterator();
            while (it.hasNext()) {
                if (obj.equals(((WVal) it.next()).get())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        private boolean retainValues(Collection collection) {
            boolean z = false;
            Iterator it = DoubleWeakHashMap.this.inner.values().iterator();
            while (it.hasNext()) {
                if (!collection.contains(((WVal) it.next()).get())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
    }
}
