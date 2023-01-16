package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

@Beta
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractExecutionThreadService.class */
public abstract class AbstractExecutionThreadService implements Service {
    private static final Logger logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    private final Service delegate = new AbstractService() { // from class: com.google.common.util.concurrent.AbstractExecutionThreadService.1
        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStart() {
            MoreExecutors.renamingDecorator(AbstractExecutionThreadService.this.executor(), new Supplier<String>() { // from class: com.google.common.util.concurrent.AbstractExecutionThreadService.1.1
                @Override // com.google.common.base.Supplier, java.util.function.Supplier
                public String get() {
                    return AbstractExecutionThreadService.this.serviceName();
                }
            }).execute(new Runnable() { // from class: com.google.common.util.concurrent.AbstractExecutionThreadService.1.2
                /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                    jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:5:0x0028
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                    */
                @Override // java.lang.Runnable
                public void run() {
                    /*
                        r5 = this;
                        r0 = r5
                        com.google.common.util.concurrent.AbstractExecutionThreadService$1 r0 = com.google.common.util.concurrent.AbstractExecutionThreadService.C05421.this     // Catch: Throwable -> 0x0060
                        com.google.common.util.concurrent.AbstractExecutionThreadService r0 = com.google.common.util.concurrent.AbstractExecutionThreadService.this     // Catch: Throwable -> 0x0060
                        r0.startUp()     // Catch: Throwable -> 0x0060
                        r0 = r5
                        com.google.common.util.concurrent.AbstractExecutionThreadService$1 r0 = com.google.common.util.concurrent.AbstractExecutionThreadService.C05421.this     // Catch: Throwable -> 0x0060
                        r0.notifyStarted()     // Catch: Throwable -> 0x0060
                        r0 = r5
                        com.google.common.util.concurrent.AbstractExecutionThreadService$1 r0 = com.google.common.util.concurrent.AbstractExecutionThreadService.C05421.this     // Catch: Throwable -> 0x0060
                        boolean r0 = r0.isRunning()     // Catch: Throwable -> 0x0060
                        if (r0 == 0) goto L_0x004c
                        r0 = r5
                        com.google.common.util.concurrent.AbstractExecutionThreadService$1 r0 = com.google.common.util.concurrent.AbstractExecutionThreadService.C05421.this     // Catch: Throwable -> 0x0060, Throwable -> 0x0028
                        com.google.common.util.concurrent.AbstractExecutionThreadService r0 = com.google.common.util.concurrent.AbstractExecutionThreadService.this     // Catch: Throwable -> 0x0060, Throwable -> 0x0028
                        r0.run()     // Catch: Throwable -> 0x0060, Throwable -> 0x0028
                        goto L_0x004c
                    L_0x0028:
                        r6 = move-exception
                        r0 = r5
                        com.google.common.util.concurrent.AbstractExecutionThreadService$1 r0 = com.google.common.util.concurrent.AbstractExecutionThreadService.C05421.this     // Catch: Throwable -> 0x0060, Exception -> 0x0036
                        com.google.common.util.concurrent.AbstractExecutionThreadService r0 = com.google.common.util.concurrent.AbstractExecutionThreadService.this     // Catch: Throwable -> 0x0060, Exception -> 0x0036
                        r0.shutDown()     // Catch: Throwable -> 0x0060, Exception -> 0x0036
                        goto L_0x0043
                    L_0x0036:
                        r7 = move-exception
                        java.util.logging.Logger r0 = com.google.common.util.concurrent.AbstractExecutionThreadService.access$000()     // Catch: Throwable -> 0x0060
                        java.util.logging.Level r1 = java.util.logging.Level.WARNING     // Catch: Throwable -> 0x0060
                        java.lang.String r2 = "Error while attempting to shut down the service after failure."
                        r3 = r7
                        r0.log(r1, r2, r3)     // Catch: Throwable -> 0x0060
                    L_0x0043:
                        r0 = r5
                        com.google.common.util.concurrent.AbstractExecutionThreadService$1 r0 = com.google.common.util.concurrent.AbstractExecutionThreadService.C05421.this     // Catch: Throwable -> 0x0060
                        r1 = r6
                        r0.notifyFailed(r1)     // Catch: Throwable -> 0x0060
                        return
                    L_0x004c:
                        r0 = r5
                        com.google.common.util.concurrent.AbstractExecutionThreadService$1 r0 = com.google.common.util.concurrent.AbstractExecutionThreadService.C05421.this     // Catch: Throwable -> 0x0060
                        com.google.common.util.concurrent.AbstractExecutionThreadService r0 = com.google.common.util.concurrent.AbstractExecutionThreadService.this     // Catch: Throwable -> 0x0060
                        r0.shutDown()     // Catch: Throwable -> 0x0060
                        r0 = r5
                        com.google.common.util.concurrent.AbstractExecutionThreadService$1 r0 = com.google.common.util.concurrent.AbstractExecutionThreadService.C05421.this     // Catch: Throwable -> 0x0060
                        r0.notifyStopped()     // Catch: Throwable -> 0x0060
                        goto L_0x0069
                    L_0x0060:
                        r6 = move-exception
                        r0 = r5
                        com.google.common.util.concurrent.AbstractExecutionThreadService$1 r0 = com.google.common.util.concurrent.AbstractExecutionThreadService.C05421.this
                        r1 = r6
                        r0.notifyFailed(r1)
                    L_0x0069:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractExecutionThreadService.C05421.RunnableC05442.run():void");
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected void doStop() {
            AbstractExecutionThreadService.this.triggerShutdown();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractExecutionThreadService.this.toString();
        }
    };

    protected abstract void run() throws Exception;

    protected AbstractExecutionThreadService() {
    }

    protected void startUp() throws Exception {
    }

    protected void shutDown() throws Exception {
    }

    protected void triggerShutdown() {
    }

    protected Executor executor() {
        return new Executor() { // from class: com.google.common.util.concurrent.AbstractExecutionThreadService.2
            @Override // java.util.concurrent.Executor
            public void execute(Runnable command) {
                MoreExecutors.newThread(AbstractExecutionThreadService.this.serviceName(), command).start();
            }
        };
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long timeout, TimeUnit unit) throws TimeoutException {
        this.delegate.awaitRunning(timeout, unit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long timeout, TimeUnit unit) throws TimeoutException {
        this.delegate.awaitTerminated(timeout, unit);
    }

    protected String serviceName() {
        return getClass().getSimpleName();
    }
}
