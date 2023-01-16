package org.eclipse.jetty.websocket.common.frames;

import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.websocket.api.extensions.Frame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/frames/CloseFrame.class */
public class CloseFrame extends ControlFrame {
    public CloseFrame() {
        super((byte) 8);
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame, org.eclipse.jetty.websocket.api.extensions.Frame
    public Frame.Type getType() {
        return Frame.Type.CLOSE;
    }

    public static String truncate(String reason) {
        return StringUtil.truncate(reason, 123);
    }
}
