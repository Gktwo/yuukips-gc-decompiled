package org.eclipse.jetty.websocket.server;

import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/ServletWebSocketRequest.class */
public class ServletWebSocketRequest extends ServletUpgradeRequest {
    public ServletWebSocketRequest(HttpServletRequest request) throws URISyntaxException {
        super(request);
    }
}
