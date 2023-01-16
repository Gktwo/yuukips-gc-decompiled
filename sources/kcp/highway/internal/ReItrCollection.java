package kcp.highway.internal;

import java.util.Collection;

/* loaded from: grasscutter.jar:kcp/highway/internal/ReItrCollection.class */
public interface ReItrCollection<E> extends Collection<E> {
    @Override // java.util.Collection, java.lang.Iterable
    ReusableIterator<E> iterator();
}
