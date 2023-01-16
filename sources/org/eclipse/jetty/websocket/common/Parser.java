package org.eclipse.jetty.websocket.common;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.MessageTooLargeException;
import org.eclipse.jetty.websocket.api.ProtocolException;
import org.eclipse.jetty.websocket.api.WebSocketBehavior;
import org.eclipse.jetty.websocket.api.WebSocketException;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.extensions.Extension;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.api.extensions.IncomingFrames;
import org.eclipse.jetty.websocket.common.frames.BinaryFrame;
import org.eclipse.jetty.websocket.common.frames.CloseFrame;
import org.eclipse.jetty.websocket.common.frames.ContinuationFrame;
import org.eclipse.jetty.websocket.common.frames.PingFrame;
import org.eclipse.jetty.websocket.common.frames.PongFrame;
import org.eclipse.jetty.websocket.common.frames.TextFrame;
import org.eclipse.jetty.websocket.common.p025io.payload.DeMaskProcessor;
import org.eclipse.jetty.websocket.common.p025io.payload.PayloadProcessor;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/Parser.class */
public class Parser {
    private static final Logger LOG = Log.getLogger(Parser.class);
    private final WebSocketPolicy policy;
    private final ByteBufferPool bufferPool;
    private WebSocketFrame frame;
    private boolean priorDataFrame;
    private ByteBuffer payload;
    private int payloadLength;
    private IncomingFrames incomingFramesHandler;
    private final LongAdder messagesIn = new LongAdder();
    private State state = State.START;
    private int cursor = 0;
    private PayloadProcessor maskProcessor = new DeMaskProcessor();
    private byte flagsInUse = 0;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/Parser$State.class */
    public enum State {
        START,
        PAYLOAD_LEN,
        PAYLOAD_LEN_BYTES,
        MASK,
        MASK_BYTES,
        PAYLOAD
    }

