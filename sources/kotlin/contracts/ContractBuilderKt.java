package kotlin.contracts;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.ContractsDsl;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContractBuilder.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��\u0016\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\u001a%\u0010��\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\bø\u0001��\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0006"}, m373d2 = {"contract", "", "builder", "Lkotlin/Function1;", "Lkotlin/contracts/ContractBuilder;", "Lkotlin/ExtensionFunctionType;", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/contracts/ContractBuilderKt.class */
public final class ContractBuilderKt {
    @ContractsDsl
    @SinceKotlin(version = "1.3")
    @InlineOnly
    @ExperimentalContracts
    private static final void contract(Function1<? super ContractBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builder");
    }
}
