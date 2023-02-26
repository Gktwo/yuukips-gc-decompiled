package p013io.javalin.core.compression;

import com.nixxcode.jvmbrotli.common.BrotliLoader;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.util.security.Constraint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.core.util.JavalinLogger;
import p013io.javalin.core.util.OptionalDependency;
import p013io.javalin.core.util.Util;

/* compiled from: CompressionStrategy.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��,\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\u0018�� \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n��\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n��\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, m373d2 = {"Lio/javalin/core/compression/CompressionStrategy;", "", "brotli", "Lio/javalin/core/compression/Brotli;", GzipHandler.GZIP, "Lio/javalin/core/compression/Gzip;", "(Lio/javalin/core/compression/Brotli;Lio/javalin/core/compression/Gzip;)V", "getBrotli", "()Lio/javalin/core/compression/Brotli;", "excludedMimeTypesFromCompression", "", "", "getExcludedMimeTypesFromCompression", "()Ljava/util/List;", "setExcludedMimeTypesFromCompression", "(Ljava/util/List;)V", "getGzip", "()Lio/javalin/core/compression/Gzip;", "minSizeForCompression", "", "getMinSizeForCompression", "()I", "setMinSizeForCompression", "(I)V", "tryLoadBrotli", "Companion", "javalin"})
/* renamed from: io.javalin.core.compression.CompressionStrategy */
/* loaded from: grasscutter.jar:io/javalin/core/compression/CompressionStrategy.class */
public final class CompressionStrategy {
    @Nullable
    private final Brotli brotli;
    @Nullable
    private final Gzip gzip;
    private int minSizeForCompression;
    @NotNull
    private List<String> excludedMimeTypesFromCompression;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final CompressionStrategy NONE = new CompressionStrategy(null, null, 3, null);
    @JvmField
    @NotNull
    public static final CompressionStrategy GZIP = new CompressionStrategy(null, new Gzip(0, 1, null));

    public CompressionStrategy() {
        this(null, null, 3, null);
    }

    public CompressionStrategy(@Nullable Brotli brotli, @Nullable Gzip gzip) {
        this.brotli = brotli != null ? tryLoadBrotli(brotli) : null;
        this.gzip = gzip;
        this.minSizeForCompression = 1500;
        this.excludedMimeTypesFromCompression = CollectionsKt.listOf((Object[]) new String[]{"image/", "audio/", "video/", "application/compress", "application/zip", "application/gzip", "application/bzip2", "application/brotli", "application/x-xz", "application/x-rar-compressed"});
    }

    public /* synthetic */ CompressionStrategy(Brotli brotli, Gzip gzip, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : brotli, (i & 2) != 0 ? null : gzip);
    }

    /* compiled from: CompressionStrategy.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u0006"}, m373d2 = {"Lio/javalin/core/compression/CompressionStrategy$Companion;", "", "()V", "GZIP", "Lio/javalin/core/compression/CompressionStrategy;", Constraint.NONE, "javalin"})
    /* renamed from: io.javalin.core.compression.CompressionStrategy$Companion */
    /* loaded from: grasscutter.jar:io/javalin/core/compression/CompressionStrategy$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }

    @Nullable
    public final Brotli getBrotli() {
        return this.brotli;
    }

    @Nullable
    public final Gzip getGzip() {
        return this.gzip;
    }

    public final int getMinSizeForCompression() {
        return this.minSizeForCompression;
    }

    public final void setMinSizeForCompression(int i) {
        this.minSizeForCompression = i;
    }

    @NotNull
    public final List<String> getExcludedMimeTypesFromCompression() {
        return this.excludedMimeTypesFromCompression;
    }

    public final void setExcludedMimeTypesFromCompression(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.excludedMimeTypesFromCompression = list;
    }

    private final Brotli tryLoadBrotli(Brotli brotli) {
        Util.INSTANCE.ensureDependencyPresent(OptionalDependency.JVMBROTLI, true);
        if (BrotliLoader.isBrotliAvailable()) {
            return brotli;
        }
        JavalinLogger.warn$default("\nFailed to enable Brotli compression, because the jvm-brotli native library couldn't be loaded.\njvm-brotli is currently only supported on Windows, Linux and Mac OSX.\nIf you are running Javalin on a supported system, but are still getting this error,\ntry re-importing your Maven and/or Gradle dependencies. If that doesn't resolve it,\nplease create an issue at https://github.com/tipsy/javalin/\n---------------------------------------------------------------\nIf you still want compression, please ensure GZIP is enabled!\n---------------------------------------------------------------", null, 2, null);
        return null;
    }
}
