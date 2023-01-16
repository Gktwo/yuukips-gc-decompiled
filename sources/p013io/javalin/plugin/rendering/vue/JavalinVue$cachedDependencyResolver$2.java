package p013io.javalin.plugin.rendering.vue;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavalinVue.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\u0006\n��\n\u0002\u0018\u0002\u0010��\u001a\u00020\u0001H\n"}, m373d2 = {"<anonymous>", "Lio/javalin/plugin/rendering/vue/VueDependencyResolver;"})
/* renamed from: io.javalin.plugin.rendering.vue.JavalinVue$cachedDependencyResolver$2 */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/JavalinVue$cachedDependencyResolver$2.class */
final class JavalinVue$cachedDependencyResolver$2 extends Lambda implements Function0<VueDependencyResolver> {
    public static final JavalinVue$cachedDependencyResolver$2 INSTANCE = new JavalinVue$cachedDependencyResolver$2();

    JavalinVue$cachedDependencyResolver$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final VueDependencyResolver invoke() {
        return new VueDependencyResolver(JavalinVue.INSTANCE.getCachedPaths$javalin(), JavalinVue.INSTANCE.getVueAppName$javalin());
    }
}
