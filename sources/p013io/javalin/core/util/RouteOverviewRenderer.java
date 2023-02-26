package p013io.javalin.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import p013io.javalin.Javalin;
import p013io.javalin.core.event.EventListener;
import p013io.javalin.core.event.HandlerMetaInfo;
import p013io.javalin.core.event.WsHandlerMetaInfo;
import p013io.javalin.http.ContentType;
import p013io.javalin.http.Context;
import p013io.javalin.http.Handler;

/* compiled from: RouteOverviewUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n��\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n��\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0013"}, m373d2 = {"Lio/javalin/core/util/RouteOverviewRenderer;", "Lio/javalin/http/Handler;", "app", "Lio/javalin/Javalin;", "(Lio/javalin/Javalin;)V", "getApp", "()Lio/javalin/Javalin;", "handlerMetaInfoList", "", "Lio/javalin/core/event/HandlerMetaInfo;", "getHandlerMetaInfoList", "()Ljava/util/List;", "wsHandlerMetaInfoList", "Lio/javalin/core/event/WsHandlerMetaInfo;", "getWsHandlerMetaInfoList", "handle", "", "ctx", "Lio/javalin/http/Context;", "javalin"})
/* renamed from: io.javalin.core.util.RouteOverviewRenderer */
/* loaded from: grasscutter.jar:io/javalin/core/util/RouteOverviewRenderer.class */
public final class RouteOverviewRenderer implements Handler {
    @NotNull
    private final Javalin app;
    @NotNull
    private final List<HandlerMetaInfo> handlerMetaInfoList = new ArrayList();
    @NotNull
    private final List<WsHandlerMetaInfo> wsHandlerMetaInfoList = new ArrayList();

    public RouteOverviewRenderer(@NotNull Javalin app) {
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
        this.app.events((v1) -> {
            m5784_init_$lambda1(r1, v1);
        });
        this.app.events((v1) -> {
            m5786_init_$lambda3(r1, v1);
        });
    }

    @NotNull
    public final Javalin getApp() {
        return this.app;
    }

    @NotNull
    public final List<HandlerMetaInfo> getHandlerMetaInfoList() {
        return this.handlerMetaInfoList;
    }

    @NotNull
    public final List<WsHandlerMetaInfo> getWsHandlerMetaInfoList() {
        return this.wsHandlerMetaInfoList;
    }

    /* renamed from: lambda-1$lambda-0  reason: not valid java name */
    private static final void m5783lambda1$lambda0(RouteOverviewRenderer this$0, HandlerMetaInfo handlerInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<HandlerMetaInfo> handlerMetaInfoList = this$0.getHandlerMetaInfoList();
        Intrinsics.checkNotNullExpressionValue(handlerInfo, "handlerInfo");
        handlerMetaInfoList.add(handlerInfo);
    }

    /* renamed from: _init_$lambda-1  reason: not valid java name */
    private static final void m5784_init_$lambda1(RouteOverviewRenderer this$0, EventListener it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        it.handlerAdded((v1) -> {
            m5783lambda1$lambda0(r1, v1);
        });
    }

    /* renamed from: lambda-3$lambda-2  reason: not valid java name */
    private static final void m5785lambda3$lambda2(RouteOverviewRenderer this$0, WsHandlerMetaInfo handlerInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<WsHandlerMetaInfo> wsHandlerMetaInfoList = this$0.getWsHandlerMetaInfoList();
        Intrinsics.checkNotNullExpressionValue(handlerInfo, "handlerInfo");
        wsHandlerMetaInfoList.add(handlerInfo);
    }

    /* renamed from: _init_$lambda-3  reason: not valid java name */
    private static final void m5786_init_$lambda3(RouteOverviewRenderer this$0, EventListener it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        it.wsHandlerAdded((v1) -> {
            m5785lambda3$lambda2(r1, v1);
        });
    }

    @Override // p013io.javalin.http.Handler
    public void handle(@NotNull Context ctx) {
        boolean z;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String header = ctx.header("Accept");
        if (header == null) {
            z = false;
        } else {
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, Logger.ROOT_LOGGER_NAME);
            String lowerCase = header.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (lowerCase == null) {
                z = false;
            } else {
                z = StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) ContentType.JSON, false, 2, (Object) null);
            }
        }
        if (z) {
            ctx.header("Content-Type", ContentType.JSON);
            ctx.result(RouteOverviewUtil.createJsonOverview(this.handlerMetaInfoList, this.wsHandlerMetaInfoList));
            return;
        }
        ctx.html(RouteOverviewUtil.createHtmlOverview(this.handlerMetaInfoList, this.wsHandlerMetaInfoList));
    }
}
