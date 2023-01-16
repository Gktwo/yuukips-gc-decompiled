package p013io.javalin.http;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p013io.javalin.core.PathParser;

/* compiled from: PathMatcher.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��<\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018��2\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J;\u0010\u001c\u001a\u00020��2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050 2\u0006\u0010!\u001a\u00020\u0005J\t\u0010\"\u001a\u00020#HÖ\u0001J\u000e\u0010$\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0005J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n��\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n��\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n��R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n��\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, m373d2 = {"Lio/javalin/http/HandlerEntry;", "", "type", "Lio/javalin/http/HandlerType;", "path", "", "ignoreTrailingSlashes", "", "handler", "Lio/javalin/http/Handler;", "rawHandler", "(Lio/javalin/http/HandlerType;Ljava/lang/String;ZLio/javalin/http/Handler;Lio/javalin/http/Handler;)V", "getHandler", "()Lio/javalin/http/Handler;", "getIgnoreTrailingSlashes", "()Z", "getPath", "()Ljava/lang/String;", "pathParser", "Lio/javalin/core/PathParser;", "getRawHandler", "getType", "()Lio/javalin/http/HandlerType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "extractPathParams", "", "requestUri", "hashCode", "", "matches", Printer.TO_STRING, "javalin"})
/* renamed from: io.javalin.http.HandlerEntry */
/* loaded from: grasscutter.jar:io/javalin/http/HandlerEntry.class */
public final class HandlerEntry {
    @NotNull
    private final HandlerType type;
    @NotNull
    private final String path;
    private final boolean ignoreTrailingSlashes;
    @NotNull
    private final Handler handler;
    @NotNull
    private final Handler rawHandler;
    @NotNull
    private final PathParser pathParser;

    @NotNull
    public final HandlerType component1() {
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
    public final Handler component4() {
        return this.handler;
    }

    @NotNull
    public final Handler component5() {
        return this.rawHandler;
    }

    @NotNull
    public final HandlerEntry copy(@NotNull HandlerType type, @NotNull String path, boolean ignoreTrailingSlashes, @NotNull Handler handler, @NotNull Handler rawHandler) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(rawHandler, "rawHandler");
        return new HandlerEntry(type, path, ignoreTrailingSlashes, handler, rawHandler);
    }

    public static /* synthetic */ HandlerEntry copy$default(HandlerEntry handlerEntry, HandlerType handlerType, String str, boolean z, Handler handler, Handler handler2, int i, Object obj) {
        if ((i & 1) != 0) {
            handlerType = handlerEntry.type;
        }
        if ((i & 2) != 0) {
            str = handlerEntry.path;
        }
        if ((i & 4) != 0) {
            z = handlerEntry.ignoreTrailingSlashes;
        }
        if ((i & 8) != 0) {
            handler = handlerEntry.handler;
        }
        if ((i & 16) != 0) {
            handler2 = handlerEntry.rawHandler;
        }
        return handlerEntry.copy(handlerType, str, z, handler, handler2);
    }

    @NotNull
    public String toString() {
        return "HandlerEntry(type=" + this.type + ", path=" + this.path + ", ignoreTrailingSlashes=" + this.ignoreTrailingSlashes + ", handler=" + this.handler + ", rawHandler=" + this.rawHandler + ')';
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
        return ((((hashCode + i) * 31) + this.handler.hashCode()) * 31) + this.rawHandler.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HandlerEntry)) {
            return false;
        }
        HandlerEntry handlerEntry = (HandlerEntry) other;
        return this.type == handlerEntry.type && Intrinsics.areEqual(this.path, handlerEntry.path) && this.ignoreTrailingSlashes == handlerEntry.ignoreTrailingSlashes && Intrinsics.areEqual(this.handler, handlerEntry.handler) && Intrinsics.areEqual(this.rawHandler, handlerEntry.rawHandler);
    }

    public HandlerEntry(@NotNull HandlerType type, @NotNull String path, boolean ignoreTrailingSlashes, @NotNull Handler handler, @NotNull Handler rawHandler) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(rawHandler, "rawHandler");
        this.type = type;
        this.path = path;
        this.ignoreTrailingSlashes = ignoreTrailingSlashes;
        this.handler = handler;
        this.rawHandler = rawHandler;
        this.pathParser = new PathParser(this.path, this.ignoreTrailingSlashes);
    }

    @NotNull
    public final HandlerType getType() {
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
    public final Handler getHandler() {
        return this.handler;
    }

    @NotNull
    public final Handler getRawHandler() {
        return this.rawHandler;
    }

    public final boolean matches(@NotNull String requestUri) {
        Intrinsics.checkNotNullParameter(requestUri, "requestUri");
        return this.pathParser.matches(requestUri);
    }

    @NotNull
    public final Map<String, String> extractPathParams(@NotNull String requestUri) {
        Intrinsics.checkNotNullParameter(requestUri, "requestUri");
        return this.pathParser.extractPathParams(requestUri);
    }
}
