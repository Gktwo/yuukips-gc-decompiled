package p014it.unimi.dsi.fastutil.booleans;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBooleanCollection.class */
public abstract class AbstractBooleanCollection extends AbstractCollection<Boolean> implements BooleanCollection {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public abstract BooleanIterator iterator();

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean add(boolean k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean contains(boolean k) {
        BooleanIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextBoolean()) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean rem(boolean k) {
        BooleanIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextBoolean()) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    @Deprecated
    public boolean add(Boolean key) {
        return add(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    @Deprecated
    public boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    @Deprecated
    public boolean remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean[] toArray(boolean[] a) {
        int size = size();
        if (a == null) {
            a = new boolean[size];
        } else if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        BooleanIterators.unwrap(iterator(), a);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean[] toBooleanArray() {
        return toArray((boolean[]) null);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    @Deprecated
    public boolean[] toBooleanArray(boolean[] a) {
        return toArray(a);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean addAll(BooleanCollection c) {
        boolean retVal = false;
        BooleanIterator i = c.iterator();
        while (i.hasNext()) {
            if (add(i.nextBoolean())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Boolean> c) {
        if (c instanceof BooleanCollection) {
            return addAll((BooleanCollection) c);
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean containsAll(BooleanCollection c) {
        BooleanIterator i = c.iterator();
        while (i.hasNext()) {
            if (!contains(i.nextBoolean())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection<?> c) {
        if (c instanceof BooleanCollection) {
            return containsAll((BooleanCollection) c);
        }
        return containsAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean removeAll(BooleanCollection c) {
        boolean retVal = false;
        BooleanIterator i = c.iterator();
        while (i.hasNext()) {
            if (rem(i.nextBoolean())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        if (c instanceof BooleanCollection) {
            return removeAll((BooleanCollection) c);
        }
        return removeAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean retainAll(BooleanCollection c) {
        boolean retVal = false;
        BooleanIterator i = iterator();
        while (i.hasNext()) {
            if (!c.contains(i.nextBoolean())) {
                i.remove();
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> c) {
        if (c instanceof BooleanCollection) {
            return retainAll((BooleanCollection) c);
        }
        return retainAll(c);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        BooleanIterator i = iterator();
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
                s.append(String.valueOf(i.nextBoolean()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
