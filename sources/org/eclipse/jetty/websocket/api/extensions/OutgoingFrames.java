package org.eclipse.jetty.websocket.api.extensions;

import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.WriteCallback;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/extensions/OutgoingFrames.class */
public interface OutgoingFrames {
    void outgoingFrame(Frame frame, WriteCallback writeCallback, BatchMode batchMode);
}
