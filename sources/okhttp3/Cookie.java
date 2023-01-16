package okhttp3;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import dev.morphia.mapping.Mapper;
import emu.grasscutter.net.packet.PacketOpcodes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.hostnames;
import okhttp3.internal.http.dates;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: Cookie.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018�� &2\u00020\u0001:\u0002%&BO\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\r\u0010\u0007\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0012J\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0017J\r\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0018J\r\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001eJ\r\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0002\b\u001fJ\r\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u0003H\u0016J\u0015\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\nH��¢\u0006\u0002\b#J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b$R\u0013\u0010\u0007\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\u000fR\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0010R\u0013\u0010\r\u001a\u00020\n8\u0007¢\u0006\b\n��\u001a\u0004\b\r\u0010\u0011R\u0013\u0010\u000b\u001a\u00020\n8\u0007¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\u0011R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\b\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\b\u0010\u000fR\u0013\u0010\f\u001a\u00020\n8\u0007¢\u0006\b\n��\u001a\u0004\b\f\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8\u0007¢\u0006\b\n��\u001a\u0004\b\t\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0004\u0010\u000f¨\u0006'"}, m373d2 = {"Lokhttp3/Cookie;", "", "name", "", "value", "expiresAt", "", "domain", "path", "secure", "", "httpOnly", "persistent", "hostOnly", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "()Ljava/lang/String;", "()J", "()Z", "-deprecated_domain", "equals", "other", "-deprecated_expiresAt", "hashCode", "", "-deprecated_hostOnly", "-deprecated_httpOnly", "matches", "url", "Lokhttp3/HttpUrl;", "-deprecated_name", "-deprecated_path", "-deprecated_persistent", "-deprecated_secure", Printer.TO_STRING, "forObsoleteRfc2965", "toString$okhttp", "-deprecated_value", "Builder", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/Cookie.class */
public final class Cookie {
    @NotNull
    private final String name;
    @NotNull
    private final String value;
    private final long expiresAt;
    @NotNull
    private final String domain;
    @NotNull
    private final String path;
    private final boolean secure;
    private final boolean httpOnly;
    private final boolean persistent;
    private final boolean hostOnly;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    @JvmStatic
    @Nullable
    public static final Cookie parse(@NotNull HttpUrl url, @NotNull String setCookie) {
        return Companion.parse(url, setCookie);
    }

    @JvmStatic
    @NotNull
    public static final List<Cookie> parseAll(@NotNull HttpUrl url, @NotNull Headers headers) {
        return Companion.parseAll(url, headers);
    }

    public /* synthetic */ Cookie(String name, String value, long expiresAt, String domain, String path, boolean secure, boolean httpOnly, boolean persistent, boolean hostOnly, DefaultConstructorMarker $constructor_marker) {
        this(name, value, expiresAt, domain, path, secure, httpOnly, persistent, hostOnly);
    }

    private Cookie(String name, String value, long expiresAt, String domain, String path, boolean secure, boolean httpOnly, boolean persistent, boolean hostOnly) {
        this.name = name;
        this.value = value;
        this.expiresAt = expiresAt;
        this.domain = domain;
        this.path = path;
        this.secure = secure;
        this.httpOnly = httpOnly;
        this.persistent = persistent;
        this.hostOnly = hostOnly;
    }

    @JvmName(name = "name")
    @NotNull
    public final String name() {
        return this.name;
    }

    @JvmName(name = "value")
    @NotNull
    public final String value() {
        return this.value;
    }

    @JvmName(name = "expiresAt")
    public final long expiresAt() {
        return this.expiresAt;
    }

    @JvmName(name = "domain")
    @NotNull
    public final String domain() {
        return this.domain;
    }

    @JvmName(name = "path")
    @NotNull
    public final String path() {
        return this.path;
    }

    @JvmName(name = "secure")
    public final boolean secure() {
        return this.secure;
    }

    @JvmName(name = "httpOnly")
    public final boolean httpOnly() {
        return this.httpOnly;
    }

    @JvmName(name = "persistent")
    public final boolean persistent() {
        return this.persistent;
    }

