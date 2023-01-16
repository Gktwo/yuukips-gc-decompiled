package p013io.javalin.plugin.rendering.vue;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Context;

/* compiled from: VueRenderer.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001c\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, m373d2 = {"Lio/javalin/plugin/rendering/vue/VueRenderer;", "", "()V", "postRender", "", "layout", "ctx", "Lio/javalin/http/Context;", "preRender", "javalin"})
/* renamed from: io.javalin.plugin.rendering.vue.VueRenderer */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/VueRenderer.class */
public class VueRenderer {
    @NotNull
    public String preRender(@NotNull String layout, @NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return layout;
    }

    @NotNull
    public String postRender(@NotNull String layout, @NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return layout;
    }
}
