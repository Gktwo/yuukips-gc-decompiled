package p013io.javalin.core.plugin;

import org.jetbrains.annotations.NotNull;
import p013io.javalin.Javalin;

@FunctionalInterface
/* renamed from: io.javalin.core.plugin.Plugin */
/* loaded from: grasscutter.jar:io/javalin/core/plugin/Plugin.class */
public interface Plugin {
    void apply(@NotNull Javalin javalin);
}
