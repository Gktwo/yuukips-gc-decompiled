package kotlin.p016io;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Utils.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48, m374d1 = {"��\u0014\n��\n\u0002\u0010\u0001\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, m373d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/io/File;", "exception", "Ljava/io/IOException;", "invoke"})
/* renamed from: kotlin.io.FilesKt__UtilsKt$copyRecursively$1 */
/* loaded from: grasscutter.jar:kotlin/io/FilesKt__UtilsKt$copyRecursively$1.class */
final class FilesKt__UtilsKt$copyRecursively$1 extends Lambda implements Function2 {
    public static final FilesKt__UtilsKt$copyRecursively$1 INSTANCE = new FilesKt__UtilsKt$copyRecursively$1();

    FilesKt__UtilsKt$copyRecursively$1() {
        super(2);
    }

    @NotNull
    public final Void invoke(@NotNull File file, @NotNull IOException exception) {
        Intrinsics.checkNotNullParameter(file, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        throw exception;
    }
}
