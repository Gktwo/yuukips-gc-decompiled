package p013io.netty.handler.ssl;

/* renamed from: io.netty.handler.ssl.SniCompletionEvent */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SniCompletionEvent.class */
public final class SniCompletionEvent extends SslCompletionEvent {
    private final String hostname;

    public SniCompletionEvent(String hostname) {
        this.hostname = hostname;
    }

    public SniCompletionEvent(String hostname, Throwable cause) {
        super(cause);
        this.hostname = hostname;
    }

    public SniCompletionEvent(Throwable cause) {
        this(null, cause);
    }

    public String hostname() {
        return this.hostname;
    }

    @Override // p013io.netty.handler.ssl.SslCompletionEvent
    public String toString() {
        Throwable cause = cause();
        return cause == null ? getClass().getSimpleName() + "(SUCCESS='" + this.hostname + "'\")" : getClass().getSimpleName() + '(' + cause + ')';
    }
}
