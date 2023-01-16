package okhttp3;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import dev.morphia.mapping.Mapper;
import emu.grasscutter.net.packet.PacketOpcodes;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.internal.progressionUtil;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.hostnames;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import org.eclipse.jetty.util.URIUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import org.quartz.jobs.p027ee.mail.SendMailJob;
import org.slf4j.Marker;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: HttpUrl.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��H\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n��\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018�� J2\u00020\u0001:\u0002IJBa\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b!J\r\u0010\u0011\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\"J\r\u0010\u0012\u001a\u00020\u0003H\u0007¢\u0006\u0002\b#J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\b$J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b%J\r\u0010\u0016\u001a\u00020\u0003H\u0007¢\u0006\u0002\b&J\u0013\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0002J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b)J\b\u0010*\u001a\u00020\bH\u0016J\r\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0002\b+J\u0006\u0010,\u001a\u00020-J\u0010\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\b/J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\b0J\r\u0010\u001a\u001a\u00020\bH\u0007¢\u0006\u0002\b1J\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b2J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b3J\u0010\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u00105\u001a\u00020\u0003J\u000e\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\bJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0007¢\u0006\u0002\b8J\u0010\u00109\u001a\u0004\u0018\u00010\u00032\u0006\u00107\u001a\u00020\bJ\u0016\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u00105\u001a\u00020\u0003J\r\u0010 \u001a\u00020\bH\u0007¢\u0006\u0002\b;J\u0006\u0010<\u001a\u00020\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010��2\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b>J\b\u0010?\u001a\u00020\u0003H\u0016J\r\u0010@\u001a\u00020AH\u0007¢\u0006\u0002\bBJ\r\u0010C\u001a\u00020DH\u0007¢\u0006\u0002\b\rJ\b\u0010E\u001a\u0004\u0018\u00010\u0003J\r\u0010B\u001a\u00020AH\u0007¢\u0006\u0002\bFJ\r\u0010\r\u001a\u00020DH\u0007¢\u0006\u0002\bGJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\bHR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\f\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n��\u001a\u0004\b\u0017\u0010\u0019R\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0010R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0007¢\u0006\b\n��\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nX\u0004¢\u0006\u0002\n��R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0011\u0010 \u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b \u0010\u001bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0002\u0010\u0010R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0004\u0010\u0010¨\u0006K"}, m373d2 = {"Lokhttp3/HttpUrl;", "", "scheme", "", SendMailJob.PROP_USERNAME, "password", "host", "port", "", "pathSegments", "", "queryNamesAndValues", "fragment", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "encodedFragment", "()Ljava/lang/String;", "encodedPassword", "encodedPath", "encodedPathSegments", "()Ljava/util/List;", "encodedQuery", "encodedUsername", "isHttps", "", "()Z", "pathSize", "()I", "query", "queryParameterNames", "", "()Ljava/util/Set;", "querySize", "-deprecated_encodedFragment", "-deprecated_encodedPassword", "-deprecated_encodedPath", "-deprecated_encodedPathSegments", "-deprecated_encodedQuery", "-deprecated_encodedUsername", "equals", "other", "-deprecated_fragment", "hashCode", "-deprecated_host", "newBuilder", "Lokhttp3/HttpUrl$Builder;", "link", "-deprecated_password", "-deprecated_pathSegments", "-deprecated_pathSize", "-deprecated_port", "-deprecated_query", "queryParameter", "name", "queryParameterName", "index", "-deprecated_queryParameterNames", "queryParameterValue", "queryParameterValues", "-deprecated_querySize", "redact", "resolve", "-deprecated_scheme", Printer.TO_STRING, "toUri", "Ljava/net/URI;", "uri", "toUrl", "Ljava/net/URL;", "topPrivateDomain", "-deprecated_uri", "-deprecated_url", "-deprecated_username", "Builder", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/HttpUrl.class */
public final class HttpUrl {
    @NotNull
    private final String scheme;
    @NotNull
    private final String username;
    @NotNull
    private final String password;
    @NotNull
    private final String host;
    private final int port;
    @NotNull
    private final List<String> pathSegments;
    @Nullable
    private final List<String> queryNamesAndValues;
    @Nullable
    private final String fragment;
    @NotNull
    private final String url;
    private final boolean isHttps;
    @NotNull
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    @NotNull
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    @NotNull
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    @NotNull
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    @NotNull
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    @NotNull
    public static final String FRAGMENT_ENCODE_SET = "";
    @NotNull
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    @JvmStatic
    public static final int defaultPort(@NotNull String scheme) {
        return Companion.defaultPort(scheme);
    }

    @JvmStatic
    @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
    @NotNull
    public static final HttpUrl get(@NotNull String $this$get) {
        return Companion.get($this$get);
    }

    @JvmStatic
    @JvmName(name = "parse")
    @Nullable
    public static final HttpUrl parse(@NotNull String $this$parse) {
        return Companion.parse($this$parse);
    }

    @JvmStatic
    @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
    @Nullable
    public static final HttpUrl get(@NotNull URL $this$get) {
        return Companion.get($this$get);
    }

    @JvmStatic
    @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
    @Nullable
    public static final HttpUrl get(@NotNull URI $this$get) {
        return Companion.get($this$get);
    }

    public HttpUrl(@NotNull String scheme, @NotNull String username, @NotNull String password, @NotNull String host, int port, @NotNull List<String> list, @Nullable List<String> list2, @Nullable String fragment, @NotNull String url) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(username, SendMailJob.PROP_USERNAME);
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(list, "pathSegments");
        Intrinsics.checkNotNullParameter(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = fragment;
        this.url = url;
        this.isHttps = Intrinsics.areEqual(this.scheme, URIUtil.HTTPS);
    }

    @JvmName(name = "scheme")
    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @JvmName(name = SendMailJob.PROP_USERNAME)
    @NotNull
    public final String username() {
        return this.username;
    }

    @JvmName(name = "password")
    @NotNull
    public final String password() {
        return this.password;
    }

    @JvmName(name = "host")
    @NotNull
    public final String host() {
        return this.host;
    }

    @JvmName(name = "port")
    public final int port() {
        return this.port;
    }

    @JvmName(name = "pathSegments")
    @NotNull
    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    @JvmName(name = "fragment")
    @Nullable
    public final String fragment() {
        return this.fragment;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    @JvmName(name = "url")
    @NotNull
    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @JvmName(name = "uri")
    @NotNull
    public final URI uri() {
        URI uri;
        String uri2 = newBuilder().reencodeForUri$okhttp().toString();
        try {
            uri = new URI(uri2);
        } catch (URISyntaxException e) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(uri2, ""));
                Intrinsics.checkNotNullExpressionValue(create, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                uri = create;
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
        return uri;
    }

    @JvmName(name = "encodedUsername")
    @NotNull
    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int usernameStart = this.scheme.length() + 3;
        String substring = this.url.substring(usernameStart, Util.delimiterOffset(this.url, ":@", usernameStart, this.url.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @JvmName(name = "encodedPassword")
    @NotNull
    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        String substring = this.url.substring(StringsKt.indexOf$default((CharSequence) this.url, ':', this.scheme.length() + 3, false, 4, (Object) null) + 1, StringsKt.indexOf$default((CharSequence) this.url, '@', 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @JvmName(name = "pathSize")
    public final int pathSize() {
        return this.pathSegments.size();
    }

    @JvmName(name = "encodedPath")
    @NotNull
    public final String encodedPath() {
        int pathStart = StringsKt.indexOf$default((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String substring = this.url.substring(pathStart, Util.delimiterOffset(this.url, "?#", pathStart, this.url.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @JvmName(name = "encodedPathSegments")
    @NotNull
    public final List<String> encodedPathSegments() {
        int pathStart = StringsKt.indexOf$default((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        int pathEnd = Util.delimiterOffset(this.url, "?#", pathStart, this.url.length());
        List result = new ArrayList();
        int i = pathStart;
        while (i < pathEnd) {
            int i2 = i + 1;
            int segmentEnd = Util.delimiterOffset(this.url, '/', i2, pathEnd);
            String substring = this.url.substring(i2, segmentEnd);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            result.add(substring);
            i = segmentEnd;
        }
        return result;
    }

    @JvmName(name = "encodedQuery")
    @Nullable
    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int queryStart = StringsKt.indexOf$default((CharSequence) this.url, '?', 0, false, 6, (Object) null) + 1;
        String substring = this.url.substring(queryStart, Util.delimiterOffset(this.url, '#', queryStart, this.url.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @JvmName(name = "query")
    @Nullable
    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, result);
        return result.toString();
    }

    @JvmName(name = "querySize")
    public final int querySize() {
        if (this.queryNamesAndValues != null) {
            return this.queryNamesAndValues.size() / 2;
        }
        return 0;
    }

    @Nullable
    public final String queryParameter(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.queryNamesAndValues == null) {
            return null;
        }
        IntProgression step = RangesKt.step(RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || i > last) && (step2 >= 0 || last > i)) {
            return null;
        }
        do {
            i += step2;
            if (Intrinsics.areEqual(name, this.queryNamesAndValues.get(i))) {
                return this.queryNamesAndValues.get(i + 1);
            }
        } while (i != last);
        return null;
    }

    @JvmName(name = "queryParameterNames")
    @NotNull
    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return SetsKt.emptySet();
        }
        LinkedHashSet result = new LinkedHashSet();
        IntProgression step = RangesKt.step(RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || i > last) && (step2 >= 0 || last > i)) {
            Set<String> unmodifiableSet = Collections.unmodifiableSet(result);
            Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(result)");
            return unmodifiableSet;
        }
        do {
            i += step2;
            String str = this.queryNamesAndValues.get(i);
            Intrinsics.checkNotNull(str);
            result.add(str);
        } while (i != last);
        Set<String> unmodifiableSet = Collections.unmodifiableSet(result);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(result)");
        return unmodifiableSet;
    }

    @NotNull
    public final List<String> queryParameterValues(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.queryNamesAndValues == null) {
            return CollectionsKt.emptyList();
        }
        List result = new ArrayList();
        IntProgression step = RangesKt.step(RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || i > last) && (step2 >= 0 || last > i)) {
            List<String> unmodifiableList = Collections.unmodifiableList(result);
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(result)");
            return unmodifiableList;
        }
        do {
            i += step2;
            if (Intrinsics.areEqual(name, this.queryNamesAndValues.get(i))) {
                result.add(this.queryNamesAndValues.get(i + 1));
            }
        } while (i != last);
        List<String> unmodifiableList = Collections.unmodifiableList(result);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(result)");
        return unmodifiableList;
    }

    @NotNull
    public final String queryParameterName(int index) {
        if (this.queryNamesAndValues == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = this.queryNamesAndValues.get(index * 2);
        Intrinsics.checkNotNull(str);
        return str;
    }

    @Nullable
    public final String queryParameterValue(int index) {
        if (this.queryNamesAndValues != null) {
            return this.queryNamesAndValues.get((index * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    @JvmName(name = "encodedFragment")
    @Nullable
    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String substring = this.url.substring(StringsKt.indexOf$default((CharSequence) this.url, '#', 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @NotNull
    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        Intrinsics.checkNotNull(newBuilder);
        return newBuilder.username("").password("").build().toString();
    }

    @Nullable
    public final HttpUrl resolve(@NotNull String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        Builder newBuilder = newBuilder(link);
        if (newBuilder == null) {
            return null;
        }
        return newBuilder.build();
    }

    @NotNull
    public final Builder newBuilder() {
        Builder result = new Builder();
        result.setScheme$okhttp(this.scheme);
        result.setEncodedUsername$okhttp(encodedUsername());
        result.setEncodedPassword$okhttp(encodedPassword());
        result.setHost$okhttp(this.host);
        result.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        result.getEncodedPathSegments$okhttp().clear();
        result.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        result.encodedQuery(encodedQuery());
        result.setEncodedFragment$okhttp(encodedFragment());
        return result;
    }

    @Nullable
    public final Builder newBuilder(@NotNull String link) {
        Builder builder;
        Intrinsics.checkNotNullParameter(link, "link");
        try {
            builder = new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException e) {
            builder = null;
        }
        return builder;
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof HttpUrl) && Intrinsics.areEqual(((HttpUrl) other).url, this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return this.url;
    }

    @Nullable
    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    @Deprecated(message = "moved to toUrl()", replaceWith = @ReplaceWith(expression = "toUrl()", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_url")
    @NotNull
    /* renamed from: -deprecated_url  reason: not valid java name */
    public final URL m9207deprecated_url() {
        return url();
    }

    @Deprecated(message = "moved to toUri()", replaceWith = @ReplaceWith(expression = "toUri()", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_uri")
    @NotNull
    /* renamed from: -deprecated_uri  reason: not valid java name */
    public final URI m9208deprecated_uri() {
        return uri();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_scheme")
    @NotNull
    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m9209deprecated_scheme() {
        return this.scheme;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedUsername", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_encodedUsername")
    @NotNull
    /* renamed from: -deprecated_encodedUsername  reason: not valid java name */
    public final String m9210deprecated_encodedUsername() {
        return encodedUsername();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "username", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_username")
    @NotNull
    /* renamed from: -deprecated_username  reason: not valid java name */
    public final String m9211deprecated_username() {
        return this.username;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPassword", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_encodedPassword")
    @NotNull
    /* renamed from: -deprecated_encodedPassword  reason: not valid java name */
    public final String m9212deprecated_encodedPassword() {
        return encodedPassword();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "password", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_password")
    @NotNull
    /* renamed from: -deprecated_password  reason: not valid java name */
    public final String m9213deprecated_password() {
        return this.password;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "host", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_host")
    @NotNull
    /* renamed from: -deprecated_host  reason: not valid java name */
    public final String m9214deprecated_host() {
        return this.host;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "port", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_port")
    /* renamed from: -deprecated_port  reason: not valid java name */
    public final int m9215deprecated_port() {
        return this.port;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSize", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_pathSize")
    /* renamed from: -deprecated_pathSize  reason: not valid java name */
    public final int m9216deprecated_pathSize() {
        return pathSize();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPath", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_encodedPath")
    @NotNull
    /* renamed from: -deprecated_encodedPath  reason: not valid java name */
    public final String m9217deprecated_encodedPath() {
        return encodedPath();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPathSegments", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_encodedPathSegments")
    @NotNull
    /* renamed from: -deprecated_encodedPathSegments  reason: not valid java name */
    public final List<String> m9218deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSegments", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_pathSegments")
    @NotNull
    /* renamed from: -deprecated_pathSegments  reason: not valid java name */
    public final List<String> m9219deprecated_pathSegments() {
        return this.pathSegments;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedQuery", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_encodedQuery")
    @Nullable
    /* renamed from: -deprecated_encodedQuery  reason: not valid java name */
    public final String m9220deprecated_encodedQuery() {
        return encodedQuery();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "query", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_query")
    @Nullable
    /* renamed from: -deprecated_query  reason: not valid java name */
    public final String m9221deprecated_query() {
        return query();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "querySize", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_querySize")
    /* renamed from: -deprecated_querySize  reason: not valid java name */
    public final int m9222deprecated_querySize() {
        return querySize();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "queryParameterNames", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_queryParameterNames")
    @NotNull
    /* renamed from: -deprecated_queryParameterNames  reason: not valid java name */
    public final Set<String> m9223deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedFragment", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_encodedFragment")
    @Nullable
    /* renamed from: -deprecated_encodedFragment  reason: not valid java name */
    public final String m9224deprecated_encodedFragment() {
        return encodedFragment();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "fragment", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_fragment")
    @Nullable
    /* renamed from: -deprecated_fragment  reason: not valid java name */
    public final String m9225deprecated_fragment() {
        return this.fragment;
    }

    /* compiled from: HttpUrl.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��<\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0017\u0018�� V2\u00020\u0001:\u0001VB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010#\u001a\u00020��2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020��2\u0006\u0010\f\u001a\u00020\u0004J\u0018\u0010&\u001a\u00020��2\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u000e\u0010)\u001a\u00020��2\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020��2\u0006\u0010,\u001a\u00020\u0004J\u0018\u0010+\u001a\u00020��2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020��2\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0006\u00102\u001a\u000203J\b\u00104\u001a\u00020\u001bH\u0002J\u0010\u0010\u0003\u001a\u00020��2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u00105\u001a\u00020��2\u0006\u00105\u001a\u00020\u0004J\u0010\u00106\u001a\u00020��2\b\u00106\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0014\u001a\u00020��2\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u00107\u001a\u00020��2\b\u00107\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0017\u001a\u00020��2\u0006\u0010\u0017\u001a\u00020\u0004J\u0010\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u0010\u0010:\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u001f\u0010;\u001a\u00020��2\b\u0010<\u001a\u0004\u0018\u0001032\u0006\u00109\u001a\u00020\u0004H��¢\u0006\u0002\b=J\u000e\u0010>\u001a\u00020��2\u0006\u0010>\u001a\u00020\u0004J\b\u0010?\u001a\u00020@H\u0002J\u000e\u0010\u001a\u001a\u00020��2\u0006\u0010\u001a\u001a\u00020\u001bJ0\u0010A\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010E\u001a\u00020��2\b\u0010E\u001a\u0004\u0018\u00010\u0004J\r\u0010F\u001a\u00020��H��¢\u0006\u0002\bGJ\u0010\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020\u0004H\u0002J\u000e\u0010J\u001a\u00020��2\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020��2\u0006\u00100\u001a\u00020\u0004J\u000e\u0010L\u001a\u00020��2\u0006\u0010M\u001a\u00020\u001bJ \u0010N\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001bH\u0002J\u000e\u0010 \u001a\u00020��2\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010P\u001a\u00020��2\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0004J\u0018\u0010Q\u001a\u00020��2\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u0016\u0010R\u001a\u00020��2\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0004J\u0018\u0010S\u001a\u00020��2\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\b\u0010T\u001a\u00020\u0004H\u0016J\u000e\u0010U\u001a\u00020��2\u0006\u0010U\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0004¢\u0006\b\n��\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006W"}, m373d2 = {"Lokhttp3/HttpUrl$Builder;", "", "()V", "encodedFragment", "", "getEncodedFragment$okhttp", "()Ljava/lang/String;", "setEncodedFragment$okhttp", "(Ljava/lang/String;)V", "encodedPassword", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "encodedPathSegments", "", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedUsername", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "host", "getHost$okhttp", "setHost$okhttp", "port", "", "getPort$okhttp", "()I", "setPort$okhttp", "(I)V", "scheme", "getScheme$okhttp", "setScheme$okhttp", "addEncodedPathSegment", "encodedPathSegment", "addEncodedPathSegments", "addEncodedQueryParameter", "encodedName", "encodedValue", "addPathSegment", "pathSegment", "addPathSegments", "pathSegments", "alreadyEncoded", "", "addQueryParameter", "name", "value", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lokhttp3/HttpUrl;", "effectivePort", "encodedPath", "encodedQuery", "fragment", "isDot", "input", "isDotDot", "parse", "base", "parse$okhttp", "password", "pop", "", "push", "pos", "limit", "addTrailingSlash", "query", "reencodeForUri", "reencodeForUri$okhttp", "removeAllCanonicalQueryParameters", "canonicalName", "removeAllEncodedQueryParameters", "removeAllQueryParameters", "removePathSegment", "index", "resolvePath", "startPos", "setEncodedPathSegment", "setEncodedQueryParameter", "setPathSegment", "setQueryParameter", Printer.TO_STRING, SendMailJob.PROP_USERNAME, "Companion", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/HttpUrl$Builder.class */
    public static final class Builder {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @Nullable
        private String scheme;
        @Nullable
        private String host;
        @Nullable
        private List<String> encodedQueryNamesAndValues;
        @Nullable
        private String encodedFragment;
        @NotNull
        public static final String INVALID_HOST = "Invalid URL host";
        @NotNull
        private String encodedUsername = "";
        @NotNull
        private String encodedPassword = "";
        private int port = -1;
        @NotNull
        private final List<String> encodedPathSegments = new ArrayList();

        public Builder() {
            this.encodedPathSegments.add("");
        }

        @Nullable
        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final void setScheme$okhttp(@Nullable String str) {
            this.scheme = str;
        }

        @NotNull
        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final void setEncodedUsername$okhttp(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedUsername = str;
        }

        @NotNull
        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final void setEncodedPassword$okhttp(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedPassword = str;
        }

        @Nullable
        public final String getHost$okhttp() {
            return this.host;
        }

        public final void setHost$okhttp(@Nullable String str) {
            this.host = str;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final void setPort$okhttp(int i) {
            this.port = i;
        }

        @NotNull
        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        @Nullable
        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final void setEncodedQueryNamesAndValues$okhttp(@Nullable List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        @Nullable
        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final void setEncodedFragment$okhttp(@Nullable String str) {
            this.encodedFragment = str;
        }

        @NotNull
        public final Builder scheme(@NotNull String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            Builder $this$scheme_u24lambda_u2d0 = this;
            if (StringsKt.equals(scheme, URIUtil.HTTP, true)) {
                $this$scheme_u24lambda_u2d0.setScheme$okhttp(URIUtil.HTTP);
            } else if (StringsKt.equals(scheme, URIUtil.HTTPS, true)) {
                $this$scheme_u24lambda_u2d0.setScheme$okhttp(URIUtil.HTTPS);
            } else {
                throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected scheme: ", scheme));
            }
            return this;
        }

        @NotNull
        public final Builder username(@NotNull String username) {
            Intrinsics.checkNotNullParameter(username, SendMailJob.PROP_USERNAME);
            setEncodedUsername$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, PacketOpcodes.EnterSceneReadyRsp, null));
            return this;
        }

        @NotNull
        public final Builder encodedUsername(@NotNull String encodedUsername) {
            Intrinsics.checkNotNullParameter(encodedUsername, "encodedUsername");
            setEncodedUsername$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PacketOpcodes.SceneEntityAppearNotify, null));
            return this;
        }

        @NotNull
        public final Builder password(@NotNull String password) {
            Intrinsics.checkNotNullParameter(password, "password");
            setEncodedPassword$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, PacketOpcodes.EnterSceneReadyRsp, null));
            return this;
        }

        @NotNull
        public final Builder encodedPassword(@NotNull String encodedPassword) {
            Intrinsics.checkNotNullParameter(encodedPassword, "encodedPassword");
            setEncodedPassword$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PacketOpcodes.SceneEntityAppearNotify, null));
            return this;
        }

        @NotNull
        public final Builder host(@NotNull String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            Builder $this$host_u24lambda_u2d5 = this;
            String encoded = hostnames.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, host, 0, 0, false, 7, null));
            if (encoded == null) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected host: ", host));
            }
            $this$host_u24lambda_u2d5.setHost$okhttp(encoded);
            return this;
        }

        @NotNull
        public final Builder port(int port) {
            Builder $this$port_u24lambda_u2d7 = this;
            if (!(1 <= port ? port < 65536 : false)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected port: ", Integer.valueOf(port)).toString());
            }
            $this$port_u24lambda_u2d7.setPort$okhttp(port);
            return this;
        }

        private final int effectivePort() {
            if (this.port != -1) {
                return this.port;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            Intrinsics.checkNotNull(str);
            return companion.defaultPort(str);
        }

        @NotNull
        public final Builder addPathSegment(@NotNull String pathSegment) {
            Intrinsics.checkNotNullParameter(pathSegment, "pathSegment");
            push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        @NotNull
        public final Builder addPathSegments(@NotNull String pathSegments) {
            Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        @NotNull
        public final Builder addEncodedPathSegment(@NotNull String encodedPathSegment) {
            Intrinsics.checkNotNullParameter(encodedPathSegment, "encodedPathSegment");
            push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        @NotNull
        public final Builder addEncodedPathSegments(@NotNull String encodedPathSegments) {
            Intrinsics.checkNotNullParameter(encodedPathSegments, "encodedPathSegments");
            return addPathSegments(encodedPathSegments, true);
        }

        private final Builder addPathSegments(String pathSegments, boolean alreadyEncoded) {
            Builder $this$addPathSegments_u24lambda_u2d10 = this;
            int offset = 0;
            do {
                int segmentEnd = Util.delimiterOffset(pathSegments, "/\\", offset, pathSegments.length());
                $this$addPathSegments_u24lambda_u2d10.push(pathSegments, offset, segmentEnd, segmentEnd < pathSegments.length(), alreadyEncoded);
                offset = segmentEnd + 1;
            } while (offset <= pathSegments.length());
            return this;
        }

        @NotNull
        public final Builder setPathSegment(int index, @NotNull String pathSegment) {
            Intrinsics.checkNotNullParameter(pathSegment, "pathSegment");
            Builder $this$setPathSegment_u24lambda_u2d12 = this;
            String canonicalPathSegment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, pathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, PacketOpcodes.EnterSceneReadyRsp, null);
            if (!(!$this$setPathSegment_u24lambda_u2d12.isDot(canonicalPathSegment) && !$this$setPathSegment_u24lambda_u2d12.isDotDot(canonicalPathSegment))) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected path segment: ", pathSegment).toString());
            }
            $this$setPathSegment_u24lambda_u2d12.getEncodedPathSegments$okhttp().set(index, canonicalPathSegment);
            return this;
        }

        @NotNull
        public final Builder setEncodedPathSegment(int index, @NotNull String encodedPathSegment) {
            Intrinsics.checkNotNullParameter(encodedPathSegment, "encodedPathSegment");
            Builder $this$setEncodedPathSegment_u24lambda_u2d14 = this;
            String canonicalPathSegment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, PacketOpcodes.SceneEntityAppearNotify, null);
            $this$setEncodedPathSegment_u24lambda_u2d14.getEncodedPathSegments$okhttp().set(index, canonicalPathSegment);
            if (!$this$setEncodedPathSegment_u24lambda_u2d14.isDot(canonicalPathSegment) && !$this$setEncodedPathSegment_u24lambda_u2d14.isDotDot(canonicalPathSegment)) {
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected path segment: ", encodedPathSegment).toString());
        }

        @NotNull
        public final Builder removePathSegment(int index) {
            Builder $this$removePathSegment_u24lambda_u2d15 = this;
            $this$removePathSegment_u24lambda_u2d15.getEncodedPathSegments$okhttp().remove(index);
            if ($this$removePathSegment_u24lambda_u2d15.getEncodedPathSegments$okhttp().isEmpty()) {
                $this$removePathSegment_u24lambda_u2d15.getEncodedPathSegments$okhttp().add("");
            }
            return this;
        }

        @NotNull
        public final Builder encodedPath(@NotNull String encodedPath) {
            Intrinsics.checkNotNullParameter(encodedPath, "encodedPath");
            Builder $this$encodedPath_u24lambda_u2d17 = this;
            if (!StringsKt.startsWith$default(encodedPath, "/", false, 2, (Object) null)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected encodedPath: ", encodedPath).toString());
            }
            $this$encodedPath_u24lambda_u2d17.resolvePath(encodedPath, 0, encodedPath.length());
            return this;
        }

        @NotNull
        public final Builder query(@Nullable String query) {
            List<String> list;
            Builder $this$query_u24lambda_u2d18 = this;
            if (query == null) {
                list = null;
            } else {
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, query, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, PacketOpcodes.SceneInitFinishReq, null);
                list = canonicalize$okhttp$default == null ? null : HttpUrl.Companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
            }
            $this$query_u24lambda_u2d18.setEncodedQueryNamesAndValues$okhttp(list);
            return this;
        }

        @NotNull
        public final Builder encodedQuery(@Nullable String encodedQuery) {
            List<String> list;
            Builder $this$encodedQuery_u24lambda_u2d19 = this;
            if (encodedQuery == null) {
                list = null;
            } else {
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedQuery, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, PacketOpcodes.ExitSceneWeatherAreaNotify, null);
                list = canonicalize$okhttp$default == null ? null : HttpUrl.Companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
            }
            $this$encodedQuery_u24lambda_u2d19.setEncodedQueryNamesAndValues$okhttp(list);
            return this;
        }

        @NotNull
        public final Builder addQueryParameter(@NotNull String name, @Nullable String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Builder $this$addQueryParameter_u24lambda_u2d20 = this;
            if ($this$addQueryParameter_u24lambda_u2d20.getEncodedQueryNamesAndValues$okhttp() == null) {
                $this$addQueryParameter_u24lambda_u2d20.setEncodedQueryNamesAndValues$okhttp(new ArrayList());
            }
            List<String> encodedQueryNamesAndValues$okhttp = $this$addQueryParameter_u24lambda_u2d20.getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.checkNotNull(encodedQueryNamesAndValues$okhttp);
            encodedQueryNamesAndValues$okhttp.add(Companion.canonicalize$okhttp$default(HttpUrl.Companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, PacketOpcodes.SceneInitFinishReq, null));
            List<String> encodedQueryNamesAndValues$okhttp2 = $this$addQueryParameter_u24lambda_u2d20.getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.checkNotNull(encodedQueryNamesAndValues$okhttp2);
            encodedQueryNamesAndValues$okhttp2.add(value == null ? null : Companion.canonicalize$okhttp$default(HttpUrl.Companion, value, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, PacketOpcodes.SceneInitFinishReq, null));
            return this;
        }

        @NotNull
        public final Builder addEncodedQueryParameter(@NotNull String encodedName, @Nullable String encodedValue) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            Builder $this$addEncodedQueryParameter_u24lambda_u2d21 = this;
            if ($this$addEncodedQueryParameter_u24lambda_u2d21.getEncodedQueryNamesAndValues$okhttp() == null) {
                $this$addEncodedQueryParameter_u24lambda_u2d21.setEncodedQueryNamesAndValues$okhttp(new ArrayList());
            }
            List<String> encodedQueryNamesAndValues$okhttp = $this$addEncodedQueryParameter_u24lambda_u2d21.getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.checkNotNull(encodedQueryNamesAndValues$okhttp);
            encodedQueryNamesAndValues$okhttp.add(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, PacketOpcodes.ExitSceneWeatherAreaNotify, null));
            List<String> encodedQueryNamesAndValues$okhttp2 = $this$addEncodedQueryParameter_u24lambda_u2d21.getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.checkNotNull(encodedQueryNamesAndValues$okhttp2);
            encodedQueryNamesAndValues$okhttp2.add(encodedValue == null ? null : Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedValue, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, PacketOpcodes.ExitSceneWeatherAreaNotify, null));
            return this;
        }

        @NotNull
        public final Builder setQueryParameter(@NotNull String name, @Nullable String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Builder $this$setQueryParameter_u24lambda_u2d22 = this;
            $this$setQueryParameter_u24lambda_u2d22.removeAllQueryParameters(name);
            $this$setQueryParameter_u24lambda_u2d22.addQueryParameter(name, value);
            return this;
        }

        @NotNull
        public final Builder setEncodedQueryParameter(@NotNull String encodedName, @Nullable String encodedValue) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            Builder $this$setEncodedQueryParameter_u24lambda_u2d23 = this;
            $this$setEncodedQueryParameter_u24lambda_u2d23.removeAllEncodedQueryParameters(encodedName);
            $this$setEncodedQueryParameter_u24lambda_u2d23.addEncodedQueryParameter(encodedName, encodedValue);
            return this;
        }

        @NotNull
        public final Builder removeAllQueryParameters(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            Builder $this$removeAllQueryParameters_u24lambda_u2d24 = this;
            if ($this$removeAllQueryParameters_u24lambda_u2d24.getEncodedQueryNamesAndValues$okhttp() == null) {
                return $this$removeAllQueryParameters_u24lambda_u2d24;
            }
            $this$removeAllQueryParameters_u24lambda_u2d24.removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, PacketOpcodes.SceneInitFinishReq, null));
            return this;
        }

        @NotNull
        public final Builder removeAllEncodedQueryParameters(@NotNull String encodedName) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            Builder $this$removeAllEncodedQueryParameters_u24lambda_u2d25 = this;
            if ($this$removeAllEncodedQueryParameters_u24lambda_u2d25.getEncodedQueryNamesAndValues$okhttp() == null) {
                return $this$removeAllEncodedQueryParameters_u24lambda_u2d25;
            }
            $this$removeAllEncodedQueryParameters_u24lambda_u2d25.removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, PacketOpcodes.ExitSceneWeatherAreaNotify, null));
            return this;
        }

        private final void removeAllCanonicalQueryParameters(String canonicalName) {
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            int size = list.size() - 2;
            int i = size;
            int progressionLastElement = progressionUtil.getProgressionLastElement(size, 0, -2);
            if (progressionLastElement <= i) {
                do {
                    i -= 2;
                    List<String> list2 = this.encodedQueryNamesAndValues;
                    Intrinsics.checkNotNull(list2);
                    if (Intrinsics.areEqual(canonicalName, list2.get(i))) {
                        List<String> list3 = this.encodedQueryNamesAndValues;
                        Intrinsics.checkNotNull(list3);
                        list3.remove(i + 1);
                        List<String> list4 = this.encodedQueryNamesAndValues;
                        Intrinsics.checkNotNull(list4);
                        list4.remove(i);
                        List<String> list5 = this.encodedQueryNamesAndValues;
                        Intrinsics.checkNotNull(list5);
                        if (list5.isEmpty()) {
                            this.encodedQueryNamesAndValues = null;
                            return;
                        }
                    }
                } while (i != progressionLastElement);
            }
        }

        @NotNull
        public final Builder fragment(@Nullable String fragment) {
            setEncodedFragment$okhttp(fragment == null ? null : Companion.canonicalize$okhttp$default(HttpUrl.Companion, fragment, 0, 0, "", false, false, false, true, null, 187, null));
            return this;
        }

        @NotNull
        public final Builder encodedFragment(@Nullable String encodedFragment) {
            setEncodedFragment$okhttp(encodedFragment == null ? null : Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedFragment, 0, 0, "", true, false, false, true, null, 179, null));
            return this;
        }

        @NotNull
        public final Builder reencodeForUri$okhttp() {
            Builder $this$reencodeForUri_u24lambda_u2d28 = this;
            String host$okhttp = $this$reencodeForUri_u24lambda_u2d28.getHost$okhttp();
            $this$reencodeForUri_u24lambda_u2d28.setHost$okhttp(host$okhttp == null ? null : new Regex("[\"<>^`{|}]").replace(host$okhttp, ""));
            int i = 0;
            int size = $this$reencodeForUri_u24lambda_u2d28.getEncodedPathSegments$okhttp().size();
            while (i < size) {
                i++;
                $this$reencodeForUri_u24lambda_u2d28.getEncodedPathSegments$okhttp().set(i, Companion.canonicalize$okhttp$default(HttpUrl.Companion, $this$reencodeForUri_u24lambda_u2d28.getEncodedPathSegments$okhttp().get(i), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, PacketOpcodes.SceneAvatarStaminaStepRsp, null));
            }
            List encodedQueryNamesAndValues = $this$reencodeForUri_u24lambda_u2d28.getEncodedQueryNamesAndValues$okhttp();
            if (encodedQueryNamesAndValues != null) {
                int i2 = 0;
                int size2 = encodedQueryNamesAndValues.size();
                while (i2 < size2) {
                    i2++;
                    String str = encodedQueryNamesAndValues.get(i2);
                    encodedQueryNamesAndValues.set(i2, str == null ? null : Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null));
                }
            }
            String encodedFragment$okhttp = $this$reencodeForUri_u24lambda_u2d28.getEncodedFragment$okhttp();
            $this$reencodeForUri_u24lambda_u2d28.setEncodedFragment$okhttp(encodedFragment$okhttp == null ? null : Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedFragment$okhttp, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null));
            return this;
        }

        @NotNull
        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(HttpUrl.Companion, this.encodedUsername, 0, 0, false, 7, null);
            String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int effectivePort = effectivePort();
            Iterable<String> $this$map$iv = this.encodedPathSegments;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (String it : $this$map$iv) {
                destination$iv$iv.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, it, 0, 0, false, 7, null));
            }
            ArrayList arrayList2 = (List) destination$iv$iv;
            String str3 = str;
            String str4 = str2;
            int i = effectivePort;
            ArrayList arrayList3 = arrayList2;
            Iterable iterable = this.encodedQueryNamesAndValues;
            if (iterable == null) {
                arrayList = null;
            } else {
                Iterable<String> $this$map$iv2 = iterable;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (String it2 : $this$map$iv2) {
                    destination$iv$iv2.add(it2 == null ? null : Companion.percentDecode$okhttp$default(HttpUrl.Companion, it2, 0, 0, true, 3, null));
                }
                ArrayList arrayList4 = (List) destination$iv$iv2;
                str3 = str3;
                percentDecode$okhttp$default = percentDecode$okhttp$default;
                percentDecode$okhttp$default2 = percentDecode$okhttp$default2;
                str4 = str4;
                i = i;
                arrayList3 = arrayList3;
                arrayList = arrayList4;
            }
            String str5 = this.encodedFragment;
            return new HttpUrl(str3, percentDecode$okhttp$default, percentDecode$okhttp$default2, str4, i, arrayList3, arrayList, str5 == null ? null : Companion.percentDecode$okhttp$default(HttpUrl.Companion, str5, 0, 0, false, 7, null), toString());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x005a, code lost:
            if ((getEncodedPassword$okhttp().length() > 0) != false) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0100, code lost:
            if (r0 != r1.defaultPort(r2)) goto L_0x0103;
         */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
            // Method dump skipped, instructions count: 349
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.toString():java.lang.String");
        }

        @NotNull
        public final Builder parse$okhttp(@Nullable HttpUrl base, @NotNull String input) {
            int c;
            String str;
            Intrinsics.checkNotNullParameter(input, "input");
            int pos = Util.indexOfFirstNonAsciiWhitespace$default(input, 0, 0, 3, null);
            int limit = Util.indexOfLastNonAsciiWhitespace$default(input, pos, 0, 2, null);
            int schemeDelimiterOffset = Companion.schemeDelimiterOffset(input, pos, limit);
            if (schemeDelimiterOffset != -1) {
                if (StringsKt.startsWith(input, "https:", pos, true)) {
                    this.scheme = URIUtil.HTTPS;
                    pos += "https:".length();
                } else if (StringsKt.startsWith(input, "http:", pos, true)) {
                    this.scheme = URIUtil.HTTP;
                    pos += "http:".length();
                } else {
                    StringBuilder append = new StringBuilder().append("Expected URL scheme 'http' or 'https' but was '");
                    String substring = input.substring(0, schemeDelimiterOffset);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    throw new IllegalArgumentException(append.append(substring).append('\'').toString());
                }
            } else if (base != null) {
                this.scheme = base.scheme();
            } else {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Expected URL scheme 'http' or 'https' but no scheme was found for ", input.length() > 6 ? Intrinsics.stringPlus(StringsKt.take(input, 6), "...") : input));
            }
            boolean hasUsername = false;
            boolean hasPassword = false;
            int slashCount = Companion.slashCount(input, pos, limit);
            if (slashCount >= 2 || base == null || !Intrinsics.areEqual(base.scheme(), this.scheme)) {
                int pos2 = pos + slashCount;
                while (true) {
                    int componentDelimiterOffset = Util.delimiterOffset(input, "@/\\?#", pos2, limit);
                    if (componentDelimiterOffset != limit) {
                        c = input.charAt(componentDelimiterOffset);
                    } else {
                        c = -1;
                    }
                    switch (c) {
                        case -1:
                        case 35:
                        case 47:
                        case 63:
                        case 92:
                            int portColonOffset = Companion.portColonOffset(input, pos2, componentDelimiterOffset);
                            if (portColonOffset + 1 < componentDelimiterOffset) {
                                this.host = hostnames.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, input, pos2, portColonOffset, false, 4, null));
                                this.port = Companion.parsePort(input, portColonOffset + 1, componentDelimiterOffset);
                                if (!(this.port != -1)) {
                                    StringBuilder append2 = new StringBuilder().append("Invalid URL port: \"");
                                    String substring2 = input.substring(portColonOffset + 1, componentDelimiterOffset);
                                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                    throw new IllegalArgumentException(append2.append(substring2).append('\"').toString().toString());
                                }
                            } else {
                                this.host = hostnames.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, input, pos2, portColonOffset, false, 4, null));
                                Companion companion = HttpUrl.Companion;
                                String str2 = this.scheme;
                                Intrinsics.checkNotNull(str2);
                                this.port = companion.defaultPort(str2);
                            }
                            if (this.host != null) {
                                pos = componentDelimiterOffset;
                                break;
                            } else {
                                StringBuilder append3 = new StringBuilder().append("Invalid URL host: \"");
                                String substring3 = input.substring(pos2, portColonOffset);
                                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                                throw new IllegalArgumentException(append3.append(substring3).append('\"').toString().toString());
                            }
                        case 64:
                            if (!hasPassword) {
                                int passwordColonOffset = Util.delimiterOffset(input, ':', pos2, componentDelimiterOffset);
                                String canonicalUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, pos2, passwordColonOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PacketOpcodes.ExecuteGadgetLuaRsp, null);
                                if (hasUsername) {
                                    str = this.encodedUsername + "%40" + canonicalUsername;
                                } else {
                                    str = canonicalUsername;
                                }
                                this.encodedUsername = str;
                                if (passwordColonOffset != componentDelimiterOffset) {
                                    hasPassword = true;
                                    this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, passwordColonOffset + 1, componentDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PacketOpcodes.ExecuteGadgetLuaRsp, null);
                                }
                                hasUsername = true;
                            } else {
                                this.encodedPassword += "%40" + Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, pos2, componentDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PacketOpcodes.ExecuteGadgetLuaRsp, null);
                            }
                            pos2 = componentDelimiterOffset + 1;
                            break;
                    }
                }
            } else {
                this.encodedUsername = base.encodedUsername();
                this.encodedPassword = base.encodedPassword();
                this.host = base.host();
                this.port = base.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(base.encodedPathSegments());
                if (pos == limit || input.charAt(pos) == '#') {
                    encodedQuery(base.encodedQuery());
                }
            }
            int pathDelimiterOffset = Util.delimiterOffset(input, "?#", pos, limit);
            resolvePath(input, pos, pathDelimiterOffset);
            int pos3 = pathDelimiterOffset;
            if (pos3 < limit && input.charAt(pos3) == '?') {
                int queryDelimiterOffset = Util.delimiterOffset(input, '#', pos3, limit);
                this.encodedQueryNamesAndValues = HttpUrl.Companion.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, pos3 + 1, queryDelimiterOffset, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, PacketOpcodes.PlatformStartRouteNotify, null));
                pos3 = queryDelimiterOffset;
            }
            if (pos3 < limit && input.charAt(pos3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, pos3 + 1, limit, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        private final void resolvePath(String input, int startPos, int limit) {
            int pos = startPos;
            if (pos != limit) {
                char c = input.charAt(pos);
                if (c == '/' || c == '\\') {
                    this.encodedPathSegments.clear();
                    this.encodedPathSegments.add("");
                    pos++;
                } else {
                    this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
                }
                int i = pos;
                while (i < limit) {
                    int pathSegmentDelimiterOffset = Util.delimiterOffset(input, "/\\", i, limit);
                    boolean segmentHasTrailingSlash = pathSegmentDelimiterOffset < limit;
                    push(input, i, pathSegmentDelimiterOffset, segmentHasTrailingSlash, true);
                    i = pathSegmentDelimiterOffset;
                    if (segmentHasTrailingSlash) {
                        i++;
                    }
                }
            }
        }

        private final void push(String input, int pos, int limit, boolean addTrailingSlash, boolean alreadyEncoded) {
            String segment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, pos, limit, HttpUrl.PATH_SEGMENT_ENCODE_SET, alreadyEncoded, false, false, false, null, PacketOpcodes.ExecuteGadgetLuaRsp, null);
            if (!isDot(segment)) {
                if (isDotDot(segment)) {
                    pop();
                    return;
                }
                if (this.encodedPathSegments.get(this.encodedPathSegments.size() - 1).length() == 0) {
                    this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, segment);
                } else {
                    this.encodedPathSegments.add(segment);
                }
                if (addTrailingSlash) {
                    this.encodedPathSegments.add("");
                }
            }
        }

        private final boolean isDot(String input) {
            return Intrinsics.areEqual(input, Mapper.IGNORED_FIELDNAME) || StringsKt.equals(input, "%2e", true);
        }

        private final boolean isDotDot(String input) {
            return Intrinsics.areEqual(input, CallerDataConverter.DEFAULT_RANGE_DELIMITER) || StringsKt.equals(input, "%2e.", true) || StringsKt.equals(input, ".%2e", true) || StringsKt.equals(input, "%2e%2e", true);
        }

        private final void pop() {
            if (this.encodedPathSegments.remove(this.encodedPathSegments.size() - 1).length() == 0) {
                if (!this.encodedPathSegments.isEmpty()) {
                    this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
                    return;
                }
            }
            this.encodedPathSegments.add("");
        }

        /* compiled from: HttpUrl.kt */
        @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\r"}, m373d2 = {"Lokhttp3/HttpUrl$Builder$Companion;", "", "()V", "INVALID_HOST", "", "parsePort", "", "input", "pos", "limit", "portColonOffset", "schemeDelimiterOffset", "slashCount", "okhttp"})
        /* loaded from: grasscutter.jar:okhttp3/HttpUrl$Builder$Companion.class */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            private Companion() {
            }

            /* access modifiers changed from: private */
            public final int schemeDelimiterOffset(String input, int pos, int limit) {
                boolean z;
                if (limit - pos < 2) {
                    return -1;
                }
                char c0 = input.charAt(pos);
                if ((Intrinsics.compare((int) c0, 97) < 0 || Intrinsics.compare((int) c0, 122) > 0) && (Intrinsics.compare((int) c0, 65) < 0 || Intrinsics.compare((int) c0, 90) > 0)) {
                    return -1;
                }
                int i = pos + 1;
                while (i < limit) {
                    i++;
                    char charAt = input.charAt(i);
                    if ('a' <= charAt ? charAt < '{' : false ? true : 'A' <= charAt ? charAt < '[' : false ? true : '0' <= charAt ? charAt < ':' : false ? true : charAt == '+' ? true : charAt == '-') {
                        z = true;
                        continue;
                    } else if (charAt == '.') {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        if (charAt == ':') {
                            return i;
                        }
                        return -1;
                    }
                }
                return -1;
            }

            /* access modifiers changed from: private */
            public final int slashCount(String $this$slashCount, int pos, int limit) {
                int slashCount = 0;
                int i = pos;
                while (i < limit) {
                    i++;
                    char c = $this$slashCount.charAt(i);
                    if (c != '\\' && c != '/') {
                        break;
                    }
                    slashCount++;
                }
                return slashCount;
            }

            /* access modifiers changed from: private */
            public final int portColonOffset(String input, int pos, int limit) {
                int i = pos;
                while (i < limit) {
                    char charAt = input.charAt(i);
                    if (charAt == '[') {
                        do {
                            i++;
                            if (i < limit) {
                            }
                        } while (input.charAt(i) != ']');
                    } else if (charAt == ':') {
                        return i;
                    }
                    i++;
                }
                return limit;
            }

            /* access modifiers changed from: private */
            public final int parsePort(String input, int pos, int limit) {
                int i;
                boolean z;
                try {
                    int i2 = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, pos, limit, "", false, false, false, false, null, PacketOpcodes.ScenePlayerLocationNotify, null));
                    if (1 <= i2) {
                        z = i2 < 65536;
                    } else {
                        z = false;
                    }
                    i = z ? i2 : -1;
                } catch (NumberFormatException e) {
                    i = -1;
                }
                return i;
            }
        }
    }

    /* compiled from: HttpUrl.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��p\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0010 \n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\b\u0018J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\b\u0018J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0018J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u001cJa\u0010\u001d\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H��¢\u0006\u0002\b(J\u001c\u0010)\u001a\u00020\"*\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J/\u0010*\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\"H��¢\u0006\u0002\b+J\u0011\u0010,\u001a\u00020\u0015*\u00020\u0004H\u0007¢\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u0017H\u0007¢\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u001aH\u0007¢\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u0004H\u0007¢\u0006\u0002\b\u001bJ#\u0010.\u001a\u00020/*\b\u0012\u0004\u0012\u00020\u0004002\n\u00101\u001a\u000602j\u0002`3H��¢\u0006\u0002\b4J\u0019\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000406*\u00020\u0004H��¢\u0006\u0002\b7J%\u00108\u001a\u00020/*\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004002\n\u00101\u001a\u000602j\u0002`3H��¢\u0006\u0002\b9JV\u0010:\u001a\u00020/*\u00020;2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J,\u0010=\u001a\u00020/*\u00020;2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006?"}, m373d2 = {"Lokhttp3/HttpUrl$Companion;", "", "()V", "FORM_ENCODE_SET", "", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "HEX_DIGITS", "", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "defaultPort", "", "scheme", BeanUtil.PREFIX_GETTER_GET, "Lokhttp3/HttpUrl;", "uri", "Ljava/net/URI;", "-deprecated_get", "url", "Ljava/net/URL;", "parse", "-deprecated_parse", "canonicalize", "pos", "limit", "encodeSet", "alreadyEncoded", "", "strict", "plusIsSpace", "unicodeAllowed", "charset", "Ljava/nio/charset/Charset;", "canonicalize$okhttp", "isPercentEncoded", "percentDecode", "percentDecode$okhttp", "toHttpUrl", "toHttpUrlOrNull", "toPathString", "", "", "out", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "toPathString$okhttp", "toQueryNamesAndValues", "", "toQueryNamesAndValues$okhttp", "toQueryString", "toQueryString$okhttp", "writeCanonicalized", "Lokio/Buffer;", "input", "writePercentDecoded", "encoded", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/HttpUrl$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final int defaultPort(@NotNull String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (Intrinsics.areEqual(scheme, URIUtil.HTTP)) {
                return 80;
            }
            if (Intrinsics.areEqual(scheme, URIUtil.HTTPS)) {
                return PacketOpcodes.AddQuestContentProgressReq;
            }
            return -1;
        }

        public final void toPathString$okhttp(@NotNull List<String> list, @NotNull StringBuilder out) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            int i = 0;
            int size = list.size();
            while (i < size) {
                i++;
                out.append('/');
                out.append(list.get(i));
            }
        }

        public final void toQueryString$okhttp(@NotNull List<String> list, @NotNull StringBuilder out) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            IntProgression step = RangesKt.step(RangesKt.until(0, list.size()), 2);
            int i = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && i <= last) || (step2 < 0 && last <= i)) {
                do {
                    i += step2;
                    String name = list.get(i);
                    String value = list.get(i + 1);
                    if (i > 0) {
                        out.append('&');
                    }
                    out.append(name);
                    if (value != null) {
                        out.append('=');
                        out.append(value);
                    }
                } while (i != last);
            }
        }

        @NotNull
        public final List<String> toQueryNamesAndValues$okhttp(@NotNull String $this$toQueryNamesAndValues) {
            Intrinsics.checkNotNullParameter($this$toQueryNamesAndValues, "<this>");
            List result = new ArrayList();
            int pos = 0;
            while (pos <= $this$toQueryNamesAndValues.length()) {
                int ampersandOffset = StringsKt.indexOf$default((CharSequence) $this$toQueryNamesAndValues, '&', pos, false, 4, (Object) null);
                if (ampersandOffset == -1) {
                    ampersandOffset = $this$toQueryNamesAndValues.length();
                }
                int equalsOffset = StringsKt.indexOf$default((CharSequence) $this$toQueryNamesAndValues, '=', pos, false, 4, (Object) null);
                if (equalsOffset == -1 || equalsOffset > ampersandOffset) {
                    String substring = $this$toQueryNamesAndValues.substring(pos, ampersandOffset);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    result.add(substring);
                    result.add(null);
                } else {
                    String substring2 = $this$toQueryNamesAndValues.substring(pos, equalsOffset);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    result.add(substring2);
                    String substring3 = $this$toQueryNamesAndValues.substring(equalsOffset + 1, ampersandOffset);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    result.add(substring3);
                }
                pos = ampersandOffset + 1;
            }
            return result;
        }

        @JvmStatic
        @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
        @NotNull
        public final HttpUrl get(@NotNull String $this$toHttpUrl) {
            Intrinsics.checkNotNullParameter($this$toHttpUrl, "<this>");
            return new Builder().parse$okhttp(null, $this$toHttpUrl).build();
        }

        @JvmStatic
        @JvmName(name = "parse")
        @Nullable
        public final HttpUrl parse(@NotNull String $this$toHttpUrlOrNull) {
            HttpUrl httpUrl;
            Intrinsics.checkNotNullParameter($this$toHttpUrlOrNull, "<this>");
            try {
                httpUrl = get($this$toHttpUrlOrNull);
            } catch (IllegalArgumentException e) {
                httpUrl = null;
            }
            return httpUrl;
        }

        @JvmStatic
        @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
        @Nullable
        public final HttpUrl get(@NotNull URL $this$toHttpUrlOrNull) {
            Intrinsics.checkNotNullParameter($this$toHttpUrlOrNull, "<this>");
            String url = $this$toHttpUrlOrNull.toString();
            Intrinsics.checkNotNullExpressionValue(url, "toString()");
            return parse(url);
        }

        @JvmStatic
        @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
        @Nullable
        public final HttpUrl get(@NotNull URI $this$toHttpUrlOrNull) {
            Intrinsics.checkNotNullParameter($this$toHttpUrlOrNull, "<this>");
            String uri = $this$toHttpUrlOrNull.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "toString()");
            return parse(uri);
        }

        @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrl()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrl"}), level = DeprecationLevel.ERROR)
        @JvmName(name = "-deprecated_get")
        @NotNull
        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m9228deprecated_get(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return get(url);
        }

        @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}), level = DeprecationLevel.ERROR)
        @JvmName(name = "-deprecated_parse")
        @Nullable
        /* renamed from: -deprecated_parse  reason: not valid java name */
        public final HttpUrl m9229deprecated_parse(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return parse(url);
        }

        @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}), level = DeprecationLevel.ERROR)
        @JvmName(name = "-deprecated_get")
        @Nullable
        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m9230deprecated_get(@NotNull URL url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return get(url);
        }

        @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "uri.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}), level = DeprecationLevel.ERROR)
        @JvmName(name = "-deprecated_get")
        @Nullable
        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m9231deprecated_get(@NotNull URI uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return get(uri);
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            return companion.percentDecode$okhttp(str, i, i2, z);
        }

        @NotNull
        public final String percentDecode$okhttp(@NotNull String $this$percentDecode, int pos, int limit, boolean plusIsSpace) {
            Intrinsics.checkNotNullParameter($this$percentDecode, "<this>");
            int i = pos;
            while (i < limit) {
                i++;
                char c = $this$percentDecode.charAt(i);
                if (c == '%' || (c == '+' && plusIsSpace)) {
                    Buffer out = new Buffer();
                    out.writeUtf8($this$percentDecode, pos, i);
                    writePercentDecoded(out, $this$percentDecode, i, limit, plusIsSpace);
                    return out.readUtf8();
                }
            }
            String substring = $this$percentDecode.substring(pos, limit);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        private final void writePercentDecoded(Buffer $this$writePercentDecoded, String encoded, int pos, int limit, boolean plusIsSpace) {
            int i = pos;
            while (i < limit) {
                int codePoint = encoded.codePointAt(i);
                if (codePoint != 37 || i + 2 >= limit) {
                    if (codePoint == 43 && plusIsSpace) {
                        $this$writePercentDecoded.writeByte(32);
                        i++;
                    }
                    $this$writePercentDecoded.writeUtf8CodePoint(codePoint);
                    i += Character.charCount(codePoint);
                } else {
                    int d1 = Util.parseHexDigit(encoded.charAt(i + 1));
                    int d2 = Util.parseHexDigit(encoded.charAt(i + 2));
                    if (!(d1 == -1 || d2 == -1)) {
                        $this$writePercentDecoded.writeByte((d1 << 4) + d2);
                        i = i + 2 + Character.charCount(codePoint);
                    }
                    $this$writePercentDecoded.writeUtf8CodePoint(codePoint);
                    i += Character.charCount(codePoint);
                }
            }
        }

        private final boolean isPercentEncoded(String $this$isPercentEncoded, int pos, int limit) {
            return pos + 2 < limit && $this$isPercentEncoded.charAt(pos) == '%' && Util.parseHexDigit($this$isPercentEncoded.charAt(pos + 1)) != -1 && Util.parseHexDigit($this$isPercentEncoded.charAt(pos + 2)) != -1;
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 8) != 0) {
                z = false;
            }
            if ((i3 & 16) != 0) {
                z2 = false;
            }
            if ((i3 & 32) != 0) {
                z3 = false;
            }
            if ((i3 & 64) != 0) {
                z4 = false;
            }
            if ((i3 & 128) != 0) {
                charset = null;
            }
            return companion.canonicalize$okhttp(str, i, i2, str2, z, z2, z3, z4, charset);
        }

        @NotNull
        public final String canonicalize$okhttp(@NotNull String $this$canonicalize, int pos, int limit, @NotNull String encodeSet, boolean alreadyEncoded, boolean strict, boolean plusIsSpace, boolean unicodeAllowed, @Nullable Charset charset) {
            Intrinsics.checkNotNullParameter($this$canonicalize, "<this>");
            Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
            int i = pos;
            while (i < limit) {
                int codePoint = $this$canonicalize.codePointAt(i);
                if (codePoint < 32 || codePoint == 127 || ((codePoint >= 128 && !unicodeAllowed) || StringsKt.contains$default((CharSequence) encodeSet, (char) codePoint, false, 2, (Object) null) || ((codePoint == 37 && (!alreadyEncoded || (strict && !isPercentEncoded($this$canonicalize, i, limit)))) || (codePoint == 43 && plusIsSpace)))) {
                    Buffer out = new Buffer();
                    out.writeUtf8($this$canonicalize, pos, i);
                    writeCanonicalized(out, $this$canonicalize, i, limit, encodeSet, alreadyEncoded, strict, plusIsSpace, unicodeAllowed, charset);
                    return out.readUtf8();
                }
                i += Character.charCount(codePoint);
            }
            String substring = $this$canonicalize.substring(pos, limit);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        private final void writeCanonicalized(Buffer $this$writeCanonicalized, String input, int pos, int limit, String encodeSet, boolean alreadyEncoded, boolean strict, boolean plusIsSpace, boolean unicodeAllowed, Charset charset) {
            Buffer encodedCharBuffer = null;
            int i = pos;
            while (i < limit) {
                int codePoint = input.codePointAt(i);
                if (!alreadyEncoded || !(codePoint == 9 || codePoint == 10 || codePoint == 12 || codePoint == 13)) {
                    if (codePoint == 43 && plusIsSpace) {
                        $this$writeCanonicalized.writeUtf8(alreadyEncoded ? Marker.ANY_NON_NULL_MARKER : "%2B");
                    } else if (codePoint < 32 || codePoint == 127 || ((codePoint >= 128 && !unicodeAllowed) || StringsKt.contains$default((CharSequence) encodeSet, (char) codePoint, false, 2, (Object) null) || (codePoint == 37 && (!alreadyEncoded || (strict && !isPercentEncoded(input, i, limit)))))) {
                        if (encodedCharBuffer == null) {
                            encodedCharBuffer = new Buffer();
                        }
                        if (charset == null || Intrinsics.areEqual(charset, StandardCharsets.UTF_8)) {
                            encodedCharBuffer.writeUtf8CodePoint(codePoint);
                        } else {
                            encodedCharBuffer.writeString(input, i, i + Character.charCount(codePoint), charset);
                        }
                        while (!encodedCharBuffer.exhausted()) {
                            int b = encodedCharBuffer.readByte() & 255;
                            $this$writeCanonicalized.writeByte(37);
                            $this$writeCanonicalized.writeByte((int) HttpUrl.HEX_DIGITS[(b >> 4) & 15]);
                            $this$writeCanonicalized.writeByte((int) HttpUrl.HEX_DIGITS[b & 15]);
                        }
                    } else {
                        $this$writeCanonicalized.writeUtf8CodePoint(codePoint);
                    }
                }
                i += Character.charCount(codePoint);
            }
        }
    }
}
