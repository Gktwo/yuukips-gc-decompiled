package com.mchange.p006v1.identicator;

import com.mchange.p006v1.util.IteratorUtils;
import com.mchange.p006v1.util.ListUtils;
import com.mchange.p006v1.util.WrapperIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.mchange.v1.identicator.IdList */
/* loaded from: grasscutter.jar:com/mchange/v1/identicator/IdList.class */
public class IdList implements List {

    /* renamed from: id */
    Identicator f381id;
    List inner;

    public IdList(Identicator identicator, List list) {
        this.f381id = identicator;
        this.inner = list;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.inner.size();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.inner.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        new StrongIdHashKey(obj, this.f381id);
        return this.inner.contains(obj);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new WrapperIterator(this.inner.iterator(), true) { // from class: com.mchange.v1.identicator.IdList.1
            @Override // com.mchange.p006v1.util.WrapperIterator
            protected Object transformObject(Object obj) {
                if (obj instanceof IdHashKey) {
                    return ((IdHashKey) obj).getKeyObj();
                }
                return obj;
            }
        };
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return IteratorUtils.toArray(iterator(), size(), objArr);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        return this.inner.add(new StrongIdHashKey(obj, this.f381id));
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.inner.remove(new StrongIdHashKey(obj, this.f381id));
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        for (Object obj : collection) {
            if (!this.inner.contains(new StrongIdHashKey(obj, this.f381id))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        boolean z = false;
        for (Object obj : collection) {
            z |= this.inner.add(new StrongIdHashKey(obj, this.f381id));
        }
        return z;
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        for (Object obj : collection) {
            this.inner.add(i, new StrongIdHashKey(obj, this.f381id));
            i++;
        }
        return collection.size() > 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        boolean z = false;
        for (Object obj : collection) {
            z |= this.inner.remove(new StrongIdHashKey(obj, this.f381id));
        }
        return z;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        boolean z = false;
        for (IdHashKey idHashKey : this.inner) {
            if (!collection.contains(idHashKey.getKeyObj())) {
                this.inner.remove(idHashKey);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.inner.clear();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof List) {
            return ListUtils.equivalent(this, (List) obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Object
    public int hashCode() {
        return ListUtils.hashContents(this);
    }

    @Override // java.util.List
    public Object get(int i) {
        return ((IdHashKey) this.inner.get(i)).getKeyObj();
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        return ((IdHashKey) this.inner.set(i, new StrongIdHashKey(obj, this.f381id))).getKeyObj();
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        this.inner.add(i, new StrongIdHashKey(obj, this.f381id));
    }

    @Override // java.util.List
    public Object remove(int i) {
        IdHashKey idHashKey = (IdHashKey) this.inner.remove(i);
        if (idHashKey == null) {
            return null;
        }
        return idHashKey.getKeyObj();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.inner.indexOf(new StrongIdHashKey(obj, this.f381id));
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.inner.lastIndexOf(new StrongIdHashKey(obj, this.f381id));
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return new LinkedList(this).listIterator();
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        return new LinkedList(this).listIterator(i);
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        return new IdList(this.f381id, this.inner.subList(i, i2));
    }
}
