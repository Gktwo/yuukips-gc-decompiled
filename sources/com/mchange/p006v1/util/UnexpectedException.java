package com.mchange.p006v1.util;

import com.mchange.lang.PotentiallySecondaryRuntimeException;

/* renamed from: com.mchange.v1.util.UnexpectedException */
/* loaded from: grasscutter.jar:com/mchange/v1/util/UnexpectedException.class */
public class UnexpectedException extends PotentiallySecondaryRuntimeException {
    public UnexpectedException(String str, Throwable th) {
        super(str, th);
    }

    public UnexpectedException(Throwable th) {
        super(th);
    }

    public UnexpectedException(String str) {
        super(str);
    }

    public UnexpectedException() {
    }

    public UnexpectedException(Throwable th, String str) {
        this(str, th);
    }
}
