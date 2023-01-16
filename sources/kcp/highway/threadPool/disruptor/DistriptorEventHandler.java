package kcp.highway.threadPool.disruptor;

import com.lmax.disruptor.EventHandler;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/disruptor/DistriptorEventHandler.class */
public class DistriptorEventHandler implements EventHandler<DistriptorHandler> {
    public void onEvent(DistriptorHandler event, long sequence, boolean endOfBatch) {
        event.execute();
    }
}
