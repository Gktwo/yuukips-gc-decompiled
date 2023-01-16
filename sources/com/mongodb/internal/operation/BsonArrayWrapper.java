package com.mongodb.internal.operation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.bson.BsonArray;
import org.bson.BsonValue;
import org.bson.assertions.Assertions;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/BsonArrayWrapper.class */
public class BsonArrayWrapper<T> extends BsonArray {
    private final List<T> wrappedArray;

    /* access modifiers changed from: package-private */
    public BsonArrayWrapper(List<T> wrappedArray) {
        this.wrappedArray = (List) Assertions.notNull("wrappedArray", wrappedArray);
    }

    public List<T> getWrappedArray() {
        return this.wrappedArray;
    }

    @Override // org.bson.BsonArray
    public List<BsonValue> getValues() {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List, java.util.Collection
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List, java.util.Collection
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List, java.util.Collection
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<BsonValue> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List, java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List, java.util.Collection
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray
    public boolean add(BsonValue bsonValue) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List, java.util.Collection
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends BsonValue> c) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List
    public boolean addAll(int index, Collection<? extends BsonValue> c) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List
    public BsonValue get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray
    public BsonValue set(int index, BsonValue element) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray
    public void add(int index, BsonValue element) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List
    public BsonValue remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List
    public ListIterator<BsonValue> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List
    public ListIterator<BsonValue> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List
    public List<BsonValue> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BsonArray, java.util.List, java.util.Collection, java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !this.wrappedArray.equals(((BsonArrayWrapper) o).wrappedArray)) {
            return false;
        }
        return true;
    }

    @Override // org.bson.BsonArray, java.util.List, java.util.Collection, java.lang.Object
    public int hashCode() {
        return (31 * hashCode()) + this.wrappedArray.hashCode();
    }

    @Override // org.bson.BsonArray, java.lang.Object
    public String toString() {
        return "BsonArrayWrapper{wrappedArray=" + this.wrappedArray + '}';
    }

    @Override // org.bson.BsonArray, java.lang.Object
    public BsonArray clone() {
        throw new UnsupportedOperationException("This should never be called on an instance of this type");
    }
}
