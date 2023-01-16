package p014it.unimi.dsi.fastutil.doubles;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleCollection.class */
public abstract class AbstractDoubleCollection extends AbstractCollection<Double> implements DoubleCollection {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public abstract DoubleIterator iterator();

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean add(double k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean contains(double k) {
        DoubleIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextDouble()) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean rem(double k) {
        DoubleIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextDouble()) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    @Deprecated
    public boolean add(Double key) {
        return add(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    @Deprecated
    public boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    @Deprecated
    public boolean remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public double[] toArray(double[] a) {
        int size = size();
        if (a == null) {
            a = new double[size];
        } else if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        DoubleIterators.unwrap(iterator(), a);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public double[] toDoubleArray() {
        return toArray((double[]) null);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    @Deprecated
    public double[] toDoubleArray(double[] a) {
        return toArray(a);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public final void forEach(DoubleConsumer action) {
        forEach(action);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public final boolean removeIf(DoublePredicate filter) {
        return removeIf(filter);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean addAll(DoubleCollection c) {
        boolean retVal = false;
        DoubleIterator i = c.iterator();
        while (i.hasNext()) {
            if (add(i.nextDouble())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Double> c) {
        if (c instanceof DoubleCollection) {
            return addAll((DoubleCollection) c);
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean containsAll(DoubleCollection c) {
        DoubleIterator i = c.iterator();
        while (i.hasNext()) {
            if (!contains(i.nextDouble())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection<?> c) {
        if (c instanceof DoubleCollection) {
            return containsAll((DoubleCollection) c);
        }
        return containsAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean removeAll(DoubleCollection c) {
        boolean retVal = false;
        DoubleIterator i = c.iterator();
        while (i.hasNext()) {
            if (rem(i.nextDouble())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        if (c instanceof DoubleCollection) {
            return removeAll((DoubleCollection) c);
        }
        return removeAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean retainAll(DoubleCollection c) {
        boolean retVal = false;
        DoubleIterator i = iterator();
        while (i.hasNext()) {
            if (!c.contains(i.nextDouble())) {
                i.remove();
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> c) {
        if (c instanceof DoubleCollection) {
            return retainAll((DoubleCollection) c);
        }
        return retainAll(c);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        DoubleIterator i = iterator();
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
                s.append(String.valueOf(i.nextDouble()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
