package p013io.javalin.plugin.rendering.markdown;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.commonmark.renderer.html.HtmlRenderer;

/* compiled from: Commonmark.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\b\n��\n\u0002\u0018\u0002\n��\u0010��\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, m373d2 = {"<anonymous>", "Lorg/commonmark/renderer/html/HtmlRenderer;", "kotlin.jvm.PlatformType"})
/* renamed from: io.javalin.plugin.rendering.markdown.JavalinCommonmark$defaultRenderer$2 */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/markdown/JavalinCommonmark$defaultRenderer$2.class */
final class JavalinCommonmark$defaultRenderer$2 extends Lambda implements Function0<HtmlRenderer> {
    public static final JavalinCommonmark$defaultRenderer$2 INSTANCE = new JavalinCommonmark$defaultRenderer$2();

    JavalinCommonmark$defaultRenderer$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final HtmlRenderer invoke() {
        return HtmlRenderer.builder().build();
    }
}
