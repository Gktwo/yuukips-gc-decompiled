package org.eclipse.jetty.websocket.common.extensions.fragment;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;
import org.eclipse.jetty.util.IteratingCallback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.common.OpCode;
import org.eclipse.jetty.websocket.common.extensions.AbstractExtension;
import org.eclipse.jetty.websocket.common.frames.DataFrame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/fragment/FragmentExtension.class */
public class FragmentExtension extends AbstractExtension {
    private static final Logger LOG = Log.getLogger(FragmentExtension.class);
    private final Queue<FrameEntry> entries = new ArrayDeque();
    private final IteratingCallback flusher = new Flusher();
    private int maxLength;

    @Override // org.eclipse.jetty.websocket.common.extensions.AbstractExtension, org.eclipse.jetty.websocket.api.extensions.Extension
    public String getName() {
        return "fragment";
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.IncomingFrames
    public void incomingFrame(Frame frame) {
        nextIncomingFrame(frame);
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.OutgoingFrames
    public void outgoingFrame(Frame frame, WriteCallback callback, BatchMode batchMode) {
        ByteBuffer payload = frame.getPayload();
        int length = payload != null ? payload.remaining() : 0;
        if (OpCode.isControlFrame(frame.getOpCode()) || this.maxLength <= 0 || length <= this.maxLength) {
            nextOutgoingFrame(frame, callback, batchMode);
            return;
        }
        FrameEntry entry = new FrameEntry(frame, callback, batchMode);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Queuing {}", entry);
        }
        offerEntry(entry);
        this.flusher.iterate();
    }

    @Override // org.eclipse.jetty.websocket.common.extensions.AbstractExtension
    public void setConfig(ExtensionConfig config) {
        setConfig(config);
        this.maxLength = config.getParameter("maxLength", -1);
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

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/fragment/FragmentExtension$FrameEntry.class */
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

    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/fragment/FragmentExtension$Flusher.class */
    private class Flusher extends IteratingCallback implements WriteCallback {
        private FrameEntry current;
        private boolean finished;

        private Flusher() {
            this.finished = true;
        }

        @Override // org.eclipse.jetty.util.IteratingCallback
        protected IteratingCallback.Action process() {
            if (this.finished) {
                this.current = FragmentExtension.this.pollEntry();
                if (this.current == null) {
                    if (FragmentExtension.LOG.isDebugEnabled()) {
                        FragmentExtension.LOG.debug("Processing IDLE", this.current);
                    }
                    return IteratingCallback.Action.IDLE;
                }
                if (FragmentExtension.LOG.isDebugEnabled()) {
                    FragmentExtension.LOG.debug("Processing {}", this.current);
                }
                fragment(this.current, true);
            } else {
                fragment(this.current, false);
            }
            return IteratingCallback.Action.SCHEDULED;
        }

        private void fragment(FrameEntry entry, boolean first) {
            Frame frame = entry.frame;
            ByteBuffer payload = frame.getPayload();
            int remaining = payload.remaining();
            int length = Math.min(remaining, FragmentExtension.this.maxLength);
            this.finished = length == remaining;
            DataFrame fragment = new DataFrame(frame, frame.getType().isContinuation() || !first);
            fragment.setFin(frame.isFin() && this.finished);
            int limit = payload.limit();
            int newLimit = payload.position() + length;
            payload.limit(newLimit);
            ByteBuffer payloadFragment = payload.slice();
            payload.limit(limit);
            fragment.setPayload(payloadFragment);
            if (FragmentExtension.LOG.isDebugEnabled()) {
                FragmentExtension.LOG.debug("Fragmented {}->{}", frame, fragment);
            }
            payload.position(newLimit);
            FragmentExtension.this.nextOutgoingFrame(fragment, this, entry.batchMode);
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
            if (this.finished) {
                notifyCallbackSuccess(this.current.callback);
            }
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
                    if (FragmentExtension.LOG.isDebugEnabled()) {
                        FragmentExtension.LOG.debug("Exception while notifying success of callback " + callback, x);
                    }
                }
            }
        }

        private void notifyCallbackFailure(WriteCallback callback, Throwable failure) {
            if (callback != null) {
                try {
                    callback.writeFailed(failure);
                } catch (Throwable x) {
                    if (FragmentExtension.LOG.isDebugEnabled()) {
                        FragmentExtension.LOG.debug("Exception while notifying failure of callback " + callback, x);
                    }
                }
            }
        }
    }
}
