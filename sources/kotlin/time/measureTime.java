package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeSource;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��\"\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010��\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\bø\u0001��ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a3\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b��\u0010\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\bø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a3\u0010��\u001a\u00020\u0001*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\bø\u0001��ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\n\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b��\u0010\b*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\bø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006\u000b"}, m373d2 = {"measureTime", "Lkotlin/time/Duration;", "block", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)J", "measureTimedValue", "Lkotlin/time/TimedValue;", "T", "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)J", "kotlin-stdlib"})
/* renamed from: kotlin.time.MeasureTimeKt */
/* loaded from: grasscutter.jar:kotlin/time/MeasureTimeKt.class */
public final class measureTime {
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final long measureTime(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        TimeMark mark$iv = TimeSource.Monotonic.INSTANCE.markNow();
        function0.invoke();
        return mark$iv.mo8444elapsedNowUwyO8pc();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final long measureTime(@NotNull TimeSource $this$measureTime, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter($this$measureTime, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        TimeMark mark = $this$measureTime.markNow();
        function0.invoke();
        return mark.mo8444elapsedNowUwyO8pc();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    @NotNull
    public static final <T> TimedValue<T> measureTimedValue(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return new TimedValue<>(function0.invoke(), TimeSource.Monotonic.INSTANCE.markNow().mo8444elapsedNowUwyO8pc(), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    @NotNull
    public static final <T> TimedValue<T> measureTimedValue(@NotNull TimeSource $this$measureTimedValue, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter($this$measureTimedValue, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        return new TimedValue<>(function0.invoke(), $this$measureTimedValue.markNow().mo8444elapsedNowUwyO8pc(), null);
    }
}
