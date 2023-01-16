package p013io.netty.handler.ssl;

/* renamed from: io.netty.handler.ssl.SslHandshakeCompletionEvent */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SslHandshakeCompletionEvent.class */
public final class SslHandshakeCompletionEvent extends SslCompletionEvent {
    public static final SslHandshakeCompletionEvent SUCCESS = new SslHandshakeCompletionEvent();

    private SslHandshakeCompletionEvent() {
    }

    public SslHandshakeCompletionEvent(Throwable cause) {
        super(cause);
    }
}
