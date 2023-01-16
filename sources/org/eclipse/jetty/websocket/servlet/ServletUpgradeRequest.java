package org.eclipse.jetty.websocket.servlet;

import java.net.HttpCookie;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.websocket.api.UpgradeRequest;
import org.eclipse.jetty.websocket.api.WebSocketConstants;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/servlet/ServletUpgradeRequest.class */
public class ServletUpgradeRequest implements UpgradeRequest {
    private static final String CANNOT_MODIFY_SERVLET_REQUEST = "Cannot modify Servlet Request";
    private final URI requestURI;
    private final String queryString;
    private final UpgradeHttpServletRequest request;
    private final boolean secure;
    private List<HttpCookie> cookies;
    private Map<String, List<String>> parameterMap;

    public ServletUpgradeRequest(HttpServletRequest httpRequest) throws URISyntaxException {
        this.queryString = httpRequest.getQueryString();
        this.secure = httpRequest.isSecure();
        StringBuffer uri = httpRequest.getRequestURL();
        if (this.queryString != null) {
            uri.append("?").append(this.queryString);
        }
        uri.replace(0, uri.indexOf(EmitterKt.COMMENT_PREFIX), this.secure ? "wss" : "ws");
        this.requestURI = new URI(uri.toString());
        this.request = new UpgradeHttpServletRequest(httpRequest);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void addExtensions(ExtensionConfig... configs) {
        throw new UnsupportedOperationException(CANNOT_MODIFY_SERVLET_REQUEST);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void addExtensions(String... configs) {
        throw new UnsupportedOperationException(CANNOT_MODIFY_SERVLET_REQUEST);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void clearHeaders() {
        throw new UnsupportedOperationException(CANNOT_MODIFY_SERVLET_REQUEST);
    }

    public void complete() {
        this.request.complete();
    }

    public X509Certificate[] getCertificates() {
        return (X509Certificate[]) this.request.getAttribute(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_X_509_CERTIFICATE);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public List<HttpCookie> getCookies() {
        Cookie[] requestCookies;
        if (this.cookies == null && (requestCookies = this.request.getCookies()) != null) {
            this.cookies = new ArrayList();
            for (Cookie requestCookie : requestCookies) {
                this.cookies.add(new HttpCookie(requestCookie.getName(), requestCookie.getValue()));
            }
        }
        return this.cookies;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public List<ExtensionConfig> getExtensions() {
        return ExtensionConfig.parseEnum(this.request.getHeaders(WebSocketConstants.SEC_WEBSOCKET_EXTENSIONS));
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public String getHeader(String name) {
        return this.request.getHeader(name);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public int getHeaderInt(String name) {
        String val = this.request.getHeader(name);
        if (val == null) {
            return -1;
        }
        return Integer.parseInt(val);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public Map<String, List<String>> getHeaders() {
        return this.request.getHeaders();
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public List<String> getHeaders(String name) {
        return this.request.getHeaders().get(name);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public String getHost() {
        return this.requestURI.getHost();
    }

    public HttpServletRequest getHttpServletRequest() {
        return this.request;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public String getHttpVersion() {
        return this.request.getProtocol();
    }

    public String getLocalAddress() {
        return this.request.getLocalAddr();
    }

    public Locale getLocale() {
        return this.request.getLocale();
    }

    public Enumeration<Locale> getLocales() {
        return this.request.getLocales();
    }

    public String getLocalHostName() {
        return this.request.getLocalName();
    }

    public int getLocalPort() {
        return this.request.getLocalPort();
    }

    public InetSocketAddress getLocalSocketAddress() {
        return new InetSocketAddress(getLocalAddress(), getLocalPort());
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public String getMethod() {
        return this.request.getMethod();
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public String getOrigin() {
        return getHeader("Origin");
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public Map<String, List<String>> getParameterMap() {
        Map<String, String[]> requestParams;
        if (this.parameterMap == null && (requestParams = this.request.getParameterMap()) != null) {
            this.parameterMap = new HashMap(requestParams.size());
            for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
                this.parameterMap.put(entry.getKey(), Arrays.asList(entry.getValue()));
            }
        }
        return this.parameterMap;
    }

    @Deprecated
    public Principal getPrincipal() {
        return getUserPrincipal();
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public String getProtocolVersion() {
        String version = this.request.getHeader(WebSocketConstants.SEC_WEBSOCKET_VERSION);
        if (version == null) {
            return Integer.toString(13);
        }
        return version;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public String getQueryString() {
        return this.queryString;
    }

    public String getRemoteAddress() {
        return this.request.getRemoteAddr();
    }

    public String getRemoteHostName() {
        return this.request.getRemoteHost();
    }

    public int getRemotePort() {
        return this.request.getRemotePort();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return new InetSocketAddress(getRemoteAddress(), getRemotePort());
    }

    public String getRequestPath() {
        String contextPath = this.request.getContextPath();
        String requestPath = this.request.getRequestURI();
        if (requestPath.startsWith(contextPath)) {
            requestPath = requestPath.substring(contextPath.length());
        }
        return requestPath;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public URI getRequestURI() {
        return this.requestURI;
    }

    public Object getServletAttribute(String name) {
        return this.request.getAttribute(name);
    }

    public Map<String, Object> getServletAttributes() {
        return this.request.getAttributes();
    }

    public Map<String, List<String>> getServletParameters() {
        return getParameterMap();
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public HttpSession getSession() {
        return this.request.getSession(false);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public List<String> getSubProtocols() {
        Enumeration<String> requestProtocols = this.request.getHeaders("Sec-WebSocket-Protocol");
        if (requestProtocols == null || !requestProtocols.hasMoreElements()) {
            return Collections.emptyList();
        }
        ArrayList subprotocols = new ArrayList(2);
        while (requestProtocols.hasMoreElements()) {
            Collections.addAll(subprotocols, parseProtocols(requestProtocols.nextElement()));
        }
        return subprotocols;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public Principal getUserPrincipal() {
        return this.request.getUserPrincipal();
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public boolean hasSubProtocol(String test) {
        for (String protocol : getSubProtocols()) {
            if (protocol.equalsIgnoreCase(test)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public boolean isOrigin(String test) {
        return test.equalsIgnoreCase(getOrigin());
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public boolean isSecure() {
        return this.secure;
    }

    public boolean isUserInRole(String role) {
        return this.request.isUserInRole(role);
    }

    private String[] parseProtocols(String protocol) {
        if (protocol == null) {
            return new String[0];
        }
        String protocol2 = protocol.trim();
        if (protocol2.length() == 0) {
            return new String[0];
        }
        return protocol2.split("\\s*,\\s*");
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setCookies(List<HttpCookie> cookies) {
        throw new UnsupportedOperationException(CANNOT_MODIFY_SERVLET_REQUEST);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setExtensions(List<ExtensionConfig> configs) {
        throw new UnsupportedOperationException(CANNOT_MODIFY_SERVLET_REQUEST);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setHeader(String name, List<String> values) {
        throw new UnsupportedOperationException(CANNOT_MODIFY_SERVLET_REQUEST);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setHeader(String name, String value) {
        throw new UnsupportedOperationException(CANNOT_MODIFY_SERVLET_REQUEST);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setHeaders(Map<String, List<String>> headers) {
        throw new UnsupportedOperationException(CANNOT_MODIFY_SERVLET_REQUEST);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setHttpVersion(String httpVersion) {
        throw new UnsupportedOperationException(CANNOT_MODIFY_SERVLET_REQUEST);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setMethod(String method) {
        throw new UnsupportedOperationException(CANNOT_MODIFY_SERVLET_REQUEST);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setRequestURI(URI uri) {
        throw new UnsupportedOperationException(CANNOT_MODIFY_SERVLET_REQUEST);
    }

    public void setServletAttribute(String name, Object value) {
        this.request.setAttribute(name, value);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setSession(Object session) {
        throw new UnsupportedOperationException(CANNOT_MODIFY_SERVLET_REQUEST);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setSubProtocols(List<String> subProtocols) {
        throw new UnsupportedOperationException(CANNOT_MODIFY_SERVLET_REQUEST);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setSubProtocols(String... protocols) {
        throw new UnsupportedOperationException(CANNOT_MODIFY_SERVLET_REQUEST);
    }
}
