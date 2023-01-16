package p013io.netty.channel;

import java.nio.channels.ClosedChannelException;
import p013io.netty.util.internal.ThrowableUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.StacklessClosedChannelException */
/* loaded from: grasscutter.jar:io/netty/channel/StacklessClosedChannelException.class */
public final class StacklessClosedChannelException extends ClosedChannelException {
    private static final long serialVersionUID = -2214806025529435136L;

    private StacklessClosedChannelException() {
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public static StacklessClosedChannelException newInstance(Class<?> clazz, String method) {
        return (StacklessClosedChannelException) ThrowableUtil.unknownStackTrace(new StacklessClosedChannelException(), clazz, method);
    }
}
