package org.eclipse.jetty.websocket.common.events;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Utf8Appendable;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.BadPayloadException;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.api.extensions.IncomingFrames;
import org.eclipse.jetty.websocket.common.CloseInfo;
import org.eclipse.jetty.websocket.common.WebSocketSession;
import org.eclipse.jetty.websocket.common.frames.CloseFrame;
import org.eclipse.jetty.websocket.common.message.MessageAppender;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/events/AbstractEventDriver.class */
public abstract class AbstractEventDriver extends AbstractLifeCycle implements IncomingFrames, EventDriver {
    private final Logger logger = Log.getLogger(getClass());
    protected final Logger targetLog;
    protected WebSocketPolicy policy;
    protected final Object websocket;
    protected WebSocketSession session;
    protected MessageAppender activeMessage;

    public AbstractEventDriver(WebSocketPolicy policy, Object websocket) {
        this.policy = policy;
        this.websocket = Objects.requireNonNull(websocket, "WebSocket endpoint may not be null");
        this.targetLog = Log.getLogger(websocket.getClass());
    }

    protected void appendMessage(ByteBuffer buffer, boolean fin) throws IOException {
        this.activeMessage.appendFrame(buffer, fin);
        if (fin) {
            this.activeMessage.messageComplete();
            this.activeMessage = null;
        }
    }

    protected void dispatch(Runnable runnable) {
        this.session.dispatch(runnable);
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public WebSocketPolicy getPolicy() {
        return this.policy;
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public WebSocketSession getSession() {
        return this.session;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.IncomingFrames
    public void incomingFrame(Frame frame) {
        ByteBuffer pongBuf;
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("incomingFrame({})", frame);
        }
        try {
            onFrame(frame);
            byte opcode = frame.getOpCode();
            switch (opcode) {
                case 0:
                    onContinuationFrame(frame.getPayload(), frame.isFin());
                    return;
                case 1:
                    onTextFrame(frame.getPayload(), frame.isFin());
                    return;
                case 2:
                    onBinaryFrame(frame.getPayload(), frame.isFin());
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    if (this.logger.isDebugEnabled()) {
                        this.logger.debug("Unhandled OpCode: {}", (long) opcode);
                        break;
                    }
                    break;
                case 8:
                    this.session.getConnection().remoteClose(new CloseInfo((Frame) ((CloseFrame) frame), true));
                    return;
                case 9:
                    if (this.logger.isDebugEnabled()) {
                        this.logger.debug("PING: {}", BufferUtil.toDetailString(frame.getPayload()));
                    }
                    if (frame.hasPayload()) {
                        pongBuf = ByteBuffer.allocate(frame.getPayload().remaining());
                        BufferUtil.put(frame.getPayload().slice(), pongBuf);
                        BufferUtil.flipToFlush(pongBuf, 0);
                    } else {
                        pongBuf = ByteBuffer.allocate(0);
                    }
                    onPing(frame.getPayload());
                    this.session.getRemote().sendPong(pongBuf);
                    break;
                case 10:
                    if (this.logger.isDebugEnabled()) {
                        this.logger.debug("PONG: {}", BufferUtil.toDetailString(frame.getPayload()));
                    }
                    onPong(frame.getPayload());
                    break;
            }
        } catch (Utf8Appendable.NotUtf8Exception e) {
            this.session.close(new BadPayloadException(e));
        } catch (Throwable t) {
            this.session.close(t);
        }
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public void onContinuationFrame(ByteBuffer buffer, boolean fin) throws IOException {
        if (this.activeMessage == null) {
            throw new IOException("Out of order Continuation frame encountered");
        }
        appendMessage(buffer, fin);
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public void onPong(ByteBuffer buffer) {
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public void onPing(ByteBuffer buffer) {
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public BatchMode getBatchMode() {
        return null;
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public void openSession(WebSocketSession session) {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("openSession({}) objectFactory={}", session, session.getContainerScope().getObjectFactory());
        }
        this.session = session;
        this.session.getContainerScope().getObjectFactory().decorate(this.websocket);
        try {
            onConnect();
        } catch (Throwable t) {
            this.session.close(t);
        }
    }
}
