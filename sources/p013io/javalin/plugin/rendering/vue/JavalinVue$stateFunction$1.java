package p013io.javalin.plugin.rendering.vue;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Context;

/* compiled from: JavalinVue.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\u0010\n��\n\u0002\u0010$\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\u0010��\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, m373d2 = {"<anonymous>", "", "", "it", "Lio/javalin/http/Context;"})
/* renamed from: io.javalin.plugin.rendering.vue.JavalinVue$stateFunction$1 */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/JavalinVue$stateFunction$1.class */
final class JavalinVue$stateFunction$1 extends Lambda implements Function1<Context, Map<String, ? extends String>> {
    public static final JavalinVue$stateFunction$1 INSTANCE = new JavalinVue$stateFunction$1();

    JavalinVue$stateFunction$1() {
        super(1);
    }

    @NotNull
    public final Map<String, String> invoke(@NotNull Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return MapsKt.emptyMap();
    }
}
