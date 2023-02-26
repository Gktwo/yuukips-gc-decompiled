package p013io.javalin.http;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: ErrorMapper.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\u0010\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0016\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0005"}, m373d2 = {"contentTypeWrap", "Lio/javalin/http/Handler;", "contentType", "", "errorHandler", "javalin"})
/* renamed from: io.javalin.http.ErrorMapperKt */
/* loaded from: grasscutter.jar:io/javalin/http/ErrorMapperKt.class */
public final class ErrorMapperKt {
    @NotNull
    public static final Handler contentTypeWrap(@NotNull String contentType, @NotNull Handler errorHandler) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
        return (v2) -> {
            m5816contentTypeWrap$lambda0(r0, r1, v2);
        };
    }

    /* renamed from: contentTypeWrap$lambda-0  reason: not valid java name */
    private static final void m5816contentTypeWrap$lambda0(String $contentType, Handler $errorHandler, Context ctx) {
        Intrinsics.checkNotNullParameter($contentType, "$contentType");
        Intrinsics.checkNotNullParameter($errorHandler, "$errorHandler");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String header = ctx.header("Accept");
        if (header == null ? false : StringsKt.contains((CharSequence) header, (CharSequence) $contentType, true)) {
            $errorHandler.handle(ctx);
        }
    }
}
