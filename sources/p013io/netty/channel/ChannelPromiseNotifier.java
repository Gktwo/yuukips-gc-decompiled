package p013io.netty.channel;

import p013io.netty.util.concurrent.PromiseNotifier;

@Deprecated
/* renamed from: io.netty.channel.ChannelPromiseNotifier */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelPromiseNotifier.class */
public final class ChannelPromiseNotifier extends PromiseNotifier<Void, ChannelFuture> implements ChannelFutureListener {
    public ChannelPromiseNotifier(ChannelPromise... promises) {
        super(promises);
    }

    public ChannelPromiseNotifier(boolean logNotifyFailure, ChannelPromise... promises) {
        super(logNotifyFailure, promises);
    }
}
