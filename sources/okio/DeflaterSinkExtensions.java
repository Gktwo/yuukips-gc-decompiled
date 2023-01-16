package okio;

import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.jetbrains.annotations.NotNull;

/* compiled from: DeflaterSink.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\u0012\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\u001a\u0017\u0010��\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\b¨\u0006\u0005"}, m373d2 = {GzipHandler.DEFLATE, "Lokio/DeflaterSink;", "Lokio/Sink;", "deflater", "Ljava/util/zip/Deflater;", "okio"})
@JvmName(name = "-DeflaterSinkExtensions")
/* renamed from: okio.-DeflaterSinkExtensions  reason: invalid class name */
/* loaded from: grasscutter.jar:okio/-DeflaterSinkExtensions.class */
public final class DeflaterSinkExtensions {
    public static /* synthetic */ DeflaterSink deflate$default(Sink $this$deflate_u24default, Deflater deflater, int i, Object obj) {
        if ((i & 1) != 0) {
            deflater = new Deflater();
        }
        Intrinsics.checkNotNullParameter($this$deflate_u24default, "<this>");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        return new DeflaterSink($this$deflate_u24default, deflater);
    }

    @NotNull
    public static final DeflaterSink deflate(@NotNull Sink $this$deflate, @NotNull Deflater deflater) {
        Intrinsics.checkNotNullParameter($this$deflate, "<this>");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        return new DeflaterSink($this$deflate, deflater);
    }
}
