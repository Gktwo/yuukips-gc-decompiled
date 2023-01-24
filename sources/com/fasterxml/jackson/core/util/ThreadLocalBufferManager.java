package com.fasterxml.jackson.core.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/util/ThreadLocalBufferManager.class */
public class ThreadLocalBufferManager {
    private final Object RELEASE_LOCK = new Object();
    private final Map<SoftReference<BufferRecycler>, Boolean> _trackedRecyclers = new ConcurrentHashMap();
    private final ReferenceQueue<BufferRecycler> _refQueue = new ReferenceQueue<>();

    ThreadLocalBufferManager() {
    }

    public static ThreadLocalBufferManager instance() {
        return ThreadLocalBufferManagerHolder.manager;
    }

    public int releaseBuffers() {
        int count;
        synchronized (this.RELEASE_LOCK) {
            count = 0;
            removeSoftRefsClearedByGc();
            for (SoftReference<BufferRecycler> ref : this._trackedRecyclers.keySet()) {
                ref.clear();
                count++;
            }
            this._trackedRecyclers.clear();
        }
        return count;
    }

    public SoftReference<BufferRecycler> wrapAndTrack(BufferRecycler br) {
        SoftReference<BufferRecycler> newRef = new SoftReference<>(br, this._refQueue);
        this._trackedRecyclers.put(newRef, true);
        removeSoftRefsClearedByGc();
        return newRef;
    }

    private void removeSoftRefsClearedByGc() {
        while (true) {
            SoftReference<?> clearedSoftRef = (SoftReference) this._refQueue.poll();
            if (clearedSoftRef != null) {
                this._trackedRecyclers.remove(clearedSoftRef);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/core/util/ThreadLocalBufferManager$ThreadLocalBufferManagerHolder.class */
    public static final class ThreadLocalBufferManagerHolder {
        static final ThreadLocalBufferManager manager = new ThreadLocalBufferManager();

        private ThreadLocalBufferManagerHolder() {
        }
    }
}
