package p013io.netty.handler.timeout;

import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.handler.timeout.ReadTimeoutException */
/* loaded from: grasscutter.jar:io/netty/handler/timeout/ReadTimeoutException.class */
public final class ReadTimeoutException extends TimeoutException {
    private static final long serialVersionUID = 169287984113283421L;
    public static final ReadTimeoutException INSTANCE;

    static {
        INSTANCE = PlatformDependent.javaVersion() >= 7 ? new ReadTimeoutException(true) : new ReadTimeoutException();
    }

    public ReadTimeoutException() {
    }

    public ReadTimeoutException(String message) {
        super(message, false);
    }

    private ReadTimeoutException(boolean shared) {
        super(null, shared);
    }
}
