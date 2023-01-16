package com.mchange.p006v1.util;

/* renamed from: com.mchange.v1.util.UnreliableIterator */
/* loaded from: grasscutter.jar:com/mchange/v1/util/UnreliableIterator.class */
public interface UnreliableIterator extends UIterator {
    @Override // com.mchange.p006v1.util.UIterator
    boolean hasNext() throws UnreliableIteratorException;

    @Override // com.mchange.p006v1.util.UIterator
    Object next() throws UnreliableIteratorException;

    @Override // com.mchange.p006v1.util.UIterator
    void remove() throws UnreliableIteratorException;

    @Override // com.mchange.p006v1.util.UIterator, com.mchange.p006v1.util.ClosableResource
    void close() throws UnreliableIteratorException;
}
