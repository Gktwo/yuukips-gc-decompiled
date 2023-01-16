package p013io.javalin.websocket;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p013io.javalin.core.PathParser;
import p013io.javalin.core.security.RouteRole;

/* compiled from: WsPathMatcher.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��D\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n��\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018��2\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JA\u0010\u001f\u001a\u00020��2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#2\u0006\u0010\u0004\u001a\u00020\u0005J\t\u0010$\u001a\u00020%HÖ\u0001J\u000e\u0010&\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n��\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n��R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n��\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n��\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, m373d2 = {"Lio/javalin/websocket/WsEntry;", "", "type", "Lio/javalin/websocket/WsHandlerType;", "path", "", "ignoreTrailingSlashes", "", "wsConfig", "Lio/javalin/websocket/WsConfig;", "roles", "", "Lio/javalin/core/security/RouteRole;", "(Lio/javalin/websocket/WsHandlerType;Ljava/lang/String;ZLio/javalin/websocket/WsConfig;Ljava/util/Set;)V", "getIgnoreTrailingSlashes", "()Z", "getPath", "()Ljava/lang/String;", "pathParser", "Lio/javalin/core/PathParser;", "getRoles", "()Ljava/util/Set;", "getType", "()Lio/javalin/websocket/WsHandlerType;", "getWsConfig", "()Lio/javalin/websocket/WsConfig;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "extractPathParams", "", "hashCode", "", "matches", Printer.TO_STRING, "javalin"})
/* renamed from: io.javalin.websocket.WsEntry */
/* loaded from: grasscutter.jar:io/javalin/websocket/WsEntry.class */
public final class WsEntry {
    @NotNull
    private final WsHandlerType type;
    @NotNull
    private final String path;
    private final boolean ignoreTrailingSlashes;
    @NotNull
    private final WsConfig wsConfig;
    @NotNull
    private final Set<RouteRole> roles;
    @NotNull
    private final PathParser pathParser;

    @NotNull
    public final WsHandlerType component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.path;
    }

    public final boolean component3() {
        return this.ignoreTrailingSlashes;
    }

    @NotNull
    public final WsConfig component4() {
        return this.wsConfig;
    }

    @NotNull
    public final Set<RouteRole> component5() {
        return this.roles;
    }

    @NotNull
    public final WsEntry copy(@NotNull WsHandlerType type, @NotNull String path, boolean ignoreTrailingSlashes, @NotNull WsConfig wsConfig, @NotNull Set<? extends RouteRole> set) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(wsConfig, "wsConfig");
        Intrinsics.checkNotNullParameter(set, "roles");
        return new WsEntry(type, path, ignoreTrailingSlashes, wsConfig, set);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: io.javalin.websocket.WsEntry */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WsEntry copy$default(WsEntry wsEntry, WsHandlerType wsHandlerType, String str, boolean z, WsConfig wsConfig, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            wsHandlerType = wsEntry.type;
        }
        if ((i & 2) != 0) {
            str = wsEntry.path;
        }
        if ((i & 4) != 0) {
            z = wsEntry.ignoreTrailingSlashes;
        }
        if ((i & 8) != 0) {
            wsConfig = wsEntry.wsConfig;
        }
        if ((i & 16) != 0) {
            set = wsEntry.roles;
        }
        return wsEntry.copy(wsHandlerType, str, z, wsConfig, set);
    }

    @NotNull
    public String toString() {
        return "WsEntry(type=" + this.type + ", path=" + this.path + ", ignoreTrailingSlashes=" + this.ignoreTrailingSlashes + ", wsConfig=" + this.wsConfig + ", roles=" + this.roles + ')';
    }

    public int hashCode() {
        int hashCode = ((this.type.hashCode() * 31) + this.path.hashCode()) * 31;
        boolean z = this.ignoreTrailingSlashes;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return ((((hashCode + i) * 31) + this.wsConfig.hashCode()) * 31) + this.roles.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WsEntry)) {
            return false;
        }
        WsEntry wsEntry = (WsEntry) other;
        return this.type == wsEntry.type && Intrinsics.areEqual(this.path, wsEntry.path) && this.ignoreTrailingSlashes == wsEntry.ignoreTrailingSlashes && Intrinsics.areEqual(this.wsConfig, wsEntry.wsConfig) && Intrinsics.areEqual(this.roles, wsEntry.roles);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: java.util.Set<? extends io.javalin.core.security.RouteRole> */
    /* JADX WARN: Multi-variable type inference failed */
    public WsEntry(@NotNull WsHandlerType type, @NotNull String path, boolean ignoreTrailingSlashes, @NotNull WsConfig wsConfig, @NotNull Set<? extends RouteRole> set) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(wsConfig, "wsConfig");
        Intrinsics.checkNotNullParameter(set, "roles");
        this.type = type;
        this.path = path;
        this.ignoreTrailingSlashes = ignoreTrailingSlashes;
        this.wsConfig = wsConfig;
        this.roles = set;
        this.pathParser = new PathParser(this.path, this.ignoreTrailingSlashes);
    }

    @NotNull
    public final WsHandlerType getType() {
        return this.type;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public final boolean getIgnoreTrailingSlashes() {
        return this.ignoreTrailingSlashes;
    }

    @NotNull
    public final WsConfig getWsConfig() {
        return this.wsConfig;
    }

    @NotNull
    public final Set<RouteRole> getRoles() {
        return this.roles;
    }

    public final boolean matches(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.pathParser.matches(path);
    }

    @NotNull
    public final Map<String, String> extractPathParams(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.pathParser.extractPathParams(path);
    }
}
