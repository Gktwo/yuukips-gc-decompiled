package p014it.unimi.dsi.fastutil.floats;

import java.util.Set;
import p014it.unimi.dsi.fastutil.HashCommon;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloatSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloatSet.class */
public abstract class AbstractFloatSet extends AbstractFloatCollection implements Cloneable, FloatSet {
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public abstract FloatIterator iterator();

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
        if (s instanceof FloatSet) {
            return containsAll((FloatSet) s);
        }
        return containsAll(s);
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int n = size();
        FloatIterator i = iterator();
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += HashCommon.float2int(i.nextFloat());
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatSet
    public boolean remove(float k) {
        return rem(k);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    @Deprecated
    public boolean rem(float k) {
        return remove(k);
    }
}
