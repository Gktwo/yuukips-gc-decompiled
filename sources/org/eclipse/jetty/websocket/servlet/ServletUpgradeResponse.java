package org.eclipse.jetty.websocket.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.websocket.api.UpgradeResponse;
import org.eclipse.jetty.websocket.api.WebSocketConstants;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/servlet/ServletUpgradeResponse.class */
public class ServletUpgradeResponse implements UpgradeResponse {
    private HttpServletResponse response;
    private boolean extensionsNegotiated = false;
    private boolean subprotocolNegotiated = false;
    private Map<String, List<String>> headers = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private List<ExtensionConfig> extensions = new ArrayList();
    private boolean success = false;
    private int status;

    public ServletUpgradeResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void addHeader(String name, String value) {
        if (value != null) {
            List<String> values = this.headers.get(name);
            if (values == null) {
                values = new ArrayList();
                this.headers.put(name, values);
            }
            values.add(value);
        }
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void setHeader(String name, String value) {
        if (this.response != null) {
            this.response.setHeader(name, null);
        }
        List<String> values = this.headers.get(name);
        if (values == null) {
            values = new ArrayList();
            this.headers.put(name, values);
        } else {
            values.clear();
        }
        values.add(value);
    }

    public void complete() {
        if (this.response != null) {
            Map<String, Collection<String>> real = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            for (String name : this.response.getHeaderNames()) {
                real.put(name, this.response.getHeaders(name));
            }
            for (Map.Entry<String, List<String>> entry : getHeaders().entrySet()) {
                for (String value : entry.getValue()) {
                    this.response.addHeader(entry.getKey(), value);
                }
            }
            for (Map.Entry<String, Collection<String>> entry2 : real.entrySet()) {
                String name2 = entry2.getKey();
                Collection<String> prepend = entry2.getValue();
                List<String> values = this.headers.getOrDefault(name2, new ArrayList());
                values.addAll(0, prepend);
                this.headers.put(name2, values);
            }
            this.status = this.response.getStatus();
            this.response = null;
        }
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public String getAcceptedSubProtocol() {
        return getHeader("Sec-WebSocket-Protocol");
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public List<ExtensionConfig> getExtensions() {
        return this.extensions;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public String getHeader(String name) {
        String value;
        if (this.response != null && (value = this.response.getHeader(name)) != null) {
            return value;
        }
        List<String> values = this.headers.get(name);
        if (values == null || values.isEmpty()) {
            return null;
        }
        return values.get(0);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public Set<String> getHeaderNames() {
        if (this.response == null) {
            return this.headers.keySet();
        }
        Set<String> h = new HashSet<>(this.response.getHeaderNames());
        h.addAll(this.headers.keySet());
        return h;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public List<String> getHeaders(String name) {
        if (this.response == null) {
            return this.headers.get(name);
        }
        List<String> values = new ArrayList<>(this.response.getHeaders(name));
        values.addAll(this.headers.get(name));
        if (values.isEmpty()) {
            return null;
        }
        return values;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public int getStatusCode() {
        if (this.response != null) {
            return this.response.getStatus();
        }
        return this.status;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public String getStatusReason() {
        throw new UnsupportedOperationException("Servlet's do not support Status Reason");
    }

    public boolean isCommitted() {
        if (this.response != null) {
            return this.response.isCommitted();
        }
        return true;
    }

    public boolean isExtensionsNegotiated() {
        return this.extensionsNegotiated;
    }

    public boolean isSubprotocolNegotiated() {
        return this.subprotocolNegotiated;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public boolean isSuccess() {
        return this.success;
    }

    public void sendError(int statusCode, String message) throws IOException {
        setSuccess(false);
        HttpServletResponse r = this.response;
        complete();
        r.sendError(statusCode, message);
        r.flushBuffer();
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void sendForbidden(String message) throws IOException {
        setSuccess(false);
        HttpServletResponse r = this.response;
        complete();
        r.sendError(403, message);
        r.flushBuffer();
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void setAcceptedSubProtocol(String protocol) {
        this.response.setHeader("Sec-WebSocket-Protocol", protocol);
        this.subprotocolNegotiated = true;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void setExtensions(List<ExtensionConfig> configs) {
        this.extensions.clear();
        this.extensions.addAll(configs);
        this.response.setHeader(WebSocketConstants.SEC_WEBSOCKET_EXTENSIONS, ExtensionConfig.toHeaderValue(configs));
        this.extensionsNegotiated = true;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void setStatusCode(int statusCode) {
        if (this.response != null) {
            this.response.setStatus(statusCode);
        }
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void setStatusReason(String statusReason) {
        throw new UnsupportedOperationException("Servlet's do not support Status Reason");
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String toString() {
        return String.format("r=%s s=%d h=%s", this.response, Integer.valueOf(this.status), this.headers);
    }
}
