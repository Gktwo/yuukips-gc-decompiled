package p013io.javalin.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p013io.javalin.core.plugin.Plugin;

@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010��\u001a\u0002H\u0001\"\n\b��\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\b¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m373d2 = {"getPlugin", "T", "Lio/javalin/core/plugin/Plugin;", "Lio/javalin/core/JavalinConfig;", "(Lio/javalin/core/JavalinConfig;)Lio/javalin/core/plugin/Plugin;", "javalin"})
/* renamed from: io.javalin.core.JavalinConfigExtKt */
/* loaded from: grasscutter.jar:io/javalin/core/JavalinConfigExtKt.class */
public final class JavalinConfigExt {
    public static final /* synthetic */ <T extends Plugin> T getPlugin(JavalinConfig $this$getPlugin) {
        Intrinsics.checkNotNullParameter($this$getPlugin, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        Plugin plugin = $this$getPlugin.getPlugin(Plugin.class);
        Intrinsics.checkNotNullExpressionValue(plugin, "getPlugin(T::class.java)");
        return (T) plugin;
    }
}
