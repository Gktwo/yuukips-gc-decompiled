package p013io.javalin.plugin.rendering.template;

import gg.jte.TemplateEngine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: JavalinJte.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\b\n��\n\u0002\u0018\u0002\n��\u0010��\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, m373d2 = {"<anonymous>", "Lgg/jte/TemplateEngine;", "kotlin.jvm.PlatformType"})
/* renamed from: io.javalin.plugin.rendering.template.JavalinJte$defaultTemplateEngine$2 */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/template/JavalinJte$defaultTemplateEngine$2.class */
final class JavalinJte$defaultTemplateEngine$2 extends Lambda implements Function0<TemplateEngine> {
    public static final JavalinJte$defaultTemplateEngine$2 INSTANCE = new JavalinJte$defaultTemplateEngine$2();

    JavalinJte$defaultTemplateEngine$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final TemplateEngine invoke() {
        return JavalinJte.INSTANCE.defaultJteEngine();
    }
}
