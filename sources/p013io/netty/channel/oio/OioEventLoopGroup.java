package p013io.netty.channel.oio;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import p013io.netty.channel.ThreadPerChannelEventLoopGroup;

@Deprecated
/* renamed from: io.netty.channel.oio.OioEventLoopGroup */
/* loaded from: grasscutter.jar:io/netty/channel/oio/OioEventLoopGroup.class */
public class OioEventLoopGroup extends ThreadPerChannelEventLoopGroup {
    public OioEventLoopGroup() {
        this(0);
    }

    public OioEventLoopGroup(int maxChannels) {
        this(maxChannels, (ThreadFactory) null);
    }

    public OioEventLoopGroup(int maxChannels, Executor executor) {
        super(maxChannels, executor, new Object[0]);
    }

    public OioEventLoopGroup(int maxChannels, ThreadFactory threadFactory) {
        super(maxChannels, threadFactory, new Object[0]);
    }
}
