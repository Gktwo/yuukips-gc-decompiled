package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/Callables.class */
public final class Callables {
    private Callables() {
    }

    public static <T> Callable<T> returning(final T value) {
        return new Callable<T>() { // from class: com.google.common.util.concurrent.Callables.1
            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            @Override // java.util.concurrent.Callable
            public T call() {
                return value;
            }
        };
    }

    @Beta
    @GwtIncompatible
    public static <T> AsyncCallable<T> asAsyncCallable(final Callable<T> callable, final ListeningExecutorService listeningExecutorService) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(listeningExecutorService);
        return new AsyncCallable<T>() { // from class: com.google.common.util.concurrent.Callables.2
            @Override // com.google.common.util.concurrent.AsyncCallable
            public ListenableFuture<T> call() throws Exception {
                return listeningExecutorService.submit(callable);
            }
        };
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public static <T> Callable<T> threadRenaming(final Callable<T> callable, final Supplier<String> nameSupplier) {
        Preconditions.checkNotNull(nameSupplier);
        Preconditions.checkNotNull(callable);
        return new Callable<T>() { // from class: com.google.common.util.concurrent.Callables.3
            /* JADX WARN: Type inference failed for: r0v14, types: [T, java.lang.Object] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public T call() throws java.lang.Exception {
                /*
                    r3 = this;
                    java.lang.Thread r0 = java.lang.Thread.currentThread()
                    r4 = r0
                    r0 = r4
                    java.lang.String r0 = r0.getName()
                    r5 = r0
                    r0 = r3
                    com.google.common.base.Supplier r0 = r6
                    java.lang.Object r0 = r0.get()
                    java.lang.String r0 = (java.lang.String) r0
                    r1 = r4
                    boolean r0 = com.google.common.util.concurrent.Callables.access$000(r0, r1)
                    r6 = r0
                    r0 = r3
                    java.util.concurrent.Callable r0 = r5     // Catch: all -> 0x0033
                    java.lang.Object r0 = r0.call()     // Catch: all -> 0x0033
                    r7 = r0
                    r0 = r6
                    if (r0 == 0) goto L_0x0030
                    r0 = r5
                    r1 = r4
                    boolean r0 = com.google.common.util.concurrent.Callables.access$000(r0, r1)
                    r8 = r0
                L_0x0030:
                    r0 = r7
                    return r0
                L_0x0033:
                    r9 = move-exception
                    r0 = r6
                    if (r0 == 0) goto L_0x0040
                    r0 = r5
                    r1 = r4
                    boolean r0 = com.google.common.util.concurrent.Callables.access$000(r0, r1)
                    r10 = r0
                L_0x0040:
                    r0 = r9
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Callables.CallableC05683.call():java.lang.Object");
            }
        };
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public static Runnable threadRenaming(final Runnable task, final Supplier<String> nameSupplier) {
        Preconditions.checkNotNull(nameSupplier);
        Preconditions.checkNotNull(task);
        return new Runnable() { // from class: com.google.common.util.concurrent.Callables.4
            @Override // java.lang.Runnable
            public void run() {
                Thread currentThread = Thread.currentThread();
                String oldName = currentThread.getName();
                boolean restoreName = Callables.trySetName((String) nameSupplier.get(), currentThread);
                try {
                    task.run();
                    if (restoreName) {
                        Callables.trySetName(oldName, currentThread);
                    }
                } catch (Throwable th) {
                    if (restoreName) {
                        Callables.trySetName(oldName, currentThread);
                    }
                    throw th;
                }
            }
        };
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    public static boolean trySetName(String threadName, Thread currentThread) {
        try {
            currentThread.setName(threadName);
            return true;
        } catch (SecurityException e) {
            return false;
        }
    }
}
