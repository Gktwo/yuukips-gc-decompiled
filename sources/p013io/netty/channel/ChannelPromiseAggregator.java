package p013io.netty.channel;

import p013io.netty.util.concurrent.PromiseAggregator;

@Deprecated
/* renamed from: io.netty.channel.ChannelPromiseAggregator */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelPromiseAggregator.class */
public final class ChannelPromiseAggregator extends PromiseAggregator<Void, ChannelFuture> implements ChannelFutureListener {
    public ChannelPromiseAggregator(ChannelPromise aggregatePromise) {
        super(aggregatePromise);
    }
}
