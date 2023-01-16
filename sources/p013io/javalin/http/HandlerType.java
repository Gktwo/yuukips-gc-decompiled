package p013io.javalin.http;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.javalin.core.util.Header;

/* compiled from: HandlerType.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0001\u0018�� \u00112\b\u0012\u0004\u0012\u00020��0\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, m373d2 = {"Lio/javalin/http/HandlerType;", "", "(Ljava/lang/String;I)V", "isHttpMethod", "", "GET", "POST", "PUT", "PATCH", "DELETE", "HEAD", "TRACE", "CONNECT", "OPTIONS", "BEFORE", "AFTER", "INVALID", "Companion", "javalin"})
/* renamed from: io.javalin.http.HandlerType */
/* loaded from: grasscutter.jar:io/javalin/http/HandlerType.class */
public enum HandlerType {
    GET,
    POST,
    PUT,
    PATCH,
    DELETE,
    HEAD,
    TRACE,
    CONNECT,
    OPTIONS,
    BEFORE,
    AFTER,
    INVALID;
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Map<String, HandlerType> methodMap;

    /* compiled from: HandlerType.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48)
    /* renamed from: io.javalin.http.HandlerType$WhenMappings */
    /* loaded from: grasscutter.jar:io/javalin/http/HandlerType$WhenMappings.class */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HandlerType.values().length];
            iArr[HandlerType.GET.ordinal()] = 1;
            iArr[HandlerType.HEAD.ordinal()] = 2;
            iArr[HandlerType.POST.ordinal()] = 3;
            iArr[HandlerType.PUT.ordinal()] = 4;
            iArr[HandlerType.DELETE.ordinal()] = 5;
            iArr[HandlerType.CONNECT.ordinal()] = 6;
            iArr[HandlerType.OPTIONS.ordinal()] = 7;
            iArr[HandlerType.TRACE.ordinal()] = 8;
            iArr[HandlerType.PATCH.ordinal()] = 9;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        HandlerType[] values = values();
        Collection destination$iv$iv = new ArrayList(values.length);
        for (HandlerType handlerType : values) {
            destination$iv$iv.add(Tuples.m366to(handlerType.toString(), handlerType));
        }
        methodMap = MapsKt.toMap((List) destination$iv$iv);
    }

    public final boolean isHttpMethod() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    /* compiled from: HandlerType.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\"\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n��¨\u0006\n"}, m373d2 = {"Lio/javalin/http/HandlerType$Companion;", "", "()V", "methodMap", "", "", "Lio/javalin/http/HandlerType;", "fromServletRequest", "httpRequest", "Ljavax/servlet/http/HttpServletRequest;", "javalin"})
    /* renamed from: io.javalin.http.HandlerType$Companion */
    /* loaded from: grasscutter.jar:io/javalin/http/HandlerType$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final HandlerType fromServletRequest(@NotNull HttpServletRequest httpRequest) {
            Intrinsics.checkNotNullParameter(httpRequest, "httpRequest");
            String header = httpRequest.getHeader(Header.X_HTTP_METHOD_OVERRIDE);
            String key = header == null ? httpRequest.getMethod() : header;
            Map map = HandlerType.methodMap;
            Intrinsics.checkNotNullExpressionValue(key, Action.KEY_ATTRIBUTE);
            String upperCase = key.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.Strin….toUpperCase(Locale.ROOT)");
            HandlerType handlerType = (HandlerType) map.get(upperCase);
            return handlerType == null ? HandlerType.INVALID : handlerType;
        }
    }
}
