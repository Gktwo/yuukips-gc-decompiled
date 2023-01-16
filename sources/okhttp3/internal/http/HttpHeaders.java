package okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jline.builtins.Tmux;

/* compiled from: HttpHeaders.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��R\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n��\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\n\u0010\r\u001a\u00020\u0004*\u00020\u0006\u001a\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H\u0002\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\f*\u00020\u0010H\u0002\u001a\u000e\u0010\u0014\u001a\u0004\u0018\u00010\f*\u00020\u0010H\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u000f*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n\u001a\f\u0010\u001a\u001a\u00020\u0004*\u00020\u0010H\u0002\u001a\u0014\u0010\u001b\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\"\u000e\u0010��\u001a\u00020\u0001X\u0004¢\u0006\u0002\n��\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n��¨\u0006\u001e"}, m373d2 = {"QUOTED_STRING_DELIMITERS", "Lokio/ByteString;", "TOKEN_DELIMITERS", "hasBody", "", "response", "Lokhttp3/Response;", "parseChallenges", "", "Lokhttp3/Challenge;", "Lokhttp3/Headers;", "headerName", "", "promisesBody", "readChallengeHeader", "", "Lokio/Buffer;", "result", "", "readQuotedString", "readToken", "receiveHeaders", "Lokhttp3/CookieJar;", "url", "Lokhttp3/HttpUrl;", "headers", "skipCommasAndWhitespace", "startsWith", Tmux.OPT_PREFIX, "", "okhttp"})
@JvmName(name = "HttpHeaders")
/* loaded from: grasscutter.jar:okhttp3/internal/http/HttpHeaders.class */
public final class HttpHeaders {
    @NotNull
    private static final ByteString QUOTED_STRING_DELIMITERS = ByteString.Companion.encodeUtf8("\"\\");
    @NotNull
    private static final ByteString TOKEN_DELIMITERS = ByteString.Companion.encodeUtf8("\t ,=");

