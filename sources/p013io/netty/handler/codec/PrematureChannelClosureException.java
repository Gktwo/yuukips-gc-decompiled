package p013io.netty.handler.codec;

/* renamed from: io.netty.handler.codec.PrematureChannelClosureException */
/* loaded from: grasscutter.jar:io/netty/handler/codec/PrematureChannelClosureException.class */
public class PrematureChannelClosureException extends CodecException {
    private static final long serialVersionUID = 4907642202594703094L;

    public PrematureChannelClosureException() {
    }

    public PrematureChannelClosureException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrematureChannelClosureException(String message) {
        super(message);
    }

    public PrematureChannelClosureException(Throwable cause) {
        super(cause);
    }
}
