package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Interceptor.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 176, m374d1 = {"��\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m373d2 = {"<anonymous>", "Lokhttp3/Response;", "it", "Lokhttp3/Interceptor$Chain;", "intercept"})
/* loaded from: grasscutter.jar:okhttp3/Interceptor$Companion$invoke$1.class */
public final class Interceptor$Companion$invoke$1 implements Interceptor {
    final /* synthetic */ Function1<Interceptor.Chain, Response> $block;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super okhttp3.Interceptor$Chain, okhttp3.Response> */
    /* JADX WARN: Multi-variable type inference failed */
    public Interceptor$Companion$invoke$1(Function1<? super Interceptor.Chain, Response> function1) {
        this.$block = function1;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public final Response intercept(@NotNull Interceptor.Chain it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this.$block.invoke(it);
    }
}
