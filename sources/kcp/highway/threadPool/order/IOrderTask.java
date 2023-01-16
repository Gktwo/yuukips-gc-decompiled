package kcp.highway.threadPool.order;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/order/IOrderTask.class */
public interface IOrderTask extends Runnable {
    OrderedThreadSession getSession();
}
