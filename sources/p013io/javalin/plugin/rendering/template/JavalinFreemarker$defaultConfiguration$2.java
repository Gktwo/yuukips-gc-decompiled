package p013io.javalin.plugin.rendering.template;

import freemarker.template.Configuration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavalinFreemarker.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\u0006\n��\n\u0002\u0018\u0002\u0010��\u001a\u00020\u0001H\n"}, m373d2 = {"<anonymous>", "Lfreemarker/template/Configuration;"})
/* renamed from: io.javalin.plugin.rendering.template.JavalinFreemarker$defaultConfiguration$2 */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/template/JavalinFreemarker$defaultConfiguration$2.class */
final class JavalinFreemarker$defaultConfiguration$2 extends Lambda implements Function0<Configuration> {
    public static final JavalinFreemarker$defaultConfiguration$2 INSTANCE = new JavalinFreemarker$defaultConfiguration$2();

    JavalinFreemarker$defaultConfiguration$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Configuration invoke() {
        return JavalinFreemarker.INSTANCE.defaultFreemarkerEngine();
    }
}
