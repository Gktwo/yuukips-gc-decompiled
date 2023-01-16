package p013io.javalin.apibuilder;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Handler;

/* compiled from: CrudHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018��2\b\u0012\u0004\u0012\u00020��0\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bR#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n��\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, m373d2 = {"Lio/javalin/apibuilder/CrudFunction;", "", "value", "", "createHandler", "Lkotlin/Function2;", "Lio/javalin/apibuilder/CrudHandler;", "Lio/javalin/http/Handler;", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getCreateHandler", "()Lkotlin/jvm/functions/Function2;", "getValue", "()Ljava/lang/String;", "GET_ALL", "GET_ONE", "CREATE", "UPDATE", "DELETE", "javalin"})
/* renamed from: io.javalin.apibuilder.CrudFunction */
/* loaded from: grasscutter.jar:io/javalin/apibuilder/CrudFunction.class */
public enum CrudFunction {
    GET_ALL("getAll", C27411.INSTANCE),
    GET_ONE("getOne", C27422.INSTANCE),
    CREATE("create", C27433.INSTANCE),
    UPDATE("update", C27444.INSTANCE),
    DELETE("delete", C27455.INSTANCE);
    
    @NotNull
    private final String value;
    @NotNull
    private final Function2<CrudHandler, String, Handler> createHandler;

    CrudFunction(String value, Function2 createHandler) {
        this.value = value;
        this.createHandler = createHandler;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    @NotNull
    public final Function2<CrudHandler, String, Handler> getCreateHandler() {
        return this.createHandler;
    }
}
