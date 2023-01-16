package p013io.javalin.websocket;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.core.util.JavalinLogger;
import p013io.javalin.core.util.Util;

/* compiled from: WsExceptionMapper.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u000e\u001a\u00020\u000fR5\u0010\u0003\u001a&\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u00060\u0006j\u0002`\u00070\u0005\u0012\u0010\u0012\u000e\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\b0\u0004¢\u0006\b\n��\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, m373d2 = {"Lio/javalin/websocket/WsExceptionMapper;", "", "()V", "handlers", "", "Ljava/lang/Class;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lio/javalin/websocket/WsExceptionHandler;", "getHandlers", "()Ljava/util/Map;", "handle", "", "exception", "ctx", "Lio/javalin/websocket/WsContext;", "javalin"})
/* renamed from: io.javalin.websocket.WsExceptionMapper */
/* loaded from: grasscutter.jar:io/javalin/websocket/WsExceptionMapper.class */
public final class WsExceptionMapper {
    @NotNull
    private final Map<Class<? extends Exception>, WsExceptionHandler<Exception>> handlers = new LinkedHashMap();

    @NotNull
    public final Map<Class<? extends Exception>, WsExceptionHandler<Exception>> getHandlers() {
        return this.handlers;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.javalin.core.util.Util */
    /* JADX WARN: Multi-variable type inference failed */
    public final void handle(@NotNull Exception exception, @NotNull WsContext ctx) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        WsExceptionHandler handler = (WsExceptionHandler) Util.INSTANCE.findByClass(this.handlers, exception.getClass());
        if (handler != null) {
            handler.handle(exception, ctx);
            return;
        }
        JavalinLogger.warn("Uncaught exception in WebSocket handler", exception);
        ctx.session.close(StatusCode.SERVER_ERROR, exception.getMessage());
    }
}
