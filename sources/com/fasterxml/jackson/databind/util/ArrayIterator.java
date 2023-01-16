package com.fasterxml.jackson.databind.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/util/ArrayIterator.class */
public class ArrayIterator<T> implements Iterator<T>, Iterable<T> {

    /* renamed from: _a */
    private final T[] f238_a;
    private int _index = 0;

    public ArrayIterator(T[] a) {
        this.f238_a = a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this._index < this.f238_a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this._index >= this.f238_a.length) {
            throw new NoSuchElementException();
        }
        T[] tArr = this.f238_a;
        int i = this._index;
        this._index = i + 1;
        return tArr[i];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this;
    }
}
