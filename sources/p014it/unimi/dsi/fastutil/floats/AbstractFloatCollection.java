package p014it.unimi.dsi.fastutil.floats;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloatCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloatCollection.class */
public abstract class AbstractFloatCollection extends AbstractCollection<Float> implements FloatCollection {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public abstract FloatIterator iterator();

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean add(float k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean contains(float k) {
        FloatIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextFloat()) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean rem(float k) {
        FloatIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextFloat()) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    @Deprecated
    public boolean add(Float key) {
        return add(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    @Deprecated
    public boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    @Deprecated
    public boolean remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    public float[] toArray(float[] a) {
        int size = size();
        if (a == null) {
            a = new float[size];
        } else if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        FloatIterators.unwrap(iterator(), a);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    public float[] toFloatArray() {
        return toArray((float[]) null);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    @Deprecated
    public float[] toFloatArray(float[] a) {
        return toArray(a);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean addAll(FloatCollection c) {
        boolean retVal = false;
        FloatIterator i = c.iterator();
        while (i.hasNext()) {
            if (add(i.nextFloat())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Float> c) {
        if (c instanceof FloatCollection) {
            return addAll((FloatCollection) c);
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean containsAll(FloatCollection c) {
        FloatIterator i = c.iterator();
        while (i.hasNext()) {
            if (!contains(i.nextFloat())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection<?> c) {
        if (c instanceof FloatCollection) {
            return containsAll((FloatCollection) c);
        }
        return containsAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean removeAll(FloatCollection c) {
        boolean retVal = false;
        FloatIterator i = c.iterator();
        while (i.hasNext()) {
            if (rem(i.nextFloat())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        if (c instanceof FloatCollection) {
            return removeAll((FloatCollection) c);
        }
        return removeAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean retainAll(FloatCollection c) {
        boolean retVal = false;
        FloatIterator i = iterator();
        while (i.hasNext()) {
            if (!c.contains(i.nextFloat())) {
                i.remove();
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> c) {
        if (c instanceof FloatCollection) {
            return retainAll((FloatCollection) c);
        }
        return retainAll(c);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        FloatIterator i = iterator();
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
                s.append(String.valueOf(i.nextFloat()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
