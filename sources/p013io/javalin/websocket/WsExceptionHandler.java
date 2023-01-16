package p013io.javalin.websocket;

import java.lang.Exception;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
/* renamed from: io.javalin.websocket.WsExceptionHandler */
/* loaded from: grasscutter.jar:io/javalin/websocket/WsExceptionHandler.class */
public interface WsExceptionHandler<T extends Exception> {
    void handle(@NotNull T t, @NotNull WsContext wsContext);
}
