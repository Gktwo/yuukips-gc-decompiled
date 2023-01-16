package p013io.javalin.plugin.rendering.template;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.core.util.OptionalDependency;
import p013io.javalin.core.util.Util;
import p013io.javalin.http.Context;
import p013io.javalin.plugin.rendering.FileRenderer;

/* compiled from: JavalinVelocity.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0006\u0010\u0003\u001a\u00020\u0004J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n��¨\u0006\u0015"}, m373d2 = {"Lio/javalin/plugin/rendering/template/JavalinVelocity;", "Lio/javalin/plugin/rendering/FileRenderer;", "()V", "defaultVelocityEngine", "Lorg/apache/velocity/app/VelocityEngine;", "getDefaultVelocityEngine", "()Lorg/apache/velocity/app/VelocityEngine;", "defaultVelocityEngine$delegate", "Lkotlin/Lazy;", "velocityEngine", "configure", "", "staticVelocityEngine", "render", "", "filePath", "model", "", "", "ctx", "Lio/javalin/http/Context;", "javalin"})
/* renamed from: io.javalin.plugin.rendering.template.JavalinVelocity */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/template/JavalinVelocity.class */
public final class JavalinVelocity implements FileRenderer {
    @Nullable
    private static VelocityEngine velocityEngine;
    @NotNull
    public static final JavalinVelocity INSTANCE = new JavalinVelocity();
    @NotNull
    private static final Lazy defaultVelocityEngine$delegate = LazyKt.lazy(JavalinVelocity$defaultVelocityEngine$2.INSTANCE);

    private JavalinVelocity() {
    }

    private final VelocityEngine getDefaultVelocityEngine() {
        return (VelocityEngine) defaultVelocityEngine$delegate.getValue();
    }

    @JvmStatic
    public static final void configure(@NotNull VelocityEngine staticVelocityEngine) {
        Intrinsics.checkNotNullParameter(staticVelocityEngine, "staticVelocityEngine");
        JavalinVelocity javalinVelocity = INSTANCE;
        velocityEngine = staticVelocityEngine;
    }

    @Override // p013io.javalin.plugin.rendering.FileRenderer
    @NotNull
    public String render(@NotNull String filePath, @NotNull Map<String, ? extends Object> map, @Nullable Context ctx) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(map, "model");
        Util.ensureDependencyPresent$default(Util.INSTANCE, OptionalDependency.VELOCITY, false, 2, null);
        StringWriter stringWriter = new StringWriter();
        VelocityEngine velocityEngine2 = velocityEngine;
        (velocityEngine2 == null ? getDefaultVelocityEngine() : velocityEngine2).getTemplate(filePath, StandardCharsets.UTF_8.name()).merge(new VelocityContext(MapsKt.toMutableMap(map)), stringWriter);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "stringWriter.toString()");
        return stringWriter2;
    }

    @NotNull
    public final VelocityEngine defaultVelocityEngine() {
        VelocityEngine $this$defaultVelocityEngine_u24lambda_u2d0 = new VelocityEngine();
        $this$defaultVelocityEngine_u24lambda_u2d0.setProperty("resource.loaders", "class");
        $this$defaultVelocityEngine_u24lambda_u2d0.setProperty("resource.loader.class.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        return $this$defaultVelocityEngine_u24lambda_u2d0;
    }
}
