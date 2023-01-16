package org.eclipse.jetty.websocket.common.extensions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import org.eclipse.jetty.util.IteratingCallback;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.Extension;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.api.extensions.ExtensionFactory;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.api.extensions.IncomingFrames;
import org.eclipse.jetty.websocket.api.extensions.OutgoingFrames;
import org.eclipse.jetty.websocket.common.Generator;
import org.eclipse.jetty.websocket.common.Parser;

@ManagedObject("Extension Stack")
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/ExtensionStack.class */
public class ExtensionStack extends ContainerLifeCycle implements IncomingFrames, OutgoingFrames {
    private static final Logger LOG = Log.getLogger(ExtensionStack.class);
    private final Queue<FrameEntry> entries = new ArrayDeque();
    private final IteratingCallback flusher = new Flusher();
    private final ExtensionFactory factory;
    private List<Extension> extensions;
    private IncomingFrames nextIncoming;
    private OutgoingFrames nextOutgoing;

    public ExtensionStack(ExtensionFactory factory) {
        this.factory = factory;
    }

    public void configure(Generator generator) {
        generator.configureFromExtensions(this.extensions);
    }

    public void configure(Parser parser) {
        parser.configureFromExtensions(this.extensions);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        doStart();
        if (this.extensions != null && this.extensions.size() > 0) {
            ListIterator<Extension> exts = this.extensions.listIterator();
            while (exts.hasNext()) {
                Extension ext = exts.next();
                ext.setNextOutgoingFrames(this.nextOutgoing);
                this.nextOutgoing = ext;
                if (ext instanceof LifeCycle) {
                    addBean((Object) ext, true);
                }
            }
            while (exts.hasPrevious()) {
                Extension ext2 = exts.previous();
                ext2.setNextIncomingFrames(this.nextIncoming);
                this.nextIncoming = ext2;
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dumpSelf() {
        return String.format("%s@%x[size=%d,queueSize=%d]", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(this.extensions.size()), Integer.valueOf(getQueueSize()));
    }

    @ManagedAttribute(name = "Extension List", readonly = true)
    public List<Extension> getExtensions() {
        return this.extensions;
    }

    private IncomingFrames getLastIncoming() {
        IncomingFrames last = this.nextIncoming;
        boolean done = false;
        while (!done) {
            if (last instanceof AbstractExtension) {
                last = ((AbstractExtension) last).getNextIncoming();
            } else {
                done = true;
            }
        }
        return last;
    }

    private OutgoingFrames getLastOutgoing() {
        OutgoingFrames last = this.nextOutgoing;
        boolean done = false;
        while (!done) {
            if (last instanceof AbstractExtension) {
                last = ((AbstractExtension) last).getNextOutgoing();
            } else {
                done = true;
            }
        }
        return last;
    }

    public List<ExtensionConfig> getNegotiatedExtensions() {
        List<ExtensionConfig> ret = new ArrayList<>();
        if (this.extensions == null) {
            return ret;
        }
        for (Extension ext : this.extensions) {
            if (ext.getName().charAt(0) != '@') {
                ret.add(ext.getConfig());
            }
        }
        return ret;
    }

    @ManagedAttribute(name = "Next Incoming Frames Handler", readonly = true)
    public IncomingFrames getNextIncoming() {
        return this.nextIncoming;
    }

    @ManagedAttribute(name = "Next Outgoing Frames Handler", readonly = true)
    public OutgoingFrames getNextOutgoing() {
        return this.nextOutgoing;
    }

    public boolean hasNegotiatedExtensions() {
        return this.extensions != null && this.extensions.size() > 0;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.IncomingFrames
    public void incomingFrame(Frame frame) {
        this.nextIncoming.incomingFrame(frame);
    }

    public void negotiate(List<ExtensionConfig> configs) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Extension Configs={}", configs);
        }
        this.extensions = new ArrayList();
        String[] rsvClaims = new String[3];
        for (ExtensionConfig config : configs) {
            Extension ext = this.factory.newInstance(config);
            if (ext != null) {
                if (!ext.isRsv1User() || rsvClaims[0] == null) {
                    if (!ext.isRsv2User() || rsvClaims[1] == null) {
                        if (!ext.isRsv3User() || rsvClaims[2] == null) {
                            this.extensions.add(ext);
                            addBean(ext);
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("Adding Extension: {}", config);
                            }
                            if (ext.isRsv1User()) {
                                rsvClaims[0] = ext.getName();
                            }
                            if (ext.isRsv2User()) {
                                rsvClaims[1] = ext.getName();
                            }
                            if (ext.isRsv3User()) {
                                rsvClaims[2] = ext.getName();
                            }
                        } else if (LOG.isDebugEnabled()) {
                            LOG.debug("Not adding extension {}. Extension {} already claimed RSV3", config, rsvClaims[2]);
                        }
                    } else if (LOG.isDebugEnabled()) {
                        LOG.debug("Not adding extension {}. Extension {} already claimed RSV2", config, rsvClaims[1]);
                    }
                } else if (LOG.isDebugEnabled()) {
                    LOG.debug("Not adding extension {}. Extension {} already claimed RSV1", config, rsvClaims[0]);
                }
            }
        }
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.OutgoingFrames
    public void outgoingFrame(Frame frame, WriteCallback callback, BatchMode batchMode) {
        FrameEntry entry = new FrameEntry(frame, callback, batchMode);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Queuing {}", entry);
        }
        offerEntry(entry);
        this.flusher.iterate();
    }

    public void setNextIncoming(IncomingFrames nextIncoming) {
        this.nextIncoming = nextIncoming;
    }

    public void setNextOutgoing(OutgoingFrames nextOutgoing) {
        this.nextOutgoing = nextOutgoing;
    }

    public void setPolicy(WebSocketPolicy policy) {
        for (Extension extension : this.extensions) {
            if (extension instanceof AbstractExtension) {
                ((AbstractExtension) extension).setPolicy(policy);
            }
        }
    }

    private void offerEntry(FrameEntry entry) {
        synchronized (this) {
            this.entries.offer(entry);
        }
    }

    /* access modifiers changed from: private */
    public FrameEntry pollEntry() {
        FrameEntry poll;
        synchronized (this) {
            poll = this.entries.poll();
        }
        return poll;
    }

    private int getQueueSize() {
        int size;
        synchronized (this) {
            size = this.entries.size();
        }
        return size;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ExtensionStack[");
        s.append("queueSize=").append(getQueueSize());
        s.append(",extensions=");
        if (this.extensions == null) {
            s.append("<null>");
        } else {
            s.append('[');
            boolean delim = false;
            for (Extension ext : this.extensions) {
                if (delim) {
                    s.append(',');
                }
                if (ext == null) {
                    s.append("<null>");
                } else {
                    s.append(ext.getName());
                }
                delim = true;
            }
            s.append(']');
        }
        s.append(",incoming=").append(this.nextIncoming == null ? "<null>" : this.nextIncoming.getClass().getName());
        s.append(",outgoing=").append(this.nextOutgoing == null ? "<null>" : this.nextOutgoing.getClass().getName());
        s.append("]");
        return s.toString();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/ExtensionStack$FrameEntry.class */
    public static class FrameEntry {
        private final Frame frame;
        private final WriteCallback callback;
        private final BatchMode batchMode;

        private FrameEntry(Frame frame, WriteCallback callback, BatchMode batchMode) {
            this.frame = frame;
            this.callback = callback;
            this.batchMode = batchMode;
        }

        public String toString() {
            return this.frame.toString();
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/ExtensionStack$Flusher.class */
    private class Flusher extends IteratingCallback implements WriteCallback {
        private FrameEntry current;

        private Flusher() {
        }

        @Override // org.eclipse.jetty.util.IteratingCallback
        protected IteratingCallback.Action process() throws Exception {
            this.current = ExtensionStack.this.pollEntry();
            if (this.current == null) {
                if (ExtensionStack.LOG.isDebugEnabled()) {
                    ExtensionStack.LOG.debug("Entering IDLE", new Object[0]);
                }
                return IteratingCallback.Action.IDLE;
            }
            if (ExtensionStack.LOG.isDebugEnabled()) {
                ExtensionStack.LOG.debug("Processing {}", this.current);
            }
            ExtensionStack.this.nextOutgoing.outgoingFrame(this.current.frame, this, this.current.batchMode);
            return IteratingCallback.Action.SCHEDULED;
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.util.IteratingCallback
        public void onCompleteSuccess() {
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.util.IteratingCallback
        public void onCompleteFailure(Throwable x) {
        }

        @Override // org.eclipse.jetty.websocket.api.WriteCallback
        public void writeSuccess() {
            notifyCallbackSuccess(this.current.callback);
            succeeded();
        }

        @Override // org.eclipse.jetty.websocket.api.WriteCallback
        public void writeFailed(Throwable x) {
            notifyCallbackFailure(this.current.callback, x);
            succeeded();
        }

        private void notifyCallbackSuccess(WriteCallback callback) {
            if (callback != null) {
                try {
                    callback.writeSuccess();
                } catch (Throwable x) {
                    if (ExtensionStack.LOG.isDebugEnabled()) {
                        ExtensionStack.LOG.debug("Exception while notifying success of callback " + callback, x);
                    }
                }
            }
        }

        private void notifyCallbackFailure(WriteCallback callback, Throwable failure) {
            if (callback != null) {
                try {
                    callback.writeFailed(failure);
                } catch (Throwable x) {
                    if (ExtensionStack.LOG.isDebugEnabled()) {
                        ExtensionStack.LOG.debug("Exception while notifying failure of callback " + callback, x);
                    }
                }
            }
        }
    }
}
