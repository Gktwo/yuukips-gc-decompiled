package p013io.netty.handler.timeout;

import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.handler.timeout.WriteTimeoutException */
/* loaded from: grasscutter.jar:io/netty/handler/timeout/WriteTimeoutException.class */
public final class WriteTimeoutException extends TimeoutException {
    private static final long serialVersionUID = -144786655770296065L;
    public static final WriteTimeoutException INSTANCE;

    static {
        INSTANCE = PlatformDependent.javaVersion() >= 7 ? new WriteTimeoutException(true) : new WriteTimeoutException();
    }

    public WriteTimeoutException() {
    }

    public WriteTimeoutException(String message) {
        super(message, false);
    }

    private WriteTimeoutException(boolean shared) {
        super(null, shared);
    }
}
