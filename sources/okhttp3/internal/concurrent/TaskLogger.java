package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.time.DurationKt;
import okhttp3.internal.http2.Http2Connection;
import org.jetbrains.annotations.NotNull;
import org.quartz.jobs.p027ee.mail.SendMailJob;

@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��*\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\t\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a5\u0010\u000b\u001a\u0002H\f\"\u0004\b��\u0010\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\bø\u0001��¢\u0006\u0002\u0010\u000f\u001a*\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\bø\u0001��\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0012"}, m373d2 = {"formatDuration", "", "ns", "", "log", "", "task", "Lokhttp3/internal/concurrent/Task;", "queue", "Lokhttp3/internal/concurrent/TaskQueue;", SendMailJob.PROP_MESSAGE, "logElapsed", "T", "block", "Lkotlin/Function0;", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "taskLog", "messageBlock", "okhttp"})
/* renamed from: okhttp3.internal.concurrent.TaskLoggerKt */
/* loaded from: grasscutter.jar:okhttp3/internal/concurrent/TaskLoggerKt.class */
public final class TaskLogger {
    public static final void taskLog(@NotNull Task task, @NotNull TaskQueue queue, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(queue, "queue");
        Intrinsics.checkNotNullParameter(function0, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, queue, function0.invoke());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0044 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [long] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T logElapsed(@org.jetbrains.annotations.NotNull okhttp3.internal.concurrent.Task r6, @org.jetbrains.annotations.NotNull okhttp3.internal.concurrent.TaskQueue r7, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> r8) {
        /*
            r0 = r6
            java.lang.String r1 = "task"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r7
            java.lang.String r1 = "queue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r8
            java.lang.String r1 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = 0
            r9 = r0
            r0 = -1
            r10 = r0
            okhttp3.internal.concurrent.TaskRunner$Companion r0 = okhttp3.internal.concurrent.TaskRunner.Companion
            java.util.logging.Logger r0 = r0.getLogger()
            java.util.logging.Level r1 = java.util.logging.Level.FINE
            boolean r0 = r0.isLoggable(r1)
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L_0x0041
            r0 = r7
            okhttp3.internal.concurrent.TaskRunner r0 = r0.getTaskRunner$okhttp()
            okhttp3.internal.concurrent.TaskRunner$Backend r0 = r0.getBackend()
            long r0 = r0.nanoTime()
            r10 = r0
            r0 = r6
            r1 = r7
            java.lang.String r2 = "starting"
            access$log(r0, r1, r2)
        L_0x0041:
            r0 = 0
            r13 = r0
            r0 = r8
            java.lang.Object r0 = r0.invoke()     // Catch: all -> 0x0085
            r14 = r0
            r0 = 1
            r13 = r0
            r0 = r14
            r15 = r0
            r0 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            r0 = r12
            if (r0 == 0) goto L_0x007e
            r0 = r7
            okhttp3.internal.concurrent.TaskRunner r0 = r0.getTaskRunner$okhttp()
            okhttp3.internal.concurrent.TaskRunner$Backend r0 = r0.getBackend()
            long r0 = r0.nanoTime()
            r1 = r10
            long r0 = r0 - r1
            r16 = r0
            r0 = r6
            r1 = r7
            java.lang.String r2 = "finished run in "
            r3 = r16
            java.lang.String r3 = formatDuration(r3)
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            access$log(r0, r1, r2)
        L_0x007e:
            r0 = 1
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            r0 = r15
            return r0
        L_0x0085:
            r14 = move-exception
            r0 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            r0 = r12
            if (r0 == 0) goto L_0x00c7
            r0 = r7
            okhttp3.internal.concurrent.TaskRunner r0 = r0.getTaskRunner$okhttp()
            okhttp3.internal.concurrent.TaskRunner$Backend r0 = r0.getBackend()
            long r0 = r0.nanoTime()
            r1 = r10
            long r0 = r0 - r1
            r15 = r0
            r0 = r13
            if (r0 == 0) goto L_0x00b8
            r0 = r6
            r1 = r7
            java.lang.String r2 = "finished run in "
            r3 = r15
            java.lang.String r3 = formatDuration(r3)
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            access$log(r0, r1, r2)
            goto L_0x00c7
        L_0x00b8:
            r0 = r6
            r1 = r7
            java.lang.String r2 = "failed a run in "
            r3 = r15
            java.lang.String r3 = formatDuration(r3)
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            access$log(r0, r1, r2)
        L_0x00c7:
            r0 = 1
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            r0 = r14
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.concurrent.TaskLogger.logElapsed(okhttp3.internal.concurrent.Task, okhttp3.internal.concurrent.TaskQueue, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void log(Task task, TaskQueue queue, String message) {
        Logger logger = TaskRunner.Companion.getLogger();
        StringBuilder append = new StringBuilder().append(queue.getName$okhttp()).append(' ');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = {message};
        String format = String.format("%-22s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        logger.fine(append.append(format).append(": ").append(task.getName()).toString());
    }

    @NotNull
    public static final String formatDuration(long ns) {
        String s;
        if (ns <= -999500000) {
            s = ((ns - ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        } else if (ns <= -999500) {
            s = ((ns - ((long) 500000)) / ((long) DurationKt.NANOS_IN_MILLIS)) + " ms";
        } else if (ns <= 0) {
            s = ((ns - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (ns < 999500) {
            s = ((ns + ((long) 500)) / ((long) 1000)) + " µs";
        } else {
            s = ns < 999500000 ? ((ns + ((long) 500000)) / ((long) DurationKt.NANOS_IN_MILLIS)) + " ms" : ((ns + ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = {s};
        String format = String.format("%6s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
