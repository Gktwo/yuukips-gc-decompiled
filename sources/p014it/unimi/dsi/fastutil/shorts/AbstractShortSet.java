package p014it.unimi.dsi.fastutil.shorts;

import java.util.Set;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShortSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShortSet.class */
public abstract class AbstractShortSet extends AbstractShortCollection implements Cloneable, ShortSet {
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public abstract ShortIterator iterator();

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
        if (s instanceof ShortSet) {
            return containsAll((ShortSet) s);
        }
        return containsAll(s);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        short h = 0;
        int n = size();
        ShortIterator i = iterator();
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += i.nextShort();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSet
    public boolean remove(short k) {
        return rem(k);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    @Deprecated
    public boolean rem(short k) {
        return remove(k);
    }
}
