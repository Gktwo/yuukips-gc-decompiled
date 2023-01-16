package org.eclipse.jetty.websocket.common;

import java.io.IOException;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.SharedBlockingCallback;
import org.eclipse.jetty.util.thread.Invocable;
import org.eclipse.jetty.websocket.api.WriteCallback;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/BlockingWriteCallback.class */
public class BlockingWriteCallback extends SharedBlockingCallback {
    public WriteBlocker acquireWriteBlocker() throws IOException {
        return new WriteBlocker(acquire());
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/BlockingWriteCallback$WriteBlocker.class */
    public static class WriteBlocker implements WriteCallback, Callback, AutoCloseable {
        private final SharedBlockingCallback.Blocker blocker;

        protected WriteBlocker(SharedBlockingCallback.Blocker blocker) {
            this.blocker = blocker;
        }

        @Override // org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            return Invocable.InvocationType.NON_BLOCKING;
        }

        @Override // org.eclipse.jetty.websocket.api.WriteCallback
        public void writeFailed(Throwable x) {
            this.blocker.failed(x);
        }

        @Override // org.eclipse.jetty.websocket.api.WriteCallback
        public void writeSuccess() {
            this.blocker.succeeded();
        }

        @Override // org.eclipse.jetty.util.Callback
        public void succeeded() {
            this.blocker.succeeded();
        }

        @Override // org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            this.blocker.failed(x);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            this.blocker.close();
        }

        public void block() throws IOException {
            this.blocker.block();
        }
    }
}
