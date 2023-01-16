package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��\u0018\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\u0010��\n��\u001a\u0011\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b\u001a\"\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001��\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0007"}, m373d2 = {"assert", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "kotlin-stdlib"}, m368xs = "kotlin/PreconditionsKt")
/* renamed from: kotlin.PreconditionsKt__AssertionsJVMKt */
/* loaded from: grasscutter.jar:kotlin/PreconditionsKt__AssertionsJVMKt.class */
public class AssertionsJVM {
    @InlineOnly
    /* renamed from: assert  reason: not valid java name */
    private static final void m7052assert(boolean value) {
        if (_Assertions.ENABLED && !value) {
            throw new AssertionError("Assertion failed");
        }
    }

    @InlineOnly
    /* renamed from: assert  reason: not valid java name */
    private static final void m7053assert(boolean value, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        if (_Assertions.ENABLED && !value) {
            throw new AssertionError(function0.invoke());
        }
    }
}
