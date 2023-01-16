package com.mchange.p006v1.util;

import com.mchange.lang.PotentiallySecondaryException;

/* renamed from: com.mchange.v1.util.UnreliableIteratorException */
/* loaded from: grasscutter.jar:com/mchange/v1/util/UnreliableIteratorException.class */
public class UnreliableIteratorException extends PotentiallySecondaryException {
    public UnreliableIteratorException(String str, Throwable th) {
        super(str, th);
    }

    public UnreliableIteratorException(Throwable th) {
        super(th);
    }

    public UnreliableIteratorException(String str) {
        super(str);
    }

    public UnreliableIteratorException() {
    }
}
