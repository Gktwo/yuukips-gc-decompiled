package p013io.javalin.core.security;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.jetty.util.URIUtil;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Context;
import p013io.javalin.http.Handler;
import p013io.javalin.http.util.ContextUtil;

/* compiled from: SecurityUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��*\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\r"}, m373d2 = {"Lio/javalin/core/security/SecurityUtil;", "", "()V", "noopAccessManager", "", "handler", "Lio/javalin/http/Handler;", "ctx", "Lio/javalin/http/Context;", "roles", "", "Lio/javalin/core/security/RouteRole;", "sslRedirect", "javalin"})
/* renamed from: io.javalin.core.security.SecurityUtil */
/* loaded from: grasscutter.jar:io/javalin/core/security/SecurityUtil.class */
public final class SecurityUtil {
    @NotNull
    public static final SecurityUtil INSTANCE = new SecurityUtil();

    private SecurityUtil() {
    }

    @JvmStatic
    public static final void noopAccessManager(@NotNull Handler handler, @NotNull Context ctx, @NotNull Set<? extends RouteRole> set) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(set, "roles");
        if (!set.isEmpty()) {
            throw new IllegalStateException("No access manager configured. Add an access manager using 'Javalin.create(c -> c.accessManager(...))'.");
        }
        handler.handle(ctx);
    }

    @JvmStatic
    public static final void sslRedirect(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (!ContextUtil.INSTANCE.isLocalhost(ctx)) {
            String xForwardedProto = ctx.header("x-forwarded-proto");
            if (Intrinsics.areEqual(xForwardedProto, URIUtil.HTTP) || (xForwardedProto == null && Intrinsics.areEqual(ctx.scheme(), URIUtil.HTTP))) {
                ctx.redirect(StringsKt.replace$default(ctx.fullUrl(), URIUtil.HTTP, URIUtil.HTTPS, false, 4, (Object) null), 301);
            }
        }
    }
}
