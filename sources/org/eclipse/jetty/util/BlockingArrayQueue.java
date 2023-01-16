package org.eclipse.jetty.util;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/BlockingArrayQueue.class */
public class BlockingArrayQueue<E> extends AbstractList<E> implements BlockingQueue<E> {
    private static final int HEAD_OFFSET = MemoryUtils.getIntegersPerCacheLine() - 1;
    private static final int TAIL_OFFSET = HEAD_OFFSET + MemoryUtils.getIntegersPerCacheLine();
    public static final int DEFAULT_CAPACITY = 128;
    public static final int DEFAULT_GROWTH = 64;
    private final int _maxCapacity;
    private final int _growCapacity;
    private final int[] _indexes;
    private final Lock _tailLock;
    private final AtomicInteger _size;
    private final Lock _headLock;
    private final Condition _notEmpty;
    private Object[] _elements;

    public BlockingArrayQueue() {
        this._indexes = new int[TAIL_OFFSET + 1];
        this._tailLock = new ReentrantLock();
        this._size = new AtomicInteger();
        this._headLock = new ReentrantLock();
        this._notEmpty = this._headLock.newCondition();
        this._elements = new Object[128];
        this._growCapacity = 64;
        this._maxCapacity = Integer.MAX_VALUE;
    }

    public BlockingArrayQueue(int maxCapacity) {
        this._indexes = new int[TAIL_OFFSET + 1];
        this._tailLock = new ReentrantLock();
        this._size = new AtomicInteger();
        this._headLock = new ReentrantLock();
        this._notEmpty = this._headLock.newCondition();
        this._elements = new Object[maxCapacity];
        this._growCapacity = -1;
        this._maxCapacity = maxCapacity;
    }

    public BlockingArrayQueue(int capacity, int growBy) {
        this._indexes = new int[TAIL_OFFSET + 1];
        this._tailLock = new ReentrantLock();
        this._size = new AtomicInteger();
        this._headLock = new ReentrantLock();
        this._notEmpty = this._headLock.newCondition();
        this._elements = new Object[capacity];
        this._growCapacity = growBy;
        this._maxCapacity = Integer.MAX_VALUE;
    }

