package org.eclipse.jetty.util.compression;

import java.util.zip.Deflater;
import org.eclipse.jetty.util.component.Container;
import org.eclipse.jetty.util.thread.ThreadPool;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/compression/DeflaterPool.class */
public class DeflaterPool extends CompressionPool<Deflater> {
    private final int compressionLevel;
    private final boolean nowrap;

    public DeflaterPool(int capacity, int compressionLevel, boolean nowrap) {
        super(capacity);
        this.compressionLevel = compressionLevel;
        this.nowrap = nowrap;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.compression.CompressionPool
    public Deflater newObject() {
        return new Deflater(this.compressionLevel, this.nowrap);
    }

    /* access modifiers changed from: protected */
    public void end(Deflater deflater) {
        deflater.end();
    }

    /* access modifiers changed from: protected */
    public void reset(Deflater deflater) {
        deflater.reset();
    }

    public static DeflaterPool ensurePool(Container container) {
        DeflaterPool pool = (DeflaterPool) container.getBean(DeflaterPool.class);
        if (pool != null) {
            return pool;
        }
        int capacity = -1;
        ThreadPool.SizedThreadPool threadPool = (ThreadPool.SizedThreadPool) container.getBean(ThreadPool.SizedThreadPool.class);
        if (threadPool != null) {
            capacity = threadPool.getMaxThreads();
        }
        DeflaterPool pool2 = new DeflaterPool(capacity, -1, true);
        container.addBean(pool2, true);
        return pool2;
    }
}
