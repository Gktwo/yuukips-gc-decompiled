package p013io.javalin.core.util;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.bytebuddy.utility.JavaConstant;
import org.eclipse.jetty.util.security.Constraint;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

/* compiled from: Headers.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��b\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n��\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018��2\u00020\u0001:\u0007$%&'()*B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\"J\f\u0010#\u001a\u00020\u0005*\u00020\u0005H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0007¨\u0006+"}, m373d2 = {"Lio/javalin/core/util/Headers;", "", "()V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "clearSiteData", "", "data", "", "Lio/javalin/core/util/Headers$ClearSiteData;", "([Lio/javalin/core/util/Headers$ClearSiteData;)V", "contentSecurityPolicy", "crossOriginEmbedderPolicy", "policy", "Lio/javalin/core/util/Headers$CrossOriginEmbedderPolicy;", "crossOriginOpenerPolicy", "Lio/javalin/core/util/Headers$CrossOriginOpenerPolicy;", "crossOriginResourcePolicy", "Lio/javalin/core/util/Headers$CrossOriginResourcePolicy;", "referrerPolicy", "Lio/javalin/core/util/Headers$ReferrerPolicy;", "strictTransportSecurity", "duration", "Ljava/time/Duration;", "includeSubdomains", "", "xContentTypeOptionsNoSniff", "xFrameOptions", "Lio/javalin/core/util/Headers$XFrameOptions;", "domain", "xPermittedCrossDomainPolicies", "Lio/javalin/core/util/Headers$CrossDomainPolicy;", "toHttpHeaderValue", "ClearSiteData", "CrossDomainPolicy", "CrossOriginEmbedderPolicy", "CrossOriginOpenerPolicy", "CrossOriginResourcePolicy", "ReferrerPolicy", "XFrameOptions", "javalin"})
/* renamed from: io.javalin.core.util.Headers */
/* loaded from: grasscutter.jar:io/javalin/core/util/Headers.class */
public final class Headers {
    @NotNull
    private final Map<String, String> headers = new LinkedHashMap();

    /* compiled from: Headers.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018��2\b\u0012\u0004\u0012\u00020��0\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m373d2 = {"Lio/javalin/core/util/Headers$CrossDomainPolicy;", "", "(Ljava/lang/String;I)V", Constraint.NONE, "MASTER_ONLY", "BY_CONTENT_TYPE", "BY_FTP_FILENAME", "ALL", "javalin"})
    /* renamed from: io.javalin.core.util.Headers$CrossDomainPolicy */
    /* loaded from: grasscutter.jar:io/javalin/core/util/Headers$CrossDomainPolicy.class */
    public enum CrossDomainPolicy {
        NONE,
        MASTER_ONLY,
        BY_CONTENT_TYPE,
        BY_FTP_FILENAME,
        ALL
    }

    /* compiled from: Headers.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018��2\b\u0012\u0004\u0012\u00020��0\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m373d2 = {"Lio/javalin/core/util/Headers$CrossOriginEmbedderPolicy;", "", "(Ljava/lang/String;I)V", "UNSAFE_NONE", "REQUIRE_CORP", "javalin"})
    /* renamed from: io.javalin.core.util.Headers$CrossOriginEmbedderPolicy */
    /* loaded from: grasscutter.jar:io/javalin/core/util/Headers$CrossOriginEmbedderPolicy.class */
    public enum CrossOriginEmbedderPolicy {
        UNSAFE_NONE,
        REQUIRE_CORP
    }

    /* compiled from: Headers.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018��2\b\u0012\u0004\u0012\u00020��0\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m373d2 = {"Lio/javalin/core/util/Headers$CrossOriginOpenerPolicy;", "", "(Ljava/lang/String;I)V", "UNSAFE_NONE", "SAME_ORIGIN_ALLOW_POPUPS", "SAME_ORIGIN", "javalin"})
    /* renamed from: io.javalin.core.util.Headers$CrossOriginOpenerPolicy */
    /* loaded from: grasscutter.jar:io/javalin/core/util/Headers$CrossOriginOpenerPolicy.class */
    public enum CrossOriginOpenerPolicy {
        UNSAFE_NONE,
        SAME_ORIGIN_ALLOW_POPUPS,
        SAME_ORIGIN
    }

    /* compiled from: Headers.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018��2\b\u0012\u0004\u0012\u00020��0\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m373d2 = {"Lio/javalin/core/util/Headers$CrossOriginResourcePolicy;", "", "(Ljava/lang/String;I)V", "SAME_SITE", "SAME_ORIGIN", "CROSS_ORIGIN", "javalin"})
    /* renamed from: io.javalin.core.util.Headers$CrossOriginResourcePolicy */
    /* loaded from: grasscutter.jar:io/javalin/core/util/Headers$CrossOriginResourcePolicy.class */
    public enum CrossOriginResourcePolicy {
        SAME_SITE,
        SAME_ORIGIN,
        CROSS_ORIGIN
    }

