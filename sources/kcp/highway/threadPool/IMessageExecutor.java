package kcp.highway.threadPool;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/IMessageExecutor.class */
public interface IMessageExecutor {
    void stop();

    boolean isFull();

    void execute(ITask iTask);
}
