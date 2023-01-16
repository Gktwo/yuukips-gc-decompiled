package org.eclipse.jetty.websocket.server;

import java.io.IOException;
import org.eclipse.jetty.http.BadMessageException;
import org.eclipse.jetty.websocket.common.AcceptHash;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import p013io.javalin.core.util.Header;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/HandshakeRFC6455.class */
public class HandshakeRFC6455 implements WebSocketHandshake {
    public static final int VERSION = 13;

    @Override // org.eclipse.jetty.websocket.server.WebSocketHandshake
    public void doHandshakeResponse(ServletUpgradeRequest request, ServletUpgradeResponse response) throws IOException {
        String key = request.getHeader(Header.SEC_WEBSOCKET_KEY);
        if (key == null) {
            throw new BadMessageException("Missing request header 'Sec-WebSocket-Key'");
        }
        response.setHeader("Upgrade", "WebSocket");
        response.addHeader("Connection", "Upgrade");
        response.addHeader("Sec-WebSocket-Accept", AcceptHash.hashKey(key));
        request.complete();
        response.setStatusCode(101);
        response.complete();
    }
}
