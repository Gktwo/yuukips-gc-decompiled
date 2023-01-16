package p013io.javalin.core.compression;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.util.security.Constraint;
import org.jetbrains.annotations.NotNull;

/* compiled from: CompressionType.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n��\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018�� \u000e2\b\u0012\u0004\u0012\u00020��0\u0001:\u0001\u000eB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\b\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, m373d2 = {"Lio/javalin/core/compression/CompressionType;", "", "typeName", "", "extension", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getExtension", "()Ljava/lang/String;", "getTypeName", "acceptEncoding", "", "GZIP", "BR", Constraint.NONE, "Companion", "javalin"})
/* renamed from: io.javalin.core.compression.CompressionType */
/* loaded from: grasscutter.jar:io/javalin/core/compression/CompressionType.class */
public enum CompressionType {
    GZIP(GzipHandler.GZIP, ".gz"),
    BR("br", ".br"),
    NONE("", "");
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String typeName;
    @NotNull
    private final String extension;

    CompressionType(String typeName, String extension) {
        this.typeName = typeName;
        this.extension = extension;
    }

    @NotNull
    public final String getTypeName() {
        return this.typeName;
    }

    @NotNull
    public final String getExtension() {
        return this.extension;
    }

    public final boolean acceptEncoding(@NotNull String acceptEncoding) {
        Intrinsics.checkNotNullParameter(acceptEncoding, "acceptEncoding");
        return StringsKt.contains((CharSequence) acceptEncoding, (CharSequence) this.typeName, true);
    }

    /* compiled from: CompressionType.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m373d2 = {"Lio/javalin/core/compression/CompressionType$Companion;", "", "()V", "getByAcceptEncoding", "Lio/javalin/core/compression/CompressionType;", "acceptEncoding", "", "javalin"})
    /* renamed from: io.javalin.core.compression.CompressionType$Companion */
    /* loaded from: grasscutter.jar:io/javalin/core/compression/CompressionType$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CompressionType getByAcceptEncoding(@NotNull String acceptEncoding) {
            CompressionType compressionType;
            Intrinsics.checkNotNullParameter(acceptEncoding, "acceptEncoding");
            CompressionType[] values = CompressionType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    compressionType = null;
                    break;
                }
                CompressionType it = values[i];
                if (it.acceptEncoding(acceptEncoding)) {
                    compressionType = it;
                    break;
                }
                i++;
            }
            return compressionType == null ? CompressionType.NONE : compressionType;
        }
    }
}
