package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: TaskQueue.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��V\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\b\u0018��2\u00020\u0001:\u00013B\u0017\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\r\u0010#\u001a\u00020\u000eH��¢\u0006\u0002\b$J8\u0010%\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u000e2\u000e\b\u0004\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0*H\bø\u0001��J\u0006\u0010+\u001a\u00020,J.\u0010-\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0004\u0010)\u001a\b\u0012\u0004\u0012\u00020'0*H\bø\u0001��J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020'J%\u0010/\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u00100\u001a\u00020\u000eH��¢\u0006\u0002\b1J\u0006\u0010\u001c\u001a\u00020\"J\b\u00102\u001a\u00020\u0005H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n��\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014X\u0004¢\u0006\b\n��\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n��\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n��\u001a\u0004\b\u001f\u0010 \u0002\u0007\n\u0005\b20\u0001¨\u00064"}, m373d2 = {"Lokhttp3/internal/concurrent/TaskQueue;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "name", "", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/String;)V", "activeTask", "Lokhttp3/internal/concurrent/Task;", "getActiveTask$okhttp", "()Lokhttp3/internal/concurrent/Task;", "setActiveTask$okhttp", "(Lokhttp3/internal/concurrent/Task;)V", "cancelActiveTask", "", "getCancelActiveTask$okhttp", "()Z", "setCancelActiveTask$okhttp", "(Z)V", "futureTasks", "", "getFutureTasks$okhttp", "()Ljava/util/List;", "getName$okhttp", "()Ljava/lang/String;", "scheduledTasks", "", "getScheduledTasks", "shutdown", "getShutdown$okhttp", "setShutdown$okhttp", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "cancelAll", "", "cancelAllAndDecide", "cancelAllAndDecide$okhttp", "execute", "delayNanos", "", "cancelable", "block", "Lkotlin/Function0;", "idleLatch", "Ljava/util/concurrent/CountDownLatch;", "schedule", "task", "scheduleAndDecide", "recurrence", "scheduleAndDecide$okhttp", Printer.TO_STRING, "AwaitIdleTask", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/concurrent/TaskQueue.class */
public final class TaskQueue {
    @NotNull
    private final TaskRunner taskRunner;
    @NotNull
    private final String name;
    private boolean shutdown;
    @Nullable
    private Task activeTask;
    @NotNull
    private final List<Task> futureTasks = new ArrayList();
    private boolean cancelActiveTask;

