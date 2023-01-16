package org.eclipse.jetty.p023io;

import java.nio.ByteBuffer;
import org.eclipse.jetty.util.BufferUtil;

/* renamed from: org.eclipse.jetty.io.NullByteBufferPool */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/NullByteBufferPool.class */
public class NullByteBufferPool implements ByteBufferPool {
    @Override // org.eclipse.jetty.p023io.ByteBufferPool
    public ByteBuffer acquire(int size, boolean direct) {
        if (direct) {
            return BufferUtil.allocateDirect(size);
        }
        return BufferUtil.allocate(size);
    }

    @Override // org.eclipse.jetty.p023io.ByteBufferPool
    public void release(ByteBuffer buffer) {
        BufferUtil.clear(buffer);
    }
}
