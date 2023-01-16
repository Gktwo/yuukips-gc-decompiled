package p013io.netty.handler.ssl;

import javax.net.ssl.SSLHandshakeException;

/* renamed from: io.netty.handler.ssl.SslHandshakeTimeoutException */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SslHandshakeTimeoutException.class */
public final class SslHandshakeTimeoutException extends SSLHandshakeException {
    /* access modifiers changed from: package-private */
    public SslHandshakeTimeoutException(String reason) {
        super(reason);
    }
}
