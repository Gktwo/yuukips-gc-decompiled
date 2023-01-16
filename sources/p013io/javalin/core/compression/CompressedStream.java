package p013io.javalin.core.compression;

import java.io.OutputStream;
import javax.servlet.ServletOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p013io.javalin.http.Context;

/* compiled from: CompressedStream.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��.\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018�� \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020��2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m373d2 = {"Lio/javalin/core/compression/CompressedStream;", "", "type", "Lio/javalin/core/compression/CompressionType;", "outputStream", "Ljava/io/OutputStream;", "(Lio/javalin/core/compression/CompressionType;Ljava/io/OutputStream;)V", "getOutputStream", "()Ljava/io/OutputStream;", "getType", "()Lio/javalin/core/compression/CompressionType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", Printer.TO_STRING, "", "Companion", "javalin"})
/* renamed from: io.javalin.core.compression.CompressedStream */
/* loaded from: grasscutter.jar:io/javalin/core/compression/CompressedStream.class */
public final class CompressedStream {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final CompressionType type;
    @NotNull
    private final OutputStream outputStream;

    @NotNull
    public final CompressionType component1() {
        return this.type;
    }

    @NotNull
    public final OutputStream component2() {
        return this.outputStream;
    }

    @NotNull
    public final CompressedStream copy(@NotNull CompressionType type, @NotNull OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        return new CompressedStream(type, outputStream);
    }

    public static /* synthetic */ CompressedStream copy$default(CompressedStream compressedStream, CompressionType compressionType, OutputStream outputStream, int i, Object obj) {
        if ((i & 1) != 0) {
            compressionType = compressedStream.type;
        }
        if ((i & 2) != 0) {
            outputStream = compressedStream.outputStream;
        }
        return compressedStream.copy(compressionType, outputStream);
    }

    @NotNull
    public String toString() {
        return "CompressedStream(type=" + this.type + ", outputStream=" + this.outputStream + ')';
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.outputStream.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompressedStream)) {
            return false;
        }
        CompressedStream compressedStream = (CompressedStream) other;
        return this.type == compressedStream.type && Intrinsics.areEqual(this.outputStream, compressedStream.outputStream);
    }

    /* compiled from: CompressedStream.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, m373d2 = {"Lio/javalin/core/compression/CompressedStream$Companion;", "", "()V", "tryBrotli", "Lio/javalin/core/compression/CompressedStream;", "compression", "Lio/javalin/core/compression/CompressionStrategy;", "ctx", "Lio/javalin/http/Context;", "tryGzip", "javalin"})
    /* renamed from: io.javalin.core.compression.CompressedStream$Companion */
    /* loaded from: grasscutter.jar:io/javalin/core/compression/CompressedStream$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final CompressedStream tryBrotli(@NotNull CompressionStrategy compression, @NotNull Context ctx) {
            Intrinsics.checkNotNullParameter(compression, "compression");
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            if (compression.getBrotli() != null) {
                String header = ctx.header("Accept-Encoding");
                if (header == null ? false : StringsKt.contains((CharSequence) header, (CharSequence) CompressionType.BR.getTypeName(), true)) {
                    CompressionType compressionType = CompressionType.BR;
                    ServletOutputStream outputStream = ctx.res.getOutputStream();
                    Intrinsics.checkNotNullExpressionValue(outputStream, "ctx.res.outputStream");
                    return new CompressedStream(compressionType, (OutputStream) new LeveledBrotliStream(outputStream, compression.getBrotli().getLevel()));
                }
            }
            return null;
        }

        @Nullable
        public final CompressedStream tryGzip(@NotNull CompressionStrategy compression, @NotNull Context ctx) {
            Intrinsics.checkNotNullParameter(compression, "compression");
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            if (compression.getGzip() != null) {
                String header = ctx.header("Accept-Encoding");
                if (header == null ? false : StringsKt.contains((CharSequence) header, (CharSequence) CompressionType.GZIP.getTypeName(), true)) {
                    CompressionType compressionType = CompressionType.GZIP;
                    ServletOutputStream outputStream = ctx.res.getOutputStream();
                    Intrinsics.checkNotNullExpressionValue(outputStream, "ctx.res.outputStream");
                    return new CompressedStream(compressionType, new LeveledGzipStream(outputStream, compression.getGzip().getLevel()));
                }
            }
            return null;
        }
    }

    public CompressedStream(@NotNull CompressionType type, @NotNull OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        this.type = type;
        this.outputStream = outputStream;
    }

    @NotNull
    public final CompressionType getType() {
        return this.type;
    }

    @NotNull
    public final OutputStream getOutputStream() {
        return this.outputStream;
    }
}
