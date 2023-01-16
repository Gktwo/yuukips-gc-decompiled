package com.mchange.p006v1.cachedstore;

import com.mchange.p006v1.util.WrapperIterator;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.mchange.v1.cachedstore.ManualCleanupSoftSet */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/ManualCleanupSoftSet.class */
class ManualCleanupSoftSet extends AbstractSet implements Vacuumable {
    HashSet inner = new HashSet();
    ReferenceQueue queue = new ReferenceQueue();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator iterator() {
        return new WrapperIterator(this.inner.iterator(), true) { // from class: com.mchange.v1.cachedstore.ManualCleanupSoftSet.1
            @Override // com.mchange.p006v1.util.WrapperIterator
            protected Object transformObject(Object obj) {
                Object obj2 = ((SoftKey) obj).get();
                return obj2 == null ? SKIP_TOKEN : obj2;
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.inner.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.inner.contains(new SoftKey(obj, null));
    }

    private ArrayList toArrayList() {
        ArrayList arrayList = new ArrayList(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return toArrayList().toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        return toArrayList().toArray(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        return this.inner.add(new SoftKey(obj, this.queue));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.inner.remove(new SoftKey(obj, null));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.inner.clear();
    }

    @Override // com.mchange.p006v1.cachedstore.Vacuumable
    public void vacuum() throws CachedStoreException {
        while (true) {
            SoftKey softKey = (SoftKey) this.queue.poll();
            if (softKey != null) {
                this.inner.remove(softKey);
            } else {
                return;
            }
        }
    }
}
