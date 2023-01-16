package p014it.unimi.dsi.fastutil.shorts;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShortCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShortCollection.class */
public abstract class AbstractShortCollection extends AbstractCollection<Short> implements ShortCollection {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public abstract ShortIterator iterator();

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean add(short k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean contains(short k) {
        ShortIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextShort()) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean rem(short k) {
        ShortIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextShort()) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    @Deprecated
    public boolean add(Short key) {
        return add(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    @Deprecated
    public boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    @Deprecated
    public boolean remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public short[] toArray(short[] a) {
        int size = size();
        if (a == null) {
            a = new short[size];
        } else if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        ShortIterators.unwrap(iterator(), a);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public short[] toShortArray() {
        return toArray((short[]) null);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    @Deprecated
    public short[] toShortArray(short[] a) {
        return toArray(a);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean addAll(ShortCollection c) {
        boolean retVal = false;
        ShortIterator i = c.iterator();
        while (i.hasNext()) {
            if (add(i.nextShort())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Short> c) {
        if (c instanceof ShortCollection) {
            return addAll((ShortCollection) c);
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean containsAll(ShortCollection c) {
        ShortIterator i = c.iterator();
        while (i.hasNext()) {
            if (!contains(i.nextShort())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection<?> c) {
        if (c instanceof ShortCollection) {
            return containsAll((ShortCollection) c);
        }
        return containsAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean removeAll(ShortCollection c) {
        boolean retVal = false;
        ShortIterator i = c.iterator();
        while (i.hasNext()) {
            if (rem(i.nextShort())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        if (c instanceof ShortCollection) {
            return removeAll((ShortCollection) c);
        }
        return removeAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean retainAll(ShortCollection c) {
        boolean retVal = false;
        ShortIterator i = iterator();
        while (i.hasNext()) {
            if (!c.contains(i.nextShort())) {
                i.remove();
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> c) {
        if (c instanceof ShortCollection) {
            return retainAll((ShortCollection) c);
        }
        return retainAll(c);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ShortIterator i = iterator();
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
                s.append(String.valueOf((int) i.nextShort()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
