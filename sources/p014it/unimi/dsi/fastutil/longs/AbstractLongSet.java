package p014it.unimi.dsi.fastutil.longs;

import java.util.Set;
import p014it.unimi.dsi.fastutil.HashCommon;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongSet.class */
public abstract class AbstractLongSet extends AbstractLongCollection implements Cloneable, LongSet {
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    public abstract LongIterator iterator();

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
        if (s instanceof LongSet) {
            return containsAll((LongSet) s);
        }
        return containsAll(s);
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int n = size();
        LongIterator i = iterator();
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += HashCommon.long2int(i.nextLong());
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongSet
    public boolean remove(long k) {
        return rem(k);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    @Deprecated
    public boolean rem(long k) {
        return remove(k);
    }
}
