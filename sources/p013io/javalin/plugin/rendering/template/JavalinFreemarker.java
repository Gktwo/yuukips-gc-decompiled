package p013io.javalin.plugin.rendering.template;

import freemarker.template.Configuration;
import freemarker.template.Version;
import java.io.StringWriter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.core.util.OptionalDependency;
import p013io.javalin.core.util.Util;
import p013io.javalin.http.Context;
import p013io.javalin.plugin.rendering.FileRenderer;

/* compiled from: JavalinFreemarker.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0002J0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n��R\u001b\u0010\u0005\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, m373d2 = {"Lio/javalin/plugin/rendering/template/JavalinFreemarker;", "Lio/javalin/plugin/rendering/FileRenderer;", "()V", "configuration", "Lfreemarker/template/Configuration;", "defaultConfiguration", "getDefaultConfiguration", "()Lfreemarker/template/Configuration;", "defaultConfiguration$delegate", "Lkotlin/Lazy;", "configure", "", "staticConfiguration", "defaultFreemarkerEngine", "render", "", "filePath", "model", "", "", "ctx", "Lio/javalin/http/Context;", "javalin"})
/* renamed from: io.javalin.plugin.rendering.template.JavalinFreemarker */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/template/JavalinFreemarker.class */
public final class JavalinFreemarker implements FileRenderer {
    @Nullable
    private static Configuration configuration;
    @NotNull
    public static final JavalinFreemarker INSTANCE = new JavalinFreemarker();
    @NotNull
    private static final Lazy defaultConfiguration$delegate = LazyKt.lazy(JavalinFreemarker$defaultConfiguration$2.INSTANCE);

    private JavalinFreemarker() {
    }

    private final Configuration getDefaultConfiguration() {
        return (Configuration) defaultConfiguration$delegate.getValue();
    }

    @JvmStatic
    public static final void configure(@NotNull Configuration staticConfiguration) {
        Intrinsics.checkNotNullParameter(staticConfiguration, "staticConfiguration");
        JavalinFreemarker javalinFreemarker = INSTANCE;
        configuration = staticConfiguration;
    }

    @Override // p013io.javalin.plugin.rendering.FileRenderer
    @NotNull
    public String render(@NotNull String filePath, @NotNull Map<String, ? extends Object> map, @Nullable Context ctx) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(map, "model");
        Util.ensureDependencyPresent$default(Util.INSTANCE, OptionalDependency.FREEMARKER, false, 2, null);
        StringWriter stringWriter = new StringWriter();
        Configuration configuration2 = configuration;
        (configuration2 == null ? getDefaultConfiguration() : configuration2).getTemplate(filePath).process(map, stringWriter);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "stringWriter.toString()");
        return stringWriter2;
    }

    /* access modifiers changed from: private */
    public final Configuration defaultFreemarkerEngine() {
        Configuration $this$defaultFreemarkerEngine_u24lambda_u2d0 = new Configuration(new Version(2, 3, 26));
        $this$defaultFreemarkerEngine_u24lambda_u2d0.setClassForTemplateLoading(JavalinFreemarker.class, "/");
        return $this$defaultFreemarkerEngine_u24lambda_u2d0;
    }
}
