package p013io.javalin.jetty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.classic.ClassicConstants;
import p013io.javalin.core.JavalinConfig;
import p013io.javalin.core.security.RouteRole;
import p013io.javalin.core.util.Header;
import p013io.javalin.http.Context;
import p013io.javalin.http.JavalinServlet;
import p013io.javalin.http.util.ContextUtil;
import p013io.javalin.websocket.WsConfig;
import p013io.javalin.websocket.WsConnection;
import p013io.javalin.websocket.WsEntry;
import p013io.javalin.websocket.WsExceptionMapper;
import p013io.javalin.websocket.WsHandlerType;
import p013io.javalin.websocket.WsPathMatcher;

/* compiled from: JavalinJettyServlet.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\"\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0014J\u0018\u0010+\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n��R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n��\u001a\u0004\b\u000f\u0010\u0010¨\u0006,"}, m373d2 = {"Lio/javalin/jetty/JavalinJettyServlet;", "Lorg/eclipse/jetty/websocket/servlet/WebSocketServlet;", "config", "Lio/javalin/core/JavalinConfig;", "httpServlet", "Lio/javalin/http/JavalinServlet;", "(Lio/javalin/core/JavalinConfig;Lio/javalin/http/JavalinServlet;)V", "getConfig", "()Lio/javalin/core/JavalinConfig;", "wsExceptionMapper", "Lio/javalin/websocket/WsExceptionMapper;", "getWsExceptionMapper", "()Lio/javalin/websocket/WsExceptionMapper;", "wsPathMatcher", "Lio/javalin/websocket/WsPathMatcher;", "getWsPathMatcher", "()Lio/javalin/websocket/WsPathMatcher;", "addHandler", "", "handlerType", "Lio/javalin/websocket/WsHandlerType;", "path", "", "ws", "Ljava/util/function/Consumer;", "Lio/javalin/websocket/WsConfig;", "roles", "", "Lio/javalin/core/security/RouteRole;", "allowedByAccessManager", "", "entry", "Lio/javalin/websocket/WsEntry;", "ctx", "Lio/javalin/http/Context;", "configure", "factory", "Lorg/eclipse/jetty/websocket/servlet/WebSocketServletFactory;", "service", "req", "Ljavax/servlet/http/HttpServletRequest;", "res", "Ljavax/servlet/http/HttpServletResponse;", "setWsProtocolHeader", "javalin"})
/* renamed from: io.javalin.jetty.JavalinJettyServlet */
/* loaded from: grasscutter.jar:io/javalin/jetty/JavalinJettyServlet.class */
public final class JavalinJettyServlet extends WebSocketServlet {
    @NotNull
    private final JavalinConfig config;
    @NotNull
    private final JavalinServlet httpServlet;
    @NotNull
    private final WsExceptionMapper wsExceptionMapper = new WsExceptionMapper();
    @NotNull
    private final WsPathMatcher wsPathMatcher = new WsPathMatcher();

