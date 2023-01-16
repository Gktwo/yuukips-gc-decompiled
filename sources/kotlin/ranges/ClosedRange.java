package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Range.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000f\n\u0002\u0010��\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018��*\u000e\b��\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028��H\u0002¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\nH\u0016R\u0012\u0010\u0004\u001a\u00028��X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00028��X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u000e"}, m373d2 = {"Lkotlin/ranges/ClosedRange;", "T", "", "", "endInclusive", "getEndInclusive", "()Ljava/lang/Comparable;", "start", "getStart", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/ranges/ClosedRange.class */
public interface ClosedRange<T extends Comparable<? super T>> {
    @NotNull
    T getStart();

    @NotNull
    T getEndInclusive();

    boolean contains(@NotNull T t);

    boolean isEmpty();

    /* compiled from: Range.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48)
    /* loaded from: grasscutter.jar:kotlin/ranges/ClosedRange$DefaultImpls.class */
    public static final class DefaultImpls {
        public static <T extends Comparable<? super T>> boolean contains(@NotNull ClosedRange<T> closedRange, @NotNull T t) {
            Intrinsics.checkNotNullParameter(t, "value");
            return t.compareTo(closedRange.getStart()) >= 0 && t.compareTo(closedRange.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean isEmpty(@NotNull ClosedRange<T> closedRange) {
            return closedRange.getStart().compareTo(closedRange.getEndInclusive()) > 0;
        }
    }
}
