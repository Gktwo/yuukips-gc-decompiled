package kcp.highway.erasure.fec;

import java.util.ArrayList;

/* loaded from: grasscutter.jar:kcp/highway/erasure/fec/MyArrayList.class */
public class MyArrayList<E> extends ArrayList<E> {
    public MyArrayList() {
    }

    public MyArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    public void removeRange(int fromIndex, int toIndex) {
        removeRange(fromIndex, toIndex);
    }
}
