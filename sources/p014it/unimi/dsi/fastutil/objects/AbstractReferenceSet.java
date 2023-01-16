package p014it.unimi.dsi.fastutil.objects;

import java.util.Set;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReferenceSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReferenceSet.class */
public abstract class AbstractReferenceSet<K> extends AbstractReferenceCollection<K> implements Cloneable, ReferenceSet<K> {
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
    public abstract ObjectIterator<K> iterator();

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
        return containsAll(s);
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<K> i = iterator();
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += System.identityHashCode(i.next());
        }
    }
}
