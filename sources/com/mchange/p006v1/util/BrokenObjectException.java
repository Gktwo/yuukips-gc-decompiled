package com.mchange.p006v1.util;

/* renamed from: com.mchange.v1.util.BrokenObjectException */
/* loaded from: grasscutter.jar:com/mchange/v1/util/BrokenObjectException.class */
public class BrokenObjectException extends Exception {
    Object broken;

    public BrokenObjectException(Object obj, String str) {
        super(str);
        this.broken = obj;
    }

    public BrokenObjectException(Object obj) {
        this.broken = obj;
    }

    public Object getBrokenObject() {
        return this.broken;
    }
}
