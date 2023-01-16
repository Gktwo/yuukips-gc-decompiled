package p013io.javalin.core.security;

import java.util.Set;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Context;
import p013io.javalin.http.Handler;

@FunctionalInterface
/* renamed from: io.javalin.core.security.AccessManager */
/* loaded from: grasscutter.jar:io/javalin/core/security/AccessManager.class */
public interface AccessManager {
    void manage(@NotNull Handler handler, @NotNull Context context, @NotNull Set<RouteRole> set) throws Exception;
}
