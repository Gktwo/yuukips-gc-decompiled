package p013io.netty.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p013io.netty.util.internal.StringUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.PoolChunkList */
/* loaded from: grasscutter.jar:io/netty/buffer/PoolChunkList.class */
public final class PoolChunkList<T> implements PoolChunkListMetric {
    private static final Iterator<PoolChunkMetric> EMPTY_METRICS;
    private final PoolArena<T> arena;
    private final PoolChunkList<T> nextList;
    private final int minUsage;
    private final int maxUsage;
    private final int maxCapacity;
    private PoolChunk<T> head;
    private final int freeMinThreshold;
    private final int freeMaxThreshold;
    private PoolChunkList<T> prevList;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !PoolChunkList.class.desiredAssertionStatus();
        EMPTY_METRICS = Collections.emptyList().iterator();
    }

    /* access modifiers changed from: package-private */
    public PoolChunkList(PoolArena<T> arena, PoolChunkList<T> nextList, int minUsage, int maxUsage, int chunkSize) {
        if ($assertionsDisabled || minUsage <= maxUsage) {
            this.arena = arena;
            this.nextList = nextList;
            this.minUsage = minUsage;
            this.maxUsage = maxUsage;
            this.maxCapacity = calculateMaxCapacity(minUsage, chunkSize);
            this.freeMinThreshold = maxUsage == 100 ? 0 : (int) ((((double) chunkSize) * ((100.0d - ((double) maxUsage)) + 0.99999999d)) / 100.0d);
            this.freeMaxThreshold = minUsage == 100 ? 0 : (int) ((((double) chunkSize) * ((100.0d - ((double) minUsage)) + 0.99999999d)) / 100.0d);
            return;
        }
        throw new AssertionError();
    }

    private static int calculateMaxCapacity(int minUsage, int chunkSize) {
        int minUsage2 = minUsage0(minUsage);
        if (minUsage2 == 100) {
            return 0;
        }
        return (int) ((((long) chunkSize) * (100 - ((long) minUsage2))) / 100);
    }

    /* access modifiers changed from: package-private */
    public void prevList(PoolChunkList<T> prevList) {
        if ($assertionsDisabled || this.prevList == null) {
            this.prevList = prevList;
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public boolean allocate(PooledByteBuf<T> buf, int reqCapacity, int sizeIdx, PoolThreadCache threadCache) {
        if (this.arena.sizeIdx2size(sizeIdx) > this.maxCapacity) {
            return false;
        }
        for (PoolChunk<T> cur = this.head; cur != null; cur = cur.next) {
            if (cur.allocate(buf, reqCapacity, sizeIdx, threadCache)) {
                if (cur.freeBytes > this.freeMinThreshold) {
                    return true;
                } else {
                    remove(cur);
                    this.nextList.add(cur);
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean free(PoolChunk<T> chunk, long handle, int normCapacity, ByteBuffer nioBuffer) {
        chunk.free(handle, normCapacity, nioBuffer);
        if (chunk.freeBytes <= this.freeMaxThreshold) {
            return true;
        }
        remove(chunk);
        return move0(chunk);
    }

    private boolean move(PoolChunk<T> chunk) {
        if (!$assertionsDisabled && chunk.usage() >= this.maxUsage) {
            throw new AssertionError();
        } else if (chunk.freeBytes > this.freeMaxThreshold) {
            return move0(chunk);
        } else {
            add0(chunk);
            return true;
        }
    }

    private boolean move0(PoolChunk<T> chunk) {
        if (this.prevList != null) {
            return this.prevList.move(chunk);
        }
        if ($assertionsDisabled || chunk.usage() == 0) {
            return false;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void add(PoolChunk<T> chunk) {
        if (chunk.freeBytes <= this.freeMinThreshold) {
            this.nextList.add(chunk);
        } else {
            add0(chunk);
        }
    }

    void add0(PoolChunk<T> chunk) {
        chunk.parent = this;
        if (this.head == null) {
            this.head = chunk;
            chunk.prev = null;
            chunk.next = null;
            return;
        }
        chunk.prev = null;
        chunk.next = this.head;
        this.head.prev = chunk;
        this.head = chunk;
    }

    private void remove(PoolChunk<T> cur) {
        if (cur == this.head) {
            this.head = cur.next;
            if (this.head != null) {
                this.head.prev = null;
                return;
            }
            return;
        }
        PoolChunk<T> next = cur.next;
        cur.prev.next = next;
        if (next != null) {
            next.prev = cur.prev;
        }
    }

    @Override // p013io.netty.buffer.PoolChunkListMetric
    public int minUsage() {
        return minUsage0(this.minUsage);
    }

    @Override // p013io.netty.buffer.PoolChunkListMetric
    public int maxUsage() {
        return Math.min(this.maxUsage, 100);
    }

    private static int minUsage0(int value) {
        return Math.max(1, value);
    }

    @Override // java.lang.Iterable
    public Iterator<PoolChunkMetric> iterator() {
        synchronized (this.arena) {
            if (this.head == null) {
                return EMPTY_METRICS;
            }
            List<PoolChunkMetric> metrics = new ArrayList<>();
            PoolChunk<T> cur = this.head;
            do {
                metrics.add(cur);
                cur = cur.next;
            } while (cur != null);
            return metrics.iterator();
        }
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder buf = new StringBuilder();
        synchronized (this.arena) {
            if (this.head == null) {
                return "none";
            }
            PoolChunk<T> cur = this.head;
            while (true) {
                buf.append(cur);
                cur = cur.next;
                if (cur == null) {
                    return buf.toString();
                }
                buf.append(StringUtil.NEWLINE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void destroy(PoolArena<T> arena) {
        for (PoolChunk<T> chunk = this.head; chunk != null; chunk = chunk.next) {
            arena.destroyChunk(chunk);
        }
        this.head = null;
    }
}
