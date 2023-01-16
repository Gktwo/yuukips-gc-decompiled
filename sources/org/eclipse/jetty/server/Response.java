package org.eclipse.jetty.server;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.IllegalSelectorException;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.function.Supplier;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import org.eclipse.jetty.http.DateGenerator;
import org.eclipse.jetty.http.HttpContent;
import org.eclipse.jetty.http.HttpCookie;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpGenerator;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpHeaderValue;
import org.eclipse.jetty.http.HttpScheme;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.http.MetaData;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.http.PreEncodedHttpField;
import org.eclipse.jetty.p023io.RuntimeIOException;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.util.AtomicBiInteger;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.jline.reader.impl.LineReaderImpl;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/Response.class */
public class Response implements HttpServletResponse {
    private static final int __MIN_BUFFER_SIZE = 1;
    public static final int NO_CONTENT_LENGTH = -1;
    public static final int USE_KNOWN_CONTENT_LENGTH = -2;
    public static final String SET_INCLUDE_HEADER_PREFIX = "org.eclipse.jetty.server.include.";
    private final HttpChannel _channel;
    private final HttpOutput _out;
    private String _reason;
    private Locale _locale;
    private MimeTypes.Type _mimeType;
    private String _characterEncoding;
    private String _contentType;
    private ResponseWriter _writer;
    private Supplier<HttpFields> _trailers;
    private static final Logger LOG = Log.getLogger(Response.class);
    private static final HttpField __EXPIRES_01JAN1970 = new PreEncodedHttpField(HttpHeader.EXPIRES, DateGenerator.__01Jan1970);
    private static final EnumSet<EncodingFrom> __localeOverride = EnumSet.of(EncodingFrom.NOT_SET, EncodingFrom.INFERRED);
    private static final EnumSet<EncodingFrom> __explicitCharset = EnumSet.of(EncodingFrom.SET_LOCALE, EncodingFrom.SET_CHARACTER_ENCODING);
    private final HttpFields _fields = new HttpFields();
    private final AtomicBiInteger _errorSentAndIncludes = new AtomicBiInteger();
    private int _status = 200;
    private EncodingFrom _encodingFrom = EncodingFrom.NOT_SET;
    private OutputType _outputType = OutputType.NONE;
    private long _contentLength = -1;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Response$EncodingFrom.class */
    public enum EncodingFrom {
        NOT_SET,
        INFERRED,
        SET_LOCALE,
        SET_CONTENT_TYPE,
        SET_CHARACTER_ENCODING
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Response$OutputType.class */
    public enum OutputType {
        NONE,
        STREAM,
        WRITER
    }

    public Response(HttpChannel channel, HttpOutput out) {
        this._channel = channel;
        this._out = out;
    }

    public HttpChannel getHttpChannel() {
        return this._channel;
    }

    /* access modifiers changed from: protected */
    public void recycle() {
        this._fields.clear();
        this._errorSentAndIncludes.set(0);
        this._out.recycle();
        this._status = 200;
        this._reason = null;
        this._locale = null;
        this._mimeType = null;
        this._characterEncoding = null;
        this._encodingFrom = EncodingFrom.NOT_SET;
        this._contentType = null;
        this._outputType = OutputType.NONE;
        this._contentLength = -1;
        this._trailers = null;
    }

    public HttpOutput getHttpOutput() {
        return this._out;
    }

    public void reopen() {
        setErrorSent(false);
        this._out.reopen();
    }

    public void errorClose() {
        setErrorSent(true);
        this._out.softClose();
    }

    private boolean isMutable() {
        return this._errorSentAndIncludes.get() == 0;
    }

    private void setErrorSent(boolean errorSent) {
        this._errorSentAndIncludes.getAndSetHi(errorSent ? 1 : 0);
    }

    public boolean isIncluding() {
        return this._errorSentAndIncludes.getLo() > 0;
    }

    public void include() {
        this._errorSentAndIncludes.add(0, 1);
    }

    public void included() {
        this._errorSentAndIncludes.add(0, -1);
        if (this._outputType == OutputType.WRITER) {
            this._writer.reopen();
        }
        this._out.reopen();
    }

    public void addCookie(HttpCookie cookie) {
        if (StringUtil.isBlank(cookie.getName())) {
            throw new IllegalArgumentException("Cookie.name cannot be blank/null");
        }
        this._fields.add(new HttpCookie.SetCookieHttpField(checkSameSite(cookie), getHttpChannel().getHttpConfiguration().getResponseCookieCompliance()));
        this._fields.put(__EXPIRES_01JAN1970);
    }

