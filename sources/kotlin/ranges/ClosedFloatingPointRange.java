package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Ranges.kt */
@SinceKotlin(version = "1.1")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018��*\u000e\b��\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028��H\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001d\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028��2\u0006\u0010\u000b\u001a\u00028��H&¢\u0006\u0002\u0010\f¨\u0006\r"}, m373d2 = {"Lkotlin/ranges/ClosedFloatingPointRange;", "T", "", "Lkotlin/ranges/ClosedRange;", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "lessThanOrEquals", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Z", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/ranges/ClosedFloatingPointRange.class */
public interface ClosedFloatingPointRange<T extends Comparable<? super T>> extends ClosedRange<T> {
    @Override // kotlin.ranges.ClosedRange
    boolean contains(@NotNull T t);

    @Override // kotlin.ranges.ClosedRange
    boolean isEmpty();

    boolean lessThanOrEquals(@NotNull T t, @NotNull T t2);

    /* compiled from: Ranges.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48)
    /* loaded from: grasscutter.jar:kotlin/ranges/ClosedFloatingPointRange$DefaultImpls.class */
    public static final class DefaultImpls {
        public static <T extends Comparable<? super T>> boolean contains(@NotNull ClosedFloatingPointRange<T> closedFloatingPointRange, @NotNull T t) {
            Intrinsics.checkNotNullParameter(t, "value");
            return closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), t) && closedFloatingPointRange.lessThanOrEquals(t, closedFloatingPointRange.getEndInclusive());
        }

        public static <T extends Comparable<? super T>> boolean isEmpty(@NotNull ClosedFloatingPointRange<T> closedFloatingPointRange) {
            return !closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), closedFloatingPointRange.getEndInclusive());
        }
    }
}
