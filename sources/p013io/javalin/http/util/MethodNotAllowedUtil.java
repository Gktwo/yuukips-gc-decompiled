package p013io.javalin.http.util;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Context;
import p013io.javalin.http.HandlerType;

/* compiled from: MethodNotAllowedUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��0\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010$\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ(\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u000f"}, m373d2 = {"Lio/javalin/http/util/MethodNotAllowedUtil;", "", "()V", "findAvailableHttpHandlerTypes", "", "Lio/javalin/http/HandlerType;", "matcher", "Lio/javalin/http/PathMatcher;", "requestUri", "", "getAvailableHandlerTypes", "", "ctx", "Lio/javalin/http/Context;", "availableHandlerTypes", "javalin"})
/* renamed from: io.javalin.http.util.MethodNotAllowedUtil */
/* loaded from: grasscutter.jar:io/javalin/http/util/MethodNotAllowedUtil.class */
public final class MethodNotAllowedUtil {
    @NotNull
    public static final MethodNotAllowedUtil INSTANCE = new MethodNotAllowedUtil();

    private MethodNotAllowedUtil() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0083 A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<p013io.javalin.http.HandlerType> findAvailableHttpHandlerTypes(@org.jetbrains.annotations.NotNull p013io.javalin.http.PathMatcher r5, @org.jetbrains.annotations.NotNull java.lang.String r6) {
        /*
            r4 = this;
            r0 = r5
            java.lang.String r1 = "matcher"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r6
            java.lang.String r1 = "requestUri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            io.javalin.http.HandlerType[] r0 = p013io.javalin.http.HandlerType.values()
            r7 = r0
            r0 = 0
            r8 = r0
            r0 = r7
            r9 = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            r10 = r0
            r0 = 0
            r11 = r0
            r0 = r9
            r12 = r0
            r0 = r12
            int r0 = r0.length
            r13 = r0
            r0 = 0
            r14 = r0
        L_0x0032:
            r0 = r14
            r1 = r13
            if (r0 >= r1) goto L_0x0089
            r0 = r12
            r1 = r14
            r0 = r0[r1]
            r15 = r0
            r0 = r15
            r16 = r0
            r0 = 0
            r17 = r0
            r0 = r16
            boolean r0 = r0.isHttpMethod()
            if (r0 == 0) goto L_0x0074
            r0 = r5
            r1 = r16
            r2 = r6
            java.util.List r0 = r0.findEntries(r1, r2)
            java.util.Collection r0 = (java.util.Collection) r0
            r18 = r0
            r0 = 0
            r19 = r0
            r0 = r18
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x006c
            r0 = 1
            goto L_0x006d
        L_0x006c:
            r0 = 0
        L_0x006d:
            if (r0 == 0) goto L_0x0074
            r0 = 1
            goto L_0x0075
        L_0x0074:
            r0 = 0
        L_0x0075:
            if (r0 == 0) goto L_0x0083
            r0 = r10
            r1 = r15
            boolean r0 = r0.add(r1)
        L_0x0083:
            int r14 = r14 + 1
            goto L_0x0032
        L_0x0089:
            r0 = r10
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.javalin.http.util.MethodNotAllowedUtil.findAvailableHttpHandlerTypes(io.javalin.http.PathMatcher, java.lang.String):java.util.List");
    }

    @NotNull
    public final Map<String, String> getAvailableHandlerTypes(@NotNull Context ctx, @NotNull List<? extends HandlerType> list) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(list, "availableHandlerTypes");
        return MapsKt.mapOf(Tuples.m366to(ContextUtil.INSTANCE.acceptsHtml(ctx) ? "Available methods" : "availableMethods", CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, null, 62, null)));
    }
}
