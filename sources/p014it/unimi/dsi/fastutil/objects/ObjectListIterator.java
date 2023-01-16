package p014it.unimi.dsi.fastutil.objects;

import java.util.ListIterator;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectListIterator.class */
public interface ObjectListIterator<K> extends ObjectBidirectionalIterator<K>, ListIterator<K> {
    @Override // java.util.ListIterator
    default void set(K k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    default void add(K k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    default void remove() {
        throw new UnsupportedOperationException();
    }
}
