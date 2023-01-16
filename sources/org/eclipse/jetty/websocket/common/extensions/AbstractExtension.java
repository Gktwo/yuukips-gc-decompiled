package org.eclipse.jetty.websocket.common.extensions;

import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.Extension;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.api.extensions.IncomingFrames;
import org.eclipse.jetty.websocket.api.extensions.OutgoingFrames;
import org.eclipse.jetty.websocket.common.LogicalConnection;
import org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope;

@ManagedObject("Abstract Extension")
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/AbstractExtension.class */
public abstract class AbstractExtension extends AbstractLifeCycle implements Extension {
    private final Logger log = Log.getLogger(getClass());
    private WebSocketPolicy policy;
    private ByteBufferPool bufferPool;
    private ExtensionConfig config;
    private LogicalConnection connection;
    private OutgoingFrames nextOutgoing;
    private IncomingFrames nextIncoming;

    @Deprecated
    public void init(WebSocketContainerScope container) {
        init(container.getPolicy(), container.getBufferPool());
    }

    public void init(WebSocketPolicy policy, ByteBufferPool bufferPool) {
        this.policy = policy;
        this.bufferPool = bufferPool;
    }

    public ByteBufferPool getBufferPool() {
        return this.bufferPool;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Extension
    public ExtensionConfig getConfig() {
        return this.config;
    }

    public LogicalConnection getConnection() {
        return this.connection;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Extension
    public String getName() {
        return this.config.getName();
    }

    @ManagedAttribute(name = "Next Incoming Frame Handler", readonly = true)
    public IncomingFrames getNextIncoming() {
        return this.nextIncoming;
    }

    @ManagedAttribute(name = "Next Outgoing Frame Handler", readonly = true)
    public OutgoingFrames getNextOutgoing() {
        return this.nextOutgoing;
    }

    public WebSocketPolicy getPolicy() {
        return this.policy;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Extension
    public boolean isRsv1User() {
        return false;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Extension
    public boolean isRsv2User() {
        return false;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Extension
    public boolean isRsv3User() {
        return false;
    }

    protected void nextIncomingFrame(Frame frame) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("nextIncomingFrame({})", frame);
        }
        this.nextIncoming.incomingFrame(frame);
    }

    protected void nextOutgoingFrame(Frame frame, WriteCallback callback, BatchMode batchMode) {
        try {
            if (this.log.isDebugEnabled()) {
                this.log.debug("nextOutgoingFrame({})", frame);
            }
            this.nextOutgoing.outgoingFrame(frame, callback, batchMode);
        } catch (Throwable t) {
            if (callback != null) {
                callback.writeFailed(t);
            } else {
                this.log.warn(t);
            }
        }
    }

    public void setBufferPool(ByteBufferPool bufferPool) {
        this.bufferPool = bufferPool;
    }

    public void setConfig(ExtensionConfig config) {
        this.config = config;
    }

    public void setConnection(LogicalConnection connection) {
        this.connection = connection;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Extension
    public void setNextIncomingFrames(IncomingFrames nextIncoming) {
        this.nextIncoming = nextIncoming;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Extension
    public void setNextOutgoingFrames(OutgoingFrames nextOutgoing) {
        this.nextOutgoing = nextOutgoing;
    }

    public void setPolicy(WebSocketPolicy policy) {
        this.policy = policy;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), this.config.getParameterizedName());
    }
}
