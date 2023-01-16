package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

@Beta
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractScheduledService.class */
public abstract class AbstractScheduledService implements Service {
    private static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
    private final AbstractService delegate = new ServiceDelegate();

    protected abstract void runOneIteration() throws Exception;

    protected abstract Scheduler scheduler();

    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractScheduledService$Scheduler.class */
    public static abstract class Scheduler {
        abstract Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable);

        public static Scheduler newFixedDelaySchedule(final long initialDelay, final long delay, final TimeUnit unit) {
            Preconditions.checkNotNull(unit);
            Preconditions.checkArgument(delay > 0, "delay must be > 0, found %s", delay);
            return new Scheduler() { // from class: com.google.common.util.concurrent.AbstractScheduledService.Scheduler.1
                @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
                public Future<?> schedule(AbstractService service, ScheduledExecutorService executor, Runnable task) {
                    return executor.scheduleWithFixedDelay(task, initialDelay, delay, unit);
                }
            };
        }

        public static Scheduler newFixedRateSchedule(final long initialDelay, final long period, final TimeUnit unit) {
            Preconditions.checkNotNull(unit);
            Preconditions.checkArgument(period > 0, "period must be > 0, found %s", period);
            return new Scheduler() { // from class: com.google.common.util.concurrent.AbstractScheduledService.Scheduler.2
                @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
                public Future<?> schedule(AbstractService service, ScheduledExecutorService executor, Runnable task) {
                    return executor.scheduleAtFixedRate(task, initialDelay, period, unit);
                }
            };
        }

