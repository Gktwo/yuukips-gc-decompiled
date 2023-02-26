package p013io.javalin.core.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Tuples;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.Javalin;
import p013io.javalin.core.event.EventListener;
import p013io.javalin.core.event.HandlerMetaInfo;
import p013io.javalin.core.plugin.Plugin;
import p013io.javalin.core.plugin.PluginLifecycleInit;
import p013io.javalin.http.Context;
import p013io.javalin.http.HandlerEntry;
import p013io.javalin.http.HandlerType;
import p013io.javalin.http.PathMatcher;
import p013io.javalin.websocket.WsBinaryMessageContext;
import p013io.javalin.websocket.WsCloseContext;
import p013io.javalin.websocket.WsConfig;
import p013io.javalin.websocket.WsConnectContext;
import p013io.javalin.websocket.WsContext;
import p013io.javalin.websocket.WsErrorContext;
import p013io.javalin.websocket.WsMessageContext;

/* compiled from: LogUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��D\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u0007\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018��2\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u001e\u0010\u0014\u001a\u00020\b*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000bH\u0002J\f\u0010\u0018\u001a\u00020\u0010*\u00020\u000bH\u0002¨\u0006\u001a"}, m373d2 = {"Lio/javalin/core/util/LogUtil;", "", "()V", "executionTimeMs", "", "ctx", "Lio/javalin/http/Context;", "requestDevLogger", "", "time", "resBody", "", "setup", "matcher", "Lio/javalin/http/PathMatcher;", "hasRequestLogger", "", "wsDevLogger", "ws", "Lio/javalin/websocket/WsConfig;", "logEvent", "Lio/javalin/websocket/WsContext;", "event", "additionalInfo", "probablyFormData", "HandlerLoggingPlugin", "javalin"})
/* renamed from: io.javalin.core.util.LogUtil */
/* loaded from: grasscutter.jar:io/javalin/core/util/LogUtil.class */
public final class LogUtil {
    @NotNull
    public static final LogUtil INSTANCE = new LogUtil();

    private LogUtil() {
    }

