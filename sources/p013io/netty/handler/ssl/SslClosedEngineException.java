package p013io.netty.handler.ssl;

import javax.net.ssl.SSLException;

/* renamed from: io.netty.handler.ssl.SslClosedEngineException */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SslClosedEngineException.class */
public final class SslClosedEngineException extends SSLException {
    private static final long serialVersionUID = -5204207600474401904L;

    public SslClosedEngineException(String reason) {
        super(reason);
    }
}
