package org.eclipse.jetty.http;

import com.google.common.net.HttpHeaders;
import java.nio.ByteBuffer;
import org.eclipse.jetty.util.ArrayTrie;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.Trie;
import org.eclipse.jetty.websocket.api.WebSocketConstants;
import p013io.javalin.core.util.Header;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpHeader.class */
public enum HttpHeader {
    CONNECTION("Connection"),
    CACHE_CONTROL("Cache-Control"),
    DATE("Date"),
    PRAGMA("Pragma"),
    PROXY_CONNECTION("Proxy-Connection"),
    TRAILER("Trailer"),
    TRANSFER_ENCODING("Transfer-Encoding"),
    UPGRADE("Upgrade"),
    VIA("Via"),
    WARNING("Warning"),
    NEGOTIATE("Negotiate"),
    ALLOW("Allow"),
    CONTENT_ENCODING("Content-Encoding"),
    CONTENT_LANGUAGE("Content-Language"),
    CONTENT_LENGTH("Content-Length"),
    CONTENT_LOCATION("Content-Location"),
    CONTENT_MD5(HttpHeaders.CONTENT_MD5),
    CONTENT_RANGE("Content-Range"),
    CONTENT_TYPE("Content-Type"),
    EXPIRES("Expires"),
    LAST_MODIFIED("Last-Modified"),
    ACCEPT("Accept"),
    ACCEPT_CHARSET("Accept-Charset"),
    ACCEPT_ENCODING("Accept-Encoding"),
    ACCEPT_LANGUAGE("Accept-Language"),
    AUTHORIZATION("Authorization"),
    EXPECT("Expect"),
    FORWARDED(HttpHeaders.FORWARDED),
    FROM("From"),
    HOST("Host"),
    IF_MATCH("If-Match"),
    IF_MODIFIED_SINCE("If-Modified-Since"),
    IF_NONE_MATCH("If-None-Match"),
    IF_RANGE("If-Range"),
    IF_UNMODIFIED_SINCE("If-Unmodified-Since"),
    KEEP_ALIVE("Keep-Alive"),
    MAX_FORWARDS("Max-Forwards"),
    PROXY_AUTHORIZATION("Proxy-Authorization"),
    RANGE("Range"),
    REQUEST_RANGE("Request-Range"),
    REFERER("Referer"),
    TE("TE"),
    USER_AGENT("User-Agent"),
    X_FORWARDED_FOR("X-Forwarded-For"),
    X_FORWARDED_PORT(HttpHeaders.X_FORWARDED_PORT),
    X_FORWARDED_PROTO(HttpHeaders.X_FORWARDED_PROTO),
    X_FORWARDED_SERVER("X-Forwarded-Server"),
    X_FORWARDED_HOST(HttpHeaders.X_FORWARDED_HOST),
    ACCEPT_RANGES("Accept-Ranges"),
    AGE("Age"),
    ETAG("ETag"),
    LOCATION("Location"),
    PROXY_AUTHENTICATE("Proxy-Authenticate"),
    RETRY_AFTER("Retry-After"),
    SERVER("Server"),
    SERVLET_ENGINE("Servlet-Engine"),
    VARY("Vary"),
    WWW_AUTHENTICATE("WWW-Authenticate"),
    ORIGIN("Origin"),
    SEC_WEBSOCKET_KEY(Header.SEC_WEBSOCKET_KEY),
    SEC_WEBSOCKET_VERSION(WebSocketConstants.SEC_WEBSOCKET_VERSION),
    SEC_WEBSOCKET_EXTENSIONS(WebSocketConstants.SEC_WEBSOCKET_EXTENSIONS),
    SEC_WEBSOCKET_SUBPROTOCOL("Sec-WebSocket-Protocol"),
    SEC_WEBSOCKET_ACCEPT("Sec-WebSocket-Accept"),
    COOKIE("Cookie"),
    SET_COOKIE("Set-Cookie"),
    SET_COOKIE2(HttpHeaders.SET_COOKIE2),
    MIME_VERSION("MIME-Version"),
    IDENTITY("identity"),
    X_POWERED_BY(HttpHeaders.X_POWERED_BY),
    HTTP2_SETTINGS(HttpHeaders.HTTP2_SETTINGS),
    STRICT_TRANSPORT_SECURITY("Strict-Transport-Security"),
    C_METHOD(okhttp3.internal.http2.Header.TARGET_METHOD_UTF8, true),
    C_SCHEME(okhttp3.internal.http2.Header.TARGET_SCHEME_UTF8, true),
    C_AUTHORITY(okhttp3.internal.http2.Header.TARGET_AUTHORITY_UTF8, true),
    C_PATH(okhttp3.internal.http2.Header.TARGET_PATH_UTF8, true),
    C_STATUS(okhttp3.internal.http2.Header.RESPONSE_STATUS_UTF8, true),
    UNKNOWN("::UNKNOWN::", true);
    
    public static final Trie<HttpHeader> CACHE = new ArrayTrie(630);
    private final String _string;
    private final String _lowerCase;
    private final byte[] _bytes;
    private final byte[] _bytesColonSpace;
    private final ByteBuffer _buffer;
    private final boolean _pseudo;

    static {
        HttpHeader[] values = values();
        for (HttpHeader header : values) {
            if (header != UNKNOWN && !CACHE.put(header.toString(), header)) {
                throw new IllegalStateException();
            }
        }
    }

    HttpHeader(String s) {
        this(s, false);
    }

    HttpHeader(String s, boolean pseudo) {
        this._string = s;
        this._lowerCase = StringUtil.asciiToLowerCase(s);
        this._bytes = StringUtil.getBytes(s);
        this._bytesColonSpace = StringUtil.getBytes(s + ": ");
        this._buffer = ByteBuffer.wrap(this._bytes);
        this._pseudo = pseudo;
    }

    public String lowerCaseName() {
        return this._lowerCase;
    }

    public ByteBuffer toBuffer() {
        return this._buffer.asReadOnlyBuffer();
    }

    public byte[] getBytes() {
        return this._bytes;
    }

    public byte[] getBytesColonSpace() {
        return this._bytesColonSpace;
    }

    /* renamed from: is */
    public boolean m42is(String s) {
        return this._string.equalsIgnoreCase(s);
    }

    public boolean isPseudo() {
        return this._pseudo;
    }

    public String asString() {
        return this._string;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this._string;
    }
}
