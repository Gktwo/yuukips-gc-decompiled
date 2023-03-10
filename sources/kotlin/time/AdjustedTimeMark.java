package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: TimeSource.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0003\u0018��2\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001��¢\u0006\u0002\u0010\u0005J\u0015\u0010\u000b\u001a\u00020\u0004H\u0016ø\u0001��ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u0007J\u001b\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0004H\u0002ø\u0001��¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001��ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n��\u001a\u0004\b\t\u0010\n\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, m373d2 = {"Lkotlin/time/AdjustedTimeMark;", "Lkotlin/time/TimeMark;", "mark", "adjustment", "Lkotlin/time/Duration;", "(Lkotlin/time/TimeMark;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdjustment-UwyO8pc", "()J", "J", "getMark", "()Lkotlin/time/TimeMark;", "elapsedNow", "elapsedNow-UwyO8pc", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "kotlin-stdlib"})
@ExperimentalTime
/* loaded from: grasscutter.jar:kotlin/time/AdjustedTimeMark.class */
public final class AdjustedTimeMark extends TimeMark {
    @NotNull
    private final TimeMark mark;
    private final long adjustment;

    public /* synthetic */ AdjustedTimeMark(TimeMark mark, long adjustment, DefaultConstructorMarker $constructor_marker) {
        this(mark, adjustment);
    }

    private AdjustedTimeMark(TimeMark mark, long adjustment) {
        this.mark = mark;
        this.adjustment = adjustment;
    }

    @NotNull
    public final TimeMark getMark() {
        return this.mark;
    }

    /* renamed from: getAdjustment-UwyO8pc  reason: not valid java name */
    public final long m8443getAdjustmentUwyO8pc() {
        return this.adjustment;
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: elapsedNow-UwyO8pc */
    public long mo8441elapsedNowUwyO8pc() {
        return Duration.m8452minusLRDsOJo(this.mark.mo8441elapsedNowUwyO8pc(), m8443getAdjustmentUwyO8pc());
    }

    @Override // kotlin.time.TimeMark
    @NotNull
    /* renamed from: plus-LRDsOJo */
    public TimeMark mo8442plusLRDsOJo(long duration) {
        return new AdjustedTimeMark(this.mark, Duration.m8450plusLRDsOJo(m8443getAdjustmentUwyO8pc(), duration), null);
    }
}
