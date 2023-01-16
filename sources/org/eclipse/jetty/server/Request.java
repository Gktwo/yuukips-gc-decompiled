package org.eclipse.jetty.server;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncListener;
import javax.servlet.DispatcherType;
import javax.servlet.MultipartConfigElement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;
import org.eclipse.jetty.http.BadMessageException;
import org.eclipse.jetty.http.HostPortHttpField;
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.http.HttpCookie;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpHeaderValue;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpScheme;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.http.MetaData;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.RuntimeIOException;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.MultiParts;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.session.Session;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.util.Attributes;
import org.eclipse.jetty.util.AttributesMap;
import org.eclipse.jetty.util.C5747IO;
import org.eclipse.jetty.util.HostPort;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.UrlEncoded;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/Request.class */
public class Request implements HttpServletRequest {
    public static final String MULTIPART_CONFIG_ELEMENT = "org.eclipse.jetty.multipartConfig";
    public static final String MULTIPARTS = "org.eclipse.jetty.multiParts";
    private static final int INPUT_NONE = 0;
    private static final int INPUT_STREAM = 1;
    private static final int INPUT_READER = 2;
    private final HttpChannel _channel;
    private final HttpInput _input;
    private MetaData.Request _metaData;
    private String _originalURI;
    private String _contextPath;
    private String _servletPath;
    private String _pathInfo;
    private boolean _secure;
    private boolean _newContext;
    private boolean _contentParamsExtracted;
    private Attributes _attributes;
    private Authentication _authentication;
    private String _contentType;
    private String _characterEncoding;
    private ContextHandler.Context _context;
    private ContextHandler.Context _errorContext;
    private CookieCutter _cookies;
    private DispatcherType _dispatcherType;
    private BufferedReader _reader;
    private String _readerEncoding;
    private MultiMap<String> _queryParameters;
    private MultiMap<String> _contentParameters;
    private MultiMap<String> _parameters;
    private String _queryEncoding;
    private InetSocketAddress _remote;
    private String _requestedSessionId;
    private UserIdentity.Scope _scope;
    private HttpSession _session;
    private SessionHandler _sessionHandler;
    private long _timeStamp;
    private MultiParts _multiParts;
    private AsyncContextState _async;
    private List<Session> _sessions;
    private static final Logger LOG = Log.getLogger(Request.class);
    private static final Collection<Locale> __defaultLocale = Collections.singleton(Locale.getDefault());
    private static final MultiMap<String> NO_PARAMS = new MultiMap<>();
    private final List<ServletRequestAttributeListener> _requestAttributeListeners = new ArrayList();
    private Object _asyncNotSupportedSource = null;
    private boolean _cookiesExtracted = false;
    private boolean _handled = false;
    private boolean _requestedSessionIdFromCookie = false;
    private int _inputState = 0;

    private static boolean isNoParams(MultiMap<String> inputParameters) {
        return inputParameters == NO_PARAMS;
    }

    public static Request getBaseRequest(ServletRequest request) {
        if (request instanceof Request) {
            return (Request) request;
        }
        Object channel = request.getAttribute(HttpChannel.class.getName());
        if (channel instanceof HttpChannel) {
            return ((HttpChannel) channel).getRequest();
        }
        while (request instanceof ServletRequestWrapper) {
            request = ((ServletRequestWrapper) request).getRequest();
        }
        if (request instanceof Request) {
            return (Request) request;
        }
        return null;
    }

    public Request(HttpChannel channel, HttpInput input) {
        this._channel = channel;
        this._input = input;
    }

    public HttpFields getHttpFields() {
        MetaData.Request metadata = this._metaData;
        if (metadata == null) {
            return null;
        }
        return metadata.getFields();
    }

    public HttpFields getTrailers() {
        MetaData.Request metadata = this._metaData;
        Supplier<HttpFields> trailers = metadata == null ? null : metadata.getTrailerSupplier();
        if (trailers == null) {
            return null;
        }
        return trailers.get();
    }

    public HttpInput getHttpInput() {
        return this._input;
    }

    public boolean isPush() {
        return Boolean.TRUE.equals(getAttribute("org.eclipse.jetty.pushed"));
    }

    public boolean isPushSupported() {
        return !isPush() && getHttpChannel().getHttpTransport().isPushSupported();
    }

    public PushBuilder getPushBuilder() {
        String id;
        if (!isPushSupported()) {
            return null;
        }
        HttpFields fields = new HttpFields(getHttpFields().size() + 5);
        boolean conditional = false;
        Iterator<HttpField> it = getHttpFields().iterator();
        while (it.hasNext()) {
            HttpField field = it.next();
            HttpHeader header = field.getHeader();
            if (header == null) {
                fields.add(field);
            } else {
                switch (header) {
                    case IF_MATCH:
                    case IF_RANGE:
                    case IF_UNMODIFIED_SINCE:
                    case RANGE:
                    case EXPECT:
                    case REFERER:
                    case COOKIE:
                    case AUTHORIZATION:
                        break;
                    case IF_NONE_MATCH:
                    case IF_MODIFIED_SINCE:
                        conditional = true;
                        continue;
                    default:
                        fields.add(field);
                        continue;
                }
            }
        }
        try {
            HttpSession session = getSession();
            if (session != null) {
                session.getLastAccessedTime();
                id = session.getId();
            } else {
                id = getRequestedSessionId();
            }
        } catch (IllegalStateException e) {
            id = getRequestedSessionId();
        }
        PushBuilder builder = new PushBuilderImpl(this, fields, getMethod(), getQueryString(), id, conditional);
        builder.addHeader("referer", getRequestURL().toString());
        return builder;
    }

    public void addEventListener(EventListener listener) {
        if (listener instanceof ServletRequestAttributeListener) {
            this._requestAttributeListeners.add((ServletRequestAttributeListener) listener);
        }
        if (listener instanceof AsyncListener) {
            throw new IllegalArgumentException(listener.getClass().toString());
        }
    }

    public void enterSession(HttpSession s) {
        if (s instanceof Session) {
            if (this._sessions == null) {
                this._sessions = new ArrayList();
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Request {} entering session={}", this, s);
            }
            this._sessions.add((Session) s);
        }
    }

