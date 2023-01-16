package org.eclipse.jetty.websocket.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/servlet/UpgradeHttpServletRequest.class */
public class UpgradeHttpServletRequest implements HttpServletRequest {
    private static final String UNSUPPORTED_WITH_WEBSOCKET_UPGRADE = "Feature unsupported with a Upgraded to WebSocket HttpServletRequest";
    private HttpServletRequest request;
    private final ServletContext context;
    private final DispatcherType dispatcher;
    private final String method;
    private final String protocol;
    private final String scheme;
    private final boolean secure;
    private final String requestURI;
    private final StringBuffer requestURL;
    private final String pathInfo;
    private final String pathTranslated;
    private final String servletPath;
    private final String query;
    private final String authType;
    private final Cookie[] cookies;
    private final String remoteUser;
    private final Principal principal;
    private final Map<String, List<String>> headers = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private final Map<String, String[]> parameters = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private final Map<String, Object> attributes = new HashMap(2);
    private final List<Locale> locales = new ArrayList(2);
    private HttpSession session;
    private final InetSocketAddress localAddress;
    private final String localName;
    private final InetSocketAddress remoteAddress;
    private final String remoteName;
    private final InetSocketAddress serverAddress;

    public UpgradeHttpServletRequest(HttpServletRequest httpRequest) {
        this.request = httpRequest;
        this.context = httpRequest.getServletContext();
        this.dispatcher = httpRequest.getDispatcherType();
        this.method = httpRequest.getMethod();
        this.protocol = httpRequest.getProtocol();
        this.scheme = httpRequest.getScheme();
        this.secure = httpRequest.isSecure();
        this.requestURI = httpRequest.getRequestURI();
        this.requestURL = httpRequest.getRequestURL();
        this.pathInfo = httpRequest.getPathInfo();
        this.pathTranslated = httpRequest.getPathTranslated();
        this.servletPath = httpRequest.getServletPath();
        this.query = httpRequest.getQueryString();
        this.authType = httpRequest.getAuthType();
        this.cookies = this.request.getCookies();
        this.remoteUser = httpRequest.getRemoteUser();
        this.principal = httpRequest.getUserPrincipal();
        Enumeration<String> headerNames = httpRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            this.headers.put(name, Collections.list(httpRequest.getHeaders(name)));
        }
        this.parameters.putAll(this.request.getParameterMap());
        Enumeration<String> attributeNames = httpRequest.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name2 = attributeNames.nextElement();
            this.attributes.put(name2, httpRequest.getAttribute(name2));
        }
        Enumeration<Locale> localeElements = httpRequest.getLocales();
        while (localeElements.hasMoreElements()) {
            this.locales.add(localeElements.nextElement());
        }
        this.localAddress = InetSocketAddress.createUnresolved(httpRequest.getLocalAddr(), httpRequest.getLocalPort());
        this.localName = httpRequest.getLocalName();
        this.remoteAddress = InetSocketAddress.createUnresolved(httpRequest.getRemoteAddr(), httpRequest.getRemotePort());
        this.remoteName = httpRequest.getRemoteHost();
        this.serverAddress = InetSocketAddress.createUnresolved(httpRequest.getServerName(), httpRequest.getServerPort());
    }

    public HttpServletRequest getHttpServletRequest() {
        return this.request;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getAuthType() {
        return this.authType;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Cookie[] getCookies() {
        return this.cookies;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getHeader(String name) {
        List<String> values = this.headers.get(name);
        if (values == null || values.isEmpty()) {
            return null;
        }
        return values.get(0);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Enumeration<String> getHeaders(String name) {
        List<String> values = this.headers.get(name);
        if (values == null) {
            return Collections.emptyEnumeration();
        }
        return Collections.enumeration(values);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Enumeration<String> getHeaderNames() {
        return Collections.enumeration(this.headers.keySet());
    }

    public Map<String, List<String>> getHeaders() {
        return Collections.unmodifiableMap(this.headers);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public long getDateHeader(String name) {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public int getIntHeader(String name) {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getMethod() {
        return this.method;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getPathInfo() {
        return this.pathInfo;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getPathTranslated() {
        return this.pathTranslated;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getContextPath() {
        return this.context.getContextPath();
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getQueryString() {
        return this.query;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getRemoteUser() {
        return this.remoteUser;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isUserInRole(String role) {
        HttpServletRequest request = getHttpServletRequest();
        if (request != null) {
            return request.isUserInRole(role);
        }
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Principal getUserPrincipal() {
        return this.principal;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getRequestURI() {
        return this.requestURI;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public StringBuffer getRequestURL() {
        return this.requestURL;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getServletPath() {
        return this.servletPath;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public HttpSession getSession(boolean create) {
        HttpServletRequest request = getHttpServletRequest();
        if (request == null) {
            return this.session;
        }
        HttpSession session = request.getSession(create);
        this.session = session;
        return session;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public HttpSession getSession() {
        return getSession(true);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getRequestedSessionId() {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isRequestedSessionIdValid() {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isRequestedSessionIdFromCookie() {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isRequestedSessionIdFromURL() {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isRequestedSessionIdFromUrl() {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.ServletRequest
    public Object getAttribute(String name) {
        return this.attributes.get(name);
    }

    @Override // javax.servlet.ServletRequest
    public Enumeration<String> getAttributeNames() {
        return Collections.enumeration(this.attributes.keySet());
    }

    public Map<String, Object> getAttributes() {
        return Collections.unmodifiableMap(this.attributes);
    }

    @Override // javax.servlet.ServletRequest
    public String getParameter(String name) {
        String[] values = this.parameters.get(name);
        if (values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }

    @Override // javax.servlet.ServletRequest
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(this.parameters.keySet());
    }

    @Override // javax.servlet.ServletRequest
    public String[] getParameterValues(String name) {
        return this.parameters.get(name);
    }

    @Override // javax.servlet.ServletRequest
    public Map<String, String[]> getParameterMap() {
        return this.parameters;
    }

    @Override // javax.servlet.ServletRequest
    public String getProtocol() {
        return this.protocol;
    }

    @Override // javax.servlet.ServletRequest
    public String getScheme() {
        return this.scheme;
    }

    @Override // javax.servlet.ServletRequest
    public String getServerName() {
        return this.serverAddress.getHostString();
    }

    @Override // javax.servlet.ServletRequest
    public int getServerPort() {
        return this.serverAddress.getPort();
    }

    @Override // javax.servlet.ServletRequest
    public String getRemoteAddr() {
        return this.remoteAddress.getHostString();
    }

    @Override // javax.servlet.ServletRequest
    public int getRemotePort() {
        return this.remoteAddress.getPort();
    }

    @Override // javax.servlet.ServletRequest
    public String getRemoteHost() {
        return this.remoteName;
    }

    @Override // javax.servlet.ServletRequest
    public void setAttribute(String name, Object value) {
        HttpServletRequest request = getHttpServletRequest();
        if (request != null) {
            request.setAttribute(name, value);
        }
        this.attributes.put(name, value);
    }

    @Override // javax.servlet.ServletRequest
    public void removeAttribute(String name) {
        HttpServletRequest request = getHttpServletRequest();
        if (request != null) {
            request.removeAttribute(name);
        }
        this.attributes.remove(name);
    }

    @Override // javax.servlet.ServletRequest
    public Locale getLocale() {
        if (this.locales.isEmpty()) {
            return Locale.getDefault();
        }
        return this.locales.get(0);
    }

    @Override // javax.servlet.ServletRequest
    public Enumeration<Locale> getLocales() {
        return Collections.enumeration(this.locales);
    }

    @Override // javax.servlet.ServletRequest
    public boolean isSecure() {
        return this.secure;
    }

    @Override // javax.servlet.ServletRequest
    public String getRealPath(String path) {
        return this.context.getRealPath(path);
    }

    @Override // javax.servlet.ServletRequest
    public String getLocalName() {
        return this.localName;
    }

    @Override // javax.servlet.ServletRequest
    public String getLocalAddr() {
        return this.localAddress.getHostString();
    }

    @Override // javax.servlet.ServletRequest
    public int getLocalPort() {
        return this.localAddress.getPort();
    }

    @Override // javax.servlet.ServletRequest
    public ServletContext getServletContext() {
        return this.context;
    }

    @Override // javax.servlet.ServletRequest
    public DispatcherType getDispatcherType() {
        return this.dispatcher;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String changeSessionId() {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.ServletRequest
    public AsyncContext getAsyncContext() {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.ServletRequest
    public String getCharacterEncoding() {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.ServletRequest
    public int getContentLength() {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.ServletRequest
    public long getContentLengthLong() {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.ServletRequest
    public String getContentType() {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.ServletRequest
    public ServletInputStream getInputStream() throws IOException {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Part getPart(String name) throws IOException, ServletException {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Collection<Part> getParts() throws IOException, ServletException {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.ServletRequest
    public BufferedReader getReader() throws IOException {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.ServletRequest
    public RequestDispatcher getRequestDispatcher(String path) {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.ServletRequest
    public boolean isAsyncStarted() {
        return false;
    }

    @Override // javax.servlet.ServletRequest
    public boolean isAsyncSupported() {
        return false;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public void login(String username, String password) throws ServletException {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public void logout() throws ServletException {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.ServletRequest
    public void setCharacterEncoding(String enc) throws UnsupportedEncodingException {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.ServletRequest
    public AsyncContext startAsync() throws IllegalStateException {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.ServletRequest
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
        throw new UnsupportedOperationException(UNSUPPORTED_WITH_WEBSOCKET_UPGRADE);
    }

    public void complete() {
        this.request = null;
    }
}
