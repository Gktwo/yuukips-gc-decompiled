package p013io.javalin.core.util;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p013io.javalin.core.security.RouteRole;

/* compiled from: RouteOverviewUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��,\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018��2\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020��2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n��\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m373d2 = {"Lio/javalin/core/util/RouteOverviewConfig;", "", "path", "", "roles", "", "Lio/javalin/core/security/RouteRole;", "(Ljava/lang/String;Ljava/util/Set;)V", "getPath", "()Ljava/lang/String;", "getRoles", "()Ljava/util/Set;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", Printer.TO_STRING, "javalin"})
/* renamed from: io.javalin.core.util.RouteOverviewConfig */
/* loaded from: grasscutter.jar:io/javalin/core/util/RouteOverviewConfig.class */
public final class RouteOverviewConfig {
    @NotNull
    private final String path;
    @NotNull
    private final Set<RouteRole> roles;

    @NotNull
    public final String component1() {
        return this.path;
    }

    @NotNull
    public final Set<RouteRole> component2() {
        return this.roles;
    }

    @NotNull
    public final RouteOverviewConfig copy(@NotNull String path, @NotNull Set<? extends RouteRole> set) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(set, "roles");
        return new RouteOverviewConfig(path, set);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.javalin.core.util.RouteOverviewConfig */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RouteOverviewConfig copy$default(RouteOverviewConfig routeOverviewConfig, String str, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            str = routeOverviewConfig.path;
        }
        if ((i & 2) != 0) {
            set = routeOverviewConfig.roles;
        }
        return routeOverviewConfig.copy(str, set);
    }

    @NotNull
    public String toString() {
        return "RouteOverviewConfig(path=" + this.path + ", roles=" + this.roles + ')';
    }

    public int hashCode() {
        return (this.path.hashCode() * 31) + this.roles.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RouteOverviewConfig)) {
            return false;
        }
        RouteOverviewConfig routeOverviewConfig = (RouteOverviewConfig) other;
        return Intrinsics.areEqual(this.path, routeOverviewConfig.path) && Intrinsics.areEqual(this.roles, routeOverviewConfig.roles);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Set<? extends io.javalin.core.security.RouteRole> */
    /* JADX WARN: Multi-variable type inference failed */
    public RouteOverviewConfig(@NotNull String path, @NotNull Set<? extends RouteRole> set) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(set, "roles");
        this.path = path;
        this.roles = set;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final Set<RouteRole> getRoles() {
        return this.roles;
    }
}
