package org.eclipse.jetty.util;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/LeakDetector.class */
public class LeakDetector<T> extends AbstractLifeCycle implements Runnable {
    private static final Logger LOG = Log.getLogger(LeakDetector.class);
    private final ReferenceQueue<T> queue = new ReferenceQueue<>();
    private final ConcurrentMap<String, LeakDetector<T>.LeakInfo> resources = new ConcurrentHashMap();
    private Thread thread;

    public boolean acquired(T resource) {
        String id = mo34id(resource);
        return this.resources.putIfAbsent(id, new LeakInfo(resource, id)) == null;
    }

    public boolean released(T resource) {
        return this.resources.remove(mo34id(resource)) != null;
    }

    /* renamed from: id */
    public String mo34id(T resource) {
        return String.valueOf(System.identityHashCode(resource));
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStart() throws Exception {
        doStart();
        this.thread = new Thread(this, getClass().getSimpleName());
        this.thread.setDaemon(true);
        this.thread.start();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws Exception {
        doStop();
        this.thread.interrupt();
    }

    @Override // java.lang.Runnable
    public void run() {
        while (isRunning()) {
            try {
                LeakDetector<T>.LeakInfo leakInfo = (LeakInfo) this.queue.remove();
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Resource GC'ed: {}", leakInfo);
                }
                if (this.resources.remove(((LeakInfo) leakInfo).f3159id) != null) {
                    leaked(leakInfo);
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    protected void leaked(LeakDetector<T>.LeakInfo leakInfo) {
        LOG.warn("Resource leaked: " + ((LeakInfo) leakInfo).description, ((LeakInfo) leakInfo).stackFrames);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/LeakDetector$LeakInfo.class */
    public class LeakInfo extends PhantomReference<T> {

        /* renamed from: id */
        private final String f3159id;
        private final String description;
        private final Throwable stackFrames;

        private LeakInfo(T referent, String id) {
            super(referent, LeakDetector.this.queue);
            this.f3159id = id;
            this.description = referent.toString();
            this.stackFrames = new Throwable();
        }

        public String getResourceDescription() {
            return this.description;
        }

        public Throwable getStackFrames() {
            return this.stackFrames;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.description;
        }
    }
}
