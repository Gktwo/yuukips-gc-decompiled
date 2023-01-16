package org.eclipse.jetty.websocket.common.events;

import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/events/JettyAnnotatedImpl.class */
public class JettyAnnotatedImpl implements EventDriverImpl {
    private ConcurrentHashMap<Class<?>, JettyAnnotatedMetadata> cache = new ConcurrentHashMap<>();

    @Override // org.eclipse.jetty.websocket.common.events.EventDriverImpl
    public EventDriver create(Object websocket, WebSocketPolicy policy) {
        JettyAnnotatedEventDriver jettyAnnotatedEventDriver;
        Class<?> websocketClass = websocket.getClass();
        synchronized (this) {
            JettyAnnotatedMetadata metadata = this.cache.get(websocketClass);
            if (metadata == null) {
                metadata = new JettyAnnotatedScanner().scan(websocketClass);
                this.cache.put(websocketClass, metadata);
            }
            jettyAnnotatedEventDriver = new JettyAnnotatedEventDriver(policy, websocket, metadata);
        }
        return jettyAnnotatedEventDriver;
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriverImpl
    public String describeRule() {
        return "class is annotated with @" + WebSocket.class.getName();
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriverImpl
    public boolean supports(Object websocket) {
        return ((WebSocket) websocket.getClass().getAnnotation(WebSocket.class)) != null;
    }

    public String toString() {
        return String.format("%s [cache.count=%d]", getClass().getSimpleName(), Integer.valueOf(this.cache.size()));
    }
}
