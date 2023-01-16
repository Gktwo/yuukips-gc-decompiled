package p013io.javalin.http.util;

import com.sun.jna.Callback;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p016io.IOStreams;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.javalin.core.security.BasicAuthCredentials;
import p013io.javalin.core.util.JavalinLogger;
import p013io.javalin.http.ContentType;
import p013io.javalin.http.Context;
import p013io.javalin.http.HandlerEntry;
import p013io.javalin.http.HandlerType;
import p013io.javalin.http.HttpCode;
import p013io.javalin.http.HttpResponseException;

/* compiled from: ContextUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��r\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000fJ7\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\u0004\b��\u0010\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00110\u00132\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J#\u0010\u0019\u001a\u0004\u0018\u0001H\u0011\"\u0004\b��\u0010\u00112\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u001c\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004JX\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00042\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040#2\b\b\u0002\u0010$\u001a\u00020%2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010#H\u0007J,\u0010'\u001a\u00020\u00042\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040#2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004J\u001a\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.J(\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0004000#2\u0006\u00101\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004J\u001e\u00102\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0004J\u000e\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004J\n\u00108\u001a\u00020\u0007*\u00020\tJ\n\u00109\u001a\u00020\u000b*\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006:"}, m373d2 = {"Lio/javalin/http/util/ContextUtil;", "", "()V", "maxRequestSizeKey", "", "sessionCacheKeyPrefix", "acceptsHtml", "", "ctx", "Lio/javalin/http/Context;", "cacheAndSetSessionAttribute", "", Action.KEY_ATTRIBUTE, "value", "req", "Ljavax/servlet/http/HttpServletRequest;", "cachedSessionAttributeOrCompute", "T", Callback.METHOD_NAME, "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lio/javalin/http/Context;)Ljava/lang/Object;", "changeBaseRequest", "getBasicAuthCredentials", "Lio/javalin/core/security/BasicAuthCredentials;", "header", "getCachedRequestAttributeOrSessionAttribute", "(Ljava/lang/String;Ljavax/servlet/http/HttpServletRequest;)Ljava/lang/Object;", "getRequestCharset", "hasBasicAuthCredentials", "init", "request", "response", "Ljavax/servlet/http/HttpServletResponse;", "matchedPath", "pathParamMap", "", "handlerType", "Lio/javalin/http/HandlerType;", "appAttributes", "pathParamOrThrow", "pathParams", "url", "readAndResetStreamIfPossible", "stream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "splitKeyValueStringAndGroupByKey", "", "string", "update", "handlerEntry", "Lio/javalin/http/HandlerEntry;", "requestUri", "urlDecode", "s", "isLocalhost", "throwPayloadTooLargeIfPayloadTooLarge", "javalin"})
/* renamed from: io.javalin.http.util.ContextUtil */
/* loaded from: grasscutter.jar:io/javalin/http/util/ContextUtil.class */
public final class ContextUtil {
    @NotNull
    public static final ContextUtil INSTANCE = new ContextUtil();
    @NotNull
    public static final String maxRequestSizeKey = "javalin-max-request-size";
    @NotNull
    public static final String sessionCacheKeyPrefix = "javalin-session-attribute-cache-";

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Context init(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull String matchedPath, @NotNull Map<String, String> map, @NotNull HandlerType handlerType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(matchedPath, "matchedPath");
        Intrinsics.checkNotNullParameter(map, "pathParamMap");
        Intrinsics.checkNotNullParameter(handlerType, "handlerType");
        return init$default(request, response, matchedPath, map, handlerType, null, 32, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Context init(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull String matchedPath, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(matchedPath, "matchedPath");
        Intrinsics.checkNotNullParameter(map, "pathParamMap");
        return init$default(request, response, matchedPath, map, null, null, 48, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Context init(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull String matchedPath) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(matchedPath, "matchedPath");
        return init$default(request, response, matchedPath, null, null, null, 56, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Context init(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        return init$default(request, response, null, null, null, null, 60, null);
    }

    private ContextUtil() {
    }

    @NotNull
    public final Context update(@NotNull Context ctx, @NotNull HandlerEntry handlerEntry, @NotNull String requestUri) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(handlerEntry, "handlerEntry");
        Intrinsics.checkNotNullParameter(requestUri, "requestUri");
        ctx.setMatchedPath$javalin(handlerEntry.getPath());
        ctx.setPathParamMap$javalin(handlerEntry.extractPathParams(requestUri));
        ctx.setHandlerType$javalin(handlerEntry.getType());
        if (ctx.getHandlerType$javalin() != HandlerType.AFTER) {
            ctx.setEndpointHandlerPath$javalin(handlerEntry.getPath());
        }
        return ctx;
    }

    @Nullable
    public final String getRequestCharset(@NotNull Context ctx) {
        Object obj;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String value = ctx.req.getHeader("Content-Type");
        if (value == null) {
            return null;
        }
        Iterator it = StringsKt.split$default((CharSequence) value, new String[]{";"}, false, 0, 6, (Object) null).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            Object next = it.next();
            String it2 = (String) next;
            if (it2 != null) {
                if (StringsKt.startsWith(StringsKt.trim((CharSequence) it2).toString(), "charset", true)) {
                    obj = next;
                    break;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        String it3 = (String) obj;
        if (it3 == null) {
            return null;
        }
        String str = (String) StringsKt.split$default((CharSequence) it3, new String[]{"="}, false, 0, 6, (Object) null).get(1);
        if (str != null) {
            return StringsKt.trim((CharSequence) str).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @NotNull
    public final Map<String, List<String>> splitKeyValueStringAndGroupByKey(@NotNull String string, @NotNull String charset) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (string.length() == 0) {
            return MapsKt.emptyMap();
        }
        Iterable<String> $this$map$iv = StringsKt.split$default((CharSequence) string, new String[]{"&"}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (String str : $this$map$iv) {
            destination$iv$iv.add(StringsKt.split$default((CharSequence) str, new String[]{"="}, false, 2, 2, (Object) null));
        }
        Iterable $this$groupBy$iv = (List) destination$iv$iv;
        Map destination$iv$iv2 = new LinkedHashMap();
        for (Object element$iv$iv : $this$groupBy$iv) {
            String decode = URLDecoder.decode((String) ((List) element$iv$iv).get(0), charset);
            Object value$iv$iv$iv = destination$iv$iv2.get(decode);
            if (value$iv$iv$iv == null) {
                ArrayList arrayList2 = new ArrayList();
                destination$iv$iv2.put(decode, arrayList2);
                arrayList = arrayList2;
            } else {
                arrayList = value$iv$iv$iv;
            }
            List it = (List) element$iv$iv;
            ((List) arrayList).add(it.size() > 1 ? URLDecoder.decode((String) it.get(1), charset) : "");
        }
        Map destination$iv$iv3 = new LinkedHashMap(MapsKt.mapCapacity(destination$iv$iv2.size()));
        for (Object element$iv$iv$iv : destination$iv$iv2.entrySet()) {
            destination$iv$iv3.put(((Map.Entry) element$iv$iv$iv).getKey(), CollectionsKt.toList((Iterable) ((Map.Entry) element$iv$iv$iv).getValue()));
        }
        return destination$iv$iv3;
    }

    @NotNull
    public final String pathParamOrThrow(@NotNull Map<String, String> map, @NotNull String key, @NotNull String url) {
        Intrinsics.checkNotNullParameter(map, "pathParams");
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(url, "url");
        String str = map.get(StringsKt.replaceFirst$default(StringsKt.replaceFirst$default(key, "{", "", false, 4, (Object) null), "}", "", false, 4, (Object) null));
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException('\'' + key + "' is not a valid path-param for '" + url + "'.");
    }

    @NotNull
    public final String urlDecode(@NotNull String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        String decode = URLDecoder.decode(StringsKt.replace$default(s, Marker.ANY_NON_NULL_MARKER, "%2B", false, 4, (Object) null), "UTF-8");
        Intrinsics.checkNotNullExpressionValue(decode, "decode(s.replace(\"+\", \"%2B\"), \"UTF-8\")");
        return StringsKt.replace$default(decode, "%2B", Marker.ANY_NON_NULL_MARKER, false, 4, (Object) null);
    }

    public final boolean hasBasicAuthCredentials(@Nullable String header) {
        boolean z;
        try {
            getBasicAuthCredentials(header);
            z = true;
        } catch (Exception e) {
            z = false;
        }
        return z;
    }

    @NotNull
    public final BasicAuthCredentials getBasicAuthCredentials(@Nullable String header) {
        boolean z;
        if (header == null) {
            z = false;
        } else {
            z = StringsKt.startsWith$default(header, "Basic ", false, 2, (Object) null);
        }
        if (!z) {
            throw new IllegalArgumentException(("Invalid basicauth header. Value was '" + ((Object) header) + "'.").toString());
        }
        Base64.Decoder decoder = Base64.getDecoder();
        Intrinsics.checkNotNull(header);
        byte[] decode = decoder.decode(StringsKt.removePrefix(header, (CharSequence) "Basic "));
        Intrinsics.checkNotNullExpressionValue(decode, "getDecoder().decode(head…!.removePrefix(\"Basic \"))");
        List split$default = StringsKt.split$default((CharSequence) new String(decode, Charsets.UTF_8), new char[]{':'}, false, 2, 2, (Object) null);
        return new BasicAuthCredentials((String) split$default.get(0), (String) split$default.get(1));
    }

    public final boolean acceptsHtml(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String header = ctx.header("Accept");
        return header != null && StringsKt.contains$default((CharSequence) header, (CharSequence) ContentType.HTML, false, 2, (Object) null);
    }

    public static /* synthetic */ Context init$default(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String str, Map map, HandlerType handlerType, Map map2, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "*";
        }
        if ((i & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 16) != 0) {
            handlerType = HandlerType.INVALID;
        }
        if ((i & 32) != 0) {
            map2 = MapsKt.emptyMap();
        }
        return init(httpServletRequest, httpServletResponse, str, map, handlerType, map2);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Context init(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull String matchedPath, @NotNull Map<String, String> map, @NotNull HandlerType handlerType, @NotNull Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(matchedPath, "matchedPath");
        Intrinsics.checkNotNullParameter(map, "pathParamMap");
        Intrinsics.checkNotNullParameter(handlerType, "handlerType");
        Intrinsics.checkNotNullParameter(map2, "appAttributes");
        Context $this$init_u24lambda_u2d9 = new Context(request, response, map2);
        $this$init_u24lambda_u2d9.setMatchedPath$javalin(matchedPath);
        $this$init_u24lambda_u2d9.setPathParamMap$javalin(map);
        $this$init_u24lambda_u2d9.setHandlerType$javalin(handlerType);
        return $this$init_u24lambda_u2d9;
    }

    public final boolean isLocalhost(@NotNull Context $this$isLocalhost) {
        boolean z;
        String it;
        boolean z2;
        Intrinsics.checkNotNullParameter($this$isLocalhost, "<this>");
        try {
            it = new URL($this$isLocalhost.url()).getHost();
        } catch (Exception e) {
            z = false;
        }
        if (!Intrinsics.areEqual(it, "localhost")) {
            if (!Intrinsics.areEqual(it, "127.0.0.1")) {
                z2 = false;
                z = z2;
                return z;
            }
        }
        z2 = true;
        z = z2;
        return z;
    }

    @NotNull
    public final Context changeBaseRequest(@NotNull Context ctx, @NotNull HttpServletRequest req) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(req, "req");
        Context $this$changeBaseRequest_u24lambda_u2d11 = new Context(req, ctx.res, ctx.getAppAttributes$javalin());
        $this$changeBaseRequest_u24lambda_u2d11.setPathParamMap$javalin(ctx.getPathParamMap$javalin());
        $this$changeBaseRequest_u24lambda_u2d11.setMatchedPath$javalin(ctx.getMatchedPath$javalin());
        return $this$changeBaseRequest_u24lambda_u2d11;
    }

    public final void throwPayloadTooLargeIfPayloadTooLarge(@NotNull Context $this$throwPayloadTooLargeIfPayloadTooLarge) {
        Intrinsics.checkNotNullParameter($this$throwPayloadTooLargeIfPayloadTooLarge, "<this>");
        long maxRequestSize = ((Number) $this$throwPayloadTooLargeIfPayloadTooLarge.appAttribute(maxRequestSizeKey)).longValue();
        if (((long) $this$throwPayloadTooLargeIfPayloadTooLarge.req.getContentLength()) > maxRequestSize) {
            JavalinLogger.warn$default("Body greater than max size (" + maxRequestSize + " bytes)", null, 2, null);
            throw new HttpResponseException(HttpCode.PAYLOAD_TOO_LARGE.getStatus(), HttpCode.PAYLOAD_TOO_LARGE.getMessage(), null, 4, null);
        }
    }

    public final void cacheAndSetSessionAttribute(@NotNull String key, @Nullable Object value, @NotNull HttpServletRequest req) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(req, "req");
        req.setAttribute(Intrinsics.stringPlus(sessionCacheKeyPrefix, key), value);
        req.getSession().setAttribute(key, value);
    }

    @Nullable
    public final <T> T getCachedRequestAttributeOrSessionAttribute(@NotNull String key, @NotNull HttpServletRequest req) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(req, "req");
        if (req.getAttribute(Intrinsics.stringPlus(sessionCacheKeyPrefix, key)) == null) {
            req.setAttribute(Intrinsics.stringPlus(sessionCacheKeyPrefix, key), req.getSession().getAttribute(key));
        }
        return (T) req.getAttribute(Intrinsics.stringPlus(sessionCacheKeyPrefix, key));
    }

    @Nullable
    public final <T> T cachedSessionAttributeOrCompute(@NotNull Function1<? super Context, ? extends T> function1, @NotNull String key, @NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(function1, Callback.METHOD_NAME);
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (getCachedRequestAttributeOrSessionAttribute(key, ctx.req) == null) {
            cacheAndSetSessionAttribute(key, function1.invoke(ctx), ctx.req);
        }
        return (T) getCachedRequestAttributeOrSessionAttribute(key, ctx.req);
    }

    @Nullable
    public final String readAndResetStreamIfPossible(@Nullable InputStream stream, @NotNull Charset charset) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (stream == null) {
            str = null;
        } else {
            try {
                stream.reset();
                byte[] readBytes = IOStreams.readBytes(stream);
                str = readBytes == null ? null : new String(readBytes, charset);
            } catch (Exception e) {
                str2 = "resultString unavailable (resultStream couldn't be reset)";
            }
        }
        if (stream != null) {
            stream.reset();
        }
        str2 = str;
        return str2;
    }
}
