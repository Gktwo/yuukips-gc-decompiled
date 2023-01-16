package p013io.javalin.http;

import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.core.JavalinConfig;
import p013io.javalin.core.compression.CompressedStream;
import p013io.javalin.core.compression.CompressionStrategy;

/* compiled from: JavalinResponseWrapper.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n��\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n��\u0018��2\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J \u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001eH\u0016J\u000e\u0010!\u001a\u00020\u0016*\u0004\u0018\u00010\"H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n��R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n��\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, m373d2 = {"Lio/javalin/http/OutputStreamWrapper;", "Ljavax/servlet/ServletOutputStream;", "config", "Lio/javalin/core/JavalinConfig;", "ctx", "Lio/javalin/http/Context;", "response", "Ljavax/servlet/http/HttpServletResponse;", "(Lio/javalin/core/JavalinConfig;Lio/javalin/http/Context;Ljavax/servlet/http/HttpServletResponse;)V", "compressedStream", "Lio/javalin/core/compression/CompressedStream;", "compression", "Lio/javalin/core/compression/CompressionStrategy;", "getConfig", "()Lio/javalin/core/JavalinConfig;", "getCtx", "()Lio/javalin/http/Context;", "getResponse", "()Ljavax/servlet/http/HttpServletResponse;", "close", "", "isReady", "", "setWriteListener", "writeListener", "Ljavax/servlet/WriteListener;", "write", "bytes", "", "offset", "", "length", "byte", "allowsForCompression", "", "javalin"})
/* renamed from: io.javalin.http.OutputStreamWrapper */
/* loaded from: grasscutter.jar:io/javalin/http/OutputStreamWrapper.class */
public final class OutputStreamWrapper extends ServletOutputStream {
    @NotNull
    private final JavalinConfig config;
    @NotNull
    private final Context ctx;
    @NotNull
    private final HttpServletResponse response;
    @NotNull
    private final CompressionStrategy compression;
    @Nullable
    private CompressedStream compressedStream;

    public OutputStreamWrapper(@NotNull JavalinConfig config, @NotNull Context ctx, @NotNull HttpServletResponse response) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(response, "response");
        this.config = config;
        this.ctx = ctx;
        this.response = response;
        CompressionStrategy compressionStrategy = this.config.inner.compressionStrategy;
        Intrinsics.checkNotNullExpressionValue(compressionStrategy, "config.inner.compressionStrategy");
        this.compression = compressionStrategy;
    }

    public /* synthetic */ OutputStreamWrapper(JavalinConfig javalinConfig, Context context, HttpServletResponse httpServletResponse, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(javalinConfig, context, (i & 4) != 0 ? context.res : httpServletResponse);
    }

    @NotNull
    public final JavalinConfig getConfig() {
        return this.config;
    }

    @NotNull
    public final Context getCtx() {
        return this.ctx;
    }

    @NotNull
    public final HttpServletResponse getResponse() {
        return this.response;
    }

    @Override // java.io.OutputStream
    public void write(@NotNull byte[] bytes, int offset, int length) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (this.compressedStream == null && length >= this.compression.getMinSizeForCompression() && allowsForCompression(this.response.getContentType())) {
            CompressedStream tryBrotli = CompressedStream.Companion.tryBrotli(this.compression, this.ctx);
            this.compressedStream = tryBrotli == null ? CompressedStream.Companion.tryGzip(this.compression, this.ctx) : tryBrotli;
            CompressedStream it = this.compressedStream;
            if (it != null) {
                getResponse().setHeader("Content-Encoding", it.getType().getTypeName());
            }
        }
        CompressedStream compressedStream = this.compressedStream;
        OutputStream outputStream = compressedStream == null ? null : compressedStream.getOutputStream();
        (outputStream == null ? this.response.getOutputStream() : outputStream).write(bytes, offset, length);
    }

    private final boolean allowsForCompression(String $this$allowsForCompression) {
        boolean z;
        if ($this$allowsForCompression != null) {
            Iterable $this$none$iv = this.compression.getExcludedMimeTypesFromCompression();
            if (!($this$none$iv instanceof Collection) || !((Collection) $this$none$iv).isEmpty()) {
                Iterator<T> it = $this$none$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    if (StringsKt.contains((CharSequence) $this$allowsForCompression, (CharSequence) ((String) it.next()), true)) {
                        z = false;
                        break;
                    }
                }
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.response.getOutputStream().write(i);
    }

    @Override // javax.servlet.ServletOutputStream
    public void setWriteListener(@Nullable WriteListener writeListener) {
        this.response.getOutputStream().setWriteListener(writeListener);
    }

    @Override // javax.servlet.ServletOutputStream
    public boolean isReady() {
        return this.response.getOutputStream().isReady();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        OutputStream outputStream;
        CompressedStream compressedStream = this.compressedStream;
        if (compressedStream != null && (outputStream = compressedStream.getOutputStream()) != null) {
            outputStream.close();
        }
    }
}
