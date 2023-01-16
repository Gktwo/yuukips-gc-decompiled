package p013io.javalin.core.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.core.event.HandlerMetaInfo;

/* compiled from: HttpAllowedMethodsOnRoutesUtil.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\f\n��\n\u0002\u0010\r\n��\n\u0002\u0018\u0002\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m373d2 = {"<anonymous>", "", "it", "Lio/javalin/core/event/HandlerMetaInfo;"})
/* renamed from: io.javalin.core.util.HttpAllowedMethodsOnRoutesUtil$createOptionsEndPoint$1$1$1 */
/* loaded from: grasscutter.jar:io/javalin/core/util/HttpAllowedMethodsOnRoutesUtil$createOptionsEndPoint$1$1$1.class */
public final class HttpAllowedMethodsOnRoutesUtil$createOptionsEndPoint$1$1$1 extends Lambda implements Function1<HandlerMetaInfo, CharSequence> {
    public static final HttpAllowedMethodsOnRoutesUtil$createOptionsEndPoint$1$1$1 INSTANCE = new HttpAllowedMethodsOnRoutesUtil$createOptionsEndPoint$1$1$1();

    HttpAllowedMethodsOnRoutesUtil$createOptionsEndPoint$1$1$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull HandlerMetaInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getHttpMethod().toString();
    }
}
