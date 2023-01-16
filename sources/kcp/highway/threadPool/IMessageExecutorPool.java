package kcp.highway.threadPool;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/IMessageExecutorPool.class */
public interface IMessageExecutorPool {
    IMessageExecutor getIMessageExecutor();

    void stop();
}
