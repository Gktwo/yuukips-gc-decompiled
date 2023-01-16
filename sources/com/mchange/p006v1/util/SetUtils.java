package com.mchange.p006v1.util;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.mchange.v1.util.SetUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/util/SetUtils.class */
public final class SetUtils {
    public static Set oneElementUnmodifiableSet(final Object obj) {
        return new AbstractSet() { // from class: com.mchange.v1.util.SetUtils.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator iterator() {
                return IteratorUtils.oneElementUnmodifiableIterator(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return 1;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj2) {
                return obj2 == obj;
            }
        };
    }

    public static Set setFromArray(Object[] objArr) {
        HashSet hashSet = new HashSet();
        for (Object obj : objArr) {
            hashSet.add(obj);
        }
        return hashSet;
    }

    public static boolean equivalentDisregardingSort(Set set, Set set2) {
        return set.containsAll(set2) && set2.containsAll(set);
    }

    public static int hashContentsDisregardingSort(Set set) {
        int i = 0;
        for (Object obj : set) {
            if (obj != null) {
                i ^= obj.hashCode();
            }
        }
        return i;
    }
}
