package kotlin.p016io.path;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;

/* compiled from: PathUtils.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n��R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n��¨\u0006\n"}, m373d2 = {"Lkotlin/io/path/PathRelativizer;", "", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", "base", "kotlin-stdlib-jdk7"})
/* renamed from: kotlin.io.path.PathRelativizer */
/* loaded from: grasscutter.jar:kotlin/io/path/PathRelativizer.class */
final class PathRelativizer {
    @NotNull
    public static final PathRelativizer INSTANCE = new PathRelativizer();
    private static final Path emptyPath = Paths.get("", new String[0]);
    private static final Path parentPath = Paths.get(CallerDataConverter.DEFAULT_RANGE_DELIMITER, new String[0]);

    private PathRelativizer() {
    }

    @NotNull
    public final Path tryRelativeTo(@NotNull Path path, @NotNull Path base) {
        Path r;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(base, "base");
        Path bn = base.normalize();
        Path pn = path.normalize();
        Path rn = bn.relativize(pn);
        int i = 0;
        Intrinsics.checkNotNullExpressionValue(bn, "bn");
        int nameCount = bn.getNameCount();
        Intrinsics.checkNotNullExpressionValue(pn, "pn");
        int min = Math.min(nameCount, pn.getNameCount());
        while (i < min && !(!Intrinsics.areEqual(bn.getName(i), parentPath))) {
            if (!Intrinsics.areEqual(pn.getName(i), parentPath)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
            i++;
        }
        if (!(!Intrinsics.areEqual(pn, bn)) || !Intrinsics.areEqual(bn, emptyPath)) {
            String rnString = rn.toString();
            Intrinsics.checkNotNullExpressionValue(rn, "rn");
            FileSystem fileSystem = rn.getFileSystem();
            Intrinsics.checkNotNullExpressionValue(fileSystem, "rn.fileSystem");
            String separator = fileSystem.getSeparator();
            Intrinsics.checkNotNullExpressionValue(separator, "rn.fileSystem.separator");
            if (StringsKt.endsWith$default(rnString, separator, false, 2, (Object) null)) {
                FileSystem fileSystem2 = rn.getFileSystem();
                FileSystem fileSystem3 = rn.getFileSystem();
                Intrinsics.checkNotNullExpressionValue(fileSystem3, "rn.fileSystem");
                r = fileSystem2.getPath(StringsKt.dropLast(rnString, fileSystem3.getSeparator().length()), new String[0]);
            } else {
                r = rn;
            }
        } else {
            r = pn;
        }
        Intrinsics.checkNotNullExpressionValue(r, "r");
        return r;
    }
}
