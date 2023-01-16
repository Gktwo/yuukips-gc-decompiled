package com.mchange.util.impl;

/* compiled from: LongObjectHash.java */
/* loaded from: grasscutter.jar:com/mchange/util/impl/LOHRecElem.class */
class LOHRecElem {
    long num;
    Object obj;
    LOHRecElem next;

    /* access modifiers changed from: package-private */
    public LOHRecElem(long j, Object obj, LOHRecElem lOHRecElem) {
        this.num = j;
        this.obj = obj;
        this.next = lOHRecElem;
    }
}