    @JvmStatic
    public static final void requestDevLogger(@NotNull Context ctx, float time) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        try {
            HandlerType type = HandlerType.Companion.fromServletRequest(ctx.req);
            String requestUri = ctx.req.getRequestURI();
            Object attribute = ctx.attribute("javalin-request-log-matcher");
            Intrinsics.checkNotNull(attribute);
            PathMatcher matcher = (PathMatcher) attribute;
            HandlerType handlerType = HandlerType.BEFORE;
            Intrinsics.checkNotNullExpressionValue(requestUri, "requestUri");
            Iterable<HandlerEntry> $this$map$iv = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) matcher.findEntries(handlerType, requestUri), (Iterable) matcher.findEntries(type, requestUri)), (Iterable) matcher.findEntries(HandlerType.AFTER, requestUri));
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (HandlerEntry it : $this$map$iv) {
                destination$iv$iv.add(it.getType().name() + '=' + it.getPath());
            }
            List allMatching = (List) destination$iv$iv;
            Collection<String> headerNames = ctx.res.getHeaderNames();
            Intrinsics.checkNotNullExpressionValue(headerNames, "res.headerNames");
            Map resHeaders = MapsKt.toMap(SequencesKt.map(CollectionsKt.asSequence(headerNames), new Function1<String, Pair<? extends String, ? extends String>>(ctx) { // from class: io.javalin.core.util.LogUtil$requestDevLogger$1$resHeaders$1
                final /* synthetic */ Context $this_with;

                /* access modifiers changed from: package-private */
                {
                    this.$this_with = $receiver;
                }

                @NotNull
                public final Pair<String, String> invoke(String it2) {
                    return Tuples.m366to(it2, this.$this_with.res.getHeader(it2));
                }
            }));
            StringBuilder sb = new StringBuilder();
            StringBuilder append = sb.append("JAVALIN REQUEST DEBUG LOG:\n                        |Request: ").append(ctx.method()).append(" [").append(ctx.path()).append("]\n                        |    Matching endpoint-handlers: ").append(allMatching).append("\n                        |    Headers: ").append(ctx.headerMap()).append("\n                        |    Cookies: ").append(ctx.cookieMap()).append("\n                        |    Body: ").append(ctx.isMultipart() ? "Multipart data ..." : ctx.body()).append("\n                        |    QueryString: ").append((Object) ctx.queryString()).append("\n                        |    QueryParams: ");
            Map $this$mapValues$iv = ctx.queryParamMap();
            Map destination$iv$iv2 = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
            for (Object element$iv$iv$iv : $this$mapValues$iv.entrySet()) {
                destination$iv$iv2.put(((Map.Entry) element$iv$iv$iv).getKey(), ((List) ((Map.Entry) element$iv$iv$iv).getValue()).toString());
            }
            StringBuilder append2 = append.append(destination$iv$iv2).append("\n                        |    FormParams: ");
            Map $this$mapValues$iv2 = INSTANCE.probablyFormData(ctx.body()) ? ctx.formParamMap() : MapsKt.emptyMap();
            Map destination$iv$iv3 = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv2.size()));
            for (Object element$iv$iv$iv2 : $this$mapValues$iv2.entrySet()) {
                destination$iv$iv3.put(((Map.Entry) element$iv$iv$iv2).getKey(), ((List) ((Map.Entry) element$iv$iv$iv2).getValue()).toString());
            }
            append2.append(destination$iv$iv3).append("\n                        |Response: [").append(ctx.status()).append("], execution took ").append(new Formatter(Locale.US).format("%.2f", Float.valueOf(time))).append(" ms\n                        |    Headers: ");
            sb.append(resHeaders).append("\n                        |    ").append(INSTANCE.resBody(ctx)).append("\n                        |----------------------------------------------------------------------------------");
            JavalinLogger.info$default(StringsKt.trimMargin$default(sb.toString(), null, 1, null), null, 2, null);
        } catch (Exception e) {
            JavalinLogger.info("An exception occurred while logging debug-info", e);
        }
    }

    private final boolean probablyFormData(String $this$probablyFormData) {
        boolean z;
        if ($this$probablyFormData == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        Character firstOrNull = StringsKt.firstOrNull(StringsKt.trim((CharSequence) $this$probablyFormData).toString());
        if (firstOrNull == null) {
            z = false;
        } else {
            z = Character.isLetter(firstOrNull.charValue());
        }
        return z && StringsKt.split$default((CharSequence) $this$probablyFormData, new String[]{"="}, false, 0, 6, (Object) null).size() >= 2;
    }

    private final String resBody(Context ctx) {
        if (Intrinsics.areEqual(ctx.req.getAttribute("handled-as-static-file"), (Object) true)) {
            return "Body is a static file (not logged)";
        }
        InputStream stream = ctx.resultStream();
        if (stream == null) {
            return "No body was set";
        }
        if (!stream.markSupported()) {
            return "Body is binary (not logged)";
        }
        boolean gzipped = Intrinsics.areEqual(ctx.res.getHeader("Content-Encoding"), GzipHandler.GZIP);
        boolean brotlied = Intrinsics.areEqual(ctx.res.getHeader("Content-Encoding"), "br");
        String resBody = ctx.resultString();
        Intrinsics.checkNotNull(resBody);
        return gzipped ? "Body is gzipped (" + resBody.length() + " bytes, not logged)" : brotlied ? "Body is brotlied (" + resBody.length() + " bytes, not logged)" : StringsKt.contains$default((CharSequence) resBody, (CharSequence) "resultString unavailable", false, 2, (Object) null) ? "Body is an InputStream which can't be reset, so it can't be logged" : "Body is " + resBody.length() + " bytes (starts on next line):\n    " + resBody;
    }

    public final void setup(@NotNull Context ctx, @NotNull PathMatcher matcher, boolean hasRequestLogger) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        if (hasRequestLogger) {
            ctx.attribute("javalin-request-log-matcher", matcher);
            ctx.attribute("javalin-request-log-start-time", Long.valueOf(System.nanoTime()));
        }
    }

    public final float executionTimeMs(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        long nanoTime = System.nanoTime();
        Object attribute = ctx.attribute("javalin-request-log-start-time");
        Intrinsics.checkNotNull(attribute);
        return ((float) (nanoTime - ((Number) attribute).longValue())) / 1000000.0f;
    }

    @JvmStatic
    public static final void wsDevLogger(@NotNull WsConfig ws) {
        Intrinsics.checkNotNullParameter(ws, "ws");
        ws.onConnect(LogUtil::m5773wsDevLogger$lambda4);
        ws.onMessage(LogUtil::m5774wsDevLogger$lambda5);
        ws.onBinaryMessage(LogUtil::m5775wsDevLogger$lambda6);
        ws.onClose(LogUtil::m5776wsDevLogger$lambda7);
        ws.onError(LogUtil::m5777wsDevLogger$lambda8);
    }

    /* renamed from: wsDevLogger$lambda-4  reason: not valid java name */
    private static final void m5773wsDevLogger$lambda4(WsConnectContext ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        logEvent$default(INSTANCE, ctx, "onConnect", null, 2, null);
    }

    /* renamed from: wsDevLogger$lambda-5  reason: not valid java name */
    private static final void m5774wsDevLogger$lambda5(WsMessageContext ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        INSTANCE.logEvent(ctx, "onMessage", Intrinsics.stringPlus("Message (next line):\n", ctx.message()));
    }

    /* renamed from: wsDevLogger$lambda-6  reason: not valid java name */
    private static final void m5775wsDevLogger$lambda6(WsBinaryMessageContext ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        INSTANCE.logEvent(ctx, "onBinaryMessage", "Offset: " + ctx.offset() + ", Length: " + ctx.length() + "\nMessage (next line):\n" + ctx.data());
    }

    /* renamed from: wsDevLogger$lambda-7  reason: not valid java name */
    private static final void m5776wsDevLogger$lambda7(WsCloseContext ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        LogUtil logUtil = INSTANCE;
        WsCloseContext wsCloseContext = ctx;
        StringBuilder append = new StringBuilder().append("StatusCode: ").append(ctx.status()).append("\nReason: ");
        String reason = ctx.reason();
        logUtil.logEvent(wsCloseContext, "onClose", append.append(reason == null ? "No reason was provided" : reason).toString());
    }

    /* renamed from: wsDevLogger$lambda-8  reason: not valid java name */
    private static final void m5777wsDevLogger$lambda8(WsErrorContext ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        LogUtil logUtil = INSTANCE;
        WsErrorContext wsErrorContext = ctx;
        Throwable error = ctx.error();
        logUtil.logEvent(wsErrorContext, "onError", Intrinsics.stringPlus("Throwable:  ", error == null ? "No throwable was provided" : error));
    }

    static /* synthetic */ void logEvent$default(LogUtil logUtil, WsContext wsContext, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        logUtil.logEvent(wsContext, str, str2);
    }

    private final void logEvent(WsContext $this$logEvent, String event, String additionalInfo) {
        String str;
        StringBuilder append = new StringBuilder().append("JAVALIN WEBSOCKET DEBUG LOG\n                |WebSocket Event: ").append(event).append("\n                |Session Id: ").append($this$logEvent.getSessionId()).append("\n                |Host: ").append((Object) $this$logEvent.host()).append("\n                |Matched Path: ").append($this$logEvent.matchedPath()).append("\n                |PathParams: ").append($this$logEvent.pathParamMap()).append("\n                |QueryParams: ");
        if ($this$logEvent.queryString() != null) {
            Map $this$mapValues$iv = $this$logEvent.queryParamMap();
            Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
            for (Object element$iv$iv$iv : $this$mapValues$iv.entrySet()) {
                destination$iv$iv.put(((Map.Entry) element$iv$iv$iv).getKey(), ((List) ((Map.Entry) element$iv$iv$iv).getValue()).toString());
            }
            append = append;
            str = destination$iv$iv.toString();
        } else {
            str = "No query string was provided";
        }
        JavalinLogger.info$default(StringsKt.trimMargin$default(append.append(str).append("\n                |").append(additionalInfo).append("\n                |----------------------------------------------------------------------------------").toString(), null, 1, null), null, 2, null);
    }

    /* compiled from: LogUtil.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\b��\u0018��2\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, m373d2 = {"Lio/javalin/core/util/LogUtil$HandlerLoggingPlugin;", "Lio/javalin/core/plugin/Plugin;", "Lio/javalin/core/plugin/PluginLifecycleInit;", "()V", "apply", "", "app", "Lio/javalin/Javalin;", "init", "javalin"})
    /* renamed from: io.javalin.core.util.LogUtil$HandlerLoggingPlugin */
    /* loaded from: grasscutter.jar:io/javalin/core/util/LogUtil$HandlerLoggingPlugin.class */
    public static final class HandlerLoggingPlugin implements Plugin, PluginLifecycleInit {
        @Override // p013io.javalin.core.plugin.Plugin
        public void apply(@NotNull Javalin app) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        @Override // p013io.javalin.core.plugin.PluginLifecycleInit
        public void init(@NotNull Javalin app) {
            Intrinsics.checkNotNullParameter(app, "app");
            app.events(HandlerLoggingPlugin::m5780init$lambda1);
        }

        /* renamed from: init$lambda-1  reason: not valid java name */
        private static final void m5780init$lambda1(EventListener on) {
            on.handlerAdded(HandlerLoggingPlugin::m5779init$lambda1$lambda0);
        }

        /* renamed from: init$lambda-1$lambda-0  reason: not valid java name */
        private static final void m5779init$lambda1$lambda0(HandlerMetaInfo handlerMetaInfo) {
            JavalinLogger.info$default("JAVALIN HANDLER REGISTRATION DEBUG LOG: " + handlerMetaInfo.getHttpMethod() + '[' + handlerMetaInfo.getPath() + ']', null, 2, null);
        }
    }
}
