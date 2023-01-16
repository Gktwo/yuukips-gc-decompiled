package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.util.Set;

/* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBooleanSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBooleanSet.class */
public abstract class AbstractBooleanSet extends AbstractBooleanCollection implements Cloneable, BooleanSet {
    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public abstract BooleanIterator iterator();

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
        if (s instanceof BooleanSet) {
            return containsAll((BooleanSet) s);
        }
        return containsAll(s);
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int n = size();
        BooleanIterator i = iterator();
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += i.nextBoolean() ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSet
    public boolean remove(boolean k) {
        return rem(k);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    @Deprecated
    public boolean rem(boolean k) {
        return remove(k);
    }
}
