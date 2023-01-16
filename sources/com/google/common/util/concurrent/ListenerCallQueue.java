package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/ListenerCallQueue.class */
public final class ListenerCallQueue<L> {
    private static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
    private final List<PerListenerQueue<L>> listeners = Collections.synchronizedList(new ArrayList());

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/ListenerCallQueue$Event.class */
    public interface Event<L> {
        void call(L l);
    }

    public void addListener(L listener, Executor executor) {
        Preconditions.checkNotNull(listener, "listener");
        Preconditions.checkNotNull(executor, "executor");
        this.listeners.add(new PerListenerQueue<>(listener, executor));
    }

    public void enqueue(Event<L> event) {
        enqueueHelper(event, event);
    }

    public void enqueue(Event<L> event, String label) {
        enqueueHelper(event, label);
    }

    private void enqueueHelper(Event<L> event, Object label) {
        Preconditions.checkNotNull(event, "event");
        Preconditions.checkNotNull(label, "label");
        synchronized (this.listeners) {
            for (PerListenerQueue<L> queue : this.listeners) {
                queue.add(event, label);
            }
        }
    }

    public void dispatch() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).dispatch();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/ListenerCallQueue$PerListenerQueue.class */
    public static final class PerListenerQueue<L> implements Runnable {
        final L listener;
        final Executor executor;
        @GuardedBy("this")
        final Queue<Event<L>> waitQueue = Queues.newArrayDeque();
        @GuardedBy("this")
        final Queue<Object> labelQueue = Queues.newArrayDeque();
        @GuardedBy("this")
        boolean isThreadScheduled;

        PerListenerQueue(L listener, Executor executor) {
            this.listener = (L) Preconditions.checkNotNull(listener);
            this.executor = (Executor) Preconditions.checkNotNull(executor);
        }

        synchronized void add(Event<L> event, Object label) {
            this.waitQueue.add(event);
            this.labelQueue.add(label);
        }

        void dispatch() {
            boolean scheduleEventRunner = false;
            synchronized (this) {
                if (!this.isThreadScheduled) {
                    this.isThreadScheduled = true;
                    scheduleEventRunner = true;
                }
            }
            if (scheduleEventRunner) {
                try {
                    this.executor.execute(this);
                } catch (RuntimeException e) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        ListenerCallQueue.logger.log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, (Throwable) e);
                        throw e;
                    }
                }
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:19:0x0051
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.lang.Runnable
        public void run() {
            /*
                r5 = this;
                r0 = 1
                r6 = r0
            L_0x0002:
                r0 = r5
                r1 = r0
                r9 = r1
                monitor-enter(r0)     // Catch: all -> 0x009c
                r0 = r5
                boolean r0 = r0.isThreadScheduled     // Catch: all -> 0x009c, all -> 0x003c
                com.google.common.base.Preconditions.checkState(r0)     // Catch: all -> 0x009c, all -> 0x003c
                r0 = r5
                java.util.Queue<com.google.common.util.concurrent.ListenerCallQueue$Event<L>> r0 = r0.waitQueue     // Catch: all -> 0x009c, all -> 0x003c
                java.lang.Object r0 = r0.poll()     // Catch: all -> 0x009c, all -> 0x003c
                com.google.common.util.concurrent.ListenerCallQueue$Event r0 = (com.google.common.util.concurrent.ListenerCallQueue.Event) r0     // Catch: all -> 0x009c, all -> 0x003c
                r7 = r0
                r0 = r5
                java.util.Queue<java.lang.Object> r0 = r0.labelQueue     // Catch: all -> 0x009c, all -> 0x003c
                java.lang.Object r0 = r0.poll()     // Catch: all -> 0x009c, all -> 0x003c
                r8 = r0
                r0 = r7
                if (r0 != 0) goto L_0x0036
                r0 = r5
                r1 = 0
                r0.isThreadScheduled = r1     // Catch: all -> 0x009c, all -> 0x003c
                r0 = 0
                r6 = r0
                r0 = r9
                monitor-exit(r0)     // Catch: all -> 0x009c, all -> 0x003c
                goto L_0x0080
            L_0x0036:
                r0 = r9
                monitor-exit(r0)     // Catch: all -> 0x009c, all -> 0x003c
                goto L_0x0044
            L_0x003c:
                r10 = move-exception
                r0 = r9
                monitor-exit(r0)     // Catch: all -> 0x009c, all -> 0x003c
                r0 = r10
                throw r0     // Catch: all -> 0x009c
            L_0x0044:
                r0 = r7
                r1 = r5
                L r1 = r1.listener     // Catch: all -> 0x009c, RuntimeException -> 0x0051
                r0.call(r1)     // Catch: all -> 0x009c, RuntimeException -> 0x0051
                goto L_0x007d
            L_0x0051:
                r9 = move-exception
                java.util.logging.Logger r0 = com.google.common.util.concurrent.ListenerCallQueue.access$000()     // Catch: all -> 0x009c
                java.util.logging.Level r1 = java.util.logging.Level.SEVERE     // Catch: all -> 0x009c
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: all -> 0x009c
                r3 = r2
                r3.<init>()     // Catch: all -> 0x009c
                java.lang.String r3 = "Exception while executing callback: "
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: all -> 0x009c
                r3 = r5
                L r3 = r3.listener     // Catch: all -> 0x009c
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: all -> 0x009c
                java.lang.String r3 = " "
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: all -> 0x009c
                r3 = r8
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: all -> 0x009c
                java.lang.String r2 = r2.toString()     // Catch: all -> 0x009c
                r3 = r9
                r0.log(r1, r2, r3)     // Catch: all -> 0x009c
            L_0x007d:
                goto L_0x0002
            L_0x0080:
                r0 = r6
                if (r0 == 0) goto L_0x00bd
                r0 = r5
                r1 = r0
                r7 = r1
                monitor-enter(r0)
                r0 = r5
                r1 = 0
                r0.isThreadScheduled = r1     // Catch: all -> 0x0092
                r0 = r7
                monitor-exit(r0)     // Catch: all -> 0x0092
                goto L_0x0099
            L_0x0092:
                r11 = move-exception
                r0 = r7
                monitor-exit(r0)     // Catch: all -> 0x0092
                r0 = r11
                throw r0
            L_0x0099:
                goto L_0x00bd
            L_0x009c:
                r12 = move-exception
                r0 = r6
                if (r0 == 0) goto L_0x00ba
                r0 = r5
                r1 = r0
                r13 = r1
                monitor-enter(r0)
                r0 = r5
                r1 = 0
                r0.isThreadScheduled = r1     // Catch: all -> 0x00b2
                r0 = r13
                monitor-exit(r0)     // Catch: all -> 0x00b2
                goto L_0x00ba
            L_0x00b2:
                r14 = move-exception
                r0 = r13
                monitor-exit(r0)     // Catch: all -> 0x00b2
                r0 = r14
                throw r0
            L_0x00ba:
                r0 = r12
                throw r0
            L_0x00bd:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue.run():void");
        }
    }
}
