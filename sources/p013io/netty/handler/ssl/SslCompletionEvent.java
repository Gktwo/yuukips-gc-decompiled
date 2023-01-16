package p013io.netty.handler.ssl;

import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.ssl.SslCompletionEvent */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SslCompletionEvent.class */
public abstract class SslCompletionEvent {
    private final Throwable cause;

    /* access modifiers changed from: package-private */
    public SslCompletionEvent() {
        this.cause = null;
    }

    /* access modifiers changed from: package-private */
    public SslCompletionEvent(Throwable cause) {
        this.cause = (Throwable) ObjectUtil.checkNotNull(cause, "cause");
    }

    public final boolean isSuccess() {
        return this.cause == null;
    }

    public final Throwable cause() {
        return this.cause;
    }

    public String toString() {
        Throwable cause = cause();
        return cause == null ? getClass().getSimpleName() + "(SUCCESS)" : getClass().getSimpleName() + '(' + cause + ')';
    }
}
