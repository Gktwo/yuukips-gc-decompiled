package kotlin;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: AssertionsJVM.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÁ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048��X\u0004¢\u0006\b\n��\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, m373d2 = {"Lkotlin/_Assertions;", "", "()V", "ENABLED", "", "getENABLED$annotations", "kotlin-stdlib"})
@PublishedApi
/* loaded from: grasscutter.jar:kotlin/_Assertions.class */
public final class _Assertions {
    @NotNull
    public static final _Assertions INSTANCE = new _Assertions();
    @JvmField
    public static final boolean ENABLED = INSTANCE.getClass().desiredAssertionStatus();

    @PublishedApi
    public static /* synthetic */ void getENABLED$annotations() {
    }

    private _Assertions() {
    }
}
