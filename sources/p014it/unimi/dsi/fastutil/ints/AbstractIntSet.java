package p014it.unimi.dsi.fastutil.ints;

import java.util.Set;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractIntSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractIntSet.class */
public abstract class AbstractIntSet extends AbstractIntCollection implements Cloneable, IntSet {
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    public abstract IntIterator iterator();

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Set)) {
            return false;
        }
        Set<?> s = (Set) o;
        if (s.size() != size()) {
            return false;
        }
        if (s instanceof IntSet) {
            return containsAll((IntSet) s);
        }
        return containsAll(s);
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int n = size();
        IntIterator i = iterator();
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += i.nextInt();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntSet
    public boolean remove(int k) {
        return rem(k);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    @Deprecated
    public boolean rem(int k) {
        return remove(k);
    }
}
