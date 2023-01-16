package org.eclipse.jetty.p023io;

import java.io.EOFException;

/* renamed from: org.eclipse.jetty.io.EofException */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/EofException.class */
public class EofException extends EOFException implements QuietException {
    public EofException() {
    }

    public EofException(String reason) {
        super(reason);
    }

    public EofException(Throwable th) {
        if (th != null) {
            initCause(th);
        }
    }
}
