package org.eclipse.jetty.websocket.client;

import java.net.CookieStore;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.UrlEncoded;
import org.eclipse.jetty.websocket.api.WebSocketConstants;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.common.UpgradeRequestAdapter;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/client/ClientUpgradeRequest.class */
public class ClientUpgradeRequest extends UpgradeRequestAdapter {
    private static final Set<String> FORBIDDEN_HEADERS = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    private final String key;
    private Object localEndpoint;
    private long timeout;

    static {
        FORBIDDEN_HEADERS.add("cookie");
        FORBIDDEN_HEADERS.add("upgrade");
        FORBIDDEN_HEADERS.add("host");
        FORBIDDEN_HEADERS.add("connection");
        FORBIDDEN_HEADERS.add("sec-websocket-key");
        FORBIDDEN_HEADERS.add("sec-websocket-extensions");
        FORBIDDEN_HEADERS.add("sec-websocket-accept");
        FORBIDDEN_HEADERS.add("sec-websocket-protocol");
        FORBIDDEN_HEADERS.add("sec-websocket-version");
        FORBIDDEN_HEADERS.add("pragma");
        FORBIDDEN_HEADERS.add("cache-control");
    }

    public ClientUpgradeRequest() {
        this.key = genRandomKey();
    }

    /* access modifiers changed from: protected */
    public ClientUpgradeRequest(URI requestURI) {
        super(requestURI);
        this.key = genRandomKey();
    }

    public ClientUpgradeRequest(WebSocketUpgradeRequest wsRequest) {
        this(wsRequest.getURI());
        setCookies(wsRequest.getCookies());
        Map<String, List<String>> headers = new HashMap<>();
        Iterator<HttpField> it = wsRequest.getHeaders().iterator();
        while (it.hasNext()) {
            HttpField field = it.next();
            String key = field.getName();
            List<String> values = headers.get(key);
            values = values == null ? new ArrayList() : values;
            values.addAll(Arrays.asList(field.getValues()));
            headers.put(key, values);
            if (key.equalsIgnoreCase("Sec-WebSocket-Protocol")) {
                String[] split = field.getValue().split(",");
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    setSubProtocols(split[i]);
                }
            }
            if (key.equalsIgnoreCase(WebSocketConstants.SEC_WEBSOCKET_EXTENSIONS)) {
                Iterator<ExtensionConfig> it2 = ExtensionConfig.parseList(field.getValues()).iterator();
                while (it2.hasNext()) {
                    addExtensions(it2.next());
                }
            }
        }
        setHeaders(headers);
        setHttpVersion(wsRequest.getVersion().toString());
        setMethod(wsRequest.getMethod());
    }

    private final String genRandomKey() {
        byte[] bytes = new byte[16];
        ThreadLocalRandom.current().nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public String getKey() {
        return this.key;
    }

    @Deprecated
    public void setCookiesFrom(CookieStore cookieStore) {
        throw new UnsupportedOperationException("Request specific CookieStore no longer supported");
    }

    @Override // org.eclipse.jetty.websocket.common.UpgradeRequestAdapter, org.eclipse.jetty.websocket.api.UpgradeRequest
    public void setRequestURI(URI uri) {
        setRequestURI(uri);
        Map<String, List<String>> pmap = new HashMap<>();
        String query = uri.getRawQuery();
        if (StringUtil.isNotBlank(query)) {
            MultiMap<String> params = new MultiMap<>();
            UrlEncoded.decodeTo(query, params, StandardCharsets.UTF_8);
            for (String key : params.keySet()) {
                List<String> values = params.getValues(key);
                if (values == null) {
                    pmap.put(key, new ArrayList<>());
                } else {
                    List<String> copy = new ArrayList<>();
                    copy.addAll(values);
                    pmap.put(key, copy);
                }
            }
            setParameterMap(pmap);
        }
    }

    public void setTimeout(long timeout, TimeUnit unit) {
        this.timeout = unit.toMillis(timeout);
    }

    public long getTimeout() {
        return this.timeout;
    }

    public void setLocalEndpoint(Object websocket) {
        this.localEndpoint = websocket;
    }

    public Object getLocalEndpoint() {
        return this.localEndpoint;
    }
}
