package okio;

import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: InflaterSource.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\u0012\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\u001a\u0017\u0010��\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\b¨\u0006\u0005"}, m373d2 = {"inflate", "Lokio/InflaterSource;", "Lokio/Source;", "inflater", "Ljava/util/zip/Inflater;", "okio"})
@JvmName(name = "-InflaterSourceExtensions")
/* renamed from: okio.-InflaterSourceExtensions  reason: invalid class name */
/* loaded from: grasscutter.jar:okio/-InflaterSourceExtensions.class */
public final class InflaterSourceExtensions {
    public static /* synthetic */ InflaterSource inflate$default(Source $this$inflate_u24default, Inflater inflater, int i, Object obj) {
        if ((i & 1) != 0) {
            inflater = new Inflater();
        }
        Intrinsics.checkNotNullParameter($this$inflate_u24default, "<this>");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return new InflaterSource($this$inflate_u24default, inflater);
    }

    @NotNull
    public static final InflaterSource inflate(@NotNull Source $this$inflate, @NotNull Inflater inflater) {
        Intrinsics.checkNotNullParameter($this$inflate, "<this>");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return new InflaterSource($this$inflate, inflater);
    }
}
