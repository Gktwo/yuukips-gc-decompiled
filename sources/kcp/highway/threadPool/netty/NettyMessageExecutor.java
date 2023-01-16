package kcp.highway.threadPool.netty;

import kcp.highway.threadPool.IMessageExecutor;
import kcp.highway.threadPool.ITask;
import p013io.netty.channel.EventLoop;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/netty/NettyMessageExecutor.class */
public class NettyMessageExecutor implements IMessageExecutor {
    private EventLoop eventLoop;

    public NettyMessageExecutor(EventLoop eventLoop) {
        this.eventLoop = eventLoop;
    }

    @Override // kcp.highway.threadPool.IMessageExecutor
    public void stop() {
    }

    @Override // kcp.highway.threadPool.IMessageExecutor
    public boolean isFull() {
        return false;
    }

    @Override // kcp.highway.threadPool.IMessageExecutor
    public void execute(ITask iTask) {
        this.eventLoop.execute(() -> {
            iTask.execute();
        });
    }
}
