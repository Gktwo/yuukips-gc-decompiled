package kcp.highway.internal;

import java.util.ListIterator;

/* loaded from: grasscutter.jar:kcp/highway/internal/ReusableListIterator.class */
public interface ReusableListIterator<E> extends ListIterator<E>, ReusableIterator<E> {
    @Override // kcp.highway.internal.ReusableIterator
    ReusableListIterator<E> rewind();

    ReusableListIterator<E> rewind(int i);
}
