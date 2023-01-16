package p013io.javalin.http.staticfiles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: ResourceHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��(\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\bf\u0018��2\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, m373d2 = {"Lio/javalin/http/staticfiles/ResourceHandler;", "", "addStaticFileConfig", "", "config", "Lio/javalin/http/staticfiles/StaticFileConfig;", "handle", "", "httpRequest", "Ljavax/servlet/http/HttpServletRequest;", "httpResponse", "Ljavax/servlet/http/HttpServletResponse;", "javalin"})
/* renamed from: io.javalin.http.staticfiles.ResourceHandler */
/* loaded from: grasscutter.jar:io/javalin/http/staticfiles/ResourceHandler.class */
public interface ResourceHandler {
    boolean handle(@NotNull HttpServletRequest httpServletRequest, @NotNull HttpServletResponse httpServletResponse);

    void addStaticFileConfig(@NotNull StaticFileConfig staticFileConfig);
}
