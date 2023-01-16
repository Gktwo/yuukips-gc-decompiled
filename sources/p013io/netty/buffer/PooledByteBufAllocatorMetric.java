package p013io.netty.buffer;

import java.util.List;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.buffer.PooledByteBufAllocatorMetric */
/* loaded from: grasscutter.jar:io/netty/buffer/PooledByteBufAllocatorMetric.class */
public final class PooledByteBufAllocatorMetric implements ByteBufAllocatorMetric {
    private final PooledByteBufAllocator allocator;

    /* access modifiers changed from: package-private */
    public PooledByteBufAllocatorMetric(PooledByteBufAllocator allocator) {
        this.allocator = allocator;
    }

    public int numHeapArenas() {
        return this.allocator.numHeapArenas();
    }

    public int numDirectArenas() {
        return this.allocator.numDirectArenas();
    }

    public List<PoolArenaMetric> heapArenas() {
        return this.allocator.heapArenas();
    }

    public List<PoolArenaMetric> directArenas() {
        return this.allocator.directArenas();
    }

    public int numThreadLocalCaches() {
        return this.allocator.numThreadLocalCaches();
    }

    @Deprecated
    public int tinyCacheSize() {
        return this.allocator.tinyCacheSize();
    }

    public int smallCacheSize() {
        return this.allocator.smallCacheSize();
    }

    public int normalCacheSize() {
        return this.allocator.normalCacheSize();
    }

    public int chunkSize() {
        return this.allocator.chunkSize();
    }

    @Override // p013io.netty.buffer.ByteBufAllocatorMetric
    public long usedHeapMemory() {
        return this.allocator.usedHeapMemory();
    }

    @Override // p013io.netty.buffer.ByteBufAllocatorMetric
    public long usedDirectMemory() {
        return this.allocator.usedDirectMemory();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append(StringUtil.simpleClassName(this)).append("(usedHeapMemory: ").append(usedHeapMemory()).append("; usedDirectMemory: ").append(usedDirectMemory()).append("; numHeapArenas: ").append(numHeapArenas()).append("; numDirectArenas: ").append(numDirectArenas()).append("; smallCacheSize: ").append(smallCacheSize()).append("; normalCacheSize: ").append(normalCacheSize()).append("; numThreadLocalCaches: ").append(numThreadLocalCaches()).append("; chunkSize: ").append(chunkSize()).append(')');
        return sb.toString();
    }
}
