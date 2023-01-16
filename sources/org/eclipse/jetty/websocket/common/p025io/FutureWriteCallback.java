package org.eclipse.jetty.websocket.common.p025io;

import org.eclipse.jetty.util.FutureCallback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.WriteCallback;

/* renamed from: org.eclipse.jetty.websocket.common.io.FutureWriteCallback */
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/FutureWriteCallback.class */
public class FutureWriteCallback extends FutureCallback implements WriteCallback {
    private static final Logger LOG = Log.getLogger(FutureWriteCallback.class);

    @Override // org.eclipse.jetty.websocket.api.WriteCallback
    public void writeFailed(Throwable cause) {
        if (LOG.isDebugEnabled()) {
            LOG.debug(".writeFailed", cause);
        }
        failed(cause);
    }

    @Override // org.eclipse.jetty.websocket.api.WriteCallback
    public void writeSuccess() {
        if (LOG.isDebugEnabled()) {
            LOG.debug(".writeSuccess", new Object[0]);
        }
        succeeded();
    }
}
