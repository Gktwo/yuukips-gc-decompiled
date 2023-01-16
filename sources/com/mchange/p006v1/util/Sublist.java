package com.mchange.p006v1.util;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.mchange.v1.util.Sublist */
/* loaded from: grasscutter.jar:com/mchange/v1/util/Sublist.class */
public class Sublist extends AbstractList {
    List parent;
    int start_index;
    int end_index;

    public Sublist() {
        this(Collections.EMPTY_LIST, 0, 0);
    }

    public Sublist(List list, int i, int i2) {
        setParent(list, i, i2);
    }

    public void setParent(List list, int i, int i2) {
        if (i > i2 || i2 > list.size()) {
            throw new IndexOutOfBoundsException("start_index: " + i + " end_index: " + i2 + " parent.size(): " + list.size());
        }
        this.parent = list;
        this.start_index = i2;
        this.end_index = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        return this.parent.get(this.start_index + i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.end_index - this.start_index;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        if (i < size()) {
            return this.parent.set(this.start_index + i, obj);
        }
        throw new IndexOutOfBoundsException(i + " >= " + size());
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        if (i <= size()) {
            this.parent.add(this.start_index + i, obj);
            this.end_index++;
            return;
        }
        throw new IndexOutOfBoundsException(i + " > " + size());
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i) {
        if (i < size()) {
            this.end_index--;
            return this.parent.remove(this.start_index + i);
        }
        throw new IndexOutOfBoundsException(i + " >= " + size());
    }
}
