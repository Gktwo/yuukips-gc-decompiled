package p013io.javalin.core.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.core.util.Headers;

/* compiled from: Headers.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48)
/* renamed from: io.javalin.core.util.Headers$clearSiteData$1 */
/* loaded from: grasscutter.jar:io/javalin/core/util/Headers$clearSiteData$1.class */
/* synthetic */ class Headers$clearSiteData$1 extends FunctionReferenceImpl implements Function1<Headers.ClearSiteData, String> {
    public static final Headers$clearSiteData$1 INSTANCE = new Headers$clearSiteData$1();

    Headers$clearSiteData$1() {
        super(1, Headers.ClearSiteData.class, "headerValue", "headerValue()Ljava/lang/String;", 0);
    }

    @NotNull
    public final String invoke(@NotNull Headers.ClearSiteData p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.headerValue();
    }
}
