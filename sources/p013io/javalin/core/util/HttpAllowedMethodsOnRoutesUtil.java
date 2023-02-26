package p013io.javalin.core.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.core.CoreConstants;
import p013io.javalin.Javalin;
import p013io.javalin.core.event.EventListener;
import p013io.javalin.core.event.HandlerMetaInfo;
import p013io.javalin.core.plugin.Plugin;
import p013io.javalin.core.plugin.PluginLifecycleInit;
import p013io.javalin.http.Context;

/* compiled from: HttpAllowedMethodsOnRoutesUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018��2\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0004¢\u0006\u0002\n��¨\u0006\u0011"}, m373d2 = {"Lio/javalin/core/util/HttpAllowedMethodsOnRoutesUtil;", "Lio/javalin/core/plugin/Plugin;", "Lio/javalin/core/plugin/PluginLifecycleInit;", "()V", "endpoints", "", "", "", "Lio/javalin/core/event/HandlerMetaInfo;", "addOptionsToList", "", "handlerMetaInfo", "apply", "app", "Lio/javalin/Javalin;", "createOptionsEndPoint", "init", "javalin"})
/* renamed from: io.javalin.core.util.HttpAllowedMethodsOnRoutesUtil */
/* loaded from: grasscutter.jar:io/javalin/core/util/HttpAllowedMethodsOnRoutesUtil.class */
public final class HttpAllowedMethodsOnRoutesUtil implements Plugin, PluginLifecycleInit {
    @NotNull
    private final Map<String, Set<HandlerMetaInfo>> endpoints = new LinkedHashMap();

    @Override // p013io.javalin.core.plugin.PluginLifecycleInit
    public void init(@NotNull Javalin app) {
        Intrinsics.checkNotNullParameter(app, "app");
        app.events((v1) -> {
            m5767init$lambda1(r1, v1);
        });
    }

    /* renamed from: init$lambda-1  reason: not valid java name */
    private static final void m5767init$lambda1(HttpAllowedMethodsOnRoutesUtil this$0, EventListener it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        it.handlerAdded((v1) -> {
            m5766init$lambda1$lambda0(r1, v1);
        });
    }

    /* renamed from: init$lambda-1$lambda-0  reason: not valid java name */
    private static final void m5766init$lambda1$lambda0(HttpAllowedMethodsOnRoutesUtil this$0, HandlerMetaInfo handlerInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(handlerInfo, "handlerInfo");
        this$0.addOptionsToList(handlerInfo);
    }

    @Override // p013io.javalin.core.plugin.Plugin
    public void apply(@NotNull Javalin app) {
        Intrinsics.checkNotNullParameter(app, "app");
        app.events((v2) -> {
            m5769apply$lambda3(r1, r2, v2);
        });
    }

    /* renamed from: apply$lambda-3  reason: not valid java name */
    private static final void m5769apply$lambda3(HttpAllowedMethodsOnRoutesUtil this$0, Javalin $app, EventListener it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($app, "$app");
        it.serverStarted(() -> {
            m5768apply$lambda3$lambda2(r1, r2);
        });
    }

    /* renamed from: apply$lambda-3$lambda-2  reason: not valid java name */
    private static final void m5768apply$lambda3$lambda2(HttpAllowedMethodsOnRoutesUtil this$0, Javalin $app) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($app, "$app");
        this$0.createOptionsEndPoint($app);
    }

    private final void addOptionsToList(HandlerMetaInfo handlerMetaInfo) {
        Object obj;
        Map $this$getOrPut$iv = this.endpoints;
        String path = handlerMetaInfo.getPath();
        Object value$iv = $this$getOrPut$iv.get(path);
        if (value$iv == null) {
            Set<HandlerMetaInfo> mutableSetOf = SetsKt.mutableSetOf(handlerMetaInfo);
            $this$getOrPut$iv.put(path, mutableSetOf);
            obj = mutableSetOf;
        } else {
            obj = value$iv;
        }
        ((Set) obj).add(handlerMetaInfo);
    }

    private final void createOptionsEndPoint(Javalin app) {
        for (Map.Entry element$iv : this.endpoints.entrySet()) {
            app.options(element$iv.getKey(), (v1) -> {
                m5770createOptionsEndPoint$lambda6$lambda5(r2, v1);
            });
        }
    }

    /* renamed from: createOptionsEndPoint$lambda-6$lambda-5  reason: not valid java name */
    private static final void m5770createOptionsEndPoint$lambda6$lambda5(Map.Entry $endpoint, Context context) {
        Intrinsics.checkNotNullParameter($endpoint, "$endpoint");
        Intrinsics.checkNotNullParameter(context, CoreConstants.CONTEXT_SCOPE_VALUE);
        context.header("Access-Control-Allow-Methods", CollectionsKt.joinToString$default((Iterable) $endpoint.getValue(), ",", null, null, 0, null, HttpAllowedMethodsOnRoutesUtil$createOptionsEndPoint$1$1$1.INSTANCE, 30, null));
    }
}
