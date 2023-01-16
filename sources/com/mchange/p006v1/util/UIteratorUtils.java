package com.mchange.p006v1.util;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.mchange.v1.util.UIteratorUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/util/UIteratorUtils.class */
public class UIteratorUtils {
    public static void addToCollection(Collection collection, UIterator uIterator) throws Exception {
        while (uIterator.hasNext()) {
            collection.add(uIterator.next());
        }
    }

    public static UIterator uiteratorFromIterator(final Iterator it) {
        return new UIterator() { // from class: com.mchange.v1.util.UIteratorUtils.1
            @Override // com.mchange.p006v1.util.UIterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // com.mchange.p006v1.util.UIterator
            public Object next() {
                return it.next();
            }

            @Override // com.mchange.p006v1.util.UIterator
            public void remove() {
                it.remove();
            }

            @Override // com.mchange.p006v1.util.UIterator, com.mchange.p006v1.util.ClosableResource
            public void close() {
            }
        };
    }
}
