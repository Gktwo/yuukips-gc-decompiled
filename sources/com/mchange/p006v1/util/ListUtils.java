package com.mchange.p006v1.util;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.mchange.v1.util.ListUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/util/ListUtils.class */
public final class ListUtils {
    public static List oneElementUnmodifiableList(final Object obj) {
        return new AbstractList() { // from class: com.mchange.v1.util.ListUtils.1
            @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
            public Iterator iterator() {
                return IteratorUtils.oneElementUnmodifiableIterator(obj);
            }

            @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
            public int size() {
                return 1;
            }

            @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
            public boolean isEmpty() {
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
            public boolean contains(Object obj2) {
                return obj2 == obj;
            }

            @Override // java.util.AbstractList, java.util.List
            public Object get(int i) {
                if (i == 0) {
                    return obj;
                }
                throw new IndexOutOfBoundsException("One element list has no element index " + i);
            }
        };
    }

    public static boolean equivalent(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        return IteratorUtils.equivalent(list.iterator(), list2.iterator());
    }

    public static int hashContents(List list) {
        int i = 0;
        int i2 = 0;
        for (Object obj : list) {
            if (obj != null) {
                i ^= obj.hashCode() ^ i2;
            }
            i2++;
        }
        return i;
    }
}
