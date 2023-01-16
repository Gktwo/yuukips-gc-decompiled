package p013io.netty.channel;

import java.nio.channels.ClosedChannelException;

/* renamed from: io.netty.channel.ExtendedClosedChannelException */
/* loaded from: grasscutter.jar:io/netty/channel/ExtendedClosedChannelException.class */
final class ExtendedClosedChannelException extends ClosedChannelException {
    ExtendedClosedChannelException(Throwable cause) {
        if (cause != null) {
            initCause(cause);
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
