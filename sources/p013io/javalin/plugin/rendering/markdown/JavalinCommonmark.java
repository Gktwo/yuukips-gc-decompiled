package p013io.javalin.plugin.rendering.markdown;

import java.net.URL;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p016io.TextStreamsKt;
import kotlin.text.Charsets;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.core.util.OptionalDependency;
import p013io.javalin.core.util.Util;
import p013io.javalin.http.Context;
import p013io.javalin.plugin.rendering.FileRenderer;

/* compiled from: Commonmark.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J0\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n��R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n��¨\u0006\u001c"}, m373d2 = {"Lio/javalin/plugin/rendering/markdown/JavalinCommonmark;", "Lio/javalin/plugin/rendering/FileRenderer;", "()V", "defaultParser", "Lorg/commonmark/parser/Parser;", "getDefaultParser", "()Lorg/commonmark/parser/Parser;", "defaultParser$delegate", "Lkotlin/Lazy;", "defaultRenderer", "Lorg/commonmark/renderer/html/HtmlRenderer;", "getDefaultRenderer", "()Lorg/commonmark/renderer/html/HtmlRenderer;", "defaultRenderer$delegate", "parser", "renderer", "configure", "", "staticHtmlRenderer", "staticMarkdownParser", "render", "", "filePath", "model", "", "", "ctx", "Lio/javalin/http/Context;", "javalin"})
/* renamed from: io.javalin.plugin.rendering.markdown.JavalinCommonmark */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/markdown/JavalinCommonmark.class */
public final class JavalinCommonmark implements FileRenderer {
    @Nullable
    private static HtmlRenderer renderer;
    @Nullable
    private static Parser parser;
    @NotNull
    public static final JavalinCommonmark INSTANCE = new JavalinCommonmark();
    @NotNull
    private static final Lazy defaultRenderer$delegate = LazyKt.lazy(JavalinCommonmark$defaultRenderer$2.INSTANCE);
    @NotNull
    private static final Lazy defaultParser$delegate = LazyKt.lazy(Commonmark.INSTANCE);

    private JavalinCommonmark() {
    }

    private final HtmlRenderer getDefaultRenderer() {
        Object value = defaultRenderer$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-defaultRenderer>(...)");
        return (HtmlRenderer) value;
    }

    private final Parser getDefaultParser() {
        Object value = defaultParser$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-defaultParser>(...)");
        return (Parser) value;
    }

    @JvmStatic
    public static final void configure(@NotNull HtmlRenderer staticHtmlRenderer, @NotNull Parser staticMarkdownParser) {
        Intrinsics.checkNotNullParameter(staticHtmlRenderer, "staticHtmlRenderer");
        Intrinsics.checkNotNullParameter(staticMarkdownParser, "staticMarkdownParser");
        JavalinCommonmark javalinCommonmark = INSTANCE;
        renderer = staticHtmlRenderer;
        JavalinCommonmark javalinCommonmark2 = INSTANCE;
        parser = staticMarkdownParser;
    }

    @Override // p013io.javalin.plugin.rendering.FileRenderer
    @NotNull
    public String render(@NotNull String filePath, @NotNull Map<String, ? extends Object> map, @Nullable Context ctx) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(map, "model");
        Util.ensureDependencyPresent$default(Util.INSTANCE, OptionalDependency.COMMONMARK, false, 2, null);
        URL resource = JavalinCommonmark.class.getResource(filePath);
        Intrinsics.checkNotNullExpressionValue(resource, "JavalinCommonmark::class…ava.getResource(filePath)");
        String fileContent = new String(TextStreamsKt.readBytes(resource), Charsets.UTF_8);
        HtmlRenderer htmlRenderer = renderer;
        HtmlRenderer defaultRenderer = htmlRenderer == null ? getDefaultRenderer() : htmlRenderer;
        Parser parser2 = parser;
        String render = defaultRenderer.render((parser2 == null ? getDefaultParser() : parser2).parse(fileContent));
        Intrinsics.checkNotNullExpressionValue(render, "renderer ?: defaultRende…rser).parse(fileContent))");
        return render;
    }
}
