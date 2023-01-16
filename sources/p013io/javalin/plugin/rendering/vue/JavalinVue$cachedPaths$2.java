package p013io.javalin.plugin.rendering.vue;

import java.nio.file.Path;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavalinVue.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\n\n��\n\u0002\u0010\"\n\u0002\u0018\u0002\u0010��\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, m373d2 = {"<anonymous>", "", "Ljava/nio/file/Path;"})
/* renamed from: io.javalin.plugin.rendering.vue.JavalinVue$cachedPaths$2 */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/JavalinVue$cachedPaths$2.class */
final class JavalinVue$cachedPaths$2 extends Lambda implements Function0<Set<? extends Path>> {
    public static final JavalinVue$cachedPaths$2 INSTANCE = new JavalinVue$cachedPaths$2();

    JavalinVue$cachedPaths$2() {
        super(0);
    }

    /* Return type fixed from 'java.util.Set<java.nio.file.Path>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Set<? extends Path> invoke() {
        return JavalinVue.INSTANCE.walkPaths();
    }
}