    private void leaveSession(Session session) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request {} leaving session {}", this, session);
        }
        ContextHandler handler = ContextHandler.getContextHandler(session.getServletContext());
        if (handler == null) {
            session.getSessionHandler().complete(session);
        } else {
            handler.handle(this, () -> {
                session.getSessionHandler().complete(session);
            });
        }
    }

    private void commitSession(Session session) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Response {} committing for session {}", this, session);
        }
        ContextHandler handler = ContextHandler.getContextHandler(session.getServletContext());
        if (handler == null) {
            session.getSessionHandler().commit(session);
        } else {
            handler.handle(this, () -> {
                session.getSessionHandler().commit(session);
            });
        }
    }

    private MultiMap<String> getParameters() {
        if (!this._contentParamsExtracted) {
            this._contentParamsExtracted = true;
            if (this._contentParameters == null) {
                try {
                    extractContentParameters();
                } catch (IllegalArgumentException | IllegalStateException e) {
                    LOG.warn(e.toString(), new Object[0]);
                    throw new BadMessageException("Unable to parse form content", e);
                }
            }
        }
        if (this._queryParameters == null) {
            try {
                extractQueryParameters();
            } catch (IllegalArgumentException | IllegalStateException e2) {
                throw new BadMessageException("Unable to parse URI query", e2);
            }
        }
        if (isNoParams(this._queryParameters) || this._queryParameters.size() == 0) {
            this._parameters = this._contentParameters;
        } else if (isNoParams(this._contentParameters) || this._contentParameters.size() == 0) {
            this._parameters = this._queryParameters;
        } else if (this._parameters == null) {
            this._parameters = new MultiMap<>();
            this._parameters.addAllValues(this._queryParameters);
            this._parameters.addAllValues(this._contentParameters);
        }
        MultiMap<String> parameters = this._parameters;
        return parameters == null ? NO_PARAMS : parameters;
    }

    private void extractQueryParameters() {
        MetaData.Request metadata = this._metaData;
        if (metadata == null || metadata.getURI() == null || !metadata.getURI().hasQuery()) {
            this._queryParameters = NO_PARAMS;
            return;
        }
        this._queryParameters = new MultiMap<>();
        if (this._queryEncoding == null) {
            metadata.getURI().decodeQueryTo(this._queryParameters);
            return;
        }
        try {
            metadata.getURI().decodeQueryTo(this._queryParameters, this._queryEncoding);
        } catch (UnsupportedEncodingException e) {
            if (LOG.isDebugEnabled()) {
                LOG.warn(e);
            } else {
                LOG.warn(e.toString(), new Object[0]);
            }
        }
    }

    private boolean isContentEncodingSupported() {
        String contentEncoding = getHttpFields().get(HttpHeader.CONTENT_ENCODING);
        if (contentEncoding == null) {
            return true;
        }
        return HttpHeaderValue.IDENTITY.m41is(contentEncoding);
    }

    private void extractContentParameters() {
        String contentType = getContentType();
        if (contentType == null || contentType.isEmpty()) {
            this._contentParameters = NO_PARAMS;
            return;
        }
        this._contentParameters = new MultiMap<>();
        if (getContentLength() != 0 && this._inputState == 0) {
            String baseType = HttpFields.valueParameters(contentType, null);
            if (!MimeTypes.Type.FORM_ENCODED.m37is(baseType) || !this._channel.getHttpConfiguration().isFormEncodedMethod(getMethod())) {
                if (MimeTypes.Type.MULTIPART_FORM_DATA.m37is(baseType) && getAttribute(MULTIPART_CONFIG_ELEMENT) != null && this._multiParts == null) {
                    try {
                        if (this._metaData == null || isContentEncodingSupported()) {
                            getParts(this._contentParameters);
                            return;
                        }
                        throw new BadMessageException(415, "Unsupported Content-Encoding");
                    } catch (IOException e) {
                        LOG.debug(e);
                        throw new RuntimeIOException(e);
                    }
                }
            } else if (this._metaData == null || isContentEncodingSupported()) {
                extractFormParameters(this._contentParameters);
            } else {
                throw new BadMessageException(415, "Unsupported Content-Encoding");
            }
        }
    }

    public void extractFormParameters(MultiMap<String> params) {
        int maxFormKeys;
        int maxFormContentSize;
        try {
            if (this._context != null) {
                ContextHandler contextHandler = this._context.getContextHandler();
                maxFormContentSize = contextHandler.getMaxFormContentSize();
                maxFormKeys = contextHandler.getMaxFormKeys();
            } else {
                maxFormContentSize = lookupServerAttribute(ContextHandler.MAX_FORM_CONTENT_SIZE_KEY, ContextHandler.DEFAULT_MAX_FORM_CONTENT_SIZE);
                maxFormKeys = lookupServerAttribute(ContextHandler.MAX_FORM_KEYS_KEY, 1000);
            }
            int contentLength = getContentLength();
            if (maxFormContentSize < 0 || contentLength <= maxFormContentSize) {
                InputStream in = getInputStream();
                if (this._input.isAsync()) {
                    throw new IllegalStateException("Cannot extract parameters with async IO");
                }
                UrlEncoded.decodeTo(in, params, getCharacterEncoding(), maxFormContentSize, maxFormKeys);
                return;
            }
            throw new IllegalStateException("Form is larger than max length " + maxFormContentSize);
        } catch (IOException e) {
            LOG.debug(e);
            throw new RuntimeIOException(e);
        }
    }

    private int lookupServerAttribute(String key, int dftValue) {
        Object attribute = this._channel.getServer().getAttribute(key);
        if (attribute instanceof Number) {
            return ((Number) attribute).intValue();
        }
        if (attribute instanceof String) {
            return Integer.parseInt((String) attribute);
        }
        return dftValue;
    }

    @Override // javax.servlet.ServletRequest
    public AsyncContext getAsyncContext() {
        HttpChannelState state = getHttpChannelState();
        if (this._async != null && state.isAsyncStarted()) {
            return this._async;
        }
        throw new IllegalStateException(state.getStatusString());
    }

    public HttpChannelState getHttpChannelState() {
        return this._channel.getState();
    }

    @Override // javax.servlet.ServletRequest
    public Object getAttribute(String name) {
        if (name.startsWith("org.eclipse.jetty")) {
            if (Server.class.getName().equals(name)) {
                return this._channel.getServer();
            }
            if (HttpChannel.class.getName().equals(name)) {
                return this._channel;
            }
            if (HttpConnection.class.getName().equals(name) && (this._channel.getHttpTransport() instanceof HttpConnection)) {
                return this._channel.getHttpTransport();
            }
        }
        if (this._attributes == null) {
            return null;
        }
        return this._attributes.getAttribute(name);
    }

    @Override // javax.servlet.ServletRequest
    public Enumeration<String> getAttributeNames() {
        if (this._attributes == null) {
            return Collections.enumeration(Collections.emptyList());
        }
        return AttributesMap.getAttributeNamesCopy(this._attributes);
    }

    public Attributes getAttributes() {
        if (this._attributes == null) {
            this._attributes = new ServletAttributes();
        }
        return this._attributes;
    }

    public Authentication getAuthentication() {
        return this._authentication;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getAuthType() {
        if (this._authentication instanceof Authentication.Deferred) {
            setAuthentication(((Authentication.Deferred) this._authentication).authenticate(this));
        }
        if (this._authentication instanceof Authentication.User) {
            return ((Authentication.User) this._authentication).getAuthMethod();
        }
        return null;
    }

    @Override // javax.servlet.ServletRequest
    public String getCharacterEncoding() {
        String contentType;
        if (this._characterEncoding == null && (contentType = getContentType()) != null) {
            MimeTypes.Type mime = MimeTypes.CACHE.get(contentType);
            String charset = (mime == null || mime.getCharset() == null) ? MimeTypes.getCharsetFromContentType(contentType) : mime.getCharset().toString();
            if (charset != null) {
                this._characterEncoding = charset;
            }
        }
        return this._characterEncoding;
    }

    public HttpChannel getHttpChannel() {
        return this._channel;
    }

    @Override // javax.servlet.ServletRequest
    public int getContentLength() {
        MetaData.Request metadata = this._metaData;
        if (metadata == null) {
            return -1;
        }
        long contentLength = metadata.getContentLength();
        if (contentLength == Long.MIN_VALUE) {
            return (int) metadata.getFields().getLongField(HttpHeader.CONTENT_LENGTH.asString());
        }
        if (contentLength > 2147483647L) {
            return -1;
        }
        return (int) contentLength;
    }

    @Override // javax.servlet.ServletRequest
    public long getContentLengthLong() {
        MetaData.Request metadata = this._metaData;
        if (metadata == null) {
            return -1;
        }
        if (metadata.getContentLength() != Long.MIN_VALUE) {
            return metadata.getContentLength();
        }
        return metadata.getFields().getLongField(HttpHeader.CONTENT_LENGTH.asString());
    }

    public long getContentRead() {
        return this._input.getContentConsumed();
    }

    @Override // javax.servlet.ServletRequest
    public String getContentType() {
        if (this._contentType == null) {
            MetaData.Request metadata = this._metaData;
            this._contentType = metadata == null ? null : metadata.getFields().get(HttpHeader.CONTENT_TYPE);
        }
        return this._contentType;
    }

    public ContextHandler.Context getContext() {
        return this._context;
    }

    public ContextHandler.Context getErrorContext() {
        ContextHandler handler;
        if (!isAsyncStarted() || (handler = this._channel.getState().getContextHandler()) == null) {
            return this._errorContext;
        }
        return handler.getServletContext();
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getContextPath() {
        return this._contextPath;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Cookie[] getCookies() {
        MetaData.Request metadata = this._metaData;
        if (metadata != null && !this._cookiesExtracted) {
            this._cookiesExtracted = true;
            Iterator<HttpField> it = metadata.getFields().iterator();
            while (it.hasNext()) {
                HttpField field = it.next();
                if (field.getHeader() == HttpHeader.COOKIE) {
                    if (this._cookies == null) {
                        this._cookies = new CookieCutter(getHttpChannel().getHttpConfiguration().getRequestCookieCompliance());
                    }
                    this._cookies.addCookieField(field.getValue());
                }
            }
            if (this._cookies == null || this._cookies.getCookies().length == 0) {
                return null;
            }
            return this._cookies.getCookies();
        } else if (this._cookies == null || this._cookies.getCookies().length == 0) {
            return null;
        } else {
            return this._cookies.getCookies();
        }
    }

    @Override // javax.servlet.http.HttpServletRequest
    public long getDateHeader(String name) {
        MetaData.Request metadata = this._metaData;
        if (metadata == null) {
            return -1;
        }
        return metadata.getFields().getDateField(name);
    }

    @Override // javax.servlet.ServletRequest
    public DispatcherType getDispatcherType() {
        return this._dispatcherType;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getHeader(String name) {
        MetaData.Request metadata = this._metaData;
        if (metadata == null) {
            return null;
        }
        return metadata.getFields().get(name);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Enumeration<String> getHeaderNames() {
        MetaData.Request metadata = this._metaData;
        return metadata == null ? Collections.emptyEnumeration() : metadata.getFields().getFieldNames();
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Enumeration<String> getHeaders(String name) {
        MetaData.Request metadata = this._metaData;
        if (metadata == null) {
            return Collections.emptyEnumeration();
        }
        Enumeration<String> e = metadata.getFields().getValues(name);
        if (e == null) {
            return Collections.enumeration(Collections.emptyList());
        }
        return e;
    }

    public int getInputState() {
        return this._inputState;
    }

    @Override // javax.servlet.ServletRequest
    public ServletInputStream getInputStream() throws IOException {
        if (this._inputState == 0 || this._inputState == 1) {
            this._inputState = 1;
            if (this._channel.isExpecting100Continue()) {
                this._channel.continue100(this._input.available());
            }
            return this._input;
        }
        throw new IllegalStateException("READER");
    }

    @Override // javax.servlet.http.HttpServletRequest
    public int getIntHeader(String name) {
        MetaData.Request metadata = this._metaData;
        if (metadata == null) {
            return -1;
        }
        return (int) metadata.getFields().getLongField(name);
    }

    @Override // javax.servlet.ServletRequest
    public Locale getLocale() {
        MetaData.Request metadata = this._metaData;
        if (metadata == null) {
            return Locale.getDefault();
        }
        List<String> acceptable = metadata.getFields().getQualityCSV(HttpHeader.ACCEPT_LANGUAGE);
        if (acceptable.isEmpty()) {
            return Locale.getDefault();
        }
        String language = HttpFields.stripParameters(acceptable.get(0));
        String country = "";
        int dash = language.indexOf(45);
        if (dash > -1) {
            country = language.substring(dash + 1).trim();
            language = language.substring(0, dash).trim();
        }
        return new Locale(language, country);
    }

    @Override // javax.servlet.ServletRequest
    public Enumeration<Locale> getLocales() {
        MetaData.Request metadata = this._metaData;
        if (metadata == null) {
            return Collections.enumeration(__defaultLocale);
        }
        List<String> acceptable = metadata.getFields().getQualityCSV(HttpHeader.ACCEPT_LANGUAGE);
        if (acceptable.isEmpty()) {
            return Collections.enumeration(__defaultLocale);
        }
        return Collections.enumeration((List) acceptable.stream().map(language -> {
            String language2 = HttpFields.stripParameters(language);
            String country = "";
            int dash = language2.indexOf(45);
            if (dash > -1) {
                country = language2.substring(dash + 1).trim();
                language2 = language2.substring(0, dash).trim();
            }
            return new Locale(language2, country);
        }).collect(Collectors.toList()));
    }

    @Override // javax.servlet.ServletRequest
    public String getLocalAddr() {
        InetSocketAddress local;
        String result;
        if (this._channel == null || (local = this._channel.getLocalAddress()) == null) {
            return "";
        }
        InetAddress address = local.getAddress();
        if (address == null) {
            result = local.getHostString();
        } else {
            result = address.getHostAddress();
        }
        return formatAddrOrHost(result);
    }

    @Override // javax.servlet.ServletRequest
    public String getLocalName() {
        if (this._channel != null) {
            return formatAddrOrHost(this._channel.getLocalName());
        }
        return "";
    }

    @Override // javax.servlet.ServletRequest
    public int getLocalPort() {
        int localPort;
        if (this._channel == null || (localPort = this._channel.getLocalPort()) <= 0) {
            return 0;
        }
        return localPort;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getMethod() {
        MetaData.Request metadata = this._metaData;
        if (metadata == null) {
            return null;
        }
        return metadata.getMethod();
    }

    @Override // javax.servlet.ServletRequest
    public String getParameter(String name) {
        return getParameters().getValue(name, 0);
    }

    @Override // javax.servlet.ServletRequest
    public Map<String, String[]> getParameterMap() {
        return Collections.unmodifiableMap(getParameters().toStringArrayMap());
    }

    @Override // javax.servlet.ServletRequest
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(getParameters().keySet());
    }

    @Override // javax.servlet.ServletRequest
    public String[] getParameterValues(String name) {
        List<String> vals = getParameters().getValues(name);
        if (vals == null) {
            return null;
        }
        return (String[]) vals.toArray(new String[vals.size()]);
    }

    public MultiMap<String> getQueryParameters() {
        return this._queryParameters;
    }

    public void setQueryParameters(MultiMap<String> queryParameters) {
        this._queryParameters = queryParameters;
    }

    public void setContentParameters(MultiMap<String> contentParameters) {
        this._contentParameters = contentParameters;
    }

    public void resetParameters() {
        this._parameters = null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getPathInfo() {
        return this._pathInfo;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getPathTranslated() {
        if (this._pathInfo == null || this._context == null) {
            return null;
        }
        return this._context.getRealPath(this._pathInfo);
    }

    @Override // javax.servlet.ServletRequest
    public String getProtocol() {
        HttpVersion version;
        MetaData.Request metadata = this._metaData;
        if (metadata == null || (version = metadata.getHttpVersion()) == null) {
            return null;
        }
        return version.toString();
    }

    public HttpVersion getHttpVersion() {
        MetaData.Request metadata = this._metaData;
        if (metadata == null) {
            return null;
        }
        return metadata.getHttpVersion();
    }

    public String getQueryEncoding() {
        return this._queryEncoding;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getQueryString() {
        MetaData.Request metadata = this._metaData;
        if (metadata == null) {
            return null;
        }
        return metadata.getURI().getQuery();
    }

    @Override // javax.servlet.ServletRequest
    public BufferedReader getReader() throws IOException {
        if (this._inputState != 0 && this._inputState != 2) {
            throw new IllegalStateException("STREAMED");
        } else if (this._inputState == 2) {
            return this._reader;
        } else {
            String encoding = getCharacterEncoding();
            if (encoding == null) {
                encoding = StringUtil.__ISO_8859_1;
            }
            if (this._reader == null || !encoding.equalsIgnoreCase(this._readerEncoding)) {
                final ServletInputStream in = getInputStream();
                this._readerEncoding = encoding;
                this._reader = new BufferedReader(new InputStreamReader(in, encoding)) { // from class: org.eclipse.jetty.server.Request.1
                    @Override // java.io.BufferedReader, java.io.Closeable, java.io.Reader, java.lang.AutoCloseable
                    public void close() throws IOException {
                        in.close();
                    }
                };
            }
            this._inputState = 2;
            return this._reader;
        }
    }

    @Override // javax.servlet.ServletRequest
    public String getRealPath(String path) {
        if (this._context == null) {
            return null;
        }
        return this._context.getRealPath(path);
    }

    public InetSocketAddress getRemoteInetSocketAddress() {
        InetSocketAddress remote = this._remote;
        if (remote == null) {
            remote = this._channel.getRemoteAddress();
        }
        return remote;
    }

    @Override // javax.servlet.ServletRequest
    public String getRemoteAddr() {
        String result;
        InetSocketAddress remote = this._remote;
        if (remote == null) {
            remote = this._channel.getRemoteAddress();
        }
        if (remote == null) {
            return "";
        }
        InetAddress address = remote.getAddress();
        if (address == null) {
            result = remote.getHostString();
        } else {
            result = address.getHostAddress();
        }
        return formatAddrOrHost(result);
    }

    @Override // javax.servlet.ServletRequest
    public String getRemoteHost() {
        InetSocketAddress remote = this._remote;
        if (remote == null) {
            remote = this._channel.getRemoteAddress();
        }
        if (remote == null) {
            return "";
        }
        return formatAddrOrHost(remote.getHostString());
    }

    @Override // javax.servlet.ServletRequest
    public int getRemotePort() {
        InetSocketAddress remote = this._remote;
        if (remote == null) {
            remote = this._channel.getRemoteAddress();
        }
        if (remote == null) {
            return 0;
        }
        return remote.getPort();
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getRemoteUser() {
        Principal p = getUserPrincipal();
        if (p == null) {
            return null;
        }
        return p.getName();
    }

    @Override // javax.servlet.ServletRequest
    public RequestDispatcher getRequestDispatcher(String path) {
        String relTo;
        String path2 = URIUtil.compactPath(path);
        if (path2 == null || this._context == null) {
            return null;
        }
        if (!path2.startsWith("/")) {
            String relTo2 = URIUtil.addPaths(this._servletPath, this._pathInfo);
            int slash = relTo2.lastIndexOf("/");
            if (slash > 1) {
                relTo = relTo2.substring(0, slash + 1);
            } else {
                relTo = "/";
            }
            path2 = URIUtil.addPaths(relTo, path2);
        }
        return this._context.getRequestDispatcher(path2);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getRequestedSessionId() {
        return this._requestedSessionId;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getRequestURI() {
        MetaData.Request metadata = this._metaData;
        if (metadata == null) {
            return null;
        }
        return metadata.getURI().getPath();
    }

    @Override // javax.servlet.http.HttpServletRequest
    public StringBuffer getRequestURL() {
        StringBuffer url = new StringBuffer(128);
        URIUtil.appendSchemeHostPort(url, getScheme(), getServerName(), getServerPort());
        url.append(getRequestURI());
        return url;
    }

    public Response getResponse() {
        return this._channel.getResponse();
    }

    public StringBuilder getRootURL() {
        StringBuilder url = new StringBuilder(128);
        URIUtil.appendSchemeHostPort(url, getScheme(), getServerName(), getServerPort());
        return url;
    }

    @Override // javax.servlet.ServletRequest
    public String getScheme() {
        MetaData.Request metadata = this._metaData;
        String scheme = metadata == null ? null : metadata.getURI().getScheme();
        return scheme == null ? HttpScheme.HTTP.asString() : scheme;
    }

    @Override // javax.servlet.ServletRequest
    public String getServerName() {
        MetaData.Request metadata = this._metaData;
        String name = metadata == null ? null : formatAddrOrHost(metadata.getURI().getHost());
        if (name != null) {
            return name;
        }
        return findServerName();
    }

    private String findServerName() {
        HostPort serverAuthority;
        MetaData.Request metadata = this._metaData;
        HttpField host = metadata == null ? null : metadata.getFields().getField(HttpHeader.HOST);
        if (host != null) {
            if (!(host instanceof HostPortHttpField) && host.getValue() != null && !host.getValue().isEmpty()) {
                host = new HostPortHttpField(host.getValue());
            }
            if (host instanceof HostPortHttpField) {
                HostPortHttpField authority = (HostPortHttpField) host;
                metadata.getURI().setAuthority(authority.getHost(), authority.getPort());
                return formatAddrOrHost(authority.getHost());
            }
        }
        if (this._channel != null && (serverAuthority = this._channel.getServerAuthority()) != null) {
            return formatAddrOrHost(serverAuthority.getHost());
        }
        String name = getLocalName();
        if (name != null) {
            return formatAddrOrHost(name);
        }
        return "";
    }

    @Override // javax.servlet.ServletRequest
    public int getServerPort() {
        MetaData.Request metadata = this._metaData;
        HttpURI uri = metadata == null ? null : metadata.getURI();
        int port = (uri == null || uri.getHost() == null) ? findServerPort() : uri.getPort();
        if (port > 0) {
            return port;
        }
        if (HttpScheme.HTTPS.m39is(getScheme())) {
            return PacketOpcodes.AddQuestContentProgressReq;
        }
        return 80;
    }

    private int findServerPort() {
        HostPort serverAuthority;
        HostPortHttpField authority;
        MetaData.Request metadata = this._metaData;
        HttpField host = metadata == null ? null : metadata.getFields().getField(HttpHeader.HOST);
        if (host != null) {
            if (host instanceof HostPortHttpField) {
                authority = (HostPortHttpField) host;
            } else {
                authority = new HostPortHttpField(host.getValue());
            }
            if (authority.getHostPort().hasHost() && authority.getHostPort().hasPort()) {
                metadata.getURI().setAuthority(authority.getHost(), authority.getPort());
                return authority.getPort();
            }
        }
        if (this._channel == null || (serverAuthority = this._channel.getServerAuthority()) == null) {
            return getLocalPort();
        }
        return serverAuthority.getPort();
    }

    @Override // javax.servlet.ServletRequest
    public ServletContext getServletContext() {
        return this._context;
    }

    public String getServletName() {
        if (this._scope != null) {
            return this._scope.getName();
        }
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getServletPath() {
        if (this._servletPath == null) {
            this._servletPath = "";
        }
        return this._servletPath;
    }

    public ServletResponse getServletResponse() {
        return this._channel.getResponse();
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String changeSessionId() {
        HttpSession session = getSession(false);
        if (session == null) {
            throw new IllegalStateException("No session");
        }
        if (session instanceof Session) {
            Session s = (Session) session;
            s.renewId(this);
            if (getRemoteUser() != null) {
                s.setAttribute(Session.SESSION_CREATED_SECURE, Boolean.TRUE);
            }
            if (s.isIdChanged() && this._sessionHandler.isUsingCookies()) {
                this._channel.getResponse().replaceCookie(this._sessionHandler.getSessionCookie(s, getContextPath(), isSecure()));
            }
        }
        return session.getId();
    }

    public void onCompleted() {
        if (this._sessions != null) {
            for (Session s : this._sessions) {
                leaveSession(s);
            }
        }
    }

    public void onResponseCommit() {
        if (this._sessions != null) {
            for (Session s : this._sessions) {
                commitSession(s);
            }
        }
    }

    public HttpSession getSession(SessionHandler sessionHandler) {
        if (this._sessions == null || this._sessions.size() == 0 || sessionHandler == null) {
            return null;
        }
        HttpSession session = null;
        for (HttpSession s : this._sessions) {
            Session ss = (Session) Session.class.cast(s);
            if (sessionHandler == ss.getSessionHandler()) {
                session = s;
                if (ss.isValid()) {
                    return session;
                }
            }
        }
        return session;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public HttpSession getSession() {
        return getSession(true);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public HttpSession getSession(boolean create) {
        if (this._session != null) {
            if (this._sessionHandler == null || this._sessionHandler.isValid(this._session)) {
                return this._session;
            }
            this._session = null;
        }
        if (!create) {
            return null;
        }
        if (getResponse().isCommitted()) {
            throw new IllegalStateException("Response is committed");
        } else if (this._sessionHandler == null) {
            throw new IllegalStateException("No SessionManager");
        } else {
            this._session = this._sessionHandler.newHttpSession(this);
            if (this._session == null) {
                throw new IllegalStateException("Create session failed");
            }
            HttpCookie cookie = this._sessionHandler.getSessionCookie(this._session, getContextPath(), isSecure());
            if (cookie != null) {
                this._channel.getResponse().replaceCookie(cookie);
            }
            return this._session;
        }
    }

    public SessionHandler getSessionHandler() {
        return this._sessionHandler;
    }

    public long getTimeStamp() {
        return this._timeStamp;
    }

    public HttpURI getHttpURI() {
        MetaData.Request metadata = this._metaData;
        if (metadata == null) {
            return null;
        }
        return metadata.getURI();
    }

    public String getOriginalURI() {
        return this._originalURI;
    }

    public void setHttpURI(HttpURI uri) {
        this._metaData.setURI(uri);
    }

    public UserIdentity getUserIdentity() {
        if (this._authentication instanceof Authentication.Deferred) {
            setAuthentication(((Authentication.Deferred) this._authentication).authenticate(this));
        }
        if (this._authentication instanceof Authentication.User) {
            return ((Authentication.User) this._authentication).getUserIdentity();
        }
        return null;
    }

    public UserIdentity getResolvedUserIdentity() {
        if (this._authentication instanceof Authentication.User) {
            return ((Authentication.User) this._authentication).getUserIdentity();
        }
        return null;
    }

    public UserIdentity.Scope getUserIdentityScope() {
        return this._scope;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Principal getUserPrincipal() {
        if (this._authentication instanceof Authentication.Deferred) {
            setAuthentication(((Authentication.Deferred) this._authentication).authenticate(this));
        }
        if (this._authentication instanceof Authentication.User) {
            return ((Authentication.User) this._authentication).getUserIdentity().getUserPrincipal();
        }
        return null;
    }

    public boolean isHandled() {
        return this._handled;
    }

    @Override // javax.servlet.ServletRequest
    public boolean isAsyncStarted() {
        return getHttpChannelState().isAsyncStarted();
    }

    @Override // javax.servlet.ServletRequest
    public boolean isAsyncSupported() {
        return this._asyncNotSupportedSource == null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isRequestedSessionIdFromCookie() {
        return this._requestedSessionId != null && this._requestedSessionIdFromCookie;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isRequestedSessionIdFromUrl() {
        return this._requestedSessionId != null && !this._requestedSessionIdFromCookie;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isRequestedSessionIdFromURL() {
        return this._requestedSessionId != null && !this._requestedSessionIdFromCookie;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isRequestedSessionIdValid() {
        HttpSession session;
        return (this._requestedSessionId == null || (session = getSession(false)) == null || !this._sessionHandler.getSessionIdManager().getId(this._requestedSessionId).equals(this._sessionHandler.getId(session))) ? false : true;
    }

    @Override // javax.servlet.ServletRequest
    public boolean isSecure() {
        return this._secure;
    }

    public void setSecure(boolean secure) {
        this._secure = secure;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isUserInRole(String role) {
        if (this._authentication instanceof Authentication.Deferred) {
            setAuthentication(((Authentication.Deferred) this._authentication).authenticate(this));
        }
        if (this._authentication instanceof Authentication.User) {
            return ((Authentication.User) this._authentication).isUserInRole(this._scope, role);
        }
        return false;
    }

    public void setMetaData(MetaData.Request request) {
        String encoded;
        String path;
        HttpCompliance compliance;
        if (!(this._metaData != null || this._input == null || this._channel == null)) {
            this._input.recycle();
            this._channel.getResponse().getHttpOutput().reopen();
        }
        this._metaData = request;
        setMethod(request.getMethod());
        HttpURI uri = request.getURI();
        if (uri.hasViolations()) {
            Connection connection = this._channel == null ? null : this._channel.getConnection();
            if (connection instanceof HttpConnection) {
                compliance = ((HttpConnection) connection).getHttpCompliance();
            } else {
                compliance = this._channel != null ? (HttpCompliance) this._channel.getConnector().getBean(HttpCompliance.class) : null;
            }
            String badMessage = HttpCompliance.checkUriCompliance(compliance, uri);
            if (badMessage != null) {
                throw new BadMessageException(badMessage);
            }
        }
        if (HttpMethod.CONNECT.m40is(request.getMethod())) {
            this._originalURI = uri.getAuthority();
            encoded = "/";
        } else {
            this._originalURI = (!uri.isAbsolute() || request.getHttpVersion() == HttpVersion.HTTP_2) ? uri.getPathQuery() : uri.toString();
            encoded = uri.getPath();
        }
        if (encoded == null) {
            path = uri.isAbsolute() ? "/" : null;
            uri.setPath(path);
        } else if (encoded.startsWith("/")) {
            path = encoded.length() == 1 ? "/" : uri.getDecodedPath();
        } else if ("*".equals(encoded) || HttpMethod.CONNECT.m40is(getMethod())) {
            path = encoded;
        } else {
            path = null;
        }
        if (path == null || path.isEmpty()) {
            setPathInfo(encoded == null ? "" : encoded);
            throw new BadMessageException(400, "Bad URI");
        } else {
            setPathInfo(path);
        }
    }

    public MetaData.Request getMetaData() {
        return this._metaData;
    }

    public boolean hasMetaData() {
        return this._metaData != null;
    }

    /* access modifiers changed from: protected */
    public void recycle() {
        if (this._context != null) {
            throw new IllegalStateException("Request in context!");
        }
        if (this._reader != null && this._inputState == 2) {
            try {
                int r = this._reader.read();
                while (r != -1) {
                    r = this._reader.read();
                }
            } catch (Exception e) {
                LOG.ignore(e);
                this._reader = null;
                this._readerEncoding = null;
            }
        }
        getHttpChannelState().recycle();
        this._requestAttributeListeners.clear();
        this._metaData = null;
        this._originalURI = null;
        this._contextPath = null;
        this._servletPath = null;
        this._pathInfo = null;
        this._asyncNotSupportedSource = null;
        this._secure = false;
        this._newContext = false;
        this._cookiesExtracted = false;
        this._handled = false;
        this._contentParamsExtracted = false;
        this._requestedSessionIdFromCookie = false;
        this._attributes = Attributes.unwrap(this._attributes);
        if (this._attributes != null) {
            if (ServletAttributes.class.equals(this._attributes.getClass())) {
                this._attributes.clearAttributes();
            } else {
                this._attributes = null;
            }
        }
        setAuthentication(Authentication.NOT_CHECKED);
        this._contentType = null;
        this._characterEncoding = null;
        this._context = null;
        this._errorContext = null;
        if (this._cookies != null) {
            this._cookies.reset();
        }
        this._dispatcherType = null;
        this._inputState = 0;
        this._queryParameters = null;
        this._contentParameters = null;
        this._parameters = null;
        this._queryEncoding = null;
        this._remote = null;
        this._requestedSessionId = null;
        this._scope = null;
        this._session = null;
        this._sessionHandler = null;
        this._timeStamp = 0;
        this._multiParts = null;
        if (this._async != null) {
            this._async.reset();
        }
        this._async = null;
        this._sessions = null;
    }

    @Override // javax.servlet.ServletRequest
    public void removeAttribute(String name) {
        Object oldValue = this._attributes == null ? null : this._attributes.getAttribute(name);
        if (this._attributes != null) {
            this._attributes.removeAttribute(name);
        }
        if (!(oldValue == null || this._requestAttributeListeners.isEmpty())) {
            ServletRequestAttributeEvent event = new ServletRequestAttributeEvent(this._context, this, name, oldValue);
            for (ServletRequestAttributeListener listener : this._requestAttributeListeners) {
                listener.attributeRemoved(event);
            }
        }
    }

    public void removeEventListener(EventListener listener) {
        this._requestAttributeListeners.remove(listener);
    }

    public void setAsyncSupported(boolean supported, Object source) {
        this._asyncNotSupportedSource = supported ? null : source == null ? "unknown" : source;
    }

    @Override // javax.servlet.ServletRequest
    public void setAttribute(String name, Object value) {
        Object oldValue = this._attributes == null ? null : this._attributes.getAttribute(name);
        if ("org.eclipse.jetty.server.Request.queryEncoding".equals(name)) {
            setQueryEncoding(value == null ? null : value.toString());
        } else if ("org.eclipse.jetty.server.sendContent".equals(name)) {
            LOG.warn("Deprecated: org.eclipse.jetty.server.sendContent", new Object[0]);
        }
        if (this._attributes == null) {
            this._attributes = new ServletAttributes();
        }
        this._attributes.setAttribute(name, value);
        if (!this._requestAttributeListeners.isEmpty()) {
            ServletRequestAttributeEvent event = new ServletRequestAttributeEvent(this._context, this, name, oldValue == null ? value : oldValue);
            for (ServletRequestAttributeListener l : this._requestAttributeListeners) {
                if (oldValue == null) {
                    l.attributeAdded(event);
                } else if (value == null) {
                    l.attributeRemoved(event);
                } else {
                    l.attributeReplaced(event);
                }
            }
        }
    }

    public void setAttributes(Attributes attributes) {
        this._attributes = attributes;
    }

    public void setAsyncAttributes() {
        String queryString;
        String pathInfo;
        String servletPath;
        String contextPath;
        Attributes baseAttributes;
        if (getAttribute(AsyncContext.ASYNC_REQUEST_URI) == null) {
            String requestURI = (String) getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);
            if (requestURI != null) {
                contextPath = (String) getAttribute(RequestDispatcher.FORWARD_CONTEXT_PATH);
                servletPath = (String) getAttribute(RequestDispatcher.FORWARD_SERVLET_PATH);
                pathInfo = (String) getAttribute(RequestDispatcher.FORWARD_PATH_INFO);
                queryString = (String) getAttribute(RequestDispatcher.FORWARD_QUERY_STRING);
            } else {
                requestURI = getRequestURI();
                contextPath = getContextPath();
                servletPath = getServletPath();
                pathInfo = getPathInfo();
                queryString = getQueryString();
            }
            if (this._attributes == null) {
                ServletAttributes servletAttributes = new ServletAttributes();
                baseAttributes = servletAttributes;
                this._attributes = servletAttributes;
            } else {
                baseAttributes = Attributes.unwrap(this._attributes);
            }
            if (baseAttributes instanceof ServletAttributes) {
                ((ServletAttributes) baseAttributes).setAsyncAttributes(requestURI, contextPath, servletPath, pathInfo, queryString);
            } else {
                AsyncAttributes.applyAsyncAttributes(this._attributes, requestURI, contextPath, servletPath, pathInfo, queryString);
            }
        }
    }

    public void setAuthentication(Authentication authentication) {
        this._authentication = authentication;
    }

    @Override // javax.servlet.ServletRequest
    public void setCharacterEncoding(String encoding) throws UnsupportedEncodingException {
        if (this._inputState == 0) {
            this._characterEncoding = encoding;
            if (!StringUtil.isUTF8(encoding)) {
                try {
                    Charset.forName(encoding);
                } catch (UnsupportedCharsetException e) {
                    throw new UnsupportedEncodingException(e.getMessage());
                }
            }
        }
    }

    public void setCharacterEncodingUnchecked(String encoding) {
        this._characterEncoding = encoding;
    }

    public void setContentType(String contentType) {
        this._contentType = contentType;
    }

    public void setContext(ContextHandler.Context context) {
        this._newContext = this._context != context;
        if (context == null) {
            this._context = null;
            return;
        }
        this._context = context;
        this._errorContext = context;
    }

    public boolean takeNewContext() {
        boolean nc = this._newContext;
        this._newContext = false;
        return nc;
    }

    public void setContextPath(String contextPath) {
        this._contextPath = contextPath;
    }

    public void setCookies(Cookie[] cookies) {
        if (this._cookies == null) {
            this._cookies = new CookieCutter(getHttpChannel().getHttpConfiguration().getRequestCookieCompliance());
        }
        this._cookies.setCookies(cookies);
    }

    public void setDispatcherType(DispatcherType type) {
        this._dispatcherType = type;
    }

    public void setHandled(boolean h) {
        this._handled = h;
    }

    public void setMethod(String method) {
        MetaData.Request metadata = this._metaData;
        if (metadata != null) {
            metadata.setMethod(method);
        }
    }

    public void setHttpVersion(HttpVersion version) {
        MetaData.Request metadata = this._metaData;
        if (metadata != null) {
            metadata.setHttpVersion(version);
        }
    }

    public boolean isHead() {
        MetaData.Request metadata = this._metaData;
        return metadata != null && HttpMethod.HEAD.m40is(metadata.getMethod());
    }

    public void setPathInfo(String pathInfo) {
        this._pathInfo = pathInfo;
    }

    public void setQueryEncoding(String queryEncoding) {
        this._queryEncoding = queryEncoding;
    }

    public void setQueryString(String queryString) {
        MetaData.Request metadata = this._metaData;
        if (metadata != null) {
            metadata.getURI().setQuery(queryString);
        }
        this._queryEncoding = null;
    }

    public void setRemoteAddr(InetSocketAddress addr) {
        this._remote = addr;
    }

    public void setRequestedSessionId(String requestedSessionId) {
        this._requestedSessionId = requestedSessionId;
    }

    public void setRequestedSessionIdFromCookie(boolean requestedSessionIdCookie) {
        this._requestedSessionIdFromCookie = requestedSessionIdCookie;
    }

    public void setURIPathQuery(String requestURI) {
        MetaData.Request metadata = this._metaData;
        if (metadata != null) {
            metadata.getURI().setPathQuery(requestURI);
        }
    }

    public void setScheme(String scheme) {
        MetaData.Request metadata = this._metaData;
        if (metadata != null) {
            metadata.getURI().setScheme(scheme);
        }
    }

    public void setAuthority(String host, int port) {
        MetaData.Request metadata = this._metaData;
        if (metadata != null) {
            metadata.getURI().setAuthority(host, port);
        }
    }

    public void setServletPath(String servletPath) {
        this._servletPath = servletPath;
    }

    public void setSession(HttpSession session) {
        this._session = session;
    }

    public void setSessionHandler(SessionHandler sessionHandler) {
        this._sessionHandler = sessionHandler;
    }

    public void setTimeStamp(long ts) {
        this._timeStamp = ts;
    }

    public void setUserIdentityScope(UserIdentity.Scope scope) {
        this._scope = scope;
    }

    @Override // javax.servlet.ServletRequest
    public AsyncContext startAsync() throws IllegalStateException {
        if (this._asyncNotSupportedSource != null) {
            throw new IllegalStateException("!asyncSupported: " + this._asyncNotSupportedSource);
        }
        HttpChannelState state = getHttpChannelState();
        if (this._async == null) {
            this._async = new AsyncContextState(state);
        }
        state.startAsync(new AsyncContextEvent(this._context, this._async, state, this, this, getResponse()));
        return this._async;
    }

    @Override // javax.servlet.ServletRequest
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        String uri;
        if (this._asyncNotSupportedSource != null) {
            throw new IllegalStateException("!asyncSupported: " + this._asyncNotSupportedSource);
        }
        HttpChannelState state = getHttpChannelState();
        if (this._async == null) {
            this._async = new AsyncContextState(state);
        }
        AsyncContextEvent event = new AsyncContextEvent(this._context, this._async, state, this, servletRequest, servletResponse);
        event.setDispatchContext(getServletContext());
        String uri2 = unwrap(servletRequest).getRequestURI();
        if (this._contextPath == null || !uri2.startsWith(this._contextPath)) {
            uri = URIUtil.encodePath(URIUtil.addPaths(getServletPath(), getPathInfo()));
        } else {
            uri = uri2.substring(this._contextPath.length());
        }
        event.setDispatchPath(uri);
        state.startAsync(event);
        return this._async;
    }

    public static HttpServletRequest unwrap(ServletRequest servletRequest) {
        if (servletRequest instanceof HttpServletRequestWrapper) {
            return (HttpServletRequestWrapper) servletRequest;
        }
        if (servletRequest instanceof ServletRequestWrapper) {
            return unwrap(((ServletRequestWrapper) servletRequest).getRequest());
        }
        return (HttpServletRequest) servletRequest;
    }

    public String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = getClass().getSimpleName();
        objArr[1] = this._handled ? "[" : "(";
        objArr[2] = getMethod();
        objArr[3] = getHttpURI();
        objArr[4] = this._handled ? "]" : ")";
        objArr[5] = Integer.valueOf(hashCode());
        return String.format("%s%s%s %s%s@%x", objArr);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
        if (this._authentication instanceof Authentication.Deferred) {
            setAuthentication(((Authentication.Deferred) this._authentication).authenticate(this, response));
            return !(this._authentication instanceof Authentication.ResponseSent);
        }
        response.sendError(401);
        return false;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Part getPart(String name) throws IOException, ServletException {
        getParts();
        return this._multiParts.getPart(name);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Collection<Part> getParts() throws IOException, ServletException {
        String contentType = getContentType();
        if (contentType != null && MimeTypes.Type.MULTIPART_FORM_DATA.m37is(HttpFields.valueParameters(contentType, null))) {
            return getParts(null);
        }
        throw new ServletException("Unsupported Content-Type [" + contentType + "], expected [multipart/form-data]");
    }

    private Collection<Part> getParts(MultiMap<String> params) throws IOException {
        Charset defaultCharset;
        InputStream is;
        if (this._multiParts == null) {
            this._multiParts = (MultiParts) getAttribute(MULTIPARTS);
        }
        if (this._multiParts == null) {
            MultipartConfigElement config = (MultipartConfigElement) getAttribute(MULTIPART_CONFIG_ELEMENT);
            if (config == null) {
                throw new IllegalStateException("No multipart config for servlet");
            }
            this._multiParts = newMultiParts(config);
            setAttribute(MULTIPARTS, this._multiParts);
            Collection<Part> parts = this._multiParts.getParts();
            String formCharset = null;
            Part charsetPart = this._multiParts.getPart("_charset_");
            if (charsetPart != null) {
                is = charsetPart.getInputStream();
                try {
                    ByteArrayOutputStream os = new ByteArrayOutputStream();
                    C5747IO.copy(is, os);
                    formCharset = new String(os.toByteArray(), StandardCharsets.UTF_8);
                    if (is != null) {
                        is.close();
                    }
                } finally {
                }
            }
            if (formCharset != null) {
                defaultCharset = Charset.forName(formCharset);
            } else if (getCharacterEncoding() != null) {
                defaultCharset = Charset.forName(getCharacterEncoding());
            } else {
                defaultCharset = StandardCharsets.UTF_8;
            }
            ByteArrayOutputStream os2 = null;
            for (Part p : parts) {
                if (p.getSubmittedFileName() == null) {
                    String charset = null;
                    if (p.getContentType() != null) {
                        charset = MimeTypes.getCharsetFromContentType(p.getContentType());
                    }
                    is = p.getInputStream();
                    if (os2 == null) {
                        try {
                            os2 = new ByteArrayOutputStream();
                        } finally {
                        }
                    }
                    C5747IO.copy(is, os2);
                    String content = new String(os2.toByteArray(), charset == null ? defaultCharset : Charset.forName(charset));
                    if (this._contentParameters == null) {
                        this._contentParameters = params == null ? new MultiMap<>() : params;
                    }
                    this._contentParameters.add(p.getName(), content);
                    if (is != null) {
                        is.close();
                    }
                    os2.reset();
                }
            }
        }
        return this._multiParts.getParts();
    }

    private MultiParts newMultiParts(MultipartConfigElement config) throws IOException {
        MultiPartFormDataCompliance compliance = getHttpChannel().getHttpConfiguration().getMultipartFormDataCompliance();
        if (LOG.isDebugEnabled()) {
            LOG.debug("newMultiParts {} {}", compliance, this);
        }
        switch (compliance) {
            case RFC7578:
                return new MultiParts.MultiPartsHttpParser(getInputStream(), getContentType(), config, this._context != null ? (File) this._context.getAttribute("javax.servlet.context.tempdir") : null, this);
            case LEGACY:
            default:
                return new MultiParts.MultiPartsUtilParser(getInputStream(), getContentType(), config, this._context != null ? (File) this._context.getAttribute("javax.servlet.context.tempdir") : null, this);
        }
    }

    @Override // javax.servlet.http.HttpServletRequest
    public void login(String username, String password) throws ServletException {
        if (this._authentication instanceof Authentication.LoginAuthentication) {
            Authentication auth = ((Authentication.LoginAuthentication) this._authentication).login(username, password, this);
            if (auth == null) {
                throw new Authentication.Failed("Authentication failed for username '" + username + "'");
            }
            this._authentication = auth;
            return;
        }
        throw new Authentication.Failed("Authenticated failed for username '" + username + "'. Already authenticated as " + this._authentication);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public void logout() throws ServletException {
        if (this._authentication instanceof Authentication.LogoutAuthentication) {
            this._authentication = ((Authentication.LogoutAuthentication) this._authentication).logout(this);
        }
    }

    public void mergeQueryParameters(String oldQuery, String newQuery, boolean updateQueryString) {
        MultiMap<String> mergedQueryParams;
        MultiMap<String> newQueryParams = null;
        if (newQuery != null) {
            newQueryParams = new MultiMap<>();
            try {
                UrlEncoded.decodeTo(newQuery, newQueryParams, UrlEncoded.ENCODING);
            } catch (Exception e) {
                throw new BadMessageException(500, "Bad query encoding", e);
            }
        }
        MultiMap<String> oldQueryParams = this._queryParameters;
        if (oldQueryParams == null && oldQuery != null) {
            oldQueryParams = new MultiMap<>();
            try {
                UrlEncoded.decodeTo(oldQuery, oldQueryParams, getQueryEncoding());
            } catch (Throwable ex) {
                throw new BadMessageException(400, "Bad query encoding", ex);
            }
        }
        if (newQueryParams == null || newQueryParams.size() == 0) {
            mergedQueryParams = oldQueryParams == null ? NO_PARAMS : oldQueryParams;
        } else if (oldQueryParams == null || oldQueryParams.size() == 0) {
            mergedQueryParams = newQueryParams == null ? NO_PARAMS : newQueryParams;
        } else {
            mergedQueryParams = new MultiMap<>(newQueryParams);
            mergedQueryParams.addAllValues(oldQueryParams);
        }
        setQueryParameters(mergedQueryParams);
        resetParameters();
        if (!updateQueryString) {
            return;
        }
        if (newQuery == null) {
            setQueryString(oldQuery);
        } else if (oldQuery == null) {
            setQueryString(newQuery);
        } else {
            StringBuilder mergedQuery = new StringBuilder();
            if (newQuery != null) {
                mergedQuery.append(newQuery);
            }
            for (Map.Entry<String, String> entry : mergedQueryParams.entrySet()) {
                if (newQueryParams == null || !newQueryParams.containsKey(entry.getKey())) {
                    for (String value : (List) entry.getValue()) {
                        if (mergedQuery.length() > 0) {
                            mergedQuery.append("&");
                        }
                        URIUtil.encodePath(mergedQuery, entry.getKey());
                        mergedQuery.append('=');
                        URIUtil.encodePath(mergedQuery, value);
                    }
                }
            }
            setQueryString(mergedQuery.toString());
        }
    }

    @Override // javax.servlet.http.HttpServletRequest
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
        throw new ServletException("HttpServletRequest.upgrade() not supported in Jetty");
    }

    private String formatAddrOrHost(String name) {
        return this._channel == null ? HostPort.normalizeHost(name) : this._channel.formatAddrOrHost(name);
    }
}
