package org.eclipse.jetty.websocket.api;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/UpgradeResponse.class */
public interface UpgradeResponse {
    void addHeader(String str, String str2);

    String getAcceptedSubProtocol();

    List<ExtensionConfig> getExtensions();

    String getHeader(String str);

    Set<String> getHeaderNames();

    Map<String, List<String>> getHeaders();

    List<String> getHeaders(String str);

    int getStatusCode();

    String getStatusReason();

    @Deprecated
    boolean isSuccess();

    void sendForbidden(String str) throws IOException;

    void setAcceptedSubProtocol(String str);

    void setExtensions(List<ExtensionConfig> list);

    void setHeader(String str, String str2);

    void setStatusCode(int i);

    void setStatusReason(String str);

    @Deprecated
    void setSuccess(boolean z);
}
