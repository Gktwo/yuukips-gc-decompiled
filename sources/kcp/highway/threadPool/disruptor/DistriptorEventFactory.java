package kcp.highway.threadPool.disruptor;

import com.lmax.disruptor.EventFactory;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/disruptor/DistriptorEventFactory.class */
public class DistriptorEventFactory implements EventFactory<DistriptorHandler> {
    @Override // com.lmax.disruptor.EventFactory
    public DistriptorHandler newInstance() {
        return new DistriptorHandler();
    }
}
