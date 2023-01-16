package nonapi.p019io.github.classgraph.concurrency;

import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import nonapi.p019io.github.classgraph.utils.LogNode;

/* renamed from: nonapi.io.github.classgraph.concurrency.WorkQueue */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/concurrency/WorkQueue.class */
public class WorkQueue<T> implements AutoCloseable {
    private final WorkUnitProcessor<T> workUnitProcessor;
    private final int numWorkers;
    private final InterruptionChecker interruptionChecker;
    private final LogNode log;
    private final BlockingQueue<WorkUnitWrapper<T>> workUnits = new LinkedBlockingQueue();
    private final AtomicInteger numIncompleteWorkUnits = new AtomicInteger();
    private final ConcurrentLinkedQueue<Future<?>> workerFutures = new ConcurrentLinkedQueue<>();

    /* renamed from: nonapi.io.github.classgraph.concurrency.WorkQueue$WorkUnitProcessor */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/concurrency/WorkQueue$WorkUnitProcessor.class */
    public interface WorkUnitProcessor<T> {
        void processWorkUnit(T t, WorkQueue<T> workQueue, LogNode logNode) throws InterruptedException;
    }

    /* access modifiers changed from: private */
    /* renamed from: nonapi.io.github.classgraph.concurrency.WorkQueue$WorkUnitWrapper */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/concurrency/WorkQueue$WorkUnitWrapper.class */
    public static class WorkUnitWrapper<T> {
        final T workUnit;

        public WorkUnitWrapper(T workUnit) {
            this.workUnit = workUnit;
        }
    }

    public static <U> void runWorkQueue(Collection<U> elements, ExecutorService executorService, InterruptionChecker interruptionChecker, int numParallelTasks, LogNode log, WorkUnitProcessor<U> workUnitProcessor) throws InterruptedException, ExecutionException {
        if (!elements.isEmpty()) {
            WorkQueue<U> workQueue = new WorkQueue<>(elements, workUnitProcessor, numParallelTasks, interruptionChecker, log);
            Throwable th = null;
            try {
                workQueue.startWorkers(executorService, numParallelTasks - 1);
                workQueue.runWorkLoop();
                if (workQueue == null) {
                    return;
                }
                if (0 != 0) {
                    try {
                        workQueue.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                } else {
                    workQueue.close();
                }
            } catch (Throwable th3) {
                if (workQueue != null) {
                    if (0 != 0) {
                        try {
                            workQueue.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        workQueue.close();
                    }
                }
                throw th3;
            }
        }
    }

    private WorkQueue(Collection<T> initialWorkUnits, WorkUnitProcessor<T> workUnitProcessor, int numWorkers, InterruptionChecker interruptionChecker, LogNode log) {
        this.workUnitProcessor = workUnitProcessor;
        this.numWorkers = numWorkers;
        this.interruptionChecker = interruptionChecker;
        this.log = log;
        addWorkUnits(initialWorkUnits);
    }

    private void startWorkers(ExecutorService executorService, int numTasks) {
        for (int i = 0; i < numTasks; i++) {
            this.workerFutures.add(executorService.submit(new Callable<Void>() { // from class: nonapi.io.github.classgraph.concurrency.WorkQueue.1
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    WorkQueue.this.runWorkLoop();
                    return null;
                }
            }));
        }
    }

    private void sendPoisonPills() {
        for (int i = 0; i < this.numWorkers; i++) {
            this.workUnits.add(new WorkUnitWrapper<>(null));
        }
    }

    /* access modifiers changed from: private */
    public void runWorkLoop() throws InterruptedException, ExecutionException {
        while (true) {
            this.interruptionChecker.check();
            WorkUnitWrapper<T> workUnitWrapper = this.workUnits.take();
            if (workUnitWrapper.workUnit != null) {
                try {
                    try {
                        this.workUnitProcessor.processWorkUnit(workUnitWrapper.workUnit, this, this.log);
                        if (this.numIncompleteWorkUnits.decrementAndGet() == 0) {
                            sendPoisonPills();
                        }
                    } catch (InterruptedException | OutOfMemoryError e) {
                        this.workUnits.clear();
                        sendPoisonPills();
                        throw e;
                    } catch (RuntimeException e2) {
                        this.workUnits.clear();
                        sendPoisonPills();
                        throw new ExecutionException("Worker thread threw unchecked exception", e2);
                    }
                } catch (Throwable th) {
                    if (this.numIncompleteWorkUnits.decrementAndGet() == 0) {
                        sendPoisonPills();
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    public void addWorkUnit(T workUnit) {
        if (workUnit == null) {
            throw new NullPointerException("workUnit cannot be null");
        }
        this.numIncompleteWorkUnits.incrementAndGet();
        this.workUnits.add(new WorkUnitWrapper<>(workUnit));
    }

    public void addWorkUnits(Collection<T> workUnits) {
        for (T workUnit : workUnits) {
            addWorkUnit(workUnit);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() throws ExecutionException {
        while (true) {
            Future<?> future = this.workerFutures.poll();
            if (future != null) {
                try {
                    future.get();
                } catch (InterruptedException e) {
                    if (this.log != null) {
                        this.log.log("~", "Worker thread was interrupted");
                    }
                    this.interruptionChecker.interrupt();
                } catch (CancellationException e2) {
                    if (this.log != null) {
                        this.log.log("~", "Worker thread was cancelled");
                    }
                } catch (ExecutionException e3) {
                    this.interruptionChecker.setExecutionException(e3);
                    this.interruptionChecker.interrupt();
                }
            } else {
                return;
            }
        }
    }
}
