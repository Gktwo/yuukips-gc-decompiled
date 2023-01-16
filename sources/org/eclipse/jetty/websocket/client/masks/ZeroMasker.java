package org.eclipse.jetty.websocket.client.masks;

import java.util.Arrays;
import org.eclipse.jetty.websocket.common.WebSocketFrame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/client/masks/ZeroMasker.class */
public class ZeroMasker implements Masker {
    private final byte[] mask = new byte[4];

    public ZeroMasker() {
        Arrays.fill(this.mask, (byte) 0);
    }

    @Override // org.eclipse.jetty.websocket.client.masks.Masker
    public void setMask(WebSocketFrame frame) {
        frame.setMask(this.mask);
    }
}
