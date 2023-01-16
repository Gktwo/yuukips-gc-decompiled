package p014it.unimi.dsi.fastutil.longs;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongCollection.class */
public abstract class AbstractLongCollection extends AbstractCollection<Long> implements LongCollection {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    public abstract LongIterator iterator();

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean add(long k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean contains(long k) {
        LongIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextLong()) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean rem(long k) {
        LongIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextLong()) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    @Deprecated
    public boolean add(Long key) {
        return add(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.longs.LongCollection
    @Deprecated
    public boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.longs.LongCollection
    @Deprecated
    public boolean remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    public long[] toArray(long[] a) {
        int size = size();
        if (a == null) {
            a = new long[size];
        } else if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        LongIterators.unwrap(iterator(), a);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    public long[] toLongArray() {
        return toArray((long[]) null);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    @Deprecated
    public long[] toLongArray(long[] a) {
        return toArray(a);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
    public final void forEach(LongConsumer action) {
        forEach(action);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    public final boolean removeIf(LongPredicate filter) {
        return removeIf(filter);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean addAll(LongCollection c) {
        boolean retVal = false;
        LongIterator i = c.iterator();
        while (i.hasNext()) {
            if (add(i.nextLong())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Long> c) {
        if (c instanceof LongCollection) {
            return addAll((LongCollection) c);
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean containsAll(LongCollection c) {
        LongIterator i = c.iterator();
        while (i.hasNext()) {
            if (!contains(i.nextLong())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection<?> c) {
        if (c instanceof LongCollection) {
            return containsAll((LongCollection) c);
        }
        return containsAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean removeAll(LongCollection c) {
        boolean retVal = false;
        LongIterator i = c.iterator();
        while (i.hasNext()) {
            if (rem(i.nextLong())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        if (c instanceof LongCollection) {
            return removeAll((LongCollection) c);
        }
        return removeAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean retainAll(LongCollection c) {
        boolean retVal = false;
        LongIterator i = iterator();
        while (i.hasNext()) {
            if (!c.contains(i.nextLong())) {
                i.remove();
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> c) {
        if (c instanceof LongCollection) {
            return retainAll((LongCollection) c);
        }
        return retainAll(c);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        LongIterator i = iterator();
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
                s.append(String.valueOf(i.nextLong()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
