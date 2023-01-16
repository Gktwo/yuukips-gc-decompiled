package p013io.javalin.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.websocket.api.Session;
import org.jetbrains.annotations.NotNull;

/* compiled from: WsContext.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0012\n��\n\u0002\u0010\b\n\u0002\b\u0003\u0018��2\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n��¨\u0006\f"}, m373d2 = {"Lio/javalin/websocket/WsBinaryMessageContext;", "Lio/javalin/websocket/WsContext;", "sessionId", "", "session", "Lorg/eclipse/jetty/websocket/api/Session;", "data", "", "offset", "", "length", "(Ljava/lang/String;Lorg/eclipse/jetty/websocket/api/Session;[BII)V", "javalin"})
/* renamed from: io.javalin.websocket.WsBinaryMessageContext */
/* loaded from: grasscutter.jar:io/javalin/websocket/WsBinaryMessageContext.class */
public final class WsBinaryMessageContext extends WsContext {
    @NotNull
    private final byte[] data;
    private final int offset;
    private final int length;

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public WsBinaryMessageContext(@NotNull String sessionId, @NotNull Session session, @NotNull byte[] data, int offset, int length) {
        super(sessionId, session);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.offset = offset;
        this.length = length;
    }

    @NotNull
    public final byte[] data() {
        return this.data;
    }

    public final int offset() {
        return this.offset;
    }

    public final int length() {
        return this.length;
    }
}
