package p013io.netty.buffer;

/* renamed from: io.netty.buffer.PoolChunkMetric */
/* loaded from: grasscutter.jar:io/netty/buffer/PoolChunkMetric.class */
public interface PoolChunkMetric {
    int usage();

    int chunkSize();

    int freeBytes();
}
