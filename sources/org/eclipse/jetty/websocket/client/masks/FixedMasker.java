package org.eclipse.jetty.websocket.client.masks;

import java.util.Arrays;
import org.eclipse.jetty.websocket.common.WebSocketFrame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/client/masks/FixedMasker.class */
public class FixedMasker implements Masker {
    private final byte[] mask;

    public FixedMasker() {
        this(new byte[]{-1, -1, -1, -1});
    }

    public FixedMasker(byte[] mask) {
        this.mask = Arrays.copyOf(mask, 4);
    }

    @Override // org.eclipse.jetty.websocket.client.masks.Masker
    public void setMask(WebSocketFrame frame) {
        frame.setMask(this.mask);
    }
}
