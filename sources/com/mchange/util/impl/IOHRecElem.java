package com.mchange.util.impl;

/* compiled from: IntObjectHash.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mchange/util/impl/IOHRecElem.class */
public class IOHRecElem {
    int num;
    Object obj;
    IOHRecElem next;

    /* access modifiers changed from: package-private */
    public IOHRecElem(int i, Object obj, IOHRecElem iOHRecElem) {
        this.num = i;
        this.obj = obj;
        this.next = iOHRecElem;
    }
}
