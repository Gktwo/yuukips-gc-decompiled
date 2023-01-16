package p013io.netty.buffer;

/* renamed from: io.netty.buffer.PoolSubpageMetric */
/* loaded from: grasscutter.jar:io/netty/buffer/PoolSubpageMetric.class */
public interface PoolSubpageMetric {
    int maxNumElements();

    int numAvailable();

    int elementSize();

    int pageSize();
}
