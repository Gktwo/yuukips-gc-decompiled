package p014it.unimi.dsi.fastutil.chars;

import java.util.Set;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractCharSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractCharSet.class */
public abstract class AbstractCharSet extends AbstractCharCollection implements Cloneable, CharSet {
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
    public abstract CharIterator iterator();

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
        if (s instanceof CharSet) {
            return containsAll((CharSet) s);
        }
        return containsAll(s);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        char h = 0;
        int n = size();
        CharIterator i = iterator();
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += i.nextChar();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharSet
    public boolean remove(char k) {
        return rem(k);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    @Deprecated
    public boolean rem(char k) {
        return remove(k);
    }
}
