package p013io.javalin.http.util;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.eclipse.jetty.server.Request;
import org.jetbrains.annotations.NotNull;

/* compiled from: MultipartUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\f\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m373d2 = {"<anonymous>", "", "req", "Ljavax/servlet/http/HttpServletRequest;"})
/* renamed from: io.javalin.http.util.MultipartUtil$preUploadFunction$1 */
/* loaded from: grasscutter.jar:io/javalin/http/util/MultipartUtil$preUploadFunction$1.class */
final class MultipartUtil$preUploadFunction$1 extends Lambda implements Function1<HttpServletRequest, Unit> {
    public static final MultipartUtil$preUploadFunction$1 INSTANCE = new MultipartUtil$preUploadFunction$1();

    MultipartUtil$preUploadFunction$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HttpServletRequest httpServletRequest) {
        invoke(httpServletRequest);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull HttpServletRequest req) {
        Intrinsics.checkNotNullParameter(req, "req");
        if (req.getAttribute(Request.MULTIPART_CONFIG_ELEMENT) == null) {
            req.setAttribute(Request.MULTIPART_CONFIG_ELEMENT, new MultipartConfigElement(System.getProperty("java.io.tmpdir"), -1, -1, 1));
        }
    }
}