    /* compiled from: Headers.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0001\u0018��2\b\u0012\u0004\u0012\u00020��0\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m373d2 = {"Lio/javalin/core/util/Headers$ReferrerPolicy;", "", "(Ljava/lang/String;I)V", "NO_REFERRER", "NO_REFERRER_WHEN_DOWNGRADE", "ORIGIN", "ORIGIN_WHEN_CROSS_ORIGIN", "SAME_ORIGIN", "STRICT_ORIGIN", "STRICT_ORIGIN_WHEN_CROSS_ORIGIN", "UNSAFE_URL", "javalin"})
    /* renamed from: io.javalin.core.util.Headers$ReferrerPolicy */
    /* loaded from: grasscutter.jar:io/javalin/core/util/Headers$ReferrerPolicy.class */
    public enum ReferrerPolicy {
        NO_REFERRER,
        NO_REFERRER_WHEN_DOWNGRADE,
        ORIGIN,
        ORIGIN_WHEN_CROSS_ORIGIN,
        SAME_ORIGIN,
        STRICT_ORIGIN,
        STRICT_ORIGIN_WHEN_CROSS_ORIGIN,
        UNSAFE_URL
    }

    /* compiled from: Headers.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018��2\b\u0012\u0004\u0012\u00020��0\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m373d2 = {"Lio/javalin/core/util/Headers$XFrameOptions;", "", "(Ljava/lang/String;I)V", "DENY", "SAMEORIGIN", "javalin"})
    /* renamed from: io.javalin.core.util.Headers$XFrameOptions */
    /* loaded from: grasscutter.jar:io/javalin/core/util/Headers$XFrameOptions.class */
    public enum XFrameOptions {
        DENY,
        SAMEORIGIN
    }

    @NotNull
    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final void strictTransportSecurity(@NotNull Duration duration, boolean includeSubdomains) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        this.headers.put("Strict-Transport-Security", "max-age=" + duration.getSeconds() + (includeSubdomains ? " ; includeSubDomains" : ""));
    }

    public final void xFrameOptions(@NotNull XFrameOptions xFrameOptions) {
        Intrinsics.checkNotNullParameter(xFrameOptions, "xFrameOptions");
        this.headers.put("X-Frame-Options", toHttpHeaderValue(xFrameOptions.name()));
    }

    public final void xFrameOptions(@NotNull String domain) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        this.headers.put("X-Frame-Options", Intrinsics.stringPlus("allow-from: ", domain));
    }

    public final void xContentTypeOptionsNoSniff() {
        this.headers.put("X-Content-Type-Options", "nosniff");
    }

    public final void contentSecurityPolicy(@NotNull String contentSecurityPolicy) {
        Intrinsics.checkNotNullParameter(contentSecurityPolicy, "contentSecurityPolicy");
        this.headers.put("Content-Security-Policy", contentSecurityPolicy);
    }

    public final void xPermittedCrossDomainPolicies(@NotNull CrossDomainPolicy policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        this.headers.put(Header.X_PERMITTED_CROSS_DOMAIN_POLICIES, toHttpHeaderValue(policy.name()));
    }

    public final void referrerPolicy(@NotNull ReferrerPolicy policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        this.headers.put("Referrer-Policy", toHttpHeaderValue(policy.name()));
    }

    /* compiled from: Headers.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018��2\b\u0012\u0004\u0012\u00020��0\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m373d2 = {"Lio/javalin/core/util/Headers$ClearSiteData;", "", "(Ljava/lang/String;I)V", "headerValue", "", "CACHE", "COOKIES", "STORAGE", "EXECUTION_CONTEXTS", "ANY", "javalin"})
    /* renamed from: io.javalin.core.util.Headers$ClearSiteData */
    /* loaded from: grasscutter.jar:io/javalin/core/util/Headers$ClearSiteData.class */
    public enum ClearSiteData {
        CACHE,
        COOKIES,
        STORAGE,
        EXECUTION_CONTEXTS,
        ANY;

        @NotNull
        public final String headerValue() {
            if (this == ANY) {
                return "\"*\"";
            }
            if (this == EXECUTION_CONTEXTS) {
                return "\"executionContexts\"";
            }
            StringBuilder append = new StringBuilder().append('\"');
            String name = name();
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, Logger.ROOT_LOGGER_NAME);
            if (name == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return append.append(lowerCase).append('\"').toString();
        }
    }

    public final void clearSiteData(@NotNull ClearSiteData... data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.headers.put(Header.CLEAR_SITE_DATA, ArraysKt.joinToString$default(data, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, Headers$clearSiteData$1.INSTANCE, 30, (Object) null));
    }

    public final void crossOriginEmbedderPolicy(@NotNull CrossOriginEmbedderPolicy policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        this.headers.put(Header.CROSS_ORIGIN_EMBEDDER_POLICY, toHttpHeaderValue(policy.name()));
    }

    public final void crossOriginOpenerPolicy(@NotNull CrossOriginOpenerPolicy policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        this.headers.put(Header.CROSS_ORIGIN_OPENER_POLICY, toHttpHeaderValue(policy.name()));
    }

    public final void crossOriginResourcePolicy(@NotNull CrossOriginResourcePolicy policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        this.headers.put(Header.CROSS_ORIGIN_RESOURCE_POLICY, toHttpHeaderValue(policy.name()));
    }

    private final String toHttpHeaderValue(String $this$toHttpHeaderValue) {
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, Logger.ROOT_LOGGER_NAME);
        if ($this$toHttpHeaderValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = $this$toHttpHeaderValue.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return StringsKt.replace$default(lowerCase, JavaConstant.Dynamic.DEFAULT_NAME, "-", false, 4, (Object) null);
    }
}
