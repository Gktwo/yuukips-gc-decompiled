package org.eclipse.jetty.http;

import dev.morphia.mapping.Mapper;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.EnumSet;
import java.util.Objects;
import org.eclipse.jetty.util.ArrayTrie;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.Trie;
import org.eclipse.jetty.util.UrlEncoded;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpURI.class */
public class HttpURI {
    private static final Trie<Boolean> __ambiguousSegments = new ArrayTrie();
    private String _scheme;
    private String _user;
    private String _host;
    private int _port;
    private String _path;
    private String _param;
    private String _query;
    private String _fragment;
    private String _uri;
    private String _decodedPath;
    private final EnumSet<Violation> _violations;
    private boolean _emptySegment;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpURI$State.class */
    public enum State {
        START,
        HOST_OR_PATH,
        SCHEME_OR_PATH,
        HOST,
        IPV6,
        PORT,
        PATH,
        PARAM,
        QUERY,
        FRAGMENT,
        ASTERISK
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpURI$Violation.class */
    public enum Violation {
        SEGMENT("Ambiguous path segments"),
        SEPARATOR("Ambiguous path separator"),
        PARAM("Ambiguous path parameters"),
        ENCODING("Ambiguous double encoding"),
        EMPTY("Ambiguous empty segments"),
        UTF16("Non standard UTF-16 encoding");
        
        private final String _message;

        Violation(String message) {
            this._message = message;
        }

        /* access modifiers changed from: package-private */
        public String getMessage() {
            return this._message;
        }
    }

    static {
        __ambiguousSegments.put(Mapper.IGNORED_FIELDNAME, Boolean.FALSE);
        __ambiguousSegments.put("%2e", Boolean.TRUE);
        __ambiguousSegments.put("%u002e", Boolean.TRUE);
        __ambiguousSegments.put(CallerDataConverter.DEFAULT_RANGE_DELIMITER, Boolean.FALSE);
        __ambiguousSegments.put(".%2e", Boolean.TRUE);
        __ambiguousSegments.put(".%u002e", Boolean.TRUE);
        __ambiguousSegments.put("%2e.", Boolean.TRUE);
        __ambiguousSegments.put("%2e%2e", Boolean.TRUE);
        __ambiguousSegments.put("%2e%u002e", Boolean.TRUE);
        __ambiguousSegments.put("%u002e.", Boolean.TRUE);
        __ambiguousSegments.put("%u002e%2e", Boolean.TRUE);
        __ambiguousSegments.put("%u002e%u002e", Boolean.TRUE);
    }

    public static HttpURI createHttpURI(String scheme, String host, int port, String path, String param, String query, String fragment) {
        if (port == 80 && HttpScheme.HTTP.m39is(scheme)) {
            port = 0;
        }
        if (port == 443 && HttpScheme.HTTPS.m39is(scheme)) {
            port = 0;
        }
        return new HttpURI(scheme, host, port, path, param, query, fragment);
    }

    public HttpURI() {
        this._violations = EnumSet.noneOf(Violation.class);
    }

    public HttpURI(String scheme, String host, int port, String path, String param, String query, String fragment) {
        this._violations = EnumSet.noneOf(Violation.class);
        this._scheme = scheme;
        this._host = host;
        this._port = port;
        if (path != null) {
            parse(State.PATH, path, 0, path.length());
        }
        if (param != null) {
            this._param = param;
        }
        if (query != null) {
            this._query = query;
        }
        if (fragment != null) {
            this._fragment = fragment;
        }
    }

    public HttpURI(HttpURI uri) {
        this._violations = EnumSet.noneOf(Violation.class);
        this._scheme = uri._scheme;
        this._user = uri._user;
        this._host = uri._host;
        this._port = uri._port;
        this._path = uri._path;
        this._param = uri._param;
        this._query = uri._query;
        this._fragment = uri._fragment;
        this._uri = uri._uri;
        this._decodedPath = uri._decodedPath;
        this._violations.addAll(uri._violations);
        this._emptySegment = false;
    }

    public HttpURI(HttpURI schemeHostPort, HttpURI uri) {
        this._violations = EnumSet.noneOf(Violation.class);
        this._scheme = schemeHostPort._scheme;
        this._user = schemeHostPort._user;
        this._host = schemeHostPort._host;
        this._port = schemeHostPort._port;
        this._path = uri._path;
        this._param = uri._param;
        this._query = uri._query;
        this._fragment = uri._fragment;
        this._uri = uri._uri;
        this._decodedPath = uri._decodedPath;
        this._violations.addAll(uri._violations);
        this._emptySegment = false;
    }

