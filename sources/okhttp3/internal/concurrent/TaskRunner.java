package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;

/* compiled from: TaskRunner.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��J\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010\t\n��\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\r\u0018�� #2\u00020\u0001:\u0003\"#$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u001c\u001a\u00020\u0016J\u0015\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\tH��¢\u0006\u0002\b\u001fJ\u0006\u0010 \u001a\u00020\tJ\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n��R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n��R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n��R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n��R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n��¨\u0006%"}, m373d2 = {"Lokhttp3/internal/concurrent/TaskRunner;", "", "backend", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "(Lokhttp3/internal/concurrent/TaskRunner$Backend;)V", "getBackend", "()Lokhttp3/internal/concurrent/TaskRunner$Backend;", "busyQueues", "", "Lokhttp3/internal/concurrent/TaskQueue;", "coordinatorWaiting", "", "coordinatorWakeUpAt", "", "nextQueueName", "", "readyQueues", "runnable", "Ljava/lang/Runnable;", "activeQueues", "", "afterRun", "", "task", "Lokhttp3/internal/concurrent/Task;", "delayNanos", "awaitTaskToRun", "beforeRun", "cancelAll", "kickCoordinator", "taskQueue", "kickCoordinator$okhttp", "newQueue", "runTask", "Backend", "Companion", "RealBackend", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/concurrent/TaskRunner.class */
public final class TaskRunner {
    @NotNull
    private final Backend backend;
    private boolean coordinatorWaiting;
    private long coordinatorWakeUpAt;
    @NotNull
    private static final Logger logger;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final TaskRunner INSTANCE = new TaskRunner(new RealBackend(Util.threadFactory(Intrinsics.stringPlus(Util.okHttpName, " TaskRunner"), true)));
    private int nextQueueName = 10000;
    @NotNull
    private final List<TaskQueue> busyQueues = new ArrayList();
    @NotNull
    private final List<TaskQueue> readyQueues = new ArrayList();
    @NotNull
    private final Runnable runnable = new Runnable(this) { // from class: okhttp3.internal.concurrent.TaskRunner$runnable$1
        final /* synthetic */ TaskRunner this$0;

        /* access modifiers changed from: package-private */
        {
            this.this$0 = $receiver;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r11v2, types: [long] */
        /* JADX WARN: Type inference failed for: r11v5 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            // Method dump skipped, instructions count: 276
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.concurrent.TaskRunner$runnable$1.run():void");
        }
    };

    /* compiled from: TaskRunner.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��(\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018��2\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\tH&¨\u0006\u000e"}, m373d2 = {"Lokhttp3/internal/concurrent/TaskRunner$Backend;", "", "beforeTask", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/concurrent/TaskRunner$Backend.class */
    public interface Backend {
        void beforeTask(@NotNull TaskRunner taskRunner);

        long nanoTime();

        void coordinatorNotify(@NotNull TaskRunner taskRunner);

        void coordinatorWait(@NotNull TaskRunner taskRunner, long j);

        void execute(@NotNull Runnable runnable);
    }

    public TaskRunner(@NotNull Backend backend) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        this.backend = backend;
    }

    @NotNull
    public final Backend getBackend() {
        return this.backend;
    }

    public final void kickCoordinator$okhttp(@NotNull TaskQueue taskQueue) {
        Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            if (taskQueue.getActiveTask$okhttp() == null) {
                if (!taskQueue.getFutureTasks$okhttp().isEmpty()) {
                    Util.addIfAbsent(this.readyQueues, taskQueue);
                } else {
                    this.readyQueues.remove(taskQueue);
                }
            }
            if (this.coordinatorWaiting) {
                this.backend.coordinatorNotify(this);
            } else {
                this.backend.execute(this.runnable);
            }
        } else {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
    }

    private final void beforeRun(Task task) {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            task.setNextExecuteNanoTime$okhttp(-1);
            TaskQueue queue = task.getQueue$okhttp();
            Intrinsics.checkNotNull(queue);
            queue.getFutureTasks$okhttp().remove(task);
            this.readyQueues.remove(queue);
            queue.setActiveTask$okhttp(task);
            this.busyQueues.add(queue);
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0054 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: okhttp3.internal.concurrent.TaskRunner */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r0v20, types: [long] */
    /* JADX WARN: Type inference failed for: r12v3, types: [long] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void runTask(okhttp3.internal.concurrent.Task r6) {
        /*
            r5 = this;
            r0 = r5
            r7 = r0
            r0 = 0
            r8 = r0
            boolean r0 = okhttp3.internal.Util.assertionsEnabled
            if (r0 == 0) goto L_0x003a
            r0 = r7
            boolean r0 = java.lang.Thread.holdsLock(r0)
            if (r0 == 0) goto L_0x003a
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Thread "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.String r3 = r3.getName()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " MUST NOT hold lock on "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x003a:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r7 = r0
            r0 = r7
            java.lang.String r0 = r0.getName()
            r8 = r0
            r0 = r7
            r1 = r6
            java.lang.String r1 = r1.getName()
            r0.setName(r1)
            r0 = 0
            r12 = r0
            r0 = -1
            r12 = r0
            r0 = r6
            long r0 = r0.runOnce()     // Catch: all -> 0x0088
            r12 = r0
            r0 = r5
            r9 = r0
            r0 = r9
            monitor-enter(r0)
            r0 = 0
            r10 = r0
            r0 = r5
            r1 = r6
            r2 = r12
            r0.afterRun(r1, r2)     // Catch: all -> 0x0078
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: all -> 0x0078
            r10 = r0
            r0 = r9
            monitor-exit(r0)
            goto L_0x0080
        L_0x0078:
            r10 = move-exception
            r0 = r9
            monitor-exit(r0)
            r0 = r10
            throw r0
        L_0x0080:
            r0 = r7
            r1 = r8
            r0.setName(r1)
            goto L_0x00b7
        L_0x0088:
            r9 = move-exception
            r0 = r5
            r10 = r0
            r0 = r10
            monitor-enter(r0)
            r0 = 0
            r11 = r0
            r0 = r5
            r1 = r6
            r2 = r12
            r0.afterRun(r1, r2)     // Catch: all -> 0x00a7
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: all -> 0x00a7
            r11 = r0
            r0 = r10
            monitor-exit(r0)
            goto L_0x00af
        L_0x00a7:
            r11 = move-exception
            r0 = r10
            monitor-exit(r0)
            r0 = r11
            throw r0
        L_0x00af:
            r0 = r7
            r1 = r8
            r0.setName(r1)
            r0 = r9
            throw r0
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.concurrent.TaskRunner.runTask(okhttp3.internal.concurrent.Task):void");
    }

    private final void afterRun(Task task, long delayNanos) {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            TaskQueue queue = task.getQueue$okhttp();
            Intrinsics.checkNotNull(queue);
            if (!(queue.getActiveTask$okhttp() == task)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            boolean cancelActiveTask = queue.getCancelActiveTask$okhttp();
            queue.setCancelActiveTask$okhttp(false);
            queue.setActiveTask$okhttp(null);
            this.busyQueues.remove(queue);
            if (delayNanos != -1 && !cancelActiveTask && !queue.getShutdown$okhttp()) {
                queue.scheduleAndDecide$okhttp(task, delayNanos, true);
            }
            if (!queue.getFutureTasks$okhttp().isEmpty()) {
                this.readyQueues.add(queue);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:65:0x0069 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x00c8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x0069 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v48, types: [okhttp3.internal.concurrent.TaskRunner$Backend] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [long] */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00f4, code lost:
        if ((!r7.readyQueues.isEmpty()) != false) goto L_0x00f7;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okhttp3.internal.concurrent.Task awaitTaskToRun() {
        /*
        // Method dump skipped, instructions count: 349
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.concurrent.TaskRunner.awaitTaskToRun():okhttp3.internal.concurrent.Task");
    }

    @NotNull
    public final TaskQueue newQueue() {
        int name;
        synchronized (this) {
            name = this.nextQueueName;
            this.nextQueueName = name + 1;
        }
        return new TaskQueue(this, Intrinsics.stringPlus("Q", Integer.valueOf(name)));
    }

    @NotNull
    public final List<TaskQueue> activeQueues() {
        List<TaskQueue> plus;
        synchronized (this) {
            plus = CollectionsKt.plus((Collection) this.busyQueues, (Iterable) this.readyQueues);
        }
        return plus;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0071 A[ORIG_RETURN, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x003d A[LOOP:1: B:8:0x003d->B:12:0x006e, LOOP_START, PHI: r4 
      PHI: (r4v2 'i' int) = (r4v1 'i' int), (r4v3 'i' int) binds: [B:7:0x003a, B:12:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cancelAll() {
        /*
            r3 = this;
            r0 = r3
            java.util.List<okhttp3.internal.concurrent.TaskQueue> r0 = r0.busyQueues
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
            r4 = r0
            r0 = 0
            r1 = r4
            if (r0 > r1) goto L_0x002c
        L_0x0011:
            r0 = r4
            r5 = r0
            int r4 = r4 + -1
            r0 = r3
            java.util.List<okhttp3.internal.concurrent.TaskQueue> r0 = r0.busyQueues
            r1 = r5
            java.lang.Object r0 = r0.get(r1)
            okhttp3.internal.concurrent.TaskQueue r0 = (okhttp3.internal.concurrent.TaskQueue) r0
            boolean r0 = r0.cancelAllAndDecide$okhttp()
            r0 = 0
            r1 = r4
            if (r0 <= r1) goto L_0x0011
        L_0x002c:
            r0 = r3
            java.util.List<okhttp3.internal.concurrent.TaskQueue> r0 = r0.readyQueues
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
            r4 = r0
            r0 = 0
            r1 = r4
            if (r0 > r1) goto L_0x0071
        L_0x003d:
            r0 = r4
            r5 = r0
            int r4 = r4 + -1
            r0 = r3
            java.util.List<okhttp3.internal.concurrent.TaskQueue> r0 = r0.readyQueues
            r1 = r5
            java.lang.Object r0 = r0.get(r1)
            okhttp3.internal.concurrent.TaskQueue r0 = (okhttp3.internal.concurrent.TaskQueue) r0
            r6 = r0
            r0 = r6
            boolean r0 = r0.cancelAllAndDecide$okhttp()
            r0 = r6
            java.util.List r0 = r0.getFutureTasks$okhttp()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x006c
            r0 = r3
            java.util.List<okhttp3.internal.concurrent.TaskQueue> r0 = r0.readyQueues
            r1 = r5
            java.lang.Object r0 = r0.remove(r1)
        L_0x006c:
            r0 = 0
            r1 = r4
            if (r0 <= r1) goto L_0x003d
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.concurrent.TaskRunner.cancelAll():void");
    }

    /* compiled from: TaskRunner.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��6\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u0014"}, m373d2 = {"Lokhttp3/internal/concurrent/TaskRunner$RealBackend;", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(Ljava/util/concurrent/ThreadFactory;)V", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "beforeTask", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "shutdown", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/concurrent/TaskRunner$RealBackend.class */
    public static final class RealBackend implements Backend {
        @NotNull
        private final ThreadPoolExecutor executor;

        public RealBackend(@NotNull ThreadFactory threadFactory) {
            Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void beforeTask(@NotNull TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public long nanoTime() {
            return System.nanoTime();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void coordinatorNotify(@NotNull TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void coordinatorWait(@NotNull TaskRunner taskRunner, long nanos) throws InterruptedException {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            long ms = nanos / 1000000;
            long ns = nanos - (ms * 1000000);
            if (ms > 0 || nanos > 0) {
                taskRunner.wait(ms, (int) ns);
            }
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void execute(@NotNull Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.executor.execute(runnable);
        }

        public final void shutdown() {
            this.executor.shutdown();
        }
    }

    /* compiled from: TaskRunner.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m373d2 = {"Lokhttp3/internal/concurrent/TaskRunner$Companion;", "", "()V", "INSTANCE", "Lokhttp3/internal/concurrent/TaskRunner;", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/concurrent/TaskRunner$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Logger getLogger() {
            return TaskRunner.logger;
        }
    }

    static {
        Logger logger2 = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger2, "getLogger(TaskRunner::class.java.name)");
        logger = logger2;
    }
}
