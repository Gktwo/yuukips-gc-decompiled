package p013io.javalin.plugin.metrics;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.HandlerEntry;

/* compiled from: MicrometerPlugin.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\f\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m373d2 = {"<anonymous>", "", "it", "Lio/javalin/http/HandlerEntry;"})
/* renamed from: io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$1 */
/* loaded from: grasscutter.jar:io/javalin/plugin/metrics/MicrometerPlugin$apply$1$1$getTags$uri$1.class */
final class MicrometerPlugin$apply$1$1$getTags$uri$1 extends Lambda implements Function1<HandlerEntry, String> {
    public static final MicrometerPlugin$apply$1$1$getTags$uri$1 INSTANCE = new MicrometerPlugin$apply$1$1$getTags$uri$1();

    MicrometerPlugin$apply$1$1$getTags$uri$1() {
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull HandlerEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getPath();
    }
}
