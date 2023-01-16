package p013io.netty.handler.timeout;

import p013io.netty.channel.ChannelException;

/* renamed from: io.netty.handler.timeout.TimeoutException */
/* loaded from: grasscutter.jar:io/netty/handler/timeout/TimeoutException.class */
public class TimeoutException extends ChannelException {
    private static final long serialVersionUID = 4673641882869672533L;

    /* access modifiers changed from: package-private */
    public TimeoutException() {
    }

    /* access modifiers changed from: package-private */
    public TimeoutException(String message, boolean shared) {
        super(message, null, shared);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
