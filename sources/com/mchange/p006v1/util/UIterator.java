package com.mchange.p006v1.util;

/* renamed from: com.mchange.v1.util.UIterator */
/* loaded from: grasscutter.jar:com/mchange/v1/util/UIterator.class */
public interface UIterator extends ClosableResource {
    boolean hasNext() throws Exception;

    Object next() throws Exception;

    void remove() throws Exception;

    @Override // com.mchange.p006v1.util.ClosableResource
    void close() throws Exception;
}
