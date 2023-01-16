package p013io.javalin.plugin.rendering.template;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.apache.velocity.app.VelocityEngine;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavalinVelocity.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\u0006\n��\n\u0002\u0018\u0002\u0010��\u001a\u00020\u0001H\n"}, m373d2 = {"<anonymous>", "Lorg/apache/velocity/app/VelocityEngine;"})
/* renamed from: io.javalin.plugin.rendering.template.JavalinVelocity$defaultVelocityEngine$2 */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/template/JavalinVelocity$defaultVelocityEngine$2.class */
final class JavalinVelocity$defaultVelocityEngine$2 extends Lambda implements Function0<VelocityEngine> {
    public static final JavalinVelocity$defaultVelocityEngine$2 INSTANCE = new JavalinVelocity$defaultVelocityEngine$2();

    JavalinVelocity$defaultVelocityEngine$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final VelocityEngine invoke() {
        return JavalinVelocity.INSTANCE.defaultVelocityEngine();
    }
}
