package p013io.netty.buffer;

/* renamed from: io.netty.buffer.PoolChunkListMetric */
/* loaded from: grasscutter.jar:io/netty/buffer/PoolChunkListMetric.class */
public interface PoolChunkListMetric extends Iterable<PoolChunkMetric> {
    int minUsage();

    int maxUsage();
}
