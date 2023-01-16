package p013io.netty.util.concurrent;

/* renamed from: io.netty.util.concurrent.DefaultProgressivePromise */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/DefaultProgressivePromise.class */
public class DefaultProgressivePromise<V> extends DefaultPromise<V> implements ProgressivePromise<V> {
    public DefaultProgressivePromise(EventExecutor executor) {
        super(executor);
    }

    /* access modifiers changed from: protected */
    public DefaultProgressivePromise() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r0 > 0) goto L_0x0020;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p013io.netty.util.concurrent.ProgressivePromise
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p013io.netty.util.concurrent.ProgressivePromise<V> setProgress(long r7, long r9) {
        /*
            r6 = this;
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0014
            r0 = -1
            r9 = r0
            r0 = r7
            java.lang.String r1 = "progress"
            long r0 = p013io.netty.util.internal.ObjectUtil.checkPositiveOrZero(r0, r1)
            goto L_0x0049
        L_0x0014:
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0020
            r0 = r7
            r1 = r9
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0049
        L_0x0020:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "progress: "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " (expected: 0 <= progress <= total ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r9
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "))"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0049:
            r0 = r6
            boolean r0 = r0.isDone()
            if (r0 == 0) goto L_0x005a
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "complete already"
            r1.<init>(r2)
            throw r0
        L_0x005a:
            r0 = r6
            r1 = r7
            r2 = r9
            r0.notifyProgressiveListeners(r1, r2)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.concurrent.DefaultProgressivePromise.setProgress(long, long):io.netty.util.concurrent.ProgressivePromise");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p013io.netty.util.concurrent.ProgressivePromise
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean tryProgress(long r7, long r9) {
        /*
            r6 = this;
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0019
            r0 = -1
            r9 = r0
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0017
            r0 = r6
            boolean r0 = r0.isDone()
            if (r0 == 0) goto L_0x002e
        L_0x0017:
            r0 = 0
            return r0
        L_0x0019:
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x002c
            r0 = r7
            r1 = r9
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x002c
            r0 = r6
            boolean r0 = r0.isDone()
            if (r0 == 0) goto L_0x002e
        L_0x002c:
            r0 = 0
            return r0
        L_0x002e:
            r0 = r6
            r1 = r7
            r2 = r9
            r0.notifyProgressiveListeners(r1, r2)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.concurrent.DefaultProgressivePromise.tryProgress(long, long):boolean");
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ProgressivePromise<V> addListener(GenericFutureListener<? extends Future<? super V>> listener) {
        addListener((GenericFutureListener) listener);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ProgressivePromise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... listeners) {
        addListeners((GenericFutureListener[]) listeners);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ProgressivePromise<V> removeListener(GenericFutureListener<? extends Future<? super V>> listener) {
        removeListener((GenericFutureListener) listener);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ProgressivePromise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... listeners) {
        removeListeners((GenericFutureListener[]) listeners);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ProgressivePromise<V> sync() throws InterruptedException {
        sync();
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ProgressivePromise<V> syncUninterruptibly() {
        syncUninterruptibly();
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ProgressivePromise<V> await() throws InterruptedException {
        await();
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ProgressivePromise<V> awaitUninterruptibly() {
        awaitUninterruptibly();
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise<V> setSuccess(V result) {
        setSuccess((DefaultProgressivePromise<V>) result);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Promise, p013io.netty.channel.ChannelPromise
    public ProgressivePromise<V> setFailure(Throwable cause) {
        setFailure(cause);
        return this;
    }
}
