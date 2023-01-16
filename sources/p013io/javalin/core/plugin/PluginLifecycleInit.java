package p013io.javalin.core.plugin;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.Javalin;

/* compiled from: PluginLifecyles.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0016\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\bf\u0018��2\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m373d2 = {"Lio/javalin/core/plugin/PluginLifecycleInit;", "", "init", "", "app", "Lio/javalin/Javalin;", "javalin"})
/* renamed from: io.javalin.core.plugin.PluginLifecycleInit */
/* loaded from: grasscutter.jar:io/javalin/core/plugin/PluginLifecycleInit.class */
public interface PluginLifecycleInit {
    void init(@NotNull Javalin javalin);
}
