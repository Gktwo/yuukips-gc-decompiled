package org.eclipse.jetty.websocket.common.events;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.util.Objects;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Utf8StringBuilder;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.WebSocketConnectionListener;
import org.eclipse.jetty.websocket.api.WebSocketFrameListener;
import org.eclipse.jetty.websocket.api.WebSocketListener;
import org.eclipse.jetty.websocket.api.WebSocketPartialListener;
import org.eclipse.jetty.websocket.api.WebSocketPingPongListener;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.common.CloseInfo;
import org.eclipse.jetty.websocket.common.frames.ReadOnlyDelegatedFrame;
import org.eclipse.jetty.websocket.common.message.SimpleBinaryMessage;
import org.eclipse.jetty.websocket.common.util.TextUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/events/JettyListenerEventDriver.class */
public class JettyListenerEventDriver extends AbstractEventDriver {
    private static final Logger LOG = Log.getLogger(JettyListenerEventDriver.class);
    private final WebSocketConnectionListener listener;
    private Utf8StringBuilder utf8Partial;
    private PartialMode partialMode = PartialMode.NONE;
    private boolean hasCloseBeenCalled = false;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/events/JettyListenerEventDriver$PartialMode.class */
    public enum PartialMode {
        NONE,
        TEXT,
        BINARY
    }

    public JettyListenerEventDriver(WebSocketPolicy policy, WebSocketConnectionListener listener) {
        super(policy, listener);
        this.listener = (WebSocketConnectionListener) Objects.requireNonNull(listener, "Listener may not be null");
        if (LOG.isDebugEnabled()) {
            LOG.debug("ctor / listener={}, policy={}", listener.getClass().getName(), policy);
        }
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public void onBinaryFrame(ByteBuffer buffer, boolean fin) throws IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onBinaryFrame({}, {}) - webSocketListener={}, webSocketPartialListener={}, listener={}, activeMessage={}", BufferUtil.toDetailString(buffer), Boolean.valueOf(fin), Boolean.valueOf(this.listener instanceof WebSocketListener), Boolean.valueOf(this.listener instanceof WebSocketPartialListener), this.listener.getClass().getName(), this.activeMessage);
        }
        if (this.listener instanceof WebSocketListener) {
            if (this.activeMessage == null) {
                this.activeMessage = new SimpleBinaryMessage(this);
            }
            appendMessage(buffer, fin);
        }
        if (this.listener instanceof WebSocketPartialListener) {
            switch (this.partialMode) {
                case NONE:
                    this.partialMode = PartialMode.BINARY;
                case BINARY:
                    ((WebSocketPartialListener) this.listener).onWebSocketPartialBinary(buffer.slice().asReadOnlyBuffer(), fin);
                    break;
                case TEXT:
                    throw new IOException("Out of order binary frame encountered");
            }
            if (fin) {
                this.partialMode = PartialMode.NONE;
            }
        }
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public void onBinaryMessage(byte[] data) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onBinaryMessage([{}]) - webSocketListener={}, listener={}", Integer.valueOf(data.length), Boolean.valueOf(this.listener instanceof WebSocketListener), this.listener.getClass().getName());
        }
        if (this.listener instanceof WebSocketListener) {
            ((WebSocketListener) this.listener).onWebSocketBinary(data, 0, data.length);
        }
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public void onClose(CloseInfo close) {
        if (!this.hasCloseBeenCalled) {
            this.hasCloseBeenCalled = true;
            int statusCode = close.getStatusCode();
            String reason = close.getReason();
            if (LOG.isDebugEnabled()) {
                LOG.debug("onClose({},{}) - listener={}", Integer.valueOf(statusCode), reason, this.listener.getClass().getName());
            }
            this.listener.onWebSocketClose(statusCode, reason);
        }
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public void onConnect() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onConnect({}) - listener={}", this.session, this.listener.getClass().getName());
        }
        this.listener.onWebSocketConnect(this.session);
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public void onError(Throwable cause) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onError({}) - listener={}", cause.getClass().getName(), this.listener.getClass().getName());
        }
        this.listener.onWebSocketError(cause);
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public void onFrame(Frame frame) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onFrame({}) - frameListener={}, pingPongListener={}, listener={}", frame, Boolean.valueOf(this.listener instanceof WebSocketFrameListener), Boolean.valueOf(this.listener instanceof WebSocketPingPongListener), this.listener.getClass().getName());
        }
        if (this.listener instanceof WebSocketFrameListener) {
            ((WebSocketFrameListener) this.listener).onWebSocketFrame(new ReadOnlyDelegatedFrame(frame));
        }
        if (!(this.listener instanceof WebSocketPingPongListener)) {
            return;
        }
        if (frame.getType() == Frame.Type.PING) {
            ((WebSocketPingPongListener) this.listener).onWebSocketPing(frame.getPayload().asReadOnlyBuffer());
        } else if (frame.getType() == Frame.Type.PONG) {
            ((WebSocketPingPongListener) this.listener).onWebSocketPong(frame.getPayload().asReadOnlyBuffer());
        }
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public void onInputStream(InputStream stream) {
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public void onReader(Reader reader) {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ea  */
    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onTextFrame(java.nio.ByteBuffer r8, boolean r9) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 264
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.websocket.common.events.JettyListenerEventDriver.onTextFrame(java.nio.ByteBuffer, boolean):void");
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public void onTextMessage(String message) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onTextMessage([{}] \"{}\") - webSocketListener={}, listener={}", Integer.valueOf(message.length()), TextUtil.maxStringLength(60, message), Boolean.valueOf(this.listener instanceof WebSocketListener), this.listener.getClass().getName());
        }
        if (this.listener instanceof WebSocketListener) {
            ((WebSocketListener) this.listener).onWebSocketText(message);
        }
    }

    @Override // org.eclipse.jetty.websocket.common.events.AbstractEventDriver, org.eclipse.jetty.websocket.common.events.EventDriver
    public void onContinuationFrame(ByteBuffer buffer, boolean fin) throws IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onContinuationFrame({}, {}) - webSocketListener={}, webSocketPartialListener={}, listener={}, activeMessage={}", BufferUtil.toDetailString(buffer), Boolean.valueOf(fin), Boolean.valueOf(this.listener instanceof WebSocketListener), Boolean.valueOf(this.listener instanceof WebSocketPartialListener), this.listener.getClass().getName(), this.activeMessage);
        }
        if (this.listener instanceof WebSocketPartialListener) {
            switch (this.partialMode) {
                case NONE:
                    throw new IOException("Out of order Continuation frame encountered");
                case BINARY:
                    onBinaryFrame(buffer, fin);
                    return;
                case TEXT:
                    onTextFrame(buffer, fin);
                    return;
                default:
                    return;
            }
        } else if (this.listener instanceof WebSocketListener) {
            onContinuationFrame(buffer, fin);
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s[%s]", JettyListenerEventDriver.class.getSimpleName(), this.listener.getClass().getName());
    }
}
