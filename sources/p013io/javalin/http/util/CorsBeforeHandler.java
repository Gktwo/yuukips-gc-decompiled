package p013io.javalin.http.util;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Context;
import p013io.javalin.http.Handler;

/* compiled from: CorsUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n��¨\u0006\n"}, m373d2 = {"Lio/javalin/http/util/CorsBeforeHandler;", "Lio/javalin/http/Handler;", "origins", "", "", "(Ljava/util/List;)V", "handle", "", "ctx", "Lio/javalin/http/Context;", "javalin"})
/* renamed from: io.javalin.http.util.CorsBeforeHandler */
/* loaded from: grasscutter.jar:io/javalin/http/util/CorsBeforeHandler.class */
public final class CorsBeforeHandler implements Handler {
    @NotNull
    private final List<String> origins;

    public CorsBeforeHandler(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "origins");
        this.origins = list;
    }

    @Override // p013io.javalin.http.Handler
    public void handle(@NotNull Context ctx) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String header = ctx.header("Origin");
        String header2 = header == null ? ctx.header("Referer") : header;
        if (header2 != null) {
            Iterable<String> $this$map$iv = this.origins;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (String it : $this$map$iv) {
                destination$iv$iv.add(StringsKt.removeSuffix(it, (CharSequence) "/"));
            }
            Iterator it2 = ((List) destination$iv$iv).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                Object element$iv = it2.next();
                String it3 = (String) element$iv;
                if (Intrinsics.areEqual(it3, "*") || Intrinsics.areEqual(header2, it3)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    obj = element$iv;
                    break;
                }
            }
            if (((String) obj) != null) {
                ctx.header("Access-Control-Allow-Origin", header2);
                ctx.header("Access-Control-Allow-Credentials", C3P0Substitutions.DEBUG);
                ctx.header("Vary", "Origin");
            }
        }
        if (Intrinsics.areEqual(ctx.method(), "OPTIONS")) {
            String it4 = ctx.header("Access-Control-Request-Headers");
            if (it4 != null) {
                ctx.header("Access-Control-Allow-Headers", it4);
            }
            String it5 = ctx.header("Access-Control-Request-Method");
            if (it5 != null) {
                ctx.header("Access-Control-Allow-Methods", it5);
            }
        }
    }
}
