package p013io.javalin.plugin.rendering.template;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
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

/* compiled from: JavalinPebble.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u0003\u001a\n \r*\u0004\u0018\u00010\u00040\u0004H\u0002J0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n��¨\u0006\u0016"}, m373d2 = {"Lio/javalin/plugin/rendering/template/JavalinPebble;", "Lio/javalin/plugin/rendering/FileRenderer;", "()V", "defaultPebbleEngine", "Lcom/mitchellbosecke/pebble/PebbleEngine;", "getDefaultPebbleEngine", "()Lcom/mitchellbosecke/pebble/PebbleEngine;", "defaultPebbleEngine$delegate", "Lkotlin/Lazy;", "pebbleEngine", "configure", "", "staticPebbleEngine", "kotlin.jvm.PlatformType", "render", "", "filePath", "model", "", "", "ctx", "Lio/javalin/http/Context;", "javalin"})
/* renamed from: io.javalin.plugin.rendering.template.JavalinPebble */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/template/JavalinPebble.class */
public final class JavalinPebble implements FileRenderer {
    @Nullable
    private static PebbleEngine pebbleEngine;
    @NotNull
    public static final JavalinPebble INSTANCE = new JavalinPebble();
    @NotNull
    private static final Lazy defaultPebbleEngine$delegate = LazyKt.lazy(JavalinPebble$defaultPebbleEngine$2.INSTANCE);

    private JavalinPebble() {
    }

    private final PebbleEngine getDefaultPebbleEngine() {
        Object value = defaultPebbleEngine$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-defaultPebbleEngine>(...)");
        return (PebbleEngine) value;
    }

    @JvmStatic
    public static final void configure(@NotNull PebbleEngine staticPebbleEngine) {
        Intrinsics.checkNotNullParameter(staticPebbleEngine, "staticPebbleEngine");
        JavalinPebble javalinPebble = INSTANCE;
        pebbleEngine = staticPebbleEngine;
    }

    @Override // p013io.javalin.plugin.rendering.FileRenderer
    @NotNull
    public String render(@NotNull String filePath, @NotNull Map<String, ? extends Object> map, @Nullable Context ctx) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(map, "model");
        Util.ensureDependencyPresent$default(Util.INSTANCE, OptionalDependency.PEBBLE, false, 2, null);
        PebbleEngine pebbleEngine2 = pebbleEngine;
        PebbleTemplate compiledTemplate = (pebbleEngine2 == null ? getDefaultPebbleEngine() : pebbleEngine2).getTemplate(filePath);
        StringWriter stringWriter = new StringWriter();
        compiledTemplate.evaluate(stringWriter, map);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "stringWriter.toString()");
        return stringWriter2;
    }

    /* access modifiers changed from: private */
    public final PebbleEngine defaultPebbleEngine() {
        return new PebbleEngine.Builder().loader(new ClasspathLoader()).strictVariables(false).build();
    }
}