    public TaskQueue(@NotNull TaskRunner taskRunner, @NotNull String name) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(name, "name");
        this.taskRunner = taskRunner;
        this.name = name;
    }

    @NotNull
    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    @NotNull
    public final String getName$okhttp() {
        return this.name;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final void setShutdown$okhttp(boolean z) {
        this.shutdown = z;
    }

    @Nullable
    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final void setActiveTask$okhttp(@Nullable Task task) {
        this.activeTask = task;
    }

    @NotNull
    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final void setCancelActiveTask$okhttp(boolean z) {
        this.cancelActiveTask = z;
    }

    @NotNull
    public final List<Task> getScheduledTasks() {
        List<Task> list;
        synchronized (this.taskRunner) {
            list = CollectionsKt.toList(getFutureTasks$okhttp());
        }
        return list;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        taskQueue.schedule(task, j);
    }

    public final void schedule(@NotNull Task task, long delayNanos) {
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.taskRunner) {
            if (!getShutdown$okhttp()) {
                if (scheduleAndDecide$okhttp(task, delayNanos, false)) {
                    getTaskRunner$okhttp().kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.INSTANCE;
            } else if (task.getCancelable()) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLogger.log(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLogger.log(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void schedule$default(okhttp3.internal.concurrent.TaskQueue r6, java.lang.String r7, long r8, kotlin.jvm.functions.Function0 r10, int r11, java.lang.Object r12) {
        /*
            r0 = r11
            r1 = 2
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0009
            r0 = 0
            r8 = r0
        L_0x0009:
            r0 = r7
            java.lang.String r1 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r10
            java.lang.String r1 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = 0
            r11 = r0
            r0 = r6
            okhttp3.internal.concurrent.TaskQueue$schedule$2 r1 = new okhttp3.internal.concurrent.TaskQueue$schedule$2
            r2 = r1
            r3 = r7
            r4 = r10
            r2.<init>(r3, r4)
            okhttp3.internal.concurrent.Task r1 = (okhttp3.internal.concurrent.Task) r1
            r2 = r8
            r0.schedule(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.concurrent.TaskQueue.schedule$default(okhttp3.internal.concurrent.TaskQueue, java.lang.String, long, kotlin.jvm.functions.Function0, int, java.lang.Object):void");
    }

    public final void schedule(@NotNull String name, long delayNanos, @NotNull Function0<Long> function0) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
        schedule(new TaskQueue$schedule$2(name, function0), delayNanos);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void execute$default(okhttp3.internal.concurrent.TaskQueue r7, java.lang.String r8, long r9, boolean r11, kotlin.jvm.functions.Function0 r12, int r13, java.lang.Object r14) {
        /*
            r0 = r13
            r1 = 2
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0009
            r0 = 0
            r9 = r0
        L_0x0009:
            r0 = r13
            r1 = 4
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0013
            r0 = 1
            r11 = r0
        L_0x0013:
            r0 = r8
            java.lang.String r1 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r12
            java.lang.String r1 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = 0
            r13 = r0
            r0 = r7
            okhttp3.internal.concurrent.TaskQueue$execute$1 r1 = new okhttp3.internal.concurrent.TaskQueue$execute$1
            r2 = r1
            r3 = r8
            r4 = r11
            r5 = r12
            r2.<init>(r3, r4, r5)
            okhttp3.internal.concurrent.Task r1 = (okhttp3.internal.concurrent.Task) r1
            r2 = r9
            r0.schedule(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.concurrent.TaskQueue.execute$default(okhttp3.internal.concurrent.TaskQueue, java.lang.String, long, boolean, kotlin.jvm.functions.Function0, int, java.lang.Object):void");
    }

    public final void execute(@NotNull String name, long delayNanos, boolean cancelable, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
        schedule(new TaskQueue$execute$1(name, cancelable, function0), delayNanos);
    }

    @NotNull
    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (getActiveTask$okhttp() != null || !getFutureTasks$okhttp().isEmpty()) {
                Task existingTask = getActiveTask$okhttp();
                if (existingTask instanceof AwaitIdleTask) {
                    return ((AwaitIdleTask) existingTask).getLatch();
                }
                for (Task futureTask : getFutureTasks$okhttp()) {
                    if (futureTask instanceof AwaitIdleTask) {
                        return ((AwaitIdleTask) futureTask).getLatch();
                    }
                }
                AwaitIdleTask newTask = new AwaitIdleTask();
                if (scheduleAndDecide$okhttp(newTask, 0, false)) {
                    getTaskRunner$okhttp().kickCoordinator$okhttp(this);
                }
                return newTask.getLatch();
            }
            return new CountDownLatch(0);
        }
    }

    /* compiled from: TaskQueue.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n��\b\u0002\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m373d2 = {"Lokhttp3/internal/concurrent/TaskQueue$AwaitIdleTask;", "Lokhttp3/internal/concurrent/Task;", "()V", "latch", "Ljava/util/concurrent/CountDownLatch;", "getLatch", "()Ljava/util/concurrent/CountDownLatch;", "runOnce", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/concurrent/TaskQueue$AwaitIdleTask.class */
    public static final class AwaitIdleTask extends Task {
        @NotNull
        private final CountDownLatch latch = new CountDownLatch(1);

        public AwaitIdleTask() {
            super(Intrinsics.stringPlus(Util.okHttpName, " awaitIdle"), false);
        }

        @NotNull
        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.latch.countDown();
            return -1;
        }
    }

    public final boolean scheduleAndDecide$okhttp(@NotNull Task task, long delayNanos, boolean recurrence) {
        int i;
        Intrinsics.checkNotNullParameter(task, "task");
        task.initQueue$okhttp(this);
        long now = this.taskRunner.getBackend().nanoTime();
        long executeNanoTime = now + delayNanos;
        int existingIndex = this.futureTasks.indexOf(task);
        if (existingIndex != -1) {
            if (task.getNextExecuteNanoTime$okhttp() > executeNanoTime) {
                this.futureTasks.remove(existingIndex);
            } else if (!TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                return false;
            } else {
                TaskLogger.log(task, this, "already scheduled");
                return false;
            }
        }
        task.setNextExecuteNanoTime$okhttp(executeNanoTime);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            TaskLogger.log(task, this, recurrence ? Intrinsics.stringPlus("run again after ", TaskLogger.formatDuration(executeNanoTime - now)) : Intrinsics.stringPlus("scheduled after ", TaskLogger.formatDuration(executeNanoTime - now)));
        }
        int index$iv = 0;
        Iterator<Task> it = this.futureTasks.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (((Task) it.next()).getNextExecuteNanoTime$okhttp() - now > delayNanos) {
                i = index$iv;
                break;
            }
            index$iv++;
        }
        int insertAt = i;
        if (insertAt == -1) {
            insertAt = this.futureTasks.size();
        }
        this.futureTasks.add(insertAt, task);
        return insertAt == 0;
    }

    public final void cancelAll() {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this.taskRunner) {
                if (cancelAllAndDecide$okhttp()) {
                    getTaskRunner$okhttp().kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
    }

    public final void shutdown() {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this.taskRunner) {
                setShutdown$okhttp(true);
                if (cancelAllAndDecide$okhttp()) {
                    getTaskRunner$okhttp().kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
    }

    public final boolean cancelAllAndDecide$okhttp() {
        if (this.activeTask != null) {
            Task task = this.activeTask;
            Intrinsics.checkNotNull(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean tasksCanceled = false;
        int i = this.futureTasks.size() - 1;
        if (0 > i) {
            return tasksCanceled;
        }
        do {
            i--;
            if (this.futureTasks.get(i).getCancelable()) {
                Task task$iv = this.futureTasks.get(i);
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLogger.log(task$iv, this, "canceled");
                }
                tasksCanceled = true;
                this.futureTasks.remove(i);
            }
        } while (0 <= i);
        return tasksCanceled;
    }

    @NotNull
    public String toString() {
        return this.name;
    }
}
