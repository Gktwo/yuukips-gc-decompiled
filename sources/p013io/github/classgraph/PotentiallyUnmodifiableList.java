package p013io.github.classgraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* access modifiers changed from: package-private */
/* renamed from: io.github.classgraph.PotentiallyUnmodifiableList */
/* loaded from: grasscutter.jar:io/github/classgraph/PotentiallyUnmodifiableList.class */
public class PotentiallyUnmodifiableList<T> extends ArrayList<T> {
    static final long serialVersionUID = 1;
    boolean modifiable = true;

    /* access modifiers changed from: package-private */
    public PotentiallyUnmodifiableList() {
    }

    /* access modifiers changed from: package-private */
    public PotentiallyUnmodifiableList(int sizeHint) {
        super(sizeHint);
    }

    /* access modifiers changed from: package-private */
    public PotentiallyUnmodifiableList(Collection<T> collection) {
        super(collection);
    }

    @Override // java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Object
    public boolean equals(Object o) {
        return equals(o);
    }

    @Override // java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Object
    public int hashCode() {
        return hashCode();
    }

    void makeUnmodifiable() {
        this.modifiable = false;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(T element) {
        if (this.modifiable) {
            return add(element);
        }
        throw new IllegalArgumentException("List is immutable");
    }

    @Override // java.util.ArrayList, java.util.List, java.util.AbstractList
    public void add(int index, T element) {
        if (!this.modifiable) {
            throw new IllegalArgumentException("List is immutable");
        }
        add(index, element);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean remove(Object o) {
        if (this.modifiable) {
            return remove(o);
        }
        throw new IllegalArgumentException("List is immutable");
    }

    @Override // java.util.ArrayList, java.util.List, java.util.AbstractList
    public T remove(int index) {
        if (this.modifiable) {
            return remove(index);
        }
        throw new IllegalArgumentException("List is immutable");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Collection<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> c) {
        if (this.modifiable || c.isEmpty()) {
            return addAll(c);
        }
        throw new IllegalArgumentException("List is immutable");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.Collection<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.List, java.util.AbstractList
    public boolean addAll(int index, Collection<? extends T> c) {
        if (this.modifiable || c.isEmpty()) {
            return addAll(index, c);
        }
        throw new IllegalArgumentException("List is immutable");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        if (this.modifiable || c.isEmpty()) {
            return removeAll(c);
        }
        throw new IllegalArgumentException("List is immutable");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> c) {
        if (this.modifiable || isEmpty()) {
            return retainAll(c);
        }
        throw new IllegalArgumentException("List is immutable");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public void clear() {
        if (this.modifiable || isEmpty()) {
            clear();
            return;
        }
        throw new IllegalArgumentException("List is immutable");
    }

    @Override // java.util.ArrayList, java.util.List, java.util.AbstractList
    public T set(int index, T element) {
        if (this.modifiable) {
            return set(index, element);
        }
        throw new IllegalArgumentException("List is immutable");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public Iterator<T> iterator() {
        final Iterator<T> iterator = iterator();
        return new Iterator<T>() { // from class: io.github.classgraph.PotentiallyUnmodifiableList.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                if (PotentiallyUnmodifiableList.this.isEmpty()) {
                    return false;
                }
                return iterator.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                return (T) iterator.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                if (!PotentiallyUnmodifiableList.this.modifiable) {
                    throw new IllegalArgumentException("List is immutable");
                }
                iterator.remove();
            }
        };
    }

    @Override // java.util.ArrayList, java.util.List, java.util.AbstractList
    public ListIterator<T> listIterator() {
        final ListIterator<T> iterator = listIterator();
        return new ListIterator<T>() { // from class: io.github.classgraph.PotentiallyUnmodifiableList.2
            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                if (PotentiallyUnmodifiableList.this.isEmpty()) {
                    return false;
                }
                return iterator.hasNext();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public T next() {
                return (T) iterator.next();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                if (PotentiallyUnmodifiableList.this.isEmpty()) {
                    return false;
                }
                return iterator.hasPrevious();
            }

            @Override // java.util.ListIterator
            public T previous() {
                return (T) iterator.previous();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                if (PotentiallyUnmodifiableList.this.isEmpty()) {
                    return 0;
                }
                return iterator.nextIndex();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                if (PotentiallyUnmodifiableList.this.isEmpty()) {
                    return -1;
                }
                return iterator.previousIndex();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                if (!PotentiallyUnmodifiableList.this.modifiable) {
                    throw new IllegalArgumentException("List is immutable");
                }
                iterator.remove();
            }

            @Override // java.util.ListIterator
            public void set(T e) {
                if (!PotentiallyUnmodifiableList.this.modifiable) {
                    throw new IllegalArgumentException("List is immutable");
                }
                iterator.set(e);
            }

            @Override // java.util.ListIterator
            public void add(T e) {
                if (!PotentiallyUnmodifiableList.this.modifiable) {
                    throw new IllegalArgumentException("List is immutable");
                }
                iterator.add(e);
            }
        };
    }
}
