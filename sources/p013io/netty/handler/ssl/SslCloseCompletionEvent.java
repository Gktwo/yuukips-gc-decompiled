package p013io.netty.handler.ssl;

/* renamed from: io.netty.handler.ssl.SslCloseCompletionEvent */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SslCloseCompletionEvent.class */
public final class SslCloseCompletionEvent extends SslCompletionEvent {
    public static final SslCloseCompletionEvent SUCCESS = new SslCloseCompletionEvent();

    private SslCloseCompletionEvent() {
    }

    public SslCloseCompletionEvent(Throwable cause) {
        super(cause);
    }
}
