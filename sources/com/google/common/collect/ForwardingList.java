package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/ForwardingList.class */
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract List<E> delegate();

    @Override // java.util.List
    public void add(int index, E element) {
        delegate().add(index, element);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    public boolean addAll(int index, Collection<? extends E> elements) {
        return delegate().addAll(index, elements);
    }

    @Override // java.util.List
    public E get(int index) {
        return delegate().get(index);
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        return delegate().indexOf(element);
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        return delegate().lastIndexOf(element);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int index) {
        return delegate().listIterator(index);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    public E remove(int index) {
        return delegate().remove(index);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    public E set(int index, E element) {
        return delegate().set(index, element);
    }

    @Override // java.util.List
    public List<E> subList(int fromIndex, int toIndex) {
        return delegate().subList(fromIndex, toIndex);
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object object) {
        return object == this || delegate().equals(object);
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public int hashCode() {
        return delegate().hashCode();
    }

    protected boolean standardAdd(E element) {
        add(size(), element);
        return true;
    }

    protected boolean standardAddAll(int index, Iterable<? extends E> elements) {
        return Lists.addAllImpl(this, index, elements);
    }

    protected int standardIndexOf(Object element) {
        return Lists.indexOfImpl(this, element);
    }

    protected int standardLastIndexOf(Object element) {
        return Lists.lastIndexOfImpl(this, element);
    }

    protected Iterator<E> standardIterator() {
        return listIterator();
    }

    protected ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    @Beta
    protected ListIterator<E> standardListIterator(int start) {
        return Lists.listIteratorImpl(this, start);
    }

    @Beta
    protected List<E> standardSubList(int fromIndex, int toIndex) {
        return Lists.subListImpl(this, fromIndex, toIndex);
    }

    @Beta
    protected boolean standardEquals(Object object) {
        return Lists.equalsImpl(this, object);
    }

    @Beta
    protected int standardHashCode() {
        return Lists.hashCodeImpl(this);
    }
}
