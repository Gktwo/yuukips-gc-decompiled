package p013io.javalin.plugin.rendering.template;

import com.github.mustachejava.DefaultMustacheFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavalinMustache.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\u0006\n��\n\u0002\u0018\u0002\u0010��\u001a\u00020\u0001H\n"}, m373d2 = {"<anonymous>", "Lcom/github/mustachejava/DefaultMustacheFactory;"})
/* renamed from: io.javalin.plugin.rendering.template.JavalinMustache$defaultMustacheFactory$2 */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/template/JavalinMustache$defaultMustacheFactory$2.class */
final class JavalinMustache$defaultMustacheFactory$2 extends Lambda implements Function0<DefaultMustacheFactory> {
    public static final JavalinMustache$defaultMustacheFactory$2 INSTANCE = new JavalinMustache$defaultMustacheFactory$2();

    JavalinMustache$defaultMustacheFactory$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final DefaultMustacheFactory invoke() {
        return new DefaultMustacheFactory("./");
    }
}