    @NotNull
    public static final List<Challenge> parseChallenges(@NotNull Headers $this$parseChallenges, @NotNull String headerName) {
        Intrinsics.checkNotNullParameter($this$parseChallenges, "<this>");
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        List result = new ArrayList();
        int h = 0;
        int size = $this$parseChallenges.size();
        while (h < size) {
            h++;
            if (StringsKt.equals(headerName, $this$parseChallenges.name(h), true)) {
                try {
                    readChallengeHeader(new Buffer().writeUtf8($this$parseChallenges.value(h)), result);
                } catch (EOFException e) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e);
                }
            }
        }
        return result;
    }

    private static final void readChallengeHeader(Buffer $this$readChallengeHeader, List<Challenge> list) throws EOFException {
        String peek = null;
        while (true) {
            if (peek == null) {
                skipCommasAndWhitespace($this$readChallengeHeader);
                peek = readToken($this$readChallengeHeader);
                if (peek == null) {
                    return;
                }
            }
            boolean commaPrefixed = skipCommasAndWhitespace($this$readChallengeHeader);
            peek = readToken($this$readChallengeHeader);
            if (peek != null) {
                int eqCount = Util.skipAll($this$readChallengeHeader, (byte) 61);
                boolean commaSuffixed = skipCommasAndWhitespace($this$readChallengeHeader);
                if (commaPrefixed || (!commaSuffixed && !$this$readChallengeHeader.exhausted())) {
                    Map parameters = new LinkedHashMap();
                    int eqCount2 = eqCount + Util.skipAll($this$readChallengeHeader, (byte) 61);
                    while (true) {
                        if (peek == null) {
                            peek = readToken($this$readChallengeHeader);
                            if (skipCommasAndWhitespace($this$readChallengeHeader)) {
                                break;
                            }
                            eqCount2 = Util.skipAll($this$readChallengeHeader, (byte) 61);
                        }
                        if (eqCount2 == 0) {
                            break;
                        } else if (eqCount2 <= 1 && !skipCommasAndWhitespace($this$readChallengeHeader)) {
                            String parameterValue = startsWith($this$readChallengeHeader, (byte) 34) ? readQuotedString($this$readChallengeHeader) : readToken($this$readChallengeHeader);
                            if (parameterValue != null) {
                                String replaced = (String) parameters.put(peek, parameterValue);
                                peek = null;
                                if (replaced == null) {
                                    if (!skipCommasAndWhitespace($this$readChallengeHeader) && !$this$readChallengeHeader.exhausted()) {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    list.add(new Challenge(peek, parameters));
                } else {
                    Map singletonMap = Collections.singletonMap(null, Intrinsics.stringPlus(peek, StringsKt.repeat("=", eqCount)));
                    Intrinsics.checkNotNullExpressionValue(singletonMap, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
                    list.add(new Challenge(peek, singletonMap));
                    peek = null;
                }
            } else if ($this$readChallengeHeader.exhausted()) {
                list.add(new Challenge(peek, MapsKt.emptyMap()));
                return;
            } else {
                return;
            }
        }
    }

    private static final boolean skipCommasAndWhitespace(Buffer $this$skipCommasAndWhitespace) {
        boolean commaFound = false;
        while (!$this$skipCommasAndWhitespace.exhausted()) {
            byte b = $this$skipCommasAndWhitespace.getByte(0);
            if (b != 44) {
                if (!(b == 32 ? true : b == 9)) {
                    break;
                }
                $this$skipCommasAndWhitespace.readByte();
            } else {
                $this$skipCommasAndWhitespace.readByte();
                commaFound = true;
            }
        }
        return commaFound;
    }

    private static final boolean startsWith(Buffer $this$startsWith, byte prefix) {
        return !$this$startsWith.exhausted() && $this$startsWith.getByte(0) == prefix;
    }

    private static final String readQuotedString(Buffer $this$readQuotedString) throws EOFException {
        if (!($this$readQuotedString.readByte() == 34)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Buffer result = new Buffer();
        while (true) {
            long i = $this$readQuotedString.indexOfElement(QUOTED_STRING_DELIMITERS);
            if (i == -1) {
                return null;
            }
            if ($this$readQuotedString.getByte(i) == 34) {
                result.write($this$readQuotedString, i);
                $this$readQuotedString.readByte();
                return result.readUtf8();
            } else if ($this$readQuotedString.size() == i + 1) {
                return null;
            } else {
                result.write($this$readQuotedString, i);
                $this$readQuotedString.readByte();
                result.write($this$readQuotedString, 1L);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    private static final String readToken(Buffer $this$readToken) {
        char indexOfElement = $this$readToken.indexOfElement(TOKEN_DELIMITERS);
        int i = (indexOfElement > -1 ? 1 : (indexOfElement == -1 ? 0 : -1));
        long tokenSize = indexOfElement;
        if (i == 0) {
            tokenSize = $this$readToken.size();
        }
        if ((tokenSize == 1 ? 1 : 0) != 0) {
            return $this$readToken.readUtf8(tokenSize);
        }
        return null;
    }

    public static final void receiveHeaders(@NotNull CookieJar $this$receiveHeaders, @NotNull HttpUrl url, @NotNull Headers headers) {
        Intrinsics.checkNotNullParameter($this$receiveHeaders, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if ($this$receiveHeaders != CookieJar.NO_COOKIES) {
            List cookies = Cookie.Companion.parseAll(url, headers);
            if (!cookies.isEmpty()) {
                $this$receiveHeaders.saveFromResponse(url, cookies);
            }
        }
    }

    public static final boolean promisesBody(@NotNull Response $this$promisesBody) {
        Intrinsics.checkNotNullParameter($this$promisesBody, "<this>");
        if (Intrinsics.areEqual($this$promisesBody.request().method(), "HEAD")) {
            return false;
        }
        int responseCode = $this$promisesBody.code();
        if (((responseCode >= 100 && responseCode < 200) || responseCode == 204 || responseCode == 304) && Util.headersContentLength($this$promisesBody) == -1 && !StringsKt.equals("chunked", Response.header$default($this$promisesBody, "Transfer-Encoding", null, 2, null), true)) {
            return false;
        }
        return true;
    }

    @Deprecated(message = "No longer supported", replaceWith = @ReplaceWith(expression = "response.promisesBody()", imports = {}), level = DeprecationLevel.ERROR)
    public static final boolean hasBody(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return promisesBody(response);
    }
}
