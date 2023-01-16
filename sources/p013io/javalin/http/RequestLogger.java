package p013io.javalin.http;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
/* renamed from: io.javalin.http.RequestLogger */
/* loaded from: grasscutter.jar:io/javalin/http/RequestLogger.class */
public interface RequestLogger {
    void handle(@NotNull Context context, @NotNull Float f) throws Exception;
}
