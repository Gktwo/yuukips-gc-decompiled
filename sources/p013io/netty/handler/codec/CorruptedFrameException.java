package p013io.netty.handler.codec;

/* renamed from: io.netty.handler.codec.CorruptedFrameException */
/* loaded from: grasscutter.jar:io/netty/handler/codec/CorruptedFrameException.class */
public class CorruptedFrameException extends DecoderException {
    private static final long serialVersionUID = 3918052232492988408L;

    public CorruptedFrameException() {
    }

    public CorruptedFrameException(String message, Throwable cause) {
        super(message, cause);
    }

    public CorruptedFrameException(String message) {
        super(message);
    }

    public CorruptedFrameException(Throwable cause) {
        super(cause);
    }
}
