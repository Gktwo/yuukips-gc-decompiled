package com.mchange.p009v2.util;

import com.mchange.p009v2.lang.VersionUtils;

/* renamed from: com.mchange.v2.util.ResourceClosedException */
/* loaded from: grasscutter.jar:com/mchange/v2/util/ResourceClosedException.class */
public class ResourceClosedException extends RuntimeException {
    Throwable rootCause;

    public ResourceClosedException(String str, Throwable th) {
        super(str);
        setRootCause(th);
    }

    public ResourceClosedException(Throwable th) {
        setRootCause(th);
    }

    public ResourceClosedException(String str) {
        super(str);
    }

    public ResourceClosedException() {
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.rootCause;
    }

    private void setRootCause(Throwable th) {
        this.rootCause = th;
        if (VersionUtils.isAtLeastJavaVersion14()) {
            initCause(th);
        }
    }
}
