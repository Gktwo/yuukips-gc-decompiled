package p013io.javalin.http;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
/* renamed from: io.javalin.http.Handler */
/* loaded from: grasscutter.jar:io/javalin/http/Handler.class */
public interface Handler {
    void handle(@NotNull Context context) throws Exception;
}
