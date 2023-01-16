package org.eclipse.jetty.websocket.common.events;

import org.eclipse.jetty.websocket.api.WebSocketConnectionListener;
import org.eclipse.jetty.websocket.api.WebSocketListener;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/events/JettyListenerImpl.class */
public class JettyListenerImpl implements EventDriverImpl {
    @Override // org.eclipse.jetty.websocket.common.events.EventDriverImpl
    public EventDriver create(Object websocket, WebSocketPolicy policy) {
        return new JettyListenerEventDriver(policy, (WebSocketConnectionListener) websocket);
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriverImpl
    public String describeRule() {
        return "class implements " + WebSocketListener.class.getName();
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriverImpl
    public boolean supports(Object websocket) {
        return websocket instanceof WebSocketConnectionListener;
    }
}
