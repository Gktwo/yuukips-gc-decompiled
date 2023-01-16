package p013io.netty.channel;

/* renamed from: io.netty.channel.EventLoopException */
/* loaded from: grasscutter.jar:io/netty/channel/EventLoopException.class */
public class EventLoopException extends ChannelException {
    private static final long serialVersionUID = -8969100344583703616L;

    public EventLoopException() {
    }

    public EventLoopException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventLoopException(String message) {
        super(message);
    }

    public EventLoopException(Throwable cause) {
        super(cause);
    }
}
