package p013io.javalin.plugin.rendering.template;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Context;
import p013io.javalin.http.util.ContextUtil;

/* compiled from: JavalinJte.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\f\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m373d2 = {"<anonymous>", "", "it", "Lio/javalin/http/Context;"})
/* renamed from: io.javalin.plugin.rendering.template.JavalinJte$isDevFunction$1 */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/template/JavalinJte$isDevFunction$1.class */
final class JavalinJte$isDevFunction$1 extends Lambda implements Function1<Context, Boolean> {
    public static final JavalinJte$isDevFunction$1 INSTANCE = new JavalinJte$isDevFunction$1();

    JavalinJte$isDevFunction$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(ContextUtil.INSTANCE.isLocalhost(it));
    }
}