    public JavalinJettyServlet(@NotNull JavalinConfig config, @NotNull JavalinServlet httpServlet) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(httpServlet, "httpServlet");
        this.config = config;
        this.httpServlet = httpServlet;
    }

    @NotNull
    public final JavalinConfig getConfig() {
        return this.config;
    }

    @NotNull
    public final WsExceptionMapper getWsExceptionMapper() {
        return this.wsExceptionMapper;
    }

    @NotNull
    public final WsPathMatcher getWsPathMatcher() {
        return this.wsPathMatcher;
    }

    public final void addHandler(@NotNull WsHandlerType handlerType, @NotNull String path, @NotNull Consumer<WsConfig> consumer, @NotNull Set<? extends RouteRole> set) {
        Intrinsics.checkNotNullParameter(handlerType, "handlerType");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(consumer, "ws");
        Intrinsics.checkNotNullParameter(set, "roles");
        WsPathMatcher wsPathMatcher = this.wsPathMatcher;
        boolean z = this.config.ignoreTrailingSlashes;
        WsConfig $this$addHandler_u24lambda_u2d0 = new WsConfig();
        consumer.accept($this$addHandler_u24lambda_u2d0);
        Unit unit = Unit.INSTANCE;
        wsPathMatcher.add(new WsEntry(handlerType, path, z, $this$addHandler_u24lambda_u2d0, set));
    }

    @Override // org.eclipse.jetty.websocket.servlet.WebSocketServlet
    public void configure(@NotNull WebSocketServletFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Consumer<WebSocketServletFactory> consumer = this.config.inner.wsFactoryConfig;
        if (consumer != null) {
            consumer.accept(factory);
        }
        factory.setCreator((v1, v2) -> {
            return m5858configure$lambda2(r1, v1, v2);
        });
    }

    /* renamed from: configure$lambda-2  reason: not valid java name */
    private static final Object m5858configure$lambda2(JavalinJettyServlet this$0, ServletUpgradeRequest req, ServletUpgradeResponse $noName_1) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object attribute = req.getHttpServletRequest().getAttribute(JavalinJettyServletKt.upgradeContextKey);
        if (attribute == null) {
            throw new NullPointerException("null cannot be cast to non-null type io.javalin.http.Context");
        }
        Context preUpgradeContext = (Context) attribute;
        HttpServletRequest httpServletRequest = req.getHttpServletRequest();
        ContextUtil contextUtil = ContextUtil.INSTANCE;
        HttpServletRequest httpServletRequest2 = req.getHttpServletRequest();
        Intrinsics.checkNotNullExpressionValue(httpServletRequest2, "req.httpServletRequest");
        httpServletRequest.setAttribute(JavalinJettyServletKt.upgradeContextKey, contextUtil.changeBaseRequest(preUpgradeContext, httpServletRequest2));
        HttpServletRequest httpServletRequest3 = req.getHttpServletRequest();
        String str = JavalinJettyServletKt.upgradeSessionAttrsKey;
        HttpSession session = req.getSession();
        if (session == null) {
            linkedHashMap = null;
        } else {
            Enumeration<String> attributeNames = session.getAttributeNames();
            if (attributeNames == null) {
                linkedHashMap = null;
            } else {
                Sequence $this$associateWith$iv = SequencesKt.asSequence(CollectionsKt.iterator(attributeNames));
                if ($this$associateWith$iv == null) {
                    linkedHashMap = null;
                } else {
                    LinkedHashMap result$iv = new LinkedHashMap();
                    for (Object element$iv$iv : $this$associateWith$iv) {
                        result$iv.put(element$iv$iv, req.getSession().getAttribute((String) element$iv$iv));
                    }
                    LinkedHashMap linkedHashMap2 = result$iv;
                    httpServletRequest3 = httpServletRequest3;
                    str = str;
                    linkedHashMap = linkedHashMap2;
                }
            }
        }
        httpServletRequest3.setAttribute(str, linkedHashMap);
        return new WsConnection(this$0.getWsPathMatcher(), this$0.getWsExceptionMapper(), this$0.getConfig().inner.wsLogger);
    }

    /* JADX INFO: Multiple debug info for r0v14 io.javalin.http.Context: [D('upgradeContext' io.javalin.http.Context), D('$this$service_u24lambda_u2d3' io.javalin.http.Context)] */
    @Override // org.eclipse.jetty.websocket.servlet.WebSocketServlet, javax.servlet.http.HttpServlet
    protected void service(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        if (req.getHeader(Header.SEC_WEBSOCKET_KEY) == null) {
            this.httpServlet.service((ServletRequest) req, (ServletResponse) res);
            return;
        }
        String requestURI = req.getRequestURI();
        Intrinsics.checkNotNullExpressionValue(requestURI, ClassicConstants.REQUEST_REQUEST_URI);
        String contextPath = req.getContextPath();
        Intrinsics.checkNotNullExpressionValue(contextPath, "req.contextPath");
        String requestUri = StringsKt.removePrefix(requestURI, (CharSequence) contextPath);
        WsEntry entry = this.wsPathMatcher.findEndpointHandlerEntry(requestUri);
        if (entry == null) {
            res.sendError(404, "WebSocket handler not found");
            return;
        }
        Map<String, Object> map = this.config.inner.appAttributes;
        Intrinsics.checkNotNullExpressionValue(map, "config.inner.appAttributes");
        Context $this$service_u24lambda_u2d3 = new Context(req, res, map);
        $this$service_u24lambda_u2d3.setPathParamMap$javalin(entry.extractPathParams(requestUri));
        $this$service_u24lambda_u2d3.setMatchedPath$javalin(entry.getPath());
        if (!allowedByAccessManager(entry, $this$service_u24lambda_u2d3)) {
            res.sendError(401, "Unauthorized");
            return;
        }
        req.setAttribute(JavalinJettyServletKt.upgradeContextKey, $this$service_u24lambda_u2d3);
        setWsProtocolHeader(req, res);
        service(req, res);
    }

    private final boolean allowedByAccessManager(WsEntry entry, Context ctx) {
        boolean z;
        try {
            this.config.inner.accessManager.manage(JavalinJettyServlet::m5859allowedByAccessManager$lambda4, ctx, entry.getRoles());
            z = Intrinsics.areEqual(ctx.attribute("javalin-ws-upgrade-allowed"), (Object) true);
        } catch (Exception e) {
            z = false;
        }
        return z;
    }

    /* renamed from: allowedByAccessManager$lambda-4  reason: not valid java name */
    private static final void m5859allowedByAccessManager$lambda4(Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.attribute("javalin-ws-upgrade-allowed", true);
    }

    private final void setWsProtocolHeader(HttpServletRequest req, HttpServletResponse res) {
        Object obj;
        boolean z;
        String wsProtocolHeader = req.getHeader("Sec-WebSocket-Protocol");
        if (wsProtocolHeader != null) {
            Iterable<String> $this$map$iv = StringsKt.split$default((CharSequence) wsProtocolHeader, new char[]{','}, false, 0, 6, (Object) null);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (String it : $this$map$iv) {
                if (it == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                destination$iv$iv.add(StringsKt.trim((CharSequence) it).toString());
            }
            Iterator it2 = ((List) destination$iv$iv).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it2.next();
                if (!StringsKt.isBlank((String) next)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    obj = next;
                    break;
                }
            }
            String firstProtocol = (String) obj;
            if (firstProtocol != null) {
                res.setHeader("Sec-WebSocket-Protocol", firstProtocol);
            }
        }
    }
}
