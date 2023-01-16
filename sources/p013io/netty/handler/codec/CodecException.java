package p013io.netty.handler.codec;

/* renamed from: io.netty.handler.codec.CodecException */
/* loaded from: grasscutter.jar:io/netty/handler/codec/CodecException.class */
public class CodecException extends RuntimeException {
    private static final long serialVersionUID = -1464830400709348473L;

    public CodecException() {
    }

    public CodecException(String message, Throwable cause) {
        super(message, cause);
    }

    public CodecException(String message) {
        super(message);
    }

    public CodecException(Throwable cause) {
        super(cause);
    }
}
