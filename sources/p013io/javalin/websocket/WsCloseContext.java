package p013io.javalin.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.websocket.api.Session;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WsContext.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0004\u0018��2\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\b\u0010\b\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\n\u001a\u00020\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��¨\u0006\u000b"}, m373d2 = {"Lio/javalin/websocket/WsCloseContext;", "Lio/javalin/websocket/WsContext;", "sessionId", "", "session", "Lorg/eclipse/jetty/websocket/api/Session;", "statusCode", "", "reason", "(Ljava/lang/String;Lorg/eclipse/jetty/websocket/api/Session;ILjava/lang/String;)V", "status", "javalin"})
/* renamed from: io.javalin.websocket.WsCloseContext */
/* loaded from: grasscutter.jar:io/javalin/websocket/WsCloseContext.class */
public final class WsCloseContext extends WsContext {
    private final int statusCode;
    @Nullable
    private final String reason;

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public WsCloseContext(@NotNull String sessionId, @NotNull Session session, int statusCode, @Nullable String reason) {
        super(sessionId, session);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(session, "session");
        this.statusCode = statusCode;
        this.reason = reason;
    }

    public final int status() {
        return this.statusCode;
    }

    @Nullable
    public final String reason() {
        return this.reason;
    }
}
