package org.eclipse.jetty.websocket.common;

import java.net.HttpCookie;
import java.net.URI;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.eclipse.jetty.websocket.api.UpgradeRequest;
import org.eclipse.jetty.websocket.api.WebSocketConstants;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.api.util.QuoteUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/UpgradeRequestAdapter.class */
public class UpgradeRequestAdapter implements UpgradeRequest {
    private URI requestURI;
    private List<String> subProtocols;
    private List<ExtensionConfig> extensions;
    private List<HttpCookie> cookies;
    private Map<String, List<String>> headers;
    private Map<String, List<String>> parameters;
    private Object session;
    private String httpVersion;
    private String method;
    private String host;
    private boolean secure;

    /* access modifiers changed from: protected */
    public UpgradeRequestAdapter() {
        this.subProtocols = new ArrayList(1);
        this.extensions = new ArrayList(1);
        this.cookies = new ArrayList(1);
        this.headers = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.parameters = new HashMap(1);
    }

    public UpgradeRequestAdapter(String requestURI) {
        this(URI.create(requestURI));
    }

    public UpgradeRequestAdapter(URI requestURI) {
        this.subProtocols = new ArrayList(1);
        this.extensions = new ArrayList(1);
        this.cookies = new ArrayList(1);
        this.headers = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.parameters = new HashMap(1);
        setRequestURI(requestURI);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void addExtensions(ExtensionConfig... configs) {
        Collections.addAll(this.extensions, configs);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void addExtensions(String... configs) {
        for (String config : configs) {
            this.extensions.add(ExtensionConfig.parse(config));
        }
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void clearHeaders() {
        this.headers.clear();
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public List<HttpCookie> getCookies() {
        return this.cookies;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public List<ExtensionConfig> getExtensions() {
        return this.extensions;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public String getHeader(String name) {
        int size;
        List<String> values = this.headers.get(name);
        if (values == null || (size = values.size()) <= 0) {
            return null;
        }
        if (size == 1) {
            return values.get(0);
        }
        boolean needsDelim = false;
        StringBuilder ret = new StringBuilder();
        for (String value : values) {
            if (needsDelim) {
                ret.append(", ");
            }
            QuoteUtil.quoteIfNeeded(ret, value, QuoteUtil.ABNF_REQUIRED_QUOTING);
            needsDelim = true;
        }
        return ret.toString();
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public int getHeaderInt(String name) {
        int size;
        List<String> values = this.headers.get(name);
        if (values == null || (size = values.size()) <= 0) {
            return -1;
        }
        if (size == 1) {
            return Integer.parseInt(values.get(0));
        }
        throw new NumberFormatException("Cannot convert multi-value header into int");
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public List<String> getHeaders(String name) {
        return this.headers.get(name);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public String getHost() {
        return this.host;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public String getHttpVersion() {
        return this.httpVersion;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public String getMethod() {
        return this.method;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public String getOrigin() {
        return getHeader("Origin");
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public Map<String, List<String>> getParameterMap() {
        return Collections.unmodifiableMap(this.parameters);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public String getProtocolVersion() {
        String version = getHeader(WebSocketConstants.SEC_WEBSOCKET_VERSION);
        if (version == null) {
            return "13";
        }
        return version;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public String getQueryString() {
        return this.requestURI.getQuery();
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public URI getRequestURI() {
        return this.requestURI;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public Object getSession() {
        return this.session;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public List<String> getSubProtocols() {
        return this.subProtocols;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public Principal getUserPrincipal() {
        return null;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public boolean hasSubProtocol(String test) {
        for (String protocol : this.subProtocols) {
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

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setCookies(List<HttpCookie> cookies) {
        this.cookies.clear();
        if (cookies != null && !cookies.isEmpty()) {
            this.cookies.addAll(cookies);
        }
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setExtensions(List<ExtensionConfig> configs) {
        this.extensions.clear();
        if (configs != null) {
            this.extensions.addAll(configs);
        }
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setHeader(String name, List<String> values) {
        this.headers.put(name, values);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setHeader(String name, String value) {
        List<String> values = new ArrayList<>();
        values.add(value);
        setHeader(name, values);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setHeaders(Map<String, List<String>> headers) {
        clearHeaders();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            setHeader(entry.getKey(), entry.getValue());
        }
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setMethod(String method) {
        this.method = method;
    }

    /* access modifiers changed from: protected */
    public void setParameterMap(Map<String, List<String>> parameters) {
        this.parameters.clear();
        this.parameters.putAll(parameters);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setRequestURI(URI uri) {
        this.requestURI = uri;
        String scheme = uri.getScheme();
        if ("ws".equalsIgnoreCase(scheme)) {
            this.secure = false;
        } else if ("wss".equalsIgnoreCase(scheme)) {
            this.secure = true;
        } else {
            throw new IllegalArgumentException("URI scheme must be 'ws' or 'wss'");
        }
        this.host = this.requestURI.getHost();
        this.parameters.clear();
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setSession(Object session) {
        this.session = session;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setSubProtocols(List<String> subProtocols) {
        this.subProtocols.clear();
        if (subProtocols != null) {
            this.subProtocols.addAll(subProtocols);
        }
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setSubProtocols(String... protocols) {
        this.subProtocols.clear();
        Collections.addAll(this.subProtocols, protocols);
    }
}
