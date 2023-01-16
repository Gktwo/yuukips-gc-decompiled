package org.eclipse.jetty.websocket.common;

import java.net.URI;
import org.eclipse.jetty.websocket.common.events.EventDriver;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/SessionFactory.class */
public interface SessionFactory {
    boolean supports(EventDriver eventDriver);

    WebSocketSession createSession(URI uri, EventDriver eventDriver, LogicalConnection logicalConnection);
}