    public HttpURI(String uri) {
        this._violations = EnumSet.noneOf(Violation.class);
        this._port = -1;
        parse(State.START, uri, 0, uri.length());
    }

    public HttpURI(URI uri) {
        this._violations = EnumSet.noneOf(Violation.class);
        this._uri = null;
        this._scheme = uri.getScheme();
        this._host = uri.getHost();
        if (this._host == null && uri.getRawSchemeSpecificPart().startsWith("//")) {
            this._host = "";
        }
        this._port = uri.getPort();
        this._user = uri.getUserInfo();
        String path = uri.getRawPath();
        if (path != null) {
            parse(State.PATH, path, 0, path.length());
        }
        this._query = uri.getRawQuery();
        this._fragment = uri.getFragment();
    }

    public HttpURI(String scheme, String host, int port, String pathQuery) {
        this._violations = EnumSet.noneOf(Violation.class);
        this._uri = null;
        this._scheme = scheme;
        this._host = host;
        this._port = port;
        if (pathQuery != null) {
            parse(State.PATH, pathQuery, 0, pathQuery.length());
        }
    }

    public void clear() {
        this._uri = null;
        this._scheme = null;
        this._user = null;
        this._host = null;
        this._port = -1;
        this._path = null;
        this._param = null;
        this._query = null;
        this._fragment = null;
        this._decodedPath = null;
        this._emptySegment = false;
        this._violations.clear();
    }

    public void parse(String uri) {
        clear();
        this._uri = uri;
        parse(State.START, uri, 0, uri.length());
    }

    public void parseRequestTarget(String method, String uri) {
        clear();
        this._uri = uri;
        if (HttpMethod.CONNECT.m40is(method)) {
            parse(State.HOST, uri, 0, uri.length());
        } else {
            parse(uri.startsWith("/") ? State.PATH : State.START, uri, 0, uri.length());
        }
    }

    @Deprecated
    public void parseConnect(String uri) {
        clear();
        this._uri = uri;
        this._path = uri;
    }

