package p013io.javalin.core.util;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.Javalin;
import p013io.javalin.core.plugin.Plugin;
import p013io.javalin.http.Context;

/* compiled from: HeadersPlugin.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��¨\u0006\t"}, m373d2 = {"Lio/javalin/core/util/HeadersPlugin;", "Lio/javalin/core/plugin/Plugin;", "headers", "Lio/javalin/core/util/Headers;", "(Lio/javalin/core/util/Headers;)V", "apply", "", "app", "Lio/javalin/Javalin;", "javalin"})
/* renamed from: io.javalin.core.util.HeadersPlugin */
/* loaded from: grasscutter.jar:io/javalin/core/util/HeadersPlugin.class */
public final class HeadersPlugin implements Plugin {
    @NotNull
    private final Headers headers;

    public HeadersPlugin(@NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.headers = headers;
    }

    @Override // p013io.javalin.core.plugin.Plugin
    public void apply(@NotNull Javalin app) {
        Intrinsics.checkNotNullParameter(app, "app");
        app.before((v1) -> {
            m5765apply$lambda1(r1, v1);
        });
    }

    /* renamed from: apply$lambda-1  reason: not valid java name */
    private static final void m5765apply$lambda1(HeadersPlugin this$0, Context ctx) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        for (Map.Entry element$iv : this$0.headers.getHeaders().entrySet()) {
            ctx.header(element$iv.getKey(), element$iv.getValue());
        }
    }
}
