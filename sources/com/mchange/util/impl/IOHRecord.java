package com.mchange.util.impl;

/* compiled from: IntObjectHash.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mchange/util/impl/IOHRecord.class */
public class IOHRecord extends IOHRecElem {
    IntObjectHash parent;
    int size = 0;

    /* access modifiers changed from: package-private */
    public IOHRecord(int i) {
        super(i, null, null);
    }

    /* access modifiers changed from: package-private */
    public IOHRecElem findInt(int i) {
        for (IOHRecElem iOHRecElem = this; iOHRecElem.next != null; iOHRecElem = iOHRecElem.next) {
            if (iOHRecElem.next.num == i) {
                return iOHRecElem;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean add(int i, Object obj, boolean z) {
        IOHRecElem findInt = findInt(i);
        if (findInt == null) {
            this.next = new IOHRecElem(i, obj, this.next);
            this.size++;
            return false;
        } else if (!z) {
            return true;
        } else {
            findInt.next = new IOHRecElem(i, obj, findInt.next.next);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public Object remove(int i) {
        IOHRecElem findInt = findInt(i);
        if (findInt == null) {
            return null;
        }
        Object obj = findInt.next.obj;
        findInt.next = findInt.next.next;
        this.size--;
        if (this.size == 0) {
            this.parent.records[this.num] = null;
        }
        return obj;
    }

    /* access modifiers changed from: package-private */
    public Object get(int i) {
        IOHRecElem findInt = findInt(i);
        if (findInt != null) {
            return findInt.next.obj;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [com.mchange.util.impl.IOHRecElem] */
    /* access modifiers changed from: package-private */
    public IOHRecord split(int i) {
        IOHRecord iOHRecord = null;
        IOHRecord iOHRecord2 = null;
        for (IOHRecElem iOHRecElem = this; iOHRecElem.next != null; iOHRecElem = iOHRecElem.next) {
            if (Math.abs(iOHRecElem.next.num % i) != this.num) {
                if (iOHRecord == null) {
                    iOHRecord = new IOHRecord(this.num * 2);
                    iOHRecord2 = iOHRecord;
                }
                iOHRecord2.next = iOHRecElem.next;
                iOHRecElem.next = iOHRecElem.next.next;
                iOHRecord2 = iOHRecord2.next;
                iOHRecord2.next = null;
            }
        }
        return iOHRecord;
    }
}
