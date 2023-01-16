package p013io.netty.channel;

import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.FailedChannelFuture */
/* loaded from: grasscutter.jar:io/netty/channel/FailedChannelFuture.class */
public final class FailedChannelFuture extends CompleteChannelFuture {
    private final Throwable cause;

    /* access modifiers changed from: package-private */
    public FailedChannelFuture(Channel channel, EventExecutor executor, Throwable cause) {
        super(channel, executor);
        this.cause = (Throwable) ObjectUtil.checkNotNull(cause, "cause");
    }

    @Override // p013io.netty.util.concurrent.Future
    public Throwable cause() {
        return this.cause;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return false;
    }

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.channel.CompleteChannelFuture, p013io.netty.util.concurrent.CompleteFuture, p013io.netty.util.concurrent.Future
    public Future<Void> sync() {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.channel.CompleteChannelFuture, p013io.netty.util.concurrent.CompleteFuture, p013io.netty.util.concurrent.Future
    public Future<Void> syncUninterruptibly() {
        PlatformDependent.throwException(this.cause);
        return this;
    }
}
