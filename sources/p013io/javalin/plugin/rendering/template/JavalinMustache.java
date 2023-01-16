package p013io.javalin.plugin.rendering.template;

import com.github.mustachejava.MustacheFactory;
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

/* compiled from: JavalinMustache.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n��¨\u0006\u0015"}, m373d2 = {"Lio/javalin/plugin/rendering/template/JavalinMustache;", "Lio/javalin/plugin/rendering/FileRenderer;", "()V", "defaultMustacheFactory", "Lcom/github/mustachejava/MustacheFactory;", "getDefaultMustacheFactory", "()Lcom/github/mustachejava/MustacheFactory;", "defaultMustacheFactory$delegate", "Lkotlin/Lazy;", "mustacheFactory", "configure", "", "staticMustacheFactory", "render", "", "filePath", "model", "", "", "ctx", "Lio/javalin/http/Context;", "javalin"})
/* renamed from: io.javalin.plugin.rendering.template.JavalinMustache */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/template/JavalinMustache.class */
public final class JavalinMustache implements FileRenderer {
    @Nullable
    private static MustacheFactory mustacheFactory;
    @NotNull
    public static final JavalinMustache INSTANCE = new JavalinMustache();
    @NotNull
    private static final Lazy defaultMustacheFactory$delegate = LazyKt.lazy(JavalinMustache$defaultMustacheFactory$2.INSTANCE);

    private JavalinMustache() {
    }

    private final MustacheFactory getDefaultMustacheFactory() {
        return (MustacheFactory) defaultMustacheFactory$delegate.getValue();
    }

    @JvmStatic
    public static final void configure(@NotNull MustacheFactory staticMustacheFactory) {
        Intrinsics.checkNotNullParameter(staticMustacheFactory, "staticMustacheFactory");
        JavalinMustache javalinMustache = INSTANCE;
        mustacheFactory = staticMustacheFactory;
    }

    @Override // p013io.javalin.plugin.rendering.FileRenderer
    @NotNull
    public String render(@NotNull String filePath, @NotNull Map<String, ? extends Object> map, @Nullable Context ctx) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(map, "model");
        Util.ensureDependencyPresent$default(Util.INSTANCE, OptionalDependency.MUSTACHE, false, 2, null);
        StringWriter stringWriter = new StringWriter();
        MustacheFactory mustacheFactory2 = mustacheFactory;
        (mustacheFactory2 == null ? getDefaultMustacheFactory() : mustacheFactory2).compile(filePath).execute(stringWriter, map).close();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "stringWriter.toString()");
        return stringWriter2;
    }
}
