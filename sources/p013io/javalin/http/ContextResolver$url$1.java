package p013io.javalin.http;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: ContextResolver.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\f\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m373d2 = {"<anonymous>", "", "it", "Lio/javalin/http/Context;"})
/* renamed from: io.javalin.http.ContextResolver$url$1 */
/* loaded from: grasscutter.jar:io/javalin/http/ContextResolver$url$1.class */
public final class ContextResolver$url$1 extends Lambda implements Function1<Context, String> {
    public static final ContextResolver$url$1 INSTANCE = new ContextResolver$url$1();

    ContextResolver$url$1() {
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String stringBuffer = it.req.getRequestURL().toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer, "it.req.requestURL.toString()");
        return stringBuffer;
    }
}
