package p013io.javalin.plugin.rendering;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Context;

/* compiled from: JavalinRenderer.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\u0014\n��\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010��\n��\n\u0002\u0018\u0002\u0010��\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, m373d2 = {"<anonymous>", "", "", "", "it", "Lio/javalin/http/Context;"})
/* renamed from: io.javalin.plugin.rendering.JavalinRenderer$baseModelFunction$1 */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/JavalinRenderer$baseModelFunction$1.class */
final class JavalinRenderer$baseModelFunction$1 extends Lambda implements Function1<Context, Map<String, ? extends Object>> {
    public static final JavalinRenderer$baseModelFunction$1 INSTANCE = new JavalinRenderer$baseModelFunction$1();

    JavalinRenderer$baseModelFunction$1() {
        super(1);
    }

    @NotNull
    public final Map<String, Object> invoke(@NotNull Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return MapsKt.emptyMap();
    }
}
