package p013io.javalin.plugin.rendering.vue;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.builtins.TTop;
import p013io.javalin.http.Context;

/* compiled from: VueComponent.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, m373d2 = {"Lio/javalin/plugin/rendering/vue/VueComponent;", "Lio/javalin/plugin/rendering/vue/VueHandler;", "component", "", TTop.STAT_STATE, "", "renderer", "Lio/javalin/plugin/rendering/vue/VueRenderer;", "(Ljava/lang/String;Ljava/lang/Object;Lio/javalin/plugin/rendering/vue/VueRenderer;)V", "getComponent", "()Ljava/lang/String;", "getState", "()Ljava/lang/Object;", "postRender", "layout", "ctx", "Lio/javalin/http/Context;", "preRender", "javalin"})
/* renamed from: io.javalin.plugin.rendering.vue.VueComponent */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/VueComponent.class */
public final class VueComponent extends VueHandler {
    @NotNull
    private final String component;
    @Nullable
    private final Object state;
    @NotNull
    private final VueRenderer renderer;

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VueComponent(@NotNull String component, @Nullable Object state) {
        this(component, state, null, 4, null);
        Intrinsics.checkNotNullParameter(component, "component");
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VueComponent(@NotNull String component) {
        this(component, null, null, 6, null);
        Intrinsics.checkNotNullParameter(component, "component");
    }

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VueComponent(@NotNull String component, @Nullable Object state, @NotNull VueRenderer renderer) {
        super(component);
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        this.component = component;
        this.state = state;
        this.renderer = renderer;
    }

    public /* synthetic */ VueComponent(String str, Object obj, VueRenderer vueRenderer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? new VueRenderer() : vueRenderer);
    }

    @NotNull
    public final String getComponent() {
        return this.component;
    }

    @Nullable
    public final Object getState() {
        return this.state;
    }

    @Override // p013io.javalin.plugin.rendering.vue.VueHandler
    @Nullable
    public Object state(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return this.state;
    }

    @Override // p013io.javalin.plugin.rendering.vue.VueHandler
    @NotNull
    public String preRender(@NotNull String layout, @NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return this.renderer.preRender(layout, ctx);
    }

    @Override // p013io.javalin.plugin.rendering.vue.VueHandler
    @NotNull
    public String postRender(@NotNull String layout, @NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return this.renderer.postRender(layout, ctx);
    }
}
