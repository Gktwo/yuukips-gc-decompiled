package p014it.unimi.dsi.fastutil.doubles;

import java.util.Set;
import p014it.unimi.dsi.fastutil.HashCommon;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleSet.class */
public abstract class AbstractDoubleSet extends AbstractDoubleCollection implements Cloneable, DoubleSet {
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public abstract DoubleIterator iterator();

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
        if (s instanceof DoubleSet) {
            return containsAll((DoubleSet) s);
        }
        return containsAll(s);
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int n = size();
        DoubleIterator i = iterator();
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += HashCommon.double2int(i.nextDouble());
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSet
    public boolean remove(double k) {
        return rem(k);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    @Deprecated
    public boolean rem(double k) {
        return remove(k);
    }
}
