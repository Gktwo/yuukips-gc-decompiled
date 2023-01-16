package p013io.javalin.plugin.rendering.template;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.thymeleaf.TemplateEngine;

/* compiled from: JavalinThymeleaf.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\u0006\n��\n\u0002\u0018\u0002\u0010��\u001a\u00020\u0001H\n"}, m373d2 = {"<anonymous>", "Lorg/thymeleaf/TemplateEngine;"})
/* renamed from: io.javalin.plugin.rendering.template.JavalinThymeleaf$defaultTemplateEngine$2 */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/template/JavalinThymeleaf$defaultTemplateEngine$2.class */
final class JavalinThymeleaf$defaultTemplateEngine$2 extends Lambda implements Function0<TemplateEngine> {
    public static final JavalinThymeleaf$defaultTemplateEngine$2 INSTANCE = new JavalinThymeleaf$defaultTemplateEngine$2();

    JavalinThymeleaf$defaultTemplateEngine$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final TemplateEngine invoke() {
        return JavalinThymeleaf.INSTANCE.defaultThymeLeafEngine();
    }
}