    public BlockingArrayQueue(int capacity, int growBy, int maxCapacity) {
        this._indexes = new int[TAIL_OFFSET + 1];
        this._tailLock = new ReentrantLock();
        this._size = new AtomicInteger();
        this._headLock = new ReentrantLock();
        this._notEmpty = this._headLock.newCondition();
        if (capacity > maxCapacity) {
            throw new IllegalArgumentException();
        }
        this._elements = new Object[capacity];
        this._growCapacity = growBy;
        this._maxCapacity = maxCapacity;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0038
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public void clear() {
        /*
            r4 = this;
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0._tailLock
            r0.lock()
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0._headLock     // Catch: all -> 0x0050
            r0.lock()     // Catch: all -> 0x0050
            r0 = r4
            int[] r0 = r0._indexes     // Catch: all -> 0x0038, all -> 0x0050
            int r1 = org.eclipse.jetty.util.BlockingArrayQueue.HEAD_OFFSET     // Catch: all -> 0x0038, all -> 0x0050
            r2 = 0
            r0[r1] = r2     // Catch: all -> 0x0038, all -> 0x0050
            r0 = r4
            int[] r0 = r0._indexes     // Catch: all -> 0x0038, all -> 0x0050
            int r1 = org.eclipse.jetty.util.BlockingArrayQueue.TAIL_OFFSET     // Catch: all -> 0x0038, all -> 0x0050
            r2 = 0
            r0[r1] = r2     // Catch: all -> 0x0038, all -> 0x0050
            r0 = r4
            java.util.concurrent.atomic.AtomicInteger r0 = r0._size     // Catch: all -> 0x0038, all -> 0x0050
            r1 = 0
            r0.set(r1)     // Catch: all -> 0x0038, all -> 0x0050
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0._headLock     // Catch: all -> 0x0050
            r0.unlock()     // Catch: all -> 0x0050
            goto L_0x0044
        L_0x0038:
            r5 = move-exception
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0._headLock     // Catch: all -> 0x0050
            r0.unlock()     // Catch: all -> 0x0050
            r0 = r5
            throw r0     // Catch: all -> 0x0050
        L_0x0044:
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0._tailLock
            r0.unlock()
            goto L_0x005c
        L_0x0050:
            r6 = move-exception
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0._tailLock
            r0.unlock()
            r0 = r6
            throw r0
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.BlockingArrayQueue.clear():void");
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this._size.get();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.Queue
    public E poll() {
        if (this._size.get() == 0) {
            return null;
        }
        E e = null;
        this._headLock.lock();
        try {
            if (this._size.get() > 0) {
                int head = this._indexes[HEAD_OFFSET];
                e = (E) this._elements[head];
                this._elements[head] = null;
                this._indexes[HEAD_OFFSET] = (head + 1) % this._elements.length;
                if (this._size.decrementAndGet() > 0) {
                    this._notEmpty.signal();
                }
            }
            return e;
        } finally {
            this._headLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E peek() {
        if (this._size.get() == 0) {
            return null;
        }
        E e = null;
        this._headLock.lock();
        try {
            if (this._size.get() > 0) {
                e = (E) this._elements[this._indexes[HEAD_OFFSET]];
            }
            return e;
        } finally {
            this._headLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E remove() {
        E e = poll();
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Queue
    public E element() {
        E e = peek();
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean offer(E e) {
        Objects.requireNonNull(e);
        this._tailLock.lock();
        try {
            int size = this._size.get();
            if (size >= this._maxCapacity) {
                return false;
            }
            if (size == this._elements.length) {
                this._headLock.lock();
                if (!grow()) {
                    this._tailLock.unlock();
                    return false;
                }
                this._headLock.unlock();
            }
            int tail = this._indexes[TAIL_OFFSET];
            this._elements[tail] = e;
            this._indexes[TAIL_OFFSET] = (tail + 1) % this._elements.length;
            boolean notEmpty = this._size.getAndIncrement() == 0;
            this._tailLock.unlock();
            if (!notEmpty) {
                return true;
            }
            this._headLock.lock();
            try {
                this._notEmpty.signal();
                this._headLock.unlock();
                return true;
            } finally {
                this._headLock.unlock();
            }
        } finally {
            this._tailLock.unlock();
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean add(E e) {
        if (offer(e)) {
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E o) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E o, long timeout, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0024
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.util.concurrent.BlockingQueue
    public E take() throws java.lang.InterruptedException {
        /*
            r5 = this;
            r0 = 0
            r6 = r0
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0._headLock
            r0.lockInterruptibly()
        L_0x000b:
            r0 = r5
            java.util.concurrent.atomic.AtomicInteger r0 = r0._size     // Catch: all -> 0x0077, InterruptedException -> 0x0024
            int r0 = r0.get()     // Catch: all -> 0x0077, InterruptedException -> 0x0024
            if (r0 != 0) goto L_0x0021
            r0 = r5
            java.util.concurrent.locks.Condition r0 = r0._notEmpty     // Catch: all -> 0x0077, InterruptedException -> 0x0024
            r0.await()     // Catch: all -> 0x0077, InterruptedException -> 0x0024
            goto L_0x000b
        L_0x0021:
            goto L_0x0030
        L_0x0024:
            r7 = move-exception
            r0 = r5
            java.util.concurrent.locks.Condition r0 = r0._notEmpty     // Catch: all -> 0x0077
            r0.signal()     // Catch: all -> 0x0077
            r0 = r7
            throw r0     // Catch: all -> 0x0077
        L_0x0030:
            r0 = r5
            int[] r0 = r0._indexes     // Catch: all -> 0x0077
            int r1 = org.eclipse.jetty.util.BlockingArrayQueue.HEAD_OFFSET     // Catch: all -> 0x0077
            r0 = r0[r1]     // Catch: all -> 0x0077
            r7 = r0
            r0 = r5
            java.lang.Object[] r0 = r0._elements     // Catch: all -> 0x0077
            r1 = r7
            r0 = r0[r1]     // Catch: all -> 0x0077
            r6 = r0
            r0 = r5
            java.lang.Object[] r0 = r0._elements     // Catch: all -> 0x0077
            r1 = r7
            r2 = 0
            r0[r1] = r2     // Catch: all -> 0x0077
            r0 = r5
            int[] r0 = r0._indexes     // Catch: all -> 0x0077
            int r1 = org.eclipse.jetty.util.BlockingArrayQueue.HEAD_OFFSET     // Catch: all -> 0x0077
            r2 = r7
            r3 = 1
            int r2 = r2 + r3
            r3 = r5
            java.lang.Object[] r3 = r3._elements     // Catch: all -> 0x0077
            int r3 = r3.length     // Catch: all -> 0x0077
            int r2 = r2 % r3
            r0[r1] = r2     // Catch: all -> 0x0077
            r0 = r5
            java.util.concurrent.atomic.AtomicInteger r0 = r0._size     // Catch: all -> 0x0077
            int r0 = r0.decrementAndGet()     // Catch: all -> 0x0077
            if (r0 <= 0) goto L_0x006b
            r0 = r5
            java.util.concurrent.locks.Condition r0 = r0._notEmpty     // Catch: all -> 0x0077
            r0.signal()     // Catch: all -> 0x0077
        L_0x006b:
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0._headLock
            r0.unlock()
            goto L_0x0083
        L_0x0077:
            r8 = move-exception
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0._headLock
            r0.unlock()
            r0 = r8
            throw r0
        L_0x0083:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.BlockingArrayQueue.take():java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v39, types: [java.util.concurrent.locks.Condition] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.util.concurrent.BlockingQueue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E poll(long r6, java.util.concurrent.TimeUnit r8) throws java.lang.InterruptedException {
        /*
            r5 = this;
            r0 = r8
            r1 = r6
            long r0 = r0.toNanos(r1)
            r9 = r0
            r0 = 0
            r11 = r0
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0._headLock
            r0.lockInterruptibly()
        L_0x0013:
            r0 = r5
            java.util.concurrent.atomic.AtomicInteger r0 = r0._size     // Catch: InterruptedException -> 0x0046, all -> 0x00a0
            int r0 = r0.get()     // Catch: InterruptedException -> 0x0046, all -> 0x00a0
            if (r0 != 0) goto L_0x0043
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0033
            r0 = 0
            r12 = r0
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0._headLock
            r0.unlock()
            r0 = r12
            return r0
        L_0x0033:
            r0 = r5
            java.util.concurrent.locks.Condition r0 = r0._notEmpty     // Catch: InterruptedException -> 0x0046, all -> 0x00a0
            r1 = r9
            long r0 = r0.awaitNanos(r1)     // Catch: InterruptedException -> 0x0046, all -> 0x00a0
            r9 = r0
            goto L_0x0013
        L_0x0043:
            goto L_0x0054
        L_0x0046:
            r12 = move-exception
            r0 = r5
            java.util.concurrent.locks.Condition r0 = r0._notEmpty     // Catch: all -> 0x00a0
            r0.signal()     // Catch: all -> 0x00a0
            r0 = r12
            throw r0     // Catch: all -> 0x00a0
        L_0x0054:
            r0 = r5
            int[] r0 = r0._indexes     // Catch: all -> 0x00a0
            int r1 = org.eclipse.jetty.util.BlockingArrayQueue.HEAD_OFFSET     // Catch: all -> 0x00a0
            r0 = r0[r1]     // Catch: all -> 0x00a0
            r12 = r0
            r0 = r5
            java.lang.Object[] r0 = r0._elements     // Catch: all -> 0x00a0
            r1 = r12
            r0 = r0[r1]     // Catch: all -> 0x00a0
            r11 = r0
            r0 = r5
            java.lang.Object[] r0 = r0._elements     // Catch: all -> 0x00a0
            r1 = r12
            r2 = 0
            r0[r1] = r2     // Catch: all -> 0x00a0
            r0 = r5
            int[] r0 = r0._indexes     // Catch: all -> 0x00a0
            int r1 = org.eclipse.jetty.util.BlockingArrayQueue.HEAD_OFFSET     // Catch: all -> 0x00a0
            r2 = r12
            r3 = 1
            int r2 = r2 + r3
            r3 = r5
            java.lang.Object[] r3 = r3._elements     // Catch: all -> 0x00a0
            int r3 = r3.length     // Catch: all -> 0x00a0
            int r2 = r2 % r3
            r0[r1] = r2     // Catch: all -> 0x00a0
            r0 = r5
            java.util.concurrent.atomic.AtomicInteger r0 = r0._size     // Catch: all -> 0x00a0
            int r0 = r0.decrementAndGet()     // Catch: all -> 0x00a0
            if (r0 <= 0) goto L_0x0094
            r0 = r5
            java.util.concurrent.locks.Condition r0 = r0._notEmpty     // Catch: all -> 0x00a0
            r0.signal()     // Catch: all -> 0x00a0
        L_0x0094:
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0._headLock
            r0.unlock()
            goto L_0x00ae
        L_0x00a0:
            r13 = move-exception
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0._headLock
            r0.unlock()
            r0 = r13
            throw r0
        L_0x00ae:
            r0 = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.BlockingArrayQueue.poll(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean remove(Object o) {
        this._tailLock.lock();
        try {
            this._headLock.lock();
            if (isEmpty()) {
                this._headLock.unlock();
                this._tailLock.unlock();
                return false;
            }
            int head = this._indexes[HEAD_OFFSET];
            int tail = this._indexes[TAIL_OFFSET];
            int capacity = this._elements.length;
            int i = head;
            while (!Objects.equals(this._elements[i], o)) {
                i++;
                if (i == capacity) {
                    i = 0;
                }
                if (i == tail) {
                    this._headLock.unlock();
                    this._tailLock.unlock();
                    return false;
                }
            }
            remove(i >= head ? i - head : (capacity - head) + i);
            this._headLock.unlock();
            this._tailLock.unlock();
            return true;
        } catch (Throwable th) {
            this._tailLock.unlock();
            throw th;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0030
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        /*
            r3 = this;
            r0 = r3
            java.util.concurrent.locks.Lock r0 = r0._tailLock
            r0.lock()
            r0 = r3
            java.util.concurrent.locks.Lock r0 = r0._headLock     // Catch: all -> 0x003c
            r0.lock()     // Catch: all -> 0x003c
            r0 = r3
            int r0 = r0.getCapacity()     // Catch: all -> 0x003c, all -> 0x0030
            r1 = r3
            int r1 = r1.size()     // Catch: all -> 0x003c, all -> 0x0030
            int r0 = r0 - r1
            r4 = r0
            r0 = r3
            java.util.concurrent.locks.Lock r0 = r0._headLock     // Catch: all -> 0x003c
            r0.unlock()     // Catch: all -> 0x003c
            r0 = r3
            java.util.concurrent.locks.Lock r0 = r0._tailLock
            r0.unlock()
            r0 = r4
            return r0
        L_0x0030:
            r5 = move-exception
            r0 = r3
            java.util.concurrent.locks.Lock r0 = r0._headLock     // Catch: all -> 0x003c
            r0.unlock()     // Catch: all -> 0x003c
            r0 = r5
            throw r0     // Catch: all -> 0x003c
        L_0x003c:
            r6 = move-exception
            r0 = r3
            java.util.concurrent.locks.Lock r0 = r0._tailLock
            r0.unlock()
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.BlockingArrayQueue.remainingCapacity():int");
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c) {
        return drainTo(c, Integer.MAX_VALUE);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:18:0x00a4
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(java.util.Collection<? super E> r5, int r6) {
        /*
            r4 = this;
            r0 = 0
            r7 = r0
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0._tailLock
            r0.lock()
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0._headLock     // Catch: all -> 0x00be
            r0.lock()     // Catch: all -> 0x00be
            r0 = r4
            int[] r0 = r0._indexes     // Catch: all -> 0x00a4, all -> 0x00be
            int r1 = org.eclipse.jetty.util.BlockingArrayQueue.HEAD_OFFSET     // Catch: all -> 0x00a4, all -> 0x00be
            r0 = r0[r1]     // Catch: all -> 0x00a4, all -> 0x00be
            r8 = r0
            r0 = r4
            int[] r0 = r0._indexes     // Catch: all -> 0x00a4, all -> 0x00be
            int r1 = org.eclipse.jetty.util.BlockingArrayQueue.TAIL_OFFSET     // Catch: all -> 0x00a4, all -> 0x00be
            r0 = r0[r1]     // Catch: all -> 0x00a4, all -> 0x00be
            r9 = r0
            r0 = r4
            java.lang.Object[] r0 = r0._elements     // Catch: all -> 0x00a4, all -> 0x00be
            int r0 = r0.length     // Catch: all -> 0x00a4, all -> 0x00be
            r10 = r0
            r0 = r8
            r11 = r0
        L_0x0033:
            r0 = r11
            r1 = r9
            if (r0 == r1) goto L_0x0060
            r0 = r7
            r1 = r6
            if (r0 >= r1) goto L_0x0060
            int r7 = r7 + 1
            r0 = r5
            r1 = r4
            java.lang.Object[] r1 = r1._elements     // Catch: all -> 0x00a4, all -> 0x00be
            r2 = r11
            r1 = r1[r2]     // Catch: all -> 0x00a4, all -> 0x00be
            boolean r0 = r0.add(r1)     // Catch: all -> 0x00a4, all -> 0x00be
            int r11 = r11 + 1
            r0 = r11
            r1 = r10
            if (r0 != r1) goto L_0x0033
            r0 = 0
            r11 = r0
            goto L_0x0033
        L_0x0060:
            r0 = r11
            r1 = r9
            if (r0 != r1) goto L_0x0084
            r0 = r4
            int[] r0 = r0._indexes     // Catch: all -> 0x00a4, all -> 0x00be
            int r1 = org.eclipse.jetty.util.BlockingArrayQueue.HEAD_OFFSET     // Catch: all -> 0x00a4, all -> 0x00be
            r2 = 0
            r0[r1] = r2     // Catch: all -> 0x00a4, all -> 0x00be
            r0 = r4
            int[] r0 = r0._indexes     // Catch: all -> 0x00a4, all -> 0x00be
            int r1 = org.eclipse.jetty.util.BlockingArrayQueue.TAIL_OFFSET     // Catch: all -> 0x00a4, all -> 0x00be
            r2 = 0
            r0[r1] = r2     // Catch: all -> 0x00a4, all -> 0x00be
            r0 = r4
            java.util.concurrent.atomic.AtomicInteger r0 = r0._size     // Catch: all -> 0x00a4, all -> 0x00be
            r1 = 0
            r0.set(r1)     // Catch: all -> 0x00a4, all -> 0x00be
            goto L_0x0098
        L_0x0084:
            r0 = r4
            int[] r0 = r0._indexes     // Catch: all -> 0x00a4, all -> 0x00be
            int r1 = org.eclipse.jetty.util.BlockingArrayQueue.HEAD_OFFSET     // Catch: all -> 0x00a4, all -> 0x00be
            r2 = r11
            r0[r1] = r2     // Catch: all -> 0x00a4, all -> 0x00be
            r0 = r4
            java.util.concurrent.atomic.AtomicInteger r0 = r0._size     // Catch: all -> 0x00a4, all -> 0x00be
            r1 = r7
            int r1 = -r1
            int r0 = r0.addAndGet(r1)     // Catch: all -> 0x00a4, all -> 0x00be
        L_0x0098:
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0._headLock     // Catch: all -> 0x00be
            r0.unlock()     // Catch: all -> 0x00be
            goto L_0x00b2
        L_0x00a4:
            r12 = move-exception
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0._headLock     // Catch: all -> 0x00be
            r0.unlock()     // Catch: all -> 0x00be
            r0 = r12
            throw r0     // Catch: all -> 0x00be
        L_0x00b2:
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0._tailLock
            r0.unlock()
            goto L_0x00cc
        L_0x00be:
            r13 = move-exception
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0._tailLock
            r0.unlock()
            r0 = r13
            throw r0
        L_0x00cc:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.BlockingArrayQueue.drainTo(java.util.Collection, int):int");
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        this._tailLock.lock();
        try {
            this._headLock.lock();
            if (index < 0 || index >= this._size.get()) {
                throw new IndexOutOfBoundsException("!(0<" + index + "<=" + this._size + ")");
            }
            int i = this._indexes[HEAD_OFFSET] + index;
            int capacity = this._elements.length;
            if (i >= capacity) {
                i -= capacity;
            }
            E e = (E) this._elements[i];
            this._headLock.unlock();
            this._tailLock.unlock();
            return e;
        } catch (Throwable th) {
            this._tailLock.unlock();
            throw th;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        this._tailLock.lock();
        try {
            this._headLock.lock();
            int size = this._size.get();
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("!(0<" + index + "<=" + this._size + ")");
            }
            if (index == size) {
                add(e);
            } else if (this._indexes[TAIL_OFFSET] != this._indexes[HEAD_OFFSET] || grow()) {
                int i = this._indexes[HEAD_OFFSET] + index;
                int capacity = this._elements.length;
                if (i >= capacity) {
                    i -= capacity;
                }
                this._size.incrementAndGet();
                int tail = (this._indexes[TAIL_OFFSET] + 1) % capacity;
                this._indexes[TAIL_OFFSET] = tail;
                if (i < tail) {
                    System.arraycopy(this._elements, i, this._elements, i + 1, tail - i);
                    this._elements[i] = e;
                } else {
                    if (tail > 0) {
                        System.arraycopy(this._elements, 0, this._elements, 1, tail);
                        this._elements[0] = this._elements[capacity - 1];
                    }
                    System.arraycopy(this._elements, i, this._elements, i + 1, (capacity - i) - 1);
                    this._elements[i] = e;
                }
            } else {
                throw new IllegalStateException("full");
            }
            this._headLock.unlock();
        } finally {
            this._tailLock.unlock();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int index, E e) {
        Objects.requireNonNull(e);
        this._tailLock.lock();
        try {
            this._headLock.lock();
            if (index < 0 || index >= this._size.get()) {
                throw new IndexOutOfBoundsException("!(0<" + index + "<=" + this._size + ")");
            }
            int i = this._indexes[HEAD_OFFSET] + index;
            int capacity = this._elements.length;
            if (i >= capacity) {
                i -= capacity;
            }
            E old = (E) this._elements[i];
            this._elements[i] = e;
            this._headLock.unlock();
            this._tailLock.unlock();
            return old;
        } catch (Throwable th) {
            this._tailLock.unlock();
            throw th;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int index) {
        this._tailLock.lock();
        try {
            this._headLock.lock();
            if (index < 0 || index >= this._size.get()) {
                throw new IndexOutOfBoundsException("!(0<" + index + "<=" + this._size + ")");
            }
            int i = this._indexes[HEAD_OFFSET] + index;
            int capacity = this._elements.length;
            if (i >= capacity) {
                i -= capacity;
            }
            E old = (E) this._elements[i];
            int tail = this._indexes[TAIL_OFFSET];
            if (i < tail) {
                System.arraycopy(this._elements, i + 1, this._elements, i, tail - i);
                int[] iArr = this._indexes;
                int i2 = TAIL_OFFSET;
                iArr[i2] = iArr[i2] - 1;
            } else {
                System.arraycopy(this._elements, i + 1, this._elements, i, (capacity - i) - 1);
                this._elements[capacity - 1] = this._elements[0];
                if (tail > 0) {
                    System.arraycopy(this._elements, 1, this._elements, 0, tail);
                    int[] iArr2 = this._indexes;
                    int i3 = TAIL_OFFSET;
                    iArr2[i3] = iArr2[i3] - 1;
                } else {
                    this._indexes[TAIL_OFFSET] = capacity - 1;
                }
                this._elements[this._indexes[TAIL_OFFSET]] = null;
            }
            this._size.decrementAndGet();
            this._headLock.unlock();
            this._tailLock.unlock();
            return old;
        } catch (Throwable th) {
            this._tailLock.unlock();
            throw th;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:14:0x008c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.util.AbstractList, java.util.List
    public java.util.ListIterator<E> listIterator(int r8) {
        /*
            r7 = this;
            r0 = r7
            java.util.concurrent.locks.Lock r0 = r0._tailLock
            r0.lock()
            r0 = r7
            java.util.concurrent.locks.Lock r0 = r0._headLock     // Catch: all -> 0x009a
            r0.lock()     // Catch: all -> 0x009a
            r0 = r7
            int r0 = r0.size()     // Catch: all -> 0x009a, all -> 0x008c
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: all -> 0x009a, all -> 0x008c
            r9 = r0
            r0 = r7
            int r0 = r0.size()     // Catch: all -> 0x009a, all -> 0x008c
            if (r0 <= 0) goto L_0x006d
            r0 = r7
            int[] r0 = r0._indexes     // Catch: all -> 0x009a, all -> 0x008c
            int r1 = org.eclipse.jetty.util.BlockingArrayQueue.HEAD_OFFSET     // Catch: all -> 0x009a, all -> 0x008c
            r0 = r0[r1]     // Catch: all -> 0x009a, all -> 0x008c
            r10 = r0
            r0 = r7
            int[] r0 = r0._indexes     // Catch: all -> 0x009a, all -> 0x008c
            int r1 = org.eclipse.jetty.util.BlockingArrayQueue.TAIL_OFFSET     // Catch: all -> 0x009a, all -> 0x008c
            r0 = r0[r1]     // Catch: all -> 0x009a, all -> 0x008c
            r11 = r0
            r0 = r10
            r1 = r11
            if (r0 >= r1) goto L_0x004b
            r0 = r7
            java.lang.Object[] r0 = r0._elements     // Catch: all -> 0x009a, all -> 0x008c
            r1 = r10
            r2 = r9
            r3 = 0
            r4 = r11
            r5 = r10
            int r4 = r4 - r5
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)     // Catch: all -> 0x009a, all -> 0x008c
            goto L_0x006d
        L_0x004b:
            r0 = r7
            java.lang.Object[] r0 = r0._elements     // Catch: all -> 0x009a, all -> 0x008c
            int r0 = r0.length     // Catch: all -> 0x009a, all -> 0x008c
            r1 = r10
            int r0 = r0 - r1
            r12 = r0
            r0 = r7
            java.lang.Object[] r0 = r0._elements     // Catch: all -> 0x009a, all -> 0x008c
            r1 = r10
            r2 = r9
            r3 = 0
            r4 = r12
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)     // Catch: all -> 0x009a, all -> 0x008c
            r0 = r7
            java.lang.Object[] r0 = r0._elements     // Catch: all -> 0x009a, all -> 0x008c
            r1 = 0
            r2 = r9
            r3 = r12
            r4 = r11
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)     // Catch: all -> 0x009a, all -> 0x008c
        L_0x006d:
            org.eclipse.jetty.util.BlockingArrayQueue$Itr r0 = new org.eclipse.jetty.util.BlockingArrayQueue$Itr     // Catch: all -> 0x009a, all -> 0x008c
            r1 = r0
            r2 = r7
            r3 = r9
            r4 = r8
            r1.<init>(r3, r4)     // Catch: all -> 0x009a, all -> 0x008c
            r10 = r0
            r0 = r7
            java.util.concurrent.locks.Lock r0 = r0._headLock     // Catch: all -> 0x009a
            r0.unlock()     // Catch: all -> 0x009a
            r0 = r7
            java.util.concurrent.locks.Lock r0 = r0._tailLock
            r0.unlock()
            r0 = r10
            return r0
        L_0x008c:
            r13 = move-exception
            r0 = r7
            java.util.concurrent.locks.Lock r0 = r0._headLock     // Catch: all -> 0x009a
            r0.unlock()     // Catch: all -> 0x009a
            r0 = r13
            throw r0     // Catch: all -> 0x009a
        L_0x009a:
            r14 = move-exception
            r0 = r7
            java.util.concurrent.locks.Lock r0 = r0._tailLock
            r0.unlock()
            r0 = r14
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.BlockingArrayQueue.listIterator(int):java.util.ListIterator");
    }

    public int getCapacity() {
        this._tailLock.lock();
        try {
            return this._elements.length;
        } finally {
            this._tailLock.unlock();
        }
    }

    public int getMaxCapacity() {
        return this._maxCapacity;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:21:0x00c3
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private boolean grow() {
        /*
        // Method dump skipped, instructions count: 223
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.BlockingArrayQueue.grow():boolean");
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/BlockingArrayQueue$Itr.class */
    private class Itr implements ListIterator<E> {
        private final Object[] _elements;
        private int _cursor;

        public Itr(Object[] elements, int offset) {
            this._elements = elements;
            this._cursor = offset;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this._cursor < this._elements.length;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            Object[] objArr = this._elements;
            int i = this._cursor;
            this._cursor = i + 1;
            return (E) objArr[i];
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this._cursor > 0;
        }

        @Override // java.util.ListIterator
        public E previous() {
            Object[] objArr = this._elements;
            int i = this._cursor - 1;
            this._cursor = i;
            return (E) objArr[i];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this._cursor + 1;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this._cursor - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }
}
