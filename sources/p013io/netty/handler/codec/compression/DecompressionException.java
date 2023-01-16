package p013io.netty.handler.codec.compression;

import p013io.netty.handler.codec.DecoderException;

/* renamed from: io.netty.handler.codec.compression.DecompressionException */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/DecompressionException.class */
public class DecompressionException extends DecoderException {
    private static final long serialVersionUID = 3546272712208105199L;

    public DecompressionException() {
    }

    public DecompressionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DecompressionException(String message) {
        super(message);
    }

    public DecompressionException(Throwable cause) {
        super(cause);
    }
}
