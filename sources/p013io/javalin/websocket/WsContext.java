package p013io.javalin.websocket;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.websocket.api.CloseStatus;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.UpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.builtins.Tmux;
import org.quartz.jobs.p027ee.mail.SendMailJob;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.javalin.core.validation.Validator;
import p013io.javalin.http.Context;
import p013io.javalin.jetty.JavalinJettyServletKt;
import p013io.javalin.plugin.json.JsonMapperKt;

/* compiled from: WsContext.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��x\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0019\u001a\u0004\u0018\u0001H\u001a\"\u0004\b��\u0010\u001a2\u0006\u0010\u001b\u001a\u00020\u0003¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u0019\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001J\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bJ\u0006\u0010 \u001a\u00020\u001dJ\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0003J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010'\u001a\u00020\u0003J\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bJ\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010,\u001a\u00020\"H\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u00032\u0006\u0010-\u001a\u00020\u0003J\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bJ\u000e\u0010/\u001a\n 0*\u0004\u0018\u00010\u00030\u0003J\u0006\u00101\u001a\u00020\u0003J\u000e\u00102\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003J#\u00103\u001a\b\u0012\u0004\u0012\u0002H\u001a04\"\n\b��\u0010\u001a\u0018\u0001*\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0003H\bJ(\u00103\u001a\b\u0012\u0004\u0012\u0002H\u001a04\"\u0004\b��\u0010\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u0002H\u001a06J\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bJ\u0010\u00108\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u0003J#\u00109\u001a\b\u0012\u0004\u0012\u0002H\u001a04\"\n\b��\u0010\u001a\u0018\u0001*\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0003H\bJ(\u00109\u001a\b\u0012\u0004\u0012\u0002H\u001a04\"\u0004\b��\u0010\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u0002H\u001a06J\u0018\u0010:\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030;0\bJ\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030;2\u0006\u0010\u001b\u001a\u00020\u0003J\b\u0010=\u001a\u0004\u0018\u00010\u0003J2\u0010>\u001a&\u0012\f\u0012\n 0*\u0004\u0018\u00010@0@ 0*\u0012\u0012\f\u0012\n 0*\u0004\u0018\u00010@0@\u0018\u00010?0?2\u0006\u0010A\u001a\u00020BJ2\u0010>\u001a&\u0012\f\u0012\n 0*\u0004\u0018\u00010@0@ 0*\u0012\u0012\f\u0012\n 0*\u0004\u0018\u00010@0@\u0018\u00010?0?2\u0006\u0010A\u001a\u00020\u0001J2\u0010>\u001a&\u0012\f\u0012\n 0*\u0004\u0018\u00010@0@ 0*\u0012\u0012\f\u0012\n 0*\u0004\u0018\u00010@0@\u0018\u00010?0?2\u0006\u0010A\u001a\u00020\u0003J\u0014\u0010C\u001a\u00020\u001d2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010BH\u0007J\u001b\u0010D\u001a\u0004\u0018\u0001H\u001a\"\u0004\b��\u0010\u001a2\u0006\u0010\u001b\u001a\u00020\u0003¢\u0006\u0002\u0010\u001cJ\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n��R)\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b8@X\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108@X\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158@X\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017¨\u0006F"}, m373d2 = {"Lio/javalin/websocket/WsContext;", "", "sessionId", "", "session", "Lorg/eclipse/jetty/websocket/api/Session;", "(Ljava/lang/String;Lorg/eclipse/jetty/websocket/api/Session;)V", "sessionAttributes", "", "getSessionAttributes$javalin", "()Ljava/util/Map;", "sessionAttributes$delegate", "Lkotlin/Lazy;", "getSessionId", "()Ljava/lang/String;", "upgradeCtx", "Lio/javalin/http/Context;", "getUpgradeCtx$javalin", "()Lio/javalin/http/Context;", "upgradeCtx$delegate", "upgradeReq", "Lorg/eclipse/jetty/websocket/servlet/ServletUpgradeRequest;", "getUpgradeReq$javalin", "()Lorg/eclipse/jetty/websocket/servlet/ServletUpgradeRequest;", "upgradeReq$delegate", "attribute", "T", Action.KEY_ATTRIBUTE, "(Ljava/lang/String;)Ljava/lang/Object;", "", "value", "attributeMap", "closeSession", "code", "", "reason", "closeStatus", "Lorg/eclipse/jetty/websocket/api/CloseStatus;", "cookie", "name", "cookieMap", "equals", "", "other", "hashCode", "header", "headerMap", "host", "kotlin.jvm.PlatformType", "matchedPath", "pathParam", "pathParamAsClass", "Lio/javalin/core/validation/Validator;", "clazz", "Ljava/lang/Class;", "pathParamMap", "queryParam", "queryParamAsClass", "queryParamMap", "", "queryParams", "queryString", Tmux.CMD_SEND, "Ljava/util/concurrent/Future;", "Ljava/lang/Void;", SendMailJob.PROP_MESSAGE, "Ljava/nio/ByteBuffer;", "sendPing", "sessionAttribute", "sessionAttributeMap", "javalin"})
/* renamed from: io.javalin.websocket.WsContext */
/* loaded from: grasscutter.jar:io/javalin/websocket/WsContext.class */
public abstract class WsContext {
    @NotNull
    private final String sessionId;
    @JvmField
    @NotNull
    public final Session session;
    @NotNull
    private final Lazy upgradeReq$delegate = LazyKt.lazy(new Function0<ServletUpgradeRequest>(this) { // from class: io.javalin.websocket.WsContext$upgradeReq$2
        final /* synthetic */ WsContext this$0;

        /* access modifiers changed from: package-private */
        {
            this.this$0 = $receiver;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ServletUpgradeRequest invoke() {
            UpgradeRequest upgradeRequest = this.this$0.session.getUpgradeRequest();
            if (upgradeRequest != null) {
                return (ServletUpgradeRequest) upgradeRequest;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest");
        }
    });
    @NotNull
    private final Lazy upgradeCtx$delegate = LazyKt.lazy(new Function0<Context>(this) { // from class: io.javalin.websocket.WsContext$upgradeCtx$2
        final /* synthetic */ WsContext this$0;

        /* access modifiers changed from: package-private */
        {
            this.this$0 = $receiver;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Context invoke() {
            Object attribute = this.this$0.getUpgradeReq$javalin().getHttpServletRequest().getAttribute(JavalinJettyServletKt.upgradeContextKey);
            if (attribute != null) {
                return (Context) attribute;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.javalin.http.Context");
        }
    });
    @NotNull
    private final Lazy sessionAttributes$delegate = LazyKt.lazy(new Function0<Map<String, ? extends Object>>(this) { // from class: io.javalin.websocket.WsContext$sessionAttributes$2
        final /* synthetic */ WsContext this$0;

        /* access modifiers changed from: package-private */
        {
            this.this$0 = $receiver;
        }

        /* Return type fixed from 'java.util.Map<java.lang.String, java.lang.Object>' to match base method */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Map<String, ? extends Object> invoke() {
            return (Map) this.this$0.getUpgradeReq$javalin().getHttpServletRequest().getAttribute(JavalinJettyServletKt.upgradeSessionAttrsKey);
        }
    });

    @JvmOverloads
    public final void sendPing() {
        sendPing$default(this, null, 1, null);
    }

    public WsContext(@NotNull String sessionId, @NotNull Session session) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(session, "session");
        this.sessionId = sessionId;
        this.session = session;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    public final ServletUpgradeRequest getUpgradeReq$javalin() {
        return (ServletUpgradeRequest) this.upgradeReq$delegate.getValue();
    }

    @NotNull
    public final Context getUpgradeCtx$javalin() {
        return (Context) this.upgradeCtx$delegate.getValue();
    }

    @Nullable
    public final Map<String, Object> getSessionAttributes$javalin() {
        return (Map) this.sessionAttributes$delegate.getValue();
    }

    @NotNull
    public final String matchedPath() {
        return getUpgradeCtx$javalin().getMatchedPath$javalin();
    }

    public final Future<Void> send(@NotNull Object message) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        String jsonString = JsonMapperKt.jsonMapper(getUpgradeCtx$javalin()).toJsonString(message);
        Intrinsics.checkNotNullExpressionValue(jsonString, "upgradeCtx.jsonMapper().toJsonString(message)");
        return send(jsonString);
    }

    public final Future<Void> send(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        return this.session.getRemote().sendStringByFuture(message);
    }

    public final Future<Void> send(@NotNull ByteBuffer message) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        return this.session.getRemote().sendBytesByFuture(message);
    }

    @JvmOverloads
    public final void sendPing(@Nullable ByteBuffer message) {
        this.session.getRemote().sendPing(message == null ? ByteBuffer.allocate(0) : message);
    }

    public static /* synthetic */ void sendPing$default(WsContext wsContext, ByteBuffer byteBuffer, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendPing");
        }
        if ((i & 1) != 0) {
            byteBuffer = null;
        }
        wsContext.sendPing(byteBuffer);
    }

    @Nullable
    public final String queryString() {
        return getUpgradeCtx$javalin().queryString();
    }

    @NotNull
    public final Map<String, List<String>> queryParamMap() {
        return getUpgradeCtx$javalin().queryParamMap();
    }

    @NotNull
    public final List<String> queryParams(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return getUpgradeCtx$javalin().queryParams(key);
    }

    @Nullable
    public final String queryParam(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return getUpgradeCtx$javalin().queryParam(key);
    }

    @NotNull
    public final <T> Validator<T> queryParamAsClass(@NotNull String key, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return getUpgradeCtx$javalin().queryParamAsClass(key, cls);
    }

    public final /* synthetic */ <T> Validator<T> queryParamAsClass(String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.reifiedOperationMarker(4, "T");
        return queryParamAsClass(key, Object.class);
    }

    @NotNull
    public final Map<String, String> pathParamMap() {
        return getUpgradeCtx$javalin().pathParamMap();
    }

    @NotNull
    public final String pathParam(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return getUpgradeCtx$javalin().pathParam(key);
    }

    @NotNull
    public final <T> Validator<T> pathParamAsClass(@NotNull String key, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return getUpgradeCtx$javalin().pathParamAsClass(key, cls);
    }

    public final /* synthetic */ <T> Validator<T> pathParamAsClass(String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.reifiedOperationMarker(4, "T");
        return pathParamAsClass(key, Object.class);
    }

    public final String host() {
        return getUpgradeReq$javalin().getHost();
    }

    @Nullable
    public final String header(@NotNull String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        return getUpgradeCtx$javalin().header(header);
    }

    @NotNull
    public final Map<String, String> headerMap() {
        return getUpgradeCtx$javalin().headerMap();
    }

    @Nullable
    public final String cookie(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getUpgradeCtx$javalin().cookie(name);
    }

    @NotNull
    public final Map<String, String> cookieMap() {
        return getUpgradeCtx$javalin().cookieMap();
    }

    public final void attribute(@NotNull String key, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        getUpgradeCtx$javalin().attribute(key, value);
    }

    @Nullable
    public final <T> T attribute(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return (T) getUpgradeCtx$javalin().attribute(key);
    }

    @NotNull
    public final Map<String, Object> attributeMap() {
        return getUpgradeCtx$javalin().attributeMap();
    }

    @Nullable
    public final <T> T sessionAttribute(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return (T) sessionAttributeMap().get(key);
    }

    @NotNull
    public final Map<String, Object> sessionAttributeMap() {
        Map<String, Object> sessionAttributes$javalin = getSessionAttributes$javalin();
        return sessionAttributes$javalin == null ? MapsKt.emptyMap() : sessionAttributes$javalin;
    }

    public final void closeSession() {
        this.session.close();
    }

    public final void closeSession(@NotNull CloseStatus closeStatus) {
        Intrinsics.checkNotNullParameter(closeStatus, "closeStatus");
        this.session.close(closeStatus);
    }

    public final void closeSession(int code, @Nullable String reason) {
        this.session.close(code, reason);
    }

    public boolean equals(@Nullable Object other) {
        Session session = this.session;
        if (other != null) {
            return Intrinsics.areEqual(session, ((WsContext) other).session);
        }
        throw new NullPointerException("null cannot be cast to non-null type io.javalin.websocket.WsContext");
    }

    public int hashCode() {
        return this.session.hashCode();
    }
}
