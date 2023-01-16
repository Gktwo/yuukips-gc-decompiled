package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.jetbrains.annotations.NotNull;

/* compiled from: GzipSink.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\f\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\u001a\r\u0010��\u001a\u00020\u0001*\u00020\u0002H\b¨\u0006\u0003"}, m373d2 = {GzipHandler.GZIP, "Lokio/GzipSink;", "Lokio/Sink;", "okio"})
@JvmName(name = "-GzipSinkExtensions")
/* renamed from: okio.-GzipSinkExtensions  reason: invalid class name */
/* loaded from: grasscutter.jar:okio/-GzipSinkExtensions.class */
public final class GzipSinkExtensions {
    @NotNull
    public static final GzipSink gzip(@NotNull Sink $this$gzip) {
        Intrinsics.checkNotNullParameter($this$gzip, "<this>");
        return new GzipSink($this$gzip);
    }
}
