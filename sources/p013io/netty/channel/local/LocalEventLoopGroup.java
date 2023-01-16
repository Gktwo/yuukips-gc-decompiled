package p013io.netty.channel.local;

import java.util.concurrent.ThreadFactory;
import p013io.netty.channel.DefaultEventLoopGroup;

@Deprecated
/* renamed from: io.netty.channel.local.LocalEventLoopGroup */
/* loaded from: grasscutter.jar:io/netty/channel/local/LocalEventLoopGroup.class */
public class LocalEventLoopGroup extends DefaultEventLoopGroup {
    public LocalEventLoopGroup() {
    }

    public LocalEventLoopGroup(int nThreads) {
        super(nThreads);
    }

    public LocalEventLoopGroup(ThreadFactory threadFactory) {
        super(0, threadFactory);
    }

    public LocalEventLoopGroup(int nThreads, ThreadFactory threadFactory) {
        super(nThreads, threadFactory);
    }
}