        private Scheduler() {
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate.class */
    public final class ServiceDelegate extends AbstractService {
        private volatile Future<?> runningTask;
        private volatile ScheduledExecutorService executorService;
        private final ReentrantLock lock;
        private final Runnable task;

        private ServiceDelegate() {
            this.lock = new ReentrantLock();
            this.task = new Task();
        }

        /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate$Task.class */
        class Task implements Runnable {
            Task() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ServiceDelegate.this.lock.lock();
                try {
                    if (!ServiceDelegate.this.runningTask.isCancelled()) {
                        AbstractScheduledService.this.runOneIteration();
                    }
                } finally {
                    ServiceDelegate.this.lock.unlock();
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStart() {
            this.executorService = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), (Supplier<String>) new Supplier<String>() { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.1
                @Override // com.google.common.base.Supplier, java.util.function.Supplier
                public String get() {
                    return AbstractScheduledService.this.serviceName() + " " + ServiceDelegate.this.state();
                }
            });
            this.executorService.execute(new Runnable() { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.2
                @Override // java.lang.Runnable
                public void run() {
                    ServiceDelegate.this.lock.lock();
                    try {
                        AbstractScheduledService.this.startUp();
                        ServiceDelegate.this.runningTask = AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, ServiceDelegate.this.executorService, ServiceDelegate.this.task);
                        ServiceDelegate.this.notifyStarted();
                    } finally {
                        ServiceDelegate.this.lock.unlock();
                    }
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStop() {
            this.runningTask.cancel(false);
            this.executorService.execute(new Runnable() { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.3
                /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                    jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0039
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                    */
                @Override // java.lang.Runnable
                public void run() {
                    /*
                        r3 = this;
                        r0 = r3
                        com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate r0 = com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this     // Catch: Throwable -> 0x0050
                        java.util.concurrent.locks.ReentrantLock r0 = com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.access$200(r0)     // Catch: Throwable -> 0x0050
                        r0.lock()     // Catch: Throwable -> 0x0050
                        r0 = r3
                        com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate r0 = com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this     // Catch: Throwable -> 0x0050, all -> 0x0039
                        com.google.common.util.concurrent.Service$State r0 = r0.state()     // Catch: Throwable -> 0x0050, all -> 0x0039
                        com.google.common.util.concurrent.Service$State r1 = com.google.common.util.concurrent.Service.State.STOPPING     // Catch: Throwable -> 0x0050, all -> 0x0039
                        if (r0 == r1) goto L_0x0022
                        r0 = r3
                        com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate r0 = com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this     // Catch: Throwable -> 0x0050
                        java.util.concurrent.locks.ReentrantLock r0 = com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.access$200(r0)     // Catch: Throwable -> 0x0050
                        r0.unlock()     // Catch: Throwable -> 0x0050
                        return
                    L_0x0022:
                        r0 = r3
                        com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate r0 = com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this     // Catch: Throwable -> 0x0050, all -> 0x0039
                        com.google.common.util.concurrent.AbstractScheduledService r0 = com.google.common.util.concurrent.AbstractScheduledService.this     // Catch: Throwable -> 0x0050, all -> 0x0039
                        r0.shutDown()     // Catch: Throwable -> 0x0050, all -> 0x0039
                        r0 = r3
                        com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate r0 = com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this     // Catch: Throwable -> 0x0050
                        java.util.concurrent.locks.ReentrantLock r0 = com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.access$200(r0)     // Catch: Throwable -> 0x0050
                        r0.unlock()     // Catch: Throwable -> 0x0050
                        goto L_0x0046
                    L_0x0039:
                        r4 = move-exception
                        r0 = r3
                        com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate r0 = com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this     // Catch: Throwable -> 0x0050
                        java.util.concurrent.locks.ReentrantLock r0 = com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.access$200(r0)     // Catch: Throwable -> 0x0050
                        r0.unlock()     // Catch: Throwable -> 0x0050
                        r0 = r4
                        throw r0     // Catch: Throwable -> 0x0050
                    L_0x0046:
                        r0 = r3
                        com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate r0 = com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this     // Catch: Throwable -> 0x0050
                        r0.notifyStopped()     // Catch: Throwable -> 0x0050
                        goto L_0x0059
                    L_0x0050:
                        r4 = move-exception
                        r0 = r3
                        com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate r0 = com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this
                        r1 = r4
                        r0.notifyFailed(r1)
                    L_0x0059:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.RunnableC05573.run():void");
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractScheduledService.this.toString();
        }
    }

    protected AbstractScheduledService() {
    }

    protected void startUp() throws Exception {
    }

    protected void shutDown() throws Exception {
    }

    protected ScheduledExecutorService executor() {
        final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.google.common.util.concurrent.AbstractScheduledService.1ThreadFactoryImpl
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return MoreExecutors.newThread(AbstractScheduledService.this.serviceName(), runnable);
            }
        });
        addListener(new Service.Listener() { // from class: com.google.common.util.concurrent.AbstractScheduledService.1
            @Override // com.google.common.util.concurrent.Service.Listener
            public void terminated(Service.State from) {
                executor.shutdown();
            }

            @Override // com.google.common.util.concurrent.Service.Listener
            public void failed(Service.State from, Throwable failure) {
                executor.shutdown();
            }
        }, MoreExecutors.directExecutor());
        return executor;
    }

    protected String serviceName() {
        return getClass().getSimpleName();
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

    @Beta
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractScheduledService$CustomScheduler.class */
    public static abstract class CustomScheduler extends Scheduler {
        protected abstract Schedule getNextSchedule() throws Exception;

        public CustomScheduler() {
            super();
        }

        /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractScheduledService$CustomScheduler$ReschedulableCallable.class */
        private class ReschedulableCallable extends ForwardingFuture<Void> implements Callable<Void> {
            private final Runnable wrappedRunnable;
            private final ScheduledExecutorService executor;
            private final AbstractService service;
            private final ReentrantLock lock = new ReentrantLock();
            @GuardedBy("lock")
            private Future<Void> currentFuture;

            ReschedulableCallable(AbstractService service, ScheduledExecutorService executor, Runnable runnable) {
                this.wrappedRunnable = runnable;
                this.executor = executor;
                this.service = service;
            }

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                this.wrappedRunnable.run();
                reschedule();
                return null;
            }

            public void reschedule() {
                try {
                    Schedule schedule = CustomScheduler.this.getNextSchedule();
                    Throwable scheduleFailure = null;
                    this.lock.lock();
                    try {
                        if (this.currentFuture == null || !this.currentFuture.isCancelled()) {
                            this.currentFuture = this.executor.schedule(this, schedule.delay, schedule.unit);
                        }
                        this.lock.unlock();
                    } catch (Throwable th) {
                        this.lock.unlock();
                        throw th;
                    }
                    if (scheduleFailure != null) {
                        this.service.notifyFailed(scheduleFailure);
                    }
                } catch (Throwable t) {
                    this.service.notifyFailed(t);
                }
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean mayInterruptIfRunning) {
                this.lock.lock();
                try {
                    return this.currentFuture.cancel(mayInterruptIfRunning);
                } finally {
                    this.lock.unlock();
                }
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean isCancelled() {
                this.lock.lock();
                try {
                    return this.currentFuture.isCancelled();
                } finally {
                    this.lock.unlock();
                }
            }

            /* access modifiers changed from: protected */
            @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
            public Future<Void> delegate() {
                throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
            }
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        final Future<?> schedule(AbstractService service, ScheduledExecutorService executor, Runnable runnable) {
            ReschedulableCallable task = new ReschedulableCallable(service, executor, runnable);
            task.reschedule();
            return task;
        }

        /* access modifiers changed from: protected */
        @Beta
        /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AbstractScheduledService$CustomScheduler$Schedule.class */
        public static final class Schedule {
            private final long delay;
            private final TimeUnit unit;

            public Schedule(long delay, TimeUnit unit) {
                this.delay = delay;
                this.unit = (TimeUnit) Preconditions.checkNotNull(unit);
            }
        }
    }
}
