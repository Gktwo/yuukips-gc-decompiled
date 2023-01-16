package org.eclipse.jetty.p023io;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.LeakDetector;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject
/* renamed from: org.eclipse.jetty.io.LeakTrackingByteBufferPool */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/LeakTrackingByteBufferPool.class */
public class LeakTrackingByteBufferPool extends ContainerLifeCycle implements ByteBufferPool {
    private static final Logger LOG = Log.getLogger(LeakTrackingByteBufferPool.class);
    private final LeakDetector<ByteBuffer> leakDetector = new LeakDetector<ByteBuffer>() { // from class: org.eclipse.jetty.io.LeakTrackingByteBufferPool.1
        /* renamed from: id */
        public String mo34id(ByteBuffer resource) {
            return BufferUtil.toIDString(resource);
        }

        @Override // org.eclipse.jetty.util.LeakDetector
        protected void leaked(LeakDetector<ByteBuffer>.LeakInfo leakInfo) {
            LeakTrackingByteBufferPool.this.leaked.incrementAndGet();
            LeakTrackingByteBufferPool.this.leaked(leakInfo);
        }
    };
    private final AtomicLong leakedAcquires = new AtomicLong(0);
    private final AtomicLong leakedReleases = new AtomicLong(0);
    private final AtomicLong leakedRemoves = new AtomicLong(0);
    private final AtomicLong leaked = new AtomicLong(0);
    private final ByteBufferPool delegate;

    public LeakTrackingByteBufferPool(ByteBufferPool delegate) {
        this.delegate = delegate;
        addBean(this.leakDetector);
        addBean(delegate);
    }

    @Override // org.eclipse.jetty.p023io.ByteBufferPool
    public ByteBuffer acquire(int size, boolean direct) {
        ByteBuffer buffer = this.delegate.acquire(size, direct);
        if (!this.leakDetector.acquired(buffer)) {
            this.leakedAcquires.incrementAndGet();
            if (LOG.isDebugEnabled()) {
                LOG.debug("ByteBuffer leaked acquire for id {}", this.leakDetector.mo34id(buffer), new Throwable("acquire"));
            }
        }
        return buffer;
    }

    @Override // org.eclipse.jetty.p023io.ByteBufferPool
    public void release(ByteBuffer buffer) {
        if (buffer != null) {
            if (!this.leakDetector.released(buffer)) {
                this.leakedReleases.incrementAndGet();
                if (LOG.isDebugEnabled()) {
                    LOG.debug("ByteBuffer leaked release for id {}", this.leakDetector.mo34id(buffer), new Throwable("release"));
                }
            }
            this.delegate.release(buffer);
        }
    }

    @Override // org.eclipse.jetty.p023io.ByteBufferPool
    public void remove(ByteBuffer buffer) {
        if (buffer != null) {
            if (!this.leakDetector.released(buffer)) {
                this.leakedRemoves.incrementAndGet();
                if (LOG.isDebugEnabled()) {
                    LOG.debug("ByteBuffer leaked remove for id {}", this.leakDetector.mo34id(buffer), new Throwable("remove"));
                }
            }
            this.delegate.remove(buffer);
        }
    }

    @ManagedAttribute("Clears the tracking data")
    public void clearTracking() {
        this.leakedAcquires.set(0);
        this.leakedReleases.set(0);
    }

    @ManagedAttribute("The number of acquires that produced a leak")
    public long getLeakedAcquires() {
        return this.leakedAcquires.get();
    }

    @ManagedAttribute("The number of releases that produced a leak")
    public long getLeakedReleases() {
        return this.leakedReleases.get();
    }

    @ManagedAttribute("The number of removes that produced a leak")
    public long getLeakedRemoves() {
        return this.leakedRemoves.get();
    }

    @ManagedAttribute("The number of resources that were leaked")
    public long getLeakedResources() {
        return this.leaked.get();
    }

    protected void leaked(LeakDetector<ByteBuffer>.LeakInfo leakInfo) {
        LOG.warn("ByteBuffer " + leakInfo.getResourceDescription() + " leaked at:", leakInfo.getStackFrames());
    }
}
