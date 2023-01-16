package p013io.javalin.http;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContextResolver.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\u0012\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010��\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, m373d2 = {"<anonymous>", "", "ctx", "Lio/javalin/http/Context;", "result", ""})
/* renamed from: io.javalin.http.ContextResolver$defaultFutureCallback$1 */
/* loaded from: grasscutter.jar:io/javalin/http/ContextResolver$defaultFutureCallback$1.class */
public final class ContextResolver$defaultFutureCallback$1 extends Lambda implements Function2<Context, Object, Unit> {
    public static final ContextResolver$defaultFutureCallback$1 INSTANCE = new ContextResolver$defaultFutureCallback$1();

    ContextResolver$defaultFutureCallback$1() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Context context, Object p2) {
        invoke(context, p2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Context ctx, @Nullable Object result) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (!(result instanceof Unit)) {
            if (result instanceof InputStream) {
                ctx.result((InputStream) result);
            } else if (result instanceof String) {
                ctx.result((String) result);
            } else if (result != null) {
                ctx.json(result);
            }
        }
    }
}
