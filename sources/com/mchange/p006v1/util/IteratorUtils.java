package com.mchange.p006v1.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.mchange.v1.util.IteratorUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/util/IteratorUtils.class */
public final class IteratorUtils {
    public static final Iterator EMPTY_ITERATOR = new Iterator() { // from class: com.mchange.v1.util.IteratorUtils.1
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    };

    public static Iterator oneElementUnmodifiableIterator(final Object obj) {
        return new Iterator() { // from class: com.mchange.v1.util.IteratorUtils.2
            boolean shot = false;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.shot;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (this.shot) {
                    throw new NoSuchElementException();
                }
                this.shot = true;
                return obj;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove() not supported.");
            }
        };
    }

    public static boolean equivalent(Iterator it, Iterator it2) {
        while (true) {
            boolean hasNext = it.hasNext();
            if (hasNext ^ it2.hasNext()) {
                return false;
            }
            if (!hasNext) {
                return true;
            }
            Object next = it.next();
            Object next2 = it2.next();
            if (next != next2 && (next == null || !next.equals(next2))) {
                return false;
            }
        }
    }

    public static ArrayList toArrayList(Iterator it, int i) {
        ArrayList arrayList = new ArrayList(i);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static void fillArray(Iterator it, Object[] objArr, boolean z) {
        int i = 0;
        int length = objArr.length;
        while (i < length && it.hasNext()) {
            i++;
            objArr[i] = it.next();
        }
        if (z && i < length) {
            objArr[i] = null;
        }
    }

    public static void fillArray(Iterator it, Object[] objArr) {
        fillArray(it, objArr, false);
    }

    public static Object[] toArray(Iterator it, int i, Class cls, boolean z) {
        Object[] objArr = (Object[]) Array.newInstance(cls, i);
        fillArray(it, objArr, z);
        return objArr;
    }

    public static Object[] toArray(Iterator it, int i, Class cls) {
        return toArray(it, i, cls, false);
    }

    public static Object[] toArray(Iterator it, int i, Object[] objArr) {
        if (objArr.length < i) {
            return toArray(it, i, objArr.getClass().getComponentType());
        }
        fillArray(it, objArr, true);
        return objArr;
    }

    private IteratorUtils() {
    }
}
