package p013io.netty.util.concurrent;

import p013io.netty.util.internal.ObjectUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.concurrent.FastThreadLocalRunnable */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/FastThreadLocalRunnable.class */
public final class FastThreadLocalRunnable implements Runnable {
    private final Runnable runnable;

    private FastThreadLocalRunnable(Runnable runnable) {
        this.runnable = (Runnable) ObjectUtil.checkNotNull(runnable, "runnable");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.runnable.run();
        } finally {
            FastThreadLocal.removeAll();
        }
    }

    /* access modifiers changed from: package-private */
    public static Runnable wrap(Runnable runnable) {
        return runnable instanceof FastThreadLocalRunnable ? runnable : new FastThreadLocalRunnable(runnable);
    }
}
