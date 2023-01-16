package p013io.javalin.http;

import javax.servlet.AsyncEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavalinServletHandler.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\f\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m373d2 = {"<anonymous>", "", "it", "Ljavax/servlet/AsyncEvent;"})
/* renamed from: io.javalin.http.JavalinServletHandlerKt$addListener$2 */
/* loaded from: grasscutter.jar:io/javalin/http/JavalinServletHandlerKt$addListener$2.class */
public final class JavalinServletHandlerKt$addListener$2 extends Lambda implements Function1<AsyncEvent, Unit> {
    public static final JavalinServletHandlerKt$addListener$2 INSTANCE = new JavalinServletHandlerKt$addListener$2();

    JavalinServletHandlerKt$addListener$2() {
        super(1);
    }

    public final void invoke(@NotNull AsyncEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AsyncEvent asyncEvent) {
        invoke(asyncEvent);
        return Unit.INSTANCE;
    }
}
