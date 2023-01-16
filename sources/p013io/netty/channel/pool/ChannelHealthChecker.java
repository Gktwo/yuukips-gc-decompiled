package p013io.netty.channel.pool;

import p013io.netty.channel.Channel;
import p013io.netty.channel.EventLoop;
import p013io.netty.util.concurrent.Future;

/* renamed from: io.netty.channel.pool.ChannelHealthChecker */
/* loaded from: grasscutter.jar:io/netty/channel/pool/ChannelHealthChecker.class */
public interface ChannelHealthChecker {
    public static final ChannelHealthChecker ACTIVE = new ChannelHealthChecker() { // from class: io.netty.channel.pool.ChannelHealthChecker.1
        @Override // p013io.netty.channel.pool.ChannelHealthChecker
        public Future<Boolean> isHealthy(Channel channel) {
            EventLoop loop = channel.eventLoop();
            return channel.isActive() ? loop.newSucceededFuture(Boolean.TRUE) : loop.newSucceededFuture(Boolean.FALSE);
        }
    };

    Future<Boolean> isHealthy(Channel channel);
}
