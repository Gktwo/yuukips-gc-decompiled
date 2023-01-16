package org.eclipse.jetty.websocket.common.p025io;

import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.api.extensions.IncomingFrames;
import org.eclipse.jetty.websocket.api.extensions.OutgoingFrames;

/* renamed from: org.eclipse.jetty.websocket.common.io.FramePipes */
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/FramePipes.class */
public class FramePipes {

    /* renamed from: org.eclipse.jetty.websocket.common.io.FramePipes$In2Out */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/FramePipes$In2Out.class */
    private static class In2Out implements IncomingFrames {
        private OutgoingFrames outgoing;

        public In2Out(OutgoingFrames outgoing) {
            this.outgoing = outgoing;
        }

        @Override // org.eclipse.jetty.websocket.api.extensions.IncomingFrames
        public void incomingFrame(Frame frame) {
            this.outgoing.outgoingFrame(frame, null, BatchMode.OFF);
        }
    }

    /* renamed from: org.eclipse.jetty.websocket.common.io.FramePipes$Out2In */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/FramePipes$Out2In.class */
    private static class Out2In implements OutgoingFrames {
        private IncomingFrames incoming;

        public Out2In(IncomingFrames incoming) {
            this.incoming = incoming;
        }

        @Override // org.eclipse.jetty.websocket.api.extensions.OutgoingFrames
        public void outgoingFrame(Frame frame, WriteCallback callback, BatchMode batchMode) {
            try {
                this.incoming.incomingFrame(frame);
                callback.writeSuccess();
            } catch (Throwable t) {
                callback.writeFailed(t);
            }
        }
    }

    /* renamed from: to */
    public static OutgoingFrames m33to(IncomingFrames incoming) {
        return new Out2In(incoming);
    }

    /* renamed from: to */
    public static IncomingFrames m32to(OutgoingFrames outgoing) {
        return new In2Out(outgoing);
    }
}
