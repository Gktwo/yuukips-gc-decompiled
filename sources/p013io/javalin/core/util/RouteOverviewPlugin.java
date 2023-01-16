package p013io.javalin.core.util;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.Javalin;
import p013io.javalin.core.plugin.Plugin;
import p013io.javalin.core.plugin.PluginLifecycleInit;
import p013io.javalin.core.security.RouteRole;

/* compiled from: RouteOverviewPlugin.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u00012\u00020\u0002B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n��\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n��\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, m373d2 = {"Lio/javalin/core/util/RouteOverviewPlugin;", "Lio/javalin/core/plugin/Plugin;", "Lio/javalin/core/plugin/PluginLifecycleInit;", "path", "", "roles", "", "Lio/javalin/core/security/RouteRole;", "(Ljava/lang/String;[Lio/javalin/core/security/RouteRole;)V", "config", "Lio/javalin/core/util/RouteOverviewConfig;", "(Lio/javalin/core/util/RouteOverviewConfig;)V", "getConfig", "()Lio/javalin/core/util/RouteOverviewConfig;", "renderer", "Lio/javalin/core/util/RouteOverviewRenderer;", "getRenderer", "()Lio/javalin/core/util/RouteOverviewRenderer;", "setRenderer", "(Lio/javalin/core/util/RouteOverviewRenderer;)V", "apply", "", "app", "Lio/javalin/Javalin;", "init", "javalin"})
/* renamed from: io.javalin.core.util.RouteOverviewPlugin */
/* loaded from: grasscutter.jar:io/javalin/core/util/RouteOverviewPlugin.class */
public final class RouteOverviewPlugin implements Plugin, PluginLifecycleInit {
    @NotNull
    private final RouteOverviewConfig config;
    public RouteOverviewRenderer renderer;

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RouteOverviewPlugin(@NotNull String path) {
        this(path, null, 2, null);
        Intrinsics.checkNotNullParameter(path, "path");
    }

    public RouteOverviewPlugin(@NotNull RouteOverviewConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @NotNull
    public final RouteOverviewConfig getConfig() {
        return this.config;
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RouteOverviewPlugin(@NotNull String path, @NotNull RouteRole... roles) {
        this(new RouteOverviewConfig(path, ArraysKt.toSet(roles)));
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(roles, "roles");
    }

    public /* synthetic */ RouteOverviewPlugin(String str, RouteRole[] routeRoleArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new RouteRole[0] : routeRoleArr);
    }

    @NotNull
    public final RouteOverviewRenderer getRenderer() {
        RouteOverviewRenderer routeOverviewRenderer = this.renderer;
        if (routeOverviewRenderer != null) {
            return routeOverviewRenderer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        return null;
    }

    public final void setRenderer(@NotNull RouteOverviewRenderer routeOverviewRenderer) {
        Intrinsics.checkNotNullParameter(routeOverviewRenderer, "<set-?>");
        this.renderer = routeOverviewRenderer;
    }

    @Override // p013io.javalin.core.plugin.PluginLifecycleInit
    public void init(@NotNull Javalin app) {
        Intrinsics.checkNotNullParameter(app, "app");
        setRenderer(new RouteOverviewRenderer(app));
    }

    @Override // p013io.javalin.core.plugin.Plugin
    public void apply(@NotNull Javalin app) {
        Intrinsics.checkNotNullParameter(app, "app");
        String path = this.config.getPath();
        RouteOverviewRenderer renderer = getRenderer();
        Object[] array = this.config.getRoles().toArray(new RouteRole[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        RouteRole[] routeRoleArr = (RouteRole[]) array;
        app.get(path, renderer, (RouteRole[]) Arrays.copyOf(routeRoleArr, routeRoleArr.length));
    }
}
