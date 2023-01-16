package p013io.javalin.core.compression;

import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: CompressedStream.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0002\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m373d2 = {"Lio/javalin/core/compression/LeveledGzipStream;", "Ljava/util/zip/GZIPOutputStream;", "out", "Ljava/io/OutputStream;", "level", "", "(Ljava/io/OutputStream;I)V", "javalin"})
/* renamed from: io.javalin.core.compression.LeveledGzipStream */
/* loaded from: grasscutter.jar:io/javalin/core/compression/LeveledGzipStream.class */
public final class LeveledGzipStream extends GZIPOutputStream {
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public LeveledGzipStream(@NotNull OutputStream out, int level) {
        super(out);
        Intrinsics.checkNotNullParameter(out, "out");
        this.def.setLevel(level);
    }
}
