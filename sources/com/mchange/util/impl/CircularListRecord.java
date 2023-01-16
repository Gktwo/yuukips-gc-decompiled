package com.mchange.util.impl;

/* compiled from: CircularList.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mchange/util/impl/CircularListRecord.class */
public class CircularListRecord {
    Object object;
    CircularListRecord next;
    CircularListRecord prev;

    /* access modifiers changed from: package-private */
    public CircularListRecord(Object obj, CircularListRecord circularListRecord, CircularListRecord circularListRecord2) {
        this.object = obj;
        this.prev = circularListRecord;
        this.next = circularListRecord2;
    }

    /* access modifiers changed from: package-private */
    public CircularListRecord(Object obj) {
        this.object = obj;
        this.prev = this;
        this.next = this;
    }
}
