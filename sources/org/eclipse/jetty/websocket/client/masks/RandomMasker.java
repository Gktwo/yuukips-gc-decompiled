package org.eclipse.jetty.websocket.client.masks;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Random;
import org.eclipse.jetty.websocket.common.WebSocketFrame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/client/masks/RandomMasker.class */
public class RandomMasker implements Masker {
    private final Random random;

    public RandomMasker() {
        this(new SecureRandom());
    }

    public RandomMasker(Random random) {
        Objects.requireNonNull(random);
        this.random = random;
    }

    @Override // org.eclipse.jetty.websocket.client.masks.Masker
    public void setMask(WebSocketFrame frame) {
        byte[] mask = new byte[4];
        this.random.nextBytes(mask);
        frame.setMask(mask);
    }
}
