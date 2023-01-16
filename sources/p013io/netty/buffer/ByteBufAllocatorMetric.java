package p013io.netty.buffer;

/* renamed from: io.netty.buffer.ByteBufAllocatorMetric */
/* loaded from: grasscutter.jar:io/netty/buffer/ByteBufAllocatorMetric.class */
public interface ByteBufAllocatorMetric {
    long usedHeapMemory();

    long usedDirectMemory();
}
