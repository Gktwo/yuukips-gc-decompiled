package com.mchange.util;

import java.util.Iterator;

/* loaded from: grasscutter.jar:com/mchange/util/IteratorUtils.class */
public class IteratorUtils {
    public static Iterator unmodifiableIterator(final Iterator it) {
        return new Iterator() { // from class: com.mchange.util.IteratorUtils.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                return it.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("This Iterator does not support the remove operation.");
            }
        };
    }
}
