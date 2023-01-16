package kotlin.system;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��\u0014\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a'\u0010��\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\bø\u0001��\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a'\u0010\u0005\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\bø\u0001��\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0006"}, m373d2 = {"measureNanoTime", "", "block", "Lkotlin/Function0;", "", "measureTimeMillis", "kotlin-stdlib"})
@JvmName(name = "TimingKt")
/* renamed from: kotlin.system.TimingKt */
/* loaded from: grasscutter.jar:kotlin/system/TimingKt.class */
public final class Timing {
    public static final long measureTimeMillis(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        long start = System.currentTimeMillis();
        function0.invoke();
        return System.currentTimeMillis() - start;
    }

    public static final long measureNanoTime(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        long start = System.nanoTime();
        function0.invoke();
        return System.nanoTime() - start;
    }
}
