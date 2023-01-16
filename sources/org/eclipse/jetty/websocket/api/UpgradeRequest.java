package org.eclipse.jetty.websocket.api;

import java.net.HttpCookie;
import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/UpgradeRequest.class */
public interface UpgradeRequest {
    void addExtensions(ExtensionConfig... extensionConfigArr);

    void addExtensions(String... strArr);

    @Deprecated
    void clearHeaders();

    List<HttpCookie> getCookies();

    List<ExtensionConfig> getExtensions();

    String getHeader(String str);

    int getHeaderInt(String str);

    Map<String, List<String>> getHeaders();

    List<String> getHeaders(String str);

    String getHost();

    String getHttpVersion();

    String getMethod();

    String getOrigin();

    Map<String, List<String>> getParameterMap();

    String getProtocolVersion();

    String getQueryString();

    URI getRequestURI();

    Object getSession();

    List<String> getSubProtocols();

    Principal getUserPrincipal();

    boolean hasSubProtocol(String str);

    boolean isOrigin(String str);

    boolean isSecure();

    void setCookies(List<HttpCookie> list);

    void setExtensions(List<ExtensionConfig> list);

    void setHeader(String str, List<String> list);

    void setHeader(String str, String str2);

    void setHeaders(Map<String, List<String>> map);

    void setHttpVersion(String str);

    void setMethod(String str);

    void setRequestURI(URI uri);

    void setSession(Object obj);

    void setSubProtocols(List<String> list);

    void setSubProtocols(String... strArr);
}
