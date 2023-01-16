package p013io.javalin.http;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: ContextResolver.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\u000e\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010��\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, m373d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lio/javalin/http/Context;"})
/* renamed from: io.javalin.http.ContextResolver$scheme$1 */
/* loaded from: grasscutter.jar:io/javalin/http/ContextResolver$scheme$1.class */
public final class ContextResolver$scheme$1 extends Lambda implements Function1<Context, String> {
    public static final ContextResolver$scheme$1 INSTANCE = new ContextResolver$scheme$1();

    ContextResolver$scheme$1() {
        super(1);
    }

    public final String invoke(@NotNull Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String scheme = it.req.getScheme();
        Intrinsics.checkNotNullExpressionValue(scheme, "it.req.scheme");
        return scheme;
    }
}
