package p013io.netty.handler.ssl;

import javax.net.ssl.SSLException;

/* renamed from: io.netty.handler.ssl.NotSslRecordException */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/NotSslRecordException.class */
public class NotSslRecordException extends SSLException {
    private static final long serialVersionUID = -4316784434770656841L;

    public NotSslRecordException() {
        super("");
    }

    public NotSslRecordException(String message) {
        super(message);
    }

    public NotSslRecordException(Throwable cause) {
        super(cause);
    }

    public NotSslRecordException(String message, Throwable cause) {
        super(message, cause);
    }
}