    public void parse(String uri, int offset, int length) {
        clear();
        int end = offset + length;
        this._uri = uri.substring(offset, end);
        parse(State.START, uri, offset, end);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:194:0x064b, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parse(org.eclipse.jetty.http.HttpURI.State r7, java.lang.String r8, int r9, int r10) {
        /*
        // Method dump skipped, instructions count: 1987
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.http.HttpURI.parse(org.eclipse.jetty.http.HttpURI$State, java.lang.String, int, int):void");
    }

    private void checkSegment(String uri, int segment, int end, boolean param) {
        if (this._emptySegment) {
            this._violations.add(Violation.EMPTY);
        }
        if (end == segment) {
            if (end < uri.length() && "#?".indexOf(uri.charAt(end)) < 0) {
                if (segment == 0) {
                    this._violations.add(Violation.EMPTY);
                    return;
                } else if (!this._emptySegment) {
                    this._emptySegment = true;
                    return;
                }
            } else {
                return;
            }
        }
        Boolean ambiguous = __ambiguousSegments.get(uri, segment, end - segment);
        if (ambiguous != null) {
            if (Boolean.TRUE.equals(ambiguous)) {
                this._violations.add(Violation.SEGMENT);
            }
            if (param) {
                this._violations.add(Violation.PARAM);
            }
        }
    }

    public boolean hasAmbiguousSegment() {
        return this._violations.contains(Violation.SEGMENT);
    }

    public boolean hasAmbiguousEmptySegment() {
        return this._violations.contains(Violation.EMPTY);
    }

    public boolean hasAmbiguousSeparator() {
        return this._violations.contains(Violation.SEPARATOR);
    }

    public boolean hasAmbiguousParameter() {
        return this._violations.contains(Violation.PARAM);
    }

    public boolean hasAmbiguousEncoding() {
        return this._violations.contains(Violation.ENCODING);
    }

    public boolean isAmbiguous() {
        return !this._violations.isEmpty() && (this._violations.size() != 1 || !this._violations.contains(Violation.UTF16));
    }

    public boolean hasViolations() {
        return !this._violations.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean hasViolation(Violation violation) {
        return this._violations.contains(violation);
    }

    public boolean hasUtf16Encoding() {
        return this._violations.contains(Violation.UTF16);
    }

    public String getScheme() {
        return this._scheme;
    }

    public String getHost() {
        if (this._host == null || !this._host.isEmpty()) {
            return this._host;
        }
        return null;
    }

    public int getPort() {
        return this._port;
    }

    public String getPath() {
        return this._path;
    }

    public String getDecodedPath() {
        return this._decodedPath;
    }

    public String getParam() {
        return this._param;
    }

    public void setParam(String param) {
        if (!Objects.equals(this._param, param)) {
            if (this._param != null && this._path.endsWith(";" + this._param)) {
                this._path = this._path.substring(0, (this._path.length() - 1) - this._param.length());
            }
            this._param = param;
            if (this._param != null) {
                this._path = (this._path == null ? "" : this._path) + ";" + this._param;
            }
            this._uri = null;
        }
    }

    public String getQuery() {
        return this._query;
    }

    public boolean hasQuery() {
        return this._query != null && !this._query.isEmpty();
    }

    public String getFragment() {
        return this._fragment;
    }

    public void decodeQueryTo(MultiMap<String> parameters) {
        if (this._query != null) {
            UrlEncoded.decodeUtf8To(this._query, parameters);
        }
    }

    public void decodeQueryTo(MultiMap<String> parameters, String encoding) throws UnsupportedEncodingException {
        decodeQueryTo(parameters, Charset.forName(encoding));
    }

    public void decodeQueryTo(MultiMap<String> parameters, Charset encoding) throws UnsupportedEncodingException {
        if (this._query != null) {
            if (encoding == null || StandardCharsets.UTF_8.equals(encoding)) {
                UrlEncoded.decodeUtf8To(this._query, parameters);
            } else {
                UrlEncoded.decodeTo(this._query, parameters, encoding);
            }
        }
    }

    public boolean isAbsolute() {
        return this._scheme != null && !this._scheme.isEmpty();
    }

    public String toString() {
        if (this._uri == null) {
            StringBuilder out = new StringBuilder();
            if (this._scheme != null) {
                out.append(this._scheme).append(':');
            }
            if (this._host != null) {
                out.append("//");
                if (this._user != null) {
                    out.append(this._user).append('@');
                }
                out.append(this._host);
            }
            if (this._port > 0) {
                out.append(':').append(this._port);
            }
            if (this._path != null) {
                out.append(this._path);
            }
            if (this._query != null) {
                out.append('?').append(this._query);
            }
            if (this._fragment != null) {
                out.append('#').append(this._fragment);
            }
            if (out.length() > 0) {
                this._uri = out.toString();
            } else {
                this._uri = "";
            }
        }
        return this._uri;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HttpURI)) {
            return false;
        }
        return toString().equals(o.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public void setScheme(String scheme) {
        this._scheme = scheme;
        this._uri = null;
    }

    public void setAuthority(String host, int port) {
        if (host == null || isPathValidForAuthority(this._path)) {
            this._host = host;
            this._port = port;
            this._uri = null;
            return;
        }
        throw new IllegalArgumentException("Relative path with authority");
    }

    private boolean isPathValidForAuthority(String path) {
        if (path != null && !path.isEmpty() && !"*".equals(path)) {
            return path.startsWith("/");
        }
        return true;
    }

    public void setPath(String path) {
        if (!hasAuthority() || isPathValidForAuthority(path)) {
            this._uri = null;
            this._path = null;
            if (path != null) {
                parse(State.PATH, path, 0, path.length());
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Relative path with authority");
    }

    public void setPathQuery(String pathQuery) {
        if (!hasAuthority() || isPathValidForAuthority(pathQuery)) {
            this._uri = null;
            this._path = null;
            this._decodedPath = null;
            this._param = null;
            this._fragment = null;
            if (pathQuery != null) {
                parse(State.PATH, pathQuery, 0, pathQuery.length());
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Relative path with authority");
    }

    private boolean hasAuthority() {
        return this._host != null;
    }

    public void setQuery(String query) {
        this._query = query;
        this._uri = null;
    }

    public URI toURI() throws URISyntaxException {
        return new URI(this._scheme, null, this._host, this._port, this._path, this._query == null ? null : UrlEncoded.decodeString(this._query), this._fragment);
    }

    public String getPathQuery() {
        if (this._query == null) {
            return this._path;
        }
        return this._path + "?" + this._query;
    }

    public String getAuthority() {
        if (this._port > 0) {
            return this._host + EmitterKt.COMMENT_PREFIX + this._port;
        }
        return this._host;
    }

    public String getUser() {
        return this._user;
    }
}
