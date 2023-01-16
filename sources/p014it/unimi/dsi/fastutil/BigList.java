package p014it.unimi.dsi.fastutil;

import java.util.Collection;

/* renamed from: it.unimi.dsi.fastutil.BigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/BigList.class */
public interface BigList<K> extends Collection<K>, Size64 {
    K get(long j);

    K remove(long j);

    K set(long j, K k);

    void add(long j, K k);

    void size(long j);

    boolean addAll(long j, Collection<? extends K> collection);

    long indexOf(Object obj);

    long lastIndexOf(Object obj);

    BigListIterator<K> listIterator();

    BigListIterator<K> listIterator(long j);

    BigList<K> subList(long j, long j2);

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.Size64
    @Deprecated
    default int size() {
        return size();
    }
}
