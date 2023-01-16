package p013io.javalin.websocket;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* compiled from: WsConnection.kt */
@WebSocket
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\\\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018��2\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0007J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u001a\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J(\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0016H\u0007J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000eH\u0007J$\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00120&H\u0002J$\u0010(\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00120&H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n��R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n��\u001a\u0004\b\u000f\u0010\u0010¨\u0006)"}, m373d2 = {"Lio/javalin/websocket/WsConnection;", "", "matcher", "Lio/javalin/websocket/WsPathMatcher;", "exceptionMapper", "Lio/javalin/websocket/WsExceptionMapper;", "wsLogger", "Lio/javalin/websocket/WsConfig;", "(Lio/javalin/websocket/WsPathMatcher;Lio/javalin/websocket/WsExceptionMapper;Lio/javalin/websocket/WsConfig;)V", "getExceptionMapper", "()Lio/javalin/websocket/WsExceptionMapper;", "getMatcher", "()Lio/javalin/websocket/WsPathMatcher;", "sessionId", "", "getWsLogger", "()Lio/javalin/websocket/WsConfig;", "onClose", "", "session", "Lorg/eclipse/jetty/websocket/api/Session;", "statusCode", "", "reason", "onConnect", "onError", "throwable", "", "onMessage", "buffer", "", "offset", "length", SendMailJob.PROP_MESSAGE, "tryAfterHandlers", "ctx", "Lio/javalin/websocket/WsContext;", "handle", "Lkotlin/Function1;", "Lio/javalin/websocket/WsEntry;", "tryBeforeAndEndpointHandlers", "javalin"})
/* renamed from: io.javalin.websocket.WsConnection */
/* loaded from: grasscutter.jar:io/javalin/websocket/WsConnection.class */
public final class WsConnection {
    @NotNull
    private final WsPathMatcher matcher;
    @NotNull
    private final WsExceptionMapper exceptionMapper;
    @Nullable
    private final WsConfig wsLogger;
    @NotNull
    private final String sessionId;

    public WsConnection(@NotNull WsPathMatcher matcher, @NotNull WsExceptionMapper exceptionMapper, @Nullable WsConfig wsLogger) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(exceptionMapper, "exceptionMapper");
        this.matcher = matcher;
        this.exceptionMapper = exceptionMapper;
        this.wsLogger = wsLogger;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.sessionId = uuid;
    }

    @NotNull
    public final WsPathMatcher getMatcher() {
        return this.matcher;
    }

    @NotNull
    public final WsExceptionMapper getExceptionMapper() {
        return this.exceptionMapper;
    }

    @Nullable
    public final WsConfig getWsLogger() {
        return this.wsLogger;
    }

    @OnWebSocketConnect
    public final void onConnect(@NotNull Session session) {
        WsConnectHandler wsConnectHandler;
        Intrinsics.checkNotNullParameter(session, "session");
        WsConnectContext ctx = new WsConnectContext(this.sessionId, session);
        tryBeforeAndEndpointHandlers(ctx, new Function1<WsEntry, Unit>(ctx) { // from class: io.javalin.websocket.WsConnection$onConnect$1
            final /* synthetic */ WsConnectContext $ctx;

            /* access modifiers changed from: package-private */
            {
                this.$ctx = $ctx;
            }

            public final void invoke(@NotNull WsEntry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WsConnectHandler wsConnectHandler2 = it.getWsConfig().wsConnectHandler;
                if (wsConnectHandler2 != null) {
                    wsConnectHandler2.handleConnect(this.$ctx);
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WsEntry wsEntry) {
                invoke(wsEntry);
                return Unit.INSTANCE;
            }
        });
        tryAfterHandlers(ctx, new Function1<WsEntry, Unit>(ctx) { // from class: io.javalin.websocket.WsConnection$onConnect$2
            final /* synthetic */ WsConnectContext $ctx;

            /* access modifiers changed from: package-private */
            {
                this.$ctx = $ctx;
            }

            public final void invoke(@NotNull WsEntry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WsConnectHandler wsConnectHandler2 = it.getWsConfig().wsConnectHandler;
                if (wsConnectHandler2 != null) {
                    wsConnectHandler2.handleConnect(this.$ctx);
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WsEntry wsEntry) {
                invoke(wsEntry);
                return Unit.INSTANCE;
            }
        });
        WsConfig wsConfig = this.wsLogger;
        if (wsConfig != null && (wsConnectHandler = wsConfig.wsConnectHandler) != null) {
            wsConnectHandler.handleConnect(ctx);
        }
    }

    @OnWebSocketMessage
    public final void onMessage(@NotNull Session session, @NotNull String message) {
        WsMessageHandler wsMessageHandler;
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        WsMessageContext ctx = new WsMessageContext(this.sessionId, session, message);
        tryBeforeAndEndpointHandlers(ctx, new Function1<WsEntry, Unit>(ctx) { // from class: io.javalin.websocket.WsConnection$onMessage$1
            final /* synthetic */ WsMessageContext $ctx;

            /* access modifiers changed from: package-private */
            {
                this.$ctx = $ctx;
            }

            public final void invoke(@NotNull WsEntry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WsMessageHandler wsMessageHandler2 = it.getWsConfig().wsMessageHandler;
                if (wsMessageHandler2 != null) {
                    wsMessageHandler2.handleMessage(this.$ctx);
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WsEntry wsEntry) {
                invoke(wsEntry);
                return Unit.INSTANCE;
            }
        });
        tryAfterHandlers(ctx, new Function1<WsEntry, Unit>(ctx) { // from class: io.javalin.websocket.WsConnection$onMessage$2
            final /* synthetic */ WsMessageContext $ctx;

            /* access modifiers changed from: package-private */
            {
                this.$ctx = $ctx;
            }

            public final void invoke(@NotNull WsEntry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WsMessageHandler wsMessageHandler2 = it.getWsConfig().wsMessageHandler;
                if (wsMessageHandler2 != null) {
                    wsMessageHandler2.handleMessage(this.$ctx);
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WsEntry wsEntry) {
                invoke(wsEntry);
                return Unit.INSTANCE;
            }
        });
        WsConfig wsConfig = this.wsLogger;
        if (wsConfig != null && (wsMessageHandler = wsConfig.wsMessageHandler) != null) {
            wsMessageHandler.handleMessage(ctx);
        }
    }

    @OnWebSocketMessage
    public final void onMessage(@NotNull Session session, @NotNull byte[] buffer, int offset, int length) {
        WsBinaryMessageHandler wsBinaryMessageHandler;
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        WsBinaryMessageContext ctx = new WsBinaryMessageContext(this.sessionId, session, buffer, offset, length);
        tryBeforeAndEndpointHandlers(ctx, new Function1<WsEntry, Unit>(ctx) { // from class: io.javalin.websocket.WsConnection$onMessage$3
            final /* synthetic */ WsBinaryMessageContext $ctx;

            /* access modifiers changed from: package-private */
            {
                this.$ctx = $ctx;
            }

            public final void invoke(@NotNull WsEntry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WsBinaryMessageHandler wsBinaryMessageHandler2 = it.getWsConfig().wsBinaryMessageHandler;
                if (wsBinaryMessageHandler2 != null) {
                    wsBinaryMessageHandler2.handleBinaryMessage(this.$ctx);
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WsEntry wsEntry) {
                invoke(wsEntry);
                return Unit.INSTANCE;
            }
        });
        tryAfterHandlers(ctx, new Function1<WsEntry, Unit>(ctx) { // from class: io.javalin.websocket.WsConnection$onMessage$4
            final /* synthetic */ WsBinaryMessageContext $ctx;

            /* access modifiers changed from: package-private */
            {
                this.$ctx = $ctx;
            }

            public final void invoke(@NotNull WsEntry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WsBinaryMessageHandler wsBinaryMessageHandler2 = it.getWsConfig().wsBinaryMessageHandler;
                if (wsBinaryMessageHandler2 != null) {
                    wsBinaryMessageHandler2.handleBinaryMessage(this.$ctx);
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WsEntry wsEntry) {
                invoke(wsEntry);
                return Unit.INSTANCE;
            }
        });
        WsConfig wsConfig = this.wsLogger;
        if (wsConfig != null && (wsBinaryMessageHandler = wsConfig.wsBinaryMessageHandler) != null) {
            wsBinaryMessageHandler.handleBinaryMessage(ctx);
        }
    }

    @OnWebSocketClose
    public final void onClose(@NotNull Session session, int statusCode, @Nullable String reason) {
        WsCloseHandler wsCloseHandler;
        Intrinsics.checkNotNullParameter(session, "session");
        WsCloseContext ctx = new WsCloseContext(this.sessionId, session, statusCode, reason);
        tryBeforeAndEndpointHandlers(ctx, new Function1<WsEntry, Unit>(ctx) { // from class: io.javalin.websocket.WsConnection$onClose$1
            final /* synthetic */ WsCloseContext $ctx;

            /* access modifiers changed from: package-private */
            {
                this.$ctx = $ctx;
            }

            public final void invoke(@NotNull WsEntry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WsCloseHandler wsCloseHandler2 = it.getWsConfig().wsCloseHandler;
                if (wsCloseHandler2 != null) {
                    wsCloseHandler2.handleClose(this.$ctx);
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WsEntry wsEntry) {
                invoke(wsEntry);
                return Unit.INSTANCE;
            }
        });
        tryAfterHandlers(ctx, new Function1<WsEntry, Unit>(ctx) { // from class: io.javalin.websocket.WsConnection$onClose$2
            final /* synthetic */ WsCloseContext $ctx;

            /* access modifiers changed from: package-private */
            {
                this.$ctx = $ctx;
            }

            public final void invoke(@NotNull WsEntry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WsCloseHandler wsCloseHandler2 = it.getWsConfig().wsCloseHandler;
                if (wsCloseHandler2 != null) {
                    wsCloseHandler2.handleClose(this.$ctx);
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WsEntry wsEntry) {
                invoke(wsEntry);
                return Unit.INSTANCE;
            }
        });
        WsConfig wsConfig = this.wsLogger;
        if (wsConfig != null && (wsCloseHandler = wsConfig.wsCloseHandler) != null) {
            wsCloseHandler.handleClose(ctx);
        }
    }

    @OnWebSocketError
    public final void onError(@NotNull Session session, @Nullable Throwable throwable) {
        WsErrorHandler wsErrorHandler;
        Intrinsics.checkNotNullParameter(session, "session");
        WsErrorContext ctx = new WsErrorContext(this.sessionId, session, throwable);
        tryBeforeAndEndpointHandlers(ctx, new Function1<WsEntry, Unit>(ctx) { // from class: io.javalin.websocket.WsConnection$onError$1
            final /* synthetic */ WsErrorContext $ctx;

            /* access modifiers changed from: package-private */
            {
                this.$ctx = $ctx;
            }

            public final void invoke(@NotNull WsEntry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WsErrorHandler wsErrorHandler2 = it.getWsConfig().wsErrorHandler;
                if (wsErrorHandler2 != null) {
                    wsErrorHandler2.handleError(this.$ctx);
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WsEntry wsEntry) {
                invoke(wsEntry);
                return Unit.INSTANCE;
            }
        });
        tryAfterHandlers(ctx, new Function1<WsEntry, Unit>(ctx) { // from class: io.javalin.websocket.WsConnection$onError$2
            final /* synthetic */ WsErrorContext $ctx;

            /* access modifiers changed from: package-private */
            {
                this.$ctx = $ctx;
            }

            public final void invoke(@NotNull WsEntry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WsErrorHandler wsErrorHandler2 = it.getWsConfig().wsErrorHandler;
                if (wsErrorHandler2 != null) {
                    wsErrorHandler2.handleError(this.$ctx);
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WsEntry wsEntry) {
                invoke(wsEntry);
                return Unit.INSTANCE;
            }
        });
        WsConfig wsConfig = this.wsLogger;
        if (wsConfig != null && (wsErrorHandler = wsConfig.wsErrorHandler) != null) {
            wsErrorHandler.handleError(ctx);
        }
    }

    private final void tryBeforeAndEndpointHandlers(WsContext ctx, Function1<? super WsEntry, Unit> function1) {
        String requestUri = WsConnectionKt.access$uriNoContextPath(ctx.session);
        try {
            for (WsEntry it : this.matcher.findBeforeHandlerEntries(requestUri)) {
                function1.invoke(it);
            }
            WsEntry it2 = this.matcher.findEndpointHandlerEntry(requestUri);
            Intrinsics.checkNotNull(it2);
            function1.invoke(it2);
        } catch (Exception e) {
            this.exceptionMapper.handle(e, ctx);
        }
    }

    private final void tryAfterHandlers(WsContext ctx, Function1<? super WsEntry, Unit> function1) {
        try {
            for (WsEntry it : this.matcher.findAfterHandlerEntries(WsConnectionKt.access$uriNoContextPath(ctx.session))) {
                function1.invoke(it);
            }
        } catch (Exception e) {
            this.exceptionMapper.handle(e, ctx);
        }
    }
}
