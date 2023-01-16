package p014it.unimi.dsi.fastutil.ints;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractIntCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractIntCollection.class */
public abstract class AbstractIntCollection extends AbstractCollection<Integer> implements IntCollection {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    public abstract IntIterator iterator();

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean add(int k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean contains(int k) {
        IntIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextInt()) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean rem(int k) {
        IntIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextInt()) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    @Deprecated
    public boolean add(Integer key) {
        return add(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.ints.IntCollection
    @Deprecated
    public boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.ints.IntCollection
    @Deprecated
    public boolean remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    public int[] toArray(int[] a) {
        int size = size();
        if (a == null) {
            a = new int[size];
        } else if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        IntIterators.unwrap(iterator(), a);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    public int[] toIntArray() {
        return toArray((int[]) null);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    @Deprecated
    public int[] toIntArray(int[] a) {
        return toArray(a);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
    public final void forEach(IntConsumer action) {
        forEach(action);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    public final boolean removeIf(IntPredicate filter) {
        return removeIf(filter);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean addAll(IntCollection c) {
        boolean retVal = false;
        IntIterator i = c.iterator();
        while (i.hasNext()) {
            if (add(i.nextInt())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Integer> c) {
        if (c instanceof IntCollection) {
            return addAll((IntCollection) c);
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean containsAll(IntCollection c) {
        IntIterator i = c.iterator();
        while (i.hasNext()) {
            if (!contains(i.nextInt())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection<?> c) {
        if (c instanceof IntCollection) {
            return containsAll((IntCollection) c);
        }
        return containsAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean removeAll(IntCollection c) {
        boolean retVal = false;
        IntIterator i = c.iterator();
        while (i.hasNext()) {
            if (rem(i.nextInt())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        if (c instanceof IntCollection) {
            return removeAll((IntCollection) c);
        }
        return removeAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean retainAll(IntCollection c) {
        boolean retVal = false;
        IntIterator i = iterator();
        while (i.hasNext()) {
            if (!c.contains(i.nextInt())) {
                i.remove();
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> c) {
        if (c instanceof IntCollection) {
            return retainAll((IntCollection) c);
        }
        return retainAll(c);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        IntIterator i = iterator();
        int n = size();
        boolean first = true;
        s.append("{");
        while (true) {
            n--;
            if (n != 0) {
                if (first) {
                    first = false;
                } else {
                    s.append(", ");
                }
                s.append(String.valueOf(i.nextInt()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
