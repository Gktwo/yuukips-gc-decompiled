package p013io.netty.channel.pool;

import p013io.netty.channel.Channel;

/* renamed from: io.netty.channel.pool.AbstractChannelPoolHandler */
/* loaded from: grasscutter.jar:io/netty/channel/pool/AbstractChannelPoolHandler.class */
public abstract class AbstractChannelPoolHandler implements ChannelPoolHandler {
    @Override // p013io.netty.channel.pool.ChannelPoolHandler
    public void channelAcquired(Channel ch) throws Exception {
    }

    @Override // p013io.netty.channel.pool.ChannelPoolHandler
    public void channelReleased(Channel ch) throws Exception {
    }
}
