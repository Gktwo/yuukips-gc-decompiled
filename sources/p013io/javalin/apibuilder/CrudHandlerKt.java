package p013io.javalin.apibuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Handler;

/* compiled from: CrudHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\u001a\n��\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\u001a \u0010��\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H��¨\u0006\u0007"}, m373d2 = {"getCrudFunctions", "", "Lio/javalin/apibuilder/CrudFunction;", "Lio/javalin/http/Handler;", "Lio/javalin/apibuilder/CrudHandler;", "resourceId", "", "javalin"})
/* renamed from: io.javalin.apibuilder.CrudHandlerKt */
/* loaded from: grasscutter.jar:io/javalin/apibuilder/CrudHandlerKt.class */
public final class CrudHandlerKt {
    @NotNull
    public static final Map<CrudFunction, Handler> getCrudFunctions(@NotNull CrudHandler $this$getCrudFunctions, @NotNull String resourceId) {
        Intrinsics.checkNotNullParameter($this$getCrudFunctions, "<this>");
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        CrudFunction[] values = CrudFunction.values();
        Collection destination$iv$iv = new ArrayList(values.length);
        for (CrudFunction crudFunction : values) {
            destination$iv$iv.add(Tuples.m366to(crudFunction, new CrudFunctionHandler(crudFunction, $this$getCrudFunctions, resourceId, null, 8, null)));
        }
        return MapsKt.toMap((List) destination$iv$iv);
    }
}