    public Parser(WebSocketPolicy wspolicy, ByteBufferPool bufferPool) {
        this.bufferPool = bufferPool;
        this.policy = wspolicy;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void assertSanePayloadLength(long len) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} Payload Length: {} - {}", this.policy.getBehavior(), Long.valueOf(len), this);
        }
        if (len > 2147483647L) {
            throw new MessageTooLargeException("[int-sane!] cannot handle payload lengths larger than 2147483647");
        }
        switch (this.frame.getOpCode()) {
            case 1:
                this.policy.assertValidTextMessageSize((int) len);
                return;
            case 2:
                this.policy.assertValidBinaryMessageSize((int) len);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                return;
            case 8:
                if (len == 1) {
                    throw new ProtocolException("Invalid close frame payload length, [" + this.payloadLength + "]");
                }
                break;
            case 9:
            case 10:
                break;
        }
        if (len > 125) {
            throw new ProtocolException("Invalid control frame payload length, [" + this.payloadLength + "] cannot exceed [125]");
        }
    }

    public void configureFromExtensions(List<? extends Extension> exts) {
        this.flagsInUse = 0;
        for (Extension ext : exts) {
            if (ext.isRsv1User()) {
                this.flagsInUse = (byte) (this.flagsInUse | 64);
            }
            if (ext.isRsv2User()) {
                this.flagsInUse = (byte) (this.flagsInUse | 32);
            }
            if (ext.isRsv3User()) {
                this.flagsInUse = (byte) (this.flagsInUse | 16);
            }
        }
    }

    public IncomingFrames getIncomingFramesHandler() {
        return this.incomingFramesHandler;
    }

    public WebSocketPolicy getPolicy() {
        return this.policy;
    }

    public boolean isRsv1InUse() {
        return (this.flagsInUse & 64) != 0;
    }

    public boolean isRsv2InUse() {
        return (this.flagsInUse & 32) != 0;
    }

    public boolean isRsv3InUse() {
        return (this.flagsInUse & 16) != 0;
    }

    protected void notifyFrame(Frame f) throws WebSocketException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} Notify {}", this.policy.getBehavior(), getIncomingFramesHandler());
        }
        if (this.policy.getBehavior() == WebSocketBehavior.SERVER) {
            if (!f.isMasked()) {
                throw new ProtocolException("Client MUST mask all frames (RFC-6455: Section 5.1)");
            }
        } else if (this.policy.getBehavior() == WebSocketBehavior.CLIENT && f.isMasked()) {
            throw new ProtocolException("Server MUST NOT mask any frames (RFC-6455: Section 5.1)");
        }
        if (this.incomingFramesHandler != null) {
            try {
                this.incomingFramesHandler.incomingFrame(f);
            } catch (WebSocketException e) {
                throw e;
            } catch (Throwable t) {
                throw new WebSocketException(t);
            }
        } else if (LOG.isDebugEnabled()) {
            LOG.debug("No IncomingFrames Handler to notify", new Object[0]);
        }
    }

    public void parse(ByteBuffer buffer) throws WebSocketException {
        while (buffer.hasRemaining()) {
            parseSingleFrame(buffer);
        }
    }

    public void parseSingleFrame(ByteBuffer buffer) throws WebSocketException {
        if (buffer.remaining() > 0) {
            try {
                if (parseFrame(buffer)) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("{} Parsed Frame: {}", this.policy.getBehavior(), this.frame);
                    }
                    this.messagesIn.increment();
                    notifyFrame(this.frame);
                    if (this.frame.isDataFrame()) {
                        this.priorDataFrame = !this.frame.isFin();
                    }
                    reset();
                }
            } catch (Throwable t) {
                buffer.position(buffer.limit());
                reset();
                if (t instanceof WebSocketException) {
                    throw t;
                }
                throw new WebSocketException(t);
            }
        }
    }

    private void reset() {
        if (this.frame != null) {
            this.frame.reset();
        }
        this.frame = null;
        this.bufferPool.release(this.payload);
        this.payload = null;
    }

    private boolean parseFrame(ByteBuffer buffer) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} Parsing {} bytes", this.policy.getBehavior(), Integer.valueOf(buffer.remaining()));
        }
        while (buffer.hasRemaining()) {
            switch (this.state) {
                case START:
                    byte b = buffer.get();
                    boolean fin = (b & 128) != 0;
                    byte opcode = (byte) (b & 15);
                    if (OpCode.isKnown(opcode)) {
                        if (LOG.isDebugEnabled()) {
                            Logger logger = LOG;
                            Object[] objArr = new Object[6];
                            objArr[0] = this.policy.getBehavior();
                            objArr[1] = OpCode.name(opcode);
                            objArr[2] = Boolean.valueOf(fin);
                            objArr[3] = Character.valueOf((b & 64) != 0 ? '1' : '.');
                            objArr[4] = Character.valueOf((b & 32) != 0 ? '1' : '.');
                            objArr[5] = Character.valueOf((b & 16) != 0 ? '1' : '.');
                            logger.debug("{} OpCode {}, fin={} rsv={}{}{}", objArr);
                        }
                        switch (opcode) {
                            case 0:
                                this.frame = new ContinuationFrame();
                                if (!this.priorDataFrame) {
                                    throw new ProtocolException("CONTINUATION frame without prior !FIN");
                                }
                                break;
                            case 1:
                                this.frame = new TextFrame();
                                if (this.priorDataFrame) {
                                    throw new ProtocolException("Unexpected " + OpCode.name(opcode) + " frame, was expecting CONTINUATION");
                                }
                                break;
                            case 2:
                                this.frame = new BinaryFrame();
                                if (this.priorDataFrame) {
                                    throw new ProtocolException("Unexpected " + OpCode.name(opcode) + " frame, was expecting CONTINUATION");
                                }
                                break;
                            case 8:
                                this.frame = new CloseFrame();
                                if (!fin) {
                                    throw new ProtocolException("Fragmented Close Frame [" + OpCode.name(opcode) + "]");
                                }
                                break;
                            case 9:
                                this.frame = new PingFrame();
                                if (!fin) {
                                    throw new ProtocolException("Fragmented Ping Frame [" + OpCode.name(opcode) + "]");
                                }
                                break;
                            case 10:
                                this.frame = new PongFrame();
                                if (!fin) {
                                    throw new ProtocolException("Fragmented Pong Frame [" + OpCode.name(opcode) + "]");
                                }
                                break;
                        }
                        this.frame.setFin(fin);
                        if ((b & 112) != 0) {
                            if ((b & 64) != 0) {
                                if (isRsv1InUse()) {
                                    this.frame.setRsv1(true);
                                } else {
                                    if (LOG.isDebugEnabled()) {
                                        LOG.debug("RSV1 not allowed to be set: Remaining buffer: {}", BufferUtil.toDetailString(buffer));
                                    }
                                    throw new ProtocolException("RSV1 not allowed to be set");
                                }
                            }
                            if ((b & 32) != 0) {
                                if (isRsv2InUse()) {
                                    this.frame.setRsv2(true);
                                } else {
                                    if (LOG.isDebugEnabled()) {
                                        LOG.debug("RSV2 not allowed to be set: Remaining buffer: {}", BufferUtil.toDetailString(buffer));
                                    }
                                    throw new ProtocolException("RSV2 not allowed to be set");
                                }
                            }
                            if ((b & 16) != 0) {
                                if (isRsv3InUse()) {
                                    this.frame.setRsv3(true);
                                } else {
                                    if (LOG.isDebugEnabled()) {
                                        LOG.debug("RSV3 not allowed to be set: Remaining buffer: {}", BufferUtil.toDetailString(buffer));
                                    }
                                    throw new ProtocolException("RSV3 not allowed to be set");
                                }
                            }
                        }
                        this.state = State.PAYLOAD_LEN;
                        break;
                    } else {
                        throw new ProtocolException("Unknown opcode: " + ((int) opcode));
                    }
                case PAYLOAD_LEN:
                    byte b2 = buffer.get();
                    this.frame.setMasked((b2 & 128) != 0);
                    this.payloadLength = (byte) (Byte.MAX_VALUE & b2);
                    if (this.payloadLength != 127) {
                        if (this.payloadLength != 126) {
                            assertSanePayloadLength((long) this.payloadLength);
                            if (!this.frame.isMasked()) {
                                if (this.payloadLength != 0) {
                                    this.maskProcessor.reset(this.frame);
                                    this.state = State.PAYLOAD;
                                    break;
                                } else {
                                    this.state = State.START;
                                    return true;
                                }
                            } else {
                                this.state = State.MASK;
                                break;
                            }
                        } else {
                            this.payloadLength = 0;
                            this.state = State.PAYLOAD_LEN_BYTES;
                            this.cursor = 2;
                            break;
                        }
                    } else {
                        this.payloadLength = 0;
                        this.state = State.PAYLOAD_LEN_BYTES;
                        this.cursor = 8;
                        break;
                    }
                case PAYLOAD_LEN_BYTES:
                    byte b3 = buffer.get();
                    this.cursor--;
                    this.payloadLength |= (b3 & 255) << (8 * this.cursor);
                    if (this.cursor == 0) {
                        assertSanePayloadLength((long) this.payloadLength);
                        if (!this.frame.isMasked()) {
                            if (this.payloadLength != 0) {
                                this.maskProcessor.reset(this.frame);
                                this.state = State.PAYLOAD;
                                break;
                            } else {
                                this.state = State.START;
                                return true;
                            }
                        } else {
                            this.state = State.MASK;
                            break;
                        }
                    } else {
                        continue;
                    }
                case MASK:
                    byte[] m = new byte[4];
                    this.frame.setMask(m);
                    if (buffer.remaining() < 4) {
                        this.state = State.MASK_BYTES;
                        this.cursor = 4;
                        break;
                    } else {
                        buffer.get(m, 0, 4);
                        if (this.payloadLength != 0) {
                            this.maskProcessor.reset(this.frame);
                            this.state = State.PAYLOAD;
                            break;
                        } else {
                            this.state = State.START;
                            return true;
                        }
                    }
                case MASK_BYTES:
                    this.frame.getMask()[4 - this.cursor] = buffer.get();
                    this.cursor--;
                    if (this.cursor == 0) {
                        if (this.payloadLength != 0) {
                            this.maskProcessor.reset(this.frame);
                            this.state = State.PAYLOAD;
                            break;
                        } else {
                            this.state = State.START;
                            return true;
                        }
                    } else {
                        continue;
                    }
                case PAYLOAD:
                    this.frame.assertValid();
                    if (!parsePayload(buffer)) {
                        break;
                    } else {
                        if (this.frame.getOpCode() == 8) {
                            new CloseInfo(this.frame);
                        }
                        this.state = State.START;
                        return true;
                    }
            }
        }
        return false;
    }

    private boolean parsePayload(ByteBuffer buffer) {
        if (this.payloadLength == 0) {
            return true;
        }
        if (!buffer.hasRemaining()) {
            return false;
        }
        int windowBytes = Math.min(buffer.remaining(), this.payloadLength - (this.payload == null ? 0 : this.payload.position()));
        int limit = buffer.limit();
        buffer.limit(buffer.position() + windowBytes);
        ByteBuffer window = buffer.slice();
        buffer.limit(limit);
        buffer.position(buffer.position() + window.remaining());
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} Window: {}", this.policy.getBehavior(), BufferUtil.toDetailString(window));
        }
        this.maskProcessor.process(window);
        if (window.remaining() == this.payloadLength) {
            this.frame.setPayload(window);
            return true;
        }
        if (this.payload == null) {
            this.payload = this.bufferPool.acquire(this.payloadLength, false);
            BufferUtil.clearToFill(this.payload);
        }
        this.payload.put(window);
        if (this.payload.position() != this.payloadLength) {
            return false;
        }
        BufferUtil.flipToFlush(this.payload, 0);
        this.frame.setPayload(this.payload);
        return true;
    }

    public void setIncomingFramesHandler(IncomingFrames incoming) {
        this.incomingFramesHandler = incoming;
    }

    public long getMessagesIn() {
        return this.messagesIn.longValue();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Parser@").append(Integer.toHexString(hashCode()));
        builder.append("[");
        if (this.incomingFramesHandler == null) {
            builder.append("NO_HANDLER");
        } else {
            builder.append(this.incomingFramesHandler.getClass().getSimpleName());
        }
        builder.append(",s=").append(this.state);
        builder.append(",c=").append(this.cursor);
        builder.append(",len=").append(this.payloadLength);
        builder.append(",f=").append(this.frame);
        builder.append("]");
        return builder.toString();
    }
}
