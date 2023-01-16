package p013io.netty.handler.codec;

/* renamed from: io.netty.handler.codec.TooLongFrameException */
/* loaded from: grasscutter.jar:io/netty/handler/codec/TooLongFrameException.class */
public class TooLongFrameException extends DecoderException {
    private static final long serialVersionUID = -1995801950698951640L;

    public TooLongFrameException() {
    }

    public TooLongFrameException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooLongFrameException(String message) {
        super(message);
    }

    public TooLongFrameException(Throwable cause) {
        super(cause);
    }
}
