package kotlin.concurrent;

import java.util.Date;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��4\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aM\u0010��\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001��\u001aO\u0010��\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001��\u001a\u001a\u0010\u0010\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001aM\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001��\u001aO\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001��\u001a'\u0010\u0011\u001a\u00020\f2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001��\u001a3\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001��\u001a;\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001��\u001a3\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001��\u001a;\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001��\u001a;\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001��\u001a;\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001��\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, m373d2 = {"fixedRateTimer", "Ljava/util/Timer;", "name", "", "daemon", "", "startAt", "Ljava/util/Date;", "period", "", "action", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "initialDelay", "timer", "timerTask", "schedule", "time", "delay", "scheduleAtFixedRate", "kotlin-stdlib"})
@JvmName(name = "TimersKt")
/* renamed from: kotlin.concurrent.TimersKt */
/* loaded from: grasscutter.jar:kotlin/concurrent/TimersKt.class */
public final class Timer {
    @InlineOnly
    private static final TimerTask schedule(java.util.Timer $this$schedule, long delay, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$schedule, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        TimerTask task = new TimersKt$timerTask$1(function1);
        $this$schedule.schedule(task, delay);
        return task;
    }

    @InlineOnly
    private static final TimerTask schedule(java.util.Timer $this$schedule, Date time, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$schedule, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(function1, "action");
        TimerTask task = new TimersKt$timerTask$1(function1);
        $this$schedule.schedule(task, time);
        return task;
    }

    @InlineOnly
    private static final TimerTask schedule(java.util.Timer $this$schedule, long delay, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$schedule, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        TimerTask task = new TimersKt$timerTask$1(function1);
        $this$schedule.schedule(task, delay, period);
        return task;
    }

    @InlineOnly
    private static final TimerTask schedule(java.util.Timer $this$schedule, Date time, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$schedule, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(function1, "action");
        TimerTask task = new TimersKt$timerTask$1(function1);
        $this$schedule.schedule(task, time, period);
        return task;
    }

    @InlineOnly
    private static final TimerTask scheduleAtFixedRate(java.util.Timer $this$scheduleAtFixedRate, long delay, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$scheduleAtFixedRate, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        TimerTask task = new TimersKt$timerTask$1(function1);
        $this$scheduleAtFixedRate.scheduleAtFixedRate(task, delay, period);
        return task;
    }

    @InlineOnly
    private static final TimerTask scheduleAtFixedRate(java.util.Timer $this$scheduleAtFixedRate, Date time, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$scheduleAtFixedRate, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(function1, "action");
        TimerTask task = new TimersKt$timerTask$1(function1);
        $this$scheduleAtFixedRate.scheduleAtFixedRate(task, time, period);
        return task;
    }

    @PublishedApi
    @NotNull
    public static final java.util.Timer timer(@Nullable String name, boolean daemon) {
        return name == null ? new java.util.Timer(daemon) : new java.util.Timer(name, daemon);
    }

    static /* synthetic */ java.util.Timer timer$default(String name, boolean daemon, long initialDelay, long period, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            name = null;
        }
        if ((i & 2) != 0) {
            daemon = false;
        }
        if ((i & 4) != 0) {
            initialDelay = 0;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        java.util.Timer timer = timer(name, daemon);
        timer.schedule(new TimersKt$timerTask$1(action), initialDelay, period);
        return timer;
    }

    @InlineOnly
    private static final java.util.Timer timer(String name, boolean daemon, long initialDelay, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        java.util.Timer timer = timer(name, daemon);
        timer.schedule(new TimersKt$timerTask$1(function1), initialDelay, period);
        return timer;
    }

    static /* synthetic */ java.util.Timer timer$default(String name, boolean daemon, Date startAt, long period, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            name = null;
        }
        if ((i & 2) != 0) {
            daemon = false;
        }
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(action, "action");
        java.util.Timer timer = timer(name, daemon);
        timer.schedule(new TimersKt$timerTask$1(action), startAt, period);
        return timer;
    }

    @InlineOnly
    private static final java.util.Timer timer(String name, boolean daemon, Date startAt, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(function1, "action");
        java.util.Timer timer = timer(name, daemon);
        timer.schedule(new TimersKt$timerTask$1(function1), startAt, period);
        return timer;
    }

    static /* synthetic */ java.util.Timer fixedRateTimer$default(String name, boolean daemon, long initialDelay, long period, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            name = null;
        }
        if ((i & 2) != 0) {
            daemon = false;
        }
        if ((i & 4) != 0) {
            initialDelay = 0;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        java.util.Timer timer = timer(name, daemon);
        timer.scheduleAtFixedRate(new TimersKt$timerTask$1(action), initialDelay, period);
        return timer;
    }

    @InlineOnly
    private static final java.util.Timer fixedRateTimer(String name, boolean daemon, long initialDelay, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        java.util.Timer timer = timer(name, daemon);
        timer.scheduleAtFixedRate(new TimersKt$timerTask$1(function1), initialDelay, period);
        return timer;
    }

    static /* synthetic */ java.util.Timer fixedRateTimer$default(String name, boolean daemon, Date startAt, long period, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            name = null;
        }
        if ((i & 2) != 0) {
            daemon = false;
        }
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(action, "action");
        java.util.Timer timer = timer(name, daemon);
        timer.scheduleAtFixedRate(new TimersKt$timerTask$1(action), startAt, period);
        return timer;
    }

    @InlineOnly
    private static final java.util.Timer fixedRateTimer(String name, boolean daemon, Date startAt, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(function1, "action");
        java.util.Timer timer = timer(name, daemon);
        timer.scheduleAtFixedRate(new TimersKt$timerTask$1(function1), startAt, period);
        return timer;
    }

    @InlineOnly
    private static final TimerTask timerTask(Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        return new TimersKt$timerTask$1(function1);
    }
}
