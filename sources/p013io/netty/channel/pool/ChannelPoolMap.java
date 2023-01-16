package p013io.netty.channel.pool;

import p013io.netty.channel.pool.ChannelPool;

/* renamed from: io.netty.channel.pool.ChannelPoolMap */
/* loaded from: grasscutter.jar:io/netty/channel/pool/ChannelPoolMap.class */
public interface ChannelPoolMap<K, P extends ChannelPool> {
    P get(K k);

    boolean contains(K k);
}
