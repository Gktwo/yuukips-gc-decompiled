package p013io.javalin.http;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ContextResolver.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\u0012\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\"\u000e\u0010��\u001a\u00020\u0001XT¢\u0006\u0002\n��¨\u0006\u0005"}, m373d2 = {"CONTEXT_RESOLVER_KEY", "", ContextResolverKt.CONTEXT_RESOLVER_KEY, "Lio/javalin/http/ContextResolver;", "Lio/javalin/http/Context;", "javalin"})
/* renamed from: io.javalin.http.ContextResolverKt */
/* loaded from: grasscutter.jar:io/javalin/http/ContextResolverKt.class */
public final class ContextResolverKt {
    @NotNull
    public static final String CONTEXT_RESOLVER_KEY = "contextResolver";

    @NotNull
    public static final ContextResolver contextResolver(@NotNull Context $this$contextResolver) {
        Intrinsics.checkNotNullParameter($this$contextResolver, "<this>");
        return (ContextResolver) $this$contextResolver.appAttribute(CONTEXT_RESOLVER_KEY);
    }
}
