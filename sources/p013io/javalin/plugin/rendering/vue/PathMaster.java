package p013io.javalin.plugin.rendering.vue;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavalinVue.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��*\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001d\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m373d2 = {"Lio/javalin/plugin/rendering/vue/PathMaster;", "", "()V", "fileSystem", "Ljava/nio/file/FileSystem;", "kotlin.jvm.PlatformType", "getFileSystem", "()Ljava/nio/file/FileSystem;", "fileSystem$delegate", "Lkotlin/Lazy;", "classpathPath", "Ljava/nio/file/Path;", "path", "", "defaultLocation", "isDev", "", "(Ljava/lang/Boolean;)Ljava/nio/file/Path;", "javalin"})
/* renamed from: io.javalin.plugin.rendering.vue.PathMaster */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/PathMaster.class */
public final class PathMaster {
    @NotNull
    public static final PathMaster INSTANCE = new PathMaster();
    @NotNull
    private static final Lazy fileSystem$delegate = LazyKt.lazy(PathMaster$fileSystem$2.INSTANCE);

    private PathMaster() {
    }

    private final FileSystem getFileSystem() {
        return (FileSystem) fileSystem$delegate.getValue();
    }

    @NotNull
    public final Path classpathPath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (Intrinsics.areEqual(JavalinVue.INSTANCE.getResourcesJarClass$javalin().getResource(path).toURI().getScheme(), "jar")) {
            Path path2 = getFileSystem().getPath(path, new String[0]);
            Intrinsics.checkNotNullExpressionValue(path2, "fileSystem.getPath(path)");
            return path2;
        }
        Path path3 = Paths.get(JavalinVue.INSTANCE.getResourcesJarClass$javalin().getResource(path).toURI());
        Intrinsics.checkNotNullExpressionValue(path3, "get(jarClass.getResource(path).toURI())");
        return path3;
    }

    public final Path defaultLocation(@Nullable Boolean isDev) {
        return Intrinsics.areEqual((Object) isDev, (Object) true) ? Paths.get("src/main/resources/vue", new String[0]) : classpathPath("/vue");
    }
}
