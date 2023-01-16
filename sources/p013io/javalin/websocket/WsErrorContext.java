package p013io.javalin.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.websocket.api.Session;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WsContext.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018��2\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n��¨\u0006\t"}, m373d2 = {"Lio/javalin/websocket/WsErrorContext;", "Lio/javalin/websocket/WsContext;", "sessionId", "", "session", "Lorg/eclipse/jetty/websocket/api/Session;", "error", "", "(Ljava/lang/String;Lorg/eclipse/jetty/websocket/api/Session;Ljava/lang/Throwable;)V", "javalin"})
/* renamed from: io.javalin.websocket.WsErrorContext */
/* loaded from: grasscutter.jar:io/javalin/websocket/WsErrorContext.class */
public final class WsErrorContext extends WsContext {
    @Nullable
    private final Throwable error;

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public WsErrorContext(@NotNull String sessionId, @NotNull Session session, @Nullable Throwable error) {
        super(sessionId, session);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(session, "session");
        this.error = error;
    }

    @Nullable
    public final Throwable error() {
        return this.error;
    }
}
