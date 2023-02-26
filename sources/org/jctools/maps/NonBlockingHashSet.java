package org.jctools.maps;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;

/* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingHashSet.class */
public class NonBlockingHashSet<E> extends AbstractSet<E> implements Serializable {

    /* renamed from: V */
    private static final Object f3155V = "";
    private final NonBlockingHashMap<E, Object> _map = new NonBlockingHashMap<>();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E o) {
        return this._map.putIfAbsent(o, f3155V) == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o) {
        return this._map.containsKey(o);
    }

    public E get(E o) {
        return this._map.getk(o);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o) {
        return this._map.remove(o) == f3155V;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this._map.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this._map.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<E> iterator() {
        return this._map.keySet().iterator();
    }
}
