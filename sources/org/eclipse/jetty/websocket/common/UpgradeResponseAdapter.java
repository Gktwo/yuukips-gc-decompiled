package org.eclipse.jetty.websocket.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.eclipse.jetty.websocket.api.UpgradeResponse;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.api.util.QuoteUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/UpgradeResponseAdapter.class */
public class UpgradeResponseAdapter implements UpgradeResponse {
    public static final String SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
    private int statusCode;
    private String statusReason;
    private Map<String, List<String>> headers = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private List<ExtensionConfig> extensions = new ArrayList();
    private boolean success = false;

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void addHeader(String name, String value) {
        List<String> values = this.headers.get(name);
        if (values == null) {
            values = new ArrayList();
        }
        values.add(value);
        this.headers.put(name, values);
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
        int size;
        List<String> values = getHeaders(name);
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

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public Set<String> getHeaderNames() {
        return this.headers.keySet();
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public List<String> getHeaders(String name) {
        return this.headers.get(name);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public String getStatusReason() {
        return this.statusReason;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public boolean isSuccess() {
        return this.success;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void sendForbidden(String message) throws IOException {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void setAcceptedSubProtocol(String protocol) {
        setHeader("Sec-WebSocket-Protocol", protocol);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void setExtensions(List<ExtensionConfig> extensions) {
        this.extensions.clear();
        if (extensions != null) {
            this.extensions.addAll(extensions);
        }
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void setHeader(String name, String value) {
        List<String> values = new ArrayList<>();
        values.add(value);
        this.headers.put(name, values);
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    @Override // org.eclipse.jetty.websocket.api.UpgradeResponse
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
