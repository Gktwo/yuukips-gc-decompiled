package p013io.javalin.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.websocket.api.Session;
import org.jetbrains.annotations.NotNull;

/* compiled from: WsContext.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m373d2 = {"Lio/javalin/websocket/WsConnectContext;", "Lio/javalin/websocket/WsContext;", "sessionId", "", "session", "Lorg/eclipse/jetty/websocket/api/Session;", "(Ljava/lang/String;Lorg/eclipse/jetty/websocket/api/Session;)V", "javalin"})
/* renamed from: io.javalin.websocket.WsConnectContext */
/* loaded from: grasscutter.jar:io/javalin/websocket/WsConnectContext.class */
public final class WsConnectContext extends WsContext {
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public WsConnectContext(@NotNull String sessionId, @NotNull Session session) {
        super(sessionId, session);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(session, "session");
    }
}
