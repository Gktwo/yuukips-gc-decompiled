package org.eclipse.jetty.websocket.common.extensions.compress;

import java.util.zip.DataFormatException;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.BadPayloadException;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.ProtocolException;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.common.OpCode;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/compress/PerMessageDeflateExtension.class */
public class PerMessageDeflateExtension extends CompressExtension {
    private static final Logger LOG = Log.getLogger(PerMessageDeflateExtension.class);
    private ExtensionConfig configRequested;
    private ExtensionConfig configNegotiated;
    private boolean incomingContextTakeover = true;
    private boolean outgoingContextTakeover = true;
    private boolean incomingCompressed;

    @Override // org.eclipse.jetty.websocket.common.extensions.AbstractExtension, org.eclipse.jetty.websocket.api.extensions.Extension
    public String getName() {
        return "permessage-deflate";
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.IncomingFrames
    public void incomingFrame(Frame frame) {
        if (frame.getType().isData()) {
            this.incomingCompressed = frame.isRsv1();
        }
        if (OpCode.isControlFrame(frame.getOpCode()) || !this.incomingCompressed) {
            nextIncomingFrame(frame);
        } else if (frame.getOpCode() != 0 || !frame.isRsv1()) {
            try {
                ByteAccumulator accumulator = newByteAccumulator();
                decompress(accumulator, frame.getPayload());
                if (frame.isFin()) {
                    decompress(accumulator, TAIL_BYTES_BUF.slice());
                }
                forwardIncoming(frame, accumulator);
                if (accumulator != null) {
                    accumulator.close();
                }
                if (frame.isFin()) {
                    this.incomingCompressed = false;
                }
            } catch (DataFormatException e) {
                throw new BadPayloadException(e);
            }
        } else {
            throw new ProtocolException("Invalid RSV1 set on permessage-deflate CONTINUATION frame");
        }
    }

    @Override // org.eclipse.jetty.websocket.common.extensions.AbstractExtension
    protected void nextIncomingFrame(Frame frame) {
        if (frame.isFin() && !this.incomingContextTakeover) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Incoming Context Reset", new Object[0]);
            }
            this.decompressCount.set(0);
            getInflater().reset();
        }
        nextIncomingFrame(frame);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.websocket.common.extensions.AbstractExtension
    public void nextOutgoingFrame(Frame frame, WriteCallback callback, BatchMode batchMode) {
        if (frame.isFin() && !this.outgoingContextTakeover) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Outgoing Context Reset", new Object[0]);
            }
            getDeflater().reset();
        }
        nextOutgoingFrame(frame, callback, batchMode);
    }

    @Override // org.eclipse.jetty.websocket.common.extensions.compress.CompressExtension
    int getRsvUseMode() {
        return 1;
    }

    @Override // org.eclipse.jetty.websocket.common.extensions.compress.CompressExtension
    int getTailDropMode() {
        return 2;
    }

    @Override // org.eclipse.jetty.websocket.common.extensions.AbstractExtension
    public void setConfig(ExtensionConfig config) {
        this.configRequested = new ExtensionConfig(config);
        this.configNegotiated = new ExtensionConfig(config.getName());
        for (String key : config.getParameterKeys()) {
            String key2 = key.trim();
            char c = 65535;
            switch (key2.hashCode()) {
                case -708713803:
                    if (key2.equals("client_no_context_takeover")) {
                        c = 2;
                        break;
                    }
                    break;
                case 646404390:
                    if (key2.equals("client_max_window_bits")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1266201133:
                    if (key2.equals("server_no_context_takeover")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2034279582:
                    if (key2.equals("server_max_window_bits")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    break;
                case 2:
                    this.configNegotiated.setParameter("client_no_context_takeover");
                    switch (getPolicy().getBehavior()) {
                        case CLIENT:
                            this.incomingContextTakeover = false;
                            continue;
                        case SERVER:
                            this.outgoingContextTakeover = false;
                            continue;
                    }
                case 3:
                    this.configNegotiated.setParameter("server_no_context_takeover");
                    switch (getPolicy().getBehavior()) {
                        case CLIENT:
                            this.outgoingContextTakeover = false;
                            continue;
                        case SERVER:
                            this.incomingContextTakeover = false;
                            continue;
                    }
                default:
                    throw new IllegalArgumentException();
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("config: outgoingContextTakeover={}, incomingContextTakeover={} : {}", Boolean.valueOf(this.outgoingContextTakeover), Boolean.valueOf(this.incomingContextTakeover), this);
        }
        setConfig(this.configNegotiated);
    }

    @Override // org.eclipse.jetty.websocket.common.extensions.compress.CompressExtension, org.eclipse.jetty.websocket.common.extensions.AbstractExtension, org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s[requested=\"%s\", negotiated=\"%s\"]", getClass().getSimpleName(), this.configRequested.getParameterizedName(), this.configNegotiated.getParameterizedName());
    }
}
