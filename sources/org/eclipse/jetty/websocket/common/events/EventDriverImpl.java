package org.eclipse.jetty.websocket.common.events;

import org.eclipse.jetty.websocket.api.WebSocketPolicy;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/events/EventDriverImpl.class */
public interface EventDriverImpl {
    EventDriver create(Object obj, WebSocketPolicy webSocketPolicy) throws Throwable;

    String describeRule();

    boolean supports(Object obj);
}
