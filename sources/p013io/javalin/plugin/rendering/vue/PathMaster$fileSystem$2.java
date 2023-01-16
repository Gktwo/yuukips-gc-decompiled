package p013io.javalin.plugin.rendering.vue;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: JavalinVue.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\b\n��\n\u0002\u0018\u0002\n��\u0010��\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, m373d2 = {"<anonymous>", "Ljava/nio/file/FileSystem;", "kotlin.jvm.PlatformType"})
/* renamed from: io.javalin.plugin.rendering.vue.PathMaster$fileSystem$2 */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/PathMaster$fileSystem$2.class */
final class PathMaster$fileSystem$2 extends Lambda implements Function0<FileSystem> {
    public static final PathMaster$fileSystem$2 INSTANCE = new PathMaster$fileSystem$2();

    PathMaster$fileSystem$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final FileSystem invoke() {
        return FileSystems.newFileSystem(JavalinVue.INSTANCE.getResourcesJarClass$javalin().getResource("").toURI(), MapsKt.emptyMap());
    }
}
