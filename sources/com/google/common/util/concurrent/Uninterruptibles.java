package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/Uninterruptibles.class */
public final class Uninterruptibles {
    @GwtIncompatible
    public static void awaitUninterruptibly(CountDownLatch latch) {
        boolean interrupted = false;
        while (true) {
            try {
                latch.await();
                break;
            } catch (InterruptedException e) {
                interrupted = true;
            } catch (Throwable th) {
                if (interrupted) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (interrupted) {
            Thread.currentThread().interrupt();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x002b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.GwtIncompatible
    public static boolean awaitUninterruptibly(java.util.concurrent.CountDownLatch r5, long r6, java.util.concurrent.TimeUnit r8) {
        /*
            r0 = 0
            r9 = r0
            r0 = r8
            r1 = r6
            long r0 = r0.toNanos(r1)     // Catch: all -> 0x003b
            r10 = r0
            long r0 = java.lang.System.nanoTime()     // Catch: all -> 0x003b
            r1 = r10
            long r0 = r0 + r1
            r12 = r0
        L_0x0012:
            r0 = r5
            r1 = r10
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: InterruptedException -> 0x002b, all -> 0x003b
            boolean r0 = r0.await(r1, r2)     // Catch: InterruptedException -> 0x002b, all -> 0x003b
            r14 = r0
            r0 = r9
            if (r0 == 0) goto L_0x0028
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0028:
            r0 = r14
            return r0
        L_0x002b:
            r14 = move-exception
            r0 = 1
            r9 = r0
            r0 = r12
            long r1 = java.lang.System.nanoTime()     // Catch: all -> 0x003b
            long r0 = r0 - r1
            r10 = r0
            goto L_0x0012
        L_0x003b:
            r15 = move-exception
            r0 = r9
            if (r0 == 0) goto L_0x0048
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0048:
            r0 = r15
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.awaitUninterruptibly(java.util.concurrent.CountDownLatch, long, java.util.concurrent.TimeUnit):boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x002d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @com.google.common.annotations.GwtIncompatible
    public static boolean awaitUninterruptibly(java.util.concurrent.locks.Condition r5, long r6, java.util.concurrent.TimeUnit r8) {
        /*
            r0 = 0
            r9 = r0
            r0 = r8
            r1 = r6
            long r0 = r0.toNanos(r1)     // Catch: all -> 0x003d
            r10 = r0
            long r0 = java.lang.System.nanoTime()     // Catch: all -> 0x003d
            r1 = r10
            long r0 = r0 + r1
            r12 = r0
        L_0x0012:
            r0 = r5
            r1 = r10
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: all -> 0x003d, InterruptedException -> 0x002d
            boolean r0 = r0.await(r1, r2)     // Catch: all -> 0x003d, InterruptedException -> 0x002d
            r14 = r0
            r0 = r9
            if (r0 == 0) goto L_0x002a
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x002a:
            r0 = r14
            return r0
        L_0x002d:
            r14 = move-exception
            r0 = 1
            r9 = r0
            r0 = r12
            long r1 = java.lang.System.nanoTime()     // Catch: all -> 0x003d
            long r0 = r0 - r1
            r10 = r0
            goto L_0x0012
        L_0x003d:
            r15 = move-exception
            r0 = r9
            if (r0 == 0) goto L_0x004a
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x004a:
            r0 = r15
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.awaitUninterruptibly(java.util.concurrent.locks.Condition, long, java.util.concurrent.TimeUnit):boolean");
    }

    @GwtIncompatible
    public static void joinUninterruptibly(Thread toJoin) {
        boolean interrupted = false;
        while (true) {
            try {
                toJoin.join();
                break;
            } catch (InterruptedException e) {
                interrupted = true;
            } catch (Throwable th) {
                if (interrupted) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (interrupted) {
            Thread.currentThread().interrupt();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x002c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @com.google.common.annotations.GwtIncompatible
    public static void joinUninterruptibly(java.lang.Thread r5, long r6, java.util.concurrent.TimeUnit r8) {
        /*
            r0 = r5
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            r0 = 0
            r9 = r0
            r0 = r8
            r1 = r6
            long r0 = r0.toNanos(r1)     // Catch: all -> 0x003c
            r10 = r0
            long r0 = java.lang.System.nanoTime()     // Catch: all -> 0x003c
            r1 = r10
            long r0 = r0 + r1
            r12 = r0
        L_0x0017:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: all -> 0x003c, InterruptedException -> 0x002c
            r1 = r5
            r2 = r10
            r0.timedJoin(r1, r2)     // Catch: all -> 0x003c, InterruptedException -> 0x002c
            r0 = r9
            if (r0 == 0) goto L_0x002b
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x002b:
            return
        L_0x002c:
            r14 = move-exception
            r0 = 1
            r9 = r0
            r0 = r12
            long r1 = java.lang.System.nanoTime()     // Catch: all -> 0x003c
            long r0 = r0 - r1
            r10 = r0
            goto L_0x0017
        L_0x003c:
            r15 = move-exception
            r0 = r9
            if (r0 == 0) goto L_0x0049
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0049:
            r0 = r15
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.joinUninterruptibly(java.lang.Thread, long, java.util.concurrent.TimeUnit):void");
    }

    @CanIgnoreReturnValue
    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v;
        boolean interrupted = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException e) {
                interrupted = true;
            } catch (Throwable th) {
                if (interrupted) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (interrupted) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x002d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.GwtIncompatible
    public static <V> V getUninterruptibly(java.util.concurrent.Future<V> r5, long r6, java.util.concurrent.TimeUnit r8) throws java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
            r0 = 0
            r9 = r0
            r0 = r8
            r1 = r6
            long r0 = r0.toNanos(r1)     // Catch: all -> 0x003d
            r10 = r0
            long r0 = java.lang.System.nanoTime()     // Catch: all -> 0x003d
            r1 = r10
            long r0 = r0 + r1
            r12 = r0
        L_0x0012:
            r0 = r5
            r1 = r10
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: all -> 0x003d, InterruptedException -> 0x002d
            java.lang.Object r0 = r0.get(r1, r2)     // Catch: all -> 0x003d, InterruptedException -> 0x002d
            r14 = r0
            r0 = r9
            if (r0 == 0) goto L_0x002a
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x002a:
            r0 = r14
            return r0
        L_0x002d:
            r14 = move-exception
            r0 = 1
            r9 = r0
            r0 = r12
            long r1 = java.lang.System.nanoTime()     // Catch: all -> 0x003d
            long r0 = r0 - r1
            r10 = r0
            goto L_0x0012
        L_0x003d:
            r15 = move-exception
            r0 = r9
            if (r0 == 0) goto L_0x004a
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x004a:
            r0 = r15
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(java.util.concurrent.Future, long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    @GwtIncompatible
    public static <E> E takeUninterruptibly(BlockingQueue<E> queue) {
        E take;
        boolean interrupted = false;
        while (true) {
            try {
                take = queue.take();
                break;
            } catch (InterruptedException e) {
                interrupted = true;
            } catch (Throwable th) {
                if (interrupted) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (interrupted) {
            Thread.currentThread().interrupt();
        }
        return take;
    }

    @GwtIncompatible
    public static <E> void putUninterruptibly(BlockingQueue<E> queue, E element) {
        boolean interrupted = false;
        while (true) {
            try {
                queue.put(element);
                break;
            } catch (InterruptedException e) {
                interrupted = true;
            } catch (Throwable th) {
                if (interrupted) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (interrupted) {
            Thread.currentThread().interrupt();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0024
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @com.google.common.annotations.GwtIncompatible
    public static void sleepUninterruptibly(long r5, java.util.concurrent.TimeUnit r7) {
        /*
            r0 = 0
            r8 = r0
            r0 = r7
            r1 = r5
            long r0 = r0.toNanos(r1)     // Catch: all -> 0x0033
            r9 = r0
            long r0 = java.lang.System.nanoTime()     // Catch: all -> 0x0033
            r1 = r9
            long r0 = r0 + r1
            r11 = r0
        L_0x0011:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: InterruptedException -> 0x0024, all -> 0x0033
            r1 = r9
            r0.sleep(r1)     // Catch: InterruptedException -> 0x0024, all -> 0x0033
            r0 = r8
            if (r0 == 0) goto L_0x0023
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0023:
            return
        L_0x0024:
            r13 = move-exception
            r0 = 1
            r8 = r0
            r0 = r11
            long r1 = java.lang.System.nanoTime()     // Catch: all -> 0x0033
            long r0 = r0 - r1
            r9 = r0
            goto L_0x0011
        L_0x0033:
            r14 = move-exception
            r0 = r8
            if (r0 == 0) goto L_0x003f
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x003f:
            r0 = r14
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly(long, java.util.concurrent.TimeUnit):void");
    }

    @GwtIncompatible
    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, long timeout, TimeUnit unit) {
        return tryAcquireUninterruptibly(semaphore, 1, timeout, unit);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x002d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @com.google.common.annotations.GwtIncompatible
    public static boolean tryAcquireUninterruptibly(java.util.concurrent.Semaphore r6, int r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r0 = 0
            r11 = r0
            r0 = r10
            r1 = r8
            long r0 = r0.toNanos(r1)     // Catch: all -> 0x003d
            r12 = r0
            long r0 = java.lang.System.nanoTime()     // Catch: all -> 0x003d
            r1 = r12
            long r0 = r0 + r1
            r14 = r0
        L_0x0013:
            r0 = r6
            r1 = r7
            r2 = r12
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: all -> 0x003d, InterruptedException -> 0x002d
            boolean r0 = r0.tryAcquire(r1, r2, r3)     // Catch: all -> 0x003d, InterruptedException -> 0x002d
            r16 = r0
            r0 = r11
            if (r0 == 0) goto L_0x002a
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x002a:
            r0 = r16
            return r0
        L_0x002d:
            r16 = move-exception
            r0 = 1
            r11 = r0
            r0 = r14
            long r1 = java.lang.System.nanoTime()     // Catch: all -> 0x003d
            long r0 = r0 - r1
            r12 = r0
            goto L_0x0013
        L_0x003d:
            r17 = move-exception
            r0 = r11
            if (r0 == 0) goto L_0x004a
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x004a:
            r0 = r17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.tryAcquireUninterruptibly(java.util.concurrent.Semaphore, int, long, java.util.concurrent.TimeUnit):boolean");
    }

    private Uninterruptibles() {
    }
}
