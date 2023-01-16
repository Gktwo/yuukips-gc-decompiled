package p014it.unimi.dsi.fastutil.objects;

import java.util.AbstractCollection;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObjectCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObjectCollection.class */
public abstract class AbstractObjectCollection<K> extends AbstractCollection<K> implements ObjectCollection<K> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
    public abstract ObjectIterator<K> iterator();

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<K> i = iterator();
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
                Object k = i.next();
                if (this == k) {
                    s.append("(this collection)");
                } else {
                    s.append(String.valueOf(k));
                }
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
