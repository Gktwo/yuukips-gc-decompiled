package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/Queues.class */
public final class Queues {
    private Queues() {
    }

    @GwtIncompatible
    public static <E> ArrayBlockingQueue<E> newArrayBlockingQueue(int capacity) {
        return new ArrayBlockingQueue<>(capacity);
    }

    public static <E> ArrayDeque<E> newArrayDeque() {
        return new ArrayDeque<>();
    }

    public static <E> ArrayDeque<E> newArrayDeque(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new ArrayDeque<>(Collections2.cast(elements));
        }
        ArrayDeque<E> deque = new ArrayDeque<>();
        Iterables.addAll(deque, elements);
        return deque;
    }

    @GwtIncompatible
    public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue() {
        return new ConcurrentLinkedQueue<>();
    }

    @GwtIncompatible
    public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new ConcurrentLinkedQueue<>(Collections2.cast(elements));
        }
        ConcurrentLinkedQueue<E> queue = new ConcurrentLinkedQueue<>();
        Iterables.addAll(queue, elements);
        return queue;
    }

    @GwtIncompatible
    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque() {
        return new LinkedBlockingDeque<>();
    }

    @GwtIncompatible
    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(int capacity) {
        return new LinkedBlockingDeque<>(capacity);
    }

    @GwtIncompatible
    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new LinkedBlockingDeque<>(Collections2.cast(elements));
        }
        LinkedBlockingDeque<E> deque = new LinkedBlockingDeque<>();
        Iterables.addAll(deque, elements);
        return deque;
    }

    @GwtIncompatible
    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue() {
        return new LinkedBlockingQueue<>();
    }

    @GwtIncompatible
    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(int capacity) {
        return new LinkedBlockingQueue<>(capacity);
    }

    @GwtIncompatible
    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new LinkedBlockingQueue<>(Collections2.cast(elements));
        }
        LinkedBlockingQueue<E> queue = new LinkedBlockingQueue<>();
        Iterables.addAll(queue, elements);
        return queue;
    }

    @GwtIncompatible
    public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue() {
        return new PriorityBlockingQueue<>();
    }

    @GwtIncompatible
    public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new PriorityBlockingQueue<>(Collections2.cast(elements));
        }
        PriorityBlockingQueue<E> queue = new PriorityBlockingQueue<>();
        Iterables.addAll(queue, elements);
        return queue;
    }

    public static <E extends Comparable> PriorityQueue<E> newPriorityQueue() {
        return new PriorityQueue<>();
    }

    public static <E extends Comparable> PriorityQueue<E> newPriorityQueue(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new PriorityQueue<>(Collections2.cast(elements));
        }
        PriorityQueue<E> queue = new PriorityQueue<>();
        Iterables.addAll(queue, elements);
        return queue;
    }

    @GwtIncompatible
    public static <E> SynchronousQueue<E> newSynchronousQueue() {
        return new SynchronousQueue<>();
    }

    @CanIgnoreReturnValue
    @Beta
    @GwtIncompatible
    public static <E> int drain(BlockingQueue<E> q, Collection<? super E> buffer, int numElements, long timeout, TimeUnit unit) throws InterruptedException {
        Preconditions.checkNotNull(buffer);
        long deadline = System.nanoTime() + unit.toNanos(timeout);
        int added = 0;
        while (added < numElements) {
            added += q.drainTo(buffer, numElements - added);
            if (added < numElements) {
                E e = q.poll(deadline - System.nanoTime(), TimeUnit.NANOSECONDS);
                if (e == null) {
                    break;
                }
                buffer.add(e);
                added++;
            }
        }
        return added;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0047
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static <E> int drainUninterruptibly(java.util.concurrent.BlockingQueue<E> r6, java.util.Collection<? super E> r7, int r8, long r9, java.util.concurrent.TimeUnit r11) {
        /*
            r0 = r7
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            long r0 = java.lang.System.nanoTime()
            r1 = r11
            r2 = r9
            long r1 = r1.toNanos(r2)
            long r0 = r0 + r1
            r12 = r0
            r0 = 0
            r14 = r0
            r0 = 0
            r15 = r0
        L_0x0017:
            r0 = r14
            r1 = r8
            if (r0 >= r1) goto L_0x0066
            r0 = r14
            r1 = r6
            r2 = r7
            r3 = r8
            r4 = r14
            int r3 = r3 - r4
            int r1 = r1.drainTo(r2, r3)     // Catch: all -> 0x0074
            int r0 = r0 + r1
            r14 = r0
            r0 = r14
            r1 = r8
            if (r0 >= r1) goto L_0x0017
        L_0x0033:
            r0 = r6
            r1 = r12
            long r2 = java.lang.System.nanoTime()     // Catch: all -> 0x0074, InterruptedException -> 0x0047
            long r1 = r1 - r2
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: all -> 0x0074, InterruptedException -> 0x0047
            java.lang.Object r0 = r0.poll(r1, r2)     // Catch: all -> 0x0074, InterruptedException -> 0x0047
            r16 = r0
            goto L_0x004f
        L_0x0047:
            r17 = move-exception
            r0 = 1
            r15 = r0
            goto L_0x0033
        L_0x004f:
            r0 = r16
            if (r0 != 0) goto L_0x0057
            goto L_0x0066
        L_0x0057:
            r0 = r7
            r1 = r16
            boolean r0 = r0.add(r1)     // Catch: all -> 0x0074
            int r14 = r14 + 1
            goto L_0x0017
        L_0x0066:
            r0 = r15
            if (r0 == 0) goto L_0x0084
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L_0x0084
        L_0x0074:
            r18 = move-exception
            r0 = r15
            if (r0 == 0) goto L_0x0081
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0081:
            r0 = r18
            throw r0
        L_0x0084:
            r0 = r14
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Queues.drainUninterruptibly(java.util.concurrent.BlockingQueue, java.util.Collection, int, long, java.util.concurrent.TimeUnit):int");
    }

    public static <E> Queue<E> synchronizedQueue(Queue<E> queue) {
        return Synchronized.queue(queue, null);
    }

    public static <E> Deque<E> synchronizedDeque(Deque<E> deque) {
        return Synchronized.deque(deque, null);
    }
}
