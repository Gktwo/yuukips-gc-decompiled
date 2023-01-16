package com.mchange.p006v1.util;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.mchange.v1.util.UnreliableIteratorUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/util/UnreliableIteratorUtils.class */
public class UnreliableIteratorUtils {
    public static void addToCollection(Collection collection, UnreliableIterator unreliableIterator) throws UnreliableIteratorException {
        while (unreliableIterator.hasNext()) {
            collection.add(unreliableIterator.next());
        }
    }

    public static UnreliableIterator unreliableIteratorFromIterator(final Iterator it) {
        return new UnreliableIterator() { // from class: com.mchange.v1.util.UnreliableIteratorUtils.1
            @Override // com.mchange.p006v1.util.UnreliableIterator, com.mchange.p006v1.util.UIterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // com.mchange.p006v1.util.UnreliableIterator, com.mchange.p006v1.util.UIterator
            public Object next() {
                return it.next();
            }

            @Override // com.mchange.p006v1.util.UnreliableIterator, com.mchange.p006v1.util.UIterator
            public void remove() {
                it.remove();
            }

            @Override // com.mchange.p006v1.util.UnreliableIterator, com.mchange.p006v1.util.UIterator, com.mchange.p006v1.util.ClosableResource
            public void close() {
            }
        };
    }
}
