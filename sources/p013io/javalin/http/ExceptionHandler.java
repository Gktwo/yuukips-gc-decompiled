package p013io.javalin.http;

import java.lang.Exception;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
/* renamed from: io.javalin.http.ExceptionHandler */
/* loaded from: grasscutter.jar:io/javalin/http/ExceptionHandler.class */
public interface ExceptionHandler<T extends Exception> {
    void handle(@NotNull T t, @NotNull Context context);
}
