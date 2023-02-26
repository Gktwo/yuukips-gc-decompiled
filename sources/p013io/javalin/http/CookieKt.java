package p013io.javalin.http;

import java.util.Collection;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Cookie.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\u001c\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004\"\u000e\u0010��\u001a\u00020\u0001XT¢\u0006\u0002\n��¨\u0006\t"}, m373d2 = {"SAME_SITE", "", "addSameSite", "cookie", "Lio/javalin/http/Cookie;", "setJavalinCookie", "", "Ljavax/servlet/http/HttpServletResponse;", "javalinCookie", "javalin"})
/* renamed from: io.javalin.http.CookieKt */
/* loaded from: grasscutter.jar:io/javalin/http/CookieKt.class */
public final class CookieKt {
    @NotNull
    public static final String SAME_SITE = "SameSite";

    /* JADX INFO: Multiple debug info for r0v2 javax.servlet.http.Cookie: [D('$this$setJavalinCookie_u24lambda_u2d0' javax.servlet.http.Cookie), D('cookie' javax.servlet.http.Cookie)] */
    public static final void setJavalinCookie(@NotNull HttpServletResponse $this$setJavalinCookie, @NotNull Cookie javalinCookie) {
        Intrinsics.checkNotNullParameter($this$setJavalinCookie, "<this>");
        Intrinsics.checkNotNullParameter(javalinCookie, "javalinCookie");
        Cookie cookie = new Cookie(javalinCookie.getName(), javalinCookie.getValue());
        cookie.setPath(javalinCookie.getPath());
        cookie.setMaxAge(javalinCookie.getMaxAge());
        cookie.setSecure(javalinCookie.getSecure());
        cookie.setVersion(javalinCookie.getVersion());
        cookie.setHttpOnly(javalinCookie.isHttpOnly());
        cookie.setComment(javalinCookie.getComment());
        if (javalinCookie.getDomain() != null) {
            cookie.setDomain(javalinCookie.getDomain());
        }
        $this$setJavalinCookie.addCookie(cookie);
        Collection<String> headers = $this$setJavalinCookie.getHeaders("Set-Cookie");
        List<String> cookies = CollectionsKt.toMutableList((Collection) (headers == null ? CollectionsKt.emptyList() : headers));
        cookies.removeIf((v1) -> {
            return m5814setJavalinCookie$lambda4$lambda1(r1, v1);
        });
        String first = (String) CollectionsKt.removeFirst(cookies);
        if (first != null) {
            $this$setJavalinCookie.setHeader("Set-Cookie", addSameSite(first, javalinCookie));
        }
        for (String remaining : cookies) {
            Intrinsics.checkNotNullExpressionValue(remaining, "remaining");
            $this$setJavalinCookie.addHeader("Set-Cookie", addSameSite(remaining, javalinCookie));
        }
    }

    /* renamed from: setJavalinCookie$lambda-4$lambda-1  reason: not valid java name */
    private static final boolean m5814setJavalinCookie$lambda4$lambda1(Cookie $cookie, String it) {
        Intrinsics.checkNotNullParameter($cookie, "$cookie");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (StringsKt.startsWith$default(it, Intrinsics.stringPlus($cookie.getName(), "="), false, 2, (Object) null)) {
            String value = $cookie.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "cookie.value");
            if (!StringsKt.contains$default((CharSequence) it, (CharSequence) value, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final String addSameSite(@NotNull String $this$addSameSite, @NotNull Cookie cookie) {
        Intrinsics.checkNotNullParameter($this$addSameSite, "<this>");
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        return (cookie.getSameSite() == null || StringsKt.contains$default((CharSequence) $this$addSameSite, (CharSequence) SAME_SITE, false, 2, (Object) null)) ? $this$addSameSite : $this$addSameSite + "; " + cookie.getSameSite();
    }
}