    @JvmName(name = "hostOnly")
    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean matches(@NotNull HttpUrl url) {
        boolean domainMatch;
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.hostOnly) {
            domainMatch = Intrinsics.areEqual(url.host(), this.domain);
        } else {
            domainMatch = Companion.domainMatch(url.host(), this.domain);
        }
        if (domainMatch && Companion.pathMatch(url, this.path)) {
            return !this.secure || url.isHttps();
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof Cookie) && Intrinsics.areEqual(((Cookie) other).name, this.name) && Intrinsics.areEqual(((Cookie) other).value, this.value) && ((Cookie) other).expiresAt == this.expiresAt && Intrinsics.areEqual(((Cookie) other).domain, this.domain) && Intrinsics.areEqual(((Cookie) other).path, this.path) && ((Cookie) other).secure == this.secure && ((Cookie) other).httpOnly == this.httpOnly && ((Cookie) other).persistent == this.persistent && ((Cookie) other).hostOnly == this.hostOnly;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * 17) + this.name.hashCode())) + this.value.hashCode())) + Long.hashCode(this.expiresAt))) + this.domain.hashCode())) + this.path.hashCode())) + Boolean.hashCode(this.secure))) + Boolean.hashCode(this.httpOnly))) + Boolean.hashCode(this.persistent))) + Boolean.hashCode(this.hostOnly);
    }

    @NotNull
    public String toString() {
        return toString$okhttp(false);
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "name", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_name")
    @NotNull
    /* renamed from: -deprecated_name  reason: not valid java name */
    public final String m9176deprecated_name() {
        return this.name;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "value", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_value")
    @NotNull
    /* renamed from: -deprecated_value  reason: not valid java name */
    public final String m9177deprecated_value() {
        return this.value;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "persistent", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_persistent")
    /* renamed from: -deprecated_persistent  reason: not valid java name */
    public final boolean m9178deprecated_persistent() {
        return this.persistent;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "expiresAt", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_expiresAt")
    /* renamed from: -deprecated_expiresAt  reason: not valid java name */
    public final long m9179deprecated_expiresAt() {
        return this.expiresAt;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "hostOnly", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_hostOnly")
    /* renamed from: -deprecated_hostOnly  reason: not valid java name */
    public final boolean m9180deprecated_hostOnly() {
        return this.hostOnly;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "domain", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_domain")
    @NotNull
    /* renamed from: -deprecated_domain  reason: not valid java name */
    public final String m9181deprecated_domain() {
        return this.domain;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "path", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_path")
    @NotNull
    /* renamed from: -deprecated_path  reason: not valid java name */
    public final String m9182deprecated_path() {
        return this.path;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "httpOnly", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_httpOnly")
    /* renamed from: -deprecated_httpOnly  reason: not valid java name */
    public final boolean m9183deprecated_httpOnly() {
        return this.httpOnly;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "secure", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_secure")
    /* renamed from: -deprecated_secure  reason: not valid java name */
    public final boolean m9184deprecated_secure() {
        return this.secure;
    }

    @NotNull
    public final String toString$okhttp(boolean forObsoleteRfc2965) {
        StringBuilder $this$toString_u24lambda_u2d0 = new StringBuilder();
        $this$toString_u24lambda_u2d0.append(name());
        $this$toString_u24lambda_u2d0.append('=');
        $this$toString_u24lambda_u2d0.append(value());
        if (persistent()) {
            if (expiresAt() == Long.MIN_VALUE) {
                $this$toString_u24lambda_u2d0.append("; max-age=0");
            } else {
                $this$toString_u24lambda_u2d0.append("; expires=").append(dates.toHttpDateString(new Date(expiresAt())));
            }
        }
        if (!hostOnly()) {
            $this$toString_u24lambda_u2d0.append("; domain=");
            if (forObsoleteRfc2965) {
                $this$toString_u24lambda_u2d0.append(Mapper.IGNORED_FIELDNAME);
            }
            $this$toString_u24lambda_u2d0.append(domain());
        }
        $this$toString_u24lambda_u2d0.append("; path=").append(path());
        if (secure()) {
            $this$toString_u24lambda_u2d0.append("; secure");
        }
        if (httpOnly()) {
            $this$toString_u24lambda_u2d0.append("; httponly");
        }
        String sb = $this$toString_u24lambda_u2d0.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString()");
        return sb;
    }

    /* compiled from: Cookie.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��(\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0010\t\n��\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0003\u001a\u00020��2\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u0003\u001a\u00020��2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u0005\u001a\u00020��2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020��2\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020��J\u000e\u0010\n\u001a\u00020��2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020��2\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020��J\u000e\u0010\u000e\u001a\u00020��2\u0006\u0010\u000e\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n��R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n��R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n��R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n��¨\u0006\u0012"}, m373d2 = {"Lokhttp3/Cookie$Builder;", "", "()V", "domain", "", "expiresAt", "", "hostOnly", "", "httpOnly", "name", "path", "persistent", "secure", "value", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lokhttp3/Cookie;", "hostOnlyDomain", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/Cookie$Builder.class */
    public static final class Builder {
        @Nullable
        private String name;
        @Nullable
        private String value;
        @Nullable
        private String domain;
        private boolean secure;
        private boolean httpOnly;
        private boolean persistent;
        private boolean hostOnly;
        private long expiresAt = dates.MAX_DATE;
        @NotNull
        private String path = "/";

        @NotNull
        public final Builder name(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            Builder $this$name_u24lambda_u2d1 = this;
            if (!Intrinsics.areEqual(StringsKt.trim((CharSequence) name).toString(), name)) {
                throw new IllegalArgumentException("name is not trimmed".toString());
            }
            $this$name_u24lambda_u2d1.name = name;
            return this;
        }

        @NotNull
        public final Builder value(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Builder $this$value_u24lambda_u2d3 = this;
            if (!Intrinsics.areEqual(StringsKt.trim((CharSequence) value).toString(), value)) {
                throw new IllegalArgumentException("value is not trimmed".toString());
            }
            $this$value_u24lambda_u2d3.value = value;
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: long */
        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final Builder expiresAt(long expiresAt) {
            Builder $this$expiresAt_u24lambda_u2d4 = this;
            char c = expiresAt;
            int i = (c > 0 ? 1 : (c == 0 ? 0 : -1));
            long expiresAt2 = c;
            if (i <= 0) {
                expiresAt2 = Long.MIN_VALUE;
            }
            int i2 = (expiresAt2 > dates.MAX_DATE ? 1 : (expiresAt2 == dates.MAX_DATE ? 0 : -1));
            long expiresAt3 = expiresAt2;
            if (i2 > 0) {
                expiresAt3 = dates.MAX_DATE;
            }
            $this$expiresAt_u24lambda_u2d4.expiresAt = expiresAt3 == 1 ? 1 : 0;
            $this$expiresAt_u24lambda_u2d4.persistent = true;
            return this;
        }

        @NotNull
        public final Builder domain(@NotNull String domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            return domain(domain, false);
        }

        @NotNull
        public final Builder hostOnlyDomain(@NotNull String domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            return domain(domain, true);
        }

        private final Builder domain(String domain, boolean hostOnly) {
            Builder $this$domain_u24lambda_u2d5 = this;
            String canonicalDomain = hostnames.toCanonicalHost(domain);
            if (canonicalDomain == null) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected domain: ", domain));
            }
            $this$domain_u24lambda_u2d5.domain = canonicalDomain;
            $this$domain_u24lambda_u2d5.hostOnly = hostOnly;
            return this;
        }

        @NotNull
        public final Builder path(@NotNull String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            Builder $this$path_u24lambda_u2d7 = this;
            if (!StringsKt.startsWith$default(path, "/", false, 2, (Object) null)) {
                throw new IllegalArgumentException("path must start with '/'".toString());
            }
            $this$path_u24lambda_u2d7.path = path;
            return this;
        }

        @NotNull
        public final Builder secure() {
            this.secure = true;
            return this;
        }

        @NotNull
        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        @NotNull
        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
            }
            throw new NullPointerException("builder.domain == null");
        }
    }

    /* compiled from: Cookie.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��L\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n��\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J'\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH��¢\u0006\u0002\b\u001bJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0007J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0002J \u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\fH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n��R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n��R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n��R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n��¨\u0006&"}, m373d2 = {"Lokhttp3/Cookie$Companion;", "", "()V", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "dateCharacterOffset", "", "input", "", "pos", "limit", "invert", "", "domainMatch", "urlHost", "domain", "parse", "Lokhttp3/Cookie;", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "parse$okhttp", "parseAll", "", "headers", "Lokhttp3/Headers;", "parseDomain", "s", "parseExpires", "parseMaxAge", "pathMatch", "path", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/Cookie$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean domainMatch(String urlHost, String domain) {
            if (Intrinsics.areEqual(urlHost, domain)) {
                return true;
            }
            return StringsKt.endsWith$default(urlHost, domain, false, 2, (Object) null) && urlHost.charAt((urlHost.length() - domain.length()) - 1) == '.' && !Util.canParseAsIpAddress(urlHost);
        }

        /* access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl url, String path) {
            String urlPath = url.encodedPath();
            if (Intrinsics.areEqual(urlPath, path)) {
                return true;
            }
            if (StringsKt.startsWith$default(urlPath, path, false, 2, (Object) null)) {
                return StringsKt.endsWith$default(path, "/", false, 2, (Object) null) || urlPath.charAt(path.length()) == '/';
            }
            return false;
        }

        @JvmStatic
        @Nullable
        public final Cookie parse(@NotNull HttpUrl url, @NotNull String setCookie) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
            jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:28:0x00f0
            	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:232)
            	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:54)
            */
        @org.jetbrains.annotations.Nullable
        public final okhttp3.Cookie parse$okhttp(long r15, @org.jetbrains.annotations.NotNull okhttp3.HttpUrl r17, @org.jetbrains.annotations.NotNull java.lang.String r18) {
            /*
            // Method dump skipped, instructions count: 625
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.parse$okhttp(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
        }

        private final long parseExpires(String s, int pos, int limit) {
            int pos2 = dateCharacterOffset(s, pos, limit, false);
            int hour = -1;
            int minute = -1;
            int second = -1;
            int dayOfMonth = -1;
            int month = -1;
            int year = -1;
            Matcher matcher = Cookie.TIME_PATTERN.matcher(s);
            while (pos2 < limit) {
                int end = dateCharacterOffset(s, pos2 + 1, limit, true);
                matcher.region(pos2, end);
                if (hour == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group, "matcher.group(1)");
                    hour = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(group2, "matcher.group(2)");
                    minute = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue(group3, "matcher.group(3)");
                    second = Integer.parseInt(group3);
                } else if (dayOfMonth == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group4, "matcher.group(1)");
                    dayOfMonth = Integer.parseInt(group4);
                } else if (month == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group5 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(locale, "US");
                    String monthString = group5.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(monthString, "this as java.lang.String).toLowerCase(locale)");
                    String pattern = Cookie.MONTH_PATTERN.pattern();
                    Intrinsics.checkNotNullExpressionValue(pattern, "MONTH_PATTERN.pattern()");
                    month = StringsKt.indexOf$default((CharSequence) pattern, monthString, 0, false, 6, (Object) null) / 4;
                } else if (year == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String group6 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group6, "matcher.group(1)");
                    year = Integer.parseInt(group6);
                }
                pos2 = dateCharacterOffset(s, end + 1, limit, false);
            }
            if (70 <= year ? year < 100 : false) {
                year += 1900;
            }
            if (0 <= year ? year < 70 : false) {
                year += PacketOpcodes.SetCoopChapterViewedRsp;
            }
            if (!(year >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(month != -1)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(1 <= dayOfMonth ? dayOfMonth < 32 : false)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(0 <= hour ? hour < 24 : false)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(0 <= minute ? minute < 60 : false)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(0 <= second ? second < 60 : false)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar $this$parseExpires_u24lambda_u2d0 = new GregorianCalendar(Util.UTC);
            $this$parseExpires_u24lambda_u2d0.setLenient(false);
            $this$parseExpires_u24lambda_u2d0.set(1, year);
            $this$parseExpires_u24lambda_u2d0.set(2, month - 1);
            $this$parseExpires_u24lambda_u2d0.set(5, dayOfMonth);
            $this$parseExpires_u24lambda_u2d0.set(11, hour);
            $this$parseExpires_u24lambda_u2d0.set(12, minute);
            $this$parseExpires_u24lambda_u2d0.set(13, second);
            $this$parseExpires_u24lambda_u2d0.set(14, 0);
            return $this$parseExpires_u24lambda_u2d0.getTimeInMillis();
        }

        /* JADX WARNING: Removed duplicated region for block: B:41:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0098 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final int dateCharacterOffset(java.lang.String r4, int r5, int r6, boolean r7) {
            /*
                r3 = this;
                r0 = r5
                r8 = r0
            L_0x0003:
                r0 = r8
                r1 = r6
                if (r0 >= r1) goto L_0x009b
                r0 = r8
                r9 = r0
                int r8 = r8 + 1
                r0 = r4
                r1 = r9
                char r0 = r0.charAt(r1)
                r10 = r0
                r0 = r10
                r1 = 32
                if (r0 >= r1) goto L_0x0026
                r0 = r10
                r1 = 9
                if (r0 != r1) goto L_0x0082
            L_0x0026:
                r0 = r10
                r1 = 127(0x7f, float:1.78E-43)
                if (r0 >= r1) goto L_0x0082
                r0 = r10
                r1 = 57
                if (r0 > r1) goto L_0x0043
                r0 = 48
                r1 = r10
                if (r0 > r1) goto L_0x003f
                r0 = 1
                goto L_0x0044
            L_0x003f:
                r0 = 0
                goto L_0x0044
            L_0x0043:
                r0 = 0
            L_0x0044:
                if (r0 != 0) goto L_0x0082
                r0 = r10
                r1 = 122(0x7a, float:1.71E-43)
                if (r0 > r1) goto L_0x005d
                r0 = 97
                r1 = r10
                if (r0 > r1) goto L_0x0059
                r0 = 1
                goto L_0x005e
            L_0x0059:
                r0 = 0
                goto L_0x005e
            L_0x005d:
                r0 = 0
            L_0x005e:
                if (r0 != 0) goto L_0x0082
                r0 = r10
                r1 = 90
                if (r0 > r1) goto L_0x0077
                r0 = 65
                r1 = r10
                if (r0 > r1) goto L_0x0073
                r0 = 1
                goto L_0x0078
            L_0x0073:
                r0 = 0
                goto L_0x0078
            L_0x0077:
                r0 = 0
            L_0x0078:
                if (r0 != 0) goto L_0x0082
                r0 = r10
                r1 = 58
                if (r0 != r1) goto L_0x0086
            L_0x0082:
                r0 = 1
                goto L_0x0087
            L_0x0086:
                r0 = 0
            L_0x0087:
                r11 = r0
                r0 = r11
                r1 = r7
                if (r1 != 0) goto L_0x0094
                r1 = 1
                goto L_0x0095
            L_0x0094:
                r1 = 0
            L_0x0095:
                if (r0 != r1) goto L_0x0003
                r0 = r9
                return r0
            L_0x009b:
                r0 = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.dateCharacterOffset(java.lang.String, int, int, boolean):int");
        }

        private final long parseMaxAge(String s) {
            try {
                long parsed = Long.parseLong(s);
                if (parsed <= 0) {
                    return Long.MIN_VALUE;
                }
                return parsed;
            } catch (NumberFormatException e) {
                if (!new Regex("-?\\d+").matches(s)) {
                    throw e;
                } else if (StringsKt.startsWith$default(s, "-", false, 2, (Object) null)) {
                    return Long.MIN_VALUE;
                } else {
                    return LongCompanionObject.MAX_VALUE;
                }
            }
        }

        private final String parseDomain(String s) {
            if (!(!StringsKt.endsWith$default(s, Mapper.IGNORED_FIELDNAME, false, 2, (Object) null))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            String canonicalHost = hostnames.toCanonicalHost(StringsKt.removePrefix(s, (CharSequence) Mapper.IGNORED_FIELDNAME));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        @JvmStatic
        @NotNull
        public final List<Cookie> parseAll(@NotNull HttpUrl url, @NotNull Headers headers) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            List cookieStrings = headers.values("Set-Cookie");
            List cookies = null;
            int i = 0;
            int size = cookieStrings.size();
            while (i < size) {
                i++;
                Cookie cookie = parse(url, cookieStrings.get(i));
                if (cookie != null) {
                    if (cookies == null) {
                        cookies = new ArrayList();
                    }
                    cookies.add(cookie);
                }
            }
            if (cookies == null) {
                return CollectionsKt.emptyList();
            }
            List<Cookie> unmodifiableList = Collections.unmodifiableList(cookies);
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return unmodifiableList;
        }
    }
}
