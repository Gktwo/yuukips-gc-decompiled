package p013io.javalin.plugin.rendering.vue;

import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: VueHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\f\n��\n\u0002\u0010\r\n��\n\u0002\u0018\u0002\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m373d2 = {"<anonymous>", "", "it", "Ljava/nio/file/Path;"})
/* renamed from: io.javalin.plugin.rendering.vue.VueHandlerKt$joinVueFiles$2 */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/VueHandlerKt$joinVueFiles$2.class */
final class VueHandlerKt$joinVueFiles$2 extends Lambda implements Function1<Path, CharSequence> {
    public static final VueHandlerKt$joinVueFiles$2 INSTANCE = new VueHandlerKt$joinVueFiles$2();

    VueHandlerKt$joinVueFiles$2() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull Path it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "\n<!-- " + it.getFileName() + " -->\n" + VueHandlerKt.readText(it);
    }
}
