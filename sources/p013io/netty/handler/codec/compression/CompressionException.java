package p013io.netty.handler.codec.compression;

import p013io.netty.handler.codec.EncoderException;

/* renamed from: io.netty.handler.codec.compression.CompressionException */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/CompressionException.class */
public class CompressionException extends EncoderException {
    private static final long serialVersionUID = 5603413481274811897L;

    public CompressionException() {
    }

    public CompressionException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompressionException(String message) {
        super(message);
    }

    public CompressionException(Throwable cause) {
        super(cause);
    }
}
