package p013io.javalin.core.event;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p013io.javalin.core.security.RouteRole;
import p013io.javalin.http.HandlerType;

/* compiled from: EventManager.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018��2\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0001HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0017\u001a\u00020��2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n��\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, m373d2 = {"Lio/javalin/core/event/HandlerMetaInfo;", "", "httpMethod", "Lio/javalin/http/HandlerType;", "path", "", "handler", "roles", "", "Lio/javalin/core/security/RouteRole;", "(Lio/javalin/http/HandlerType;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Set;)V", "getHandler", "()Ljava/lang/Object;", "getHttpMethod", "()Lio/javalin/http/HandlerType;", "getPath", "()Ljava/lang/String;", "getRoles", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", Printer.TO_STRING, "javalin"})
/* renamed from: io.javalin.core.event.HandlerMetaInfo */
/* loaded from: grasscutter.jar:io/javalin/core/event/HandlerMetaInfo.class */
public final class HandlerMetaInfo {
    @NotNull
    private final HandlerType httpMethod;
    @NotNull
    private final String path;
    @NotNull
    private final Object handler;
    @NotNull
    private final Set<RouteRole> roles;

    @NotNull
    public final HandlerType component1() {
        return this.httpMethod;
    }

    @NotNull
    public final String component2() {
        return this.path;
    }

    @NotNull
    public final Object component3() {
        return this.handler;
    }

    @NotNull
    public final Set<RouteRole> component4() {
        return this.roles;
    }

    @NotNull
    public final HandlerMetaInfo copy(@NotNull HandlerType httpMethod, @NotNull String path, @NotNull Object handler, @NotNull Set<? extends RouteRole> set) {
        Intrinsics.checkNotNullParameter(httpMethod, "httpMethod");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(set, "roles");
        return new HandlerMetaInfo(httpMethod, path, handler, set);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.javalin.core.event.HandlerMetaInfo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HandlerMetaInfo copy$default(HandlerMetaInfo handlerMetaInfo, HandlerType handlerType, String str, Object obj, Set set, int i, Object obj2) {
        if ((i & 1) != 0) {
            handlerType = handlerMetaInfo.httpMethod;
        }
        if ((i & 2) != 0) {
            str = handlerMetaInfo.path;
        }
        if ((i & 4) != 0) {
            obj = handlerMetaInfo.handler;
        }
        if ((i & 8) != 0) {
            set = handlerMetaInfo.roles;
        }
        return handlerMetaInfo.copy(handlerType, str, obj, set);
    }

    @NotNull
    public String toString() {
        return "HandlerMetaInfo(httpMethod=" + this.httpMethod + ", path=" + this.path + ", handler=" + this.handler + ", roles=" + this.roles + ')';
    }

    public int hashCode() {
        return (((((this.httpMethod.hashCode() * 31) + this.path.hashCode()) * 31) + this.handler.hashCode()) * 31) + this.roles.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HandlerMetaInfo)) {
            return false;
        }
        HandlerMetaInfo handlerMetaInfo = (HandlerMetaInfo) other;
        return this.httpMethod == handlerMetaInfo.httpMethod && Intrinsics.areEqual(this.path, handlerMetaInfo.path) && Intrinsics.areEqual(this.handler, handlerMetaInfo.handler) && Intrinsics.areEqual(this.roles, handlerMetaInfo.roles);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.Set<? extends io.javalin.core.security.RouteRole> */
    /* JADX WARN: Multi-variable type inference failed */
    public HandlerMetaInfo(@NotNull HandlerType httpMethod, @NotNull String path, @NotNull Object handler, @NotNull Set<? extends RouteRole> set) {
        Intrinsics.checkNotNullParameter(httpMethod, "httpMethod");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(set, "roles");
        this.httpMethod = httpMethod;
        this.path = path;
        this.handler = handler;
        this.roles = set;
    }

    @NotNull
    public final HandlerType getHttpMethod() {
        return this.httpMethod;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final Object getHandler() {
        return this.handler;
    }

    @NotNull
    public final Set<RouteRole> getRoles() {
        return this.roles;
    }
}
