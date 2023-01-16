package p013io.netty.channel.pool;

import java.io.Closeable;
import p013io.netty.channel.Channel;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.Promise;

/* renamed from: io.netty.channel.pool.ChannelPool */
/* loaded from: grasscutter.jar:io/netty/channel/pool/ChannelPool.class */
public interface ChannelPool extends Closeable {
    Future<Channel> acquire();

    Future<Channel> acquire(Promise<Channel> promise);

    Future<Void> release(Channel channel);

    Future<Void> release(Channel channel, Promise<Void> promise);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
