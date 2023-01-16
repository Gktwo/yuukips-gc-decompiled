package p013io.javalin.plugin.rendering.vue;

import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Configs.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��&\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\b\u0002\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\f"}, m373d2 = {"Lio/javalin/plugin/rendering/vue/VueDirConfig;", "", "()V", "classpathPath", "", "path", "", "resourcesJarClass", "Ljava/lang/Class;", "explicitPath", "Ljava/nio/file/Path;", "externalPath", "javalin"})
/* renamed from: io.javalin.plugin.rendering.vue.VueDirConfig */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/VueDirConfig.class */
public final class VueDirConfig {
    @JvmOverloads
    public final void classpathPath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        classpathPath$default(this, path, null, 2, null);
    }

    public final void externalPath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        JavalinVue.INSTANCE.setRootDirectory$javalin(Paths.get(path, new String[0]));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.javalin.plugin.rendering.vue.VueDirConfig */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void classpathPath$default(VueDirConfig vueDirConfig, String str, Class cls, int i, Object obj) {
        if ((i & 2) != 0) {
            cls = PathMaster.class;
        }
        vueDirConfig.classpathPath(str, cls);
    }

    @JvmOverloads
    public final void classpathPath(@NotNull String path, @NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(cls, "resourcesJarClass");
        JavalinVue.INSTANCE.setResourcesJarClass$javalin(cls);
        JavalinVue.INSTANCE.setRootDirectory$javalin(PathMaster.INSTANCE.classpathPath(path));
    }

    public final void explicitPath(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        JavalinVue.INSTANCE.setRootDirectory$javalin(path);
    }
}
