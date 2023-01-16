package p013io.javalin.websocket;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: WsHandlers.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0016\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\bæ\u0001\u0018��2\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m373d2 = {"Lio/javalin/websocket/WsBinaryMessageHandler;", "", "handleBinaryMessage", "", "ctx", "Lio/javalin/websocket/WsBinaryMessageContext;", "javalin"})
/* renamed from: io.javalin.websocket.WsBinaryMessageHandler */
/* loaded from: grasscutter.jar:io/javalin/websocket/WsBinaryMessageHandler.class */
public interface WsBinaryMessageHandler {
    void handleBinaryMessage(@NotNull WsBinaryMessageContext wsBinaryMessageContext) throws Exception;
}
