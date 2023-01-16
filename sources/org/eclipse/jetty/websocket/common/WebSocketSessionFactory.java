package org.eclipse.jetty.websocket.common;

import java.net.URI;
import org.eclipse.jetty.websocket.common.events.EventDriver;
import org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver;
import org.eclipse.jetty.websocket.common.events.JettyListenerEventDriver;
import org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/WebSocketSessionFactory.class */
public class WebSocketSessionFactory implements SessionFactory {
    private final WebSocketContainerScope containerScope;

    public WebSocketSessionFactory(WebSocketContainerScope containerScope) {
        this.containerScope = containerScope;
    }

    @Override // org.eclipse.jetty.websocket.common.SessionFactory
    public boolean supports(EventDriver websocket) {
        return (websocket instanceof JettyAnnotatedEventDriver) || (websocket instanceof JettyListenerEventDriver);
    }

    @Override // org.eclipse.jetty.websocket.common.SessionFactory
    public WebSocketSession createSession(URI requestURI, EventDriver websocket, LogicalConnection connection) {
        return new WebSocketSession(this.containerScope, requestURI, websocket, connection);
    }
}
