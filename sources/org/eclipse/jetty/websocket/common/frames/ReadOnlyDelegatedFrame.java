package org.eclipse.jetty.websocket.common.frames;

import java.nio.ByteBuffer;
import org.eclipse.jetty.websocket.api.extensions.Frame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/frames/ReadOnlyDelegatedFrame.class */
public class ReadOnlyDelegatedFrame implements Frame {
    private final Frame delegate;

    public ReadOnlyDelegatedFrame(Frame frame) {
        this.delegate = frame;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public byte[] getMask() {
        return this.delegate.getMask();
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public byte getOpCode() {
        return this.delegate.getOpCode();
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public ByteBuffer getPayload() {
        if (!this.delegate.hasPayload()) {
            return null;
        }
        return this.delegate.getPayload().asReadOnlyBuffer();
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public int getPayloadLength() {
        return this.delegate.getPayloadLength();
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public Frame.Type getType() {
        return this.delegate.getType();
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public boolean hasPayload() {
        return this.delegate.hasPayload();
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public boolean isFin() {
        return this.delegate.isFin();
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    @Deprecated
    public boolean isLast() {
        return this.delegate.isLast();
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public boolean isMasked() {
        return this.delegate.isMasked();
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public boolean isRsv1() {
        return this.delegate.isRsv1();
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public boolean isRsv2() {
        return this.delegate.isRsv2();
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public boolean isRsv3() {
        return this.delegate.isRsv3();
    }
}
