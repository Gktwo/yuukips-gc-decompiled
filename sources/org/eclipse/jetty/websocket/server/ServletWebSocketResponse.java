package org.eclipse.jetty.websocket.server;

import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/ServletWebSocketResponse.class */
public class ServletWebSocketResponse extends ServletUpgradeResponse {
    public ServletWebSocketResponse(HttpServletResponse resp) {
        super(resp);
    }
}
