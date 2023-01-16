package p013io.javalin.plugin.metrics;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: MicrometerPlugin.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\b\n��\n\u0002\u0010\u000e\n��\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, m373d2 = {"<anonymous>", "", "it"})
/* renamed from: io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$2 */
/* loaded from: grasscutter.jar:io/javalin/plugin/metrics/MicrometerPlugin$apply$1$1$getTags$uri$2.class */
final class MicrometerPlugin$apply$1$1$getTags$uri$2 extends Lambda implements Function1<String, String> {
    public static final MicrometerPlugin$apply$1$1$getTags$uri$2 INSTANCE = new MicrometerPlugin$apply$1$1$getTags$uri$2();

    MicrometerPlugin$apply$1$1$getTags$uri$2() {
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (Intrinsics.areEqual(it, "/") || StringsKt.isBlank(it)) ? "root" : it;
    }
}
