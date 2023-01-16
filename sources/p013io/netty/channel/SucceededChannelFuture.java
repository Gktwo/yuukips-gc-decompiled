package p013io.netty.channel;

import p013io.netty.util.concurrent.EventExecutor;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.SucceededChannelFuture */
/* loaded from: grasscutter.jar:io/netty/channel/SucceededChannelFuture.class */
public final class SucceededChannelFuture extends CompleteChannelFuture {
    /* access modifiers changed from: package-private */
    public SucceededChannelFuture(Channel channel, EventExecutor executor) {
        super(channel, executor);
    }

    @Override // p013io.netty.util.concurrent.Future
    public Throwable cause() {
        return null;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return true;
    }
}
