package org.eclipse.jetty.util.compression;

import java.util.zip.Inflater;
import org.eclipse.jetty.util.component.Container;
import org.eclipse.jetty.util.thread.ThreadPool;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/compression/InflaterPool.class */
public class InflaterPool extends CompressionPool<Inflater> {
    private final boolean nowrap;

    public InflaterPool(int capacity, boolean nowrap) {
        super(capacity);
        this.nowrap = nowrap;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.compression.CompressionPool
    public Inflater newObject() {
        return new Inflater(this.nowrap);
    }

    /* access modifiers changed from: protected */
    public void end(Inflater inflater) {
        inflater.end();
    }

    /* access modifiers changed from: protected */
    public void reset(Inflater inflater) {
        inflater.reset();
    }

    public static InflaterPool ensurePool(Container container) {
        InflaterPool pool = (InflaterPool) container.getBean(InflaterPool.class);
        if (pool != null) {
            return pool;
        }
        int capacity = -1;
        ThreadPool.SizedThreadPool threadPool = (ThreadPool.SizedThreadPool) container.getBean(ThreadPool.SizedThreadPool.class);
        if (threadPool != null) {
            capacity = threadPool.getMaxThreads();
        }
        InflaterPool pool2 = new InflaterPool(capacity, true);
        container.addBean(pool2, true);
        return pool2;
    }
}
