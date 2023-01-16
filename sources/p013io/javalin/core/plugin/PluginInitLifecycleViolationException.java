package p013io.javalin.core.plugin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: PluginExceptions.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n��\n\u0002\u0010��\n��\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n��\b\b\u0018��2\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020��2\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m373d2 = {"Lio/javalin/core/plugin/PluginInitLifecycleViolationException;", "Lio/javalin/core/plugin/PluginLifecycleViolationException;", "pluginClass", "Ljava/lang/Class;", "Lio/javalin/core/plugin/Plugin;", "(Ljava/lang/Class;)V", "getPluginClass", "()Ljava/lang/Class;", "component1", "copy", "equals", "", "other", "", "hashCode", "", Printer.TO_STRING, "", "javalin"})
/* renamed from: io.javalin.core.plugin.PluginInitLifecycleViolationException */
/* loaded from: grasscutter.jar:io/javalin/core/plugin/PluginInitLifecycleViolationException.class */
public final class PluginInitLifecycleViolationException extends PluginLifecycleViolationException {
    @NotNull
    private final Class<? extends Plugin> pluginClass;

    @NotNull
    public final Class<? extends Plugin> component1() {
        return this.pluginClass;
    }

    @NotNull
    public final PluginInitLifecycleViolationException copy(@NotNull Class<? extends Plugin> cls) {
        Intrinsics.checkNotNullParameter(cls, "pluginClass");
        return new PluginInitLifecycleViolationException(cls);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: io.javalin.core.plugin.PluginInitLifecycleViolationException */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PluginInitLifecycleViolationException copy$default(PluginInitLifecycleViolationException pluginInitLifecycleViolationException, Class cls, int i, Object obj) {
        if ((i & 1) != 0) {
            cls = pluginInitLifecycleViolationException.pluginClass;
        }
        return pluginInitLifecycleViolationException.copy(cls);
    }

    @Override // java.lang.Throwable, java.lang.Object
    @NotNull
    public String toString() {
        return "PluginInitLifecycleViolationException(pluginClass=" + this.pluginClass + ')';
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
        return (other instanceof PluginInitLifecycleViolationException) && Intrinsics.areEqual(this.pluginClass, ((PluginInitLifecycleViolationException) other).pluginClass);
    }

    @NotNull
    public final Class<? extends Plugin> getPluginClass() {
        return this.pluginClass;
    }

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public PluginInitLifecycleViolationException(@NotNull Class<? extends Plugin> cls) {
        super(cls, "It is not allowed to register handlers during the 'Init' lifecycle. Please use the 'Apply' lifecycle instead.");
        Intrinsics.checkNotNullParameter(cls, "pluginClass");
        this.pluginClass = cls;
    }
}
