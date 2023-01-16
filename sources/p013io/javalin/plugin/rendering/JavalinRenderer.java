package p013io.javalin.plugin.rendering;

import dev.morphia.mapping.Mapper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.core.util.JavalinLogger;
import p013io.javalin.http.Context;
import p013io.javalin.plugin.rendering.markdown.JavalinCommonmark;
import p013io.javalin.plugin.rendering.template.JavalinFreemarker;
import p013io.javalin.plugin.rendering.template.JavalinJte;
import p013io.javalin.plugin.rendering.template.JavalinMustache;
import p013io.javalin.plugin.rendering.template.JavalinPebble;
import p013io.javalin.plugin.rendering.template.JavalinThymeleaf;
import p013io.javalin.plugin.rendering.template.JavalinVelocity;

/* compiled from: JavalinRenderer.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��:\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n��\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0012\"\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0013J,\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0005R,\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n��R\u0018\u0010\u000b\u001a\u00020\u0007*\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, m373d2 = {"Lio/javalin/plugin/rendering/JavalinRenderer;", "", "()V", "baseModelFunction", "Lkotlin/Function1;", "Lio/javalin/http/Context;", "", "", "extensions", "", "Lio/javalin/plugin/rendering/FileRenderer;", "extension", "getExtension", "(Ljava/lang/String;)Ljava/lang/String;", "register", "", "fileRenderer", "ext", "", "(Lio/javalin/plugin/rendering/FileRenderer;[Ljava/lang/String;)V", "renderBasedOnExtension", "filePath", "model", "ctx", "javalin"})
/* renamed from: io.javalin.plugin.rendering.JavalinRenderer */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/JavalinRenderer.class */
public final class JavalinRenderer {
    @NotNull
    public static final JavalinRenderer INSTANCE = new JavalinRenderer();
    @NotNull
    private static final Map<String, FileRenderer> extensions = new LinkedHashMap();
    @JvmField
    @NotNull
    public static Function1<? super Context, ? extends Map<String, ? extends Object>> baseModelFunction = JavalinRenderer$baseModelFunction$1.INSTANCE;

    private JavalinRenderer() {
    }

    static {
        register(JavalinVelocity.INSTANCE, ".vm", ".vtl");
        register(JavalinFreemarker.INSTANCE, ".ftl");
        register(JavalinMustache.INSTANCE, ".mustache");
        register(JavalinPebble.INSTANCE, ".peb", ".pebble");
        register(JavalinThymeleaf.INSTANCE, ".html", ".tl", ".thyme", ".thymeleaf");
        register(JavalinCommonmark.INSTANCE, ".md", ".markdown");
        register(JavalinJte.INSTANCE, ".jte", ".kte");
    }

    @NotNull
    public final String renderBasedOnExtension(@NotNull String filePath, @NotNull Map<String, ? extends Object> map, @NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(map, "model");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        FileRenderer renderer = extensions.get(getExtension(filePath));
        if (renderer == null) {
            throw new IllegalArgumentException("No Renderer registered for extension '" + getExtension(filePath) + "'.");
        }
        String render = renderer.render(filePath, MapsKt.plus((Map) baseModelFunction.invoke(ctx), map), ctx);
        Intrinsics.checkNotNullExpressionValue(render, "renderer.render(filePath…nction(ctx) + model, ctx)");
        return render;
    }

    @JvmStatic
    public static final void register(@NotNull FileRenderer fileRenderer, @NotNull String... ext) {
        Intrinsics.checkNotNullParameter(fileRenderer, "fileRenderer");
        Intrinsics.checkNotNullParameter(ext, "ext");
        for (String str : ext) {
            if (extensions.get(str) != null) {
                StringBuilder append = new StringBuilder().append('\'').append(str).append("' is already registered to ");
                FileRenderer fileRenderer2 = extensions.get(str);
                Intrinsics.checkNotNull(fileRenderer2);
                JavalinLogger.info$default(append.append(fileRenderer2.getClass()).append(". Overriding.").toString(), null, 2, null);
            }
            extensions.put(str, fileRenderer);
        }
    }

    private final String getExtension(String $this$extension) {
        return StringsKt.replaceBeforeLast$default($this$extension, Mapper.IGNORED_FIELDNAME, "", (String) null, 4, (Object) null);
    }
}
