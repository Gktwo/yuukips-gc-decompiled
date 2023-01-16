package p013io.javalin.core.plugin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: PluginExceptions.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n��\n\u0002\u0010��\n��\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n��\b\b\u0018��2\u00060\u0001j\u0002`\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004HÆ\u0003J\u001b\u0010\n\u001a\u00020��2\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0019\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, m373d2 = {"Lio/javalin/core/plugin/PluginAlreadyRegisteredException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "pluginClass", "Ljava/lang/Class;", "Lio/javalin/core/plugin/Plugin;", "(Ljava/lang/Class;)V", "getPluginClass", "()Ljava/lang/Class;", "component1", "copy", "equals", "", "other", "", "hashCode", "", Printer.TO_STRING, "", "javalin"})
/* renamed from: io.javalin.core.plugin.PluginAlreadyRegisteredException */
/* loaded from: grasscutter.jar:io/javalin/core/plugin/PluginAlreadyRegisteredException.class */
public final class PluginAlreadyRegisteredException extends RuntimeException {
    @NotNull
    private final Class<? extends Plugin> pluginClass;

    @NotNull
    public final Class<? extends Plugin> component1() {
        return this.pluginClass;
    }

    @NotNull
    public final PluginAlreadyRegisteredException copy(@NotNull Class<? extends Plugin> cls) {
        Intrinsics.checkNotNullParameter(cls, "pluginClass");
        return new PluginAlreadyRegisteredException(cls);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: io.javalin.core.plugin.PluginAlreadyRegisteredException */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PluginAlreadyRegisteredException copy$default(PluginAlreadyRegisteredException pluginAlreadyRegisteredException, Class cls, int i, Object obj) {
        if ((i & 1) != 0) {
            cls = pluginAlreadyRegisteredException.pluginClass;
        }
        return pluginAlreadyRegisteredException.copy(cls);
    }

    @Override // java.lang.Throwable, java.lang.Object
    @NotNull
    public String toString() {
        return "PluginAlreadyRegisteredException(pluginClass=" + this.pluginClass + ')';
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.pluginClass.hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PluginAlreadyRegisteredException) && Intrinsics.areEqual(this.pluginClass, ((PluginAlreadyRegisteredException) other).pluginClass);
    }

    @NotNull
    public final Class<? extends Plugin> getPluginClass() {
        return this.pluginClass;
    }

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public PluginAlreadyRegisteredException(@NotNull Class<? extends Plugin> cls) {
        super(Intrinsics.stringPlus(cls.getCanonicalName(), " is already registered"));
        Intrinsics.checkNotNullParameter(cls, "pluginClass");
        this.pluginClass = cls;
    }
}
