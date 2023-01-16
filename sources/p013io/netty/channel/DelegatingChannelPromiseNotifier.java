package p013io.netty.channel;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import net.bytebuddy.implementation.MethodDelegation;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PromiseNotificationUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.DelegatingChannelPromiseNotifier */
/* loaded from: grasscutter.jar:io/netty/channel/DelegatingChannelPromiseNotifier.class */
public final class DelegatingChannelPromiseNotifier implements ChannelPromise, ChannelFutureListener {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DelegatingChannelPromiseNotifier.class);
    private final ChannelPromise delegate;
    private final boolean logNotifyFailure;

    public DelegatingChannelPromiseNotifier(ChannelPromise delegate) {
        this(delegate, !(delegate instanceof VoidChannelPromise));
    }

    public DelegatingChannelPromiseNotifier(ChannelPromise delegate, boolean logNotifyFailure) {
        this.delegate = (ChannelPromise) ObjectUtil.checkNotNull(delegate, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.logNotifyFailure = logNotifyFailure;
    }

    public void operationComplete(ChannelFuture future) throws Exception {
        InternalLogger internalLogger = this.logNotifyFailure ? logger : null;
        if (future.isSuccess()) {
            PromiseNotificationUtil.trySuccess(this.delegate, (Void) future.get(), internalLogger);
        } else if (future.isCancelled()) {
            PromiseNotificationUtil.tryCancel(this.delegate, internalLogger);
        } else {
            PromiseNotificationUtil.tryFailure(this.delegate, future.cause(), internalLogger);
        }
    }

    @Override // p013io.netty.channel.ChannelPromise, p013io.netty.channel.ChannelFuture
    public Channel channel() {
        return this.delegate.channel();
    }

    @Override // p013io.netty.channel.ChannelPromise
    public ChannelPromise setSuccess(Void result) {
        this.delegate.setSuccess(result);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPromise
    public ChannelPromise setSuccess() {
        this.delegate.setSuccess();
        return this;
    }

    @Override // p013io.netty.channel.ChannelPromise
    public boolean trySuccess() {
        return this.delegate.trySuccess();
    }

    public boolean trySuccess(Void result) {
        return this.delegate.trySuccess(result);
    }

    @Override // p013io.netty.channel.ChannelPromise
    public ChannelPromise setFailure(Throwable cause) {
        this.delegate.setFailure(cause);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPromise, p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    public ChannelPromise addListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        this.delegate.addListener(listener);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPromise, p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    public ChannelPromise addListeners(GenericFutureListener<? extends Future<? super Void>>... listeners) {
        this.delegate.addListeners(listeners);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPromise, p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    public ChannelPromise removeListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        this.delegate.removeListener(listener);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPromise, p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    public ChannelPromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... listeners) {
        this.delegate.removeListeners(listeners);
        return this;
    }

    @Override // p013io.netty.util.concurrent.Promise
    public boolean tryFailure(Throwable cause) {
        return this.delegate.tryFailure(cause);
    }

    @Override // p013io.netty.util.concurrent.Promise
    public boolean setUncancellable() {
        return this.delegate.setUncancellable();
    }

    @Override // p013io.netty.channel.ChannelPromise, p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    public ChannelPromise await() throws InterruptedException {
        this.delegate.await();
        return this;
    }

    @Override // p013io.netty.channel.ChannelPromise, p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    public ChannelPromise awaitUninterruptibly() {
        this.delegate.awaitUninterruptibly();
        return this;
    }

    @Override // p013io.netty.channel.ChannelFuture
    public boolean isVoid() {
        return this.delegate.isVoid();
    }

    @Override // p013io.netty.channel.ChannelPromise
    public ChannelPromise unvoid() {
        return isVoid() ? new DelegatingChannelPromiseNotifier(this.delegate.unvoid()) : this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        return this.delegate.await(timeout, unit);
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean await(long timeoutMillis) throws InterruptedException {
        return this.delegate.await(timeoutMillis);
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long timeout, TimeUnit unit) {
        return this.delegate.awaitUninterruptibly(timeout, unit);
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long timeoutMillis) {
        return this.delegate.awaitUninterruptibly(timeoutMillis);
    }

    @Override // p013io.netty.util.concurrent.Future
    public Void getNow() {
        return this.delegate.getNow();
    }

    @Override // p013io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        return this.delegate.cancel(mayInterruptIfRunning);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.delegate.isDone();
    }

    @Override // java.util.concurrent.Future
    public Void get() throws InterruptedException, ExecutionException {
        return (Void) this.delegate.get();
    }

    @Override // java.util.concurrent.Future
    public Void get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return (Void) this.delegate.get(timeout, unit);
    }

    @Override // p013io.netty.channel.ChannelPromise, p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    public ChannelPromise sync() throws InterruptedException {
        this.delegate.sync();
        return this;
    }

    @Override // p013io.netty.channel.ChannelPromise, p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    public ChannelPromise syncUninterruptibly() {
        this.delegate.syncUninterruptibly();
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return this.delegate.isSuccess();
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return this.delegate.isCancellable();
    }

    @Override // p013io.netty.util.concurrent.Future
    public Throwable cause() {
        return this.delegate.cause();
    }
}
