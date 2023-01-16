package kcp.highway.internal;

import java.util.Iterator;

/* loaded from: grasscutter.jar:kcp/highway/internal/ReusableIterator.class */
public interface ReusableIterator<E> extends Iterator<E> {
    ReusableIterator<E> rewind();
}
