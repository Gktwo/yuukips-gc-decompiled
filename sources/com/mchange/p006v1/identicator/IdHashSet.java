package com.mchange.p006v1.identicator;

import com.mchange.p006v1.util.WrapperIterator;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.mchange.v1.identicator.IdHashSet */
/* loaded from: grasscutter.jar:com/mchange/v1/identicator/IdHashSet.class */
public class IdHashSet extends AbstractSet implements Set {
    HashSet inner;

    /* renamed from: id */
    Identicator f380id;

    private IdHashSet(HashSet hashSet, Identicator identicator) {
        this.inner = hashSet;
        this.f380id = identicator;
    }

    public IdHashSet(Identicator identicator) {
        this(new HashSet(), identicator);
    }

    public IdHashSet(Collection collection, Identicator identicator) {
        this(new HashSet(2 * collection.size()), identicator);
    }

    public IdHashSet(int i, float f, Identicator identicator) {
        this(new HashSet(i, f), identicator);
    }

    public IdHashSet(int i, Identicator identicator) {
        this(new HashSet(i, 0.75f), identicator);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator iterator() {
        return new WrapperIterator(this.inner.iterator(), true) { // from class: com.mchange.v1.identicator.IdHashSet.1
            @Override // com.mchange.p006v1.util.WrapperIterator
            protected Object transformObject(Object obj) {
                return ((IdHashKey) obj).getKeyObj();
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.inner.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.inner.contains(createKey(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        return this.inner.add(createKey(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.inner.remove(createKey(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.inner.clear();
    }

    private IdHashKey createKey(Object obj) {
        return new StrongIdHashKey(obj, this.f380id);
    }
}
