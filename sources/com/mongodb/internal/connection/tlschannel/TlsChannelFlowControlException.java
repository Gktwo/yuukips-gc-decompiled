package com.mongodb.internal.connection.tlschannel;

import java.io.IOException;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/TlsChannelFlowControlException.class */
public abstract class TlsChannelFlowControlException extends IOException {
    private static final long serialVersionUID = -2394919487958591959L;

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
