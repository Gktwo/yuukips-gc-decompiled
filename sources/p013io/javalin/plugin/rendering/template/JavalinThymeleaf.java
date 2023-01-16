package p013io.javalin.plugin.rendering.template;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import p013io.javalin.core.util.OptionalDependency;
import p013io.javalin.core.util.Util;
import p013io.javalin.http.Context;
import p013io.javalin.plugin.rendering.FileRenderer;

/* compiled from: JavalinThymeleaf.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0002J.\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n��¨\u0006\u0016"}, m373d2 = {"Lio/javalin/plugin/rendering/template/JavalinThymeleaf;", "Lio/javalin/plugin/rendering/FileRenderer;", "()V", "defaultTemplateEngine", "Lorg/thymeleaf/TemplateEngine;", "getDefaultTemplateEngine", "()Lorg/thymeleaf/TemplateEngine;", "defaultTemplateEngine$delegate", "Lkotlin/Lazy;", "templateEngine", "configure", "", "staticTemplateEngine", "defaultThymeLeafEngine", "render", "", "filePath", "model", "", "", "ctx", "Lio/javalin/http/Context;", "javalin"})
/* renamed from: io.javalin.plugin.rendering.template.JavalinThymeleaf */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/template/JavalinThymeleaf.class */
public final class JavalinThymeleaf implements FileRenderer {
    @Nullable
    private static TemplateEngine templateEngine;
    @NotNull
    public static final JavalinThymeleaf INSTANCE = new JavalinThymeleaf();
    @NotNull
    private static final Lazy defaultTemplateEngine$delegate = LazyKt.lazy(JavalinThymeleaf$defaultTemplateEngine$2.INSTANCE);

    private JavalinThymeleaf() {
    }

    private final TemplateEngine getDefaultTemplateEngine() {
        return (TemplateEngine) defaultTemplateEngine$delegate.getValue();
    }

    @JvmStatic
    public static final void configure(@NotNull TemplateEngine staticTemplateEngine) {
        Intrinsics.checkNotNullParameter(staticTemplateEngine, "staticTemplateEngine");
        JavalinThymeleaf javalinThymeleaf = INSTANCE;
        templateEngine = staticTemplateEngine;
    }

    @Override // p013io.javalin.plugin.rendering.FileRenderer
    @NotNull
    public String render(@NotNull String filePath, @NotNull Map<String, ? extends Object> map, @NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(map, "model");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Util.ensureDependencyPresent$default(Util.INSTANCE, OptionalDependency.THYMELEAF, false, 2, null);
        WebContext context = new WebContext(ctx.req, ctx.res, ctx.req.getServletContext());
        context.setVariables(map);
        TemplateEngine templateEngine2 = templateEngine;
        String process = (templateEngine2 == null ? getDefaultTemplateEngine() : templateEngine2).process(filePath, (IContext) context);
        Intrinsics.checkNotNullExpressionValue(process, "templateEngine ?: defaul…rocess(filePath, context)");
        return process;
    }

    /* access modifiers changed from: private */
    public final TemplateEngine defaultThymeLeafEngine() {
        TemplateEngine $this$defaultThymeLeafEngine_u24lambda_u2d1 = new TemplateEngine();
        ClassLoaderTemplateResolver $this$defaultThymeLeafEngine_u24lambda_u2d1_u24lambda_u2d0 = new ClassLoaderTemplateResolver();
        $this$defaultThymeLeafEngine_u24lambda_u2d1_u24lambda_u2d0.setTemplateMode(TemplateMode.HTML);
        Unit unit = Unit.INSTANCE;
        $this$defaultThymeLeafEngine_u24lambda_u2d1.setTemplateResolver((ITemplateResolver) $this$defaultThymeLeafEngine_u24lambda_u2d1_u24lambda_u2d0);
        return $this$defaultThymeLeafEngine_u24lambda_u2d1;
    }
}
