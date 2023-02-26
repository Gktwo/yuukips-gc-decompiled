package p013io.netty.util;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jline.builtins.TTop;
import p013io.netty.util.concurrent.FastThreadLocal;
import p013io.netty.util.internal.ObjectPool;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;
import p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;

/* renamed from: io.netty.util.Recycler */
/* loaded from: grasscutter.jar:io/netty/util/Recycler.class */
public abstract class Recycler<T> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Recycler.class);
    private static final Handle<?> NOOP_HANDLE = new Handle<Object>() { // from class: io.netty.util.Recycler.1
        @Override // p013io.netty.util.internal.ObjectPool.Handle
        public void recycle(Object object) {
        }

        public String toString() {
            return "NOOP_HANDLE";
        }
    };
    private static final int DEFAULT_INITIAL_MAX_CAPACITY_PER_THREAD = 4096;
    private static final int DEFAULT_MAX_CAPACITY_PER_THREAD;
    private static final int RATIO;
    private static final int DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD;
    private static final boolean BLOCKING_POOL;
    private final int maxCapacityPerThread;
    private final int interval;
    private final int chunkSize;
    private final FastThreadLocal<LocalPool<T>> threadLocal;

    /* renamed from: io.netty.util.Recycler$Handle */
    /* loaded from: grasscutter.jar:io/netty/util/Recycler$Handle.class */
    public interface Handle<T> extends ObjectPool.Handle<T> {
    }

    protected abstract T newObject(Handle<T> handle);

    static {
        int maxCapacityPerThread = SystemPropertyUtil.getInt("io.netty.recycler.maxCapacityPerThread", SystemPropertyUtil.getInt("io.netty.recycler.maxCapacity", 4096));
        if (maxCapacityPerThread < 0) {
            maxCapacityPerThread = 4096;
        }
        DEFAULT_MAX_CAPACITY_PER_THREAD = maxCapacityPerThread;
        DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD = SystemPropertyUtil.getInt("io.netty.recycler.chunkSize", 32);
        RATIO = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.ratio", 8));
        BLOCKING_POOL = SystemPropertyUtil.getBoolean("io.netty.recycler.blocking", false);
        if (!logger.isDebugEnabled()) {
            return;
        }
        if (DEFAULT_MAX_CAPACITY_PER_THREAD == 0) {
            logger.debug("-Dio.netty.recycler.maxCapacityPerThread: disabled");
            logger.debug("-Dio.netty.recycler.ratio: disabled");
            logger.debug("-Dio.netty.recycler.chunkSize: disabled");
            logger.debug("-Dio.netty.recycler.blocking: disabled");
            return;
        }
        logger.debug("-Dio.netty.recycler.maxCapacityPerThread: {}", Integer.valueOf(DEFAULT_MAX_CAPACITY_PER_THREAD));
        logger.debug("-Dio.netty.recycler.ratio: {}", Integer.valueOf(RATIO));
        logger.debug("-Dio.netty.recycler.chunkSize: {}", Integer.valueOf(DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD));
        logger.debug("-Dio.netty.recycler.blocking: {}", Boolean.valueOf(BLOCKING_POOL));
    }

    /* access modifiers changed from: protected */
    public Recycler() {
        this(DEFAULT_MAX_CAPACITY_PER_THREAD);
    }

    protected Recycler(int maxCapacityPerThread) {
        this(maxCapacityPerThread, RATIO, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    @Deprecated
    protected Recycler(int maxCapacityPerThread, int maxSharedCapacityFactor) {
        this(maxCapacityPerThread, RATIO, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    @Deprecated
    protected Recycler(int maxCapacityPerThread, int maxSharedCapacityFactor, int ratio, int maxDelayedQueuesPerThread) {
        this(maxCapacityPerThread, ratio, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    @Deprecated
    protected Recycler(int maxCapacityPerThread, int maxSharedCapacityFactor, int ratio, int maxDelayedQueuesPerThread, int delayedQueueRatio) {
        this(maxCapacityPerThread, ratio, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    protected Recycler(int maxCapacityPerThread, int ratio, int chunkSize) {
        this.threadLocal = new FastThreadLocal<LocalPool<T>>() { // from class: io.netty.util.Recycler.2
            /* access modifiers changed from: protected */
            @Override // p013io.netty.util.concurrent.FastThreadLocal
            public /* bridge */ /* synthetic */ void onRemoval(Object obj) throws Exception {
                onRemoval((LocalPool) ((LocalPool) obj));
            }

            /* access modifiers changed from: protected */
            @Override // p013io.netty.util.concurrent.FastThreadLocal
            public LocalPool<T> initialValue() {
                return new LocalPool<>(Recycler.this.maxCapacityPerThread, Recycler.this.interval, Recycler.this.chunkSize);
            }

            protected void onRemoval(LocalPool<T> value) throws Exception {
                onRemoval((C30992) value);
                MessagePassingQueue<DefaultHandle<T>> handles = ((LocalPool) value).pooledHandles;
                ((LocalPool) value).pooledHandles = null;
                handles.clear();
            }
        };
        this.interval = Math.max(0, ratio);
        if (maxCapacityPerThread <= 0) {
            this.maxCapacityPerThread = 0;
            this.chunkSize = 0;
            return;
        }
        this.maxCapacityPerThread = Math.max(4, maxCapacityPerThread);
        this.chunkSize = Math.max(2, Math.min(chunkSize, this.maxCapacityPerThread >> 1));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v16, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public final T get() {
        T obj;
        if (this.maxCapacityPerThread == 0) {
            return newObject(NOOP_HANDLE);
        }
        LocalPool<T> localPool = this.threadLocal.get();
        DefaultHandle<T> handle = localPool.claim();
        if (handle == null) {
            DefaultHandle<T> handle2 = localPool.newHandle();
            if (handle2 != null) {
                obj = newObject(handle2);
                handle2.set(obj);
            } else {
                obj = newObject(NOOP_HANDLE);
            }
        } else {
            obj = handle.get();
        }
        return obj;
    }

    @Deprecated
    public final boolean recycle(T o, Handle<T> handle) {
        if (handle == NOOP_HANDLE) {
            return false;
        }
        handle.recycle(o);
        return true;
    }

    final int threadLocalSize() {
        return ((LocalPool) this.threadLocal.get()).pooledHandles.size();
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.Recycler$DefaultHandle */
    /* loaded from: grasscutter.jar:io/netty/util/Recycler$DefaultHandle.class */
    public static final class DefaultHandle<T> implements Handle<T> {
        private static final int STATE_CLAIMED = 0;
        private static final int STATE_AVAILABLE = 1;
        private static final AtomicIntegerFieldUpdater<DefaultHandle<?>> STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(DefaultHandle.class, TTop.STAT_STATE);
        private volatile int state;
        private final LocalPool<T> localPool;
        private T value;

        DefaultHandle(LocalPool<T> localPool) {
            this.localPool = localPool;
        }

        @Override // p013io.netty.util.internal.ObjectPool.Handle
        public void recycle(Object object) {
            if (object != this.value) {
                throw new IllegalArgumentException("object does not belong to handle");
            }
            this.localPool.release(this);
        }

        T get() {
            return this.value;
        }

        void set(T value) {
            this.value = value;
        }

        boolean availableToClaim() {
            if (this.state != 1) {
                return false;
            }
            return STATE_UPDATER.compareAndSet(this, 1, 0);
        }

        void toAvailable() {
            if (STATE_UPDATER.getAndSet(this, 1) == 1) {
                throw new IllegalStateException("Object has been recycled already.");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.Recycler$LocalPool */
    /* loaded from: grasscutter.jar:io/netty/util/Recycler$LocalPool.class */
    public static final class LocalPool<T> {
        private final int ratioInterval;
        private volatile MessagePassingQueue<DefaultHandle<T>> pooledHandles;
        private int ratioCounter;

        LocalPool(int maxCapacity, int ratioInterval, int chunkSize) {
            this.ratioInterval = ratioInterval;
            if (Recycler.BLOCKING_POOL) {
                this.pooledHandles = new BlockingMessageQueue(maxCapacity);
            } else {
                this.pooledHandles = (MessagePassingQueue) PlatformDependent.newMpscQueue(chunkSize, maxCapacity);
            }
            this.ratioCounter = ratioInterval;
        }

        DefaultHandle<T> claim() {
            DefaultHandle<T> handle;
            MessagePassingQueue<DefaultHandle<T>> handles = this.pooledHandles;
            if (handles == null) {
                return null;
            }
            do {
                handle = handles.relaxedPoll();
                if (handle == null) {
                    break;
                }
            } while (!handle.availableToClaim());
            return handle;
        }

        void release(DefaultHandle<T> handle) {
            MessagePassingQueue<DefaultHandle<T>> handles = this.pooledHandles;
            handle.toAvailable();
            if (handles != null) {
                handles.relaxedOffer(handle);
            }
        }

        DefaultHandle<T> newHandle() {
            int i = this.ratioCounter + 1;
            this.ratioCounter = i;
            if (i < this.ratioInterval) {
                return null;
            }
            this.ratioCounter = 0;
            return new DefaultHandle<>(this);
        }
    }

    /* renamed from: io.netty.util.Recycler$BlockingMessageQueue */
    /* loaded from: grasscutter.jar:io/netty/util/Recycler$BlockingMessageQueue.class */
    private static final class BlockingMessageQueue<T> implements MessagePassingQueue<T> {
        private final Queue<T> deque = new ArrayDeque();
        private final int maxCapacity;

        BlockingMessageQueue(int maxCapacity) {
            this.maxCapacity = maxCapacity;
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public synchronized boolean offer(T e) {
            if (this.deque.size() == this.maxCapacity) {
                return false;
            }
            return this.deque.offer(e);
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public synchronized T poll() {
            return this.deque.poll();
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public synchronized T peek() {
            return this.deque.peek();
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public synchronized int size() {
            return this.deque.size();
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public synchronized void clear() {
            this.deque.clear();
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public synchronized boolean isEmpty() {
            return this.deque.isEmpty();
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int capacity() {
            return this.maxCapacity;
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public boolean relaxedOffer(T e) {
            return offer(e);
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public T relaxedPoll() {
            return poll();
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public T relaxedPeek() {
            return peek();
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int drain(MessagePassingQueue.Consumer<T> c, int limit) {
            throw new UnsupportedOperationException();
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int fill(MessagePassingQueue.Supplier<T> s, int limit) {
            throw new UnsupportedOperationException();
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int drain(MessagePassingQueue.Consumer<T> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int fill(MessagePassingQueue.Supplier<T> s) {
            throw new UnsupportedOperationException();
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public void drain(MessagePassingQueue.Consumer<T> c, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
            throw new UnsupportedOperationException();
        }

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public void fill(MessagePassingQueue.Supplier<T> s, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
            throw new UnsupportedOperationException();
        }
    }
}
