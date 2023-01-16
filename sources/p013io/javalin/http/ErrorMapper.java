package p013io.javalin.http;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ErrorMapper.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��0\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fR-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n��\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, m373d2 = {"Lio/javalin/http/ErrorMapper;", "", "()V", "errorHandlerMap", "Ljava/util/HashMap;", "", "Lio/javalin/http/Handler;", "Lkotlin/collections/HashMap;", "getErrorHandlerMap", "()Ljava/util/HashMap;", "handle", "", "statusCode", "ctx", "Lio/javalin/http/Context;", "(ILio/javalin/http/Context;)Lkotlin/Unit;", "javalin"})
/* renamed from: io.javalin.http.ErrorMapper */
/* loaded from: grasscutter.jar:io/javalin/http/ErrorMapper.class */
public final class ErrorMapper {
    @NotNull
    private final HashMap<Integer, Handler> errorHandlerMap = new HashMap<>();

    @NotNull
    public final HashMap<Integer, Handler> getErrorHandlerMap() {
        return this.errorHandlerMap;
    }

    @Nullable
    public final Unit handle(int statusCode, @NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Handler handler = this.errorHandlerMap.get(Integer.valueOf(statusCode));
        if (handler == null) {
            return null;
        }
        handler.handle(ctx);
        return Unit.INSTANCE;
    }
}
