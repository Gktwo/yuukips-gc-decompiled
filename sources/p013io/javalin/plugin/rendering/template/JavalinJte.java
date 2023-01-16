package p013io.javalin.plugin.rendering.template;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;
import gg.jte.resolve.DirectoryCodeResolver;
import java.io.File;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.core.util.OptionalDependency;
import p013io.javalin.core.util.Util;
import p013io.javalin.http.Context;
import p013io.javalin.plugin.rendering.FileRenderer;

/* compiled from: JavalinJte.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010��\n\u0002\b\u0002\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\n \u0014*\u0004\u0018\u00010\u00040\u0004H\u0002J.\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u000eH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u001e\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\r8\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n��¨\u0006\u001c"}, m373d2 = {"Lio/javalin/plugin/rendering/template/JavalinJte;", "Lio/javalin/plugin/rendering/FileRenderer;", "()V", "defaultTemplateEngine", "Lgg/jte/TemplateEngine;", "getDefaultTemplateEngine", "()Lgg/jte/TemplateEngine;", "defaultTemplateEngine$delegate", "Lkotlin/Lazy;", "isDev", "", "Ljava/lang/Boolean;", "isDevFunction", "Lkotlin/Function1;", "Lio/javalin/http/Context;", "templateEngine", "configure", "", "staticTemplateEngine", "defaultJteEngine", "kotlin.jvm.PlatformType", "render", "", "filePath", "model", "", "", "ctx", "javalin"})
/* renamed from: io.javalin.plugin.rendering.template.JavalinJte */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/template/JavalinJte.class */
public final class JavalinJte implements FileRenderer {
    @Nullable
    private static Boolean isDev;
    @Nullable
    private static TemplateEngine templateEngine;
    @NotNull
    public static final JavalinJte INSTANCE = new JavalinJte();
    @JvmField
    @NotNull
    public static Function1<? super Context, Boolean> isDevFunction = JavalinJte$isDevFunction$1.INSTANCE;
    @NotNull
    private static final Lazy defaultTemplateEngine$delegate = LazyKt.lazy(JavalinJte$defaultTemplateEngine$2.INSTANCE);

    private JavalinJte() {
    }

    private final TemplateEngine getDefaultTemplateEngine() {
        Object value = defaultTemplateEngine$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-defaultTemplateEngine>(...)");
        return (TemplateEngine) value;
    }

    @JvmStatic
    public static final void configure(@NotNull TemplateEngine staticTemplateEngine) {
        Intrinsics.checkNotNullParameter(staticTemplateEngine, "staticTemplateEngine");
        JavalinJte javalinJte = INSTANCE;
        templateEngine = staticTemplateEngine;
    }

    @Override // p013io.javalin.plugin.rendering.FileRenderer
    @NotNull
    public String render(@NotNull String filePath, @NotNull Map<String, ? extends Object> map, @NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(map, "model");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Util.ensureDependencyPresent$default(Util.INSTANCE, OptionalDependency.JTE, false, 2, null);
        Boolean bool = isDev;
        isDev = bool == null ? isDevFunction.invoke(ctx) : bool;
        if (Intrinsics.areEqual((Object) isDev, (Object) true) && StringsKt.endsWith$default(filePath, ".kte", false, 2, (Object) null)) {
            Util.ensureDependencyPresent$default(Util.INSTANCE, OptionalDependency.JTE_KOTLIN, false, 2, null);
        }
        StringOutput stringOutput = new StringOutput();
        TemplateEngine templateEngine2 = templateEngine;
        (templateEngine2 == null ? getDefaultTemplateEngine() : templateEngine2).render(filePath, map, (TemplateOutput) stringOutput);
        String stringOutput2 = stringOutput.toString();
        Intrinsics.checkNotNullExpressionValue(stringOutput2, "stringOutput.toString()");
        return stringOutput2;
    }

    /* access modifiers changed from: private */
    public final TemplateEngine defaultJteEngine() {
        return TemplateEngine.create(new DirectoryCodeResolver(new File("src/main/jte").toPath()), ContentType.Html);
    }
}
