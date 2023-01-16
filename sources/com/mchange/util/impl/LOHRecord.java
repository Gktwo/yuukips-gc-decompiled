package com.mchange.util.impl;

/* compiled from: LongObjectHash.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mchange/util/impl/LOHRecord.class */
public class LOHRecord extends LOHRecElem {
    LongObjectHash parent;
    int size = 0;

    /* access modifiers changed from: package-private */
    public LOHRecord(long j) {
        super(j, null, null);
    }

    /* access modifiers changed from: package-private */
    public LOHRecElem findLong(long j) {
        for (LOHRecElem lOHRecElem = this; lOHRecElem.next != null; lOHRecElem = lOHRecElem.next) {
            if (lOHRecElem.next.num == j) {
                return lOHRecElem;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean add(long j, Object obj, boolean z) {
        LOHRecElem findLong = findLong(j);
        if (findLong == null) {
            this.next = new LOHRecElem(j, obj, this.next);
            this.size++;
            return false;
        } else if (!z) {
            return true;
        } else {
            findLong.next = new LOHRecElem(j, obj, findLong.next.next);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public Object remove(long j) {
        LOHRecElem findLong = findLong(j);
        if (findLong == null) {
            return null;
        }
        Object obj = findLong.next.obj;
        findLong.next = findLong.next.next;
        this.size--;
        if (this.size == 0) {
            this.parent.records[(int) this.num] = null;
        }
        return obj;
    }

    /* access modifiers changed from: package-private */
    public Object get(long j) {
        LOHRecElem findLong = findLong(j);
        if (findLong != null) {
            return findLong.next.obj;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [com.mchange.util.impl.LOHRecElem] */
    /* access modifiers changed from: package-private */
    public LOHRecord split(int i) {
        LOHRecord lOHRecord = null;
        LOHRecord lOHRecord2 = null;
        for (LOHRecElem lOHRecElem = this; lOHRecElem.next != null; lOHRecElem = lOHRecElem.next) {
            if (lOHRecElem.next.num % ((long) i) != this.num) {
                if (lOHRecord == null) {
                    lOHRecord = new LOHRecord(this.num * 2);
                    lOHRecord2 = lOHRecord;
                }
                lOHRecord2.next = lOHRecElem.next;
                lOHRecElem.next = lOHRecElem.next.next;
                lOHRecord2 = lOHRecord2.next;
                lOHRecord2.next = null;
            }
        }
        return lOHRecord;
    }
}
