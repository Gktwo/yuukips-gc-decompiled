package kotlin.time;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeSource.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��\u0016\n��\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010��\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\n\u001a\u001d\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\nø\u0001��¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, m373d2 = {"compareTo", "", "Lkotlin/time/TimeMark;", "other", "minus", "Lkotlin/time/Duration;", "(Lkotlin/time/TimeMark;Lkotlin/time/TimeMark;)J", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/time/TimeSourceKt.class */
public final class TimeSourceKt {
    @SinceKotlin(version = "1.3")
    @InlineOnly
    @Deprecated(message = "Subtracting one TimeMark from another is not a well defined operation because these time marks could have been obtained from the different time sources.", level = DeprecationLevel.ERROR)
    @ExperimentalTime
    private static final long minus(TimeMark $this$minus, TimeMark other) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        throw new Error("Operation is disallowed.");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @Deprecated(message = "Comparing one TimeMark to another is not a well defined operation because these time marks could have been obtained from the different time sources.", level = DeprecationLevel.ERROR)
    @ExperimentalTime
    private static final int compareTo(TimeMark $this$compareTo, TimeMark other) {
        Intrinsics.checkNotNullParameter($this$compareTo, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        throw new Error("Operation is disallowed.");
    }
}
