package p013io.netty.channel.pool;

import p013io.netty.channel.Channel;

/* renamed from: io.netty.channel.pool.ChannelPoolHandler */
/* loaded from: grasscutter.jar:io/netty/channel/pool/ChannelPoolHandler.class */
public interface ChannelPoolHandler {
    void channelReleased(Channel channel) throws Exception;

    void channelAcquired(Channel channel) throws Exception;

    void channelCreated(Channel channel) throws Exception;
}
