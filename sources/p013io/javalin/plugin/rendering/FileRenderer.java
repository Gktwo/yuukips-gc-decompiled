package p013io.javalin.plugin.rendering;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Context;

@FunctionalInterface
/* renamed from: io.javalin.plugin.rendering.FileRenderer */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/FileRenderer.class */
public interface FileRenderer {
    String render(@NotNull String str, @NotNull Map<String, Object> map, Context context) throws Exception;
}