    private HttpCookie checkSameSite(HttpCookie cookie) {
        if (cookie == null || cookie.getSameSite() != null) {
            return cookie;
        }
        HttpCookie.SameSite contextDefault = HttpCookie.getSameSiteDefault(this._channel.getRequest().getServletContext());
        if (contextDefault == null) {
            return cookie;
        }
        return new HttpCookie(cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getPath(), cookie.getMaxAge(), cookie.isHttpOnly(), cookie.isSecure(), cookie.getComment(), cookie.getVersion(), contextDefault);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0099 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void replaceCookie(org.eclipse.jetty.http.HttpCookie r7) {
        /*
            r6 = this;
            r0 = r6
            org.eclipse.jetty.http.HttpFields r0 = r0._fields
            java.util.ListIterator r0 = r0.listIterator()
            r8 = r0
        L_0x0008:
            r0 = r8
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00c3
            r0 = r8
            java.lang.Object r0 = r0.next()
            org.eclipse.jetty.http.HttpField r0 = (org.eclipse.jetty.http.HttpField) r0
            r9 = r0
            r0 = r9
            org.eclipse.jetty.http.HttpHeader r0 = r0.getHeader()
            org.eclipse.jetty.http.HttpHeader r1 = org.eclipse.jetty.http.HttpHeader.SET_COOKIE
            if (r0 != r1) goto L_0x00c0
            r0 = r6
            org.eclipse.jetty.server.HttpChannel r0 = r0.getHttpChannel()
            org.eclipse.jetty.server.HttpConfiguration r0 = r0.getHttpConfiguration()
            org.eclipse.jetty.http.CookieCompliance r0 = r0.getResponseCookieCompliance()
            r10 = r0
            r0 = r9
            boolean r0 = r0 instanceof org.eclipse.jetty.http.HttpCookie.SetCookieHttpField
            if (r0 == 0) goto L_0x0044
            r0 = r9
            org.eclipse.jetty.http.HttpCookie$SetCookieHttpField r0 = (org.eclipse.jetty.http.HttpCookie.SetCookieHttpField) r0
            org.eclipse.jetty.http.HttpCookie r0 = r0.getHttpCookie()
            r11 = r0
            goto L_0x0051
        L_0x0044:
            org.eclipse.jetty.http.HttpCookie r0 = new org.eclipse.jetty.http.HttpCookie
            r1 = r0
            r2 = r9
            java.lang.String r2 = r2.getValue()
            r1.<init>(r2)
            r11 = r0
        L_0x0051:
            r0 = r7
            java.lang.String r0 = r0.getName()
            r1 = r11
            java.lang.String r1 = r1.getName()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0063
            goto L_0x0008
        L_0x0063:
            r0 = r7
            java.lang.String r0 = r0.getDomain()
            if (r0 != 0) goto L_0x0075
            r0 = r11
            java.lang.String r0 = r0.getDomain()
            if (r0 == 0) goto L_0x0087
            goto L_0x0008
        L_0x0075:
            r0 = r7
            java.lang.String r0 = r0.getDomain()
            r1 = r11
            java.lang.String r1 = r1.getDomain()
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x0087
            goto L_0x0008
        L_0x0087:
            r0 = r7
            java.lang.String r0 = r0.getPath()
            if (r0 != 0) goto L_0x0099
            r0 = r11
            java.lang.String r0 = r0.getPath()
            if (r0 == 0) goto L_0x00ab
            goto L_0x0008
        L_0x0099:
            r0 = r7
            java.lang.String r0 = r0.getPath()
            r1 = r11
            java.lang.String r1 = r1.getPath()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ab
            goto L_0x0008
        L_0x00ab:
            r0 = r8
            org.eclipse.jetty.http.HttpCookie$SetCookieHttpField r1 = new org.eclipse.jetty.http.HttpCookie$SetCookieHttpField
            r2 = r1
            r3 = r6
            r4 = r7
            org.eclipse.jetty.http.HttpCookie r3 = r3.checkSameSite(r4)
            r4 = r10
            r2.<init>(r3, r4)
            r0.set(r1)
            return
        L_0x00c0:
            goto L_0x0008
        L_0x00c3:
            r0 = r6
            r1 = r7
            r0.addCookie(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.Response.replaceCookie(org.eclipse.jetty.http.HttpCookie):void");
    }

    @Override // javax.servlet.http.HttpServletResponse
    public void addCookie(Cookie cookie) {
        if (!isMutable()) {
            return;
        }
        if (StringUtil.isBlank(cookie.getName())) {
            throw new IllegalArgumentException("Cookie.name cannot be blank/null");
        }
        String comment = cookie.getComment();
        boolean httpOnly = cookie.isHttpOnly() || HttpCookie.isHttpOnlyInComment(comment);
        addCookie(new HttpCookie(cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getPath(), (long) cookie.getMaxAge(), httpOnly, cookie.getSecure(), HttpCookie.getCommentWithoutAttributes(comment), cookie.getVersion(), HttpCookie.getSameSiteFromComment(comment)));
    }

    @Override // javax.servlet.http.HttpServletResponse
    public boolean containsHeader(String name) {
        return this._fields.containsKey(name);
    }

    @Override // javax.servlet.http.HttpServletResponse
    public String encodeURL(String url) {
        if (url == null) {
            return null;
        }
        Request request = this._channel.getRequest();
        SessionHandler sessionManager = request.getSessionHandler();
        if (sessionManager == null) {
            return url;
        }
        HttpURI uri = null;
        boolean hasScheme = URIUtil.hasScheme(url);
        if (sessionManager.isCheckingRemoteSessionIdEncoding() && hasScheme) {
            uri = new HttpURI(url);
            String path = uri.getPath();
            String path2 = path == null ? "" : path;
            int port = uri.getPort();
            if (port < 0) {
                port = HttpScheme.HTTPS.asString().equalsIgnoreCase(uri.getScheme()) ? PacketOpcodes.AddQuestContentProgressReq : 80;
            }
            if (!request.getServerName().equalsIgnoreCase(uri.getHost())) {
                return url;
            }
            if (request.getServerPort() != port) {
                return url;
            }
            if (!path2.startsWith(request.getContextPath())) {
                return url;
            }
        }
        String sessionURLPrefix = sessionManager.getSessionIdPathParameterNamePrefix();
        if (sessionURLPrefix == null) {
            return url;
        }
        if ((!sessionManager.isUsingCookies() || !request.isRequestedSessionIdFromCookie()) && sessionManager.isUsingURLs()) {
            HttpSession session = request.getSession(false);
            if (session == null) {
                return url;
            }
            if (!sessionManager.isValid(session)) {
                return url;
            }
            String id = sessionManager.getExtendedId(session);
            int prefix = url.indexOf(sessionURLPrefix);
            if (prefix != -1) {
                int suffix = url.indexOf("?", prefix);
                if (suffix < 0) {
                    suffix = url.indexOf(LineReaderImpl.DEFAULT_COMMENT_BEGIN, prefix);
                }
                if (suffix <= prefix) {
                    return url.substring(0, prefix + sessionURLPrefix.length()) + id;
                }
                return url.substring(0, prefix + sessionURLPrefix.length()) + id + url.substring(suffix);
            }
            String nonNullPath = "";
            if (hasScheme) {
                if (uri == null) {
                    uri = new HttpURI(url);
                }
                if (uri.getPath() == null) {
                    nonNullPath = "/";
                }
            }
            int suffix2 = url.indexOf(63);
            if (suffix2 < 0) {
                suffix2 = url.indexOf(35);
            }
            if (suffix2 < 0) {
                return url + nonNullPath + sessionURLPrefix + id;
            }
            return url.substring(0, suffix2) + nonNullPath + sessionURLPrefix + id + url.substring(suffix2);
        }
        int prefix2 = url.indexOf(sessionURLPrefix);
        if (prefix2 == -1) {
            return url;
        }
        int suffix3 = url.indexOf("?", prefix2);
        if (suffix3 < 0) {
            suffix3 = url.indexOf(LineReaderImpl.DEFAULT_COMMENT_BEGIN, prefix2);
        }
        if (suffix3 <= prefix2) {
            return url.substring(0, prefix2);
        }
        return url.substring(0, prefix2) + url.substring(suffix3);
    }

    @Override // javax.servlet.http.HttpServletResponse
    public String encodeRedirectURL(String url) {
        return encodeURL(url);
    }

    @Override // javax.servlet.http.HttpServletResponse
    @Deprecated
    public String encodeUrl(String url) {
        return encodeURL(url);
    }

    @Override // javax.servlet.http.HttpServletResponse
    @Deprecated
    public String encodeRedirectUrl(String url) {
        return encodeRedirectURL(url);
    }

    @Override // javax.servlet.http.HttpServletResponse
    public void sendError(int sc) throws IOException {
        sendError(sc, null);
    }

    @Override // javax.servlet.http.HttpServletResponse
    public void sendError(int code, String message) throws IOException {
        if (!isIncluding()) {
            switch (code) {
                case -1:
                    this._channel.abort(new IOException(message));
                    return;
                case 102:
                    sendProcessing();
                    return;
                default:
                    this._channel.getState().sendError(code, message);
                    return;
            }
        }
    }

    public void sendProcessing() throws IOException {
        if (this._channel.isExpecting102Processing() && !isCommitted()) {
            this._channel.sendResponse(HttpGenerator.PROGRESS_102_INFO, null, true);
        }
    }

    public void sendRedirect(int code, String location) throws IOException {
        sendRedirect(code, location, false);
    }

    public void sendRedirect(String location, boolean consumeAll) throws IOException {
        sendRedirect(getHttpChannel().getRequest().getHttpVersion().getVersion() < HttpVersion.HTTP_1_1.getVersion() ? 302 : 303, location, consumeAll);
    }

    public void sendRedirect(int code, String location, boolean consumeAll) throws IOException {
        StringBuilder buf;
        String location2;
        if (consumeAll) {
            getHttpChannel().ensureConsumeAllOrNotPersistent();
        }
        if (!HttpStatus.isRedirection(code)) {
            throw new IllegalArgumentException("Not a 3xx redirect code");
        } else if (isMutable()) {
            if (location == null) {
                throw new IllegalArgumentException();
            }
            if (!URIUtil.hasScheme(location)) {
                if (this._channel.getHttpConfiguration().isRelativeRedirectAllowed()) {
                    buf = new StringBuilder();
                } else {
                    buf = this._channel.getRequest().getRootURL();
                }
                if (location.startsWith("/")) {
                    location2 = URIUtil.canonicalURI(location);
                } else {
                    String path = this._channel.getRequest().getRequestURI();
                    location2 = URIUtil.canonicalURI(URIUtil.addEncodedPaths(path.endsWith("/") ? path : URIUtil.parentPath(path), location));
                    if (location2 != null && !location2.startsWith("/")) {
                        buf.append('/');
                    }
                }
                if (location2 == null) {
                    throw new IllegalStateException("path cannot be above root");
                }
                buf.append(location2);
                location = buf.toString();
            }
            resetBuffer();
            setHeader(HttpHeader.LOCATION, location);
            setStatus(code);
            closeOutput();
        }
    }

    @Override // javax.servlet.http.HttpServletResponse
    public void sendRedirect(String location) throws IOException {
        sendRedirect(302, location);
    }

    @Override // javax.servlet.http.HttpServletResponse
    public void setDateHeader(String name, long date) {
        if (isMutable()) {
            this._fields.putDateField(name, date);
        }
    }

    @Override // javax.servlet.http.HttpServletResponse
    public void addDateHeader(String name, long date) {
        if (isMutable()) {
            this._fields.addDateField(name, date);
        }
    }

    public void setHeader(HttpHeader name, String value) {
        if (!isMutable()) {
            return;
        }
        if (HttpHeader.CONTENT_TYPE == name) {
            setContentType(value);
            return;
        }
        this._fields.put(name, value);
        if (HttpHeader.CONTENT_LENGTH != name) {
            return;
        }
        if (value == null) {
            this._contentLength = -1;
        } else {
            this._contentLength = Long.parseLong(value);
        }
    }

    @Override // javax.servlet.http.HttpServletResponse
    public void setHeader(String name, String value) {
        long biInt = this._errorSentAndIncludes.get();
        if (biInt != 0) {
            boolean errorSent = AtomicBiInteger.getHi(biInt) != 0;
            boolean including = AtomicBiInteger.getLo(biInt) > 0;
            if (!errorSent && including && name.startsWith(SET_INCLUDE_HEADER_PREFIX)) {
                name = name.substring(SET_INCLUDE_HEADER_PREFIX.length());
            } else {
                return;
            }
        }
        if (HttpHeader.CONTENT_TYPE.m42is(name)) {
            setContentType(value);
            return;
        }
        this._fields.put(name, value);
        if (!HttpHeader.CONTENT_LENGTH.m42is(name)) {
            return;
        }
        if (value == null) {
            this._contentLength = -1;
        } else {
            this._contentLength = Long.parseLong(value);
        }
    }

    @Override // javax.servlet.http.HttpServletResponse
    public Collection<String> getHeaderNames() {
        return this._fields.getFieldNamesCollection();
    }

    @Override // javax.servlet.http.HttpServletResponse
    public String getHeader(String name) {
        return this._fields.get(name);
    }

    @Override // javax.servlet.http.HttpServletResponse
    public Collection<String> getHeaders(String name) {
        Collection<String> i = this._fields.getValuesList(name);
        if (i == null) {
            return Collections.emptyList();
        }
        return i;
    }

    @Override // javax.servlet.http.HttpServletResponse
    public void addHeader(String name, String value) {
        long biInt = this._errorSentAndIncludes.get();
        if (biInt != 0) {
            boolean errorSent = AtomicBiInteger.getHi(biInt) != 0;
            boolean including = AtomicBiInteger.getLo(biInt) > 0;
            if (!errorSent && including && name.startsWith(SET_INCLUDE_HEADER_PREFIX)) {
                name = name.substring(SET_INCLUDE_HEADER_PREFIX.length());
            } else {
                return;
            }
        }
        if (HttpHeader.CONTENT_TYPE.m42is(name)) {
            setContentType(value);
        } else if (HttpHeader.CONTENT_LENGTH.m42is(name)) {
            setHeader(name, value);
        } else {
            this._fields.add(name, value);
        }
    }

    @Override // javax.servlet.http.HttpServletResponse
    public void setIntHeader(String name, int value) {
        if (isMutable()) {
            this._fields.putLongField(name, (long) value);
            if (HttpHeader.CONTENT_LENGTH.m42is(name)) {
                this._contentLength = (long) value;
            }
        }
    }

    @Override // javax.servlet.http.HttpServletResponse
    public void addIntHeader(String name, int value) {
        if (isMutable()) {
            this._fields.add(name, Integer.toString(value));
            if (HttpHeader.CONTENT_LENGTH.m42is(name)) {
                this._contentLength = (long) value;
            }
        }
    }

    @Override // javax.servlet.http.HttpServletResponse
    public void setStatus(int sc) {
        if (sc <= 0) {
            throw new IllegalArgumentException();
        } else if (isMutable()) {
            if (this._status != sc) {
                this._reason = null;
            }
            this._status = sc;
        }
    }

    @Override // javax.servlet.http.HttpServletResponse
    @Deprecated
    public void setStatus(int sc, String sm) {
        setStatusWithReason(sc, sm);
    }

    public void setStatusWithReason(int sc, String sm) {
        if (sc <= 0) {
            throw new IllegalArgumentException();
        } else if (isMutable()) {
            this._status = sc;
            this._reason = sm;
        }
    }

    @Override // javax.servlet.ServletResponse
    public String getCharacterEncoding() {
        if (this._characterEncoding != null) {
            return this._characterEncoding;
        }
        String encoding = MimeTypes.getCharsetAssumedFromContentType(this._contentType);
        if (encoding != null) {
            return encoding;
        }
        String encoding2 = MimeTypes.getCharsetInferredFromContentType(this._contentType);
        if (encoding2 != null) {
            return encoding2;
        }
        return StringUtil.__ISO_8859_1;
    }

    @Override // javax.servlet.ServletResponse
    public String getContentType() {
        return this._contentType;
    }

    @Override // javax.servlet.ServletResponse
    public ServletOutputStream getOutputStream() throws IOException {
        if (this._outputType == OutputType.WRITER) {
            throw new IllegalStateException("WRITER");
        }
        this._outputType = OutputType.STREAM;
        return this._out;
    }

    public boolean isWriting() {
        return this._outputType == OutputType.WRITER;
    }

    public boolean isStreaming() {
        return this._outputType == OutputType.STREAM;
    }

    public boolean isWritingOrStreaming() {
        return isWriting() || isStreaming();
    }

    @Override // javax.servlet.ServletResponse
    public PrintWriter getWriter() throws IOException {
        if (this._outputType == OutputType.STREAM) {
            throw new IllegalStateException("STREAM");
        }
        if (this._outputType == OutputType.NONE) {
            String encoding = this._characterEncoding;
            if (encoding == null) {
                if (this._mimeType == null || !this._mimeType.isCharsetAssumed()) {
                    encoding = MimeTypes.getCharsetAssumedFromContentType(this._contentType);
                    if (encoding == null) {
                        encoding = MimeTypes.getCharsetInferredFromContentType(this._contentType);
                        if (encoding == null) {
                            encoding = StringUtil.__ISO_8859_1;
                        }
                        setCharacterEncoding(encoding, EncodingFrom.INFERRED);
                    }
                } else {
                    encoding = this._mimeType.getCharsetString();
                }
            }
            Locale locale = getLocale();
            if (this._writer != null && this._writer.isFor(locale, encoding)) {
                this._writer.reopen();
            } else if (StringUtil.__ISO_8859_1.equalsIgnoreCase(encoding)) {
                this._writer = new ResponseWriter(new Iso88591HttpWriter(this._out), locale, encoding);
            } else if (StringUtil.__UTF8.equalsIgnoreCase(encoding)) {
                this._writer = new ResponseWriter(new Utf8HttpWriter(this._out), locale, encoding);
            } else {
                this._writer = new ResponseWriter(new EncodingHttpWriter(this._out, encoding), locale, encoding);
            }
            this._outputType = OutputType.WRITER;
        }
        return this._writer;
    }

    @Override // javax.servlet.ServletResponse
    public void setContentLength(int len) {
        if (!isCommitted() && isMutable()) {
            if (len > 0) {
                long written = this._out.getWritten();
                if (written > ((long) len)) {
                    throw new IllegalArgumentException("setContentLength(" + len + ") when already written " + written);
                }
                this._contentLength = (long) len;
                this._fields.putLongField(HttpHeader.CONTENT_LENGTH, (long) len);
                if (isAllContentWritten(written)) {
                    try {
                        closeOutput();
                    } catch (IOException e) {
                        throw new RuntimeIOException(e);
                    }
                }
            } else if (len == 0) {
                long written2 = this._out.getWritten();
                if (written2 > 0) {
                    throw new IllegalArgumentException("setContentLength(0) when already written " + written2);
                }
                this._contentLength = (long) len;
                this._fields.put(HttpHeader.CONTENT_LENGTH, "0");
            } else {
                this._contentLength = (long) len;
                this._fields.remove(HttpHeader.CONTENT_LENGTH);
            }
        }
    }

    public long getContentLength() {
        return this._contentLength;
    }

    public boolean isAllContentWritten(long written) {
        return this._contentLength >= 0 && written >= this._contentLength;
    }

    public boolean isContentComplete(long written) {
        return this._contentLength < 0 || written >= this._contentLength;
    }

    public void closeOutput() throws IOException {
        if (this._outputType == OutputType.WRITER) {
            this._writer.close();
        } else {
            this._out.close();
        }
    }

    @Deprecated
    public void completeOutput() throws IOException {
        closeOutput();
    }

    public void completeOutput(Callback callback) {
        if (this._outputType == OutputType.WRITER) {
            this._writer.complete(callback);
        } else {
            this._out.complete(callback);
        }
    }

    public long getLongContentLength() {
        return this._contentLength;
    }

    public void setLongContentLength(long len) {
        if (!isCommitted() && isMutable()) {
            this._contentLength = len;
            this._fields.putLongField(HttpHeader.CONTENT_LENGTH.toString(), len);
        }
    }

    @Override // javax.servlet.ServletResponse
    public void setContentLengthLong(long length) {
        setLongContentLength(length);
    }

    @Override // javax.servlet.ServletResponse
    public void setCharacterEncoding(String encoding) {
        setCharacterEncoding(encoding, EncodingFrom.SET_CHARACTER_ENCODING);
    }

    private void setCharacterEncoding(String encoding, EncodingFrom from) {
        if (isMutable() && !isWriting() && this._outputType != OutputType.WRITER && !isCommitted()) {
            if (encoding == null) {
                this._encodingFrom = EncodingFrom.NOT_SET;
                if (this._characterEncoding != null) {
                    this._characterEncoding = null;
                    if (this._mimeType != null) {
                        this._mimeType = this._mimeType.getBaseType();
                        this._contentType = this._mimeType.asString();
                        this._fields.put(this._mimeType.getContentTypeField());
                    } else if (this._contentType != null) {
                        this._contentType = MimeTypes.getContentTypeWithoutCharset(this._contentType);
                        this._fields.put(HttpHeader.CONTENT_TYPE, this._contentType);
                    }
                }
            } else {
                this._encodingFrom = from;
                this._characterEncoding = HttpGenerator.__STRICT ? encoding : StringUtil.normalizeCharset(encoding);
                if (this._mimeType != null) {
                    this._contentType = this._mimeType.getBaseType().asString() + ";charset=" + this._characterEncoding;
                    this._mimeType = MimeTypes.CACHE.get(this._contentType);
                    if (this._mimeType == null || HttpGenerator.__STRICT) {
                        this._fields.put(HttpHeader.CONTENT_TYPE, this._contentType);
                    } else {
                        this._fields.put(this._mimeType.getContentTypeField());
                    }
                } else if (this._contentType != null) {
                    this._contentType = MimeTypes.getContentTypeWithoutCharset(this._contentType) + ";charset=" + this._characterEncoding;
                    this._fields.put(HttpHeader.CONTENT_TYPE, this._contentType);
                }
            }
        }
    }

    @Override // javax.servlet.ServletResponse
    public void setContentType(String contentType) {
        String charset;
        if (!isCommitted() && isMutable()) {
            if (contentType != null) {
                this._contentType = contentType;
                this._mimeType = MimeTypes.CACHE.get(contentType);
                if (this._mimeType == null || this._mimeType.getCharset() == null || this._mimeType.isCharsetAssumed()) {
                    charset = MimeTypes.getCharsetFromContentType(contentType);
                } else {
                    charset = this._mimeType.getCharsetString();
                }
                if (charset == null) {
                    switch (this._encodingFrom) {
                        case INFERRED:
                        case SET_CONTENT_TYPE:
                            if (!isWriting()) {
                                this._encodingFrom = EncodingFrom.NOT_SET;
                                this._characterEncoding = null;
                                break;
                            } else {
                                this._mimeType = null;
                                this._contentType += ";charset=" + this._characterEncoding;
                                break;
                            }
                        case SET_LOCALE:
                        case SET_CHARACTER_ENCODING:
                            this._contentType = contentType + ";charset=" + this._characterEncoding;
                            this._mimeType = null;
                            break;
                    }
                } else if (!isWriting() || charset.equalsIgnoreCase(this._characterEncoding)) {
                    this._characterEncoding = charset;
                    this._encodingFrom = EncodingFrom.SET_CONTENT_TYPE;
                } else {
                    this._mimeType = null;
                    this._contentType = MimeTypes.getContentTypeWithoutCharset(this._contentType);
                    if (this._characterEncoding != null) {
                        this._contentType += ";charset=" + this._characterEncoding;
                    }
                }
                if (HttpGenerator.__STRICT || this._mimeType == null) {
                    this._fields.put(HttpHeader.CONTENT_TYPE, this._contentType);
                    return;
                }
                this._contentType = this._mimeType.asString();
                this._fields.put(this._mimeType.getContentTypeField());
            } else if (!isWriting() || this._characterEncoding == null) {
                if (this._locale == null) {
                    this._characterEncoding = null;
                }
                this._mimeType = null;
                this._contentType = null;
                this._fields.remove(HttpHeader.CONTENT_TYPE);
            } else {
                throw new IllegalSelectorException();
            }
        }
    }

    @Override // javax.servlet.ServletResponse
    public void setBufferSize(int size) {
        if (isCommitted()) {
            throw new IllegalStateException("cannot set buffer size after response is in committed state");
        } else if (getContentCount() > 0) {
            throw new IllegalStateException("cannot set buffer size after response has " + getContentCount() + " bytes already written");
        } else {
            if (size < 1) {
                size = 1;
            }
            this._out.setBufferSize(size);
        }
    }

    @Override // javax.servlet.ServletResponse
    public int getBufferSize() {
        return this._out.getBufferSize();
    }

    @Override // javax.servlet.ServletResponse
    public void flushBuffer() throws IOException {
        if (!this._out.isClosed()) {
            this._out.flush();
        }
    }

    @Override // javax.servlet.ServletResponse
    public void reset() {
        SessionHandler sh;
        HttpCookie c;
        this._status = 200;
        this._reason = null;
        this._out.resetBuffer();
        this._outputType = OutputType.NONE;
        this._contentLength = -1;
        this._contentType = null;
        this._mimeType = null;
        this._characterEncoding = null;
        this._encodingFrom = EncodingFrom.NOT_SET;
        this._trailers = null;
        this._fields.clear();
        for (String value : this._channel.getRequest().getHttpFields().getCSV(HttpHeader.CONNECTION, false)) {
            HttpHeaderValue cb = HttpHeaderValue.CACHE.get(value);
            if (cb != null) {
                switch (cb) {
                    case CLOSE:
                        this._fields.put(HttpHeader.CONNECTION, HttpHeaderValue.CLOSE.toString());
                        continue;
                    case KEEP_ALIVE:
                        if (HttpVersion.HTTP_1_0.m38is(this._channel.getRequest().getProtocol())) {
                            this._fields.put(HttpHeader.CONNECTION, HttpHeaderValue.KEEP_ALIVE.toString());
                            break;
                        } else {
                            continue;
                        }
                    case TE:
                        this._fields.put(HttpHeader.CONNECTION, HttpHeaderValue.TE.toString());
                        continue;
                }
            }
        }
        Request request = getHttpChannel().getRequest();
        HttpSession session = request.getSession(false);
        if (!(session == null || !session.isNew() || (sh = request.getSessionHandler()) == null || (c = sh.getSessionCookie(session, request.getContextPath(), request.isSecure())) == null)) {
            addCookie(c);
        }
    }

    public void resetContent() {
        this._out.resetBuffer();
        this._outputType = OutputType.NONE;
        this._contentLength = -1;
        this._contentType = null;
        this._mimeType = null;
        this._characterEncoding = null;
        this._encodingFrom = EncodingFrom.NOT_SET;
        Iterator<HttpField> i = getHttpFields().iterator();
        while (i.hasNext()) {
            if (i.next().getHeader() != null) {
                switch (field.getHeader()) {
                    case CONTENT_TYPE:
                    case CONTENT_LENGTH:
                    case CONTENT_ENCODING:
                    case CONTENT_LANGUAGE:
                    case CONTENT_RANGE:
                    case CONTENT_MD5:
                    case CONTENT_LOCATION:
                    case TRANSFER_ENCODING:
                    case CACHE_CONTROL:
                    case LAST_MODIFIED:
                    case EXPIRES:
                    case ETAG:
                    case DATE:
                    case VARY:
                        i.remove();
                        continue;
                }
            }
        }
    }

    public void resetForForward() {
        resetBuffer();
        this._outputType = OutputType.NONE;
    }

    @Override // javax.servlet.ServletResponse
    public void resetBuffer() {
        this._out.resetBuffer();
        this._out.reopen();
    }

    public void setTrailers(Supplier<HttpFields> trailers) {
        this._trailers = trailers;
    }

    public Supplier<HttpFields> getTrailers() {
        return this._trailers;
    }

    /* access modifiers changed from: protected */
    public MetaData.Response newResponseMetaData() {
        MetaData.Response info = new MetaData.Response(this._channel.getRequest().getHttpVersion(), getStatus(), getReason(), this._fields, getLongContentLength());
        info.setTrailerSupplier(getTrailers());
        return info;
    }

    public MetaData.Response getCommittedMetaData() {
        MetaData.Response meta = this._channel.getCommittedMetaData();
        if (meta == null) {
            return newResponseMetaData();
        }
        return meta;
    }

    @Override // javax.servlet.ServletResponse
    public boolean isCommitted() {
        if (this._channel.isSendError()) {
            return true;
        }
        return this._channel.isCommitted();
    }

    @Override // javax.servlet.ServletResponse
    public void setLocale(Locale locale) {
        String charset;
        if (locale != null && !isCommitted() && isMutable()) {
            this._locale = locale;
            this._fields.put(HttpHeader.CONTENT_LANGUAGE, StringUtil.replace(locale.toString(), '_', '-'));
            if (this._outputType == OutputType.NONE && this._channel.getRequest().getContext() != null && (charset = this._channel.getRequest().getContext().getContextHandler().getLocaleEncoding(locale)) != null && charset.length() > 0 && __localeOverride.contains(this._encodingFrom)) {
                setCharacterEncoding(charset, EncodingFrom.SET_LOCALE);
            }
        }
    }

    @Override // javax.servlet.ServletResponse
    public Locale getLocale() {
        if (this._locale == null) {
            return Locale.getDefault();
        }
        return this._locale;
    }

    @Override // javax.servlet.http.HttpServletResponse
    public int getStatus() {
        return this._status;
    }

    public String getReason() {
        return this._reason;
    }

    public HttpFields getHttpFields() {
        return this._fields;
    }

    public long getContentCount() {
        return this._out.getWritten();
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = this._channel.getRequest().getHttpVersion();
        objArr[1] = Integer.valueOf(this._status);
        objArr[2] = this._reason == null ? "" : this._reason;
        objArr[3] = this._fields;
        return String.format("%s %d %s%n%s", objArr);
    }

    public void putHeaders(HttpContent content, long contentLength, boolean etag) {
        HttpField et;
        HttpField lm = content.getLastModified();
        if (lm != null) {
            this._fields.put(lm);
        }
        if (contentLength == -2) {
            this._fields.put(content.getContentLength());
            this._contentLength = content.getContentLengthValue();
        } else if (contentLength > -1) {
            this._fields.putLongField(HttpHeader.CONTENT_LENGTH, contentLength);
            this._contentLength = contentLength;
        }
        HttpField ct = content.getContentType();
        if (ct != null) {
            if (this._characterEncoding == null || content.getCharacterEncoding() != null || content.getContentTypeValue() == null || !__explicitCharset.contains(this._encodingFrom)) {
                this._fields.put(ct);
                this._contentType = ct.getValue();
                this._characterEncoding = content.getCharacterEncoding();
                this._mimeType = content.getMimeType();
            } else {
                setContentType(MimeTypes.getContentTypeWithoutCharset(content.getContentTypeValue()));
            }
        }
        HttpField ce = content.getContentEncoding();
        if (ce != null) {
            this._fields.put(ce);
        }
        if (etag && (et = content.getETag()) != null) {
            this._fields.put(et);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v29, types: [long] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void putHeaders(javax.servlet.http.HttpServletResponse r5, org.eclipse.jetty.http.HttpContent r6, long r7, boolean r9) {
        /*
            r0 = r6
            org.eclipse.jetty.util.resource.Resource r0 = r0.getResource()
            long r0 = r0.lastModified()
            r10 = r0
            r0 = r10
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0020
            r0 = r5
            org.eclipse.jetty.http.HttpHeader r1 = org.eclipse.jetty.http.HttpHeader.LAST_MODIFIED
            java.lang.String r1 = r1.asString()
            r2 = r10
            r0.setDateHeader(r1, r2)
        L_0x0020:
            r0 = r7
            r1 = -2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x002f
            r0 = r6
            long r0 = r0.getContentLengthValue()
            r7 = r0
        L_0x002f:
            r0 = r7
            r1 = -1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x005a
            r0 = r7
            r1 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x004a
            r0 = r5
            r1 = r7
            int r1 = (int) r1
            r0.setContentLength(r1)
            goto L_0x005a
        L_0x004a:
            r0 = r5
            org.eclipse.jetty.http.HttpHeader r1 = org.eclipse.jetty.http.HttpHeader.CONTENT_LENGTH
            java.lang.String r1 = r1.asString()
            r2 = r7
            java.lang.String r2 = java.lang.Long.toString(r2)
            r0.setHeader(r1, r2)
        L_0x005a:
            r0 = r6
            java.lang.String r0 = r0.getContentTypeValue()
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L_0x0078
            r0 = r5
            java.lang.String r0 = r0.getContentType()
            if (r0 != 0) goto L_0x0078
            r0 = r5
            r1 = r12
            r0.setContentType(r1)
        L_0x0078:
            r0 = r6
            java.lang.String r0 = r0.getContentEncodingValue()
            r13 = r0
            r0 = r13
            if (r0 == 0) goto L_0x0093
            r0 = r5
            org.eclipse.jetty.http.HttpHeader r1 = org.eclipse.jetty.http.HttpHeader.CONTENT_ENCODING
            java.lang.String r1 = r1.asString()
            r2 = r13
            r0.setHeader(r1, r2)
        L_0x0093:
            r0 = r9
            if (r0 == 0) goto L_0x00b3
            r0 = r6
            java.lang.String r0 = r0.getETagValue()
            r14 = r0
            r0 = r14
            if (r0 == 0) goto L_0x00b3
            r0 = r5
            org.eclipse.jetty.http.HttpHeader r1 = org.eclipse.jetty.http.HttpHeader.ETAG
            java.lang.String r1 = r1.asString()
            r2 = r14
            r0.setHeader(r1, r2)
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.Response.putHeaders(javax.servlet.http.HttpServletResponse, org.eclipse.jetty.http.HttpContent, long, boolean):void");
    }

    public static HttpServletResponse unwrap(ServletResponse servletResponse) {
        if (servletResponse instanceof HttpServletResponseWrapper) {
            return (HttpServletResponseWrapper) servletResponse;
        }
        if (servletResponse instanceof ServletResponseWrapper) {
            return unwrap(((ServletResponseWrapper) servletResponse).getResponse());
        }
        return (HttpServletResponse) servletResponse;
    }
}
