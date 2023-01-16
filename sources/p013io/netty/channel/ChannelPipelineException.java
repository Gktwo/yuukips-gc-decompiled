package p013io.netty.channel;

/* renamed from: io.netty.channel.ChannelPipelineException */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelPipelineException.class */
public class ChannelPipelineException extends ChannelException {
    private static final long serialVersionUID = 3379174210419885980L;

    public ChannelPipelineException() {
    }

    public ChannelPipelineException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChannelPipelineException(String message) {
        super(message);
    }

    public ChannelPipelineException(Throwable cause) {
        super(cause);
    }
}
