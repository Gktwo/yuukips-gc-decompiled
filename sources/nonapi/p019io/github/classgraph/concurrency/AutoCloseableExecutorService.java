package nonapi.p019io.github.classgraph.concurrency;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p013io.github.classgraph.ClassGraphException;

/* renamed from: nonapi.io.github.classgraph.concurrency.AutoCloseableExecutorService */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/concurrency/AutoCloseableExecutorService.class */
public class AutoCloseableExecutorService extends ThreadPoolExecutor implements AutoCloseable {
    public final InterruptionChecker interruptionChecker = new InterruptionChecker();

    public AutoCloseableExecutorService(int numThreads) {
        super(numThreads, numThreads, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new SimpleThreadFactory("ClassGraph-worker-", true));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable throwable) {
        afterExecute(runnable, throwable);
        if (throwable != null) {
            this.interruptionChecker.setExecutionException(new ExecutionException("Uncaught exception", throwable));
            this.interruptionChecker.interrupt();
        } else if (runnable instanceof Future) {
            try {
                ((Future) runnable).get();
            } catch (InterruptedException | CancellationException e) {
                this.interruptionChecker.interrupt();
            } catch (ExecutionException e2) {
                this.interruptionChecker.setExecutionException(e2);
                this.interruptionChecker.interrupt();
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        try {
            shutdown();
        } catch (SecurityException e) {
        }
        boolean terminated = false;
        try {
            terminated = awaitTermination(2500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            this.interruptionChecker.interrupt();
        }
        if (!terminated) {
            try {
                shutdownNow();
            } catch (SecurityException e3) {
                throw ClassGraphException.newClassGraphException("Could not shut down ExecutorService -- need java.lang.RuntimePermission(\"modifyThread\"), or the security manager's checkAccess method denies access", e3);
            }
        }
    }
}
