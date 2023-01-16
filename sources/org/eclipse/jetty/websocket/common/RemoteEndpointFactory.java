package org.eclipse.jetty.websocket.common;

import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.extensions.OutgoingFrames;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/RemoteEndpointFactory.class */
public interface RemoteEndpointFactory {
    RemoteEndpoint newRemoteEndpoint(LogicalConnection logicalConnection, OutgoingFrames outgoingFrames, BatchMode batchMode);
}
