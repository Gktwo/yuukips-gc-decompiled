package p013io.javalin.core.util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p016io.FilesKt;
import kotlin.p016io.TextStreamsKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: FileUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u000b"}, m373d2 = {"Lio/javalin/core/util/FileUtil;", "", "()V", "readFile", "", "path", "readResource", "streamToFile", "", "inputStream", "Ljava/io/InputStream;", "javalin"})
/* renamed from: io.javalin.core.util.FileUtil */
/* loaded from: grasscutter.jar:io/javalin/core/util/FileUtil.class */
public final class FileUtil {
    @NotNull
    public static final FileUtil INSTANCE = new FileUtil();

    private FileUtil() {
    }

    @JvmStatic
    public static final void streamToFile(@NotNull InputStream inputStream, @NotNull String path) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(path, "path");
        File newFile = new File(path);
        newFile.getParentFile().mkdirs();
        newFile.createNewFile();
        Files.copy(inputStream, newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    @JvmStatic
    @NotNull
    public static final String readResource(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        URL resource = FileUtil.class.getResource(path);
        Intrinsics.checkNotNullExpressionValue(resource, "FileUtil::class.java.getResource(path)");
        return new String(TextStreamsKt.readBytes(resource), Charsets.UTF_8);
    }

    @JvmStatic
    @NotNull
    public static final String readFile(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return FilesKt.readText$default(new File(path), null, 1, null);
    }
}
