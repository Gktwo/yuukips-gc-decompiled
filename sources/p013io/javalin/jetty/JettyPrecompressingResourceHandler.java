package p013io.javalin.jetty;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p016io.IOStreams;
import kotlin.text.StringsKt;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.util.resource.Resource;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.core.compression.CompressionStrategy;
import p013io.javalin.core.compression.CompressionType;
import p013io.javalin.core.compression.LeveledBrotliStream;
import p013io.javalin.core.compression.LeveledGzipStream;
import p013io.javalin.core.util.JavalinLogger;
import p013io.javalin.core.util.OptionalDependency;
import p013io.javalin.core.util.Util;

/* compiled from: JettyPrecompressingResourceHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��L\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n��\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0002\n��¨\u0006\u001e"}, m373d2 = {"Lio/javalin/jetty/JettyPrecompressingResourceHandler;", "", "()V", "compressedFiles", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getCompressedFiles", "()Ljava/util/concurrent/ConcurrentHashMap;", "excludedMimeTypes", "", "getExcludedMimeTypes", "()Ljava/util/List;", "resourceMaxSize", "", "excludedMimeType", "", "mimeType", "getCompressedByteArray", "resource", "Lorg/eclipse/jetty/util/resource/Resource;", "type", "Lio/javalin/core/compression/CompressionType;", "getStaticResourceByteArray", TypeProxy.INSTANCE_FIELD, "handle", "req", "Ljavax/servlet/http/HttpServletRequest;", "res", "Ljavax/servlet/http/HttpServletResponse;", "javalin"})
/* renamed from: io.javalin.jetty.JettyPrecompressingResourceHandler */
/* loaded from: grasscutter.jar:io/javalin/jetty/JettyPrecompressingResourceHandler.class */
public final class JettyPrecompressingResourceHandler {
    @NotNull
    public static final JettyPrecompressingResourceHandler INSTANCE = new JettyPrecompressingResourceHandler();
    @NotNull
    private static final ConcurrentHashMap<String, byte[]> compressedFiles = new ConcurrentHashMap<>();
    @JvmField
    public static int resourceMaxSize = 2097152;
    @NotNull
    private static final List<String> excludedMimeTypes = new CompressionStrategy(null, null, 3, null).getExcludedMimeTypesFromCompression();

    private JettyPrecompressingResourceHandler() {
    }

    @NotNull
    public final ConcurrentHashMap<String, byte[]> getCompressedFiles() {
        return compressedFiles;
    }

    @NotNull
    public final List<String> getExcludedMimeTypes() {
        return excludedMimeTypes;
    }

    public final boolean handle(@NotNull Resource resource, @NotNull HttpServletRequest req, @NotNull HttpServletResponse res) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        if (!resource.exists() || resource.isDirectory()) {
            return false;
        }
        Object attribute = req.getAttribute("jetty-target");
        if (attribute == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        String target = (String) attribute;
        CompressionType.Companion companion = CompressionType.Companion;
        String header = req.getHeader("Accept-Encoding");
        CompressionType acceptCompressType = companion.getByAcceptEncoding(header == null ? "" : header);
        String contentType = MimeTypes.getDefaultMimeByExtension(target);
        if (contentType == null || excludedMimeType(contentType)) {
            acceptCompressType = CompressionType.NONE;
        }
        byte[] resultByteArray = getStaticResourceByteArray(resource, target, acceptCompressType);
        if (resultByteArray == null) {
            return false;
        }
        res.setContentLength(resultByteArray.length);
        res.setHeader("Content-Type", contentType);
        if (acceptCompressType != CompressionType.NONE) {
            res.setHeader("Content-Encoding", acceptCompressType.getTypeName());
        }
        String weakETag = resource.getWeakETag();
        String etag = req.getHeader("If-None-Match");
        if (etag != null && Intrinsics.areEqual(etag, weakETag)) {
            res.setStatus(304);
            return true;
        }
        res.setHeader("ETag", weakETag);
        ServletOutputStream outputStream = res.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "res.outputStream");
        IOStreams.copyTo$default(new ByteArrayInputStream(resultByteArray), outputStream, 0, 2, null);
        res.getOutputStream().close();
        return true;
    }

    private final byte[] getStaticResourceByteArray(Resource resource, String target, CompressionType type) {
        if (resource.length() <= ((long) resourceMaxSize)) {
            return compressedFiles.computeIfAbsent(Intrinsics.stringPlus(target, type.getExtension()), (v2) -> {
                return m5860getStaticResourceByteArray$lambda1(r2, r3, v2);
            });
        }
        JavalinLogger.warn$default("Static file '" + target + "' is larger than configured max size for pre-compression (" + resourceMaxSize + " bytes).\nYou can configure the max size with `JettyPrecompressingResourceHandler.resourceMaxSize = newMaxSize`.", null, 2, null);
        return null;
    }

    /* renamed from: getStaticResourceByteArray$lambda-1  reason: not valid java name */
    private static final byte[] m5860getStaticResourceByteArray$lambda1(Resource $resource, CompressionType $type, String it) {
        Intrinsics.checkNotNullParameter($resource, "$resource");
        Intrinsics.checkNotNullParameter($type, "$type");
        Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.getCompressedByteArray($resource, $type);
    }

    private final byte[] getCompressedByteArray(Resource resource, CompressionType type) {
        ByteArrayOutputStream outputStream;
        InputStream fileInput = resource.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (type == CompressionType.GZIP) {
            outputStream = new LeveledGzipStream(byteArrayOutputStream, 9);
        } else if (type != CompressionType.BR || !Util.INSTANCE.dependencyIsPresent(OptionalDependency.JVMBROTLI)) {
            outputStream = byteArrayOutputStream;
        } else {
            outputStream = (OutputStream) new LeveledBrotliStream(byteArrayOutputStream, 11);
        }
        Intrinsics.checkNotNullExpressionValue(fileInput, "fileInput");
        IOStreams.copyTo$default(fileInput, outputStream, 0, 2, null);
        fileInput.close();
        outputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "byteArrayOutputStream.toByteArray()");
        return byteArray;
    }

    private final boolean excludedMimeType(String mimeType) {
        if (Intrinsics.areEqual(mimeType, "")) {
            return false;
        }
        Iterable<String> $this$any$iv = excludedMimeTypes;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (String excluded : $this$any$iv) {
            if (StringsKt.contains((CharSequence) mimeType, (CharSequence) excluded, true)) {
                return true;
            }
        }
        return false;
    }
}
