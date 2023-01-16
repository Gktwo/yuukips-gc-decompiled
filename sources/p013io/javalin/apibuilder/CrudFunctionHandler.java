package p013io.javalin.apibuilder;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Context;
import p013io.javalin.http.Handler;

/* compiled from: CrudHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0001¢\u0006\u0002\u0010\tJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, m373d2 = {"Lio/javalin/apibuilder/CrudFunctionHandler;", "Lio/javalin/http/Handler;", "function", "Lio/javalin/apibuilder/CrudFunction;", "crudHandler", "Lio/javalin/apibuilder/CrudHandler;", "resourceId", "", "handler", "(Lio/javalin/apibuilder/CrudFunction;Lio/javalin/apibuilder/CrudHandler;Ljava/lang/String;Lio/javalin/http/Handler;)V", "getCrudHandler", "()Lio/javalin/apibuilder/CrudHandler;", "getFunction", "()Lio/javalin/apibuilder/CrudFunction;", "handle", "", "ctx", "Lio/javalin/http/Context;", "javalin"})
/* renamed from: io.javalin.apibuilder.CrudFunctionHandler */
/* loaded from: grasscutter.jar:io/javalin/apibuilder/CrudFunctionHandler.class */
public final class CrudFunctionHandler implements Handler {
    @NotNull
    private final CrudFunction function;
    @NotNull
    private final CrudHandler crudHandler;
    private final /* synthetic */ Handler $$delegate_0;

    @Override // p013io.javalin.http.Handler
    public void handle(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.$$delegate_0.handle(ctx);
    }

    public CrudFunctionHandler(@NotNull CrudFunction function, @NotNull CrudHandler crudHandler, @NotNull String resourceId, @NotNull Handler handler) {
        Intrinsics.checkNotNullParameter(function, "function");
        Intrinsics.checkNotNullParameter(crudHandler, "crudHandler");
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.function = function;
        this.crudHandler = crudHandler;
        this.$$delegate_0 = handler;
    }

    public /* synthetic */ CrudFunctionHandler(CrudFunction crudFunction, CrudHandler crudHandler, String str, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(crudFunction, crudHandler, str, (i & 8) != 0 ? crudFunction.getCreateHandler().invoke(crudHandler, str) : handler);
    }

    @NotNull
    public final CrudFunction getFunction() {
        return this.function;
    }

    @NotNull
    public final CrudHandler getCrudHandler() {
        return this.crudHandler;
    }
}
